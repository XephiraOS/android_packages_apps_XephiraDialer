package com.android.incallui.oplus.answerview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.android.incallui.Log;
import com.android.incallui.R;
import com.android.incallui.oplus.widgets.b;
import com.coui.appcompat.button.COUIButton;
import g2.InterfaceC1038e;

/* compiled from: AnswerMethodDialogButton.kt */
/* loaded from: classes.dex */
public final class AnswerMethodDialogButton extends COUIButton implements InterfaceC1038e, b.a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f18769c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public com.android.incallui.oplus.answerview.protocol.a f18770a;

    /* renamed from: b, reason: collision with root package name */
    public final E2.b f18771b;

    /* compiled from: AnswerMethodDialogButton.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnswerMethodDialogButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.i.f(context, "context");
        this.f18771b = new com.android.incallui.oplus.widgets.b(this);
    }

    @Override // com.android.incallui.oplus.widgets.b.a
    public void c() {
        if (Log.sDebug) {
            Log.i("AnswerMethodDialogButton", "cancelPressState");
        }
        setFocusable(false);
        setPressed(false);
    }

    @Override // g2.InterfaceC1038e
    public com.android.incallui.oplus.answerview.protocol.a getMViewUserAction() {
        return this.f18770a;
    }

    @Override // com.coui.appcompat.button.COUIButton, android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f18771b.a(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.coui.appcompat.button.COUIButton, android.widget.TextView, android.view.View
    public void setEnabled(boolean z10) {
        if (z10) {
            setDrawableColor(getResources().getColor(R.color.incall_answer_view_dialog_btn_enable_tint, null));
            setTextColor(getResources().getColor(R.color.incall_answer_view_dialog_btn_enable_text_color, null));
        } else {
            setDrawableColor(getResources().getColor(R.color.incall_answer_view_dialog_btn_disable_tint, null));
            setTextColor(getResources().getColor(R.color.incall_answer_view_dialog_btn_disable_text_color, null));
        }
    }

    @Override // g2.InterfaceC1038e
    public void setMViewUserAction(com.android.incallui.oplus.answerview.protocol.a aVar) {
        this.f18770a = aVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AnswerMethodDialogButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        kotlin.jvm.internal.i.f(context, "context");
    }
}
