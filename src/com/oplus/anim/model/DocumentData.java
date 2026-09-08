package com.oplus.anim.model;

import android.graphics.PointF;

/* loaded from: classes3.dex */
public class DocumentData {

    /* renamed from: a, reason: collision with root package name */
    public String f25946a;

    /* renamed from: b, reason: collision with root package name */
    public String f25947b;

    /* renamed from: c, reason: collision with root package name */
    public float f25948c;

    /* renamed from: d, reason: collision with root package name */
    public Justification f25949d;

    /* renamed from: e, reason: collision with root package name */
    public int f25950e;

    /* renamed from: f, reason: collision with root package name */
    public float f25951f;

    /* renamed from: g, reason: collision with root package name */
    public float f25952g;

    /* renamed from: h, reason: collision with root package name */
    public int f25953h;

    /* renamed from: i, reason: collision with root package name */
    public int f25954i;

    /* renamed from: j, reason: collision with root package name */
    public float f25955j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f25956k;

    /* renamed from: l, reason: collision with root package name */
    public PointF f25957l;

    /* renamed from: m, reason: collision with root package name */
    public PointF f25958m;

    /* loaded from: classes3.dex */
    public enum Justification {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData(String str, String str2, float f10, Justification justification, int i10, float f11, float f12, int i11, int i12, float f13, boolean z10, PointF pointF, PointF pointF2) {
        a(str, str2, f10, justification, i10, f11, f12, i11, i12, f13, z10, pointF, pointF2);
    }

    public void a(String str, String str2, float f10, Justification justification, int i10, float f11, float f12, int i11, int i12, float f13, boolean z10, PointF pointF, PointF pointF2) {
        this.f25946a = str;
        this.f25947b = str2;
        this.f25948c = f10;
        this.f25949d = justification;
        this.f25950e = i10;
        this.f25951f = f11;
        this.f25952g = f12;
        this.f25953h = i11;
        this.f25954i = i12;
        this.f25955j = f13;
        this.f25956k = z10;
        this.f25957l = pointF;
        this.f25958m = pointF2;
    }

    public int hashCode() {
        int hashCode = (((((int) ((((this.f25946a.hashCode() * 31) + this.f25947b.hashCode()) * 31) + this.f25948c)) * 31) + this.f25949d.ordinal()) * 31) + this.f25950e;
        long floatToRawIntBits = Float.floatToRawIntBits(this.f25951f);
        return (((hashCode * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.f25953h;
    }

    public DocumentData() {
    }
}
