package F;

import android.os.CancellationSignal;

/* compiled from: CancellationSignal.java */
@Deprecated
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public boolean f777a;

    /* renamed from: b, reason: collision with root package name */
    public a f778b;

    /* renamed from: c, reason: collision with root package name */
    public Object f779c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f780d;

    /* compiled from: CancellationSignal.java */
    /* loaded from: classes.dex */
    public interface a {
        void onCancel();
    }

    public void a() {
        synchronized (this) {
            try {
                if (this.f777a) {
                    return;
                }
                this.f777a = true;
                this.f780d = true;
                a aVar = this.f778b;
                Object obj = this.f779c;
                if (aVar != null) {
                    try {
                        aVar.onCancel();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f780d = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                if (obj != null) {
                    ((CancellationSignal) obj).cancel();
                }
                synchronized (this) {
                    this.f780d = false;
                    notifyAll();
                }
            } finally {
            }
        }
    }

    public Object b() {
        Object obj;
        synchronized (this) {
            try {
                if (this.f779c == null) {
                    CancellationSignal cancellationSignal = new CancellationSignal();
                    this.f779c = cancellationSignal;
                    if (this.f777a) {
                        cancellationSignal.cancel();
                    }
                }
                obj = this.f779c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public void c(a aVar) {
        synchronized (this) {
            try {
                d();
                if (this.f778b == aVar) {
                    return;
                }
                this.f778b = aVar;
                if (this.f777a && aVar != null) {
                    aVar.onCancel();
                }
            } finally {
            }
        }
    }

    public final void d() {
        while (this.f780d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }
}
