package com.google.protobuf;

import com.google.protobuf.Utf8;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public abstract class CodedOutputStream extends ByteOutput {
    public static final int DEFAULT_BUFFER_SIZE = 4096;

    @Deprecated
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    private boolean serializationDeterministic;
    CodedOutputStreamWriter wrapper;
    private static final Logger logger = Logger.getLogger(CodedOutputStream.class.getName());
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = UnsafeUtil.hasUnsafeArrayOperations();

    /* loaded from: classes3.dex */
    public static abstract class AbstractBufferedEncoder extends CodedOutputStream {
        final byte[] buffer;
        final int limit;
        int position;
        int totalBytesWritten;

        public AbstractBufferedEncoder(int i10) {
            super();
            if (i10 >= 0) {
                byte[] bArr = new byte[Math.max(i10, 20)];
                this.buffer = bArr;
                this.limit = bArr.length;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        public final void buffer(byte b10) {
            byte[] bArr = this.buffer;
            int i10 = this.position;
            this.position = i10 + 1;
            bArr[i10] = b10;
            this.totalBytesWritten++;
        }

        public final void bufferFixed32NoTag(int i10) {
            byte[] bArr = this.buffer;
            int i11 = this.position;
            bArr[i11] = (byte) (i10 & 255);
            bArr[i11 + 1] = (byte) ((i10 >> 8) & 255);
            bArr[i11 + 2] = (byte) ((i10 >> 16) & 255);
            this.position = i11 + 4;
            bArr[i11 + 3] = (byte) ((i10 >> 24) & 255);
            this.totalBytesWritten += 4;
        }

        public final void bufferFixed64NoTag(long j10) {
            byte[] bArr = this.buffer;
            int i10 = this.position;
            bArr[i10] = (byte) (j10 & 255);
            bArr[i10 + 1] = (byte) ((j10 >> 8) & 255);
            bArr[i10 + 2] = (byte) ((j10 >> 16) & 255);
            bArr[i10 + 3] = (byte) (255 & (j10 >> 24));
            bArr[i10 + 4] = (byte) (((int) (j10 >> 32)) & 255);
            bArr[i10 + 5] = (byte) (((int) (j10 >> 40)) & 255);
            bArr[i10 + 6] = (byte) (((int) (j10 >> 48)) & 255);
            this.position = i10 + 8;
            bArr[i10 + 7] = (byte) (((int) (j10 >> 56)) & 255);
            this.totalBytesWritten += 8;
        }

        public final void bufferInt32NoTag(int i10) {
            if (i10 >= 0) {
                bufferUInt32NoTag(i10);
            } else {
                bufferUInt64NoTag(i10);
            }
        }

        public final void bufferTag(int i10, int i11) {
            bufferUInt32NoTag(WireFormat.makeTag(i10, i11));
        }

        public final void bufferUInt32NoTag(int i10) {
            if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
                long j10 = this.position;
                while ((i10 & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i11 = this.position;
                    this.position = i11 + 1;
                    UnsafeUtil.putByte(bArr, i11, (byte) ((i10 & 127) | 128));
                    i10 >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i12 = this.position;
                this.position = i12 + 1;
                UnsafeUtil.putByte(bArr2, i12, (byte) i10);
                this.totalBytesWritten += (int) (this.position - j10);
                return;
            }
            while ((i10 & (-128)) != 0) {
                byte[] bArr3 = this.buffer;
                int i13 = this.position;
                this.position = i13 + 1;
                bArr3[i13] = (byte) ((i10 & 127) | 128);
                this.totalBytesWritten++;
                i10 >>>= 7;
            }
            byte[] bArr4 = this.buffer;
            int i14 = this.position;
            this.position = i14 + 1;
            bArr4[i14] = (byte) i10;
            this.totalBytesWritten++;
        }

        public final void bufferUInt64NoTag(long j10) {
            if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
                long j11 = this.position;
                while ((j10 & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i10 = this.position;
                    this.position = i10 + 1;
                    UnsafeUtil.putByte(bArr, i10, (byte) ((((int) j10) & 127) | 128));
                    j10 >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i11 = this.position;
                this.position = i11 + 1;
                UnsafeUtil.putByte(bArr2, i11, (byte) j10);
                this.totalBytesWritten += (int) (this.position - j11);
                return;
            }
            while ((j10 & (-128)) != 0) {
                byte[] bArr3 = this.buffer;
                int i12 = this.position;
                this.position = i12 + 1;
                bArr3[i12] = (byte) ((((int) j10) & 127) | 128);
                this.totalBytesWritten++;
                j10 >>>= 7;
            }
            byte[] bArr4 = this.buffer;
            int i13 = this.position;
            this.position = i13 + 1;
            bArr4[i13] = (byte) j10;
            this.totalBytesWritten++;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.totalBytesWritten;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int spaceLeft() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    /* loaded from: classes3.dex */
    public static class ArrayEncoder extends CodedOutputStream {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        public ArrayEncoder(byte[] bArr, int i10, int i11) {
            super();
            if (bArr != null) {
                int i12 = i10 + i11;
                if ((i10 | i11 | (bArr.length - i12)) >= 0) {
                    this.buffer = bArr;
                    this.offset = i10;
                    this.position = i10;
                    this.limit = i12;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i10), Integer.valueOf(i11)));
            }
            throw new NullPointerException("buffer");
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.position - this.offset;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int spaceLeft() {
            return this.limit - this.position;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(byte b10) {
            try {
                byte[] bArr = this.buffer;
                int i10 = this.position;
                this.position = i10 + 1;
                bArr[i10] = b10;
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e10);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBool(int i10, boolean z10) {
            writeTag(i10, 0);
            write(z10 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArray(int i10, byte[] bArr) {
            writeByteArray(i10, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArrayNoTag(byte[] bArr, int i10, int i11) {
            writeUInt32NoTag(i11);
            write(bArr, i10, i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteBuffer(int i10, ByteBuffer byteBuffer) {
            writeTag(i10, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBytes(int i10, ByteString byteString) {
            writeTag(i10, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBytesNoTag(ByteString byteString) {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed32(int i10, int i11) {
            writeTag(i10, 5);
            writeFixed32NoTag(i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed32NoTag(int i10) {
            try {
                byte[] bArr = this.buffer;
                int i11 = this.position;
                bArr[i11] = (byte) (i10 & 255);
                bArr[i11 + 1] = (byte) ((i10 >> 8) & 255);
                bArr[i11 + 2] = (byte) ((i10 >> 16) & 255);
                this.position = i11 + 4;
                bArr[i11 + 3] = (byte) ((i10 >> 24) & 255);
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e10);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed64(int i10, long j10) {
            writeTag(i10, 1);
            writeFixed64NoTag(j10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed64NoTag(long j10) {
            try {
                byte[] bArr = this.buffer;
                int i10 = this.position;
                bArr[i10] = (byte) (((int) j10) & 255);
                bArr[i10 + 1] = (byte) (((int) (j10 >> 8)) & 255);
                bArr[i10 + 2] = (byte) (((int) (j10 >> 16)) & 255);
                bArr[i10 + 3] = (byte) (((int) (j10 >> 24)) & 255);
                bArr[i10 + 4] = (byte) (((int) (j10 >> 32)) & 255);
                bArr[i10 + 5] = (byte) (((int) (j10 >> 40)) & 255);
                bArr[i10 + 6] = (byte) (((int) (j10 >> 48)) & 255);
                this.position = i10 + 8;
                bArr[i10 + 7] = (byte) (((int) (j10 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e10);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeInt32(int i10, int i11) {
            writeTag(i10, 0);
            writeInt32NoTag(i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeInt32NoTag(int i10) {
            if (i10 >= 0) {
                writeUInt32NoTag(i10);
            } else {
                writeUInt64NoTag(i10);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void writeLazy(byte[] bArr, int i10, int i11) {
            write(bArr, i10, i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessage(int i10, MessageLite messageLite) {
            writeTag(i10, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessageNoTag(MessageLite messageLite) {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessageSetExtension(int i10, MessageLite messageLite) {
            writeTag(1, 3);
            writeUInt32(2, i10);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeRawBytes(ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            Java8Compatibility.clear(duplicate);
            write(duplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeRawMessageSetExtension(int i10, ByteString byteString) {
            writeTag(1, 3);
            writeUInt32(2, i10);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeString(int i10, String str) {
            writeTag(i10, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeStringNoTag(String str) {
            int i10 = this.position;
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int i11 = i10 + computeUInt32SizeNoTag2;
                    this.position = i11;
                    int encode = Utf8.encode(str, this.buffer, i11, spaceLeft());
                    this.position = i10;
                    writeUInt32NoTag((encode - i10) - computeUInt32SizeNoTag2);
                    this.position = encode;
                } else {
                    writeUInt32NoTag(Utf8.encodedLength(str));
                    this.position = Utf8.encode(str, this.buffer, this.position, spaceLeft());
                }
            } catch (Utf8.UnpairedSurrogateException e10) {
                this.position = i10;
                inefficientWriteStringNoTag(str, e10);
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(e11);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeTag(int i10, int i11) {
            writeUInt32NoTag(WireFormat.makeTag(i10, i11));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt32(int i10, int i11) {
            writeTag(i10, 0);
            writeUInt32NoTag(i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt32NoTag(int i10) {
            while ((i10 & (-128)) != 0) {
                try {
                    byte[] bArr = this.buffer;
                    int i11 = this.position;
                    this.position = i11 + 1;
                    bArr[i11] = (byte) ((i10 & 127) | 128);
                    i10 >>>= 7;
                } catch (IndexOutOfBoundsException e10) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e10);
                }
            }
            byte[] bArr2 = this.buffer;
            int i12 = this.position;
            this.position = i12 + 1;
            bArr2[i12] = (byte) i10;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt64(int i10, long j10) {
            writeTag(i10, 0);
            writeUInt64NoTag(j10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt64NoTag(long j10) {
            if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS && spaceLeft() >= 10) {
                while ((j10 & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i10 = this.position;
                    this.position = i10 + 1;
                    UnsafeUtil.putByte(bArr, i10, (byte) ((((int) j10) & 127) | 128));
                    j10 >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i11 = this.position;
                this.position = i11 + 1;
                UnsafeUtil.putByte(bArr2, i11, (byte) j10);
                return;
            }
            while ((j10 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.buffer;
                    int i12 = this.position;
                    this.position = i12 + 1;
                    bArr3[i12] = (byte) ((((int) j10) & 127) | 128);
                    j10 >>>= 7;
                } catch (IndexOutOfBoundsException e10) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e10);
                }
            }
            byte[] bArr4 = this.buffer;
            int i13 = this.position;
            this.position = i13 + 1;
            bArr4[i13] = (byte) j10;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArray(int i10, byte[] bArr, int i11, int i12) {
            writeTag(i10, 2);
            writeByteArrayNoTag(bArr, i11, i12);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void writeLazy(ByteBuffer byteBuffer) {
            write(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessage(int i10, MessageLite messageLite, Schema schema) {
            writeTag(i10, 2);
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessageNoTag(MessageLite messageLite, Schema schema) {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(byte[] bArr, int i10, int i11) {
            try {
                System.arraycopy(bArr, i10, this.buffer, this.position, i11);
                this.position += i11;
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i11)), e10);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.buffer, this.position, remaining);
                this.position += remaining;
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(remaining)), e10);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
        }
    }

    /* loaded from: classes3.dex */
    public static final class ByteOutputEncoder extends AbstractBufferedEncoder {
        private final ByteOutput out;

        public ByteOutputEncoder(ByteOutput byteOutput, int i10) {
            super(i10);
            if (byteOutput != null) {
                this.out = byteOutput;
                return;
            }
            throw new NullPointerException("out");
        }

        private void doFlush() {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        private void flushIfNotAvailable(int i10) {
            if (this.limit - this.position < i10) {
                doFlush();
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
            if (this.position > 0) {
                doFlush();
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte b10) {
            if (this.position == this.limit) {
                doFlush();
            }
            buffer(b10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int i10, boolean z10) {
            flushIfNotAvailable(11);
            bufferTag(i10, 0);
            buffer(z10 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i10, byte[] bArr) {
            writeByteArray(i10, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i10, int i11) {
            writeUInt32NoTag(i11);
            write(bArr, i10, i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int i10, ByteBuffer byteBuffer) {
            writeTag(i10, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int i10, ByteString byteString) {
            writeTag(i10, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int i10, int i11) {
            flushIfNotAvailable(14);
            bufferTag(i10, 5);
            bufferFixed32NoTag(i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i10) {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(i10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int i10, long j10) {
            flushIfNotAvailable(18);
            bufferTag(i10, 1);
            bufferFixed64NoTag(j10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j10) {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(j10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int i10, int i11) {
            flushIfNotAvailable(20);
            bufferTag(i10, 0);
            bufferInt32NoTag(i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i10) {
            if (i10 >= 0) {
                writeUInt32NoTag(i10);
            } else {
                writeUInt64NoTag(i10);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i10, int i11) {
            flush();
            this.out.writeLazy(bArr, i10, i11);
            this.totalBytesWritten += i11;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i10, MessageLite messageLite) {
            writeTag(i10, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i10, MessageLite messageLite) {
            writeTag(1, 3);
            writeUInt32(2, i10);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            Java8Compatibility.clear(duplicate);
            write(duplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i10, ByteString byteString) {
            writeTag(1, 3);
            writeUInt32(2, i10);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int i10, String str) {
            writeTag(i10, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) {
            int length = str.length() * 3;
            int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(length);
            int i10 = computeUInt32SizeNoTag + length;
            int i11 = this.limit;
            if (i10 > i11) {
                byte[] bArr = new byte[length];
                int encode = Utf8.encode(str, bArr, 0, length);
                writeUInt32NoTag(encode);
                writeLazy(bArr, 0, encode);
                return;
            }
            if (i10 > i11 - this.position) {
                doFlush();
            }
            int i12 = this.position;
            try {
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int i13 = i12 + computeUInt32SizeNoTag2;
                    this.position = i13;
                    int encode2 = Utf8.encode(str, this.buffer, i13, this.limit - i13);
                    this.position = i12;
                    int i14 = (encode2 - i12) - computeUInt32SizeNoTag2;
                    bufferUInt32NoTag(i14);
                    this.position = encode2;
                    this.totalBytesWritten += i14;
                } else {
                    int encodedLength = Utf8.encodedLength(str);
                    bufferUInt32NoTag(encodedLength);
                    this.position = Utf8.encode(str, this.buffer, this.position, encodedLength);
                    this.totalBytesWritten += encodedLength;
                }
            } catch (Utf8.UnpairedSurrogateException e10) {
                this.totalBytesWritten -= this.position - i12;
                this.position = i12;
                inefficientWriteStringNoTag(str, e10);
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(e11);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int i10, int i11) {
            writeUInt32NoTag(WireFormat.makeTag(i10, i11));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int i10, int i11) {
            flushIfNotAvailable(20);
            bufferTag(i10, 0);
            bufferUInt32NoTag(i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i10) {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(i10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int i10, long j10) {
            flushIfNotAvailable(20);
            bufferTag(i10, 0);
            bufferUInt64NoTag(j10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j10) {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(j10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i10, byte[] bArr, int i11, int i12) {
            writeTag(i10, 2);
            writeByteArrayNoTag(bArr, i11, i12);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i10, MessageLite messageLite, Schema schema) {
            writeTag(i10, 2);
            writeMessageNoTag(messageLite, schema);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite, Schema schema) {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i10, int i11) {
            flush();
            this.out.write(bArr, i10, i11);
            this.totalBytesWritten += i11;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            flush();
            int remaining = byteBuffer.remaining();
            this.out.writeLazy(byteBuffer);
            this.totalBytesWritten += remaining;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) {
            flush();
            int remaining = byteBuffer.remaining();
            this.out.write(byteBuffer);
            this.totalBytesWritten += remaining;
        }
    }

    /* loaded from: classes3.dex */
    public static final class HeapNioEncoder extends ArrayEncoder {
        private final ByteBuffer byteBuffer;
        private int initialPosition;

        public HeapNioEncoder(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.byteBuffer = byteBuffer;
            this.initialPosition = byteBuffer.position();
        }

        @Override // com.google.protobuf.CodedOutputStream.ArrayEncoder, com.google.protobuf.CodedOutputStream
        public void flush() {
            Java8Compatibility.position(this.byteBuffer, this.initialPosition + getTotalBytesWritten());
        }
    }

    /* loaded from: classes3.dex */
    public static class OutOfSpaceException extends IOException {
        private static final String MESSAGE = "CodedOutputStream was writing to a flat byte array and ran out of space.";
        private static final long serialVersionUID = -6947486886997889499L;

        public OutOfSpaceException() {
            super(MESSAGE);
        }

        public OutOfSpaceException(String str) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str);
        }

        public OutOfSpaceException(Throwable th) {
            super(MESSAGE, th);
        }

        public OutOfSpaceException(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OutputStreamEncoder extends AbstractBufferedEncoder {
        private final OutputStream out;

        public OutputStreamEncoder(OutputStream outputStream, int i10) {
            super(i10);
            if (outputStream != null) {
                this.out = outputStream;
                return;
            }
            throw new NullPointerException("out");
        }

        private void doFlush() {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        private void flushIfNotAvailable(int i10) {
            if (this.limit - this.position < i10) {
                doFlush();
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
            if (this.position > 0) {
                doFlush();
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte b10) {
            if (this.position == this.limit) {
                doFlush();
            }
            buffer(b10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int i10, boolean z10) {
            flushIfNotAvailable(11);
            bufferTag(i10, 0);
            buffer(z10 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i10, byte[] bArr) {
            writeByteArray(i10, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i10, int i11) {
            writeUInt32NoTag(i11);
            write(bArr, i10, i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int i10, ByteBuffer byteBuffer) {
            writeTag(i10, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int i10, ByteString byteString) {
            writeTag(i10, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int i10, int i11) {
            flushIfNotAvailable(14);
            bufferTag(i10, 5);
            bufferFixed32NoTag(i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i10) {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(i10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int i10, long j10) {
            flushIfNotAvailable(18);
            bufferTag(i10, 1);
            bufferFixed64NoTag(j10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j10) {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(j10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int i10, int i11) {
            flushIfNotAvailable(20);
            bufferTag(i10, 0);
            bufferInt32NoTag(i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i10) {
            if (i10 >= 0) {
                writeUInt32NoTag(i10);
            } else {
                writeUInt64NoTag(i10);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i10, int i11) {
            write(bArr, i10, i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i10, MessageLite messageLite) {
            writeTag(i10, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i10, MessageLite messageLite) {
            writeTag(1, 3);
            writeUInt32(2, i10);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            Java8Compatibility.clear(duplicate);
            write(duplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i10, ByteString byteString) {
            writeTag(1, 3);
            writeUInt32(2, i10);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int i10, String str) {
            writeTag(i10, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) {
            int encodedLength;
            try {
                int length = str.length() * 3;
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(length);
                int i10 = computeUInt32SizeNoTag + length;
                int i11 = this.limit;
                if (i10 > i11) {
                    byte[] bArr = new byte[length];
                    int encode = Utf8.encode(str, bArr, 0, length);
                    writeUInt32NoTag(encode);
                    writeLazy(bArr, 0, encode);
                    return;
                }
                if (i10 > i11 - this.position) {
                    doFlush();
                }
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                int i12 = this.position;
                try {
                    if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                        int i13 = i12 + computeUInt32SizeNoTag2;
                        this.position = i13;
                        int encode2 = Utf8.encode(str, this.buffer, i13, this.limit - i13);
                        this.position = i12;
                        encodedLength = (encode2 - i12) - computeUInt32SizeNoTag2;
                        bufferUInt32NoTag(encodedLength);
                        this.position = encode2;
                    } else {
                        encodedLength = Utf8.encodedLength(str);
                        bufferUInt32NoTag(encodedLength);
                        this.position = Utf8.encode(str, this.buffer, this.position, encodedLength);
                    }
                    this.totalBytesWritten += encodedLength;
                } catch (Utf8.UnpairedSurrogateException e10) {
                    this.totalBytesWritten -= this.position - i12;
                    this.position = i12;
                    throw e10;
                } catch (ArrayIndexOutOfBoundsException e11) {
                    throw new OutOfSpaceException(e11);
                }
            } catch (Utf8.UnpairedSurrogateException e12) {
                inefficientWriteStringNoTag(str, e12);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int i10, int i11) {
            writeUInt32NoTag(WireFormat.makeTag(i10, i11));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int i10, int i11) {
            flushIfNotAvailable(20);
            bufferTag(i10, 0);
            bufferUInt32NoTag(i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i10) {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(i10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int i10, long j10) {
            flushIfNotAvailable(20);
            bufferTag(i10, 0);
            bufferUInt64NoTag(j10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j10) {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(j10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i10, byte[] bArr, int i11, int i12) {
            writeTag(i10, 2);
            writeByteArrayNoTag(bArr, i11, i12);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            write(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i10, MessageLite messageLite, Schema schema) {
            writeTag(i10, 2);
            writeMessageNoTag(messageLite, schema);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite, Schema schema) {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i10, int i11) {
            int i12 = this.limit;
            int i13 = this.position;
            if (i12 - i13 >= i11) {
                System.arraycopy(bArr, i10, this.buffer, i13, i11);
                this.position += i11;
                this.totalBytesWritten += i11;
                return;
            }
            int i14 = i12 - i13;
            System.arraycopy(bArr, i10, this.buffer, i13, i14);
            int i15 = i10 + i14;
            int i16 = i11 - i14;
            this.position = this.limit;
            this.totalBytesWritten += i14;
            doFlush();
            if (i16 <= this.limit) {
                System.arraycopy(bArr, i15, this.buffer, 0, i16);
                this.position = i16;
            } else {
                this.out.write(bArr, i15, i16);
            }
            this.totalBytesWritten += i16;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            int i10 = this.limit;
            int i11 = this.position;
            if (i10 - i11 >= remaining) {
                byteBuffer.get(this.buffer, i11, remaining);
                this.position += remaining;
                this.totalBytesWritten += remaining;
                return;
            }
            int i12 = i10 - i11;
            byteBuffer.get(this.buffer, i11, i12);
            int i13 = remaining - i12;
            this.position = this.limit;
            this.totalBytesWritten += i12;
            doFlush();
            while (true) {
                int i14 = this.limit;
                if (i13 > i14) {
                    byteBuffer.get(this.buffer, 0, i14);
                    this.out.write(this.buffer, 0, this.limit);
                    int i15 = this.limit;
                    i13 -= i15;
                    this.totalBytesWritten += i15;
                } else {
                    byteBuffer.get(this.buffer, 0, i13);
                    this.position = i13;
                    this.totalBytesWritten += i13;
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class SafeDirectNioEncoder extends CodedOutputStream {
        private final ByteBuffer buffer;
        private final int initialPosition;
        private final ByteBuffer originalBuffer;

        public SafeDirectNioEncoder(ByteBuffer byteBuffer) {
            super();
            this.originalBuffer = byteBuffer;
            this.buffer = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.initialPosition = byteBuffer.position();
        }

        private void encode(String str) {
            try {
                Utf8.encodeUtf8(str, this.buffer);
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(e10);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
            Java8Compatibility.position(this.originalBuffer, this.buffer.position());
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int getTotalBytesWritten() {
            return this.buffer.position() - this.initialPosition;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int spaceLeft() {
            return this.buffer.remaining();
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte b10) {
            try {
                this.buffer.put(b10);
            } catch (BufferOverflowException e10) {
                throw new OutOfSpaceException(e10);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int i10, boolean z10) {
            writeTag(i10, 0);
            write(z10 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i10, byte[] bArr) {
            writeByteArray(i10, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i10, int i11) {
            writeUInt32NoTag(i11);
            write(bArr, i10, i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int i10, ByteBuffer byteBuffer) {
            writeTag(i10, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int i10, ByteString byteString) {
            writeTag(i10, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int i10, int i11) {
            writeTag(i10, 5);
            writeFixed32NoTag(i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i10) {
            try {
                this.buffer.putInt(i10);
            } catch (BufferOverflowException e10) {
                throw new OutOfSpaceException(e10);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int i10, long j10) {
            writeTag(i10, 1);
            writeFixed64NoTag(j10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j10) {
            try {
                this.buffer.putLong(j10);
            } catch (BufferOverflowException e10) {
                throw new OutOfSpaceException(e10);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int i10, int i11) {
            writeTag(i10, 0);
            writeInt32NoTag(i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i10) {
            if (i10 >= 0) {
                writeUInt32NoTag(i10);
            } else {
                writeUInt64NoTag(i10);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i10, int i11) {
            write(bArr, i10, i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i10, MessageLite messageLite) {
            writeTag(i10, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i10, MessageLite messageLite) {
            writeTag(1, 3);
            writeUInt32(2, i10);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            Java8Compatibility.clear(duplicate);
            write(duplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i10, ByteString byteString) {
            writeTag(1, 3);
            writeUInt32(2, i10);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int i10, String str) {
            writeTag(i10, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) {
            int position = this.buffer.position();
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int position2 = this.buffer.position() + computeUInt32SizeNoTag2;
                    Java8Compatibility.position(this.buffer, position2);
                    encode(str);
                    int position3 = this.buffer.position();
                    Java8Compatibility.position(this.buffer, position);
                    writeUInt32NoTag(position3 - position2);
                    Java8Compatibility.position(this.buffer, position3);
                } else {
                    writeUInt32NoTag(Utf8.encodedLength(str));
                    encode(str);
                }
            } catch (Utf8.UnpairedSurrogateException e10) {
                Java8Compatibility.position(this.buffer, position);
                inefficientWriteStringNoTag(str, e10);
            } catch (IllegalArgumentException e11) {
                throw new OutOfSpaceException(e11);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int i10, int i11) {
            writeUInt32NoTag(WireFormat.makeTag(i10, i11));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int i10, int i11) {
            writeTag(i10, 0);
            writeUInt32NoTag(i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i10) {
            while ((i10 & (-128)) != 0) {
                try {
                    this.buffer.put((byte) ((i10 & 127) | 128));
                    i10 >>>= 7;
                } catch (BufferOverflowException e10) {
                    throw new OutOfSpaceException(e10);
                }
            }
            this.buffer.put((byte) i10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int i10, long j10) {
            writeTag(i10, 0);
            writeUInt64NoTag(j10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j10) {
            while (((-128) & j10) != 0) {
                try {
                    this.buffer.put((byte) ((((int) j10) & 127) | 128));
                    j10 >>>= 7;
                } catch (BufferOverflowException e10) {
                    throw new OutOfSpaceException(e10);
                }
            }
            this.buffer.put((byte) j10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i10, byte[] bArr, int i11, int i12) {
            writeTag(i10, 2);
            writeByteArrayNoTag(bArr, i11, i12);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            write(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i10, int i11) {
            try {
                this.buffer.put(bArr, i10, i11);
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(e10);
            } catch (BufferOverflowException e11) {
                throw new OutOfSpaceException(e11);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i10, MessageLite messageLite, Schema schema) {
            writeTag(i10, 2);
            writeMessageNoTag(messageLite, schema);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite, Schema schema) {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) {
            try {
                this.buffer.put(byteBuffer);
            } catch (BufferOverflowException e10) {
                throw new OutOfSpaceException(e10);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class UnsafeDirectNioEncoder extends CodedOutputStream {
        private final long address;
        private final ByteBuffer buffer;
        private final long initialPosition;
        private final long limit;
        private final long oneVarintLimit;
        private final ByteBuffer originalBuffer;
        private long position;

        public UnsafeDirectNioEncoder(ByteBuffer byteBuffer) {
            super();
            this.originalBuffer = byteBuffer;
            this.buffer = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            long addressOffset = UnsafeUtil.addressOffset(byteBuffer);
            this.address = addressOffset;
            long position = byteBuffer.position() + addressOffset;
            this.initialPosition = position;
            long limit = addressOffset + byteBuffer.limit();
            this.limit = limit;
            this.oneVarintLimit = limit - 10;
            this.position = position;
        }

        private int bufferPos(long j10) {
            return (int) (j10 - this.address);
        }

        public static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void repositionBuffer(long j10) {
            Java8Compatibility.position(this.buffer, bufferPos(j10));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
            Java8Compatibility.position(this.originalBuffer, bufferPos(this.position));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int getTotalBytesWritten() {
            return (int) (this.position - this.initialPosition);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int spaceLeft() {
            return (int) (this.limit - this.position);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte b10) {
            long j10 = this.position;
            if (j10 < this.limit) {
                this.position = 1 + j10;
                UnsafeUtil.putByte(j10, b10);
                return;
            }
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.position), Long.valueOf(this.limit), 1));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int i10, boolean z10) {
            writeTag(i10, 0);
            write(z10 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i10, byte[] bArr) {
            writeByteArray(i10, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i10, int i11) {
            writeUInt32NoTag(i11);
            write(bArr, i10, i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int i10, ByteBuffer byteBuffer) {
            writeTag(i10, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int i10, ByteString byteString) {
            writeTag(i10, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int i10, int i11) {
            writeTag(i10, 5);
            writeFixed32NoTag(i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i10) {
            this.buffer.putInt(bufferPos(this.position), i10);
            this.position += 4;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int i10, long j10) {
            writeTag(i10, 1);
            writeFixed64NoTag(j10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j10) {
            this.buffer.putLong(bufferPos(this.position), j10);
            this.position += 8;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int i10, int i11) {
            writeTag(i10, 0);
            writeInt32NoTag(i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i10) {
            if (i10 >= 0) {
                writeUInt32NoTag(i10);
            } else {
                writeUInt64NoTag(i10);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i10, int i11) {
            write(bArr, i10, i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i10, MessageLite messageLite) {
            writeTag(i10, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i10, MessageLite messageLite) {
            writeTag(1, 3);
            writeUInt32(2, i10);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            Java8Compatibility.clear(duplicate);
            write(duplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i10, ByteString byteString) {
            writeTag(1, 3);
            writeUInt32(2, i10);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int i10, String str) {
            writeTag(i10, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) {
            long j10 = this.position;
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int bufferPos = bufferPos(this.position) + computeUInt32SizeNoTag2;
                    Java8Compatibility.position(this.buffer, bufferPos);
                    Utf8.encodeUtf8(str, this.buffer);
                    int position = this.buffer.position() - bufferPos;
                    writeUInt32NoTag(position);
                    this.position += position;
                } else {
                    int encodedLength = Utf8.encodedLength(str);
                    writeUInt32NoTag(encodedLength);
                    repositionBuffer(this.position);
                    Utf8.encodeUtf8(str, this.buffer);
                    this.position += encodedLength;
                }
            } catch (Utf8.UnpairedSurrogateException e10) {
                this.position = j10;
                repositionBuffer(j10);
                inefficientWriteStringNoTag(str, e10);
            } catch (IllegalArgumentException e11) {
                throw new OutOfSpaceException(e11);
            } catch (IndexOutOfBoundsException e12) {
                throw new OutOfSpaceException(e12);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int i10, int i11) {
            writeUInt32NoTag(WireFormat.makeTag(i10, i11));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int i10, int i11) {
            writeTag(i10, 0);
            writeUInt32NoTag(i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i10) {
            if (this.position <= this.oneVarintLimit) {
                while ((i10 & (-128)) != 0) {
                    long j10 = this.position;
                    this.position = j10 + 1;
                    UnsafeUtil.putByte(j10, (byte) ((i10 & 127) | 128));
                    i10 >>>= 7;
                }
                long j11 = this.position;
                this.position = 1 + j11;
                UnsafeUtil.putByte(j11, (byte) i10);
                return;
            }
            while (true) {
                long j12 = this.position;
                if (j12 < this.limit) {
                    if ((i10 & (-128)) == 0) {
                        this.position = 1 + j12;
                        UnsafeUtil.putByte(j12, (byte) i10);
                        return;
                    } else {
                        this.position = j12 + 1;
                        UnsafeUtil.putByte(j12, (byte) ((i10 & 127) | 128));
                        i10 >>>= 7;
                    }
                } else {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.position), Long.valueOf(this.limit), 1));
                }
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int i10, long j10) {
            writeTag(i10, 0);
            writeUInt64NoTag(j10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j10) {
            if (this.position <= this.oneVarintLimit) {
                while ((j10 & (-128)) != 0) {
                    long j11 = this.position;
                    this.position = j11 + 1;
                    UnsafeUtil.putByte(j11, (byte) ((((int) j10) & 127) | 128));
                    j10 >>>= 7;
                }
                long j12 = this.position;
                this.position = 1 + j12;
                UnsafeUtil.putByte(j12, (byte) j10);
                return;
            }
            while (true) {
                long j13 = this.position;
                if (j13 < this.limit) {
                    if ((j10 & (-128)) == 0) {
                        this.position = 1 + j13;
                        UnsafeUtil.putByte(j13, (byte) j10);
                        return;
                    } else {
                        this.position = j13 + 1;
                        UnsafeUtil.putByte(j13, (byte) ((((int) j10) & 127) | 128));
                        j10 >>>= 7;
                    }
                } else {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.position), Long.valueOf(this.limit), 1));
                }
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i10, byte[] bArr, int i11, int i12) {
            writeTag(i10, 2);
            writeByteArrayNoTag(bArr, i11, i12);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            write(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i10, MessageLite messageLite, Schema schema) {
            writeTag(i10, 2);
            writeMessageNoTag(messageLite, schema);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite, Schema schema) {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i10, int i11) {
            if (bArr != null && i10 >= 0 && i11 >= 0 && bArr.length - i11 >= i10) {
                long j10 = i11;
                long j11 = this.limit - j10;
                long j12 = this.position;
                if (j11 >= j12) {
                    UnsafeUtil.copyMemory(bArr, i10, j12, j10);
                    this.position += j10;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException("value");
            }
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.position), Long.valueOf(this.limit), Integer.valueOf(i11)));
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) {
            try {
                int remaining = byteBuffer.remaining();
                repositionBuffer(this.position);
                this.buffer.put(byteBuffer);
                this.position += remaining;
            } catch (BufferOverflowException e10) {
                throw new OutOfSpaceException(e10);
            }
        }
    }

    public static int computeBoolSize(int i10, boolean z10) {
        return computeTagSize(i10) + computeBoolSizeNoTag(z10);
    }

    public static int computeBoolSizeNoTag(boolean z10) {
        return 1;
    }

    public static int computeByteArraySize(int i10, byte[] bArr) {
        return computeTagSize(i10) + computeByteArraySizeNoTag(bArr);
    }

    public static int computeByteArraySizeNoTag(byte[] bArr) {
        return computeLengthDelimitedFieldSize(bArr.length);
    }

    public static int computeByteBufferSize(int i10, ByteBuffer byteBuffer) {
        return computeTagSize(i10) + computeByteBufferSizeNoTag(byteBuffer);
    }

    public static int computeByteBufferSizeNoTag(ByteBuffer byteBuffer) {
        return computeLengthDelimitedFieldSize(byteBuffer.capacity());
    }

    public static int computeBytesSize(int i10, ByteString byteString) {
        return computeTagSize(i10) + computeBytesSizeNoTag(byteString);
    }

    public static int computeBytesSizeNoTag(ByteString byteString) {
        return computeLengthDelimitedFieldSize(byteString.size());
    }

    public static int computeDoubleSize(int i10, double d10) {
        return computeTagSize(i10) + computeDoubleSizeNoTag(d10);
    }

    public static int computeDoubleSizeNoTag(double d10) {
        return 8;
    }

    public static int computeEnumSize(int i10, int i11) {
        return computeTagSize(i10) + computeEnumSizeNoTag(i11);
    }

    public static int computeEnumSizeNoTag(int i10) {
        return computeInt32SizeNoTag(i10);
    }

    public static int computeFixed32Size(int i10, int i11) {
        return computeTagSize(i10) + computeFixed32SizeNoTag(i11);
    }

    public static int computeFixed32SizeNoTag(int i10) {
        return 4;
    }

    public static int computeFixed64Size(int i10, long j10) {
        return computeTagSize(i10) + computeFixed64SizeNoTag(j10);
    }

    public static int computeFixed64SizeNoTag(long j10) {
        return 8;
    }

    public static int computeFloatSize(int i10, float f10) {
        return computeTagSize(i10) + computeFloatSizeNoTag(f10);
    }

    public static int computeFloatSizeNoTag(float f10) {
        return 4;
    }

    @Deprecated
    public static int computeGroupSize(int i10, MessageLite messageLite) {
        return (computeTagSize(i10) * 2) + messageLite.getSerializedSize();
    }

    @InlineMe(replacement = "value.getSerializedSize()")
    @Deprecated
    public static int computeGroupSizeNoTag(MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    public static int computeInt32Size(int i10, int i11) {
        return computeTagSize(i10) + computeInt32SizeNoTag(i11);
    }

    public static int computeInt32SizeNoTag(int i10) {
        if (i10 >= 0) {
            return computeUInt32SizeNoTag(i10);
        }
        return 10;
    }

    public static int computeInt64Size(int i10, long j10) {
        return computeTagSize(i10) + computeInt64SizeNoTag(j10);
    }

    public static int computeInt64SizeNoTag(long j10) {
        return computeUInt64SizeNoTag(j10);
    }

    public static int computeLazyFieldMessageSetExtensionSize(int i10, LazyFieldLite lazyFieldLite) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i10) + computeLazyFieldSize(3, lazyFieldLite);
    }

    public static int computeLazyFieldSize(int i10, LazyFieldLite lazyFieldLite) {
        return computeTagSize(i10) + computeLazyFieldSizeNoTag(lazyFieldLite);
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite lazyFieldLite) {
        return computeLengthDelimitedFieldSize(lazyFieldLite.getSerializedSize());
    }

    public static int computeLengthDelimitedFieldSize(int i10) {
        return computeUInt32SizeNoTag(i10) + i10;
    }

    public static int computeMessageSetExtensionSize(int i10, MessageLite messageLite) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i10) + computeMessageSize(3, messageLite);
    }

    public static int computeMessageSize(int i10, MessageLite messageLite) {
        return computeTagSize(i10) + computeMessageSizeNoTag(messageLite);
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite) {
        return computeLengthDelimitedFieldSize(messageLite.getSerializedSize());
    }

    public static int computePreferredBufferSize(int i10) {
        if (i10 > 4096) {
            return 4096;
        }
        return i10;
    }

    public static int computeRawMessageSetExtensionSize(int i10, ByteString byteString) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i10) + computeBytesSize(3, byteString);
    }

    @InlineMe(imports = {"com.google.protobuf.CodedOutputStream"}, replacement = "CodedOutputStream.computeUInt32SizeNoTag(value)")
    @Deprecated
    public static int computeRawVarint32Size(int i10) {
        return computeUInt32SizeNoTag(i10);
    }

    @InlineMe(imports = {"com.google.protobuf.CodedOutputStream"}, replacement = "CodedOutputStream.computeUInt64SizeNoTag(value)")
    @Deprecated
    public static int computeRawVarint64Size(long j10) {
        return computeUInt64SizeNoTag(j10);
    }

    public static int computeSFixed32Size(int i10, int i11) {
        return computeTagSize(i10) + computeSFixed32SizeNoTag(i11);
    }

    public static int computeSFixed32SizeNoTag(int i10) {
        return 4;
    }

    public static int computeSFixed64Size(int i10, long j10) {
        return computeTagSize(i10) + computeSFixed64SizeNoTag(j10);
    }

    public static int computeSFixed64SizeNoTag(long j10) {
        return 8;
    }

    public static int computeSInt32Size(int i10, int i11) {
        return computeTagSize(i10) + computeSInt32SizeNoTag(i11);
    }

    public static int computeSInt32SizeNoTag(int i10) {
        return computeUInt32SizeNoTag(encodeZigZag32(i10));
    }

    public static int computeSInt64Size(int i10, long j10) {
        return computeTagSize(i10) + computeSInt64SizeNoTag(j10);
    }

    public static int computeSInt64SizeNoTag(long j10) {
        return computeUInt64SizeNoTag(encodeZigZag64(j10));
    }

    public static int computeStringSize(int i10, String str) {
        return computeTagSize(i10) + computeStringSizeNoTag(str);
    }

    public static int computeStringSizeNoTag(String str) {
        int length;
        try {
            length = Utf8.encodedLength(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            length = str.getBytes(Internal.UTF_8).length;
        }
        return computeLengthDelimitedFieldSize(length);
    }

    public static int computeTagSize(int i10) {
        return computeUInt32SizeNoTag(WireFormat.makeTag(i10, 0));
    }

    public static int computeUInt32Size(int i10, int i11) {
        return computeTagSize(i10) + computeUInt32SizeNoTag(i11);
    }

    public static int computeUInt32SizeNoTag(int i10) {
        if ((i10 & (-128)) == 0) {
            return 1;
        }
        if ((i10 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i10) == 0) {
            return 3;
        }
        if ((i10 & (-268435456)) == 0) {
            return 4;
        }
        return 5;
    }

    public static int computeUInt64Size(int i10, long j10) {
        return computeTagSize(i10) + computeUInt64SizeNoTag(j10);
    }

    public static int computeUInt64SizeNoTag(long j10) {
        int i10;
        if (((-128) & j10) == 0) {
            return 1;
        }
        if (j10 < 0) {
            return 10;
        }
        if (((-34359738368L) & j10) != 0) {
            j10 >>>= 28;
            i10 = 6;
        } else {
            i10 = 2;
        }
        if (((-2097152) & j10) != 0) {
            i10 += 2;
            j10 >>>= 14;
        }
        if ((j10 & (-16384)) != 0) {
            return i10 + 1;
        }
        return i10;
    }

    public static int encodeZigZag32(int i10) {
        return (i10 >> 31) ^ (i10 << 1);
    }

    public static long encodeZigZag64(long j10) {
        return (j10 >> 63) ^ (j10 << 1);
    }

    public static CodedOutputStream newInstance(OutputStream outputStream) {
        return newInstance(outputStream, 4096);
    }

    public static CodedOutputStream newSafeInstance(ByteBuffer byteBuffer) {
        return new SafeDirectNioEncoder(byteBuffer);
    }

    public static CodedOutputStream newUnsafeInstance(ByteBuffer byteBuffer) {
        return new UnsafeDirectNioEncoder(byteBuffer);
    }

    public final void checkNoSpaceLeft() {
        if (spaceLeft() == 0) {
        } else {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void flush();

    public abstract int getTotalBytesWritten();

    public final void inefficientWriteStringNoTag(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) {
        logger.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) unpairedSurrogateException);
        byte[] bytes = str.getBytes(Internal.UTF_8);
        try {
            writeUInt32NoTag(bytes.length);
            writeLazy(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e10) {
            throw new OutOfSpaceException(e10);
        }
    }

    public boolean isSerializationDeterministic() {
        return this.serializationDeterministic;
    }

    public abstract int spaceLeft();

    public void useDeterministicSerialization() {
        this.serializationDeterministic = true;
    }

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(byte b10);

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(ByteBuffer byteBuffer);

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(byte[] bArr, int i10, int i11);

    public abstract void writeBool(int i10, boolean z10);

    public final void writeBoolNoTag(boolean z10) {
        write(z10 ? (byte) 1 : (byte) 0);
    }

    public abstract void writeByteArray(int i10, byte[] bArr);

    public abstract void writeByteArray(int i10, byte[] bArr, int i11, int i12);

    public final void writeByteArrayNoTag(byte[] bArr) {
        writeByteArrayNoTag(bArr, 0, bArr.length);
    }

    public abstract void writeByteArrayNoTag(byte[] bArr, int i10, int i11);

    public abstract void writeByteBuffer(int i10, ByteBuffer byteBuffer);

    public abstract void writeBytes(int i10, ByteString byteString);

    public abstract void writeBytesNoTag(ByteString byteString);

    public final void writeDouble(int i10, double d10) {
        writeFixed64(i10, Double.doubleToRawLongBits(d10));
    }

    public final void writeDoubleNoTag(double d10) {
        writeFixed64NoTag(Double.doubleToRawLongBits(d10));
    }

    public final void writeEnum(int i10, int i11) {
        writeInt32(i10, i11);
    }

    public final void writeEnumNoTag(int i10) {
        writeInt32NoTag(i10);
    }

    public abstract void writeFixed32(int i10, int i11);

    public abstract void writeFixed32NoTag(int i10);

    public abstract void writeFixed64(int i10, long j10);

    public abstract void writeFixed64NoTag(long j10);

    public final void writeFloat(int i10, float f10) {
        writeFixed32(i10, Float.floatToRawIntBits(f10));
    }

    public final void writeFloatNoTag(float f10) {
        writeFixed32NoTag(Float.floatToRawIntBits(f10));
    }

    @Deprecated
    public final void writeGroup(int i10, MessageLite messageLite) {
        writeTag(i10, 3);
        writeGroupNoTag(messageLite);
        writeTag(i10, 4);
    }

    @Deprecated
    public final void writeGroupNoTag(MessageLite messageLite) {
        messageLite.writeTo(this);
    }

    public abstract void writeInt32(int i10, int i11);

    public abstract void writeInt32NoTag(int i10);

    public final void writeInt64(int i10, long j10) {
        writeUInt64(i10, j10);
    }

    public final void writeInt64NoTag(long j10) {
        writeUInt64NoTag(j10);
    }

    @Override // com.google.protobuf.ByteOutput
    public abstract void writeLazy(ByteBuffer byteBuffer);

    @Override // com.google.protobuf.ByteOutput
    public abstract void writeLazy(byte[] bArr, int i10, int i11);

    public abstract void writeMessage(int i10, MessageLite messageLite);

    public abstract void writeMessage(int i10, MessageLite messageLite, Schema schema);

    public abstract void writeMessageNoTag(MessageLite messageLite);

    public abstract void writeMessageNoTag(MessageLite messageLite, Schema schema);

    public abstract void writeMessageSetExtension(int i10, MessageLite messageLite);

    public final void writeRawByte(byte b10) {
        write(b10);
    }

    public abstract void writeRawBytes(ByteBuffer byteBuffer);

    public final void writeRawBytes(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @InlineMe(replacement = "this.writeFixed32NoTag(value)")
    @Deprecated
    public final void writeRawLittleEndian32(int i10) {
        writeFixed32NoTag(i10);
    }

    @InlineMe(replacement = "this.writeFixed64NoTag(value)")
    @Deprecated
    public final void writeRawLittleEndian64(long j10) {
        writeFixed64NoTag(j10);
    }

    public abstract void writeRawMessageSetExtension(int i10, ByteString byteString);

    @InlineMe(replacement = "this.writeUInt32NoTag(value)")
    @Deprecated
    public final void writeRawVarint32(int i10) {
        writeUInt32NoTag(i10);
    }

    @InlineMe(replacement = "this.writeUInt64NoTag(value)")
    @Deprecated
    public final void writeRawVarint64(long j10) {
        writeUInt64NoTag(j10);
    }

    public final void writeSFixed32(int i10, int i11) {
        writeFixed32(i10, i11);
    }

    public final void writeSFixed32NoTag(int i10) {
        writeFixed32NoTag(i10);
    }

    public final void writeSFixed64(int i10, long j10) {
        writeFixed64(i10, j10);
    }

    public final void writeSFixed64NoTag(long j10) {
        writeFixed64NoTag(j10);
    }

    public final void writeSInt32(int i10, int i11) {
        writeUInt32(i10, encodeZigZag32(i11));
    }

    public final void writeSInt32NoTag(int i10) {
        writeUInt32NoTag(encodeZigZag32(i10));
    }

    public final void writeSInt64(int i10, long j10) {
        writeUInt64(i10, encodeZigZag64(j10));
    }

    public final void writeSInt64NoTag(long j10) {
        writeUInt64NoTag(encodeZigZag64(j10));
    }

    public abstract void writeString(int i10, String str);

    public abstract void writeStringNoTag(String str);

    public abstract void writeTag(int i10, int i11);

    public abstract void writeUInt32(int i10, int i11);

    public abstract void writeUInt32NoTag(int i10);

    public abstract void writeUInt64(int i10, long j10);

    public abstract void writeUInt64NoTag(long j10);

    private CodedOutputStream() {
    }

    @Deprecated
    public static int computeGroupSize(int i10, MessageLite messageLite, Schema schema) {
        return (computeTagSize(i10) * 2) + computeGroupSizeNoTag(messageLite, schema);
    }

    @Deprecated
    public static int computeGroupSizeNoTag(MessageLite messageLite, Schema schema) {
        return ((AbstractMessageLite) messageLite).getSerializedSize(schema);
    }

    public static int computeMessageSize(int i10, MessageLite messageLite, Schema schema) {
        return computeTagSize(i10) + computeMessageSizeNoTag(messageLite, schema);
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite, Schema schema) {
        return computeLengthDelimitedFieldSize(((AbstractMessageLite) messageLite).getSerializedSize(schema));
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int i10) {
        return new OutputStreamEncoder(outputStream, i10);
    }

    @Deprecated
    public final void writeGroupNoTag(MessageLite messageLite, Schema schema) {
        schema.writeTo(messageLite, this.wrapper);
    }

    public final void writeRawByte(int i10) {
        write((byte) i10);
    }

    public final void writeRawBytes(byte[] bArr, int i10, int i11) {
        write(bArr, i10, i11);
    }

    public static CodedOutputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public final void writeRawBytes(ByteString byteString) {
        byteString.writeTo(this);
    }

    public static CodedOutputStream newInstance(byte[] bArr, int i10, int i11) {
        return new ArrayEncoder(bArr, i10, i11);
    }

    @Deprecated
    public final void writeGroup(int i10, MessageLite messageLite, Schema schema) {
        writeTag(i10, 3);
        writeGroupNoTag(messageLite, schema);
        writeTag(i10, 4);
    }

    public static CodedOutputStream newInstance(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new HeapNioEncoder(byteBuffer);
        }
        if (byteBuffer.isDirect() && !byteBuffer.isReadOnly()) {
            if (UnsafeDirectNioEncoder.isSupported()) {
                return newUnsafeInstance(byteBuffer);
            }
            return newSafeInstance(byteBuffer);
        }
        throw new IllegalArgumentException("ByteBuffer is read-only");
    }

    @Deprecated
    public static CodedOutputStream newInstance(ByteBuffer byteBuffer, int i10) {
        return newInstance(byteBuffer);
    }

    public static CodedOutputStream newInstance(ByteOutput byteOutput, int i10) {
        if (i10 >= 0) {
            return new ByteOutputEncoder(byteOutput, i10);
        }
        throw new IllegalArgumentException("bufferSize must be positive");
    }
}
