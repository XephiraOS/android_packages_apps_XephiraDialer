package kotlin.collections;

import java.util.Iterator;
import w9.InterfaceC1658a;

/* compiled from: PrimitiveIterators.kt */
/* loaded from: classes4.dex */
public abstract class A implements Iterator<Integer>, InterfaceC1658a {
    public abstract int a();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Integer next() {
        return Integer.valueOf(a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
