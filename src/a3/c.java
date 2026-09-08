package a3;

import a3.l;
import java.util.Queue;
import s3.C1541l;

/* compiled from: BaseKeyPool.java */
/* loaded from: classes.dex */
public abstract class c<T extends l> {

    /* renamed from: a, reason: collision with root package name */
    public final Queue<T> f6356a = C1541l.f(20);

    public abstract T a();

    public T b() {
        T poll = this.f6356a.poll();
        if (poll == null) {
            return a();
        }
        return poll;
    }

    public void c(T t10) {
        if (this.f6356a.size() < 20) {
            this.f6356a.offer(t10);
        }
    }
}
