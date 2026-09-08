package k3;

import i3.AbstractC1094c;

/* compiled from: GifDrawableResource.java */
/* loaded from: classes.dex */
public class e extends AbstractC1094c<c> implements Z2.g {
    public e(c cVar) {
        super(cVar);
    }

    @Override // i3.AbstractC1094c, Z2.g
    public void a() {
        ((c) this.f32155a).e().prepareToDraw();
    }

    @Override // Z2.j
    public void b() {
        ((c) this.f32155a).stop();
        ((c) this.f32155a).k();
    }

    @Override // Z2.j
    public int c() {
        return ((c) this.f32155a).i();
    }

    @Override // Z2.j
    public Class<c> d() {
        return c.class;
    }
}
