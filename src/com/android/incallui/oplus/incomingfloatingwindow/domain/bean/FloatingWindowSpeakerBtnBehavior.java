package com.android.incallui.oplus.incomingfloatingwindow.domain.bean;

import com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import q2.c;

/* compiled from: WindowViewBehavior.kt */
/* loaded from: classes.dex */
public enum FloatingWindowSpeakerBtnBehavior implements a {
    SPEAKER_ON { // from class: com.android.incallui.oplus.incomingfloatingwindow.domain.bean.FloatingWindowSpeakerBtnBehavior.SPEAKER_ON
        @Override // q2.b
        public void b(c holder, Integer num) {
            i.f(holder, "holder");
            holder.c();
        }
    },
    SPEAKER_OFF { // from class: com.android.incallui.oplus.incomingfloatingwindow.domain.bean.FloatingWindowSpeakerBtnBehavior.SPEAKER_OFF
        @Override // q2.b
        public void b(c holder, Integer num) {
            i.f(holder, "holder");
            holder.j();
        }
    };

    private final int imageRes;
    private final int imageResNight;

    /* synthetic */ FloatingWindowSpeakerBtnBehavior(int i10, int i11, f fVar) {
        this(i10, i11);
    }

    @Override // com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a
    public int a(boolean z10) {
        return a.C0184a.a(this, z10);
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

    FloatingWindowSpeakerBtnBehavior(int i10, int i11) {
        this.imageRes = i10;
        this.imageResNight = i11;
    }
}
