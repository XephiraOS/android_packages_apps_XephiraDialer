package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.heytap.accessory.constant.FastPairConstants;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {

    /* renamed from: g, reason: collision with root package name */
    public static final ImmutableMap<Object, Object> f24533g = new RegularImmutableMap(null, new Object[0], 0);
    private static final long serialVersionUID = 0;
    final transient Object[] alternatingKeysAndValues;

    /* renamed from: e, reason: collision with root package name */
    public final transient Object f24534e;

    /* renamed from: f, reason: collision with root package name */
    public final transient int f24535f;

    /* loaded from: classes3.dex */
    public static class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {

        /* renamed from: c, reason: collision with root package name */
        public final transient ImmutableMap<K, V> f24536c;

        /* renamed from: d, reason: collision with root package name */
        public final transient Object[] f24537d;

        /* renamed from: e, reason: collision with root package name */
        public final transient int f24538e;

        /* renamed from: f, reason: collision with root package name */
        public final transient int f24539f;

        public EntrySet(ImmutableMap<K, V> immutableMap, Object[] objArr, int i10, int i11) {
            this.f24536c = immutableMap;
            this.f24537d = objArr;
            this.f24538e = i10;
            this.f24539f = i11;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int c(Object[] objArr, int i10) {
            return a().c(objArr, i10);
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.f24536c.get(key))) {
                return false;
            }
            return true;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean i() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: j */
        public C<Map.Entry<K, V>> iterator() {
            return a().iterator();
        }

        @Override // com.google.common.collect.ImmutableSet
        public ImmutableList<Map.Entry<K, V>> n() {
            return new ImmutableList<Map.Entry<K, V>>() { // from class: com.google.common.collect.RegularImmutableMap.EntrySet.1
                @Override // com.google.common.collect.ImmutableCollection
                public boolean i() {
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return EntrySet.this.f24539f;
                }

                @Override // java.util.List
                /* renamed from: x, reason: merged with bridge method [inline-methods] */
                public Map.Entry<K, V> get(int i10) {
                    com.google.common.base.k.m(i10, EntrySet.this.f24539f);
                    int i11 = i10 * 2;
                    Object obj = EntrySet.this.f24537d[EntrySet.this.f24538e + i11];
                    Objects.requireNonNull(obj);
                    Object obj2 = EntrySet.this.f24537d[i11 + (EntrySet.this.f24538e ^ 1)];
                    Objects.requireNonNull(obj2);
                    return new AbstractMap.SimpleImmutableEntry(obj, obj2);
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f24539f;
        }
    }

    /* loaded from: classes3.dex */
    public static final class KeySet<K> extends ImmutableSet<K> {

        /* renamed from: c, reason: collision with root package name */
        public final transient ImmutableMap<K, ?> f24540c;

        /* renamed from: d, reason: collision with root package name */
        public final transient ImmutableList<K> f24541d;

        public KeySet(ImmutableMap<K, ?> immutableMap, ImmutableList<K> immutableList) {
            this.f24540c = immutableMap;
            this.f24541d = immutableList;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public ImmutableList<K> a() {
            return this.f24541d;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int c(Object[] objArr, int i10) {
            return a().c(objArr, i10);
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (this.f24540c.get(obj) != null) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean i() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: j */
        public C<K> iterator() {
            return a().iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f24540c.size();
        }
    }

    /* loaded from: classes3.dex */
    public static final class KeysOrValuesAsList extends ImmutableList<Object> {

        /* renamed from: c, reason: collision with root package name */
        public final transient Object[] f24542c;

        /* renamed from: d, reason: collision with root package name */
        public final transient int f24543d;

        /* renamed from: e, reason: collision with root package name */
        public final transient int f24544e;

        public KeysOrValuesAsList(Object[] objArr, int i10, int i11) {
            this.f24542c = objArr;
            this.f24543d = i10;
            this.f24544e = i11;
        }

        @Override // java.util.List
        public Object get(int i10) {
            com.google.common.base.k.m(i10, this.f24544e);
            Object obj = this.f24542c[(i10 * 2) + this.f24543d];
            Objects.requireNonNull(obj);
            return obj;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean i() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f24544e;
        }
    }

    public RegularImmutableMap(Object obj, Object[] objArr, int i10) {
        this.f24534e = obj;
        this.alternatingKeysAndValues = objArr;
        this.f24535f = i10;
    }

    public static <K, V> RegularImmutableMap<K, V> n(int i10, Object[] objArr, ImmutableMap.a<K, V> aVar) {
        if (i10 == 0) {
            return (RegularImmutableMap) f24533g;
        }
        if (i10 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[1];
            Objects.requireNonNull(obj2);
            f.a(obj, obj2);
            return new RegularImmutableMap<>(null, objArr, 1);
        }
        com.google.common.base.k.r(i10, objArr.length >> 1);
        Object o10 = o(objArr, i10, ImmutableSet.chooseTableSize(i10), 0);
        if (o10 instanceof Object[]) {
            Object[] objArr2 = (Object[]) o10;
            ImmutableMap.a.C0221a c0221a = (ImmutableMap.a.C0221a) objArr2[2];
            if (aVar != null) {
                aVar.f24434e = c0221a;
                Object obj3 = objArr2[0];
                int intValue = ((Integer) objArr2[1]).intValue();
                objArr = Arrays.copyOf(objArr, intValue * 2);
                o10 = obj3;
                i10 = intValue;
            } else {
                throw c0221a.a();
            }
        }
        return new RegularImmutableMap<>(o10, objArr, i10);
    }

    public static Object o(Object[] objArr, int i10, int i11, int i12) {
        ImmutableMap.a.C0221a c0221a = null;
        if (i10 == 1) {
            Object obj = objArr[i12];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[i12 ^ 1];
            Objects.requireNonNull(obj2);
            f.a(obj, obj2);
            return null;
        }
        int i13 = i11 - 1;
        int i14 = -1;
        if (i11 <= 128) {
            byte[] bArr = new byte[i11];
            Arrays.fill(bArr, (byte) -1);
            int i15 = 0;
            for (int i16 = 0; i16 < i10; i16++) {
                int i17 = (i16 * 2) + i12;
                int i18 = (i15 * 2) + i12;
                Object obj3 = objArr[i17];
                Objects.requireNonNull(obj3);
                Object obj4 = objArr[i17 ^ 1];
                Objects.requireNonNull(obj4);
                f.a(obj3, obj4);
                int c10 = l.c(obj3.hashCode());
                while (true) {
                    int i19 = c10 & i13;
                    int i20 = bArr[i19] & FastPairConstants.GO_INTENT_NOT_SET;
                    if (i20 == 255) {
                        bArr[i19] = (byte) i18;
                        if (i15 < i16) {
                            objArr[i18] = obj3;
                            objArr[i18 ^ 1] = obj4;
                        }
                        i15++;
                    } else {
                        if (obj3.equals(objArr[i20])) {
                            int i21 = i20 ^ 1;
                            Object obj5 = objArr[i21];
                            Objects.requireNonNull(obj5);
                            c0221a = new ImmutableMap.a.C0221a(obj3, obj4, obj5);
                            objArr[i21] = obj4;
                            break;
                        }
                        c10 = i19 + 1;
                    }
                }
            }
            if (i15 != i10) {
                return new Object[]{bArr, Integer.valueOf(i15), c0221a};
            }
            return bArr;
        }
        if (i11 <= 32768) {
            short[] sArr = new short[i11];
            Arrays.fill(sArr, (short) -1);
            int i22 = 0;
            for (int i23 = 0; i23 < i10; i23++) {
                int i24 = (i23 * 2) + i12;
                int i25 = (i22 * 2) + i12;
                Object obj6 = objArr[i24];
                Objects.requireNonNull(obj6);
                Object obj7 = objArr[i24 ^ 1];
                Objects.requireNonNull(obj7);
                f.a(obj6, obj7);
                int c11 = l.c(obj6.hashCode());
                while (true) {
                    int i26 = c11 & i13;
                    int i27 = sArr[i26] & 65535;
                    if (i27 == 65535) {
                        sArr[i26] = (short) i25;
                        if (i22 < i23) {
                            objArr[i25] = obj6;
                            objArr[i25 ^ 1] = obj7;
                        }
                        i22++;
                    } else {
                        if (obj6.equals(objArr[i27])) {
                            int i28 = i27 ^ 1;
                            Object obj8 = objArr[i28];
                            Objects.requireNonNull(obj8);
                            c0221a = new ImmutableMap.a.C0221a(obj6, obj7, obj8);
                            objArr[i28] = obj7;
                            break;
                        }
                        c11 = i26 + 1;
                    }
                }
            }
            if (i22 != i10) {
                return new Object[]{sArr, Integer.valueOf(i22), c0221a};
            }
            return sArr;
        }
        int[] iArr = new int[i11];
        Arrays.fill(iArr, -1);
        int i29 = 0;
        int i30 = 0;
        while (i29 < i10) {
            int i31 = (i29 * 2) + i12;
            int i32 = (i30 * 2) + i12;
            Object obj9 = objArr[i31];
            Objects.requireNonNull(obj9);
            Object obj10 = objArr[i31 ^ 1];
            Objects.requireNonNull(obj10);
            f.a(obj9, obj10);
            int c12 = l.c(obj9.hashCode());
            while (true) {
                int i33 = c12 & i13;
                int i34 = iArr[i33];
                if (i34 == i14) {
                    iArr[i33] = i32;
                    if (i30 < i29) {
                        objArr[i32] = obj9;
                        objArr[i32 ^ 1] = obj10;
                    }
                    i30++;
                } else {
                    if (obj9.equals(objArr[i34])) {
                        int i35 = i34 ^ 1;
                        Object obj11 = objArr[i35];
                        Objects.requireNonNull(obj11);
                        c0221a = new ImmutableMap.a.C0221a(obj9, obj10, obj11);
                        objArr[i35] = obj10;
                        break;
                    }
                    c12 = i33 + 1;
                    i14 = -1;
                }
            }
            i29++;
            i14 = -1;
        }
        if (i30 != i10) {
            return new Object[]{iArr, Integer.valueOf(i30), c0221a};
        }
        return iArr;
    }

    public static Object p(Object obj, Object[] objArr, int i10, int i11, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i10 == 1) {
            Object obj3 = objArr[i11];
            Objects.requireNonNull(obj3);
            if (!obj3.equals(obj2)) {
                return null;
            }
            Object obj4 = objArr[i11 ^ 1];
            Objects.requireNonNull(obj4);
            return obj4;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length - 1;
            int c10 = l.c(obj2.hashCode());
            while (true) {
                int i12 = c10 & length;
                int i13 = bArr[i12] & FastPairConstants.GO_INTENT_NOT_SET;
                if (i13 == 255) {
                    return null;
                }
                if (obj2.equals(objArr[i13])) {
                    return objArr[i13 ^ 1];
                }
                c10 = i12 + 1;
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length2 = sArr.length - 1;
            int c11 = l.c(obj2.hashCode());
            while (true) {
                int i14 = c11 & length2;
                int i15 = sArr[i14] & 65535;
                if (i15 == 65535) {
                    return null;
                }
                if (obj2.equals(objArr[i15])) {
                    return objArr[i15 ^ 1];
                }
                c11 = i14 + 1;
            }
        } else {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length - 1;
            int c12 = l.c(obj2.hashCode());
            while (true) {
                int i16 = c12 & length3;
                int i17 = iArr[i16];
                if (i17 == -1) {
                    return null;
                }
                if (obj2.equals(objArr[i17])) {
                    return objArr[i17 ^ 1];
                }
                c12 = i16 + 1;
            }
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> e() {
        return new EntrySet(this, this.alternatingKeysAndValues, 0, this.f24535f);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> f() {
        return new KeySet(this, new KeysOrValuesAsList(this.alternatingKeysAndValues, 0, this.f24535f));
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableCollection<V> g() {
        return new KeysOrValuesAsList(this.alternatingKeysAndValues, 1, this.f24535f);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        V v10 = (V) p(this.f24534e, this.alternatingKeysAndValues, this.f24535f, 0, obj);
        if (v10 == null) {
            return null;
        }
        return v10;
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean j() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f24535f;
    }
}
