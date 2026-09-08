package com.android.incallui.clean.presentation.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.incallui.R;
import com.android.incallui.clean.presentation.view.InCallMarqueeTextView;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: InCallMarqueeTextView.kt */
/* loaded from: classes.dex */
public final class InCallMarqueeTextView extends AppCompatTextView {

    /* renamed from: r, reason: collision with root package name */
    public static final a f18369r = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public String f18370a;

    /* renamed from: b, reason: collision with root package name */
    public float f18371b;

    /* renamed from: c, reason: collision with root package name */
    public int f18372c;

    /* renamed from: d, reason: collision with root package name */
    public int f18373d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f18374e;

    /* renamed from: f, reason: collision with root package name */
    public int f18375f;

    /* renamed from: g, reason: collision with root package name */
    public String f18376g;

    /* renamed from: h, reason: collision with root package name */
    public int f18377h;

    /* renamed from: i, reason: collision with root package name */
    public ValueAnimator f18378i;

    /* renamed from: j, reason: collision with root package name */
    public b f18379j;

    /* renamed from: k, reason: collision with root package name */
    public final int f18380k;

    /* renamed from: l, reason: collision with root package name */
    public int f18381l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f18382m;

    /* renamed from: n, reason: collision with root package name */
    public int f18383n;

    /* renamed from: o, reason: collision with root package name */
    public String f18384o;

    /* renamed from: p, reason: collision with root package name */
    public TextView.BufferType f18385p;

    /* renamed from: q, reason: collision with root package name */
    public E2.a f18386q;

    /* compiled from: InCallMarqueeTextView.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: InCallMarqueeTextView.kt */
    /* loaded from: classes.dex */
    public final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InCallMarqueeTextView.this.d();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InCallMarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i.f(context, "context");
        this.f18370a = "";
        this.f18376g = "";
        this.f18380k = getResources().getDimensionPixelSize(R.dimen.call_card_marquee_text_interval);
        this.f18381l = getResources().getDimensionPixelSize(R.dimen.call_card_fading_edge_size);
        this.f18384o = "";
        this.f18386q = new E2.a(this, attributeSet);
        initTextViewAttributes();
        i();
        this.f18379j = new b();
        setScroller(null);
    }

    public static final void e(InCallMarqueeTextView this$0, ValueAnimator valueAnimator) {
        i.f(this$0, "this$0");
        this$0.f18373d = (int) (this$0.f18373d - this$0.f18371b);
        this$0.invalidate();
    }

    public static final void f(InCallMarqueeTextView this$0, ValueAnimator valueAnimator) {
        i.f(this$0, "this$0");
        this$0.f18373d = (int) (this$0.f18373d + this$0.f18371b);
        this$0.invalidate();
    }

    private final void l() {
        this.f18374e = false;
        removeCallbacks(this.f18379j);
        ValueAnimator valueAnimator = this.f18378i;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.f18378i = null;
    }

    @Override // android.widget.TextView, android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.f18382m && this.f18374e) {
            int abs = Math.abs(this.f18373d - this.f18372c);
            if (abs > 0) {
                int i10 = abs / this.f18377h;
                int i11 = this.f18375f;
                if (i10 >= i11) {
                    int i12 = i11 + 1;
                    this.f18375f = i12;
                    if (i12 >= 2) {
                        if (isLayoutRtl()) {
                            this.f18373d += this.f18377h;
                        } else {
                            this.f18373d -= this.f18377h;
                        }
                        this.f18375f--;
                    }
                }
            }
            scrollTo(this.f18373d, 0);
        }
    }

    public final void d() {
        if (this.f18382m && !this.f18374e) {
            ValueAnimator valueAnimator = this.f18378i;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.f18374e = true;
            ValueAnimator ofInt = ValueAnimator.ofInt(Integer.MAX_VALUE);
            ofInt.setDuration(Long.MAX_VALUE);
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.setRepeatCount(-1);
            ofInt.setRepeatMode(1);
            if (isLayoutRtl()) {
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: M1.a
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        InCallMarqueeTextView.e(InCallMarqueeTextView.this, valueAnimator2);
                    }
                });
            } else {
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: M1.b
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        InCallMarqueeTextView.f(InCallMarqueeTextView.this, valueAnimator2);
                    }
                });
            }
            ofInt.start();
            this.f18378i = ofInt;
        }
    }

    public final void g() {
        j();
        E2.a aVar = this.f18386q;
        if (aVar != null) {
            aVar.a(this.f18384o);
        }
        if (getPaint().measureText(this.f18384o) > (getMeasuredWidth() - getPaddingStart()) - getPaddingEnd()) {
            this.f18382m = true;
            h();
            setFadingEdgeLength(this.f18381l);
            postDelayed(this.f18379j, 1000L);
            return;
        }
        this.f18382m = false;
        h();
        setFadingEdgeLength(0);
    }

    public final String generateTextDistance() {
        String str = " ";
        int ceil = (int) Math.ceil(this.f18380k / getPaint().measureText(" "));
        if (this.f18380k != 0) {
            str = "";
        }
        if (ceil >= 0) {
            int i10 = 0;
            while (true) {
                str = str + ' ';
                if (i10 == ceil) {
                    break;
                }
                i10++;
            }
        }
        return str;
    }

    @Override // android.widget.TextView, android.view.View
    public float getLeftFadingEdgeStrength() {
        return 1.0f;
    }

    @Override // android.widget.TextView, android.view.View
    public float getRightFadingEdgeStrength() {
        return 1.0f;
    }

    public final void h() {
        if (this.f18382m) {
            this.f18376g = this.f18384o + generateTextDistance();
            this.f18375f = 0;
            this.f18377h = (int) getPaint().measureText(this.f18376g);
            this.f18370a = "";
            for (int i10 = 0; i10 < 2; i10++) {
                this.f18370a += this.f18376g;
            }
        } else {
            this.f18370a = this.f18384o;
            this.f18376g = "";
        }
        if (!i.b(this.f18370a, getText())) {
            super.setText(this.f18370a, this.f18385p);
        }
    }

    public final void i() {
        float f10;
        float dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.call_card_marquee_speed);
        Display display = getDisplay();
        if (display != null) {
            f10 = display.getRefreshRate();
        } else {
            f10 = 60.0f;
        }
        this.f18371b = dimensionPixelSize / f10;
    }

    public final void initTextViewAttributes() {
        setHorizontalFadingEdgeEnabled(true);
        setEllipsize(null);
        setSingleLine();
    }

    public final void j() {
        this.f18374e = false;
        removeCallbacks(this.f18379j);
        ValueAnimator valueAnimator = this.f18378i;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.f18378i = null;
        k();
    }

    public final void k() {
        int i10 = this.f18372c;
        this.f18373d = i10;
        scrollTo(i10, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f18383n != getMeasuredWidth()) {
            this.f18383n = getMeasuredWidth();
            g();
        }
    }

    @Override // android.widget.TextView, android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        boolean onPreDraw = super.onPreDraw();
        if (this.f18372c != getScrollX()) {
            this.f18372c = getScrollX();
            k();
        }
        return onPreDraw;
    }

    @Override // android.widget.TextView, android.view.View
    public void onVisibilityAggregated(boolean z10) {
        super.onVisibilityAggregated(z10);
        if (z10 && this.f18382m) {
            postDelayed(this.f18379j, 1000L);
        } else {
            j();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10 && this.f18382m) {
            postDelayed(this.f18379j, 1000L);
        } else {
            l();
        }
    }

    public final void setMaxTextSize(float f10) {
        E2.a aVar = this.f18386q;
        if (aVar != null) {
            aVar.c(f10);
        }
    }

    public final void setMinTextSize(float f10) {
        E2.a aVar = this.f18386q;
        if (aVar != null) {
            aVar.d(f10);
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        String str;
        this.f18385p = bufferType;
        if (charSequence == null || (str = charSequence.toString()) == null) {
            str = "";
        }
        if (i.b(this.f18384o, str)) {
            return;
        }
        this.f18384o = str;
        g();
    }
}
