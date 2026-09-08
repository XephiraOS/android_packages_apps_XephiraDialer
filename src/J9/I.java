package j9;

import io.grpc.MethodDescriptor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ServerServiceDefinition.java */
/* loaded from: classes4.dex */
public final class I {

    /* renamed from: a, reason: collision with root package name */
    public final L f33988a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, H<?, ?>> f33989b;

    /* compiled from: ServerServiceDefinition.java */
    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f33990a;

        /* renamed from: b, reason: collision with root package name */
        public final L f33991b;

        /* renamed from: c, reason: collision with root package name */
        public final Map<String, H<?, ?>> f33992c;

        public <ReqT, RespT> b a(MethodDescriptor<ReqT, RespT> methodDescriptor, io.grpc.B<ReqT, RespT> b10) {
            return b(H.a((MethodDescriptor) com.google.common.base.k.p(methodDescriptor, "method must not be null"), (io.grpc.B) com.google.common.base.k.p(b10, "handler must not be null")));
        }

        public <ReqT, RespT> b b(H<ReqT, RespT> h10) {
            MethodDescriptor<ReqT, RespT> b10 = h10.b();
            com.google.common.base.k.l(this.f33990a.equals(b10.d()), "Method name should be prefixed with service name and separated with '/'. Expected service name: '%s'. Actual fully qualifed method name: '%s'.", this.f33990a, b10.c());
            String c10 = b10.c();
            com.google.common.base.k.x(!this.f33992c.containsKey(c10), "Method by same name already registered: %s", c10);
            this.f33992c.put(c10, h10);
            return this;
        }

        public I c() {
            L l10 = this.f33991b;
            if (l10 == null) {
                ArrayList arrayList = new ArrayList(this.f33992c.size());
                Iterator<H<?, ?>> it = this.f33992c.values().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().b());
                }
                l10 = new L(this.f33990a, arrayList);
            }
            HashMap hashMap = new HashMap(this.f33992c);
            for (MethodDescriptor<?, ?> methodDescriptor : l10.a()) {
                H h10 = (H) hashMap.remove(methodDescriptor.c());
                if (h10 != null) {
                    if (h10.b() != methodDescriptor) {
                        throw new IllegalStateException("Bound method for " + methodDescriptor.c() + " not same instance as method in service descriptor");
                    }
                } else {
                    throw new IllegalStateException("No method bound for descriptor entry " + methodDescriptor.c());
                }
            }
            if (hashMap.size() <= 0) {
                return new I(l10, this.f33992c);
            }
            throw new IllegalStateException("No entry in descriptor matching bound method " + ((H) hashMap.values().iterator().next()).b().c());
        }

        public b(L l10) {
            this.f33992c = new HashMap();
            this.f33991b = (L) com.google.common.base.k.p(l10, "serviceDescriptor");
            this.f33990a = l10.b();
        }
    }

    public static b a(L l10) {
        return new b(l10);
    }

    public Collection<H<?, ?>> b() {
        return this.f33989b.values();
    }

    public L c() {
        return this.f33988a;
    }

    public I(L l10, Map<String, H<?, ?>> map) {
        this.f33988a = (L) com.google.common.base.k.p(l10, "serviceDescriptor");
        this.f33989b = Collections.unmodifiableMap(new HashMap(map));
    }
}
