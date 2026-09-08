package E6;

import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.util.Log;
import android.view.View;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.contextutil.COUIContextUtil;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: HighLightAnimator.kt */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static final a f734c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final View f735a;

    /* renamed from: b, reason: collision with root package name */
    public final ArgbEvaluator f736b;

    /* compiled from: HighLightAnimator.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: Runnable.kt */
    /* loaded from: classes3.dex */
    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            c cVar = c.this;
            cVar.d(cVar.e());
        }
    }

    public c(View itemView) {
        i.f(itemView, "itemView");
        this.f735a = itemView;
        this.f736b = new ArgbEvaluator();
    }

    public static final float g(float f10) {
        if (f10 < 0.0f) {
            return 0.0f;
        }
        if (f10 < 0.08f) {
            return f10 / 0.08f;
        }
        if (f10 < 0.28f) {
            return 1.0f;
        }
        if (f10 >= 0.68f) {
            return 0.0f;
        }
        return (0.68f - f10) / 0.4f;
    }

    public static final void h(ValueAnimator valueAnimator, COUICardListSelectedItemLayout cOUICardListSelectedItemLayout, int i10, int i11, c this$0, ValueAnimator it) {
        i.f(this$0, "this$0");
        i.f(it, "it");
        if (!valueAnimator.isRunning()) {
            return;
        }
        float animatedFraction = it.getAnimatedFraction();
        if (animatedFraction <= 0.0f) {
            cOUICardListSelectedItemLayout.refreshCardBg(i10);
        } else {
            if (animatedFraction >= 1.0f) {
                cOUICardListSelectedItemLayout.refreshCardBg(i11);
                return;
            }
            Object evaluate = this$0.f736b.evaluate(animatedFraction, Integer.valueOf(i10), Integer.valueOf(i11));
            i.d(evaluate, "null cannot be cast to non-null type kotlin.Number");
            cOUICardListSelectedItemLayout.refreshCardBg(((Number) evaluate).intValue());
        }
    }

    public final void d(View view) {
        COUICardListSelectedItemLayout cOUICardListSelectedItemLayout;
        Log.d("HighlightAnimator", "addHighlightBackground");
        if (view instanceof COUICardListSelectedItemLayout) {
            cOUICardListSelectedItemLayout = (COUICardListSelectedItemLayout) view;
        } else {
            cOUICardListSelectedItemLayout = null;
        }
        ValueAnimator f10 = f(cOUICardListSelectedItemLayout);
        if (f10 != null) {
            f10.start();
        }
    }

    public final View e() {
        return this.f735a;
    }

    public final ValueAnimator f(final COUICardListSelectedItemLayout cOUICardListSelectedItemLayout) {
        if (cOUICardListSelectedItemLayout == null) {
            return null;
        }
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(1250L);
        ofFloat.setInterpolator(new TimeInterpolator() { // from class: E6.a
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f10) {
                float g10;
                g10 = c.g(f10);
                return g10;
            }
        });
        final int attrColor = COUIContextUtil.getAttrColor(cOUICardListSelectedItemLayout.getContext(), X8.c.f4386j);
        final int attrColor2 = COUIContextUtil.getAttrColor(cOUICardListSelectedItemLayout.getContext(), X8.c.f4388k);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: E6.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                c.h(ofFloat, cOUICardListSelectedItemLayout, attrColor, attrColor2, this, valueAnimator);
            }
        });
        return ofFloat;
    }

    public final void i() {
        this.f735a.postDelayed(new b(), 600L);
    }
}
