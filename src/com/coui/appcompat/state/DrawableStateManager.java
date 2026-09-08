package com.coui.appcompat.state;

import android.util.SparseIntArray;
import com.coui.appcompat.log.COUILog;

/* loaded from: classes.dex */
public final class DrawableStateManager implements DrawableStateProxy {
    private final SparseIntArray STATE_MAP;
    private final String TAG;
    private final DrawableStateProxy mCallback;
    private boolean mDrawableEnabled;
    private int mNativeStateDisabledFlag;
    int mStateFlag;
    int mStateLockedFlag;
    private int mTouchType;

    public DrawableStateManager(String str, DrawableStateProxy drawableStateProxy) {
        SparseIntArray sparseIntArray = new SparseIntArray();
        this.STATE_MAP = sparseIntArray;
        this.mTouchType = 0;
        this.mNativeStateDisabledFlag = 0;
        this.mDrawableEnabled = true;
        this.mStateFlag = 0;
        this.mStateLockedFlag = 0;
        this.TAG = str;
        this.mCallback = drawableStateProxy;
        sparseIntArray.put(16842908, 2);
        sparseIntArray.put(16843623, 4);
        sparseIntArray.put(1, 1);
        sparseIntArray.put(16842913, 8);
        sparseIntArray.put(16842919, 16);
        sparseIntArray.put(16842910, 32);
    }

    private void checkOnViewStateChanged(int[] iArr, int i10) {
        int length = iArr.length;
        boolean z10 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                break;
            }
            if (iArr[i11] == i10) {
                z10 = true;
                break;
            }
            i11++;
        }
        if ((z10 && (this.mStateFlag & this.STATE_MAP.get(i10)) == 0) || (!z10 && (this.mStateFlag & this.STATE_MAP.get(i10)) != 0)) {
            notifyStateChanged(i10, z10);
        }
    }

    private String getTouchTypeName() {
        int i10 = this.mTouchType;
        if (i10 != 0) {
            if (i10 != 1) {
                return "Unknown";
            }
            return "selected";
        }
        return "pressed";
    }

    private void notifyStateChanged(int i10, boolean z10) {
        int i11;
        boolean z11 = true;
        if (((this.mStateFlag & this.STATE_MAP.get(i10)) != 0 && z10) || ((this.mStateFlag & this.STATE_MAP.get(i10)) == 0 && !z10)) {
            COUILog.i(this.TAG, "state " + getStateName(i10) + " not changed: " + z10);
            if (i10 != 1) {
                return;
            }
        }
        if ((this.mStateFlag & this.STATE_MAP.get(i10)) == 0) {
            z11 = false;
        }
        int i12 = this.mStateFlag;
        int i13 = this.STATE_MAP.get(i10);
        if (z10) {
            i11 = i12 | i13;
        } else {
            i11 = i12 & (~i13);
        }
        this.mStateFlag = i11;
        onViewStateChanged(i10);
        COUILog.d(this.TAG, "state " + getStateName(i10) + " changed from " + z11 + " to " + z10);
    }

    public String getStateName(int i10) {
        switch (i10) {
            case 1:
                return "touch entered #" + getTouchTypeName();
            case 16842908:
                return "focused";
            case 16842910:
                return "enabled";
            case 16842913:
                return "selected";
            case 16842919:
                return "pressed";
            case 16843623:
                return "hovered";
            default:
                return "Unknown";
        }
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public int getTouchType() {
        return this.mTouchType;
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public boolean isDrawableEnabled() {
        return this.mDrawableEnabled;
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public boolean isEnabled() {
        if ((this.STATE_MAP.get(16842910) & this.mStateFlag) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public boolean isFocused() {
        if ((this.STATE_MAP.get(16842908) & this.mStateFlag) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public boolean isHovered() {
        if ((this.STATE_MAP.get(16843623) & this.mStateFlag) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public boolean isNativeStateEnabled(int i10) {
        if ((this.mNativeStateDisabledFlag & i10) == 0) {
            return true;
        }
        return false;
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public boolean isPressed() {
        if ((this.STATE_MAP.get(16842919) & this.mStateFlag) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public boolean isSelected() {
        if ((this.STATE_MAP.get(16842913) & this.mStateFlag) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public boolean isStateLocked(int i10) {
        if ((this.STATE_MAP.get(i10) & this.mStateLockedFlag) != 0) {
            return true;
        }
        return false;
    }

    public boolean isStateful() {
        return true;
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public boolean isTouchEntered() {
        if ((this.STATE_MAP.get(1) & this.mStateFlag) != 0) {
            return true;
        }
        return false;
    }

    public void onStateChange(int[] iArr) {
        if (isNativeStateEnabled(32)) {
            checkOnViewStateChanged(iArr, 16842910);
        }
        if (isNativeStateEnabled(2)) {
            checkOnViewStateChanged(iArr, 16842908);
        }
        if (isNativeStateEnabled(4)) {
            checkOnViewStateChanged(iArr, 16843623);
        }
        if (isNativeStateEnabled(8)) {
            checkOnViewStateChanged(iArr, 16842913);
        }
        if (isNativeStateEnabled(16)) {
            checkOnViewStateChanged(iArr, 16842919);
        }
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public void onViewStateChanged(int i10) {
        this.mCallback.onViewStateChanged(i10);
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public void setDrawableEnabled(boolean z10) {
        this.mDrawableEnabled = z10;
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public void setFocusEntered() {
        notifyStateChanged(16842908, true);
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public void setFocusExited() {
        notifyStateChanged(16842908, false);
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public void setHoverEntered() {
        notifyStateChanged(16843623, true);
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public void setHoverExited() {
        notifyStateChanged(16843623, false);
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public void setNativeStateEnabled(int i10, boolean z10) {
        if (i10 != 2 && i10 != 4 && i10 != 8 && i10 != 16 && i10 != 32) {
            COUILog.e(this.TAG, "wrong state flag");
        } else if (z10) {
            this.mNativeStateDisabledFlag = i10 | this.mNativeStateDisabledFlag;
        } else {
            this.mNativeStateDisabledFlag = (~i10) & this.mNativeStateDisabledFlag;
        }
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public void setSelectedEntered() {
        notifyStateChanged(16842913, true);
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public void setSelectedExited() {
        notifyStateChanged(16842913, false);
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public void setStateLocked(int i10, boolean z10, boolean z11, boolean z12) {
        if (z10) {
            this.mStateLockedFlag = this.STATE_MAP.get(i10) | this.mStateLockedFlag;
        } else {
            this.mStateLockedFlag = (~this.STATE_MAP.get(i10)) & this.mStateLockedFlag;
        }
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public void setTouchEntered() {
        this.mTouchType = 0;
        notifyStateChanged(1, true);
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public void setTouchExited() {
        this.mTouchType = 0;
        notifyStateChanged(1, false);
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public void setTouchSelectEntered() {
        this.mTouchType = 1;
        notifyStateChanged(1, true);
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public void setTouchSelectExited() {
        this.mTouchType = 1;
        notifyStateChanged(1, false);
    }
}
