package com.android.contacts.framework.vcard;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Base64;
import com.customize.contacts.backupandrestore.plugin.ContactBackupPlugin;
import com.oplus.backup.sdk.common.utils.Constants;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: VCardBuilder.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: r, reason: collision with root package name */
    public static final Set<String> f16479r = Collections.unmodifiableSet(new HashSet(Arrays.asList("vnd.android.cursor.item/nickname", "vnd.android.cursor.item/contact_event", "vnd.android.cursor.item/relation", "vnd.android.cursor.item/im", "vnd.android.cursor.item/omoji_photo")));

    /* renamed from: s, reason: collision with root package name */
    public static final Map<Integer, Integer> f16480s;

    /* renamed from: a, reason: collision with root package name */
    public final int f16481a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f16482b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f16483c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f16484d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f16485e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f16486f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f16487g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f16488h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f16489i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f16490j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f16491k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f16492l;

    /* renamed from: m, reason: collision with root package name */
    public final String f16493m;

    /* renamed from: n, reason: collision with root package name */
    public final String f16494n;

    /* renamed from: o, reason: collision with root package name */
    public StringBuilder f16495o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f16496p;

    /* renamed from: q, reason: collision with root package name */
    public Context f16497q;

    /* compiled from: VCardBuilder.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f16498a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f16499b;

        /* renamed from: c, reason: collision with root package name */
        public final String f16500c;

        public a(boolean z10, boolean z11, String str) {
            this.f16498a = z10;
            this.f16499b = z11;
            this.f16500c = str;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f16480s = hashMap;
        hashMap.put(1, 0);
        hashMap.put(2, 1);
        hashMap.put(3, 2);
        hashMap.put(0, 3);
    }

    public c(Context context, int i10, String str) {
        boolean z10;
        this.f16497q = context;
        this.f16481a = i10;
        if (e.h(i10)) {
            H7.b.i(h.LOG_TAG, "Should not use vCard 4.0 when building vCard. It is not officially published yet.");
        }
        boolean z11 = true;
        if (!e.g(i10) && !e.h(i10)) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.f16482b = z10;
        this.f16486f = e.m(i10);
        this.f16485e = e.d(i10);
        this.f16483c = e.i(i10);
        this.f16484d = e.j(i10);
        this.f16487g = e.o(i10);
        this.f16488h = e.p(i10);
        this.f16490j = e.l(i10);
        this.f16489i = e.a(i10);
        this.f16491k = e.i(i10);
        if (e.g(i10) && "UTF-8".equalsIgnoreCase(str)) {
            z11 = false;
        }
        this.f16492l = z11;
        if (e.d(i10)) {
            if (!"SHIFT_JIS".equalsIgnoreCase(str)) {
                if (TextUtils.isEmpty(str)) {
                    this.f16493m = "SHIFT_JIS";
                } else {
                    this.f16493m = str;
                }
            } else {
                this.f16493m = str;
            }
            this.f16494n = "CHARSET=SHIFT_JIS";
        } else if (TextUtils.isEmpty(str)) {
            H7.b.e(h.LOG_TAG, "Use the charset \"UTF-8\" for export.");
            this.f16493m = "UTF-8";
            this.f16494n = "CHARSET=UTF-8";
        } else {
            this.f16493m = str;
            this.f16494n = "CHARSET=" + str;
        }
        M();
    }

    public c A(List<ContentValues> list) {
        if (list != null && !list.isEmpty()) {
            if (this.f16485e) {
                B(list);
            } else {
                C(list);
            }
        } else if (this.f16485e) {
            this.f16495o.append("ADR");
            this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
            this.f16495o.append("HOME");
            this.f16495o.append(":");
            this.f16495o.append(ContactBackupPlugin.END_OF_LINE);
        }
        return this;
    }

    public final void B(List<ContentValues> list) {
        ContentValues contentValues;
        int i10;
        int i11;
        Iterator<ContentValues> it = list.iterator();
        ContentValues contentValues2 = null;
        int i12 = Integer.MAX_VALUE;
        int i13 = Integer.MAX_VALUE;
        while (true) {
            if (it.hasNext()) {
                ContentValues next = it.next();
                if (next != null) {
                    Integer asInteger = next.getAsInteger("data2");
                    Integer num = f16480s.get(asInteger);
                    if (num != null) {
                        i11 = num.intValue();
                    } else {
                        i11 = Integer.MAX_VALUE;
                    }
                    if (i11 < i12) {
                        i13 = asInteger.intValue();
                        if (i11 == 0) {
                            i10 = i13;
                            contentValues = next;
                            break;
                        } else {
                            contentValues2 = next;
                            i12 = i11;
                        }
                    } else {
                        continue;
                    }
                }
            } else {
                contentValues = contentValues2;
                i10 = i13;
                break;
            }
        }
        if (contentValues == null) {
            H7.b.i(h.LOG_TAG, "Should not come here. Must have at least one postal data.");
        } else {
            z(i10, contentValues.getAsString("data3"), contentValues, false, true);
        }
    }

    public final void C(List<ContentValues> list) {
        int i10;
        for (ContentValues contentValues : list) {
            if (contentValues != null) {
                Integer asInteger = contentValues.getAsInteger("data2");
                if (asInteger != null) {
                    i10 = asInteger.intValue();
                } else {
                    i10 = 1;
                }
                String asString = contentValues.getAsString("data3");
                Integer asInteger2 = contentValues.getAsInteger("is_primary");
                boolean z10 = false;
                if (asInteger2 != null && asInteger2.intValue() > 0) {
                    z10 = true;
                }
                z(i10, asString, contentValues, z10, false);
            }
        }
    }

    public c D(List<ContentValues> list) {
        if (this.f16487g && list != null) {
            for (ContentValues contentValues : list) {
                if (contentValues != null) {
                    a("vnd.android.cursor.item/relation", contentValues);
                }
            }
        }
        return this;
    }

    public c E(List<ContentValues> list) {
        boolean z10;
        String str;
        if (this.f16482b) {
            z10 = false;
        } else {
            if (this.f16488h) {
                z10 = true;
            }
            return this;
        }
        if (list != null) {
            Iterator<ContentValues> it = list.iterator();
            while (it.hasNext()) {
                String asString = it.next().getAsString("data1");
                if (!TextUtils.isEmpty(asString)) {
                    if (z10) {
                        if (asString.startsWith("sip:")) {
                            if (asString.length() != 4) {
                                asString = asString.substring(4);
                            }
                        }
                        n("X-SIP", asString);
                    } else {
                        if (!asString.startsWith("sip:")) {
                            asString = "sip:" + asString;
                        }
                        if (e.h(this.f16481a)) {
                            str = "TEL";
                        } else {
                            str = "IMPP";
                        }
                        n(str, asString);
                    }
                }
            }
        }
        return this;
    }

    public void F(List<ContentValues> list, boolean z10) {
        Long asLong;
        if (list != null && list.size() > 0 && (asLong = list.get(0).getAsLong("starred")) != null && asLong.longValue() != 0) {
            k(r0.k.a("X-CUSTOMIZE-STARRED", z10), String.valueOf(asLong));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x014a, code lost:
    
        if (r9 == false) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void G(java.lang.Integer r6, java.lang.String r7, java.lang.String r8, boolean r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.vcard.c.G(java.lang.Integer, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, boolean):void");
    }

    public final void H(String str) {
        I(this.f16495o, str);
    }

    public final void I(StringBuilder sb, String str) {
        if (e.h(this.f16481a) || ((e.g(this.f16481a) || this.f16489i) && !this.f16485e)) {
            sb.append("TYPE");
            sb.append("=");
        }
        sb.append(str);
    }

    public final void J(List<String> list) {
        String F10;
        boolean z10 = true;
        for (String str : list) {
            if (!e.g(this.f16481a) && !e.h(this.f16481a)) {
                if (VCardUtils.x(str)) {
                    if (z10) {
                        z10 = false;
                    } else {
                        this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
                    }
                    H(str);
                }
            } else {
                if (e.h(this.f16481a)) {
                    F10 = VCardUtils.G(str);
                } else {
                    F10 = VCardUtils.F(str);
                }
                if (!TextUtils.isEmpty(F10)) {
                    if (z10) {
                        z10 = false;
                    } else {
                        this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
                    }
                    H(F10);
                }
            }
        }
    }

    public final void K(StringBuilder sb, Integer num) {
        if (this.f16485e) {
            sb.append("VOICE");
            return;
        }
        String r10 = VCardUtils.r(num);
        if (r10 != null) {
            H(r10);
            return;
        }
        H7.b.c(h.LOG_TAG, "Unknown or unsupported (by vCard) Phone type: " + num);
    }

    public c L(List<ContentValues> list) {
        if (list != null) {
            Iterator<ContentValues> it = list.iterator();
            while (it.hasNext()) {
                String asString = it.next().getAsString("data1");
                if (asString != null) {
                    asString = asString.trim();
                }
                if (!TextUtils.isEmpty(asString)) {
                    n("URL", asString);
                }
            }
        }
        return this;
    }

    public void M() {
        this.f16495o = new StringBuilder();
        this.f16496p = false;
        k("BEGIN", "VCARD");
        if (e.h(this.f16481a)) {
            k("VERSION", "4.0");
        } else {
            if (e.g(this.f16481a)) {
                k("VERSION", "3.0");
                return;
            }
            if (!e.f(this.f16481a)) {
                H7.b.i(h.LOG_TAG, "Unknown vCard version detected.");
            }
            k("VERSION", "2.1");
        }
    }

    public final boolean N(ContentValues contentValues) {
        String asString = contentValues.getAsString("data3");
        String asString2 = contentValues.getAsString("data5");
        String asString3 = contentValues.getAsString("data2");
        String asString4 = contentValues.getAsString("data4");
        String asString5 = contentValues.getAsString("data6");
        String asString6 = contentValues.getAsString("data9");
        String asString7 = contentValues.getAsString("data8");
        String asString8 = contentValues.getAsString("data7");
        String asString9 = contentValues.getAsString("data1");
        if (TextUtils.isEmpty(asString) && TextUtils.isEmpty(asString2) && TextUtils.isEmpty(asString3) && TextUtils.isEmpty(asString4) && TextUtils.isEmpty(asString5) && TextUtils.isEmpty(asString6) && TextUtils.isEmpty(asString7) && TextUtils.isEmpty(asString8) && TextUtils.isEmpty(asString9)) {
            return false;
        }
        return true;
    }

    public final String O(String str) {
        byte[] bytes;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            bytes = str.getBytes(this.f16493m);
        } catch (UnsupportedEncodingException unused) {
            H7.b.c(h.LOG_TAG, "Charset " + this.f16493m + " cannot be used. Try default charset");
            bytes = str.getBytes();
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < bytes.length) {
            sb.append(String.format("=%02X", Byte.valueOf(bytes[i10])));
            i10++;
            i11 += 3;
            if (i11 >= 67) {
                sb.append("=\r\n");
                i11 = 0;
            }
        }
        return sb.toString();
    }

    public final String P(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (charAt != '\n') {
                if (charAt != '\r') {
                    if (charAt != ',') {
                        if (charAt != '>') {
                            if (charAt != '\\') {
                                if (charAt != ';') {
                                    if (charAt != '<') {
                                        sb.append(charAt);
                                    }
                                } else {
                                    sb.append('\\');
                                    sb.append(';');
                                }
                            } else if (this.f16482b) {
                                sb.append("\\\\");
                            }
                        }
                        if (this.f16485e) {
                            sb.append('\\');
                            sb.append(charAt);
                        } else {
                            sb.append(charAt);
                        }
                    } else if (this.f16482b) {
                        sb.append("\\,");
                    } else {
                        sb.append(charAt);
                    }
                } else if (i10 + 1 < length && str.charAt(i10) == '\n') {
                }
            }
            sb.append("\\n");
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0043, code lost:
    
        if (N(r2) == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0045, code lost:
    
        r1 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.content.ContentValues Q(java.util.List<android.content.ContentValues> r5) {
        /*
            r4 = this;
            java.util.Iterator r5 = r5.iterator()
            r0 = 0
            r1 = r0
        L6:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L47
            java.lang.Object r2 = r5.next()
            android.content.ContentValues r2 = (android.content.ContentValues) r2
            if (r2 != 0) goto L15
            goto L6
        L15:
            java.lang.String r3 = "is_super_primary"
            java.lang.Integer r3 = r2.getAsInteger(r3)
            if (r3 == 0) goto L25
            int r3 = r3.intValue()
            if (r3 <= 0) goto L25
            r0 = r2
            goto L47
        L25:
            if (r0 != 0) goto L6
            java.lang.String r3 = "is_primary"
            java.lang.Integer r3 = r2.getAsInteger(r3)
            if (r3 == 0) goto L3d
            int r3 = r3.intValue()
            if (r3 <= 0) goto L3d
            boolean r3 = r4.N(r2)
            if (r3 == 0) goto L3d
            r0 = r2
            goto L6
        L3d:
            if (r1 != 0) goto L6
            boolean r3 = r4.N(r2)
            if (r3 == 0) goto L6
            r1 = r2
            goto L6
        L47:
            if (r0 != 0) goto L52
            if (r1 == 0) goto L4c
            goto L53
        L4c:
            android.content.ContentValues r1 = new android.content.ContentValues
            r1.<init>()
            goto L53
        L52:
            r1 = r0
        L53:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.vcard.c.Q(java.util.List):android.content.ContentValues");
    }

    public final boolean R(String... strArr) {
        if (!this.f16492l) {
            return false;
        }
        for (String str : strArr) {
            if (!VCardUtils.l(str)) {
                return true;
            }
        }
        return false;
    }

    public final List<String> S(String str) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (charAt == '\n' && sb.length() > 0) {
                arrayList.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(charAt);
            }
        }
        if (sb.length() > 0) {
            arrayList.add(sb.toString());
        }
        return arrayList;
    }

    public a T(ContentValues contentValues) {
        String P10;
        String P11;
        String P12;
        String P13;
        String P14;
        String P15;
        String str;
        String asString = contentValues.getAsString("data5");
        String asString2 = contentValues.getAsString("data6");
        String asString3 = contentValues.getAsString("data4");
        String asString4 = contentValues.getAsString("data7");
        String asString5 = contentValues.getAsString("data8");
        String asString6 = contentValues.getAsString("data9");
        String asString7 = contentValues.getAsString("data10");
        String[] strArr = {asString, asString2, asString3, asString4, asString5, asString6, asString7};
        boolean z10 = false;
        if (!VCardUtils.b(strArr)) {
            if (this.f16486f && !VCardUtils.j(strArr)) {
                z10 = true;
            }
            boolean z11 = !VCardUtils.l(strArr);
            if (TextUtils.isEmpty(asString4)) {
                if (TextUtils.isEmpty(asString2)) {
                    asString4 = "";
                } else {
                    asString4 = asString2;
                }
            } else if (!TextUtils.isEmpty(asString2)) {
                asString4 = asString4 + " " + asString2;
            }
            if (z10) {
                P11 = O(asString);
                P12 = O(asString3);
                P13 = O(asString4);
                P14 = O(asString5);
                P15 = O(asString6);
                str = O(asString7);
            } else {
                P11 = P(asString);
                P12 = P(asString3);
                P13 = P(asString4);
                P14 = P(asString5);
                P15 = P(asString6);
                String P16 = P(asString7);
                P(asString2);
                str = P16;
            }
            return new a(z10, z11, P11 + Constants.DataMigration.SPLIT_TAG + Constants.DataMigration.SPLIT_TAG + P12 + Constants.DataMigration.SPLIT_TAG + P13 + Constants.DataMigration.SPLIT_TAG + P14 + Constants.DataMigration.SPLIT_TAG + P15 + Constants.DataMigration.SPLIT_TAG + str);
        }
        String asString8 = contentValues.getAsString("data1");
        if (TextUtils.isEmpty(asString8)) {
            return null;
        }
        if (this.f16486f && !VCardUtils.j(asString8)) {
            z10 = true;
        }
        boolean z12 = !VCardUtils.l(asString8);
        if (z10) {
            P10 = O(asString8);
        } else {
            P10 = P(asString8);
        }
        return new a(z10, z12, Constants.DataMigration.SPLIT_TAG + P10 + Constants.DataMigration.SPLIT_TAG + Constants.DataMigration.SPLIT_TAG + Constants.DataMigration.SPLIT_TAG + Constants.DataMigration.SPLIT_TAG + Constants.DataMigration.SPLIT_TAG);
    }

    public void a(String str, ContentValues contentValues) {
        boolean z10;
        String P10;
        if (!f16479r.contains(str)) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList();
        boolean z11 = true;
        for (int i10 = 1; i10 <= 15; i10++) {
            String asString = contentValues.getAsString("data" + i10);
            if (asString == null) {
                asString = "";
            }
            arrayList.add(asString);
        }
        if (this.f16492l && !VCardUtils.i(arrayList)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!this.f16486f || VCardUtils.i(arrayList)) {
            z11 = false;
        }
        if (TextUtils.equals("vnd.android.cursor.item/omoji_photo", str)) {
            this.f16495o.append("X-CUSTOMIZE-OMOJI");
        } else {
            this.f16495o.append("X-ANDROID-CUSTOM");
        }
        if (z10) {
            this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
            this.f16495o.append(this.f16494n);
        }
        if (z11) {
            this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
            this.f16495o.append("ENCODING=QUOTED-PRINTABLE");
        }
        this.f16495o.append(":");
        this.f16495o.append(str);
        for (String str2 : arrayList) {
            if (z11) {
                P10 = O(str2);
            } else {
                P10 = P(str2);
            }
            this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
            this.f16495o.append(P10);
        }
        this.f16495o.append(ContactBackupPlugin.END_OF_LINE);
    }

    public void b(String str, String str2, boolean z10) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append("BUSINESS-CARD-PHOTO");
        sb.append(Constants.DataMigration.SPLIT_TAG);
        if (z10) {
            str3 = "FRONT";
        } else {
            str3 = "BACK";
        }
        sb.append(str3);
        sb.append(Constants.DataMigration.SPLIT_TAG);
        if (this.f16482b) {
            sb.append("ENCODING=B");
        } else {
            sb.append("ENCODING=BASE64");
        }
        sb.append(Constants.DataMigration.SPLIT_TAG);
        I(sb, str2);
        sb.append(":");
        sb.append(str);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        int length = sb2.length();
        int i10 = 73;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            sb3.append(sb2.charAt(i12));
            i11++;
            if (i11 > i10) {
                sb3.append(ContactBackupPlugin.END_OF_LINE);
                sb3.append(" ");
                i10 = 72;
                i11 = 0;
            }
        }
        this.f16495o.append(sb3.toString());
        this.f16495o.append(ContactBackupPlugin.END_OF_LINE);
        this.f16495o.append(ContactBackupPlugin.END_OF_LINE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0006 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.android.contacts.framework.vcard.c c(java.util.List<android.content.ContentValues> r6) {
        /*
            r5 = this;
            if (r6 == 0) goto L7a
            java.util.Iterator r6 = r6.iterator()
        L6:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L7a
            java.lang.Object r0 = r6.next()
            android.content.ContentValues r0 = (android.content.ContentValues) r0
            if (r0 != 0) goto L15
            goto L6
        L15:
            java.lang.String r1 = "data1"
            java.lang.String r1 = r0.getAsString(r1)
            java.lang.String r2 = "vCard"
            if (r1 == 0) goto L47
            android.content.Context r3 = r5.f16497q     // Catch: java.io.FileNotFoundException -> L32
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.io.FileNotFoundException -> L32
            android.graphics.Bitmap r1 = I7.a.e(r3, r1)     // Catch: java.io.FileNotFoundException -> L32
            r3 = 819200(0xc8000, float:1.147944E-39)
            byte[] r1 = I7.a.a(r1, r3)     // Catch: java.io.FileNotFoundException -> L32
            goto L48
        L32:
            r1 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "e = "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            H7.b.c(r2, r1)
        L47:
            r1 = 0
        L48:
            if (r1 != 0) goto L4b
            goto L6
        L4b:
            java.lang.String r3 = com.android.contacts.framework.vcard.VCardUtils.v(r1)
            if (r3 != 0) goto L57
            java.lang.String r0 = "Unknown photo type. Ignored."
            H7.b.b(r2, r0)
            goto L6
        L57:
            java.lang.String r2 = new java.lang.String
            r4 = 2
            byte[] r1 = android.util.Base64.encode(r1, r4)
            r2.<init>(r1)
            java.lang.String r1 = "data2"
            java.lang.Integer r0 = r0.getAsInteger(r1)
            int r0 = r0.intValue()
            if (r0 != 0) goto L6f
            r0 = 1
            goto L70
        L6f:
            r0 = 0
        L70:
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto L6
            r5.b(r2, r3, r0)
            goto L6
        L7a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.vcard.c.c(java.util.List):com.android.contacts.framework.vcard.c");
    }

    public void d(List<ContentValues> list, boolean z10) {
        Long asLong;
        if (list != null && list.size() > 0 && (asLong = list.get(0).getAsLong(R0.c.f3184b)) != null && asLong.longValue() != 0) {
            k(r0.k.a("X-CUSTOMIZE-MODIFY-DATE", z10), String.valueOf(asLong));
        }
    }

    public void e(int i10, String str, String str2, boolean z10) {
        String str3 = "HOME";
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    str3 = null;
                    if (i10 != 3) {
                        if (i10 != 4) {
                            H7.b.c(h.LOG_TAG, "Unknown Email type: " + i10);
                        }
                        str3 = "CELL";
                    }
                } else {
                    str3 = "WORK";
                }
            }
        } else {
            if (!VCardUtils.w(str)) {
                if (!TextUtils.isEmpty(str) && VCardUtils.h(str)) {
                    str3 = "X-" + str;
                }
            }
            str3 = "CELL";
        }
        ArrayList arrayList = new ArrayList();
        if (z10) {
            arrayList.add("PREF");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(str3);
        }
        o("EMAIL", arrayList, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0060, code lost:
    
        if (r3 == false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.android.contacts.framework.vcard.c f(java.util.List<android.content.ContentValues> r9) {
        /*
            r8 = this;
            r0 = 1
            r1 = 0
            if (r9 == 0) goto L62
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.Iterator r9 = r9.iterator()
            r3 = r1
        Le:
            boolean r4 = r9.hasNext()
            if (r4 == 0) goto L60
            java.lang.Object r4 = r9.next()
            android.content.ContentValues r4 = (android.content.ContentValues) r4
            java.lang.String r5 = "data1"
            java.lang.String r5 = r4.getAsString(r5)
            if (r5 == 0) goto L26
            java.lang.String r5 = r5.trim()
        L26:
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 == 0) goto L2d
            goto Le
        L2d:
            java.lang.String r3 = "data2"
            java.lang.Integer r3 = r4.getAsInteger(r3)
            if (r3 == 0) goto L3a
            int r3 = r3.intValue()
            goto L3b
        L3a:
            r3 = 3
        L3b:
            java.lang.String r6 = "data3"
            java.lang.String r6 = r4.getAsString(r6)
            java.lang.String r7 = "is_primary"
            java.lang.Integer r4 = r4.getAsInteger(r7)
            if (r4 == 0) goto L51
            int r4 = r4.intValue()
            if (r4 <= 0) goto L51
            r4 = r0
            goto L52
        L51:
            r4 = r1
        L52:
            boolean r7 = r2.contains(r5)
            if (r7 != 0) goto L5e
            r2.add(r5)
            r8.e(r3, r6, r5, r4)
        L5e:
            r3 = r0
            goto Le
        L60:
            if (r3 != 0) goto L6b
        L62:
            boolean r9 = r8.f16485e
            if (r9 == 0) goto L6b
            java.lang.String r9 = ""
            r8.e(r0, r9, r9, r1)
        L6b:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.vcard.c.f(java.util.List):com.android.contacts.framework.vcard.c");
    }

    public c g(List<ContentValues> list, boolean z10) {
        int i10;
        if (list != null) {
            Iterator<ContentValues> it = list.iterator();
            String str = null;
            String str2 = null;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ContentValues next = it.next();
                if (next != null) {
                    Integer asInteger = next.getAsInteger("data2");
                    if (asInteger != null && asInteger.intValue() == 3) {
                        String asString = next.getAsString("data1");
                        if (asString != null) {
                            Integer asInteger2 = next.getAsInteger("data10");
                            if (asInteger2 != null) {
                                i10 = asInteger2.intValue();
                            } else {
                                i10 = 0;
                            }
                            Integer asInteger3 = next.getAsInteger("is_super_primary");
                            if (asInteger3 != null && asInteger3.intValue() > 0) {
                                str = asString;
                                i11 = i10;
                                break;
                            }
                            Integer asInteger4 = next.getAsInteger("is_primary");
                            if (asInteger4 != null && asInteger4.intValue() > 0) {
                                str = asString;
                                i11 = i10;
                            } else if (str2 == null) {
                                str2 = asString;
                                i12 = i10;
                            }
                        } else {
                            continue;
                        }
                    } else if (this.f16487g) {
                        a("vnd.android.cursor.item/contact_event", next);
                    }
                }
            }
            String str3 = "BDAY";
            if (str != null) {
                if (i11 != 0) {
                    str3 = r0.k.a("CUSTOMIZE-CBDAY", z10);
                }
                n(str3, str.trim());
            } else if (str2 != null) {
                if (i12 != 0) {
                    str3 = r0.k.a("CUSTOMIZE-CBDAY", z10);
                }
                n(str3, str2.trim());
            }
        }
        return this;
    }

    public void h(ContentResolver contentResolver, List<ContentValues> list, boolean z10) {
        H7.b.b(h.LOG_TAG, "appendGroup(), begin");
        if (list != null && list.size() > 0) {
            for (ContentValues contentValues : list) {
                if (contentValues != null && contentValues.getAsLong("data1") != null) {
                    String asString = contentValues.getAsString("title");
                    H7.b.b(h.LOG_TAG, "appendGroup(), title = " + asString);
                    if (!TextUtils.isEmpty(asString)) {
                        i(asString, z10);
                    }
                }
            }
            return;
        }
        H7.b.b(h.LOG_TAG, "appendGroup(), contentValuesList = " + list);
    }

    public void i(String str, boolean z10) {
        boolean z11 = true;
        boolean z12 = !VCardUtils.l(str);
        if (!this.f16486f || VCardUtils.j(str)) {
            z11 = false;
        }
        l(r0.k.a("X-CUSTOMIZE-GROUP", z10), str, z12, z11);
    }

    public c j(List<ContentValues> list) {
        int i10;
        if (list != null) {
            for (ContentValues contentValues : list) {
                Integer asInteger = contentValues.getAsInteger("data5");
                if (asInteger != null) {
                    String t10 = VCardUtils.t(asInteger.intValue());
                    if (t10 == null) {
                        a("vnd.android.cursor.item/im", contentValues);
                    } else {
                        String asString = contentValues.getAsString("data1");
                        if (asString != null) {
                            asString = asString.trim();
                        }
                        if (!TextUtils.isEmpty(asString)) {
                            Integer asInteger2 = contentValues.getAsInteger("data2");
                            if (asInteger2 != null) {
                                i10 = asInteger2.intValue();
                            } else {
                                i10 = 3;
                            }
                            String str = null;
                            if (i10 != 0) {
                                if (i10 != 1) {
                                    if (i10 == 2) {
                                        str = "WORK";
                                    }
                                } else {
                                    str = "HOME";
                                }
                            } else {
                                String asString2 = contentValues.getAsString("data3");
                                if (asString2 != null) {
                                    str = "X-" + asString2;
                                }
                            }
                            ArrayList arrayList = new ArrayList();
                            if (!TextUtils.isEmpty(str)) {
                                arrayList.add(str);
                            }
                            Integer asInteger3 = contentValues.getAsInteger("is_primary");
                            if (asInteger3 != null && asInteger3.intValue() > 0) {
                                arrayList.add("PREF");
                            }
                            o(t10, arrayList, asString);
                        }
                    }
                }
            }
        }
        return this;
    }

    public void k(String str, String str2) {
        l(str, str2, false, false);
    }

    public void l(String str, String str2, boolean z10, boolean z11) {
        m(str, null, str2, z10, z11);
    }

    public void m(String str, List<String> list, String str2, boolean z10, boolean z11) {
        String P10;
        this.f16495o.append(str);
        if (list != null && list.size() > 0) {
            this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
            J(list);
        }
        if (z10) {
            this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
            this.f16495o.append(this.f16494n);
        }
        if (z11) {
            this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
            this.f16495o.append("ENCODING=QUOTED-PRINTABLE");
            P10 = O(str2);
        } else {
            P10 = P(str2);
        }
        this.f16495o.append(":");
        this.f16495o.append(P10);
        this.f16495o.append(ContactBackupPlugin.END_OF_LINE);
    }

    public void n(String str, String str2) {
        o(str, null, str2);
    }

    public void o(String str, List<String> list, String str2) {
        boolean z10 = true;
        boolean z11 = !VCardUtils.l(str2);
        if (!this.f16486f || VCardUtils.j(str2)) {
            z10 = false;
        }
        m(str, list, str2, z11, z10);
    }

    public c p(List<ContentValues> list) {
        boolean z10;
        ContentValues contentValues;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String P10;
        String P11;
        String P12;
        String P13;
        String P14;
        String P15;
        String str6;
        ContentValues contentValues2;
        String P16;
        if (e.h(this.f16481a)) {
            return q(list);
        }
        if (list != null && !list.isEmpty()) {
            ContentValues Q10 = Q(list);
            String asString = Q10.getAsString("data3");
            String asString2 = Q10.getAsString("data5");
            String asString3 = Q10.getAsString("data2");
            String asString4 = Q10.getAsString("data4");
            String asString5 = Q10.getAsString("data6");
            String asString6 = Q10.getAsString("data1");
            boolean z11 = false;
            if (TextUtils.isEmpty(asString) && TextUtils.isEmpty(asString3)) {
                if (!TextUtils.isEmpty(asString6)) {
                    if (!this.f16490j && !VCardUtils.j(asString6)) {
                        z11 = true;
                    }
                    if (z11) {
                        P16 = O(asString6);
                    } else {
                        P16 = P(asString6);
                    }
                    this.f16495o.append("N");
                    if (R(asString6)) {
                        this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
                        this.f16495o.append(this.f16494n);
                    }
                    if (z11) {
                        this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
                        this.f16495o.append("ENCODING=QUOTED-PRINTABLE");
                    }
                    this.f16495o.append(":");
                    this.f16495o.append(P16);
                    this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
                    this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
                    this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
                    this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
                    this.f16495o.append(ContactBackupPlugin.END_OF_LINE);
                    this.f16495o.append("FN");
                    if (R(asString6)) {
                        this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
                        this.f16495o.append(this.f16494n);
                    }
                    this.f16495o.append(":");
                    this.f16495o.append(P16);
                    this.f16495o.append(ContactBackupPlugin.END_OF_LINE);
                } else if (e.g(this.f16481a)) {
                    k("N", "");
                    k("FN", "");
                } else if (this.f16485e) {
                    k("N", "");
                }
                contentValues2 = Q10;
            } else {
                boolean R10 = R(asString, asString3, asString2, asString4, asString5);
                if (!this.f16490j && (!VCardUtils.j(asString) || !VCardUtils.j(asString3) || !VCardUtils.j(asString2) || !VCardUtils.j(asString4) || !VCardUtils.j(asString5))) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!TextUtils.isEmpty(asString6)) {
                    str2 = "FN";
                    contentValues = Q10;
                    str = Constants.DataMigration.SPLIT_TAG;
                    str3 = ":";
                    str4 = "ENCODING=QUOTED-PRINTABLE";
                    str5 = ContactBackupPlugin.END_OF_LINE;
                } else {
                    int b10 = e.b(this.f16481a);
                    contentValues = Q10;
                    str = Constants.DataMigration.SPLIT_TAG;
                    str2 = "FN";
                    str3 = ":";
                    str4 = "ENCODING=QUOTED-PRINTABLE";
                    str5 = ContactBackupPlugin.END_OF_LINE;
                    asString6 = VCardUtils.e(b10, asString, asString2, asString3, asString4, asString5);
                }
                boolean R11 = R(asString6);
                if (!this.f16490j && !VCardUtils.j(asString6)) {
                    z11 = true;
                }
                if (z10) {
                    P10 = O(asString);
                    P11 = O(asString3);
                    P12 = O(asString2);
                    P13 = O(asString4);
                    P14 = O(asString5);
                } else {
                    P10 = P(asString);
                    P11 = P(asString3);
                    P12 = P(asString2);
                    P13 = P(asString4);
                    P14 = P(asString5);
                }
                if (z11) {
                    P15 = O(asString6);
                } else {
                    P15 = P(asString6);
                }
                this.f16495o.append("N");
                if (this.f16485e) {
                    if (R10) {
                        this.f16495o.append(str);
                        this.f16495o.append(this.f16494n);
                    }
                    if (z10) {
                        this.f16495o.append(str);
                        this.f16495o.append(str4);
                    }
                    str6 = str3;
                    this.f16495o.append(str6);
                    this.f16495o.append(asString6);
                    this.f16495o.append(str);
                    this.f16495o.append(str);
                    this.f16495o.append(str);
                    this.f16495o.append(str);
                } else {
                    str6 = str3;
                    if (R10) {
                        this.f16495o.append(str);
                        this.f16495o.append(this.f16494n);
                    }
                    if (z10) {
                        this.f16495o.append(str);
                        this.f16495o.append(str4);
                    }
                    this.f16495o.append(str6);
                    this.f16495o.append(P10);
                    this.f16495o.append(str);
                    this.f16495o.append(P11);
                    this.f16495o.append(str);
                    this.f16495o.append(P12);
                    this.f16495o.append(str);
                    this.f16495o.append(P13);
                    this.f16495o.append(str);
                    this.f16495o.append(P14);
                }
                String str7 = str5;
                this.f16495o.append(str7);
                this.f16495o.append(str2);
                if (R11) {
                    this.f16495o.append(str);
                    this.f16495o.append(this.f16494n);
                }
                if (z11) {
                    this.f16495o.append(str);
                    this.f16495o.append(str4);
                }
                this.f16495o.append(str6);
                this.f16495o.append(P15);
                this.f16495o.append(str7);
                contentValues2 = contentValues;
            }
            w(contentValues2);
            return this;
        }
        if (e.g(this.f16481a)) {
            k("N", "");
            k("FN", "");
        } else if (this.f16485e) {
            k("N", "");
        }
        return this;
    }

    public final c q(List<ContentValues> list) {
        String str;
        if (this.f16485e || this.f16491k) {
            H7.b.i(h.LOG_TAG, "Invalid flag is used in vCard 4.0 construction. Ignored.");
        }
        if (list != null && !list.isEmpty()) {
            ContentValues Q10 = Q(list);
            String asString = Q10.getAsString("data3");
            String asString2 = Q10.getAsString("data5");
            String asString3 = Q10.getAsString("data2");
            String asString4 = Q10.getAsString("data4");
            String asString5 = Q10.getAsString("data6");
            String asString6 = Q10.getAsString("data1");
            if (TextUtils.isEmpty(asString) && TextUtils.isEmpty(asString3) && TextUtils.isEmpty(asString2) && TextUtils.isEmpty(asString4) && TextUtils.isEmpty(asString5)) {
                if (TextUtils.isEmpty(asString6)) {
                    k("FN", "");
                    return this;
                }
                str = asString6;
            } else {
                str = asString;
            }
            String asString7 = Q10.getAsString("data9");
            String asString8 = Q10.getAsString("data8");
            String asString9 = Q10.getAsString("data7");
            String P10 = P(str);
            String P11 = P(asString3);
            String P12 = P(asString2);
            String P13 = P(asString4);
            String P14 = P(asString5);
            this.f16495o.append("N");
            if (!TextUtils.isEmpty(asString7) || !TextUtils.isEmpty(asString8) || !TextUtils.isEmpty(asString9)) {
                this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
                String str2 = P(asString7) + ';' + P(asString9) + ';' + P(asString8);
                StringBuilder sb = this.f16495o;
                sb.append("SORT-AS=");
                sb.append(VCardUtils.G(str2));
            }
            this.f16495o.append(":");
            this.f16495o.append(P10);
            this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
            this.f16495o.append(P11);
            this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
            this.f16495o.append(P12);
            this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
            this.f16495o.append(P13);
            this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
            this.f16495o.append(P14);
            this.f16495o.append(ContactBackupPlugin.END_OF_LINE);
            if (TextUtils.isEmpty(asString6)) {
                H7.b.i(h.LOG_TAG, "DISPLAY_NAME is empty.");
                k("FN", P(VCardUtils.e(e.b(this.f16481a), str, asString2, asString3, asString4, asString5)));
            } else {
                String P15 = P(asString6);
                this.f16495o.append("FN");
                this.f16495o.append(":");
                this.f16495o.append(P15);
                this.f16495o.append(ContactBackupPlugin.END_OF_LINE);
            }
            w(Q10);
            return this;
        }
        k("FN", "");
        return this;
    }

    public c r(List<ContentValues> list) {
        boolean z10;
        if (this.f16482b) {
            z10 = false;
        } else {
            if (this.f16487g) {
                z10 = true;
            }
            return this;
        }
        if (list != null) {
            for (ContentValues contentValues : list) {
                String asString = contentValues.getAsString("data1");
                if (!TextUtils.isEmpty(asString)) {
                    if (z10) {
                        a("vnd.android.cursor.item/nickname", contentValues);
                    } else {
                        n("NICKNAME", asString);
                    }
                }
            }
        }
        return this;
    }

    public c s(List<ContentValues> list) {
        boolean z10;
        if (list != null) {
            boolean z11 = false;
            if (this.f16484d) {
                StringBuilder sb = new StringBuilder();
                Iterator<ContentValues> it = list.iterator();
                boolean z12 = true;
                while (it.hasNext()) {
                    String asString = it.next().getAsString("data1");
                    if (asString == null) {
                        asString = "";
                    }
                    if (asString.length() > 0) {
                        if (z12) {
                            z12 = false;
                        } else {
                            sb.append('\n');
                        }
                        sb.append(asString);
                    }
                }
                String sb2 = sb.toString();
                boolean z13 = !VCardUtils.l(sb2);
                if (this.f16486f && !VCardUtils.j(sb2)) {
                    z11 = true;
                }
                l("NOTE", sb2, z13, z11);
            } else {
                Iterator<ContentValues> it2 = list.iterator();
                while (it2.hasNext()) {
                    String asString2 = it2.next().getAsString("data1");
                    if (!TextUtils.isEmpty(asString2)) {
                        boolean z14 = !VCardUtils.l(asString2);
                        if (this.f16486f && !VCardUtils.j(asString2)) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        l("NOTE", asString2, z14, z10);
                    }
                }
            }
        }
        return this;
    }

    public c t(List<ContentValues> list) {
        if (list != null) {
            for (ContentValues contentValues : list) {
                if (contentValues != null) {
                    a("vnd.android.cursor.item/omoji_photo", contentValues);
                }
            }
        }
        return this;
    }

    public String toString() {
        if (!this.f16496p) {
            if (this.f16485e) {
                k("X-CLASS", "PUBLIC");
                k("X-REDUCTION", "");
                k("X-NO", "");
                k("X-DCM-HMN-MODE", "");
            }
            k("END", "VCARD");
            this.f16496p = true;
        }
        return this.f16495o.toString();
    }

    public c u(List<ContentValues> list) {
        boolean z10;
        if (list != null) {
            for (ContentValues contentValues : list) {
                String asString = contentValues.getAsString("data1");
                if (asString != null) {
                    asString = asString.trim();
                }
                String asString2 = contentValues.getAsString("data5");
                if (asString2 != null) {
                    asString2 = asString2.trim();
                }
                String asString3 = contentValues.getAsString("data4");
                if (asString3 != null) {
                    asString3 = asString3.trim();
                }
                StringBuilder sb = new StringBuilder();
                if (!TextUtils.isEmpty(asString)) {
                    sb.append(asString);
                }
                if (!TextUtils.isEmpty(asString2)) {
                    if (sb.length() > 0) {
                        sb.append(';');
                    }
                    sb.append(asString2);
                }
                String sb2 = sb.toString();
                boolean z11 = true;
                boolean z12 = !VCardUtils.l(sb2);
                if (this.f16486f && !VCardUtils.j(sb2)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                l("ORG", sb2, z12, z10);
                if (!TextUtils.isEmpty(asString3)) {
                    boolean z13 = !VCardUtils.l(asString3);
                    if (!this.f16486f || VCardUtils.j(asString3)) {
                        z11 = false;
                    }
                    l("TITLE", asString3, z13, z11);
                }
            }
        }
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:99:0x0199, code lost:
    
        if (r15 == false) goto L84;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.android.contacts.framework.vcard.c v(java.util.List<android.content.ContentValues> r23, com.android.contacts.framework.vcard.t r24, boolean r25) {
        /*
            Method dump skipped, instructions count: 437
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.vcard.c.v(java.util.List, com.android.contacts.framework.vcard.t, boolean):com.android.contacts.framework.vcard.c");
    }

    public final void w(ContentValues contentValues) {
        String P10;
        boolean z10;
        String P11;
        boolean z11;
        String P12;
        String P13;
        String P14;
        String P15;
        boolean z12;
        String asString = contentValues.getAsString("data9");
        String asString2 = contentValues.getAsString("data8");
        String asString3 = contentValues.getAsString("data7");
        if (this.f16491k) {
            asString = VCardUtils.D(asString);
            asString2 = VCardUtils.D(asString2);
            asString3 = VCardUtils.D(asString3);
        }
        if (TextUtils.isEmpty(asString) && TextUtils.isEmpty(asString2) && TextUtils.isEmpty(asString3)) {
            if (this.f16485e) {
                this.f16495o.append("SOUND");
                this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
                this.f16495o.append("X-IRMC-N");
                this.f16495o.append(":");
                this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
                this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
                this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
                this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
                this.f16495o.append(ContactBackupPlugin.END_OF_LINE);
                return;
            }
            return;
        }
        boolean z13 = true;
        if (!e.h(this.f16481a)) {
            if (e.g(this.f16481a)) {
                String d10 = VCardUtils.d(this.f16481a, asString, asString2, asString3);
                this.f16495o.append("SORT-STRING");
                if (e.g(this.f16481a) && R(d10)) {
                    this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
                    this.f16495o.append(this.f16494n);
                }
                this.f16495o.append(":");
                this.f16495o.append(P(d10));
                this.f16495o.append(ContactBackupPlugin.END_OF_LINE);
            } else if (this.f16483c) {
                this.f16495o.append("SOUND");
                this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
                this.f16495o.append("X-IRMC-N");
                if (!this.f16490j && (!VCardUtils.j(asString) || !VCardUtils.j(asString2) || !VCardUtils.j(asString3))) {
                    P13 = O(asString);
                    P14 = O(asString2);
                    P15 = O(asString3);
                } else {
                    P13 = P(asString);
                    P14 = P(asString2);
                    P15 = P(asString3);
                }
                if (R(P13, P14, P15)) {
                    this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
                    this.f16495o.append(this.f16494n);
                }
                this.f16495o.append(":");
                if (!TextUtils.isEmpty(P13)) {
                    this.f16495o.append(P13);
                    z12 = false;
                } else {
                    z12 = true;
                }
                if (!TextUtils.isEmpty(P14)) {
                    if (z12) {
                        z12 = false;
                    } else {
                        this.f16495o.append(' ');
                    }
                    this.f16495o.append(P14);
                }
                if (!TextUtils.isEmpty(P15)) {
                    if (!z12) {
                        this.f16495o.append(' ');
                    }
                    this.f16495o.append(P15);
                }
                this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
                this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
                this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
                this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
                this.f16495o.append(ContactBackupPlugin.END_OF_LINE);
            }
        }
        if (this.f16488h) {
            if (!TextUtils.isEmpty(asString3)) {
                if (this.f16486f && !VCardUtils.j(asString3)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    P12 = O(asString3);
                } else {
                    P12 = P(asString3);
                }
                this.f16495o.append("X-PHONETIC-FIRST-NAME");
                if (R(asString3)) {
                    this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
                    this.f16495o.append(this.f16494n);
                }
                if (z11) {
                    this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
                    this.f16495o.append("ENCODING=QUOTED-PRINTABLE");
                }
                this.f16495o.append(":");
                this.f16495o.append(P12);
                this.f16495o.append(ContactBackupPlugin.END_OF_LINE);
            }
            if (!TextUtils.isEmpty(asString2)) {
                if (this.f16486f && !VCardUtils.j(asString2)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    P11 = O(asString2);
                } else {
                    P11 = P(asString2);
                }
                this.f16495o.append("X-PHONETIC-MIDDLE-NAME");
                if (R(asString2)) {
                    this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
                    this.f16495o.append(this.f16494n);
                }
                if (z10) {
                    this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
                    this.f16495o.append("ENCODING=QUOTED-PRINTABLE");
                }
                this.f16495o.append(":");
                this.f16495o.append(P11);
                this.f16495o.append(ContactBackupPlugin.END_OF_LINE);
            }
            if (!TextUtils.isEmpty(asString)) {
                if (!this.f16486f || VCardUtils.j(asString)) {
                    z13 = false;
                }
                if (z13) {
                    P10 = O(asString);
                } else {
                    P10 = P(asString);
                }
                this.f16495o.append("X-PHONETIC-LAST-NAME");
                if (R(asString)) {
                    this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
                    this.f16495o.append(this.f16494n);
                }
                if (z13) {
                    this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
                    this.f16495o.append("ENCODING=QUOTED-PRINTABLE");
                }
                this.f16495o.append(":");
                this.f16495o.append(P10);
                this.f16495o.append(ContactBackupPlugin.END_OF_LINE);
            }
        }
    }

    public void x(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("PHOTO");
        sb.append(Constants.DataMigration.SPLIT_TAG);
        if (this.f16482b) {
            sb.append("ENCODING=B");
        } else {
            sb.append("ENCODING=BASE64");
        }
        sb.append(Constants.DataMigration.SPLIT_TAG);
        I(sb, str2);
        sb.append(":");
        sb.append(str);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        int length = sb2.length();
        int i10 = 73;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            sb3.append(sb2.charAt(i12));
            i11++;
            if (i11 > i10) {
                sb3.append(ContactBackupPlugin.END_OF_LINE);
                sb3.append(" ");
                i10 = 72;
                i11 = 0;
            }
        }
        this.f16495o.append(sb3.toString());
        this.f16495o.append(ContactBackupPlugin.END_OF_LINE);
        this.f16495o.append(ContactBackupPlugin.END_OF_LINE);
    }

    public c y(List<ContentValues> list, boolean z10) {
        byte[] asByteArray;
        if (list != null) {
            for (ContentValues contentValues : list) {
                if (contentValues != null) {
                    if (z10 && contentValues.getAsLong("data14") != null) {
                        try {
                            asByteArray = I7.a.a(I7.a.e(this.f16497q, ContentUris.withAppendedId(ContactsContract.DisplayPhoto.CONTENT_URI, contentValues.getAsLong("data14").longValue())), 819200);
                        } catch (FileNotFoundException e10) {
                            H7.b.c(h.LOG_TAG, "e = " + e10);
                            asByteArray = null;
                        }
                    } else {
                        asByteArray = contentValues.getAsByteArray("data15");
                    }
                    if (asByteArray != null) {
                        String v10 = VCardUtils.v(asByteArray);
                        if (v10 == null) {
                            H7.b.b(h.LOG_TAG, "Unknown photo type. Ignored.");
                        } else {
                            String str = new String(Base64.encode(asByteArray, 2));
                            if (!TextUtils.isEmpty(str)) {
                                x(str, v10);
                            }
                        }
                    }
                }
            }
        }
        return this;
    }

    public void z(int i10, String str, ContentValues contentValues, boolean z10, boolean z11) {
        boolean z12;
        String str2;
        boolean z13;
        a T10 = T(contentValues);
        if (T10 == null) {
            if (z11) {
                z13 = false;
                str2 = "";
                z12 = false;
            } else {
                return;
            }
        } else {
            z12 = T10.f16498a;
            boolean z14 = T10.f16499b;
            str2 = T10.f16500c;
            z13 = z14;
        }
        ArrayList arrayList = new ArrayList();
        if (z10) {
            arrayList.add("PREF");
        }
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        H7.b.c(h.LOG_TAG, "Unknown StructuredPostal type: " + i10);
                    }
                } else {
                    arrayList.add("WORK");
                }
            } else {
                arrayList.add("HOME");
            }
        } else if (!TextUtils.isEmpty(str) && VCardUtils.h(str)) {
            arrayList.add("X-" + str);
        }
        this.f16495o.append("ADR");
        if (!arrayList.isEmpty()) {
            this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
            J(arrayList);
        }
        if (z13) {
            this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
            this.f16495o.append(this.f16494n);
        }
        if (z12) {
            this.f16495o.append(Constants.DataMigration.SPLIT_TAG);
            this.f16495o.append("ENCODING=QUOTED-PRINTABLE");
        }
        this.f16495o.append(":");
        this.f16495o.append(str2);
        this.f16495o.append(ContactBackupPlugin.END_OF_LINE);
    }
}
