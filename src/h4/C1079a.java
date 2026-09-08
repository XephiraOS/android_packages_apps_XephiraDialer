package h4;

import android.graphics.Canvas;

/* compiled from: CanvasCompat.java */
/* renamed from: h4.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1079a {

    /* compiled from: CanvasCompat.java */
    /* renamed from: h4.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0303a {
        void a(Canvas canvas);
    }

    public static int a(Canvas canvas, float f10, float f11, float f12, float f13, int i10) {
        return canvas.saveLayerAlpha(f10, f11, f12, f13, i10);
    }
}
