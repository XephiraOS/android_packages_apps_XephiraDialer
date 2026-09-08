package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public boolean f7465a;

    /* renamed from: b, reason: collision with root package name */
    public View f7466b;

    /* renamed from: c, reason: collision with root package name */
    public View f7467c;

    /* renamed from: d, reason: collision with root package name */
    public View f7468d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f7469e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f7470f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable f7471g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f7472h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f7473i;

    /* renamed from: j, reason: collision with root package name */
    public int f7474j;

    /* loaded from: classes.dex */
    public static class a {
        public static void a(ActionBarContainer actionBarContainer) {
            actionBarContainer.invalidateOutline();
        }
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackground(new C0428b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.j.f30412a);
        this.f7469e = obtainStyledAttributes.getDrawable(e.j.f30418b);
        this.f7470f = obtainStyledAttributes.getDrawable(e.j.f30430d);
        this.f7474j = obtainStyledAttributes.getDimensionPixelSize(e.j.f30460j, -1);
        boolean z10 = true;
        if (getId() == e.f.f30205M) {
            this.f7472h = true;
            this.f7471g = obtainStyledAttributes.getDrawable(e.j.f30424c);
        }
        obtainStyledAttributes.recycle();
        if (!this.f7472h ? this.f7469e != null || this.f7470f != null : this.f7471g != null) {
            z10 = false;
        }
        setWillNotDraw(z10);
    }

    public final int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public final boolean b(View view) {
        if (view != null && view.getVisibility() != 8 && view.getMeasuredHeight() != 0) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f7469e;
        if (drawable != null && drawable.isStateful()) {
            this.f7469e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f7470f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f7470f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f7471g;
        if (drawable3 != null && drawable3.isStateful()) {
            this.f7471g.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.f7466b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f7469e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f7470f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f7471g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f7467c = findViewById(e.f.f30214a);
        this.f7468d = findViewById(e.f.f30219f);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f7465a && !super.onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        boolean z11;
        Drawable drawable;
        super.onLayout(z10, i10, i11, i12, i13);
        View view = this.f7466b;
        boolean z12 = true;
        if (view != null && view.getVisibility() != 8) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            int measuredHeight2 = measuredHeight - view.getMeasuredHeight();
            int i14 = layoutParams.bottomMargin;
            view.layout(i10, measuredHeight2 - i14, i12, measuredHeight - i14);
        }
        if (this.f7472h) {
            Drawable drawable2 = this.f7471g;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                return;
            }
        } else {
            if (this.f7469e != null) {
                if (this.f7467c.getVisibility() == 0) {
                    this.f7469e.setBounds(this.f7467c.getLeft(), this.f7467c.getTop(), this.f7467c.getRight(), this.f7467c.getBottom());
                } else {
                    View view2 = this.f7468d;
                    if (view2 != null && view2.getVisibility() == 0) {
                        this.f7469e.setBounds(this.f7468d.getLeft(), this.f7468d.getTop(), this.f7468d.getRight(), this.f7468d.getBottom());
                    } else {
                        this.f7469e.setBounds(0, 0, 0, 0);
                    }
                }
            } else {
                z12 = false;
            }
            this.f7473i = z11;
            if (z11 && (drawable = this.f7470f) != null) {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            } else if (!z12) {
                return;
            }
        }
        invalidate();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        if (this.f7467c == null && View.MeasureSpec.getMode(i11) == Integer.MIN_VALUE && (i14 = this.f7474j) >= 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(Math.min(i14, View.MeasureSpec.getSize(i11)), Integer.MIN_VALUE);
        }
        super.onMeasure(i10, i11);
        if (this.f7467c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i11);
        View view = this.f7466b;
        if (view != null && view.getVisibility() != 8 && mode != 1073741824) {
            if (!b(this.f7467c)) {
                i12 = a(this.f7467c);
            } else if (!b(this.f7468d)) {
                i12 = a(this.f7468d);
            } else {
                i12 = 0;
            }
            if (mode == Integer.MIN_VALUE) {
                i13 = View.MeasureSpec.getSize(i11);
            } else {
                i13 = Integer.MAX_VALUE;
            }
            setMeasuredDimension(getMeasuredWidth(), Math.min(i12 + a(this.f7466b), i13));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f7469e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f7469e);
        }
        this.f7469e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f7467c;
            if (view != null) {
                this.f7469e.setBounds(view.getLeft(), this.f7467c.getTop(), this.f7467c.getRight(), this.f7467c.getBottom());
            }
        }
        boolean z10 = false;
        if (!this.f7472h ? !(this.f7469e != null || this.f7470f != null) : this.f7471g == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        a.a(this);
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f7471g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f7471g);
        }
        this.f7471g = drawable;
        boolean z10 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f7472h && (drawable2 = this.f7471g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f7472h ? !(this.f7469e != null || this.f7470f != null) : this.f7471g == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        a.a(this);
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f7470f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f7470f);
        }
        this.f7470f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f7473i && (drawable2 = this.f7470f) != null) {
                drawable2.setBounds(this.f7466b.getLeft(), this.f7466b.getTop(), this.f7466b.getRight(), this.f7466b.getBottom());
            }
        }
        boolean z10 = false;
        if (!this.f7472h ? !(this.f7469e != null || this.f7470f != null) : this.f7471g == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        a.a(this);
    }

    public void setTabContainer(D d10) {
        View view = this.f7466b;
        if (view != null) {
            removeView(view);
        }
        this.f7466b = d10;
        if (d10 != null) {
            addView(d10);
            ViewGroup.LayoutParams layoutParams = d10.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            d10.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z10) {
        int i10;
        this.f7465a = z10;
        if (z10) {
            i10 = 393216;
        } else {
            i10 = 262144;
        }
        setDescendantFocusability(i10);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        boolean z10;
        super.setVisibility(i10);
        if (i10 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Drawable drawable = this.f7469e;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
        Drawable drawable2 = this.f7470f;
        if (drawable2 != null) {
            drawable2.setVisible(z10, false);
        }
        Drawable drawable3 = this.f7471g;
        if (drawable3 != null) {
            drawable3.setVisible(z10, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        if ((drawable == this.f7469e && !this.f7472h) || ((drawable == this.f7470f && this.f7473i) || ((drawable == this.f7471g && this.f7472h) || super.verifyDrawable(drawable)))) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i10) {
        if (i10 != 0) {
            return super.startActionModeForChild(view, callback, i10);
        }
        return null;
    }
}
