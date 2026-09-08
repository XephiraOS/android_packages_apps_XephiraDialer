package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.e;

/* loaded from: classes.dex */
public class MotionHelper extends ConstraintHelper implements MotionLayout.i {

    /* renamed from: j, reason: collision with root package name */
    public boolean f8006j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f8007k;

    /* renamed from: l, reason: collision with root package name */
    public float f8008l;

    /* renamed from: m, reason: collision with root package name */
    public View[] f8009m;

    public MotionHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8006j = false;
        this.f8007k = false;
        n(attributeSet);
    }

    public float getProgress() {
        return this.f8008l;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void n(AttributeSet attributeSet) {
        super.n(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, e.f8844F6);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == e.f8862H6) {
                    this.f8006j = obtainStyledAttributes.getBoolean(index, this.f8006j);
                } else if (index == e.f8853G6) {
                    this.f8007k = obtainStyledAttributes.getBoolean(index, this.f8007k);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void setProgress(float f10) {
        this.f8008l = f10;
        int i10 = 0;
        if (this.f8636b > 0) {
            this.f8009m = m((ConstraintLayout) getParent());
            while (i10 < this.f8636b) {
                y(this.f8009m[i10], f10);
                i10++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i10 < childCount) {
            View childAt = viewGroup.getChildAt(i10);
            if (!(childAt instanceof MotionHelper)) {
                y(childAt, f10);
            }
            i10++;
        }
    }

    public boolean w() {
        return this.f8007k;
    }

    public boolean x() {
        return this.f8006j;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
    public void d(MotionLayout motionLayout, int i10) {
    }

    public void y(View view, float f10) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
    public void b(MotionLayout motionLayout, int i10, int i11) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
    public void a(MotionLayout motionLayout, int i10, int i11, float f10) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
    public void c(MotionLayout motionLayout, int i10, boolean z10, float f10) {
    }
}
