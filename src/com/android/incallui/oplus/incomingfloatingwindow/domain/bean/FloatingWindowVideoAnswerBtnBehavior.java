package com.android.incallui.oplus.incomingfloatingwindow.domain.bean;

import com.android.incallui.R;
import com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a;
import kotlin.jvm.internal.i;
import q2.c;

/* compiled from: WindowViewBehavior.kt */
/* loaded from: classes.dex */
public enum FloatingWindowVideoAnswerBtnBehavior implements a {
    VIDEO_ANSWER(R.drawable.floating_window_btn_video_answer, R.drawable.floating_window_btn_video_answer_night),
    VIDEO_ANSWER_VOWIFI(R.drawable.floating_window_btn_vowifi_video_answer, R.drawable.floating_window_btn_vowifi_video_answer_night),
    VIDEO_ANSWER_BLUETOOTH(R.drawable.floating_window_btn_bluetooth_video_answer, R.drawable.floating_window_btn_bluetooth_video_answer_night);

    private final int imageRes;
    private final int imageResNight;

    FloatingWindowVideoAnswerBtnBehavior(int i10, int i11) {
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
        holder.g(true, num);
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
