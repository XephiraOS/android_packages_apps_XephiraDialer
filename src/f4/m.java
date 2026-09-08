package F4;

import com.google.gson.p;
import com.google.gson.r;
import com.google.gson.s;

/* compiled from: TreeTypeAdapter.java */
/* loaded from: classes3.dex */
public final class m<T> extends l<T> {

    /* renamed from: a, reason: collision with root package name */
    public final p<T> f912a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.gson.i<T> f913b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.gson.d f914c;

    /* renamed from: d, reason: collision with root package name */
    public final J4.a<T> f915d;

    /* renamed from: e, reason: collision with root package name */
    public final s f916e;

    /* renamed from: f, reason: collision with root package name */
    public final m<T>.b f917f = new b();

    /* renamed from: g, reason: collision with root package name */
    public final boolean f918g;

    /* renamed from: h, reason: collision with root package name */
    public volatile r<T> f919h;

    /* compiled from: TreeTypeAdapter.java */
    /* loaded from: classes3.dex */
    public final class b implements com.google.gson.o, com.google.gson.h {
        public b() {
        }
    }

    public m(p<T> pVar, com.google.gson.i<T> iVar, com.google.gson.d dVar, J4.a<T> aVar, s sVar, boolean z10) {
        this.f912a = pVar;
        this.f913b = iVar;
        this.f914c = dVar;
        this.f915d = aVar;
        this.f916e = sVar;
        this.f918g = z10;
    }

    private r<T> f() {
        r<T> rVar = this.f919h;
        if (rVar == null) {
            r<T> n10 = this.f914c.n(this.f916e, this.f915d);
            this.f919h = n10;
            return n10;
        }
        return rVar;
    }

    @Override // com.google.gson.r
    public T b(K4.a aVar) {
        if (this.f913b == null) {
            return f().b(aVar);
        }
        com.google.gson.j a10 = com.google.gson.internal.j.a(aVar);
        if (this.f918g && a10.h()) {
            return null;
        }
        return this.f913b.a(a10, this.f915d.getType(), this.f917f);
    }

    @Override // com.google.gson.r
    public void d(K4.b bVar, T t10) {
        p<T> pVar = this.f912a;
        if (pVar == null) {
            f().d(bVar, t10);
        } else if (this.f918g && t10 == null) {
            bVar.I();
        } else {
            com.google.gson.internal.j.b(pVar.a(t10, this.f915d.getType(), this.f917f), bVar);
        }
    }

    @Override // F4.l
    public r<T> e() {
        if (this.f912a == null) {
            return f();
        }
        return this;
    }
}
