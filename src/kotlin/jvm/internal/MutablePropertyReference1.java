package kotlin.jvm.internal;

import C9.i;

/* loaded from: classes4.dex */
public abstract class MutablePropertyReference1 extends MutablePropertyReference implements C9.g {
    public MutablePropertyReference1(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }

    @Override // C9.i
    public i.a a() {
        ((C9.g) getReflected()).a();
        return null;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public C9.b computeReflected() {
        return k.d(this);
    }

    @Override // v9.l
    public Object invoke(Object obj) {
        return get(obj);
    }
}
