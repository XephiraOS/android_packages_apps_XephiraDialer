package W9;

import com.heytap.accessory.constant.FastPairConstants;
import org.tensorflow.lite.DataType;

/* compiled from: TensorBufferUint8.java */
/* loaded from: classes4.dex */
public final class c extends a {

    /* renamed from: e, reason: collision with root package name */
    public static final DataType f4254e = DataType.UINT8;

    public c(int[] iArr) {
        super(iArr);
    }

    @Override // W9.a
    public DataType e() {
        return f4254e;
    }

    @Override // W9.a
    public float[] g() {
        this.f4248a.rewind();
        float[] fArr = new float[this.f4250c];
        for (int i10 = 0; i10 < this.f4250c; i10++) {
            fArr[i10] = this.f4248a.get() & FastPairConstants.GO_INTENT_NOT_SET;
        }
        return fArr;
    }

    @Override // W9.a
    public int i() {
        return f4254e.a();
    }
}
