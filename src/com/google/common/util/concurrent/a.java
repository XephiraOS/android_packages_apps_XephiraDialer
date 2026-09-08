package com.google.common.util.concurrent;

import java.util.concurrent.Future;

/* compiled from: Futures.java */
/* loaded from: classes3.dex */
public final class a extends e {
    public static <V> V a(Future<V> future) {
        com.google.common.base.k.x(future.isDone(), "Future was expected to be done: %s", future);
        return (V) k.a(future);
    }
}
