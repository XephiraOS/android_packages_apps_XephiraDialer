package com.heytap.accessory.bean;

/* loaded from: classes3.dex */
public class ServiceChannel {
    public static final int PRIORITY_HIGH = 2;
    public static final int PRIORITY_LOW = 0;
    public static final int PRIORITY_MEDIUM = 1;
    public static final int RELIABILITY_DISABLE = 4;
    public static final int RELIABILITY_ENABLE = 5;
    private int mChannelId;
    private int mClassType;
    private int mPriority;
    private int mReliability;

    public ServiceChannel(int i10, int i11, int i12, int i13) {
        this.mChannelId = i10;
        this.mPriority = i11;
        this.mReliability = i12;
        this.mClassType = i13;
    }

    public int getChannelId() {
        return this.mChannelId;
    }

    public int getClassType() {
        return this.mClassType;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int getReliability() {
        return this.mReliability;
    }

    public String toString() {
        return "ServiceChannel{mChannelId=" + this.mChannelId + ", mPriority=" + this.mPriority + ", mReliability=" + this.mReliability + ", mClassType=" + this.mClassType + '}';
    }
}
