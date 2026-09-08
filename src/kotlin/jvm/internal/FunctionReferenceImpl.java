package kotlin.jvm.internal;

/* loaded from: classes4.dex */
public class FunctionReferenceImpl extends FunctionReference {
    public FunctionReferenceImpl(int i10, C9.e eVar, String str, String str2) {
        super(i10, CallableReference.NO_RECEIVER, ((c) eVar).d(), str, str2, !(eVar instanceof C9.c) ? 1 : 0);
    }

    public FunctionReferenceImpl(int i10, Class cls, String str, String str2, int i11) {
        super(i10, CallableReference.NO_RECEIVER, cls, str, str2, i11);
    }

    public FunctionReferenceImpl(int i10, Object obj, Class cls, String str, String str2, int i11) {
        super(i10, obj, cls, str, str2, i11);
    }
}
