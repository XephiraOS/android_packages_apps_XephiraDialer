package W;

import I.i;
import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.os.OperationCanceledException;
import androidx.loader.content.ModernAsyncTask;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* compiled from: AsyncTaskLoader.java */
/* loaded from: classes.dex */
public abstract class a<D> extends c<D> {

    /* renamed from: j, reason: collision with root package name */
    public final Executor f4096j;

    /* renamed from: k, reason: collision with root package name */
    public volatile a<D>.RunnableC0077a f4097k;

    /* renamed from: l, reason: collision with root package name */
    public volatile a<D>.RunnableC0077a f4098l;

    /* renamed from: m, reason: collision with root package name */
    public long f4099m;

    /* renamed from: n, reason: collision with root package name */
    public long f4100n;

    /* renamed from: o, reason: collision with root package name */
    public Handler f4101o;

    /* compiled from: AsyncTaskLoader.java */
    /* renamed from: W.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class RunnableC0077a extends ModernAsyncTask<Void, Void, D> implements Runnable {

        /* renamed from: k, reason: collision with root package name */
        public final CountDownLatch f4102k = new CountDownLatch(1);

        /* renamed from: l, reason: collision with root package name */
        public boolean f4103l;

        public RunnableC0077a() {
        }

        @Override // androidx.loader.content.ModernAsyncTask
        public void h(D d10) {
            try {
                a.this.E(this, d10);
            } finally {
                this.f4102k.countDown();
            }
        }

        @Override // androidx.loader.content.ModernAsyncTask
        public void i(D d10) {
            try {
                a.this.F(this, d10);
            } finally {
                this.f4102k.countDown();
            }
        }

        @Override // androidx.loader.content.ModernAsyncTask
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public D b(Void... voidArr) {
            try {
                return (D) a.this.K();
            } catch (OperationCanceledException e10) {
                if (this.f()) {
                    return null;
                }
                throw e10;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4103l = false;
            a.this.G();
        }
    }

    public a(Context context) {
        this(context, ModernAsyncTask.f10408h);
    }

    public void E(a<D>.RunnableC0077a runnableC0077a, D d10) {
        J(d10);
        if (this.f4098l == runnableC0077a) {
            x();
            this.f4100n = SystemClock.uptimeMillis();
            this.f4098l = null;
            e();
            G();
        }
    }

    public void F(a<D>.RunnableC0077a runnableC0077a, D d10) {
        if (this.f4097k != runnableC0077a) {
            E(runnableC0077a, d10);
            return;
        }
        if (k()) {
            J(d10);
            return;
        }
        c();
        this.f4100n = SystemClock.uptimeMillis();
        this.f4097k = null;
        f(d10);
    }

    public void G() {
        if (this.f4098l == null && this.f4097k != null) {
            if (this.f4097k.f4103l) {
                this.f4097k.f4103l = false;
                this.f4101o.removeCallbacks(this.f4097k);
            }
            if (this.f4099m > 0 && SystemClock.uptimeMillis() < this.f4100n + this.f4099m) {
                this.f4097k.f4103l = true;
                this.f4101o.postAtTime(this.f4097k, this.f4100n + this.f4099m);
            } else {
                this.f4097k.c(this.f4096j, null);
            }
        }
    }

    public boolean H() {
        if (this.f4098l != null) {
            return true;
        }
        return false;
    }

    public abstract D I();

    public D K() {
        return I();
    }

    @Override // W.c
    @Deprecated
    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.g(str, fileDescriptor, printWriter, strArr);
        if (this.f4097k != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f4097k);
            printWriter.print(" waiting=");
            printWriter.println(this.f4097k.f4103l);
        }
        if (this.f4098l != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f4098l);
            printWriter.print(" waiting=");
            printWriter.println(this.f4098l.f4103l);
        }
        if (this.f4099m != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            i.c(this.f4099m, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            i.b(this.f4100n, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    @Override // W.c
    public boolean o() {
        if (this.f4097k == null) {
            return false;
        }
        if (!this.f4117e) {
            this.f4120h = true;
        }
        if (this.f4098l != null) {
            if (this.f4097k.f4103l) {
                this.f4097k.f4103l = false;
                this.f4101o.removeCallbacks(this.f4097k);
            }
            this.f4097k = null;
            return false;
        }
        if (this.f4097k.f4103l) {
            this.f4097k.f4103l = false;
            this.f4101o.removeCallbacks(this.f4097k);
            this.f4097k = null;
            return false;
        }
        boolean a10 = this.f4097k.a(false);
        if (a10) {
            this.f4098l = this.f4097k;
            D();
        }
        this.f4097k = null;
        return a10;
    }

    @Override // W.c
    public void q() {
        super.q();
        b();
        this.f4097k = new RunnableC0077a();
        G();
    }

    public a(Context context, Executor executor) {
        super(context);
        this.f4100n = -10000L;
        this.f4096j = executor;
    }

    public void D() {
    }

    public void J(D d10) {
    }
}
