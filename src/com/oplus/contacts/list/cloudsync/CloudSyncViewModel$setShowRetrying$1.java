package com.oplus.contacts.list.cloudsync;

import androidx.lifecycle.v;
import com.oplus.contacts.list.cloudsync.CloudSyncState;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import kotlinx.coroutines.M;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: CloudSyncViewModel.kt */
@InterfaceC1470d(c = "com.oplus.contacts.list.cloudsync.CloudSyncViewModel$setShowRetrying$1", f = "CloudSyncViewModel.kt", l = {208}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class CloudSyncViewModel$setShowRetrying$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    int label;
    final /* synthetic */ CloudSyncViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CloudSyncViewModel$setShowRetrying$1(CloudSyncViewModel cloudSyncViewModel, kotlin.coroutines.c<? super CloudSyncViewModel$setShowRetrying$1> cVar) {
        super(2, cVar);
        this.this$0 = cloudSyncViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new CloudSyncViewModel$setShowRetrying$1(this.this$0, cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        v vVar;
        v vVar2;
        boolean z10;
        v vVar3;
        boolean z11;
        v vVar4;
        boolean z12;
        c10 = kotlin.coroutines.intrinsics.b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                kotlin.b.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            kotlin.b.b(obj);
            this.label = 1;
            if (M.a(3500L, this) == c10) {
                return c10;
            }
        }
        H7.b.b("CloudSyncViewModel", "show retrying over 3.5s");
        this.this$0.f27879k = false;
        vVar = this.this$0.f27873e;
        CloudSyncState cloudSyncState = (CloudSyncState) vVar.getValue();
        if (cloudSyncState instanceof CloudSyncState.c) {
            vVar4 = this.this$0.f27873e;
            z12 = this.this$0.f27879k;
            vVar4.m(new CloudSyncState.c(z12));
        } else if (cloudSyncState instanceof CloudSyncState.e) {
            vVar3 = this.this$0.f27873e;
            z11 = this.this$0.f27879k;
            vVar3.m(new CloudSyncState.e(z11));
        } else if (cloudSyncState instanceof CloudSyncState.b) {
            vVar2 = this.this$0.f27873e;
            z10 = this.this$0.f27879k;
            vVar2.m(new CloudSyncState.b(z10, ((CloudSyncState.b) cloudSyncState).d()));
        }
        return q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((CloudSyncViewModel$setShowRetrying$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
