package com.android.contacts.scenecard;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.C1467a;
import p9.InterfaceC1470d;

/* compiled from: SceneDialPadViewController.kt */
@InterfaceC1470d(c = "com.android.contacts.scenecard.SceneDialPadViewController$refreshDialSwitchState$1$1", f = "SceneDialPadViewController.kt", l = {874}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SceneDialPadViewController$refreshDialSwitchState$1$1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ int $newSilkType;
    int label;
    final /* synthetic */ SceneDialPadViewController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SceneDialPadViewController$refreshDialSwitchState$1$1(SceneDialPadViewController sceneDialPadViewController, int i10, kotlin.coroutines.c<? super SceneDialPadViewController$refreshDialSwitchState$1$1> cVar) {
        super(2, cVar);
        this.this$0 = sceneDialPadViewController;
        this.$newSilkType = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new SceneDialPadViewController$refreshDialSwitchState$1$1(this.this$0, this.$newSilkType, cVar);
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
            iVar = this.this$0.f17162f;
            Integer d10 = C1467a.d(this.$newSilkType);
            this.label = 1;
            if (iVar.emit(d10, this) == c10) {
                return c10;
            }
        }
        return m9.q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((SceneDialPadViewController$refreshDialSwitchState$1$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
