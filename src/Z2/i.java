package Z2;

import s3.C1540k;
import t3.C1589a;

/* compiled from: LockedResource.java */
/* loaded from: classes.dex */
public final class i<Z> implements j<Z>, C1589a.f {

    /* renamed from: e, reason: collision with root package name */
    public static final I.e<i<?>> f5886e = C1589a.d(20, new a());

    /* renamed from: a, reason: collision with root package name */
    public final t3.c f5887a = t3.c.a();

    /* renamed from: b, reason: collision with root package name */
    public j<Z> f5888b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5889c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f5890d;

    /* compiled from: LockedResource.java */
    /* loaded from: classes.dex */
    public class a implements C1589a.d<i<?>> {
        @Override // t3.C1589a.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i<?> create() {
            return new i<>();
        }
    }

    public static <Z> i<Z> f(j<Z> jVar) {
        i<Z> iVar = (i) C1540k.d(f5886e.b());
        iVar.a(jVar);
        return iVar;
    }

    private void g() {
        this.f5888b = null;
        f5886e.a(this);
    }

    public final void a(j<Z> jVar) {
        this.f5890d = false;
        this.f5889c = true;
        this.f5888b = jVar;
    }

    @Override // Z2.j
    public synchronized void b() {
        this.f5887a.c();
        this.f5890d = true;
        if (!this.f5889c) {
            this.f5888b.b();
            g();
        }
    }

    @Override // Z2.j
    public int c() {
        return this.f5888b.c();
    }

    @Override // Z2.j
    public Class<Z> d() {
        return this.f5888b.d();
    }

    @Override // t3.C1589a.f
    public t3.c e() {
        return this.f5887a;
    }

    @Override // Z2.j
    public Z get() {
        return this.f5888b.get();
    }

    public synchronized void h() {
        this.f5887a.c();
        if (this.f5889c) {
            this.f5889c = false;
            if (this.f5890d) {
                b();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }
}
