package com.android.contacts.business.calllog.breenocall.summary;

import com.android.contacts.framework.baseui.util.t;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: AutoCallSummaryTipManager.kt */
@InterfaceC1470d(c = "com.android.contacts.business.calllog.breenocall.summary.AutoCallSummaryTipManager$asyncLoad$1$1$1", f = "AutoCallSummaryTipManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AutoCallSummaryTipManager$asyncLoad$1$1$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ ArrayList<AutoCallSummaryEntity> $entities;
    final /* synthetic */ t $it;
    final /* synthetic */ ArrayList<String> $normalizedNumbers;
    final /* synthetic */ ArrayList<String> $numbers;
    int label;
    final /* synthetic */ AutoCallSummaryTipManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoCallSummaryTipManager$asyncLoad$1$1$1(AutoCallSummaryTipManager autoCallSummaryTipManager, ArrayList<String> arrayList, ArrayList<AutoCallSummaryEntity> arrayList2, ArrayList<String> arrayList3, t tVar, kotlin.coroutines.c<? super AutoCallSummaryTipManager$asyncLoad$1$1$1> cVar) {
        super(2, cVar);
        this.this$0 = autoCallSummaryTipManager;
        this.$numbers = arrayList;
        this.$entities = arrayList2;
        this.$normalizedNumbers = arrayList3;
        this.$it = tVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new AutoCallSummaryTipManager$asyncLoad$1$1$1(this.this$0, this.$numbers, this.$entities, this.$normalizedNumbers, this.$it, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            this.this$0.update(this.$numbers, this.$entities, this.$normalizedNumbers);
            t.a.a(this.$it, this.this$0.isShowCallSummaryTip() ? 1 : 0, null, null, 4, null);
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((AutoCallSummaryTipManager$asyncLoad$1$1$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
