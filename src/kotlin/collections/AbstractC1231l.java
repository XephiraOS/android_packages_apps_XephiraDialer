package kotlin.collections;

import java.util.Iterator;
import w9.InterfaceC1658a;

/* compiled from: PrimitiveIterators.kt */
/* renamed from: kotlin.collections.l, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1231l implements Iterator<Character>, InterfaceC1658a {
    public abstract char a();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Character next() {
        return Character.valueOf(a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
