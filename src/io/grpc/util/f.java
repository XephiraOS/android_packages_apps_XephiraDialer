package io.grpc.util;

import com.google.common.base.k;
import com.google.common.collect.C;
import com.google.common.collect.ImmutableList;
import io.grpc.C1107a;
import io.grpc.C1114h;
import io.grpc.ConnectivityState;
import io.grpc.Status;
import io.grpc.internal.X;
import io.grpc.q;
import io.grpc.r;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: MultiChildLoadBalancer.java */
/* loaded from: classes4.dex */
public abstract class f extends q {

    /* renamed from: l, reason: collision with root package name */
    public static final Logger f33535l = Logger.getLogger(f.class.getName());

    /* renamed from: h, reason: collision with root package name */
    public final q.e f33537h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f33538i;

    /* renamed from: k, reason: collision with root package name */
    public ConnectivityState f33540k;

    /* renamed from: g, reason: collision with root package name */
    public final Map<Object, c> f33536g = new LinkedHashMap();

    /* renamed from: j, reason: collision with root package name */
    public final r f33539j = new X();

    /* compiled from: MultiChildLoadBalancer.java */
    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Status f33541a;

        /* renamed from: b, reason: collision with root package name */
        public final List<c> f33542b;

        public b(Status status, List<c> list) {
            this.f33541a = status;
            this.f33542b = list;
        }
    }

    /* compiled from: MultiChildLoadBalancer.java */
    /* loaded from: classes4.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public final Object f33543a;

        /* renamed from: b, reason: collision with root package name */
        public q.h f33544b;

        /* renamed from: c, reason: collision with root package name */
        public final Object f33545c;

        /* renamed from: d, reason: collision with root package name */
        public final e f33546d;

        /* renamed from: e, reason: collision with root package name */
        public final r f33547e;

        /* renamed from: f, reason: collision with root package name */
        public ConnectivityState f33548f;

        /* renamed from: g, reason: collision with root package name */
        public q.j f33549g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f33550h;

        /* compiled from: MultiChildLoadBalancer.java */
        /* loaded from: classes4.dex */
        public final class a extends io.grpc.util.c {
            public a() {
            }

            @Override // io.grpc.util.c, io.grpc.q.e
            public void f(ConnectivityState connectivityState, q.j jVar) {
                if (f.this.f33536g.containsKey(c.this.f33543a)) {
                    c.this.f33548f = connectivityState;
                    c.this.f33549g = jVar;
                    if (!c.this.f33550h) {
                        f fVar = f.this;
                        if (!fVar.f33538i) {
                            if (connectivityState == ConnectivityState.IDLE && fVar.u()) {
                                c.this.f33546d.e();
                            }
                            f.this.w();
                        }
                    }
                }
            }

            @Override // io.grpc.util.c
            public q.e g() {
                return f.this.f33537h;
            }
        }

        public c(f fVar, Object obj, r rVar, Object obj2, q.j jVar) {
            this(obj, rVar, obj2, jVar, null, false);
        }

        public q.h getResolvedAddresses() {
            return this.f33544b;
        }

        public void h() {
            if (this.f33550h) {
                return;
            }
            f.this.f33536g.remove(this.f33543a);
            this.f33550h = true;
            f.f33535l.log(Level.FINE, "Child balancer {0} deactivated", this.f33543a);
        }

        public Object i() {
            return this.f33545c;
        }

        public q.j j() {
            return this.f33549g;
        }

        public ConnectivityState k() {
            return this.f33548f;
        }

        public r l() {
            return this.f33547e;
        }

        public boolean m() {
            return this.f33550h;
        }

        public void n(r rVar) {
            this.f33550h = false;
        }

        public void o(q.h hVar) {
            k.p(hVar, "Missing address list for child");
            this.f33544b = hVar;
        }

        public void p() {
            this.f33546d.f();
            this.f33548f = ConnectivityState.SHUTDOWN;
            f.f33535l.log(Level.FINE, "Child balancer {0} deleted", this.f33543a);
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("Address = ");
            sb.append(this.f33543a);
            sb.append(", state = ");
            sb.append(this.f33548f);
            sb.append(", picker type: ");
            sb.append(this.f33549g.getClass());
            sb.append(", lb: ");
            sb.append(this.f33546d.g().getClass());
            if (this.f33550h) {
                str = ", deactivated";
            } else {
                str = "";
            }
            sb.append(str);
            return sb.toString();
        }

        public c(Object obj, r rVar, Object obj2, q.j jVar, q.h hVar, boolean z10) {
            this.f33543a = obj;
            this.f33547e = rVar;
            this.f33550h = z10;
            this.f33549g = jVar;
            this.f33545c = obj2;
            e eVar = new e(new a());
            this.f33546d = eVar;
            this.f33548f = z10 ? ConnectivityState.IDLE : ConnectivityState.CONNECTING;
            this.f33544b = hVar;
            if (z10) {
                return;
            }
            eVar.r(rVar);
        }
    }

    /* compiled from: MultiChildLoadBalancer.java */
    /* loaded from: classes4.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final String[] f33553a;

        /* renamed from: b, reason: collision with root package name */
        public final int f33554b;

        public d(C1114h c1114h) {
            k.p(c1114h, "eag");
            this.f33553a = new String[c1114h.a().size()];
            Iterator<SocketAddress> it = c1114h.a().iterator();
            int i10 = 0;
            while (it.hasNext()) {
                this.f33553a[i10] = it.next().toString();
                i10++;
            }
            Arrays.sort(this.f33553a);
            this.f33554b = Arrays.hashCode(this.f33553a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (dVar.f33554b == this.f33554b) {
                String[] strArr = dVar.f33553a;
                int length = strArr.length;
                String[] strArr2 = this.f33553a;
                if (length == strArr2.length) {
                    return Arrays.equals(strArr, strArr2);
                }
            }
            return false;
        }

        public int hashCode() {
            return this.f33554b;
        }

        public String toString() {
            return Arrays.toString(this.f33553a);
        }
    }

    public f(q.e eVar) {
        this.f33537h = (q.e) k.p(eVar, "helper");
        f33535l.log(Level.FINE, "Created");
    }

    public static ConnectivityState k(ConnectivityState connectivityState, ConnectivityState connectivityState2) {
        if (connectivityState == null) {
            return connectivityState2;
        }
        ConnectivityState connectivityState3 = ConnectivityState.READY;
        if (connectivityState != connectivityState3 && connectivityState2 != connectivityState3 && connectivityState != (connectivityState3 = ConnectivityState.CONNECTING) && connectivityState2 != connectivityState3 && connectivityState != (connectivityState3 = ConnectivityState.IDLE) && connectivityState2 != connectivityState3) {
            return connectivityState;
        }
        return connectivityState3;
    }

    @Override // io.grpc.q
    public Status a(q.h hVar) {
        try {
            this.f33538i = true;
            b g10 = g(hVar);
            if (!g10.f33541a.o()) {
                return g10.f33541a;
            }
            w();
            v(g10.f33542b);
            return g10.f33541a;
        } finally {
            this.f33538i = false;
        }
    }

    @Override // io.grpc.q
    public void c(Status status) {
        if (this.f33540k != ConnectivityState.READY) {
            this.f33537h.f(ConnectivityState.TRANSIENT_FAILURE, o(status));
        }
    }

    @Override // io.grpc.q
    public void f() {
        f33535l.log(Level.INFO, "Shutdown");
        Iterator<c> it = this.f33536g.values().iterator();
        while (it.hasNext()) {
            it.next().p();
        }
        this.f33536g.clear();
    }

    public b g(q.h hVar) {
        f33535l.log(Level.FINE, "Received resolution result: {0}", hVar);
        Map<Object, c> l10 = l(hVar);
        if (l10.isEmpty()) {
            Status r10 = Status.f32383t.r("NameResolver returned no usable address. " + hVar);
            c(r10);
            return new b(r10, null);
        }
        for (Map.Entry<Object, c> entry : l10.entrySet()) {
            Object key = entry.getKey();
            r l11 = entry.getValue().l();
            Object i10 = entry.getValue().i();
            if (!this.f33536g.containsKey(key)) {
                this.f33536g.put(key, entry.getValue());
            } else {
                c cVar = this.f33536g.get(key);
                if (cVar.m() && t()) {
                    cVar.n(l11);
                }
            }
            c cVar2 = this.f33536g.get(key);
            q.h n10 = n(key, hVar, i10);
            this.f33536g.get(key).o(n10);
            if (!cVar2.f33550h) {
                cVar2.f33546d.d(n10);
            }
        }
        ArrayList arrayList = new ArrayList();
        C it = ImmutableList.o(this.f33536g.keySet()).iterator();
        while (it.hasNext()) {
            E next = it.next();
            if (!l10.containsKey(next)) {
                c cVar3 = this.f33536g.get(next);
                cVar3.h();
                arrayList.add(cVar3);
            }
        }
        return new b(Status.f32368e, arrayList);
    }

    public Collection<c> getChildLbStates() {
        return this.f33536g.values();
    }

    public Map<Object, c> l(q.h hVar) {
        HashMap hashMap = new HashMap();
        Iterator<C1114h> it = hVar.a().iterator();
        while (it.hasNext()) {
            d dVar = new d(it.next());
            c cVar = this.f33536g.get(dVar);
            if (cVar != null) {
                hashMap.put(dVar, cVar);
            } else {
                hashMap.put(dVar, m(dVar, null, q(), hVar));
            }
        }
        return hashMap;
    }

    public c m(Object obj, Object obj2, q.j jVar, q.h hVar) {
        return new c(this, obj, this.f33539j, obj2, jVar);
    }

    public q.h n(Object obj, q.h hVar, Object obj2) {
        d dVar;
        C1114h c1114h;
        if (obj instanceof C1114h) {
            dVar = new d((C1114h) obj);
        } else {
            k.e(obj instanceof d, "key is wrong type");
            dVar = (d) obj;
        }
        Iterator<C1114h> it = hVar.a().iterator();
        while (true) {
            if (it.hasNext()) {
                c1114h = it.next();
                if (dVar.equals(new d(c1114h))) {
                    break;
                }
            } else {
                c1114h = null;
                break;
            }
        }
        k.p(c1114h, obj + " no longer present in load balancer children");
        return hVar.e().b(Collections.singletonList(c1114h)).c(C1107a.c().d(q.f33437e, Boolean.TRUE).a()).d(obj2).a();
    }

    public q.j o(Status status) {
        return new q.d(q.f.f(status));
    }

    public q.e p() {
        return this.f33537h;
    }

    public q.j q() {
        return new q.d(q.f.g());
    }

    public List<c> r() {
        ArrayList arrayList = new ArrayList();
        for (c cVar : getChildLbStates()) {
            if (!cVar.m() && cVar.k() == ConnectivityState.READY) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public abstract q.j s(Map<Object, q.j> map);

    public boolean t() {
        return true;
    }

    public boolean u() {
        return true;
    }

    public void v(List<c> list) {
        Iterator<c> it = list.iterator();
        while (it.hasNext()) {
            it.next().p();
        }
    }

    public void w() {
        HashMap hashMap = new HashMap();
        ConnectivityState connectivityState = null;
        for (c cVar : getChildLbStates()) {
            if (!cVar.f33550h) {
                hashMap.put(cVar.f33543a, cVar.f33549g);
                connectivityState = k(connectivityState, cVar.f33548f);
            }
        }
        if (connectivityState != null) {
            this.f33537h.f(connectivityState, s(hashMap));
            this.f33540k = connectivityState;
        }
    }
}
