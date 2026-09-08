package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import e4.C0977c;
import e4.l;
import t4.c;
import t4.e;
import t4.i;

/* loaded from: classes3.dex */
public class CircularProgressIndicator extends a<CircularProgressIndicatorSpec> {

    /* renamed from: p, reason: collision with root package name */
    public static final int f23515p = l.f31002D;

    public CircularProgressIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0977c.f30677l);
    }

    public int getIndicatorDirection() {
        return ((CircularProgressIndicatorSpec) this.f23525a).f23518j;
    }

    public int getIndicatorInset() {
        return ((CircularProgressIndicatorSpec) this.f23525a).f23517i;
    }

    public int getIndicatorSize() {
        return ((CircularProgressIndicatorSpec) this.f23525a).f23516h;
    }

    @Override // com.google.android.material.progressindicator.a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public CircularProgressIndicatorSpec i(Context context, AttributeSet attributeSet) {
        return new CircularProgressIndicatorSpec(context, attributeSet);
    }

    public final void s() {
        c cVar = new c((CircularProgressIndicatorSpec) this.f23525a);
        setIndeterminateDrawable(i.t(getContext(), (CircularProgressIndicatorSpec) this.f23525a, cVar));
        setProgressDrawable(e.v(getContext(), (CircularProgressIndicatorSpec) this.f23525a, cVar));
    }

    public void setIndicatorDirection(int i10) {
        ((CircularProgressIndicatorSpec) this.f23525a).f23518j = i10;
        invalidate();
    }

    public void setIndicatorInset(int i10) {
        S s10 = this.f23525a;
        if (((CircularProgressIndicatorSpec) s10).f23517i != i10) {
            ((CircularProgressIndicatorSpec) s10).f23517i = i10;
            invalidate();
        }
    }

    public void setIndicatorSize(int i10) {
        int max = Math.max(i10, getTrackThickness() * 2);
        S s10 = this.f23525a;
        if (((CircularProgressIndicatorSpec) s10).f23516h != max) {
            ((CircularProgressIndicatorSpec) s10).f23516h = max;
            ((CircularProgressIndicatorSpec) s10).e();
            requestLayout();
            invalidate();
        }
    }

    @Override // com.google.android.material.progressindicator.a
    public void setTrackThickness(int i10) {
        super.setTrackThickness(i10);
        ((CircularProgressIndicatorSpec) this.f23525a).e();
    }

    public CircularProgressIndicator(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10, f23515p);
        s();
    }
}
