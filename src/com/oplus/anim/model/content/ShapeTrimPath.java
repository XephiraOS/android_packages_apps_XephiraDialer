package com.oplus.anim.model.content;

import b6.u;
import com.oplus.anim.C0820a;
import com.oplus.anim.EffectiveAnimationDrawable;
import f6.C1015b;
import g6.c;

/* loaded from: classes3.dex */
public class ShapeTrimPath implements c {

    /* renamed from: a, reason: collision with root package name */
    public final String f26018a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f26019b;

    /* renamed from: c, reason: collision with root package name */
    public final C1015b f26020c;

    /* renamed from: d, reason: collision with root package name */
    public final C1015b f26021d;

    /* renamed from: e, reason: collision with root package name */
    public final C1015b f26022e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f26023f;

    /* loaded from: classes3.dex */
    public enum Type {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static Type a(int i10) {
            if (i10 != 1) {
                if (i10 == 2) {
                    return INDIVIDUALLY;
                }
                throw new IllegalArgumentException("Unknown trim path type " + i10);
            }
            return SIMULTANEOUSLY;
        }
    }

    public ShapeTrimPath(String str, Type type, C1015b c1015b, C1015b c1015b2, C1015b c1015b3, boolean z10) {
        this.f26018a = str;
        this.f26019b = type;
        this.f26020c = c1015b;
        this.f26021d = c1015b2;
        this.f26022e = c1015b3;
        this.f26023f = z10;
    }

    @Override // g6.c
    public b6.c a(EffectiveAnimationDrawable effectiveAnimationDrawable, C0820a c0820a, com.oplus.anim.model.layer.a aVar) {
        return new u(aVar, this);
    }

    public C1015b b() {
        return this.f26021d;
    }

    public String c() {
        return this.f26018a;
    }

    public C1015b d() {
        return this.f26022e;
    }

    public C1015b e() {
        return this.f26020c;
    }

    public Type f() {
        return this.f26019b;
    }

    public boolean g() {
        return this.f26023f;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f26020c + ", end: " + this.f26021d + ", offset: " + this.f26022e + "}";
    }
}
