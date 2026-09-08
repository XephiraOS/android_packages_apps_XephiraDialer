package androidx.activity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import v9.InterfaceC1637a;

/* compiled from: FullyDrawnReporter.kt */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f7111a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC1637a<m9.q> f7112b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f7113c;

    /* renamed from: d, reason: collision with root package name */
    public int f7114d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7115e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7116f;

    /* renamed from: g, reason: collision with root package name */
    public final List<InterfaceC1637a<m9.q>> f7117g;

    /* renamed from: h, reason: collision with root package name */
    public final Runnable f7118h;

    public l(Executor executor, InterfaceC1637a<m9.q> reportFullyDrawn) {
        kotlin.jvm.internal.i.f(executor, "executor");
        kotlin.jvm.internal.i.f(reportFullyDrawn, "reportFullyDrawn");
        this.f7111a = executor;
        this.f7112b = reportFullyDrawn;
        this.f7113c = new Object();
        this.f7117g = new ArrayList();
        this.f7118h = new Runnable() { // from class: androidx.activity.k
            @Override // java.lang.Runnable
            public final void run() {
                l.d(l.this);
            }
        };
    }

    public static final void d(l this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        synchronized (this$0.f7113c) {
            try {
                this$0.f7115e = false;
                if (this$0.f7114d == 0 && !this$0.f7116f) {
                    this$0.f7112b.invoke();
                    this$0.b();
                }
                m9.q qVar = m9.q.f35511a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        synchronized (this.f7113c) {
            try {
                this.f7116f = true;
                Iterator<T> it = this.f7117g.iterator();
                while (it.hasNext()) {
                    ((InterfaceC1637a) it.next()).invoke();
                }
                this.f7117g.clear();
                m9.q qVar = m9.q.f35511a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c() {
        boolean z10;
        synchronized (this.f7113c) {
            z10 = this.f7116f;
        }
        return z10;
    }
}
