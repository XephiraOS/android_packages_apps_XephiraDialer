package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.internal.ThemeEnforcement;
import e4.C0977c;
import e4.m;
import t4.AbstractC1591b;

/* loaded from: classes3.dex */
public final class LinearProgressIndicatorSpec extends AbstractC1591b {

    /* renamed from: h, reason: collision with root package name */
    public int f23520h;

    /* renamed from: i, reason: collision with root package name */
    public int f23521i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f23522j;

    /* renamed from: k, reason: collision with root package name */
    public int f23523k;

    public LinearProgressIndicatorSpec(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0977c.f30635G);
    }

    @Override // t4.AbstractC1591b
    public void e() {
        super.e();
        if (this.f23523k >= 0) {
            if (this.f23520h == 0) {
                if (this.f37183b > 0 && this.f37188g == 0) {
                    throw new IllegalArgumentException("Rounded corners without gap are not supported in contiguous indeterminate animation.");
                }
                if (this.f37184c.length < 3) {
                    throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Stop indicator size must be >= 0.");
    }

    public LinearProgressIndicatorSpec(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, LinearProgressIndicator.f23519p);
    }

    public LinearProgressIndicatorSpec(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, m.f31498p4, C0977c.f30635G, LinearProgressIndicator.f23519p, new int[0]);
        this.f23520h = obtainStyledAttributes.getInt(m.f31509q4, 1);
        this.f23521i = obtainStyledAttributes.getInt(m.f31520r4, 0);
        this.f23523k = Math.min(obtainStyledAttributes.getDimensionPixelSize(m.f31531s4, 0), this.f37182a);
        obtainStyledAttributes.recycle();
        e();
        this.f23522j = this.f23521i == 1;
    }
}
