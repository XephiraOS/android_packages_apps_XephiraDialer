package com.android.contacts.util;

import com.android.contacts.util.A;
import java.util.List;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import p9.InterfaceC1470d;

/* compiled from: ContentAssociateCreator.kt */
@InterfaceC1470d(c = "com.android.contacts.util.ContentAssociateCreator$tryShowAssociateWindow$1$1$1", f = "ContentAssociateCreator.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ContentAssociateCreator$tryShowAssociateWindow$1$1$1 extends SuspendLambda implements v9.p<E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ List<A.b> $similarContact;
    int label;
    final /* synthetic */ ContentAssociateCreator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentAssociateCreator$tryShowAssociateWindow$1$1$1(ContentAssociateCreator contentAssociateCreator, List<A.b> list, kotlin.coroutines.c<? super ContentAssociateCreator$tryShowAssociateWindow$1$1$1> cVar) {
        super(2, cVar);
        this.this$0 = contentAssociateCreator;
        this.$similarContact = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new ContentAssociateCreator$tryShowAssociateWindow$1$1$1(this.this$0, this.$similarContact, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            this.this$0.B(this.$similarContact);
            return m9.q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((ContentAssociateCreator$tryShowAssociateWindow$1$1$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
