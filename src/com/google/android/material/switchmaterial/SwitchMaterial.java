package com.google.android.material.switchmaterial;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.internal.ViewUtils;
import e4.C0977c;
import e4.C0979e;
import e4.l;
import l4.C1292a;
import o4.C1403a;

/* loaded from: classes3.dex */
public class SwitchMaterial extends SwitchCompat {

    /* renamed from: e, reason: collision with root package name */
    public static final int f23859e = l.f31005G;

    /* renamed from: f, reason: collision with root package name */
    public static final int[][] f23860f = {new int[]{16842910, R.attr.state_checked}, new int[]{16842910, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: a, reason: collision with root package name */
    public final C1403a f23861a;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f23862b;

    /* renamed from: c, reason: collision with root package name */
    public ColorStateList f23863c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f23864d;

    public SwitchMaterial(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0977c.f30700w0);
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.f23862b == null) {
            int d10 = C1292a.d(this, C0977c.f30697v);
            int d11 = C1292a.d(this, C0977c.f30681n);
            float dimension = getResources().getDimension(C0979e.f30758R0);
            if (this.f23861a.e()) {
                dimension += ViewUtils.getParentAbsoluteElevation(this);
            }
            int c10 = this.f23861a.c(d10, dimension);
            int[][] iArr = f23860f;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = C1292a.j(d10, d11, 1.0f);
            iArr2[1] = c10;
            iArr2[2] = C1292a.j(d10, d11, 0.38f);
            iArr2[3] = c10;
            this.f23862b = new ColorStateList(iArr, iArr2);
        }
        return this.f23862b;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.f23863c == null) {
            int[][] iArr = f23860f;
            int[] iArr2 = new int[iArr.length];
            int d10 = C1292a.d(this, C0977c.f30697v);
            int d11 = C1292a.d(this, C0977c.f30681n);
            int d12 = C1292a.d(this, C0977c.f30689r);
            iArr2[0] = C1292a.j(d10, d11, 0.54f);
            iArr2[1] = C1292a.j(d10, d12, 0.32f);
            iArr2[2] = C1292a.j(d10, d11, 0.12f);
            iArr2[3] = C1292a.j(d10, d12, 0.12f);
            this.f23863c = new ColorStateList(iArr, iArr2);
        }
        return this.f23863c;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f23864d && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.f23864d && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.f23864d = z10;
        if (z10) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        } else {
            setThumbTintList(null);
            setTrackTintList(null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public SwitchMaterial(android.content.Context r7, android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.switchmaterial.SwitchMaterial.f23859e
            android.content.Context r7 = B4.a.c(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            android.content.Context r0 = r6.getContext()
            o4.a r7 = new o4.a
            r7.<init>(r0)
            r6.f23861a = r7
            int[] r2 = e4.m.oa
            r7 = 0
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r9 = e4.m.pa
            boolean r7 = r8.getBoolean(r9, r7)
            r6.f23864d = r7
            r8.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.switchmaterial.SwitchMaterial.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
