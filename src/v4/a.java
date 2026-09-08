package V4;

import P4.e;
import P4.f;
import P4.g;
import S4.b;
import S4.d;
import W4.c;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.List;
import java.util.Map;

/* compiled from: DataMatrixReader.java */
/* loaded from: classes3.dex */
public final class a implements e {

    /* renamed from: b, reason: collision with root package name */
    public static final g[] f4007b = new g[0];

    /* renamed from: a, reason: collision with root package name */
    public final c f4008a = new c();

    public static b b(b bVar) {
        int[] i10 = bVar.i();
        int[] e10 = bVar.e();
        if (i10 != null && e10 != null) {
            int c10 = c(i10, bVar);
            int i11 = i10[1];
            int i12 = e10[1];
            int i13 = i10[0];
            int i14 = ((e10[0] - i13) + 1) / c10;
            int i15 = ((i12 - i11) + 1) / c10;
            if (i14 > 0 && i15 > 0) {
                int i16 = c10 / 2;
                int i17 = i11 + i16;
                int i18 = i13 + i16;
                b bVar2 = new b(i14, i15);
                for (int i19 = 0; i19 < i15; i19++) {
                    int i20 = (i19 * c10) + i17;
                    for (int i21 = 0; i21 < i14; i21++) {
                        if (bVar.d((i21 * c10) + i18, i20)) {
                            bVar2.l(i21, i19);
                        }
                    }
                }
                return bVar2;
            }
            throw NotFoundException.a();
        }
        throw NotFoundException.a();
    }

    public static int c(int[] iArr, b bVar) {
        int j10 = bVar.j();
        int i10 = iArr[0];
        int i11 = iArr[1];
        while (i10 < j10 && bVar.d(i10, i11)) {
            i10++;
        }
        if (i10 != j10) {
            int i12 = i10 - iArr[0];
            if (i12 != 0) {
                return i12;
            }
            throw NotFoundException.a();
        }
        throw NotFoundException.a();
    }

    @Override // P4.e
    public f a(P4.b bVar, Map<DecodeHintType, ?> map) {
        d b10;
        g[] b11;
        if (map != null && map.containsKey(DecodeHintType.PURE_BARCODE)) {
            b10 = this.f4008a.b(b(bVar.a()));
            b11 = f4007b;
        } else {
            S4.f b12 = new X4.a(bVar.a()).b();
            b10 = this.f4008a.b(b12.a());
            b11 = b12.b();
        }
        f fVar = new f(b10.h(), b10.e(), b11, BarcodeFormat.DATA_MATRIX);
        List<byte[]> a10 = b10.a();
        if (a10 != null) {
            fVar.h(ResultMetadataType.BYTE_SEGMENTS, a10);
        }
        String b13 = b10.b();
        if (b13 != null) {
            fVar.h(ResultMetadataType.ERROR_CORRECTION_LEVEL, b13);
        }
        return fVar;
    }

    @Override // P4.e
    public void reset() {
    }
}
