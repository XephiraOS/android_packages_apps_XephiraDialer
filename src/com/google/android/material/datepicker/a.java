package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import androidx.core.view.K;
import u4.C1607c;

/* compiled from: CalendarItemStyle.java */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f23188a;

    /* renamed from: b, reason: collision with root package name */
    public final ColorStateList f23189b;

    /* renamed from: c, reason: collision with root package name */
    public final ColorStateList f23190c;

    /* renamed from: d, reason: collision with root package name */
    public final ColorStateList f23191d;

    /* renamed from: e, reason: collision with root package name */
    public final int f23192e;

    /* renamed from: f, reason: collision with root package name */
    public final x4.n f23193f;

    public a(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i10, x4.n nVar, Rect rect) {
        I.h.c(rect.left);
        I.h.c(rect.top);
        I.h.c(rect.right);
        I.h.c(rect.bottom);
        this.f23188a = rect;
        this.f23189b = colorStateList2;
        this.f23190c = colorStateList;
        this.f23191d = colorStateList3;
        this.f23192e = i10;
        this.f23193f = nVar;
    }

    public static a a(Context context, int i10) {
        boolean z10;
        if (i10 != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        I.h.b(z10, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i10, e4.m.f31488o5);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(e4.m.f31499p5, 0), obtainStyledAttributes.getDimensionPixelOffset(e4.m.f31521r5, 0), obtainStyledAttributes.getDimensionPixelOffset(e4.m.f31510q5, 0), obtainStyledAttributes.getDimensionPixelOffset(e4.m.f31532s5, 0));
        ColorStateList a10 = C1607c.a(context, obtainStyledAttributes, e4.m.f31543t5);
        ColorStateList a11 = C1607c.a(context, obtainStyledAttributes, e4.m.f31598y5);
        ColorStateList a12 = C1607c.a(context, obtainStyledAttributes, e4.m.f31576w5);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(e4.m.f31587x5, 0);
        x4.n m10 = x4.n.b(context, obtainStyledAttributes.getResourceId(e4.m.f31554u5, 0), obtainStyledAttributes.getResourceId(e4.m.f31565v5, 0)).m();
        obtainStyledAttributes.recycle();
        return new a(a10, a11, a12, dimensionPixelSize, m10, rect);
    }

    public int b() {
        return this.f23188a.bottom;
    }

    public int c() {
        return this.f23188a.top;
    }

    public void d(TextView textView) {
        e(textView, null, null);
    }

    public void e(TextView textView, ColorStateList colorStateList, ColorStateList colorStateList2) {
        x4.i iVar = new x4.i();
        x4.i iVar2 = new x4.i();
        iVar.setShapeAppearanceModel(this.f23193f);
        iVar2.setShapeAppearanceModel(this.f23193f);
        if (colorStateList == null) {
            colorStateList = this.f23190c;
        }
        iVar.setFillColor(colorStateList);
        iVar.setStroke(this.f23192e, this.f23191d);
        if (colorStateList2 == null) {
            colorStateList2 = this.f23189b;
        }
        textView.setTextColor(colorStateList2);
        RippleDrawable rippleDrawable = new RippleDrawable(this.f23189b.withAlpha(30), iVar, iVar2);
        Rect rect = this.f23188a;
        K.n0(textView, new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
