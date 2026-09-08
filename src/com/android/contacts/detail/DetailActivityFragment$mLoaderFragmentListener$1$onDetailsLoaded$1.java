package com.android.contacts.detail;

import com.android.contacts.ContactLoader;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC1470d;

/* compiled from: DetailActivityFragment.kt */
@InterfaceC1470d(c = "com.android.contacts.detail.DetailActivityFragment$mLoaderFragmentListener$1$onDetailsLoaded$1", f = "DetailActivityFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DetailActivityFragment$mLoaderFragmentListener$1$onDetailsLoaded$1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ ContactLoader.Result $result;
    int label;
    final /* synthetic */ DetailActivityFragment this$0;
    final /* synthetic */ DetailActivityFragment$mLoaderFragmentListener$1 this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetailActivityFragment$mLoaderFragmentListener$1$onDetailsLoaded$1(DetailActivityFragment detailActivityFragment, ContactLoader.Result result, DetailActivityFragment$mLoaderFragmentListener$1 detailActivityFragment$mLoaderFragmentListener$1, kotlin.coroutines.c<? super DetailActivityFragment$mLoaderFragmentListener$1$onDetailsLoaded$1> cVar) {
        super(2, cVar);
        this.this$0 = detailActivityFragment;
        this.$result = result;
        this.this$1 = detailActivityFragment$mLoaderFragmentListener$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new DetailActivityFragment$mLoaderFragmentListener$1$onDetailsLoaded$1(this.this$0, this.$result, this.this$1, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            z0 p32 = this.this$0.p3();
            if (p32 != null) {
                p32.V1(this.$result);
            }
            this.this$1.g(this.$result);
            return m9.q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((DetailActivityFragment$mLoaderFragmentListener$1$onDetailsLoaded$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
