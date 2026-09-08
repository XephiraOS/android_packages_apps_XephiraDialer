package com.oplus.anim.model.content;

import b6.i;
import com.oplus.anim.C0820a;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.model.content.ShapeStroke;
import f6.C1015b;
import f6.C1016c;
import f6.C1017d;
import f6.f;
import g6.c;
import java.util.List;

/* compiled from: GradientStroke.java */
/* loaded from: classes3.dex */
public class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public final String f26027a;

    /* renamed from: b, reason: collision with root package name */
    public final GradientType f26028b;

    /* renamed from: c, reason: collision with root package name */
    public final C1016c f26029c;

    /* renamed from: d, reason: collision with root package name */
    public final C1017d f26030d;

    /* renamed from: e, reason: collision with root package name */
    public final f f26031e;

    /* renamed from: f, reason: collision with root package name */
    public final f f26032f;

    /* renamed from: g, reason: collision with root package name */
    public final C1015b f26033g;

    /* renamed from: h, reason: collision with root package name */
    public final ShapeStroke.LineCapType f26034h;

    /* renamed from: i, reason: collision with root package name */
    public final ShapeStroke.LineJoinType f26035i;

    /* renamed from: j, reason: collision with root package name */
    public final float f26036j;

    /* renamed from: k, reason: collision with root package name */
    public final List<C1015b> f26037k;

    /* renamed from: l, reason: collision with root package name */
    public final C1015b f26038l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f26039m;

    public a(String str, GradientType gradientType, C1016c c1016c, C1017d c1017d, f fVar, f fVar2, C1015b c1015b, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f10, List<C1015b> list, C1015b c1015b2, boolean z10) {
        this.f26027a = str;
        this.f26028b = gradientType;
        this.f26029c = c1016c;
        this.f26030d = c1017d;
        this.f26031e = fVar;
        this.f26032f = fVar2;
        this.f26033g = c1015b;
        this.f26034h = lineCapType;
        this.f26035i = lineJoinType;
        this.f26036j = f10;
        this.f26037k = list;
        this.f26038l = c1015b2;
        this.f26039m = z10;
    }

    @Override // g6.c
    public b6.c a(EffectiveAnimationDrawable effectiveAnimationDrawable, C0820a c0820a, com.oplus.anim.model.layer.a aVar) {
        return new i(effectiveAnimationDrawable, aVar, this);
    }

    public ShapeStroke.LineCapType b() {
        return this.f26034h;
    }

    public C1015b c() {
        return this.f26038l;
    }

    public f d() {
        return this.f26032f;
    }

    public C1016c e() {
        return this.f26029c;
    }

    public GradientType f() {
        return this.f26028b;
    }

    public ShapeStroke.LineJoinType g() {
        return this.f26035i;
    }

    public List<C1015b> h() {
        return this.f26037k;
    }

    public float i() {
        return this.f26036j;
    }

    public String j() {
        return this.f26027a;
    }

    public C1017d k() {
        return this.f26030d;
    }

    public f l() {
        return this.f26031e;
    }

    public C1015b m() {
        return this.f26033g;
    }

    public boolean n() {
        return this.f26039m;
    }
}
