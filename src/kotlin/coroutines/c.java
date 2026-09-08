package kotlin.coroutines;

/* compiled from: Continuation.kt */
/* loaded from: classes4.dex */
public interface c<T> {
    CoroutineContext getContext();

    void resumeWith(Object obj);
}
