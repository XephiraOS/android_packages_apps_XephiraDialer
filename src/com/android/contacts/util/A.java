package com.android.contacts.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.ArrayMap;
import android.util.Log;
import com.android.contacts.framework.phonenumber.PhoneNumberUtils;
import com.android.contacts.model.AccountType;
import com.coui.appcompat.vibrateutil.VibrateUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import n1.AbstractC1362a;
import p.C1416b;

/* compiled from: SimilarContactLoader.kt */
/* loaded from: classes.dex */
public final class A {

    /* renamed from: f, reason: collision with root package name */
    public static final a f17515f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f17516g = {"+86"};

    /* renamed from: a, reason: collision with root package name */
    public final Context f17517a;

    /* renamed from: b, reason: collision with root package name */
    public final String f17518b;

    /* renamed from: c, reason: collision with root package name */
    public final int f17519c;

    /* renamed from: d, reason: collision with root package name */
    public final Uri f17520d;

    /* renamed from: e, reason: collision with root package name */
    public final C1416b<String> f17521e;

    /* compiled from: SimilarContactLoader.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final String[] a() {
            return A.f17516g;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: SimilarContactLoader.kt */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f17522a;

        /* renamed from: b, reason: collision with root package name */
        public final String f17523b;

        /* renamed from: c, reason: collision with root package name */
        public String f17524c;

        /* renamed from: d, reason: collision with root package name */
        public String f17525d;

        /* renamed from: e, reason: collision with root package name */
        public final String f17526e;

        public b(String _id, String displayName, String phone, String email, String lookupKey) {
            kotlin.jvm.internal.i.f(_id, "_id");
            kotlin.jvm.internal.i.f(displayName, "displayName");
            kotlin.jvm.internal.i.f(phone, "phone");
            kotlin.jvm.internal.i.f(email, "email");
            kotlin.jvm.internal.i.f(lookupKey, "lookupKey");
            this.f17522a = _id;
            this.f17523b = displayName;
            this.f17524c = phone;
            this.f17525d = email;
            this.f17526e = lookupKey;
        }

        public final String a() {
            return this.f17523b;
        }

        public final String b() {
            return this.f17525d;
        }

        public final String c() {
            return this.f17526e;
        }

        public final String d() {
            return this.f17524c;
        }

        public final String e() {
            return this.f17522a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (kotlin.jvm.internal.i.b(this.f17522a, bVar.f17522a) && kotlin.jvm.internal.i.b(this.f17523b, bVar.f17523b) && kotlin.jvm.internal.i.b(this.f17524c, bVar.f17524c) && kotlin.jvm.internal.i.b(this.f17525d, bVar.f17525d) && kotlin.jvm.internal.i.b(this.f17526e, bVar.f17526e)) {
                return true;
            }
            return false;
        }

        public final void f(String str) {
            kotlin.jvm.internal.i.f(str, "<set-?>");
            this.f17525d = str;
        }

        public final void g(String str) {
            kotlin.jvm.internal.i.f(str, "<set-?>");
            this.f17524c = str;
        }

        public int hashCode() {
            return (((((((this.f17522a.hashCode() * 31) + this.f17523b.hashCode()) * 31) + this.f17524c.hashCode()) * 31) + this.f17525d.hashCode()) * 31) + this.f17526e.hashCode();
        }

        public String toString() {
            return "SimilarContactInfo(_id=" + this.f17522a + ", displayName=" + this.f17523b + ", phone=" + this.f17524c + ", email=" + this.f17525d + ", lookupKey=" + this.f17526e + ")";
        }
    }

    public A(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        this.f17517a = context;
        this.f17518b = "ContentAssociateCreator";
        this.f17519c = VibrateUtils.STRENGTH_OFFSET;
        this.f17520d = ContactsContract.Data.CONTENT_URI;
        C1416b<String> c1416b = new C1416b<>(0, 1, null);
        this.f17521e = c1416b;
        c1416b.add("com.android.oplus.sim");
        for (AccountType accountType : AbstractC1362a.h(context).f(false)) {
            if (!accountType.b()) {
                C1416b<String> c1416b2 = this.f17521e;
                String str = accountType.c().f35594a;
                kotlin.jvm.internal.i.e(str, "account.accountTypeAndDataSet.mAccountType");
                c1416b2.add(str);
            }
        }
    }

    public static final String[] c() {
        return f17515f.a();
    }

    public final ArrayMap<String, b> b(String str, String str2, List<String> list, int i10) {
        Iterable<kotlin.collections.x> R10;
        String[] strArr;
        Iterable<kotlin.collections.x> R11;
        int i11 = 1;
        ArrayMap<String, b> arrayMap = new ArrayMap<>();
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        if (kotlin.jvm.internal.i.b(str, "vnd.android.cursor.item/phone_v2")) {
            sb.append("mimetype = ? AND REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(data1,'(',''), ')',''),'-',''),'.',''), ' ','') IN (");
        } else {
            sb.append("mimetype = ? AND data1 IN (");
        }
        for (String str3 : f17515f.a()) {
            if (kotlin.jvm.internal.i.b("vnd.android.cursor.item/phone_v2", str)) {
                String f10 = PhoneNumberUtils.f(str2, f17515f.a());
                if (!arrayList.contains(f10)) {
                    arrayList.add(f10);
                    sb.append("?,");
                }
                arrayList.add(str3 + f10);
                sb.append("?,");
            } else if (!arrayList.contains(str2)) {
                sb.append("?,");
                arrayList.add(str2);
            }
        }
        sb.setCharAt(sb.length() - 1, ')');
        C1416b c1416b = new C1416b(0, 1, null);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            c1416b.add(it.next());
        }
        if (R0.a.f3166b == null) {
            Iterator<String> it2 = this.f17521e.iterator();
            while (it2.hasNext()) {
                c1416b.remove(it2.next());
            }
            sb.append(" AND (");
            sb.append(" account_type IS NULL ");
            R11 = CollectionsKt___CollectionsKt.R(c1416b);
            for (kotlin.collections.x xVar : R11) {
                sb.append(" OR account_type = ? ");
                arrayList.add(xVar.b());
            }
            sb.append(")");
        } else {
            Iterator<String> it3 = this.f17521e.iterator();
            while (it3.hasNext()) {
                String next = it3.next();
                sb.append(" AND account_type <> ? ");
                arrayList.add(next);
                c1416b.remove(next);
            }
            sb.append(" AND (");
            R10 = CollectionsKt___CollectionsKt.R(c1416b);
            for (kotlin.collections.x xVar2 : R10) {
                if (xVar2.a() == c1416b.size() - 1) {
                    sb.append(" account_type = ? ");
                } else {
                    sb.append(" account_type = ? OR ");
                }
                arrayList.add(xVar2.b());
            }
            sb.append(")");
        }
        H7.b.b(this.f17518b, "where is : " + ((Object) sb) + " where args size is : " + arrayList.size());
        try {
            if (i10 == 1) {
                strArr = new String[]{"raw_contact_id", "data1", "lookup", "display_name"};
            } else {
                strArr = new String[]{"raw_contact_id", "data1", "lookup", "display_name_alt"};
            }
            Cursor query = this.f17517a.getContentResolver().query(ContactsContract.Data.CONTENT_URI, strArr, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null);
            if (query != null) {
                try {
                    query.moveToPosition(-1);
                    while (query.moveToNext()) {
                        String rawId = query.getString(0);
                        String value = query.getString(i11);
                        String lookup = query.getString(2);
                        String name = query.getString(3);
                        if (kotlin.jvm.internal.i.b(str, "vnd.android.cursor.item/phone_v2")) {
                            kotlin.jvm.internal.i.e(rawId, "rawId");
                            kotlin.jvm.internal.i.e(name, "name");
                            kotlin.jvm.internal.i.e(value, "value");
                            kotlin.jvm.internal.i.e(lookup, "lookup");
                            arrayMap.put(rawId, new b(rawId, name, value, "", lookup));
                        } else if (kotlin.jvm.internal.i.b(str, "vnd.android.cursor.item/email_v2")) {
                            kotlin.jvm.internal.i.e(rawId, "rawId");
                            kotlin.jvm.internal.i.e(name, "name");
                            kotlin.jvm.internal.i.e(value, "value");
                            kotlin.jvm.internal.i.e(lookup, "lookup");
                            arrayMap.put(rawId, new b(rawId, name, "", value, lookup));
                        } else {
                            kotlin.jvm.internal.i.e(rawId, "rawId");
                            kotlin.jvm.internal.i.e(name, "name");
                            kotlin.jvm.internal.i.e(lookup, "lookup");
                            arrayMap.put(rawId, new b(rawId, name, "", "", lookup));
                        }
                        i11 = 1;
                    }
                    m9.q qVar = m9.q.f35511a;
                    kotlin.io.a.a(query, null);
                } finally {
                }
            }
        } catch (Exception e10) {
            Log.d(this.f17518b, "Exception when getAllMatchedContactId " + e10);
        }
        return arrayMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x014c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.android.contacts.util.A.b> d(java.lang.String r23, java.lang.String r24, java.util.List<java.lang.String> r25, int r26) {
        /*
            Method dump skipped, instructions count: 512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.util.A.d(java.lang.String, java.lang.String, java.util.List, int):java.util.List");
    }
}
