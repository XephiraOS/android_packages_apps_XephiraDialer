package com.heytap.accessory.bean;

import android.os.Bundle;
import java.util.Locale;

/* loaded from: classes3.dex */
public class TrafficReport {
    private static final String KEY_DELAY_TIME = "key_delay_time";
    private static final String KEY_MAX_WINDOW_SIZE = "key_max_window_size";
    private static final String KEY_TENDENCY = "key_tendency";
    private static final String KEY_USED_SIZE = "key_used_size";
    private long mMaxWindowSize;
    private long mUsedSize;
    private Tendency mTendency = Tendency.UNKNOWN;
    private int mDelayTime = 0;

    /* loaded from: classes3.dex */
    public enum Tendency {
        UNKNOWN,
        INCREASING,
        STABLE,
        DECREASING
    }

    public TrafficReport(long j10, long j11) {
        this.mMaxWindowSize = 0L;
        this.mUsedSize = 0L;
        this.mMaxWindowSize = j10;
        this.mUsedSize = j11;
    }

    public static TrafficReport createFromBundle(Bundle bundle) {
        long j10 = bundle.getLong(KEY_MAX_WINDOW_SIZE);
        long j11 = bundle.getLong(KEY_USED_SIZE);
        int i10 = bundle.getInt(KEY_TENDENCY);
        int i11 = bundle.getInt(KEY_DELAY_TIME);
        TrafficReport trafficReport = new TrafficReport(j10, j11);
        if (Tendency.values().length > i10) {
            trafficReport.setTendency(Tendency.values()[i10]);
        }
        trafficReport.setDelayTime(i11);
        return trafficReport;
    }

    public Bundle getBundle() {
        Bundle bundle = new Bundle();
        bundle.putLong(KEY_MAX_WINDOW_SIZE, this.mMaxWindowSize);
        bundle.putLong(KEY_USED_SIZE, this.mUsedSize);
        bundle.putInt(KEY_TENDENCY, this.mTendency.ordinal());
        bundle.putInt(KEY_DELAY_TIME, this.mDelayTime);
        return bundle;
    }

    public int getDelayTime() {
        return this.mDelayTime;
    }

    public long getLeftWindowSize() {
        return this.mMaxWindowSize - this.mUsedSize;
    }

    public long getMaxWindowSize() {
        return this.mMaxWindowSize;
    }

    public Tendency getTendency() {
        return this.mTendency;
    }

    public float getUsedPercent() {
        return (((float) this.mUsedSize) / ((float) this.mMaxWindowSize)) * 100.0f;
    }

    public String getUsedPercentString(int i10) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.CHINA, "%." + i10 + "f", Float.valueOf(getUsedPercent())));
        sb.append("%");
        return sb.toString();
    }

    public long getUsedSize() {
        return this.mUsedSize;
    }

    public void setDelayTime(int i10) {
        this.mDelayTime = i10;
    }

    public void setMaxWindowSize(long j10) {
        this.mMaxWindowSize = j10;
    }

    public void setTendency(Tendency tendency) {
        this.mTendency = tendency;
    }

    public void setUsedSize(long j10) {
        this.mUsedSize = j10;
    }
}
