package com.android.incallui.oplus.incomingfloatingwindow.domain.bean;

import com.android.incallui.R;
import q2.b;

/* compiled from: WindowViewBehavior.kt */
/* loaded from: classes.dex */
public interface a extends b {

    /* compiled from: WindowViewBehavior.kt */
    /* renamed from: com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0184a {
        public static int a(a aVar, boolean z10) {
            if (z10) {
                return aVar.c();
            }
            return aVar.f();
        }

        public static int b(a aVar, a aVar2) {
            return R.anim.floating_window_button_fade_in;
        }

        public static int c(a aVar, a aVar2) {
            return R.anim.floating_window_button_fade_away;
        }
    }

    int a(boolean z10);

    int c();

    int d(a aVar);

    int e(a aVar);

    int f();
}
