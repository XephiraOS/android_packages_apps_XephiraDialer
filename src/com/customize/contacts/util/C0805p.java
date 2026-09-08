package com.customize.contacts.util;

import android.icu.text.AlphabeticIndex;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: ContactSortUtils.java */
/* renamed from: com.customize.contacts.util.p, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0805p {

    /* renamed from: g, reason: collision with root package name */
    public static final Locale f22152g = new Locale("ar");

    /* renamed from: h, reason: collision with root package name */
    public static final Locale f22153h = new Locale("el");

    /* renamed from: i, reason: collision with root package name */
    public static final Locale f22154i = new Locale("he");

    /* renamed from: j, reason: collision with root package name */
    public static final Locale f22155j = new Locale("sr");

    /* renamed from: k, reason: collision with root package name */
    public static final Locale f22156k = new Locale("uk");

    /* renamed from: l, reason: collision with root package name */
    public static final Locale f22157l = new Locale("th");

    /* renamed from: m, reason: collision with root package name */
    public static C0805p f22158m;

    /* renamed from: n, reason: collision with root package name */
    public static L f22159n;

    /* renamed from: o, reason: collision with root package name */
    public static L f22160o;

    /* renamed from: a, reason: collision with root package name */
    public final AlphabeticIndex.ImmutableIndex f22161a;

    /* renamed from: b, reason: collision with root package name */
    public final int f22162b;

    /* renamed from: c, reason: collision with root package name */
    public final int f22163c;

    /* renamed from: d, reason: collision with root package name */
    public final char[] f22164d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f22165e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f22166f;

    public C0805p(L l10) {
        char[] cArr;
        if (l10.toString().equals("ur_PK")) {
            h(new L(new Locale("ar_EG")));
        } else {
            h(l10);
        }
        boolean h10 = K.h();
        this.f22165e = h10;
        this.f22166f = K.g();
        if (h10) {
            cArr = z7.c0.a(Locale.TAIWAN.getCountry());
        } else {
            cArr = null;
        }
        cArr = cArr == null ? new char[0] : cArr;
        this.f22164d = cArr;
        Locale c10 = l10.c();
        AlphabeticIndex maxLabelCount = new AlphabeticIndex(l10.b()).setMaxLabelCount(300);
        if (H7.a.b()) {
            H7.b.b("ContactSortUtils", "the locales.getPrimaryLocale() is " + l10.b().toString());
        }
        if (c10 != null) {
            maxLabelCount.addLabels(c10);
        }
        AlphabeticIndex.ImmutableIndex buildImmutableIndex = maxLabelCount.addLabels(Locale.ENGLISH).addLabels(Locale.JAPANESE).addLabels(Locale.KOREAN).addLabels(f22157l).addLabels(f22152g).addLabels(f22154i).addLabels(f22153h).addLabels(f22156k).addLabels(f22155j).buildImmutableIndex();
        this.f22161a = buildImmutableIndex;
        int length = cArr.length + buildImmutableIndex.getBucketCount();
        this.f22162b = length;
        this.f22163c = length - 1;
        if (H7.a.b()) {
            H7.b.e("ContactSortUtils", "AddressBook Labels [" + f22159n.toString() + "]: " + f().toString());
        }
    }

    public static synchronized C0805p e() {
        C0805p c0805p;
        L l10;
        synchronized (C0805p.class) {
            try {
                L l11 = f22160o;
                if (l11 == null) {
                    f22160o = L.a();
                } else {
                    if (l11.toString().equals("ur_PK")) {
                        f22160o = new L(new Locale("ar_EG"));
                    }
                    f22160o = L.a();
                }
                if (H7.a.b() && f22159n != null && f22160o != null) {
                    H7.b.b("ContactSortUtils", "getInstance,the mLocals is " + f22159n.toString() + ", the mCuurentLocales is " + f22160o.toString());
                }
                if (f22158m == null || ((l10 = f22159n) != null && !l10.toString().equals(f22160o.toString()))) {
                    f22158m = new C0805p(L.a());
                }
                c0805p = f22158m;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0805p;
    }

    public static void h(L l10) {
        f22159n = l10;
    }

    public int a() {
        return this.f22162b + 1;
    }

    public int b(String str) {
        String b10;
        if (!this.f22165e || (b10 = z7.d0.b(str)) == null || b10.length() <= 0 || 12549 > b10.charAt(0) || b10.charAt(0) > 12585) {
            return -1;
        }
        return g(b10.charAt(0));
    }

    public int c(String str, boolean z10) {
        if (str == null) {
            return this.f22163c;
        }
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            int codePointAt = Character.codePointAt(str, i10);
            if (!Character.isDigit(codePointAt) && codePointAt != 35) {
                if (!Character.isSpaceChar(codePointAt) && codePointAt != 43 && codePointAt != 40 && codePointAt != 41 && codePointAt != 46 && codePointAt != 45 && codePointAt != 35) {
                    break;
                }
                i10 += Character.charCount(codePointAt);
            } else {
                return this.f22163c;
            }
        }
        int b10 = b(str);
        if (b10 > 0) {
            return b10;
        }
        if (this.f22166f || z10) {
            try {
                str = z7.c0.d(str);
            } catch (Exception e10) {
                H7.b.c("ContactSortUtils", "change to pinyin error" + e10);
            }
        }
        int bucketIndex = this.f22161a.getBucketIndex(str);
        if (bucketIndex == 0) {
            return bucketIndex;
        }
        if (bucketIndex <= 0) {
            return this.f22163c;
        }
        int i11 = this.f22163c;
        if (bucketIndex >= i11) {
            return i11 + 1;
        }
        return bucketIndex + this.f22164d.length;
    }

    public String d(int i10) {
        if (i10 >= 0 && i10 != this.f22163c) {
            if (i10 > 0) {
                char[] cArr = this.f22164d;
                if (i10 <= cArr.length) {
                    return String.valueOf(cArr[i10 - 1]);
                }
            }
            if (i10 > 0) {
                i10 -= this.f22164d.length;
            }
            if (i10 >= 0 && i10 < this.f22161a.getBucketCount()) {
                return this.f22161a.getBucket(i10).getLabel();
            }
        }
        return "#";
    }

    public ArrayList<String> f() {
        int a10 = a();
        ArrayList<String> arrayList = new ArrayList<>(a10);
        for (int i10 = 0; i10 < a10; i10++) {
            arrayList.add(d(i10));
        }
        return arrayList;
    }

    public int g(char c10) {
        char[] cArr = this.f22164d;
        if (cArr.length == 0) {
            return -1;
        }
        int length = cArr.length;
        int i10 = length - 1;
        int i11 = length / 2;
        int i12 = 0;
        while (i12 < i10) {
            char[] cArr2 = this.f22164d;
            if (cArr2[i12] == c10) {
                return i12 + 1;
            }
            if (cArr2[i10] == c10) {
                return i10 + 1;
            }
            char c11 = cArr2[i11];
            if (c11 == c10) {
                return i11 + 1;
            }
            if (c11 < c10) {
                i12 = i11 + 1;
                i10--;
                i11 = ((i10 - i12) + 1) / 2;
            } else {
                i12++;
                i10 = i11 - 1;
                i11 = ((i10 - i12) + 1) / 2;
            }
        }
        return -1;
    }
}
