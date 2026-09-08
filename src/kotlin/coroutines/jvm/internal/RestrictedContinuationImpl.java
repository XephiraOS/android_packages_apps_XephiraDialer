package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes4.dex */
public abstract class RestrictedContinuationImpl extends BaseContinuationImpl {
    public RestrictedContinuationImpl(c<Object> cVar) {
        super(cVar);
        if (cVar != null && cVar.getContext() != EmptyCoroutineContext.f34213a) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
        }
    }

    @Override // kotlin.coroutines.c
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.f34213a;
    }
}
