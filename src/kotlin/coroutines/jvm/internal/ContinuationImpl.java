package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.jvm.internal.i;
import p9.C1468b;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes4.dex */
public abstract class ContinuationImpl extends BaseContinuationImpl {
    private final CoroutineContext _context;
    private transient c<Object> intercepted;

    public ContinuationImpl(c<Object> cVar, CoroutineContext coroutineContext) {
        super(cVar);
        this._context = coroutineContext;
    }

    @Override // kotlin.coroutines.c
    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this._context;
        i.c(coroutineContext);
        return coroutineContext;
    }

    public final c<Object> intercepted() {
        c<Object> cVar = this.intercepted;
        if (cVar == null) {
            d dVar = (d) getContext().a(d.f34217t);
            if (dVar == null || (cVar = dVar.l(this)) == null) {
                cVar = this;
            }
            this.intercepted = cVar;
        }
        return cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        c<?> cVar = this.intercepted;
        if (cVar != null && cVar != this) {
            CoroutineContext.a a10 = getContext().a(d.f34217t);
            i.c(a10);
            ((d) a10).g(cVar);
        }
        this.intercepted = C1468b.f36109a;
    }

    public ContinuationImpl(c<Object> cVar) {
        this(cVar, cVar != null ? cVar.getContext() : null);
    }
}
