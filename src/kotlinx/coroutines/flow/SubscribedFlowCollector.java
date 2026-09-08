package kotlinx.coroutines.flow;

import m9.q;

/* compiled from: Share.kt */
/* loaded from: classes4.dex */
public final class SubscribedFlowCollector<T> implements b<T> {

    /* renamed from: a, reason: collision with root package name */
    public final b<T> f34438a;

    /* renamed from: b, reason: collision with root package name */
    public final v9.p<b<? super T>, kotlin.coroutines.c<? super q>, Object> f34439b;

    /* JADX WARN: Removed duplicated region for block: B:21:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(kotlin.coroutines.c<? super m9.q> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1 r0 = (kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1 r0 = new kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.c()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.b.b(r8)
            goto L7a
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.flow.internal.SafeCollector r7 = (kotlinx.coroutines.flow.internal.SafeCollector) r7
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.SubscribedFlowCollector r2 = (kotlinx.coroutines.flow.SubscribedFlowCollector) r2
            kotlin.b.b(r8)     // Catch: java.lang.Throwable -> L40
            goto L61
        L40:
            r8 = move-exception
            goto L84
        L42:
            kotlin.b.b(r8)
            kotlinx.coroutines.flow.internal.SafeCollector r8 = new kotlinx.coroutines.flow.internal.SafeCollector
            kotlinx.coroutines.flow.b<T> r2 = r7.f34438a
            kotlin.coroutines.CoroutineContext r5 = r0.getContext()
            r8.<init>(r2, r5)
            v9.p<kotlinx.coroutines.flow.b<? super T>, kotlin.coroutines.c<? super m9.q>, java.lang.Object> r2 = r7.f34439b     // Catch: java.lang.Throwable -> L80
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L80
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L80
            r0.label = r4     // Catch: java.lang.Throwable -> L80
            java.lang.Object r2 = r2.invoke(r8, r0)     // Catch: java.lang.Throwable -> L80
            if (r2 != r1) goto L5f
            return r1
        L5f:
            r2 = r7
            r7 = r8
        L61:
            r7.releaseIntercepted()
            kotlinx.coroutines.flow.b<T> r7 = r2.f34438a
            boolean r8 = r7 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector
            if (r8 == 0) goto L7d
            kotlinx.coroutines.flow.SubscribedFlowCollector r7 = (kotlinx.coroutines.flow.SubscribedFlowCollector) r7
            r8 = 0
            r0.L$0 = r8
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r7 = r7.a(r0)
            if (r7 != r1) goto L7a
            return r1
        L7a:
            m9.q r7 = m9.q.f35511a
            return r7
        L7d:
            m9.q r7 = m9.q.f35511a
            return r7
        L80:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L84:
            r7.releaseIntercepted()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SubscribedFlowCollector.a(kotlin.coroutines.c):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.b
    public Object emit(T t10, kotlin.coroutines.c<? super q> cVar) {
        return this.f34438a.emit(t10, cVar);
    }
}
