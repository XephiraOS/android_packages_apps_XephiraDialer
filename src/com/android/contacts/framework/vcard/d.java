package com.android.contacts.framework.vcard;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Entity;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.oplus.backup.sdk.common.plugin.BRPluginConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import l1.C1288a;

/* compiled from: VCardComposer.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: p, reason: collision with root package name */
    public static final Map<Integer, String> f16501p;

    /* renamed from: q, reason: collision with root package name */
    public static final String[] f16502q;

    /* renamed from: a, reason: collision with root package name */
    public final int f16503a;

    /* renamed from: b, reason: collision with root package name */
    public final ContentResolver f16504b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f16505c;

    /* renamed from: d, reason: collision with root package name */
    public Context f16506d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f16507e;

    /* renamed from: f, reason: collision with root package name */
    public Cursor f16508f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f16509g;

    /* renamed from: h, reason: collision with root package name */
    public int f16510h;

    /* renamed from: i, reason: collision with root package name */
    public Uri f16511i;

    /* renamed from: j, reason: collision with root package name */
    public final String f16512j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f16513k;

    /* renamed from: l, reason: collision with root package name */
    public String f16514l;

    /* renamed from: m, reason: collision with root package name */
    public Uri f16515m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f16516n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f16517o;

    /* compiled from: VCardComposer.java */
    /* loaded from: classes.dex */
    public static class a extends com.android.contacts.framework.vcard.a {

        /* renamed from: c, reason: collision with root package name */
        public static final String[] f16518c = {"data1", "data2", "data3", "data4", "data5", "data6", "data7", "data8", "data9", "data10", "data11", "data12", "data13", "data14", "data15", "data_sync1", "data_sync2", "data_sync3", "data_sync4"};

        public a(Cursor cursor) {
            super(cursor);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x00f2, code lost:
        
            r7.addSubValue(android.provider.ContactsContract.Data.CONTENT_URI, r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x00fb, code lost:
        
            if (r13.moveToNext() != false) goto L26;
         */
        @Override // com.android.contacts.framework.vcard.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public android.content.Entity a(android.database.Cursor r13) {
            /*
                Method dump skipped, instructions count: 254
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.vcard.d.a.a(android.database.Cursor):android.content.Entity");
        }

        public boolean c() {
            return this.f16476a.isAfterLast();
        }
    }

    /* compiled from: VCardComposer.java */
    /* loaded from: classes.dex */
    public interface b {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f16519a = {"name_raw_contact_id", "account_name", "account_type", "data_set", BreenoCallContract.BaseColumns._ID, "dirty", BRPluginConfig.VERSION, "sourceid", "sync1", "sync2", "sync3", "sync4", "deleted", "contact_id", "starred", R0.c.f3184b, "data_id", "res_package", "mimetype", "is_primary", "is_super_primary", "group_sourceid", "data_version", "title", "data1", "data2", "data3", "data4", "data5", "data6", "data7", "data8", "data9", "data10", "data11", "data12", "data13", "data14", "data15", "data_sync1", "data_sync2", "data_sync3", "data_sync4"};
    }

    static {
        HashMap hashMap = new HashMap();
        f16501p = hashMap;
        hashMap.put(0, "X-AIM");
        hashMap.put(1, "X-MSN");
        hashMap.put(2, "X-YAHOO");
        hashMap.put(6, "X-ICQ");
        hashMap.put(7, "X-JABBER");
        hashMap.put(3, "X-SKYPE-USERNAME");
        f16502q = new String[]{BreenoCallContract.BaseColumns._ID};
    }

    public d(Context context, int i10, boolean z10) {
        this(context, i10, null, z10);
    }

    public static void g(Cursor cursor, ContentValues contentValues, String str, int i10) {
        if (i10 != -1 && !cursor.isNull(i10)) {
            contentValues.put(str, Long.valueOf(cursor.getLong(i10)));
        }
    }

    public static void h(Cursor cursor, ContentValues contentValues, String str, int i10) {
        if (i10 != -1 && !cursor.isNull(i10)) {
            contentValues.put(str, cursor.getString(i10));
        }
    }

    public String c(Map<String, List<ContentValues>> map, boolean z10, boolean z11) {
        if (map == null) {
            H7.b.c("VCardComposer", "The given map is null. Ignore and return empty String");
            return "";
        }
        c cVar = new c(this.f16506d, this.f16503a, this.f16512j);
        cVar.p(map.get("vnd.android.cursor.item/name")).r(map.get("vnd.android.cursor.item/nickname")).v(map.get("vnd.android.cursor.item/phone_v2"), null, z11).f(map.get("vnd.android.cursor.item/email_v2")).A(map.get("vnd.android.cursor.item/postal-address_v2")).u(map.get("vnd.android.cursor.item/organization")).L(map.get("vnd.android.cursor.item/website"));
        cVar.h(this.f16504b, map.get("vnd.android.cursor.item/group_membership"), z11);
        if ((this.f16503a & 8388608) == 0) {
            cVar.y(map.get("vnd.android.cursor.item/photo"), z10);
        }
        cVar.s(map.get("vnd.android.cursor.item/note")).g(map.get("vnd.android.cursor.item/contact_event"), z11).j(map.get("vnd.android.cursor.item/im")).E(map.get("vnd.android.cursor.item/sip_address")).D(map.get("vnd.android.cursor.item/relation"));
        cVar.d(map.get(R0.c.f3184b), z11);
        cVar.F(map.get("starred"), z11);
        cVar.c(map.get("vnd.android.cursor.item/business_card_photo"));
        if (z10) {
            cVar.t(map.get("vnd.android.cursor.item/omoji_photo"));
        }
        return cVar.toString();
    }

    public final void d() {
        Cursor cursor;
        if (!this.f16509g && (cursor = this.f16508f) != null) {
            try {
                cursor.close();
            } catch (SQLiteException e10) {
                H7.b.c("VCardComposer", "SQLiteException on Cursor#close(): " + e10.getMessage());
            }
            this.f16508f = null;
        }
    }

    public String e(Cursor cursor, boolean z10) {
        return f(cursor, z10, false, null);
    }

    public String f(Cursor cursor, boolean z10, boolean z11, ArrayList<String> arrayList) {
        String str;
        a aVar;
        long j10;
        boolean z12;
        List<ContentValues> list;
        String str2;
        Iterator<Entity.NamedContentValues> it;
        d dVar = this;
        String str3 = "data4";
        String str4 = "VCardComposer";
        if (cursor == null) {
            return "";
        }
        if (dVar.f16505c && !dVar.f16507e) {
            dVar.f16507e = true;
        }
        HashMap hashMap = new HashMap();
        try {
            try {
                aVar = new a(cursor);
            } finally {
            }
        } catch (Exception e10) {
            e = e10;
            str = "VCardComposer";
        }
        if (aVar.c()) {
            H7.b.i("VCardComposer", "Data does not exist. contactId: ");
            return "";
        }
        H7.b.i("VCardComposer", "createOneEntryInternal() Is profile: " + dVar.f16516n);
        boolean z13 = false;
        if (!dVar.f16516n) {
            j10 = cursor.getLong(0);
        } else {
            j10 = -1;
        }
        while (true) {
            Entity next = aVar.next();
            Iterator<Entity.NamedContentValues> it2 = next.getSubValues().iterator();
            boolean z14 = z13;
            ContentValues contentValues = null;
            while (it2.hasNext()) {
                ContentValues contentValues2 = it2.next().values;
                String asString = contentValues2.getAsString("mimetype");
                if (asString != null) {
                    it = it2;
                    if (asString.equals("vnd.android.cursor.item/relation") && contentValues2.containsKey(str3)) {
                        contentValues2.remove(str3);
                    }
                    List<ContentValues> list2 = hashMap.get(asString);
                    if (list2 == null) {
                        list2 = new ArrayList<>();
                        hashMap.put(asString, list2);
                    }
                    str2 = str3;
                    if (dVar.f16516n || (!asString.equals("vnd.android.cursor.item/name") && !asString.equals("vnd.android.cursor.item/omoji_photo"))) {
                        str = str4;
                        list2.add(contentValues2);
                    } else {
                        str = str4;
                        if (asString.equals("vnd.android.cursor.item/name")) {
                            try {
                                if (j10 == next.getEntityValues().getAsLong(BreenoCallContract.BaseColumns._ID).longValue()) {
                                    list2.clear();
                                    list2.add(contentValues2);
                                    z14 = true;
                                    contentValues = null;
                                }
                            } catch (Exception e11) {
                                e = e11;
                                H7.b.c(str, "createOneEntryIndeed error:" + e);
                                return c(hashMap, z10, z11);
                            }
                        }
                        if (asString.equals("vnd.android.cursor.item/name") && contentValues == null) {
                            contentValues = contentValues2;
                        } else if (asString.equals("vnd.android.cursor.item/omoji_photo") && j10 == next.getEntityValues().getAsLong(BreenoCallContract.BaseColumns._ID).longValue() && C1288a.f34669b) {
                            list2.add(contentValues2);
                            if (arrayList != null) {
                                arrayList.add(contentValues2.getAsString("data1"));
                            }
                        }
                    }
                } else {
                    str2 = str3;
                    str = str4;
                    it = it2;
                }
                dVar = this;
                it2 = it;
                str3 = str2;
                str4 = str;
            }
            String str5 = str3;
            String str6 = str4;
            if (!z14 && contentValues != null && (list = hashMap.get("vnd.android.cursor.item/name")) != null && list.size() == 0) {
                list.add(contentValues);
            }
            ContentValues entityValues = next.getEntityValues();
            String str7 = R0.c.f3184b;
            Long asLong = entityValues.getAsLong(str7);
            if (asLong != null && asLong.longValue() != 0) {
                List<ContentValues> list3 = hashMap.get(str7);
                if (list3 == null) {
                    list3 = new ArrayList<>();
                    hashMap.put(str7, list3);
                }
                ContentValues contentValues3 = new ContentValues(1);
                contentValues3.put(str7, asLong);
                list3.add(contentValues3);
            }
            Long asLong2 = entityValues.getAsLong("starred");
            if (asLong2 != null && asLong2.longValue() != 0) {
                List<ContentValues> list4 = hashMap.get("starred");
                if (list4 == null) {
                    list4 = new ArrayList<>();
                    hashMap.put("starred", list4);
                }
                z12 = true;
                ContentValues contentValues4 = new ContentValues(1);
                contentValues4.put("starred", asLong2);
                list4.add(contentValues4);
            } else {
                z12 = true;
            }
            if (!aVar.hasNext()) {
                break;
            }
            dVar = this;
            str3 = str5;
            str4 = str6;
            z13 = false;
        }
        return c(hashMap, z10, z11);
    }

    public void finalize() {
        try {
            if (!this.f16517o) {
                H7.b.c("VCardComposer", "finalized() is called before terminate() being called");
            }
        } finally {
            super.finalize();
        }
    }

    public int i() {
        Cursor cursor = this.f16508f;
        if (cursor == null) {
            H7.b.i("VCardComposer", "This object is not ready yet.");
            return 0;
        }
        return cursor.getCount();
    }

    public Cursor j() {
        return this.f16508f;
    }

    public String k() {
        return this.f16514l;
    }

    public boolean l(Uri uri, String[] strArr, String str, String[] strArr2, String str2, Uri uri2) {
        if (!"com.android.contacts".equals(uri.getAuthority())) {
            H7.b.e("VCardComposer", "Unexpected contentUri: " + uri);
            this.f16514l = "The Uri vCard composer received is not supported by the composer.";
            return false;
        }
        if (!n(uri2) || !m(uri, strArr, str, strArr2, str2) || !p()) {
            return false;
        }
        return o();
    }

    public final boolean m(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        this.f16509g = false;
        Cursor e10 = G7.c.e(this.f16504b, uri, strArr, str, strArr2, str2);
        this.f16508f = e10;
        if (e10 == null) {
            H7.b.c("VCardComposer", "Cursor became null unexpectedly");
            this.f16514l = "Failed to get database information";
            return false;
        }
        return true;
    }

    public final boolean n(Uri uri) {
        if (uri == null) {
            uri = ContactsContract.RawContactsEntity.CONTENT_URI;
        }
        this.f16511i = uri;
        this.f16516n = uri.equals(Uri.withAppendedPath(this.f16515m, "raw_contact_entities"));
        if (this.f16513k) {
            H7.b.c("VCardComposer", "init() is already called");
            return false;
        }
        return true;
    }

    public final boolean o() {
        this.f16513k = true;
        this.f16517o = false;
        return true;
    }

    public final boolean p() {
        if (this.f16508f.getCount() != 0 && this.f16508f.moveToFirst()) {
            this.f16510h = this.f16508f.getColumnIndex("contact_id");
            H7.b.e("VCardComposer", "mIdColumn = " + this.f16510h);
            if (this.f16510h < 0) {
                return false;
            }
            return true;
        }
        H7.b.e("VCardComposer", String.format("mCursor has an error (getCount: %d): ", Integer.valueOf(this.f16508f.getCount())));
        d();
        return false;
    }

    public boolean q() {
        Cursor cursor = this.f16508f;
        if (cursor == null) {
            H7.b.i("VCardComposer", "This object is not ready yet.");
            return false;
        }
        return cursor.isAfterLast();
    }

    public void r() {
        d();
        this.f16517o = true;
    }

    public d(Context context, int i10, String str, boolean z10) {
        this(context, context.getContentResolver(), i10, str, z10);
    }

    public d(Context context, ContentResolver contentResolver, int i10, String str, boolean z10) {
        this.f16514l = "No error";
        this.f16515m = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "profile");
        this.f16516n = false;
        this.f16517o = true;
        this.f16506d = context;
        this.f16503a = i10;
        this.f16504b = contentResolver;
        boolean d10 = e.d(i10);
        this.f16505c = d10;
        str = TextUtils.isEmpty(str) ? "UTF-8" : str;
        boolean z11 = (e.g(i10) && "UTF-8".equalsIgnoreCase(str)) ? false : true;
        if (!d10 && !z11) {
            if (TextUtils.isEmpty(str)) {
                this.f16512j = "UTF-8";
            } else {
                this.f16512j = str;
            }
        } else if ("SHIFT_JIS".equalsIgnoreCase(str)) {
            this.f16512j = str;
        } else if (TextUtils.isEmpty(str)) {
            this.f16512j = "SHIFT_JIS";
        } else {
            this.f16512j = str;
        }
        H7.b.b("VCardComposer", "Use the charset \"" + this.f16512j + "\"");
    }
}
