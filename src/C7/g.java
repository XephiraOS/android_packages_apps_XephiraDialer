package C7;

import C9.j;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.i;
import v9.InterfaceC1637a;

/* compiled from: Weak.kt */
/* loaded from: classes3.dex */
public final class g<T> {

    /* renamed from: a, reason: collision with root package name */
    public WeakReference<T> f407a;

    public g(InterfaceC1637a<? extends T> initializer) {
        i.f(initializer, "initializer");
        this.f407a = new WeakReference<>(initializer.invoke());
    }

    public final T a(Object obj, j<?> property) {
        i.f(property, "property");
        return this.f407a.get();
    }
}
