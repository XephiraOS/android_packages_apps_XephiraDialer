package com.google.protobuf;

import com.google.protobuf.UnknownFieldSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class UnknownFieldSetSchema extends UnknownFieldSchema<UnknownFieldSet, UnknownFieldSet.Builder> {
    @Override // com.google.protobuf.UnknownFieldSchema
    public boolean shouldDiscardUnknownFields(Reader reader) {
        return reader.shouldDiscardUnknownFields();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public void addFixed32(UnknownFieldSet.Builder builder, int i10, int i11) {
        builder.mergeField(i10, UnknownFieldSet.Field.newBuilder().addFixed32(i11).build());
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public void addFixed64(UnknownFieldSet.Builder builder, int i10, long j10) {
        builder.mergeField(i10, UnknownFieldSet.Field.newBuilder().addFixed64(j10).build());
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public void addGroup(UnknownFieldSet.Builder builder, int i10, UnknownFieldSet unknownFieldSet) {
        builder.mergeField(i10, UnknownFieldSet.Field.newBuilder().addGroup(unknownFieldSet).build());
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public void addLengthDelimited(UnknownFieldSet.Builder builder, int i10, ByteString byteString) {
        builder.mergeField(i10, UnknownFieldSet.Field.newBuilder().addLengthDelimited(byteString).build());
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public void addVarint(UnknownFieldSet.Builder builder, int i10, long j10) {
        builder.mergeField(i10, UnknownFieldSet.Field.newBuilder().addVarint(j10).build());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    public UnknownFieldSet.Builder getBuilderFromMessage(Object obj) {
        return ((GeneratedMessageV3) obj).unknownFields.toBuilder();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    public UnknownFieldSet getFromMessage(Object obj) {
        return ((GeneratedMessageV3) obj).unknownFields;
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public int getSerializedSize(UnknownFieldSet unknownFieldSet) {
        return unknownFieldSet.getSerializedSize();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public int getSerializedSizeAsMessageSet(UnknownFieldSet unknownFieldSet) {
        return unknownFieldSet.getSerializedSizeAsMessageSet();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public UnknownFieldSet merge(UnknownFieldSet unknownFieldSet, UnknownFieldSet unknownFieldSet2) {
        return unknownFieldSet.toBuilder().mergeFrom(unknownFieldSet2).build();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    public UnknownFieldSet.Builder newBuilder() {
        return UnknownFieldSet.newBuilder();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public void setBuilderToMessage(Object obj, UnknownFieldSet.Builder builder) {
        ((GeneratedMessageV3) obj).unknownFields = builder.build();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public void setToMessage(Object obj, UnknownFieldSet unknownFieldSet) {
        ((GeneratedMessageV3) obj).unknownFields = unknownFieldSet;
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public UnknownFieldSet toImmutable(UnknownFieldSet.Builder builder) {
        return builder.build();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public void writeAsMessageSetTo(UnknownFieldSet unknownFieldSet, Writer writer) {
        unknownFieldSet.writeAsMessageSetTo(writer);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public void writeTo(UnknownFieldSet unknownFieldSet, Writer writer) {
        unknownFieldSet.writeTo(writer);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public void makeImmutable(Object obj) {
    }
}
