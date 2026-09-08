package p;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.collections.C1228i;
import q.C1474a;

/* compiled from: SimpleArrayMap.kt */
/* loaded from: classes.dex */
public class i<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public int[] f35960a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f35961b;

    /* renamed from: c, reason: collision with root package name */
    public int f35962c;

    public i() {
        this(0, 1, null);
    }

    public final int b(V v10) {
        int i10 = this.f35962c * 2;
        Object[] objArr = this.f35961b;
        if (v10 == null) {
            for (int i11 = 1; i11 < i10; i11 += 2) {
                if (objArr[i11] == null) {
                    return i11 >> 1;
                }
            }
            return -1;
        }
        for (int i12 = 1; i12 < i10; i12 += 2) {
            if (kotlin.jvm.internal.i.b(v10, objArr[i12])) {
                return i12 >> 1;
            }
        }
        return -1;
    }

    public void clear() {
        if (this.f35962c > 0) {
            this.f35960a = C1474a.f36116a;
            this.f35961b = C1474a.f36118c;
            this.f35962c = 0;
        }
        if (this.f35962c <= 0) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(K k10) {
        if (f(k10) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsValue(V v10) {
        if (b(v10) >= 0) {
            return true;
        }
        return false;
    }

    public void d(int i10) {
        int i11 = this.f35962c;
        int[] iArr = this.f35960a;
        if (iArr.length < i10) {
            int[] copyOf = Arrays.copyOf(iArr, i10);
            kotlin.jvm.internal.i.e(copyOf, "copyOf(this, newSize)");
            this.f35960a = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f35961b, i10 * 2);
            kotlin.jvm.internal.i.e(copyOf2, "copyOf(this, newSize)");
            this.f35961b = copyOf2;
        }
        if (this.f35962c == i11) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    public final int e(K k10, int i10) {
        int i11 = this.f35962c;
        if (i11 == 0) {
            return -1;
        }
        int a10 = C1474a.a(this.f35960a, i11, i10);
        if (a10 < 0) {
            return a10;
        }
        if (kotlin.jvm.internal.i.b(k10, this.f35961b[a10 << 1])) {
            return a10;
        }
        int i12 = a10 + 1;
        while (i12 < i11 && this.f35960a[i12] == i10) {
            if (kotlin.jvm.internal.i.b(k10, this.f35961b[i12 << 1])) {
                return i12;
            }
            i12++;
        }
        for (int i13 = a10 - 1; i13 >= 0 && this.f35960a[i13] == i10; i13--) {
            if (kotlin.jvm.internal.i.b(k10, this.f35961b[i13 << 1])) {
                return i13;
            }
        }
        return ~i12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof i) {
                if (size() != ((i) obj).size()) {
                    return false;
                }
                i iVar = (i) obj;
                int i10 = this.f35962c;
                for (int i11 = 0; i11 < i10; i11++) {
                    K h10 = h(i11);
                    V l10 = l(i11);
                    Object obj2 = iVar.get(h10);
                    if (l10 == null) {
                        if (obj2 != null || !iVar.containsKey(h10)) {
                            return false;
                        }
                    } else if (!kotlin.jvm.internal.i.b(l10, obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || size() != ((Map) obj).size()) {
                return false;
            }
            int i12 = this.f35962c;
            for (int i13 = 0; i13 < i12; i13++) {
                K h11 = h(i13);
                V l11 = l(i13);
                Object obj3 = ((Map) obj).get(h11);
                if (l11 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(h11)) {
                        return false;
                    }
                } else if (!kotlin.jvm.internal.i.b(l11, obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public int f(K k10) {
        if (k10 == null) {
            return g();
        }
        return e(k10, k10.hashCode());
    }

    public final int g() {
        int i10 = this.f35962c;
        if (i10 == 0) {
            return -1;
        }
        int a10 = C1474a.a(this.f35960a, i10, 0);
        if (a10 < 0) {
            return a10;
        }
        if (this.f35961b[a10 << 1] == null) {
            return a10;
        }
        int i11 = a10 + 1;
        while (i11 < i10 && this.f35960a[i11] == 0) {
            if (this.f35961b[i11 << 1] == null) {
                return i11;
            }
            i11++;
        }
        for (int i12 = a10 - 1; i12 >= 0 && this.f35960a[i12] == 0; i12--) {
            if (this.f35961b[i12 << 1] == null) {
                return i12;
            }
        }
        return ~i11;
    }

    public V get(K k10) {
        int f10 = f(k10);
        if (f10 >= 0) {
            return (V) this.f35961b[(f10 << 1) + 1];
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V getOrDefault(Object obj, V v10) {
        int f10 = f(obj);
        if (f10 >= 0) {
            return (V) this.f35961b[(f10 << 1) + 1];
        }
        return v10;
    }

    public K h(int i10) {
        if (i10 >= 0 && i10 < this.f35962c) {
            return (K) this.f35961b[i10 << 1];
        }
        throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i10).toString());
    }

    public int hashCode() {
        int i10;
        int[] iArr = this.f35960a;
        Object[] objArr = this.f35961b;
        int i11 = this.f35962c;
        int i12 = 1;
        int i13 = 0;
        int i14 = 0;
        while (i13 < i11) {
            Object obj = objArr[i12];
            int i15 = iArr[i13];
            if (obj != null) {
                i10 = obj.hashCode();
            } else {
                i10 = 0;
            }
            i14 += i10 ^ i15;
            i13++;
            i12 += 2;
        }
        return i14;
    }

    public void i(i<? extends K, ? extends V> map) {
        kotlin.jvm.internal.i.f(map, "map");
        int i10 = map.f35962c;
        d(this.f35962c + i10);
        if (this.f35962c == 0) {
            if (i10 > 0) {
                C1228i.h(map.f35960a, this.f35960a, 0, 0, i10);
                C1228i.j(map.f35961b, this.f35961b, 0, 0, i10 << 1);
                this.f35962c = i10;
                return;
            }
            return;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            put(map.h(i11), map.l(i11));
        }
    }

    public boolean isEmpty() {
        if (this.f35962c <= 0) {
            return true;
        }
        return false;
    }

    public V j(int i10) {
        int i11;
        if (i10 >= 0 && i10 < (i11 = this.f35962c)) {
            Object[] objArr = this.f35961b;
            int i12 = i10 << 1;
            V v10 = (V) objArr[i12 + 1];
            if (i11 <= 1) {
                clear();
            } else {
                int i13 = i11 - 1;
                int[] iArr = this.f35960a;
                int i14 = 8;
                if (iArr.length > 8 && i11 < iArr.length / 3) {
                    if (i11 > 8) {
                        i14 = i11 + (i11 >> 1);
                    }
                    int[] copyOf = Arrays.copyOf(iArr, i14);
                    kotlin.jvm.internal.i.e(copyOf, "copyOf(this, newSize)");
                    this.f35960a = copyOf;
                    Object[] copyOf2 = Arrays.copyOf(this.f35961b, i14 << 1);
                    kotlin.jvm.internal.i.e(copyOf2, "copyOf(this, newSize)");
                    this.f35961b = copyOf2;
                    if (i11 == this.f35962c) {
                        if (i10 > 0) {
                            C1228i.h(iArr, this.f35960a, 0, 0, i10);
                            C1228i.j(objArr, this.f35961b, 0, 0, i12);
                        }
                        if (i10 < i13) {
                            int i15 = i10 + 1;
                            C1228i.h(iArr, this.f35960a, i10, i15, i11);
                            C1228i.j(objArr, this.f35961b, i12, i15 << 1, i11 << 1);
                        }
                    } else {
                        throw new ConcurrentModificationException();
                    }
                } else {
                    if (i10 < i13) {
                        int i16 = i10 + 1;
                        C1228i.h(iArr, iArr, i10, i16, i11);
                        Object[] objArr2 = this.f35961b;
                        C1228i.j(objArr2, objArr2, i12, i16 << 1, i11 << 1);
                    }
                    Object[] objArr3 = this.f35961b;
                    int i17 = i13 << 1;
                    objArr3[i17] = null;
                    objArr3[i17 + 1] = null;
                }
                if (i11 == this.f35962c) {
                    this.f35962c = i13;
                } else {
                    throw new ConcurrentModificationException();
                }
            }
            return v10;
        }
        throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i10).toString());
    }

    public V k(int i10, V v10) {
        if (i10 >= 0 && i10 < this.f35962c) {
            int i11 = (i10 << 1) + 1;
            Object[] objArr = this.f35961b;
            V v11 = (V) objArr[i11];
            objArr[i11] = v10;
            return v11;
        }
        throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i10).toString());
    }

    public V l(int i10) {
        if (i10 >= 0 && i10 < this.f35962c) {
            return (V) this.f35961b[(i10 << 1) + 1];
        }
        throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i10).toString());
    }

    public V put(K k10, V v10) {
        int i10;
        int g10;
        int i11 = this.f35962c;
        if (k10 != null) {
            i10 = k10.hashCode();
        } else {
            i10 = 0;
        }
        if (k10 != null) {
            g10 = e(k10, i10);
        } else {
            g10 = g();
        }
        if (g10 >= 0) {
            int i12 = (g10 << 1) + 1;
            Object[] objArr = this.f35961b;
            V v11 = (V) objArr[i12];
            objArr[i12] = v10;
            return v11;
        }
        int i13 = ~g10;
        int[] iArr = this.f35960a;
        if (i11 >= iArr.length) {
            int i14 = 8;
            if (i11 >= 8) {
                i14 = (i11 >> 1) + i11;
            } else if (i11 < 4) {
                i14 = 4;
            }
            int[] copyOf = Arrays.copyOf(iArr, i14);
            kotlin.jvm.internal.i.e(copyOf, "copyOf(this, newSize)");
            this.f35960a = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f35961b, i14 << 1);
            kotlin.jvm.internal.i.e(copyOf2, "copyOf(this, newSize)");
            this.f35961b = copyOf2;
            if (i11 != this.f35962c) {
                throw new ConcurrentModificationException();
            }
        }
        if (i13 < i11) {
            int[] iArr2 = this.f35960a;
            int i15 = i13 + 1;
            C1228i.h(iArr2, iArr2, i15, i13, i11);
            Object[] objArr2 = this.f35961b;
            C1228i.j(objArr2, objArr2, i15 << 1, i13 << 1, this.f35962c << 1);
        }
        int i16 = this.f35962c;
        if (i11 == i16) {
            int[] iArr3 = this.f35960a;
            if (i13 < iArr3.length) {
                iArr3[i13] = i10;
                Object[] objArr3 = this.f35961b;
                int i17 = i13 << 1;
                objArr3[i17] = k10;
                objArr3[i17 + 1] = v10;
                this.f35962c = i16 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k10, V v10) {
        V v11 = get(k10);
        if (v11 == null) {
            return put(k10, v10);
        }
        return v11;
    }

    public V remove(K k10) {
        int f10 = f(k10);
        if (f10 >= 0) {
            return j(f10);
        }
        return null;
    }

    public V replace(K k10, V v10) {
        int f10 = f(k10);
        if (f10 >= 0) {
            return k(f10, v10);
        }
        return null;
    }

    public int size() {
        return this.f35962c;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f35962c * 28);
        sb.append('{');
        int i10 = this.f35962c;
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 > 0) {
                sb.append(", ");
            }
            K h10 = h(i11);
            if (h10 != sb) {
                sb.append(h10);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V l10 = l(i11);
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

    public i(int i10) {
        int[] iArr;
        Object[] objArr;
        if (i10 == 0) {
            iArr = C1474a.f36116a;
        } else {
            iArr = new int[i10];
        }
        this.f35960a = iArr;
        if (i10 == 0) {
            objArr = C1474a.f36118c;
        } else {
            objArr = new Object[i10 << 1];
        }
        this.f35961b = objArr;
    }

    public boolean remove(K k10, V v10) {
        int f10 = f(k10);
        if (f10 < 0 || !kotlin.jvm.internal.i.b(v10, l(f10))) {
            return false;
        }
        j(f10);
        return true;
    }

    public boolean replace(K k10, V v10, V v11) {
        int f10 = f(k10);
        if (f10 < 0 || !kotlin.jvm.internal.i.b(v10, l(f10))) {
            return false;
        }
        k(f10, v11);
        return true;
    }

    public /* synthetic */ i(int i10, int i11, kotlin.jvm.internal.f fVar) {
        this((i11 & 1) != 0 ? 0 : i10);
    }

    public i(i<? extends K, ? extends V> iVar) {
        this(0, 1, null);
        if (iVar != null) {
            i(iVar);
        }
    }
}
