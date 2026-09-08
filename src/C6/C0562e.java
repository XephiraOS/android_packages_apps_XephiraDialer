package c6;

import java.util.List;
import m6.C1337c;

/* compiled from: GradientColorKeyframeAnimation.java */
/* renamed from: c6.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0562e extends AbstractC0564g<g6.d> {

    /* renamed from: i, reason: collision with root package name */
    public final g6.d f12820i;

    public C0562e(List<C1337c<g6.d>> list) {
        super(list);
        g6.d dVar = list.get(0).f35155b;
        int e10 = dVar != null ? dVar.e() : 0;
        this.f12820i = new g6.d(new float[e10], new int[e10]);
    }

    @Override // c6.AbstractC0558a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public g6.d i(C1337c<g6.d> c1337c, float f10) {
        this.f12820i.f(c1337c.f35155b, c1337c.f35156c, f10);
        return this.f12820i;
    }
}
