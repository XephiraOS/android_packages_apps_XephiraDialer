package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: SnackbarManager.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    public static a f23849e;

    /* renamed from: a, reason: collision with root package name */
    public final Object f23850a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final Handler f23851b = new Handler(Looper.getMainLooper(), new C0217a());

    /* renamed from: c, reason: collision with root package name */
    public c f23852c;

    /* renamed from: d, reason: collision with root package name */
    public c f23853d;

    /* compiled from: SnackbarManager.java */
    /* renamed from: com.google.android.material.snackbar.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0217a implements Handler.Callback {
        public C0217a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            a.this.d((c) message.obj);
            return true;
        }
    }

    /* compiled from: SnackbarManager.java */
    /* loaded from: classes3.dex */
    public interface b {
        void a(int i10);

        void show();
    }

    /* compiled from: SnackbarManager.java */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<b> f23855a;

        /* renamed from: b, reason: collision with root package name */
        public int f23856b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f23857c;

        public boolean a(b bVar) {
            if (bVar != null && this.f23855a.get() == bVar) {
                return true;
            }
            return false;
        }
    }

    public static a c() {
        if (f23849e == null) {
            f23849e = new a();
        }
        return f23849e;
    }

    public final boolean a(c cVar, int i10) {
        b bVar = cVar.f23855a.get();
        if (bVar != null) {
            this.f23851b.removeCallbacksAndMessages(cVar);
            bVar.a(i10);
            return true;
        }
        return false;
    }

    public void b(b bVar, int i10) {
        synchronized (this.f23850a) {
            try {
                if (f(bVar)) {
                    a(this.f23852c, i10);
                } else if (g(bVar)) {
                    a(this.f23853d, i10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d(c cVar) {
        synchronized (this.f23850a) {
            try {
                if (this.f23852c != cVar) {
                    if (this.f23853d == cVar) {
                    }
                }
                a(cVar, 2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean e(b bVar) {
        boolean z10;
        synchronized (this.f23850a) {
            try {
                if (!f(bVar) && !g(bVar)) {
                    z10 = false;
                }
                z10 = true;
            } finally {
            }
        }
        return z10;
    }

    public final boolean f(b bVar) {
        c cVar = this.f23852c;
        if (cVar != null && cVar.a(bVar)) {
            return true;
        }
        return false;
    }

    public final boolean g(b bVar) {
        c cVar = this.f23853d;
        if (cVar != null && cVar.a(bVar)) {
            return true;
        }
        return false;
    }

    public void h(b bVar) {
        synchronized (this.f23850a) {
            try {
                if (f(bVar)) {
                    this.f23852c = null;
                    if (this.f23853d != null) {
                        m();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void i(b bVar) {
        synchronized (this.f23850a) {
            try {
                if (f(bVar)) {
                    l(this.f23852c);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void j(b bVar) {
        synchronized (this.f23850a) {
            try {
                if (f(bVar)) {
                    c cVar = this.f23852c;
                    if (!cVar.f23857c) {
                        cVar.f23857c = true;
                        this.f23851b.removeCallbacksAndMessages(cVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void k(b bVar) {
        synchronized (this.f23850a) {
            try {
                if (f(bVar)) {
                    c cVar = this.f23852c;
                    if (cVar.f23857c) {
                        cVar.f23857c = false;
                        l(cVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void l(c cVar) {
        int i10 = cVar.f23856b;
        if (i10 == -2) {
            return;
        }
        if (i10 <= 0) {
            if (i10 == -1) {
                i10 = 1500;
            } else {
                i10 = 2750;
            }
        }
        this.f23851b.removeCallbacksAndMessages(cVar);
        Handler handler = this.f23851b;
        handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i10);
    }

    public final void m() {
        c cVar = this.f23853d;
        if (cVar != null) {
            this.f23852c = cVar;
            this.f23853d = null;
            b bVar = cVar.f23855a.get();
            if (bVar != null) {
                bVar.show();
            } else {
                this.f23852c = null;
            }
        }
    }
}
