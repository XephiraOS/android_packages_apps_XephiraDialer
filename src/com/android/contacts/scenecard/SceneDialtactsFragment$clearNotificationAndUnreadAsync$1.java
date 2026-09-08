package com.android.contacts.scenecard;

import R0.c;
import com.android.contacts.framework.virtualsupport.utils.GrpcUtils;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC1470d;

/* compiled from: SceneDialtactsFragment.kt */
@InterfaceC1470d(c = "com.android.contacts.scenecard.SceneDialtactsFragment$clearNotificationAndUnreadAsync$1", f = "SceneDialtactsFragment.kt", l = {332}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SceneDialtactsFragment$clearNotificationAndUnreadAsync$1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SceneDialtactsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SceneDialtactsFragment$clearNotificationAndUnreadAsync$1(SceneDialtactsFragment sceneDialtactsFragment, kotlin.coroutines.c<? super SceneDialtactsFragment$clearNotificationAndUnreadAsync$1> cVar) {
        super(2, cVar);
        this.this$0 = sceneDialtactsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        SceneDialtactsFragment$clearNotificationAndUnreadAsync$1 sceneDialtactsFragment$clearNotificationAndUnreadAsync$1 = new SceneDialtactsFragment$clearNotificationAndUnreadAsync$1(this.this$0, cVar);
        sceneDialtactsFragment$clearNotificationAndUnreadAsync$1.L$0 = obj;
        return sceneDialtactsFragment$clearNotificationAndUnreadAsync$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        Object b10;
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
            this.L$0 = (kotlinx.coroutines.E) this.L$0;
            this.label = 1;
            if (kotlinx.coroutines.M.a(800L, this) == c10) {
                return c10;
            }
        }
        SceneDialtactsFragment sceneDialtactsFragment = this.this$0;
        try {
            Result.a aVar = Result.f34166a;
            P7.a aVar2 = P7.a.f2961a;
            com.oplus.foundation.util.ui.a.a(aVar2.a(), 0);
            G0.c.p(sceneDialtactsFragment.getContext(), 0, c.a.f3195a, 0, 0, 16, null);
            com.android.contacts.framework.api.appstore.missedcall.a.a(aVar2.a());
            sceneDialtactsFragment.D1(aVar2.a().getContentResolver());
            GrpcUtils.syncClearMissedCallsOperation(aVar2.a());
            b10 = Result.b(m9.q.f35511a);
        } catch (Throwable th) {
            Result.a aVar3 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.e("SceneDialtactsFragment", "clearNotificationAndUnread " + d10 + " " + d10.getMessage());
        }
        return m9.q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((SceneDialtactsFragment$clearNotificationAndUnreadAsync$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
