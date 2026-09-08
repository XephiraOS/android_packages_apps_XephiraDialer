package kotlin.collections;

import java.util.Iterator;
import v9.InterfaceC1637a;
import w9.InterfaceC1658a;

/* compiled from: Iterables.kt */
/* loaded from: classes4.dex */
public final class y<T> implements Iterable<x<? extends T>>, InterfaceC1658a {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC1637a<Iterator<T>> f34207a;

    /* JADX WARN: Multi-variable type inference failed */
    public y(InterfaceC1637a<? extends Iterator<? extends T>> iteratorFactory) {
        kotlin.jvm.internal.i.f(iteratorFactory, "iteratorFactory");
        this.f34207a = iteratorFactory;
    }

    @Override // java.lang.Iterable
    public Iterator<x<T>> iterator() {
        return new z(this.f34207a.invoke());
    }
}
