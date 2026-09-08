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
import java.util.List;

/* loaded from: classes3.dex */
public class VCardEntryCreator {
    public static final int ACCOUNT_NAME_INDEX = 3;
    public static final int ACCOUNT_TYPE_INDEX = 4;
    public static final int DATA10_INDEX = 21;
    public static final int DATA1_INDEX = 12;
    public static final int DATA2_INDEX = 13;
    public static final int DATA3_INDEX = 14;
    public static final int DATA4_INDEX = 15;
    public static final int DATA5_INDEX = 16;
    public static final int DATA6_INDEX = 17;
    public static final int DATA7_INDEX = 18;
    public static final int DATA8_INDEX = 19;
    public static final int DATA9_INDEX = 20;
    public static final int DATA_IS_PRIMARY_INDEX = 9;
    public static final int DATA_IS_SUPER_PRIMARY_INDEX = 10;
    public static final int DELETED_INDEX = 1;
    public static final int DIRTY_INDEX = 5;
    public static final int ENTITY_DATA_ID_INDEX = 8;
    public static final int MIMETYPE_INDEX = 11;
    public static final String[] RAW_ENTITY_PROJECTION = {BreenoCallContract.BaseColumns._ID, "deleted", "starred", "account_name", "account_type", "dirty", "sourceid", "sync1", "data_id", "is_primary", "is_super_primary", "mimetype", "data1", "data2", "data3", "data4", "data5", "data6", "data7", "data8", "data9", "data10"};
    public static final int RAW_ID_INDEX = 0;
    public static final int SOURCE_ID_INDEX = 6;
    public static final int STARRED_INDEX = 2;
    public static final int SYS_VERSION_INDEX = 7;
    private static final String TAG = "VCardEntryCreator";

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x005d, code lost:
    
        if (r13.equals("vnd.android.cursor.item/organization") == false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void addData(com.android.contacts.framework.vcard.VCardEntry r12, java.lang.String r13, android.database.Cursor r14) {
        /*
            Method dump skipped, instructions count: 616
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.backupandrestore.plugin.helper.VCardEntryCreator.addData(com.android.contacts.framework.vcard.VCardEntry, java.lang.String, android.database.Cursor):void");
    }

    public static void buildVCardEntries(Account account, List<VCardEntry> list, Cursor cursor) {
        long j10 = 0;
        VCardEntry vCardEntry = null;
        while (cursor.moveToNext()) {
            if (isTargetAccount(account, cursor.getString(3), cursor.getString(4))) {
                long j11 = cursor.getLong(0);
                if (j11 != j10) {
                    VCardEntry fromCursor = fromCursor(cursor);
                    list.add(fromCursor);
                    cursor.moveToPrevious();
                    vCardEntry = fromCursor;
                    j10 = j11;
                } else if (vCardEntry != null) {
                    addData(vCardEntry, cursor.getString(11), cursor);
                }
            }
        }
    }

    public static VCardEntry fromCursor(Cursor cursor) {
        VCardEntry vCardEntry = new VCardEntry();
        vCardEntry.p0(cursor.getLong(0));
        vCardEntry.f(cursor.getString(2));
        return vCardEntry;
    }

    public static List<VCardEntry> getVCardEntries(Context context, Account account, String str, String str2) {
        Uri buildUriWithAccountInfo = DuplicatedCheckHelper.buildUriWithAccountInfo(ContactsContract.RawContactsEntity.CONTENT_URI, account, true);
        if (TextUtils.isEmpty(str2)) {
            str2 = BreenoCallContract.BaseColumns._ID;
        }
        String str3 = str2;
        ArrayList arrayList = new ArrayList();
        try {
            Cursor query = context.getContentResolver().query(buildUriWithAccountInfo, RAW_ENTITY_PROJECTION, str, null, str3);
            if (query != null) {
                try {
                    buildVCardEntries(account, arrayList, query);
                } finally {
                }
            }
            if (a.b()) {
                b.b(TAG, "getRawContactsEntities: selection: " + str + ", raw count: " + arrayList.size());
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e10) {
            b.c(TAG, "getRawContactsEntities: exception: " + e10);
        }
        return arrayList;
    }

    private static boolean isTargetAccount(Account account, String str, String str2) {
        if (!TextUtils.isEmpty(account.f16941a) && !TextUtils.isEmpty(account.f16942b) && account.f16941a.equals(str) && account.f16942b.equals(str2)) {
            return true;
        }
        return false;
    }
}
