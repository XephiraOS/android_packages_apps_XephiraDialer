package com.android.contacts.framework.baseui.viewmodel;

import H7.a;
import com.android.contacts.framework.baseui.util.AiCallTranslateStateController;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.C1467a;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: TabActivityViewModel.kt */
@InterfaceC1470d(c = "com.android.contacts.framework.baseui.viewmodel.TabActivityViewModel$refreshToolbarRedDot$1", f = "TabActivityViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class TabActivityViewModel$refreshToolbarRedDot$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    int label;
    final /* synthetic */ TabActivityViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabActivityViewModel$refreshToolbarRedDot$1(TabActivityViewModel tabActivityViewModel, c<? super TabActivityViewModel$refreshToolbarRedDot$1> cVar) {
        super(2, cVar);
        this.this$0 = tabActivityViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new TabActivityViewModel$refreshToolbarRedDot$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            if (a.b()) {
                H7.b.b("TabActivityViewModel", "refreshToolbarRedDot");
            }
            this.this$0.l().m(C1467a.a(AiCallTranslateStateController.f15829b.a().f(P7.a.f2961a.a())));
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((TabActivityViewModel$refreshToolbarRedDot$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
