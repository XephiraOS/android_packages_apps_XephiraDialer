package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* compiled from: SavedStateHandleSupport.kt */
/* loaded from: classes.dex */
public final class SavedStateHandleAttacher implements InterfaceC0489l {

    /* renamed from: a, reason: collision with root package name */
    public final SavedStateHandlesProvider f10321a;

    public SavedStateHandleAttacher(SavedStateHandlesProvider provider) {
        kotlin.jvm.internal.i.f(provider, "provider");
        this.f10321a = provider;
    }

    @Override // androidx.lifecycle.InterfaceC0489l
    public void onStateChanged(InterfaceC0492o source, Lifecycle.Event event) {
        kotlin.jvm.internal.i.f(source, "source");
        kotlin.jvm.internal.i.f(event, "event");
        if (event == Lifecycle.Event.ON_CREATE) {
            source.getLifecycle().d(this);
            this.f10321a.c();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + event).toString());
        }
    }
}
