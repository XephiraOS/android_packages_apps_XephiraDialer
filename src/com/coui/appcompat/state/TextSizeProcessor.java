package com.coui.appcompat.state;

import android.util.SparseArray;
import android.widget.TextView;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes.dex */
public class TextSizeProcessor extends Processor<Float, TextView> {
    public static final int KEY_SIZE_UNIT = 2;
    public static final int KEY_TEXT_SIZE = 1;

    /* loaded from: classes.dex */
    public static class Builder {
        SparseArray<Float> mSparseArray = new SparseArray<>();
        int mState;
        TextView mView;

        public Builder(int i10) {
            this.mState = i10;
        }

        public TextSizeProcessor create() {
            return new TextSizeProcessor(this.mView, this.mState, this.mSparseArray);
        }

        public Builder setSizeType(float f10) {
            this.mSparseArray.put(2, Float.valueOf(f10));
            return this;
        }

        public Builder setTextSize(float f10) {
            this.mSparseArray.put(1, Float.valueOf(f10));
            return this;
        }

        public Builder with(TextView textView) {
            this.mView = textView;
            return this;
        }
    }

    @Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface TypedValue {
        public static final float DP = 1.0f;
        public static final float PX = 2.0f;
        public static final float SP = 0.0f;
    }

    private int getTypedValueByKeySizeUnit(float f10) {
        if (f10 == 1.0f) {
            return 1;
        }
        if (f10 == 2.0f) {
            return 0;
        }
        return 2;
    }

    private TextSizeProcessor(TextView textView, int i10, SparseArray<Float> sparseArray) {
        super(textView, i10, sparseArray);
    }

    @Override // com.coui.appcompat.state.Processor
    public void onProcess(TextView textView, int i10, SparseArray<Float> sparseArray) {
        int typedValueByKeySizeUnit = sparseArray.get(2) != null ? getTypedValueByKeySizeUnit(sparseArray.get(2).floatValue()) : 2;
        if (sparseArray.get(1) != null) {
            textView.setTextSize(typedValueByKeySizeUnit, sparseArray.get(1).floatValue());
        }
    }
}
