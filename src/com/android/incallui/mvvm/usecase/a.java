package com.android.incallui.mvvm.usecase;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: VideoBackgroundUseCase.kt */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes.dex */
public @interface a {

    /* renamed from: b, reason: collision with root package name */
    public static final C0181a f18583b = C0181a.f18584a;

    /* compiled from: VideoBackgroundUseCase.kt */
    /* renamed from: com.android.incallui.mvvm.usecase.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0181a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C0181a f18584a = new C0181a();

        public final String a(int i10) {
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        return "";
                    }
                    return "SHOWING";
                }
                return "STATE_IDLE";
            }
            return "INVALID";
        }
    }
}
