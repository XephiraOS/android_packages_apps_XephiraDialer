package com.android.contacts.detail;

import android.content.Context;
import com.android.contacts.ContactShortcuts;
import java.util.Map;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC1470d;

/* compiled from: DetailActivityFragment.kt */
@InterfaceC1470d(c = "com.android.contacts.detail.DetailActivityFragment$showCreateContactsShortcut$1", f = "DetailActivityFragment.kt", l = {2189}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DetailActivityFragment$showCreateContactsShortcut$1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    int label;
    final /* synthetic */ DetailActivityFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetailActivityFragment$showCreateContactsShortcut$1(DetailActivityFragment detailActivityFragment, kotlin.coroutines.c<? super DetailActivityFragment$showCreateContactsShortcut$1> cVar) {
        super(2, cVar);
        this.this$0 = detailActivityFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new DetailActivityFragment$showCreateContactsShortcut$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        Map b10;
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
            ContactShortcuts contactShortcuts = ContactShortcuts.f13087j;
            long j10 = this.this$0.f14422W;
            this.label = 1;
            if (contactShortcuts.B(j10, this) == c10) {
                return c10;
            }
        }
        Context requireContext = this.this$0.requireContext();
        b10 = kotlin.collections.D.b(m9.g.a("click_send_desk", "detail"));
        com.android.contacts.framework.baseui.util.A.a(requireContext, 2000309, 200032616, b10, false);
        return m9.q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((DetailActivityFragment$showCreateContactsShortcut$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
