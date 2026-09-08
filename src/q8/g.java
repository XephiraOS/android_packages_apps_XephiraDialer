package q8;

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
import o8.C1410b;

/* compiled from: SignVerifyUtils.java */
/* loaded from: classes3.dex */
public class g {
    public static PublicKey a(byte[] bArr, String str) {
        try {
            return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(bArr));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e10) {
            e10.printStackTrace();
            d.c("convertPublicKey get exception - " + e10.getMessage());
            return null;
        }
    }

    public static List<C1410b> b() {
        ArrayList arrayList = new ArrayList();
        C1410b c1410b = new C1410b();
        c1410b.c("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEvE0DoqARwzQKOb/b0cx7B0BQ4Ux8mTdND8rX9KHproZAuOP/M049VdcJ53sjVujUF1URD4IGMtkId2QYwXoDHw==");
        c1410b.d("OK");
        arrayList.add(c1410b);
        return arrayList;
    }

    public static byte[] c(Context context, String str, byte[] bArr, int i10, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        byte[] b10 = b.b(str, b.e(context, str));
        byte[] bArr5 = new byte[b10.length + i10 + 10];
        h.a(bArr, 0, bArr5, 0, 1);
        h.a(bArr2, 0, bArr5, 1, 1);
        h.a(b10, 0, bArr5, 2, b10.length);
        h.a(bArr3, 0, bArr5, b10.length + 2, 4);
        h.a(bArr4, 0, bArr5, b10.length + 6, i10);
        h.a(h.d(i10), 0, bArr5, b10.length + i10 + 6, 4);
        return bArr5;
    }

    public static boolean d(String str, Signature signature, byte[] bArr, byte[] bArr2) {
        PublicKey a10 = a(C1495a.a(str), "EC");
        if (a10 == null) {
            return false;
        }
        signature.initVerify(a10);
        signature.update(bArr);
        return signature.verify(bArr2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean e(Context context, String str, byte[] bArr, int i10, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        byte[] c10 = c(context, str, bArr, i10, bArr2, bArr3, bArr4);
        int i11 = 0;
        try {
            Signature signature = Signature.getInstance("SHA256withECDSA");
            List<C1410b> b10 = b();
            boolean z10 = false;
            while (i11 < b10.size()) {
                try {
                    if ("OK".equals(b10.get(i11).b()) && (z10 = d(b10.get(i11).a(), signature, c10, bArr5))) {
                        return true;
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
