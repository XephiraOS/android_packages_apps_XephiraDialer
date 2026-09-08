package kotlin.collections;

import java.util.AbstractList;
import java.util.List;
import w9.InterfaceC1659b;

/* compiled from: AbstractMutableList.kt */
/* renamed from: kotlin.collections.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1222c<E> extends AbstractList<E> implements List<E>, InterfaceC1659b {
    public abstract int a();

    public abstract E c(int i10);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int i10) {
        return c(i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return a();
    }
}
