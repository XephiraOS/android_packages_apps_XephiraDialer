package com.heytap.accessory.bean;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import n5.C1371a;

/* loaded from: classes3.dex */
public class FlowControlConfig {
    private static final int DEFAULT_MAX_WINDOW_SIZE = 3000000;
    private static final String KEY_CHANNEL_TYPE = "key_ban_channel_type";
    private static final String KEY_MAX_WINDOW_SIZE = "key_max_window_size";
    private static final String KEY_SYMBOL = "key_symbol";
    private static final String KEY_TC_DELAY_TIME = "key_tc_delay_time";
    private static final String KEY_TC_STRATEGY = "key_tc_strategy";
    private static final String KEY_TC_SWITCH = "key_tc_switch";
    private static final String KEY_TRANSPORT_TYPE = "key_ban_transport_type";
    public static final int STRATEGY_AUTO = 0;
    public static final int STRATEGY_NONE = -1;
    public static final int STRATEGY_SEND_ADDITION_SIZE = 2;
    public static final int STRATEGY_SEND_ADDITION_SIZE_LAZY = 1;
    private static final String TAG = "[TCTrack]FlowControlConfig";
    private static final String VALUE_SYMBOL = "FlowControlConfig";
    private final Map<Integer, Boolean> mChannelTypeEnableMap;
    private final boolean mEnable;
    private final int mHandleMsgTime;
    private int mMaxWindowSize;
    private final int mStrategy;
    private final Map<Integer, Boolean> mTransportTypeEnableMap;

    /* renamed from: com.heytap.accessory.bean.FlowControlConfig$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$heytap$accessory$bean$FlowControlConfig$Strategy;

        static {
            int[] iArr = new int[Strategy.values().length];
            $SwitchMap$com$heytap$accessory$bean$FlowControlConfig$Strategy = iArr;
            try {
                iArr[Strategy.STRATEGY_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$heytap$accessory$bean$FlowControlConfig$Strategy[Strategy.STRATEGY_AUTO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$heytap$accessory$bean$FlowControlConfig$Strategy[Strategy.STRATEGY_SEND_ADDITION_SIZE_LAZY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$heytap$accessory$bean$FlowControlConfig$Strategy[Strategy.STRATEGY_SEND_ADDITION_SIZE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        private boolean mEnable;
        private int mHandleMsgTime;
        private int mStrategy;
        private int mMaxWindowSize = FlowControlConfig.DEFAULT_MAX_WINDOW_SIZE;
        private final Map<Integer, Boolean> mTransportTypeEnableMap = new HashMap();
        private final Map<Integer, Boolean> mChannelTypeEnableMap = new HashMap();

        public Builder() {
            enableStream(true).enableFile(true).enableWifiLan(false).enableWifi(false).enableBt(true).enableBle(true);
        }

        public FlowControlConfig create() {
            return new FlowControlConfig(this.mEnable, this.mMaxWindowSize, this.mStrategy, this.mHandleMsgTime, this.mTransportTypeEnableMap, this.mChannelTypeEnableMap, null);
        }

        public Builder enableBle(boolean z10) {
            this.mTransportTypeEnableMap.put(4, Boolean.valueOf(z10));
            return this;
        }

        public Builder enableBt(boolean z10) {
            this.mTransportTypeEnableMap.put(2, Boolean.valueOf(z10));
            return this;
        }

        public Builder enableChannelType(int i10, boolean z10) {
            this.mChannelTypeEnableMap.put(Integer.valueOf(i10), Boolean.valueOf(z10));
            return this;
        }

        public Builder enableFile(boolean z10) {
            this.mChannelTypeEnableMap.put(0, Boolean.valueOf(z10));
            return this;
        }

        public Builder enableStream(boolean z10) {
            this.mChannelTypeEnableMap.put(2, Boolean.valueOf(z10));
            return this;
        }

        public Builder enableTransport(int i10, boolean z10) {
            this.mTransportTypeEnableMap.put(Integer.valueOf(i10), Boolean.valueOf(z10));
            return this;
        }

        public Builder enableWifi(boolean z10) {
            this.mTransportTypeEnableMap.put(1, Boolean.valueOf(z10));
            return this;
        }

        public Builder enableWifiLan(boolean z10) {
            this.mTransportTypeEnableMap.put(8, Boolean.valueOf(z10));
            return this;
        }

        public Builder setEnable(boolean z10) {
            this.mEnable = z10;
            return this;
        }

        public Builder setHandleMsgTime(int i10) {
            this.mHandleMsgTime = i10;
            if (C1371a.h()) {
                if (this.mHandleMsgTime > 0) {
                    C1371a.d(FlowControlConfig.TAG, "setHandleMsgTime is just for test!");
                }
            } else if (this.mHandleMsgTime > 0) {
                this.mHandleMsgTime = 0;
                C1371a.g(FlowControlConfig.TAG, "setHandleMsgTime is a method just for test. reset to 0");
            }
            return this;
        }

        public Builder setMaxWindowSize(int i10) {
            this.mMaxWindowSize = i10;
            return this;
        }

        public Builder setStrategy(Strategy strategy) {
            int i10 = AnonymousClass1.$SwitchMap$com$heytap$accessory$bean$FlowControlConfig$Strategy[strategy.ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            C1371a.k(FlowControlConfig.TAG, "set FlowControlStrategy failed, unknown strategy:" + strategy);
                        } else {
                            this.mStrategy = 2;
                        }
                    } else {
                        this.mStrategy = 1;
                    }
                } else {
                    this.mStrategy = 0;
                }
            } else {
                this.mStrategy = -1;
            }
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public enum Strategy {
        STRATEGY_NONE,
        STRATEGY_AUTO,
        STRATEGY_SEND_ADDITION_SIZE_LAZY,
        STRATEGY_SEND_ADDITION_SIZE
    }

    public /* synthetic */ FlowControlConfig(boolean z10, int i10, int i11, int i12, Map map, Map map2, AnonymousClass1 anonymousClass1) {
        this(z10, i10, i11, i12, map, map2);
    }

    public static FlowControlConfig createFromBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return new FlowControlConfig(bundle.getBoolean(KEY_TC_SWITCH), bundle.getInt(KEY_MAX_WINDOW_SIZE), bundle.getInt(KEY_TC_STRATEGY), bundle.getInt(KEY_TC_DELAY_TIME), toTransportEnableMap(bundle.getIntegerArrayList(KEY_TRANSPORT_TYPE)), toChannelEnableMap(bundle.getIntegerArrayList(KEY_CHANNEL_TYPE)));
    }

    public static boolean isFlowControlConfig(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return VALUE_SYMBOL.equals(bundle.get(KEY_SYMBOL));
    }

    private static Map<Integer, Boolean> toChannelEnableMap(List<Integer> list) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        hashMap.put(0, Boolean.valueOf(!list.contains(0)));
        hashMap.put(2, Boolean.valueOf(!list.contains(2)));
        return hashMap;
    }

    private ArrayList<Integer> toDisableList(Map<Integer, Boolean> map) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Integer num : map.keySet()) {
            if (num != null && Boolean.FALSE.equals(map.get(num))) {
                arrayList.add(num);
            }
        }
        return arrayList;
    }

    private static Map<Integer, Boolean> toTransportEnableMap(List<Integer> list) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        hashMap.put(1, Boolean.valueOf(!list.contains(1)));
        hashMap.put(8, Boolean.valueOf(!list.contains(8)));
        hashMap.put(4, Boolean.valueOf(!list.contains(4)));
        hashMap.put(2, Boolean.valueOf(!list.contains(2)));
        return hashMap;
    }

    public Bundle getBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_SYMBOL, VALUE_SYMBOL);
        bundle.putInt(KEY_TC_DELAY_TIME, this.mHandleMsgTime);
        bundle.putBoolean(KEY_TC_SWITCH, this.mEnable);
        bundle.putInt(KEY_TC_STRATEGY, this.mStrategy);
        bundle.putInt(KEY_MAX_WINDOW_SIZE, this.mMaxWindowSize);
        bundle.putIntegerArrayList(KEY_TRANSPORT_TYPE, toDisableList(this.mTransportTypeEnableMap));
        bundle.putIntegerArrayList(KEY_CHANNEL_TYPE, toDisableList(this.mChannelTypeEnableMap));
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

    public boolean isChannelTypeEnable(int i10) {
        Boolean bool = this.mChannelTypeEnableMap.get(Integer.valueOf(i10));
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public boolean isTransportTypeEnable(int i10) {
        Boolean bool = this.mTransportTypeEnableMap.get(Integer.valueOf(i10));
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public String toString() {
        return "TrafficControlConfig{mHandleMsgTime=" + this.mHandleMsgTime + ", mEnable=" + this.mEnable + ", mStrategy=" + this.mStrategy + ", mMaxWindowSize=" + this.mMaxWindowSize + ", TransportEnable=" + this.mTransportTypeEnableMap + ", ChannelEnable=" + this.mChannelTypeEnableMap + '}';
    }

    private FlowControlConfig(boolean z10, int i10, int i11, int i12, Map<Integer, Boolean> map, Map<Integer, Boolean> map2) {
        this.mEnable = z10;
        this.mMaxWindowSize = i10;
        this.mStrategy = i11;
        this.mHandleMsgTime = i12;
        this.mTransportTypeEnableMap = map;
        this.mChannelTypeEnableMap = map2;
    }
}
