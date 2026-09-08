package a1;

import com.android.contacts.framework.bttransmission.obex.ObexOperationImpl;
import d1.C0947b;

/* compiled from: ObexOperationProxy.java */
/* loaded from: classes.dex */
public class i implements h {

    /* renamed from: b, reason: collision with root package name */
    public C0947b f6344b = new C0947b();

    /* renamed from: a, reason: collision with root package name */
    public h f6343a = new ObexOperationImpl();

    @Override // a1.h
    public int a() {
        C0947b.a(" obex on connect", 0);
        return this.f6343a.a();
    }

    @Override // a1.h
    public int b(Object obj) {
        C0947b.a(" obex on setTarget", 0);
        return this.f6343a.b(obj);
    }

    @Override // a1.h
    public int c() {
        C0947b.a("obex on get", 0);
        return this.f6343a.c();
    }

    @Override // a1.h
    public int d() {
        C0947b.a(" obex on disconnect", 0);
        return this.f6343a.d();
    }

    @Override // a1.h
    public int e() {
        C0947b.a(" obex on abort", 0);
        return this.f6343a.e();
    }

    @Override // a1.h
    public int f() {
        C0947b.a(" obex on getPhoneBookSize", 0);
        return this.f6343a.f();
    }
}
