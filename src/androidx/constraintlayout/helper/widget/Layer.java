package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.e;

/* loaded from: classes.dex */
public class Layer extends ConstraintHelper {

    /* renamed from: A, reason: collision with root package name */
    public boolean f7988A;

    /* renamed from: B, reason: collision with root package name */
    public View[] f7989B;

    /* renamed from: C, reason: collision with root package name */
    public float f7990C;

    /* renamed from: D, reason: collision with root package name */
    public float f7991D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f7992E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f7993F;

    /* renamed from: j, reason: collision with root package name */
    public float f7994j;

    /* renamed from: k, reason: collision with root package name */
    public float f7995k;

    /* renamed from: l, reason: collision with root package name */
    public float f7996l;

    /* renamed from: m, reason: collision with root package name */
    public ConstraintLayout f7997m;

    /* renamed from: n, reason: collision with root package name */
    public float f7998n;

    /* renamed from: o, reason: collision with root package name */
    public float f7999o;

    /* renamed from: p, reason: collision with root package name */
    public float f8000p;

    /* renamed from: q, reason: collision with root package name */
    public float f8001q;

    /* renamed from: r, reason: collision with root package name */
    public float f8002r;

    /* renamed from: x, reason: collision with root package name */
    public float f8003x;

    /* renamed from: y, reason: collision with root package name */
    public float f8004y;

    /* renamed from: z, reason: collision with root package name */
    public float f8005z;

    public Layer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7994j = Float.NaN;
        this.f7995k = Float.NaN;
        this.f7996l = Float.NaN;
        this.f7998n = 1.0f;
        this.f7999o = 1.0f;
        this.f8000p = Float.NaN;
        this.f8001q = Float.NaN;
        this.f8002r = Float.NaN;
        this.f8003x = Float.NaN;
        this.f8004y = Float.NaN;
        this.f8005z = Float.NaN;
        this.f7988A = true;
        this.f7989B = null;
        this.f7990C = 0.0f;
        this.f7991D = 0.0f;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void n(AttributeSet attributeSet) {
        super.n(attributeSet);
        this.f8639e = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, e.f9028a1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == e.f9098h1) {
                    this.f7992E = true;
                } else if (index == e.f9167o1) {
                    this.f7993F = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f7997m = (ConstraintLayout) getParent();
        if (this.f7992E || this.f7993F) {
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i10 = 0; i10 < this.f8636b; i10++) {
                View viewById = this.f7997m.getViewById(this.f8635a[i10]);
                if (viewById != null) {
                    if (this.f7992E) {
                        viewById.setVisibility(visibility);
                    }
                    if (this.f7993F && elevation > 0.0f) {
                        viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void q(ConstraintLayout constraintLayout) {
        x();
        this.f8000p = Float.NaN;
        this.f8001q = Float.NaN;
        ConstraintWidget constraintWidget = ((ConstraintLayout.LayoutParams) getLayoutParams()).getConstraintWidget();
        constraintWidget.Y0(0);
        constraintWidget.z0(0);
        w();
        layout(((int) this.f8004y) - getPaddingLeft(), ((int) this.f8005z) - getPaddingTop(), ((int) this.f8002r) + getPaddingRight(), ((int) this.f8003x) + getPaddingBottom());
        y();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void s(ConstraintLayout constraintLayout) {
        this.f7997m = constraintLayout;
        float rotation = getRotation();
        if (rotation == 0.0f) {
            if (!Float.isNaN(this.f7996l)) {
                this.f7996l = rotation;
                return;
            }
            return;
        }
        this.f7996l = rotation;
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        h();
    }

    @Override // android.view.View
    public void setPivotX(float f10) {
        this.f7994j = f10;
        y();
    }

    @Override // android.view.View
    public void setPivotY(float f10) {
        this.f7995k = f10;
        y();
    }

    @Override // android.view.View
    public void setRotation(float f10) {
        this.f7996l = f10;
        y();
    }

    @Override // android.view.View
    public void setScaleX(float f10) {
        this.f7998n = f10;
        y();
    }

    @Override // android.view.View
    public void setScaleY(float f10) {
        this.f7999o = f10;
        y();
    }

    @Override // android.view.View
    public void setTranslationX(float f10) {
        this.f7990C = f10;
        y();
    }

    @Override // android.view.View
    public void setTranslationY(float f10) {
        this.f7991D = f10;
        y();
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        h();
    }

    public void w() {
        if (this.f7997m == null) {
            return;
        }
        if (!this.f7988A && !Float.isNaN(this.f8000p) && !Float.isNaN(this.f8001q)) {
            return;
        }
        if (!Float.isNaN(this.f7994j) && !Float.isNaN(this.f7995k)) {
            this.f8001q = this.f7995k;
            this.f8000p = this.f7994j;
            return;
        }
        View[] m10 = m(this.f7997m);
        int left = m10[0].getLeft();
        int top = m10[0].getTop();
        int right = m10[0].getRight();
        int bottom = m10[0].getBottom();
        for (int i10 = 0; i10 < this.f8636b; i10++) {
            View view = m10[i10];
            left = Math.min(left, view.getLeft());
            top = Math.min(top, view.getTop());
            right = Math.max(right, view.getRight());
            bottom = Math.max(bottom, view.getBottom());
        }
        this.f8002r = right;
        this.f8003x = bottom;
        this.f8004y = left;
        this.f8005z = top;
        if (Float.isNaN(this.f7994j)) {
            this.f8000p = (left + right) / 2;
        } else {
            this.f8000p = this.f7994j;
        }
        if (Float.isNaN(this.f7995k)) {
            this.f8001q = (top + bottom) / 2;
        } else {
            this.f8001q = this.f7995k;
        }
    }

    public final void x() {
        int i10;
        if (this.f7997m == null || (i10 = this.f8636b) == 0) {
            return;
        }
        View[] viewArr = this.f7989B;
        if (viewArr == null || viewArr.length != i10) {
            this.f7989B = new View[i10];
        }
        for (int i11 = 0; i11 < this.f8636b; i11++) {
            this.f7989B[i11] = this.f7997m.getViewById(this.f8635a[i11]);
        }
    }

    public final void y() {
        double radians;
        if (this.f7997m == null) {
            return;
        }
        if (this.f7989B == null) {
            x();
        }
        w();
        if (Float.isNaN(this.f7996l)) {
            radians = 0.0d;
        } else {
            radians = Math.toRadians(this.f7996l);
        }
        float sin = (float) Math.sin(radians);
        float cos = (float) Math.cos(radians);
        float f10 = this.f7998n;
        float f11 = f10 * cos;
        float f12 = this.f7999o;
        float f13 = (-f12) * sin;
        float f14 = f10 * sin;
        float f15 = f12 * cos;
        for (int i10 = 0; i10 < this.f8636b; i10++) {
            View view = this.f7989B[i10];
            int left = (view.getLeft() + view.getRight()) / 2;
            int top = (view.getTop() + view.getBottom()) / 2;
            float f16 = left - this.f8000p;
            float f17 = top - this.f8001q;
            float f18 = (((f11 * f16) + (f13 * f17)) - f16) + this.f7990C;
            float f19 = (((f16 * f14) + (f15 * f17)) - f17) + this.f7991D;
            view.setTranslationX(f18);
            view.setTranslationY(f19);
            view.setScaleY(this.f7999o);
            view.setScaleX(this.f7998n);
            if (!Float.isNaN(this.f7996l)) {
                view.setRotation(this.f7996l);
            }
        }
    }
}
