package androidx.lifecycle;

import java.util.Iterator;
import java.util.Map;
import l.C1286b;

/* compiled from: MediatorLiveData.java */
/* loaded from: classes.dex */
public class t<T> extends v<T> {

    /* renamed from: l, reason: collision with root package name */
    public C1286b<LiveData<?>, a<?>> f10384l = new C1286b<>();

    /* compiled from: MediatorLiveData.java */
    /* loaded from: classes.dex */
    public static class a<V> implements w<V> {

        /* renamed from: a, reason: collision with root package name */
        public final LiveData<V> f10385a;

        /* renamed from: b, reason: collision with root package name */
        public final w<? super V> f10386b;

        /* renamed from: c, reason: collision with root package name */
        public int f10387c = -1;

        public a(LiveData<V> liveData, w<? super V> wVar) {
            this.f10385a = liveData;
            this.f10386b = wVar;
        }

        public void a() {
            this.f10385a.j(this);
        }

        public void b() {
            this.f10385a.n(this);
        }

        @Override // androidx.lifecycle.w
        public void onChanged(V v10) {
            if (this.f10387c != this.f10385a.e()) {
                this.f10387c = this.f10385a.e();
                this.f10386b.onChanged(v10);
            }
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void k() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it = this.f10384l.iterator();
        while (it.hasNext()) {
            it.next().getValue().a();
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void l() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it = this.f10384l.iterator();
        while (it.hasNext()) {
            it.next().getValue().b();
        }
    }

    public <S> void p(LiveData<S> liveData, w<? super S> wVar) {
        if (liveData != null) {
            a<?> aVar = new a<>(liveData, wVar);
            a<?> i10 = this.f10384l.i(liveData, aVar);
            if (i10 != null && i10.f10386b != wVar) {
                throw new IllegalArgumentException("This source was already added with the different observer");
            }
            if (i10 == null && f()) {
                aVar.a();
                return;
            }
            return;
        }
        throw new NullPointerException("source cannot be null");
    }

    public <S> void q(LiveData<S> liveData) {
        a<?> j10 = this.f10384l.j(liveData);
        if (j10 != null) {
            j10.b();
        }
    }
}
