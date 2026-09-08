package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public class Constraints extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public b f8654a;

    public Constraints(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(attributeSet);
        super.setVisibility(8);
    }

    @Override // android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public final void c(AttributeSet attributeSet) {
        Log.v("Constraints", " ################# init");
    }

    public b getConstraintSet() {
        if (this.f8654a == null) {
            this.f8654a = new b();
        }
        this.f8654a.j(this);
        return this.f8654a;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.LayoutParams(layoutParams);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ConstraintLayout.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public float f8655a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f8656b;

        /* renamed from: c, reason: collision with root package name */
        public float f8657c;

        /* renamed from: d, reason: collision with root package name */
        public float f8658d;

        /* renamed from: e, reason: collision with root package name */
        public float f8659e;

        /* renamed from: f, reason: collision with root package name */
        public float f8660f;

        /* renamed from: g, reason: collision with root package name */
        public float f8661g;

        /* renamed from: h, reason: collision with root package name */
        public float f8662h;

        /* renamed from: i, reason: collision with root package name */
        public float f8663i;

        /* renamed from: j, reason: collision with root package name */
        public float f8664j;

        /* renamed from: k, reason: collision with root package name */
        public float f8665k;

        /* renamed from: l, reason: collision with root package name */
        public float f8666l;

        /* renamed from: m, reason: collision with root package name */
        public float f8667m;

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
            this.f8655a = 1.0f;
            this.f8656b = false;
            this.f8657c = 0.0f;
            this.f8658d = 0.0f;
            this.f8659e = 0.0f;
            this.f8660f = 0.0f;
            this.f8661g = 1.0f;
            this.f8662h = 1.0f;
            this.f8663i = 0.0f;
            this.f8664j = 0.0f;
            this.f8665k = 0.0f;
            this.f8666l = 0.0f;
            this.f8667m = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f8655a = 1.0f;
            this.f8656b = false;
            this.f8657c = 0.0f;
            this.f8658d = 0.0f;
            this.f8659e = 0.0f;
            this.f8660f = 0.0f;
            this.f8661g = 1.0f;
            this.f8662h = 1.0f;
            this.f8663i = 0.0f;
            this.f8664j = 0.0f;
            this.f8665k = 0.0f;
            this.f8666l = 0.0f;
            this.f8667m = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.f8939Q2);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == e.f8948R2) {
                    this.f8655a = obtainStyledAttributes.getFloat(index, this.f8655a);
                } else if (index == e.f9050c3) {
                    this.f8657c = obtainStyledAttributes.getFloat(index, this.f8657c);
                    this.f8656b = true;
                } else if (index == e.f9020Z2) {
                    this.f8659e = obtainStyledAttributes.getFloat(index, this.f8659e);
                } else if (index == e.f9030a3) {
                    this.f8660f = obtainStyledAttributes.getFloat(index, this.f8660f);
                } else if (index == e.f9011Y2) {
                    this.f8658d = obtainStyledAttributes.getFloat(index, this.f8658d);
                } else if (index == e.f8993W2) {
                    this.f8661g = obtainStyledAttributes.getFloat(index, this.f8661g);
                } else if (index == e.f9002X2) {
                    this.f8662h = obtainStyledAttributes.getFloat(index, this.f8662h);
                } else if (index == e.f8957S2) {
                    this.f8663i = obtainStyledAttributes.getFloat(index, this.f8663i);
                } else if (index == e.f8966T2) {
                    this.f8664j = obtainStyledAttributes.getFloat(index, this.f8664j);
                } else if (index == e.f8975U2) {
                    this.f8665k = obtainStyledAttributes.getFloat(index, this.f8665k);
                } else if (index == e.f8984V2) {
                    this.f8666l = obtainStyledAttributes.getFloat(index, this.f8666l);
                } else if (index == e.f9040b3) {
                    this.f8667m = obtainStyledAttributes.getFloat(index, this.f8667m);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
    }
}
