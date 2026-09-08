package c6;

import java.util.Collections;
import m6.C1336b;
import m6.C1337c;

/* compiled from: ValueCallbackKeyframeAnimation.java */
/* loaded from: classes3.dex */
public class q<K, A> extends AbstractC0558a<K, A> {

    /* renamed from: i, reason: collision with root package name */
    public final A f12859i;

    public q(C1336b<A> c1336b) {
        this(c1336b, null);
    }

    @Override // c6.AbstractC0558a
    public float c() {
        return 1.0f;
    }

    @Override // c6.AbstractC0558a
    public A h() {
        C1336b<A> c1336b = this.f12801e;
        A a10 = this.f12859i;
        return c1336b.b(0.0f, 0.0f, a10, a10, f(), f(), f());
    }

    @Override // c6.AbstractC0558a
    public A i(C1337c<K> c1337c, float f10) {
        return h();
    }

    @Override // c6.AbstractC0558a
    public void k() {
        if (this.f12801e != null) {
            super.k();
        }
    }

    @Override // c6.AbstractC0558a
    public void m(float f10) {
        this.f12800d = f10;
    }

    public q(C1336b<A> c1336b, A a10) {
        super(Collections.emptyList());
        n(c1336b);
        this.f12859i = a10;
    }
}
