package m6;

import c6.AbstractC0558a;

/* compiled from: EffectiveValueCallback.java */
/* renamed from: m6.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1336b<T> {

    /* renamed from: a, reason: collision with root package name */
    public final C1335a<T> f35151a;

    /* renamed from: b, reason: collision with root package name */
    public AbstractC0558a<?, ?> f35152b;

    /* renamed from: c, reason: collision with root package name */
    public T f35153c;

    public C1336b() {
        this.f35151a = new C1335a<>();
        this.f35153c = null;
    }

    public T a(C1335a<T> c1335a) {
        return this.f35153c;
    }

    public final T b(float f10, float f11, T t10, T t11, float f12, float f13, float f14) {
        return a(this.f35151a.h(f10, f11, t10, t11, f12, f13, f14));
    }

    public final void c(AbstractC0558a<?, ?> abstractC0558a) {
        this.f35152b = abstractC0558a;
    }

    public C1336b(T t10) {
        this.f35151a = new C1335a<>();
        this.f35153c = t10;
    }
}
