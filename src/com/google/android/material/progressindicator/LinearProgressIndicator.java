package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.view.K;
import e4.C0977c;
import e4.l;
import t4.e;
import t4.i;
import t4.j;
import t4.k;

/* loaded from: classes3.dex */
public class LinearProgressIndicator extends a<LinearProgressIndicatorSpec> {

    /* renamed from: p, reason: collision with root package name */
    public static final int f23519p = l.f31007I;

    public LinearProgressIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0977c.f30635G);
    }

    private void s() {
        j jVar = new j((LinearProgressIndicatorSpec) this.f23525a);
        setIndeterminateDrawable(i.u(getContext(), (LinearProgressIndicatorSpec) this.f23525a, jVar));
        setProgressDrawable(e.w(getContext(), (LinearProgressIndicatorSpec) this.f23525a, jVar));
    }

    public int getIndeterminateAnimationType() {
        return ((LinearProgressIndicatorSpec) this.f23525a).f23520h;
    }

    public int getIndicatorDirection() {
        return ((LinearProgressIndicatorSpec) this.f23525a).f23521i;
    }

    public int getTrackStopIndicatorSize() {
        return ((LinearProgressIndicatorSpec) this.f23525a).f23523k;
    }

    @Override // com.google.android.material.progressindicator.a
    public void o(int i10, boolean z10) {
        S s10 = this.f23525a;
        if (s10 != 0 && ((LinearProgressIndicatorSpec) s10).f23520h == 0 && isIndeterminate()) {
            return;
        }
        super.o(i10, z10);
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        S s10 = this.f23525a;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) s10;
        boolean z11 = true;
        if (((LinearProgressIndicatorSpec) s10).f23521i != 1 && ((K.v(this) != 1 || ((LinearProgressIndicatorSpec) this.f23525a).f23521i != 2) && (K.v(this) != 0 || ((LinearProgressIndicatorSpec) this.f23525a).f23521i != 3))) {
            z11 = false;
        }
        linearProgressIndicatorSpec.f23522j = z11;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        int paddingLeft = i10 - (getPaddingLeft() + getPaddingRight());
        int paddingTop = i11 - (getPaddingTop() + getPaddingBottom());
        i<LinearProgressIndicatorSpec> indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
        e<LinearProgressIndicatorSpec> progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
    }

    @Override // com.google.android.material.progressindicator.a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public LinearProgressIndicatorSpec i(Context context, AttributeSet attributeSet) {
        return new LinearProgressIndicatorSpec(context, attributeSet);
    }

    public void setIndeterminateAnimationType(int i10) {
        if (((LinearProgressIndicatorSpec) this.f23525a).f23520h == i10) {
            return;
        }
        if (q() && isIndeterminate()) {
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
        S s10 = this.f23525a;
        ((LinearProgressIndicatorSpec) s10).f23520h = i10;
        ((LinearProgressIndicatorSpec) s10).e();
        if (i10 == 0) {
            getIndeterminateDrawable().y(new k((LinearProgressIndicatorSpec) this.f23525a));
        } else {
            getIndeterminateDrawable().y(new t4.l(getContext(), (LinearProgressIndicatorSpec) this.f23525a));
        }
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.a
    public void setIndicatorColor(int... iArr) {
        super.setIndicatorColor(iArr);
        ((LinearProgressIndicatorSpec) this.f23525a).e();
    }

    public void setIndicatorDirection(int i10) {
        S s10 = this.f23525a;
        ((LinearProgressIndicatorSpec) s10).f23521i = i10;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) s10;
        boolean z10 = true;
        if (i10 != 1 && ((K.v(this) != 1 || ((LinearProgressIndicatorSpec) this.f23525a).f23521i != 2) && (K.v(this) != 0 || i10 != 3))) {
            z10 = false;
        }
        linearProgressIndicatorSpec.f23522j = z10;
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.a
    public void setTrackCornerRadius(int i10) {
        super.setTrackCornerRadius(i10);
        ((LinearProgressIndicatorSpec) this.f23525a).e();
        invalidate();
    }

    public void setTrackStopIndicatorSize(int i10) {
        S s10 = this.f23525a;
        if (((LinearProgressIndicatorSpec) s10).f23523k != i10) {
            ((LinearProgressIndicatorSpec) s10).f23523k = Math.min(i10, ((LinearProgressIndicatorSpec) s10).f37182a);
            ((LinearProgressIndicatorSpec) this.f23525a).e();
            invalidate();
        }
    }

    public LinearProgressIndicator(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10, f23519p);
        s();
    }
}
