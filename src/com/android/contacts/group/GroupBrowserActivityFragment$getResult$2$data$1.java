package com.android.contacts.group;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.oplus.dialer.R;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: GroupBrowserActivityFragment.kt */
@InterfaceC1470d(c = "com.android.contacts.group.GroupBrowserActivityFragment$getResult$2$data$1", f = "GroupBrowserActivityFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class GroupBrowserActivityFragment$getResult$2$data$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super String>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ GroupBrowserActivityFragment $fragment;
    final /* synthetic */ String $groupName;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupBrowserActivityFragment$getResult$2$data$1(GroupBrowserActivityFragment groupBrowserActivityFragment, String str, FragmentActivity fragmentActivity, kotlin.coroutines.c<? super GroupBrowserActivityFragment$getResult$2$data$1> cVar) {
        super(2, cVar);
        this.$fragment = groupBrowserActivityFragment;
        this.$groupName = str;
        this.$activity = fragmentActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new GroupBrowserActivityFragment$getResult$2$data$1(this.$fragment, this.$groupName, this.$activity, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            this.$fragment.f16618L = true;
            if (TextUtils.isEmpty(this.$groupName)) {
                return this.$activity.getApplicationContext().getString(R.string.oplus_group_name_cannot_be_empty);
            }
            if (N3.b.m(this.$activity.getApplicationContext(), this.$groupName, this.$fragment.f16617K)) {
                return this.$activity.getApplicationContext().getString(R.string.oplus_group_name_exist);
            }
            return null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super String> cVar) {
        return ((GroupBrowserActivityFragment$getResult$2$data$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
