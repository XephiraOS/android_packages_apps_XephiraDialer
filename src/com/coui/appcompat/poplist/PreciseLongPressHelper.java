package com.coui.appcompat.poplist;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public class PreciseLongPressHelper {
    private OnPreciseLongClickListener mOnPreciseLongClickListener;
    private View mTarget;
    private View.OnTouchListener mTouchListenerTransfer;
    private float[] mLastTouchDownXY = new float[2];
    private View.OnTouchListener mOnTouchListener = new View.OnTouchListener() { // from class: com.coui.appcompat.poplist.PreciseLongPressHelper.1
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (PreciseLongPressHelper.this.mTouchListenerTransfer != null) {
                PreciseLongPressHelper.this.mTouchListenerTransfer.onTouch(view, motionEvent);
            }
            if (motionEvent.getActionMasked() == 0) {
                PreciseLongPressHelper.this.mLastTouchDownXY[0] = motionEvent.getX();
                PreciseLongPressHelper.this.mLastTouchDownXY[1] = motionEvent.getY();
            }
            return false;
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.coui.appcompat.poplist.PreciseLongPressHelper.2
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            PreciseLongPressHelper.this.mOnPreciseLongClickListener.onLongClick(view, Math.round(PreciseLongPressHelper.this.mLastTouchDownXY[0]), Math.round(PreciseLongPressHelper.this.mLastTouchDownXY[1]));
            return true;
        }
    };

    /* loaded from: classes.dex */
    public interface OnPreciseLongClickListener {
        void onLongClick(View view, int i10, int i11);
    }

    public PreciseLongPressHelper(View view, OnPreciseLongClickListener onPreciseLongClickListener) {
        this.mTarget = view;
        this.mOnPreciseLongClickListener = onPreciseLongClickListener;
    }

    public void setTouchListenerTransfer(View.OnTouchListener onTouchListener) {
        this.mTouchListenerTransfer = onTouchListener;
    }

    public void setup() {
        this.mTarget.setOnTouchListener(this.mOnTouchListener);
        this.mTarget.setOnLongClickListener(this.mOnLongClickListener);
    }
}
