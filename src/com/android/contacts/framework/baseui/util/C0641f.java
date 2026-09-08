package com.android.contacts.framework.baseui.util;

import android.view.MotionEvent;

/* compiled from: FeedbackAnimatorHelper.kt */
/* renamed from: com.android.contacts.framework.baseui.util.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0641f {
    public static final void a(C0640e c0640e, MotionEvent event) {
        kotlin.jvm.internal.i.f(c0640e, "<this>");
        kotlin.jvm.internal.i.f(event, "event");
        int action = event.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                c0640e.e(false);
                return;
            }
            return;
        }
        c0640e.e(true);
    }
}
