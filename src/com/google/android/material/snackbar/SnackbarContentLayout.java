package com.google.android.material.snackbar;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.K;
import e4.C0977c;
import e4.C0979e;
import e4.g;
import f4.C1001b;
import s4.C1550i;
import z4.InterfaceC1733a;

/* loaded from: classes3.dex */
public class SnackbarContentLayout extends LinearLayout implements InterfaceC1733a {

    /* renamed from: a, reason: collision with root package name */
    public TextView f23845a;

    /* renamed from: b, reason: collision with root package name */
    public Button f23846b;

    /* renamed from: c, reason: collision with root package name */
    public final TimeInterpolator f23847c;

    /* renamed from: d, reason: collision with root package name */
    public int f23848d;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23847c = C1550i.g(context, C0977c.f30662d0, C1001b.f31703b);
    }

    public static void c(View view, int i10, int i11) {
        if (K.Q(view)) {
            K.A0(view, K.A(view), i10, K.z(view), i11);
        } else {
            view.setPadding(view.getPaddingLeft(), i10, view.getPaddingRight(), i11);
        }
    }

    @Override // z4.InterfaceC1733a
    public void a(int i10, int i11) {
        this.f23845a.setAlpha(0.0f);
        long j10 = i11;
        long j11 = i10;
        this.f23845a.animate().alpha(1.0f).setDuration(j10).setInterpolator(this.f23847c).setStartDelay(j11).start();
        if (this.f23846b.getVisibility() == 0) {
            this.f23846b.setAlpha(0.0f);
            this.f23846b.animate().alpha(1.0f).setDuration(j10).setInterpolator(this.f23847c).setStartDelay(j11).start();
        }
    }

    @Override // z4.InterfaceC1733a
    public void b(int i10, int i11) {
        this.f23845a.setAlpha(1.0f);
        long j10 = i11;
        long j11 = i10;
        this.f23845a.animate().alpha(0.0f).setDuration(j10).setInterpolator(this.f23847c).setStartDelay(j11).start();
        if (this.f23846b.getVisibility() == 0) {
            this.f23846b.setAlpha(1.0f);
            this.f23846b.animate().alpha(0.0f).setDuration(j10).setInterpolator(this.f23847c).setStartDelay(j11).start();
        }
    }

    public final boolean d(int i10, int i11, int i12) {
        boolean z10;
        if (i10 != getOrientation()) {
            setOrientation(i10);
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f23845a.getPaddingTop() == i11 && this.f23845a.getPaddingBottom() == i12) {
            return z10;
        }
        c(this.f23845a, i11, i12);
        return true;
    }

    public Button getActionView() {
        return this.f23846b;
    }

    public TextView getMessageView() {
        return this.f23845a;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f23845a = (TextView) findViewById(g.f30885k0);
        this.f23846b = (Button) findViewById(g.f30883j0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        boolean z10;
        super.onMeasure(i10, i11);
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(C0979e.f30798n);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(C0979e.f30796m);
        Layout layout = this.f23845a.getLayout();
        if (layout != null && layout.getLineCount() > 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 && this.f23848d > 0 && this.f23846b.getMeasuredWidth() > this.f23848d) {
            if (!d(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                return;
            }
        } else {
            if (!z10) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!d(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        }
        super.onMeasure(i10, i11);
    }

    public void setMaxInlineActionWidth(int i10) {
        this.f23848d = i10;
    }
}
