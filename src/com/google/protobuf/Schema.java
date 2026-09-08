package com.google.protobuf;

import com.google.protobuf.ArrayDecoders;

/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: classes3.dex */
public interface Schema<T> {
    boolean equals(T t10, T t11);

    int getSerializedSize(T t10);

    int hashCode(T t10);

    boolean isInitialized(T t10);

    void makeImmutable(T t10);

    void mergeFrom(T t10, Reader reader, ExtensionRegistryLite extensionRegistryLite);

    void mergeFrom(T t10, T t11);

    void mergeFrom(T t10, byte[] bArr, int i10, int i11, ArrayDecoders.Registers registers);

    T newInstance();

    void writeTo(T t10, Writer writer);
}
