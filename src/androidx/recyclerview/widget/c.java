package androidx.recyclerview.widget;

import androidx.recyclerview.widget.j;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: AsyncDifferConfig.java */
/* loaded from: classes.dex */
public final class c<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f11012a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f11013b;

    /* renamed from: c, reason: collision with root package name */
    public final j.f<T> f11014c;

    /* compiled from: AsyncDifferConfig.java */
    /* loaded from: classes.dex */
    public static final class a<T> {

        /* renamed from: d, reason: collision with root package name */
        public static final Object f11015d = new Object();

        /* renamed from: e, reason: collision with root package name */
        public static Executor f11016e;

        /* renamed from: a, reason: collision with root package name */
        public Executor f11017a;

        /* renamed from: b, reason: collision with root package name */
        public Executor f11018b;

        /* renamed from: c, reason: collision with root package name */
        public final j.f<T> f11019c;

        public a(j.f<T> fVar) {
            this.f11019c = fVar;
        }

        public c<T> a() {
            if (this.f11018b == null) {
                synchronized (f11015d) {
                    try {
                        if (f11016e == null) {
                            f11016e = Executors.newFixedThreadPool(2);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                this.f11018b = f11016e;
            }
            return new c<>(this.f11017a, this.f11018b, this.f11019c);
        }
    }

    public c(Executor executor, Executor executor2, j.f<T> fVar) {
        this.f11012a = executor;
        this.f11013b = executor2;
        this.f11014c = fVar;
    }

    public Executor a() {
        return this.f11013b;
    }

    public j.f<T> b() {
        return this.f11014c;
    }

    public Executor c() {
        return this.f11012a;
    }
}
