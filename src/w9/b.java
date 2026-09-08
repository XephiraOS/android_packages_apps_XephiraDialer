package W9;

import org.tensorflow.lite.DataType;

/* compiled from: TensorBufferFloat.java */
/* loaded from: classes4.dex */
public final class b extends a {

    /* renamed from: e, reason: collision with root package name */
    public static final DataType f4253e = DataType.FLOAT32;

    public b(int[] iArr) {
        super(iArr);
    }

    @Override // W9.a
    public DataType e() {
        return f4253e;
    }

    @Override // W9.a
    public float[] g() {
        this.f4248a.rewind();
        float[] fArr = new float[this.f4250c];
        this.f4248a.asFloatBuffer().get(fArr);
        return fArr;
    }

    @Override // W9.a
    public int i() {
        return f4253e.a();
    }
}
