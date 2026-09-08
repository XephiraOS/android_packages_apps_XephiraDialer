package com.oua.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes4.dex */
class OUAFileCipher {
    private static final int BLOCK_SIZE = 65536;
    private static final int SAMPLE_RATE = 10;
    private static final String TAG = "com.oua.util.OUAFileCipher";

    /* loaded from: classes4.dex */
    public static class Header implements Serializable {
        public int encryptedSize;
        public byte[] iv;
        public int originSize;
        public int sampleRate;

        private Header() {
        }
    }

    /* loaded from: classes4.dex */
    public interface OuaDataReader {
        byte[] read();
    }

    /* loaded from: classes4.dex */
    public interface Reader {
        int read(byte[] bArr);
    }

    /* loaded from: classes4.dex */
    public interface Writer {
        void write(byte[] bArr);
    }

    private static Cipher createCipher(int i10, String str, byte[] bArr) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        if (bArr != null) {
            cipher.init(i10, secretKeySpec, new IvParameterSpec(bArr));
        } else {
            cipher.init(i10, secretKeySpec);
        }
        return cipher;
    }

    public static ByteBuffer decrypt2DirectBuffer(final InputStream inputStream, String str) {
        Header readHeader = readHeader(inputStream);
        log("read header " + StringUtil.toString(readHeader));
        final ByteBuffer allocateDirect = ByteBuffer.allocateDirect(readHeader.originSize);
        allocateDirect.order(ByteOrder.nativeOrder());
        runDecrypt(new OuaDataReader() { // from class: com.oua.util.y
            @Override // com.oua.util.OUAFileCipher.OuaDataReader
            public final byte[] read() {
                byte[] readBytes;
                readBytes = IOStreamUtil.readBytes(inputStream);
                return readBytes;
            }
        }, new Writer() { // from class: com.oua.util.z
            @Override // com.oua.util.OUAFileCipher.Writer
            public final void write(byte[] bArr) {
                allocateDirect.put(bArr);
            }
        }, str, readHeader.iv, readHeader.sampleRate, readHeader.encryptedSize);
        allocateDirect.flip();
        return allocateDirect;
    }

    public static String decrypt2String(final InputStream inputStream, String str) {
        Header readHeader = readHeader(inputStream);
        log("header " + StringUtil.toString(readHeader));
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        runDecrypt(new OuaDataReader() { // from class: com.oua.util.A
            @Override // com.oua.util.OUAFileCipher.OuaDataReader
            public final byte[] read() {
                byte[] readBytes;
                readBytes = IOStreamUtil.readBytes(inputStream);
                return readBytes;
            }
        }, new Writer() { // from class: com.oua.util.B
            @Override // com.oua.util.OUAFileCipher.Writer
            public final void write(byte[] bArr) {
                byteArrayOutputStream.write(bArr);
            }
        }, str, readHeader.iv, readHeader.sampleRate, readHeader.encryptedSize);
        return byteArrayOutputStream.toString("UTF-8");
    }

    public static int encrypt(final InputStream inputStream, OutputStream outputStream, String str, byte[] bArr) {
        Header header = new Header();
        header.sampleRate = 10;
        header.iv = bArr;
        header.originSize = inputStream.available();
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        runEncrypt(new Reader() { // from class: com.oua.util.C
            @Override // com.oua.util.OUAFileCipher.Reader
            public final int read(byte[] bArr2) {
                int read;
                read = inputStream.read(bArr2);
                return read;
            }
        }, new Writer() { // from class: com.oua.util.D
            @Override // com.oua.util.OUAFileCipher.Writer
            public final void write(byte[] bArr2) {
                IOStreamUtil.writeBytes(byteArrayOutputStream, bArr2);
            }
        }, str, header.iv, header.sampleRate, 65536);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        header.encryptedSize = byteArray.length;
        log("write header " + StringUtil.toString(header));
        int writeObject = IOStreamUtil.writeObject(outputStream, header);
        outputStream.write(byteArray);
        return writeObject + byteArray.length;
    }

    private static String normPassword(String str) {
        if (str.length() >= 16) {
            if (str.length() != 16) {
                return str.substring(0, 16);
            }
            return str;
        }
        throw new Exception("Invalid Password! Too short. Expected >= 16");
    }

    private static Header readHeader(InputStream inputStream) {
        return (Header) IOStreamUtil.readObject(inputStream, Header.class);
    }

    private static void runDecrypt(OuaDataReader ouaDataReader, Writer writer, String str, byte[] bArr, int i10, int i11) {
        Cipher createCipher = createCipher(2, normPassword(str), bArr);
        int i12 = 0;
        int i13 = 0;
        while (i12 < i11) {
            byte[] read = ouaDataReader.read();
            i12 += read.length + 4;
            log("read encrypted " + read.length);
            if (i13 % i10 == 0) {
                read = createCipher.doFinal(read);
            }
            log("write origin " + read.length);
            writer.write(read);
            log(String.format("read total %d/%d ", Integer.valueOf(i12), Integer.valueOf(i11)));
            i13++;
        }
    }

    private static void runEncrypt(Reader reader, Writer writer, String str, byte[] bArr, int i10, int i11) {
        byte[] bArr2;
        Cipher createCipher = createCipher(1, normPassword(str), bArr);
        byte[] bArr3 = new byte[i11];
        int i12 = 0;
        while (true) {
            int read = reader.read(bArr3);
            if (read > 0) {
                log("read origin " + read);
                if (i12 % i10 == 0) {
                    bArr2 = createCipher.doFinal(bArr3, 0, read);
                } else if (read < i11) {
                    bArr2 = Arrays.copyOf(bArr3, read);
                } else {
                    bArr2 = bArr3;
                }
                log("write encrypted " + bArr2.length);
                writer.write(bArr2);
                i12++;
            } else {
                return;
            }
        }
    }

    private static void log(String str) {
    }
}
