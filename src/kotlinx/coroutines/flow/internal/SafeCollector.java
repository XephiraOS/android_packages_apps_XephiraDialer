package kotlinx.coroutines.flow.internal;

import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.C1271o0;
import m9.q;
import p9.C1472f;
import p9.InterfaceC1469c;
import v9.p;

/* compiled from: SafeCollector.kt */
/* loaded from: classes4.dex */
public final class SafeCollector<T> extends ContinuationImpl implements kotlinx.coroutines.flow.b<T>, InterfaceC1469c {
    public final CoroutineContext collectContext;
    public final int collectContextSize;
    public final kotlinx.coroutines.flow.b<T> collector;
    private kotlin.coroutines.c<? super q> completion;
    private CoroutineContext lastEmissionContext;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCollector(kotlinx.coroutines.flow.b<? super T> bVar, CoroutineContext coroutineContext) {
        super(h.f34461a, EmptyCoroutineContext.f34213a);
        this.collector = bVar;
        this.collectContext = coroutineContext;
        this.collectContextSize = ((Number) coroutineContext.y(0, new p<Integer, CoroutineContext.a, Integer>() { // from class: kotlinx.coroutines.flow.internal.SafeCollector$collectContextSize$1
            public final Integer b(int i10, CoroutineContext.a aVar) {
                return Integer.valueOf(i10 + 1);
            }

            @Override // v9.p
            public /* bridge */ /* synthetic */ Integer invoke(Integer num, CoroutineContext.a aVar) {
                return b(num.intValue(), aVar);
            }
        })).intValue();
    }

    public final void e(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, T t10) {
        if (coroutineContext2 instanceof f) {
            j((f) coroutineContext2, t10);
        }
        SafeCollector_commonKt.a(this, coroutineContext);
    }

    @Override // kotlinx.coroutines.flow.b
    public Object emit(T t10, kotlin.coroutines.c<? super q> cVar) {
        Object c10;
        Object c11;
        try {
            Object g10 = g(cVar, t10);
            c10 = kotlin.coroutines.intrinsics.b.c();
            if (g10 == c10) {
                C1472f.c(cVar);
            }
            c11 = kotlin.coroutines.intrinsics.b.c();
            if (g10 == c11) {
                return g10;
            }
            return q.f35511a;
        } catch (Throwable th) {
            this.lastEmissionContext = new f(th, cVar.getContext());
            throw th;
        }
    }

    public final Object g(kotlin.coroutines.c<? super q> cVar, T t10) {
        Object c10;
        CoroutineContext context = cVar.getContext();
        C1271o0.f(context);
        CoroutineContext coroutineContext = this.lastEmissionContext;
        if (coroutineContext != context) {
            e(context, coroutineContext, t10);
            this.lastEmissionContext = context;
        }
        this.completion = cVar;
        v9.q a10 = SafeCollectorKt.a();
        kotlinx.coroutines.flow.b<T> bVar = this.collector;
        kotlin.jvm.internal.i.d(bVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        kotlin.jvm.internal.i.d(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object d10 = a10.d(bVar, t10, this);
        c10 = kotlin.coroutines.intrinsics.b.c();
        if (!kotlin.jvm.internal.i.b(d10, c10)) {
            this.completion = null;
        }
        return d10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, p9.InterfaceC1469c
    public InterfaceC1469c getCallerFrame() {
        kotlin.coroutines.c<? super q> cVar = this.completion;
        if (cVar instanceof InterfaceC1469c) {
            return (InterfaceC1469c) cVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.c
    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this.lastEmissionContext;
        if (coroutineContext == null) {
            return EmptyCoroutineContext.f34213a;
        }
        return coroutineContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public Object invokeSuspend(Object obj) {
        Object c10;
        Throwable d10 = Result.d(obj);
        if (d10 != null) {
            this.lastEmissionContext = new f(d10, getContext());
        }
        kotlin.coroutines.c<? super q> cVar = this.completion;
        if (cVar != null) {
            cVar.resumeWith(obj);
        }
        c10 = kotlin.coroutines.intrinsics.b.c();
        return c10;
    }

    public final void j(f fVar, Object obj) {
        String e10;
        e10 = StringsKt__IndentKt.e("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + fVar.f34459a + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ");
        throw new IllegalStateException(e10.toString());
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
