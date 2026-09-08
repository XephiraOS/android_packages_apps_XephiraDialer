package com.android.incallui;

import android.content.Context;
import android.view.OrientationEventListener;

/* loaded from: classes.dex */
public class InCallOrientationEventListener extends OrientationEventListener {
    private static int ROTATION_THRESHOLD = 10;
    public static final int SCREEN_ORIENTATION_0 = 0;
    public static final int SCREEN_ORIENTATION_180 = 180;
    public static final int SCREEN_ORIENTATION_270 = 270;
    public static final int SCREEN_ORIENTATION_360 = 360;
    public static final int SCREEN_ORIENTATION_90 = 90;
    private static int SCREEN_ORIENTATION_UNKNOWN = -1;
    private static int sCurrentOrientation;
    private boolean mEnabled;

    public InCallOrientationEventListener(Context context) {
        super(context);
        this.mEnabled = false;
    }

    private static boolean isInLeftRange(int i10, int i11, int i12) {
        return isWithinRange(i10, i11 - i12, i11);
    }

    private static boolean isInRightRange(int i10, int i11, int i12) {
        return isWithinRange(i10, i11, i12 + i11);
    }

    private static boolean isWithinRange(int i10, int i11, int i12) {
        if (i10 >= i11 && i10 < i12) {
            return true;
        }
        return false;
    }

    private static boolean isWithinThreshold(int i10, int i11, int i12) {
        return isWithinRange(i10, i11 - i12, i11 + i12);
    }

    private int toScreenOrientation(int i10) {
        if (isInLeftRange(i10, 360, ROTATION_THRESHOLD) || isInRightRange(i10, 0, ROTATION_THRESHOLD)) {
            return 0;
        }
        if (isWithinThreshold(i10, 90, ROTATION_THRESHOLD)) {
            return 270;
        }
        if (isWithinThreshold(i10, 180, ROTATION_THRESHOLD)) {
            return 180;
        }
        if (isWithinThreshold(i10, 270, ROTATION_THRESHOLD)) {
            return 90;
        }
        return SCREEN_ORIENTATION_UNKNOWN;
    }

    @Override // android.view.OrientationEventListener
    public void disable() {
        if (!this.mEnabled) {
            Log.v(this, "enable: Orientation listener is already disabled. Ignoring...");
        } else {
            this.mEnabled = false;
            super.disable();
        }
    }

    public void enable(boolean z10) {
        if (this.mEnabled) {
            Log.v(this, "enable: Orientation listener is already enabled. Ignoring...");
            return;
        }
        super.enable();
        this.mEnabled = true;
        if (z10) {
            InCallPresenter.getInstance().onDeviceOrientationChange(sCurrentOrientation);
        }
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i10) {
        int screenOrientation;
        if (i10 != -1 && (screenOrientation = toScreenOrientation(i10)) != SCREEN_ORIENTATION_UNKNOWN && sCurrentOrientation != screenOrientation) {
            sCurrentOrientation = screenOrientation;
            InCallPresenter.getInstance().onDeviceOrientationChange(sCurrentOrientation);
        }
    }

    @Override // android.view.OrientationEventListener
    public void enable() {
        enable(false);
    }
}
