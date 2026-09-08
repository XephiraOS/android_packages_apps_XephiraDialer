package com.customize.contacts.manager;

import androidx.fragment.app.FragmentActivity;
import com.customize.contacts.fragment.SearchFragment;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import p9.InterfaceC1470d;

/* compiled from: MainActivitySearchManager.kt */
@InterfaceC1470d(c = "com.customize.contacts.manager.MainActivitySearchManager$cacheSearchFragment$1", f = "MainActivitySearchManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class MainActivitySearchManager$cacheSearchFragment$1 extends SuspendLambda implements v9.p<E, kotlin.coroutines.c<? super m9.q>, Object> {
    int label;
    final /* synthetic */ MainActivitySearchManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivitySearchManager$cacheSearchFragment$1(MainActivitySearchManager mainActivitySearchManager, kotlin.coroutines.c<? super MainActivitySearchManager$cacheSearchFragment$1> cVar) {
        super(2, cVar);
        this.this$0 = mainActivitySearchManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new MainActivitySearchManager$cacheSearchFragment$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            FragmentActivity g10 = this.this$0.g();
            MainActivitySearchManager mainActivitySearchManager = this.this$0;
            SearchFragment searchFragment = new SearchFragment();
            searchFragment.P3(g10);
            mainActivitySearchManager.f21518d = searchFragment;
            return m9.q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((MainActivitySearchManager$cacheSearchFragment$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
