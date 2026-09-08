package c6;

import java.util.List;
import m6.C1336b;
import m6.C1337c;
import m6.C1338d;

/* compiled from: ScaleKeyframeAnimation.java */
/* loaded from: classes3.dex */
public class l extends AbstractC0564g<C1338d> {

    /* renamed from: i, reason: collision with root package name */
    public final C1338d f12831i;

    public l(List<C1337c<C1338d>> list) {
        super(list);
        this.f12831i = new C1338d();
    }

    @Override // c6.AbstractC0558a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public C1338d i(C1337c<C1338d> c1337c, float f10) {
        C1338d c1338d;
        C1338d c1338d2;
        C1338d c1338d3 = c1337c.f35155b;
        if (c1338d3 != null && (c1338d = c1337c.f35156c) != null) {
            C1338d c1338d4 = c1338d3;
            C1338d c1338d5 = c1338d;
            C1336b<A> c1336b = this.f12801e;
            if (c1336b != 0 && (c1338d2 = (C1338d) c1336b.b(c1337c.f35160g, c1337c.f35161h.floatValue(), c1338d4, c1338d5, f10, e(), f())) != null) {
                return c1338d2;
            }
            this.f12831i.d(l6.g.i(c1338d4.b(), c1338d5.b(), f10), l6.g.i(c1338d4.c(), c1338d5.c(), f10));
            return this.f12831i;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
