package com.oplus.epona.interceptor;

import com.oplus.epona.Call$Callback;
import com.oplus.epona.Request;
import com.oplus.epona.Response;
import com.oplus.epona.f;
import com.oplus.utils.C0864z;

/* compiled from: CallComponentInterceptor.java */
/* loaded from: classes3.dex */
public class b implements f {
    public static /* synthetic */ void c(String str, String str2, String str3, Call$Callback call$Callback, Response response) {
        C0864z.c("Epona->CallComponentInterceptor", "Caller(%s) call component(%s) action(%s) response:(%s)", str, str2, str3, response);
        call$Callback.onReceive(response);
    }

    @Override // com.oplus.epona.f
    public void a(f.a aVar) {
        Request d10 = aVar.d();
        final String componentName = d10.getComponentName();
        final String actionName = d10.getActionName();
        com.oplus.epona.c e10 = com.oplus.epona.d.e(componentName);
        if (e10 != null) {
            final String callerPackageName = d10.getCallerPackageName();
            final Call$Callback a10 = aVar.a();
            if (aVar.c()) {
                e10.b(d10, new Call$Callback() { // from class: com.oplus.epona.interceptor.a
                    @Override // com.oplus.epona.Call$Callback
                    public final void onReceive(Response response) {
                        b.c(callerPackageName, componentName, actionName, a10, response);
                    }
                });
                return;
            }
            Response a11 = e10.a(d10);
            C0864z.c("Epona->CallComponentInterceptor", "Caller(%s) call component(%s) action(%s) response:(%s)", callerPackageName, componentName, actionName, a11);
            a10.onReceive(a11);
            return;
        }
        aVar.b();
    }
}
