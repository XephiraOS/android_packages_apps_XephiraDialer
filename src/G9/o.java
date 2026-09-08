package G9;

import java.io.InterruptedIOException;

/* compiled from: Timeout.kt */
/* loaded from: classes4.dex */
public class o {

    /* renamed from: c, reason: collision with root package name */
    public static final b f1165c = new b(null);

    /* renamed from: d, reason: collision with root package name */
    public static final o f1166d = new a();

    /* renamed from: a, reason: collision with root package name */
    public boolean f1167a;

    /* renamed from: b, reason: collision with root package name */
    public long f1168b;

    /* compiled from: Timeout.kt */
    /* loaded from: classes4.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public void a() {
        if (!Thread.currentThread().isInterrupted()) {
            if (this.f1167a && this.f1168b - System.nanoTime() <= 0) {
                throw new InterruptedIOException("deadline reached");
            }
            return;
        }
        throw new InterruptedIOException("interrupted");
    }

    /* compiled from: Timeout.kt */
    /* loaded from: classes4.dex */
    public static final class a extends o {
        @Override // G9.o
        public void a() {
        }
    }
}
