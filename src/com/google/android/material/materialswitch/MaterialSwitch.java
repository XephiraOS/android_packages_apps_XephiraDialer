package com.google.android.material.materialswitch;

import C.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.SwitchCompat;
import e4.C0977c;
import e4.l;
import f.C0991a;
import n4.C1370a;

/* loaded from: classes3.dex */
public class MaterialSwitch extends SwitchCompat {

    /* renamed from: n, reason: collision with root package name */
    public static final int f23455n = l.f31037t;

    /* renamed from: o, reason: collision with root package name */
    public static final int[] f23456o = {C0977c.f30698v0};

    /* renamed from: a, reason: collision with root package name */
    public Drawable f23457a;

    /* renamed from: b, reason: collision with root package name */
    public Drawable f23458b;

    /* renamed from: c, reason: collision with root package name */
    public int f23459c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f23460d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f23461e;

    /* renamed from: f, reason: collision with root package name */
    public ColorStateList f23462f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f23463g;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f23464h;

    /* renamed from: i, reason: collision with root package name */
    public ColorStateList f23465i;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f23466j;

    /* renamed from: k, reason: collision with root package name */
    public PorterDuff.Mode f23467k;

    /* renamed from: l, reason: collision with root package name */
    public int[] f23468l;

    /* renamed from: m, reason: collision with root package name */
    public int[] f23469m;

    public MaterialSwitch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0977c.f30646R);
    }

    public static void c(Drawable drawable, ColorStateList colorStateList, int[] iArr, int[] iArr2, float f10) {
        if (drawable != null && colorStateList != null) {
            a.n(drawable, B.a.i(colorStateList.getColorForState(iArr, 0), colorStateList.getColorForState(iArr2, 0), f10));
        }
    }

    public final void a() {
        this.f23457a = C1370a.c(this.f23457a, this.f23462f, getThumbTintMode());
        this.f23458b = C1370a.c(this.f23458b, this.f23463g, this.f23464h);
        d();
        Drawable drawable = this.f23457a;
        Drawable drawable2 = this.f23458b;
        int i10 = this.f23459c;
        super.setThumbDrawable(C1370a.b(drawable, drawable2, i10, i10));
        refreshDrawableState();
    }

    public final void b() {
        this.f23460d = C1370a.c(this.f23460d, this.f23465i, getTrackTintMode());
        this.f23461e = C1370a.c(this.f23461e, this.f23466j, this.f23467k);
        d();
        Drawable drawable = this.f23460d;
        if (drawable != null && this.f23461e != null) {
            drawable = new LayerDrawable(new Drawable[]{this.f23460d, this.f23461e});
        } else if (drawable == null) {
            drawable = this.f23461e;
        }
        if (drawable != null) {
            setSwitchMinWidth(drawable.getIntrinsicWidth());
        }
        super.setTrackDrawable(drawable);
    }

    public final void d() {
        if (this.f23462f == null && this.f23463g == null && this.f23465i == null && this.f23466j == null) {
            return;
        }
        float thumbPosition = getThumbPosition();
        ColorStateList colorStateList = this.f23462f;
        if (colorStateList != null) {
            c(this.f23457a, colorStateList, this.f23468l, this.f23469m, thumbPosition);
        }
        ColorStateList colorStateList2 = this.f23463g;
        if (colorStateList2 != null) {
            c(this.f23458b, colorStateList2, this.f23468l, this.f23469m, thumbPosition);
        }
        ColorStateList colorStateList3 = this.f23465i;
        if (colorStateList3 != null) {
            c(this.f23460d, colorStateList3, this.f23468l, this.f23469m, thumbPosition);
        }
        ColorStateList colorStateList4 = this.f23466j;
        if (colorStateList4 != null) {
            c(this.f23461e, colorStateList4, this.f23468l, this.f23469m, thumbPosition);
        }
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public Drawable getThumbDrawable() {
        return this.f23457a;
    }

    public Drawable getThumbIconDrawable() {
        return this.f23458b;
    }

    public int getThumbIconSize() {
        return this.f23459c;
    }

    public ColorStateList getThumbIconTintList() {
        return this.f23463g;
    }

    public PorterDuff.Mode getThumbIconTintMode() {
        return this.f23464h;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public ColorStateList getThumbTintList() {
        return this.f23462f;
    }

    public Drawable getTrackDecorationDrawable() {
        return this.f23461e;
    }

    public ColorStateList getTrackDecorationTintList() {
        return this.f23466j;
    }

    public PorterDuff.Mode getTrackDecorationTintMode() {
        return this.f23467k;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public Drawable getTrackDrawable() {
        return this.f23460d;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public ColorStateList getTrackTintList() {
        return this.f23465i;
    }

    @Override // android.view.View
    public void invalidate() {
        d();
        super.invalidate();
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        if (this.f23458b != null) {
            View.mergeDrawableStates(onCreateDrawableState, f23456o);
        }
        this.f23468l = C1370a.j(onCreateDrawableState);
        this.f23469m = C1370a.f(onCreateDrawableState);
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbDrawable(Drawable drawable) {
        this.f23457a = drawable;
        a();
    }

    public void setThumbIconDrawable(Drawable drawable) {
        this.f23458b = drawable;
        a();
    }

    public void setThumbIconResource(int i10) {
        setThumbIconDrawable(C0991a.b(getContext(), i10));
    }

    public void setThumbIconSize(int i10) {
        if (this.f23459c != i10) {
            this.f23459c = i10;
            a();
        }
    }

    public void setThumbIconTintList(ColorStateList colorStateList) {
        this.f23463g = colorStateList;
        a();
    }

    public void setThumbIconTintMode(PorterDuff.Mode mode) {
        this.f23464h = mode;
        a();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbTintList(ColorStateList colorStateList) {
        this.f23462f = colorStateList;
        a();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbTintMode(PorterDuff.Mode mode) {
        super.setThumbTintMode(mode);
        a();
    }

    public void setTrackDecorationDrawable(Drawable drawable) {
        this.f23461e = drawable;
        b();
    }

    public void setTrackDecorationResource(int i10) {
        setTrackDecorationDrawable(C0991a.b(getContext(), i10));
    }

    public void setTrackDecorationTintList(ColorStateList colorStateList) {
        this.f23466j = colorStateList;
        b();
    }

    public void setTrackDecorationTintMode(PorterDuff.Mode mode) {
        this.f23467k = mode;
        b();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackDrawable(Drawable drawable) {
        this.f23460d = drawable;
        b();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackTintList(ColorStateList colorStateList) {
        this.f23465i = colorStateList;
        b();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackTintMode(PorterDuff.Mode mode) {
        super.setTrackTintMode(mode);
        b();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialSwitch(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = com.google.android.material.materialswitch.MaterialSwitch.f23455n
            android.content.Context r8 = B4.a.c(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            r8 = -1
            r7.f23459c = r8
            android.content.Context r0 = r7.getContext()
            android.graphics.drawable.Drawable r1 = super.getThumbDrawable()
            r7.f23457a = r1
            android.content.res.ColorStateList r1 = super.getThumbTintList()
            r7.f23462f = r1
            r1 = 0
            super.setThumbTintList(r1)
            android.graphics.drawable.Drawable r2 = super.getTrackDrawable()
            r7.f23460d = r2
            android.content.res.ColorStateList r2 = super.getTrackTintList()
            r7.f23465i = r2
            super.setTrackTintList(r1)
            int[] r2 = e4.m.f31412h6
            r6 = 0
            int[] r5 = new int[r6]
            r1 = r9
            r3 = r10
            androidx.appcompat.widget.K r9 = com.google.android.material.internal.ThemeEnforcement.obtainTintedStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r10 = e4.m.f31423i6
            android.graphics.drawable.Drawable r10 = r9.g(r10)
            r7.f23458b = r10
            int r10 = e4.m.f31434j6
            int r10 = r9.f(r10, r8)
            r7.f23459c = r10
            int r10 = e4.m.f31445k6
            android.content.res.ColorStateList r10 = r9.c(r10)
            r7.f23463g = r10
            int r10 = e4.m.f31456l6
            int r10 = r9.k(r10, r8)
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r10 = com.google.android.material.internal.ViewUtils.parseTintMode(r10, r0)
            r7.f23464h = r10
            int r10 = e4.m.f31467m6
            android.graphics.drawable.Drawable r10 = r9.g(r10)
            r7.f23461e = r10
            int r10 = e4.m.f31478n6
            android.content.res.ColorStateList r10 = r9.c(r10)
            r7.f23466j = r10
            int r10 = e4.m.f31489o6
            int r8 = r9.k(r10, r8)
            android.graphics.PorterDuff$Mode r8 = com.google.android.material.internal.ViewUtils.parseTintMode(r8, r0)
            r7.f23467k = r8
            r9.y()
            r7.setEnforceSwitchWidth(r6)
            r7.a()
            r7.b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.materialswitch.MaterialSwitch.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
