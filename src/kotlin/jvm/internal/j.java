package kotlin.jvm.internal;

/* compiled from: PackageReference.kt */
/* loaded from: classes4.dex */
public final class j implements c {

    /* renamed from: a, reason: collision with root package name */
    public final Class<?> f34241a;

    /* renamed from: b, reason: collision with root package name */
    public final String f34242b;

    public j(Class<?> jClass, String moduleName) {
        i.f(jClass, "jClass");
        i.f(moduleName, "moduleName");
        this.f34241a = jClass;
        this.f34242b = moduleName;
    }

    @Override // kotlin.jvm.internal.c
    public Class<?> d() {
        return this.f34241a;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof j) && i.b(d(), ((j) obj).d())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return d().hashCode();
    }

    public String toString() {
        return d().toString() + " (Kotlin reflection is not available)";
    }
}
