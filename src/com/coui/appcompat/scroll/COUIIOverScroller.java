package com.coui.appcompat.scroll;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public interface COUIIOverScroller {
    void abortAnimation();

    boolean computeScrollOffset();

    void fling(int i10, int i11, int i12, int i13);

    void fling(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17);

    void fling(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19);

    int getCOUICurrX();

    int getCOUICurrY();

    int getCOUIFinalX();

    int getCOUIFinalY();

    float getCurrVelocity();

    float getCurrVelocityX();

    float getCurrVelocityY();

    boolean isCOUIFinished();

    boolean isScrollingInDirection(float f10, float f11);

    void notifyHorizontalEdgeReached(int i10, int i11, int i12);

    void notifyVerticalEdgeReached(int i10, int i11, int i12);

    void setCOUIFriction(float f10);

    void setCurrVelocityX(float f10);

    void setCurrVelocityY(float f10);

    void setFinalX(int i10);

    void setFinalY(int i10);

    void setFlingFriction(float f10);

    void setInterpolator(Interpolator interpolator);

    void setIsScrollView(boolean z10);

    boolean springBack(int i10, int i11, int i12, int i13, int i14, int i15);

    void startScroll(int i10, int i11, int i12, int i13);

    void startScroll(int i10, int i11, int i12, int i13, int i14);

    default void setDurationRatio(float f10) {
    }

    default void setVelocityXRatio(float f10) {
    }

    default void setVelocityYRatio(float f10) {
    }
}
