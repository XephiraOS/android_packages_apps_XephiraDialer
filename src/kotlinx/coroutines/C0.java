package kotlinx.coroutines;

import kotlin.Result;

/* compiled from: JobSupport.kt */
/* loaded from: classes4.dex */
public final class C0 extends AbstractC1276r0 {

    /* renamed from: e, reason: collision with root package name */
    public final kotlin.coroutines.c<m9.q> f34303e;

    /* JADX WARN: Multi-variable type inference failed */
    public C0(kotlin.coroutines.c<? super m9.q> cVar) {
        this.f34303e = cVar;
    }

    @Override // v9.l
    public /* bridge */ /* synthetic */ m9.q invoke(Throwable th) {
        u(th);
        return m9.q.f35511a;
    }

    @Override // kotlinx.coroutines.AbstractC1284z
    public void u(Throwable th) {
        kotlin.coroutines.c<m9.q> cVar = this.f34303e;
        Result.a aVar = Result.f34166a;
        cVar.resumeWith(Result.b(m9.q.f35511a));
    }
}
