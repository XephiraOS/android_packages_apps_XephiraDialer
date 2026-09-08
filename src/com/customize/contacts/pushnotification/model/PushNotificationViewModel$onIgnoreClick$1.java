package com.customize.contacts.pushnotification.model;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: PushNotificationViewModel.kt */
@InterfaceC1470d(c = "com.customize.contacts.pushnotification.model.PushNotificationViewModel$onIgnoreClick$1", f = "PushNotificationViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class PushNotificationViewModel$onIgnoreClick$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ c $notification;
    int label;
    final /* synthetic */ PushNotificationViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushNotificationViewModel$onIgnoreClick$1(PushNotificationViewModel pushNotificationViewModel, c cVar, kotlin.coroutines.c<? super PushNotificationViewModel$onIgnoreClick$1> cVar2) {
        super(2, cVar2);
        this.this$0 = pushNotificationViewModel;
        this.$notification = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new PushNotificationViewModel$onIgnoreClick$1(this.this$0, this.$notification, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            this.this$0.l().f(this.$notification);
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((PushNotificationViewModel$onIgnoreClick$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
