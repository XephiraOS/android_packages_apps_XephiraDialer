package com.android.contacts.framework.vcard;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: VCardSourceDetector.java */
/* loaded from: classes.dex */
public class v implements l {

    /* renamed from: d, reason: collision with root package name */
    public static Set<String> f16562d = new HashSet(Arrays.asList("X-PHONETIC-FIRST-NAME", "X-PHONETIC-MIDDLE-NAME", "X-PHONETIC-LAST-NAME", "X-ABADR", "X-ABUID"));

    /* renamed from: e, reason: collision with root package name */
    public static Set<String> f16563e = new HashSet(Arrays.asList("X-GNO", "X-GN", "X-REDUCTION"));

    /* renamed from: f, reason: collision with root package name */
    public static Set<String> f16564f = new HashSet(Arrays.asList("X-MICROSOFT-ASST_TEL", "X-MICROSOFT-ASSISTANT", "X-MICROSOFT-OFFICELOC"));

    /* renamed from: g, reason: collision with root package name */
    public static Set<String> f16565g = new HashSet(Arrays.asList("X-SD-VERN", "X-SD-FORMAT_VER", "X-SD-CATEGORIES", "X-SD-CLASS", "X-SD-DCREATED", "X-SD-DESCRIPTION"));

    /* renamed from: h, reason: collision with root package name */
    public static String f16566h = "X-SD-CHAR_CODE";

    /* renamed from: a, reason: collision with root package name */
    public int f16567a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f16568b = -1;

    /* renamed from: c, reason: collision with root package name */
    public String f16569c;

    @Override // com.android.contacts.framework.vcard.l
    public void d(u uVar) {
        String d10 = uVar.d();
        List<String> h10 = uVar.h();
        if (d10.equalsIgnoreCase("VERSION") && h10.size() > 0) {
            String str = h10.get(0);
            if (str.equals("2.1")) {
                this.f16568b = 0;
            } else if (str.equals("3.0")) {
                this.f16568b = 1;
            } else if (str.equals("4.0")) {
                this.f16568b = 2;
            } else {
                H7.b.i(h.LOG_TAG, "Invalid version string: " + str);
            }
        } else if (d10.equalsIgnoreCase(f16566h)) {
            this.f16567a = 3;
            if (h10.size() > 0) {
                this.f16569c = h10.get(0);
            }
        }
        if (this.f16567a != 0) {
            return;
        }
        if (f16564f.contains(d10)) {
            this.f16567a = 4;
            return;
        }
        if (f16565g.contains(d10)) {
            this.f16567a = 3;
        } else if (f16563e.contains(d10)) {
            this.f16567a = 2;
        } else if (f16562d.contains(d10)) {
            this.f16567a = 1;
        }
    }

    public String f() {
        if (TextUtils.isEmpty(this.f16569c)) {
            return this.f16569c;
        }
        int i10 = this.f16567a;
        if (i10 != 1) {
            if (i10 != 2 && i10 != 3 && i10 != 4) {
                return null;
            }
            return "SHIFT_JIS";
        }
        return "UTF-8";
    }

    public int g() {
        int i10 = this.f16567a;
        if (i10 != 2) {
            if (i10 != 3) {
                int i11 = this.f16568b;
                if (i11 == 0) {
                    return -1073741824;
                }
                if (i11 == 1) {
                    return -1073741823;
                }
                if (i11 == 2) {
                    return -1073741822;
                }
                return 0;
            }
            return 939524104;
        }
        return 402653192;
    }

    @Override // com.android.contacts.framework.vcard.l
    public void a() {
    }

    @Override // com.android.contacts.framework.vcard.l
    public void b() {
    }

    @Override // com.android.contacts.framework.vcard.l
    public void c() {
    }

    @Override // com.android.contacts.framework.vcard.l
    public void e() {
    }
}
