package kotlin.jvm.internal;

/* loaded from: classes4.dex */
public class PropertyReference0Impl extends PropertyReference0 {
    public PropertyReference0Impl(Class cls, String str, String str2, int i10) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i10);
    }

    @Override // C9.h
    public Object get() {
        a();
        throw null;
    }

    public PropertyReference0Impl(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
