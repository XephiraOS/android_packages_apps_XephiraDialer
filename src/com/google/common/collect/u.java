package com.google.common.collect;

import java.util.Iterator;

/* compiled from: PeekingIterator.java */
/* loaded from: classes3.dex */
public interface u<E> extends Iterator<E> {
    @Override // java.util.Iterator
    E next();

    E peek();
}
