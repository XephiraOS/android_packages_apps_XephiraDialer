package com.android.contacts.business.calllog.breenocall.summary;

import android.content.Context;
import com.android.contacts.business.calllog.breenocall.summary.AutoCallSummaryTipManager;
import com.android.contacts.framework.baseui.util.t;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.E;
import kotlinx.coroutines.S;
import kotlinx.coroutines.w0;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: AutoCallSummaryTipManager.kt */
@InterfaceC1470d(c = "com.android.contacts.business.calllog.breenocall.summary.AutoCallSummaryTipManager$asyncLoad$1", f = "AutoCallSummaryTipManager.kt", l = {100}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AutoCallSummaryTipManager$asyncLoad$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ ArrayList<String> $normalizedNumbers;
    final /* synthetic */ ArrayList<String> $numbers;
    int label;
    final /* synthetic */ AutoCallSummaryTipManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoCallSummaryTipManager$asyncLoad$1(AutoCallSummaryTipManager autoCallSummaryTipManager, ArrayList<String> arrayList, ArrayList<String> arrayList2, kotlin.coroutines.c<? super AutoCallSummaryTipManager$asyncLoad$1> cVar) {
        super(2, cVar);
        this.this$0 = autoCallSummaryTipManager;
        this.$numbers = arrayList;
        this.$normalizedNumbers = arrayList2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new AutoCallSummaryTipManager$asyncLoad$1(this.this$0, this.$numbers, this.$normalizedNumbers, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        boolean z10;
        Context context;
        ArrayList loadNumbersSummaryState;
        t tVar;
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
            this.this$0.inSuperPowerSaveMode = L7.a.c();
            z10 = this.this$0.inSuperPowerSaveMode;
            if (!z10) {
                AutoCallSummaryTipManager.Companion companion = AutoCallSummaryTipManager.Companion;
                context = this.this$0.context;
                loadNumbersSummaryState = companion.loadNumbersSummaryState(context, this.$numbers, this.$normalizedNumbers);
                tVar = this.this$0.simpleCallback;
                if (tVar != null) {
                    AutoCallSummaryTipManager autoCallSummaryTipManager = this.this$0;
                    ArrayList<String> arrayList = this.$numbers;
                    ArrayList<String> arrayList2 = this.$normalizedNumbers;
                    w0 c11 = S.c();
                    AutoCallSummaryTipManager$asyncLoad$1$1$1 autoCallSummaryTipManager$asyncLoad$1$1$1 = new AutoCallSummaryTipManager$asyncLoad$1$1$1(autoCallSummaryTipManager, arrayList, loadNumbersSummaryState, arrayList2, tVar, null);
                    this.label = 1;
                    if (C1244g.g(c11, autoCallSummaryTipManager$asyncLoad$1$1$1, this) == c10) {
                        return c10;
                    }
                }
            }
        }
        return q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((AutoCallSummaryTipManager$asyncLoad$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
