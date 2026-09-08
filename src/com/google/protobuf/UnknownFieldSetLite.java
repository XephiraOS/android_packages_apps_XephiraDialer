package com.google.protobuf;

import com.google.protobuf.Writer;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class UnknownFieldSetLite {
    private static final UnknownFieldSetLite DEFAULT_INSTANCE = new UnknownFieldSetLite(0, new int[0], new Object[0], false);
    private static final int MIN_CAPACITY = 8;
    private int count;
    private boolean isMutable;
    private int memoizedSerializedSize;
    private Object[] objects;
    private int[] tags;

    private UnknownFieldSetLite() {
        this(0, new int[8], new Object[8], true);
    }

    private void ensureCapacity(int i10) {
        int[] iArr = this.tags;
        if (i10 > iArr.length) {
            int i11 = this.count;
            int i12 = i11 + (i11 / 2);
            if (i12 >= i10) {
                i10 = i12;
            }
            if (i10 < 8) {
                i10 = 8;
            }
            this.tags = Arrays.copyOf(iArr, i10);
            this.objects = Arrays.copyOf(this.objects, i10);
        }
    }

    public static UnknownFieldSetLite getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static int hashCode(int[] iArr, int i10) {
        int i11 = 17;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 = (i11 * 31) + iArr[i12];
        }
        return i11;
    }

    private UnknownFieldSetLite mergeFrom(CodedInputStream codedInputStream) {
        int readTag;
        do {
            readTag = codedInputStream.readTag();
            if (readTag == 0) {
                break;
            }
        } while (mergeFieldFrom(readTag, codedInputStream));
        return this;
    }

    public static UnknownFieldSetLite mutableCopyOf(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        int i10 = unknownFieldSetLite.count + unknownFieldSetLite2.count;
        int[] copyOf = Arrays.copyOf(unknownFieldSetLite.tags, i10);
        System.arraycopy(unknownFieldSetLite2.tags, 0, copyOf, unknownFieldSetLite.count, unknownFieldSetLite2.count);
        Object[] copyOf2 = Arrays.copyOf(unknownFieldSetLite.objects, i10);
        System.arraycopy(unknownFieldSetLite2.objects, 0, copyOf2, unknownFieldSetLite.count, unknownFieldSetLite2.count);
        return new UnknownFieldSetLite(i10, copyOf, copyOf2, true);
    }

    public static UnknownFieldSetLite newInstance() {
        return new UnknownFieldSetLite();
    }

    private static boolean objectsEquals(Object[] objArr, Object[] objArr2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (!objArr[i11].equals(objArr2[i11])) {
                return false;
            }
        }
        return true;
    }

    private static boolean tagsEquals(int[] iArr, int[] iArr2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (iArr[i11] != iArr2[i11]) {
                return false;
            }
        }
        return true;
    }

    private static void writeField(int i10, Object obj, Writer writer) {
        int tagFieldNumber = WireFormat.getTagFieldNumber(i10);
        int tagWireType = WireFormat.getTagWireType(i10);
        if (tagWireType != 0) {
            if (tagWireType != 1) {
                if (tagWireType != 2) {
                    if (tagWireType != 3) {
                        if (tagWireType == 5) {
                            writer.writeFixed32(tagFieldNumber, ((Integer) obj).intValue());
                            return;
                        }
                        throw new RuntimeException(InvalidProtocolBufferException.invalidWireType());
                    }
                    if (writer.fieldOrder() == Writer.FieldOrder.ASCENDING) {
                        writer.writeStartGroup(tagFieldNumber);
                        ((UnknownFieldSetLite) obj).writeTo(writer);
                        writer.writeEndGroup(tagFieldNumber);
                        return;
                    } else {
                        writer.writeEndGroup(tagFieldNumber);
                        ((UnknownFieldSetLite) obj).writeTo(writer);
                        writer.writeStartGroup(tagFieldNumber);
                        return;
                    }
                }
                writer.writeBytes(tagFieldNumber, (ByteString) obj);
                return;
            }
            writer.writeFixed64(tagFieldNumber, ((Long) obj).longValue());
            return;
        }
        writer.writeInt64(tagFieldNumber, ((Long) obj).longValue());
    }

    public void checkMutable() {
        if (this.isMutable) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UnknownFieldSetLite)) {
            return false;
        }
        UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite) obj;
        int i10 = this.count;
        if (i10 == unknownFieldSetLite.count && tagsEquals(this.tags, unknownFieldSetLite.tags, i10) && objectsEquals(this.objects, unknownFieldSetLite.objects, this.count)) {
            return true;
        }
        return false;
    }

    public int getSerializedSize() {
        int computeUInt64Size;
        int i10 = this.memoizedSerializedSize;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.count; i12++) {
            int i13 = this.tags[i12];
            int tagFieldNumber = WireFormat.getTagFieldNumber(i13);
            int tagWireType = WireFormat.getTagWireType(i13);
            if (tagWireType != 0) {
                if (tagWireType != 1) {
                    if (tagWireType != 2) {
                        if (tagWireType != 3) {
                            if (tagWireType == 5) {
                                computeUInt64Size = CodedOutputStream.computeFixed32Size(tagFieldNumber, ((Integer) this.objects[i12]).intValue());
                            } else {
                                throw new IllegalStateException(InvalidProtocolBufferException.invalidWireType());
                            }
                        } else {
                            computeUInt64Size = (CodedOutputStream.computeTagSize(tagFieldNumber) * 2) + ((UnknownFieldSetLite) this.objects[i12]).getSerializedSize();
                        }
                    } else {
                        computeUInt64Size = CodedOutputStream.computeBytesSize(tagFieldNumber, (ByteString) this.objects[i12]);
                    }
                } else {
                    computeUInt64Size = CodedOutputStream.computeFixed64Size(tagFieldNumber, ((Long) this.objects[i12]).longValue());
                }
            } else {
                computeUInt64Size = CodedOutputStream.computeUInt64Size(tagFieldNumber, ((Long) this.objects[i12]).longValue());
            }
            i11 += computeUInt64Size;
        }
        this.memoizedSerializedSize = i11;
        return i11;
    }

    public int getSerializedSizeAsMessageSet() {
        int i10 = this.memoizedSerializedSize;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.count; i12++) {
            i11 += CodedOutputStream.computeRawMessageSetExtensionSize(WireFormat.getTagFieldNumber(this.tags[i12]), (ByteString) this.objects[i12]);
        }
        this.memoizedSerializedSize = i11;
        return i11;
    }

    public void makeImmutable() {
        if (this.isMutable) {
            this.isMutable = false;
        }
    }

    public boolean mergeFieldFrom(int i10, CodedInputStream codedInputStream) {
        checkMutable();
        int tagFieldNumber = WireFormat.getTagFieldNumber(i10);
        int tagWireType = WireFormat.getTagWireType(i10);
        if (tagWireType != 0) {
            if (tagWireType != 1) {
                if (tagWireType != 2) {
                    if (tagWireType != 3) {
                        if (tagWireType != 4) {
                            if (tagWireType == 5) {
                                storeField(i10, Integer.valueOf(codedInputStream.readFixed32()));
                                return true;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        return false;
                    }
                    UnknownFieldSetLite unknownFieldSetLite = new UnknownFieldSetLite();
                    unknownFieldSetLite.mergeFrom(codedInputStream);
                    codedInputStream.checkLastTagWas(WireFormat.makeTag(tagFieldNumber, 4));
                    storeField(i10, unknownFieldSetLite);
                    return true;
                }
                storeField(i10, codedInputStream.readBytes());
                return true;
            }
            storeField(i10, Long.valueOf(codedInputStream.readFixed64()));
            return true;
        }
        storeField(i10, Long.valueOf(codedInputStream.readInt64()));
        return true;
    }

    public UnknownFieldSetLite mergeLengthDelimitedField(int i10, ByteString byteString) {
        checkMutable();
        if (i10 != 0) {
            storeField(WireFormat.makeTag(i10, 2), byteString);
            return this;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    public UnknownFieldSetLite mergeVarintField(int i10, int i11) {
        checkMutable();
        if (i10 != 0) {
            storeField(WireFormat.makeTag(i10, 0), Long.valueOf(i11));
            return this;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    public final void printWithIndent(StringBuilder sb, int i10) {
        for (int i11 = 0; i11 < this.count; i11++) {
            MessageLiteToString.printField(sb, i10, String.valueOf(WireFormat.getTagFieldNumber(this.tags[i11])), this.objects[i11]);
        }
    }

    public void storeField(int i10, Object obj) {
        checkMutable();
        ensureCapacity(this.count + 1);
        int[] iArr = this.tags;
        int i11 = this.count;
        iArr[i11] = i10;
        this.objects[i11] = obj;
        this.count = i11 + 1;
    }

    public void writeAsMessageSetTo(CodedOutputStream codedOutputStream) {
        for (int i10 = 0; i10 < this.count; i10++) {
            codedOutputStream.writeRawMessageSetExtension(WireFormat.getTagFieldNumber(this.tags[i10]), (ByteString) this.objects[i10]);
        }
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        for (int i10 = 0; i10 < this.count; i10++) {
            int i11 = this.tags[i10];
            int tagFieldNumber = WireFormat.getTagFieldNumber(i11);
            int tagWireType = WireFormat.getTagWireType(i11);
            if (tagWireType == 0) {
                codedOutputStream.writeUInt64(tagFieldNumber, ((Long) this.objects[i10]).longValue());
            } else if (tagWireType == 1) {
                codedOutputStream.writeFixed64(tagFieldNumber, ((Long) this.objects[i10]).longValue());
            } else if (tagWireType == 2) {
                codedOutputStream.writeBytes(tagFieldNumber, (ByteString) this.objects[i10]);
            } else if (tagWireType == 3) {
                codedOutputStream.writeTag(tagFieldNumber, 3);
                ((UnknownFieldSetLite) this.objects[i10]).writeTo(codedOutputStream);
                codedOutputStream.writeTag(tagFieldNumber, 4);
            } else if (tagWireType == 5) {
                codedOutputStream.writeFixed32(tagFieldNumber, ((Integer) this.objects[i10]).intValue());
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    private UnknownFieldSetLite(int i10, int[] iArr, Object[] objArr, boolean z10) {
        this.memoizedSerializedSize = -1;
        this.count = i10;
        this.tags = iArr;
        this.objects = objArr;
        this.isMutable = z10;
    }

    private static int hashCode(Object[] objArr, int i10) {
        int i11 = 17;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 = (i11 * 31) + objArr[i12].hashCode();
        }
        return i11;
    }

    public int hashCode() {
        int i10 = this.count;
        return ((((527 + i10) * 31) + hashCode(this.tags, i10)) * 31) + hashCode(this.objects, this.count);
    }

    @CanIgnoreReturnValue
    public UnknownFieldSetLite mergeFrom(UnknownFieldSetLite unknownFieldSetLite) {
        if (unknownFieldSetLite.equals(getDefaultInstance())) {
            return this;
        }
        checkMutable();
        int i10 = this.count + unknownFieldSetLite.count;
        ensureCapacity(i10);
        System.arraycopy(unknownFieldSetLite.tags, 0, this.tags, this.count, unknownFieldSetLite.count);
        System.arraycopy(unknownFieldSetLite.objects, 0, this.objects, this.count, unknownFieldSetLite.count);
        this.count = i10;
        return this;
    }

    public void writeAsMessageSetTo(Writer writer) {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            for (int i10 = this.count - 1; i10 >= 0; i10--) {
                writer.writeMessageSetItem(WireFormat.getTagFieldNumber(this.tags[i10]), this.objects[i10]);
            }
            return;
        }
        for (int i11 = 0; i11 < this.count; i11++) {
            writer.writeMessageSetItem(WireFormat.getTagFieldNumber(this.tags[i11]), this.objects[i11]);
        }
    }

    public void writeTo(Writer writer) {
        if (this.count == 0) {
            return;
        }
        if (writer.fieldOrder() == Writer.FieldOrder.ASCENDING) {
            for (int i10 = 0; i10 < this.count; i10++) {
                writeField(this.tags[i10], this.objects[i10], writer);
            }
            return;
        }
        for (int i11 = this.count - 1; i11 >= 0; i11--) {
            writeField(this.tags[i11], this.objects[i11], writer);
        }
    }
}
