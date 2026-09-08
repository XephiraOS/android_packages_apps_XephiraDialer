package B9;

import kotlin.collections.A;
import w9.InterfaceC1658a;

/* compiled from: Progressions.kt */
/* loaded from: classes4.dex */
public class d implements Iterable<Integer>, InterfaceC1658a {

    /* renamed from: d, reason: collision with root package name */
    public static final a f296d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final int f297a;

    /* renamed from: b, reason: collision with root package name */
    public final int f298b;

    /* renamed from: c, reason: collision with root package name */
    public final int f299c;

    /* compiled from: Progressions.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public a() {
        }

        public final d a(int i10, int i11, int i12) {
            return new d(i10, i11, i12);
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public d(int i10, int i11, int i12) {
        if (i12 != 0) {
            if (i12 != Integer.MIN_VALUE) {
                this.f297a = i10;
                this.f298b = r9.c.b(i10, i11, i12);
                this.f299c = i12;
                return;
            }
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public final int a() {
        return this.f297a;
    }

    public final int c() {
        return this.f298b;
    }

    public final int e() {
        return this.f299c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            if (!isEmpty() || !((d) obj).isEmpty()) {
                d dVar = (d) obj;
                if (this.f297a != dVar.f297a || this.f298b != dVar.f298b || this.f299c != dVar.f299c) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public A iterator() {
        return new e(this.f297a, this.f298b, this.f299c);
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return this.f299c + (((this.f297a * 31) + this.f298b) * 31);
    }

    public boolean isEmpty() {
        if (this.f299c > 0) {
            if (this.f297a <= this.f298b) {
                return false;
            }
        } else if (this.f297a >= this.f298b) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb;
        int i10;
        if (this.f299c > 0) {
            sb = new StringBuilder();
            sb.append(this.f297a);
            sb.append("..");
            sb.append(this.f298b);
            sb.append(" step ");
            i10 = this.f299c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f297a);
            sb.append(" downTo ");
            sb.append(this.f298b);
            sb.append(" step ");
            i10 = -this.f299c;
        }
        sb.append(i10);
        return sb.toString();
    }
}
