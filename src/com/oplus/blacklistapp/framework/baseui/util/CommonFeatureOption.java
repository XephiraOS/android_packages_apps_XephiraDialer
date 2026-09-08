package com.oplus.blacklistapp.framework.baseui.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.oplus.content.OplusFeatureConfigManager;
import com.oplus.coreapp.appfeature.AppFeatureProviderUtils;
import kotlin.Result;
import kotlin.a;
import kotlin.b;
import kotlin.jvm.internal.i;
import m9.d;
import m9.q;
import v9.InterfaceC1637a;

/* compiled from: CommonFeatureOption.kt */
/* loaded from: classes3.dex */
public final class CommonFeatureOption {

    /* renamed from: a, reason: collision with root package name */
    public static final CommonFeatureOption f27243a = new CommonFeatureOption();

    /* renamed from: b, reason: collision with root package name */
    public static final String f27244b = "oplus.hardware.linermotor.support";

    /* renamed from: c, reason: collision with root package name */
    public static Context f27245c;

    /* renamed from: d, reason: collision with root package name */
    public static final d f27246d;

    /* renamed from: e, reason: collision with root package name */
    public static final d f27247e;

    /* renamed from: f, reason: collision with root package name */
    public static final d f27248f;

    static {
        d b10;
        d b11;
        d b12;
        b10 = a.b(new InterfaceC1637a<Boolean>() { // from class: com.oplus.blacklistapp.framework.baseui.util.CommonFeatureOption$taskBarEnable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                Context context;
                context = CommonFeatureOption.f27245c;
                return Boolean.valueOf(context != null ? AppFeatureProviderUtils.p(context.getContentResolver(), "com.android.launcher.TASKBAR_ENABLE") : false);
            }
        });
        f27246d = b10;
        b11 = a.b(new InterfaceC1637a<Boolean>() { // from class: com.oplus.blacklistapp.framework.baseui.util.CommonFeatureOption$isTablet$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                Object b13;
                boolean z10 = false;
                try {
                    Result.a aVar = Result.f34166a;
                    z10 = OplusFeatureConfigManager.getInstance().hasFeature("oplus.hardware.type.tablet");
                    b13 = Result.b(q.f35511a);
                } catch (Throwable th) {
                    Result.a aVar2 = Result.f34166a;
                    b13 = Result.b(b.a(th));
                }
                Throwable d10 = Result.d(b13);
                if (d10 != null) {
                    Log.e("CommonFeatureOption", "exception hasFeature FEATURE_TABLET " + d10);
                }
                return Boolean.valueOf(z10);
            }
        });
        f27247e = b11;
        b12 = a.b(new InterfaceC1637a<Boolean>() { // from class: com.oplus.blacklistapp.framework.baseui.util.CommonFeatureOption$hardwareLinerMotorSupport$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                Context context;
                boolean z10;
                PackageManager packageManager;
                String str;
                context = CommonFeatureOption.f27245c;
                if (context == null || (packageManager = context.getPackageManager()) == null) {
                    z10 = false;
                } else {
                    str = CommonFeatureOption.f27244b;
                    z10 = packageManager.hasSystemFeature(str);
                }
                return Boolean.valueOf(z10);
            }
        });
        f27248f = b12;
    }

    public static final boolean c() {
        return ((Boolean) f27248f.getValue()).booleanValue();
    }

    public static final boolean d() {
        return ((Boolean) f27246d.getValue()).booleanValue();
    }

    public static final void e(Context ctx) {
        i.f(ctx, "ctx");
        f27245c = ctx;
    }

    public static final boolean f() {
        return ((Boolean) f27247e.getValue()).booleanValue();
    }
}
