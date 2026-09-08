package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.d;
import m9.n;
import v9.InterfaceC1637a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJVM.kt */
/* loaded from: classes4.dex */
public final class SafePublicationLazyImpl<T> implements d<T>, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final a f34167a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> f34168b = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "_value");
    private volatile Object _value;

    /* renamed from: final, reason: not valid java name */
    private final Object f0final;
    private volatile InterfaceC1637a<? extends T> initializer;

    /* compiled from: LazyJVM.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public SafePublicationLazyImpl(InterfaceC1637a<? extends T> initializer) {
        i.f(initializer, "initializer");
        this.initializer = initializer;
        n nVar = n.f35505a;
        this._value = nVar;
        this.f0final = nVar;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    public boolean a() {
        if (this._value != n.f35505a) {
            return true;
        }
        return false;
    }

    @Override // m9.d
    public T getValue() {
        T t10 = (T) this._value;
        n nVar = n.f35505a;
        if (t10 != nVar) {
            return t10;
        }
        InterfaceC1637a<? extends T> interfaceC1637a = this.initializer;
        if (interfaceC1637a != null) {
            T invoke = interfaceC1637a.invoke();
            if (f34168b.compareAndSet(this, nVar, invoke)) {
                this.initializer = null;
                return invoke;
            }
        }
        return (T) this._value;
    }

    public String toString() {
        if (a()) {
            return String.valueOf(getValue());
        }
        return "Lazy value not initialized yet.";
    }
}
