package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.C1258i;
import kotlinx.coroutines.internal.ThreadContextKt;

/* compiled from: DispatchedTask.kt */
/* loaded from: classes4.dex */
public abstract class O<T> extends E9.g {

    /* renamed from: c, reason: collision with root package name */
    public int f34330c;

    public O(int i10) {
        this.f34330c = i10;
    }

    public abstract kotlin.coroutines.c<T> d();

    public Throwable e(Object obj) {
        C1282x c1282x;
        if (obj instanceof C1282x) {
            c1282x = (C1282x) obj;
        } else {
            c1282x = null;
        }
        if (c1282x == null) {
            return null;
        }
        return c1282x.f34650a;
    }

    public final void j(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            m9.b.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        kotlin.jvm.internal.i.c(th);
        D.a(d().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object k();

    @Override // java.lang.Runnable
    public final void run() {
        Object b10;
        O0<?> o02;
        InterfaceC1265l0 interfaceC1265l0;
        Object b11;
        E9.h hVar = this.f753b;
        try {
            kotlin.coroutines.c<T> d10 = d();
            kotlin.jvm.internal.i.d(d10, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            C1258i c1258i = (C1258i) d10;
            kotlin.coroutines.c<T> cVar = c1258i.f34512e;
            Object obj = c1258i.f34514g;
            CoroutineContext context = cVar.getContext();
            Object c10 = ThreadContextKt.c(context, obj);
            if (c10 != ThreadContextKt.f34495a) {
                o02 = CoroutineContextKt.g(cVar, context, c10);
            } else {
                o02 = null;
            }
            try {
                CoroutineContext context2 = cVar.getContext();
                Object k10 = k();
                Throwable e10 = e(k10);
                if (e10 == null && P.b(this.f34330c)) {
                    interfaceC1265l0 = (InterfaceC1265l0) context2.a(InterfaceC1265l0.f34546v);
                } else {
                    interfaceC1265l0 = null;
                }
                if (interfaceC1265l0 != null && !interfaceC1265l0.c()) {
                    CancellationException B10 = interfaceC1265l0.B();
                    a(k10, B10);
                    Result.a aVar = Result.f34166a;
                    cVar.resumeWith(Result.b(kotlin.b.a(B10)));
                } else if (e10 != null) {
                    Result.a aVar2 = Result.f34166a;
                    cVar.resumeWith(Result.b(kotlin.b.a(e10)));
                } else {
                    Result.a aVar3 = Result.f34166a;
                    cVar.resumeWith(Result.b(g(k10)));
                }
                m9.q qVar = m9.q.f35511a;
                if (o02 == null || o02.N0()) {
                    ThreadContextKt.a(context, c10);
                }
                try {
                    hVar.a();
                    b11 = Result.b(m9.q.f35511a);
                } catch (Throwable th) {
                    Result.a aVar4 = Result.f34166a;
                    b11 = Result.b(kotlin.b.a(th));
                }
                j(null, Result.d(b11));
            } catch (Throwable th2) {
                if (o02 == null || o02.N0()) {
                    ThreadContextKt.a(context, c10);
                }
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                Result.a aVar5 = Result.f34166a;
                hVar.a();
                b10 = Result.b(m9.q.f35511a);
            } catch (Throwable th4) {
                Result.a aVar6 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th4));
            }
            j(th3, Result.d(b10));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T g(Object obj) {
        return obj;
    }

    public void a(Object obj, Throwable th) {
    }
}
