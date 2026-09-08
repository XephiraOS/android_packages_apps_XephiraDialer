package com.oplus.blacklistapp.callintercept.settings;

import android.content.SharedPreferences;
import com.coui.appcompat.couiswitch.COUISwitch;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.E;
import kotlinx.coroutines.S;
import p9.InterfaceC1470d;

/* compiled from: CallHarassInterceptMarkedNumberFragment.kt */
@InterfaceC1470d(c = "com.oplus.blacklistapp.callintercept.settings.CallHarassInterceptMarkedNumberFragment$onSwitchClick$1", f = "CallHarassInterceptMarkedNumberFragment.kt", l = {382}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class CallHarassInterceptMarkedNumberFragment$onSwitchClick$1 extends SuspendLambda implements v9.p<E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ boolean $isChecked;
    final /* synthetic */ COUISwitch $switch;
    int label;
    final /* synthetic */ CallHarassInterceptMarkedNumberFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallHarassInterceptMarkedNumberFragment$onSwitchClick$1(CallHarassInterceptMarkedNumberFragment callHarassInterceptMarkedNumberFragment, boolean z10, COUISwitch cOUISwitch, kotlin.coroutines.c<? super CallHarassInterceptMarkedNumberFragment$onSwitchClick$1> cVar) {
        super(2, cVar);
        this.this$0 = callHarassInterceptMarkedNumberFragment;
        this.$isChecked = z10;
        this.$switch = cOUISwitch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new CallHarassInterceptMarkedNumberFragment$onSwitchClick$1(this.this$0, this.$isChecked, this.$switch, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        int i10;
        int i11;
        ArrayList arrayList;
        A a10;
        c10 = kotlin.coroutines.intrinsics.b.c();
        int i12 = this.label;
        Object obj2 = null;
        if (i12 != 0) {
            if (i12 == 1) {
                kotlin.b.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            kotlin.b.b(obj);
            CoroutineDispatcher b10 = S.b();
            CallHarassInterceptMarkedNumberFragment$onSwitchClick$1$updateStrangersOff$1 callHarassInterceptMarkedNumberFragment$onSwitchClick$1$updateStrangersOff$1 = new CallHarassInterceptMarkedNumberFragment$onSwitchClick$1$updateStrangersOff$1(this.this$0, null);
            this.label = 1;
            obj = C1244g.g(b10, callHarassInterceptMarkedNumberFragment$onSwitchClick$1$updateStrangersOff$1, this);
            if (obj == c10) {
                return c10;
            }
        }
        Boolean bool = (Boolean) obj;
        if (bool != null && this.this$0.isAdded()) {
            if (bool.booleanValue() && this.$isChecked) {
                a10 = this.this$0.f26771g;
                a10.e(this.this$0.getContext());
            } else {
                SharedPreferences b11 = androidx.preference.j.b(this.this$0.getContext());
                i10 = this.this$0.f26770f;
                u.d(b11, i10, "harass_intercept_marked_number_v2", this.$isChecked, 3);
                SharedPreferences b12 = androidx.preference.j.b(this.this$0.getContext());
                i11 = this.this$0.f26770f;
                u.d(b12, i11, "harass_intercept_marked_number", this.$isChecked, 3);
                this.$switch.setChecked(this.$isChecked);
                arrayList = this.this$0.f26768d;
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((f) next).e() == 4) {
                        obj2 = next;
                        break;
                    }
                }
                f fVar = (f) obj2;
                if (fVar != null) {
                    fVar.i(this.$isChecked);
                }
                this.this$0.M1();
            }
        }
        return m9.q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((CallHarassInterceptMarkedNumberFragment$onSwitchClick$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
