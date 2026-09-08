package org.tensorflow.lite;

/* loaded from: classes4.dex */
public final class TensorFlowLite {

    /* renamed from: a, reason: collision with root package name */
    public static final Throwable f35919a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f35920b = false;

    static {
        try {
            System.loadLibrary("tensorflowlite_jni");
            e = null;
        } catch (UnsatisfiedLinkError e10) {
            e = e10;
        }
        f35919a = e;
    }

    public static void a() {
        if (f35920b) {
            return;
        }
        try {
            nativeRuntimeVersion();
            f35920b = true;
        } catch (UnsatisfiedLinkError e10) {
            e = e10;
            Object obj = f35919a;
            if (obj != null) {
                e = obj;
            }
            throw new UnsatisfiedLinkError("Failed to load native TensorFlow Lite methods. Check that the correct native libraries are present, and, if using a custom native library, have been properly loaded via System.loadLibrary():\n  " + e);
        }
    }

    public static String b() {
        a();
        return nativeRuntimeVersion();
    }

    public static native String nativeRuntimeVersion();

    public static native String nativeSchemaVersion();
}
