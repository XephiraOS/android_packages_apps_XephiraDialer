package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.e;
import androidx.constraintlayout.solver.widgets.h;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.VirtualLayout;
import androidx.constraintlayout.widget.b;
import v.C1616b;

/* loaded from: classes.dex */
public class Flow extends VirtualLayout {

    /* renamed from: l, reason: collision with root package name */
    public e f7987l;

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public void n(AttributeSet attributeSet) {
        super.n(attributeSet);
        this.f7987l = new e();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.e.f9028a1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == androidx.constraintlayout.widget.e.f9038b1) {
                    this.f7987l.o2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == androidx.constraintlayout.widget.e.f9048c1) {
                    this.f7987l.u1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == androidx.constraintlayout.widget.e.f9148m1) {
                    this.f7987l.z1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == androidx.constraintlayout.widget.e.f9158n1) {
                    this.f7987l.w1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == androidx.constraintlayout.widget.e.f9058d1) {
                    this.f7987l.x1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == androidx.constraintlayout.widget.e.f9068e1) {
                    this.f7987l.A1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == androidx.constraintlayout.widget.e.f9078f1) {
                    this.f7987l.y1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == androidx.constraintlayout.widget.e.f9088g1) {
                    this.f7987l.v1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == androidx.constraintlayout.widget.e.f8902M1) {
                    this.f7987l.t2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == androidx.constraintlayout.widget.e.f8812C1) {
                    this.f7987l.i2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == androidx.constraintlayout.widget.e.f8893L1) {
                    this.f7987l.s2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == androidx.constraintlayout.widget.e.f9239w1) {
                    this.f7987l.c2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == androidx.constraintlayout.widget.e.f8830E1) {
                    this.f7987l.k2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == androidx.constraintlayout.widget.e.f9257y1) {
                    this.f7987l.e2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == androidx.constraintlayout.widget.e.f8848G1) {
                    this.f7987l.m2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == androidx.constraintlayout.widget.e.f8794A1) {
                    this.f7987l.g2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == androidx.constraintlayout.widget.e.f9230v1) {
                    this.f7987l.b2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == androidx.constraintlayout.widget.e.f8821D1) {
                    this.f7987l.j2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == androidx.constraintlayout.widget.e.f9248x1) {
                    this.f7987l.d2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == androidx.constraintlayout.widget.e.f8839F1) {
                    this.f7987l.l2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == androidx.constraintlayout.widget.e.f8875J1) {
                    this.f7987l.q2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == androidx.constraintlayout.widget.e.f9266z1) {
                    this.f7987l.f2(obtainStyledAttributes.getInt(index, 2));
                } else if (index == androidx.constraintlayout.widget.e.f8866I1) {
                    this.f7987l.p2(obtainStyledAttributes.getInt(index, 2));
                } else if (index == androidx.constraintlayout.widget.e.f8803B1) {
                    this.f7987l.h2(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == androidx.constraintlayout.widget.e.f8884K1) {
                    this.f7987l.r2(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == androidx.constraintlayout.widget.e.f8857H1) {
                    this.f7987l.n2(obtainStyledAttributes.getInt(index, -1));
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f8638d = this.f7987l;
        v();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void o(b.a aVar, C1616b c1616b, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        super.o(aVar, c1616b, layoutParams, sparseArray);
        if (c1616b instanceof e) {
            e eVar = (e) c1616b;
            int i10 = layoutParams.orientation;
            if (i10 != -1) {
                eVar.o2(i10);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onMeasure(int i10, int i11) {
        w(this.f7987l, i10, i11);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void p(ConstraintWidget constraintWidget, boolean z10) {
        this.f7987l.g1(z10);
    }

    public void setFirstHorizontalBias(float f10) {
        this.f7987l.b2(f10);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i10) {
        this.f7987l.c2(i10);
        requestLayout();
    }

    public void setFirstVerticalBias(float f10) {
        this.f7987l.d2(f10);
        requestLayout();
    }

    public void setFirstVerticalStyle(int i10) {
        this.f7987l.e2(i10);
        requestLayout();
    }

    public void setHorizontalAlign(int i10) {
        this.f7987l.f2(i10);
        requestLayout();
    }

    public void setHorizontalBias(float f10) {
        this.f7987l.g2(f10);
        requestLayout();
    }

    public void setHorizontalGap(int i10) {
        this.f7987l.h2(i10);
        requestLayout();
    }

    public void setHorizontalStyle(int i10) {
        this.f7987l.i2(i10);
        requestLayout();
    }

    public void setMaxElementsWrap(int i10) {
        this.f7987l.n2(i10);
        requestLayout();
    }

    public void setOrientation(int i10) {
        this.f7987l.o2(i10);
        requestLayout();
    }

    public void setPadding(int i10) {
        this.f7987l.u1(i10);
        requestLayout();
    }

    public void setPaddingBottom(int i10) {
        this.f7987l.v1(i10);
        requestLayout();
    }

    public void setPaddingLeft(int i10) {
        this.f7987l.x1(i10);
        requestLayout();
    }

    public void setPaddingRight(int i10) {
        this.f7987l.y1(i10);
        requestLayout();
    }

    public void setPaddingTop(int i10) {
        this.f7987l.A1(i10);
        requestLayout();
    }

    public void setVerticalAlign(int i10) {
        this.f7987l.p2(i10);
        requestLayout();
    }

    public void setVerticalBias(float f10) {
        this.f7987l.q2(f10);
        requestLayout();
    }

    public void setVerticalGap(int i10) {
        this.f7987l.r2(i10);
        requestLayout();
    }

    public void setVerticalStyle(int i10) {
        this.f7987l.s2(i10);
        requestLayout();
    }

    public void setWrapMode(int i10) {
        this.f7987l.t2(i10);
        requestLayout();
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout
    public void w(h hVar, int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (hVar != null) {
            hVar.o1(mode, size, mode2, size2);
            setMeasuredDimension(hVar.j1(), hVar.i1());
        } else {
            setMeasuredDimension(0, 0);
        }
    }
}
