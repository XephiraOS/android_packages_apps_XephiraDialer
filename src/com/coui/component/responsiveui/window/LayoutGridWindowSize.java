package com.coui.component.responsiveui.window;

import android.content.Context;
import com.coui.component.responsiveui.unit.Dp;
import kotlin.jvm.internal.i;

/* compiled from: LayoutGridWindowSize.kt */
/* loaded from: classes3.dex */
public final class LayoutGridWindowSize {

    /* renamed from: a, reason: collision with root package name */
    public int f20034a;

    /* renamed from: b, reason: collision with root package name */
    public int f20035b;

    public LayoutGridWindowSize(int i10, int i11) {
        this.f20034a = i10;
        this.f20035b = i11;
    }

    public static /* synthetic */ LayoutGridWindowSize copy$default(LayoutGridWindowSize layoutGridWindowSize, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = layoutGridWindowSize.f20034a;
        }
        if ((i12 & 2) != 0) {
            i11 = layoutGridWindowSize.f20035b;
        }
        return layoutGridWindowSize.copy(i10, i11);
    }

    public final int component1() {
        return this.f20034a;
    }

    public final int component2() {
        return this.f20035b;
    }

    public final LayoutGridWindowSize copy(int i10, int i11) {
        return new LayoutGridWindowSize(i10, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && LayoutGridWindowSize.class == obj.getClass()) {
            LayoutGridWindowSize layoutGridWindowSize = (LayoutGridWindowSize) obj;
            if (this.f20034a == layoutGridWindowSize.f20034a && this.f20035b == layoutGridWindowSize.f20035b) {
                return true;
            }
        }
        return false;
    }

    public final int getHeight() {
        return this.f20035b;
    }

    public final int getWidth() {
        return this.f20034a;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f20034a) * 31) + Integer.hashCode(this.f20035b);
    }

    public final void setHeight(int i10) {
        this.f20035b = i10;
    }

    public final void setWidth(int i10) {
        this.f20034a = i10;
    }

    public String toString() {
        return "(width = " + this.f20034a + ", height = " + this.f20035b + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LayoutGridWindowSize(LayoutGridWindowSize windowSize) {
        this(windowSize.f20034a, windowSize.f20035b);
        i.f(windowSize, "windowSize");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LayoutGridWindowSize(Context context, Dp width, Dp height) {
        this((int) width.toPixel(context), (int) height.toPixel(context));
        i.f(context, "context");
        i.f(width, "width");
        i.f(height, "height");
    }
}
