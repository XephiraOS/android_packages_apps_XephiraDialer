package androidx.databinding;

import java.io.Serializable;

/* loaded from: classes.dex */
public class ObservableField<T> extends b implements Serializable {
    static final long serialVersionUID = 1;
    private T mValue;

    public ObservableField(T t10) {
        this.mValue = t10;
    }

    public T s0() {
        return this.mValue;
    }

    public ObservableField() {
    }
}
