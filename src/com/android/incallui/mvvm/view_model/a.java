package com.android.incallui.mvvm.view_model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: BackgroundViewModel.kt */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes.dex */
public @interface a {

    /* renamed from: d, reason: collision with root package name */
    public static final C0182a f18720d = C0182a.f18721a;

    /* compiled from: BackgroundViewModel.kt */
    /* renamed from: com.android.incallui.mvvm.view_model.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0182a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C0182a f18721a = new C0182a();

        public final String a(int i10) {
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            if (i10 != 4) {
                                return "";
                            }
                            return "VIDEO_PREVIEW";
                        }
                        return "WALLPAPER";
                    }
                    return "CONTACT";
                }
                return "OMOJI";
            }
            return "DARK";
        }
    }
}
