package io.grpc.util;

import com.google.common.base.k;
import io.grpc.ConnectivityState;
import io.grpc.q;
import io.grpc.util.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class RoundRobinLoadBalancer extends f {

    /* renamed from: m, reason: collision with root package name */
    public final AtomicInteger f33518m;

    /* renamed from: n, reason: collision with root package name */
    public q.j f33519n;

    /* loaded from: classes4.dex */
    public static final class EmptyPicker extends q.j {
        @Override // io.grpc.q.j
        public q.f a(q.g gVar) {
            return q.f.g();
        }

        public boolean equals(Object obj) {
            return obj instanceof EmptyPicker;
        }

        public int hashCode() {
            return EmptyPicker.class.hashCode();
        }
    }

    /* loaded from: classes4.dex */
    public static class ReadyPicker extends q.j {

        /* renamed from: a, reason: collision with root package name */
        public final List<q.j> f33520a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicInteger f33521b;

        /* renamed from: c, reason: collision with root package name */
        public final int f33522c;

        public ReadyPicker(List<q.j> list, AtomicInteger atomicInteger) {
            k.e(!list.isEmpty(), "empty list");
            this.f33520a = list;
            this.f33521b = (AtomicInteger) k.p(atomicInteger, "index");
            Iterator<q.j> it = list.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                i10 += it.next().hashCode();
            }
            this.f33522c = i10;
        }

        @Override // io.grpc.q.j
        public q.f a(q.g gVar) {
            return this.f33520a.get(b()).a(gVar);
        }

        public final int b() {
            return (this.f33521b.getAndIncrement() & Integer.MAX_VALUE) % this.f33520a.size();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ReadyPicker)) {
                return false;
            }
            ReadyPicker readyPicker = (ReadyPicker) obj;
            if (readyPicker == this) {
                return true;
            }
            if (this.f33522c != readyPicker.f33522c || this.f33521b != readyPicker.f33521b || this.f33520a.size() != readyPicker.f33520a.size() || !new HashSet(this.f33520a).containsAll(readyPicker.f33520a)) {
                return false;
            }
            return true;
        }

        public List<q.j> getSubchannelPickers() {
            return this.f33520a;
        }

        public int hashCode() {
            return this.f33522c;
        }

        public String toString() {
            return com.google.common.base.f.b(ReadyPicker.class).d("subchannelPickers", this.f33520a).toString();
        }
    }

    public RoundRobinLoadBalancer(q.e eVar) {
        super(eVar);
        this.f33518m = new AtomicInteger(new Random().nextInt());
        this.f33519n = new EmptyPicker();
    }

    private void y(ConnectivityState connectivityState, q.j jVar) {
        if (connectivityState != this.f33540k || !jVar.equals(this.f33519n)) {
            p().f(connectivityState, jVar);
            this.f33540k = connectivityState;
            this.f33519n = jVar;
        }
    }

    @Override // io.grpc.util.f
    public q.j s(Map<Object, q.j> map) {
        throw new UnsupportedOperationException();
    }

    @Override // io.grpc.util.f
    public void w() {
        List<f.c> r10 = r();
        if (r10.isEmpty()) {
            Iterator<f.c> it = getChildLbStates().iterator();
            while (it.hasNext()) {
                ConnectivityState k10 = it.next().k();
                ConnectivityState connectivityState = ConnectivityState.CONNECTING;
                if (k10 == connectivityState || k10 == ConnectivityState.IDLE) {
                    y(connectivityState, new EmptyPicker());
                    return;
                }
            }
            y(ConnectivityState.TRANSIENT_FAILURE, x(getChildLbStates()));
            return;
        }
        y(ConnectivityState.READY, x(r10));
    }

    public q.j x(Collection<f.c> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator<f.c> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().j());
        }
        return new ReadyPicker(arrayList, this.f33518m);
    }
}
