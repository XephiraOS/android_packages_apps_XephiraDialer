package V;

import androidx.lifecycle.I;
import kotlin.jvm.internal.i;
import v9.l;

/* compiled from: InitializerViewModelFactory.kt */
/* loaded from: classes.dex */
public final class f<T extends I> {

    /* renamed from: a, reason: collision with root package name */
    public final Class<T> f3961a;

    /* renamed from: b, reason: collision with root package name */
    public final l<a, T> f3962b;

    /* JADX WARN: Multi-variable type inference failed */
    public f(Class<T> clazz, l<? super a, ? extends T> initializer) {
        i.f(clazz, "clazz");
        i.f(initializer, "initializer");
        this.f3961a = clazz;
        this.f3962b = initializer;
    }

    public final Class<T> a() {
        return this.f3961a;
    }

    public final l<a, T> b() {
        return this.f3962b;
    }
}
