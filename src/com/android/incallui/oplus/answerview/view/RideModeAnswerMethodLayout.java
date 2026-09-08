package com.android.incallui.oplus.answerview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.android.incallui.R;
import com.android.incallui.oplus.answerview.view.AnswerMethodLayout;
import com.android.incallui.oplus.answerview.view.GuideAnimatorView;
import com.android.incallui.oplus.answerview.view.SwipeAnswerImageView;

/* compiled from: RideModeAnswerMethodLayout.kt */
/* loaded from: classes.dex */
public final class RideModeAnswerMethodLayout extends AnswerMethodLayout {

    /* renamed from: i, reason: collision with root package name */
    public static final a f18790i = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public SwipeAnswerImageView f18791c;

    /* renamed from: d, reason: collision with root package name */
    public SwipeAnswerImageView f18792d;

    /* renamed from: e, reason: collision with root package name */
    public GuideAnimatorView f18793e;

    /* renamed from: f, reason: collision with root package name */
    public GuideAnimatorView f18794f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f18795g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f18796h;

    /* compiled from: RideModeAnswerMethodLayout.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final void b(SwipeAnswerImageView swipeAnswerImageView, TextView textView, GuideAnimatorView guideAnimatorView) {
            SwipeAnswerImageView.a aVar = SwipeAnswerImageView.f18802C;
            aVar.d(swipeAnswerImageView);
            aVar.c(swipeAnswerImageView, true);
            GuideAnimatorView.f18782g.a(guideAnimatorView);
            AnswerMethodLayout.a aVar2 = AnswerMethodLayout.f18772b;
            aVar2.a(swipeAnswerImageView, 1.0f);
            aVar2.a(textView, 1.0f);
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RideModeAnswerMethodLayout(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        kotlin.jvm.internal.i.f(context, "context");
    }

    public static final void j(RideModeAnswerMethodLayout this$0, View view, int i10) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.g(view, i10);
    }

    @Override // com.android.incallui.oplus.answerview.view.AnswerMethodLayout, com.android.incallui.oplus.answerview.view.j.c
    public void a() {
        a aVar = f18790i;
        SwipeAnswerImageView swipeAnswerImageView = this.f18791c;
        GuideAnimatorView guideAnimatorView = null;
        if (swipeAnswerImageView == null) {
            kotlin.jvm.internal.i.q("mRideDeclineView");
            swipeAnswerImageView = null;
        }
        TextView textView = this.f18795g;
        if (textView == null) {
            kotlin.jvm.internal.i.q("mRideDeclineDescription");
            textView = null;
        }
        GuideAnimatorView guideAnimatorView2 = this.f18793e;
        if (guideAnimatorView2 == null) {
            kotlin.jvm.internal.i.q("mRideDeclineGuideView");
            guideAnimatorView2 = null;
        }
        aVar.b(swipeAnswerImageView, textView, guideAnimatorView2);
        SwipeAnswerImageView swipeAnswerImageView2 = this.f18792d;
        if (swipeAnswerImageView2 == null) {
            kotlin.jvm.internal.i.q("mRideAnsView");
            swipeAnswerImageView2 = null;
        }
        TextView textView2 = this.f18796h;
        if (textView2 == null) {
            kotlin.jvm.internal.i.q("mRideAnswerDescription");
            textView2 = null;
        }
        GuideAnimatorView guideAnimatorView3 = this.f18794f;
        if (guideAnimatorView3 == null) {
            kotlin.jvm.internal.i.q("mRideAnswerGuideView");
        } else {
            guideAnimatorView = guideAnimatorView3;
        }
        aVar.b(swipeAnswerImageView2, textView2, guideAnimatorView);
        AnswerMethodLayout.f18772b.e(this);
    }

    @Override // com.android.incallui.oplus.answerview.view.AnswerMethodLayout, com.android.incallui.oplus.answerview.view.j.c
    public void b(final View view, final int i10) {
        AnswerMethodLayout.f18772b.d(this);
        post(new Runnable() { // from class: com.android.incallui.oplus.answerview.view.e
            @Override // java.lang.Runnable
            public final void run() {
                RideModeAnswerMethodLayout.j(RideModeAnswerMethodLayout.this, view, i10);
            }
        });
    }

    @Override // com.android.incallui.oplus.answerview.view.AnswerMethodLayout, com.android.incallui.oplus.answerview.view.j.c
    public void d() {
        SwipeAnswerImageView.a aVar = SwipeAnswerImageView.f18802C;
        SwipeAnswerImageView swipeAnswerImageView = this.f18791c;
        SwipeAnswerImageView swipeAnswerImageView2 = null;
        if (swipeAnswerImageView == null) {
            kotlin.jvm.internal.i.q("mRideDeclineView");
            swipeAnswerImageView = null;
        }
        aVar.c(swipeAnswerImageView, false);
        SwipeAnswerImageView swipeAnswerImageView3 = this.f18792d;
        if (swipeAnswerImageView3 == null) {
            kotlin.jvm.internal.i.q("mRideAnsView");
        } else {
            swipeAnswerImageView2 = swipeAnswerImageView3;
        }
        aVar.c(swipeAnswerImageView2, false);
    }

    @Override // com.android.incallui.oplus.answerview.view.AnswerMethodLayout, com.android.incallui.oplus.answerview.view.j.c
    public void e(float f10) {
        float a10;
        a10 = B9.i.a(0.0f, 1 - Math.abs(f10));
        AnswerMethodLayout.a aVar = AnswerMethodLayout.f18772b;
        SwipeAnswerImageView swipeAnswerImageView = this.f18791c;
        TextView textView = null;
        if (swipeAnswerImageView == null) {
            kotlin.jvm.internal.i.q("mRideDeclineView");
            swipeAnswerImageView = null;
        }
        aVar.a(swipeAnswerImageView, a10);
        TextView textView2 = this.f18795g;
        if (textView2 == null) {
            kotlin.jvm.internal.i.q("mRideDeclineDescription");
            textView2 = null;
        }
        aVar.a(textView2, a10);
        SwipeAnswerImageView swipeAnswerImageView2 = this.f18792d;
        if (swipeAnswerImageView2 == null) {
            kotlin.jvm.internal.i.q("mRideAnsView");
            swipeAnswerImageView2 = null;
        }
        aVar.a(swipeAnswerImageView2, a10);
        TextView textView3 = this.f18796h;
        if (textView3 == null) {
            kotlin.jvm.internal.i.q("mRideAnswerDescription");
        } else {
            textView = textView3;
        }
        aVar.a(textView, a10);
    }

    @Override // com.android.incallui.oplus.answerview.view.AnswerMethodLayout, com.android.incallui.oplus.answerview.view.j.c
    public void f() {
        SwipeAnswerImageView.a aVar = SwipeAnswerImageView.f18802C;
        SwipeAnswerImageView swipeAnswerImageView = this.f18791c;
        GuideAnimatorView guideAnimatorView = null;
        if (swipeAnswerImageView == null) {
            kotlin.jvm.internal.i.q("mRideDeclineView");
            swipeAnswerImageView = null;
        }
        aVar.f(swipeAnswerImageView);
        GuideAnimatorView.a aVar2 = GuideAnimatorView.f18782g;
        GuideAnimatorView guideAnimatorView2 = this.f18793e;
        if (guideAnimatorView2 == null) {
            kotlin.jvm.internal.i.q("mRideDeclineGuideView");
            guideAnimatorView2 = null;
        }
        aVar2.b(guideAnimatorView2);
        SwipeAnswerImageView swipeAnswerImageView2 = this.f18792d;
        if (swipeAnswerImageView2 == null) {
            kotlin.jvm.internal.i.q("mRideAnsView");
            swipeAnswerImageView2 = null;
        }
        aVar.f(swipeAnswerImageView2);
        GuideAnimatorView guideAnimatorView3 = this.f18794f;
        if (guideAnimatorView3 == null) {
            kotlin.jvm.internal.i.q("mRideAnswerGuideView");
        } else {
            guideAnimatorView = guideAnimatorView3;
        }
        aVar2.b(guideAnimatorView);
    }

    @Override // g2.InterfaceC1035b
    public void m() {
        Log.d("RideModeAnswerMethodLayout", "onHideAnswerView: ");
        SwipeAnswerImageView.a aVar = SwipeAnswerImageView.f18802C;
        SwipeAnswerImageView swipeAnswerImageView = this.f18791c;
        SwipeAnswerImageView swipeAnswerImageView2 = null;
        if (swipeAnswerImageView == null) {
            kotlin.jvm.internal.i.q("mRideDeclineView");
            swipeAnswerImageView = null;
        }
        aVar.e(swipeAnswerImageView);
        SwipeAnswerImageView swipeAnswerImageView3 = this.f18792d;
        if (swipeAnswerImageView3 == null) {
            kotlin.jvm.internal.i.q("mRideAnsView");
        } else {
            swipeAnswerImageView2 = swipeAnswerImageView3;
        }
        aVar.e(swipeAnswerImageView2);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(R.id.ride_decline_view);
        kotlin.jvm.internal.i.e(findViewById, "findViewById(R.id.ride_decline_view)");
        this.f18791c = (SwipeAnswerImageView) findViewById;
        View findViewById2 = findViewById(R.id.ride_answer_view);
        kotlin.jvm.internal.i.e(findViewById2, "findViewById(R.id.ride_answer_view)");
        this.f18792d = (SwipeAnswerImageView) findViewById2;
        View findViewById3 = findViewById(R.id.ride_decline_description);
        kotlin.jvm.internal.i.e(findViewById3, "findViewById(R.id.ride_decline_description)");
        this.f18795g = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.decline_guide_view);
        kotlin.jvm.internal.i.e(findViewById4, "findViewById(R.id.decline_guide_view)");
        this.f18793e = (GuideAnimatorView) findViewById4;
        View findViewById5 = findViewById(R.id.ride_answer_description);
        kotlin.jvm.internal.i.e(findViewById5, "findViewById(R.id.ride_answer_description)");
        this.f18796h = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.answer_guide_view);
        kotlin.jvm.internal.i.e(findViewById6, "findViewById(R.id.answer_guide_view)");
        this.f18794f = (GuideAnimatorView) findViewById6;
        SwipeAnswerImageView.a aVar = SwipeAnswerImageView.f18802C;
        SwipeAnswerImageView swipeAnswerImageView = this.f18791c;
        SwipeAnswerImageView swipeAnswerImageView2 = null;
        if (swipeAnswerImageView == null) {
            kotlin.jvm.internal.i.q("mRideDeclineView");
            swipeAnswerImageView = null;
        }
        aVar.b(swipeAnswerImageView, this);
        SwipeAnswerImageView swipeAnswerImageView3 = this.f18792d;
        if (swipeAnswerImageView3 == null) {
            kotlin.jvm.internal.i.q("mRideAnsView");
        } else {
            swipeAnswerImageView2 = swipeAnswerImageView3;
        }
        aVar.b(swipeAnswerImageView2, this);
    }

    @Override // g2.InterfaceC1035b
    public void v0() {
        Log.d("RideModeAnswerMethodLayout", "onShowAnswerView: ");
        SwipeAnswerImageView.a aVar = SwipeAnswerImageView.f18802C;
        SwipeAnswerImageView swipeAnswerImageView = this.f18791c;
        SwipeAnswerImageView swipeAnswerImageView2 = null;
        if (swipeAnswerImageView == null) {
            kotlin.jvm.internal.i.q("mRideDeclineView");
            swipeAnswerImageView = null;
        }
        aVar.a(swipeAnswerImageView);
        SwipeAnswerImageView swipeAnswerImageView3 = this.f18792d;
        if (swipeAnswerImageView3 == null) {
            kotlin.jvm.internal.i.q("mRideAnsView");
        } else {
            swipeAnswerImageView2 = swipeAnswerImageView3;
        }
        aVar.a(swipeAnswerImageView2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RideModeAnswerMethodLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        kotlin.jvm.internal.i.f(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RideModeAnswerMethodLayout(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
        kotlin.jvm.internal.i.f(context, "context");
    }
}
