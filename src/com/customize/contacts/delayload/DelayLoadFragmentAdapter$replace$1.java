package com.customize.contacts.delayload;

import androidx.fragment.app.B;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.customize.contacts.activities.ContactsTabActivity;
import com.oplus.dialer.R;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.E;
import kotlinx.coroutines.M;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: DelayLoadFragmentAdapter.kt */
@InterfaceC1470d(c = "com.customize.contacts.delayload.DelayLoadFragmentAdapter$replace$1", f = "DelayLoadFragmentAdapter.kt", l = {36}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DelayLoadFragmentAdapter$replace$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ ContactsTabActivity $activity;
    final /* synthetic */ FragmentManager $fragmentManager;
    final /* synthetic */ ContactsTabActivity.l $pagerAdapter;
    int label;
    final /* synthetic */ DelayLoadFragmentAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DelayLoadFragmentAdapter$replace$1(DelayLoadFragmentAdapter delayLoadFragmentAdapter, ContactsTabActivity contactsTabActivity, FragmentManager fragmentManager, ContactsTabActivity.l lVar, c<? super DelayLoadFragmentAdapter$replace$1> cVar) {
        super(2, cVar);
        this.this$0 = delayLoadFragmentAdapter;
        this.$activity = contactsTabActivity;
        this.$fragmentManager = fragmentManager;
        this.$pagerAdapter = lVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new DelayLoadFragmentAdapter$replace$1(this.this$0, this.$activity, this.$fragmentManager, this.$pagerAdapter, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        Object b10;
        Fragment fragment;
        String str;
        String str2;
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
            this.label = 1;
            if (M.a(50L, this) == c10) {
                return c10;
            }
        }
        DelayLoadFragmentAdapter delayLoadFragmentAdapter = this.this$0;
        ContactsTabActivity contactsTabActivity = this.$activity;
        FragmentManager fragmentManager = this.$fragmentManager;
        ContactsTabActivity.l lVar = this.$pagerAdapter;
        try {
            Result.a aVar = Result.f34166a;
            if (!delayLoadFragmentAdapter.f20948a && contactsTabActivity != null && fragmentManager != null && lVar != null) {
                B p10 = fragmentManager.p();
                i.e(p10, "fragmentManager.beginTransaction()");
                p10.r(delayLoadFragmentAdapter.f20949b);
                fragment = delayLoadFragmentAdapter.f20946c;
                delayLoadFragmentAdapter.f20949b = fragment;
                str = delayLoadFragmentAdapter.f20947d;
                p10.c(R.id.view_pager, fragment, str);
                p10.j();
                fragmentManager.i0();
                lVar.notifyDataSetChanged();
                delayLoadFragmentAdapter.f20948a = true;
                str2 = delayLoadFragmentAdapter.f20947d;
                H7.b.b("DelayLoadFragmentAdapter", "replaced tag:" + str2);
            }
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("DelayLoadFragmentAdapter", "exception" + d10);
        }
        return q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((DelayLoadFragmentAdapter$replace$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
