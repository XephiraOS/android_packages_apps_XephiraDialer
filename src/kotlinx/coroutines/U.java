package kotlinx.coroutines;

/* compiled from: CancellableContinuation.kt */
/* loaded from: classes4.dex */
public final class U extends AbstractC1262k {

    /* renamed from: a, reason: collision with root package name */
    public final T f34340a;

    public U(T t10) {
        this.f34340a = t10;
    }

    @Override // kotlinx.coroutines.AbstractC1264l
    public void f(Throwable th) {
        this.f34340a.b();
    }

    @Override // v9.l
    public /* bridge */ /* synthetic */ m9.q invoke(Throwable th) {
        f(th);
        return m9.q.f35511a;
    }

    public String toString() {
        return "DisposeOnCancel[" + this.f34340a + ']';
    }
}
