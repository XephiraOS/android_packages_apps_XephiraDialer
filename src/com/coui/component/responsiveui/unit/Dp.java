package com.coui.component.responsiveui.unit;

import android.content.Context;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: Dp.kt */
/* loaded from: classes3.dex */
public final class Dp {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final float f20031a;

    /* compiled from: Dp.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public Companion() {
        }

        public final Dp pixel2Dp(Context context, int i10) {
            i.f(context, "context");
            return DpKt.pixel2Dp(i10, context);
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public Dp(float f10) {
        this.f20031a = f10;
    }

    public final int compareTo(Dp other) {
        i.f(other, "other");
        return Float.compare(this.f20031a, other.f20031a);
    }

    public final Dp div(Dp other) {
        i.f(other, "other");
        return new Dp(this.f20031a / other.f20031a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Dp.class == obj.getClass() && Float.compare(this.f20031a, ((Dp) obj).f20031a) == 0) {
            return true;
        }
        return false;
    }

    public final float getValue() {
        return this.f20031a;
    }

    public int hashCode() {
        return Float.hashCode(this.f20031a);
    }

    public final Dp minus(Dp other) {
        i.f(other, "other");
        return new Dp(this.f20031a - other.f20031a);
    }

    public final Dp plus(Dp other) {
        i.f(other, "other");
        return new Dp(this.f20031a + other.f20031a);
    }

    public final float toPixel(Context context) {
        i.f(context, "context");
        return this.f20031a * context.getResources().getDisplayMetrics().density;
    }

    public String toString() {
        return this.f20031a + " dp";
    }
}
