package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.internal.ThemeEnforcement;
import e4.C0977c;
import e4.C0979e;
import e4.m;
import t4.AbstractC1591b;
import u4.C1607c;

/* loaded from: classes3.dex */
public final class CircularProgressIndicatorSpec extends AbstractC1591b {

    /* renamed from: h, reason: collision with root package name */
    public int f23516h;

    /* renamed from: i, reason: collision with root package name */
    public int f23517i;

    /* renamed from: j, reason: collision with root package name */
    public int f23518j;

    public CircularProgressIndicatorSpec(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0977c.f30677l);
    }

    public CircularProgressIndicatorSpec(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, CircularProgressIndicator.f23515p);
    }

    public CircularProgressIndicatorSpec(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C0979e.f30736G0);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(C0979e.f30734F0);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, m.f31496p2, i10, i11, new int[0]);
        this.f23516h = Math.max(C1607c.d(context, obtainStyledAttributes, m.f31529s2, dimensionPixelSize), this.f37182a * 2);
        this.f23517i = C1607c.d(context, obtainStyledAttributes, m.f31518r2, dimensionPixelSize2);
        this.f23518j = obtainStyledAttributes.getInt(m.f31507q2, 0);
        obtainStyledAttributes.recycle();
        e();
    }
}
