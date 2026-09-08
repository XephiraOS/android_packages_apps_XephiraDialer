package com.android.contacts.detail;

import android.content.Context;
import com.android.contacts.ContactShortcuts;
import java.util.Map;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$IntRef;
import p9.InterfaceC1470d;

/* compiled from: DetailActivityFragment.kt */
@InterfaceC1470d(c = "com.android.contacts.detail.DetailActivityFragment$showCreateContactsShortcut$dialog$1$1", f = "DetailActivityFragment.kt", l = {2217, 2225}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DetailActivityFragment$showCreateContactsShortcut$dialog$1$1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ Ref$IntRef $callContactPos;
    final /* synthetic */ int $cancelPos;
    final /* synthetic */ int $pos;
    final /* synthetic */ int $viewContactPos;
    int label;
    final /* synthetic */ DetailActivityFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetailActivityFragment$showCreateContactsShortcut$dialog$1$1(int i10, int i11, DetailActivityFragment detailActivityFragment, Ref$IntRef ref$IntRef, int i12, kotlin.coroutines.c<? super DetailActivityFragment$showCreateContactsShortcut$dialog$1$1> cVar) {
        super(2, cVar);
        this.$pos = i10;
        this.$viewContactPos = i11;
        this.this$0 = detailActivityFragment;
        this.$callContactPos = ref$IntRef;
        this.$cancelPos = i12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new DetailActivityFragment$showCreateContactsShortcut$dialog$1$1(this.$pos, this.$viewContactPos, this.this$0, this.$callContactPos, this.$cancelPos, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        Map b10;
        Map b11;
        c10 = kotlin.coroutines.intrinsics.b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    kotlin.b.b(obj);
                    Context requireContext = this.this$0.requireContext();
                    b11 = kotlin.collections.D.b(m9.g.a("click_send_desk", "call"));
                    com.android.contacts.framework.baseui.util.A.a(requireContext, 2000309, 200032616, b11, false);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                kotlin.b.b(obj);
                Context requireContext2 = this.this$0.requireContext();
                b10 = kotlin.collections.D.b(m9.g.a("click_send_desk", "detail"));
                com.android.contacts.framework.baseui.util.A.a(requireContext2, 2000309, 200032616, b10, false);
            }
        } else {
            kotlin.b.b(obj);
            int i11 = this.$pos;
            if (i11 == this.$viewContactPos) {
                ContactShortcuts contactShortcuts = ContactShortcuts.f13087j;
                long j10 = this.this$0.f14422W;
                this.label = 1;
                if (contactShortcuts.B(j10, this) == c10) {
                    return c10;
                }
                Context requireContext22 = this.this$0.requireContext();
                b10 = kotlin.collections.D.b(m9.g.a("click_send_desk", "detail"));
                com.android.contacts.framework.baseui.util.A.a(requireContext22, 2000309, 200032616, b10, false);
            } else if (i11 == this.$callContactPos.element) {
                ContactShortcuts contactShortcuts2 = ContactShortcuts.f13087j;
                long j11 = this.this$0.f14422W;
                this.label = 2;
                if (contactShortcuts2.z(j11, this) == c10) {
                    return c10;
                }
                Context requireContext3 = this.this$0.requireContext();
                b11 = kotlin.collections.D.b(m9.g.a("click_send_desk", "call"));
                com.android.contacts.framework.baseui.util.A.a(requireContext3, 2000309, 200032616, b11, false);
            } else if (i11 == this.$cancelPos) {
                H7.b.e("DetailActivityFragment", "create shortcut cancel");
            }
        }
        return m9.q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((DetailActivityFragment$showCreateContactsShortcut$dialog$1$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
