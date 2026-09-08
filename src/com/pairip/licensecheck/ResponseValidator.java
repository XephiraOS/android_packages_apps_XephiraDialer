package com.pairip.licensecheck;

import android.os.Bundle;
import android.util.Base64;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ResponseValidator {
    private static final String KEY_FACTORY_ALGORITHM = "RSA";
    private static final String PAYLOAD_LICENSE_DATA = "LICENSE_DATA";
    private static final String PAYLOAD_PACKAGE_NAME = "packageName";
    private static final String SIGNATURE_ALGORITHM = "SHA256withRSA";
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    public static void validateResponse(Bundle responsePayload, String packageName) throws LicenseCheckException {
        try {
            String string = responsePayload.getString(PAYLOAD_LICENSE_DATA);
            if (string == null) {
                throw new LicenseCheckException("Invalid response");
            }
            String[] split = string.split("\\.", -1);
            if (split.length != 3) {
                throw new LicenseCheckException("Invalid response");
            }
            JSONObject base64ToJson = base64ToJson(split[0]);
            JSONObject base64ToJson2 = base64ToJson(split[1]);
            String str = split[2];
            String str2 = split[0] + "." + split[1];
            if (!base64ToJson.getString("alg").equals("RS256")) {
                throw new LicenseCheckException("Response must be signed with RS256 algorithm.");
            }
            verifySignature(str2, str, SIGNATURE_ALGORITHM, getPublicKey());
            if (!base64ToJson2.getString("packageName").equals(packageName)) {
                throw new LicenseCheckException("Package name doesn't match.");
            }
        } catch (JSONException e10) {
            throw new LicenseCheckException("Could not decode json", e10);
        }
    }

    private static JSONObject base64ToJson(String input) throws LicenseCheckException {
        try {
            return new JSONObject(new String(Base64.decode(input, 8), UTF_8));
        } catch (IllegalArgumentException | JSONException e10) {
            throw new LicenseCheckException("Invalid response", e10);
        }
    }

    private static void verifySignature(String signedData, String signature, String signatureAlgorithm, PublicKey publicKey) throws LicenseCheckException {
        try {
            Signature signature2 = Signature.getInstance(signatureAlgorithm);
            signature2.initVerify(publicKey);
            signature2.update(signedData.getBytes(UTF_8));
            if (signature2.verify(Base64.decode(signature, 8))) {
            } else {
                throw new LicenseCheckException("Signature verification failed.");
            }
        } catch (IllegalArgumentException e10) {
            throw new LicenseCheckException("Could not base64 decode returned signature", e10);
        } catch (InvalidKeyException e11) {
            throw new LicenseCheckException("Could not sign data with the public key", e11);
        } catch (NoSuchAlgorithmException e12) {
            throw new LicenseCheckException(String.format("Could not find %s algorithm on the device", signatureAlgorithm), e12);
        } catch (SignatureException e13) {
            throw new LicenseCheckException("Could not parse returned signature.", e13);
        }
    }

    private static PublicKey getPublicKey() throws LicenseCheckException {
        try {
            return KeyFactory.getInstance(KEY_FACTORY_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(LicenseClient.getLicensePubKey(), 0)));
        } catch (IllegalArgumentException e10) {
            throw new LicenseCheckException("Could not decode public key", e10);
        } catch (NoSuchAlgorithmException e11) {
            throw new LicenseCheckException(String.format("%s algorithm not found on device", KEY_FACTORY_ALGORITHM), e11);
        } catch (InvalidKeySpecException e12) {
            throw new LicenseCheckException("Could not create key specification from the public key", e12);
        }
    }

    private ResponseValidator() {
    }
}
