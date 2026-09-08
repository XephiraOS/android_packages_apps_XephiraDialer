package com.oplus.epona.interceptor;

import com.oplus.epona.Call$Callback;
import com.oplus.epona.Request;
import com.oplus.epona.Response;
import com.oplus.epona.f;
import com.oplus.epona.provider.ProviderInfo;
import com.oplus.utils.C0864z;
import java.lang.reflect.InvocationTargetException;

/* compiled from: CallProviderInterceptor.java */
/* loaded from: classes3.dex */
public class d implements f {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(String str, String str2, String str3, Call$Callback call$Callback, Response response) {
        C0864z.c("Epona->CallProviderInterceptor", "Caller(%s) call component(%s) action(%s) response:(%s)", str, str2, str3, response);
        call$Callback.onReceive(response);
    }

    @Override // com.oplus.epona.f
    public void a(f.a aVar) {
        Response f10;
        Request d10 = aVar.d();
        final String componentName = d10.getComponentName();
        final String callerPackageName = d10.getCallerPackageName();
        ProviderInfo f11 = com.oplus.epona.d.f(componentName);
        if (f11 != null) {
            final Call$Callback a10 = aVar.a();
            try {
                final String actionName = d10.getActionName();
                if (aVar.c()) {
                    f11.getMethod(actionName).invoke(null, d10, new Call$Callback() { // from class: com.oplus.epona.interceptor.c
                        @Override // com.oplus.epona.Call$Callback
                        public final void onReceive(Response response) {
                            d.c(callerPackageName, componentName, actionName, a10, response);
                        }
                    });
                } else {
                    Response response = (Response) f11.getMethod(actionName).invoke(null, d10);
                    C0864z.c("Epona->CallProviderInterceptor", "Caller(%s) call component(%s) action(%s) response:(%s)", callerPackageName, componentName, actionName, response);
                    a10.onReceive(response);
                }
                return;
            } catch (Exception e10) {
                if (e10 instanceof InvocationTargetException) {
                    InvocationTargetException invocationTargetException = (InvocationTargetException) e10;
                    C0864z.d("Epona->CallProviderInterceptor", "InvocationTargetException happened with component(%s) Exception: %s", componentName, invocationTargetException.getTargetException());
                    f10 = Response.f(String.format("InvocationTargetException happened with component(%s) Exception: %s", componentName, invocationTargetException.getTargetException()));
                } else {
                    C0864z.d("Epona->CallProviderInterceptor", "fail to run static provider with componentName(%s) cause: %s ", componentName, e10.toString());
                    f10 = Response.f(String.format("fail to run static provider with componentName(%s) cause: %s ", componentName, e10));
                }
                a10.onReceive(f10);
                return;
            }
        }
        aVar.b();
    }
}
