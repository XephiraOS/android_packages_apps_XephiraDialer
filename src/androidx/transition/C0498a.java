package androidx.transition;

import android.graphics.Canvas;

/* compiled from: CanvasUtils.java */
/* renamed from: androidx.transition.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0498a {

    /* compiled from: CanvasUtils.java */
    /* renamed from: androidx.transition.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0140a {
        public static void a(Canvas canvas) {
            canvas.disableZ();
        }

        public static void b(Canvas canvas) {
            canvas.enableZ();
        }
    }

    public static void a(Canvas canvas, boolean z10) {
        if (z10) {
            C0140a.b(canvas);
        } else {
            C0140a.a(canvas);
        }
    }
}
