package com.oplus.foundation.util.io;

import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: CloseableUtils.kt */
@InterfaceC1470d(c = "com.oplus.foundation.util.io.CloseableUtils$closeSilenceAsync$1", f = "CloseableUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class CloseableUtils$closeSilenceAsync$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ AutoCloseable[] $closeableOjs;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CloseableUtils$closeSilenceAsync$1(AutoCloseable[] autoCloseableArr, kotlin.coroutines.c<? super CloseableUtils$closeSilenceAsync$1> cVar) {
        super(2, cVar);
        this.$closeableOjs = autoCloseableArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new CloseableUtils$closeSilenceAsync$1(this.$closeableOjs, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object b10;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            for (AutoCloseable autoCloseable : this.$closeableOjs) {
                if (autoCloseable != null) {
                    try {
                        Result.a aVar = Result.f34166a;
                        if (H7.a.b()) {
                            H7.b.b("CloseableUtils", "it.close() -------------");
                        }
                        autoCloseable.close();
                        b10 = Result.b(q.f35511a);
                    } catch (Throwable th) {
                        Result.a aVar2 = Result.f34166a;
                        b10 = Result.b(kotlin.b.a(th));
                    }
                    Throwable d10 = Result.d(b10);
                    if (d10 != null) {
                        H7.b.c("CloseableUtils", "throwable = " + d10);
                    }
                    Result.a(b10);
                }
            }
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((CloseableUtils$closeSilenceAsync$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
