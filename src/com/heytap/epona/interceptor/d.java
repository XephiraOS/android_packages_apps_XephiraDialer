package com.heytap.epona.interceptor;

import com.heytap.epona.Request;
import com.heytap.epona.Response;
import com.heytap.epona.d;

/* compiled from: CallProviderInterceptor.java */
/* loaded from: classes3.dex */
public class d implements com.heytap.epona.d {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(Request request, com.heytap.epona.a aVar, Response response) {
        H5.a.b("CallProviderInterceptor", "Component(%s).Action(%s) response : %s", request.d(), request.b(), response);
        aVar.O(response);
    }

    @Override // com.heytap.epona.d
    public void a(d.a aVar) {
        final Request d10 = aVar.d();
        String d11 = d10.d();
        G5.a d12 = com.heytap.epona.c.d(d11);
        if (d12 != null) {
            final com.heytap.epona.a a10 = aVar.a();
            try {
                String b10 = d10.b();
                if (aVar.c()) {
                    d12.a(b10).invoke(null, d10, new com.heytap.epona.a() { // from class: com.heytap.epona.interceptor.c
                        @Override // com.heytap.epona.a
                        public final void O(Response response) {
                            d.c(Request.this, a10, response);
                        }
                    });
                } else {
                    Response response = (Response) d12.a(b10).invoke(null, d10);
                    H5.a.b("CallProviderInterceptor", "Component(%s).Action(%s) response : %s", d10.d(), d10.b(), response);
                    a10.O(response);
                }
                return;
            } catch (Exception e10) {
                H5.a.c("CallProviderInterceptor", "fail to run static provider with componentName = %s and exception is %s", d11, e10.toString());
                a10.O(Response.d());
                return;
            }
        }
        aVar.b();
    }
}
