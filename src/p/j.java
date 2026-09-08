package p;

import java.util.Arrays;
import kotlin.collections.C1228i;
import q.C1474a;

/* compiled from: SparseArrayCompat.jvm.kt */
/* loaded from: classes.dex */
public class j<E> implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ boolean f35963a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ int[] f35964b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object[] f35965c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ int f35966d;

    public j() {
        this(0, 1, null);
    }

    public void a(int i10, E e10) {
        int i11 = this.f35966d;
        if (i11 != 0 && i10 <= this.f35964b[i11 - 1]) {
            g(i10, e10);
            return;
        }
        if (this.f35963a && i11 >= this.f35964b.length) {
            k.e(this);
        }
        int i12 = this.f35966d;
        if (i12 >= this.f35964b.length) {
            int e11 = C1474a.e(i12 + 1);
            int[] copyOf = Arrays.copyOf(this.f35964b, e11);
            kotlin.jvm.internal.i.e(copyOf, "copyOf(this, newSize)");
            this.f35964b = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f35965c, e11);
            kotlin.jvm.internal.i.e(copyOf2, "copyOf(this, newSize)");
            this.f35965c = copyOf2;
        }
        this.f35964b[i12] = i10;
        this.f35965c[i12] = e10;
        this.f35966d = i12 + 1;
    }

    public void b() {
        int i10 = this.f35966d;
        Object[] objArr = this.f35965c;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        this.f35966d = 0;
        this.f35963a = false;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public j<E> clone() {
        Object clone = super.clone();
        kotlin.jvm.internal.i.d(clone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        j<E> jVar = (j) clone;
        jVar.f35964b = (int[]) this.f35964b.clone();
        jVar.f35965c = (Object[]) this.f35965c.clone();
        return jVar;
    }

    public E d(int i10) {
        return (E) k.c(this, i10);
    }

    public int e(E e10) {
        if (this.f35963a) {
            k.e(this);
        }
        int i10 = this.f35966d;
        for (int i11 = 0; i11 < i10; i11++) {
            if (this.f35965c[i11] == e10) {
                return i11;
            }
        }
        return -1;
    }

    public int f(int i10) {
        if (this.f35963a) {
            k.e(this);
        }
        return this.f35964b[i10];
    }

    public void g(int i10, E e10) {
        Object obj;
        int a10 = C1474a.a(this.f35964b, this.f35966d, i10);
        if (a10 >= 0) {
            this.f35965c[a10] = e10;
            return;
        }
        int i11 = ~a10;
        if (i11 < this.f35966d) {
            Object obj2 = this.f35965c[i11];
            obj = k.f35967a;
            if (obj2 == obj) {
                this.f35964b[i11] = i10;
                this.f35965c[i11] = e10;
                return;
            }
        }
        if (this.f35963a && this.f35966d >= this.f35964b.length) {
            k.e(this);
            i11 = ~C1474a.a(this.f35964b, this.f35966d, i10);
        }
        int i12 = this.f35966d;
        if (i12 >= this.f35964b.length) {
            int e11 = C1474a.e(i12 + 1);
            int[] copyOf = Arrays.copyOf(this.f35964b, e11);
            kotlin.jvm.internal.i.e(copyOf, "copyOf(this, newSize)");
            this.f35964b = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f35965c, e11);
            kotlin.jvm.internal.i.e(copyOf2, "copyOf(this, newSize)");
            this.f35965c = copyOf2;
        }
        int i13 = this.f35966d;
        if (i13 - i11 != 0) {
            int[] iArr = this.f35964b;
            int i14 = i11 + 1;
            C1228i.h(iArr, iArr, i14, i11, i13);
            Object[] objArr = this.f35965c;
            C1228i.j(objArr, objArr, i14, i11, this.f35966d);
        }
        this.f35964b[i11] = i10;
        this.f35965c[i11] = e10;
        this.f35966d++;
    }

    public void h(int i10) {
        k.d(this, i10);
    }

    public int i() {
        if (this.f35963a) {
            k.e(this);
        }
        return this.f35966d;
    }

    public E j(int i10) {
        if (this.f35963a) {
            k.e(this);
        }
        return (E) this.f35965c[i10];
    }

    public String toString() {
        if (i() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f35966d * 28);
        sb.append('{');
        int i10 = this.f35966d;
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 > 0) {
                sb.append(", ");
            }
            sb.append(f(i11));
            sb.append('=');
            E j10 = j(i11);
            if (j10 != this) {
                sb.append(j10);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        kotlin.jvm.internal.i.e(sb2, "buffer.toString()");
        return sb2;
    }

    public j(int i10) {
        if (i10 == 0) {
            this.f35964b = C1474a.f36116a;
            this.f35965c = C1474a.f36118c;
        } else {
            int e10 = C1474a.e(i10);
            this.f35964b = new int[e10];
            this.f35965c = new Object[e10];
        }
    }

    public /* synthetic */ j(int i10, int i11, kotlin.jvm.internal.f fVar) {
        this((i11 & 1) != 0 ? 10 : i10);
    }
}
