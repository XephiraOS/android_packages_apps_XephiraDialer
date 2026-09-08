package com.android.contacts.scenecard;

import F0.c;
import com.customize.contacts.util.C0801l;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.C1467a;
import p9.InterfaceC1470d;

/* compiled from: SceneDialPadViewController.kt */
@InterfaceC1470d(c = "com.android.contacts.scenecard.SceneDialPadViewController$preQueryNumberInfo$1", f = "SceneDialPadViewController.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SceneDialPadViewController$preQueryNumberInfo$1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ String $number;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SceneDialPadViewController$preQueryNumberInfo$1(String str, kotlin.coroutines.c<? super SceneDialPadViewController$preQueryNumberInfo$1> cVar) {
        super(2, cVar);
        this.$number = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        SceneDialPadViewController$preQueryNumberInfo$1 sceneDialPadViewController$preQueryNumberInfo$1 = new SceneDialPadViewController$preQueryNumberInfo$1(this.$number, cVar);
        sceneDialPadViewController$preQueryNumberInfo$1.L$0 = obj;
        return sceneDialPadViewController$preQueryNumberInfo$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            String str = this.$number;
            try {
                Result.a aVar = Result.f34166a;
                if (B3.a.u()) {
                    E0.b.F(new c.a().h(str).c(C1467a.d(2)).e(C1467a.e(0L)).j(C1467a.d(0)).i(C1467a.e(System.currentTimeMillis())).k(C1467a.d(-1)).f(C1467a.a(true)).b(C1467a.a(C0801l.o(2))).a());
                }
                Result.b(m9.q.f35511a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                Result.b(kotlin.b.a(th));
            }
            return m9.q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((SceneDialPadViewController$preQueryNumberInfo$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
