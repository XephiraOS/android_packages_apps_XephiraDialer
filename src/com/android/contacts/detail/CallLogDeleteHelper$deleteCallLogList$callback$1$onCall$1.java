package com.android.contacts.detail;

import androidx.activity.ComponentActivity;
import com.oplus.dialer.R;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC1470d;

/* compiled from: CallLogDeleteHelper.kt */
@InterfaceC1470d(c = "com.android.contacts.detail.CallLogDeleteHelper$deleteCallLogList$callback$1$onCall$1", f = "CallLogDeleteHelper.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class CallLogDeleteHelper$deleteCallLogList$callback$1$onCall$1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ ComponentActivity $context;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallLogDeleteHelper$deleteCallLogList$callback$1$onCall$1(ComponentActivity componentActivity, kotlin.coroutines.c<? super CallLogDeleteHelper$deleteCallLogList$callback$1$onCall$1> cVar) {
        super(2, cVar);
        this.$context = componentActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new CallLogDeleteHelper$deleteCallLogList$callback$1$onCall$1(this.$context, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            com.oplus.foundation.util.ui.c.d(this.$context, R.string.call_recording_file_not_delete);
            return m9.q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((CallLogDeleteHelper$deleteCallLogList$callback$1$onCall$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
