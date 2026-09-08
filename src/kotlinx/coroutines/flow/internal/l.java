package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import p9.InterfaceC1469c;

/* compiled from: ChannelFlow.kt */
/* loaded from: classes4.dex */
public final class l<T> implements kotlin.coroutines.c<T>, InterfaceC1469c {

    /* renamed from: a, reason: collision with root package name */
    public final kotlin.coroutines.c<T> f34468a;

    /* renamed from: b, reason: collision with root package name */
    public final CoroutineContext f34469b;

    /* JADX WARN: Multi-variable type inference failed */
    public l(kotlin.coroutines.c<? super T> cVar, CoroutineContext coroutineContext) {
        this.f34468a = cVar;
        this.f34469b = coroutineContext;
    }

    @Override // p9.InterfaceC1469c
    public InterfaceC1469c getCallerFrame() {
        kotlin.coroutines.c<T> cVar = this.f34468a;
        if (cVar instanceof InterfaceC1469c) {
            return (InterfaceC1469c) cVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.c
    public CoroutineContext getContext() {
        return this.f34469b;
    }

    @Override // kotlin.coroutines.c
    public void resumeWith(Object obj) {
        this.f34468a.resumeWith(obj);
    }
}
