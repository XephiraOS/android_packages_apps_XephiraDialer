package com.android.incallui.oplus.answerview.protocol;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.android.incallui.R;
import g2.InterfaceC1034a;
import kotlin.jvm.internal.i;

/* compiled from: AnswerViewBehavior.kt */
/* loaded from: classes.dex */
public enum RideModeDeclineViewBehavior implements a {
    DECLINE_IN_RIDE_MODE(R.drawable.incall_btn_reject);

    private final int mImageRes;

    RideModeDeclineViewBehavior(int i10) {
        this.mImageRes = i10;
    }

    @Override // com.android.incallui.oplus.answerview.protocol.a
    public void a(Context context, InterfaceC1034a interfaceC1034a, int i10) {
        i.f(context, "context");
        if (interfaceC1034a != null) {
            interfaceC1034a.onDecline(context);
        }
    }

    @Override // com.android.incallui.oplus.answerview.protocol.a
    public void b(View view) {
        ImageView imageView;
        if (view instanceof ImageView) {
            imageView = (ImageView) view;
        } else {
            imageView = null;
        }
        if (imageView != null) {
            imageView.setImageResource(this.mImageRes);
        }
    }
}
