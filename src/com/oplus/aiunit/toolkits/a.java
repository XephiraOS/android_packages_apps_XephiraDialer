package com.oplus.aiunit.toolkits;

import Y5.a;
import android.content.Context;
import android.os.Bundle;
import com.oplus.aiunit.core.data.ServiceType;
import kotlin.jvm.internal.i;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a */
    public static final a f25732a = new a();

    public static /* synthetic */ Bundle b(a aVar, Context context, Bundle bundle, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bundle = null;
        }
        return aVar.a(context, bundle);
    }

    public static final int c(Context context, String detectName) {
        i.f(context, "context");
        i.f(detectName, "detectName");
        ServiceType d10 = X5.a.d(context);
        if (d10 == ServiceType.f25583a) {
            return -1;
        }
        Bundle b10 = b(f25732a, context, null, 2, null);
        b10.putString("package::unit_name", detectName);
        b10.putString("ai::key::method_call", "ai::value::get_authorize_status");
        Bundle b11 = a.C0086a.b(Y5.a.f5542a, context, d10, null, b10, null, 16, null);
        if (b11 == null) {
            return -1;
        }
        return b11.getInt("ai::key::authorize_status", -1);
    }

    public static final com.oplus.aiunit.core.data.a d(Context context, String detectName, Bundle bundle) {
        com.oplus.aiunit.core.data.a aVar;
        i.f(context, "context");
        i.f(detectName, "detectName");
        ServiceType a10 = X5.a.a(context);
        if (a10 != ServiceType.f25583a) {
            if (X5.a.f(X5.a.e(context, a10.b()))) {
                Bundle a11 = f25732a.a(context, bundle);
                a11.putString("package::unit_name", detectName);
                a11.putString("ai::key::method_call", "ai::value::get_detect_data");
                Bundle b10 = a.C0086a.b(Y5.a.f5542a, context, a10, null, a11, null, 16, null);
                if (b10 == null) {
                    b10 = new Bundle();
                }
                aVar = new com.oplus.aiunit.core.data.a(detectName, b10);
            } else if (X5.a.k(context, detectName)) {
                aVar = new com.oplus.aiunit.core.data.a(detectName, true);
            } else {
                aVar = new com.oplus.aiunit.core.data.a(detectName, false);
            }
        } else {
            aVar = new com.oplus.aiunit.core.data.a(detectName, false);
        }
        Z5.a.c("AISettings", "getDetectData: " + aVar);
        return aVar;
    }

    public static /* synthetic */ com.oplus.aiunit.core.data.a e(Context context, String str, Bundle bundle, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            bundle = null;
        }
        return d(context, str, bundle);
    }

    public static final int f(Context context) {
        i.f(context, "context");
        ServiceType d10 = X5.a.d(context);
        if (d10 == ServiceType.f25583a) {
            return -1;
        }
        Bundle b10 = b(f25732a, context, null, 2, null);
        b10.putString("ai::key::method_call", "ai::value::get_llm_queue_status");
        Bundle b11 = a.C0086a.b(Y5.a.f5542a, context, d10, null, b10, null, 16, null);
        if (b11 == null) {
            return -1;
        }
        return b11.getInt("ai::key::llm_queue_status", -1);
    }

    public static final int g(Context context, String detectName) {
        i.f(context, "context");
        i.f(detectName, "detectName");
        ServiceType a10 = X5.a.a(context);
        if (!X5.a.f(X5.a.e(context, a10.b()))) {
            return -1;
        }
        Bundle b10 = b(f25732a, context, null, 2, null);
        b10.putString("package::unit_name", detectName);
        b10.putString("ai::key::method_call", "ai::value::get_settings");
        Bundle b11 = a.C0086a.b(Y5.a.f5542a, context, a10, null, b10, null, 16, null);
        if (b11 == null) {
            return -1;
        }
        return b11.getInt("ai::key::settings_status", -1);
    }

    public final Bundle a(Context context, Bundle bundle) {
        Bundle c10 = X5.a.c(context);
        if (bundle != null) {
            c10.putAll(bundle);
        }
        return c10;
    }
}
