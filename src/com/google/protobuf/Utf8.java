package com.google.protobuf;

import com.coui.appcompat.statement.COUIIndividualStatementDialog;
import com.heytap.accessory.constant.FastPairConstants;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class Utf8 {
    private static final long ASCII_MASK_LONG = -9187201950435737472L;
    static final int COMPLETE = 0;
    static final int MALFORMED = -1;
    static final int MAX_BYTES_PER_CHAR = 3;
    private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
    private static final Processor processor;

    /* loaded from: classes3.dex */
    public static class DecodeUtil {
        private DecodeUtil() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleFourBytes(byte b10, byte b11, byte b12, byte b13, char[] cArr, int i10) {
            if (!isNotTrailingByte(b11) && (((b10 << 28) + (b11 + 112)) >> 30) == 0 && !isNotTrailingByte(b12) && !isNotTrailingByte(b13)) {
                int trailingByteValue = ((b10 & 7) << 18) | (trailingByteValue(b11) << 12) | (trailingByteValue(b12) << 6) | trailingByteValue(b13);
                cArr[i10] = highSurrogate(trailingByteValue);
                cArr[i10 + 1] = lowSurrogate(trailingByteValue);
                return;
            }
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleOneByte(byte b10, char[] cArr, int i10) {
            cArr[i10] = (char) b10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleThreeBytes(byte b10, byte b11, byte b12, char[] cArr, int i10) {
            if (!isNotTrailingByte(b11) && ((b10 != -32 || b11 >= -96) && ((b10 != -19 || b11 < -96) && !isNotTrailingByte(b12)))) {
                cArr[i10] = (char) (((b10 & FastPairConstants.GO_INTENT_MAX) << 12) | (trailingByteValue(b11) << 6) | trailingByteValue(b12));
                return;
            }
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleTwoBytes(byte b10, byte b11, char[] cArr, int i10) {
            if (b10 >= -62 && !isNotTrailingByte(b11)) {
                cArr[i10] = (char) (((b10 & 31) << 6) | trailingByteValue(b11));
                return;
            }
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        private static char highSurrogate(int i10) {
            return (char) ((i10 >>> 10) + 55232);
        }

        private static boolean isNotTrailingByte(byte b10) {
            if (b10 > -65) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isOneByte(byte b10) {
            if (b10 >= 0) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isThreeBytes(byte b10) {
            if (b10 < -16) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isTwoBytes(byte b10) {
            if (b10 < -32) {
                return true;
            }
            return false;
        }

        private static char lowSurrogate(int i10) {
            return (char) ((i10 & 1023) + 56320);
        }

        private static int trailingByteValue(byte b10) {
            return b10 & 63;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Processor {
        public final String decodeUtf8(ByteBuffer byteBuffer, int i10, int i11) {
            if (byteBuffer.hasArray()) {
                return decodeUtf8(byteBuffer.array(), byteBuffer.arrayOffset() + i10, i11);
            }
            if (byteBuffer.isDirect()) {
                return decodeUtf8Direct(byteBuffer, i10, i11);
            }
            return decodeUtf8Default(byteBuffer, i10, i11);
        }

        public abstract String decodeUtf8(byte[] bArr, int i10, int i11);

        public final String decodeUtf8Default(ByteBuffer byteBuffer, int i10, int i11) {
            if ((i10 | i11 | ((byteBuffer.limit() - i10) - i11)) >= 0) {
                int i12 = i10 + i11;
                char[] cArr = new char[i11];
                int i13 = 0;
                while (i10 < i12) {
                    byte b10 = byteBuffer.get(i10);
                    if (!DecodeUtil.isOneByte(b10)) {
                        break;
                    }
                    i10++;
                    DecodeUtil.handleOneByte(b10, cArr, i13);
                    i13++;
                }
                int i14 = i13;
                while (i10 < i12) {
                    int i15 = i10 + 1;
                    byte b11 = byteBuffer.get(i10);
                    if (DecodeUtil.isOneByte(b11)) {
                        int i16 = i14 + 1;
                        DecodeUtil.handleOneByte(b11, cArr, i14);
                        while (i15 < i12) {
                            byte b12 = byteBuffer.get(i15);
                            if (!DecodeUtil.isOneByte(b12)) {
                                break;
                            }
                            i15++;
                            DecodeUtil.handleOneByte(b12, cArr, i16);
                            i16++;
                        }
                        i14 = i16;
                        i10 = i15;
                    } else if (DecodeUtil.isTwoBytes(b11)) {
                        if (i15 < i12) {
                            i10 += 2;
                            DecodeUtil.handleTwoBytes(b11, byteBuffer.get(i15), cArr, i14);
                            i14++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (DecodeUtil.isThreeBytes(b11)) {
                        if (i15 < i12 - 1) {
                            int i17 = i10 + 2;
                            i10 += 3;
                            DecodeUtil.handleThreeBytes(b11, byteBuffer.get(i15), byteBuffer.get(i17), cArr, i14);
                            i14++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (i15 < i12 - 2) {
                        byte b13 = byteBuffer.get(i15);
                        int i18 = i10 + 3;
                        byte b14 = byteBuffer.get(i10 + 2);
                        i10 += 4;
                        DecodeUtil.handleFourBytes(b11, b13, b14, byteBuffer.get(i18), cArr, i14);
                        i14 += 2;
                    } else {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                }
                return new String(cArr, 0, i14);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i10), Integer.valueOf(i11)));
        }

        public abstract String decodeUtf8Direct(ByteBuffer byteBuffer, int i10, int i11);

        public abstract int encodeUtf8(CharSequence charSequence, byte[] bArr, int i10, int i11);

        public final void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                int arrayOffset = byteBuffer.arrayOffset();
                Java8Compatibility.position(byteBuffer, Utf8.encode(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
            } else if (byteBuffer.isDirect()) {
                encodeUtf8Direct(charSequence, byteBuffer);
            } else {
                encodeUtf8Default(charSequence, byteBuffer);
            }
        }

        public final void encodeUtf8Default(CharSequence charSequence, ByteBuffer byteBuffer) {
            int i10;
            int length = charSequence.length();
            int position = byteBuffer.position();
            int i11 = 0;
            while (i11 < length) {
                try {
                    char charAt = charSequence.charAt(i11);
                    if (charAt >= 128) {
                        break;
                    }
                    byteBuffer.put(position + i11, (byte) charAt);
                    i11++;
                } catch (IndexOutOfBoundsException unused) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i11) + " at index " + (byteBuffer.position() + Math.max(i11, (position - byteBuffer.position()) + 1)));
                }
            }
            if (i11 == length) {
                Java8Compatibility.position(byteBuffer, position + i11);
                return;
            }
            position += i11;
            while (i11 < length) {
                char charAt2 = charSequence.charAt(i11);
                if (charAt2 < 128) {
                    byteBuffer.put(position, (byte) charAt2);
                } else if (charAt2 < 2048) {
                    int i12 = position + 1;
                    try {
                        byteBuffer.put(position, (byte) ((charAt2 >>> 6) | 192));
                        byteBuffer.put(i12, (byte) ((charAt2 & '?') | 128));
                        position = i12;
                    } catch (IndexOutOfBoundsException unused2) {
                        position = i12;
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i11) + " at index " + (byteBuffer.position() + Math.max(i11, (position - byteBuffer.position()) + 1)));
                    }
                } else {
                    if (charAt2 >= 55296 && 57343 >= charAt2) {
                        int i13 = i11 + 1;
                        if (i13 != length) {
                            try {
                                char charAt3 = charSequence.charAt(i13);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    int i14 = position + 1;
                                    try {
                                        byteBuffer.put(position, (byte) ((codePoint >>> 18) | 240));
                                        i10 = position + 2;
                                    } catch (IndexOutOfBoundsException unused3) {
                                        position = i14;
                                        i11 = i13;
                                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i11) + " at index " + (byteBuffer.position() + Math.max(i11, (position - byteBuffer.position()) + 1)));
                                    }
                                    try {
                                        byteBuffer.put(i14, (byte) (((codePoint >>> 12) & 63) | 128));
                                        position += 3;
                                        byteBuffer.put(i10, (byte) (((codePoint >>> 6) & 63) | 128));
                                        byteBuffer.put(position, (byte) ((codePoint & 63) | 128));
                                        i11 = i13;
                                    } catch (IndexOutOfBoundsException unused4) {
                                        i11 = i13;
                                        position = i10;
                                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i11) + " at index " + (byteBuffer.position() + Math.max(i11, (position - byteBuffer.position()) + 1)));
                                    }
                                } else {
                                    i11 = i13;
                                }
                            } catch (IndexOutOfBoundsException unused5) {
                            }
                        }
                        throw new UnpairedSurrogateException(i11, length);
                    }
                    int i15 = position + 1;
                    byteBuffer.put(position, (byte) ((charAt2 >>> '\f') | 224));
                    position += 2;
                    byteBuffer.put(i15, (byte) (((charAt2 >>> 6) & 63) | 128));
                    byteBuffer.put(position, (byte) ((charAt2 & '?') | 128));
                }
                i11++;
                position++;
            }
            Java8Compatibility.position(byteBuffer, position);
        }

        public abstract void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer);

        public final boolean isValidUtf8(byte[] bArr, int i10, int i11) {
            return partialIsValidUtf8(0, bArr, i10, i11) == 0;
        }

        public final int partialIsValidUtf8(int i10, ByteBuffer byteBuffer, int i11, int i12) {
            if (byteBuffer.hasArray()) {
                int arrayOffset = byteBuffer.arrayOffset();
                return partialIsValidUtf8(i10, byteBuffer.array(), i11 + arrayOffset, arrayOffset + i12);
            }
            if (byteBuffer.isDirect()) {
                return partialIsValidUtf8Direct(i10, byteBuffer, i11, i12);
            }
            return partialIsValidUtf8Default(i10, byteBuffer, i11, i12);
        }

        public abstract int partialIsValidUtf8(int i10, byte[] bArr, int i11, int i12);

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        
            if (r7.get(r8) > (-65)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x004c, code lost:
        
            if (r7.get(r8) > (-65)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x008f, code lost:
        
            if (r7.get(r6) > (-65)) goto L53;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int partialIsValidUtf8Default(int r6, java.nio.ByteBuffer r7, int r8, int r9) {
            /*
                r5 = this;
                if (r6 == 0) goto L92
                if (r8 < r9) goto L5
                return r6
            L5:
                byte r5 = (byte) r6
                r0 = -32
                r1 = -1
                r2 = -65
                if (r5 >= r0) goto L1e
                r6 = -62
                if (r5 < r6) goto L1d
                int r5 = r8 + 1
                byte r6 = r7.get(r8)
                if (r6 <= r2) goto L1a
                goto L1d
            L1a:
                r8 = r5
                goto L92
            L1d:
                return r1
            L1e:
                r3 = -16
                if (r5 >= r3) goto L4f
                int r6 = r6 >> 8
                int r6 = ~r6
                byte r6 = (byte) r6
                if (r6 != 0) goto L38
                int r6 = r8 + 1
                byte r8 = r7.get(r8)
                if (r6 < r9) goto L35
                int r5 = com.google.protobuf.Utf8.access$000(r5, r8)
                return r5
            L35:
                r4 = r8
                r8 = r6
                r6 = r4
            L38:
                if (r6 > r2) goto L4e
                r3 = -96
                if (r5 != r0) goto L40
                if (r6 < r3) goto L4e
            L40:
                r0 = -19
                if (r5 != r0) goto L46
                if (r6 >= r3) goto L4e
            L46:
                int r5 = r8 + 1
                byte r6 = r7.get(r8)
                if (r6 <= r2) goto L1a
            L4e:
                return r1
            L4f:
                int r0 = r6 >> 8
                int r0 = ~r0
                byte r0 = (byte) r0
                if (r0 != 0) goto L64
                int r6 = r8 + 1
                byte r0 = r7.get(r8)
                if (r6 < r9) goto L62
                int r5 = com.google.protobuf.Utf8.access$000(r5, r0)
                return r5
            L62:
                r8 = 0
                goto L6a
            L64:
                int r6 = r6 >> 16
                byte r6 = (byte) r6
                r4 = r8
                r8 = r6
                r6 = r4
            L6a:
                if (r8 != 0) goto L7c
                int r8 = r6 + 1
                byte r6 = r7.get(r6)
                if (r8 < r9) goto L79
                int r5 = com.google.protobuf.Utf8.access$100(r5, r0, r6)
                return r5
            L79:
                r4 = r8
                r8 = r6
                r6 = r4
            L7c:
                if (r0 > r2) goto L91
                int r5 = r5 << 28
                int r0 = r0 + 112
                int r5 = r5 + r0
                int r5 = r5 >> 30
                if (r5 != 0) goto L91
                if (r8 > r2) goto L91
                int r8 = r6 + 1
                byte r5 = r7.get(r6)
                if (r5 <= r2) goto L92
            L91:
                return r1
            L92:
                int r5 = partialIsValidUtf8(r7, r8, r9)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.Processor.partialIsValidUtf8Default(int, java.nio.ByteBuffer, int, int):int");
        }

        public abstract int partialIsValidUtf8Direct(int i10, ByteBuffer byteBuffer, int i11, int i12);

        public final boolean isValidUtf8(ByteBuffer byteBuffer, int i10, int i11) {
            return partialIsValidUtf8(0, byteBuffer, i10, i11) == 0;
        }

        private static int partialIsValidUtf8(ByteBuffer byteBuffer, int i10, int i11) {
            int estimateConsecutiveAscii = i10 + Utf8.estimateConsecutiveAscii(byteBuffer, i10, i11);
            while (estimateConsecutiveAscii < i11) {
                int i12 = estimateConsecutiveAscii + 1;
                byte b10 = byteBuffer.get(estimateConsecutiveAscii);
                if (b10 >= 0) {
                    estimateConsecutiveAscii = i12;
                } else if (b10 < -32) {
                    if (i12 >= i11) {
                        return b10;
                    }
                    if (b10 < -62 || byteBuffer.get(i12) > -65) {
                        return -1;
                    }
                    estimateConsecutiveAscii += 2;
                } else {
                    if (b10 >= -16) {
                        if (i12 >= i11 - 2) {
                            return Utf8.incompleteStateFor(byteBuffer, b10, i12, i11 - i12);
                        }
                        int i13 = estimateConsecutiveAscii + 2;
                        byte b11 = byteBuffer.get(i12);
                        if (b11 <= -65 && (((b10 << 28) + (b11 + 112)) >> 30) == 0) {
                            int i14 = estimateConsecutiveAscii + 3;
                            if (byteBuffer.get(i13) <= -65) {
                                estimateConsecutiveAscii += 4;
                                if (byteBuffer.get(i14) > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                    if (i12 >= i11 - 1) {
                        return Utf8.incompleteStateFor(byteBuffer, b10, i12, i11 - i12);
                    }
                    int i15 = estimateConsecutiveAscii + 2;
                    byte b12 = byteBuffer.get(i12);
                    if (b12 > -65 || ((b10 == -32 && b12 < -96) || ((b10 == -19 && b12 >= -96) || byteBuffer.get(i15) > -65))) {
                        return -1;
                    }
                    estimateConsecutiveAscii += 3;
                }
            }
            return 0;
        }
    }

    /* loaded from: classes3.dex */
    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i10, int i11) {
            super("Unpaired surrogate at index " + i10 + " of " + i11);
        }
    }

    static {
        Processor safeProcessor;
        if (UnsafeProcessor.isAvailable() && !Android.isOnAndroidDevice()) {
            safeProcessor = new UnsafeProcessor();
        } else {
            safeProcessor = new SafeProcessor();
        }
        processor = safeProcessor;
    }

    private Utf8() {
    }

    public static String decodeUtf8(ByteBuffer byteBuffer, int i10, int i11) {
        return processor.decodeUtf8(byteBuffer, i10, i11);
    }

    public static int encode(CharSequence charSequence, byte[] bArr, int i10, int i11) {
        return processor.encodeUtf8(charSequence, bArr, i10, i11);
    }

    public static void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        processor.encodeUtf8(charSequence, byteBuffer);
    }

    public static int encodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length && charSequence.charAt(i10) < 128) {
            i10++;
        }
        int i11 = length;
        while (true) {
            if (i10 < length) {
                char charAt = charSequence.charAt(i10);
                if (charAt < 2048) {
                    i11 += (127 - charAt) >>> 31;
                    i10++;
                } else {
                    i11 += encodedLengthGeneral(charSequence, i10);
                    break;
                }
            } else {
                break;
            }
        }
        if (i11 >= length) {
            return i11;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i11 + 4294967296L));
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        int i11 = 0;
        while (i10 < length) {
            char charAt = charSequence.charAt(i10);
            if (charAt < 2048) {
                i11 += (127 - charAt) >>> 31;
            } else {
                i11 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i10) >= 65536) {
                        i10++;
                    } else {
                        throw new UnpairedSurrogateException(i10, length);
                    }
                }
            }
            i10++;
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int estimateConsecutiveAscii(ByteBuffer byteBuffer, int i10, int i11) {
        int i12 = i11 - 7;
        int i13 = i10;
        while (i13 < i12 && (byteBuffer.getLong(i13) & ASCII_MASK_LONG) == 0) {
            i13 += 8;
        }
        return i13 - i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i10) {
        if (i10 > -12) {
            return -1;
        }
        return i10;
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return processor.isValidUtf8(bArr, 0, bArr.length);
    }

    public static int partialIsValidUtf8(int i10, byte[] bArr, int i11, int i12) {
        return processor.partialIsValidUtf8(i10, bArr, i11, i12);
    }

    public static String decodeUtf8(byte[] bArr, int i10, int i11) {
        return processor.decodeUtf8(bArr, i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i10, int i11) {
        if (i10 > -12 || i11 > -65) {
            return -1;
        }
        return i10 ^ (i11 << 8);
    }

    public static boolean isValidUtf8(byte[] bArr, int i10, int i11) {
        return processor.isValidUtf8(bArr, i10, i11);
    }

    public static int partialIsValidUtf8(int i10, ByteBuffer byteBuffer, int i11, int i12) {
        return processor.partialIsValidUtf8(i10, byteBuffer, i11, i12);
    }

    /* loaded from: classes3.dex */
    public static final class UnsafeProcessor extends Processor {
        public static boolean isAvailable() {
            if (UnsafeUtil.hasUnsafeArrayOperations() && UnsafeUtil.hasUnsafeByteBufferOperations()) {
                return true;
            }
            return false;
        }

        private static int unsafeEstimateConsecutiveAscii(byte[] bArr, long j10, int i10) {
            int i11 = 0;
            if (i10 < 16) {
                return 0;
            }
            int i12 = 8 - (((int) j10) & 7);
            while (i11 < i12) {
                long j11 = 1 + j10;
                if (UnsafeUtil.getByte(bArr, j10) < 0) {
                    return i11;
                }
                i11++;
                j10 = j11;
            }
            while (true) {
                int i13 = i11 + 8;
                if (i13 > i10 || (UnsafeUtil.getLong((Object) bArr, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + j10) & Utf8.ASCII_MASK_LONG) != 0) {
                    break;
                }
                j10 += 8;
                i11 = i13;
            }
            while (i11 < i10) {
                long j12 = j10 + 1;
                if (UnsafeUtil.getByte(bArr, j10) < 0) {
                    return i11;
                }
                i11++;
                j10 = j12;
            }
            return i10;
        }

        private static int unsafeIncompleteStateFor(byte[] bArr, int i10, long j10, int i11) {
            if (i11 == 0) {
                return Utf8.incompleteStateFor(i10);
            }
            if (i11 == 1) {
                return Utf8.incompleteStateFor(i10, UnsafeUtil.getByte(bArr, j10));
            }
            if (i11 == 2) {
                return Utf8.incompleteStateFor(i10, UnsafeUtil.getByte(bArr, j10), UnsafeUtil.getByte(bArr, j10 + 1));
            }
            throw new AssertionError();
        }

        @Override // com.google.protobuf.Utf8.Processor
        public String decodeUtf8(byte[] bArr, int i10, int i11) {
            Charset charset = Internal.UTF_8;
            String str = new String(bArr, i10, i11, charset);
            if (!str.contains("�")) {
                return str;
            }
            if (Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bArr, i10, i11 + i10))) {
                return str;
            }
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        @Override // com.google.protobuf.Utf8.Processor
        public String decodeUtf8Direct(ByteBuffer byteBuffer, int i10, int i11) {
            if ((i10 | i11 | ((byteBuffer.limit() - i10) - i11)) >= 0) {
                long addressOffset = UnsafeUtil.addressOffset(byteBuffer) + i10;
                long j10 = i11 + addressOffset;
                char[] cArr = new char[i11];
                int i12 = 0;
                while (addressOffset < j10) {
                    byte b10 = UnsafeUtil.getByte(addressOffset);
                    if (!DecodeUtil.isOneByte(b10)) {
                        break;
                    }
                    addressOffset++;
                    DecodeUtil.handleOneByte(b10, cArr, i12);
                    i12++;
                }
                int i13 = i12;
                while (addressOffset < j10) {
                    long j11 = addressOffset + 1;
                    byte b11 = UnsafeUtil.getByte(addressOffset);
                    if (DecodeUtil.isOneByte(b11)) {
                        int i14 = i13 + 1;
                        DecodeUtil.handleOneByte(b11, cArr, i13);
                        while (j11 < j10) {
                            byte b12 = UnsafeUtil.getByte(j11);
                            if (!DecodeUtil.isOneByte(b12)) {
                                break;
                            }
                            j11++;
                            DecodeUtil.handleOneByte(b12, cArr, i14);
                            i14++;
                        }
                        i13 = i14;
                        addressOffset = j11;
                    } else if (DecodeUtil.isTwoBytes(b11)) {
                        if (j11 < j10) {
                            addressOffset += 2;
                            DecodeUtil.handleTwoBytes(b11, UnsafeUtil.getByte(j11), cArr, i13);
                            i13++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (DecodeUtil.isThreeBytes(b11)) {
                        if (j11 < j10 - 1) {
                            long j12 = 2 + addressOffset;
                            addressOffset += 3;
                            DecodeUtil.handleThreeBytes(b11, UnsafeUtil.getByte(j11), UnsafeUtil.getByte(j12), cArr, i13);
                            i13++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (j11 < j10 - 2) {
                        byte b13 = UnsafeUtil.getByte(j11);
                        long j13 = 3 + addressOffset;
                        byte b14 = UnsafeUtil.getByte(2 + addressOffset);
                        addressOffset += 4;
                        DecodeUtil.handleFourBytes(b11, b13, b14, UnsafeUtil.getByte(j13), cArr, i13);
                        i13 += 2;
                    } else {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                }
                return new String(cArr, 0, i13);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i10), Integer.valueOf(i11)));
        }

        @Override // com.google.protobuf.Utf8.Processor
        public int encodeUtf8(CharSequence charSequence, byte[] bArr, int i10, int i11) {
            long j10;
            String str;
            String str2;
            int i12;
            long j11;
            long j12;
            char charAt;
            long j13 = i10;
            long j14 = i11 + j13;
            int length = charSequence.length();
            String str3 = " at index ";
            String str4 = "Failed writing ";
            if (length <= i11 && bArr.length - i11 >= i10) {
                int i13 = 0;
                while (true) {
                    j10 = 1;
                    if (i13 >= length || (charAt = charSequence.charAt(i13)) >= 128) {
                        break;
                    }
                    UnsafeUtil.putByte(bArr, j13, (byte) charAt);
                    i13++;
                    j13 = 1 + j13;
                }
                if (i13 == length) {
                    return (int) j13;
                }
                while (i13 < length) {
                    char charAt2 = charSequence.charAt(i13);
                    if (charAt2 < 128 && j13 < j14) {
                        UnsafeUtil.putByte(bArr, j13, (byte) charAt2);
                        j12 = j14;
                        str = str3;
                        j11 = j10;
                        j13 += j10;
                        str2 = str4;
                    } else {
                        if (charAt2 < 2048 && j13 <= j14 - 2) {
                            str = str3;
                            str2 = str4;
                            long j15 = j13 + j10;
                            UnsafeUtil.putByte(bArr, j13, (byte) ((charAt2 >>> 6) | 960));
                            j13 += 2;
                            UnsafeUtil.putByte(bArr, j15, (byte) ((charAt2 & '?') | 128));
                        } else {
                            str = str3;
                            str2 = str4;
                            if ((charAt2 < 55296 || 57343 < charAt2) && j13 <= j14 - 3) {
                                UnsafeUtil.putByte(bArr, j13, (byte) ((charAt2 >>> '\f') | COUIIndividualStatementDialog.MEDIUM_LARGE_SCREEN_SW_THRESHOLD));
                                long j16 = j13 + 2;
                                UnsafeUtil.putByte(bArr, j13 + 1, (byte) (((charAt2 >>> 6) & 63) | 128));
                                j13 += 3;
                                UnsafeUtil.putByte(bArr, j16, (byte) ((charAt2 & '?') | 128));
                            } else {
                                if (j13 <= j14 - 4) {
                                    int i14 = i13 + 1;
                                    if (i14 != length) {
                                        char charAt3 = charSequence.charAt(i14);
                                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                                            j11 = 1;
                                            UnsafeUtil.putByte(bArr, j13, (byte) ((codePoint >>> 18) | 240));
                                            j12 = j14;
                                            UnsafeUtil.putByte(bArr, j13 + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                            long j17 = j13 + 3;
                                            UnsafeUtil.putByte(bArr, j13 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                            j13 += 4;
                                            UnsafeUtil.putByte(bArr, j17, (byte) ((codePoint & 63) | 128));
                                            i13 = i14;
                                        } else {
                                            i13 = i14;
                                        }
                                    }
                                    throw new UnpairedSurrogateException(i13 - 1, length);
                                }
                                if (55296 <= charAt2 && charAt2 <= 57343 && ((i12 = i13 + 1) == length || !Character.isSurrogatePair(charAt2, charSequence.charAt(i12)))) {
                                    throw new UnpairedSurrogateException(i13, length);
                                }
                                throw new ArrayIndexOutOfBoundsException(str2 + charAt2 + str + j13);
                            }
                        }
                        j12 = j14;
                        j11 = 1;
                    }
                    i13++;
                    str3 = str;
                    str4 = str2;
                    j10 = j11;
                    j14 = j12;
                }
                return (int) j13;
            }
            throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i10 + i11));
        }

        @Override // com.google.protobuf.Utf8.Processor
        public void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer) {
            long j10;
            char c10;
            long j11;
            int i10;
            int i11;
            char c11;
            char charAt;
            long addressOffset = UnsafeUtil.addressOffset(byteBuffer);
            long position = byteBuffer.position() + addressOffset;
            long limit = byteBuffer.limit() + addressOffset;
            int length = charSequence.length();
            if (length <= limit - position) {
                int i12 = 0;
                while (true) {
                    j10 = 1;
                    c10 = 128;
                    if (i12 >= length || (charAt = charSequence.charAt(i12)) >= 128) {
                        break;
                    }
                    UnsafeUtil.putByte(position, (byte) charAt);
                    i12++;
                    position = 1 + position;
                }
                if (i12 == length) {
                    Java8Compatibility.position(byteBuffer, (int) (position - addressOffset));
                    return;
                }
                while (i12 < length) {
                    char charAt2 = charSequence.charAt(i12);
                    if (charAt2 < c10 && position < limit) {
                        UnsafeUtil.putByte(position, (byte) charAt2);
                        j11 = addressOffset;
                        i11 = i12;
                        c11 = c10;
                        position += j10;
                    } else {
                        if (charAt2 < 2048 && position <= limit - 2) {
                            j11 = addressOffset;
                            long j12 = position + j10;
                            UnsafeUtil.putByte(position, (byte) ((charAt2 >>> 6) | 960));
                            position += 2;
                            UnsafeUtil.putByte(j12, (byte) ((charAt2 & '?') | 128));
                        } else {
                            j11 = addressOffset;
                            if ((charAt2 < 55296 || 57343 < charAt2) && position <= limit - 3) {
                                long j13 = position + j10;
                                UnsafeUtil.putByte(position, (byte) ((charAt2 >>> '\f') | COUIIndividualStatementDialog.MEDIUM_LARGE_SCREEN_SW_THRESHOLD));
                                long j14 = position + 2;
                                UnsafeUtil.putByte(j13, (byte) (((charAt2 >>> 6) & 63) | 128));
                                position += 3;
                                UnsafeUtil.putByte(j14, (byte) ((charAt2 & '?') | 128));
                            } else {
                                if (position <= limit - 4) {
                                    i11 = i12 + 1;
                                    if (i11 != length) {
                                        char charAt3 = charSequence.charAt(i11);
                                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                                            UnsafeUtil.putByte(position, (byte) ((codePoint >>> 18) | 240));
                                            c11 = 128;
                                            UnsafeUtil.putByte(position + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                            long j15 = position + 3;
                                            UnsafeUtil.putByte(position + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                            position += 4;
                                            UnsafeUtil.putByte(j15, (byte) ((codePoint & 63) | 128));
                                        } else {
                                            i12 = i11;
                                        }
                                    }
                                    throw new UnpairedSurrogateException(i12 - 1, length);
                                }
                                if (55296 <= charAt2 && charAt2 <= 57343 && ((i10 = i12 + 1) == length || !Character.isSurrogatePair(charAt2, charSequence.charAt(i10)))) {
                                    throw new UnpairedSurrogateException(i12, length);
                                }
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + position);
                            }
                        }
                        i11 = i12;
                        c11 = 128;
                    }
                    c10 = c11;
                    addressOffset = j11;
                    j10 = 1;
                    i12 = i11 + 1;
                }
                Java8Compatibility.position(byteBuffer, (int) (position - addressOffset));
                return;
            }
            throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + byteBuffer.limit());
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0058, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r11, r0) > (-65)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x009e, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r11, r0) > (-65)) goto L59;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int partialIsValidUtf8(int r10, byte[] r11, int r12, int r13) {
            /*
                Method dump skipped, instructions count: 197
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(int, byte[], int, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0062, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r0) > (-65)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00a8, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r0) > (-65)) goto L59;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int partialIsValidUtf8Direct(int r9, java.nio.ByteBuffer r10, int r11, int r12) {
            /*
                Method dump skipped, instructions count: 210
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8Direct(int, java.nio.ByteBuffer, int, int):int");
        }

        private static int unsafeEstimateConsecutiveAscii(long j10, int i10) {
            if (i10 < 16) {
                return 0;
            }
            int i11 = (int) ((-j10) & 7);
            int i12 = i11;
            while (i12 > 0) {
                long j11 = 1 + j10;
                if (UnsafeUtil.getByte(j10) < 0) {
                    return i11 - i12;
                }
                i12--;
                j10 = j11;
            }
            int i13 = i10 - i11;
            while (i13 >= 8 && (UnsafeUtil.getLong(j10) & Utf8.ASCII_MASK_LONG) == 0) {
                j10 += 8;
                i13 -= 8;
            }
            return i10 - i13;
        }

        private static int unsafeIncompleteStateFor(long j10, int i10, int i11) {
            if (i11 == 0) {
                return Utf8.incompleteStateFor(i10);
            }
            if (i11 == 1) {
                return Utf8.incompleteStateFor(i10, UnsafeUtil.getByte(j10));
            }
            if (i11 == 2) {
                return Utf8.incompleteStateFor(i10, UnsafeUtil.getByte(j10), UnsafeUtil.getByte(j10 + 1));
            }
            throw new AssertionError();
        }

        /* JADX WARN: Code restructure failed: missing block: B:69:0x0039, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static int partialIsValidUtf8(byte[] r10, long r11, int r13) {
            /*
                int r0 = unsafeEstimateConsecutiveAscii(r10, r11, r13)
                int r13 = r13 - r0
                long r0 = (long) r0
                long r11 = r11 + r0
            L7:
                r0 = 0
                r1 = r0
            L9:
                r2 = 1
                if (r13 <= 0) goto L1a
                long r4 = r11 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r10, r11)
                if (r1 < 0) goto L19
                int r13 = r13 + (-1)
                r11 = r4
                goto L9
            L19:
                r11 = r4
            L1a:
                if (r13 != 0) goto L1d
                return r0
            L1d:
                int r0 = r13 + (-1)
                r4 = -32
                r5 = -1
                r6 = -65
                if (r1 >= r4) goto L3a
                if (r0 != 0) goto L29
                return r1
            L29:
                int r13 = r13 + (-2)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r11
                byte r11 = com.google.protobuf.UnsafeUtil.getByte(r10, r11)
                if (r11 <= r6) goto L37
                goto L39
            L37:
                r11 = r2
                goto L7
            L39:
                return r5
            L3a:
                r7 = -16
                r8 = 2
                if (r1 >= r7) goto L65
                r7 = 2
                if (r0 >= r7) goto L48
                int r10 = unsafeIncompleteStateFor(r10, r1, r11, r0)
                return r10
            L48:
                int r13 = r13 + (-3)
                long r2 = r2 + r11
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r10, r11)
                if (r0 > r6) goto L64
                r7 = -96
                if (r1 != r4) goto L57
                if (r0 < r7) goto L64
            L57:
                r4 = -19
                if (r1 != r4) goto L5d
                if (r0 >= r7) goto L64
            L5d:
                long r11 = r11 + r8
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r10, r2)
                if (r0 <= r6) goto L7
            L64:
                return r5
            L65:
                r4 = 3
                if (r0 >= r4) goto L6d
                int r10 = unsafeIncompleteStateFor(r10, r1, r11, r0)
                return r10
            L6d:
                int r13 = r13 + (-4)
                long r2 = r2 + r11
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r10, r11)
                if (r0 > r6) goto L8f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L8f
                long r8 = r8 + r11
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r10, r2)
                if (r0 > r6) goto L8f
                r0 = 3
                long r11 = r11 + r0
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r10, r8)
                if (r0 <= r6) goto L7
            L8f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(byte[], long, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:69:0x0039, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static int partialIsValidUtf8(long r10, int r12) {
            /*
                int r0 = unsafeEstimateConsecutiveAscii(r10, r12)
                long r1 = (long) r0
                long r10 = r10 + r1
                int r12 = r12 - r0
            L7:
                r0 = 0
                r1 = r0
            L9:
                r2 = 1
                if (r12 <= 0) goto L1a
                long r4 = r10 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r10)
                if (r1 < 0) goto L19
                int r12 = r12 + (-1)
                r10 = r4
                goto L9
            L19:
                r10 = r4
            L1a:
                if (r12 != 0) goto L1d
                return r0
            L1d:
                int r0 = r12 + (-1)
                r4 = -32
                r5 = -1
                r6 = -65
                if (r1 >= r4) goto L3a
                if (r0 != 0) goto L29
                return r1
            L29:
                int r12 = r12 + (-2)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r10
                byte r10 = com.google.protobuf.UnsafeUtil.getByte(r10)
                if (r10 <= r6) goto L37
                goto L39
            L37:
                r10 = r2
                goto L7
            L39:
                return r5
            L3a:
                r7 = -16
                r8 = 2
                if (r1 >= r7) goto L65
                r7 = 2
                if (r0 >= r7) goto L48
                int r10 = unsafeIncompleteStateFor(r10, r1, r0)
                return r10
            L48:
                int r12 = r12 + (-3)
                long r2 = r2 + r10
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r10)
                if (r0 > r6) goto L64
                r7 = -96
                if (r1 != r4) goto L57
                if (r0 < r7) goto L64
            L57:
                r4 = -19
                if (r1 != r4) goto L5d
                if (r0 >= r7) goto L64
            L5d:
                long r10 = r10 + r8
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r2)
                if (r0 <= r6) goto L7
            L64:
                return r5
            L65:
                r4 = 3
                if (r0 >= r4) goto L6d
                int r10 = unsafeIncompleteStateFor(r10, r1, r0)
                return r10
            L6d:
                int r12 = r12 + (-4)
                long r2 = r2 + r10
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r10)
                if (r0 > r6) goto L8f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L8f
                long r8 = r8 + r10
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r2)
                if (r0 > r6) goto L8f
                r0 = 3
                long r10 = r10 + r0
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r8)
                if (r0 <= r6) goto L7
            L8f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(long, int):int");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i10, int i11, int i12) {
        if (i10 > -12 || i11 > -65 || i12 > -65) {
            return -1;
        }
        return (i10 ^ (i11 << 8)) ^ (i12 << 16);
    }

    public static boolean isValidUtf8(ByteBuffer byteBuffer) {
        return processor.isValidUtf8(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(byte[] bArr, int i10, int i11) {
        byte b10 = bArr[i10 - 1];
        int i12 = i11 - i10;
        if (i12 == 0) {
            return incompleteStateFor(b10);
        }
        if (i12 == 1) {
            return incompleteStateFor(b10, bArr[i10]);
        }
        if (i12 == 2) {
            return incompleteStateFor(b10, bArr[i10], bArr[i10 + 1]);
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(ByteBuffer byteBuffer, int i10, int i11, int i12) {
        if (i12 == 0) {
            return incompleteStateFor(i10);
        }
        if (i12 == 1) {
            return incompleteStateFor(i10, byteBuffer.get(i11));
        }
        if (i12 == 2) {
            return incompleteStateFor(i10, byteBuffer.get(i11), byteBuffer.get(i11 + 1));
        }
        throw new AssertionError();
    }

    /* loaded from: classes3.dex */
    public static final class SafeProcessor extends Processor {
        private static int partialIsValidUtf8NonAscii(byte[] bArr, int i10, int i11) {
            while (i10 < i11) {
                int i12 = i10 + 1;
                byte b10 = bArr[i10];
                if (b10 < 0) {
                    if (b10 < -32) {
                        if (i12 >= i11) {
                            return b10;
                        }
                        if (b10 >= -62) {
                            i10 += 2;
                            if (bArr[i12] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (b10 < -16) {
                        if (i12 >= i11 - 1) {
                            return Utf8.incompleteStateFor(bArr, i12, i11);
                        }
                        int i13 = i10 + 2;
                        byte b11 = bArr[i12];
                        if (b11 <= -65 && ((b10 != -32 || b11 >= -96) && (b10 != -19 || b11 < -96))) {
                            i10 += 3;
                            if (bArr[i13] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (i12 >= i11 - 2) {
                        return Utf8.incompleteStateFor(bArr, i12, i11);
                    }
                    int i14 = i10 + 2;
                    byte b12 = bArr[i12];
                    if (b12 <= -65 && (((b10 << 28) + (b12 + 112)) >> 30) == 0) {
                        int i15 = i10 + 3;
                        if (bArr[i14] <= -65) {
                            i10 += 4;
                            if (bArr[i15] > -65) {
                            }
                        }
                    }
                    return -1;
                }
                i10 = i12;
            }
            return 0;
        }

        @Override // com.google.protobuf.Utf8.Processor
        public String decodeUtf8(byte[] bArr, int i10, int i11) {
            if ((i10 | i11 | ((bArr.length - i10) - i11)) >= 0) {
                int i12 = i10 + i11;
                char[] cArr = new char[i11];
                int i13 = 0;
                while (i10 < i12) {
                    byte b10 = bArr[i10];
                    if (!DecodeUtil.isOneByte(b10)) {
                        break;
                    }
                    i10++;
                    DecodeUtil.handleOneByte(b10, cArr, i13);
                    i13++;
                }
                int i14 = i13;
                while (i10 < i12) {
                    int i15 = i10 + 1;
                    byte b11 = bArr[i10];
                    if (DecodeUtil.isOneByte(b11)) {
                        int i16 = i14 + 1;
                        DecodeUtil.handleOneByte(b11, cArr, i14);
                        while (i15 < i12) {
                            byte b12 = bArr[i15];
                            if (!DecodeUtil.isOneByte(b12)) {
                                break;
                            }
                            i15++;
                            DecodeUtil.handleOneByte(b12, cArr, i16);
                            i16++;
                        }
                        i14 = i16;
                        i10 = i15;
                    } else if (DecodeUtil.isTwoBytes(b11)) {
                        if (i15 < i12) {
                            i10 += 2;
                            DecodeUtil.handleTwoBytes(b11, bArr[i15], cArr, i14);
                            i14++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (DecodeUtil.isThreeBytes(b11)) {
                        if (i15 < i12 - 1) {
                            int i17 = i10 + 2;
                            i10 += 3;
                            DecodeUtil.handleThreeBytes(b11, bArr[i15], bArr[i17], cArr, i14);
                            i14++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (i15 < i12 - 2) {
                        byte b13 = bArr[i15];
                        int i18 = i10 + 3;
                        byte b14 = bArr[i10 + 2];
                        i10 += 4;
                        DecodeUtil.handleFourBytes(b11, b13, b14, bArr[i18], cArr, i14);
                        i14 += 2;
                    } else {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                }
                return new String(cArr, 0, i14);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i10), Integer.valueOf(i11)));
        }

        @Override // com.google.protobuf.Utf8.Processor
        public String decodeUtf8Direct(ByteBuffer byteBuffer, int i10, int i11) {
            return decodeUtf8Default(byteBuffer, i10, i11);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        
            return r9 + r6;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int encodeUtf8(java.lang.CharSequence r7, byte[] r8, int r9, int r10) {
            /*
                Method dump skipped, instructions count: 254
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.SafeProcessor.encodeUtf8(java.lang.CharSequence, byte[], int, int):int");
        }

        @Override // com.google.protobuf.Utf8.Processor
        public void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer) {
            encodeUtf8Default(charSequence, byteBuffer);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
        
            if (r7[r8] > (-65)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0046, code lost:
        
            if (r7[r8] > (-65)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0083, code lost:
        
            if (r7[r6] > (-65)) goto L53;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int partialIsValidUtf8(int r6, byte[] r7, int r8, int r9) {
            /*
                r5 = this;
                if (r6 == 0) goto L86
                if (r8 < r9) goto L5
                return r6
            L5:
                byte r5 = (byte) r6
                r0 = -32
                r1 = -1
                r2 = -65
                if (r5 >= r0) goto L1c
                r6 = -62
                if (r5 < r6) goto L1b
                int r5 = r8 + 1
                r6 = r7[r8]
                if (r6 <= r2) goto L18
                goto L1b
            L18:
                r8 = r5
                goto L86
            L1b:
                return r1
            L1c:
                r3 = -16
                if (r5 >= r3) goto L49
                int r6 = r6 >> 8
                int r6 = ~r6
                byte r6 = (byte) r6
                if (r6 != 0) goto L34
                int r6 = r8 + 1
                r8 = r7[r8]
                if (r6 < r9) goto L31
                int r5 = com.google.protobuf.Utf8.access$000(r5, r8)
                return r5
            L31:
                r4 = r8
                r8 = r6
                r6 = r4
            L34:
                if (r6 > r2) goto L48
                r3 = -96
                if (r5 != r0) goto L3c
                if (r6 < r3) goto L48
            L3c:
                r0 = -19
                if (r5 != r0) goto L42
                if (r6 >= r3) goto L48
            L42:
                int r5 = r8 + 1
                r6 = r7[r8]
                if (r6 <= r2) goto L18
            L48:
                return r1
            L49:
                int r0 = r6 >> 8
                int r0 = ~r0
                byte r0 = (byte) r0
                if (r0 != 0) goto L5c
                int r6 = r8 + 1
                r0 = r7[r8]
                if (r6 < r9) goto L5a
                int r5 = com.google.protobuf.Utf8.access$000(r5, r0)
                return r5
            L5a:
                r8 = 0
                goto L62
            L5c:
                int r6 = r6 >> 16
                byte r6 = (byte) r6
                r4 = r8
                r8 = r6
                r6 = r4
            L62:
                if (r8 != 0) goto L72
                int r8 = r6 + 1
                r6 = r7[r6]
                if (r8 < r9) goto L6f
                int r5 = com.google.protobuf.Utf8.access$100(r5, r0, r6)
                return r5
            L6f:
                r4 = r8
                r8 = r6
                r6 = r4
            L72:
                if (r0 > r2) goto L85
                int r5 = r5 << 28
                int r0 = r0 + 112
                int r5 = r5 + r0
                int r5 = r5 >> 30
                if (r5 != 0) goto L85
                if (r8 > r2) goto L85
                int r8 = r6 + 1
                r5 = r7[r6]
                if (r5 <= r2) goto L86
            L85:
                return r1
            L86:
                int r5 = partialIsValidUtf8(r7, r8, r9)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.SafeProcessor.partialIsValidUtf8(int, byte[], int, int):int");
        }

        @Override // com.google.protobuf.Utf8.Processor
        public int partialIsValidUtf8Direct(int i10, ByteBuffer byteBuffer, int i11, int i12) {
            return partialIsValidUtf8Default(i10, byteBuffer, i11, i12);
        }

        private static int partialIsValidUtf8(byte[] bArr, int i10, int i11) {
            while (i10 < i11 && bArr[i10] >= 0) {
                i10++;
            }
            if (i10 >= i11) {
                return 0;
            }
            return partialIsValidUtf8NonAscii(bArr, i10, i11);
        }
    }
}
