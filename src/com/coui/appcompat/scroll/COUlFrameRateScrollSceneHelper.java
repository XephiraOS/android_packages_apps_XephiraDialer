package com.coui.appcompat.scroll;

import android.os.Bundle;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.version.COUIVersionUtil;
import com.oplus.dynamicframerate.DynamicFrameRateManager;

/* loaded from: classes.dex */
public class COUlFrameRateScrollSceneHelper {
    public static final int ANIMATION_TYPE_LIST_SCROLL = 10102;
    public static final int FRAME_RATE_MIN_SUB_SDK = 10;
    public static final String TAG = "COUlFrameRateHelper";
    private boolean mFrameRateIsOpening = false;
    private boolean mSupportRateVSdk;

    public COUlFrameRateScrollSceneHelper(boolean z10) {
        enableFrameRate(z10);
    }

    public final void enableFrameRate(boolean z10) {
        if (z10 && COUIVersionUtil.checkOPlusViewSubSDK(34, 10)) {
            int dynamicFrameRateType = DynamicFrameRateManager.getDynamicFrameRateType();
            if (dynamicFrameRateType == 1 || dynamicFrameRateType == 2) {
                this.mSupportRateVSdk = true;
                return;
            }
            return;
        }
        this.mSupportRateVSdk = false;
    }

    public void setFrameRate(boolean z10) {
        int i10;
        if (this.mSupportRateVSdk) {
            if (this.mFrameRateIsOpening != z10) {
                if (z10) {
                    i10 = -1;
                } else {
                    i10 = -2;
                }
                DynamicFrameRateManager.setFrameRate(this, 10102, i10, (Bundle) null);
                COUILog.d(TAG, "setFrameRate isStart:" + z10, new Throwable());
                this.mFrameRateIsOpening = z10;
                return;
            }
            return;
        }
        COUILog.d(TAG, "SetFrameRate not success, mSupportRateVSdk is false");
    }
}
