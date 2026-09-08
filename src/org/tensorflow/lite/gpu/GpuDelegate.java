package org.tensorflow.lite.gpu;

import java.io.Closeable;

/* loaded from: classes4.dex */
public class GpuDelegate implements org.tensorflow.lite.a, Closeable {

    /* renamed from: a, reason: collision with root package name */
    public long f35927a;

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f35928a = true;

        /* renamed from: b, reason: collision with root package name */
        public int f35929b = 0;
    }

    static {
        System.loadLibrary("tensorflowlite_gpu_jni");
    }

    public GpuDelegate(a aVar) {
        this.f35927a = createDelegate(aVar.f35928a, aVar.f35929b);
    }

    private static native long createDelegate(boolean z10, int i10);

    private static native void deleteDelegate(long j10);

    @Override // org.tensorflow.lite.a
    public long a() {
        return this.f35927a;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        long j10 = this.f35927a;
        if (j10 != 0) {
            deleteDelegate(j10);
            this.f35927a = 0L;
        }
    }

    public GpuDelegate() {
        this(new a());
    }
}
