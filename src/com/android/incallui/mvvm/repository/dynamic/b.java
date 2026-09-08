package com.android.incallui.mvvm.repository.dynamic;

import com.android.incallui.OplusInCallApp;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.mvvm.utils.h;

/* compiled from: FBEModeRepository.kt */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f18561a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final h<Boolean> f18562b = new h<>(Boolean.valueOf(!OplusPhoneUtils.isUserUnlocked(OplusInCallApp.getAppContext())), false, 2, null);

    public final h<Boolean> a() {
        return f18562b;
    }
}
