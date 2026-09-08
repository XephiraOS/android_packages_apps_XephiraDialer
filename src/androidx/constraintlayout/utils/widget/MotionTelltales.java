package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.e;

/* loaded from: classes.dex */
public class MotionTelltales extends MockView {

    /* renamed from: l, reason: collision with root package name */
    public Paint f8609l;

    /* renamed from: m, reason: collision with root package name */
    public MotionLayout f8610m;

    /* renamed from: n, reason: collision with root package name */
    public float[] f8611n;

    /* renamed from: o, reason: collision with root package name */
    public Matrix f8612o;

    /* renamed from: p, reason: collision with root package name */
    public int f8613p;

    /* renamed from: q, reason: collision with root package name */
    public int f8614q;

    /* renamed from: r, reason: collision with root package name */
    public float f8615r;

    public MotionTelltales(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8609l = new Paint();
        this.f8611n = new float[2];
        this.f8612o = new Matrix();
        this.f8613p = 0;
        this.f8614q = -65281;
        this.f8615r = 0.25f;
        a(context, attributeSet);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.f8961S6);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == e.f8970T6) {
                    this.f8614q = obtainStyledAttributes.getColor(index, this.f8614q);
                } else if (index == e.f8988V6) {
                    this.f8613p = obtainStyledAttributes.getInt(index, this.f8613p);
                } else if (index == e.f8979U6) {
                    this.f8615r = obtainStyledAttributes.getFloat(index, this.f8615r);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f8609l.setColor(this.f8614q);
        this.f8609l.setStrokeWidth(5.0f);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // androidx.constraintlayout.utils.widget.MockView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getMatrix().invert(this.f8612o);
        if (this.f8610m == null) {
            ViewParent parent = getParent();
            if (parent instanceof MotionLayout) {
                this.f8610m = (MotionLayout) parent;
                return;
            }
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float[] fArr = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        for (int i10 = 0; i10 < 5; i10++) {
            float f10 = fArr[i10];
            for (int i11 = 0; i11 < 5; i11++) {
                float f11 = fArr[i11];
                this.f8610m.O(this, f11, f10, this.f8611n, this.f8613p);
                this.f8612o.mapVectors(this.f8611n);
                float f12 = width * f11;
                float f13 = height * f10;
                float[] fArr2 = this.f8611n;
                float f14 = fArr2[0];
                float f15 = this.f8615r;
                float f16 = f13 - (fArr2[1] * f15);
                this.f8612o.mapVectors(fArr2);
                canvas.drawLine(f12, f13, f12 - (f14 * f15), f16, this.f8609l);
            }
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        postInvalidate();
    }

    public void setText(CharSequence charSequence) {
        this.f8603f = charSequence.toString();
        requestLayout();
    }
}
