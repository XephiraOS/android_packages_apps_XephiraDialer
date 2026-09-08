package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.d;
import m9.n;
import v9.InterfaceC1637a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJVM.kt */
/* loaded from: classes4.dex */
public final class SynchronizedLazyImpl<T> implements d<T>, Serializable {
    private volatile Object _value;
    private InterfaceC1637a<? extends T> initializer;
    private final Object lock;

    public SynchronizedLazyImpl(InterfaceC1637a<? extends T> initializer, Object obj) {
        i.f(initializer, "initializer");
        this.initializer = initializer;
        this._value = n.f35505a;
        this.lock = obj == null ? this : obj;
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
        T t10;
        T t11 = (T) this._value;
        n nVar = n.f35505a;
        if (t11 != nVar) {
            return t11;
        }
        synchronized (this.lock) {
            t10 = (T) this._value;
            if (t10 == nVar) {
                InterfaceC1637a<? extends T> interfaceC1637a = this.initializer;
                i.c(interfaceC1637a);
                t10 = interfaceC1637a.invoke();
                this._value = t10;
                this.initializer = null;
            }
        }
        return t10;
    }

    public String toString() {
        if (a()) {
            return String.valueOf(getValue());
        }
        return "Lazy value not initialized yet.";
    }

    public /* synthetic */ SynchronizedLazyImpl(InterfaceC1637a interfaceC1637a, Object obj, int i10, f fVar) {
        this(interfaceC1637a, (i10 & 2) != 0 ? null : obj);
    }
}
