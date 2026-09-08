package F8;

import java.util.concurrent.locks.ReentrantLock;

/* compiled from: SystemServiceProxy.java */
/* loaded from: classes3.dex */
public abstract class a<T> {

    /* renamed from: e, reason: collision with root package name */
    public static String f1014e;

    /* renamed from: b, reason: collision with root package name */
    public String f1016b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1017c;

    /* renamed from: a, reason: collision with root package name */
    public ThreadLocal<String> f1015a = new ThreadLocal<>();

    /* renamed from: d, reason: collision with root package name */
    public final ReentrantLock f1018d = new ReentrantLock(true);

    public a() {
        f1014e = getClass().getName();
        this.f1017c = true;
    }
}
