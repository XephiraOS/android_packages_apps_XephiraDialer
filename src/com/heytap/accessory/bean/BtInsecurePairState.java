package com.heytap.accessory.bean;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public final class BtInsecurePairState {
    private String mMac;
    private PairState mPairState;

    public BtInsecurePairState() {
        this.mPairState = new PairState();
    }

    public String getMac() {
        String str = this.mMac;
        if (str == null) {
            return "";
        }
        return str;
    }

    public boolean isPaired() {
        return this.mPairState.isPaired();
    }

    public void setMac(String str) {
        this.mMac = str;
    }

    public void setPaired(boolean z10) {
        this.mPairState.setPaired(z10);
    }

    public BtInsecurePairState(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mMac = str;
        this.mPairState.setPaired(true);
    }
}
