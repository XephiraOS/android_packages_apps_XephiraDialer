package com.android.incallui.foldscreen.presentation.view;

import P1.d;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.android.incallui.foldscreen.presentation.view.FlingUpAnswerMethodFoldLayout;
import com.android.incallui.oplus.answerview.view.AnswerMethodDialogButton;
import com.android.incallui.oplus.answerview.view.AnswerMethodLayout;
import com.android.incallui.oplus.answerview.view.GuideAnimatorView;
import com.android.incallui.oplus.answerview.view.SwipeAnswerImageView;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: FlingUpAnswerMethodFoldLayout.kt */
/* loaded from: classes.dex */
public final class FlingUpAnswerMethodFoldLayout extends AnswerMethodLayout {

    /* renamed from: h, reason: collision with root package name */
    public static final a f18451h = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public AnswerMethodDialogButton f18452c;

    /* renamed from: d, reason: collision with root package name */
    public SwipeAnswerImageView f18453d;

    /* renamed from: e, reason: collision with root package name */
    public SwipeAnswerImageView f18454e;

    /* renamed from: f, reason: collision with root package name */
    public GuideAnimatorView f18455f;

    /* renamed from: g, reason: collision with root package name */
    public GuideAnimatorView f18456g;

    /* compiled from: FlingUpAnswerMethodFoldLayout.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlingUpAnswerMethodFoldLayout(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        i.f(context, "context");
    }

    public static final void l(final FlingUpAnswerMethodFoldLayout this$0, final View view) {
        i.f(this$0, "this$0");
        this$0.post(new Runnable() { // from class: a2.c
            @Override // java.lang.Runnable
            public final void run() {
                FlingUpAnswerMethodFoldLayout.n(FlingUpAnswerMethodFoldLayout.this, view);
            }
        });
    }

    public static final void n(FlingUpAnswerMethodFoldLayout this$0, View view) {
        i.f(this$0, "this$0");
        AnswerMethodLayout.h(this$0, view, 0, 2, null);
    }

    public static final void o(FlingUpAnswerMethodFoldLayout this$0, View view, int i10) {
        i.f(this$0, "this$0");
        this$0.g(view, i10);
    }

    @Override // com.android.incallui.oplus.answerview.view.AnswerMethodLayout, com.android.incallui.oplus.answerview.view.j.c
    public void a() {
        AnswerMethodLayout.a aVar = AnswerMethodLayout.f18772b;
        SwipeAnswerImageView swipeAnswerImageView = this.f18454e;
        AnswerMethodDialogButton answerMethodDialogButton = null;
        if (swipeAnswerImageView == null) {
            i.q("mFoldBtnDeclineView");
            swipeAnswerImageView = null;
        }
        GuideAnimatorView guideAnimatorView = this.f18455f;
        if (guideAnimatorView == null) {
            i.q("mFoldDeclineGuideView");
            guideAnimatorView = null;
        }
        aVar.b(swipeAnswerImageView, guideAnimatorView);
        SwipeAnswerImageView swipeAnswerImageView2 = this.f18453d;
        if (swipeAnswerImageView2 == null) {
            i.q("mFoldVoiceAnsView");
            swipeAnswerImageView2 = null;
        }
        GuideAnimatorView guideAnimatorView2 = this.f18456g;
        if (guideAnimatorView2 == null) {
            i.q("mFoldVoiceGuideView");
            guideAnimatorView2 = null;
        }
        aVar.b(swipeAnswerImageView2, guideAnimatorView2);
        AnswerMethodDialogButton answerMethodDialogButton2 = this.f18452c;
        if (answerMethodDialogButton2 == null) {
            i.q("mFoldDialogDeclineView");
        } else {
            answerMethodDialogButton = answerMethodDialogButton2;
        }
        aVar.a(answerMethodDialogButton, 1.0f);
        aVar.e(this);
    }

    @Override // com.android.incallui.oplus.answerview.view.AnswerMethodLayout, com.android.incallui.oplus.answerview.view.j.c
    public void b(final View view, final int i10) {
        AnswerMethodLayout.f18772b.d(this);
        post(new Runnable() { // from class: a2.a
            @Override // java.lang.Runnable
            public final void run() {
                FlingUpAnswerMethodFoldLayout.o(FlingUpAnswerMethodFoldLayout.this, view, i10);
            }
        });
    }

    @Override // com.android.incallui.oplus.answerview.view.AnswerMethodLayout, com.android.incallui.oplus.answerview.view.j.c
    public void d() {
        SwipeAnswerImageView.a aVar = SwipeAnswerImageView.f18802C;
        SwipeAnswerImageView swipeAnswerImageView = this.f18454e;
        SwipeAnswerImageView swipeAnswerImageView2 = null;
        if (swipeAnswerImageView == null) {
            i.q("mFoldBtnDeclineView");
            swipeAnswerImageView = null;
        }
        aVar.c(swipeAnswerImageView, false);
        SwipeAnswerImageView swipeAnswerImageView3 = this.f18453d;
        if (swipeAnswerImageView3 == null) {
            i.q("mFoldVoiceAnsView");
        } else {
            swipeAnswerImageView2 = swipeAnswerImageView3;
        }
        aVar.c(swipeAnswerImageView2, false);
    }

    @Override // com.android.incallui.oplus.answerview.view.AnswerMethodLayout, com.android.incallui.oplus.answerview.view.j.c
    public void e(float f10) {
        float a10;
        a10 = B9.i.a(0.0f, 1.0f - Math.abs(f10));
        AnswerMethodLayout.a aVar = AnswerMethodLayout.f18772b;
        SwipeAnswerImageView swipeAnswerImageView = this.f18454e;
        AnswerMethodDialogButton answerMethodDialogButton = null;
        if (swipeAnswerImageView == null) {
            i.q("mFoldBtnDeclineView");
            swipeAnswerImageView = null;
        }
        aVar.a(swipeAnswerImageView, a10);
        SwipeAnswerImageView swipeAnswerImageView2 = this.f18453d;
        if (swipeAnswerImageView2 == null) {
            i.q("mFoldVoiceAnsView");
            swipeAnswerImageView2 = null;
        }
        aVar.a(swipeAnswerImageView2, a10);
        AnswerMethodDialogButton answerMethodDialogButton2 = this.f18452c;
        if (answerMethodDialogButton2 == null) {
            i.q("mFoldDialogDeclineView");
        } else {
            answerMethodDialogButton = answerMethodDialogButton2;
        }
        aVar.a(answerMethodDialogButton, a10);
    }

    @Override // com.android.incallui.oplus.answerview.view.AnswerMethodLayout, com.android.incallui.oplus.answerview.view.j.c
    public void f() {
        AnswerMethodLayout.a aVar = AnswerMethodLayout.f18772b;
        SwipeAnswerImageView swipeAnswerImageView = this.f18454e;
        GuideAnimatorView guideAnimatorView = null;
        if (swipeAnswerImageView == null) {
            i.q("mFoldBtnDeclineView");
            swipeAnswerImageView = null;
        }
        GuideAnimatorView guideAnimatorView2 = this.f18455f;
        if (guideAnimatorView2 == null) {
            i.q("mFoldDeclineGuideView");
            guideAnimatorView2 = null;
        }
        aVar.c(swipeAnswerImageView, guideAnimatorView2);
        SwipeAnswerImageView swipeAnswerImageView2 = this.f18453d;
        if (swipeAnswerImageView2 == null) {
            i.q("mFoldVoiceAnsView");
            swipeAnswerImageView2 = null;
        }
        GuideAnimatorView guideAnimatorView3 = this.f18456g;
        if (guideAnimatorView3 == null) {
            i.q("mFoldVoiceGuideView");
        } else {
            guideAnimatorView = guideAnimatorView3;
        }
        aVar.c(swipeAnswerImageView2, guideAnimatorView);
    }

    @Override // g2.InterfaceC1035b
    public void m() {
        Log.d("FlingUpAnswerMethodFoldLayout", "onHideAnswerView: ");
        SwipeAnswerImageView.a aVar = SwipeAnswerImageView.f18802C;
        SwipeAnswerImageView swipeAnswerImageView = this.f18454e;
        SwipeAnswerImageView swipeAnswerImageView2 = null;
        if (swipeAnswerImageView == null) {
            i.q("mFoldBtnDeclineView");
            swipeAnswerImageView = null;
        }
        aVar.e(swipeAnswerImageView);
        SwipeAnswerImageView swipeAnswerImageView3 = this.f18453d;
        if (swipeAnswerImageView3 == null) {
            i.q("mFoldVoiceAnsView");
        } else {
            swipeAnswerImageView2 = swipeAnswerImageView3;
        }
        aVar.e(swipeAnswerImageView2);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(d.f2846e);
        i.e(findViewById, "findViewById(R.id.fold_dialog_decline_view)");
        this.f18452c = (AnswerMethodDialogButton) findViewById;
        View findViewById2 = findViewById(d.f2851j);
        i.e(findViewById2, "findViewById(R.id.fold_voice_ans_view)");
        this.f18453d = (SwipeAnswerImageView) findViewById2;
        View findViewById3 = findViewById(d.f2844c);
        i.e(findViewById3, "findViewById(R.id.fold_btn_decline_view)");
        this.f18454e = (SwipeAnswerImageView) findViewById3;
        View findViewById4 = findViewById(d.f2845d);
        i.e(findViewById4, "findViewById(R.id.fold_decline_guide_view)");
        this.f18455f = (GuideAnimatorView) findViewById4;
        View findViewById5 = findViewById(d.f2852k);
        i.e(findViewById5, "findViewById(R.id.fold_voice_guide_view)");
        this.f18456g = (GuideAnimatorView) findViewById5;
        SwipeAnswerImageView.a aVar = SwipeAnswerImageView.f18802C;
        SwipeAnswerImageView swipeAnswerImageView = this.f18454e;
        AnswerMethodDialogButton answerMethodDialogButton = null;
        if (swipeAnswerImageView == null) {
            i.q("mFoldBtnDeclineView");
            swipeAnswerImageView = null;
        }
        aVar.b(swipeAnswerImageView, this);
        SwipeAnswerImageView swipeAnswerImageView2 = this.f18453d;
        if (swipeAnswerImageView2 == null) {
            i.q("mFoldVoiceAnsView");
            swipeAnswerImageView2 = null;
        }
        aVar.b(swipeAnswerImageView2, this);
        AnswerMethodDialogButton answerMethodDialogButton2 = this.f18452c;
        if (answerMethodDialogButton2 == null) {
            i.q("mFoldDialogDeclineView");
        } else {
            answerMethodDialogButton = answerMethodDialogButton2;
        }
        answerMethodDialogButton.setOnClickListener(new View.OnClickListener() { // from class: a2.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FlingUpAnswerMethodFoldLayout.l(FlingUpAnswerMethodFoldLayout.this, view);
            }
        });
    }

    @Override // g2.InterfaceC1035b
    public void v0() {
        Log.d("FlingUpAnswerMethodFoldLayout", "onDisplayAnswerView: ");
        SwipeAnswerImageView.a aVar = SwipeAnswerImageView.f18802C;
        SwipeAnswerImageView swipeAnswerImageView = this.f18454e;
        SwipeAnswerImageView swipeAnswerImageView2 = null;
        if (swipeAnswerImageView == null) {
            i.q("mFoldBtnDeclineView");
            swipeAnswerImageView = null;
        }
        aVar.a(swipeAnswerImageView);
        SwipeAnswerImageView swipeAnswerImageView3 = this.f18453d;
        if (swipeAnswerImageView3 == null) {
            i.q("mFoldVoiceAnsView");
        } else {
            swipeAnswerImageView2 = swipeAnswerImageView3;
        }
        aVar.a(swipeAnswerImageView2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlingUpAnswerMethodFoldLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        i.f(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlingUpAnswerMethodFoldLayout(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
        i.f(context, "context");
    }
}
