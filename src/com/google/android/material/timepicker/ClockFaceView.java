package com.google.android.material.timepicker;

import J.d;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.core.view.C0446a;
import androidx.core.view.K;
import com.google.android.material.timepicker.ClockHandView;
import e4.C0977c;
import e4.C0978d;
import e4.C0979e;
import e4.g;
import e4.i;
import e4.l;
import e4.m;
import f.C0991a;
import java.util.Arrays;
import u4.C1607c;

/* loaded from: classes3.dex */
class ClockFaceView extends RadialViewGroup implements ClockHandView.b {

    /* renamed from: d, reason: collision with root package name */
    public final ClockHandView f24187d;

    /* renamed from: e, reason: collision with root package name */
    public final Rect f24188e;

    /* renamed from: f, reason: collision with root package name */
    public final RectF f24189f;

    /* renamed from: g, reason: collision with root package name */
    public final Rect f24190g;

    /* renamed from: h, reason: collision with root package name */
    public final SparseArray<TextView> f24191h;

    /* renamed from: i, reason: collision with root package name */
    public final C0446a f24192i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f24193j;

    /* renamed from: k, reason: collision with root package name */
    public final float[] f24194k;

    /* renamed from: l, reason: collision with root package name */
    public final int f24195l;

    /* renamed from: m, reason: collision with root package name */
    public final int f24196m;

    /* renamed from: n, reason: collision with root package name */
    public final int f24197n;

    /* renamed from: o, reason: collision with root package name */
    public final int f24198o;

    /* renamed from: p, reason: collision with root package name */
    public String[] f24199p;

    /* renamed from: q, reason: collision with root package name */
    public float f24200q;

    /* renamed from: r, reason: collision with root package name */
    public final ColorStateList f24201r;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!ClockFaceView.this.isShown()) {
                return true;
            }
            ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ClockFaceView.this.k(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.f24187d.i()) - ClockFaceView.this.f24195l);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends C0446a {
        public b() {
        }

        @Override // androidx.core.view.C0446a
        public void onInitializeAccessibilityNodeInfo(View view, J.d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            int intValue = ((Integer) view.getTag(g.f30898r)).intValue();
            if (intValue > 0) {
                dVar.L0((View) ClockFaceView.this.f24191h.get(intValue - 1));
            }
            dVar.k0(d.f.a(0, 1, intValue, 1, false, view.isSelected()));
            dVar.i0(true);
            dVar.b(d.a.f1394i);
        }

        @Override // androidx.core.view.C0446a
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            if (i10 == 16) {
                long uptimeMillis = SystemClock.uptimeMillis();
                view.getHitRect(ClockFaceView.this.f24188e);
                float centerX = ClockFaceView.this.f24188e.centerX();
                float centerY = ClockFaceView.this.f24188e.centerY();
                ClockFaceView.this.f24187d.onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, centerX, centerY, 0));
                ClockFaceView.this.f24187d.onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 1, centerX, centerY, 0));
                return true;
            }
            return super.performAccessibilityAction(view, i10, bundle);
        }
    }

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0977c.f30642N);
    }

    public static float w(float f10, float f11, float f12) {
        return Math.max(Math.max(f10, f11), f12);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.b
    public void c(float f10, boolean z10) {
        if (Math.abs(this.f24200q - f10) > 0.001f) {
            this.f24200q = f10;
            t();
        }
    }

    @Override // com.google.android.material.timepicker.RadialViewGroup
    public void k(int i10) {
        if (i10 != j()) {
            super.k(i10);
            this.f24187d.m(j());
        }
    }

    @Override // com.google.android.material.timepicker.RadialViewGroup
    public void n() {
        super.n();
        for (int i10 = 0; i10 < this.f24191h.size(); i10++) {
            this.f24191h.get(i10).setVisibility(0);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        J.d.O0(accessibilityNodeInfo).j0(d.e.b(1, this.f24199p.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        t();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int w10 = (int) (this.f24198o / w(this.f24196m / displayMetrics.heightPixels, this.f24197n / displayMetrics.widthPixels, 1.0f));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(w10, 1073741824);
        setMeasuredDimension(w10, w10);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    public final void t() {
        boolean z10;
        RectF e10 = this.f24187d.e();
        TextView v10 = v(e10);
        for (int i10 = 0; i10 < this.f24191h.size(); i10++) {
            TextView textView = this.f24191h.get(i10);
            if (textView != null) {
                if (textView == v10) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                textView.setSelected(z10);
                textView.getPaint().setShader(u(e10, textView));
                textView.invalidate();
            }
        }
    }

    public final RadialGradient u(RectF rectF, TextView textView) {
        textView.getHitRect(this.f24188e);
        this.f24189f.set(this.f24188e);
        textView.getLineBounds(0, this.f24190g);
        RectF rectF2 = this.f24189f;
        Rect rect = this.f24190g;
        rectF2.inset(rect.left, rect.top);
        if (!RectF.intersects(rectF, this.f24189f)) {
            return null;
        }
        return new RadialGradient(rectF.centerX() - this.f24189f.left, rectF.centerY() - this.f24189f.top, rectF.width() * 0.5f, this.f24193j, this.f24194k, Shader.TileMode.CLAMP);
    }

    public final TextView v(RectF rectF) {
        float f10 = Float.MAX_VALUE;
        TextView textView = null;
        for (int i10 = 0; i10 < this.f24191h.size(); i10++) {
            TextView textView2 = this.f24191h.get(i10);
            if (textView2 != null) {
                textView2.getHitRect(this.f24188e);
                this.f24189f.set(this.f24188e);
                this.f24189f.union(rectF);
                float width = this.f24189f.width() * this.f24189f.height();
                if (width < f10) {
                    textView = textView2;
                    f10 = width;
                }
            }
        }
        return textView;
    }

    public void x(String[] strArr, int i10) {
        this.f24199p = strArr;
        y(i10);
    }

    public final void y(int i10) {
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = this.f24191h.size();
        boolean z10 = false;
        for (int i11 = 0; i11 < Math.max(this.f24199p.length, size); i11++) {
            TextView textView = this.f24191h.get(i11);
            if (i11 >= this.f24199p.length) {
                removeView(textView);
                this.f24191h.remove(i11);
            } else {
                if (textView == null) {
                    textView = (TextView) from.inflate(i.f30933m, (ViewGroup) this, false);
                    this.f24191h.put(i11, textView);
                    addView(textView);
                }
                textView.setText(this.f24199p[i11]);
                textView.setTag(g.f30898r, Integer.valueOf(i11));
                int i12 = (i11 / 12) + 1;
                textView.setTag(g.f30888m, Integer.valueOf(i12));
                if (i12 > 1) {
                    z10 = true;
                }
                K.j0(textView, this.f24192i);
                textView.setTextColor(this.f24201r);
                if (i10 != 0) {
                    textView.setContentDescription(getResources().getString(i10, this.f24199p[i11]));
                }
            }
        }
        this.f24187d.q(z10);
    }

    public ClockFaceView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f24188e = new Rect();
        this.f24189f = new RectF();
        this.f24190g = new Rect();
        this.f24191h = new SparseArray<>();
        this.f24194k = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f31540t2, i10, l.f31015Q);
        Resources resources = getResources();
        ColorStateList a10 = C1607c.a(context, obtainStyledAttributes, m.f31562v2);
        this.f24201r = a10;
        LayoutInflater.from(context).inflate(i.f30934n, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(g.f30886l);
        this.f24187d = clockHandView;
        this.f24195l = resources.getDimensionPixelSize(C0979e.f30755Q);
        int colorForState = a10.getColorForState(new int[]{16842913}, a10.getDefaultColor());
        this.f24193j = new int[]{colorForState, colorForState, a10.getDefaultColor()};
        clockHandView.b(this);
        int defaultColor = C0991a.a(context, C0978d.f30718l).getDefaultColor();
        ColorStateList a11 = C1607c.a(context, obtainStyledAttributes, m.f31551u2);
        setBackgroundColor(a11 != null ? a11.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new a());
        setFocusable(true);
        obtainStyledAttributes.recycle();
        this.f24192i = new b();
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        x(strArr, 0);
        this.f24196m = resources.getDimensionPixelSize(C0979e.f30781e0);
        this.f24197n = resources.getDimensionPixelSize(C0979e.f30783f0);
        this.f24198o = resources.getDimensionPixelSize(C0979e.f30759S);
    }
}
