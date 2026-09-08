package com.oplus.anim;

import java.util.Arrays;

/* compiled from: EffectiveAnimationResult.java */
/* renamed from: com.oplus.anim.s, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0837s<V> {

    /* renamed from: a, reason: collision with root package name */
    public final V f26199a;

    /* renamed from: b, reason: collision with root package name */
    public final Throwable f26200b;

    public C0837s(V v10) {
        this.f26199a = v10;
        this.f26200b = null;
    }

    public Throwable a() {
        return this.f26200b;
    }

    public V b() {
        return this.f26199a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0837s)) {
            return false;
        }
        C0837s c0837s = (C0837s) obj;
        if (b() != null && b().equals(c0837s.b())) {
            return true;
        }
        if (a() == null || c0837s.a() == null) {
            return false;
        }
        return a().toString().equals(a().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{b(), a()});
    }

    public C0837s(Throwable th) {
        this.f26200b = th;
        this.f26199a = null;
    }
}
