package com.oplus.blacklistapp.callintercept.settings;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.coui.appcompat.checkbox.COUICheckBox;
import com.oplus.utils.C0846g;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.E;
import kotlinx.coroutines.S;
import p9.InterfaceC1470d;

/* compiled from: CallHarassInterceptMarkedNumberFragment.kt */
@InterfaceC1470d(c = "com.oplus.blacklistapp.callintercept.settings.CallHarassInterceptMarkedNumberFragment$onMultiChoiceClick$1", f = "CallHarassInterceptMarkedNumberFragment.kt", l = {490}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class CallHarassInterceptMarkedNumberFragment$onMultiChoiceClick$1 extends SuspendLambda implements v9.p<E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ COUICheckBox $checkBox;
    final /* synthetic */ int $position;
    int label;
    final /* synthetic */ CallHarassInterceptMarkedNumberFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallHarassInterceptMarkedNumberFragment$onMultiChoiceClick$1(CallHarassInterceptMarkedNumberFragment callHarassInterceptMarkedNumberFragment, int i10, COUICheckBox cOUICheckBox, kotlin.coroutines.c<? super CallHarassInterceptMarkedNumberFragment$onMultiChoiceClick$1> cVar) {
        super(2, cVar);
        this.this$0 = callHarassInterceptMarkedNumberFragment;
        this.$position = i10;
        this.$checkBox = cOUICheckBox;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new CallHarassInterceptMarkedNumberFragment$onMultiChoiceClick$1(this.this$0, this.$position, this.$checkBox, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        ArrayList arrayList;
        String B12;
        String C12;
        int i10;
        String B13;
        String C13;
        A a10;
        c10 = kotlin.coroutines.intrinsics.b.c();
        int i11 = this.label;
        Context context = null;
        if (i11 != 0) {
            if (i11 == 1) {
                kotlin.b.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            kotlin.b.b(obj);
            CoroutineDispatcher b10 = S.b();
            CallHarassInterceptMarkedNumberFragment$onMultiChoiceClick$1$updateStrangersOff$1 callHarassInterceptMarkedNumberFragment$onMultiChoiceClick$1$updateStrangersOff$1 = new CallHarassInterceptMarkedNumberFragment$onMultiChoiceClick$1$updateStrangersOff$1(this.this$0, null);
            this.label = 1;
            obj = C1244g.g(b10, callHarassInterceptMarkedNumberFragment$onMultiChoiceClick$1$updateStrangersOff$1, this);
            if (obj == c10) {
                return c10;
            }
        }
        Boolean bool = (Boolean) obj;
        C0846g.i("CallHarassInterceptMarkedNumberFragment", "updateStrangersOff = " + bool);
        if (bool != null && this.this$0.isAdded()) {
            if (bool.booleanValue()) {
                a10 = this.this$0.f26771g;
                a10.e(this.this$0.getContext());
            } else {
                arrayList = this.this$0.f26768d;
                Object obj2 = arrayList.get(this.$position);
                kotlin.jvm.internal.i.e(obj2, "data[position]");
                f fVar = (f) obj2;
                if (fVar.e() != 1) {
                    C0846g.i("CallHarassInterceptMarkedNumberFragment", "onMultiChoiceClick return position=" + this.$position);
                    return m9.q.f35511a;
                }
                fVar.i(!fVar.b());
                int i12 = 0;
                if (!kotlin.jvm.internal.i.b(fVar.c(), this.this$0.getString(com.oplus.blacklistapp.u.f27675q)) && !kotlin.jvm.internal.i.b(fVar.c(), this.this$0.getString(com.oplus.blacklistapp.u.f27501C1))) {
                    CallHarassInterceptMarkedNumberFragment callHarassInterceptMarkedNumberFragment = this.this$0;
                    B13 = callHarassInterceptMarkedNumberFragment.B1(fVar.c());
                    callHarassInterceptMarkedNumberFragment.L1(B13, fVar.b(), 0);
                    CallHarassInterceptMarkedNumberFragment callHarassInterceptMarkedNumberFragment2 = this.this$0;
                    C13 = callHarassInterceptMarkedNumberFragment2.C1(fVar.c());
                    callHarassInterceptMarkedNumberFragment2.L1(C13, fVar.b(), 0);
                } else {
                    CallHarassInterceptMarkedNumberFragment callHarassInterceptMarkedNumberFragment3 = this.this$0;
                    B12 = callHarassInterceptMarkedNumberFragment3.B1(fVar.c());
                    callHarassInterceptMarkedNumberFragment3.L1(B12, fVar.b(), 3);
                    CallHarassInterceptMarkedNumberFragment callHarassInterceptMarkedNumberFragment4 = this.this$0;
                    C12 = callHarassInterceptMarkedNumberFragment4.C1(fVar.c());
                    callHarassInterceptMarkedNumberFragment4.L1(C12, fVar.b(), 3);
                }
                COUICheckBox cOUICheckBox = this.$checkBox;
                if (fVar.b()) {
                    i12 = 2;
                }
                cOUICheckBox.setState(i12);
                i10 = this.this$0.f26770f;
                FragmentActivity activity = this.this$0.getActivity();
                if (activity != null) {
                    context = activity.getApplicationContext();
                }
                MarkNumberThresholdUtil.h(i10, context);
            }
        }
        return m9.q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((CallHarassInterceptMarkedNumberFragment$onMultiChoiceClick$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
