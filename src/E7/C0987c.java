package e7;

import com.heytap.epona.Request;
import com.oplus.epona.Request;

/* compiled from: OplusToHeytapRequestConverter.java */
/* renamed from: e7.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0987c implements InterfaceC0985a<Request, com.heytap.epona.Request> {
    @Override // e7.InterfaceC0985a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.heytap.epona.Request convert(Request request) {
        com.heytap.epona.Request a10 = new Request.b().c(request.getComponentName()).b(request.getActionName()).a();
        a10.f(request.getBundle());
        return a10;
    }
}
