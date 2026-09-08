package c6;

import android.graphics.Path;
import b6.s;
import java.util.List;
import m6.C1337c;

/* compiled from: ShapeKeyframeAnimation.java */
/* loaded from: classes3.dex */
public class m extends AbstractC0558a<g6.i, Path> {

    /* renamed from: i, reason: collision with root package name */
    public final g6.i f12832i;

    /* renamed from: j, reason: collision with root package name */
    public final Path f12833j;

    /* renamed from: k, reason: collision with root package name */
    public List<s> f12834k;

    public m(List<C1337c<g6.i>> list) {
        super(list);
        this.f12832i = new g6.i();
        this.f12833j = new Path();
    }

    @Override // c6.AbstractC0558a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public Path i(C1337c<g6.i> c1337c, float f10) {
        this.f12832i.c(c1337c.f35155b, c1337c.f35156c, f10);
        g6.i iVar = this.f12832i;
        List<s> list = this.f12834k;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                iVar = this.f12834k.get(size).c(iVar);
            }
        }
        l6.g.h(iVar, this.f12833j);
        return this.f12833j;
    }

    public void q(List<s> list) {
        this.f12834k = list;
    }
}
