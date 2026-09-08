package androidx.lifecycle;

import androidx.lifecycle.C0478a;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: Access modifiers changed from: package-private */
@Deprecated
/* loaded from: classes.dex */
public class ReflectiveGenericLifecycleObserver implements InterfaceC0489l {

    /* renamed from: a, reason: collision with root package name */
    public final Object f10312a;

    /* renamed from: b, reason: collision with root package name */
    public final C0478a.C0128a f10313b;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f10312a = obj;
        this.f10313b = C0478a.f10348c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.InterfaceC0489l
    public void onStateChanged(InterfaceC0492o interfaceC0492o, Lifecycle.Event event) {
        this.f10313b.a(interfaceC0492o, event, this.f10312a);
    }
}
