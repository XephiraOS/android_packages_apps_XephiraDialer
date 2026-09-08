package com.android.contacts.vcard;

import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: ProcessorBase.java */
/* loaded from: classes.dex */
public abstract class q implements RunnableFuture<Object> {
    public abstract int a();

    public abstract boolean cancel(boolean z10);

    @Override // java.util.concurrent.Future
    public final Object get() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean isDone();

    @Override // java.util.concurrent.Future
    public final Object get(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }
}
