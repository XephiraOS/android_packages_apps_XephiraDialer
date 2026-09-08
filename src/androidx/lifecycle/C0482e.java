package androidx.lifecycle;

import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.S;
import kotlinx.coroutines.w0;

/* compiled from: DispatchQueue.kt */
/* renamed from: androidx.lifecycle.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0482e {

    /* renamed from: b, reason: collision with root package name */
    public boolean f10359b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f10360c;

    /* renamed from: a, reason: collision with root package name */
    public boolean f10358a = true;

    /* renamed from: d, reason: collision with root package name */
    public final Queue<Runnable> f10361d = new ArrayDeque();

    public static final void d(C0482e this$0, Runnable runnable) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(runnable, "$runnable");
        this$0.f(runnable);
    }

    public final boolean b() {
        if (!this.f10359b && this.f10358a) {
            return false;
        }
        return true;
    }

    public final void c(CoroutineContext context, final Runnable runnable) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(runnable, "runnable");
        w0 i02 = S.c().i0();
        if (!i02.g0(context) && !b()) {
            f(runnable);
        } else {
            i02.f0(context, new Runnable() { // from class: androidx.lifecycle.d
                @Override // java.lang.Runnable
                public final void run() {
                    C0482e.d(C0482e.this, runnable);
                }
            });
        }
    }

    public final void e() {
        if (this.f10360c) {
            return;
        }
        try {
            this.f10360c = true;
            while ((!this.f10361d.isEmpty()) && b()) {
                Runnable poll = this.f10361d.poll();
                if (poll != null) {
                    poll.run();
                }
            }
        } finally {
            this.f10360c = false;
        }
    }

    public final void f(Runnable runnable) {
        if (this.f10361d.offer(runnable)) {
            e();
            return;
        }
        throw new IllegalStateException("cannot enqueue any more runnables".toString());
    }

    public final void g() {
        this.f10359b = true;
        e();
    }

    public final void h() {
        this.f10358a = true;
    }

    public final void i() {
        if (!this.f10358a) {
            return;
        }
        if (!this.f10359b) {
            this.f10358a = false;
            e();
            return;
        }
        throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
    }
}
