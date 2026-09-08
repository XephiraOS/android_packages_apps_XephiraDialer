package kotlin.jvm.internal;

import C9.h;

/* loaded from: classes4.dex */
public abstract class PropertyReference0 extends PropertyReference implements C9.h {
    public PropertyReference0(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }

    @Override // C9.h
    public h.a a() {
        ((C9.h) getReflected()).a();
        return null;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public C9.b computeReflected() {
        return k.e(this);
    }

    @Override // v9.InterfaceC1637a
    public Object invoke() {
        return get();
    }
}
