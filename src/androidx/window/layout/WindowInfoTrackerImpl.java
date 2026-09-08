package androidx.window.layout;

import android.app.Activity;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.flow.c;

/* compiled from: WindowInfoTrackerImpl.kt */
/* loaded from: classes.dex */
public final class WindowInfoTrackerImpl implements WindowInfoTracker {

    /* renamed from: d, reason: collision with root package name */
    public static final Companion f12066d = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    public final WindowMetricsCalculator f12067b;

    /* renamed from: c, reason: collision with root package name */
    public final WindowBackend f12068c;

    /* compiled from: WindowInfoTrackerImpl.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public WindowInfoTrackerImpl(WindowMetricsCalculator windowMetricsCalculator, WindowBackend windowBackend) {
        i.f(windowMetricsCalculator, "windowMetricsCalculator");
        i.f(windowBackend, "windowBackend");
        this.f12067b = windowMetricsCalculator;
        this.f12068c = windowBackend;
    }

    @Override // androidx.window.layout.WindowInfoTracker
    public kotlinx.coroutines.flow.a<WindowLayoutInfo> b(Activity activity) {
        i.f(activity, "activity");
        return c.h(new WindowInfoTrackerImpl$windowLayoutInfo$1(this, activity, null));
    }
}
