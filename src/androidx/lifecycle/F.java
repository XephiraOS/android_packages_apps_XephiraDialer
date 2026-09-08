package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.C1229j;

/* compiled from: SavedStateViewModelFactory.kt */
/* loaded from: classes.dex */
public final class F {

    /* renamed from: a, reason: collision with root package name */
    public static final List<Class<?>> f10252a;

    /* renamed from: b, reason: collision with root package name */
    public static final List<Class<?>> f10253b;

    static {
        List<Class<?>> j10;
        List<Class<?>> b10;
        j10 = kotlin.collections.o.j(Application.class, D.class);
        f10252a = j10;
        b10 = kotlin.collections.n.b(D.class);
        f10253b = b10;
    }

    public static final <T> Constructor<T> c(Class<T> modelClass, List<? extends Class<?>> signature) {
        List K10;
        kotlin.jvm.internal.i.f(modelClass, "modelClass");
        kotlin.jvm.internal.i.f(signature, "signature");
        Object[] constructors = modelClass.getConstructors();
        kotlin.jvm.internal.i.e(constructors, "modelClass.constructors");
        for (Object obj : constructors) {
            Constructor<T> constructor = (Constructor<T>) obj;
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            kotlin.jvm.internal.i.e(parameterTypes, "constructor.parameterTypes");
            K10 = C1229j.K(parameterTypes);
            if (kotlin.jvm.internal.i.b(signature, K10)) {
                kotlin.jvm.internal.i.d(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactoryKt.findMatchingConstructor>");
                return constructor;
            }
            if (signature.size() == K10.size() && K10.containsAll(signature)) {
                throw new UnsupportedOperationException("Class " + modelClass.getSimpleName() + " must have parameters in the proper order: " + signature);
            }
        }
        return null;
    }

    public static final <T extends I> T d(Class<T> modelClass, Constructor<T> constructor, Object... params) {
        kotlin.jvm.internal.i.f(modelClass, "modelClass");
        kotlin.jvm.internal.i.f(constructor, "constructor");
        kotlin.jvm.internal.i.f(params, "params");
        try {
            return constructor.newInstance(Arrays.copyOf(params, params.length));
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Failed to access " + modelClass, e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException("A " + modelClass + " cannot be instantiated.", e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException("An exception happened in constructor of " + modelClass, e12.getCause());
        }
    }
}
