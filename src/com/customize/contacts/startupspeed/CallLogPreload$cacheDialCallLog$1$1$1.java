package com.customize.contacts.startupspeed;

import android.database.Cursor;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: CallLogPreload.kt */
@InterfaceC1470d(c = "com.customize.contacts.startupspeed.CallLogPreload$cacheDialCallLog$1$1$1", f = "CallLogPreload.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class CallLogPreload$cacheDialCallLog$1$1$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ Ref$ObjectRef<Cursor> $cursor;
    final /* synthetic */ com.android.contacts.framework.baseui.calllog.b $partGroupHandler;
    int label;
    final /* synthetic */ CallLogPreload this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallLogPreload$cacheDialCallLog$1$1$1(CallLogPreload callLogPreload, Ref$ObjectRef<Cursor> ref$ObjectRef, com.android.contacts.framework.baseui.calllog.b bVar, kotlin.coroutines.c<? super CallLogPreload$cacheDialCallLog$1$1$1> cVar) {
        super(2, cVar);
        this.this$0 = callLogPreload;
        this.$cursor = ref$ObjectRef;
        this.$partGroupHandler = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new CallLogPreload$cacheDialCallLog$1$1$1(this.this$0, this.$cursor, this.$partGroupHandler, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            this.this$0.c(this.$cursor.element, this.$partGroupHandler);
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((CallLogPreload$cacheDialCallLog$1$1$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
