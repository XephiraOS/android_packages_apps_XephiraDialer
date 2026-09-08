package com.android.incallui.oplus.widgets;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.Property;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import java.util.ArrayList;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.n;

/* compiled from: LoadingAnimTextView.kt */
/* loaded from: classes.dex */
public final class LoadingAnimTextView extends AppCompatTextView {

    /* renamed from: g, reason: collision with root package name */
    public static final a f19141g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f19142a;

    /* renamed from: b, reason: collision with root package name */
    public LinearInterpolator f19143b;

    /* renamed from: c, reason: collision with root package name */
    public AnimatorSet f19144c;

    /* renamed from: d, reason: collision with root package name */
    public AnimatorSet f19145d;

    /* renamed from: e, reason: collision with root package name */
    public AnimatorSet f19146e;

    /* renamed from: f, reason: collision with root package name */
    public final Property<AlphaForegroundColorSpan, Float> f19147f;

    /* compiled from: LoadingAnimTextView.kt */
    /* loaded from: classes.dex */
    public final class AlphaForegroundColorSpan extends ForegroundColorSpan {

        /* renamed from: a, reason: collision with root package name */
        public float f19148a;

        public AlphaForegroundColorSpan(int i10) {
            super(i10);
            this.f19148a = 0.2f;
        }

        public final int b(float f10) {
            int b10;
            b10 = x9.c.b(255 * f10);
            return b10;
        }

        public final float d() {
            return this.f19148a;
        }

        public final void f(float f10) {
            this.f19148a = f10;
            LoadingAnimTextView.this.invalidate();
        }

        @Override // android.text.style.ForegroundColorSpan
        public int getForegroundColor() {
            int foregroundColor = super.getForegroundColor();
            return Color.argb(b(this.f19148a), Color.red(foregroundColor), Color.green(foregroundColor), Color.blue(foregroundColor));
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            i.f(textPaint, "textPaint");
            textPaint.setColor(getForegroundColor());
        }
    }

    /* compiled from: LoadingAnimTextView.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: Animator.kt */
    /* loaded from: classes.dex */
    public static final class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            i.f(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i.f(animator, "animator");
            LoadingAnimTextView.this.d();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            i.f(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            i.f(animator, "animator");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingAnimTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        i.f(context, "context");
        i.f(attrs, "attrs");
        this.f19143b = new LinearInterpolator();
        this.f19147f = new com.android.incallui.oplus.widgets.a(Float.TYPE);
    }

    private final void b() {
        AnimatorSet animatorSet = this.f19144c;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.f19145d;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        AnimatorSet animatorSet3 = this.f19146e;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
        }
        this.f19144c = null;
        this.f19145d = null;
        this.f19146e = null;
    }

    public final AnimatorSet c(AlphaForegroundColorSpan alphaForegroundColorSpan, long j10, boolean z10) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(alphaForegroundColorSpan, this.f19147f, 0.2f, 0.5f);
        ofFloat.setInterpolator(this.f19143b);
        ofFloat.setDuration(133L);
        i.e(ofFloat, "ofFloat(span, ALPHA_FORE… duration = 133\n        }");
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(alphaForegroundColorSpan, this.f19147f, 0.5f, 1.0f);
        ofFloat2.setInterpolator(this.f19143b);
        ofFloat2.setDuration(67L);
        i.e(ofFloat2, "ofFloat(span, ALPHA_FORE…  duration = 67\n        }");
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(alphaForegroundColorSpan, this.f19147f, 1.0f, 1.0f);
        ofFloat3.setInterpolator(this.f19143b);
        ofFloat3.setDuration(266L);
        i.e(ofFloat3, "ofFloat(span, ALPHA_FORE… duration = 266\n        }");
        arrayList.add(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(alphaForegroundColorSpan, this.f19147f, 1.0f, 0.5f);
        ofFloat4.setInterpolator(this.f19143b);
        ofFloat4.setDuration(67L);
        i.e(ofFloat4, "ofFloat(span, ALPHA_FORE…  duration = 67\n        }");
        arrayList.add(ofFloat4);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(alphaForegroundColorSpan, this.f19147f, 0.5f, 0.2f);
        ofFloat5.setInterpolator(this.f19143b);
        ofFloat5.setDuration(133L);
        i.e(ofFloat5, "ofFloat(span, ALPHA_FORE… duration = 133\n        }");
        arrayList.add(ofFloat5);
        if (z10) {
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(alphaForegroundColorSpan, this.f19147f, 0.2f, 0.2f);
            ofFloat6.setInterpolator(this.f19143b);
            ofFloat6.setDuration(333L);
            i.e(ofFloat6, "ofFloat(span, ALPHA_FORE…ation = 333\n            }");
            arrayList.add(ofFloat6);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setStartDelay(j10);
        animatorSet.playSequentially(arrayList);
        return animatorSet;
    }

    public final void d() {
        AnimatorSet animatorSet = this.f19144c;
        if (animatorSet != null) {
            animatorSet.start();
        }
        AnimatorSet animatorSet2 = this.f19145d;
        if (animatorSet2 != null) {
            animatorSet2.start();
        }
        AnimatorSet animatorSet3 = this.f19146e;
        if (animatorSet3 != null) {
            animatorSet3.start();
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        CharSequence t10;
        String str;
        int J10;
        if (charSequence != null && charSequence.length() != 0) {
            t10 = n.t(charSequence.toString(), "…", "...", false, 4, null);
            CharSequence charSequence2 = this.f19142a;
            if (charSequence2 != null) {
                str = charSequence2.toString();
            } else {
                str = null;
            }
            if (i.b(t10, str)) {
                return;
            }
            b();
            this.f19142a = t10;
            J10 = StringsKt__StringsKt.J(t10, "...", 0, false, 6, null);
            if (J10 == -1) {
                super.setText(t10, bufferType);
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(t10);
            AlphaForegroundColorSpan alphaForegroundColorSpan = new AlphaForegroundColorSpan(getCurrentTextColor());
            AlphaForegroundColorSpan alphaForegroundColorSpan2 = new AlphaForegroundColorSpan(getCurrentTextColor());
            AlphaForegroundColorSpan alphaForegroundColorSpan3 = new AlphaForegroundColorSpan(getCurrentTextColor());
            int i10 = J10 + 1;
            spannableStringBuilder.setSpan(alphaForegroundColorSpan, J10, i10, 33);
            int i11 = J10 + 2;
            spannableStringBuilder.setSpan(alphaForegroundColorSpan2, i10, i11, 33);
            spannableStringBuilder.setSpan(alphaForegroundColorSpan3, i11, J10 + 3, 33);
            this.f19144c = c(alphaForegroundColorSpan, 0L, false);
            this.f19145d = c(alphaForegroundColorSpan2, 333L, false);
            AnimatorSet c10 = c(alphaForegroundColorSpan3, 666L, true);
            this.f19146e = c10;
            if (c10 != null) {
                c10.addListener(new b());
            }
            d();
            super.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
            return;
        }
        b();
        this.f19142a = charSequence;
    }
}
