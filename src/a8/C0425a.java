package a8;

import com.android.incallui.OplusPhoneUtils;
import com.heytap.accessory.constant.FastPairConstants;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyAgreement;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: PocSecurity.java */
/* renamed from: a8.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0425a {

    /* renamed from: f, reason: collision with root package name */
    public static Logger f6453f = Logger.getLogger(C0425a.class.getSimpleName());

    /* renamed from: a, reason: collision with root package name */
    public SecretKeySpec f6454a = null;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f6455b = null;

    /* renamed from: c, reason: collision with root package name */
    public KeyPair f6456c = null;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f6457d = null;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f6458e = null;

    public C0425a() {
        f();
    }

    public final String a(byte[] bArr) {
        if (bArr != null && bArr.length >= 1) {
            StringBuilder sb = new StringBuilder();
            for (byte b10 : bArr) {
                String hexString = Integer.toHexString(b10 & FastPairConstants.GO_INTENT_NOT_SET);
                if (hexString.length() < 2) {
                    sb.append(OplusPhoneUtils.DeviceState.UNLOCK_DEVICE);
                }
                sb.append(hexString);
            }
            f6453f.info("byteArray2HexString:" + sb.toString().toLowerCase() + " length:" + sb.toString().toLowerCase().length());
            return sb.toString().toLowerCase();
        }
        f6453f.info("byteArray2HexString byteArray invalid");
        return null;
    }

    public byte[] b(byte[] bArr) {
        try {
            if (this.f6455b != null && this.f6454a != null) {
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(2, this.f6454a, new GCMParameterSpec(128, this.f6455b));
                return cipher.doFinal(bArr);
            }
            f6453f.severe("decrypt mIv == null || mKey == null failed");
            return null;
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public boolean c(byte[] bArr) {
        PublicKey j10 = j(bArr);
        if (j10 == null) {
            f6453f.severe("deriveKey keySpecToPublicKey failed");
            return false;
        }
        KeyPair keyPair = this.f6456c;
        if (keyPair == null) {
            f6453f.severe("deriveKey mKeyPair == null");
            return false;
        }
        byte[] h10 = h(j10, keyPair.getPrivate());
        if (h10 == null) {
            f6453f.severe("deriveKey generateSecreKey failed");
            return false;
        }
        byte[] d10 = d("SHA-256", h10);
        if (d10 == null) {
            f6453f.severe("deriveKey digest failed");
            return false;
        }
        this.f6454a = new SecretKeySpec(Arrays.copyOfRange(d10, 0, 16), "AES");
        this.f6455b = Arrays.copyOfRange(d10, 16, 28);
        return true;
    }

    public final byte[] d(String str, byte[]... bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            for (byte[] bArr2 : bArr) {
                messageDigest.update(bArr2);
            }
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public byte[] e(byte[] bArr) {
        try {
            if (this.f6455b != null && this.f6454a != null) {
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(1, this.f6454a, new GCMParameterSpec(128, this.f6455b));
                return cipher.doFinal(bArr);
            }
            f6453f.severe("encrypt mIv == null || mKey == null failed");
            return null;
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public final void f() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
            keyPairGenerator.initialize(new ECGenParameterSpec("secp256r1"));
            this.f6456c = keyPairGenerator.genKeyPair();
        } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException e10) {
            e10.printStackTrace();
        }
    }

    public byte[] g() {
        KeyPair keyPair = this.f6456c;
        if (keyPair == null) {
            return null;
        }
        ECPublicKey eCPublicKey = (ECPublicKey) keyPair.getPublic();
        if (eCPublicKey == null) {
            f6453f.severe("genKeySpec ecPublicKey == null");
            return null;
        }
        byte[] i10 = i(eCPublicKey);
        f6453f.info("keySpec string:" + a(i10));
        return i10;
    }

    public final byte[] h(PublicKey publicKey, PrivateKey privateKey) {
        try {
            KeyAgreement keyAgreement = KeyAgreement.getInstance("ECDH");
            keyAgreement.init(privateKey);
            keyAgreement.doPhase(publicKey, true);
            return keyAgreement.generateSecret();
        } catch (InvalidKeyException | NoSuchAlgorithmException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public final byte[] i(ECPublicKey eCPublicKey) {
        BigInteger affineX = eCPublicKey.getW().getAffineX();
        BigInteger affineY = eCPublicKey.getW().getAffineY();
        byte[] bArr = new byte[64];
        byte[] byteArray = affineX.toByteArray();
        if (byteArray.length == 33) {
            System.arraycopy(byteArray, 1, bArr, 0, 32);
        } else {
            System.arraycopy(byteArray, 0, bArr, 32 - byteArray.length, byteArray.length);
        }
        byte[] byteArray2 = affineY.toByteArray();
        if (byteArray2.length == 33) {
            System.arraycopy(byteArray2, 1, bArr, 32, 32);
        } else {
            System.arraycopy(byteArray2, 0, bArr, 64 - byteArray2.length, byteArray2.length);
        }
        return bArr;
    }

    public final PublicKey j(byte[] bArr) {
        if (this.f6456c == null) {
            f6453f.severe("keySpecToPublicKey mKeyPair == null");
            return null;
        }
        if (bArr.length != 64) {
            f6453f.severe("keySpecToPublicKey invalid keySpec.length");
            return null;
        }
        try {
            return KeyFactory.getInstance("EC").generatePublic(new ECPublicKeySpec(new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 0, bArr.length / 2)), new BigInteger(1, Arrays.copyOfRange(bArr, bArr.length / 2, bArr.length))), ((ECPublicKey) this.f6456c.getPublic()).getParams()));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
