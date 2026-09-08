package T2;

import android.os.SystemClock;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.d;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: RequestFuture.java */
/* loaded from: classes.dex */
public class k<T> implements Future<T>, d.b<T>, d.a {

    /* renamed from: a, reason: collision with root package name */
    public Request<?> f3741a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3742b = false;

    /* renamed from: c, reason: collision with root package name */
    public T f3743c;

    /* renamed from: d, reason: collision with root package name */
    public VolleyError f3744d;

    public static <E> k<E> d() {
        return new k<>();
    }

    @Override // com.android.volley.d.b
    public synchronized void a(T t10) {
        this.f3742b = true;
        this.f3743c = t10;
        notifyAll();
    }

    @Override // com.android.volley.d.a
    public synchronized void b(VolleyError volleyError) {
        this.f3744d = volleyError;
        notifyAll();
    }

    public final synchronized T c(Long l10) {
        if (this.f3744d == null) {
            if (this.f3742b) {
                return this.f3743c;
            }
            if (l10 == null) {
                while (!isDone()) {
                    wait(0L);
                }
            } else if (l10.longValue() > 0) {
                long uptimeMillis = SystemClock.uptimeMillis();
                long longValue = l10.longValue() + uptimeMillis;
                while (!isDone() && uptimeMillis < longValue) {
                    wait(longValue - uptimeMillis);
                    uptimeMillis = SystemClock.uptimeMillis();
                }
            }
            if (this.f3744d == null) {
                if (this.f3742b) {
                    return this.f3743c;
                }
                throw new TimeoutException();
            }
            throw new ExecutionException(this.f3744d);
        }
        throw new ExecutionException(this.f3744d);
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z10) {
        if (this.f3741a == null) {
            return false;
        }
        if (isDone()) {
            return false;
        }
        this.f3741a.c();
        return true;
    }

    @Override // java.util.concurrent.Future
    public T get() {
        try {
            return c(null);
        } catch (TimeoutException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        Request<?> request = this.f3741a;
        if (request == null) {
            return false;
        }
        return request.A();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z10;
        if (!this.f3742b && this.f3744d == null) {
            if (!isCancelled()) {
                z10 = false;
            }
        }
        z10 = true;
        return z10;
    }

    @Override // java.util.concurrent.Future
    public T get(long j10, TimeUnit timeUnit) {
        return c(Long.valueOf(TimeUnit.MILLISECONDS.convert(j10, timeUnit)));
    }
}
