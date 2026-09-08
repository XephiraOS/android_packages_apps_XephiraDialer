package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* compiled from: SingleGeneratedAdapterObserver.kt */
/* loaded from: classes.dex */
public final class SingleGeneratedAdapterObserver implements InterfaceC0489l {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0484g f10334a;

    public SingleGeneratedAdapterObserver(InterfaceC0484g generatedAdapter) {
        kotlin.jvm.internal.i.f(generatedAdapter, "generatedAdapter");
        this.f10334a = generatedAdapter;
    }

    @Override // androidx.lifecycle.InterfaceC0489l
    public void onStateChanged(InterfaceC0492o source, Lifecycle.Event event) {
        kotlin.jvm.internal.i.f(source, "source");
        kotlin.jvm.internal.i.f(event, "event");
        this.f10334a.a(source, event, false, null);
        this.f10334a.a(source, event, true, null);
    }
}
