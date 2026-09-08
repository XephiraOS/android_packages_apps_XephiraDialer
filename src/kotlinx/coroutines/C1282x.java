package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: CompletionState.kt */
/* renamed from: kotlinx.coroutines.x, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C1282x {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f34649b = AtomicIntegerFieldUpdater.newUpdater(C1282x.class, "_handled");
    private volatile int _handled;

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f34650a;

    public C1282x(Throwable th, boolean z10) {
        this.f34650a = th;
        this._handled = z10 ? 1 : 0;
    }

    public final boolean a() {
        if (f34649b.get(this) != 0) {
            return true;
        }
        return false;
    }

    public final boolean b() {
        return f34649b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return G.a(this) + '[' + this.f34650a + ']';
    }

    public /* synthetic */ C1282x(Throwable th, boolean z10, int i10, kotlin.jvm.internal.f fVar) {
        this(th, (i10 & 2) != 0 ? false : z10);
    }
}
