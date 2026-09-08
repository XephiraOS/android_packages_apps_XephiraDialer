package com.android.incallui.oplus.answerview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.android.incallui.R;

/* compiled from: StaticAnswerMethodLayout.kt */
/* loaded from: classes.dex */
public final class StaticAnswerMethodLayout extends AnswerMethodLayout implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public StaticAnswerImageView f18798c;

    /* renamed from: d, reason: collision with root package name */
    public StaticAnswerImageView f18799d;

    /* renamed from: e, reason: collision with root package name */
    public StaticAnswerImageView f18800e;

    /* renamed from: f, reason: collision with root package name */
    public AnswerMethodDialogButton f18801f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticAnswerMethodLayout(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        kotlin.jvm.internal.i.f(context, "context");
    }

    public static final void j(StaticAnswerMethodLayout this$0, View it) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(it, "$it");
        AnswerMethodLayout.h(this$0, it, 0, 2, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(final View view) {
        if (view != null) {
            post(new Runnable() { // from class: com.android.incallui.oplus.answerview.view.f
                @Override // java.lang.Runnable
                public final void run() {
                    StaticAnswerMethodLayout.j(StaticAnswerMethodLayout.this, view);
                }
            });
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(R.id.static_btn_decline_view);
        kotlin.jvm.internal.i.e(findViewById, "findViewById(R.id.static_btn_decline_view)");
        this.f18798c = (StaticAnswerImageView) findViewById;
        View findViewById2 = findViewById(R.id.static_video_ans_view);
        kotlin.jvm.internal.i.e(findViewById2, "findViewById(R.id.static_video_ans_view)");
        this.f18799d = (StaticAnswerImageView) findViewById2;
        View findViewById3 = findViewById(R.id.static_voice_ans_view);
        kotlin.jvm.internal.i.e(findViewById3, "findViewById(R.id.static_voice_ans_view)");
        this.f18800e = (StaticAnswerImageView) findViewById3;
        View findViewById4 = findViewById(R.id.static_dialog_decline_view);
        kotlin.jvm.internal.i.e(findViewById4, "findViewById(R.id.static_dialog_decline_view)");
        this.f18801f = (AnswerMethodDialogButton) findViewById4;
        StaticAnswerImageView staticAnswerImageView = this.f18798c;
        AnswerMethodDialogButton answerMethodDialogButton = null;
        if (staticAnswerImageView == null) {
            kotlin.jvm.internal.i.q("mStaticBtnDeclineView");
            staticAnswerImageView = null;
        }
        staticAnswerImageView.setOnClickListener(this);
        StaticAnswerImageView staticAnswerImageView2 = this.f18799d;
        if (staticAnswerImageView2 == null) {
            kotlin.jvm.internal.i.q("mStaticVideoAnsView");
            staticAnswerImageView2 = null;
        }
        staticAnswerImageView2.setOnClickListener(this);
        StaticAnswerImageView staticAnswerImageView3 = this.f18800e;
        if (staticAnswerImageView3 == null) {
            kotlin.jvm.internal.i.q("mStaticVoiceAnsView");
            staticAnswerImageView3 = null;
        }
        staticAnswerImageView3.setOnClickListener(this);
        AnswerMethodDialogButton answerMethodDialogButton2 = this.f18801f;
        if (answerMethodDialogButton2 == null) {
            kotlin.jvm.internal.i.q("mStaticDialogDeclineView");
        } else {
            answerMethodDialogButton = answerMethodDialogButton2;
        }
        answerMethodDialogButton.setOnClickListener(this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StaticAnswerMethodLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        kotlin.jvm.internal.i.f(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StaticAnswerMethodLayout(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
        kotlin.jvm.internal.i.f(context, "context");
    }

    @Override // g2.InterfaceC1035b
    public void m() {
    }

    @Override // g2.InterfaceC1035b
    public void v0() {
    }
}
