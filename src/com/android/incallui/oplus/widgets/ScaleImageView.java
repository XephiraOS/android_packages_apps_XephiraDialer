package com.android.incallui.oplus.widgets;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.PathInterpolator;
import com.android.incallui.oplus.widgets.ScaleImageView;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: ScaleImageView.kt */
/* loaded from: classes.dex */
public class ScaleImageView extends OplusIncallUIImageView {

    /* renamed from: e, reason: collision with root package name */
    public static final a f19154e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public static final PathInterpolator f19155f = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);

    /* renamed from: b, reason: collision with root package name */
    public boolean f19156b;

    /* renamed from: c, reason: collision with root package name */
    public ValueAnimator f19157c;

    /* renamed from: d, reason: collision with root package name */
    public float f19158d;

    /* compiled from: ScaleImageView.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i.f(context, "context");
        this.f19158d = 1.0f;
    }

    public static final void j(ScaleImageView this$0, boolean z10, ValueAnimator valueAnimator) {
        i.f(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue("scaleHolder");
        i.d(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.f19158d = ((Float) animatedValue).floatValue();
        if (this$0.f19156b && z10 && ((float) valueAnimator.getCurrentPlayTime()) > ((float) valueAnimator.getDuration()) * 0.7f) {
            valueAnimator.cancel();
            this$0.executeScaleAnimator(false);
        } else {
            this$0.setScale(this$0.f19158d);
        }
    }

    public static final void k(ScaleImageView this$0, boolean z10) {
        i.f(this$0, "this$0");
        this$0.executeScaleAnimator(z10);
    }

    private final void setScale(float f10) {
        float d10;
        float a10;
        d10 = B9.i.d(1.0f, f10);
        a10 = B9.i.a(0.92f, d10);
        setScaleX(a10);
        setScaleY(a10);
    }

    public final void executeScaleAnimator(final boolean z10) {
        float f10;
        long j10;
        this.f19156b = false;
        i(z10);
        if (this.f19156b) {
            return;
        }
        ValueAnimator valueAnimator = this.f19157c;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
        }
        float f11 = 1.0f;
        if (z10) {
            f10 = 1.0f;
        } else {
            f10 = this.f19158d;
        }
        if (z10) {
            f11 = 0.92f;
        }
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("scaleHolder", f10, f11));
        ofPropertyValuesHolder.setInterpolator(f19155f);
        if (z10) {
            j10 = 200;
        } else {
            j10 = 340;
        }
        ofPropertyValuesHolder.setDuration(j10);
        ofPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: E2.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ScaleImageView.j(ScaleImageView.this, z10, valueAnimator2);
            }
        });
        ofPropertyValuesHolder.start();
        this.f19157c = ofPropertyValuesHolder;
    }

    public final void i(boolean z10) {
        boolean z11;
        ValueAnimator valueAnimator = this.f19157c;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            if (!z10 && ((float) valueAnimator.getCurrentPlayTime()) < ((float) valueAnimator.getDuration()) * 0.7f) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.f19156b = z11;
            if (!z11) {
                valueAnimator.cancel();
            }
        }
    }

    @Override // android.view.View
    public void setPressed(final boolean z10) {
        if (isPressed() != z10) {
            super.setPressed(z10);
            post(new Runnable() { // from class: E2.e
                @Override // java.lang.Runnable
                public final void run() {
                    ScaleImageView.k(ScaleImageView.this, z10);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScaleImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
        this.f19158d = 1.0f;
    }
}
