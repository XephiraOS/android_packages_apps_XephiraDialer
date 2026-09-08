package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapMakerInternalMap.Segment;
import com.google.common.collect.MapMakerInternalMap.h;
import com.google.j2objc.annotations.Weak;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class MapMakerInternalMap<K, V, E extends h<K, V, E>, S extends Segment<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {

    /* renamed from: h, reason: collision with root package name */
    public static final t<Object, Object, d> f24472h = new a();
    private static final long serialVersionUID = 5;

    /* renamed from: a, reason: collision with root package name */
    public final transient int f24473a;

    /* renamed from: b, reason: collision with root package name */
    public final transient int f24474b;

    /* renamed from: c, reason: collision with root package name */
    public final transient Segment<K, V, E, S>[] f24475c;
    final int concurrencyLevel;

    /* renamed from: d, reason: collision with root package name */
    public final transient i<K, V, E, S> f24476d;

    /* renamed from: e, reason: collision with root package name */
    public transient Set<K> f24477e;

    /* renamed from: f, reason: collision with root package name */
    public transient Collection<V> f24478f;

    /* renamed from: g, reason: collision with root package name */
    public transient Set<Map.Entry<K, V>> f24479g;
    final Equivalence<Object> keyEquivalence;

    /* loaded from: classes3.dex */
    public static abstract class AbstractSerializationProxy<K, V> extends com.google.common.collect.i<K, V> implements Serializable {
        private static final long serialVersionUID = 3;

        /* renamed from: a, reason: collision with root package name */
        public transient ConcurrentMap<K, V> f24480a;
        final int concurrencyLevel;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;

        public AbstractSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i10, ConcurrentMap<K, V> concurrentMap) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.concurrencyLevel = i10;
            this.f24480a = concurrentMap;
        }

        @Override // com.google.common.collect.j
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public ConcurrentMap<K, V> b() {
            return this.f24480a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void g(ObjectInputStream objectInputStream) {
            while (true) {
                Object readObject = objectInputStream.readObject();
                if (readObject == null) {
                    return;
                }
                this.f24480a.put(readObject, objectInputStream.readObject());
            }
        }

        public com.google.common.collect.o h(ObjectInputStream objectInputStream) {
            return new com.google.common.collect.o().g(objectInputStream.readInt()).j(this.keyStrength).k(this.valueStrength).h(this.keyEquivalence).a(this.concurrencyLevel);
        }

        public void i(ObjectOutputStream objectOutputStream) {
            objectOutputStream.writeInt(this.f24480a.size());
            for (Map.Entry<K, V> entry : this.f24480a.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject(null);
        }
    }

    /* loaded from: classes3.dex */
    public static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 3;

        public SerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i10, ConcurrentMap<K, V> concurrentMap) {
            super(strength, strength2, equivalence, equivalence2, i10, concurrentMap);
        }

        private void readObject(ObjectInputStream objectInputStream) {
            objectInputStream.defaultReadObject();
            this.f24480a = h(objectInputStream).i();
            g(objectInputStream);
        }

        private Object readResolve() {
            return this.f24480a;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) {
            objectOutputStream.defaultWriteObject();
            i(objectOutputStream);
        }
    }

    /* loaded from: classes3.dex */
    public enum Strength {
        STRONG { // from class: com.google.common.collect.MapMakerInternalMap.Strength.1
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            public Equivalence<Object> b() {
                return Equivalence.c();
            }
        },
        WEAK { // from class: com.google.common.collect.MapMakerInternalMap.Strength.2
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            public Equivalence<Object> b() {
                return Equivalence.f();
            }
        };

        public abstract Equivalence<Object> b();

        /* synthetic */ Strength(a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class b<K, V, E extends h<K, V, E>> implements h<K, V, E> {

        /* renamed from: a, reason: collision with root package name */
        public final K f24484a;

        /* renamed from: b, reason: collision with root package name */
        public final int f24485b;

        public b(K k10, int i10) {
            this.f24484a = k10;
            this.f24485b = i10;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public E a() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final int c() {
            return this.f24485b;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final K getKey() {
            return this.f24484a;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class c<K, V, E extends h<K, V, E>> extends WeakReference<K> implements h<K, V, E> {

        /* renamed from: a, reason: collision with root package name */
        public final int f24486a;

        public c(ReferenceQueue<K> referenceQueue, K k10, int i10) {
            super(k10, referenceQueue);
            this.f24486a = i10;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public E a() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final int c() {
            return this.f24486a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final K getKey() {
            return get();
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements h<Object, Object, d> {
        public d() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public int c() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public d a() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public Object getKey() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public Object getValue() {
            throw new AssertionError();
        }
    }

    /* loaded from: classes3.dex */
    public final class e extends MapMakerInternalMap<K, V, E, S>.g<Map.Entry<K, V>> {
        public e(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // java.util.Iterator
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            return c();
        }
    }

    /* loaded from: classes3.dex */
    public final class f extends l<Map.Entry<K, V>> {
        public f() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (obj2 = MapMakerInternalMap.this.get(key)) == null || !MapMakerInternalMap.this.valueEquivalence().d(entry.getValue(), obj2)) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new e(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || !MapMakerInternalMap.this.remove(key, entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* loaded from: classes3.dex */
    public abstract class g<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        public int f24488a;

        /* renamed from: b, reason: collision with root package name */
        public int f24489b = -1;

        /* renamed from: c, reason: collision with root package name */
        public Segment<K, V, E, S> f24490c;

        /* renamed from: d, reason: collision with root package name */
        public AtomicReferenceArray<E> f24491d;

        /* renamed from: e, reason: collision with root package name */
        public E f24492e;

        /* renamed from: f, reason: collision with root package name */
        public MapMakerInternalMap<K, V, E, S>.v f24493f;

        /* renamed from: g, reason: collision with root package name */
        public MapMakerInternalMap<K, V, E, S>.v f24494g;

        public g() {
            this.f24488a = MapMakerInternalMap.this.f24475c.length - 1;
            a();
        }

        public final void a() {
            this.f24493f = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i10 = this.f24488a;
                if (i10 >= 0) {
                    Segment<K, V, E, S>[] segmentArr = MapMakerInternalMap.this.f24475c;
                    this.f24488a = i10 - 1;
                    Segment<K, V, E, S> segment = segmentArr[i10];
                    this.f24490c = segment;
                    if (segment.count != 0) {
                        this.f24491d = this.f24490c.table;
                        this.f24489b = r0.length() - 1;
                        if (e()) {
                            return;
                        }
                    }
                } else {
                    return;
                }
            }
        }

        public boolean b(E e10) {
            try {
                Object key = e10.getKey();
                Object f10 = MapMakerInternalMap.this.f(e10);
                if (f10 != null) {
                    this.f24493f = new v(key, f10);
                    this.f24490c.t();
                    return true;
                }
                this.f24490c.t();
                return false;
            } catch (Throwable th) {
                this.f24490c.t();
                throw th;
            }
        }

        public MapMakerInternalMap<K, V, E, S>.v c() {
            MapMakerInternalMap<K, V, E, S>.v vVar = this.f24493f;
            if (vVar != null) {
                this.f24494g = vVar;
                a();
                return this.f24494g;
            }
            throw new NoSuchElementException();
        }

        public boolean d() {
            E e10 = this.f24492e;
            if (e10 == null) {
                return false;
            }
            while (true) {
                this.f24492e = (E) e10.a();
                E e11 = this.f24492e;
                if (e11 != null) {
                    if (b(e11)) {
                        return true;
                    }
                    e10 = this.f24492e;
                } else {
                    return false;
                }
            }
        }

        public boolean e() {
            while (true) {
                int i10 = this.f24489b;
                if (i10 >= 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.f24491d;
                    this.f24489b = i10 - 1;
                    E e10 = atomicReferenceArray.get(i10);
                    this.f24492e = e10;
                    if (e10 != null && (b(e10) || d())) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f24493f != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            boolean z10;
            if (this.f24494g != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            com.google.common.collect.f.c(z10);
            MapMakerInternalMap.this.remove(this.f24494g.getKey());
            this.f24494g = null;
        }
    }

    /* loaded from: classes3.dex */
    public interface h<K, V, E extends h<K, V, E>> {
        E a();

        int c();

        K getKey();

        V getValue();
    }

    /* loaded from: classes3.dex */
    public interface i<K, V, E extends h<K, V, E>, S extends Segment<K, V, E, S>> {
        S a(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i10);

        E b(S s10, E e10, E e11);

        Strength c();

        Strength d();

        void e(S s10, E e10, V v10);

        E f(S s10, K k10, int i10, E e10);
    }

    /* loaded from: classes3.dex */
    public final class j extends MapMakerInternalMap<K, V, E, S>.g<K> {
        public j(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return c().getKey();
        }
    }

    /* loaded from: classes3.dex */
    public final class k extends l<K> {
        public k() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new j(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (MapMakerInternalMap.this.remove(obj) != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class l<E> extends AbstractSet<E> {
        public l() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return MapMakerInternalMap.m(this).toArray();
        }

        public /* synthetic */ l(a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapMakerInternalMap.m(this).toArray(tArr);
        }
    }

    /* loaded from: classes3.dex */
    public static class m<K, V> extends b<K, V, m<K, V>> implements h {

        /* renamed from: c, reason: collision with root package name */
        public volatile V f24497c;

        /* loaded from: classes3.dex */
        public static final class a<K, V> implements i<K, V, m<K, V>, StrongKeyStrongValueSegment<K, V>> {

            /* renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f24498a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f24498a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength c() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength d() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public m<K, V> b(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, m<K, V> mVar, m<K, V> mVar2) {
                m<K, V> f10 = f(strongKeyStrongValueSegment, mVar.f24484a, mVar.f24485b, mVar2);
                f10.f24497c = mVar.f24497c;
                return f10;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public m<K, V> f(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, K k10, int i10, m<K, V> mVar) {
                if (mVar == null) {
                    return new m<>(k10, i10, null);
                }
                return new b(k10, i10, mVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public StrongKeyStrongValueSegment<K, V> a(MapMakerInternalMap<K, V, m<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i10) {
                return new StrongKeyStrongValueSegment<>(mapMakerInternalMap, i10);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void e(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, m<K, V> mVar, V v10) {
                mVar.f24497c = v10;
            }
        }

        /* loaded from: classes3.dex */
        public static final class b<K, V> extends m<K, V> {

            /* renamed from: d, reason: collision with root package name */
            public final m<K, V> f24499d;

            public b(K k10, int i10, m<K, V> mVar) {
                super(k10, i10, null);
                this.f24499d = mVar;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.b, com.google.common.collect.MapMakerInternalMap.h
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public m<K, V> a() {
                return this.f24499d;
            }
        }

        public /* synthetic */ m(Object obj, int i10, a aVar) {
            this(obj, i10);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final V getValue() {
            return this.f24497c;
        }

        public m(K k10, int i10) {
            super(k10, i10);
            this.f24497c = null;
        }
    }

    /* loaded from: classes3.dex */
    public static class n<K, V> extends b<K, V, n<K, V>> implements s<K, V, n<K, V>> {

        /* renamed from: c, reason: collision with root package name */
        public volatile t<K, V, n<K, V>> f24500c;

        /* loaded from: classes3.dex */
        public static final class a<K, V> implements i<K, V, n<K, V>, StrongKeyWeakValueSegment<K, V>> {

            /* renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f24501a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f24501a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength c() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength d() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public n<K, V> b(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, n<K, V> nVar, n<K, V> nVar2) {
                if (Segment.p(nVar)) {
                    return null;
                }
                n<K, V> f10 = f(strongKeyWeakValueSegment, nVar.f24484a, nVar.f24485b, nVar2);
                f10.f24500c = nVar.f24500c.b(((StrongKeyWeakValueSegment) strongKeyWeakValueSegment).queueForValues, f10);
                return f10;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public n<K, V> f(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, K k10, int i10, n<K, V> nVar) {
                if (nVar == null) {
                    return new n<>(k10, i10, null);
                }
                return new b(k10, i10, nVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public StrongKeyWeakValueSegment<K, V> a(MapMakerInternalMap<K, V, n<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i10) {
                return new StrongKeyWeakValueSegment<>(mapMakerInternalMap, i10);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void e(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, n<K, V> nVar, V v10) {
                t tVar = nVar.f24500c;
                nVar.f24500c = new u(((StrongKeyWeakValueSegment) strongKeyWeakValueSegment).queueForValues, v10, nVar);
                tVar.clear();
            }
        }

        /* loaded from: classes3.dex */
        public static final class b<K, V> extends n<K, V> {

            /* renamed from: d, reason: collision with root package name */
            public final n<K, V> f24502d;

            public b(K k10, int i10, n<K, V> nVar) {
                super(k10, i10, null);
                this.f24502d = nVar;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.b, com.google.common.collect.MapMakerInternalMap.h
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public n<K, V> a() {
                return this.f24502d;
            }
        }

        public /* synthetic */ n(Object obj, int i10, a aVar) {
            this(obj, i10);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.s
        public final t<K, V, n<K, V>> b() {
            return this.f24500c;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final V getValue() {
            return this.f24500c.get();
        }

        public n(K k10, int i10) {
            super(k10, i10);
            this.f24500c = MapMakerInternalMap.n();
        }
    }

    /* loaded from: classes3.dex */
    public final class o extends MapMakerInternalMap<K, V, E, S>.g<V> {
        public o(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return c().getValue();
        }
    }

    /* loaded from: classes3.dex */
    public final class p extends AbstractCollection<V> {
        public p() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new o(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return MapMakerInternalMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return MapMakerInternalMap.m(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapMakerInternalMap.m(this).toArray(tArr);
        }
    }

    /* loaded from: classes3.dex */
    public static class q<K, V> extends c<K, V, q<K, V>> implements h {

        /* renamed from: b, reason: collision with root package name */
        public volatile V f24504b;

        /* loaded from: classes3.dex */
        public static final class a<K, V> implements i<K, V, q<K, V>, WeakKeyStrongValueSegment<K, V>> {

            /* renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f24505a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f24505a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength c() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength d() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public q<K, V> b(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, q<K, V> qVar, q<K, V> qVar2) {
                K key = qVar.getKey();
                if (key == null) {
                    return null;
                }
                q<K, V> f10 = f(weakKeyStrongValueSegment, key, qVar.f24486a, qVar2);
                f10.f24504b = qVar.f24504b;
                return f10;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public q<K, V> f(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, K k10, int i10, q<K, V> qVar) {
                if (qVar == null) {
                    return new q<>(((WeakKeyStrongValueSegment) weakKeyStrongValueSegment).queueForKeys, k10, i10, null);
                }
                return new b(((WeakKeyStrongValueSegment) weakKeyStrongValueSegment).queueForKeys, k10, i10, qVar, null);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public WeakKeyStrongValueSegment<K, V> a(MapMakerInternalMap<K, V, q<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i10) {
                return new WeakKeyStrongValueSegment<>(mapMakerInternalMap, i10);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void e(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, q<K, V> qVar, V v10) {
                qVar.f24504b = v10;
            }
        }

        /* loaded from: classes3.dex */
        public static final class b<K, V> extends q<K, V> {

            /* renamed from: c, reason: collision with root package name */
            public final q<K, V> f24506c;

            public /* synthetic */ b(ReferenceQueue referenceQueue, Object obj, int i10, q qVar, a aVar) {
                this(referenceQueue, obj, i10, qVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.c, com.google.common.collect.MapMakerInternalMap.h
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public q<K, V> a() {
                return this.f24506c;
            }

            public b(ReferenceQueue<K> referenceQueue, K k10, int i10, q<K, V> qVar) {
                super(referenceQueue, k10, i10, null);
                this.f24506c = qVar;
            }
        }

        public /* synthetic */ q(ReferenceQueue referenceQueue, Object obj, int i10, a aVar) {
            this(referenceQueue, obj, i10);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final V getValue() {
            return this.f24504b;
        }

        public q(ReferenceQueue<K> referenceQueue, K k10, int i10) {
            super(referenceQueue, k10, i10);
            this.f24504b = null;
        }
    }

    /* loaded from: classes3.dex */
    public static class r<K, V> extends c<K, V, r<K, V>> implements s<K, V, r<K, V>> {

        /* renamed from: b, reason: collision with root package name */
        public volatile t<K, V, r<K, V>> f24507b;

        /* loaded from: classes3.dex */
        public static final class a<K, V> implements i<K, V, r<K, V>, WeakKeyWeakValueSegment<K, V>> {

            /* renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f24508a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f24508a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength c() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength d() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public r<K, V> b(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, r<K, V> rVar, r<K, V> rVar2) {
                K key = rVar.getKey();
                if (key == null || Segment.p(rVar)) {
                    return null;
                }
                r<K, V> f10 = f(weakKeyWeakValueSegment, key, rVar.f24486a, rVar2);
                f10.f24507b = rVar.f24507b.b(((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForValues, f10);
                return f10;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public r<K, V> f(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, K k10, int i10, r<K, V> rVar) {
                if (rVar == null) {
                    return new r<>(((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForKeys, k10, i10);
                }
                return new b(((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForKeys, k10, i10, rVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public WeakKeyWeakValueSegment<K, V> a(MapMakerInternalMap<K, V, r<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i10) {
                return new WeakKeyWeakValueSegment<>(mapMakerInternalMap, i10);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void e(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, r<K, V> rVar, V v10) {
                t tVar = rVar.f24507b;
                rVar.f24507b = new u(((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForValues, v10, rVar);
                tVar.clear();
            }
        }

        /* loaded from: classes3.dex */
        public static final class b<K, V> extends r<K, V> {

            /* renamed from: c, reason: collision with root package name */
            public final r<K, V> f24509c;

            public b(ReferenceQueue<K> referenceQueue, K k10, int i10, r<K, V> rVar) {
                super(referenceQueue, k10, i10);
                this.f24509c = rVar;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.c, com.google.common.collect.MapMakerInternalMap.h
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public r<K, V> a() {
                return this.f24509c;
            }
        }

        public r(ReferenceQueue<K> referenceQueue, K k10, int i10) {
            super(referenceQueue, k10, i10);
            this.f24507b = MapMakerInternalMap.n();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.s
        public final t<K, V, r<K, V>> b() {
            return this.f24507b;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final V getValue() {
            return this.f24507b.get();
        }
    }

    /* loaded from: classes3.dex */
    public interface s<K, V, E extends h<K, V, E>> extends h<K, V, E> {
        t<K, V, E> b();
    }

    /* loaded from: classes3.dex */
    public interface t<K, V, E extends h<K, V, E>> {
        E a();

        t<K, V, E> b(ReferenceQueue<V> referenceQueue, E e10);

        void clear();

        V get();
    }

    /* loaded from: classes3.dex */
    public static final class u<K, V, E extends h<K, V, E>> extends WeakReference<V> implements t<K, V, E> {

        /* renamed from: a, reason: collision with root package name */
        @Weak
        public final E f24510a;

        public u(ReferenceQueue<V> referenceQueue, V v10, E e10) {
            super(v10, referenceQueue);
            this.f24510a = e10;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t
        public E a() {
            return this.f24510a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t
        public t<K, V, E> b(ReferenceQueue<V> referenceQueue, E e10) {
            return new u(referenceQueue, get(), e10);
        }
    }

    /* loaded from: classes3.dex */
    public final class v extends AbstractC0817b<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final K f24511a;

        /* renamed from: b, reason: collision with root package name */
        public V f24512b;

        public v(K k10, V v10) {
            this.f24511a = k10;
            this.f24512b = v10;
        }

        @Override // com.google.common.collect.AbstractC0817b, java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!this.f24511a.equals(entry.getKey()) || !this.f24512b.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // com.google.common.collect.AbstractC0817b, java.util.Map.Entry
        public K getKey() {
            return this.f24511a;
        }

        @Override // com.google.common.collect.AbstractC0817b, java.util.Map.Entry
        public V getValue() {
            return this.f24512b;
        }

        @Override // com.google.common.collect.AbstractC0817b, java.util.Map.Entry
        public int hashCode() {
            return this.f24512b.hashCode() ^ this.f24511a.hashCode();
        }

        @Override // com.google.common.collect.AbstractC0817b, java.util.Map.Entry
        public V setValue(V v10) {
            V v11 = (V) MapMakerInternalMap.this.put(this.f24511a, v10);
            this.f24512b = v10;
            return v11;
        }
    }

    public MapMakerInternalMap(com.google.common.collect.o oVar, i<K, V, E, S> iVar) {
        this.concurrencyLevel = Math.min(oVar.b(), 65536);
        this.keyEquivalence = oVar.d();
        this.f24476d = iVar;
        int min = Math.min(oVar.c(), 1073741824);
        int i10 = 0;
        int i11 = 1;
        int i12 = 0;
        int i13 = 1;
        while (i13 < this.concurrencyLevel) {
            i12++;
            i13 <<= 1;
        }
        this.f24474b = 32 - i12;
        this.f24473a = i13 - 1;
        this.f24475c = h(i13);
        int i14 = min / i13;
        while (i11 < (i13 * i14 < min ? i14 + 1 : i14)) {
            i11 <<= 1;
        }
        while (true) {
            Segment<K, V, E, S>[] segmentArr = this.f24475c;
            if (i10 < segmentArr.length) {
                segmentArr[i10] = e(i11);
                i10++;
            } else {
                return;
            }
        }
    }

    public static <K, V> MapMakerInternalMap<K, V, ? extends h<K, V, ?>, ?> d(com.google.common.collect.o oVar) {
        Strength e10 = oVar.e();
        Strength strength = Strength.STRONG;
        if (e10 == strength && oVar.f() == strength) {
            return new MapMakerInternalMap<>(oVar, m.a.h());
        }
        if (oVar.e() == strength && oVar.f() == Strength.WEAK) {
            return new MapMakerInternalMap<>(oVar, n.a.h());
        }
        Strength e11 = oVar.e();
        Strength strength2 = Strength.WEAK;
        if (e11 == strength2 && oVar.f() == strength) {
            return new MapMakerInternalMap<>(oVar, q.a.h());
        }
        if (oVar.e() == strength2 && oVar.f() == strength2) {
            return new MapMakerInternalMap<>(oVar, r.a.h());
        }
        throw new AssertionError();
    }

    public static int k(int i10) {
        int i11 = i10 + ((i10 << 15) ^ (-12931));
        int i12 = i11 ^ (i11 >>> 10);
        int i13 = i12 + (i12 << 3);
        int i14 = i13 ^ (i13 >>> 6);
        int i15 = i14 + (i14 << 2) + (i14 << 14);
        return i15 ^ (i15 >>> 16);
    }

    public static <E> ArrayList<E> m(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        Iterators.a(arrayList, collection.iterator());
        return arrayList;
    }

    public static <K, V, E extends h<K, V, E>> t<K, V, E> n() {
        return (t<K, V, E>) f24472h;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializationProxy");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V, E, S> segment : this.f24475c) {
            segment.b();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int g10 = g(obj);
        return l(g10).d(obj, g10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [int] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.google.common.collect.MapMakerInternalMap$Segment] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>>[]] */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        boolean z10 = false;
        if (obj == null) {
            return false;
        }
        Segment<K, V, E, S>[] segmentArr = this.f24475c;
        long j10 = -1;
        int i10 = 0;
        while (i10 < 3) {
            int length = segmentArr.length;
            long j11 = 0;
            for (?? r10 = z10; r10 < length; r10++) {
                ?? r11 = segmentArr[r10];
                int i11 = r11.count;
                AtomicReferenceArray<E> atomicReferenceArray = r11.table;
                for (?? r13 = z10; r13 < atomicReferenceArray.length(); r13++) {
                    for (E e10 = atomicReferenceArray.get(r13); e10 != null; e10 = e10.a()) {
                        Object m10 = r11.m(e10);
                        if (m10 != null && valueEquivalence().d(obj, m10)) {
                            return true;
                        }
                    }
                }
                j11 += r11.modCount;
                z10 = false;
            }
            if (j11 == j10) {
                return false;
            }
            i10++;
            j10 = j11;
            z10 = false;
        }
        return z10;
    }

    public E copyEntry(E e10, E e11) {
        return l(e10.c()).e(e10, e11);
    }

    public Segment<K, V, E, S> e(int i10) {
        return this.f24476d.a(this, i10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f24479g;
        if (set == null) {
            f fVar = new f();
            this.f24479g = fVar;
            return fVar;
        }
        return set;
    }

    public V f(E e10) {
        if (e10.getKey() == null) {
            return null;
        }
        return (V) e10.getValue();
    }

    public int g(Object obj) {
        return k(this.keyEquivalence.e(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        int g10 = g(obj);
        return l(g10).i(obj, g10);
    }

    public final Segment<K, V, E, S>[] h(int i10) {
        return new Segment[i10];
    }

    public void i(E e10) {
        int c10 = e10.c();
        l(c10).w(e10, c10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V, E, S>[] segmentArr = this.f24475c;
        long j10 = 0;
        for (int i10 = 0; i10 < segmentArr.length; i10++) {
            if (segmentArr[i10].count != 0) {
                return false;
            }
            j10 += segmentArr[i10].modCount;
        }
        if (j10 == 0) {
            return true;
        }
        for (int i11 = 0; i11 < segmentArr.length; i11++) {
            if (segmentArr[i11].count != 0) {
                return false;
            }
            j10 -= segmentArr[i11].modCount;
        }
        if (j10 != 0) {
            return false;
        }
        return true;
    }

    public boolean isLiveForTesting(h<K, V, ?> hVar) {
        if (l(hVar.c()).n(hVar) != null) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void j(t<K, V, E> tVar) {
        E a10 = tVar.a();
        int c10 = a10.c();
        l(c10).x(a10.getKey(), c10, tVar);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f24477e;
        if (set == null) {
            k kVar = new k();
            this.f24477e = kVar;
            return kVar;
        }
        return set;
    }

    public Strength keyStrength() {
        return this.f24476d.c();
    }

    public Segment<K, V, E, S> l(int i10) {
        return this.f24475c[this.f24473a & (i10 >>> this.f24474b)];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k10, V v10) {
        com.google.common.base.k.o(k10);
        com.google.common.base.k.o(v10);
        int g10 = g(k10);
        return l(g10).v(k10, g10, v10, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k10, V v10) {
        com.google.common.base.k.o(k10);
        com.google.common.base.k.o(v10);
        int g10 = g(k10);
        return l(g10).v(k10, g10, v10, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int g10 = g(obj);
        return l(g10).y(obj, g10);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k10, V v10, V v11) {
        com.google.common.base.k.o(k10);
        com.google.common.base.k.o(v11);
        if (v10 == null) {
            return false;
        }
        int g10 = g(k10);
        return l(g10).C(k10, g10, v10, v11);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j10 = 0;
        for (int i10 = 0; i10 < this.f24475c.length; i10++) {
            j10 += r5[i10].count;
        }
        return com.google.common.primitives.b.b(j10);
    }

    public Equivalence<Object> valueEquivalence() {
        return this.f24476d.d().b();
    }

    public Strength valueStrength() {
        return this.f24476d.d();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.f24478f;
        if (collection == null) {
            p pVar = new p();
            this.f24478f = pVar;
            return pVar;
        }
        return collection;
    }

    public Object writeReplace() {
        return new SerializationProxy(this.f24476d.c(), this.f24476d.d(), this.keyEquivalence, this.f24476d.d().b(), this.concurrencyLevel, this);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int g10 = g(obj);
        return l(g10).z(obj, g10, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k10, V v10) {
        com.google.common.base.k.o(k10);
        com.google.common.base.k.o(v10);
        int g10 = g(k10);
        return l(g10).B(k10, g10, v10);
    }

    /* loaded from: classes3.dex */
    public static abstract class Segment<K, V, E extends h<K, V, E>, S extends Segment<K, V, E, S>> extends ReentrantLock {
        volatile int count;

        @Weak
        final MapMakerInternalMap<K, V, E, S> map;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        volatile AtomicReferenceArray<E> table;
        int threshold;

        public Segment(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i10) {
            this.map = mapMakerInternalMap;
            o(s(i10));
        }

        public static <K, V, E extends h<K, V, E>> boolean p(E e10) {
            if (e10.getValue() == null) {
                return true;
            }
            return false;
        }

        public E A(E e10, E e11) {
            int i10 = this.count;
            E e12 = (E) e11.a();
            while (e10 != e11) {
                E e13 = e(e10, e12);
                if (e13 != null) {
                    e12 = e13;
                } else {
                    i10--;
                }
                e10 = (E) e10.a();
            }
            this.count = i10;
            return e12;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public V B(K k10, int i10, V v10) {
            lock();
            try {
                u();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                h hVar = (h) atomicReferenceArray.get(length);
                for (h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.a()) {
                    Object key = hVar2.getKey();
                    if (hVar2.c() == i10 && key != null && this.map.keyEquivalence.d(k10, key)) {
                        V v11 = (V) hVar2.getValue();
                        if (v11 == null) {
                            if (p(hVar2)) {
                                this.modCount++;
                                h A10 = A(hVar, hVar2);
                                int i11 = this.count - 1;
                                atomicReferenceArray.set(length, A10);
                                this.count = i11;
                            }
                            return null;
                        }
                        this.modCount++;
                        G(hVar2, v10);
                        return v11;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean C(K k10, int i10, V v10, V v11) {
            lock();
            try {
                u();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                h hVar = (h) atomicReferenceArray.get(length);
                for (h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.a()) {
                    Object key = hVar2.getKey();
                    if (hVar2.c() == i10 && key != null && this.map.keyEquivalence.d(k10, key)) {
                        Object value = hVar2.getValue();
                        if (value == null) {
                            if (p(hVar2)) {
                                this.modCount++;
                                h A10 = A(hVar, hVar2);
                                int i11 = this.count - 1;
                                atomicReferenceArray.set(length, A10);
                                this.count = i11;
                            }
                            return false;
                        }
                        if (!this.map.valueEquivalence().d(v10, value)) {
                            return false;
                        }
                        this.modCount++;
                        G(hVar2, v11);
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        public void D() {
            E();
        }

        public void E() {
            if (tryLock()) {
                try {
                    r();
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        public abstract S F();

        public void G(E e10, V v10) {
            this.map.f24476d.e(F(), e10, v10);
        }

        public void H() {
            if (tryLock()) {
                try {
                    r();
                } finally {
                    unlock();
                }
            }
        }

        public abstract E a(h<K, V, ?> hVar);

        public void b() {
            if (this.count != 0) {
                lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    for (int i10 = 0; i10 < atomicReferenceArray.length(); i10++) {
                        atomicReferenceArray.set(i10, null);
                    }
                    q();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                    unlock();
                } catch (Throwable th) {
                    unlock();
                    throw th;
                }
            }
        }

        public <T> void c(ReferenceQueue<T> referenceQueue) {
            do {
            } while (referenceQueue.poll() != null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i10 = 0; i10 < length; i10++) {
                        for (E e10 = atomicReferenceArray.get(i10); e10 != null; e10 = e10.a()) {
                            Object m10 = m(e10);
                            if (m10 != null && this.map.valueEquivalence().d(obj, m10)) {
                                t();
                                return true;
                            }
                        }
                    }
                }
                return false;
            } finally {
                t();
            }
        }

        public boolean d(Object obj, int i10) {
            try {
                boolean z10 = false;
                if (this.count == 0) {
                    return false;
                }
                E l10 = l(obj, i10);
                if (l10 != null) {
                    if (l10.getValue() != null) {
                        z10 = true;
                    }
                }
                return z10;
            } finally {
                t();
            }
        }

        public E e(E e10, E e11) {
            return this.map.f24476d.b(F(), e10, e11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void f(ReferenceQueue<K> referenceQueue) {
            int i10 = 0;
            do {
                Reference<? extends K> poll = referenceQueue.poll();
                if (poll != null) {
                    this.map.i((h) poll);
                    i10++;
                } else {
                    return;
                }
            } while (i10 != 16);
        }

        public void g(ReferenceQueue<V> referenceQueue) {
            int i10 = 0;
            do {
                Reference<? extends V> poll = referenceQueue.poll();
                if (poll != null) {
                    this.map.j((t) poll);
                    i10++;
                } else {
                    return;
                }
            } while (i10 != 16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void h() {
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i10 = this.count;
            AtomicReferenceArray<E> atomicReferenceArray2 = (AtomicReferenceArray<E>) s(length << 1);
            this.threshold = (atomicReferenceArray2.length() * 3) / 4;
            int length2 = atomicReferenceArray2.length() - 1;
            for (int i11 = 0; i11 < length; i11++) {
                E e10 = atomicReferenceArray.get(i11);
                if (e10 != null) {
                    h a10 = e10.a();
                    int c10 = e10.c() & length2;
                    if (a10 == null) {
                        atomicReferenceArray2.set(c10, e10);
                    } else {
                        h hVar = e10;
                        while (a10 != null) {
                            int c11 = a10.c() & length2;
                            if (c11 != c10) {
                                hVar = a10;
                                c10 = c11;
                            }
                            a10 = a10.a();
                        }
                        atomicReferenceArray2.set(c10, hVar);
                        while (e10 != hVar) {
                            int c12 = e10.c() & length2;
                            h e11 = e(e10, (h) atomicReferenceArray2.get(c12));
                            if (e11 != null) {
                                atomicReferenceArray2.set(c12, e11);
                            } else {
                                i10--;
                            }
                            e10 = e10.a();
                        }
                    }
                }
            }
            this.table = atomicReferenceArray2;
            this.count = i10;
        }

        public V i(Object obj, int i10) {
            try {
                E l10 = l(obj, i10);
                if (l10 == null) {
                    t();
                    return null;
                }
                V v10 = (V) l10.getValue();
                if (v10 == null) {
                    H();
                }
                return v10;
            } finally {
                t();
            }
        }

        public E j(Object obj, int i10) {
            if (this.count != 0) {
                for (E k10 = k(i10); k10 != null; k10 = (E) k10.a()) {
                    if (k10.c() == i10) {
                        Object key = k10.getKey();
                        if (key == null) {
                            H();
                        } else if (this.map.keyEquivalence.d(obj, key)) {
                            return k10;
                        }
                    }
                }
                return null;
            }
            return null;
        }

        public E k(int i10) {
            return this.table.get(i10 & (r1.length() - 1));
        }

        public E l(Object obj, int i10) {
            return j(obj, i10);
        }

        public V m(E e10) {
            if (e10.getKey() == null) {
                H();
                return null;
            }
            V v10 = (V) e10.getValue();
            if (v10 == null) {
                H();
                return null;
            }
            return v10;
        }

        public V n(h<K, V, ?> hVar) {
            return m(a(hVar));
        }

        public void o(AtomicReferenceArray<E> atomicReferenceArray) {
            this.threshold = (atomicReferenceArray.length() * 3) / 4;
            this.table = atomicReferenceArray;
        }

        public AtomicReferenceArray<E> s(int i10) {
            return new AtomicReferenceArray<>(i10);
        }

        public void t() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                D();
            }
        }

        public void u() {
            E();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public V v(K k10, int i10, V v10, boolean z10) {
            lock();
            try {
                u();
                int i11 = this.count + 1;
                if (i11 > this.threshold) {
                    h();
                    i11 = this.count + 1;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                h hVar = (h) atomicReferenceArray.get(length);
                for (h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.a()) {
                    Object key = hVar2.getKey();
                    if (hVar2.c() == i10 && key != null && this.map.keyEquivalence.d(k10, key)) {
                        V v11 = (V) hVar2.getValue();
                        if (v11 == null) {
                            this.modCount++;
                            G(hVar2, v10);
                            this.count = this.count;
                            unlock();
                            return null;
                        }
                        if (z10) {
                            unlock();
                            return v11;
                        }
                        this.modCount++;
                        G(hVar2, v10);
                        unlock();
                        return v11;
                    }
                }
                this.modCount++;
                h f10 = this.map.f24476d.f(F(), k10, i10, hVar);
                G(f10, v10);
                atomicReferenceArray.set(length, f10);
                this.count = i11;
                unlock();
                return null;
            } catch (Throwable th) {
                unlock();
                throw th;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean w(E e10, int i10) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = i10 & (atomicReferenceArray.length() - 1);
                h hVar = (h) atomicReferenceArray.get(length);
                for (h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.a()) {
                    if (hVar2 == e10) {
                        this.modCount++;
                        h A10 = A(hVar, hVar2);
                        int i11 = this.count - 1;
                        atomicReferenceArray.set(length, A10);
                        this.count = i11;
                        return true;
                    }
                }
                unlock();
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean x(K k10, int i10, t<K, V, E> tVar) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                h hVar = (h) atomicReferenceArray.get(length);
                for (h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.a()) {
                    Object key = hVar2.getKey();
                    if (hVar2.c() == i10 && key != null && this.map.keyEquivalence.d(k10, key)) {
                        if (((s) hVar2).b() != tVar) {
                            return false;
                        }
                        this.modCount++;
                        h A10 = A(hVar, hVar2);
                        int i11 = this.count - 1;
                        atomicReferenceArray.set(length, A10);
                        this.count = i11;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public V y(Object obj, int i10) {
            lock();
            try {
                u();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                h hVar = (h) atomicReferenceArray.get(length);
                for (h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.a()) {
                    Object key = hVar2.getKey();
                    if (hVar2.c() == i10 && key != null && this.map.keyEquivalence.d(obj, key)) {
                        V v10 = (V) hVar2.getValue();
                        if (v10 == null && !p(hVar2)) {
                            return null;
                        }
                        this.modCount++;
                        h A10 = A(hVar, hVar2);
                        int i11 = this.count - 1;
                        atomicReferenceArray.set(length, A10);
                        this.count = i11;
                        return v10;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
        
            if (r8.map.valueEquivalence().d(r11, r4.getValue()) == false) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
        
            r5 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
        
            r8.modCount++;
            r9 = A(r3, r4);
            r10 = r8.count - 1;
            r0.set(r1, r9);
            r8.count = r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
        
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
        
            if (p(r4) == false) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
        
            return false;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean z(java.lang.Object r9, int r10, java.lang.Object r11) {
            /*
                r8 = this;
                r8.lock()
                r8.u()     // Catch: java.lang.Throwable -> L5c
                java.util.concurrent.atomic.AtomicReferenceArray<E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>> r0 = r8.table     // Catch: java.lang.Throwable -> L5c
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L5c
                r2 = 1
                int r1 = r1 - r2
                r1 = r1 & r10
                java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L5c
                com.google.common.collect.MapMakerInternalMap$h r3 = (com.google.common.collect.MapMakerInternalMap.h) r3     // Catch: java.lang.Throwable -> L5c
                r4 = r3
            L16:
                r5 = 0
                if (r4 == 0) goto L67
                java.lang.Object r6 = r4.getKey()     // Catch: java.lang.Throwable -> L5c
                int r7 = r4.c()     // Catch: java.lang.Throwable -> L5c
                if (r7 != r10) goto L62
                if (r6 == 0) goto L62
                com.google.common.collect.MapMakerInternalMap<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> r7 = r8.map     // Catch: java.lang.Throwable -> L5c
                com.google.common.base.Equivalence<java.lang.Object> r7 = r7.keyEquivalence     // Catch: java.lang.Throwable -> L5c
                boolean r6 = r7.d(r9, r6)     // Catch: java.lang.Throwable -> L5c
                if (r6 == 0) goto L62
                java.lang.Object r9 = r4.getValue()     // Catch: java.lang.Throwable -> L5c
                com.google.common.collect.MapMakerInternalMap<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> r10 = r8.map     // Catch: java.lang.Throwable -> L5c
                com.google.common.base.Equivalence r10 = r10.valueEquivalence()     // Catch: java.lang.Throwable -> L5c
                boolean r9 = r10.d(r11, r9)     // Catch: java.lang.Throwable -> L5c
                if (r9 == 0) goto L41
                r5 = r2
                goto L47
            L41:
                boolean r9 = p(r4)     // Catch: java.lang.Throwable -> L5c
                if (r9 == 0) goto L5e
            L47:
                int r9 = r8.modCount     // Catch: java.lang.Throwable -> L5c
                int r9 = r9 + r2
                r8.modCount = r9     // Catch: java.lang.Throwable -> L5c
                com.google.common.collect.MapMakerInternalMap$h r9 = r8.A(r3, r4)     // Catch: java.lang.Throwable -> L5c
                int r10 = r8.count     // Catch: java.lang.Throwable -> L5c
                int r10 = r10 - r2
                r0.set(r1, r9)     // Catch: java.lang.Throwable -> L5c
                r8.count = r10     // Catch: java.lang.Throwable -> L5c
                r8.unlock()
                return r5
            L5c:
                r9 = move-exception
                goto L6b
            L5e:
                r8.unlock()
                return r5
            L62:
                com.google.common.collect.MapMakerInternalMap$h r4 = r4.a()     // Catch: java.lang.Throwable -> L5c
                goto L16
            L67:
                r8.unlock()
                return r5
            L6b:
                r8.unlock()
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.Segment.z(java.lang.Object, int, java.lang.Object):boolean");
        }

        public void q() {
        }

        public void r() {
        }
    }

    /* loaded from: classes3.dex */
    public static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, m<K, V>, StrongKeyStrongValueSegment<K, V>> {
        public StrongKeyStrongValueSegment(MapMakerInternalMap<K, V, m<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i10) {
            super(mapMakerInternalMap, i10);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        public m<K, V> a(h<K, V, ?> hVar) {
            return (m) hVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* renamed from: J, reason: merged with bridge method [inline-methods] */
        public StrongKeyStrongValueSegment<K, V> F() {
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, n<K, V>, StrongKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<V> queueForValues;

        public StrongKeyWeakValueSegment(MapMakerInternalMap<K, V, n<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i10) {
            super(mapMakerInternalMap, i10);
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* renamed from: J, reason: merged with bridge method [inline-methods] */
        public n<K, V> a(h<K, V, ?> hVar) {
            return (n) hVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void q() {
            c(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void r() {
            g(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* renamed from: K, reason: merged with bridge method [inline-methods] */
        public StrongKeyWeakValueSegment<K, V> F() {
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, q<K, V>, WeakKeyStrongValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;

        public WeakKeyStrongValueSegment(MapMakerInternalMap<K, V, q<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i10) {
            super(mapMakerInternalMap, i10);
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* renamed from: J, reason: merged with bridge method [inline-methods] */
        public q<K, V> a(h<K, V, ?> hVar) {
            return (q) hVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void q() {
            c(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void r() {
            f(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* renamed from: K, reason: merged with bridge method [inline-methods] */
        public WeakKeyStrongValueSegment<K, V> F() {
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, r<K, V>, WeakKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;
        private final ReferenceQueue<V> queueForValues;

        public WeakKeyWeakValueSegment(MapMakerInternalMap<K, V, r<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i10) {
            super(mapMakerInternalMap, i10);
            this.queueForKeys = new ReferenceQueue<>();
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* renamed from: K, reason: merged with bridge method [inline-methods] */
        public r<K, V> a(h<K, V, ?> hVar) {
            return (r) hVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void q() {
            c(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void r() {
            f(this.queueForKeys);
            g(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* renamed from: L, reason: merged with bridge method [inline-methods] */
        public WeakKeyWeakValueSegment<K, V> F() {
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements t<Object, Object, d> {
        @Override // com.google.common.collect.MapMakerInternalMap.t
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public d a() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t
        public Object get() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t
        public void clear() {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public t<Object, Object, d> b(ReferenceQueue<Object> referenceQueue, d dVar) {
            return this;
        }
    }
}
