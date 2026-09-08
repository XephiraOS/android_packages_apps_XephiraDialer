package com.customize.contacts.util;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import com.android.incallui.OplusAutoRedialNotificationUI;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;

/* compiled from: PresetContactsUtils.kt */
/* loaded from: classes3.dex */
public final class V {

    /* renamed from: a, reason: collision with root package name */
    public static final V f21975a = new V();

    /* renamed from: b, reason: collision with root package name */
    public static final String f21976b;

    /* compiled from: PresetContactsUtils.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        @E4.c("name")
        public String f21977a;

        /* renamed from: b, reason: collision with root package name */
        @E4.c("phoneNumbers")
        public List<b> f21978b;

        /* renamed from: c, reason: collision with root package name */
        @E4.c("emails")
        public List<b> f21979c;

        /* renamed from: d, reason: collision with root package name */
        @E4.c("websites")
        public List<String> f21980d;

        /* renamed from: e, reason: collision with root package name */
        @E4.c("photo")
        public String f21981e;

        public final List<b> a() {
            return this.f21979c;
        }

        public final String b() {
            return this.f21977a;
        }

        public final List<b> c() {
            return this.f21978b;
        }

        public final String d() {
            return this.f21981e;
        }

        public final List<String> e() {
            return this.f21980d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (kotlin.jvm.internal.i.b(this.f21977a, aVar.f21977a) && kotlin.jvm.internal.i.b(this.f21978b, aVar.f21978b) && kotlin.jvm.internal.i.b(this.f21979c, aVar.f21979c) && kotlin.jvm.internal.i.b(this.f21980d, aVar.f21980d) && kotlin.jvm.internal.i.b(this.f21981e, aVar.f21981e)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            String str = this.f21977a;
            int i10 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i11 = hashCode * 31;
            List<b> list = this.f21978b;
            if (list == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = list.hashCode();
            }
            int i12 = (i11 + hashCode2) * 31;
            List<b> list2 = this.f21979c;
            if (list2 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = list2.hashCode();
            }
            int i13 = (i12 + hashCode3) * 31;
            List<String> list3 = this.f21980d;
            if (list3 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = list3.hashCode();
            }
            int i14 = (i13 + hashCode4) * 31;
            String str2 = this.f21981e;
            if (str2 != null) {
                i10 = str2.hashCode();
            }
            return i14 + i10;
        }

        public String toString() {
            return "ContactBean(name=" + this.f21977a + ", phoneNumbers=" + this.f21978b + ", emails=" + this.f21979c + ", websites=" + this.f21980d + ", photo=" + this.f21981e + ")";
        }
    }

    /* compiled from: PresetContactsUtils.kt */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        @E4.c("data")
        public String f21982a;

        /* renamed from: b, reason: collision with root package name */
        @E4.c(OplusAutoRedialNotificationUI.TYPE)
        public String f21983b;

        public final String a() {
            return this.f21982a;
        }

        public final String b() {
            return this.f21983b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (kotlin.jvm.internal.i.b(this.f21982a, bVar.f21982a) && kotlin.jvm.internal.i.b(this.f21983b, bVar.f21983b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            String str = this.f21982a;
            int i10 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i11 = hashCode * 31;
            String str2 = this.f21983b;
            if (str2 != null) {
                i10 = str2.hashCode();
            }
            return i11 + i10;
        }

        public String toString() {
            return "DataAndTypeBean(data=" + this.f21982a + ", type=" + this.f21983b + ")";
        }
    }

    /* compiled from: PresetContactsUtils.kt */
    /* loaded from: classes3.dex */
    public static final class c extends J4.a<List<a>> {
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0022, code lost:
    
        if (r0 == null) goto L6;
     */
    static {
        /*
            com.customize.contacts.util.V r0 = new com.customize.contacts.util.V
            r0.<init>()
            com.customize.contacts.util.V.f21975a = r0
            java.io.File r0 = D7.a.k()
            if (r0 == 0) goto L24
            java.lang.String r0 = r0.getAbsolutePath()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "/contacts/"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            if (r0 != 0) goto L26
        L24:
            java.lang.String r0 = "/my_company/contacts/"
        L26:
            com.customize.contacts.util.V.f21976b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.util.V.<clinit>():void");
    }

    public static final void a(Context context, List<a> contactInfo) {
        byte[] e10;
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(contactInfo, "contactInfo");
        if (contactInfo.size() > 0) {
            for (a aVar : contactInfo) {
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI);
                kotlin.jvm.internal.i.e(newInsert, "newInsert(ContactsContra….RawContacts.CONTENT_URI)");
                newInsert.withValue("account_type", R0.a.f3166b).withValue("account_name", R0.a.f3165a);
                arrayList.add(newInsert.build());
                String b10 = aVar.b();
                if (b10 != null) {
                    arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/name").withValue("data1", b10).withValue("data2", b10).build());
                }
                List<b> c10 = aVar.c();
                if (c10 != null) {
                    for (b bVar : c10) {
                        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/phone_v2").withValue("data1", bVar.a()).withValue("data2", bVar.b()).build());
                    }
                }
                List<b> a10 = aVar.a();
                if (a10 != null) {
                    for (b bVar2 : a10) {
                        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/email_v2").withValue("data1", bVar2.a()).withValue("data2", bVar2.b()).build());
                    }
                }
                List<String> e11 = aVar.e();
                if (e11 != null) {
                    Iterator<String> it = e11.iterator();
                    while (it.hasNext()) {
                        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/website").withValue("data1", it.next()).withValue("data2", 7).build());
                    }
                }
                String d10 = aVar.d();
                if (d10 != null) {
                    File file = new File(f21976b + d10);
                    if (file.exists() && (e10 = com.android.contacts.util.i.e(BitmapFactory.decodeFile(file.toString()), 1080.0f, 2400.0f)) != null) {
                        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/photo").withValue("data15", e10).build());
                    }
                }
                context.getContentResolver().applyBatch("com.android.contacts", arrayList);
            }
        }
    }

    public static final synchronized void b(Context context) {
        Object b10;
        synchronized (V.class) {
            try {
                kotlin.jvm.internal.i.f(context, "context");
                boolean equals = TextUtils.equals(d(context), "true");
                if (H7.a.b()) {
                    H7.b.b("PresetContactsUtils", "presetContactsIfNeed: hasPresetContacts = " + equals);
                }
                File file = new File(f21976b + "contacts_info.json");
                if (!equals && file.exists()) {
                    if (H7.a.b()) {
                        H7.b.b("PresetContactsUtils", "presetContactsIfNeed: contactsInfoFile exists");
                    }
                    try {
                        Result.a aVar = Result.f34166a;
                        List list = (List) new com.google.gson.d().k(c(file), new c().getType());
                        if (list != null) {
                            if (H7.a.b()) {
                                H7.b.b("PresetContactsUtils", "presetContactsIfNeed: " + list.size());
                            }
                            a(context, list);
                        }
                        e(context);
                        b10 = Result.b(m9.q.f35511a);
                    } catch (Throwable th) {
                        Result.a aVar2 = Result.f34166a;
                        b10 = Result.b(kotlin.b.a(th));
                    }
                    Throwable d10 = Result.d(b10);
                    if (d10 != null) {
                        Log.e("ExceptionUtils", "Exception when invoke block : " + d10);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:
    
        if (r6 == null) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String c(java.io.File r6) {
        /*
            java.lang.String r0 = "file"
            kotlin.jvm.internal.i.f(r6, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            r6.<init>(r2)     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
        L1a:
            java.lang.String r1 = r6.readLine()     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L27
            if (r1 == 0) goto L29
            r0.append(r1)     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L27
            goto L1a
        L24:
            r0 = move-exception
            r1 = r6
            goto L56
        L27:
            r1 = move-exception
            goto L33
        L29:
            r6.close()
            goto L4c
        L2d:
            r0 = move-exception
            goto L56
        L2f:
            r6 = move-exception
            r5 = r1
            r1 = r6
            r6 = r5
        L33:
            java.lang.String r2 = "PresetContactsUtils"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L24
            r3.<init>()     // Catch: java.lang.Throwable -> L24
            java.lang.String r4 = "readContactsInfoFile: e = "
            r3.append(r4)     // Catch: java.lang.Throwable -> L24
            r3.append(r1)     // Catch: java.lang.Throwable -> L24
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L24
            android.util.Log.e(r2, r1)     // Catch: java.lang.Throwable -> L24
            if (r6 == 0) goto L4c
            goto L29
        L4c:
            java.lang.String r6 = r0.toString()
            java.lang.String r0 = "stringBuilder.toString()"
            kotlin.jvm.internal.i.e(r6, r0)
            return r6
        L56:
            if (r1 == 0) goto L5b
            r1.close()
        L5b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.util.V.c(java.io.File):java.lang.String");
    }

    public static final String d(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        Bundle bundle = new Bundle();
        bundle.putString("key_property_key", "has_preset_contacts");
        Bundle call = context.getContentResolver().call(ContactsContract.AUTHORITY_URI, "method_get_property", (String) null, bundle);
        if (call == null) {
            return null;
        }
        return call.getString("key_property_value");
    }

    public static final void e(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        Bundle bundle = new Bundle();
        bundle.putString("key_property_key", "has_preset_contacts");
        bundle.putString("key_property_value", "true");
        Boolean bool = null;
        Bundle call = context.getContentResolver().call(ContactsContract.AUTHORITY_URI, "method_set_property", (String) null, bundle);
        if (H7.a.b()) {
            if (call != null) {
                bool = Boolean.valueOf(call.getBoolean("key_set_property_result"));
            }
            H7.b.b("PresetContactsUtils", "writeSharedPreferenceToContactsProvider result: " + bool);
        }
    }
}
