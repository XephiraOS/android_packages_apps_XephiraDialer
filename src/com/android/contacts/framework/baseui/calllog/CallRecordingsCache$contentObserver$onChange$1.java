package com.android.contacts.framework.baseui.calllog;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import kotlinx.coroutines.M;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: CallRecordingsCache.kt */
@InterfaceC1470d(c = "com.android.contacts.framework.baseui.calllog.CallRecordingsCache$contentObserver$onChange$1", f = "CallRecordingsCache.kt", l = {78}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class CallRecordingsCache$contentObserver$onChange$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    int label;

    public CallRecordingsCache$contentObserver$onChange$1(kotlin.coroutines.c<? super CallRecordingsCache$contentObserver$onChange$1> cVar) {
        super(2, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new CallRecordingsCache$contentObserver$onChange$1(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        boolean z10;
        boolean z11;
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
            this.label = 1;
            if (M.a(1000L, this) == c10) {
                return c10;
            }
        }
        z10 = CallRecordingsCache.f15757d;
        StringBuilder sb = new StringBuilder();
        sb.append("onChange: delay 1s to reload? ");
        sb.append(!z10);
        H7.b.e("CallRecordingsCache", sb.toString());
        z11 = CallRecordingsCache.f15757d;
        if (!z11) {
            CallRecordingsCache.f15754a.s();
        }
        CallRecordingsCache.f15761h = null;
        return q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((CallRecordingsCache$contentObserver$onChange$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
