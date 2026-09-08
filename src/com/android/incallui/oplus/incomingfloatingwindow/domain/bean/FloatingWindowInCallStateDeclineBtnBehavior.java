package com.android.incallui.oplus.incomingfloatingwindow.domain.bean;

import com.android.incallui.R;
import com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import q2.c;

/* compiled from: WindowViewBehavior.kt */
/* loaded from: classes.dex */
public enum FloatingWindowInCallStateDeclineBtnBehavior implements a {
    INCALL_STATE_DECLINE { // from class: com.android.incallui.oplus.incomingfloatingwindow.domain.bean.FloatingWindowInCallStateDeclineBtnBehavior.INCALL_STATE_DECLINE
        @Override // com.android.incallui.oplus.incomingfloatingwindow.domain.bean.FloatingWindowInCallStateDeclineBtnBehavior, com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a
        public int d(a aVar) {
            if (aVar == FloatingWindowVoiceAnswerBtnBehavior.VOICE_ANSWER) {
                return R.anim.floating_window_decline_button_rotate_in;
            }
            return super.d(aVar);
        }

        @Override // com.android.incallui.oplus.incomingfloatingwindow.domain.bean.FloatingWindowInCallStateDeclineBtnBehavior, com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a
        public int e(a aVar) {
            if (aVar == FloatingWindowVoiceAnswerBtnBehavior.VOICE_ANSWER) {
                return R.anim.floating_window_decline_button_rotate_out;
            }
            return super.e(aVar);
        }
    },
    INCALL_STATE_DECLINE_VOWIFI(R.drawable.floating_window_btn_vowifi_decline, R.drawable.floating_window_btn_vowifi_decline_night),
    INCALL_STATE_DECLINE_BLUETOOTH(R.drawable.floating_window_btn_bluetooth_decline, R.drawable.floating_window_btn_bluetooth_decline_night);

    private final int imageRes;
    private final int imageResNight;

    /* synthetic */ FloatingWindowInCallStateDeclineBtnBehavior(int i10, int i11, f fVar) {
        this(i10, i11);
    }

    @Override // com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a
    public int a(boolean z10) {
        return a.C0184a.a(this, z10);
    }

    @Override // q2.b
    public void b(c holder, Integer num) {
        i.f(holder, "holder");
        holder.a();
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

    FloatingWindowInCallStateDeclineBtnBehavior(int i10, int i11) {
        this.imageRes = i10;
        this.imageResNight = i11;
    }
}
