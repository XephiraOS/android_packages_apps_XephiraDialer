package kotlin.jvm.internal;

/* loaded from: classes4.dex */
public abstract class PropertyReference extends CallableReference implements C9.j {
    private final boolean syntheticJavaProperty;

    public PropertyReference() {
        this.syntheticJavaProperty = false;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public C9.b compute() {
        if (!this.syntheticJavaProperty) {
            return super.compute();
        }
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PropertyReference) {
            PropertyReference propertyReference = (PropertyReference) obj;
            if (getOwner().equals(propertyReference.getOwner()) && getName().equals(propertyReference.getName()) && getSignature().equals(propertyReference.getSignature()) && i.b(getBoundReceiver(), propertyReference.getBoundReceiver())) {
                return true;
            }
            return false;
        }
        if (!(obj instanceof C9.j)) {
            return false;
        }
        return obj.equals(compute());
    }

    @Override // kotlin.jvm.internal.CallableReference
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C9.j getReflected() {
        if (!this.syntheticJavaProperty) {
            return (C9.j) super.getReflected();
        }
        throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties");
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public String toString() {
        C9.b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    public PropertyReference(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, (i10 & 1) == 1);
        this.syntheticJavaProperty = (i10 & 2) == 2;
    }
}
