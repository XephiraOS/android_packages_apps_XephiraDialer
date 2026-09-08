package kotlin.jvm.internal;

/* loaded from: classes4.dex */
public class FunctionReference extends CallableReference implements h, C9.f {
    private final int arity;
    private final int flags;

    public FunctionReference(int i10) {
        this(i10, CallableReference.NO_RECEIVER, null, null, null, 0);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public C9.b computeReflected() {
        return k.a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReference) {
            FunctionReference functionReference = (FunctionReference) obj;
            if (getName().equals(functionReference.getName()) && getSignature().equals(functionReference.getSignature()) && this.flags == functionReference.flags && this.arity == functionReference.arity && i.b(getBoundReceiver(), functionReference.getBoundReceiver()) && i.b(getOwner(), functionReference.getOwner())) {
                return true;
            }
            return false;
        }
        if (!(obj instanceof C9.f)) {
            return false;
        }
        return obj.equals(compute());
    }

    @Override // kotlin.jvm.internal.h
    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        int hashCode;
        if (getOwner() == null) {
            hashCode = 0;
        } else {
            hashCode = getOwner().hashCode() * 31;
        }
        return ((hashCode + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // C9.f
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // C9.f
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // C9.f
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // C9.f
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kotlin.jvm.internal.CallableReference, C9.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        C9.b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    public FunctionReference(int i10, Object obj) {
        this(i10, obj, null, null, null, 0);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public C9.f getReflected() {
        return (C9.f) super.getReflected();
    }

    public FunctionReference(int i10, Object obj, Class cls, String str, String str2, int i11) {
        super(obj, cls, str, str2, (i11 & 1) == 1);
        this.arity = i10;
        this.flags = i11 >> 1;
    }
}
