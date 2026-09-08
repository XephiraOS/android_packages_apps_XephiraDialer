package com.coui.appcompat.poplist;

import android.view.MotionEvent;
import android.view.View;
import com.coui.appcompat.AccessibilityUtils.COUIAccessibilityUtil;

/* loaded from: classes.dex */
public class PreciseClickHelper {
    private OnPreciseClickListener mOnPreciseClickListener;
    private View mTarget;
    private float[] mLastTouchDownXY = new float[2];
    private View.OnTouchListener mOnTouchListener = new View.OnTouchListener() { // from class: com.coui.appcompat.poplist.PreciseClickHelper.1
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() == 0) {
                PreciseClickHelper.this.mLastTouchDownXY[0] = motionEvent.getX();
                PreciseClickHelper.this.mLastTouchDownXY[1] = motionEvent.getY();
            }
            return false;
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.coui.appcompat.poplist.PreciseClickHelper.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!COUIAccessibilityUtil.isTalkbackEnabled(view.getContext()) && (PreciseClickHelper.this.mLastTouchDownXY[0] != 0.0f || PreciseClickHelper.this.mLastTouchDownXY[1] != 0.0f)) {
                PreciseClickHelper.this.mOnPreciseClickListener.onClick(view, Math.round(PreciseClickHelper.this.mLastTouchDownXY[0]), Math.round(PreciseClickHelper.this.mLastTouchDownXY[1]));
                return;
            }
            PreciseClickHelper.this.mOnPreciseClickListener.onClick(view, view.getWidth() / 2, view.getHeight() / 2);
        }
    };

    /* loaded from: classes.dex */
    public interface OnPreciseClickListener {
        void onClick(View view, int i10, int i11);
    }

    public PreciseClickHelper(View view, OnPreciseClickListener onPreciseClickListener) {
        this.mTarget = view;
        this.mOnPreciseClickListener = onPreciseClickListener;
    }

    public void setup() {
        this.mTarget.setOnTouchListener(this.mOnTouchListener);
        this.mTarget.setOnClickListener(this.mOnClickListener);
    }

    public void unSet() {
        this.mTarget.setOnClickListener(null);
        this.mTarget.setOnTouchListener(null);
    }
}
