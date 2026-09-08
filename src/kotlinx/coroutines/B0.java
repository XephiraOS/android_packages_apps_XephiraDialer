package kotlinx.coroutines;

import kotlin.Result;

/* compiled from: JobSupport.kt */
/* loaded from: classes4.dex */
public final class B0<T> extends AbstractC1276r0 {

    /* renamed from: e, reason: collision with root package name */
    public final C1268n<T> f34300e;

    /* JADX WARN: Multi-variable type inference failed */
    public B0(C1268n<? super T> c1268n) {
        this.f34300e = c1268n;
    }

    @Override // v9.l
    public /* bridge */ /* synthetic */ m9.q invoke(Throwable th) {
        u(th);
        return m9.q.f35511a;
    }

    @Override // kotlinx.coroutines.AbstractC1284z
    public void u(Throwable th) {
        Object d02 = v().d0();
        if (d02 instanceof C1282x) {
            C1268n<T> c1268n = this.f34300e;
            Result.a aVar = Result.f34166a;
            c1268n.resumeWith(Result.b(kotlin.b.a(((C1282x) d02).f34650a)));
        } else {
            C1268n<T> c1268n2 = this.f34300e;
            Result.a aVar2 = Result.f34166a;
            c1268n2.resumeWith(Result.b(t0.h(d02)));
        }
    }
}
