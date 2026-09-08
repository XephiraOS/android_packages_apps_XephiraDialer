package com.google.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: classes3.dex */
public abstract class UnknownFieldSchema<T, B> {
    public abstract void addFixed32(B b10, int i10, int i11);

    public abstract void addFixed64(B b10, int i10, long j10);

    public abstract void addGroup(B b10, int i10, T t10);

    public abstract void addLengthDelimited(B b10, int i10, ByteString byteString);

    public abstract void addVarint(B b10, int i10, long j10);

    public abstract B getBuilderFromMessage(Object obj);

    public abstract T getFromMessage(Object obj);

    public abstract int getSerializedSize(T t10);

    public abstract int getSerializedSizeAsMessageSet(T t10);

    public abstract void makeImmutable(Object obj);

    public abstract T merge(T t10, T t11);

    public final void mergeFrom(B b10, Reader reader) {
        while (reader.getFieldNumber() != Integer.MAX_VALUE && mergeOneFieldFrom(b10, reader)) {
        }
    }

    public final boolean mergeOneFieldFrom(B b10, Reader reader) {
        int tag = reader.getTag();
        int tagFieldNumber = WireFormat.getTagFieldNumber(tag);
        int tagWireType = WireFormat.getTagWireType(tag);
        if (tagWireType != 0) {
            if (tagWireType != 1) {
                if (tagWireType != 2) {
                    if (tagWireType != 3) {
                        if (tagWireType != 4) {
                            if (tagWireType == 5) {
                                addFixed32(b10, tagFieldNumber, reader.readFixed32());
                                return true;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        return false;
                    }
                    B newBuilder = newBuilder();
                    int makeTag = WireFormat.makeTag(tagFieldNumber, 4);
                    mergeFrom(newBuilder, reader);
                    if (makeTag == reader.getTag()) {
                        addGroup(b10, tagFieldNumber, toImmutable(newBuilder));
                        return true;
                    }
                    throw InvalidProtocolBufferException.invalidEndTag();
                }
                addLengthDelimited(b10, tagFieldNumber, reader.readBytes());
                return true;
            }
            addFixed64(b10, tagFieldNumber, reader.readFixed64());
            return true;
        }
        addVarint(b10, tagFieldNumber, reader.readInt64());
        return true;
    }

    public abstract B newBuilder();

    public abstract void setBuilderToMessage(Object obj, B b10);

    public abstract void setToMessage(Object obj, T t10);

    public abstract boolean shouldDiscardUnknownFields(Reader reader);

    public abstract T toImmutable(B b10);

    public abstract void writeAsMessageSetTo(T t10, Writer writer);

    public abstract void writeTo(T t10, Writer writer);
}
