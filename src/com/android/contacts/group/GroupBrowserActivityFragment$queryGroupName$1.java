package com.android.contacts.group;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: GroupBrowserActivityFragment.kt */
@InterfaceC1470d(c = "com.android.contacts.group.GroupBrowserActivityFragment$queryGroupName$1", f = "GroupBrowserActivityFragment.kt", l = {1042}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class GroupBrowserActivityFragment$queryGroupName$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ GroupBrowserActivityFragment $fragment;
    int label;
    final /* synthetic */ GroupBrowserActivityFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupBrowserActivityFragment$queryGroupName$1(GroupBrowserActivityFragment groupBrowserActivityFragment, GroupBrowserActivityFragment groupBrowserActivityFragment2, kotlin.coroutines.c<? super GroupBrowserActivityFragment$queryGroupName$1> cVar) {
        super(2, cVar);
        this.this$0 = groupBrowserActivityFragment;
        this.$fragment = groupBrowserActivityFragment2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new GroupBrowserActivityFragment$queryGroupName$1(this.this$0, this.$fragment, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        Object b32;
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
            GroupBrowserActivityFragment groupBrowserActivityFragment = this.this$0;
            GroupBrowserActivityFragment groupBrowserActivityFragment2 = this.$fragment;
            String a32 = groupBrowserActivityFragment.a3();
            this.label = 1;
            b32 = groupBrowserActivityFragment.b3(groupBrowserActivityFragment2, a32, this);
            if (b32 == c10) {
                return c10;
            }
        }
        return q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((GroupBrowserActivityFragment$queryGroupName$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
