package io.grpc;

import io.grpc.C1107a;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: EquivalentAddressGroup.java */
/* renamed from: io.grpc.h, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1114h {

    /* renamed from: d, reason: collision with root package name */
    public static final C1107a.c<String> f32449d = C1107a.c.a("io.grpc.EquivalentAddressGroup.ATTR_AUTHORITY_OVERRIDE");

    /* renamed from: a, reason: collision with root package name */
    public final List<SocketAddress> f32450a;

    /* renamed from: b, reason: collision with root package name */
    public final C1107a f32451b;

    /* renamed from: c, reason: collision with root package name */
    public final int f32452c;

    public C1114h(List<SocketAddress> list, C1107a c1107a) {
        com.google.common.base.k.e(!list.isEmpty(), "addrs is empty");
        List<SocketAddress> unmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.f32450a = unmodifiableList;
        this.f32451b = (C1107a) com.google.common.base.k.p(c1107a, "attrs");
        this.f32452c = unmodifiableList.hashCode();
    }

    public List<SocketAddress> a() {
        return this.f32450a;
    }

    public C1107a b() {
        return this.f32451b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1114h)) {
            return false;
        }
        C1114h c1114h = (C1114h) obj;
        if (this.f32450a.size() != c1114h.f32450a.size()) {
            return false;
        }
        for (int i10 = 0; i10 < this.f32450a.size(); i10++) {
            if (!this.f32450a.get(i10).equals(c1114h.f32450a.get(i10))) {
                return false;
            }
        }
        if (this.f32451b.equals(c1114h.f32451b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f32452c;
    }

    public String toString() {
        return "[" + this.f32450a + "/" + this.f32451b + "]";
    }

    public C1114h(SocketAddress socketAddress) {
        this(socketAddress, C1107a.f32411c);
    }

    public C1114h(SocketAddress socketAddress, C1107a c1107a) {
        this((List<SocketAddress>) Collections.singletonList(socketAddress), c1107a);
    }
}
