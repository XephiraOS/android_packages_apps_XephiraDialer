package com.coui.appcompat.state;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class MarginProcessor extends Processor<Integer, View> {
    public static final int KEY_BOTTOM_MARGIN = 2;
    public static final int KEY_END_MARGIN = 3;
    public static final int KEY_START_MARGIN = 1;
    public static final int KEY_TOP_MARGIN = 0;

    /* loaded from: classes.dex */
    public static class Builder {
        SparseArray<Integer> mSparseArray = new SparseArray<>();
        int mState;
        View mView;

        public Builder(int i10) {
            this.mState = i10;
        }

        public MarginProcessor create() {
            return new MarginProcessor(this.mView, this.mState, this.mSparseArray);
        }

        public Builder setMarginBottom(int i10) {
            this.mSparseArray.put(2, Integer.valueOf(i10));
            return this;
        }

        public Builder setMarginEnd(int i10) {
            this.mSparseArray.put(3, Integer.valueOf(i10));
            return this;
        }

        public Builder setMarginStart(int i10) {
            this.mSparseArray.put(1, Integer.valueOf(i10));
            return this;
        }

        public Builder setMarginTop(int i10) {
            this.mSparseArray.put(0, Integer.valueOf(i10));
            return this;
        }

        public Builder with(View view) {
            this.mView = view;
            return this;
        }
    }

    @Override // com.coui.appcompat.state.Processor
    public void onProcess(View view, int i10, SparseArray<Integer> sparseArray) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (sparseArray.get(1) != null) {
            marginLayoutParams.setMarginStart(sparseArray.get(1).intValue());
        }
        if (sparseArray.get(3) != null) {
            marginLayoutParams.setMarginEnd(sparseArray.get(3).intValue());
        }
        if (sparseArray.get(0) != null) {
            marginLayoutParams.topMargin = sparseArray.get(0).intValue();
        }
        if (sparseArray.get(2) != null) {
            marginLayoutParams.bottomMargin = sparseArray.get(2).intValue();
        }
        view.setLayoutParams(marginLayoutParams);
    }

    @Override // com.coui.appcompat.state.Processor
    public void process(View view) {
        if (view != null && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            super.process(view);
            return;
        }
        throw new IllegalArgumentException("mView == null, or layoutParams is wrong");
    }

    private MarginProcessor(View view, int i10, SparseArray<Integer> sparseArray) {
        super(view, i10, sparseArray);
    }
}
