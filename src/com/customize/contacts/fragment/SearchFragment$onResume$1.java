package com.customize.contacts.fragment;

import com.coui.appcompat.searchview.COUISearchBar;
import com.coui.appcompat.toolbar.COUIActionMenuView;
import com.coui.appcompat.toolbar.COUIToolbar;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC1470d;

/* compiled from: SearchFragment.kt */
@InterfaceC1470d(c = "com.customize.contacts.fragment.SearchFragment$onResume$1", f = "SearchFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class SearchFragment$onResume$1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    int label;
    final /* synthetic */ SearchFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchFragment$onResume$1(SearchFragment searchFragment, kotlin.coroutines.c<? super SearchFragment$onResume$1> cVar) {
        super(2, cVar);
        this.this$0 = searchFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new SearchFragment$onResume$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        COUISearchBar cOUISearchBar;
        COUIToolbar cOUIToolbar;
        COUIActionMenuView cOUIActionMenuView;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            cOUISearchBar = this.this$0.f34972l;
            if (cOUISearchBar != null) {
                cOUISearchBar.changeStateImmediately(1);
            }
            cOUIToolbar = this.this$0.f35048T0;
            if (cOUIToolbar != null) {
                cOUIActionMenuView = cOUIToolbar.getMenuView();
            } else {
                cOUIActionMenuView = null;
            }
            if (cOUIActionMenuView != null) {
                cOUIActionMenuView.setVisibility(8);
            }
            return m9.q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((SearchFragment$onResume$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
