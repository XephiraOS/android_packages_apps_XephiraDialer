package com.android.contacts.group.viewmodel;

import androidx.lifecycle.v;
import com.android.contacts.group.j;
import com.android.contacts.group.model.GroupBrowseListRepository;
import java.util.List;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: GroupBrowseListViewModel.kt */
@InterfaceC1470d(c = "com.android.contacts.group.viewmodel.GroupBrowseListViewModel$loadAccountGroups$1", f = "GroupBrowseListViewModel.kt", l = {58}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class GroupBrowseListViewModel$loadAccountGroups$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    int label;
    final /* synthetic */ GroupBrowseListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupBrowseListViewModel$loadAccountGroups$1(GroupBrowseListViewModel groupBrowseListViewModel, c<? super GroupBrowseListViewModel$loadAccountGroups$1> cVar) {
        super(2, cVar);
        this.this$0 = groupBrowseListViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new GroupBrowseListViewModel$loadAccountGroups$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        GroupBrowseListRepository groupBrowseListRepository;
        c10 = b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                kotlin.b.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            kotlin.b.b(obj);
            groupBrowseListRepository = this.this$0.f16707d;
            this.label = 1;
            obj = groupBrowseListRepository.a(this);
            if (obj == c10) {
                return c10;
            }
        }
        List<j> list = (List) obj;
        v<List<j>> h10 = this.this$0.h();
        i.c(list);
        h10.m(list);
        return q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((GroupBrowseListViewModel$loadAccountGroups$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
