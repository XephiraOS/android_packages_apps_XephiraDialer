package com.android.incallui.oplus.incomingfloatingwindow.domain.bean;

import com.android.incallui.R;
import com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a;
import kotlin.jvm.internal.i;
import q2.c;

/* compiled from: WindowViewBehavior.kt */
/* loaded from: classes.dex */
public enum FloatingWindowInComingStateDeclineBtnBehavior implements a {
    INCOMING_STATE_DECLINE(R.drawable.floating_window_btn_decline, R.drawable.floating_window_btn_decline_night),
    INCOMING_STATE_DECLINE_VOWIFI(R.drawable.floating_window_btn_vowifi_decline, R.drawable.floating_window_btn_vowifi_decline_night),
    INCOMING_STATE_DECLINE_BLUETOOTH(R.drawable.floating_window_btn_bluetooth_decline, R.drawable.floating_window_btn_bluetooth_decline_night);

    private final int imageRes;
    private final int imageResNight;

    FloatingWindowInComingStateDeclineBtnBehavior(int i10, int i11) {
        this.imageRes = i10;
        this.imageResNight = i11;
    }

    @Override // com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a
    public int a(boolean z10) {
        return a.C0184a.a(this, z10);
    }

    @Override // q2.b
    public void b(c holder, Integer num) {
        i.f(holder, "holder");
        holder.e();
    }

    @Override // com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a
    public int c() {
        return this.imageResNight;
    }

    @Override // com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a
    public int d(a aVar) {
        return a.C0184a.b(this, aVar);
    }

    @Override // com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a
    public int e(a aVar) {
        return a.C0184a.c(this, aVar);
    }

    @Override // com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a
    public int f() {
        return this.imageRes;
    }
}
