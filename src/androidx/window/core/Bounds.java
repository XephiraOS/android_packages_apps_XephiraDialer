package androidx.window.core;

import android.graphics.Rect;
import kotlin.jvm.internal.i;

/* compiled from: Bounds.kt */
/* loaded from: classes.dex */
public final class Bounds {

    /* renamed from: a, reason: collision with root package name */
    public final int f11890a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11891b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11892c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11893d;

    public Bounds(int i10, int i11, int i12, int i13) {
        this.f11890a = i10;
        this.f11891b = i11;
        this.f11892c = i12;
        this.f11893d = i13;
    }

    public final int a() {
        return this.f11893d - this.f11891b;
    }

    public final int b() {
        return this.f11890a;
    }

    public final int c() {
        return this.f11891b;
    }

    public final int d() {
        return this.f11892c - this.f11890a;
    }

    public final boolean e() {
        if (a() == 0 && d() == 0) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!i.b(Bounds.class, cls)) {
            return false;
        }
        if (obj != null) {
            Bounds bounds = (Bounds) obj;
            if (this.f11890a == bounds.f11890a && this.f11891b == bounds.f11891b && this.f11892c == bounds.f11892c && this.f11893d == bounds.f11893d) {
                return true;
            }
            return false;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.window.core.Bounds");
    }

    public final Rect f() {
        return new Rect(this.f11890a, this.f11891b, this.f11892c, this.f11893d);
    }

    public int hashCode() {
        return (((((this.f11890a * 31) + this.f11891b) * 31) + this.f11892c) * 31) + this.f11893d;
    }

    public String toString() {
        return Bounds.class.getSimpleName() + " { [" + this.f11890a + ',' + this.f11891b + ',' + this.f11892c + ',' + this.f11893d + "] }";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Bounds(Rect rect) {
        this(rect.left, rect.top, rect.right, rect.bottom);
        i.f(rect, "rect");
    }
}
