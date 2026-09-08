package J0;

import android.content.Context;
import android.os.Bundle;
import android.telecom.TelecomManager;
import com.android.contacts.framework.api.appstore.missedcall.IMissedCallApi;

/* compiled from: MissedCallApiImpl.kt */
/* loaded from: classes.dex */
public final class i implements IMissedCallApi {

    /* renamed from: b, reason: collision with root package name */
    public static final a f1462b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public static final i f1463c = new i();

    /* compiled from: MissedCallApiImpl.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final i a() {
            return i.f1463c;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    @Override // com.android.contacts.framework.api.appstore.missedcall.IMissedCallApi
    public void a(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        H7.b.b("IMissedCallApi", "clearAllMissedCalls");
        k.a(context);
        d(context);
    }

    @Override // com.android.contacts.framework.api.appstore.missedcall.IMissedCallApi
    public void b(Context context, Bundle bundle) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(bundle, "bundle");
        H7.b.b("IMissedCallApi", "clearInterceptMissedCalls");
        k.b(context, bundle);
        Object systemService = context.getSystemService("telecom");
        kotlin.jvm.internal.i.d(systemService, "null cannot be cast to non-null type android.telecom.TelecomManager");
        com.android.contacts.framework.baseui.util.p.d((TelecomManager) systemService, bundle);
    }

    public final void d(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        try {
            Object systemService = context.getSystemService("telecom");
            kotlin.jvm.internal.i.d(systemService, "null cannot be cast to non-null type android.telecom.TelecomManager");
            ((TelecomManager) systemService).cancelMissedCallsNotification();
        } catch (Exception unused) {
            H7.b.c("IMissedCallApi", "Failed to clear missed calls notification due to remote exception");
        }
    }
}
