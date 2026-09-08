package S3;

import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import i5.C1100a;
import i5.C1101b;
import java.util.Hashtable;

/* compiled from: QrcodeManager.java */
/* loaded from: classes3.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f3470a;

    public static Bitmap a(String str, int i10, int i11) {
        if (str != null) {
            try {
                if (!"".equals(str)) {
                    Hashtable hashtable = new Hashtable();
                    hashtable.put(EncodeHintType.CHARACTER_SET, "utf-8");
                    hashtable.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
                    hashtable.put(EncodeHintType.MARGIN, 0);
                    S4.b a10 = new C1101b().a(str, BarcodeFormat.QR_CODE, i10, i11, hashtable);
                    int[] iArr = new int[i10 * i11];
                    for (int i12 = 0; i12 < i11; i12++) {
                        for (int i13 = 0; i13 < i10; i13++) {
                            if (a10.d(i13, i12)) {
                                iArr[(i12 * i10) + i13] = -16777216;
                            } else {
                                iArr[(i12 * i10) + i13] = -1;
                            }
                        }
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
                    createBitmap.setPixels(iArr, 0, i10, 0, 0, i10, i11);
                    return createBitmap;
                }
            } catch (Exception e10) {
                H7.b.c("QrcodeManager", e10.toString());
            }
        }
        return null;
    }

    public static Bitmap b(String str) {
        return new e().b(str, 500, 500);
    }

    public String c(Bitmap bitmap) {
        Hashtable hashtable = new Hashtable();
        hashtable.put(DecodeHintType.CHARACTER_SET, "UTF8");
        P4.b bVar = new P4.b(new S4.i(new o(bitmap)));
        C1100a c1100a = new C1100a();
        try {
            try {
                return c1100a.a(bVar, hashtable).f();
            } catch (Exception e10) {
                H7.b.c("QrcodeManager", "e = " + e10);
                c1100a.reset();
                return null;
            }
        } finally {
            c1100a.reset();
        }
    }

    public String d(byte[] bArr, int i10, int i11) {
        P4.f fVar;
        P4.d dVar = new P4.d();
        try {
            try {
                this.f3470a = new byte[bArr.length];
                for (int i12 = 0; i12 < i11; i12++) {
                    for (int i13 = 0; i13 < i10; i13++) {
                        this.f3470a[(((i13 * i11) + i11) - i12) - 1] = bArr[(i12 * i10) + i13];
                    }
                }
                fVar = dVar.c(new P4.b(new S4.i(new j(this.f3470a, i11, i10, 0, 0, i11, i10))));
                dVar.reset();
            } catch (Exception e10) {
                H7.b.c("QrcodeManager", "e = " + e10);
                dVar.reset();
                fVar = null;
            }
            if (fVar == null) {
                return null;
            }
            return fVar.f();
        } catch (Throwable th) {
            dVar.reset();
            throw th;
        }
    }
}
