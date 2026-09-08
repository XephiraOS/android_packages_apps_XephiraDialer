package com.oplus.foundation.util.feature;

import P7.a;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.oplus.coreapp.appfeature.AppFeatureProviderUtils;
import com.oplus.foundation.util.OsUtils;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.i;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: CommonFeatureOption.kt */
/* loaded from: classes3.dex */
public final class CommonFeatureOption {

    /* renamed from: a, reason: collision with root package name */
    public static final CommonFeatureOption f28289a = new CommonFeatureOption();

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f28290b;

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f28291c;

    /* renamed from: d, reason: collision with root package name */
    public static InterfaceC1637a<Boolean> f28292d;

    /* renamed from: e, reason: collision with root package name */
    public static final d f28293e;

    /* renamed from: f, reason: collision with root package name */
    public static final d f28294f;

    /* renamed from: g, reason: collision with root package name */
    public static final d f28295g;

    /* renamed from: h, reason: collision with root package name */
    public static final d f28296h;

    /* renamed from: i, reason: collision with root package name */
    public static final d f28297i;

    /* renamed from: j, reason: collision with root package name */
    public static final d f28298j;

    /* renamed from: k, reason: collision with root package name */
    public static final d f28299k;

    static {
        boolean z10;
        d a10;
        d a11;
        d a12;
        d a13;
        d a14;
        d a15;
        d a16;
        if ((!i.b("wifi-only", M7.d.a("ro.carrier")) || VirtualSupportUtils.m()) && !a.f2961a.a().getPackageManager().hasSystemFeature("oplus.software.dial.unsupported")) {
            z10 = true;
        } else {
            z10 = false;
        }
        f28290b = z10;
        f28291c = TextUtils.equals("wifi-only", M7.d.a("ro.carrier"));
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f34162b;
        a10 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.oplus.foundation.util.feature.CommonFeatureOption$taskBarEnable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                return Boolean.valueOf(OsUtils.k() ? AppFeatureProviderUtils.p(a.f2961a.a().getContentResolver(), "com.android.launcher.TASKBAR_ENABLE") : false);
            }
        });
        f28293e = a10;
        a11 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.oplus.foundation.util.feature.CommonFeatureOption$businessDisable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                return Boolean.valueOf(AppFeatureProviderUtils.p(a.f2961a.a().getContentResolver(), "os.contacts.businesshall.disable"));
            }
        });
        f28294f = a11;
        a12 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.oplus.foundation.util.feature.CommonFeatureOption$insertContactsBusinessCardDisable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                return Boolean.valueOf(AppFeatureProviderUtils.p(a.f2961a.a().getContentResolver(), "os.contacts.insertcontacts.businesscard.disable"));
            }
        });
        f28295g = a12;
        a13 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.oplus.foundation.util.feature.CommonFeatureOption$insertContactsQrCodeDisable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                return Boolean.valueOf(AppFeatureProviderUtils.p(a.f2961a.a().getContentResolver(), "os.contacts.insertcontacts.qrcode.disable"));
            }
        });
        f28296h = a13;
        a14 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.oplus.foundation.util.feature.CommonFeatureOption$customFeature$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                boolean z11 = false;
                if (!OsUtils.f28275a.i() && (packageManager = a.f2961a.a().getPackageManager()) != null) {
                    z11 = packageManager.hasSystemFeature("oppo.business.custom");
                }
                return Boolean.valueOf(z11);
            }
        });
        f28297i = a14;
        a15 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.oplus.foundation.util.feature.CommonFeatureOption$govHideContactNumber$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                boolean c10;
                PackageManager packageManager;
                c10 = CommonFeatureOption.f28289a.c();
                boolean z11 = false;
                if (c10 && (packageManager = a.f2961a.a().getPackageManager()) != null) {
                    z11 = packageManager.hasSystemFeature("oppo.common.gov.hide.contacts_number");
                }
                return Boolean.valueOf(z11);
            }
        });
        f28298j = a15;
        a16 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.oplus.foundation.util.feature.CommonFeatureOption$govHideBlackWhiteList$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                boolean c10;
                PackageManager packageManager;
                c10 = CommonFeatureOption.f28289a.c();
                boolean z11 = false;
                if (c10 && (packageManager = a.f2961a.a().getPackageManager()) != null) {
                    z11 = packageManager.hasSystemFeature("oppo.common.gov.black_or_white_contactlist");
                }
                return Boolean.valueOf(z11);
            }
        });
        f28299k = a16;
    }

    public static final boolean h() {
        return ((Boolean) f28293e.getValue()).booleanValue();
    }

    public static final void i(InterfaceC1637a<Boolean> isSupportNumberRecognitionFunction) {
        i.f(isSupportNumberRecognitionFunction, "isSupportNumberRecognitionFunction");
        f28292d = isSupportNumberRecognitionFunction;
    }

    public static final boolean j() {
        return f28290b;
    }

    public static final boolean k() {
        return FeatureUtil.N();
    }

    public static final boolean l() {
        InterfaceC1637a<Boolean> interfaceC1637a = f28292d;
        if (interfaceC1637a != null) {
            return interfaceC1637a.invoke().booleanValue();
        }
        return false;
    }

    public static final boolean m() {
        return FeatureUtil.V();
    }

    public static final boolean n() {
        return f28291c;
    }

    public static final boolean o(Context context) {
        if (!m() && !k()) {
            return false;
        }
        return true;
    }

    public final boolean b() {
        return ((Boolean) f28294f.getValue()).booleanValue();
    }

    public final boolean c() {
        return ((Boolean) f28297i.getValue()).booleanValue();
    }

    public final boolean d() {
        return ((Boolean) f28299k.getValue()).booleanValue();
    }

    public final boolean e() {
        return ((Boolean) f28298j.getValue()).booleanValue();
    }

    public final boolean f() {
        return ((Boolean) f28295g.getValue()).booleanValue();
    }

    public final boolean g() {
        return ((Boolean) f28296h.getValue()).booleanValue();
    }
}
