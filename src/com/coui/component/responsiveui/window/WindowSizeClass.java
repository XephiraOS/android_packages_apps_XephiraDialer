package com.coui.component.responsiveui.window;

import com.coui.component.responsiveui.unit.Dp;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: WindowSizeClass.kt */
/* loaded from: classes3.dex */
public final class WindowSizeClass {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final WindowWidthSizeClass f20038a;

    /* renamed from: b, reason: collision with root package name */
    public final WindowHeightSizeClass f20039b;

    /* renamed from: c, reason: collision with root package name */
    public final WindowTotalSizeClass f20040c;

    /* compiled from: WindowSizeClass.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public Companion() {
        }

        public final WindowSizeClass calculateFromSize(Dp width, Dp height) {
            i.f(width, "width");
            i.f(height, "height");
            return new WindowSizeClass(WindowWidthSizeClass.Companion.fromWidth(width), WindowHeightSizeClass.Companion.fromHeight(height), WindowTotalSizeClass.Companion.fromWidthAndHeight(width, height), null);
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public /* synthetic */ WindowSizeClass(WindowWidthSizeClass windowWidthSizeClass, WindowHeightSizeClass windowHeightSizeClass, WindowTotalSizeClass windowTotalSizeClass, f fVar) {
        this(windowWidthSizeClass, windowHeightSizeClass, windowTotalSizeClass);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WindowSizeClass.class != obj.getClass()) {
            return false;
        }
        WindowSizeClass windowSizeClass = (WindowSizeClass) obj;
        if (i.b(this.f20038a, windowSizeClass.f20038a) && i.b(this.f20039b, windowSizeClass.f20039b) && i.b(this.f20040c, windowSizeClass.f20040c)) {
            return true;
        }
        return false;
    }

    public final WindowHeightSizeClass getWindowHeightSizeClass() {
        return this.f20039b;
    }

    public final WindowTotalSizeClass getWindowTotalSizeClass() {
        return this.f20040c;
    }

    public final WindowWidthSizeClass getWindowWidthSizeClass() {
        return this.f20038a;
    }

    public int hashCode() {
        return (((this.f20038a.hashCode() * 31) + this.f20039b.hashCode()) * 31) + this.f20040c.hashCode();
    }

    public String toString() {
        return "WindowSizeClass(" + this.f20038a + ", " + this.f20039b + ", " + this.f20040c + ')';
    }

    public WindowSizeClass(WindowWidthSizeClass windowWidthSizeClass, WindowHeightSizeClass windowHeightSizeClass, WindowTotalSizeClass windowTotalSizeClass) {
        this.f20038a = windowWidthSizeClass;
        this.f20039b = windowHeightSizeClass;
        this.f20040c = windowTotalSizeClass;
    }
}
