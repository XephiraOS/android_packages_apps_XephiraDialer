package s3;

import p.C1415a;

/* compiled from: CachedHashCodeArrayMap.java */
/* renamed from: s3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1531b<K, V> extends C1415a<K, V> {

    /* renamed from: g, reason: collision with root package name */
    public int f36754g;

    @Override // p.i, java.util.Map
    public void clear() {
        this.f36754g = 0;
        super.clear();
    }

    @Override // p.i, java.util.Map
    public int hashCode() {
        if (this.f36754g == 0) {
            this.f36754g = super.hashCode();
        }
        return this.f36754g;
    }

    @Override // p.i
    public void i(p.i<? extends K, ? extends V> iVar) {
        this.f36754g = 0;
        super.i(iVar);
    }

    @Override // p.i
    public V j(int i10) {
        this.f36754g = 0;
        return (V) super.j(i10);
    }

    @Override // p.i
    public V k(int i10, V v10) {
        this.f36754g = 0;
        return (V) super.k(i10, v10);
    }

    @Override // p.i, java.util.Map
    public V put(K k10, V v10) {
        this.f36754g = 0;
        return (V) super.put(k10, v10);
    }
}
