package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* compiled from: SavedStateHandleController.kt */
/* loaded from: classes.dex */
public final class SavedStateHandleController implements InterfaceC0489l {

    /* renamed from: a, reason: collision with root package name */
    public final String f10322a;

    /* renamed from: b, reason: collision with root package name */
    public final D f10323b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f10324c;

    public SavedStateHandleController(String key, D handle) {
        kotlin.jvm.internal.i.f(key, "key");
        kotlin.jvm.internal.i.f(handle, "handle");
        this.f10322a = key;
        this.f10323b = handle;
    }

    public final void a(androidx.savedstate.a registry, Lifecycle lifecycle) {
        kotlin.jvm.internal.i.f(registry, "registry");
        kotlin.jvm.internal.i.f(lifecycle, "lifecycle");
        if (!this.f10324c) {
            this.f10324c = true;
            lifecycle.a(this);
            registry.h(this.f10322a, this.f10323b.c());
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner".toString());
    }

    public final D b() {
        return this.f10323b;
    }

    public final boolean c() {
        return this.f10324c;
    }

    @Override // androidx.lifecycle.InterfaceC0489l
    public void onStateChanged(InterfaceC0492o source, Lifecycle.Event event) {
        kotlin.jvm.internal.i.f(source, "source");
        kotlin.jvm.internal.i.f(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.f10324c = false;
            source.getLifecycle().d(this);
        }
    }
}
