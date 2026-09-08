package io.grpc.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: InternalHandlerRegistry.java */
/* loaded from: classes4.dex */
public final class G extends j9.s {

    /* renamed from: a, reason: collision with root package name */
    public final List<j9.I> f32516a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, j9.H<?, ?>> f32517b;

    /* compiled from: InternalHandlerRegistry.java */
    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final HashMap<String, j9.I> f32518a = new LinkedHashMap();

        public b a(j9.I i10) {
            this.f32518a.put(i10.c().b(), i10);
            return this;
        }

        public G b() {
            HashMap hashMap = new HashMap();
            Iterator<j9.I> it = this.f32518a.values().iterator();
            while (it.hasNext()) {
                for (j9.H<?, ?> h10 : it.next().b()) {
                    hashMap.put(h10.b().c(), h10);
                }
            }
            return new G(Collections.unmodifiableList(new ArrayList(this.f32518a.values())), Collections.unmodifiableMap(hashMap));
        }
    }

    @Override // j9.s
    public j9.H<?, ?> b(String str, String str2) {
        return this.f32517b.get(str);
    }

    public G(List<j9.I> list, Map<String, j9.H<?, ?>> map) {
        this.f32516a = list;
        this.f32517b = map;
    }
}
