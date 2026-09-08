package f3;

import Z2.j;
import s3.C1540k;

/* compiled from: SimpleResource.java */
/* renamed from: f3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0998b<T> implements j<T> {

    /* renamed from: a, reason: collision with root package name */
    public final T f31700a;

    public C0998b(T t10) {
        this.f31700a = (T) C1540k.d(t10);
    }

    @Override // Z2.j
    public final int c() {
        return 1;
    }

    @Override // Z2.j
    public Class<T> d() {
        return (Class<T>) this.f31700a.getClass();
    }

    @Override // Z2.j
    public final T get() {
        return this.f31700a;
    }

    @Override // Z2.j
    public void b() {
    }
}
