package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public class Placeholder extends View {

    /* renamed from: a, reason: collision with root package name */
    public int f8668a;

    /* renamed from: b, reason: collision with root package name */
    public View f8669b;

    /* renamed from: c, reason: collision with root package name */
    public int f8670c;

    public Placeholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8668a = -1;
        this.f8669b = null;
        this.f8670c = 4;
        a(attributeSet);
    }

    public final void a(AttributeSet attributeSet) {
        super.setVisibility(this.f8670c);
        this.f8668a = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, e.f8912N2);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == e.f8921O2) {
                    this.f8668a = obtainStyledAttributes.getResourceId(index, this.f8668a);
                } else if (index == e.f8930P2) {
                    this.f8670c = obtainStyledAttributes.getInt(index, this.f8670c);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void b(ConstraintLayout constraintLayout) {
        if (this.f8669b == null) {
            return;
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f8669b.getLayoutParams();
        layoutParams2.widget.X0(0);
        ConstraintWidget.DimensionBehaviour B10 = layoutParams.widget.B();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        if (B10 != dimensionBehaviour) {
            layoutParams.widget.Y0(layoutParams2.widget.U());
        }
        if (layoutParams.widget.R() != dimensionBehaviour) {
            layoutParams.widget.z0(layoutParams2.widget.y());
        }
        layoutParams2.widget.X0(8);
    }

    public void c(ConstraintLayout constraintLayout) {
        if (this.f8668a == -1 && !isInEditMode()) {
            setVisibility(this.f8670c);
        }
        View findViewById = constraintLayout.findViewById(this.f8668a);
        this.f8669b = findViewById;
        if (findViewById != null) {
            ((ConstraintLayout.LayoutParams) findViewById.getLayoutParams()).isInPlaceholder = true;
            this.f8669b.setVisibility(0);
            setVisibility(0);
        }
    }

    public View getContent() {
        return this.f8669b;
    }

    public int getEmptyVisibility() {
        return this.f8670c;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((width / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((height / 2.0f) + (rect.height() / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i10) {
        View findViewById;
        if (this.f8668a == i10) {
            return;
        }
        View view = this.f8669b;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.LayoutParams) this.f8669b.getLayoutParams()).isInPlaceholder = false;
            this.f8669b = null;
        }
        this.f8668a = i10;
        if (i10 != -1 && (findViewById = ((View) getParent()).findViewById(i10)) != null) {
            findViewById.setVisibility(8);
        }
    }

    public void setEmptyVisibility(int i10) {
        this.f8670c = i10;
    }
}
