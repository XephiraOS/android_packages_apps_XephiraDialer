package Y4;

import P4.e;
import P4.f;
import P4.g;
import S4.b;
import S4.d;
import Z4.c;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.Map;

/* compiled from: MaxiCodeReader.java */
/* loaded from: classes3.dex */
public final class a implements e {

    /* renamed from: b, reason: collision with root package name */
    public static final g[] f5540b = new g[0];

    /* renamed from: a, reason: collision with root package name */
    public final c f5541a = new c();

    private static b b(b bVar) {
        int[] f10 = bVar.f();
        if (f10 != null) {
            int i10 = f10[0];
            int i11 = f10[1];
            int i12 = f10[2];
            int i13 = f10[3];
            b bVar2 = new b(30, 33);
            for (int i14 = 0; i14 < 33; i14++) {
                int i15 = (((i14 * i13) + (i13 / 2)) / 33) + i11;
                for (int i16 = 0; i16 < 30; i16++) {
                    if (bVar.d(((((i16 * i12) + (i12 / 2)) + (((i14 & 1) * i12) / 2)) / 30) + i10, i15)) {
                        bVar2.l(i16, i14);
                    }
                }
            }
            return bVar2;
        }
        throw NotFoundException.a();
    }

    @Override // P4.e
    public f a(P4.b bVar, Map<DecodeHintType, ?> map) {
        d b10 = this.f5541a.b(b(bVar.a()), map);
        f fVar = new f(b10.h(), b10.e(), f5540b, BarcodeFormat.MAXICODE);
        String b11 = b10.b();
        if (b11 != null) {
            fVar.h(ResultMetadataType.ERROR_CORRECTION_LEVEL, b11);
        }
        return fVar;
    }

    @Override // P4.e
    public void reset() {
    }
}
