package com.android.contacts.framework.omoji.viewmodel;

import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: OmojiViewModule.kt */
@InterfaceC1470d(c = "com.android.contacts.framework.omoji.viewmodel.OmojiViewModule$getOmojiList$1$1$onResult$1", f = "OmojiViewModule.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class OmojiViewModule$getOmojiList$1$1$onResult$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ a $omojiData;
    int label;
    final /* synthetic */ OmojiViewModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OmojiViewModule$getOmojiList$1$1$onResult$1(OmojiViewModule omojiViewModule, a aVar, c<? super OmojiViewModule$getOmojiList$1$1$onResult$1> cVar) {
        super(2, cVar);
        this.this$0 = omojiViewModule;
        this.$omojiData = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new OmojiViewModule$getOmojiList$1$1$onResult$1(this.this$0, this.$omojiData, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            this.this$0.g().o(this.$omojiData);
            H7.b.e("OmojiViewModule", "getOmojiList setValue -------");
            OmojiRepository omojiRepository = OmojiRepository.f16303a;
            omojiRepository.a().c(this.$omojiData.b());
            omojiRepository.a().d(this.$omojiData.a());
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((OmojiViewModule$getOmojiList$1$1$onResult$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
