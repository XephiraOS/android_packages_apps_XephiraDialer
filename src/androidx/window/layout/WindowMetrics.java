package androidx.window.layout;

import android.graphics.Rect;
import androidx.window.core.Bounds;
import kotlin.jvm.internal.i;

/* compiled from: WindowMetrics.kt */
/* loaded from: classes.dex */
public final class WindowMetrics {

    /* renamed from: a, reason: collision with root package name */
    public final Bounds f12070a;

    public WindowMetrics(Bounds _bounds) {
        i.f(_bounds, "_bounds");
        this.f12070a = _bounds;
    }

    public final Rect a() {
        return this.f12070a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && i.b(WindowMetrics.class, obj.getClass())) {
            return i.b(this.f12070a, ((WindowMetrics) obj).f12070a);
        }
        return false;
    }

    public int hashCode() {
        return this.f12070a.hashCode();
    }

    public String toString() {
        return "WindowMetrics { bounds: " + a() + " }";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WindowMetrics(Rect bounds) {
        this(new Bounds(bounds));
        i.f(bounds, "bounds");
    }
}
