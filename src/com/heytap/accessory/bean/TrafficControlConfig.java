package com.heytap.accessory.bean;

import android.os.Bundle;
import com.heytap.accessory.bean.FlowControlConfig;
import java.util.ArrayList;

@Deprecated
/* loaded from: classes3.dex */
public class TrafficControlConfig {
    private static final int DEFAULT_MAX_WINDOW_SIZE = 3000000;
    private static final String KEY_BAN_CHANNEL_TYPE = "key_ban_channel_type";
    private static final String KEY_BAN_TRANSPORT_TYPE = "key_ban_transport_type";
    private static final String KEY_MAX_WINDOW_SIZE = "key_max_window_size";
    private static final String KEY_SHOW_LOG = "key_show_log";
    private static final String KEY_TC_DELAY_TIME = "key_tc_delay_time";
    private static final String KEY_TC_STRATEGY = "key_tc_strategy";
    private static final String KEY_TC_SWITCH = "key_tc_switch";
    public static final int STRATEGY_AUTO = 0;
    public static final int STRATEGY_NONE = -1;
    public static final int STRATEGY_SEND_ADDITION_SIZE = 2;
    public static final int STRATEGY_SEND_ADDITION_SIZE_LAZY = 1;
    private boolean mEnable;
    private int mHandleMsgTime;
    private boolean mShowLog;
    private int mStrategy;
    private int mMaxWindowSize = DEFAULT_MAX_WINDOW_SIZE;
    private ArrayList<Integer> mTransportTypeBanList = new ArrayList<>();
    private ArrayList<Integer> mChannelTypeBanList = new ArrayList<>();

    public static TrafficControlConfig createFromBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        int i10 = bundle.getInt(KEY_TC_DELAY_TIME);
        boolean z10 = bundle.getBoolean(KEY_TC_SWITCH);
        int i11 = bundle.getInt(KEY_TC_STRATEGY);
        int i12 = bundle.getInt(KEY_MAX_WINDOW_SIZE);
        boolean z11 = bundle.getBoolean(KEY_SHOW_LOG);
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(KEY_BAN_TRANSPORT_TYPE);
        ArrayList<Integer> integerArrayList2 = bundle.getIntegerArrayList(KEY_BAN_CHANNEL_TYPE);
        TrafficControlConfig trafficControlConfig = new TrafficControlConfig();
        trafficControlConfig.setHandleMsgTime(i10);
        trafficControlConfig.setEnable(z10);
        trafficControlConfig.setStrategy(i11);
        trafficControlConfig.setMaxWindowSize(i12);
        trafficControlConfig.setShowLog(z11);
        trafficControlConfig.setTransportTypeBanList(integerArrayList);
        trafficControlConfig.setChannelTypeBanList(integerArrayList2);
        return trafficControlConfig;
    }

    private ArrayList<Integer> getChannelTypeBanList() {
        return this.mChannelTypeBanList;
    }

    private ArrayList<Integer> getTransportTypeBanList() {
        return this.mTransportTypeBanList;
    }

    private void setChannelTypeBanList(ArrayList<Integer> arrayList) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.mChannelTypeBanList = arrayList;
    }

    private void setTransportTypeBanList(ArrayList<Integer> arrayList) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.mTransportTypeBanList = arrayList;
    }

    public TrafficControlConfig banChannelType(int i10) {
        this.mChannelTypeBanList.add(Integer.valueOf(i10));
        return this;
    }

    public TrafficControlConfig banTransportType(int i10) {
        this.mTransportTypeBanList.add(Integer.valueOf(i10));
        return this;
    }

    public void clearBanList() {
        this.mChannelTypeBanList.clear();
        this.mTransportTypeBanList.clear();
    }

    public FlowControlConfig convertToNewVersion() {
        FlowControlConfig.Builder builder = new FlowControlConfig.Builder();
        FlowControlConfig.Strategy strategy = FlowControlConfig.Strategy.STRATEGY_NONE;
        int i10 = this.mStrategy;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    strategy = FlowControlConfig.Strategy.STRATEGY_SEND_ADDITION_SIZE;
                }
            } else {
                strategy = FlowControlConfig.Strategy.STRATEGY_SEND_ADDITION_SIZE_LAZY;
            }
        } else {
            strategy = FlowControlConfig.Strategy.STRATEGY_AUTO;
        }
        return builder.setEnable(this.mEnable).setMaxWindowSize(this.mMaxWindowSize).setStrategy(strategy).setHandleMsgTime(this.mHandleMsgTime).enableWifi(false).enableWifiLan(false).enableBle(!hasTransportTypeBanned(4)).enableBt(!hasTransportTypeBanned(2)).enableFile(!hasChannelTypeBanned(0)).enableStream(!hasChannelTypeBanned(2)).create();
    }

    public Bundle getBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_TC_DELAY_TIME, this.mHandleMsgTime);
        bundle.putBoolean(KEY_TC_SWITCH, this.mEnable);
        bundle.putInt(KEY_TC_STRATEGY, this.mStrategy);
        bundle.putInt(KEY_MAX_WINDOW_SIZE, this.mMaxWindowSize);
        bundle.putBoolean(KEY_SHOW_LOG, this.mShowLog);
        bundle.putIntegerArrayList(KEY_BAN_TRANSPORT_TYPE, this.mTransportTypeBanList);
        bundle.putIntegerArrayList(KEY_BAN_CHANNEL_TYPE, this.mChannelTypeBanList);
        return bundle;
    }

    public int getHandleMsgTime() {
        return this.mHandleMsgTime;
    }

    public int getMaxWindowSize() {
        return this.mMaxWindowSize;
    }

    public int getStrategy() {
        return this.mStrategy;
    }

    public boolean hasChannelTypeBanned(int i10) {
        return this.mChannelTypeBanList.contains(Integer.valueOf(i10));
    }

    public boolean hasTransportTypeBanned(int i10) {
        return this.mTransportTypeBanList.contains(Integer.valueOf(i10));
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public boolean isShowLog() {
        return this.mShowLog;
    }

    public void setEnable(boolean z10) {
        this.mEnable = z10;
    }

    public void setHandleMsgTime(int i10) {
        this.mHandleMsgTime = i10;
    }

    public void setMaxWindowSize(int i10) {
        this.mMaxWindowSize = i10;
    }

    public void setShowLog(boolean z10) {
        this.mShowLog = z10;
    }

    public void setStrategy(int i10) {
        this.mStrategy = i10;
    }

    public String toString() {
        return "TrafficControlConfig{mHandleMsgTime=" + this.mHandleMsgTime + ", mEnable=" + this.mEnable + ", mStrategy=" + this.mStrategy + ", mMaxWindowSize=" + this.mMaxWindowSize + ", mShowLog=" + this.mShowLog + ", banChannel=" + this.mChannelTypeBanList + ", banTransport=" + this.mTransportTypeBanList + '}';
    }
}
