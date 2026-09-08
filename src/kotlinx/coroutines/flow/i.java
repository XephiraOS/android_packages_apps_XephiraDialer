package kotlinx.coroutines.flow;

/* compiled from: StateFlow.kt */
/* loaded from: classes4.dex */
public interface i<T> extends m<T>, h<T> {
    boolean c(T t10, T t11);

    @Override // kotlinx.coroutines.flow.m
    T getValue();

    void setValue(T t10);
}
