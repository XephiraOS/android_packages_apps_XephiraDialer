package j9;

import com.oplus.backup.sdk.common.utils.Constants;
import io.grpc.MethodDescriptor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* compiled from: ServiceDescriptor.java */
/* loaded from: classes4.dex */
public final class L {

    /* renamed from: a, reason: collision with root package name */
    public final String f33994a;

    /* renamed from: b, reason: collision with root package name */
    public final Collection<MethodDescriptor<?, ?>> f33995b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f33996c;

    /* compiled from: ServiceDescriptor.java */
    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public String f33997a;

        /* renamed from: b, reason: collision with root package name */
        public List<MethodDescriptor<?, ?>> f33998b;

        /* renamed from: c, reason: collision with root package name */
        public Object f33999c;

        public final b e(Collection<MethodDescriptor<?, ?>> collection) {
            this.f33998b.addAll(collection);
            return this;
        }

        public b f(MethodDescriptor<?, ?> methodDescriptor) {
            this.f33998b.add((MethodDescriptor) com.google.common.base.k.p(methodDescriptor, Constants.MessagerConstants.METHOD_KEY));
            return this;
        }

        public L g() {
            return new L(this);
        }

        public b h(String str) {
            this.f33997a = (String) com.google.common.base.k.p(str, "name");
            return this;
        }

        public b i(Object obj) {
            this.f33999c = obj;
            return this;
        }

        public b(String str) {
            this.f33998b = new ArrayList();
            h(str);
        }
    }

    public static b c(String str) {
        return new b(str);
    }

    public static void d(String str, Collection<MethodDescriptor<?, ?>> collection) {
        HashSet hashSet = new HashSet(collection.size());
        for (MethodDescriptor<?, ?> methodDescriptor : collection) {
            com.google.common.base.k.p(methodDescriptor, Constants.MessagerConstants.METHOD_KEY);
            String d10 = methodDescriptor.d();
            com.google.common.base.k.l(str.equals(d10), "service names %s != %s", d10, str);
            com.google.common.base.k.k(hashSet.add(methodDescriptor.c()), "duplicate name %s", methodDescriptor.c());
        }
    }

    public Collection<MethodDescriptor<?, ?>> a() {
        return this.f33995b;
    }

    public String b() {
        return this.f33994a;
    }

    public String toString() {
        return com.google.common.base.f.c(this).d("name", this.f33994a).d("schemaDescriptor", this.f33996c).d("methods", this.f33995b).m().toString();
    }

    public L(String str, Collection<MethodDescriptor<?, ?>> collection) {
        this(c(str).e((Collection) com.google.common.base.k.p(collection, "methods")));
    }

    public L(b bVar) {
        String str = bVar.f33997a;
        this.f33994a = str;
        d(str, bVar.f33998b);
        this.f33995b = Collections.unmodifiableList(new ArrayList(bVar.f33998b));
        this.f33996c = bVar.f33999c;
    }
}
