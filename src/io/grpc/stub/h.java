package io.grpc.stub;

/* compiled from: StreamObserver.java */
/* loaded from: classes4.dex */
public interface h<V> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(V v10);
}
