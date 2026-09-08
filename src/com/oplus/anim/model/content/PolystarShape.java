package com.oplus.anim.model.content;

import android.graphics.PointF;
import b6.n;
import com.oplus.anim.C0820a;
import com.oplus.anim.EffectiveAnimationDrawable;
import f6.C1015b;
import f6.m;
import g6.c;

/* loaded from: classes3.dex */
public class PolystarShape implements c {

    /* renamed from: a, reason: collision with root package name */
    public final String f25984a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f25985b;

    /* renamed from: c, reason: collision with root package name */
    public final C1015b f25986c;

    /* renamed from: d, reason: collision with root package name */
    public final m<PointF, PointF> f25987d;

    /* renamed from: e, reason: collision with root package name */
    public final C1015b f25988e;

    /* renamed from: f, reason: collision with root package name */
    public final C1015b f25989f;

    /* renamed from: g, reason: collision with root package name */
    public final C1015b f25990g;

    /* renamed from: h, reason: collision with root package name */
    public final C1015b f25991h;

    /* renamed from: i, reason: collision with root package name */
    public final C1015b f25992i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f25993j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f25994k;

    /* loaded from: classes3.dex */
    public enum Type {
        STAR(1),
        POLYGON(2);

        private final int value;

        Type(int i10) {
            this.value = i10;
        }

        public static Type a(int i10) {
            for (Type type : values()) {
                if (type.value == i10) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, C1015b c1015b, m<PointF, PointF> mVar, C1015b c1015b2, C1015b c1015b3, C1015b c1015b4, C1015b c1015b5, C1015b c1015b6, boolean z10, boolean z11) {
        this.f25984a = str;
        this.f25985b = type;
        this.f25986c = c1015b;
        this.f25987d = mVar;
        this.f25988e = c1015b2;
        this.f25989f = c1015b3;
        this.f25990g = c1015b4;
        this.f25991h = c1015b5;
        this.f25992i = c1015b6;
        this.f25993j = z10;
        this.f25994k = z11;
    }

    @Override // g6.c
    public b6.c a(EffectiveAnimationDrawable effectiveAnimationDrawable, C0820a c0820a, com.oplus.anim.model.layer.a aVar) {
        return new n(effectiveAnimationDrawable, aVar, this);
    }

    public C1015b b() {
        return this.f25989f;
    }

    public C1015b c() {
        return this.f25991h;
    }

    public String d() {
        return this.f25984a;
    }

    public C1015b e() {
        return this.f25990g;
    }

    public C1015b f() {
        return this.f25992i;
    }

    public C1015b g() {
        return this.f25986c;
    }

    public m<PointF, PointF> h() {
        return this.f25987d;
    }

    public C1015b i() {
        return this.f25988e;
    }

    public Type j() {
        return this.f25985b;
    }

    public boolean k() {
        return this.f25993j;
    }

    public boolean l() {
        return this.f25994k;
    }
}
