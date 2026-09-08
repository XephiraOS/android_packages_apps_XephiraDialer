package com.oplus.foundation.util.feature;

import H7.b;
import M7.a;
import android.text.TextUtils;
import com.oplus.content.OplusFeatureConfigManager;
import com.oplus.coreapp.appfeature.AppFeatureProviderUtils;
import com.oplus.os.OplusBuild;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import m9.d;
import m9.e;
import m9.q;
import v9.InterfaceC1637a;

/* compiled from: FeatureUtil.kt */
/* loaded from: classes3.dex */
public final class FeatureUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final FeatureUtil f28316a = new FeatureUtil();

    /* renamed from: b, reason: collision with root package name */
    public static final d f28317b;

    /* renamed from: c, reason: collision with root package name */
    public static final d f28318c;

    /* renamed from: d, reason: collision with root package name */
    public static final d f28319d;

    /* renamed from: e, reason: collision with root package name */
    public static final d f28320e;

    /* renamed from: f, reason: collision with root package name */
    public static final d f28321f;

    /* renamed from: g, reason: collision with root package name */
    public static final d f28322g;

    /* renamed from: h, reason: collision with root package name */
    public static final d f28323h;

    /* renamed from: i, reason: collision with root package name */
    public static final d f28324i;

    /* renamed from: j, reason: collision with root package name */
    public static final d f28325j;

    /* renamed from: k, reason: collision with root package name */
    public static final d f28326k;

    /* renamed from: l, reason: collision with root package name */
    public static final d f28327l;

    /* renamed from: m, reason: collision with root package name */
    public static final d f28328m;

    /* renamed from: n, reason: collision with root package name */
    public static boolean f28329n;

    /* renamed from: o, reason: collision with root package name */
    public static final d f28330o;

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f34162b;
        f28317b = e.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.oplus.foundation.util.feature.FeatureUtil$initIsTablet$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                boolean J10;
                J10 = FeatureUtil.J();
                return Boolean.valueOf(J10);
            }
        });
        f28318c = e.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.oplus.foundation.util.feature.FeatureUtil$initIsFoldDevice$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                boolean B10;
                B10 = FeatureUtil.B();
                return Boolean.valueOf(B10);
            }
        });
        f28319d = e.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.oplus.foundation.util.feature.FeatureUtil$initIsDragonflyDevice$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                boolean A10;
                A10 = FeatureUtil.A();
                return Boolean.valueOf(A10);
            }
        });
        f28320e = e.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.oplus.foundation.util.feature.FeatureUtil$initIsSupportSecondaryMiniApp$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                boolean D10;
                D10 = FeatureUtil.D();
                return Boolean.valueOf(D10);
            }
        });
        f28321f = e.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.oplus.foundation.util.feature.FeatureUtil$initIsSupportVoiceIsolation$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                boolean G10;
                G10 = FeatureUtil.G();
                return Boolean.valueOf(G10);
            }
        });
        f28322g = e.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.oplus.foundation.util.feature.FeatureUtil$initIsSupportVoiceDenoise$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                boolean E10;
                E10 = FeatureUtil.f28316a.E();
                return Boolean.valueOf(E10);
            }
        });
        f28323h = e.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.oplus.foundation.util.feature.FeatureUtil$initIsSupportVoiceIsolationV2$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                boolean H10;
                H10 = FeatureUtil.f28316a.H();
                return Boolean.valueOf(H10);
            }
        });
        f28324i = e.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.oplus.foundation.util.feature.FeatureUtil$initIsSupportVoiceDenoiseV2$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                boolean F10;
                F10 = FeatureUtil.f28316a.F();
                return Boolean.valueOf(F10);
            }
        });
        f28325j = e.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.oplus.foundation.util.feature.FeatureUtil$initIsSupportVoiceIsolationV3$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                boolean I10;
                I10 = FeatureUtil.I();
                return Boolean.valueOf(I10);
            }
        });
        f28326k = e.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.oplus.foundation.util.feature.FeatureUtil$initIsTtSatelliteSupport$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                boolean K10;
                K10 = FeatureUtil.f28316a.K();
                return Boolean.valueOf(K10);
            }
        });
        f28327l = e.a(lazyThreadSafetyMode, new InterfaceC1637a<String>() { // from class: com.oplus.foundation.util.feature.FeatureUtil$oplusNumberEngineSupportVersion$2
            @Override // v9.InterfaceC1637a
            public final String invoke() {
                String a10 = a.a(P7.a.f2961a.a(), "com.ted.number", "oplus_number_engine_support_version", "");
                b.e("FeatureUtil", "oplusNumberEngineSupport: " + a10);
                return a10;
            }
        });
        f28328m = e.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.oplus.foundation.util.feature.FeatureUtil$oplusNumberRecognitionExperienceImprovement$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                boolean h10 = a.h(P7.a.f2961a.a(), "com.ted.number", "number_recognition_experience_improvement", "true");
                Boolean valueOf = Boolean.valueOf(h10);
                b.e("FeatureUtil", "oplusNumberRecognitionExperienceImprovement: " + h10);
                return valueOf;
            }
        });
        f28329n = true;
        f28330o = e.b(new InterfaceC1637a<Boolean>() { // from class: com.oplus.foundation.util.feature.FeatureUtil$initIsSupportCallPrivacy$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                boolean C10;
                C10 = FeatureUtil.f28316a.C();
                return Boolean.valueOf(C10);
            }
        });
    }

    public static final boolean A() {
        Object b10;
        boolean z10 = false;
        try {
            Result.a aVar = Result.f34166a;
            z10 = J6.e.a("oplus.software.fold_remap_display_disabled");
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            b.c("FeatureUtil", "exception hasFeature FEATURE_FOLD_REMAP_DISPLAY_DISABLED " + d10);
        }
        return z10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
    
        if (com.oplus.content.OplusFeatureConfigManager.getInstance().hasFeature("oplus.software.fold_remap_display_disabled") == false) goto L10;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean B() {
        /*
            r0 = 0
            kotlin.Result$a r1 = kotlin.Result.f34166a     // Catch: java.lang.Throwable -> L26
            r1 = 30
            r2 = 1
            boolean r1 = C7.b.a(r1, r2)     // Catch: java.lang.Throwable -> L26
            java.lang.String r3 = "oplus.software.fold_remap_display_disabled"
            java.lang.String r4 = "oplus.hardware.type.fold"
            if (r1 == 0) goto L28
            com.oplus.content.OplusFeatureConfigManager r1 = com.oplus.content.OplusFeatureConfigManager.getInstance()     // Catch: java.lang.Throwable -> L26
            boolean r1 = r1.hasFeature(r4)     // Catch: java.lang.Throwable -> L26
            if (r1 == 0) goto L35
            com.oplus.content.OplusFeatureConfigManager r1 = com.oplus.content.OplusFeatureConfigManager.getInstance()     // Catch: java.lang.Throwable -> L26
            boolean r1 = r1.hasFeature(r3)     // Catch: java.lang.Throwable -> L26
            if (r1 != 0) goto L35
        L24:
            r0 = r2
            goto L35
        L26:
            r1 = move-exception
            goto L3c
        L28:
            boolean r1 = J6.e.a(r4)     // Catch: java.lang.Throwable -> L26
            if (r1 == 0) goto L35
            boolean r1 = J6.e.a(r3)     // Catch: java.lang.Throwable -> L26
            if (r1 != 0) goto L35
            goto L24
        L35:
            m9.q r1 = m9.q.f35511a     // Catch: java.lang.Throwable -> L26
            java.lang.Object r1 = kotlin.Result.b(r1)     // Catch: java.lang.Throwable -> L26
            goto L46
        L3c:
            kotlin.Result$a r2 = kotlin.Result.f34166a
            java.lang.Object r1 = kotlin.b.a(r1)
            java.lang.Object r1 = kotlin.Result.b(r1)
        L46:
            java.lang.Throwable r1 = kotlin.Result.d(r1)
            if (r1 == 0) goto L62
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "exception hasFeature FEATURE_FOLD "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "FeatureUtil"
            H7.b.c(r2, r1)
        L62:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.foundation.util.feature.FeatureUtil.B():boolean");
    }

    public static final boolean D() {
        Object b10;
        try {
            Result.a aVar = Result.f34166a;
            b10 = Result.b(Boolean.valueOf(AppFeatureProviderUtils.c(P7.a.f2961a.a().getContentResolver(), "oplus.software.support_secondary_mini_app", false)));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            b.c("FeatureUtil", "exception hasFeature FEATURE_SUPPORT_SECONDARY_MINI_APP " + d10);
        }
        Boolean bool = Boolean.FALSE;
        if (Result.f(b10)) {
            b10 = bool;
        }
        return ((Boolean) b10).booleanValue();
    }

    public static final boolean G() {
        return z("oplus.hardware.audio.voice_isolation_support");
    }

    public static final boolean I() {
        return z("oplus.hardware.audio.voice_isolation_support_v3");
    }

    public static final boolean J() {
        return z("oplus.hardware.type.tablet");
    }

    public static final boolean L() {
        return f28329n;
    }

    public static final boolean M() {
        return f28316a.l();
    }

    public static final boolean N() {
        return f28316a.m();
    }

    public static final boolean O() {
        return !TextUtils.isEmpty(f28316a.x());
    }

    public static final boolean P() {
        return f28316a.y();
    }

    public static final boolean R() {
        return f28316a.n();
    }

    public static final boolean S() {
        return f28316a.o();
    }

    public static final boolean T() {
        FeatureUtil featureUtil = f28316a;
        if (!featureUtil.r() && !featureUtil.p() && !featureUtil.s() && !featureUtil.q() && !featureUtil.t()) {
            return false;
        }
        return true;
    }

    public static final boolean U() {
        return f28316a.t();
    }

    public static final boolean V() {
        return f28316a.u();
    }

    public static final boolean W() {
        return f28316a.v();
    }

    public static final void X(boolean z10) {
        f28329n = z10;
    }

    public static final String w() {
        return f28316a.x();
    }

    public static final boolean z(String str) {
        Object b10;
        boolean z10 = false;
        try {
            Result.a aVar = Result.f34166a;
            if (C7.b.a(30, 1)) {
                z10 = OplusFeatureConfigManager.getInstance().hasFeature(str);
            } else {
                z10 = J6.e.a(str);
            }
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            b.c("FeatureUtil", "exception hasFeature " + str + " " + d10);
        }
        return z10;
    }

    public final boolean C() {
        return z("oplus.software.audio.privacy_call_software_mode_support");
    }

    public final boolean E() {
        return z("oplus.hardware.audio.voice_denoise_support");
    }

    public final boolean F() {
        return z("oplus.hardware.audio.voice_denoise_support_v2");
    }

    public final boolean H() {
        return z("oplus.hardware.audio.voice_isolation_support_v2");
    }

    public final boolean K() {
        return z("oplus.software.radio.tt_satellite_support");
    }

    public final boolean Q() {
        int i10 = OplusBuild.VERSION.SDK_VERSION;
        int i11 = OplusBuild.VERSION.SDK_SUB_VERSION;
        if (H7.a.b()) {
            b.b("FeatureUtil", "isSatelliteApiSupport: api: " + i10 + ", subApi: " + i11);
        }
        if (i10 <= 33 && ((i10 != 33 || i11 < 31) && (i10 != 31 || i11 < 23))) {
            return false;
        }
        return true;
    }

    public final boolean l() {
        return ((Boolean) f28319d.getValue()).booleanValue();
    }

    public final boolean m() {
        return ((Boolean) f28318c.getValue()).booleanValue();
    }

    public final boolean n() {
        return ((Boolean) f28330o.getValue()).booleanValue();
    }

    public final boolean o() {
        return ((Boolean) f28320e.getValue()).booleanValue();
    }

    public final boolean p() {
        return ((Boolean) f28322g.getValue()).booleanValue();
    }

    public final boolean q() {
        return ((Boolean) f28324i.getValue()).booleanValue();
    }

    public final boolean r() {
        return ((Boolean) f28321f.getValue()).booleanValue();
    }

    public final boolean s() {
        return ((Boolean) f28323h.getValue()).booleanValue();
    }

    public final boolean t() {
        return ((Boolean) f28325j.getValue()).booleanValue();
    }

    public final boolean u() {
        return ((Boolean) f28317b.getValue()).booleanValue();
    }

    public final boolean v() {
        return ((Boolean) f28326k.getValue()).booleanValue();
    }

    public final String x() {
        return (String) f28327l.getValue();
    }

    public final boolean y() {
        return ((Boolean) f28328m.getValue()).booleanValue();
    }
}
