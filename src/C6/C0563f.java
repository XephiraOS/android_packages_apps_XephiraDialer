package c6;

import java.util.List;
import m6.C1336b;
import m6.C1337c;

/* compiled from: IntegerKeyframeAnimation.java */
/* renamed from: c6.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0563f extends AbstractC0564g<Integer> {
    public C0563f(List<C1337c<Integer>> list) {
        super(list);
    }

    public int p() {
        return q(b(), d());
    }

    public int q(C1337c<Integer> c1337c, float f10) {
        Integer num;
        if (c1337c.f35155b != null && c1337c.f35156c != null) {
            C1336b<A> c1336b = this.f12801e;
            if (c1336b != 0 && (num = (Integer) c1336b.b(c1337c.f35160g, c1337c.f35161h.floatValue(), c1337c.f35155b, c1337c.f35156c, f10, e(), f())) != null) {
                return num.intValue();
            }
            return l6.g.j(c1337c.h(), c1337c.e(), f10);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    @Override // c6.AbstractC0558a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public Integer i(C1337c<Integer> c1337c, float f10) {
        return Integer.valueOf(q(c1337c, f10));
    }
}
