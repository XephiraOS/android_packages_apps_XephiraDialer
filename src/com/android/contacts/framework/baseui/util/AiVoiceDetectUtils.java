package com.android.contacts.framework.baseui.util;

import android.content.Context;
import com.oplus.coreapp.appfeature.AppFeatureProviderUtils;
import com.oplus.foundation.util.feature.CommonOSPublicFeature;
import com.oplus.os.OplusBuild;
import v9.InterfaceC1637a;

/* compiled from: AiVoiceDetectUtils.kt */
/* loaded from: classes.dex */
public final class AiVoiceDetectUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final AiVoiceDetectUtils f15837a = new AiVoiceDetectUtils();

    /* renamed from: b, reason: collision with root package name */
    public static final m9.d f15838b;

    /* renamed from: c, reason: collision with root package name */
    public static final m9.d f15839c;

    static {
        m9.d b10;
        m9.d b11;
        b10 = kotlin.a.b(new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.framework.baseui.util.AiVoiceDetectUtils$isAiVoiceDetectSupport$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                return Boolean.valueOf(AppFeatureProviderUtils.g(P7.a.f2961a.a().getContentResolver(), "com.oplus.phonemanager.ai_voice_detect", 0) != 0);
            }
        });
        f15838b = b10;
        b11 = kotlin.a.b(new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.framework.baseui.util.AiVoiceDetectUtils$isOSSupport$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                return Boolean.valueOf(OplusBuild.VERSION.SDK_VERSION >= 34);
            }
        });
        f15839c = b11;
    }

    public static final boolean a(Context context, int i10) {
        if (context == null) {
            return false;
        }
        AiVoiceDetectUtils aiVoiceDetectUtils = f15837a;
        if (!aiVoiceDetectUtils.b() || !aiVoiceDetectUtils.c() || !CommonOSPublicFeature.f() || (i10 & Integer.MIN_VALUE) != Integer.MIN_VALUE) {
            return false;
        }
        return true;
    }

    public final boolean b() {
        return ((Boolean) f15838b.getValue()).booleanValue();
    }

    public final boolean c() {
        return ((Boolean) f15839c.getValue()).booleanValue();
    }
}
