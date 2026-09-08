package V;

import androidx.lifecycle.I;
import androidx.lifecycle.K;
import kotlin.jvm.internal.i;

/* compiled from: InitializerViewModelFactory.kt */
/* loaded from: classes.dex */
public final class b implements K.b {

    /* renamed from: b, reason: collision with root package name */
    public final f<?>[] f3958b;

    public b(f<?>... initializers) {
        i.f(initializers, "initializers");
        this.f3958b = initializers;
    }

    @Override // androidx.lifecycle.K.b
    public <T extends I> T b(Class<T> modelClass, a extras) {
        i.f(modelClass, "modelClass");
        i.f(extras, "extras");
        T t10 = null;
        for (f<?> fVar : this.f3958b) {
            if (i.b(fVar.a(), modelClass)) {
                Object invoke = fVar.b().invoke(extras);
                if (invoke instanceof I) {
                    t10 = (T) invoke;
                } else {
                    t10 = null;
                }
            }
        }
        if (t10 != null) {
            return t10;
        }
        throw new IllegalArgumentException("No initializer set for given class " + modelClass.getName());
    }
}
