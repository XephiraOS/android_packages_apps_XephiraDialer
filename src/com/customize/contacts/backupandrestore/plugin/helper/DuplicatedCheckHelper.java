package com.customize.contacts.backupandrestore.plugin.helper;

import H7.a;
import H7.b;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.vcard.VCardEntry;
import com.android.contacts.model.Account;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class DuplicatedCheckHelper {
    private static final boolean DEBUG_RAW_INFO = false;
    public static final DuplicatedCheckHelper INSTANCE = new DuplicatedCheckHelper();
    public static final int QUERY_BATCH_SIZE = 50;
    private static final String TAG = "DuplicatedCheckHelper";
    private Context mContext;
    private Account mTargetAccount;
    private final Map<String, ArrayList<Long>> mDisplayNameCache = new HashMap();
    private final List<VCardEntryWithIds> mVCardEntryWithIdsList = new ArrayList();

    /* loaded from: classes3.dex */
    public static class VCardEntryWithIds {
        public static final int EXIST_SAME = 1;
        public static final int NO_SAME = 2;
        public static final int TO_CHECK = 0;
        public final ArrayList<Long> mRawIds;
        public int mState = 0;
        public final VCardEntry mVCardEntry;

        public VCardEntryWithIds(VCardEntry vCardEntry, ArrayList<Long> arrayList) {
            this.mVCardEntry = vCardEntry;
            this.mRawIds = arrayList;
        }

        public void setState(int i10) {
            this.mState = i10;
        }
    }

    private DuplicatedCheckHelper() {
    }

    private static String buildSqlInClause(Set<Long> set) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<Long> it = set.iterator();
        while (it.hasNext()) {
            sb.append(it.next().longValue());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        return sb.toString();
    }

    public static Uri buildUriWithAccountInfo(Uri uri, Account account, boolean z10) {
        Uri.Builder buildUpon = uri.buildUpon();
        if (!TextUtils.isEmpty(account.f16941a) && !TextUtils.isEmpty(account.f16942b)) {
            buildUpon.appendQueryParameter("account_name", account.f16941a);
            buildUpon.appendQueryParameter("account_type", account.f16942b);
        }
        if (z10) {
            buildUpon.appendQueryParameter("caller_is_syncadapter", "true");
        }
        return buildUpon.build();
    }

    private static HashMap<String, ArrayList<Long>> getRawContactDisplayNames(Context context, Account account) {
        Uri buildUriWithAccountInfo = buildUriWithAccountInfo(ContactsContract.RawContactsEntity.CONTENT_URI, account, true);
        HashMap<String, ArrayList<Long>> hashMap = new HashMap<>();
        try {
            Cursor query = context.getContentResolver().query(buildUriWithAccountInfo, new String[]{BreenoCallContract.BaseColumns._ID, "data1"}, "deleted=0 AND mimetype='vnd.android.cursor.item/name'", null, "data1");
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        int columnIndex = query.getColumnIndex("data1");
                        int columnIndex2 = query.getColumnIndex(BreenoCallContract.BaseColumns._ID);
                        while (query.moveToNext()) {
                            String string = query.getString(columnIndex);
                            if (!TextUtils.isEmpty(string)) {
                                long j10 = query.getLong(columnIndex2);
                                arrayList.add(string);
                                arrayList2.add(Long.valueOf(j10));
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            int size = arrayList.size();
                            ArrayList<Long> arrayList3 = new ArrayList<>();
                            String str = (String) arrayList.get(0);
                            for (int i10 = 0; i10 < size; i10++) {
                                String str2 = (String) arrayList.get(i10);
                                Long l10 = (Long) arrayList2.get(i10);
                                l10.longValue();
                                if (str2.equals(str)) {
                                    arrayList3.add(l10);
                                } else {
                                    hashMap.put(str, arrayList3);
                                    arrayList3 = new ArrayList<>();
                                    arrayList3.add(l10);
                                    str = str2;
                                }
                            }
                            hashMap.put(str, arrayList3);
                        }
                    }
                } finally {
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e10) {
            b.c(TAG, "getRawContactDisplayNames fail! e : " + e10);
        }
        return hashMap;
    }

    private Set<Long> getRawIds() {
        HashSet hashSet = new HashSet();
        Iterator<VCardEntryWithIds> it = this.mVCardEntryWithIdsList.iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().mRawIds);
        }
        b.b(TAG, "getRawIds, current size: " + hashSet.size() + ": " + hashSet);
        return hashSet;
    }

    private static VCardEntry getVCardEntryByRid(List<VCardEntry> list, long j10) {
        for (VCardEntry vCardEntry : list) {
            if (vCardEntry.Z() == j10) {
                return vCardEntry;
            }
        }
        return null;
    }

    public int addToVCardEntryWithIdsList(VCardEntry vCardEntry, ArrayList<Long> arrayList) {
        if (a.b()) {
            b.b(TAG, "addToVCardEntryWithIdsList: " + vCardEntry);
        }
        this.mVCardEntryWithIdsList.add(new VCardEntryWithIds(vCardEntry, arrayList));
        return getRawIds().size();
    }

    public List<VCardEntryWithIds> checkSameDisplayNameRaws() {
        ArrayList arrayList = new ArrayList();
        Set<Long> rawIds = getRawIds();
        if (!rawIds.isEmpty()) {
            List<VCardEntry> vCardEntries = VCardEntryCreator.getVCardEntries(this.mContext, this.mTargetAccount, "_id IN" + buildSqlInClause(rawIds), null);
            for (VCardEntryWithIds vCardEntryWithIds : this.mVCardEntryWithIdsList) {
                vCardEntryWithIds.setState(2);
                Iterator<Long> it = vCardEntryWithIds.mRawIds.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    long longValue = it.next().longValue();
                    VCardEntry vCardEntryByRid = getVCardEntryByRid(vCardEntries, longValue);
                    if (vCardEntryByRid != null && RawComparer.isSameRawEntity(vCardEntryByRid, vCardEntryWithIds.mVCardEntry)) {
                        b.b(TAG, "checkSameDisplayNameRaws: get same raw: " + longValue);
                        vCardEntryWithIds.setState(1);
                        break;
                    }
                }
            }
            arrayList.addAll(this.mVCardEntryWithIdsList);
            this.mVCardEntryWithIdsList.clear();
        }
        return arrayList;
    }

    public void destroy() {
        this.mDisplayNameCache.clear();
        this.mContext = null;
        b.b(TAG, "destroy.");
    }

    public ArrayList<Long> getSameDisplayNameRawIds(String str) {
        return this.mDisplayNameCache.get(str);
    }

    public void init(Context context, Account account) {
        long currentTimeMillis = System.currentTimeMillis();
        this.mContext = context;
        this.mTargetAccount = account;
        this.mDisplayNameCache.clear();
        this.mDisplayNameCache.putAll(getRawContactDisplayNames(context, account));
        b.b(TAG, "init take: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public boolean isCacheEmpty() {
        return this.mDisplayNameCache.isEmpty();
    }
}
