package org.tensorflow.lite.nnapi;

import org.tensorflow.lite.TensorFlowLite;

/* loaded from: classes4.dex */
public class NnApiDelegate implements org.tensorflow.lite.a, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public long f35930a;

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f35931a = -1;

        /* renamed from: b, reason: collision with root package name */
        public String f35932b = null;

        /* renamed from: c, reason: collision with root package name */
        public String f35933c = null;

        /* renamed from: d, reason: collision with root package name */
        public String f35934d = null;

        /* renamed from: e, reason: collision with root package name */
        public Integer f35935e = null;
    }

    public NnApiDelegate(a aVar) {
        TensorFlowLite.a();
        this.f35930a = createDelegate(aVar.f35931a, aVar.f35932b, aVar.f35933c, aVar.f35934d, aVar.f35935e != null ? aVar.f35935e.intValue() : -1);
    }

    private static native long createDelegate(int i10, String str, String str2, String str3, int i11);

    private static native void deleteDelegate(long j10);

    @Override // org.tensorflow.lite.a
    public long a() {
        return this.f35930a;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        long j10 = this.f35930a;
        if (j10 != 0) {
            deleteDelegate(j10);
            this.f35930a = 0L;
        }
    }

    public NnApiDelegate() {
        this(new a());
    }
}
