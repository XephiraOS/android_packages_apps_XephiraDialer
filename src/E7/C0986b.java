package e7;

import com.heytap.epona.Response;

/* compiled from: HeytapToOplusResponseConverter.java */
/* renamed from: e7.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0986b implements InterfaceC0985a<Response, com.oplus.epona.Response> {
    @Override // e7.InterfaceC0985a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.oplus.epona.Response convert(Response response) {
        if (response.j()) {
            return com.oplus.epona.Response.k(response.h());
        }
        try {
            response.b(Exception.class);
            return com.oplus.epona.Response.f(response.i());
        } catch (Exception e10) {
            return com.oplus.epona.Response.d(e10);
        }
    }
}
