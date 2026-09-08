package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.E;
import kotlinx.coroutines.InterfaceC1265l0;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: Merge.kt */
@InterfaceC1470d(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3", f = "Merge.kt", l = {27}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class ChannelFlowTransformLatest$flowCollect$3 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.b<R> $collector;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChannelFlowTransformLatest<T, R> this$0;

    /* compiled from: Merge.kt */
    /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<InterfaceC1265l0> f34445a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ E f34446b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ChannelFlowTransformLatest<T, R> f34447c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.flow.b<R> f34448d;

        /* compiled from: Merge.kt */
        @InterfaceC1470d(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2", f = "Merge.kt", l = {34}, m = "invokeSuspend")
        /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2, reason: invalid class name */
        /* loaded from: classes4.dex */
        public static final class AnonymousClass2 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
            final /* synthetic */ kotlinx.coroutines.flow.b<R> $collector;
            final /* synthetic */ T $value;
            int label;
            final /* synthetic */ ChannelFlowTransformLatest<T, R> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass2(ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, kotlinx.coroutines.flow.b<? super R> bVar, T t10, kotlin.coroutines.c<? super AnonymousClass2> cVar) {
                super(2, cVar);
                this.this$0 = channelFlowTransformLatest;
                this.$collector = bVar;
                this.$value = t10;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new AnonymousClass2(this.this$0, this.$collector, this.$value, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object c10;
                v9.q qVar;
                c10 = kotlin.coroutines.intrinsics.b.c();
                int i10 = this.label;
                if (i10 != 0) {
                    if (i10 == 1) {
                        kotlin.b.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    kotlin.b.b(obj);
                    qVar = this.this$0.f34444e;
                    Object obj2 = this.$collector;
                    T t10 = this.$value;
                    this.label = 1;
                    if (qVar.d(obj2, t10, this) == c10) {
                        return c10;
                    }
                }
                return q.f35511a;
            }

            @Override // v9.p
            public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
                return ((AnonymousClass2) create(e10, cVar)).invokeSuspend(q.f35511a);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Ref$ObjectRef<InterfaceC1265l0> ref$ObjectRef, E e10, ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, kotlinx.coroutines.flow.b<? super R> bVar) {
            this.f34445a = ref$ObjectRef;
            this.f34446b = e10;
            this.f34447c = channelFlowTransformLatest;
            this.f34448d = bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @Override // kotlinx.coroutines.flow.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(T r7, kotlin.coroutines.c<? super m9.q> r8) {
            /*
                r6 = this;
                boolean r0 = r8 instanceof kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1
                if (r0 == 0) goto L13
                r0 = r8
                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1
                r0.<init>(r6, r8)
            L18:
                java.lang.Object r8 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.c()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L3b
                if (r2 != r3) goto L33
                java.lang.Object r6 = r0.L$2
                kotlinx.coroutines.l0 r6 = (kotlinx.coroutines.InterfaceC1265l0) r6
                java.lang.Object r7 = r0.L$1
                java.lang.Object r6 = r0.L$0
                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1 r6 = (kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3.AnonymousClass1) r6
                kotlin.b.b(r8)
                goto L5d
            L33:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L3b:
                kotlin.b.b(r8)
                kotlin.jvm.internal.Ref$ObjectRef<kotlinx.coroutines.l0> r8 = r6.f34445a
                T r8 = r8.element
                kotlinx.coroutines.l0 r8 = (kotlinx.coroutines.InterfaceC1265l0) r8
                if (r8 == 0) goto L5d
                kotlinx.coroutines.flow.internal.ChildCancelledException r2 = new kotlinx.coroutines.flow.internal.ChildCancelledException
                r2.<init>()
                r8.e(r2)
                r0.L$0 = r6
                r0.L$1 = r7
                r0.L$2 = r8
                r0.label = r3
                java.lang.Object r8 = r8.u(r0)
                if (r8 != r1) goto L5d
                return r1
            L5d:
                kotlin.jvm.internal.Ref$ObjectRef<kotlinx.coroutines.l0> r8 = r6.f34445a
                kotlinx.coroutines.E r0 = r6.f34446b
                kotlinx.coroutines.CoroutineStart r2 = kotlinx.coroutines.CoroutineStart.UNDISPATCHED
                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2 r3 = new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2
                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest<T, R> r1 = r6.f34447c
                kotlinx.coroutines.flow.b<R> r6 = r6.f34448d
                r4 = 0
                r3.<init>(r1, r6, r7, r4)
                r4 = 1
                r5 = 0
                r1 = 0
                kotlinx.coroutines.l0 r6 = kotlinx.coroutines.C1244g.d(r0, r1, r2, r3, r4, r5)
                r8.element = r6
                m9.q r6 = m9.q.f35511a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowTransformLatest$flowCollect$3(ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, kotlinx.coroutines.flow.b<? super R> bVar, kotlin.coroutines.c<? super ChannelFlowTransformLatest$flowCollect$3> cVar) {
        super(2, cVar);
        this.this$0 = channelFlowTransformLatest;
        this.$collector = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        ChannelFlowTransformLatest$flowCollect$3 channelFlowTransformLatest$flowCollect$3 = new ChannelFlowTransformLatest$flowCollect$3(this.this$0, this.$collector, cVar);
        channelFlowTransformLatest$flowCollect$3.L$0 = obj;
        return channelFlowTransformLatest$flowCollect$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        c10 = kotlin.coroutines.intrinsics.b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                kotlin.b.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            kotlin.b.b(obj);
            E e10 = (E) this.L$0;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ChannelFlowTransformLatest<T, R> channelFlowTransformLatest = this.this$0;
            kotlinx.coroutines.flow.a<S> aVar = channelFlowTransformLatest.f34443d;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(ref$ObjectRef, e10, channelFlowTransformLatest, this.$collector);
            this.label = 1;
            if (aVar.collect(anonymousClass1, this) == c10) {
                return c10;
            }
        }
        return q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((ChannelFlowTransformLatest$flowCollect$3) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
