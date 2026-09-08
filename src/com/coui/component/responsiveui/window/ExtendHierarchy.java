package com.coui.component.responsiveui.window;

import android.content.Context;
import com.coui.component.responsiveui.unit.Dp;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: ExtendHierarchy.kt */
/* loaded from: classes3.dex */
public final class ExtendHierarchy {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public static final Dp f20032a = new Dp(280);

    /* renamed from: b, reason: collision with root package name */
    public static final Dp f20033b = new Dp(360);

    /* compiled from: ExtendHierarchy.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public Companion() {
        }

        public final float childWindowWidth(Context context, WindowWidthSizeClass windowWidthSizeClass, int i10) {
            i.f(context, "context");
            i.f(windowWidthSizeClass, "windowWidthSizeClass");
            return i10 - parentWindowWidth(context, windowWidthSizeClass, i10);
        }

        public final float parentWindowWidth(Context context, WindowWidthSizeClass windowWidthSizeClass, int i10) {
            i.f(context, "context");
            i.f(windowWidthSizeClass, "windowWidthSizeClass");
            if (i.b(windowWidthSizeClass, WindowWidthSizeClass.Medium)) {
                return ExtendHierarchy.f20032a.toPixel(context);
            }
            return i.b(windowWidthSizeClass, WindowWidthSizeClass.Expanded) ? ExtendHierarchy.f20033b.toPixel(context) : i10;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final Dp childWindowWidth(WindowWidthSizeClass windowWidthSizeClass, Dp windowWidth) {
            i.f(windowWidthSizeClass, "windowWidthSizeClass");
            i.f(windowWidth, "windowWidth");
            return windowWidth.minus(parentWindowWidth(windowWidthSizeClass, windowWidth));
        }

        public final Dp parentWindowWidth(WindowWidthSizeClass windowWidthSizeClass, Dp windowWidth) {
            i.f(windowWidthSizeClass, "windowWidthSizeClass");
            i.f(windowWidth, "windowWidth");
            if (i.b(windowWidthSizeClass, WindowWidthSizeClass.Medium)) {
                return ExtendHierarchy.f20032a;
            }
            return i.b(windowWidthSizeClass, WindowWidthSizeClass.Expanded) ? ExtendHierarchy.f20033b : windowWidth;
        }
    }
}
