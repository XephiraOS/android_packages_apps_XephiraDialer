package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* compiled from: CompositeGeneratedAdaptersObserver.kt */
/* loaded from: classes.dex */
public final class CompositeGeneratedAdaptersObserver implements InterfaceC0489l {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0484g[] f10236a;

    public CompositeGeneratedAdaptersObserver(InterfaceC0484g[] generatedAdapters) {
        kotlin.jvm.internal.i.f(generatedAdapters, "generatedAdapters");
        this.f10236a = generatedAdapters;
    }

    @Override // androidx.lifecycle.InterfaceC0489l
    public void onStateChanged(InterfaceC0492o source, Lifecycle.Event event) {
        kotlin.jvm.internal.i.f(source, "source");
        kotlin.jvm.internal.i.f(event, "event");
        u uVar = new u();
        for (InterfaceC0484g interfaceC0484g : this.f10236a) {
            interfaceC0484g.a(source, event, false, uVar);
        }
        for (InterfaceC0484g interfaceC0484g2 : this.f10236a) {
            interfaceC0484g2.a(source, event, true, uVar);
        }
    }
}
