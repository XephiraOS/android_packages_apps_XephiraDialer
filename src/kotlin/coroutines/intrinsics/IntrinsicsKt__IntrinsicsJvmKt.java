package kotlin.coroutines.intrinsics;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.n;
import m9.q;
import p9.C1472f;
import v9.p;

/* compiled from: IntrinsicsJvm.kt */
/* loaded from: classes4.dex */
public class IntrinsicsKt__IntrinsicsJvmKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static <R, T> c<q> a(final p<? super R, ? super c<? super T>, ? extends Object> pVar, final R r10, c<? super T> completion) {
        i.f(pVar, "<this>");
        i.f(completion, "completion");
        final c<?> a10 = C1472f.a(completion);
        if (pVar instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) pVar).create(r10, a10);
        }
        final CoroutineContext context = a10.getContext();
        if (context == EmptyCoroutineContext.f34213a) {
            return new RestrictedContinuationImpl(a10, pVar, r10) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3
                final /* synthetic */ Object $receiver$inlined;
                final /* synthetic */ p $this_createCoroutineUnintercepted$inlined;
                private int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(a10);
                    this.$this_createCoroutineUnintercepted$inlined = pVar;
                    this.$receiver$inlined = r10;
                    i.d(a10, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public Object invokeSuspend(Object obj) {
                    int i10 = this.label;
                    if (i10 != 0) {
                        if (i10 == 1) {
                            this.label = 2;
                            kotlin.b.b(obj);
                            return obj;
                        }
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                    this.label = 1;
                    kotlin.b.b(obj);
                    i.d(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                    return ((p) n.b(this.$this_createCoroutineUnintercepted$inlined, 2)).invoke(this.$receiver$inlined, this);
                }
            };
        }
        return new ContinuationImpl(a10, context, pVar, r10) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4
            final /* synthetic */ Object $receiver$inlined;
            final /* synthetic */ p $this_createCoroutineUnintercepted$inlined;
            private int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(a10, context);
                this.$this_createCoroutineUnintercepted$inlined = pVar;
                this.$receiver$inlined = r10;
                i.d(a10, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public Object invokeSuspend(Object obj) {
                int i10 = this.label;
                if (i10 != 0) {
                    if (i10 == 1) {
                        this.label = 2;
                        kotlin.b.b(obj);
                        return obj;
                    }
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 1;
                kotlin.b.b(obj);
                i.d(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((p) n.b(this.$this_createCoroutineUnintercepted$inlined, 2)).invoke(this.$receiver$inlined, this);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> c<T> b(c<? super T> cVar) {
        ContinuationImpl continuationImpl;
        c<T> cVar2;
        i.f(cVar, "<this>");
        if (cVar instanceof ContinuationImpl) {
            continuationImpl = (ContinuationImpl) cVar;
        } else {
            continuationImpl = null;
        }
        if (continuationImpl != null && (cVar2 = (c<T>) continuationImpl.intercepted()) != null) {
            return cVar2;
        }
        return cVar;
    }
}
