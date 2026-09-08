package com.android.contacts.dialerui.dialer;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import com.android.contacts.framework.baseui.util.A;
import java.util.HashMap;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: SatelliteDialer.kt */
@InterfaceC1470d(c = "com.android.contacts.dialerui.dialer.SatelliteDialer$Statistics$trackCallActionIfInSatelliteMode$1", f = "SatelliteDialer.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SatelliteDialer$Statistics$trackCallActionIfInSatelliteMode$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $inputNumber;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SatelliteDialer$Statistics$trackCallActionIfInSatelliteMode$1(String str, Context context, kotlin.coroutines.c<? super SatelliteDialer$Statistics$trackCallActionIfInSatelliteMode$1> cVar) {
        super(2, cVar);
        this.$inputNumber = str;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new SatelliteDialer$Statistics$trackCallActionIfInSatelliteMode$1(this.$inputNumber, this.$context, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            if (com.android.contacts.framework.api.satellite.a.e()) {
                String d10 = U7.f.d(this.$inputNumber);
                if (PhoneNumberUtils.isEmergencyNumber(d10)) {
                    str = "emergency";
                } else if (E0.b.y(d10)) {
                    str = "company";
                } else if (SatelliteDialer.f14799n.c(this.$context, d10)) {
                    str = "contact";
                } else {
                    str = "other";
                }
                if (H7.a.b()) {
                    H7.b.b("Statistics", "Number: " + H7.a.d(d10) + ", " + str);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("dial_object", str);
                A.a(this.$context, 2000305, 200031811, hashMap, false);
            }
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((SatelliteDialer$Statistics$trackCallActionIfInSatelliteMode$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
