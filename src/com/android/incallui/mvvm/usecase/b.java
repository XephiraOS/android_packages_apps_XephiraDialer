package com.android.incallui.mvvm.usecase;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: VideoBackgroundUseCase.kt */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes.dex */
public @interface b {

    /* renamed from: c, reason: collision with root package name */
    public static final a f18585c = a.f18586a;

    /* compiled from: VideoBackgroundUseCase.kt */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f18586a = new a();

        public final String a(int i10) {
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        return "";
                    }
                    return "OMOJI";
                }
                return "VIDEOSHOW";
            }
            return "INVALID";
        }
    }
}
