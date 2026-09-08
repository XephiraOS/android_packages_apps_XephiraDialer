package com.coui.appcompat.reddot;

/* loaded from: classes.dex */
public class COUIHintRedDotMemento {
    private int mPointMode;
    private int mPointNumber;
    private String mPointText;

    public void applyTo(COUIHintRedDot cOUIHintRedDot) {
        cOUIHintRedDot.setPointMode(this.mPointMode);
        cOUIHintRedDot.setPointNumber(this.mPointNumber);
        cOUIHintRedDot.setPointText(this.mPointText);
    }

    public int getPointMode() {
        return this.mPointMode;
    }

    public int getPointNumber() {
        return this.mPointNumber;
    }

    public String getPointText() {
        return this.mPointText;
    }

    public void setPointMode(int i10) {
        this.mPointMode = i10;
    }

    public void setPointNumber(int i10) {
        this.mPointNumber = i10;
    }

    public void setPointText(String str) {
        this.mPointText = str;
    }
}
