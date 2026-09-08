package kotlin;

import java.io.Serializable;
import m9.d;

/* compiled from: Lazy.kt */
/* loaded from: classes4.dex */
public final class InitializedLazyImpl<T> implements d<T>, Serializable {
    private final T value;

    public InitializedLazyImpl(T t10) {
        this.value = t10;
    }

    @Override // m9.d
    public T getValue() {
        return this.value;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
