package com.coui.appcompat.stepper;

import java.util.Observable;

/* loaded from: classes.dex */
public class ObservableStep extends Observable {
    public static final int MAX_VALUE = 9999;
    public static final int MIN_VALUE = -999;
    private int mMax = MAX_VALUE;
    private int mMini = MIN_VALUE;
    private int mStep;

    public int getMaximum() {
        return this.mMax;
    }

    public int getMinimum() {
        return this.mMini;
    }

    public int getStep() {
        return this.mStep;
    }

    public void setMaximum(int i10) {
        if (i10 >= this.mMini) {
            if (i10 <= 9999) {
                this.mMax = i10;
                if (this.mStep > i10) {
                    setStep(i10);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("maximum cannot be bigger than '9999'");
        }
        throw new IllegalArgumentException("maximum cannot be smaller than mMini");
    }

    public void setMinimum(int i10) {
        if (i10 <= this.mMax) {
            if (i10 >= -999) {
                this.mMini = i10;
                if (this.mStep < i10) {
                    setStep(i10);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("minimum cannot be smaller than '-999'");
        }
        throw new IllegalArgumentException("minimum cannot be bigger than mMini");
    }

    public void setStep(int i10) {
        int min = Math.min(Math.max(i10, getMinimum()), getMaximum());
        int i11 = this.mStep;
        this.mStep = min;
        setChanged();
        notifyObservers(Integer.valueOf(i11));
    }
}
