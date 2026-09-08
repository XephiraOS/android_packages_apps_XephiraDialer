package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.i;
import m9.d;
import m9.n;
import v9.InterfaceC1637a;

/* compiled from: Lazy.kt */
/* loaded from: classes4.dex */
public final class UnsafeLazyImpl<T> implements d<T>, Serializable {
    private Object _value;
    private InterfaceC1637a<? extends T> initializer;

    public UnsafeLazyImpl(InterfaceC1637a<? extends T> initializer) {
        i.f(initializer, "initializer");
        this.initializer = initializer;
        this._value = n.f35505a;
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
        if (this._value == n.f35505a) {
            InterfaceC1637a<? extends T> interfaceC1637a = this.initializer;
            i.c(interfaceC1637a);
            this._value = interfaceC1637a.invoke();
            this.initializer = null;
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
