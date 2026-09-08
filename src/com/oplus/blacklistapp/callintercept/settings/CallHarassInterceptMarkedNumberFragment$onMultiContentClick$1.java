package com.oplus.blacklistapp.callintercept.settings;

import android.app.Dialog;
import com.oplus.utils.C0846g;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.E;
import kotlinx.coroutines.S;
import p9.InterfaceC1470d;

/* compiled from: CallHarassInterceptMarkedNumberFragment.kt */
@InterfaceC1470d(c = "com.oplus.blacklistapp.callintercept.settings.CallHarassInterceptMarkedNumberFragment$onMultiContentClick$1", f = "CallHarassInterceptMarkedNumberFragment.kt", l = {533}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class CallHarassInterceptMarkedNumberFragment$onMultiContentClick$1 extends SuspendLambda implements v9.p<E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ int $position;
    int label;
    final /* synthetic */ CallHarassInterceptMarkedNumberFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallHarassInterceptMarkedNumberFragment$onMultiContentClick$1(CallHarassInterceptMarkedNumberFragment callHarassInterceptMarkedNumberFragment, int i10, kotlin.coroutines.c<? super CallHarassInterceptMarkedNumberFragment$onMultiContentClick$1> cVar) {
        super(2, cVar);
        this.this$0 = callHarassInterceptMarkedNumberFragment;
        this.$position = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new CallHarassInterceptMarkedNumberFragment$onMultiContentClick$1(this.this$0, this.$position, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        ArrayList arrayList;
        Dialog dialog;
        A a10;
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
            CoroutineDispatcher b10 = S.b();
            CallHarassInterceptMarkedNumberFragment$onMultiContentClick$1$updateStrangersOff$1 callHarassInterceptMarkedNumberFragment$onMultiContentClick$1$updateStrangersOff$1 = new CallHarassInterceptMarkedNumberFragment$onMultiContentClick$1$updateStrangersOff$1(this.this$0, null);
            this.label = 1;
            obj = C1244g.g(b10, callHarassInterceptMarkedNumberFragment$onMultiContentClick$1$updateStrangersOff$1, this);
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
                if (fVar.e() == 1) {
                    dialog = this.this$0.f26776l;
                    if (dialog == null || !dialog.isShowing()) {
                        this.this$0.P1(this.$position, fVar.c());
                    }
                } else {
                    C0846g.i("CallHarassInterceptMarkedNumberFragment", "onMultiChoiceClick return position=" + this.$position);
                    return m9.q.f35511a;
                }
            }
        }
        return m9.q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((CallHarassInterceptMarkedNumberFragment$onMultiContentClick$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
