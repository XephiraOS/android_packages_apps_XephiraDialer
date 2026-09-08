package com.coui.appcompat.state;

import android.util.SparseArray;
import android.view.View;
import androidx.core.view.K;

/* loaded from: classes.dex */
public class PaddingProcessor extends Processor<Integer, View> {
    public static final int KEY_BOTTOM_PADDING = 2;
    public static final int KEY_END_PADDING = 3;
    public static final int KEY_START_PADDING = 1;
    public static final int KEY_TOP_PADDING = 0;

    /* loaded from: classes.dex */
    public static class Builder {
        SparseArray<Integer> mSparseArray = new SparseArray<>();
        int mState;
        View mView;

        public Builder(int i10) {
            this.mState = i10;
        }

        public PaddingProcessor create() {
            return new PaddingProcessor(this.mView, this.mState, this.mSparseArray);
        }

        public Builder setPaddingBottom(int i10) {
            this.mSparseArray.put(2, Integer.valueOf(i10));
            return this;
        }

        public Builder setPaddingEnd(int i10) {
            this.mSparseArray.put(3, Integer.valueOf(i10));
            return this;
        }

        public Builder setPaddingStart(int i10) {
            this.mSparseArray.put(1, Integer.valueOf(i10));
            return this;
        }

        public Builder setPaddingTop(int i10) {
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
        int paddingStart;
        int paddingTop;
        int paddingBottom;
        int paddingEnd;
        if (sparseArray.get(1) != null) {
            paddingStart = sparseArray.get(1).intValue();
        } else {
            paddingStart = view.getPaddingStart();
        }
        if (sparseArray.get(0) != null) {
            paddingTop = sparseArray.get(0).intValue();
        } else {
            paddingTop = view.getPaddingTop();
        }
        if (sparseArray.get(2) != null) {
            paddingBottom = sparseArray.get(2).intValue();
        } else {
            paddingBottom = view.getPaddingBottom();
        }
        if (sparseArray.get(3) != null) {
            paddingEnd = sparseArray.get(3).intValue();
        } else {
            paddingEnd = view.getPaddingEnd();
        }
        K.A0(view, paddingStart, paddingTop, paddingEnd, paddingBottom);
    }

    private PaddingProcessor(View view, int i10, SparseArray<Integer> sparseArray) {
        super(view, i10, sparseArray);
    }
}
