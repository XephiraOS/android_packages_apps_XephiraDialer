package com.android.contacts.util;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import p9.InterfaceC1470d;

/* compiled from: ContentAssociateCreator.kt */
@InterfaceC1470d(c = "com.android.contacts.util.ContentAssociateCreator$tryShowAssociateWindow$1", f = "ContentAssociateCreator.kt", l = {105, 121, 130}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ContentAssociateCreator$tryShowAssociateWindow$1 extends SuspendLambda implements v9.p<E, kotlin.coroutines.c<? super m9.q>, Object> {
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ContentAssociateCreator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentAssociateCreator$tryShowAssociateWindow$1(ContentAssociateCreator contentAssociateCreator, kotlin.coroutines.c<? super ContentAssociateCreator$tryShowAssociateWindow$1> cVar) {
        super(2, cVar);
        this.this$0 = contentAssociateCreator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        ContentAssociateCreator$tryShowAssociateWindow$1 contentAssociateCreator$tryShowAssociateWindow$1 = new ContentAssociateCreator$tryShowAssociateWindow$1(this.this$0, cVar);
        contentAssociateCreator$tryShowAssociateWindow$1.L$0 = obj;
        return contentAssociateCreator$tryShowAssociateWindow$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0123 A[Catch: NotFoundException -> 0x0017, TryCatch #0 {NotFoundException -> 0x0017, blocks: (B:7:0x0012, B:14:0x0032, B:16:0x011d, B:18:0x0123, B:20:0x012f, B:22:0x0138, B:26:0x003d, B:28:0x008f, B:30:0x0095, B:32:0x00a3, B:34:0x00ab, B:38:0x00b6, B:41:0x00c0, B:43:0x00d4, B:45:0x0105, B:53:0x0049, B:55:0x0058, B:57:0x0060, B:60:0x006a, B:62:0x0078), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x012f A[Catch: NotFoundException -> 0x0017, TryCatch #0 {NotFoundException -> 0x0017, blocks: (B:7:0x0012, B:14:0x0032, B:16:0x011d, B:18:0x0123, B:20:0x012f, B:22:0x0138, B:26:0x003d, B:28:0x008f, B:30:0x0095, B:32:0x00a3, B:34:0x00ab, B:38:0x00b6, B:41:0x00c0, B:43:0x00d4, B:45:0x0105, B:53:0x0049, B:55:0x0058, B:57:0x0060, B:60:0x006a, B:62:0x0078), top: B:2:0x000a }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.util.ContentAssociateCreator$tryShowAssociateWindow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((ContentAssociateCreator$tryShowAssociateWindow$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
