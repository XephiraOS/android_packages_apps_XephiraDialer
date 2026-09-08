package com.google.common.collect;

import java.io.Serializable;
import java.lang.Comparable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class Cut<C extends Comparable> implements Comparable<Cut<C>>, Serializable {
    private static final long serialVersionUID = 0;
    final C endpoint;

    /* loaded from: classes3.dex */
    public static final class AboveAll extends Cut<Comparable<?>> {

        /* renamed from: a, reason: collision with root package name */
        public static final AboveAll f24415a = new AboveAll();
        private static final long serialVersionUID = 0;

        private AboveAll() {
            super("");
        }

        private Object readResolve() {
            return f24415a;
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public int compareTo(Cut<Comparable<?>> cut) {
            if (cut == this) {
                return 0;
            }
            return 1;
        }

        @Override // com.google.common.collect.Cut
        public void f(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        public void g(StringBuilder sb) {
            sb.append("+∞)");
        }

        @Override // com.google.common.collect.Cut
        public Comparable<?> h() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // com.google.common.collect.Cut
        public boolean i(Comparable<?> comparable) {
            return false;
        }

        public String toString() {
            return "+∞";
        }
    }

    /* loaded from: classes3.dex */
    public static final class AboveValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        public AboveValue(C c10) {
            super((Comparable) com.google.common.base.k.o(c10));
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((Cut) obj);
        }

        @Override // com.google.common.collect.Cut
        public void f(StringBuilder sb) {
            sb.append('(');
            sb.append(this.endpoint);
        }

        @Override // com.google.common.collect.Cut
        public void g(StringBuilder sb) {
            sb.append(this.endpoint);
            sb.append(']');
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return ~this.endpoint.hashCode();
        }

        @Override // com.google.common.collect.Cut
        public boolean i(C c10) {
            if (Range.d(this.endpoint, c10) < 0) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "/" + this.endpoint + "\\";
        }
    }

    /* loaded from: classes3.dex */
    public static final class BelowAll extends Cut<Comparable<?>> {

        /* renamed from: a, reason: collision with root package name */
        public static final BelowAll f24416a = new BelowAll();
        private static final long serialVersionUID = 0;

        private BelowAll() {
            super("");
        }

        private Object readResolve() {
            return f24416a;
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        /* renamed from: e */
        public int compareTo(Cut<Comparable<?>> cut) {
            if (cut == this) {
                return 0;
            }
            return -1;
        }

        @Override // com.google.common.collect.Cut
        public void f(StringBuilder sb) {
            sb.append("(-∞");
        }

        @Override // com.google.common.collect.Cut
        public void g(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        public Comparable<?> h() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // com.google.common.collect.Cut
        public boolean i(Comparable<?> comparable) {
            return true;
        }

        public String toString() {
            return "-∞";
        }
    }

    /* loaded from: classes3.dex */
    public static final class BelowValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        public BelowValue(C c10) {
            super((Comparable) com.google.common.base.k.o(c10));
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((Cut) obj);
        }

        @Override // com.google.common.collect.Cut
        public void f(StringBuilder sb) {
            sb.append('[');
            sb.append(this.endpoint);
        }

        @Override // com.google.common.collect.Cut
        public void g(StringBuilder sb) {
            sb.append(this.endpoint);
            sb.append(')');
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return this.endpoint.hashCode();
        }

        @Override // com.google.common.collect.Cut
        public boolean i(C c10) {
            if (Range.d(this.endpoint, c10) <= 0) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "\\" + this.endpoint + "/";
        }
    }

    public Cut(C c10) {
        this.endpoint = c10;
    }

    public static <C extends Comparable> Cut<C> a() {
        return AboveAll.f24415a;
    }

    public static <C extends Comparable> Cut<C> b(C c10) {
        return new AboveValue(c10);
    }

    public static <C extends Comparable> Cut<C> c() {
        return BelowAll.f24416a;
    }

    public static <C extends Comparable> Cut<C> d(C c10) {
        return new BelowValue(c10);
    }

    @Override // java.lang.Comparable
    /* renamed from: e */
    public int compareTo(Cut<C> cut) {
        if (cut == c()) {
            return 1;
        }
        if (cut == a()) {
            return -1;
        }
        int d10 = Range.d(this.endpoint, cut.endpoint);
        if (d10 != 0) {
            return d10;
        }
        return com.google.common.primitives.a.a(this instanceof AboveValue, cut instanceof AboveValue);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Cut)) {
            return false;
        }
        try {
            if (compareTo((Cut) obj) != 0) {
                return false;
            }
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public abstract void f(StringBuilder sb);

    public abstract void g(StringBuilder sb);

    public C h() {
        return this.endpoint;
    }

    public abstract int hashCode();

    public abstract boolean i(C c10);
}
