package com.coui.appcompat.seekbar;

/* loaded from: classes.dex */
public class DeformedValueBean {
    private float mHeightBottomDeformedDownValue;
    private float mHeightBottomDeformedUpValue;
    private float mHeightTopDeformedDownValue;
    private float mHeightTopDeformedUpValue;
    private int mProgress;
    private float mScale;
    private float mWidthDeformedValue;

    public DeformedValueBean(float f10, float f11, float f12, float f13, float f14, int i10) {
        this.mHeightBottomDeformedUpValue = f10;
        this.mHeightTopDeformedUpValue = f11;
        this.mWidthDeformedValue = f12;
        this.mHeightBottomDeformedDownValue = f13;
        this.mHeightTopDeformedDownValue = f14;
        this.mProgress = i10;
    }

    public float getHeightBottomDeformedDownValue() {
        return this.mHeightBottomDeformedDownValue;
    }

    public float getHeightBottomDeformedUpValue() {
        return this.mHeightBottomDeformedUpValue;
    }

    public float getHeightTopDeformedDownValue() {
        return this.mHeightTopDeformedDownValue;
    }

    public float getHeightTopDeformedUpValue() {
        return this.mHeightTopDeformedUpValue;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public float getScale() {
        return this.mScale;
    }

    public float getWidthDeformedValue() {
        return this.mWidthDeformedValue;
    }

    public void setHeightBottomDeformedDownValue(float f10) {
        this.mHeightBottomDeformedDownValue = f10;
    }

    public void setHeightBottomDeformedUpValue(float f10) {
        this.mHeightBottomDeformedUpValue = f10;
    }

    public void setHeightTopDeformedDownValue(float f10) {
        this.mHeightTopDeformedDownValue = f10;
    }

    public void setHeightTopDeformedUpValue(float f10) {
        this.mHeightTopDeformedUpValue = f10;
    }

    public void setProgress(int i10) {
        this.mProgress = i10;
    }

    public void setScale(float f10) {
        this.mScale = f10;
    }

    public void setWidthDeformedValue(float f10) {
        this.mWidthDeformedValue = f10;
    }
}
