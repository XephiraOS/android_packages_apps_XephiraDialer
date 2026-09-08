package androidx.room;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: SharedSQLiteStatement.java */
/* loaded from: classes.dex */
public abstract class B {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f11227a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    public final RoomDatabase f11228b;

    /* renamed from: c, reason: collision with root package name */
    public volatile e0.k f11229c;

    public B(RoomDatabase roomDatabase) {
        this.f11228b = roomDatabase;
    }

    public e0.k a() {
        b();
        return e(this.f11227a.compareAndSet(false, true));
    }

    public void b() {
        this.f11228b.c();
    }

    public final e0.k c() {
        return this.f11228b.f(d());
    }

    public abstract String d();

    public final e0.k e(boolean z10) {
        if (z10) {
            if (this.f11229c == null) {
                this.f11229c = c();
            }
            return this.f11229c;
        }
        return c();
    }

    public void f(e0.k kVar) {
        if (kVar == this.f11229c) {
            this.f11227a.set(false);
        }
    }
}
