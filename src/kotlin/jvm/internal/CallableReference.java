package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KVisibility;

/* loaded from: classes4.dex */
public abstract class CallableReference implements C9.b, Serializable {
    public static final Object NO_RECEIVER = NoReceiver.f34230a;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient C9.b reflected;
    private final String signature;

    /* loaded from: classes4.dex */
    public static class NoReceiver implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public static final NoReceiver f34230a = new NoReceiver();

        private NoReceiver() {
        }

        private Object readResolve() {
            return f34230a;
        }
    }

    public CallableReference() {
        this(NO_RECEIVER);
    }

    @Override // C9.b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // C9.b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public C9.b compute() {
        C9.b bVar = this.reflected;
        if (bVar == null) {
            C9.b computeReflected = computeReflected();
            this.reflected = computeReflected;
            return computeReflected;
        }
        return bVar;
    }

    public abstract C9.b computeReflected();

    @Override // C9.a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    @Override // C9.b
    public String getName() {
        return this.name;
    }

    public C9.e getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        if (this.isTopLevel) {
            return k.c(cls);
        }
        return k.b(cls);
    }

    @Override // C9.b
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    public C9.b getReflected() {
        C9.b compute = compute();
        if (compute != this) {
            return compute;
        }
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // C9.b
    public C9.k getReturnType() {
        getReflected().getReturnType();
        return null;
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // C9.b
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // C9.b
    public KVisibility getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // C9.b
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // C9.b
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // C9.b
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // C9.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public CallableReference(Object obj) {
        this(obj, null, null, null, false);
    }

    public CallableReference(Object obj, Class cls, String str, String str2, boolean z10) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z10;
    }
}
