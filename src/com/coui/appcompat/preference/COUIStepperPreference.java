package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.preference.l;
import b9.C0532b;
import b9.C0537g;
import b9.k;
import com.coui.appcompat.stepper.COUIStepperView;
import com.coui.appcompat.stepper.IStepper;
import com.coui.appcompat.stepper.ObservableStep;
import com.coui.appcompat.stepper.OnStepChangeListener;

/* loaded from: classes.dex */
public class COUIStepperPreference extends COUIPreference implements IStepper, OnStepChangeListener {
    private COUIStepperView mCOUIStepperView;
    private int mDefaultValue;
    private int mInitialMaximum;
    private int mInitialMinimum;
    private int mInitialValue;
    private OnStepChangeListener mOnStepChangeListener;
    private int mUnit;

    public COUIStepperPreference(Context context) {
        this(context, null);
    }

    public void changePersistence(Boolean bool) {
        if (bool.booleanValue()) {
            setPersistent(true);
            persistInt(this.mInitialValue);
        } else {
            persistInt(this.mDefaultValue);
            setPersistent(false);
        }
    }

    public COUIStepperView getCOUIStepperView() {
        return this.mCOUIStepperView;
    }

    @Override // com.coui.appcompat.stepper.IStepper
    public int getCurStep() {
        return this.mCOUIStepperView.getCurStep();
    }

    @Override // com.coui.appcompat.stepper.IStepper
    public int getMaximum() {
        return this.mCOUIStepperView.getMaximum();
    }

    @Override // com.coui.appcompat.stepper.IStepper
    public int getMinimum() {
        return this.mCOUIStepperView.getMinimum();
    }

    @Override // com.coui.appcompat.stepper.IStepper
    public int getUnit() {
        return this.mCOUIStepperView.getUnit();
    }

    @Override // com.coui.appcompat.stepper.IStepper
    public void minus() {
        this.mCOUIStepperView.minus();
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        COUIStepperView cOUIStepperView = (COUIStepperView) lVar.e(C0537g.f12459H);
        this.mCOUIStepperView = cOUIStepperView;
        if (cOUIStepperView != null) {
            setMaximum(this.mInitialMaximum);
            setMinimum(this.mInitialMinimum);
            setCurStep(this.mInitialValue);
            setUnit(this.mUnit);
            this.mCOUIStepperView.setOnStepChangeListener(this);
        }
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onDetached() {
        super.onDetached();
        COUIStepperView cOUIStepperView = this.mCOUIStepperView;
        if (cOUIStepperView != null) {
            cOUIStepperView.release();
        }
    }

    @Override // androidx.preference.Preference
    public Object onGetDefaultValue(TypedArray typedArray, int i10) {
        return Integer.valueOf(typedArray.getInt(i10, 0));
    }

    @Override // androidx.preference.Preference
    public void onSetInitialValue(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        this.mInitialValue = getPersistedInt(((Integer) obj).intValue());
    }

    @Override // com.coui.appcompat.stepper.OnStepChangeListener
    public void onStepChanged(int i10, int i11) {
        this.mInitialValue = i10;
        persistInt(i10);
        if (i10 != i11) {
            callChangeListener(Integer.valueOf(i10));
        }
        OnStepChangeListener onStepChangeListener = this.mOnStepChangeListener;
        if (onStepChangeListener != null) {
            onStepChangeListener.onStepChanged(i10, i11);
        }
    }

    @Override // com.coui.appcompat.stepper.IStepper
    public void plus() {
        this.mCOUIStepperView.plus();
    }

    @Override // com.coui.appcompat.stepper.IStepper
    public void setCurStep(int i10) {
        this.mCOUIStepperView.setCurStep(i10);
    }

    @Override // com.coui.appcompat.stepper.IStepper
    public void setMaximum(int i10) {
        this.mInitialMaximum = i10;
        this.mCOUIStepperView.setMaximum(i10);
    }

    @Override // com.coui.appcompat.stepper.IStepper
    public void setMinimum(int i10) {
        this.mInitialMinimum = i10;
        this.mCOUIStepperView.setMinimum(i10);
    }

    @Override // com.coui.appcompat.stepper.IStepper
    public void setOnStepChangeListener(OnStepChangeListener onStepChangeListener) {
        this.mOnStepChangeListener = onStepChangeListener;
    }

    @Override // com.coui.appcompat.stepper.IStepper
    public void setUnit(int i10) {
        this.mUnit = i10;
        this.mCOUIStepperView.setUnit(i10);
    }

    public COUIStepperPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0532b.f12357p);
    }

    public COUIStepperPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, k.f12534l);
    }

    public COUIStepperPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b9.l.f12603b1, i10, i11);
        this.mInitialMaximum = obtainStyledAttributes.getInt(b9.l.f12609d1, ObservableStep.MAX_VALUE);
        this.mInitialMinimum = obtainStyledAttributes.getInt(b9.l.f12612e1, ObservableStep.MIN_VALUE);
        int i12 = obtainStyledAttributes.getInt(b9.l.f12606c1, 0);
        this.mInitialValue = i12;
        this.mDefaultValue = i12;
        this.mUnit = obtainStyledAttributes.getInt(b9.l.f12615f1, 1);
        obtainStyledAttributes.recycle();
    }
}
