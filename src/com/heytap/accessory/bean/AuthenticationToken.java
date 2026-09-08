package com.heytap.accessory.bean;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class AuthenticationToken {
    private static final String KEY_ENCODING_FORMAT = "ISO-8859-1";
    private int mAuthType;
    private byte[] mKey;

    public AuthenticationToken(int i10, byte[] bArr) {
        if (bArr != null) {
            this.mKey = Arrays.copyOf(bArr, bArr.length);
        }
        this.mAuthType = i10;
    }

    public int getAuthenticationType() {
        return this.mAuthType;
    }

    public byte[] getKey() {
        return this.mKey;
    }

    public String toString() {
        String str;
        try {
            byte[] bArr = this.mKey;
            if (bArr != null) {
                str = new String(bArr, KEY_ENCODING_FORMAT);
            } else {
                str = null;
            }
        } catch (UnsupportedEncodingException unused) {
            str = "Failed to encode Key!! charsetISO-8859-1 is not supported";
        }
        return "Type:" + this.mAuthType + " Key:" + str;
    }
}
