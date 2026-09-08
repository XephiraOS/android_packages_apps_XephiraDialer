package com.oua.tflite;

import com.oua.util.StringUtil;
import org.tensorflow.lite.Tensor;

/* loaded from: classes4.dex */
public class TensorUtil {
    public static String toString(Tensor tensor) {
        return String.format("{shape:%s, data_type:%s, numnBytes %d}", StringUtil.toString(tensor.r()), tensor.g(), Integer.valueOf(tensor.n()));
    }
}
