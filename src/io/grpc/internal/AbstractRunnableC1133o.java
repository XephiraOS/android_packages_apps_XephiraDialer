package io.grpc.internal;

import io.grpc.Context;

/* compiled from: ContextRunnable.java */
/* renamed from: io.grpc.internal.o, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractRunnableC1133o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final Context f33267a;

    public AbstractRunnableC1133o(Context context) {
        this.f33267a = context;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        Context c10 = this.f33267a.c();
        try {
            a();
        } finally {
            this.f33267a.o(c10);
        }
    }
}
