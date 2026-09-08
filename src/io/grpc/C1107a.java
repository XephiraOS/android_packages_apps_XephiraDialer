package io.grpc;

import java.util.IdentityHashMap;
import java.util.Map;

/* compiled from: Attributes.java */
/* renamed from: io.grpc.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1107a {

    /* renamed from: b, reason: collision with root package name */
    public static final IdentityHashMap<c<?>, Object> f32410b;

    /* renamed from: c, reason: collision with root package name */
    public static final C1107a f32411c;

    /* renamed from: a, reason: collision with root package name */
    public final IdentityHashMap<c<?>, Object> f32412a;

    /* compiled from: Attributes.java */
    /* renamed from: io.grpc.a$b */
    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public C1107a f32413a;

        /* renamed from: b, reason: collision with root package name */
        public IdentityHashMap<c<?>, Object> f32414b;

        public C1107a a() {
            if (this.f32414b != null) {
                for (Map.Entry entry : this.f32413a.f32412a.entrySet()) {
                    if (!this.f32414b.containsKey(entry.getKey())) {
                        this.f32414b.put((c) entry.getKey(), entry.getValue());
                    }
                }
                this.f32413a = new C1107a(this.f32414b);
                this.f32414b = null;
            }
            return this.f32413a;
        }

        public final IdentityHashMap<c<?>, Object> b(int i10) {
            if (this.f32414b == null) {
                this.f32414b = new IdentityHashMap<>(i10);
            }
            return this.f32414b;
        }

        public <T> b c(c<T> cVar) {
            if (this.f32413a.f32412a.containsKey(cVar)) {
                IdentityHashMap identityHashMap = new IdentityHashMap(this.f32413a.f32412a);
                identityHashMap.remove(cVar);
                this.f32413a = new C1107a(identityHashMap);
            }
            IdentityHashMap<c<?>, Object> identityHashMap2 = this.f32414b;
            if (identityHashMap2 != null) {
                identityHashMap2.remove(cVar);
            }
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <T> b d(c<T> cVar, T t10) {
            b(1).put(cVar, t10);
            return this;
        }

        public b(C1107a c1107a) {
            this.f32413a = c1107a;
        }
    }

    /* compiled from: Attributes.java */
    /* renamed from: io.grpc.a$c */
    /* loaded from: classes4.dex */
    public static final class c<T> {

        /* renamed from: a, reason: collision with root package name */
        public final String f32415a;

        public c(String str) {
            this.f32415a = str;
        }

        public static <T> c<T> a(String str) {
            return new c<>(str);
        }

        public String toString() {
            return this.f32415a;
        }
    }

    static {
        IdentityHashMap<c<?>, Object> identityHashMap = new IdentityHashMap<>();
        f32410b = identityHashMap;
        f32411c = new C1107a(identityHashMap);
    }

    public static b c() {
        return new b();
    }

    public <T> T b(c<T> cVar) {
        return (T) this.f32412a.get(cVar);
    }

    public b d() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1107a.class != obj.getClass()) {
            return false;
        }
        C1107a c1107a = (C1107a) obj;
        if (this.f32412a.size() != c1107a.f32412a.size()) {
            return false;
        }
        for (Map.Entry<c<?>, Object> entry : this.f32412a.entrySet()) {
            if (!c1107a.f32412a.containsKey(entry.getKey()) || !com.google.common.base.h.a(entry.getValue(), c1107a.f32412a.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i10 = 0;
        for (Map.Entry<c<?>, Object> entry : this.f32412a.entrySet()) {
            i10 += com.google.common.base.h.b(entry.getKey(), entry.getValue());
        }
        return i10;
    }

    public String toString() {
        return this.f32412a.toString();
    }

    public C1107a(IdentityHashMap<c<?>, Object> identityHashMap) {
        this.f32412a = identityHashMap;
    }
}
