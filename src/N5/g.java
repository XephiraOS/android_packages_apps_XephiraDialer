package N5;

import android.content.Context;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SignVerifyUtils.java */
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2373a = Signature.class.getSimpleName();

    public static PublicKey a(byte[] bArr, String str) {
        try {
            return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(bArr));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e10) {
            e10.printStackTrace();
            d.c("convertPublicKey get exception - " + e10.getMessage());
            return null;
        }
    }

    public static List<L5.b> b() {
        ArrayList arrayList = new ArrayList();
        L5.b bVar = new L5.b();
        bVar.c("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEvE0DoqARwzQKOb/b0cx7B0BQ4Ux8mTdND8rX9KHproZAuOP/M049VdcJ53sjVujUF1URD4IGMtkId2QYwXoDHw==");
        bVar.d("OK");
        arrayList.add(bVar);
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean c(Context context, String str, byte[] bArr, int i10, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        PublicKey a10;
        byte[] b10 = b.b(str, b.d(context, str));
        byte[] bArr6 = new byte[b10.length + i10 + 10];
        int i11 = 0;
        h.a(bArr, 0, bArr6, 0, 1);
        h.a(bArr2, 0, bArr6, 1, 1);
        h.a(b10, 0, bArr6, 2, b10.length);
        h.a(bArr3, 0, bArr6, b10.length + 2, 4);
        h.a(bArr4, 0, bArr6, b10.length + 6, i10);
        h.a(h.d(i10), 0, bArr6, b10.length + i10 + 6, 4);
        try {
            Signature signature = Signature.getInstance("SHA256withECDSA");
            List<L5.b> b11 = b();
            boolean z10 = false;
            while (i11 < b11.size()) {
                try {
                    if ("OK".equals(b11.get(i11).b()) && (a10 = a(a.a(b11.get(i11).a()), "EC")) != null) {
                        signature.initVerify(a10);
                        signature.update(bArr6);
                        z10 = signature.verify(bArr5);
                        if (z10) {
                            return z10;
                        }
                    }
                    i11++;
                } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e10) {
                    e = e10;
                    i11 = z10 ? 1 : 0;
                    e.printStackTrace();
                    d.c("Verify signing get an exception is " + e.getMessage());
                    return i11;
                }
            }
            return z10;
        } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e11) {
            e = e11;
        }
    }
}
