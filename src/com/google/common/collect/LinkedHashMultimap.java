package com.google.common.collect;

import com.google.common.collect.y;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
public final class LinkedHashMultimap<K, V> extends LinkedHashMultimapGwtSerializationDependencies<K, V> {
    static final double VALUE_SET_LOAD_FACTOR = 1.0d;
    private static final long serialVersionUID = 1;

    /* renamed from: f, reason: collision with root package name */
    public transient ValueEntry<K, V> f24458f;
    transient int valueSetCapacity;

    /* loaded from: classes3.dex */
    public static final class ValueEntry<K, V> extends ImmutableEntry<K, V> implements b<K, V> {
        ValueEntry<K, V> nextInValueBucket;
        ValueEntry<K, V> predecessorInMultimap;
        b<K, V> predecessorInValueSet;
        final int smearedValueHash;
        ValueEntry<K, V> successorInMultimap;
        b<K, V> successorInValueSet;

        public ValueEntry(K k10, V v10, int i10, ValueEntry<K, V> valueEntry) {
            super(k10, v10);
            this.smearedValueHash = i10;
            this.nextInValueBucket = valueEntry;
        }

        public static <K, V> ValueEntry<K, V> h() {
            return new ValueEntry<>(null, null, 0, null);
        }

        @Override // com.google.common.collect.LinkedHashMultimap.b
        public void a(b<K, V> bVar) {
            this.successorInValueSet = bVar;
        }

        public ValueEntry<K, V> b() {
            ValueEntry<K, V> valueEntry = this.predecessorInMultimap;
            Objects.requireNonNull(valueEntry);
            return valueEntry;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.b
        public b<K, V> c() {
            b<K, V> bVar = this.predecessorInValueSet;
            Objects.requireNonNull(bVar);
            return bVar;
        }

        public ValueEntry<K, V> d() {
            ValueEntry<K, V> valueEntry = this.successorInMultimap;
            Objects.requireNonNull(valueEntry);
            return valueEntry;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.b
        public b<K, V> e() {
            b<K, V> bVar = this.successorInValueSet;
            Objects.requireNonNull(bVar);
            return bVar;
        }

        public boolean f(Object obj, int i10) {
            if (this.smearedValueHash == i10 && com.google.common.base.h.a(getValue(), obj)) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.b
        public void g(b<K, V> bVar) {
            this.predecessorInValueSet = bVar;
        }

        public void i(ValueEntry<K, V> valueEntry) {
            this.predecessorInMultimap = valueEntry;
        }

        public void j(ValueEntry<K, V> valueEntry) {
            this.successorInMultimap = valueEntry;
        }
    }

    /* loaded from: classes3.dex */
    public final class ValueSet extends y.a<V> implements b<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final K f24459a;

        /* renamed from: b, reason: collision with root package name */
        public int f24460b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f24461c = 0;

        /* renamed from: d, reason: collision with root package name */
        public b<K, V> f24462d = this;

        /* renamed from: e, reason: collision with root package name */
        public b<K, V> f24463e = this;
        ValueEntry<K, V>[] hashTable;

        /* loaded from: classes3.dex */
        public class a implements Iterator<V> {

            /* renamed from: a, reason: collision with root package name */
            public b<K, V> f24465a;

            /* renamed from: b, reason: collision with root package name */
            public ValueEntry<K, V> f24466b;

            /* renamed from: c, reason: collision with root package name */
            public int f24467c;

            public a() {
                this.f24465a = ValueSet.this.f24462d;
                this.f24467c = ValueSet.this.f24461c;
            }

            public final void a() {
                if (ValueSet.this.f24461c == this.f24467c) {
                } else {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                a();
                if (this.f24465a != ValueSet.this) {
                    return true;
                }
                return false;
            }

            @Override // java.util.Iterator
            public V next() {
                if (hasNext()) {
                    ValueEntry<K, V> valueEntry = (ValueEntry) this.f24465a;
                    V value = valueEntry.getValue();
                    this.f24466b = valueEntry;
                    this.f24465a = valueEntry.e();
                    return value;
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                boolean z10;
                a();
                if (this.f24466b != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                com.google.common.base.k.v(z10, "no calls to next() since the last call to remove()");
                ValueSet.this.remove(this.f24466b.getValue());
                this.f24467c = ValueSet.this.f24461c;
                this.f24466b = null;
            }
        }

        public ValueSet(K k10, int i10) {
            this.f24459a = k10;
            this.hashTable = new ValueEntry[l.a(i10, LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)];
        }

        @Override // com.google.common.collect.LinkedHashMultimap.b
        public void a(b<K, V> bVar) {
            this.f24462d = bVar;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(V v10) {
            int d10 = l.d(v10);
            int j10 = j() & d10;
            ValueEntry<K, V> valueEntry = this.hashTable[j10];
            for (ValueEntry<K, V> valueEntry2 = valueEntry; valueEntry2 != null; valueEntry2 = valueEntry2.nextInValueBucket) {
                if (valueEntry2.f(v10, d10)) {
                    return false;
                }
            }
            ValueEntry<K, V> valueEntry3 = new ValueEntry<>(this.f24459a, v10, d10, valueEntry);
            LinkedHashMultimap.F(this.f24463e, valueEntry3);
            LinkedHashMultimap.F(valueEntry3, this);
            LinkedHashMultimap.E(LinkedHashMultimap.this.f24458f.b(), valueEntry3);
            LinkedHashMultimap.E(valueEntry3, LinkedHashMultimap.this.f24458f);
            this.hashTable[j10] = valueEntry3;
            this.f24460b++;
            this.f24461c++;
            k();
            return true;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.b
        public b<K, V> c() {
            return this.f24463e;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Arrays.fill(this.hashTable, (Object) null);
            this.f24460b = 0;
            for (b<K, V> bVar = this.f24462d; bVar != this; bVar = bVar.e()) {
                LinkedHashMultimap.C((ValueEntry) bVar);
            }
            LinkedHashMultimap.F(this, this);
            this.f24461c++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            int d10 = l.d(obj);
            for (ValueEntry<K, V> valueEntry = this.hashTable[j() & d10]; valueEntry != null; valueEntry = valueEntry.nextInValueBucket) {
                if (valueEntry.f(obj, d10)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.b
        public b<K, V> e() {
            return this.f24462d;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.b
        public void g(b<K, V> bVar) {
            this.f24463e = bVar;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new a();
        }

        public final int j() {
            return this.hashTable.length - 1;
        }

        public final void k() {
            if (l.b(this.f24460b, this.hashTable.length, LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)) {
                int length = this.hashTable.length * 2;
                ValueEntry<K, V>[] valueEntryArr = new ValueEntry[length];
                this.hashTable = valueEntryArr;
                int i10 = length - 1;
                for (b<K, V> bVar = this.f24462d; bVar != this; bVar = bVar.e()) {
                    ValueEntry<K, V> valueEntry = (ValueEntry) bVar;
                    int i11 = valueEntry.smearedValueHash & i10;
                    valueEntry.nextInValueBucket = valueEntryArr[i11];
                    valueEntryArr[i11] = valueEntry;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int d10 = l.d(obj);
            int j10 = j() & d10;
            ValueEntry<K, V> valueEntry = null;
            for (ValueEntry<K, V> valueEntry2 = this.hashTable[j10]; valueEntry2 != null; valueEntry2 = valueEntry2.nextInValueBucket) {
                if (valueEntry2.f(obj, d10)) {
                    if (valueEntry == null) {
                        this.hashTable[j10] = valueEntry2.nextInValueBucket;
                    } else {
                        valueEntry.nextInValueBucket = valueEntry2.nextInValueBucket;
                    }
                    LinkedHashMultimap.D(valueEntry2);
                    LinkedHashMultimap.C(valueEntry2);
                    this.f24460b--;
                    this.f24461c++;
                    return true;
                }
                valueEntry = valueEntry2;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f24460b;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        public ValueEntry<K, V> f24469a;

        /* renamed from: b, reason: collision with root package name */
        public ValueEntry<K, V> f24470b;

        public a() {
            this.f24469a = LinkedHashMultimap.this.f24458f.d();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (hasNext()) {
                ValueEntry<K, V> valueEntry = this.f24469a;
                this.f24470b = valueEntry;
                this.f24469a = valueEntry.d();
                return valueEntry;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f24469a != LinkedHashMultimap.this.f24458f) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            boolean z10;
            if (this.f24470b != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            com.google.common.base.k.v(z10, "no calls to next() since the last call to remove()");
            LinkedHashMultimap.this.remove(this.f24470b.getKey(), this.f24470b.getValue());
            this.f24470b = null;
        }
    }

    /* loaded from: classes3.dex */
    public interface b<K, V> {
        void a(b<K, V> bVar);

        b<K, V> c();

        b<K, V> e();

        void g(b<K, V> bVar);
    }

    public static <K, V> void C(ValueEntry<K, V> valueEntry) {
        E(valueEntry.b(), valueEntry.d());
    }

    public static <K, V> void D(b<K, V> bVar) {
        F(bVar.c(), bVar.e());
    }

    public static <K, V> void E(ValueEntry<K, V> valueEntry, ValueEntry<K, V> valueEntry2) {
        valueEntry.j(valueEntry2);
        valueEntry2.i(valueEntry);
    }

    public static <K, V> void F(b<K, V> bVar, b<K, V> bVar2) {
        bVar.a(bVar2);
        bVar2.g(bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        ValueEntry<K, V> h10 = ValueEntry.h();
        this.f24458f = h10;
        E(h10, h10);
        this.valueSetCapacity = 2;
        int readInt = objectInputStream.readInt();
        Map e10 = v.e(12);
        for (int i10 = 0; i10 < readInt; i10++) {
            Object readObject = objectInputStream.readObject();
            e10.put(readObject, p(readObject));
        }
        int readInt2 = objectInputStream.readInt();
        for (int i11 = 0; i11 < readInt2; i11++) {
            Object readObject2 = objectInputStream.readObject();
            Object readObject3 = objectInputStream.readObject();
            Collection collection = (Collection) e10.get(readObject2);
            Objects.requireNonNull(collection);
            collection.add(readObject3);
        }
        s(e10);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(keySet().size());
        Iterator<K> it = keySet().iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : u()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public Set<V> o() {
        return v.f(this.valueSetCapacity);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractC0818c, com.google.common.collect.p
    public /* bridge */ /* synthetic */ Map a() {
        return super.a();
    }

    @Override // com.google.common.collect.AbstractC0818c, com.google.common.collect.p
    public /* bridge */ /* synthetic */ boolean b(Object obj, Object obj2) {
        return super.b(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.p
    public void clear() {
        super.clear();
        ValueEntry<K, V> valueEntry = this.f24458f;
        E(valueEntry, valueEntry);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractC0818c
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractC0818c
    public Iterator<Map.Entry<K, V>> g() {
        return new a();
    }

    @Override // com.google.common.collect.AbstractC0818c
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractC0818c, com.google.common.collect.p
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.AbstractC0818c, com.google.common.collect.p
    public Set<K> keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public Collection<V> p(K k10) {
        return new ValueSet(k10, this.valueSetCapacity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.p
    public /* bridge */ /* synthetic */ boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractC0818c, com.google.common.collect.p
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.p
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.AbstractC0818c
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractSetMultimap
    public Set<Map.Entry<K, V>> u() {
        return super.u();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap
    /* renamed from: v */
    public /* bridge */ /* synthetic */ Set get(Object obj) {
        return super.get(obj);
    }
}
