package com.android.incallui.oplus.answerview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.android.incallui.R;
import com.android.incallui.oplus.answerview.view.AnswerMethodLayout;
import com.android.incallui.oplus.answerview.view.SwipeAnswerImageView;

/* compiled from: FlingUpAnswerMethodLayout.kt */
/* loaded from: classes.dex */
public final class FlingUpAnswerMethodLayout extends AnswerMethodLayout {

    /* renamed from: j, reason: collision with root package name */
    public static final a f18774j = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public SwipeAnswerImageView f18775c;

    /* renamed from: d, reason: collision with root package name */
    public SwipeAnswerImageView f18776d;

    /* renamed from: e, reason: collision with root package name */
    public SwipeAnswerImageView f18777e;

    /* renamed from: f, reason: collision with root package name */
    public AnswerMethodDialogButton f18778f;

    /* renamed from: g, reason: collision with root package name */
    public GuideAnimatorView f18779g;

    /* renamed from: h, reason: collision with root package name */
    public GuideAnimatorView f18780h;

    /* renamed from: i, reason: collision with root package name */
    public GuideAnimatorView f18781i;

    /* compiled from: FlingUpAnswerMethodLayout.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlingUpAnswerMethodLayout(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        kotlin.jvm.internal.i.f(context, "context");
    }

    public static final void l(final FlingUpAnswerMethodLayout this$0, final View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.post(new Runnable() { // from class: com.android.incallui.oplus.answerview.view.c
            @Override // java.lang.Runnable
            public final void run() {
                FlingUpAnswerMethodLayout.n(FlingUpAnswerMethodLayout.this, view);
            }
        });
    }

    public static final void n(FlingUpAnswerMethodLayout this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        AnswerMethodLayout.h(this$0, view, 0, 2, null);
    }

    public static final void o(FlingUpAnswerMethodLayout this$0, View view, int i10) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.g(view, i10);
    }

    @Override // com.android.incallui.oplus.answerview.view.AnswerMethodLayout, com.android.incallui.oplus.answerview.view.j.c
    public void a() {
        AnswerMethodLayout.a aVar = AnswerMethodLayout.f18772b;
        SwipeAnswerImageView swipeAnswerImageView = this.f18775c;
        AnswerMethodDialogButton answerMethodDialogButton = null;
        if (swipeAnswerImageView == null) {
            kotlin.jvm.internal.i.q("mBtnDeclineView");
            swipeAnswerImageView = null;
        }
        GuideAnimatorView guideAnimatorView = this.f18779g;
        if (guideAnimatorView == null) {
            kotlin.jvm.internal.i.q("mDeclineGuideView");
            guideAnimatorView = null;
        }
        aVar.b(swipeAnswerImageView, guideAnimatorView);
        SwipeAnswerImageView swipeAnswerImageView2 = this.f18777e;
        if (swipeAnswerImageView2 == null) {
            kotlin.jvm.internal.i.q("mVoiceAnsView");
            swipeAnswerImageView2 = null;
        }
        GuideAnimatorView guideAnimatorView2 = this.f18780h;
        if (guideAnimatorView2 == null) {
            kotlin.jvm.internal.i.q("mVoiceGuideView");
            guideAnimatorView2 = null;
        }
        aVar.b(swipeAnswerImageView2, guideAnimatorView2);
        SwipeAnswerImageView swipeAnswerImageView3 = this.f18776d;
        if (swipeAnswerImageView3 == null) {
            kotlin.jvm.internal.i.q("mVideoAnsView");
            swipeAnswerImageView3 = null;
        }
        GuideAnimatorView guideAnimatorView3 = this.f18781i;
        if (guideAnimatorView3 == null) {
            kotlin.jvm.internal.i.q("mVideoGuideView");
            guideAnimatorView3 = null;
        }
        aVar.b(swipeAnswerImageView3, guideAnimatorView3);
        AnswerMethodDialogButton answerMethodDialogButton2 = this.f18778f;
        if (answerMethodDialogButton2 == null) {
            kotlin.jvm.internal.i.q("mDialogDeclineView");
        } else {
            answerMethodDialogButton = answerMethodDialogButton2;
        }
        aVar.a(answerMethodDialogButton, 1.0f);
        aVar.e(this);
    }

    @Override // com.android.incallui.oplus.answerview.view.AnswerMethodLayout, com.android.incallui.oplus.answerview.view.j.c
    public void b(final View view, final int i10) {
        AnswerMethodLayout.f18772b.d(this);
        post(new Runnable() { // from class: com.android.incallui.oplus.answerview.view.a
            @Override // java.lang.Runnable
            public final void run() {
                FlingUpAnswerMethodLayout.o(FlingUpAnswerMethodLayout.this, view, i10);
            }
        });
    }

    @Override // com.android.incallui.oplus.answerview.view.AnswerMethodLayout, com.android.incallui.oplus.answerview.view.j.c
    public void d() {
        SwipeAnswerImageView.a aVar = SwipeAnswerImageView.f18802C;
        SwipeAnswerImageView swipeAnswerImageView = this.f18775c;
        SwipeAnswerImageView swipeAnswerImageView2 = null;
        if (swipeAnswerImageView == null) {
            kotlin.jvm.internal.i.q("mBtnDeclineView");
            swipeAnswerImageView = null;
        }
        aVar.c(swipeAnswerImageView, false);
        SwipeAnswerImageView swipeAnswerImageView3 = this.f18776d;
        if (swipeAnswerImageView3 == null) {
            kotlin.jvm.internal.i.q("mVideoAnsView");
            swipeAnswerImageView3 = null;
        }
        aVar.c(swipeAnswerImageView3, false);
        SwipeAnswerImageView swipeAnswerImageView4 = this.f18777e;
        if (swipeAnswerImageView4 == null) {
            kotlin.jvm.internal.i.q("mVoiceAnsView");
        } else {
            swipeAnswerImageView2 = swipeAnswerImageView4;
        }
        aVar.c(swipeAnswerImageView2, false);
    }

    @Override // com.android.incallui.oplus.answerview.view.AnswerMethodLayout, com.android.incallui.oplus.answerview.view.j.c
    public void e(float f10) {
        float a10;
        a10 = B9.i.a(0.0f, 1.0f - Math.abs(f10));
        AnswerMethodLayout.a aVar = AnswerMethodLayout.f18772b;
        SwipeAnswerImageView swipeAnswerImageView = this.f18775c;
        AnswerMethodDialogButton answerMethodDialogButton = null;
        if (swipeAnswerImageView == null) {
            kotlin.jvm.internal.i.q("mBtnDeclineView");
            swipeAnswerImageView = null;
        }
        aVar.a(swipeAnswerImageView, a10);
        SwipeAnswerImageView swipeAnswerImageView2 = this.f18776d;
        if (swipeAnswerImageView2 == null) {
            kotlin.jvm.internal.i.q("mVideoAnsView");
            swipeAnswerImageView2 = null;
        }
        aVar.a(swipeAnswerImageView2, a10);
        SwipeAnswerImageView swipeAnswerImageView3 = this.f18777e;
        if (swipeAnswerImageView3 == null) {
            kotlin.jvm.internal.i.q("mVoiceAnsView");
            swipeAnswerImageView3 = null;
        }
        aVar.a(swipeAnswerImageView3, a10);
        AnswerMethodDialogButton answerMethodDialogButton2 = this.f18778f;
        if (answerMethodDialogButton2 == null) {
            kotlin.jvm.internal.i.q("mDialogDeclineView");
        } else {
            answerMethodDialogButton = answerMethodDialogButton2;
        }
        aVar.a(answerMethodDialogButton, a10);
    }

    @Override // com.android.incallui.oplus.answerview.view.AnswerMethodLayout, com.android.incallui.oplus.answerview.view.j.c
    public void f() {
        AnswerMethodLayout.a aVar = AnswerMethodLayout.f18772b;
        SwipeAnswerImageView swipeAnswerImageView = this.f18775c;
        GuideAnimatorView guideAnimatorView = null;
        if (swipeAnswerImageView == null) {
            kotlin.jvm.internal.i.q("mBtnDeclineView");
            swipeAnswerImageView = null;
        }
        GuideAnimatorView guideAnimatorView2 = this.f18779g;
        if (guideAnimatorView2 == null) {
            kotlin.jvm.internal.i.q("mDeclineGuideView");
            guideAnimatorView2 = null;
        }
        aVar.c(swipeAnswerImageView, guideAnimatorView2);
        SwipeAnswerImageView swipeAnswerImageView2 = this.f18777e;
        if (swipeAnswerImageView2 == null) {
            kotlin.jvm.internal.i.q("mVoiceAnsView");
            swipeAnswerImageView2 = null;
        }
        GuideAnimatorView guideAnimatorView3 = this.f18780h;
        if (guideAnimatorView3 == null) {
            kotlin.jvm.internal.i.q("mVoiceGuideView");
            guideAnimatorView3 = null;
        }
        aVar.c(swipeAnswerImageView2, guideAnimatorView3);
        SwipeAnswerImageView swipeAnswerImageView3 = this.f18776d;
        if (swipeAnswerImageView3 == null) {
            kotlin.jvm.internal.i.q("mVideoAnsView");
            swipeAnswerImageView3 = null;
        }
        GuideAnimatorView guideAnimatorView4 = this.f18781i;
        if (guideAnimatorView4 == null) {
            kotlin.jvm.internal.i.q("mVideoGuideView");
        } else {
            guideAnimatorView = guideAnimatorView4;
        }
        aVar.c(swipeAnswerImageView3, guideAnimatorView);
    }

    @Override // g2.InterfaceC1035b
    public void m() {
        Log.d("FlingUpAnswerMethodLayout", "onHideAnswerView: ");
        SwipeAnswerImageView.a aVar = SwipeAnswerImageView.f18802C;
        SwipeAnswerImageView swipeAnswerImageView = this.f18775c;
        SwipeAnswerImageView swipeAnswerImageView2 = null;
        if (swipeAnswerImageView == null) {
            kotlin.jvm.internal.i.q("mBtnDeclineView");
            swipeAnswerImageView = null;
        }
        aVar.e(swipeAnswerImageView);
        SwipeAnswerImageView swipeAnswerImageView3 = this.f18776d;
        if (swipeAnswerImageView3 == null) {
            kotlin.jvm.internal.i.q("mVideoAnsView");
            swipeAnswerImageView3 = null;
        }
        aVar.e(swipeAnswerImageView3);
        SwipeAnswerImageView swipeAnswerImageView4 = this.f18777e;
        if (swipeAnswerImageView4 == null) {
            kotlin.jvm.internal.i.q("mVoiceAnsView");
        } else {
            swipeAnswerImageView2 = swipeAnswerImageView4;
        }
        aVar.e(swipeAnswerImageView2);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(R.id.btn_decline_view);
        kotlin.jvm.internal.i.e(findViewById, "findViewById(R.id.btn_decline_view)");
        this.f18775c = (SwipeAnswerImageView) findViewById;
        View findViewById2 = findViewById(R.id.video_ans_view);
        kotlin.jvm.internal.i.e(findViewById2, "findViewById(R.id.video_ans_view)");
        this.f18776d = (SwipeAnswerImageView) findViewById2;
        View findViewById3 = findViewById(R.id.voice_ans_view);
        kotlin.jvm.internal.i.e(findViewById3, "findViewById(R.id.voice_ans_view)");
        this.f18777e = (SwipeAnswerImageView) findViewById3;
        View findViewById4 = findViewById(R.id.dialog_decline_view);
        kotlin.jvm.internal.i.e(findViewById4, "findViewById(R.id.dialog_decline_view)");
        this.f18778f = (AnswerMethodDialogButton) findViewById4;
        View findViewById5 = findViewById(R.id.decline_guide_view);
        kotlin.jvm.internal.i.e(findViewById5, "findViewById(R.id.decline_guide_view)");
        this.f18779g = (GuideAnimatorView) findViewById5;
        View findViewById6 = findViewById(R.id.voice_guide_view);
        kotlin.jvm.internal.i.e(findViewById6, "findViewById(R.id.voice_guide_view)");
        this.f18780h = (GuideAnimatorView) findViewById6;
        View findViewById7 = findViewById(R.id.video_guide_view);
        kotlin.jvm.internal.i.e(findViewById7, "findViewById(R.id.video_guide_view)");
        this.f18781i = (GuideAnimatorView) findViewById7;
        SwipeAnswerImageView.a aVar = SwipeAnswerImageView.f18802C;
        SwipeAnswerImageView swipeAnswerImageView = this.f18775c;
        AnswerMethodDialogButton answerMethodDialogButton = null;
        if (swipeAnswerImageView == null) {
            kotlin.jvm.internal.i.q("mBtnDeclineView");
            swipeAnswerImageView = null;
        }
        aVar.b(swipeAnswerImageView, this);
        SwipeAnswerImageView swipeAnswerImageView2 = this.f18776d;
        if (swipeAnswerImageView2 == null) {
            kotlin.jvm.internal.i.q("mVideoAnsView");
            swipeAnswerImageView2 = null;
        }
        aVar.b(swipeAnswerImageView2, this);
        SwipeAnswerImageView swipeAnswerImageView3 = this.f18777e;
        if (swipeAnswerImageView3 == null) {
            kotlin.jvm.internal.i.q("mVoiceAnsView");
            swipeAnswerImageView3 = null;
        }
        aVar.b(swipeAnswerImageView3, this);
        AnswerMethodDialogButton answerMethodDialogButton2 = this.f18778f;
        if (answerMethodDialogButton2 == null) {
            kotlin.jvm.internal.i.q("mDialogDeclineView");
        } else {
            answerMethodDialogButton = answerMethodDialogButton2;
        }
        answerMethodDialogButton.setOnClickListener(new View.OnClickListener() { // from class: com.android.incallui.oplus.answerview.view.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FlingUpAnswerMethodLayout.l(FlingUpAnswerMethodLayout.this, view);
            }
        });
    }

    @Override // g2.InterfaceC1035b
    public void v0() {
        Log.d("FlingUpAnswerMethodLayout", "onDisplayAnswerView: ");
        SwipeAnswerImageView.a aVar = SwipeAnswerImageView.f18802C;
        SwipeAnswerImageView swipeAnswerImageView = this.f18775c;
        SwipeAnswerImageView swipeAnswerImageView2 = null;
        if (swipeAnswerImageView == null) {
            kotlin.jvm.internal.i.q("mBtnDeclineView");
            swipeAnswerImageView = null;
        }
        aVar.a(swipeAnswerImageView);
        SwipeAnswerImageView swipeAnswerImageView3 = this.f18777e;
        if (swipeAnswerImageView3 == null) {
            kotlin.jvm.internal.i.q("mVoiceAnsView");
            swipeAnswerImageView3 = null;
        }
        aVar.a(swipeAnswerImageView3);
        SwipeAnswerImageView swipeAnswerImageView4 = this.f18776d;
        if (swipeAnswerImageView4 == null) {
            kotlin.jvm.internal.i.q("mVideoAnsView");
        } else {
            swipeAnswerImageView2 = swipeAnswerImageView4;
        }
        aVar.a(swipeAnswerImageView2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlingUpAnswerMethodLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        kotlin.jvm.internal.i.f(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlingUpAnswerMethodLayout(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
        kotlin.jvm.internal.i.f(context, "context");
    }
}
