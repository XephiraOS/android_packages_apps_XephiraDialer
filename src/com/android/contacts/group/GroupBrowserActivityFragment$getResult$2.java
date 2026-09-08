package com.android.contacts.group;

import androidx.fragment.app.FragmentActivity;
import com.customize.contacts.util.C0792c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.E;
import kotlinx.coroutines.J;
import kotlinx.coroutines.S;
import kotlinx.coroutines.w0;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: GroupBrowserActivityFragment.kt */
@InterfaceC1470d(c = "com.android.contacts.group.GroupBrowserActivityFragment$getResult$2", f = "GroupBrowserActivityFragment.kt", l = {1072}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class GroupBrowserActivityFragment$getResult$2 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ GroupBrowserActivityFragment $fragment;
    final /* synthetic */ String $groupName;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: GroupBrowserActivityFragment.kt */
    @InterfaceC1470d(c = "com.android.contacts.group.GroupBrowserActivityFragment$getResult$2$1", f = "GroupBrowserActivityFragment.kt", l = {1078}, m = "invokeSuspend")
    /* renamed from: com.android.contacts.group.GroupBrowserActivityFragment$getResult$2$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
        final /* synthetic */ FragmentActivity $activity;
        final /* synthetic */ J<String> $data;
        final /* synthetic */ GroupBrowserActivityFragment $fragment;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(FragmentActivity fragmentActivity, GroupBrowserActivityFragment groupBrowserActivityFragment, J<String> j10, kotlin.coroutines.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$activity = fragmentActivity;
            this.$fragment = groupBrowserActivityFragment;
            this.$data = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass1(this.$activity, this.$fragment, this.$data, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object c10;
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
                if (C0792c.c(this.$activity)) {
                    androidx.appcompat.app.b bVar = this.$fragment.f16631Y;
                    if (bVar != null) {
                        bVar.dismiss();
                    }
                    J<String> j10 = this.$data;
                    this.label = 1;
                    obj = j10.G(this);
                    if (obj == c10) {
                        return c10;
                    }
                } else {
                    return q.f35511a;
                }
            }
            String str = (String) obj;
            if (str == null) {
                this.$fragment.o3();
            } else {
                com.oplus.foundation.util.ui.c.c(this.$activity.getApplicationContext(), str);
            }
            return q.f35511a;
        }

        @Override // v9.p
        public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
            return ((AnonymousClass1) create(e10, cVar)).invokeSuspend(q.f35511a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupBrowserActivityFragment$getResult$2(GroupBrowserActivityFragment groupBrowserActivityFragment, String str, kotlin.coroutines.c<? super GroupBrowserActivityFragment$getResult$2> cVar) {
        super(2, cVar);
        this.$fragment = groupBrowserActivityFragment;
        this.$groupName = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        GroupBrowserActivityFragment$getResult$2 groupBrowserActivityFragment$getResult$2 = new GroupBrowserActivityFragment$getResult$2(this.$fragment, this.$groupName, cVar);
        groupBrowserActivityFragment$getResult$2.L$0 = obj;
        return groupBrowserActivityFragment$getResult$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        J b10;
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
            E e10 = (E) this.L$0;
            FragmentActivity activity = this.$fragment.getActivity();
            if (activity != null) {
                b10 = C1248i.b(e10, S.b(), null, new GroupBrowserActivityFragment$getResult$2$data$1(this.$fragment, this.$groupName, activity, null), 2, null);
                w0 c11 = S.c();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(activity, this.$fragment, b10, null);
                this.label = 1;
                if (C1244g.g(c11, anonymousClass1, this) == c10) {
                    return c10;
                }
            } else {
                return q.f35511a;
            }
        }
        return q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((GroupBrowserActivityFragment$getResult$2) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
