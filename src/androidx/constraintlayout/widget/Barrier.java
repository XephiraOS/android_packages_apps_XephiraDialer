package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.b;
import v.C1616b;

/* loaded from: classes.dex */
public class Barrier extends ConstraintHelper {

    /* renamed from: j, reason: collision with root package name */
    public int f8616j;

    /* renamed from: k, reason: collision with root package name */
    public int f8617k;

    /* renamed from: l, reason: collision with root package name */
    public androidx.constraintlayout.solver.widgets.a f8618l;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public int getMargin() {
        return this.f8618l.j1();
    }

    public int getType() {
        return this.f8616j;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void n(AttributeSet attributeSet) {
        super.n(attributeSet);
        this.f8618l = new androidx.constraintlayout.solver.widgets.a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, e.f9028a1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == e.f9185q1) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == e.f9176p1) {
                    this.f8618l.m1(obtainStyledAttributes.getBoolean(index, true));
                } else if (index == e.f9194r1) {
                    this.f8618l.o1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f8638d = this.f8618l;
        v();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void o(b.a aVar, C1616b c1616b, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        super.o(aVar, c1616b, layoutParams, sparseArray);
        if (c1616b instanceof androidx.constraintlayout.solver.widgets.a) {
            androidx.constraintlayout.solver.widgets.a aVar2 = (androidx.constraintlayout.solver.widgets.a) c1616b;
            x(aVar2, aVar.f8698d.f8731b0, ((androidx.constraintlayout.solver.widgets.d) c1616b.L()).D1());
            aVar2.m1(aVar.f8698d.f8747j0);
            aVar2.o1(aVar.f8698d.f8733c0);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void p(ConstraintWidget constraintWidget, boolean z10) {
        x(constraintWidget, this.f8616j, z10);
    }

    public void setAllowsGoneWidget(boolean z10) {
        this.f8618l.m1(z10);
    }

    public void setDpMargin(int i10) {
        this.f8618l.o1((int) ((i10 * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i10) {
        this.f8618l.o1(i10);
    }

    public void setType(int i10) {
        this.f8616j = i10;
    }

    public boolean w() {
        return this.f8618l.h1();
    }

    public final void x(ConstraintWidget constraintWidget, int i10, boolean z10) {
        this.f8617k = i10;
        if (z10) {
            int i11 = this.f8616j;
            if (i11 == 5) {
                this.f8617k = 1;
            } else if (i11 == 6) {
                this.f8617k = 0;
            }
        } else {
            int i12 = this.f8616j;
            if (i12 == 5) {
                this.f8617k = 0;
            } else if (i12 == 6) {
                this.f8617k = 1;
            }
        }
        if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.a) {
            ((androidx.constraintlayout.solver.widgets.a) constraintWidget).n1(this.f8617k);
        }
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }
}
