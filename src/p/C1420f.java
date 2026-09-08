package p;

import java.util.Arrays;
import kotlin.collections.C1228i;
import q.C1474a;

/* compiled from: LongSparseArray.jvm.kt */
/* renamed from: p.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1420f<E> implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ boolean f35955a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ long[] f35956b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object[] f35957c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ int f35958d;

    public C1420f() {
        this(0, 1, null);
    }

    public void a() {
        int i10 = this.f35958d;
        Object[] objArr = this.f35957c;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        this.f35958d = 0;
        this.f35955a = false;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C1420f<E> clone() {
        Object clone = super.clone();
        kotlin.jvm.internal.i.d(clone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        C1420f<E> c1420f = (C1420f) clone;
        c1420f.f35956b = (long[]) this.f35956b.clone();
        c1420f.f35957c = (Object[]) this.f35957c.clone();
        return c1420f;
    }

    public boolean c(long j10) {
        if (e(j10) >= 0) {
            return true;
        }
        return false;
    }

    public E d(long j10) {
        Object obj;
        int b10 = C1474a.b(this.f35956b, this.f35958d, j10);
        if (b10 >= 0) {
            Object obj2 = this.f35957c[b10];
            obj = C1421g.f35959a;
            if (obj2 != obj) {
                return (E) this.f35957c[b10];
            }
        }
        return null;
    }

    public int e(long j10) {
        Object obj;
        if (this.f35955a) {
            int i10 = this.f35958d;
            long[] jArr = this.f35956b;
            Object[] objArr = this.f35957c;
            int i11 = 0;
            for (int i12 = 0; i12 < i10; i12++) {
                Object obj2 = objArr[i12];
                obj = C1421g.f35959a;
                if (obj2 != obj) {
                    if (i12 != i11) {
                        jArr[i11] = jArr[i12];
                        objArr[i11] = obj2;
                        objArr[i12] = null;
                    }
                    i11++;
                }
            }
            this.f35955a = false;
            this.f35958d = i11;
        }
        return C1474a.b(this.f35956b, this.f35958d, j10);
    }

    public boolean f() {
        if (k() == 0) {
            return true;
        }
        return false;
    }

    public long g(int i10) {
        int i11;
        Object obj;
        if (i10 >= 0 && i10 < (i11 = this.f35958d)) {
            if (this.f35955a) {
                long[] jArr = this.f35956b;
                Object[] objArr = this.f35957c;
                int i12 = 0;
                for (int i13 = 0; i13 < i11; i13++) {
                    Object obj2 = objArr[i13];
                    obj = C1421g.f35959a;
                    if (obj2 != obj) {
                        if (i13 != i12) {
                            jArr[i12] = jArr[i13];
                            objArr[i12] = obj2;
                            objArr[i13] = null;
                        }
                        i12++;
                    }
                }
                this.f35955a = false;
                this.f35958d = i12;
            }
            return this.f35956b[i10];
        }
        throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i10).toString());
    }

    public void h(long j10, E e10) {
        Object obj;
        Object obj2;
        int b10 = C1474a.b(this.f35956b, this.f35958d, j10);
        if (b10 >= 0) {
            this.f35957c[b10] = e10;
            return;
        }
        int i10 = ~b10;
        if (i10 < this.f35958d) {
            Object obj3 = this.f35957c[i10];
            obj2 = C1421g.f35959a;
            if (obj3 == obj2) {
                this.f35956b[i10] = j10;
                this.f35957c[i10] = e10;
                return;
            }
        }
        if (this.f35955a) {
            int i11 = this.f35958d;
            long[] jArr = this.f35956b;
            if (i11 >= jArr.length) {
                Object[] objArr = this.f35957c;
                int i12 = 0;
                for (int i13 = 0; i13 < i11; i13++) {
                    Object obj4 = objArr[i13];
                    obj = C1421g.f35959a;
                    if (obj4 != obj) {
                        if (i13 != i12) {
                            jArr[i12] = jArr[i13];
                            objArr[i12] = obj4;
                            objArr[i13] = null;
                        }
                        i12++;
                    }
                }
                this.f35955a = false;
                this.f35958d = i12;
                i10 = ~C1474a.b(this.f35956b, i12, j10);
            }
        }
        int i14 = this.f35958d;
        if (i14 >= this.f35956b.length) {
            int f10 = C1474a.f(i14 + 1);
            long[] copyOf = Arrays.copyOf(this.f35956b, f10);
            kotlin.jvm.internal.i.e(copyOf, "copyOf(this, newSize)");
            this.f35956b = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f35957c, f10);
            kotlin.jvm.internal.i.e(copyOf2, "copyOf(this, newSize)");
            this.f35957c = copyOf2;
        }
        int i15 = this.f35958d;
        if (i15 - i10 != 0) {
            long[] jArr2 = this.f35956b;
            int i16 = i10 + 1;
            C1228i.i(jArr2, jArr2, i16, i10, i15);
            Object[] objArr2 = this.f35957c;
            C1228i.j(objArr2, objArr2, i16, i10, this.f35958d);
        }
        this.f35956b[i10] = j10;
        this.f35957c[i10] = e10;
        this.f35958d++;
    }

    public void i(long j10) {
        Object obj;
        Object obj2;
        int b10 = C1474a.b(this.f35956b, this.f35958d, j10);
        if (b10 >= 0) {
            Object obj3 = this.f35957c[b10];
            obj = C1421g.f35959a;
            if (obj3 != obj) {
                Object[] objArr = this.f35957c;
                obj2 = C1421g.f35959a;
                objArr[b10] = obj2;
                this.f35955a = true;
            }
        }
    }

    public void j(int i10) {
        Object obj;
        Object obj2;
        Object obj3 = this.f35957c[i10];
        obj = C1421g.f35959a;
        if (obj3 != obj) {
            Object[] objArr = this.f35957c;
            obj2 = C1421g.f35959a;
            objArr[i10] = obj2;
            this.f35955a = true;
        }
    }

    public int k() {
        Object obj;
        if (this.f35955a) {
            int i10 = this.f35958d;
            long[] jArr = this.f35956b;
            Object[] objArr = this.f35957c;
            int i11 = 0;
            for (int i12 = 0; i12 < i10; i12++) {
                Object obj2 = objArr[i12];
                obj = C1421g.f35959a;
                if (obj2 != obj) {
                    if (i12 != i11) {
                        jArr[i11] = jArr[i12];
                        objArr[i11] = obj2;
                        objArr[i12] = null;
                    }
                    i11++;
                }
            }
            this.f35955a = false;
            this.f35958d = i11;
        }
        return this.f35958d;
    }

    public E l(int i10) {
        int i11;
        Object obj;
        if (i10 >= 0 && i10 < (i11 = this.f35958d)) {
            if (this.f35955a) {
                long[] jArr = this.f35956b;
                Object[] objArr = this.f35957c;
                int i12 = 0;
                for (int i13 = 0; i13 < i11; i13++) {
                    Object obj2 = objArr[i13];
                    obj = C1421g.f35959a;
                    if (obj2 != obj) {
                        if (i13 != i12) {
                            jArr[i12] = jArr[i13];
                            objArr[i12] = obj2;
                            objArr[i13] = null;
                        }
                        i12++;
                    }
                }
                this.f35955a = false;
                this.f35958d = i12;
            }
            return (E) this.f35957c[i10];
        }
        throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i10).toString());
    }

    public String toString() {
        if (k() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f35958d * 28);
        sb.append('{');
        int i10 = this.f35958d;
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 > 0) {
                sb.append(", ");
            }
            sb.append(g(i11));
            sb.append('=');
            E l10 = l(i11);
            if (l10 != sb) {
                sb.append(l10);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        kotlin.jvm.internal.i.e(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public C1420f(int i10) {
        if (i10 == 0) {
            this.f35956b = C1474a.f36117b;
            this.f35957c = C1474a.f36118c;
        } else {
            int f10 = C1474a.f(i10);
            this.f35956b = new long[f10];
            this.f35957c = new Object[f10];
        }
    }

    public /* synthetic */ C1420f(int i10, int i11, kotlin.jvm.internal.f fVar) {
        this((i11 & 1) != 0 ? 10 : i10);
    }
}
