package t4;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import t4.AbstractC1591b;

/* compiled from: DrawingDelegate.java */
/* loaded from: classes3.dex */
public abstract class g<S extends AbstractC1591b> {

    /* renamed from: a, reason: collision with root package name */
    public S f37232a;

    /* compiled from: DrawingDelegate.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public float f37233a;

        /* renamed from: b, reason: collision with root package name */
        public float f37234b;

        /* renamed from: c, reason: collision with root package name */
        public int f37235c;

        /* renamed from: d, reason: collision with root package name */
        public int f37236d;
    }

    public g(S s10) {
        this.f37232a = s10;
    }

    public abstract void a(Canvas canvas, Rect rect, float f10, boolean z10, boolean z11);

    public abstract void b(Canvas canvas, Paint paint, int i10, int i11);

    public abstract void c(Canvas canvas, Paint paint, a aVar, int i10);

    public abstract void d(Canvas canvas, Paint paint, float f10, float f11, int i10, int i11, int i12);

    public abstract int e();

    public abstract int f();

    public void g(Canvas canvas, Rect rect, float f10, boolean z10, boolean z11) {
        this.f37232a.e();
        a(canvas, rect, f10, z10, z11);
    }
}
