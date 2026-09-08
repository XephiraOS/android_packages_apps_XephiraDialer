package com.android.incallui.oplus.answerview.protocol;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.android.incallui.oplus.answerview.protocol.a;
import g2.InterfaceC1034a;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: AnswerViewBehavior.kt */
/* loaded from: classes.dex */
public enum AnswerDialogBtnBehavior implements a {
    SMS_DECLINE_IN_NORMAL_MODE { // from class: com.android.incallui.oplus.answerview.protocol.AnswerDialogBtnBehavior.SMS_DECLINE_IN_NORMAL_MODE
        @Override // com.android.incallui.oplus.answerview.protocol.AnswerDialogBtnBehavior, com.android.incallui.oplus.answerview.protocol.a
        public void a(Context context, InterfaceC1034a interfaceC1034a, int i10) {
            i.f(context, "context");
            if (interfaceC1034a != null) {
                interfaceC1034a.onShowSmsListView();
            }
        }
    },
    INTERCEPT_DECLINE_IN_YELLOW_PAGE_MODE { // from class: com.android.incallui.oplus.answerview.protocol.AnswerDialogBtnBehavior.INTERCEPT_DECLINE_IN_YELLOW_PAGE_MODE
        @Override // com.android.incallui.oplus.answerview.protocol.AnswerDialogBtnBehavior, com.android.incallui.oplus.answerview.protocol.a
        public void a(Context context, InterfaceC1034a interfaceC1034a, int i10) {
            i.f(context, "context");
            if (interfaceC1034a != null) {
                interfaceC1034a.onShowInterceptSelectionDialog();
            }
        }
    };

    private final int mTextRes;

    /* synthetic */ AnswerDialogBtnBehavior(int i10, f fVar) {
        this(i10);
    }

    @Override // com.android.incallui.oplus.answerview.protocol.a
    public void a(Context context, InterfaceC1034a interfaceC1034a, int i10) {
        a.C0183a.a(this, context, interfaceC1034a, i10);
    }

    @Override // com.android.incallui.oplus.answerview.protocol.a
    public void b(View view) {
        String str;
        TextView textView = null;
        if (view != null) {
            Context context = view.getContext();
            if (context != null) {
                str = context.getString(this.mTextRes);
            } else {
                str = null;
            }
            view.setContentDescription(str);
        }
        if (view instanceof TextView) {
            textView = (TextView) view;
        }
        if (textView != null) {
            textView.setText(this.mTextRes);
        }
    }

    AnswerDialogBtnBehavior(int i10) {
        this.mTextRes = i10;
    }
}
