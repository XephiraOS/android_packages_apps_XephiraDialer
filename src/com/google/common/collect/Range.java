package com.google.common.collect;

import java.io.Serializable;
import java.lang.Comparable;

/* loaded from: classes3.dex */
public final class Range<C extends Comparable> extends RangeGwtSerializationDependencies implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final Range<Comparable> f24529a = new Range<>(Cut.c(), Cut.a());
    private static final long serialVersionUID = 0;
    final Cut<C> lowerBound;
    final Cut<C> upperBound;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24530a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f24530a = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24530a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public Range(Cut<C> cut, Cut<C> cut2) {
        this.lowerBound = (Cut) com.google.common.base.k.o(cut);
        this.upperBound = (Cut) com.google.common.base.k.o(cut2);
        if (cut.compareTo(cut2) <= 0 && cut != Cut.a() && cut2 != Cut.c()) {
            return;
        }
        throw new IllegalArgumentException("Invalid range: " + p(cut, cut2));
    }

    public static <C extends Comparable<?>> Range<C> a() {
        return (Range<C>) f24529a;
    }

    public static <C extends Comparable<?>> Range<C> b(C c10) {
        return f(Cut.d(c10), Cut.a());
    }

    public static <C extends Comparable<?>> Range<C> c(C c10) {
        return f(Cut.c(), Cut.b(c10));
    }

    public static int d(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public static <C extends Comparable<?>> Range<C> f(Cut<C> cut, Cut<C> cut2) {
        return new Range<>(cut, cut2);
    }

    public static <C extends Comparable<?>> Range<C> g(C c10, BoundType boundType) {
        int i10 = a.f24530a[boundType.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                return b(c10);
            }
            throw new AssertionError();
        }
        return h(c10);
    }

    public static <C extends Comparable<?>> Range<C> h(C c10) {
        return f(Cut.b(c10), Cut.a());
    }

    public static <C extends Comparable<?>> Range<C> m(C c10) {
        return f(Cut.c(), Cut.d(c10));
    }

    public static <C extends Comparable<?>> Range<C> o(C c10, BoundType boundType, C c11, BoundType boundType2) {
        Cut d10;
        Cut b10;
        com.google.common.base.k.o(boundType);
        com.google.common.base.k.o(boundType2);
        BoundType boundType3 = BoundType.OPEN;
        if (boundType == boundType3) {
            d10 = Cut.b(c10);
        } else {
            d10 = Cut.d(c10);
        }
        if (boundType2 == boundType3) {
            b10 = Cut.d(c11);
        } else {
            b10 = Cut.b(c11);
        }
        return f(d10, b10);
    }

    public static String p(Cut<?> cut, Cut<?> cut2) {
        StringBuilder sb = new StringBuilder(16);
        cut.f(sb);
        sb.append("..");
        cut2.g(sb);
        return sb.toString();
    }

    public static <C extends Comparable<?>> Range<C> q(C c10, BoundType boundType) {
        int i10 = a.f24530a[boundType.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                return c(c10);
            }
            throw new AssertionError();
        }
        return m(c10);
    }

    public boolean e(C c10) {
        com.google.common.base.k.o(c10);
        if (this.lowerBound.i(c10) && !this.upperBound.i(c10)) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        if (!this.lowerBound.equals(range.lowerBound) || !this.upperBound.equals(range.upperBound)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.lowerBound.hashCode() * 31) + this.upperBound.hashCode();
    }

    public boolean i() {
        if (this.lowerBound != Cut.c()) {
            return true;
        }
        return false;
    }

    public boolean j() {
        if (this.upperBound != Cut.a()) {
            return true;
        }
        return false;
    }

    public Range<C> k(Range<C> range) {
        Cut<C> cut;
        Cut<C> cut2;
        boolean z10;
        int compareTo = this.lowerBound.compareTo(range.lowerBound);
        int compareTo2 = this.upperBound.compareTo(range.upperBound);
        if (compareTo >= 0 && compareTo2 <= 0) {
            return this;
        }
        if (compareTo <= 0 && compareTo2 >= 0) {
            return range;
        }
        if (compareTo >= 0) {
            cut = this.lowerBound;
        } else {
            cut = range.lowerBound;
        }
        if (compareTo2 <= 0) {
            cut2 = this.upperBound;
        } else {
            cut2 = range.upperBound;
        }
        if (cut.compareTo(cut2) <= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.l(z10, "intersection is undefined for disconnected ranges %s and %s", this, range);
        return f(cut, cut2);
    }

    public boolean l(Range<C> range) {
        if (this.lowerBound.compareTo(range.upperBound) <= 0 && range.lowerBound.compareTo(this.upperBound) <= 0) {
            return true;
        }
        return false;
    }

    public C n() {
        return this.lowerBound.h();
    }

    public C r() {
        return this.upperBound.h();
    }

    public Object readResolve() {
        if (equals(f24529a)) {
            return a();
        }
        return this;
    }

    public String toString() {
        return p(this.lowerBound, this.upperBound);
    }
}
