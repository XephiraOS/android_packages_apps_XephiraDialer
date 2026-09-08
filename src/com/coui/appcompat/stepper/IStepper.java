package com.coui.appcompat.stepper;

/* loaded from: classes.dex */
public interface IStepper {
    int getCurStep();

    int getMaximum();

    int getMinimum();

    int getUnit();

    void minus();

    void plus();

    void setCurStep(int i10);

    void setMaximum(int i10);

    void setMinimum(int i10);

    void setOnStepChangeListener(OnStepChangeListener onStepChangeListener);

    void setUnit(int i10);
}
