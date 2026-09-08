package P7;

import android.content.Context;
import android.content.res.Resources;
import android.telecom.TelecomManager;
import android.text.TextUtils;
import kotlin.Result;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: TelecomUtils.kt */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f2967a = new d();

    public static final String a(Context context) {
        Object b10;
        i.f(context, "context");
        String defaultDialerPackage = context.getPackageName();
        try {
            Result.a aVar = Result.f34166a;
            Object systemService = context.getSystemService("telecom");
            i.d(systemService, "null cannot be cast to non-null type android.telecom.TelecomManager");
            defaultDialerPackage = ((TelecomManager) systemService).getDefaultDialerPackage();
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("TelecomUtils", "getDefaultDialerPackage error! " + d10);
        }
        if (TextUtils.isEmpty(defaultDialerPackage)) {
            if (H7.a.b()) {
                H7.b.b("TelecomUtils", "getDefaultDialerPackage defaultDialerPackage isEmpty");
            }
            Resources system = Resources.getSystem();
            defaultDialerPackage = system.getString(system.getIdentifier("config_defaultDialer", "string", "android"));
        }
        if (H7.a.b()) {
            H7.b.b("TelecomUtils", "getDefaultDialerPackage defaultDialerPackage = " + ((Object) defaultDialerPackage));
        }
        i.e(defaultDialerPackage, "defaultDialerPackage");
        return defaultDialerPackage;
    }
}
