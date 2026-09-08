package io.grpc;

import com.heytap.accessory.constant.AFConstants;
import io.grpc.q;
import io.grpc.v;
import java.util.Map;

/* compiled from: LoadBalancerProvider.java */
/* loaded from: classes4.dex */
public abstract class r extends q.c {

    /* renamed from: a, reason: collision with root package name */
    public static final v.c f33460a = v.c.a(new a());

    /* compiled from: LoadBalancerProvider.java */
    /* loaded from: classes4.dex */
    public static final class a {
        public String toString() {
            return "service config is unused";
        }
    }

    public abstract String b();

    public abstract int c();

    public abstract boolean d();

    public v.c e(Map<String, ?> map) {
        return f33460a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final String toString() {
        return com.google.common.base.f.c(this).d("policy", b()).b(AFConstants.EXTRA_PRIORITY, c()).e("available", d()).toString();
    }
}
