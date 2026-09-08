package com.android.contacts.framework.baseui.util;

import android.content.Context;
import com.oplus.foundation.util.feature.CommonFeatureOption;

/* compiled from: CustomizeContactManagerUtils.kt */
/* renamed from: com.android.contacts.framework.baseui.util.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0638c {

    /* renamed from: a, reason: collision with root package name */
    public static final C0638c f15889a = new C0638c();

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f15890b = true;

    /* renamed from: c, reason: collision with root package name */
    public static final Context f15891c = P7.a.f2961a.a();

    /* renamed from: d, reason: collision with root package name */
    public static int f15892d = -1;

    /* renamed from: e, reason: collision with root package name */
    public static int f15893e = -1;

    /* renamed from: f, reason: collision with root package name */
    public static int f15894f = -1;

    /* renamed from: g, reason: collision with root package name */
    public static int f15895g = -1;

    public final int a() {
        int i10 = 1;
        if (f15890b) {
            if (f15895g == -1) {
                try {
                    int g10 = D7.a.g(f15891c);
                    if (g10 != -1) {
                        i10 = g10;
                    }
                } catch (Throwable th) {
                    H7.b.c("CustomizeContactManagerUtils", "getContactNumberHideMode() t: " + th);
                }
                f15895g = i10;
            }
            return f15895g;
        }
        try {
            i10 = G0.c.d(f15891c, 2, C0637b.f15885c, 1);
        } catch (Exception e10) {
            H7.b.c("CustomizeContactManagerUtils", "getContactNumberHideMode() e: " + e10);
        }
        return i10;
    }

    public final boolean b() {
        int i10;
        int h10;
        if (f15890b) {
            if (f15893e == -1) {
                try {
                    h10 = D7.a.h(f15891c);
                } catch (Throwable th) {
                    H7.b.c("CustomizeContactManagerUtils", "getContactNumberMaskEnable() t: " + th);
                }
                if (h10 == 2 || h10 == 1) {
                    i10 = 1;
                    f15893e = i10;
                }
                i10 = 0;
                f15893e = i10;
            }
            if (f15893e != 1) {
                return false;
            }
            return true;
        }
        return CommonFeatureOption.f28289a.e();
    }

    public final boolean c() {
        int i10;
        if (f15890b) {
            if (f15894f == -1) {
                try {
                } catch (Throwable th) {
                    H7.b.c("CustomizeContactManagerUtils", "getContactNumberMaskSwitch() t: " + th);
                }
                if (D7.a.h(f15891c) == 1) {
                    i10 = 1;
                    f15894f = i10;
                }
                i10 = 0;
                f15894f = i10;
            }
            if (f15894f != 1) {
                return false;
            }
        } else {
            try {
                if (G0.c.d(f15891c, 2, C0637b.f15884b, 0) != 1) {
                    return false;
                }
            } catch (Exception e10) {
                H7.b.c("CustomizeContactManagerUtils", "getContactNumberMaskSwitch() e: " + e10);
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean d() {
        int i10;
        if (f15890b) {
            if (f15892d == -1) {
                try {
                    i10 = D7.a.n(f15891c);
                } catch (Throwable th) {
                    H7.b.c("CustomizeContactManagerUtils", "isContactBlackListEnable() t: " + th);
                    i10 = 0;
                }
                f15892d = i10;
            }
            if (f15892d != 1) {
                return false;
            }
            return true;
        }
        return CommonFeatureOption.f28289a.d();
    }

    public final void e() {
        f15892d = -1;
        f15893e = -1;
        f15894f = -1;
        f15895g = -1;
    }
}
