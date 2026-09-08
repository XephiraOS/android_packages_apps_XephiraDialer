package com.android.contacts.scenecard;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC1470d;

/* compiled from: SceneSimCardStateManager.kt */
@InterfaceC1470d(c = "com.android.contacts.scenecard.SceneSimCardStateManager$wifiCallingStatusChangedListener$1$updateWifiCallingStatus$1", f = "SceneSimCardStateManager.kt", l = {115}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SceneSimCardStateManager$wifiCallingStatusChangedListener$1$updateWifiCallingStatus$1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ int $availableSimCount;
    final /* synthetic */ int $defaultSlotId;
    final /* synthetic */ boolean $isSim1WifiCalling;
    final /* synthetic */ boolean $isSim2WifiCalling;
    final /* synthetic */ boolean $isSupportVideoCall;
    int label;
    final /* synthetic */ SceneSimCardStateManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SceneSimCardStateManager$wifiCallingStatusChangedListener$1$updateWifiCallingStatus$1(int i10, boolean z10, boolean z11, boolean z12, int i11, SceneSimCardStateManager sceneSimCardStateManager, kotlin.coroutines.c<? super SceneSimCardStateManager$wifiCallingStatusChangedListener$1$updateWifiCallingStatus$1> cVar) {
        super(2, cVar);
        this.$availableSimCount = i10;
        this.$isSim1WifiCalling = z10;
        this.$isSim2WifiCalling = z11;
        this.$isSupportVideoCall = z12;
        this.$defaultSlotId = i11;
        this.this$0 = sceneSimCardStateManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new SceneSimCardStateManager$wifiCallingStatusChangedListener$1$updateWifiCallingStatus$1(this.$availableSimCount, this.$isSim1WifiCalling, this.$isSim2WifiCalling, this.$isSupportVideoCall, this.$defaultSlotId, this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        kotlinx.coroutines.flow.i iVar;
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
            H7.b.e("SceneSimCardStateManager", "availableSimCount : " + this.$availableSimCount + ", isSim1WifiCalling : " + this.$isSim1WifiCalling + ", isSim2WifiCalling: " + this.$isSim2WifiCalling + ", isSupportVideoCall : " + this.$isSupportVideoCall + ", defaultSlotId : " + this.$defaultSlotId);
            Y b10 = Y.b(this.this$0.h().getValue(), 0, null, 0L, null, 0L, 0, this.$isSim1WifiCalling, this.$isSim2WifiCalling, 63, null);
            iVar = this.this$0.f17236d;
            this.label = 1;
            if (iVar.emit(b10, this) == c10) {
                return c10;
            }
        }
        return m9.q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((SceneSimCardStateManager$wifiCallingStatusChangedListener$1$updateWifiCallingStatus$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
