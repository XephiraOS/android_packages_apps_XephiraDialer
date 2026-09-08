package com.android.contacts.scenecard;

import android.content.Context;
import com.customize.contacts.util.C0801l;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC1470d;

/* compiled from: SceneDialtactsFragment.kt */
@InterfaceC1470d(c = "com.android.contacts.scenecard.SceneDialtactsFragment$SceneDialtactsHandler$handleMessage$1$1", f = "SceneDialtactsFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SceneDialtactsFragment$SceneDialtactsHandler$handleMessage$1$1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ Context $it;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SceneDialtactsFragment$SceneDialtactsHandler$handleMessage$1$1(Context context, kotlin.coroutines.c<? super SceneDialtactsFragment$SceneDialtactsHandler$handleMessage$1$1> cVar) {
        super(2, cVar);
        this.$it = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new SceneDialtactsFragment$SceneDialtactsHandler$handleMessage$1$1(this.$it, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            C0801l.d(this.$it);
            return m9.q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((SceneDialtactsFragment$SceneDialtactsHandler$handleMessage$1$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
