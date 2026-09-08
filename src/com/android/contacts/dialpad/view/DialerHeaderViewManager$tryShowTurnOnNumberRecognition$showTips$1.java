package com.android.contacts.dialpad.view;

import android.content.Context;
import androidx.preference.j;
import com.android.contacts.framework.baseui.util.NumberIdentifyUtils;
import com.oplus.foundation.util.feature.FeatureUtil;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.C1467a;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: DialerHeaderViewManager.kt */
@InterfaceC1470d(c = "com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowTurnOnNumberRecognition$showTips$1", f = "DialerHeaderViewManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DialerHeaderViewManager$tryShowTurnOnNumberRecognition$showTips$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super Boolean>, Object> {
    final /* synthetic */ Context $context;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialerHeaderViewManager$tryShowTurnOnNumberRecognition$showTips$1(Context context, kotlin.coroutines.c<? super DialerHeaderViewManager$tryShowTurnOnNumberRecognition$showTips$1> cVar) {
        super(2, cVar);
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new DialerHeaderViewManager$tryShowTurnOnNumberRecognition$showTips$1(this.$context, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            boolean z10 = false;
            if (B3.a.u() && FeatureUtil.O() && !j.b(this.$context).getBoolean("dismiss_turn_on_number_recognition", false) && !NumberIdentifyUtils.e(this.$context)) {
                z10 = true;
            }
            return C1467a.a(z10);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super Boolean> cVar) {
        return ((DialerHeaderViewManager$tryShowTurnOnNumberRecognition$showTips$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
