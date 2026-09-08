package com.oua.util;

import android.util.Log;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.LongBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.function.Consumer;

/* loaded from: classes4.dex */
public class BufferUtil {
    private static final String TAG = "com.oua.util.BufferUtil";

    public static ByteBuffer addByte(ByteBuffer byteBuffer, byte[] bArr) {
        byteBuffer.put(bArr);
        return byteBuffer;
    }

    public static ByteBuffer addFloat(ByteBuffer byteBuffer, float[] fArr) {
        byteBuffer.asFloatBuffer().put(fArr);
        return byteBuffer;
    }

    public static ByteBuffer clone(ByteBuffer byteBuffer, int i10) {
        ByteBuffer allocate;
        if (byteBuffer.isDirect()) {
            allocate = ByteBuffer.allocateDirect(i10);
        } else {
            allocate = ByteBuffer.allocate(i10);
        }
        copyBuffer(byteBuffer, allocate);
        allocate.flip();
        Log.d(TAG, String.format("clone %s , %s , %d", byteBuffer.toString(), allocate.toString(), Integer.valueOf(i10)));
        return allocate;
    }

    public static ByteBuffer concat(ByteBuffer... byteBufferArr) {
        final ByteBuffer allocate = ByteBuffer.allocate(Arrays.stream(byteBufferArr).mapToInt(new C0940g()).sum());
        Arrays.stream(byteBufferArr).forEach(new Consumer() { // from class: com.oua.util.i
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                BufferUtil.lambda$concat$0(allocate, (ByteBuffer) obj);
            }
        });
        allocate.flip();
        return allocate;
    }

    public static ByteBuffer concatDirect(ByteBuffer... byteBufferArr) {
        final ByteBuffer allocateDirect = ByteBuffer.allocateDirect(Arrays.stream(byteBufferArr).mapToInt(new C0940g()).sum());
        allocateDirect.order(ByteOrder.nativeOrder());
        Arrays.stream(byteBufferArr).forEach(new Consumer() { // from class: com.oua.util.h
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                BufferUtil.lambda$concatDirect$1(allocateDirect, (ByteBuffer) obj);
            }
        });
        allocateDirect.flip();
        return allocateDirect;
    }

    public static void copyBuffer(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i10) {
        int limit = byteBuffer.limit();
        byteBuffer.limit(byteBuffer.position() + i10);
        byteBuffer2.put(byteBuffer);
        byteBuffer.limit(limit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$concat$0(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byteBuffer.put(byteBuffer2.duplicate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$concatDirect$1(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byteBuffer.put(byteBuffer2.duplicate());
    }

    public static String logBuffer(String str, String str2, ByteBuffer byteBuffer) {
        String str3;
        DebugConfig.logd(str, String.format("Buffer %s %s", str2, byteBuffer.toString()));
        if (DebugConfig.isLogVerbose() && (str3 = DebugConfig.debugRoot) != null) {
            String format = String.format("%s/%s.raw", str3, str2);
            saveRawBuffer(byteBuffer, format);
            return format;
        }
        return null;
    }

    public static void saveRawBuffer(ByteBuffer byteBuffer, String str) {
        try {
            Log.d(TAG, String.format("saveRawBuffer %s", str));
            FileChannel channel = new FileOutputStream(str).getChannel();
            channel.write(byteBuffer);
            channel.close();
            byteBuffer.flip();
        } catch (Exception e10) {
            Log.e(TAG, e10.toString());
        }
    }

    public static float[] toArray(FloatBuffer floatBuffer) {
        return toArray(floatBuffer, -1);
    }

    public static float[] toArray(FloatBuffer floatBuffer, int i10) {
        if (i10 <= 0) {
            i10 = floatBuffer.remaining();
        }
        float[] fArr = new float[i10];
        floatBuffer.get(fArr, 0, i10);
        return fArr;
    }

    public static void copyBuffer(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        copyBuffer(byteBuffer, byteBuffer2, byteBuffer2.remaining());
    }

    public static long[] toArray(LongBuffer longBuffer) {
        return toArray(longBuffer, -1);
    }

    public static long[] toArray(LongBuffer longBuffer, int i10) {
        if (i10 <= 0) {
            i10 = longBuffer.remaining();
        }
        long[] jArr = new long[i10];
        longBuffer.get(jArr, 0, i10);
        return jArr;
    }
}
