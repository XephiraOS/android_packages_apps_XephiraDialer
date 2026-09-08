package N2;

import D2.k;

/* compiled from: ModuleCreator.kt */
/* loaded from: classes.dex */
public abstract class a<T> extends Q2.a<T> {

    /* renamed from: b, reason: collision with root package name */
    public boolean f2295b;

    @Override // Q2.a
    public T a() {
        this.f2295b = true;
        T t10 = (T) k.c(d(), f(), e());
        if (t10 == null) {
            return null;
        }
        return t10;
    }

    @Override // Q2.a
    public T b() {
        if (this.f2295b) {
            return c();
        }
        return (T) super.b();
    }

    public abstract String d();

    public Object[] e() {
        return null;
    }

    public Class<?>[] f() {
        return null;
    }
}
