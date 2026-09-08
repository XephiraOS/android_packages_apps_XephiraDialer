package c6;

import android.graphics.PointF;
import java.util.Collections;
import m6.C1336b;
import m6.C1337c;

/* compiled from: SplitDimensionPathKeyframeAnimation.java */
/* loaded from: classes3.dex */
public class n extends AbstractC0558a<PointF, PointF> {

    /* renamed from: i, reason: collision with root package name */
    public final PointF f12835i;

    /* renamed from: j, reason: collision with root package name */
    public final PointF f12836j;

    /* renamed from: k, reason: collision with root package name */
    public final AbstractC0558a<Float, Float> f12837k;

    /* renamed from: l, reason: collision with root package name */
    public final AbstractC0558a<Float, Float> f12838l;

    /* renamed from: m, reason: collision with root package name */
    public C1336b<Float> f12839m;

    /* renamed from: n, reason: collision with root package name */
    public C1336b<Float> f12840n;

    public n(AbstractC0558a<Float, Float> abstractC0558a, AbstractC0558a<Float, Float> abstractC0558a2) {
        super(Collections.emptyList());
        this.f12835i = new PointF();
        this.f12836j = new PointF();
        this.f12837k = abstractC0558a;
        this.f12838l = abstractC0558a2;
        m(f());
    }

    @Override // c6.AbstractC0558a
    public void m(float f10) {
        this.f12837k.m(f10);
        this.f12838l.m(f10);
        this.f12835i.set(this.f12837k.h().floatValue(), this.f12838l.h().floatValue());
        for (int i10 = 0; i10 < this.f12797a.size(); i10++) {
            this.f12797a.get(i10).a();
        }
    }

    @Override // c6.AbstractC0558a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public PointF h() {
        return i(null, 0.0f);
    }

    @Override // c6.AbstractC0558a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public PointF i(C1337c<PointF> c1337c, float f10) {
        Float f11;
        C1337c<Float> b10;
        float floatValue;
        C1337c<Float> b11;
        float floatValue2;
        Float f12 = null;
        if (this.f12839m != null && (b11 = this.f12837k.b()) != null) {
            float d10 = this.f12837k.d();
            Float f13 = b11.f35161h;
            C1336b<Float> c1336b = this.f12839m;
            float f14 = b11.f35160g;
            if (f13 == null) {
                floatValue2 = f14;
            } else {
                floatValue2 = f13.floatValue();
            }
            f11 = c1336b.b(f14, floatValue2, b11.f35155b, b11.f35156c, f10, f10, d10);
        } else {
            f11 = null;
        }
        if (this.f12840n != null && (b10 = this.f12838l.b()) != null) {
            float d11 = this.f12838l.d();
            Float f15 = b10.f35161h;
            C1336b<Float> c1336b2 = this.f12840n;
            float f16 = b10.f35160g;
            if (f15 == null) {
                floatValue = f16;
            } else {
                floatValue = f15.floatValue();
            }
            f12 = c1336b2.b(f16, floatValue, b10.f35155b, b10.f35156c, f10, f10, d11);
        }
        if (f11 == null) {
            this.f12836j.set(this.f12835i.x, 0.0f);
        } else {
            this.f12836j.set(f11.floatValue(), 0.0f);
        }
        if (f12 == null) {
            PointF pointF = this.f12836j;
            pointF.set(pointF.x, this.f12835i.y);
        } else {
            PointF pointF2 = this.f12836j;
            pointF2.set(pointF2.x, f12.floatValue());
        }
        return this.f12836j;
    }

    public void r(C1336b<Float> c1336b) {
        C1336b<Float> c1336b2 = this.f12839m;
        if (c1336b2 != null) {
            c1336b2.c(null);
        }
        this.f12839m = c1336b;
        if (c1336b != null) {
            c1336b.c(this);
        }
    }

    public void s(C1336b<Float> c1336b) {
        C1336b<Float> c1336b2 = this.f12840n;
        if (c1336b2 != null) {
            c1336b2.c(null);
        }
        this.f12840n = c1336b;
        if (c1336b != null) {
            c1336b.c(this);
        }
    }
}
