package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;

/* compiled from: SettableFuture.java */
/* loaded from: classes3.dex */
public final class i<V> extends AbstractFuture.i<V> {
    public static <V> i<V> B() {
        return new i<>();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean A(V v10) {
        return super.A(v10);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture.i, com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public /* bridge */ /* synthetic */ boolean cancel(boolean z10) {
        return super.cancel(z10);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture.i, com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public /* bridge */ /* synthetic */ boolean isCancelled() {
        return super.isCancelled();
    }
}
