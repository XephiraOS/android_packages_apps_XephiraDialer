package com.coui.appcompat.state;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.pressfeedback.COUIPressFeedbackHelper;

/* loaded from: classes.dex */
public class COUIStateEffectDrawable extends LayerDrawable implements IStateEffect {
    private static final String TAG = "StateEffectDrawable";
    private boolean mEnableScaleEffect;
    private boolean mEnabled;
    private COUIPressFeedbackHelper mScaleHelper;

    public COUIStateEffectDrawable(Drawable[] drawableArr) {
        super(drawableArr);
        this.mEnabled = true;
        this.mEnableScaleEffect = false;
    }

    public void disableScaleEffect() {
        this.mEnableScaleEffect = false;
        COUIPressFeedbackHelper cOUIPressFeedbackHelper = this.mScaleHelper;
        if (cOUIPressFeedbackHelper != null) {
            cOUIPressFeedbackHelper.setTargetView(null);
        }
    }

    public void enableScaleEffect(View view) {
        enableScaleEffect(view, 0);
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z10;
        int length = iArr.length;
        int i10 = 0;
        while (true) {
            if (i10 < length) {
                if (iArr[i10] == 16842910) {
                    z10 = true;
                    break;
                }
                i10++;
            } else {
                z10 = false;
                break;
            }
        }
        if (z10 != this.mEnabled) {
            this.mEnabled = z10;
            if (!z10) {
                COUIPressFeedbackHelper cOUIPressFeedbackHelper = this.mScaleHelper;
                if (cOUIPressFeedbackHelper != null) {
                    cOUIPressFeedbackHelper.executeFeedbackAnimator(false);
                }
                reset();
            }
        }
        return super.onStateChange(iArr);
    }

    @Override // com.coui.appcompat.state.IStateEffect
    public void refresh(Context context) {
        for (int i10 = 0; i10 < getNumberOfLayers(); i10++) {
            Object drawable = getDrawable(i10);
            if (drawable instanceof IStateEffect) {
                ((IStateEffect) drawable).refresh(context);
            }
        }
    }

    @Override // com.coui.appcompat.state.IStateEffect
    public void reset() {
        for (int i10 = 0; i10 < getNumberOfLayers(); i10++) {
            Object drawable = getDrawable(i10);
            if (drawable instanceof IStateEffect) {
                ((IStateEffect) drawable).reset();
            }
        }
    }

    @Override // com.coui.appcompat.state.IStateEffect
    public void setAnimateEnabled(boolean z10) {
        for (int i10 = 0; i10 < getNumberOfLayers(); i10++) {
            Object drawable = getDrawable(i10);
            if (drawable instanceof IStateEffect) {
                ((IStateEffect) drawable).setAnimateEnabled(z10);
            }
        }
    }

    public void setFocused(boolean z10) {
        for (int i10 = 0; i10 < getNumberOfLayers(); i10++) {
            Object drawable = getDrawable(i10);
            if (drawable instanceof DrawableStateProxy) {
                if (z10) {
                    ((DrawableStateProxy) drawable).setFocusEntered();
                } else {
                    ((DrawableStateProxy) drawable).setFocusExited();
                }
            }
        }
    }

    public void setHovered(boolean z10) {
        for (int i10 = 0; i10 < getNumberOfLayers(); i10++) {
            Object drawable = getDrawable(i10);
            if (drawable instanceof DrawableStateProxy) {
                if (z10) {
                    ((DrawableStateProxy) drawable).setHoverEntered();
                } else {
                    ((DrawableStateProxy) drawable).setHoverExited();
                }
            }
        }
    }

    public void setStateLocked(int i10, boolean z10, boolean z11, boolean z12) {
        for (int i11 = 0; i11 < getNumberOfLayers(); i11++) {
            Object drawable = getDrawable(i11);
            if (drawable instanceof DrawableStateProxy) {
                ((DrawableStateProxy) drawable).setStateLocked(i10, z10, z11, z12);
            }
        }
    }

    public void setTouchSelected(boolean z10) {
        for (int i10 = 0; i10 < getNumberOfLayers(); i10++) {
            Object drawable = getDrawable(i10);
            if (drawable instanceof DrawableStateProxy) {
                if (z10) {
                    ((DrawableStateProxy) drawable).setTouchSelectEntered();
                } else {
                    ((DrawableStateProxy) drawable).setTouchSelectExited();
                }
            }
        }
    }

    public void setTouched(boolean z10) {
        COUIPressFeedbackHelper cOUIPressFeedbackHelper;
        for (int i10 = 0; i10 < getNumberOfLayers(); i10++) {
            Object drawable = getDrawable(i10);
            if (drawable instanceof DrawableStateProxy) {
                if (z10) {
                    ((DrawableStateProxy) drawable).setTouchEntered();
                } else {
                    ((DrawableStateProxy) drawable).setTouchExited();
                }
            }
        }
        if (this.mEnabled && this.mEnableScaleEffect && (cOUIPressFeedbackHelper = this.mScaleHelper) != null) {
            cOUIPressFeedbackHelper.executeFeedbackAnimator(z10);
        }
    }

    public void setViewBackground(Drawable drawable) {
        if (drawable == this) {
            COUILog.e(TAG, "Set view background failed! Should not set LayerDrawable itself as its child recusively!");
        } else {
            setDrawableByLayerId(getId(0), drawable);
        }
    }

    public void enableScaleEffect(View view, int i10) {
        this.mEnableScaleEffect = true;
        COUIPressFeedbackHelper cOUIPressFeedbackHelper = this.mScaleHelper;
        if (cOUIPressFeedbackHelper == null) {
            this.mScaleHelper = new COUIPressFeedbackHelper(view, i10);
        } else {
            cOUIPressFeedbackHelper.setTargetView(view);
            this.mScaleHelper.setViewType(i10);
        }
    }
}
