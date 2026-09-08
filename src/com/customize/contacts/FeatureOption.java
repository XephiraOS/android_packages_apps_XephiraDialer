package com.customize.contacts;

import G0.c;
import H7.b;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;
import com.android.contacts.C0580b;
import com.android.contacts.framework.baseui.util.AiCallTranslateStateController;
import com.customize.contacts.feature.OSCustomizeFeature;
import com.customize.contacts.feature.OSPublicFeature;
import com.customize.contacts.util.SettingUtils;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import com.oplus.foundation.util.feature.VirtualSupportUtils;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.a;
import kotlin.text.n;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: FeatureOption.kt */
/* loaded from: classes3.dex */
public final class FeatureOption {

    /* renamed from: a, reason: collision with root package name */
    public static final FeatureOption f20068a;

    /* renamed from: b, reason: collision with root package name */
    public static Integer f20069b;

    /* renamed from: c, reason: collision with root package name */
    public static Integer f20070c;

    /* renamed from: d, reason: collision with root package name */
    public static final d f20071d;

    /* renamed from: e, reason: collision with root package name */
    public static final d f20072e;

    /* renamed from: f, reason: collision with root package name */
    public static final d f20073f;

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f20074g;

    /* renamed from: h, reason: collision with root package name */
    public static final boolean f20075h;

    /* renamed from: i, reason: collision with root package name */
    public static final d f20076i;

    /* renamed from: j, reason: collision with root package name */
    public static final d f20077j;

    /* renamed from: k, reason: collision with root package name */
    public static final d f20078k;

    /* renamed from: l, reason: collision with root package name */
    public static Context f20079l;

    /* renamed from: m, reason: collision with root package name */
    public static PackageManager f20080m;

    /* renamed from: n, reason: collision with root package name */
    public static ContentResolver f20081n;

    static {
        d a10;
        d a11;
        d a12;
        d a13;
        d a14;
        d a15;
        FeatureOption featureOption = new FeatureOption();
        f20068a = featureOption;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f34162b;
        a10 = a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.FeatureOption$SIM_CONTACTS_AUTO_SYNC$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                Context context;
                SettingUtils settingUtils = SettingUtils.f21935a;
                context = FeatureOption.f20079l;
                return Boolean.valueOf(settingUtils.k(context));
            }
        });
        f20071d = a10;
        a11 = a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.FeatureOption$NO_COMPRESS_PHOTO_SUPPORT$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                Context context;
                context = FeatureOption.f20079l;
                return Boolean.valueOf(M7.a.h(context, "com.android.providers.contacts", "no_compress_photo_support", "true"));
            }
        });
        f20072e = a11;
        a12 = a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.FeatureOption$VIRTUAL_CALL_DATABASE_SUPPORT$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                return Boolean.valueOf(VirtualSupportUtils.p());
            }
        });
        f20073f = a12;
        boolean n10 = featureOption.n("domestic");
        f20074g = n10;
        f20075h = !n10;
        a13 = a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.FeatureOption$BUSINESS_HALL$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                return Boolean.valueOf(FeatureOption.r());
            }
        });
        f20076i = a13;
        a14 = a.a(lazyThreadSafetyMode, new InterfaceC1637a<Integer>() { // from class: com.customize.contacts.FeatureOption$COUNT_FOR_MARK_INFO_CALL_LOG_DEFAULT$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Integer invoke() {
                Context context;
                context = FeatureOption.f20079l;
                return Integer.valueOf(c.d(context, 1, R0.c.f3192j, 3));
            }
        });
        f20077j = a14;
        a15 = a.a(lazyThreadSafetyMode, new InterfaceC1637a<Integer>() { // from class: com.customize.contacts.FeatureOption$COUNT_FOR_STRANGER_CALL_LOG_DEFAULT$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Integer invoke() {
                Context context;
                context = FeatureOption.f20079l;
                return Integer.valueOf(c.d(context, 1, R0.c.f3193k, 25));
            }
        });
        f20078k = a15;
    }

    public static final boolean b() {
        return ((Boolean) f20076i.getValue()).booleanValue();
    }

    public static final void f(Context context) {
        if (context != null) {
            f20079l = context;
            f20080m = context.getPackageManager();
            f20081n = context.getContentResolver();
            OSPublicFeature.f21034a.D(context, f20080m, f20081n);
            OSCustomizeFeature.f20960a.G(context, f20080m, f20081n);
        }
    }

    public static final boolean g() {
        return b();
    }

    public static final boolean i() {
        return f20074g;
    }

    public static final boolean j() {
        return f20068a.c();
    }

    public static final boolean k() {
        return f20068a.d();
    }

    public static final boolean l() {
        return AiCallTranslateStateController.f15829b.a().g();
    }

    public static final boolean m() {
        return com.android.contacts.framework.api.breenocall.a.d();
    }

    public static final boolean o() {
        return f20075h;
    }

    public static final boolean p() {
        return f20068a.e();
    }

    public static final void q() {
        b.e("ContactFeatureOption", "VERSION_US = " + f20075h + "\nCOUNT_FOR_MARK_INFO_CALL_LOG = " + f20069b + "\nCOUNT_FOR_STRANGER_CALL_LOG = " + f20070c + "\nBUSINESS_HALL = " + b() + "\nVIRTUAL_CALL_DATABASE_SUPPORT = " + f20068a.e() + "\nIS_LIGHT_VERSION = " + C0580b.f13683a);
    }

    public static final boolean r() {
        if (!VirtualSupportUtils.m() && com.android.contacts.framework.api.businesshall.a.i() && !CommonFeatureOption.f28289a.b() && !f20068a.h()) {
            return true;
        }
        return false;
    }

    public static final void s(int i10) {
        f20069b = Integer.valueOf(i10);
    }

    public static final void t(int i10) {
        f20070c = Integer.valueOf(i10);
    }

    public final boolean c() {
        return ((Boolean) f20072e.getValue()).booleanValue();
    }

    public final boolean d() {
        return ((Boolean) f20071d.getValue()).booleanValue();
    }

    public final boolean e() {
        return ((Boolean) f20073f.getValue()).booleanValue();
    }

    public final boolean h() {
        Object b10;
        try {
            Result.a aVar = Result.f34166a;
            boolean z10 = false;
            if (R7.d.e(PreferenceManager.getDefaultSharedPreferences(f20079l), "business_hall_disable", 0) > 0) {
                z10 = true;
            }
            b10 = Result.b(Boolean.valueOf(z10));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            b.c("ContactFeatureOption", "isBusinessHallRusDisable : " + d10 + " " + d10.getMessage());
        }
        Boolean bool = Boolean.FALSE;
        if (Result.f(b10)) {
            b10 = bool;
        }
        return ((Boolean) b10).booleanValue();
    }

    public final boolean n(String str) {
        boolean p10;
        p10 = n.p("gdpr", str, true);
        return p10;
    }
}
