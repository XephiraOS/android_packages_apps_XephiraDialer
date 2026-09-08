package com.coui.appcompat.state;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class SizeProcessor extends Processor<Object, View> {
    public static final int KEY_HEIGHT = 1;
    public static final int KEY_WEIGHT = 2;
    public static final int KEY_WIDTH = 0;

    /* loaded from: classes.dex */
    public static class Builder {
        SparseArray<Object> mSparseArray = new SparseArray<>();
        int mState;
        View mView;

        public Builder(int i10) {
            this.mState = i10;
        }

        public SizeProcessor create() {
            return new SizeProcessor(this.mView, this.mState, this.mSparseArray);
        }

        public Builder setHeight(int i10) {
            this.mSparseArray.put(1, Integer.valueOf(i10));
            return this;
        }

        public Builder setWeight(float f10) {
            this.mSparseArray.put(2, Float.valueOf(f10));
            return this;
        }

        public Builder setWidth(int i10) {
            this.mSparseArray.put(0, Integer.valueOf(i10));
            return this;
        }

        public Builder with(View view) {
            this.mView = view;
            return this;
        }
    }

    @Override // com.coui.appcompat.state.Processor
    public void onProcess(View view, int i10, SparseArray<Object> sparseArray) {
        if (view != null && view.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (sparseArray.get(0) != null) {
                layoutParams.width = ((Integer) sparseArray.get(0)).intValue();
            }
            if (sparseArray.get(1) != null) {
                layoutParams.height = ((Integer) sparseArray.get(1)).intValue();
            }
            if (sparseArray.get(2) != null && (layoutParams instanceof LinearLayout.LayoutParams)) {
                ((LinearLayout.LayoutParams) layoutParams).weight = ((Float) sparseArray.get(2)).floatValue();
            }
            view.setLayoutParams(layoutParams);
        }
    }

    private SizeProcessor(View view, int i10, SparseArray<Object> sparseArray) {
        super(view, i10, sparseArray);
    }
}
