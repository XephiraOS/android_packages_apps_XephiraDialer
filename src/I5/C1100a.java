package i5;

import P4.e;
import P4.f;
import P4.g;
import S4.d;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import j5.C1165c;
import j5.C1167e;
import java.util.List;
import java.util.Map;
import k5.C1214c;

/* compiled from: QRCodeReader.java */
/* renamed from: i5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1100a implements e {

    /* renamed from: b, reason: collision with root package name */
    public static final g[] f32187b = new g[0];

    /* renamed from: a, reason: collision with root package name */
    public final C1165c f32188a = new C1165c();

    private static S4.b b(S4.b bVar) {
        int[] i10 = bVar.i();
        int[] e10 = bVar.e();
        if (i10 != null && e10 != null) {
            float c10 = c(i10, bVar);
            int i11 = i10[1];
            int i12 = e10[1];
            int i13 = i10[0];
            int i14 = e10[0];
            if (i13 < i14 && i11 < i12) {
                int i15 = i12 - i11;
                if (i15 != i14 - i13 && (i14 = i13 + i15) >= bVar.j()) {
                    throw NotFoundException.a();
                }
                int round = Math.round(((i14 - i13) + 1) / c10);
                int round2 = Math.round((i15 + 1) / c10);
                if (round > 0 && round2 > 0) {
                    if (round2 == round) {
                        int i16 = (int) (c10 / 2.0f);
                        int i17 = i11 + i16;
                        int i18 = i13 + i16;
                        int i19 = (((int) ((round - 1) * c10)) + i18) - i14;
                        if (i19 > 0) {
                            if (i19 <= i16) {
                                i18 -= i19;
                            } else {
                                throw NotFoundException.a();
                            }
                        }
                        int i20 = (((int) ((round2 - 1) * c10)) + i17) - i12;
                        if (i20 > 0) {
                            if (i20 <= i16) {
                                i17 -= i20;
                            } else {
                                throw NotFoundException.a();
                            }
                        }
                        S4.b bVar2 = new S4.b(round, round2);
                        for (int i21 = 0; i21 < round2; i21++) {
                            int i22 = ((int) (i21 * c10)) + i17;
                            for (int i23 = 0; i23 < round; i23++) {
                                if (bVar.d(((int) (i23 * c10)) + i18, i22)) {
                                    bVar2.l(i23, i21);
                                }
                            }
                        }
                        return bVar2;
                    }
                    throw NotFoundException.a();
                }
                throw NotFoundException.a();
            }
            throw NotFoundException.a();
        }
        throw NotFoundException.a();
    }

    public static float c(int[] iArr, S4.b bVar) {
        int g10 = bVar.g();
        int j10 = bVar.j();
        int i10 = iArr[0];
        boolean z10 = true;
        int i11 = iArr[1];
        int i12 = 0;
        while (i10 < j10 && i11 < g10) {
            if (z10 != bVar.d(i10, i11)) {
                i12++;
                if (i12 == 5) {
                    break;
                }
                z10 = !z10;
            }
            i10++;
            i11++;
        }
        if (i10 != j10 && i11 != g10) {
            return (i10 - iArr[0]) / 7.0f;
        }
        throw NotFoundException.a();
    }

    @Override // P4.e
    public final f a(P4.b bVar, Map<DecodeHintType, ?> map) {
        d b10;
        g[] b11;
        if (map != null && map.containsKey(DecodeHintType.PURE_BARCODE)) {
            b10 = this.f32188a.b(b(bVar.a()), map);
            b11 = f32187b;
        } else {
            S4.f e10 = new C1214c(bVar.a()).e(map);
            b10 = this.f32188a.b(e10.a(), map);
            b11 = e10.b();
        }
        if (b10.d() instanceof C1167e) {
            ((C1167e) b10.d()).a(b11);
        }
        f fVar = new f(b10.h(), b10.e(), b11, BarcodeFormat.QR_CODE);
        List<byte[]> a10 = b10.a();
        if (a10 != null) {
            fVar.h(ResultMetadataType.BYTE_SEGMENTS, a10);
        }
        String b12 = b10.b();
        if (b12 != null) {
            fVar.h(ResultMetadataType.ERROR_CORRECTION_LEVEL, b12);
        }
        if (b10.i()) {
            fVar.h(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(b10.g()));
            fVar.h(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(b10.f()));
        }
        return fVar;
    }

    @Override // P4.e
    public void reset() {
    }
}
