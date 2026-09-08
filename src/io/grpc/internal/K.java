package io.grpc.internal;

import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: LogExceptionRunnable.java */
/* loaded from: classes4.dex */
public final class K implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f32607b = Logger.getLogger(K.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f32608a;

    public K(Runnable runnable) {
        this.f32608a = (Runnable) com.google.common.base.k.p(runnable, "task");
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f32608a.run();
        } catch (Throwable th) {
            f32607b.log(Level.SEVERE, "Exception while executing runnable " + this.f32608a, th);
            com.google.common.base.q.f(th);
            throw new AssertionError(th);
        }
    }

    public String toString() {
        return "LogExceptionRunnable(" + this.f32608a + ")";
    }
}
