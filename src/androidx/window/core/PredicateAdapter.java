package androidx.window.core;

import C9.c;
import C9.d;
import android.util.Pair;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import kotlin.jvm.internal.i;
import v9.l;
import v9.p;

/* compiled from: PredicateAdapter.kt */
/* loaded from: classes.dex */
public final class PredicateAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final ClassLoader f11909a;

    /* compiled from: PredicateAdapter.kt */
    /* loaded from: classes.dex */
    public static abstract class BaseHandler<T> implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        public final c<T> f11910a;

        public abstract boolean a(Object obj, T t10);

        public final boolean b(Method method, Object[] objArr) {
            i.f(method, "<this>");
            if (i.b(method.getName(), "equals") && method.getReturnType().equals(Boolean.TYPE) && objArr != null && objArr.length == 1) {
                return true;
            }
            return false;
        }

        public final boolean c(Method method, Object[] objArr) {
            i.f(method, "<this>");
            if (i.b(method.getName(), "hashCode") && method.getReturnType().equals(Integer.TYPE) && objArr == null) {
                return true;
            }
            return false;
        }

        public final boolean d(Method method, Object[] objArr) {
            i.f(method, "<this>");
            if (i.b(method.getName(), "test") && method.getReturnType().equals(Boolean.TYPE) && objArr != null && objArr.length == 1) {
                return true;
            }
            return false;
        }

        public final boolean e(Method method, Object[] objArr) {
            i.f(method, "<this>");
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
            if (d(method, objArr)) {
                c<T> cVar = this.f11910a;
                if (objArr != null) {
                    obj2 = objArr[0];
                }
                return Boolean.valueOf(a(obj, d.a(cVar, obj2)));
            }
            if (b(method, objArr)) {
                if (objArr != null) {
                    obj2 = objArr[0];
                }
                i.c(obj2);
                if (obj == obj2) {
                    z10 = true;
                }
                return Boolean.valueOf(z10);
            }
            if (c(method, objArr)) {
                return Integer.valueOf(hashCode());
            }
            if (e(method, objArr)) {
                return toString();
            }
            throw new UnsupportedOperationException("Unexpected method call object:" + obj + ", method: " + method + ", args: " + objArr);
        }
    }

    /* compiled from: PredicateAdapter.kt */
    /* loaded from: classes.dex */
    public static final class PairPredicateStubHandler<T, U> extends BaseHandler<Pair<?, ?>> {

        /* renamed from: b, reason: collision with root package name */
        public final c<T> f11911b;

        /* renamed from: c, reason: collision with root package name */
        public final c<U> f11912c;

        /* renamed from: d, reason: collision with root package name */
        public final p<T, U, Boolean> f11913d;

        @Override // androidx.window.core.PredicateAdapter.BaseHandler
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public boolean a(Object obj, Pair<?, ?> parameter) {
            i.f(obj, "obj");
            i.f(parameter, "parameter");
            return ((Boolean) this.f11913d.invoke(d.a(this.f11911b, parameter.first), d.a(this.f11912c, parameter.second))).booleanValue();
        }

        public int hashCode() {
            return this.f11913d.hashCode();
        }

        public String toString() {
            return this.f11913d.toString();
        }
    }

    /* compiled from: PredicateAdapter.kt */
    /* loaded from: classes.dex */
    public static final class PredicateStubHandler<T> extends BaseHandler<T> {

        /* renamed from: b, reason: collision with root package name */
        public final l<T, Boolean> f11914b;

        @Override // androidx.window.core.PredicateAdapter.BaseHandler
        public boolean a(Object obj, T parameter) {
            i.f(obj, "obj");
            i.f(parameter, "parameter");
            return this.f11914b.invoke(parameter).booleanValue();
        }

        public int hashCode() {
            return this.f11914b.hashCode();
        }

        public String toString() {
            return this.f11914b.toString();
        }
    }

    public PredicateAdapter(ClassLoader loader) {
        i.f(loader, "loader");
        this.f11909a = loader;
    }
}
