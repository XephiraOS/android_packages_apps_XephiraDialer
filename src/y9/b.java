package y9;

import C9.j;
import kotlin.jvm.internal.i;

/* compiled from: Delegates.kt */
/* loaded from: classes4.dex */
public final class b<T> implements c<Object, T> {

    /* renamed from: a, reason: collision with root package name */
    public T f38158a;

    @Override // y9.c
    public T a(Object obj, j<?> property) {
        i.f(property, "property");
        T t10 = this.f38158a;
        if (t10 != null) {
            return t10;
        }
        throw new IllegalStateException("Property " + property.getName() + " should be initialized before get.");
    }

    @Override // y9.c
    public void b(Object obj, j<?> property, T value) {
        i.f(property, "property");
        i.f(value, "value");
        this.f38158a = value;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("NotNullProperty(");
        if (this.f38158a != null) {
            str = "value=" + this.f38158a;
        } else {
            str = "value not initialized yet";
        }
        sb.append(str);
        sb.append(')');
        return sb.toString();
    }
}
