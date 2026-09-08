package com.android.incallui;

import android.os.Bundle;
import android.telecom.Call;
import com.android.incallui.InCallPresenter;

/* loaded from: classes.dex */
public class OrientationModeHandler implements InCallPresenter.InCallDetailsListener, InCallPresenter.InCallUiListener {
    private static OrientationModeHandler sOrientationModeHandler;
    private int mOrientationMode = -1;
    private PrimaryCallTracker mPrimaryCallTracker;

    private OrientationModeHandler() {
    }

    public static synchronized OrientationModeHandler getInstance() {
        OrientationModeHandler orientationModeHandler;
        synchronized (OrientationModeHandler.class) {
            try {
                if (sOrientationModeHandler == null) {
                    sOrientationModeHandler = new OrientationModeHandler();
                }
                orientationModeHandler = sOrientationModeHandler;
            } catch (Throwable th) {
                throw th;
            }
        }
        return orientationModeHandler;
    }

    private void mayBeUpdateOrientationMode(Call call, Call.Details details) {
        Bundle bundle;
        int i10;
        if (call != null && details != null) {
            bundle = details.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            i10 = bundle.getInt("OrientationMode", -1);
        } else {
            i10 = -1;
        }
        Log.d(this, "mayBeUpdateOrientationMode : orientationMode: " + i10 + " mOrientationMode : " + this.mOrientationMode);
        if (InCallPresenter.getInstance().getActivity() == null) {
            Log.w(this, "mayBeUpdateOrientationMode : InCallActivity is null");
        } else if (i10 != this.mOrientationMode && i10 != -1) {
            this.mOrientationMode = i10;
            onOrientationModeChanged(call, i10);
        }
    }

    private void onOrientationModeChanged(Call call, int i10) {
        Log.d(this, "onOrientationModeChanged: Call : " + call + " orientation mode = " + i10);
        if (!this.mPrimaryCallTracker.isPrimaryCall(call)) {
            Log.e(this, "Can't set requested orientation on a non-primary call");
        } else {
            InCallPresenter.getInstance().setInCallAllowsOrientationChange(call, QtiCallUtils.toUiOrientationMode(i10));
        }
    }

    public int getCurrentOrientationMode() {
        return this.mOrientationMode;
    }

    public int getOrientation(Call call) {
        if (CallUtils.isVideoCall(call)) {
            int i10 = this.mOrientationMode;
            if (i10 == -1) {
                return 10;
            }
            return QtiCallUtils.toUiOrientationMode(i10);
        }
        return 5;
    }

    @Override // com.android.incallui.InCallPresenter.InCallDetailsListener
    public void onDetailsChanged(Call call, Call.Details details) {
        Log.d(this, "onDetailsChanged: - call: " + call + "details: " + details);
        mayBeUpdateOrientationMode(call, details);
    }

    @Override // com.android.incallui.InCallPresenter.InCallUiListener
    public void onUiShowing(boolean z10) {
        Call primaryCall = this.mPrimaryCallTracker.getPrimaryCall();
        Log.d(this, "onUiShowing showing: " + z10 + " call = " + primaryCall);
        if (z10 && primaryCall != null) {
            mayBeUpdateOrientationMode(primaryCall, primaryCall.getTelecommCall().getDetails());
        }
    }

    public void setUp() {
        this.mPrimaryCallTracker = PrimaryCallTracker.getInstance();
        InCallPresenter.getInstance().addListener(this.mPrimaryCallTracker);
        InCallPresenter.getInstance().addDetailsListener(this);
        InCallPresenter.getInstance().addInCallUiListener(this);
    }

    public void tearDown() {
        InCallPresenter.getInstance().removeListener(this.mPrimaryCallTracker);
        InCallPresenter.getInstance().removeDetailsListener(this);
        InCallPresenter.getInstance().removeInCallUiListener(this);
        this.mOrientationMode = -1;
        this.mPrimaryCallTracker = null;
    }
}
