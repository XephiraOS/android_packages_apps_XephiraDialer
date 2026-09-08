package com.android.contacts.dialpad.view;

import M7.b;
import android.content.Context;
import com.customize.contacts.feature.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: DialerHeaderViewManager.kt */
@InterfaceC1470d(c = "com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowNewCallTips$2", f = "DialerHeaderViewManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DialerHeaderViewManager$tryShowNewCallTips$2 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Ref$BooleanRef $showNewCallTips;
    int label;
    final /* synthetic */ DialerHeaderViewManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialerHeaderViewManager$tryShowNewCallTips$2(Ref$BooleanRef ref$BooleanRef, DialerHeaderViewManager dialerHeaderViewManager, Context context, kotlin.coroutines.c<? super DialerHeaderViewManager$tryShowNewCallTips$2> cVar) {
        super(2, cVar);
        this.$showNewCallTips = ref$BooleanRef;
        this.this$0 = dialerHeaderViewManager;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new DialerHeaderViewManager$tryShowNewCallTips$2(this.$showNewCallTips, this.this$0, this.$context, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean S10;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            Ref$BooleanRef ref$BooleanRef = this.$showNewCallTips;
            S10 = this.this$0.S(this.$context);
            boolean z10 = false;
            if (S10) {
                a.C0202a c0202a = com.customize.contacts.feature.a.f21107a;
                Context context = this.$context;
                if (c0202a.c(context, context.getContentResolver(), "com.android.phone.newcall.enhance_notification") && b.C0045b.a(2).f1798b.a(this.$context.getContentResolver(), "isNewCallEnable", 0) != 1 && b.C0045b.a(2).f1798b.a(this.$context.getContentResolver(), "force_data_channel_control", 0) == 1 && P7.c.d(this.$context, "com.newcall", false)) {
                    z10 = true;
                }
            }
            ref$BooleanRef.element = z10;
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((DialerHeaderViewManager$tryShowNewCallTips$2) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
