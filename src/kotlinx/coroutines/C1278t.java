package kotlinx.coroutines;

/* compiled from: JobSupport.kt */
/* renamed from: kotlinx.coroutines.t, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1278t extends AbstractC1267m0 implements InterfaceC1277s {

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC1279u f34634e;

    public C1278t(InterfaceC1279u interfaceC1279u) {
        this.f34634e = interfaceC1279u;
    }

    @Override // kotlinx.coroutines.InterfaceC1277s
    public boolean e(Throwable th) {
        return v().H(th);
    }

    @Override // kotlinx.coroutines.InterfaceC1277s
    public InterfaceC1265l0 getParent() {
        return v();
    }

    @Override // v9.l
    public /* bridge */ /* synthetic */ m9.q invoke(Throwable th) {
        u(th);
        return m9.q.f35511a;
    }

    @Override // kotlinx.coroutines.AbstractC1284z
    public void u(Throwable th) {
        this.f34634e.I(v());
    }
}
