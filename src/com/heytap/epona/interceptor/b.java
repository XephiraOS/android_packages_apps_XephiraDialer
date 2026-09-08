package com.heytap.epona.interceptor;

import com.heytap.epona.Request;
import com.heytap.epona.Response;
import com.heytap.epona.d;

/* compiled from: CallComponentInterceptor.java */
/* loaded from: classes3.dex */
public class b implements com.heytap.epona.d {
    public static /* synthetic */ void c(Request request, com.heytap.epona.a aVar, Response response) {
        H5.a.b("CallComponentInterceptor", "Component(%s).Action(%s) response : %s", request.d(), request.b(), response);
        aVar.O(response);
    }

    @Override // com.heytap.epona.d
    public void a(d.a aVar) {
        final Request d10 = aVar.d();
        com.heytap.epona.b c10 = com.heytap.epona.c.c(d10.d());
        if (c10 != null) {
            final com.heytap.epona.a a10 = aVar.a();
            if (aVar.c()) {
                c10.b(d10, new com.heytap.epona.a() { // from class: com.heytap.epona.interceptor.a
                    @Override // com.heytap.epona.a
                    public final void O(Response response) {
                        b.c(Request.this, a10, response);
                    }
                });
                return;
            }
            Response a11 = c10.a(d10);
            H5.a.b("CallComponentInterceptor", "Component(%s).Action(%s) response : %s", d10.d(), d10.b(), a11);
            a10.O(a11);
            return;
        }
        aVar.b();
    }
}
