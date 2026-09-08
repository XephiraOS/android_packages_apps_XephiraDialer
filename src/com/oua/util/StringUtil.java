package com.oua.util;

import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

/* loaded from: classes4.dex */
public class StringUtil {
    private static final String TAG = "com.oua.util.StringUtil";

    public static String byteToHex(byte[] bArr) {
        Formatter formatter = new Formatter();
        for (byte b10 : bArr) {
            formatter.format("%02x", Byte.valueOf(b10));
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }

    public static String encrypt(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.reset();
            messageDigest.update(str.getBytes());
            return byteToHex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e10) {
            Log.e(TAG, "Cannot encrypt, no SHA-1 support");
            e10.printStackTrace();
            return "";
        }
    }

    public static <T> String toString(T t10) {
        try {
            return new com.google.gson.e().c().d().b().s(t10);
        } catch (Exception e10) {
            Log.w(TAG, "toString failed!", e10);
            return "toString failed!";
        }
    }
}
