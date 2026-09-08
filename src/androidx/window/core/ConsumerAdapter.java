package androidx.window.core;

import C9.c;
import C9.d;
import android.app.Activity;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.jvm.internal.i;
import m9.q;
import v9.l;

/* compiled from: ConsumerAdapter.kt */
/* loaded from: classes.dex */
public final class ConsumerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final ClassLoader f11896a;

    /* compiled from: ConsumerAdapter.kt */
    /* loaded from: classes.dex */
    public static final class ConsumerHandler<T> implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        public final c<T> f11897a;

        /* renamed from: b, reason: collision with root package name */
        public final l<T, q> f11898b;

        /* JADX WARN: Multi-variable type inference failed */
        public ConsumerHandler(c<T> clazz, l<? super T, q> consumer) {
            i.f(clazz, "clazz");
            i.f(consumer, "consumer");
            this.f11897a = clazz;
            this.f11898b = consumer;
        }

        public final void a(T parameter) {
            i.f(parameter, "parameter");
            this.f11898b.invoke(parameter);
        }

        public final boolean b(Method method, Object[] objArr) {
            if (i.b(method.getName(), "accept") && objArr != null && objArr.length == 1) {
                return true;
            }
            return false;
        }

        public final boolean c(Method method, Object[] objArr) {
            if (i.b(method.getName(), "equals") && method.getReturnType().equals(Boolean.TYPE) && objArr != null && objArr.length == 1) {
                return true;
            }
            return false;
        }

        public final boolean d(Method method, Object[] objArr) {
            if (i.b(method.getName(), "hashCode") && method.getReturnType().equals(Integer.TYPE) && objArr == null) {
                return true;
            }
            return false;
        }

        public final boolean e(Method method, Object[] objArr) {
            if (i.b(method.getName(), "toString") && method.getReturnType().equals(String.class) && objArr == null) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            i.f(obj, "obj");
            i.f(method, "method");
            Object obj2 = null;
            boolean z10 = false;
            if (b(method, objArr)) {
                c<T> cVar = this.f11897a;
                if (objArr != null) {
                    obj2 = objArr[0];
                }
                a(d.a(cVar, obj2));
                return q.f35511a;
            }
            if (c(method, objArr)) {
                if (objArr != null) {
                    obj2 = objArr[0];
                }
                if (obj == obj2) {
                    z10 = true;
                }
                return Boolean.valueOf(z10);
            }
            if (d(method, objArr)) {
                return Integer.valueOf(this.f11898b.hashCode());
            }
            if (e(method, objArr)) {
                return this.f11898b.toString();
            }
            throw new UnsupportedOperationException("Unexpected method call object:" + obj + ", method: " + method + ", args: " + objArr);
        }
    }

    /* compiled from: ConsumerAdapter.kt */
    /* loaded from: classes.dex */
    public interface Subscription {
        void b();
    }

    public ConsumerAdapter(ClassLoader loader) {
        i.f(loader, "loader");
        this.f11896a = loader;
    }

    public final <T> void a(Object obj, c<T> clazz, String methodName, l<? super T, q> consumer) {
        i.f(obj, "obj");
        i.f(clazz, "clazz");
        i.f(methodName, "methodName");
        i.f(consumer, "consumer");
        obj.getClass().getMethod(methodName, e()).invoke(obj, b(clazz, consumer));
    }

    public final <T> Object b(c<T> cVar, l<? super T, q> lVar) {
        Object newProxyInstance = Proxy.newProxyInstance(this.f11896a, new Class[]{e()}, new ConsumerHandler(cVar, lVar));
        i.e(newProxyInstance, "newProxyInstance(loader,…onsumerClass()), handler)");
        return newProxyInstance;
    }

    public final Class<?> c() {
        try {
            return e();
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public final <T> Subscription d(final Object obj, c<T> clazz, String addMethodName, String removeMethodName, Activity activity, l<? super T, q> consumer) {
        i.f(obj, "obj");
        i.f(clazz, "clazz");
        i.f(addMethodName, "addMethodName");
        i.f(removeMethodName, "removeMethodName");
        i.f(activity, "activity");
        i.f(consumer, "consumer");
        final Object b10 = b(clazz, consumer);
        obj.getClass().getMethod(addMethodName, Activity.class, e()).invoke(obj, activity, b10);
        final Method method = obj.getClass().getMethod(removeMethodName, e());
        return new Subscription() { // from class: androidx.window.core.ConsumerAdapter$createSubscription$1
            @Override // androidx.window.core.ConsumerAdapter.Subscription
            public void b() {
                method.invoke(obj, b10);
            }
        };
    }

    public final Class<?> e() {
        Class<?> loadClass = this.f11896a.loadClass("java.util.function.Consumer");
        i.e(loadClass, "loader.loadClass(\"java.util.function.Consumer\")");
        return loadClass;
    }
}
