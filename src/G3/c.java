package G3;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.EntityIterator;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.LruCache;
import com.android.contacts.ContactsApplication;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import n1.AbstractC1362a;

/* compiled from: DBUtils.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: g, reason: collision with root package name */
    public static c f1106g;

    /* renamed from: a, reason: collision with root package name */
    public boolean f1107a = false;

    /* renamed from: b, reason: collision with root package name */
    public final LruCache<Object, String[]> f1108b = new a(20971520);

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<G3.b> f1109c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f1110d = false;

    /* renamed from: e, reason: collision with root package name */
    public Handler f1111e = null;

    /* renamed from: f, reason: collision with root package name */
    public Context f1112f;

    /* compiled from: DBUtils.java */
    /* loaded from: classes3.dex */
    public class a extends LruCache<Object, String[]> {
        public a(int i10) {
            super(i10);
        }

        @Override // android.util.LruCache
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int sizeOf(Object obj, String[] strArr) {
            return Arrays.toString(strArr).length() * 2;
        }
    }

    /* compiled from: DBUtils.java */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f1114a;

        /* renamed from: b, reason: collision with root package name */
        public String f1115b;

        /* renamed from: c, reason: collision with root package name */
        public int f1116c = 1;

        public b(String str, String str2) {
            this.f1114a = str;
            this.f1115b = str2;
        }
    }

    public c(Context context) {
        this.f1112f = context;
    }

    public static void c() {
        f1106g = null;
    }

    public static void d(G3.b bVar) {
        String str;
        String f10;
        String replaceAll;
        String e10;
        String replaceAll2;
        String replaceAll3;
        if (TextUtils.equals(bVar.f1093c, bVar.f1105o)) {
            return;
        }
        ArrayList<G3.a> arrayList = bVar.f1101k;
        int i10 = 0;
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        int i14 = -1;
        int i15 = -1;
        int i16 = -1;
        while (true) {
            if (i10 < arrayList.size()) {
                String str2 = arrayList.get(i10).f1093c;
                if (TextUtils.equals(str2, bVar.f1105o)) {
                    break;
                }
                if (-1 == i11) {
                    str = bVar.f1093c;
                } else {
                    str = arrayList.get(i11).f1093c;
                }
                if (str2.length() < str.length()) {
                    i11 = i10;
                }
                if (-1 == i12) {
                    f10 = U7.f.f(bVar.f1093c);
                } else {
                    f10 = U7.f.f(arrayList.get(i12).f1093c);
                }
                if (TextUtils.equals(str2, f10)) {
                    i12 = i10;
                }
                if (-1 == i13) {
                    replaceAll = bVar.f1093c.replaceAll("\\+", "");
                } else {
                    replaceAll = arrayList.get(i13).f1093c.replaceAll("\\+", "");
                }
                if (TextUtils.equals(str2, replaceAll)) {
                    i13 = i10;
                }
                if (-1 == i14) {
                    e10 = U7.f.e(bVar.f1093c);
                } else {
                    e10 = U7.f.e(arrayList.get(i14).f1093c);
                }
                if (TextUtils.equals(str2, e10)) {
                    i14 = i10;
                }
                if (-1 == i15) {
                    replaceAll2 = bVar.f1093c.replaceAll("_", "");
                } else {
                    replaceAll2 = arrayList.get(i15).f1093c.replaceAll("_", "");
                }
                if (TextUtils.equals(str2, replaceAll2)) {
                    i15 = i10;
                }
                if (-1 == i16) {
                    replaceAll3 = bVar.f1093c.replaceAll("(\\(\\))", "");
                } else {
                    replaceAll3 = arrayList.get(i16).f1093c.replaceAll("(\\(\\))", "");
                }
                if (TextUtils.equals(str2, replaceAll3)) {
                    i16 = i10;
                }
                i10++;
            } else {
                i10 = i11;
                break;
            }
        }
        if (-1 != i10) {
            G3.a aVar = new G3.a();
            aVar.a(bVar);
            G3.a aVar2 = arrayList.get(i10);
            bVar.a(aVar2);
            aVar2.a(aVar);
            return;
        }
        if (-1 != i12) {
            G3.a aVar3 = new G3.a();
            aVar3.a(bVar);
            G3.a aVar4 = arrayList.get(i12);
            bVar.a(aVar4);
            aVar4.a(aVar3);
            return;
        }
        if (-1 != i13) {
            G3.a aVar5 = new G3.a();
            aVar5.a(bVar);
            G3.a aVar6 = arrayList.get(i13);
            bVar.a(aVar6);
            aVar6.a(aVar5);
            return;
        }
        if (-1 != i14) {
            G3.a aVar7 = new G3.a();
            aVar7.a(bVar);
            G3.a aVar8 = arrayList.get(i14);
            bVar.a(aVar8);
            aVar8.a(aVar7);
            return;
        }
        if (-1 != i15) {
            G3.a aVar9 = new G3.a();
            aVar9.a(bVar);
            G3.a aVar10 = arrayList.get(i15);
            bVar.a(aVar10);
            aVar10.a(aVar9);
            return;
        }
        if (-1 != i16) {
            G3.a aVar11 = new G3.a();
            aVar11.a(bVar);
            G3.a aVar12 = arrayList.get(i16);
            bVar.a(aVar12);
            aVar12.a(aVar11);
        }
    }

    public static synchronized c f(Context context) {
        c cVar;
        synchronized (c.class) {
            try {
                if (f1106g == null) {
                    f1106g = new c(ContactsApplication.h().getApplicationContext());
                }
                cVar = f1106g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    public static byte[] h(Context context, long j10) {
        try {
            Cursor query = context.getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[]{"data15"}, "_id=" + j10, null, null);
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        byte[] blob = query.getBlob(0);
                        query.close();
                        return blob;
                    }
                } finally {
                }
            }
            if (query != null) {
                query.close();
                return null;
            }
            return null;
        } catch (Exception e10) {
            H7.b.c("DBUtils", "getPhoto exception: " + e10);
            return null;
        }
    }

    public static byte[] i(Context context, long j10) {
        Bitmap decodeStream;
        InputStream inputStream = null;
        try {
            InputStream openContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(context.getContentResolver(), ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, j10), true);
            if (openContactPhotoInputStream != null) {
                try {
                    decodeStream = BitmapFactory.decodeStream(openContactPhotoInputStream);
                } catch (Throwable th) {
                    th = th;
                    inputStream = openContactPhotoInputStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
            } else {
                decodeStream = null;
            }
            if (openContactPhotoInputStream != null) {
                try {
                    openContactPhotoInputStream.close();
                } catch (Exception unused2) {
                }
            }
            if (decodeStream == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                decodeStream.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                return byteArrayOutputStream.toByteArray();
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e10) {
                    H7.b.c("DBUtils", "Exception e: " + e10);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static int k(Context context, long j10) {
        String str = "account_type <> ?";
        if (R0.a.f3166b == null) {
            str = "account_type <> ? OR account_type IS NULL";
        }
        String str2 = str;
        long currentTimeMillis = System.currentTimeMillis();
        int i10 = 0;
        try {
            Cursor query = context.getContentResolver().query(ContentUris.withAppendedId(ContactsContract.AUTHORITY_URI.buildUpon().appendPath("combine_list").build(), j10), null, str2, new String[]{"com.android.oplus.sim"}, null);
            if (query != null) {
                try {
                    i10 = query.getCount();
                } finally {
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e10) {
            H7.b.c("DBUtils", "getSimilarCount: Exception: " + e10);
        }
        H7.b.e("DBUtils", "getSimilarCount: type: " + j10 + ", count: " + i10 + ", take: " + (System.currentTimeMillis() - currentTimeMillis));
        return i10;
    }

    public static boolean o(Context context, G3.b bVar) {
        ArrayList<G3.a> arrayList = bVar.f1101k;
        HashMap hashMap = new HashMap();
        hashMap.put(Long.valueOf(bVar.f1098h), new b(bVar.f1099i, bVar.f1100j));
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            G3.a aVar = arrayList.get(i10);
            if (aVar.f1091a != bVar.f1091a) {
                return true;
            }
            if (hashMap.containsKey(Long.valueOf(aVar.f1098h))) {
                ((b) hashMap.get(Long.valueOf(aVar.f1098h))).f1116c++;
            } else {
                hashMap.put(Long.valueOf(aVar.f1098h), new b(aVar.f1099i, aVar.f1100j));
            }
        }
        if (hashMap.size() == arrayList.size() + 1) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Set<Map.Entry> entrySet = hashMap.entrySet();
        AbstractC1362a h10 = AbstractC1362a.h(context);
        for (Map.Entry entry : entrySet) {
            b bVar2 = (b) entry.getValue();
            if (bVar2.f1116c != 1 && h10.c(bVar2.f1114a, bVar2.f1115b).b()) {
                arrayList2.add((Long) entry.getKey());
            }
        }
        bVar.f1101k = new ArrayList<>();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            G3.a aVar2 = arrayList.get(i11);
            if (arrayList2.contains(Long.valueOf(aVar2.f1098h))) {
                bVar.f1101k.add(aVar2);
            }
        }
        if (bVar.f1101k.size() == 0) {
            return false;
        }
        if (!arrayList2.contains(Long.valueOf(bVar.f1098h))) {
            bVar.a(bVar.f1101k.get(0));
            bVar.f1101k.remove(0);
        }
        return true;
    }

    public static boolean s(Context context, long j10, byte[] bArr) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("raw_contact_id", Long.valueOf(j10));
            contentValues.put("data15", bArr);
            contentValues.put("mimetype", "vnd.android.cursor.item/photo");
            if (context.getContentResolver().insert(R0.d.a(ContactsContract.Data.CONTENT_URI), contentValues) == null) {
                return false;
            }
            return true;
        } catch (Exception e10) {
            H7.b.c("DBUtils", "saveUpdatedPhoto Exception: " + e10);
            return false;
        }
    }

    public static void v(Context context) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("aggregation_mode", (Integer) 0);
        try {
            context.getContentResolver().update(ContactsContract.RawContacts.CONTENT_URI, contentValues, "deleted=0 AND aggregation_mode<>0 AND account_type <> 'com.android.oplus.sim'", null);
        } catch (Exception e10) {
            H7.b.c("DBUtils", "setAllContactsAggEnable error" + e10);
        }
    }

    public final boolean a(Map<String, Map<String, String>> map, ContentValues contentValues) {
        return b(map, contentValues, false);
    }

    public final boolean b(Map<String, Map<String, String>> map, ContentValues contentValues, boolean z10) {
        String asString = contentValues.getAsString("mimetype");
        if (asString == null) {
            return false;
        }
        if ("vnd.android.cursor.item/photo".equals(asString) && !z10) {
            return true;
        }
        String e10 = e(asString, contentValues);
        if ("vnd.android.cursor.item/photo".equals(asString) && z10) {
            e10 = asString;
        }
        if (TextUtils.isEmpty(e10)) {
            return false;
        }
        Map<String, String> map2 = map.get(asString);
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(asString, map2);
        }
        if (!map2.containsKey(e10)) {
            map2.put(e10, "");
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x010e, code lost:
    
        if (r8 != false) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String e(java.lang.String r11, android.content.ContentValues r12) {
        /*
            Method dump skipped, instructions count: 511
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: G3.c.e(java.lang.String, android.content.ContentValues):java.lang.String");
    }

    public ArrayList<G3.b> g() {
        return this.f1109c;
    }

    public final EntityIterator j(long j10) {
        EntityIterator newEntityIterator;
        try {
            Cursor query = this.f1112f.getContentResolver().query(ContactsContract.RawContactsEntity.CONTENT_URI, null, "_id=" + j10 + " AND deleted=0", null, null);
            if (query == null) {
                newEntityIterator = null;
            } else {
                newEntityIterator = ContactsContract.RawContacts.newEntityIterator(query);
            }
            if (newEntityIterator == null) {
                return null;
            }
            if (!newEntityIterator.hasNext()) {
                newEntityIterator.close();
                return null;
            }
            return newEntityIterator;
        } catch (Exception e10) {
            H7.b.c("DBUtils", "" + e10);
            return null;
        }
    }

    public ArrayList<G3.b> l(long j10) {
        boolean z10;
        String str;
        ArrayList<G3.b> arrayList;
        long j11;
        String str2;
        long j12;
        Cursor query;
        Throwable th;
        long j13;
        boolean z11;
        String str3;
        int i10;
        String str4;
        int i11;
        int i12;
        String str5;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        c cVar = this;
        ArrayList<G3.b> arrayList2 = new ArrayList<>();
        if (4 == j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        String str6 = "account_type <> ?";
        if (R0.a.f3166b == null) {
            str6 = "account_type <> ? OR account_type IS NULL";
        }
        String str7 = str6;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            query = cVar.f1112f.getContentResolver().query(ContentUris.withAppendedId(ContactsContract.AUTHORITY_URI.buildUpon().appendPath("combine_list").build(), j10), null, str7, new String[]{"com.android.oplus.sim"}, null);
        } catch (Exception e10) {
            e = e10;
            str = "DBUtils";
            arrayList = arrayList2;
        }
        if (query != null) {
            try {
                if (query.getCount() != 0) {
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    try {
                        currentTimeMillis = System.currentTimeMillis();
                    } catch (Throwable th2) {
                        th = th2;
                        str = "DBUtils";
                    }
                    try {
                        query.moveToPosition(-1);
                        int columnIndex = query.getColumnIndex("contact_id");
                        int columnIndex2 = query.getColumnIndex("raw_contact_id");
                        int columnIndex3 = query.getColumnIndex("display_name");
                        int columnIndex4 = query.getColumnIndex("similar_value");
                        try {
                            int columnIndex5 = query.getColumnIndex("number");
                            int columnIndex6 = query.getColumnIndex("photo_id");
                            j13 = currentTimeMillis2;
                            try {
                                int columnIndex7 = query.getColumnIndex("display_name_source");
                                int columnIndex8 = query.getColumnIndex("account_id");
                                int columnIndex9 = query.getColumnIndex("account_type");
                                int columnIndex10 = query.getColumnIndex("data_set");
                                ArrayList<G3.b> arrayList3 = arrayList2;
                                String str8 = "";
                                G3.b bVar = null;
                                long j14 = 0;
                                long j15 = 0;
                                str = "DBUtils";
                                G3.a aVar = null;
                                while (query.moveToNext() && !n()) {
                                    try {
                                        String string = query.getString(columnIndex4);
                                        int i18 = columnIndex4;
                                        int i19 = columnIndex5;
                                        long j16 = query.getLong(columnIndex2);
                                        int i20 = columnIndex2;
                                        int i21 = columnIndex3;
                                        long j17 = query.getLong(columnIndex);
                                        int i22 = columnIndex9;
                                        int i23 = columnIndex;
                                        long j18 = query.getLong(columnIndex8);
                                        if (!TextUtils.equals(str8, string) || (z10 && j14 != j18)) {
                                            z11 = z10;
                                            int i24 = columnIndex8;
                                            int i25 = columnIndex6;
                                            if (bVar == null) {
                                                str3 = ", ";
                                                i10 = i19;
                                                arrayList = arrayList3;
                                                str4 = string;
                                                cVar = this;
                                            } else {
                                                if (bVar.f1096f.size() <= 0) {
                                                    str3 = ", ";
                                                    i10 = i19;
                                                } else {
                                                    str3 = ", ";
                                                    i10 = i19;
                                                    bVar.f1095e = bVar.f1095e.substring(0, r8.length() - 2);
                                                }
                                                if (aVar != null) {
                                                    if (aVar.f1096f.size() > 0) {
                                                        aVar.f1095e = aVar.f1095e.substring(0, r0.length() - 2);
                                                    }
                                                    bVar.f1101k.add(aVar);
                                                }
                                                if (bVar.f1101k.size() > 0) {
                                                    if (!z11) {
                                                        cVar = this;
                                                        str4 = string;
                                                        if (!o(cVar.f1112f, bVar)) {
                                                            arrayList = arrayList3;
                                                        }
                                                    } else {
                                                        cVar = this;
                                                        str4 = string;
                                                    }
                                                    if (!z11) {
                                                        d(bVar);
                                                    }
                                                    arrayList = arrayList3;
                                                    try {
                                                        arrayList.add(bVar);
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        th = th;
                                                        currentTimeMillis = currentTimeMillis;
                                                        j12 = j13;
                                                        try {
                                                            try {
                                                                query.close();
                                                                throw th;
                                                            } catch (Exception e11) {
                                                                e = e11;
                                                                str2 = str;
                                                                H7.b.b(str2, "getSimilarList error e = " + e);
                                                                j11 = j12;
                                                                H7.b.e(str2, "Type: " + j10 + ", queryTake: " + j11 + ", countTake: " + (System.currentTimeMillis() - currentTimeMillis));
                                                                return arrayList;
                                                            }
                                                        } catch (Throwable th4) {
                                                            th.addSuppressed(th4);
                                                            throw th;
                                                        }
                                                    }
                                                } else {
                                                    cVar = this;
                                                    arrayList = arrayList3;
                                                    str4 = string;
                                                }
                                            }
                                            bVar = new G3.b();
                                            bVar.f1092b = j16;
                                            bVar.f1091a = j17;
                                            bVar.f1098h = j18;
                                            bVar.f1093c = query.getString(i21);
                                            bVar.f1094d = query.getInt(columnIndex7);
                                            bVar.f1099i = query.getString(i22);
                                            bVar.f1100j = query.getString(columnIndex10);
                                            bVar.f1105o = str4;
                                            columnIndex6 = i25;
                                            if (!TextUtils.isEmpty(query.getString(columnIndex6))) {
                                                bVar.f1097g = query.getLong(columnIndex6);
                                            }
                                            int i26 = i10;
                                            String string2 = query.getString(i26);
                                            if (!TextUtils.isEmpty(string2)) {
                                                String formatNumber = PhoneNumberUtils.formatNumber(string2);
                                                i11 = columnIndex10;
                                                if (!bVar.f1096f.contains(formatNumber)) {
                                                    bVar.f1096f.add(formatNumber);
                                                    StringBuilder sb = new StringBuilder();
                                                    i12 = i21;
                                                    sb.append(bVar.f1095e);
                                                    sb.append(formatNumber);
                                                    sb.append(str3);
                                                    bVar.f1095e = sb.toString();
                                                    str8 = str4;
                                                    arrayList3 = arrayList;
                                                    j14 = j18;
                                                    columnIndex10 = i11;
                                                    columnIndex3 = i12;
                                                    columnIndex = i23;
                                                    columnIndex8 = i24;
                                                    aVar = null;
                                                    columnIndex9 = i22;
                                                    j15 = j16;
                                                    columnIndex5 = i26;
                                                    columnIndex4 = i18;
                                                    columnIndex2 = i20;
                                                }
                                            } else {
                                                i11 = columnIndex10;
                                            }
                                            i12 = i21;
                                            str8 = str4;
                                            arrayList3 = arrayList;
                                            j14 = j18;
                                            columnIndex10 = i11;
                                            columnIndex3 = i12;
                                            columnIndex = i23;
                                            columnIndex8 = i24;
                                            aVar = null;
                                            columnIndex9 = i22;
                                            j15 = j16;
                                            columnIndex5 = i26;
                                            columnIndex4 = i18;
                                            columnIndex2 = i20;
                                        } else {
                                            if (j15 != j16) {
                                                if (aVar != null) {
                                                    str5 = str8;
                                                    try {
                                                        if (aVar.f1096f.size() > 0) {
                                                            i13 = columnIndex8;
                                                            z11 = z10;
                                                            aVar.f1095e = aVar.f1095e.substring(0, r2.length() - 2);
                                                        } else {
                                                            z11 = z10;
                                                            i13 = columnIndex8;
                                                        }
                                                        bVar.f1101k.add(aVar);
                                                    } catch (Throwable th5) {
                                                        th = th5;
                                                        currentTimeMillis = currentTimeMillis;
                                                        j12 = j13;
                                                        arrayList = arrayList3;
                                                        query.close();
                                                        throw th;
                                                    }
                                                } else {
                                                    str5 = str8;
                                                    z11 = z10;
                                                    i13 = columnIndex8;
                                                }
                                                aVar = new G3.a();
                                                aVar.f1092b = j16;
                                                aVar.f1091a = j17;
                                                aVar.f1098h = j18;
                                                i15 = i21;
                                                aVar.f1093c = query.getString(i15);
                                                aVar.f1094d = query.getInt(columnIndex7);
                                                i16 = i22;
                                                aVar.f1099i = query.getString(i16);
                                                aVar.f1100j = query.getString(columnIndex10);
                                                if (!TextUtils.isEmpty(query.getString(columnIndex6))) {
                                                    aVar.f1097g = query.getLong(columnIndex6);
                                                }
                                                i14 = i19;
                                                String string3 = query.getString(i14);
                                                if (!TextUtils.isEmpty(string3)) {
                                                    String formatNumber2 = PhoneNumberUtils.formatNumber(string3);
                                                    if (!aVar.f1096f.contains(formatNumber2)) {
                                                        aVar.f1096f.add(formatNumber2);
                                                        StringBuilder sb2 = new StringBuilder();
                                                        i17 = columnIndex6;
                                                        sb2.append(aVar.f1095e);
                                                        sb2.append(formatNumber2);
                                                        sb2.append(", ");
                                                        aVar.f1095e = sb2.toString();
                                                        j15 = j16;
                                                        j14 = j18;
                                                    }
                                                }
                                                i17 = columnIndex6;
                                                j15 = j16;
                                                j14 = j18;
                                            } else {
                                                str5 = str8;
                                                z11 = z10;
                                                i13 = columnIndex8;
                                                i14 = i19;
                                                i15 = i21;
                                                i16 = i22;
                                                i17 = columnIndex6;
                                                if (aVar == null) {
                                                    String string4 = query.getString(i14);
                                                    if (!TextUtils.isEmpty(string4)) {
                                                        String formatNumber3 = PhoneNumberUtils.formatNumber(string4);
                                                        if (bVar != null && !bVar.f1096f.contains(formatNumber3)) {
                                                            bVar.f1096f.add(formatNumber3);
                                                            bVar.f1095e += formatNumber3 + ", ";
                                                        }
                                                    }
                                                } else {
                                                    String string5 = query.getString(i14);
                                                    if (!TextUtils.isEmpty(string5)) {
                                                        String formatNumber4 = PhoneNumberUtils.formatNumber(string5);
                                                        if (!aVar.f1096f.contains(formatNumber4)) {
                                                            aVar.f1096f.add(formatNumber4);
                                                            aVar.f1095e += formatNumber4 + ", ";
                                                        }
                                                    }
                                                }
                                            }
                                            cVar = this;
                                            columnIndex3 = i15;
                                            columnIndex9 = i16;
                                            columnIndex5 = i14;
                                            columnIndex4 = i18;
                                            columnIndex6 = i17;
                                            columnIndex2 = i20;
                                            columnIndex = i23;
                                            str8 = str5;
                                            columnIndex8 = i13;
                                        }
                                        z10 = z11;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        arrayList = arrayList3;
                                    }
                                }
                                boolean z12 = z10;
                                arrayList = arrayList3;
                                if (aVar != null) {
                                    if (aVar.f1096f.size() > 0) {
                                        aVar.f1095e = aVar.f1095e.substring(0, r1.length() - 2);
                                    }
                                    if (bVar != null) {
                                        bVar.f1101k.add(aVar);
                                    }
                                }
                                if (bVar != null) {
                                    if (bVar.f1096f.size() > 0) {
                                        bVar.f1095e = bVar.f1095e.substring(0, r1.length() - 2);
                                    }
                                    if (bVar.f1101k.size() > 0 && (z12 || o(cVar.f1112f, bVar))) {
                                        if (!z12) {
                                            d(bVar);
                                        }
                                        arrayList.add(bVar);
                                    }
                                }
                                try {
                                    query.close();
                                    currentTimeMillis = currentTimeMillis;
                                    j11 = j13;
                                    str2 = str;
                                } catch (Exception e12) {
                                    e = e12;
                                    currentTimeMillis = currentTimeMillis;
                                    j12 = j13;
                                    str2 = str;
                                    H7.b.b(str2, "getSimilarList error e = " + e);
                                    j11 = j12;
                                    H7.b.e(str2, "Type: " + j10 + ", queryTake: " + j11 + ", countTake: " + (System.currentTimeMillis() - currentTimeMillis));
                                    return arrayList;
                                }
                                H7.b.e(str2, "Type: " + j10 + ", queryTake: " + j11 + ", countTake: " + (System.currentTimeMillis() - currentTimeMillis));
                                return arrayList;
                            } catch (Throwable th7) {
                                th = th7;
                                str = "DBUtils";
                                arrayList = arrayList2;
                                th = th;
                                currentTimeMillis = currentTimeMillis;
                                j12 = j13;
                                query.close();
                                throw th;
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            str = "DBUtils";
                            j13 = currentTimeMillis2;
                        }
                    } catch (Throwable th9) {
                        th = th9;
                        str = "DBUtils";
                        j13 = currentTimeMillis2;
                        arrayList = arrayList2;
                        th = th;
                        j12 = j13;
                        query.close();
                        throw th;
                    }
                }
            } catch (Throwable th10) {
                str = "DBUtils";
                arrayList = arrayList2;
                th = th10;
                j12 = 0;
            }
        }
        str = "DBUtils";
        arrayList = arrayList2;
        if (query != null) {
            try {
                query.close();
            } catch (Exception e13) {
                e = e13;
                j12 = 0;
                str2 = str;
                H7.b.b(str2, "getSimilarList error e = " + e);
                j11 = j12;
                H7.b.e(str2, "Type: " + j10 + ", queryTake: " + j11 + ", countTake: " + (System.currentTimeMillis() - currentTimeMillis));
                return arrayList;
            }
        }
        return arrayList;
    }

    public boolean m() {
        return this.f1110d;
    }

    public boolean n() {
        return this.f1107a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0109, code lost:
    
        r18.f1110d = r3;
        r18.f1111e = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0130, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00f9, code lost:
    
        if (r20 == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0101, code lost:
    
        r2 = l(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0105, code lost:
    
        t(4, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0108, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x010f, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0103, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.ArrayList<G3.b>, android.os.Handler] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.ArrayList<G3.b> p(java.util.ArrayList<G3.b> r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: G3.c.p(java.util.ArrayList, boolean):java.util.ArrayList");
    }

    /* JADX WARN: Code restructure failed: missing block: B:146:0x02c4, code lost:
    
        r20 = r2;
        r21 = r3;
        r17 = r4;
        r19 = r5;
        r24 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x02d5, code lost:
    
        if (r21.size() <= 1) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02d7, code lost:
    
        r2 = new java.lang.StringBuilder();
        r4 = new java.lang.StringBuilder();
        r7 = r21;
        r2.append(java.lang.String.valueOf(((G3.b) r7.get(1)).f1092b));
        r4.append(java.lang.String.valueOf(((G3.b) r7.get(1)).f1091a));
        r3 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0306, code lost:
    
        if (r3 >= r7.size()) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0308, code lost:
    
        r2.append(",");
        r2.append(java.lang.String.valueOf(((G3.b) r7.get(r3)).f1092b));
        r4.append(",");
        r4.append(java.lang.String.valueOf(((G3.b) r7.get(r3)).f1091a));
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x032f, code lost:
    
        H7.b.e("DBUtils", "rawContactIds = " + r2.toString() + ", removedContactIds = " + r4.toString());
        r3 = new android.content.ContentValues(3);
        r3.put("contact_id", java.lang.Long.valueOf(((G3.b) r7.get(0)).f1091a));
        r3.put("raw_contact_id", java.lang.Long.valueOf(((G3.b) r7.get(0)).f1092b));
        r3.put("raw_contact_ids", r2.toString());
        r3.put("remove_contact_ids", r4.toString());
        r2 = android.content.ContentProviderOperation.newUpdate(android.net.Uri.withAppendedPath(android.provider.ContactsContract.AUTHORITY_URI, com.android.contacts.compat.data.f.c("aggregate_contacts"))).withValues(r3).withYieldAllowed(true).build();
        r3 = r20;
        r3.add(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x03b1, code lost:
    
        r3 = r20;
        r7 = r21;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x025a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void q(java.util.ArrayList<G3.b> r26, int r27) {
        /*
            Method dump skipped, instructions count: 995
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: G3.c.q(java.util.ArrayList, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:191:0x00be, code lost:
    
        if (r17 == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00aa, code lost:
    
        if (r13 != 10) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:145:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e2 A[Catch: all -> 0x0120, TRY_ENTER, TryCatch #0 {all -> 0x0120, blocks: (B:38:0x00c9, B:41:0x00e2, B:42:0x00f0, B:44:0x00f6, B:46:0x010c, B:77:0x0116, B:48:0x0123, B:51:0x0138, B:53:0x0140, B:54:0x0148, B:56:0x014e, B:57:0x0151, B:59:0x0157, B:61:0x0167, B:63:0x0174, B:66:0x017c), top: B:37:0x00c9 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01b0 A[EDGE_INSN: B:82:0x01b0->B:83:0x01b0 BREAK  A[LOOP:1: B:37:0x00c9->B:81:0x019c], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean r(G3.b r29, java.lang.String r30, java.util.ArrayList<java.lang.String> r31, java.lang.String r32) {
        /*
            Method dump skipped, instructions count: 983
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: G3.c.r(G3.b, java.lang.String, java.util.ArrayList, java.lang.String):boolean");
    }

    public final void t(int i10, int i11) {
        u(i10, i11, null);
    }

    public final void u(int i10, int i11, String str) {
        Handler handler = this.f1111e;
        if (handler == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i10;
        obtainMessage.arg1 = i11;
        obtainMessage.obj = str;
        this.f1111e.sendMessage(obtainMessage);
    }

    public void w(Handler handler) {
        this.f1111e = handler;
    }

    public void x(boolean z10) {
        this.f1107a = z10;
    }
}
