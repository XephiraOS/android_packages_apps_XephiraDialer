package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public boolean f7645a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7646b;

    /* renamed from: c, reason: collision with root package name */
    public int f7647c;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7647c = -1;
        int[] iArr = e.j.f30358P0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        androidx.core.view.K.h0(this, context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        this.f7645a = obtainStyledAttributes.getBoolean(e.j.f30363Q0, true);
        obtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f7645a);
        }
    }

    private void setStacked(boolean z10) {
        int i10;
        int i11;
        if (this.f7646b != z10) {
            if (!z10 || this.f7645a) {
                this.f7646b = z10;
                setOrientation(z10 ? 1 : 0);
                if (z10) {
                    i10 = 8388613;
                } else {
                    i10 = 80;
                }
                setGravity(i10);
                View findViewById = findViewById(e.f.f30204L);
                if (findViewById != null) {
                    if (z10) {
                        i11 = 8;
                    } else {
                        i11 = 4;
                    }
                    findViewById.setVisibility(i11);
                }
                for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                    bringChildToFront(getChildAt(childCount));
                }
            }
        }
    }

    public final int a(int i10) {
        int childCount = getChildCount();
        while (i10 < childCount) {
            if (getChildAt(i10).getVisibility() == 0) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public final boolean b() {
        return this.f7646b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x004d, code lost:
    
        if (r1 != false) goto L24;
     */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = android.view.View.MeasureSpec.getSize(r6)
            boolean r1 = r5.f7645a
            r2 = 0
            if (r1 == 0) goto L18
            int r1 = r5.f7647c
            if (r0 <= r1) goto L16
            boolean r1 = r5.b()
            if (r1 == 0) goto L16
            r5.setStacked(r2)
        L16:
            r5.f7647c = r0
        L18:
            boolean r1 = r5.b()
            r3 = 1
            if (r1 != 0) goto L2f
            int r1 = android.view.View.MeasureSpec.getMode(r6)
            r4 = 1073741824(0x40000000, float:2.0)
            if (r1 != r4) goto L2f
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1)
            r1 = r3
            goto L31
        L2f:
            r0 = r6
            r1 = r2
        L31:
            super.onMeasure(r0, r7)
            boolean r0 = r5.f7645a
            if (r0 == 0) goto L4d
            boolean r0 = r5.b()
            if (r0 != 0) goto L4d
            int r0 = r5.getMeasuredWidthAndState()
            r4 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0 = r0 & r4
            r4 = 16777216(0x1000000, float:2.3509887E-38)
            if (r0 != r4) goto L4d
            r5.setStacked(r3)
            goto L4f
        L4d:
            if (r1 == 0) goto L52
        L4f:
            super.onMeasure(r6, r7)
        L52:
            int r0 = r5.a(r2)
            if (r0 < 0) goto L9e
            android.view.View r1 = r5.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r2 = (android.widget.LinearLayout.LayoutParams) r2
            int r4 = r5.getPaddingTop()
            int r1 = r1.getMeasuredHeight()
            int r4 = r4 + r1
            int r1 = r2.topMargin
            int r4 = r4 + r1
            int r1 = r2.bottomMargin
            int r4 = r4 + r1
            boolean r1 = r5.b()
            if (r1 == 0) goto L98
            int r0 = r0 + r3
            int r0 = r5.a(r0)
            if (r0 < 0) goto L96
            android.view.View r0 = r5.getChildAt(r0)
            int r0 = r0.getPaddingTop()
            android.content.res.Resources r1 = r5.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            float r1 = r1.density
            r2 = 1098907648(0x41800000, float:16.0)
            float r1 = r1 * r2
            int r1 = (int) r1
            int r0 = r0 + r1
            int r4 = r4 + r0
        L96:
            r2 = r4
            goto L9e
        L98:
            int r0 = r5.getPaddingBottom()
            int r2 = r4 + r0
        L9e:
            int r0 = androidx.core.view.K.x(r5)
            if (r0 == r2) goto Lac
            r5.setMinimumHeight(r2)
            if (r7 != 0) goto Lac
            super.onMeasure(r6, r7)
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ButtonBarLayout.onMeasure(int, int):void");
    }

    public void setAllowStacking(boolean z10) {
        if (this.f7645a != z10) {
            this.f7645a = z10;
            if (!z10 && b()) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
