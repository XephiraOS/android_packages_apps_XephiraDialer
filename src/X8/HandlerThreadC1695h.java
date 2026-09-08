package x8;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import y8.C1714f;
import y8.InterfaceC1715g;

/* compiled from: WorkThread.java */
/* renamed from: x8.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class HandlerThreadC1695h extends HandlerThread {

    /* renamed from: a, reason: collision with root package name */
    public final List<Runnable> f38096a;

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray<b> f38097b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f38098c;

    /* compiled from: WorkThread.java */
    /* renamed from: x8.h$b */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f38099a;

        /* renamed from: b, reason: collision with root package name */
        public final long f38100b;

        public b(Runnable runnable, long j10) {
            this.f38099a = runnable;
            this.f38100b = j10;
        }
    }

    /* compiled from: WorkThread.java */
    /* renamed from: x8.h$c */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public static final HandlerThreadC1695h f38101a = new HandlerThreadC1695h();
    }

    public static void b(Runnable runnable) {
        c().f(runnable);
    }

    public static HandlerThreadC1695h c() {
        return c.f38101a;
    }

    public static /* synthetic */ String e() {
        return "onLooperPrepared, but looper is null";
    }

    public synchronized boolean d(int i10) {
        boolean z10;
        Handler handler = this.f38098c;
        if (handler != null) {
            return handler.hasMessages(i10);
        }
        if (this.f38097b.get(i10) != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        return z10;
    }

    public synchronized void f(Runnable runnable) {
        try {
            Handler handler = this.f38098c;
            if (handler != null) {
                handler.post(runnable);
            } else {
                this.f38096a.add(runnable);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void g(int i10, Runnable runnable, long j10) {
        Handler handler = this.f38098c;
        if (handler != null) {
            handler.postDelayed(runnable, j10);
        } else {
            this.f38097b.put(i10, new b(runnable, j10));
        }
    }

    public synchronized void h(int i10) {
        try {
            Handler handler = this.f38098c;
            if (handler != null) {
                handler.removeMessages(i10);
            } else {
                this.f38097b.remove(i10);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.os.HandlerThread
    public void onLooperPrepared() {
        super.onLooperPrepared();
        Looper looper = getLooper();
        if (looper == null) {
            C1714f.b("WorkThread", new InterfaceC1715g() { // from class: x8.g
                @Override // y8.InterfaceC1715g
                public final Object get() {
                    String e10;
                    e10 = HandlerThreadC1695h.e();
                    return e10;
                }
            });
            return;
        }
        synchronized (this) {
            try {
                this.f38098c = new Handler(looper);
                Iterator<Runnable> it = this.f38096a.iterator();
                while (it.hasNext()) {
                    this.f38098c.post(it.next());
                }
                this.f38096a.clear();
                for (int i10 = 0; i10 < this.f38097b.size(); i10++) {
                    b valueAt = this.f38097b.valueAt(i10);
                    this.f38098c.postDelayed(valueAt.f38099a, valueAt.f38100b);
                }
                this.f38097b.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public HandlerThreadC1695h() {
        super("OplusTrack-thread");
        this.f38096a = new ArrayList();
        this.f38097b = new SparseArray<>();
        start();
    }
}
