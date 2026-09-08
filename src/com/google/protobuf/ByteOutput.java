package com.google.protobuf;

import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public abstract class ByteOutput {
    public abstract void write(byte b10);

    public abstract void write(ByteBuffer byteBuffer);

    public abstract void write(byte[] bArr, int i10, int i11);

    public abstract void writeLazy(ByteBuffer byteBuffer);

    public abstract void writeLazy(byte[] bArr, int i10, int i11);
}
