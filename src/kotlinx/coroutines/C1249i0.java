package kotlinx.coroutines;

/* compiled from: CancellableContinuationImpl.kt */
/* renamed from: kotlinx.coroutines.i0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1249i0 extends AbstractC1262k {

    /* renamed from: a, reason: collision with root package name */
    public final v9.l<Throwable, m9.q> f34477a;

    /* JADX WARN: Multi-variable type inference failed */
    public C1249i0(v9.l<? super Throwable, m9.q> lVar) {
        this.f34477a = lVar;
    }

    @Override // kotlinx.coroutines.AbstractC1264l
    public void f(Throwable th) {
        this.f34477a.invoke(th);
    }

    @Override // v9.l
    public /* bridge */ /* synthetic */ m9.q invoke(Throwable th) {
        f(th);
        return m9.q.f35511a;
    }

    public String toString() {
        return "InvokeOnCancel[" + G.a(this.f34477a) + '@' + G.b(this) + ']';
    }
}
