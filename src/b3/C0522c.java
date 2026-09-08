package b3;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import s3.C1540k;

/* compiled from: DiskCacheWriteLocker.java */
/* renamed from: b3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0522c {

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, a> f12104a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final b f12105b = new b();

    /* compiled from: DiskCacheWriteLocker.java */
    /* renamed from: b3.c$a */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Lock f12106a = new ReentrantLock();

        /* renamed from: b, reason: collision with root package name */
        public int f12107b;
    }

    /* compiled from: DiskCacheWriteLocker.java */
    /* renamed from: b3.c$b */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Queue<a> f12108a = new ArrayDeque();

        public a a() {
            a poll;
            synchronized (this.f12108a) {
                poll = this.f12108a.poll();
            }
            if (poll == null) {
                return new a();
            }
            return poll;
        }

        public void b(a aVar) {
            synchronized (this.f12108a) {
                try {
                    if (this.f12108a.size() < 10) {
                        this.f12108a.offer(aVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void a(String str) {
        a aVar;
        synchronized (this) {
            try {
                aVar = this.f12104a.get(str);
                if (aVar == null) {
                    aVar = this.f12105b.a();
                    this.f12104a.put(str, aVar);
                }
                aVar.f12107b++;
            } catch (Throwable th) {
                throw th;
            }
        }
        aVar.f12106a.lock();
    }

    public void b(String str) {
        a aVar;
        synchronized (this) {
            try {
                aVar = (a) C1540k.d(this.f12104a.get(str));
                int i10 = aVar.f12107b;
                if (i10 >= 1) {
                    int i11 = i10 - 1;
                    aVar.f12107b = i11;
                    if (i11 == 0) {
                        a remove = this.f12104a.remove(str);
                        if (remove.equals(aVar)) {
                            this.f12105b.b(remove);
                        } else {
                            throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                        }
                    }
                } else {
                    throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f12107b);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        aVar.f12106a.unlock();
    }
}
