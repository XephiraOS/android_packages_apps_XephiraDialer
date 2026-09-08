package com.android.contacts.framework.baseui.util;

import M7.b;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.android.incallui.BuildConfig;
import com.oplus.coreapp.appfeature.AppFeatureProviderUtils;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import com.oplus.foundation.util.systemcore.PrimaryUserUtils;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import v9.InterfaceC1637a;

/* compiled from: AiCallTranslateStateController.kt */
/* loaded from: classes.dex */
public final class AiCallTranslateStateController {

    /* renamed from: b, reason: collision with root package name */
    public static final a f15829b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public static boolean f15830c = true;

    /* renamed from: d, reason: collision with root package name */
    public static Boolean f15831d;

    /* renamed from: e, reason: collision with root package name */
    public static Boolean f15832e;

    /* renamed from: f, reason: collision with root package name */
    public static Boolean f15833f;

    /* renamed from: g, reason: collision with root package name */
    public static final m9.d<AiCallTranslateStateController> f15834g;

    /* renamed from: a, reason: collision with root package name */
    public Context f15835a = P7.a.f2961a.a();

    /* compiled from: AiCallTranslateStateController.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final AiCallTranslateStateController a() {
            return (AiCallTranslateStateController) AiCallTranslateStateController.f15834g.getValue();
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    static {
        m9.d<AiCallTranslateStateController> a10;
        a10 = kotlin.a.a(LazyThreadSafetyMode.f34161a, new InterfaceC1637a<AiCallTranslateStateController>() { // from class: com.android.contacts.framework.baseui.util.AiCallTranslateStateController$Companion$sInstance$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final AiCallTranslateStateController invoke() {
                return new AiCallTranslateStateController();
            }
        });
        f15834g = a10;
    }

    public final boolean b() {
        return P7.c.d(this.f15835a, "com.oplus.aicall", false);
    }

    public final boolean c(Context context, String str, String metaDataName, String str2) {
        kotlin.jvm.internal.i.f(metaDataName, "metaDataName");
        boolean z10 = false;
        if (context == null) {
            Log.i("AiCallTranslateStateController", "hasMetaData, context is null, return false");
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            kotlin.jvm.internal.i.c(str);
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            kotlin.jvm.internal.i.e(applicationInfo, "context.packageManager.g…T_META_DATA\n            )");
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null) {
                z10 = TextUtils.equals(String.valueOf(bundle.get(metaDataName)), str2);
            }
        } catch (PackageManager.NameNotFoundException e10) {
            H7.b.c("AiCallTranslateStateController", "hasMetaData, e = " + e10.getMessage());
        }
        H7.b.c("AiCallTranslateStateController", "hasMetaData, hasMeta = " + z10 + ", metaDataName = " + metaDataName);
        return z10;
    }

    public final boolean d(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        int a10 = b.C0045b.a(1).f1799c.a(context.getContentResolver(), "ai_call_translate_switch", -1);
        H7.b.e("AiCallTranslateStateController", "isCallTranslateOpen: " + a10);
        if (a10 == 1) {
            return true;
        }
        return false;
    }

    public final boolean e() {
        Boolean bool = f15833f;
        if (bool == null) {
            Boolean valueOf = Boolean.valueOf(c(this.f15835a, BuildConfig.LIBRARY_PACKAGE_NAME, "support_ai_call_translate", "true"));
            f15833f = valueOf;
            return kotlin.jvm.internal.i.b(valueOf, Boolean.TRUE);
        }
        return kotlin.jvm.internal.i.b(bool, Boolean.TRUE);
    }

    public final boolean f(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        boolean z10 = false;
        if (CommonFeatureOption.m()) {
            return false;
        }
        if (AppFeatureProviderUtils.p(P7.a.f2961a.a().getContentResolver(), "com.oplus.aicall.call_translate") && b() && !i(context) && !L7.a.c() && PrimaryUserUtils.a()) {
            z10 = true;
        }
        H7.b.e("AiCallTranslateStateController", "isNeedShow = " + z10);
        return z10;
    }

    public final boolean g() {
        f15830c = true;
        if (L7.a.c()) {
            H7.b.e("AiCallTranslateStateController", "isSupportAiCallTranslate return false for in super power save mode");
            f15830c = false;
            return false;
        }
        if (!e()) {
            H7.b.e("AiCallTranslateStateController", "InCallUI isSupportAiCallTranslate return false for meta data not support");
            f15830c = false;
            return false;
        }
        if (!j()) {
            H7.b.e("AiCallTranslateStateController", "VDC isSupportAiCallTranslate return false for meta data not support");
            f15830c = false;
            return false;
        }
        if (!h()) {
            H7.b.e("AiCallTranslateStateController", "TeleService isSupportAiCallTranslate return false for meta data not support");
            f15830c = false;
            return false;
        }
        boolean p10 = AppFeatureProviderUtils.p(P7.a.f2961a.a().getContentResolver(), "com.oplus.aicall.call_translate");
        H7.b.e("AiCallTranslateStateController", "isFeatureSupport = " + p10);
        if (!p10) {
            H7.b.e("AiCallTranslateStateController", "isSupportAiCallTranslate return false for feature");
            f15830c = false;
            return false;
        }
        if (!b()) {
            H7.b.e("AiCallTranslateStateController", "isSupportAiCall return false for meta data not support");
            f15830c = false;
            return false;
        }
        return f15830c;
    }

    public final boolean h() {
        Boolean bool = f15831d;
        if (bool == null) {
            Boolean valueOf = Boolean.valueOf(c(this.f15835a, "com.android.phone", "support_ai_call_translate", "true"));
            f15831d = valueOf;
            return kotlin.jvm.internal.i.b(valueOf, Boolean.TRUE);
        }
        return kotlin.jvm.internal.i.b(bool, Boolean.TRUE);
    }

    public final boolean i(Context context) {
        Object b10;
        kotlin.jvm.internal.i.f(context, "context");
        try {
            Result.a aVar = Result.f34166a;
            boolean z10 = true;
            if (b.C0045b.a(1).f1799c.a(context.getContentResolver(), "ai_call_enter_state", -1) != 1) {
                z10 = false;
            }
            b10 = Result.b(Boolean.valueOf(z10));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("AiCallTranslateStateController", "isUserEnterAICallAssistant getInt error " + d10 + " " + d10.getMessage());
        }
        Boolean bool = Boolean.FALSE;
        if (Result.f(b10)) {
            b10 = bool;
        }
        return ((Boolean) b10).booleanValue();
    }

    public final boolean j() {
        Boolean bool = f15832e;
        if (bool == null) {
            Boolean valueOf = Boolean.valueOf(c(this.f15835a, "com.oplus.vdc", "support_ai_call_translate", "true"));
            f15832e = valueOf;
            return kotlin.jvm.internal.i.b(valueOf, Boolean.TRUE);
        }
        return kotlin.jvm.internal.i.b(bool, Boolean.TRUE);
    }
}
