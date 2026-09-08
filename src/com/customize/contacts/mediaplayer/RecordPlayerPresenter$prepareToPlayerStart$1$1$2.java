package com.customize.contacts.mediaplayer;

import android.content.Context;
import com.customize.contacts.mediaplayer.RecordPlayerPresenter;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: RecordPlayerPresenter.kt */
@InterfaceC1470d(c = "com.customize.contacts.mediaplayer.RecordPlayerPresenter$prepareToPlayerStart$1$1$2", f = "RecordPlayerPresenter.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class RecordPlayerPresenter$prepareToPlayerStart$1$1$2 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    int label;
    final /* synthetic */ RecordPlayerPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordPlayerPresenter$prepareToPlayerStart$1$1$2(RecordPlayerPresenter recordPlayerPresenter, kotlin.coroutines.c<? super RecordPlayerPresenter$prepareToPlayerStart$1$1$2> cVar) {
        super(2, cVar);
        this.this$0 = recordPlayerPresenter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new RecordPlayerPresenter$prepareToPlayerStart$1$1$2(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            H7.b.b("RecordPlayerPresenter", "prepareToPlayerStart no recording, and delete call recording.");
            Context U10 = this.this$0.U();
            str = this.this$0.f21658l;
            B3.d.a(U10, str);
            RecordPlayerPresenter.a a02 = this.this$0.a0();
            if (a02 != null) {
                str2 = this.this$0.f21658l;
                a02.a(str2);
            }
            this.this$0.f21658l = null;
            this.this$0.f21659m = null;
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((RecordPlayerPresenter$prepareToPlayerStart$1$1$2) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
