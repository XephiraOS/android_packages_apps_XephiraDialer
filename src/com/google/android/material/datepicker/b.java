package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import e4.C0977c;
import u4.C1606b;
import u4.C1607c;

/* compiled from: CalendarStyle.java */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final a f23194a;

    /* renamed from: b, reason: collision with root package name */
    public final a f23195b;

    /* renamed from: c, reason: collision with root package name */
    public final a f23196c;

    /* renamed from: d, reason: collision with root package name */
    public final a f23197d;

    /* renamed from: e, reason: collision with root package name */
    public final a f23198e;

    /* renamed from: f, reason: collision with root package name */
    public final a f23199f;

    /* renamed from: g, reason: collision with root package name */
    public final a f23200g;

    /* renamed from: h, reason: collision with root package name */
    public final Paint f23201h;

    public b(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(C1606b.d(context, C0977c.f30639K, MaterialCalendar.class.getCanonicalName()), e4.m.f31378e5);
        this.f23194a = a.a(context, obtainStyledAttributes.getResourceId(e4.m.f31422i5, 0));
        this.f23200g = a.a(context, obtainStyledAttributes.getResourceId(e4.m.f31400g5, 0));
        this.f23195b = a.a(context, obtainStyledAttributes.getResourceId(e4.m.f31411h5, 0));
        this.f23196c = a.a(context, obtainStyledAttributes.getResourceId(e4.m.f31433j5, 0));
        ColorStateList a10 = C1607c.a(context, obtainStyledAttributes, e4.m.f31444k5);
        this.f23197d = a.a(context, obtainStyledAttributes.getResourceId(e4.m.f31466m5, 0));
        this.f23198e = a.a(context, obtainStyledAttributes.getResourceId(e4.m.f31455l5, 0));
        this.f23199f = a.a(context, obtainStyledAttributes.getResourceId(e4.m.f31477n5, 0));
        Paint paint = new Paint();
        this.f23201h = paint;
        paint.setColor(a10.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
