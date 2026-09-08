package com.customize.contacts.model;

import android.content.Context;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: NewCallRepository.kt */
@InterfaceC1470d(c = "com.customize.contacts.model.NewCallRepository$loadNewCallMessage$1$1", f = "NewCallRepository.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class NewCallRepository$loadNewCallMessage$1$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ Context $it;
    final /* synthetic */ ArrayList<String> $numbers;
    int label;
    final /* synthetic */ NewCallRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewCallRepository$loadNewCallMessage$1$1(NewCallRepository newCallRepository, Context context, ArrayList<String> arrayList, kotlin.coroutines.c<? super NewCallRepository$loadNewCallMessage$1$1> cVar) {
        super(2, cVar);
        this.this$0 = newCallRepository;
        this.$it = context;
        this.$numbers = arrayList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new NewCallRepository$loadNewCallMessage$1$1(this.this$0, this.$it, this.$numbers, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0048 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:5:0x0012, B:7:0x001a, B:10:0x001f, B:12:0x0032, B:14:0x003c, B:16:0x0048, B:17:0x004c), top: B:4:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.String r0 = "numbers"
            kotlin.coroutines.intrinsics.a.c()
            int r1 = r6.label
            if (r1 != 0) goto Lb8
            kotlin.b.b(r7)
            com.customize.contacts.model.NewCallRepository r7 = r6.this$0
            android.content.Context r1 = r6.$it
            java.util.ArrayList<java.lang.String> r2 = r6.$numbers
            kotlin.Result$a r3 = kotlin.Result.f34166a     // Catch: java.lang.Throwable -> L1d
            boolean r3 = com.customize.contacts.model.NewCallRepository.e(r7, r1)     // Catch: java.lang.Throwable -> L1d
            if (r3 != 0) goto L1f
            m9.q r6 = m9.q.f35511a     // Catch: java.lang.Throwable -> L1d
            return r6
        L1d:
            r7 = move-exception
            goto L59
        L1f:
            android.os.Bundle r3 = new android.os.Bundle     // Catch: java.lang.Throwable -> L1d
            r3.<init>()     // Catch: java.lang.Throwable -> L1d
            java.util.ArrayList r2 = com.customize.contacts.model.NewCallRepository.b(r7, r2)     // Catch: java.lang.Throwable -> L1d
            r3.putStringArrayList(r0, r2)     // Catch: java.lang.Throwable -> L1d
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L1d
            r2 = 0
            if (r1 == 0) goto L45
            android.net.Uri r4 = com.customize.contacts.model.NewCallRepository.d()     // Catch: java.lang.Throwable -> L1d
            android.content.ContentProviderClient r1 = r1.acquireUnstableContentProviderClient(r4)     // Catch: java.lang.Throwable -> L1d
            if (r1 == 0) goto L45
            java.lang.String r4 = "com.newcall.messagebox.provider"
            java.lang.String r5 = "getNewCallMsgNumbers"
            android.os.Bundle r1 = r1.call(r4, r5, r2, r3)     // Catch: java.lang.Throwable -> L1d
            goto L46
        L45:
            r1 = r2
        L46:
            if (r1 == 0) goto L4c
            java.util.ArrayList r2 = r1.getStringArrayList(r0)     // Catch: java.lang.Throwable -> L1d
        L4c:
            com.customize.contacts.model.NewCallRepository.g(r7, r2)     // Catch: java.lang.Throwable -> L1d
            com.customize.contacts.model.NewCallRepository.f(r7)     // Catch: java.lang.Throwable -> L1d
            m9.q r7 = m9.q.f35511a     // Catch: java.lang.Throwable -> L1d
            java.lang.Object r7 = kotlin.Result.b(r7)     // Catch: java.lang.Throwable -> L1d
            goto L63
        L59:
            kotlin.Result$a r0 = kotlin.Result.f34166a
            java.lang.Object r7 = kotlin.b.a(r7)
            java.lang.Object r7 = kotlin.Result.b(r7)
        L63:
            java.lang.Throwable r7 = kotlin.Result.d(r7)
            java.lang.String r0 = "NewCallRepository"
            if (r7 == 0) goto L8f
            java.lang.Throwable r1 = r7.getCause()
            java.lang.String r7 = r7.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getNewCallMsgNumbers Exception "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = " "
            r2.append(r1)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            H7.b.c(r0, r7)
        L8f:
            com.customize.contacts.model.NewCallRepository r6 = r6.this$0
            java.util.ArrayList r6 = com.customize.contacts.model.NewCallRepository.c(r6)
            if (r6 == 0) goto La0
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L9e
            goto La0
        L9e:
            r6 = 0
            goto La1
        La0:
            r6 = 1
        La1:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r1 = "loadNewCallMessage existNumbers is empty "
            r7.append(r1)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            H7.b.b(r0, r6)
            m9.q r6 = m9.q.f35511a
            return r6
        Lb8:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.model.NewCallRepository$loadNewCallMessage$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((NewCallRepository$loadNewCallMessage$1$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
