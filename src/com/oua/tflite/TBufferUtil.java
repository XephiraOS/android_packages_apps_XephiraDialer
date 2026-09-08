package com.oua.tflite;

import android.util.Log;
import com.oua.util.ArrayUtil;
import com.oua.util.BufferUtil;
import com.oua.util.SimpleTrace;
import com.oua.util.StringUtil;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class TBufferUtil {
    public static void logAndSave(String str, String str2, W9.a aVar, String str3) {
        Log.d(str, String.format("TensorBuffer %s %s", str2, toString(aVar)));
        Log.d(str, String.format("%s:%s ", str2, ArrayUtil.analyze(aVar.g())));
        if (str3 != null) {
            BufferUtil.saveRawBuffer(aVar.d(), String.format("%s/%s_%s_%s.raw", str3, str2, StringUtil.toString(aVar.h()), aVar.e().toString()));
        }
    }

    public static W9.a[] split(W9.a aVar) {
        SimpleTrace.getTrace().startSection("TensorBuffer_split", TBufferUtil.class.getName());
        if (aVar.d().remaining() == 0) {
            aVar.d().flip();
        }
        int[] h10 = aVar.h();
        int[] iArr = new int[h10.length - 1];
        for (int i10 = 0; i10 < h10.length - 1; i10++) {
            iArr[i10] = h10[i10];
        }
        int i11 = h10[h10.length - 1];
        W9.a[] aVarArr = new W9.a[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            aVarArr[i12] = W9.a.c(iArr, aVar.e());
        }
        ByteBuffer d10 = aVar.d();
        int i13 = aVar.i();
        byte[] bArr = new byte[i13];
        while (d10.hasRemaining()) {
            for (int i14 = 0; i14 < i11; i14++) {
                for (int i15 = 0; i15 < i13; i15++) {
                    aVarArr[i14].d().put(d10.get());
                }
            }
        }
        SimpleTrace.getTrace().addEvent("convert2");
        for (int i16 = 0; i16 < i11; i16++) {
            aVarArr[i16].d().flip();
        }
        SimpleTrace.getTrace().endSection("TensorBuffer_split");
        return aVarArr;
    }

    public static String toString(W9.a aVar) {
        return String.format("{shape: %s, flat_size %d, data_type: %s, buffer : %s}", StringUtil.toString(aVar.h()), Integer.valueOf(aVar.f()), aVar.e().toString(), aVar.d().toString());
    }
}
