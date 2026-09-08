package io.grpc.internal;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: SerializeReentrantCallsDirectExecutor.java */
/* loaded from: classes4.dex */
public class g0 implements Executor {

    /* renamed from: c, reason: collision with root package name */
    public static final Logger f33174c = Logger.getLogger(g0.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public boolean f33175a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayDeque<Runnable> f33176b;

    public final void a() {
        while (true) {
            Runnable poll = this.f33176b.poll();
            if (poll != null) {
                try {
                    poll.run();
                } catch (Throwable th) {
                    f33174c.log(Level.SEVERE, "Exception while executing runnable " + poll, th);
                }
            } else {
                return;
            }
        }
    }

    public final void b(Runnable runnable) {
        if (this.f33176b == null) {
            this.f33176b = new ArrayDeque<>(4);
        }
        this.f33176b.add(runnable);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
    
        if (r6.f33176b == null) goto L9;
     */
    @Override // java.util.concurrent.Executor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void execute(java.lang.Runnable r7) {
        /*
            r6 = this;
            java.lang.String r0 = "'task' must not be null."
            com.google.common.base.k.p(r7, r0)
            boolean r0 = r6.f33175a
            if (r0 != 0) goto L43
            r0 = 1
            r6.f33175a = r0
            r0 = 0
            r7.run()     // Catch: java.lang.Throwable -> L1a
            java.util.ArrayDeque<java.lang.Runnable> r7 = r6.f33176b
            if (r7 == 0) goto L17
        L14:
            r6.a()
        L17:
            r6.f33175a = r0
            goto L46
        L1a:
            r1 = move-exception
            java.util.logging.Logger r2 = io.grpc.internal.g0.f33174c     // Catch: java.lang.Throwable -> L38
            java.util.logging.Level r3 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L38
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L38
            r4.<init>()     // Catch: java.lang.Throwable -> L38
            java.lang.String r5 = "Exception while executing runnable "
            r4.append(r5)     // Catch: java.lang.Throwable -> L38
            r4.append(r7)     // Catch: java.lang.Throwable -> L38
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L38
            r2.log(r3, r7, r1)     // Catch: java.lang.Throwable -> L38
            java.util.ArrayDeque<java.lang.Runnable> r7 = r6.f33176b
            if (r7 == 0) goto L17
            goto L14
        L38:
            r7 = move-exception
            java.util.ArrayDeque<java.lang.Runnable> r1 = r6.f33176b
            if (r1 == 0) goto L40
            r6.a()
        L40:
            r6.f33175a = r0
            throw r7
        L43:
            r6.b(r7)
        L46:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.g0.execute(java.lang.Runnable):void");
    }
}
