package com.google.common.collect;

import java.lang.Comparable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class TreeRangeSet$RangesByUpperBound<C extends Comparable<?>> extends AbstractC0819d<Cut<C>, Range<C>> {

    /* renamed from: a, reason: collision with root package name */
    public final NavigableMap<Cut<C>, Range<C>> f24561a;

    /* renamed from: b, reason: collision with root package name */
    public final Range<Cut<C>> f24562b;

    /* loaded from: classes3.dex */
    public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Iterator f24563c;

        public a(Iterator it) {
            this.f24563c = it;
        }

        @Override // com.google.common.collect.AbstractIterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry<Cut<C>, Range<C>> a() {
            if (!this.f24563c.hasNext()) {
                return (Map.Entry) b();
            }
            Range range = (Range) this.f24563c.next();
            if (TreeRangeSet$RangesByUpperBound.this.f24562b.upperBound.i(range.upperBound)) {
                return (Map.Entry) b();
            }
            return Maps.c(range.upperBound, range);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ u f24565c;

        public b(u uVar) {
            this.f24565c = uVar;
        }

        @Override // com.google.common.collect.AbstractIterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry<Cut<C>, Range<C>> a() {
            if (!this.f24565c.hasNext()) {
                return (Map.Entry) b();
            }
            Range range = (Range) this.f24565c.next();
            if (TreeRangeSet$RangesByUpperBound.this.f24562b.lowerBound.i(range.upperBound)) {
                return Maps.c(range.upperBound, range);
            }
            return (Map.Entry) b();
        }
    }

    public TreeRangeSet$RangesByUpperBound(NavigableMap<Cut<C>, Range<C>> navigableMap, Range<Cut<C>> range) {
        this.f24561a = navigableMap;
        this.f24562b = range;
    }

    @Override // com.google.common.collect.Maps.e
    public Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
        Iterator<Range<C>> it;
        if (!this.f24562b.i()) {
            it = this.f24561a.values().iterator();
        } else {
            Map.Entry<Cut<C>, Range<C>> lowerEntry = this.f24561a.lowerEntry(this.f24562b.n());
            if (lowerEntry == null) {
                it = this.f24561a.values().iterator();
            } else if (this.f24562b.lowerBound.i(lowerEntry.getValue().upperBound)) {
                it = this.f24561a.tailMap(lowerEntry.getKey(), true).values().iterator();
            } else {
                it = this.f24561a.tailMap(this.f24562b.n(), true).values().iterator();
            }
        }
        return new a(it);
    }

    @Override // java.util.SortedMap
    public Comparator<? super Cut<C>> comparator() {
        return Ordering.c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (get(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractC0819d
    public Iterator<Map.Entry<Cut<C>, Range<C>>> d() {
        Collection<Range<C>> values;
        if (this.f24562b.j()) {
            values = this.f24561a.headMap(this.f24562b.r(), false).descendingMap().values();
        } else {
            values = this.f24561a.descendingMap().values();
        }
        u f10 = Iterators.f(values.iterator());
        if (f10.hasNext() && this.f24562b.upperBound.i(((Range) f10.peek()).upperBound)) {
            f10.next();
        }
        return new b(f10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Range<C> get(Object obj) {
        Map.Entry<Cut<C>, Range<C>> lowerEntry;
        if (obj instanceof Cut) {
            try {
                Cut<C> cut = (Cut) obj;
                if (this.f24562b.e(cut) && (lowerEntry = this.f24561a.lowerEntry(cut)) != null && lowerEntry.getValue().upperBound.equals(cut)) {
                    return lowerEntry.getValue();
                }
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    @Override // java.util.NavigableMap
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z10) {
        return i(Range.q(cut, BoundType.b(z10)));
    }

    @Override // java.util.NavigableMap
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z10, Cut<C> cut2, boolean z11) {
        return i(Range.o(cut, BoundType.b(z10), cut2, BoundType.b(z11)));
    }

    public final NavigableMap<Cut<C>, Range<C>> i(Range<Cut<C>> range) {
        if (range.l(this.f24562b)) {
            return new TreeRangeSet$RangesByUpperBound(this.f24561a, range.k(this.f24562b));
        }
        return ImmutableSortedMap.y();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        if (this.f24562b.equals(Range.a())) {
            return this.f24561a.isEmpty();
        }
        if (!b().hasNext()) {
            return true;
        }
        return false;
    }

    @Override // java.util.NavigableMap
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z10) {
        return i(Range.g(cut, BoundType.b(z10)));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        if (this.f24562b.equals(Range.a())) {
            return this.f24561a.size();
        }
        return Iterators.j(b());
    }
}
