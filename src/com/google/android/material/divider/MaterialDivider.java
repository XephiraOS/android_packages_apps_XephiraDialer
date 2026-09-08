package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.b;
import androidx.core.view.K;
import e4.C0977c;
import e4.l;
import x4.i;

/* loaded from: classes3.dex */
public class MaterialDivider extends View {

    /* renamed from: f, reason: collision with root package name */
    public static final int f23292f = l.f31010L;

    /* renamed from: a, reason: collision with root package name */
    public final i f23293a;

    /* renamed from: b, reason: collision with root package name */
    public int f23294b;

    /* renamed from: c, reason: collision with root package name */
    public int f23295c;

    /* renamed from: d, reason: collision with root package name */
    public int f23296d;

    /* renamed from: e, reason: collision with root package name */
    public int f23297e;

    public MaterialDivider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0977c.f30643O);
    }

    public int getDividerColor() {
        return this.f23295c;
    }

    public int getDividerInsetEnd() {
        return this.f23297e;
    }

    public int getDividerInsetStart() {
        return this.f23296d;
    }

    public int getDividerThickness() {
        return this.f23294b;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i10;
        int width;
        int i11;
        super.onDraw(canvas);
        boolean z10 = true;
        if (K.v(this) != 1) {
            z10 = false;
        }
        if (z10) {
            i10 = this.f23297e;
        } else {
            i10 = this.f23296d;
        }
        if (z10) {
            width = getWidth();
            i11 = this.f23296d;
        } else {
            width = getWidth();
            i11 = this.f23297e;
        }
        this.f23293a.setBounds(i10, 0, width - i11, getBottom() - getTop());
        this.f23293a.draw(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i11);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i12 = this.f23294b;
            if (i12 > 0 && measuredHeight != i12) {
                measuredHeight = i12;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(int i10) {
        if (this.f23295c != i10) {
            this.f23295c = i10;
            this.f23293a.setFillColor(ColorStateList.valueOf(i10));
            invalidate();
        }
    }

    public void setDividerColorResource(int i10) {
        setDividerColor(b.c(getContext(), i10));
    }

    public void setDividerInsetEnd(int i10) {
        this.f23297e = i10;
    }

    public void setDividerInsetEndResource(int i10) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i10));
    }

    public void setDividerInsetStart(int i10) {
        this.f23296d = i10;
    }

    public void setDividerInsetStartResource(int i10) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i10));
    }

    public void setDividerThickness(int i10) {
        if (this.f23294b != i10) {
            this.f23294b = i10;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(int i10) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i10));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialDivider(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = com.google.android.material.divider.MaterialDivider.f23292f
            android.content.Context r8 = B4.a.c(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.content.Context r8 = r7.getContext()
            x4.i r0 = new x4.i
            r0.<init>()
            r7.f23293a = r0
            int[] r2 = e4.m.f31292W5
            r6 = 0
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r10 = e4.m.f31335a6
            android.content.res.Resources r0 = r7.getResources()
            int r1 = e4.C0979e.f30761T
            int r0 = r0.getDimensionPixelSize(r1)
            int r10 = r9.getDimensionPixelSize(r10, r0)
            r7.f23294b = r10
            int r10 = e4.m.f31324Z5
            int r10 = r9.getDimensionPixelOffset(r10, r6)
            r7.f23296d = r10
            int r10 = e4.m.f31314Y5
            int r10 = r9.getDimensionPixelOffset(r10, r6)
            r7.f23297e = r10
            int r10 = e4.m.f31303X5
            android.content.res.ColorStateList r8 = u4.C1607c.a(r8, r9, r10)
            int r8 = r8.getDefaultColor()
            r7.setDividerColor(r8)
            r9.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.divider.MaterialDivider.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
