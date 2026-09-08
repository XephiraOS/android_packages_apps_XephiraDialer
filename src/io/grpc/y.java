package io.grpc;

import java.util.Arrays;

/* compiled from: PersistentHashArrayMappedTrie.java */
/* loaded from: classes4.dex */
public final class y {

    /* compiled from: PersistentHashArrayMappedTrie.java */
    /* loaded from: classes4.dex */
    public static final class a<K, V> implements d<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final K[] f33663a;

        /* renamed from: b, reason: collision with root package name */
        public final V[] f33664b;

        public a(K k10, V v10, K k11, V v11) {
            this(new Object[]{k10, k11}, new Object[]{v10, v11});
        }

        @Override // io.grpc.y.d
        public d<K, V> a(K k10, V v10, int i10, int i11) {
            int hashCode = this.f33663a[0].hashCode();
            if (hashCode != i10) {
                return b.b(new c(k10, v10), i10, this, hashCode, i11);
            }
            int b10 = b(k10);
            if (b10 != -1) {
                K[] kArr = this.f33663a;
                Object[] copyOf = Arrays.copyOf(kArr, kArr.length);
                Object[] copyOf2 = Arrays.copyOf(this.f33664b, this.f33663a.length);
                copyOf[b10] = k10;
                copyOf2[b10] = v10;
                return new a(copyOf, copyOf2);
            }
            K[] kArr2 = this.f33663a;
            Object[] copyOf3 = Arrays.copyOf(kArr2, kArr2.length + 1);
            Object[] copyOf4 = Arrays.copyOf(this.f33664b, this.f33663a.length + 1);
            K[] kArr3 = this.f33663a;
            copyOf3[kArr3.length] = k10;
            copyOf4[kArr3.length] = v10;
            return new a(copyOf3, copyOf4);
        }

        public final int b(K k10) {
            int i10 = 0;
            while (true) {
                K[] kArr = this.f33663a;
                if (i10 < kArr.length) {
                    if (kArr[i10] == k10) {
                        return i10;
                    }
                    i10++;
                } else {
                    return -1;
                }
            }
        }

        @Override // io.grpc.y.d
        public int size() {
            return this.f33664b.length;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("CollisionLeaf(");
            for (int i10 = 0; i10 < this.f33664b.length; i10++) {
                sb.append("(key=");
                sb.append(this.f33663a[i10]);
                sb.append(" value=");
                sb.append(this.f33664b[i10]);
                sb.append(") ");
            }
            sb.append(")");
            return sb.toString();
        }

        public a(K[] kArr, V[] vArr) {
            this.f33663a = kArr;
            this.f33664b = vArr;
        }
    }

    /* compiled from: PersistentHashArrayMappedTrie.java */
    /* loaded from: classes4.dex */
    public static final class b<K, V> implements d<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final int f33665a;

        /* renamed from: b, reason: collision with root package name */
        public final d<K, V>[] f33666b;

        /* renamed from: c, reason: collision with root package name */
        public final int f33667c;

        public b(int i10, d<K, V>[] dVarArr, int i11) {
            this.f33665a = i10;
            this.f33666b = dVarArr;
            this.f33667c = i11;
        }

        public static <K, V> d<K, V> b(d<K, V> dVar, int i10, d<K, V> dVar2, int i11, int i12) {
            int d10 = d(i10, i12);
            int d11 = d(i11, i12);
            if (d10 == d11) {
                d b10 = b(dVar, i10, dVar2, i11, i12 + 5);
                return new b(d10, new d[]{b10}, b10.size());
            }
            if (e(i10, i12) > e(i11, i12)) {
                dVar2 = dVar;
                dVar = dVar2;
            }
            return new b(d10 | d11, new d[]{dVar, dVar2}, dVar.size() + dVar2.size());
        }

        public static int d(int i10, int i11) {
            return 1 << e(i10, i11);
        }

        public static int e(int i10, int i11) {
            return (i10 >>> i11) & 31;
        }

        @Override // io.grpc.y.d
        public d<K, V> a(K k10, V v10, int i10, int i11) {
            int d10 = d(i10, i11);
            int c10 = c(d10);
            int i12 = this.f33665a;
            if ((i12 & d10) == 0) {
                int i13 = i12 | d10;
                d<K, V>[] dVarArr = this.f33666b;
                d[] dVarArr2 = new d[dVarArr.length + 1];
                System.arraycopy(dVarArr, 0, dVarArr2, 0, c10);
                dVarArr2[c10] = new c(k10, v10);
                d<K, V>[] dVarArr3 = this.f33666b;
                System.arraycopy(dVarArr3, c10, dVarArr2, c10 + 1, dVarArr3.length - c10);
                return new b(i13, dVarArr2, size() + 1);
            }
            d<K, V>[] dVarArr4 = this.f33666b;
            d[] dVarArr5 = (d[]) Arrays.copyOf(dVarArr4, dVarArr4.length);
            dVarArr5[c10] = this.f33666b[c10].a(k10, v10, i10, i11 + 5);
            return new b(this.f33665a, dVarArr5, (size() + dVarArr5[c10].size()) - this.f33666b[c10].size());
        }

        public final int c(int i10) {
            return Integer.bitCount(this.f33665a & (i10 - 1));
        }

        @Override // io.grpc.y.d
        public int size() {
            return this.f33667c;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("CompressedIndex(");
            sb.append(String.format("bitmap=%s ", Integer.toBinaryString(this.f33665a)));
            for (d<K, V> dVar : this.f33666b) {
                sb.append(dVar);
                sb.append(" ");
            }
            sb.append(")");
            return sb.toString();
        }
    }

    /* compiled from: PersistentHashArrayMappedTrie.java */
    /* loaded from: classes4.dex */
    public static final class c<K, V> implements d<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final K f33668a;

        /* renamed from: b, reason: collision with root package name */
        public final V f33669b;

        public c(K k10, V v10) {
            this.f33668a = k10;
            this.f33669b = v10;
        }

        @Override // io.grpc.y.d
        public d<K, V> a(K k10, V v10, int i10, int i11) {
            int hashCode = this.f33668a.hashCode();
            if (hashCode != i10) {
                return b.b(new c(k10, v10), i10, this, hashCode, i11);
            }
            if (this.f33668a == k10) {
                return new c(k10, v10);
            }
            return new a(this.f33668a, this.f33669b, k10, v10);
        }

        @Override // io.grpc.y.d
        public int size() {
            return 1;
        }

        public String toString() {
            return String.format("Leaf(key=%s value=%s)", this.f33668a, this.f33669b);
        }
    }

    /* compiled from: PersistentHashArrayMappedTrie.java */
    /* loaded from: classes4.dex */
    public interface d<K, V> {
        d<K, V> a(K k10, V v10, int i10, int i11);

        int size();
    }

    public static <K, V> d<K, V> a(d<K, V> dVar, K k10, V v10) {
        if (dVar == null) {
            return new c(k10, v10);
        }
        return dVar.a(k10, v10, k10.hashCode(), 0);
    }
}
