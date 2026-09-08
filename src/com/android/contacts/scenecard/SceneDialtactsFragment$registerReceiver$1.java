package com.android.contacts.scenecard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC1470d;

/* compiled from: SceneDialtactsFragment.kt */
@InterfaceC1470d(c = "com.android.contacts.scenecard.SceneDialtactsFragment$registerReceiver$1", f = "SceneDialtactsFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SceneDialtactsFragment$registerReceiver$1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    int label;
    final /* synthetic */ SceneDialtactsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SceneDialtactsFragment$registerReceiver$1(SceneDialtactsFragment sceneDialtactsFragment, kotlin.coroutines.c<? super SceneDialtactsFragment$registerReceiver$1> cVar) {
        super(2, cVar);
        this.this$0 = sceneDialtactsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new SceneDialtactsFragment$registerReceiver$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BroadcastReceiver broadcastReceiver;
        Object b10;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.oplus.contacts.display_settings_changed");
            intentFilter.addAction("com.oplus.contacts.DETAIL_UPDATE_DONE");
            intentFilter.addAction("com.oplus.contacts.force_refresh_calllog");
            broadcastReceiver = this.this$0.f17223r;
            Context context = this.this$0.getContext();
            if (broadcastReceiver != null && context != null) {
                try {
                    Result.a aVar = Result.f34166a;
                    X.a b11 = X.a.b(context);
                    kotlin.jvm.internal.i.e(b11, "getInstance(context)");
                    b11.c(broadcastReceiver, intentFilter);
                    b10 = Result.b(m9.q.f35511a);
                } catch (Throwable th) {
                    Result.a aVar2 = Result.f34166a;
                    b10 = Result.b(kotlin.b.a(th));
                }
                Throwable d10 = Result.d(b10);
                if (d10 != null) {
                    H7.b.c("SceneDialtactsFragment", "Exception: " + d10);
                }
                Result.a(b10);
            }
            return m9.q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((SceneDialtactsFragment$registerReceiver$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
