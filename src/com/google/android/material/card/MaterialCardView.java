package com.google.android.material.card;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.cardview.widget.CardView;
import e4.C0977c;
import e4.l;
import f.C0991a;
import i4.C1099b;
import x4.j;
import x4.n;
import x4.r;

/* loaded from: classes3.dex */
public class MaterialCardView extends CardView implements Checkable, r {

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f22910n = {R.attr.state_checkable};

    /* renamed from: o, reason: collision with root package name */
    public static final int[] f22911o = {R.attr.state_checked};

    /* renamed from: p, reason: collision with root package name */
    public static final int[] f22912p = {C0977c.f30688q0};

    /* renamed from: q, reason: collision with root package name */
    public static final int f22913q = l.f30999A;

    /* renamed from: j, reason: collision with root package name */
    public final C1099b f22914j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f22915k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f22916l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f22917m;

    /* loaded from: classes3.dex */
    public interface a {
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0977c.f30641M);
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f22914j.l().getBounds());
        return rectF;
    }

    @Override // androidx.cardview.widget.CardView
    public ColorStateList getCardBackgroundColor() {
        return this.f22914j.m();
    }

    public ColorStateList getCardForegroundColor() {
        return this.f22914j.n();
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.f22914j.o();
    }

    public int getCheckedIconGravity() {
        return this.f22914j.p();
    }

    public int getCheckedIconMargin() {
        return this.f22914j.q();
    }

    public int getCheckedIconSize() {
        return this.f22914j.r();
    }

    public ColorStateList getCheckedIconTint() {
        return this.f22914j.s();
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.f22914j.C().bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.f22914j.C().left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.f22914j.C().right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.f22914j.C().top;
    }

    public float getProgress() {
        return this.f22914j.w();
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.f22914j.u();
    }

    public ColorStateList getRippleColor() {
        return this.f22914j.x();
    }

    public n getShapeAppearanceModel() {
        return this.f22914j.y();
    }

    @Deprecated
    public int getStrokeColor() {
        return this.f22914j.z();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.f22914j.A();
    }

    public int getStrokeWidth() {
        return this.f22914j.B();
    }

    public final void h() {
        this.f22914j.k();
    }

    public boolean i() {
        C1099b c1099b = this.f22914j;
        if (c1099b != null && c1099b.F()) {
            return true;
        }
        return false;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f22916l;
    }

    public boolean j() {
        return this.f22917m;
    }

    public void k(int i10, int i11, int i12, int i13) {
        super.f(i10, i11, i12, i13);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f22914j.g0();
        j.f(this, this.f22914j.l());
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 3);
        if (i()) {
            View.mergeDrawableStates(onCreateDrawableState, f22910n);
        }
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f22911o);
        }
        if (j()) {
            View.mergeDrawableStates(onCreateDrawableState, f22912p);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(i());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.f22914j.K(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f22915k) {
            if (!this.f22914j.E()) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                this.f22914j.L(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(int i10) {
        this.f22914j.M(ColorStateList.valueOf(i10));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f10) {
        super.setCardElevation(f10);
        this.f22914j.i0();
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        this.f22914j.N(colorStateList);
    }

    public void setCheckable(boolean z10) {
        this.f22914j.O(z10);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        if (this.f22916l != z10) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.f22914j.R(drawable);
    }

    public void setCheckedIconGravity(int i10) {
        if (this.f22914j.p() != i10) {
            this.f22914j.S(i10);
        }
    }

    public void setCheckedIconMargin(int i10) {
        this.f22914j.T(i10);
    }

    public void setCheckedIconMarginResource(int i10) {
        if (i10 != -1) {
            this.f22914j.T(getResources().getDimensionPixelSize(i10));
        }
    }

    public void setCheckedIconResource(int i10) {
        this.f22914j.R(C0991a.b(getContext(), i10));
    }

    public void setCheckedIconSize(int i10) {
        this.f22914j.U(i10);
    }

    public void setCheckedIconSizeResource(int i10) {
        if (i10 != 0) {
            this.f22914j.U(getResources().getDimensionPixelSize(i10));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        this.f22914j.V(colorStateList);
    }

    @Override // android.view.View
    public void setClickable(boolean z10) {
        super.setClickable(z10);
        C1099b c1099b = this.f22914j;
        if (c1099b != null) {
            c1099b.g0();
        }
    }

    public void setDragged(boolean z10) {
        if (this.f22917m != z10) {
            this.f22917m = z10;
            refreshDrawableState();
            h();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f10) {
        super.setMaxCardElevation(f10);
        this.f22914j.k0();
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z10) {
        super.setPreventCornerOverlap(z10);
        this.f22914j.k0();
        this.f22914j.h0();
    }

    public void setProgress(float f10) {
        this.f22914j.X(f10);
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f10) {
        super.setRadius(f10);
        this.f22914j.W(f10);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        this.f22914j.Y(colorStateList);
    }

    public void setRippleColorResource(int i10) {
        this.f22914j.Y(C0991a.a(getContext(), i10));
    }

    @Override // x4.r
    public void setShapeAppearanceModel(n nVar) {
        setClipToOutline(nVar.u(getBoundsAsRectF()));
        this.f22914j.Z(nVar);
    }

    public void setStrokeColor(int i10) {
        setStrokeColor(ColorStateList.valueOf(i10));
    }

    public void setStrokeWidth(int i10) {
        this.f22914j.b0(i10);
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z10) {
        super.setUseCompatPadding(z10);
        this.f22914j.k0();
        this.f22914j.h0();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (i() && isEnabled()) {
            this.f22916l = !this.f22916l;
            refreshDrawableState();
            h();
            this.f22914j.Q(this.f22916l, true);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialCardView(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r6 = com.google.android.material.card.MaterialCardView.f22913q
            android.content.Context r8 = B4.a.c(r8, r9, r10, r6)
            r7.<init>(r8, r9, r10)
            r8 = 0
            r7.f22916l = r8
            r7.f22917m = r8
            r0 = 1
            r7.f22915k = r0
            android.content.Context r0 = r7.getContext()
            int[] r2 = e4.m.f31609z5
            int[] r5 = new int[r8]
            r1 = r9
            r3 = r10
            r4 = r6
            android.content.res.TypedArray r8 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            i4.b r0 = new i4.b
            r0.<init>(r7, r9, r10, r6)
            r7.f22914j = r0
            android.content.res.ColorStateList r9 = super.getCardBackgroundColor()
            r0.M(r9)
            int r9 = super.getContentPaddingLeft()
            int r10 = super.getContentPaddingTop()
            int r1 = super.getContentPaddingRight()
            int r7 = super.getContentPaddingBottom()
            r0.c0(r9, r10, r1, r7)
            r0.J(r8)
            r8.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.card.MaterialCardView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.f22914j.M(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f22914j.a0(colorStateList);
        invalidate();
    }

    public void setOnCheckedChangeListener(a aVar) {
    }
}
