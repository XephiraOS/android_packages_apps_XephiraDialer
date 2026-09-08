package com.coui.component.responsiveui.status;

import com.coui.component.responsiveui.window.LayoutGridWindowSize;
import com.coui.component.responsiveui.window.WindowSizeClass;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: WindowStatus.kt */
/* loaded from: classes3.dex */
public final class WindowStatus implements IWindowStatus {

    /* renamed from: a, reason: collision with root package name */
    public int f20028a;

    /* renamed from: b, reason: collision with root package name */
    public WindowSizeClass f20029b;

    /* renamed from: c, reason: collision with root package name */
    public LayoutGridWindowSize f20030c;

    public WindowStatus(int i10, WindowSizeClass windowSizeClass, LayoutGridWindowSize layoutGridWindowSize) {
        i.f(windowSizeClass, "windowSizeClass");
        i.f(layoutGridWindowSize, "layoutGridWindowSize");
        this.f20028a = i10;
        this.f20029b = windowSizeClass;
        this.f20030c = layoutGridWindowSize;
    }

    public static /* synthetic */ WindowStatus copy$default(WindowStatus windowStatus, int i10, WindowSizeClass windowSizeClass, LayoutGridWindowSize layoutGridWindowSize, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = windowStatus.f20028a;
        }
        if ((i11 & 2) != 0) {
            windowSizeClass = windowStatus.f20029b;
        }
        if ((i11 & 4) != 0) {
            layoutGridWindowSize = windowStatus.f20030c;
        }
        return windowStatus.copy(i10, windowSizeClass, layoutGridWindowSize);
    }

    public final int component1() {
        return this.f20028a;
    }

    public final WindowSizeClass component2() {
        return this.f20029b;
    }

    public final LayoutGridWindowSize component3() {
        return this.f20030c;
    }

    public final WindowStatus copy(int i10, WindowSizeClass windowSizeClass, LayoutGridWindowSize layoutGridWindowSize) {
        i.f(windowSizeClass, "windowSizeClass");
        i.f(layoutGridWindowSize, "layoutGridWindowSize");
        return new WindowStatus(i10, windowSizeClass, layoutGridWindowSize);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WindowStatus)) {
            return false;
        }
        WindowStatus windowStatus = (WindowStatus) obj;
        if (this.f20028a == windowStatus.f20028a && i.b(this.f20029b, windowStatus.f20029b) && i.b(this.f20030c, windowStatus.f20030c)) {
            return true;
        }
        return false;
    }

    public final LayoutGridWindowSize getLayoutGridWindowSize() {
        return this.f20030c;
    }

    public final int getOrientation() {
        return this.f20028a;
    }

    public final WindowSizeClass getWindowSizeClass() {
        return this.f20029b;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f20028a) * 31) + this.f20029b.hashCode()) * 31) + this.f20030c.hashCode();
    }

    @Override // com.coui.component.responsiveui.status.IWindowStatus
    public LayoutGridWindowSize layoutGridWindowSize() {
        return this.f20030c;
    }

    public final void setLayoutGridWindowSize(LayoutGridWindowSize layoutGridWindowSize) {
        i.f(layoutGridWindowSize, "<set-?>");
        this.f20030c = layoutGridWindowSize;
    }

    public final void setOrientation(int i10) {
        this.f20028a = i10;
    }

    public final void setWindowSizeClass(WindowSizeClass windowSizeClass) {
        i.f(windowSizeClass, "<set-?>");
        this.f20029b = windowSizeClass;
    }

    public String toString() {
        return "WindowStatus { orientation = " + this.f20028a + ", windowSizeClass = " + this.f20029b + ", windowSize = " + this.f20030c + " }";
    }

    @Override // com.coui.component.responsiveui.status.IWindowStatus
    public int windowOrientation() {
        return this.f20028a;
    }

    @Override // com.coui.component.responsiveui.status.IWindowStatus
    public WindowSizeClass windowSizeClass() {
        return this.f20029b;
    }

    public /* synthetic */ WindowStatus(int i10, WindowSizeClass windowSizeClass, LayoutGridWindowSize layoutGridWindowSize, int i11, f fVar) {
        this((i11 & 1) != 0 ? 0 : i10, windowSizeClass, layoutGridWindowSize);
    }
}
