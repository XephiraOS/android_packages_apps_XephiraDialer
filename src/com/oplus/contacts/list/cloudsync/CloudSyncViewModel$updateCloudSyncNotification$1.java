package com.oplus.contacts.list.cloudsync;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.InterfaceC1637a;
import v9.p;

/* compiled from: CloudSyncViewModel.kt */
@InterfaceC1470d(c = "com.oplus.contacts.list.cloudsync.CloudSyncViewModel$updateCloudSyncNotification$1", f = "CloudSyncViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class CloudSyncViewModel$updateCloudSyncNotification$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ InterfaceC1637a<q> $callbackFunc;
    int label;
    final /* synthetic */ CloudSyncViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CloudSyncViewModel$updateCloudSyncNotification$1(CloudSyncViewModel cloudSyncViewModel, InterfaceC1637a<q> interfaceC1637a, kotlin.coroutines.c<? super CloudSyncViewModel$updateCloudSyncNotification$1> cVar) {
        super(2, cVar);
        this.this$0 = cloudSyncViewModel;
        this.$callbackFunc = interfaceC1637a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new CloudSyncViewModel$updateCloudSyncNotification$1(this.this$0, this.$callbackFunc, cVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c2, code lost:
    
        if (r6.equals("6->2") == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00cb, code lost:
    
        if (r6.equals("5->2") == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e5, code lost:
    
        if (r6.equals("1->5") == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0122, code lost:
    
        if (r6.equals("1->3") == false) goto L46;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.contacts.list.cloudsync.CloudSyncViewModel$updateCloudSyncNotification$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((CloudSyncViewModel$updateCloudSyncNotification$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
