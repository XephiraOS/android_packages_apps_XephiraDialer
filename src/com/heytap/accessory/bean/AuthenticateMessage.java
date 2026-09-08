package com.heytap.accessory.bean;

/* loaded from: classes3.dex */
public class AuthenticateMessage {
    public static final int AUTH_TYPE_NORMAL = 1;
    public static final int AUTH_TYPE_PIN = 2;
    private byte[] mData;
    private int mType;

    public AuthenticateMessage(byte[] bArr) {
        this.mData = bArr;
    }

    public byte[] getData() {
        return this.mData;
    }

    public int getType() {
        return this.mType;
    }

    public AuthenticateMessage(int i10, byte[] bArr) {
        this.mType = i10;
        this.mData = bArr;
    }
}
