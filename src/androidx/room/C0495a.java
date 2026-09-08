package androidx.room;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import m.InterfaceC1301a;

/* compiled from: AutoCloser.java */
/* renamed from: androidx.room.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0495a {

    /* renamed from: e, reason: collision with root package name */
    public final long f11312e;

    /* renamed from: f, reason: collision with root package name */
    public final Executor f11313f;

    /* renamed from: i, reason: collision with root package name */
    public e0.g f11316i;

    /* renamed from: a, reason: collision with root package name */
    public e0.h f11308a = null;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f11309b = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    public Runnable f11310c = null;

    /* renamed from: d, reason: collision with root package name */
    public final Object f11311d = new Object();

    /* renamed from: g, reason: collision with root package name */
    public int f11314g = 0;

    /* renamed from: h, reason: collision with root package name */
    public long f11315h = SystemClock.uptimeMillis();

    /* renamed from: j, reason: collision with root package name */
    public boolean f11317j = false;

    /* renamed from: k, reason: collision with root package name */
    public final Runnable f11318k = new RunnableC0138a();

    /* renamed from: l, reason: collision with root package name */
    public final Runnable f11319l = new b();

    /* compiled from: AutoCloser.java */
    /* renamed from: androidx.room.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0138a implements Runnable {
        public RunnableC0138a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0495a c0495a = C0495a.this;
            c0495a.f11313f.execute(c0495a.f11319l);
        }
    }

    /* compiled from: AutoCloser.java */
    /* renamed from: androidx.room.a$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (C0495a.this.f11311d) {
                try {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    C0495a c0495a = C0495a.this;
                    if (uptimeMillis - c0495a.f11315h < c0495a.f11312e) {
                        return;
                    }
                    if (c0495a.f11314g != 0) {
                        return;
                    }
                    Runnable runnable = c0495a.f11310c;
                    if (runnable != null) {
                        runnable.run();
                        e0.g gVar = C0495a.this.f11316i;
                        if (gVar != null && gVar.isOpen()) {
                            try {
                                C0495a.this.f11316i.close();
                            } catch (IOException e10) {
                                c0.e.a(e10);
                            }
                            C0495a.this.f11316i = null;
                        }
                        return;
                    }
                    throw new IllegalStateException("mOnAutoCloseCallback is null but it should have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public C0495a(long j10, TimeUnit timeUnit, Executor executor) {
        this.f11312e = timeUnit.toMillis(j10);
        this.f11313f = executor;
    }

    public void a() {
        synchronized (this.f11311d) {
            try {
                this.f11317j = true;
                e0.g gVar = this.f11316i;
                if (gVar != null) {
                    gVar.close();
                }
                this.f11316i = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b() {
        synchronized (this.f11311d) {
            try {
                int i10 = this.f11314g;
                if (i10 > 0) {
                    int i11 = i10 - 1;
                    this.f11314g = i11;
                    if (i11 == 0) {
                        if (this.f11316i == null) {
                            return;
                        } else {
                            this.f11309b.postDelayed(this.f11318k, this.f11312e);
                        }
                    }
                    return;
                }
                throw new IllegalStateException("ref count is 0 or lower but we're supposed to decrement");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public <V> V c(InterfaceC1301a<e0.g, V> interfaceC1301a) {
        try {
            return interfaceC1301a.apply(e());
        } finally {
            b();
        }
    }

    public e0.g d() {
        e0.g gVar;
        synchronized (this.f11311d) {
            gVar = this.f11316i;
        }
        return gVar;
    }

    public e0.g e() {
        synchronized (this.f11311d) {
            try {
                this.f11309b.removeCallbacks(this.f11318k);
                this.f11314g++;
                if (!this.f11317j) {
                    e0.g gVar = this.f11316i;
                    if (gVar != null && gVar.isOpen()) {
                        return this.f11316i;
                    }
                    e0.h hVar = this.f11308a;
                    if (hVar != null) {
                        e0.g M10 = hVar.M();
                        this.f11316i = M10;
                        return M10;
                    }
                    throw new IllegalStateException("AutoCloser has not been initialized. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
                }
                throw new IllegalStateException("Attempting to open already closed database.");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f(e0.h hVar) {
        if (this.f11308a != null) {
            Log.e("ROOM", "AutoCloser initialized multiple times. Please file a bug against room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
        } else {
            this.f11308a = hVar;
        }
    }

    public boolean g() {
        return !this.f11317j;
    }

    public void h(Runnable runnable) {
        this.f11310c = runnable;
    }
}
