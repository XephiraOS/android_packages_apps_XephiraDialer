package com.oplus.ocs.icdf;

/* loaded from: classes3.dex */
public enum TrafficClass {
    BEST_EFFORT(0),
    BACKGROUND(32),
    SPARE(64),
    EXCELLENT_EFFORT(96),
    CONTROLLED_LOAD(128),
    VIDEO(160),
    AUDIO(184),
    VOICE(192),
    NETWORK_CONTROL(224);

    private final int value;

    TrafficClass(int i10) {
        this.value = i10;
    }

    public int getValue() {
        return this.value;
    }
}
