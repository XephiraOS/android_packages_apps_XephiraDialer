package c6;

import java.util.List;
import m6.C1336b;
import m6.C1337c;

/* compiled from: FloatKeyframeAnimation.java */
/* renamed from: c6.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0561d extends AbstractC0564g<Float> {
    public C0561d(List<C1337c<Float>> list) {
        super(list);
    }

    public float p() {
        return q(b(), d());
    }

    public float q(C1337c<Float> c1337c, float f10) {
        Float f11;
        if (c1337c.f35155b != null && c1337c.f35156c != null) {
            C1336b<A> c1336b = this.f12801e;
            if (c1336b != 0 && (f11 = (Float) c1336b.b(c1337c.f35160g, c1337c.f35161h.floatValue(), c1337c.f35155b, c1337c.f35156c, f10, e(), f())) != null) {
                return f11.floatValue();
            }
            return l6.g.i(c1337c.g(), c1337c.d(), f10);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    @Override // c6.AbstractC0558a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public Float i(C1337c<Float> c1337c, float f10) {
        return Float.valueOf(q(c1337c, f10));
    }
}
