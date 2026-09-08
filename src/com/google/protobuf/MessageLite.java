package com.google.protobuf;

import java.io.InputStream;
import java.io.OutputStream;

@CheckReturnValue
/* loaded from: classes3.dex */
public interface MessageLite extends MessageLiteOrBuilder {

    /* loaded from: classes3.dex */
    public interface Builder extends MessageLiteOrBuilder, Cloneable {
        MessageLite build();

        MessageLite buildPartial();

        @CanIgnoreReturnValue
        Builder clear();

        /* renamed from: clone */
        Builder m5clone();

        boolean mergeDelimitedFrom(InputStream inputStream);

        boolean mergeDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite);

        @CanIgnoreReturnValue
        Builder mergeFrom(ByteString byteString);

        @CanIgnoreReturnValue
        Builder mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite);

        @CanIgnoreReturnValue
        Builder mergeFrom(CodedInputStream codedInputStream);

        @CanIgnoreReturnValue
        Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite);

        @CanIgnoreReturnValue
        Builder mergeFrom(MessageLite messageLite);

        @CanIgnoreReturnValue
        Builder mergeFrom(InputStream inputStream);

        @CanIgnoreReturnValue
        Builder mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite);

        @CanIgnoreReturnValue
        Builder mergeFrom(byte[] bArr);

        @CanIgnoreReturnValue
        Builder mergeFrom(byte[] bArr, int i10, int i11);

        @CanIgnoreReturnValue
        Builder mergeFrom(byte[] bArr, int i10, int i11, ExtensionRegistryLite extensionRegistryLite);

        @CanIgnoreReturnValue
        Builder mergeFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite);
    }

    Parser<? extends MessageLite> getParserForType();

    int getSerializedSize();

    Builder newBuilderForType();

    Builder toBuilder();

    byte[] toByteArray();

    ByteString toByteString();

    void writeDelimitedTo(OutputStream outputStream);

    void writeTo(CodedOutputStream codedOutputStream);

    void writeTo(OutputStream outputStream);
}
