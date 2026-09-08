package X5;

import Z5.b;
import Z5.c;
import Z5.d;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import com.oplus.aiunit.core.data.ServiceType;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.jvm.internal.i;
import kotlin.text.m;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f4298a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Object> f4299b = new ConcurrentHashMap<>();

    /* JADX WARN: Code restructure failed: missing block: B:12:0x007a, code lost:
    
        if (r0 >= r5) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final com.oplus.aiunit.core.data.ServiceType a(android.content.Context r5) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.i.f(r5, r0)
            kotlin.Pair r0 = g(r5)
            java.lang.Object r1 = r0.c()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L1c
            java.lang.Object r5 = r0.d()
            com.oplus.aiunit.core.data.ServiceType r5 = (com.oplus.aiunit.core.data.ServiceType) r5
            return r5
        L1c:
            r0 = 2
            r1 = 0
            r2 = 0
            boolean r0 = j(r5, r2, r0, r1)
            boolean r1 = h(r5)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "acquireServiceType isAIUnitSupport = "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r3 = ", isOcrSupport = "
            r2.append(r3)
            r2.append(r1)
            r3 = 93
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = "AIProtocol"
            Z5.a.a(r4, r2)
            if (r0 == 0) goto L7f
            boolean r0 = Z5.c.b()
            if (r0 == 0) goto L50
            goto L7c
        L50:
            if (r1 == 0) goto L7c
            java.lang.String r0 = "com.oplus.aiunit"
            int r0 = Z5.b.g(r5, r0)
            java.lang.String r1 = "com.coloros.ocrservice"
            int r5 = Z5.b.g(r5, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "acquireServiceType [ai = "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r2 = ", ocr = "
            r1.append(r2)
            r1.append(r5)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            Z5.a.a(r4, r1)
            if (r0 < r5) goto L81
        L7c:
            com.oplus.aiunit.core.data.ServiceType r5 = com.oplus.aiunit.core.data.ServiceType.f25584b
            goto L86
        L7f:
            if (r1 == 0) goto L84
        L81:
            com.oplus.aiunit.core.data.ServiceType r5 = com.oplus.aiunit.core.data.ServiceType.f25585c
            goto L86
        L84:
            com.oplus.aiunit.core.data.ServiceType r5 = com.oplus.aiunit.core.data.ServiceType.f25583a
        L86:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: X5.a.a(android.content.Context):com.oplus.aiunit.core.data.ServiceType");
    }

    public static final int b() {
        return 201;
    }

    public static final Bundle c(Context context) {
        i.f(context, "context");
        Bundle bundle = new Bundle();
        bundle.putInt("package::sdk_version", b());
        bundle.putInt("ai::key::client_protocol", b());
        bundle.putInt("package::unit_api_level", 201);
        bundle.putString("package::sdk_version_name", "2.0.1-betaeaa25b0");
        bundle.putString("package::auth_style", d.a(context));
        bundle.putString("package::package_name", context.getPackageName());
        bundle.putInt("package::client_pid", Process.myPid());
        bundle.putInt("package::client_uid", Process.myUid());
        bundle.putBoolean("ai::key::download_enable", b.b(context));
        bundle.putString("ai::key::download_group", b.c(context));
        bundle.putLong("package::package_version", b.f(context));
        bundle.putInt("package::core_sdk_version", b.a(context));
        return bundle;
    }

    public static final ServiceType d(Context context) {
        i.f(context, "context");
        ServiceType a10 = a(context);
        ServiceType serviceType = ServiceType.f25583a;
        if (a10 != serviceType && b.h(context, a10.b())) {
            return a10;
        }
        return serviceType;
    }

    public static final int e(Context context, String compatPkg) {
        int i10;
        Integer g10;
        i.f(context, "context");
        i.f(compatPkg, "compatPkg");
        try {
            g10 = m.g(b.e(context, compatPkg, "protocol_version_codes"));
        } catch (Exception unused) {
        }
        if (g10 != null) {
            i10 = g10.intValue();
            Z5.a.c("AIProtocol", "getServiceVersion = " + i10 + " for " + compatPkg);
            return i10;
        }
        i10 = -1;
        Z5.a.c("AIProtocol", "getServiceVersion = " + i10 + " for " + compatPkg);
        return i10;
    }

    public static final boolean f(int i10) {
        if (i10 >= 130) {
            return true;
        }
        return false;
    }

    public static final Pair<Boolean, ServiceType> g(Context context) {
        i.f(context, "context");
        String packageName = context.getPackageName();
        if (i.b(packageName, "com.oplus.aiunit")) {
            return new Pair<>(Boolean.TRUE, ServiceType.f25584b);
        }
        if (i.b(packageName, "com.coloros.ocrservice")) {
            return new Pair<>(Boolean.TRUE, ServiceType.f25585c);
        }
        return new Pair<>(Boolean.FALSE, ServiceType.f25583a);
    }

    public static final boolean h(Context context) {
        i.f(context, "context");
        if (!c.a()) {
            Z5.a.b("AIProtocol", "sdk version is below P!");
            return false;
        }
        return b.i(context, "com.coloros.ocrservice");
    }

    public static final boolean i(Context context, int i10) {
        i.f(context, "context");
        if (!c.a()) {
            Z5.a.b("AIProtocol", "sdk version is below P!");
            return false;
        }
        if (b.g(context, "com.oplus.aiunit") < i10) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean j(Context context, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 400001;
        }
        return i(context, i10);
    }

    public static final boolean k(Context context, String detectName) {
        i.f(context, "context");
        i.f(detectName, "detectName");
        ServiceType a10 = a(context);
        if (a10 != ServiceType.f25583a) {
            return Y5.a.f5542a.c(context, detectName, a10);
        }
        return false;
    }
}
