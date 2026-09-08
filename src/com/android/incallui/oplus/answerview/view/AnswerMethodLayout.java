package com.android.incallui.oplus.answerview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.incallui.oplus.answerview.view.SwipeAnswerImageView;
import com.android.incallui.oplus.answerview.view.j;
import g2.InterfaceC1035b;
import g2.InterfaceC1036c;
import g2.InterfaceC1037d;
import g2.InterfaceC1038e;

/* compiled from: AnswerMethodLayout.kt */
/* loaded from: classes.dex */
public abstract class AnswerMethodLayout extends ConstraintLayout implements InterfaceC1036c, InterfaceC1035b, j.c {

    /* renamed from: b, reason: collision with root package name */
    public static final a f18772b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC1037d f18773a;

    /* compiled from: AnswerMethodLayout.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final void a(View view, float f10) {
            Float f11;
            if (view != null) {
                f11 = Float.valueOf(view.getAlpha());
            } else {
                f11 = null;
            }
            if (!kotlin.jvm.internal.i.a(f11, f10) && view != null) {
                view.setAlpha(f10);
            }
        }

        public final void b(SwipeAnswerImageView swipeAnswerImageView, GuideAnimatorView guideAnimatorView) {
            SwipeAnswerImageView.a aVar = SwipeAnswerImageView.f18802C;
            aVar.c(swipeAnswerImageView, true);
            aVar.d(swipeAnswerImageView);
            GuideAnimatorView.f18782g.a(guideAnimatorView);
            AnswerMethodLayout.f18772b.a(swipeAnswerImageView, 1.0f);
        }

        public final void c(SwipeAnswerImageView swipeAnswerImageView, GuideAnimatorView guideAnimatorView) {
            SwipeAnswerImageView.f18802C.f(swipeAnswerImageView);
            GuideAnimatorView.f18782g.b(guideAnimatorView);
        }

        public final void d(View view) {
            if (view != null && view.getVisibility() == 0) {
                view.setVisibility(4);
            }
        }

        public final void e(View view) {
            if (view != null && view.getVisibility() == 4) {
                view.setVisibility(0);
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnswerMethodLayout(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        kotlin.jvm.internal.i.f(context, "context");
    }

    public static /* synthetic */ void h(AnswerMethodLayout answerMethodLayout, View view, int i10, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                i10 = 0;
            }
            answerMethodLayout.g(view, i10);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchTriggerEvent");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g(View view, int i10) {
        Integer num;
        InterfaceC1038e interfaceC1038e;
        StringBuilder sb = new StringBuilder();
        sb.append("dispatchTriggerEvent: view is ");
        com.android.incallui.oplus.answerview.protocol.a aVar = null;
        if (view != 0) {
            num = Integer.valueOf(view.getId());
        } else {
            num = null;
        }
        sb.append(num);
        Log.d("AnswerMethodLayout", sb.toString());
        InterfaceC1037d interfaceC1037d = this.f18773a;
        if (interfaceC1037d != null) {
            if (view instanceof InterfaceC1038e) {
                interfaceC1038e = (InterfaceC1038e) view;
            } else {
                interfaceC1038e = null;
            }
            if (interfaceC1038e != null) {
                aVar = interfaceC1038e.getMViewUserAction();
            }
            interfaceC1037d.Q0(aVar, i10);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        kotlin.jvm.internal.i.f(event, "event");
        if (event.getPointerCount() > 1) {
            Log.d("AnswerMethodLayout", "onTouchEvent PointerCount more one PointerCount");
            return true;
        }
        return super.onInterceptTouchEvent(event);
    }

    @Override // g2.InterfaceC1036c
    public void setTriggerEventListener(InterfaceC1037d interfaceC1037d) {
        this.f18773a = interfaceC1037d;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AnswerMethodLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        kotlin.jvm.internal.i.f(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AnswerMethodLayout(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
        kotlin.jvm.internal.i.f(context, "context");
    }

    public void a() {
    }

    public void d() {
    }

    public void e(float f10) {
    }

    public void f() {
    }

    public void b(View view, int i10) {
    }
}
