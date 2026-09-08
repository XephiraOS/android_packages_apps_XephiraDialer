package c6;

import android.graphics.PointF;
import java.util.List;
import m6.C1336b;
import m6.C1337c;

/* compiled from: PointKeyframeAnimation.java */
/* loaded from: classes3.dex */
public class k extends AbstractC0564g<PointF> {

    /* renamed from: i, reason: collision with root package name */
    public final PointF f12830i;

    public k(List<C1337c<PointF>> list) {
        super(list);
        this.f12830i = new PointF();
    }

    @Override // c6.AbstractC0558a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public PointF i(C1337c<PointF> c1337c, float f10) {
        return j(c1337c, f10, f10, f10);
    }

    @Override // c6.AbstractC0558a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public PointF j(C1337c<PointF> c1337c, float f10, float f11, float f12) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = c1337c.f35155b;
        if (pointF3 != null && (pointF = c1337c.f35156c) != null) {
            PointF pointF4 = pointF3;
            PointF pointF5 = pointF;
            C1336b<A> c1336b = this.f12801e;
            if (c1336b != 0 && (pointF2 = (PointF) c1336b.b(c1337c.f35160g, c1337c.f35161h.floatValue(), pointF4, pointF5, f10, e(), f())) != null) {
                return pointF2;
            }
            PointF pointF6 = this.f12830i;
            float f13 = pointF4.x;
            float f14 = f13 + (f11 * (pointF5.x - f13));
            float f15 = pointF4.y;
            pointF6.set(f14, f15 + (f12 * (pointF5.y - f15)));
            return this.f12830i;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
