package com.android.contacts.framework.baseui.util;

import android.content.Context;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC1470d;

/* compiled from: NotificationUtils.kt */
@InterfaceC1470d(c = "com.android.contacts.framework.baseui.util.NotificationUtilsKt$cancelNumberRecognitionNotification$1", f = "NotificationUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class NotificationUtilsKt$cancelNumberRecognitionNotification$1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ Context $context;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationUtilsKt$cancelNumberRecognitionNotification$1(Context context, kotlin.coroutines.c<? super NotificationUtilsKt$cancelNumberRecognitionNotification$1> cVar) {
        super(2, cVar);
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        NotificationUtilsKt$cancelNumberRecognitionNotification$1 notificationUtilsKt$cancelNumberRecognitionNotification$1 = new NotificationUtilsKt$cancelNumberRecognitionNotification$1(this.$context, cVar);
        notificationUtilsKt$cancelNumberRecognitionNotification$1.L$0 = obj;
        return notificationUtilsKt$cancelNumberRecognitionNotification$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object b10;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            Context context = this.$context;
            try {
                Result.a aVar = Result.f34166a;
                androidx.core.app.i.c(context).a("number_recognition", 1);
                NotificationUtilsKt.f15870a = false;
                b10 = Result.b(m9.q.f35511a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.c("NotificationUtils", "cancelNumberRecognitionNotification: " + d10 + " " + d10.getMessage());
            }
            return m9.q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((NotificationUtilsKt$cancelNumberRecognitionNotification$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
