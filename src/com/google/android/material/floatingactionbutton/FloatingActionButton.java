package com.google.android.material.floatingactionbutton;

import I.h;
import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.C0433g;
import androidx.appcompat.widget.C0437k;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.K;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.a;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.stateful.ExtendableSavedState;
import e4.C0977c;
import e4.C0979e;
import e4.l;
import e4.m;
import f4.C1008i;
import f4.InterfaceC1011l;
import java.util.List;
import p4.C1440b;
import p4.InterfaceC1439a;
import w4.InterfaceC1650b;
import x4.n;
import x4.r;

/* loaded from: classes3.dex */
public class FloatingActionButton extends VisibilityAwareImageButton implements InterfaceC1439a, r, CoordinatorLayout.b {

    /* renamed from: q, reason: collision with root package name */
    public static final int f23339q = l.f31030m;

    /* renamed from: a, reason: collision with root package name */
    public ColorStateList f23340a;

    /* renamed from: b, reason: collision with root package name */
    public PorterDuff.Mode f23341b;

    /* renamed from: c, reason: collision with root package name */
    public ColorStateList f23342c;

    /* renamed from: d, reason: collision with root package name */
    public PorterDuff.Mode f23343d;

    /* renamed from: e, reason: collision with root package name */
    public ColorStateList f23344e;

    /* renamed from: f, reason: collision with root package name */
    public int f23345f;

    /* renamed from: g, reason: collision with root package name */
    public int f23346g;

    /* renamed from: h, reason: collision with root package name */
    public int f23347h;

    /* renamed from: i, reason: collision with root package name */
    public int f23348i;

    /* renamed from: j, reason: collision with root package name */
    public int f23349j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f23350k;

    /* renamed from: l, reason: collision with root package name */
    public final Rect f23351l;

    /* renamed from: m, reason: collision with root package name */
    public final Rect f23352m;

    /* renamed from: n, reason: collision with root package name */
    public final C0437k f23353n;

    /* renamed from: o, reason: collision with root package name */
    public final C1440b f23354o;

    /* renamed from: p, reason: collision with root package name */
    public com.google.android.material.floatingactionbutton.a f23355p;

    /* loaded from: classes3.dex */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: c */
        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.onDependentViewChanged(coordinatorLayout, floatingActionButton, view);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: d */
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i10) {
            return super.onLayoutChild(coordinatorLayout, floatingActionButton, i10);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onAttachedToLayoutParams(CoordinatorLayout.e eVar) {
            super.onAttachedToLayoutParams(eVar);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes3.dex */
    public class a implements a.j {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f23359a;

        public a(b bVar) {
            this.f23359a = bVar;
        }

        @Override // com.google.android.material.floatingactionbutton.a.j
        public void a() {
            this.f23359a.b(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.a.j
        public void b() {
            this.f23359a.a(FloatingActionButton.this);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements InterfaceC1650b {
        public c() {
        }

        @Override // w4.InterfaceC1650b
        public void a(Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }

        @Override // w4.InterfaceC1650b
        public boolean b() {
            return FloatingActionButton.this.f23350k;
        }

        @Override // w4.InterfaceC1650b
        public void setShadowPadding(int i10, int i11, int i12, int i13) {
            FloatingActionButton.this.f23351l.set(i10, i11, i12, i13);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i10 + floatingActionButton.f23348i, i11 + FloatingActionButton.this.f23348i, i12 + FloatingActionButton.this.f23348i, i13 + FloatingActionButton.this.f23348i);
        }
    }

    /* loaded from: classes3.dex */
    public class d<T extends FloatingActionButton> implements a.i {

        /* renamed from: a, reason: collision with root package name */
        public final InterfaceC1011l<T> f23362a;

        public d(InterfaceC1011l<T> interfaceC1011l) {
            this.f23362a = interfaceC1011l;
        }

        @Override // com.google.android.material.floatingactionbutton.a.i
        public void a() {
            this.f23362a.b(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.a.i
        public void b() {
            this.f23362a.a(FloatingActionButton.this);
        }

        public boolean equals(Object obj) {
            if ((obj instanceof d) && ((d) obj).f23362a.equals(this.f23362a)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f23362a.hashCode();
        }
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0977c.f30630D);
    }

    private com.google.android.material.floatingactionbutton.a getImpl() {
        if (this.f23355p == null) {
            this.f23355p = g();
        }
        return this.f23355p;
    }

    @Override // p4.InterfaceC1439a
    public boolean a() {
        return this.f23354o.c();
    }

    public void d(Animator.AnimatorListener animatorListener) {
        getImpl().e(animatorListener);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().E(getDrawableState());
    }

    public void e(Animator.AnimatorListener animatorListener) {
        getImpl().f(animatorListener);
    }

    public void f(InterfaceC1011l<? extends FloatingActionButton> interfaceC1011l) {
        getImpl().g(new d(interfaceC1011l));
    }

    public final com.google.android.material.floatingactionbutton.a g() {
        return new q4.d(this, new c());
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f23340a;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f23341b;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.Behavior<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().m();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().p();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().s();
    }

    public Drawable getContentBackground() {
        return getImpl().l();
    }

    public int getCustomSize() {
        return this.f23347h;
    }

    public int getExpandedComponentIdHint() {
        return this.f23354o.b();
    }

    public C1008i getHideMotionSpec() {
        return getImpl().o();
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f23344e;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f23344e;
    }

    public n getShapeAppearanceModel() {
        return (n) h.e(getImpl().t());
    }

    public C1008i getShowMotionSpec() {
        return getImpl().u();
    }

    public int getSize() {
        return this.f23346g;
    }

    public int getSizeDimension() {
        return j(this.f23346g);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.f23342c;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f23343d;
    }

    public boolean getUseCompatPadding() {
        return this.f23350k;
    }

    @Deprecated
    public boolean h(Rect rect) {
        if (!K.O(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        p(rect);
        return true;
    }

    public void i(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        p(rect);
    }

    public final int j(int i10) {
        int i11 = this.f23347h;
        if (i11 != 0) {
            return i11;
        }
        Resources resources = getResources();
        if (i10 != -1) {
            if (i10 != 1) {
                return resources.getDimensionPixelSize(C0979e.f30790j);
            }
            return resources.getDimensionPixelSize(C0979e.f30788i);
        }
        if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
            return j(1);
        }
        return j(0);
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().A();
    }

    public final void k(Rect rect) {
        i(rect);
        int i10 = -this.f23355p.v();
        rect.inset(i10, i10);
    }

    public void l(b bVar) {
        m(bVar, true);
    }

    public void m(b bVar, boolean z10) {
        getImpl().w(t(bVar), z10);
    }

    public boolean n() {
        return getImpl().y();
    }

    public boolean o() {
        return getImpl().z();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().B();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().D();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        int sizeDimension = getSizeDimension();
        this.f23348i = (sizeDimension - this.f23349j) / 2;
        getImpl().f0();
        int min = Math.min(View.resolveSize(sizeDimension, i10), View.resolveSize(sizeDimension, i11));
        Rect rect = this.f23351l;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.getSuperState());
        this.f23354o.d((Bundle) h.e(extendableSavedState.f23858a.get("expandableWidgetHelper")));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            onSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(onSaveInstanceState);
        extendableSavedState.f23858a.put("expandableWidgetHelper", this.f23354o.e());
        return extendableSavedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            k(this.f23352m);
            if (!this.f23352m.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void p(Rect rect) {
        int i10 = rect.left;
        Rect rect2 = this.f23351l;
        rect.left = i10 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    public final void q() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f23342c;
        if (colorStateList == null) {
            C.a.c(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f23343d;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(C0433g.e(colorForState, mode));
    }

    public void r(b bVar) {
        s(bVar, true);
    }

    public void s(b bVar, boolean z10) {
        getImpl().c0(t(bVar), z10);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f23340a != colorStateList) {
            this.f23340a = colorStateList;
            getImpl().L(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f23341b != mode) {
            this.f23341b = mode;
            getImpl().M(mode);
        }
    }

    public void setCompatElevation(float f10) {
        getImpl().N(f10);
    }

    public void setCompatElevationResource(int i10) {
        setCompatElevation(getResources().getDimension(i10));
    }

    public void setCompatHoveredFocusedTranslationZ(float f10) {
        getImpl().Q(f10);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i10) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i10));
    }

    public void setCompatPressedTranslationZ(float f10) {
        getImpl().U(f10);
    }

    public void setCompatPressedTranslationZResource(int i10) {
        setCompatPressedTranslationZ(getResources().getDimension(i10));
    }

    public void setCustomSize(int i10) {
        if (i10 >= 0) {
            if (i10 != this.f23347h) {
                this.f23347h = i10;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Custom size must be non-negative");
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        getImpl().g0(f10);
    }

    public void setEnsureMinTouchTargetSize(boolean z10) {
        if (z10 != getImpl().n()) {
            getImpl().O(z10);
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i10) {
        this.f23354o.f(i10);
    }

    public void setHideMotionSpec(C1008i c1008i) {
        getImpl().P(c1008i);
    }

    public void setHideMotionSpecResource(int i10) {
        setHideMotionSpec(C1008i.d(getContext(), i10));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().e0();
            if (this.f23342c != null) {
                q();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i10) {
        this.f23353n.i(i10);
        q();
    }

    public void setMaxImageSize(int i10) {
        this.f23349j = i10;
        getImpl().S(i10);
    }

    public void setRippleColor(int i10) {
        setRippleColor(ColorStateList.valueOf(i10));
    }

    @Override // android.view.View
    public void setScaleX(float f10) {
        super.setScaleX(f10);
        getImpl().I();
    }

    @Override // android.view.View
    public void setScaleY(float f10) {
        super.setScaleY(f10);
        getImpl().I();
    }

    public void setShadowPaddingEnabled(boolean z10) {
        getImpl().W(z10);
    }

    @Override // x4.r
    public void setShapeAppearanceModel(n nVar) {
        getImpl().X(nVar);
    }

    public void setShowMotionSpec(C1008i c1008i) {
        getImpl().Y(c1008i);
    }

    public void setShowMotionSpecResource(int i10) {
        setShowMotionSpec(C1008i.d(getContext(), i10));
    }

    public void setSize(int i10) {
        this.f23347h = 0;
        if (i10 != this.f23346g) {
            this.f23346g = i10;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f23342c != colorStateList) {
            this.f23342c = colorStateList;
            q();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f23343d != mode) {
            this.f23343d = mode;
            q();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f10) {
        super.setTranslationX(f10);
        getImpl().J();
    }

    @Override // android.view.View
    public void setTranslationY(float f10) {
        super.setTranslationY(f10);
        getImpl().J();
    }

    @Override // android.view.View
    public void setTranslationZ(float f10) {
        super.setTranslationZ(f10);
        getImpl().J();
    }

    public void setUseCompatPadding(boolean z10) {
        if (this.f23350k != z10) {
            this.f23350k = z10;
            getImpl().C();
        }
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    public final a.j t(b bVar) {
        if (bVar == null) {
            return null;
        }
        return new a(bVar);
    }

    /* loaded from: classes3.dex */
    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* renamed from: a, reason: collision with root package name */
        public Rect f23356a;

        /* renamed from: b, reason: collision with root package name */
        public b f23357b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f23358c;

        public BaseBehavior() {
            this.f23358c = true;
        }

        private static boolean isBottomSheet(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.e) {
                return ((CoordinatorLayout.e) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.f23351l;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        public final void b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i10;
            Rect rect = floatingActionButton.f23351l;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                CoordinatorLayout.e eVar = (CoordinatorLayout.e) floatingActionButton.getLayoutParams();
                int i11 = 0;
                if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) eVar).rightMargin) {
                    i10 = rect.right;
                } else if (floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) eVar).leftMargin) {
                    i10 = -rect.left;
                } else {
                    i10 = 0;
                }
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) {
                    i11 = rect.bottom;
                } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) eVar).topMargin) {
                    i11 = -rect.top;
                }
                if (i11 != 0) {
                    K.U(floatingActionButton, i11);
                }
                if (i10 != 0) {
                    K.T(floatingActionButton, i10);
                }
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                f(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (isBottomSheet(view)) {
                g(view, floatingActionButton);
                return false;
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i10) {
            List<View> p10 = coordinatorLayout.p(floatingActionButton);
            int size = p10.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view = p10.get(i11);
                if (view instanceof AppBarLayout) {
                    if (f(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (isBottomSheet(view) && g(view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.G(floatingActionButton, i10);
            b(coordinatorLayout, floatingActionButton);
            return true;
        }

        public final boolean e(View view, FloatingActionButton floatingActionButton) {
            CoordinatorLayout.e eVar = (CoordinatorLayout.e) floatingActionButton.getLayoutParams();
            if (!this.f23358c || eVar.e() != view.getId() || floatingActionButton.getUserSetVisibility() != 0) {
                return false;
            }
            return true;
        }

        public final boolean f(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!e(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f23356a == null) {
                this.f23356a = new Rect();
            }
            Rect rect = this.f23356a;
            DescendantOffsetUtils.getDescendantRect(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.m(this.f23357b, false);
                return true;
            }
            floatingActionButton.s(this.f23357b, false);
            return true;
        }

        public final boolean g(View view, FloatingActionButton floatingActionButton) {
            if (!e(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.e) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.m(this.f23357b, false);
                return true;
            }
            floatingActionButton.s(this.f23357b, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(CoordinatorLayout.e eVar) {
            if (eVar.f9323h == 0) {
                eVar.f9323h = 80;
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f31191N3);
            this.f23358c = obtainStyledAttributes.getBoolean(m.f31202O3, true);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public FloatingActionButton(android.content.Context r11, android.util.AttributeSet r12, int r13) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.FloatingActionButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f23344e != colorStateList) {
            this.f23344e = colorStateList;
            getImpl().V(this.f23344e);
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class b {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }
}
