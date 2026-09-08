package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: Distinct.kt */
/* loaded from: classes4.dex */
public final class DistinctFlowImpl$collect$2<T> implements b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DistinctFlowImpl<T> f34428a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<Object> f34429b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b<T> f34430c;

    /* JADX WARN: Multi-variable type inference failed */
    public DistinctFlowImpl$collect$2(DistinctFlowImpl<T> distinctFlowImpl, Ref$ObjectRef<Object> ref$ObjectRef, b<? super T> bVar) {
        this.f34428a = distinctFlowImpl;
        this.f34429b = ref$ObjectRef;
        this.f34430c = bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(T r6, kotlin.coroutines.c<? super m9.q> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1 r0 = (kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1 r0 = new kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.b.b(r7)
            goto L67
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.b.b(r7)
            kotlinx.coroutines.flow.DistinctFlowImpl<T> r7 = r5.f34428a
            v9.l<T, java.lang.Object> r7 = r7.f34426b
            java.lang.Object r7 = r7.invoke(r6)
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r2 = r5.f34429b
            T r2 = r2.element
            kotlinx.coroutines.internal.C r4 = kotlinx.coroutines.flow.internal.j.f34464a
            if (r2 == r4) goto L58
            kotlinx.coroutines.flow.DistinctFlowImpl<T> r4 = r5.f34428a
            v9.p<java.lang.Object, java.lang.Object, java.lang.Boolean> r4 = r4.f34427c
            java.lang.Object r2 = r4.invoke(r2, r7)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L55
            goto L58
        L55:
            m9.q r5 = m9.q.f35511a
            return r5
        L58:
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r2 = r5.f34429b
            r2.element = r7
            kotlinx.coroutines.flow.b<T> r5 = r5.f34430c
            r0.label = r3
            java.lang.Object r5 = r5.emit(r6, r0)
            if (r5 != r1) goto L67
            return r1
        L67:
            m9.q r5 = m9.q.f35511a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.DistinctFlowImpl$collect$2.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }
}
