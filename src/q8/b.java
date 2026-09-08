package q8;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import com.android.incallui.OplusPhoneUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* compiled from: CertUtils.java */
/* loaded from: classes3.dex */
public class b {
    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i10 = 0; i10 < bArr.length; i10++) {
            String hexString = Integer.toHexString(bArr[i10]);
            int length = hexString.length();
            if (length == 1) {
                hexString = OplusPhoneUtils.DeviceState.UNLOCK_DEVICE + hexString;
            }
            if (length > 2) {
                hexString = hexString.substring(length - 2, length);
            }
            sb.append(hexString.toUpperCase());
            if (i10 < bArr.length - 1) {
                sb.append(':');
            }
        }
        return sb.toString();
    }

    public static byte[] b(String str, String str2) {
        return (str + l(str2)).getBytes(StandardCharsets.UTF_8);
    }

    public static CertificateFactory c() {
        try {
            return CertificateFactory.getInstance("X509");
        } catch (Exception e10) {
            d.c("get instance of CertificateFactory exception " + e10.getMessage());
            return null;
        }
    }

    public static X509Certificate d(CertificateFactory certificateFactory, InputStream inputStream) {
        if (certificateFactory == null) {
            return null;
        }
        try {
            return (X509Certificate) certificateFactory.generateCertificate(inputStream);
        } catch (Exception e10) {
            d.c("get X509Certificate from CertificateFactory exception " + e10.getMessage());
            return null;
        }
    }

    public static String e(Context context, String str) {
        return g(context, "SHA1", str);
    }

    public static String f(Context context, String str) {
        return g(context, "SHA256", str);
    }

    public static String g(Context context, String str, String str2) {
        SigningInfo i10 = i(context, str2);
        if (i10 == null) {
            return "";
        }
        Signature[] apkContentsSigners = i10.getApkContentsSigners();
        if (apkContentsSigners.length == 1) {
            return j(apkContentsSigners[0].toByteArray(), str);
        }
        if (i10.hasMultipleSigners()) {
            return k(apkContentsSigners, str);
        }
        return j(apkContentsSigners[0].toByteArray(), str);
    }

    public static String h(X509Certificate x509Certificate, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (x509Certificate == null) {
                return "";
            }
            return a(messageDigest.digest(x509Certificate.getEncoded()));
        } catch (NoSuchAlgorithmException | CertificateEncodingException e10) {
            d.c("getHexStringCertificate from X509Certificate exception " + e10.getMessage());
            return "";
        }
    }

    public static SigningInfo i(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 134217728);
        } catch (PackageManager.NameNotFoundException e10) {
            d.c("get packageInfo exception " + e10.getMessage());
            packageInfo = null;
        }
        if (packageInfo == null) {
            return null;
        }
        return packageInfo.signingInfo;
    }

    public static String j(byte[] bArr, String str) {
        return h(d(c(), new ByteArrayInputStream(bArr)), str);
    }

    public static String k(Signature[] signatureArr, String str) {
        int length = signatureArr.length;
        String[] strArr = new String[length];
        for (int i10 = 0; i10 < signatureArr.length; i10++) {
            strArr[i10] = j(signatureArr[i10].toByteArray(), str);
        }
        Arrays.sort(strArr);
        StringBuilder sb = new StringBuilder();
        for (int i11 = 0; i11 < length; i11++) {
            if (i11 != length - 1) {
                sb.append(strArr[i11]);
                sb.append(":");
            } else {
                sb.append(strArr[i11]);
            }
        }
        return sb.toString();
    }

    public static String l(String str) {
        if (str.contains(":")) {
            return str.replaceAll(":", "");
        }
        return str;
    }
}
