package com.google.common.base;

import java.io.Serializable;

/* loaded from: classes3.dex */
public abstract class Equivalence<T> {

    /* loaded from: classes3.dex */
    public static final class Equals extends Equivalence<Object> implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public static final Equals f24295a = new Equals();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return f24295a;
        }

        @Override // com.google.common.base.Equivalence
        public boolean a(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        @Override // com.google.common.base.Equivalence
        public int b(Object obj) {
            return obj.hashCode();
        }
    }

    /* loaded from: classes3.dex */
    public static final class Identity extends Equivalence<Object> implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public static final Identity f24296a = new Identity();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return f24296a;
        }

        @Override // com.google.common.base.Equivalence
        public boolean a(Object obj, Object obj2) {
            return false;
        }

        @Override // com.google.common.base.Equivalence
        public int b(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    public static Equivalence<Object> c() {
        return Equals.f24295a;
    }

    public static Equivalence<Object> f() {
        return Identity.f24296a;
    }

    public abstract boolean a(T t10, T t11);

    public abstract int b(T t10);

    public final boolean d(T t10, T t11) {
        if (t10 == t11) {
            return true;
        }
        if (t10 != null && t11 != null) {
            return a(t10, t11);
        }
        return false;
    }

    public final int e(T t10) {
        if (t10 == null) {
            return 0;
        }
        return b(t10);
    }
}
