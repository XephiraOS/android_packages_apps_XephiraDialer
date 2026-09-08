package androidx.window.layout;

import kotlin.jvm.internal.i;

/* compiled from: WindowInfoTracker.kt */
/* loaded from: classes.dex */
final class EmptyDecorator implements WindowInfoTrackerDecorator {

    /* renamed from: a, reason: collision with root package name */
    public static final EmptyDecorator f11989a = new EmptyDecorator();

    private EmptyDecorator() {
    }

    @Override // androidx.window.layout.WindowInfoTrackerDecorator
    public WindowInfoTracker a(WindowInfoTracker tracker) {
        i.f(tracker, "tracker");
        return tracker;
    }
}
