package com.android.contacts.scenecard;

import com.coui.appcompat.vibrateutil.VibrateUtils;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC1470d;

/* compiled from: SceneSimCardStateManager.kt */
@InterfaceC1470d(c = "com.android.contacts.scenecard.SceneSimCardStateManager$refreshSimInfo$1", f = "SceneSimCardStateManager.kt", l = {VibrateUtils.TYPE_STEPABLE_EDGE}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SceneSimCardStateManager$refreshSimInfo$1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ Y $simCardStates;
    int label;
    final /* synthetic */ SceneSimCardStateManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SceneSimCardStateManager$refreshSimInfo$1(SceneSimCardStateManager sceneSimCardStateManager, Y y10, kotlin.coroutines.c<? super SceneSimCardStateManager$refreshSimInfo$1> cVar) {
        super(2, cVar);
        this.this$0 = sceneSimCardStateManager;
        this.$simCardStates = y10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new SceneSimCardStateManager$refreshSimInfo$1(this.this$0, this.$simCardStates, cVar);
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
            iVar = this.this$0.f17236d;
            Y y10 = this.$simCardStates;
            this.label = 1;
            if (iVar.emit(y10, this) == c10) {
                return c10;
            }
        }
        return m9.q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((SceneSimCardStateManager$refreshSimInfo$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
