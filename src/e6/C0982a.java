package e6;

import android.graphics.PointF;

/* compiled from: CubicCurveData.java */
/* renamed from: e6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0982a {

    /* renamed from: a, reason: collision with root package name */
    public final PointF f31629a;

    /* renamed from: b, reason: collision with root package name */
    public final PointF f31630b;

    /* renamed from: c, reason: collision with root package name */
    public final PointF f31631c;

    public C0982a() {
        this.f31629a = new PointF();
        this.f31630b = new PointF();
        this.f31631c = new PointF();
    }

    public PointF a() {
        return this.f31629a;
    }

    public PointF b() {
        return this.f31630b;
    }

    public PointF c() {
        return this.f31631c;
    }

    public void d(float f10, float f11) {
        this.f31629a.set(f10, f11);
    }

    public void e(float f10, float f11) {
        this.f31630b.set(f10, f11);
    }

    public void f(float f10, float f11) {
        this.f31631c.set(f10, f11);
    }

    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", Float.valueOf(this.f31631c.x), Float.valueOf(this.f31631c.y), Float.valueOf(this.f31629a.x), Float.valueOf(this.f31629a.y), Float.valueOf(this.f31630b.x), Float.valueOf(this.f31630b.y));
    }

    public C0982a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f31629a = pointF;
        this.f31630b = pointF2;
        this.f31631c = pointF3;
    }
}
