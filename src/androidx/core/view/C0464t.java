package androidx.core.view;

import android.view.MotionEvent;

/* compiled from: MotionEventCompat.java */
/* renamed from: androidx.core.view.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0464t {
    @Deprecated
    public static int a(MotionEvent motionEvent) {
        return motionEvent.getActionMasked();
    }

    public static boolean b(MotionEvent motionEvent, int i10) {
        if ((motionEvent.getSource() & i10) == i10) {
            return true;
        }
        return false;
    }
}
