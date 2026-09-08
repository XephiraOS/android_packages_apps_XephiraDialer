package com.google.android.material.radiobutton;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.c;
import e4.C0977c;
import e4.l;
import l4.C1292a;

/* loaded from: classes3.dex */
public class MaterialRadioButton extends AppCompatRadioButton {

    /* renamed from: g, reason: collision with root package name */
    public static final int f23543g = l.f31004F;

    /* renamed from: h, reason: collision with root package name */
    public static final int[][] f23544h = {new int[]{16842910, R.attr.state_checked}, new int[]{16842910, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: e, reason: collision with root package name */
    public ColorStateList f23545e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f23546f;

    public MaterialRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0977c.f30678l0);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f23545e == null) {
            int d10 = C1292a.d(this, C0977c.f30681n);
            int d11 = C1292a.d(this, C0977c.f30689r);
            int d12 = C1292a.d(this, C0977c.f30697v);
            int[][] iArr = f23544h;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = C1292a.j(d12, d10, 1.0f);
            iArr2[1] = C1292a.j(d12, d11, 0.54f);
            iArr2[2] = C1292a.j(d12, d11, 0.38f);
            iArr2[3] = C1292a.j(d12, d11, 0.38f);
            this.f23545e = new ColorStateList(iArr, iArr2);
        }
        return this.f23545e;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f23546f && c.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.f23546f = z10;
        if (z10) {
            c.d(this, getMaterialThemeColorsTintList());
        } else {
            c.d(this, null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialRadioButton(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = com.google.android.material.radiobutton.MaterialRadioButton.f23543g
            android.content.Context r8 = B4.a.c(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.content.Context r8 = r7.getContext()
            int[] r2 = e4.m.f31346b6
            r6 = 0
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r10 = e4.m.f31357c6
            boolean r0 = r9.hasValue(r10)
            if (r0 == 0) goto L28
            android.content.res.ColorStateList r8 = u4.C1607c.a(r8, r9, r10)
            androidx.core.widget.c.d(r7, r8)
        L28:
            int r8 = e4.m.f31368d6
            boolean r8 = r9.getBoolean(r8, r6)
            r7.f23546f = r8
            r9.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.radiobutton.MaterialRadioButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
