package b3;

import b3.h;
import s3.C1537h;

/* compiled from: LruResourceCache.java */
/* loaded from: classes.dex */
public class g extends C1537h<X2.b, Z2.j<?>> implements h {

    /* renamed from: e, reason: collision with root package name */
    public h.a f12118e;

    public g(long j10) {
        super(j10);
    }

    @Override // b3.h
    public void a(int i10) {
        if (i10 >= 40) {
            b();
        } else if (i10 >= 20 || i10 == 15) {
            m(h() / 2);
        }
    }

    @Override // b3.h
    public void c(h.a aVar) {
        this.f12118e = aVar;
    }

    @Override // b3.h
    public /* bridge */ /* synthetic */ Z2.j d(X2.b bVar) {
        return (Z2.j) super.l(bVar);
    }

    @Override // b3.h
    public /* bridge */ /* synthetic */ Z2.j e(X2.b bVar, Z2.j jVar) {
        return (Z2.j) super.k(bVar, jVar);
    }

    @Override // s3.C1537h
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public int i(Z2.j<?> jVar) {
        if (jVar == null) {
            return super.i(null);
        }
        return jVar.c();
    }

    @Override // s3.C1537h
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void j(X2.b bVar, Z2.j<?> jVar) {
        h.a aVar = this.f12118e;
        if (aVar != null && jVar != null) {
            aVar.c(jVar);
        }
    }
}
