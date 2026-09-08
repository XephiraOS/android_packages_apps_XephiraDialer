package com.android.contacts.scenecard;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC1470d;

/* compiled from: SceneDialTextEditor.kt */
@InterfaceC1470d(c = "com.android.contacts.scenecard.SceneDialTextEditor$dialEditTextWatcher$1$afterTextChanged$2", f = "SceneDialTextEditor.kt", l = {109}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SceneDialTextEditor$dialEditTextWatcher$1$afterTextChanged$2 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    int label;
    final /* synthetic */ SceneDialTextEditor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SceneDialTextEditor$dialEditTextWatcher$1$afterTextChanged$2(SceneDialTextEditor sceneDialTextEditor, kotlin.coroutines.c<? super SceneDialTextEditor$dialEditTextWatcher$1$afterTextChanged$2> cVar) {
        super(2, cVar);
        this.this$0 = sceneDialTextEditor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new SceneDialTextEditor$dialEditTextWatcher$1$afterTextChanged$2(this.this$0, cVar);
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
            iVar = this.this$0.f17193h;
            this.label = 1;
            if (iVar.emit("", this) == c10) {
                return c10;
            }
        }
        return m9.q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((SceneDialTextEditor$dialEditTextWatcher$1$afterTextChanged$2) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
