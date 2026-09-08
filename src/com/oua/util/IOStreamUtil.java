package com.oua.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes4.dex */
public class IOStreamUtil {
    private static final int MAX_BLOCK_SIZE = 67108864;
    private static final String TAG = "com.oua.util.IOStreamUtil";

    public static byte[] readBytes(InputStream inputStream) {
        int readInt = readInt(inputStream);
        if (readInt >= 0 && readInt <= MAX_BLOCK_SIZE) {
            byte[] bArr = new byte[readInt];
            inputStream.read(bArr);
            return bArr;
        }
        throw new IOException("Error file format! block size error " + readInt);
    }

    public static int readInt(InputStream inputStream) {
        byte[] bArr = new byte[4];
        inputStream.read(bArr);
        return ByteBuffer.wrap(bArr).order(ByteOrder.nativeOrder()).asIntBuffer().get();
    }

    public static <T> T readObject(InputStream inputStream, Class<T> cls) {
        return (T) new com.google.gson.d().j(new String(readBytes(inputStream), "UTF-8"), cls);
    }

    public static String toString(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toString("UTF-8");
            }
        }
    }

    public static int writeBytes(OutputStream outputStream, byte[] bArr) {
        writeInt(outputStream, bArr.length);
        outputStream.write(bArr);
        return bArr.length + 4;
    }

    public static int writeInt(OutputStream outputStream, int i10) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.nativeOrder());
        allocate.asIntBuffer().put(i10);
        outputStream.write(allocate.array());
        return 4;
    }

    public static int writeObject(OutputStream outputStream, Object obj) {
        return writeBytes(outputStream, StringUtil.toString(obj).getBytes("UTF-8"));
    }

    public static <T> T readObject(InputStream inputStream, Type type) {
        return (T) new com.google.gson.d().k(new String(readBytes(inputStream), "UTF-8"), type);
    }
}
