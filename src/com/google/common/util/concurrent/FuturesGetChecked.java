package com.google.common.util.concurrent;

import com.google.common.collect.Ordering;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes3.dex */
public final class FuturesGetChecked {

    /* renamed from: a, reason: collision with root package name */
    public static final Ordering<List<Class<?>>> f24651a;

    /* renamed from: b, reason: collision with root package name */
    public static final Ordering<Constructor<?>> f24652b;

    /* loaded from: classes3.dex */
    public interface GetCheckedTypeValidator {
        void a(Class<? extends Exception> cls);
    }

    /* loaded from: classes3.dex */
    public static class GetCheckedTypeValidatorHolder {

        /* renamed from: a, reason: collision with root package name */
        public static final GetCheckedTypeValidator f24653a = a();

        /* loaded from: classes3.dex */
        public enum WeakSetValidator implements GetCheckedTypeValidator {
            INSTANCE;


            /* renamed from: b, reason: collision with root package name */
            public static final Set<WeakReference<Class<? extends Exception>>> f24655b = new CopyOnWriteArraySet();

            @Override // com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidator
            public void a(Class<? extends Exception> cls) {
                Iterator<WeakReference<Class<? extends Exception>>> it = f24655b.iterator();
                while (it.hasNext()) {
                    if (cls.equals(it.next().get())) {
                        return;
                    }
                }
                FuturesGetChecked.checkExceptionClassValidity(cls);
                Set<WeakReference<Class<? extends Exception>>> set = f24655b;
                if (set.size() > 1000) {
                    set.clear();
                }
                set.add(new WeakReference<>(cls));
            }
        }

        public static GetCheckedTypeValidator a() {
            return FuturesGetChecked.weakSetValidator();
        }
    }

    static {
        Ordering<List<Class<?>>> e10 = Ordering.c().d(new com.google.common.base.d() { // from class: com.google.common.util.concurrent.b
            @Override // com.google.common.base.d
            public final Object apply(Object obj) {
                Comparable e11;
                e11 = FuturesGetChecked.e((List) obj);
                return e11;
            }
        }).a(Ordering.c().d(new com.google.common.base.d() { // from class: com.google.common.util.concurrent.c
            @Override // com.google.common.base.d
            public final Object apply(Object obj) {
                Comparable f10;
                f10 = FuturesGetChecked.f((List) obj);
                return f10;
            }
        })).e();
        f24651a = e10;
        f24652b = e10.d(new com.google.common.base.d() { // from class: com.google.common.util.concurrent.d
            @Override // com.google.common.base.d
            public final Object apply(Object obj) {
                List g10;
                g10 = FuturesGetChecked.g((Constructor) obj);
                return g10;
            }
        });
    }

    public static void checkExceptionClassValidity(Class<? extends Exception> cls) {
        com.google.common.base.k.k(isCheckedException(cls), "Futures.getChecked exception type (%s) must not be a RuntimeException", cls);
        com.google.common.base.k.k(d(cls), "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", cls);
    }

    public static boolean d(Class<? extends Exception> cls) {
        try {
            i(cls, new Exception());
            return true;
        } catch (Error | RuntimeException unused) {
            return false;
        }
    }

    public static /* synthetic */ Comparable e(List list) {
        return Boolean.valueOf(list.contains(String.class));
    }

    public static /* synthetic */ Comparable f(List list) {
        return Boolean.valueOf(list.contains(Throwable.class));
    }

    public static /* synthetic */ List g(Constructor constructor) {
        return Arrays.asList(constructor.getParameterTypes());
    }

    public static <V, X extends Exception> V getChecked(GetCheckedTypeValidator getCheckedTypeValidator, Future<V> future, Class<X> cls) {
        getCheckedTypeValidator.a(cls);
        try {
            return future.get();
        } catch (InterruptedException e10) {
            Thread.currentThread().interrupt();
            throw i(cls, e10);
        } catch (ExecutionException e11) {
            k(e11.getCause(), cls);
            throw new AssertionError();
        }
    }

    public static <X> X h(Constructor<X> constructor, Throwable th) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] objArr = new Object[parameterTypes.length];
        for (int i10 = 0; i10 < parameterTypes.length; i10++) {
            Class<?> cls = parameterTypes[i10];
            if (cls.equals(String.class)) {
                objArr[i10] = th.toString();
            } else {
                if (!cls.equals(Throwable.class)) {
                    return null;
                }
                objArr[i10] = th;
            }
        }
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public static <X extends Exception> X i(Class<X> cls, Throwable th) {
        Iterator it = j(Arrays.asList(cls.getConstructors())).iterator();
        while (it.hasNext()) {
            X x10 = (X) h((Constructor) it.next(), th);
            if (x10 != null) {
                if (x10.getCause() == null) {
                    x10.initCause(th);
                }
                return x10;
            }
        }
        throw new IllegalArgumentException("No appropriate constructor for exception of type " + cls + " in response to chained exception", th);
    }

    public static boolean isCheckedException(Class<? extends Exception> cls) {
        return !RuntimeException.class.isAssignableFrom(cls);
    }

    public static <X extends Exception> List<Constructor<X>> j(List<Constructor<X>> list) {
        return (List<Constructor<X>>) f24652b.f(list);
    }

    public static <X extends Exception> void k(Throwable th, Class<X> cls) {
        if (!(th instanceof Error)) {
            if (th instanceof RuntimeException) {
                throw new UncheckedExecutionException(th);
            }
            throw i(cls, th);
        }
        throw new ExecutionError((Error) th);
    }

    public static GetCheckedTypeValidator weakSetValidator() {
        return GetCheckedTypeValidatorHolder.WeakSetValidator.INSTANCE;
    }
}
