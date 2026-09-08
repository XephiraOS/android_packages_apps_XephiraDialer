package com.android.incallui.anim;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.android.incallui.Log;

/* compiled from: BaseInCallUIAnimListener.java */
/* loaded from: classes.dex */
public abstract class a {
    private static final String ANIMATION_NAME = "animation_name:";
    private static final int CHECK_ANIMATION_COMPLETE_DELAY = 100;
    private static final int CHECK_ANIMATION_COMPLETE_MSG = 100;
    private static final String TAG = "InCallUIAnimListener";
    protected Object mAnimation;
    protected long mAnimationDuration;
    private final String mAnimationName;
    private boolean mAnimationRunning;
    private Handler mHandler = new HandlerC0180a(Looper.getMainLooper());

    /* compiled from: BaseInCallUIAnimListener.java */
    /* renamed from: com.android.incallui.anim.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class HandlerC0180a extends Handler {
        public HandlerC0180a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 100) {
                a.this.onAnimationTimeOut();
            }
        }
    }

    public a(String str) {
        this.mAnimationName = str;
    }

    public void LogD(String str) {
        if (Log.sDebug) {
            Log.d(TAG, ANIMATION_NAME + this.mAnimationName + "  " + str);
        }
    }

    public abstract void onAnimationTimeOut();

    public void removeCheckAnimationCompleteMsg() {
        Log.d(TAG, ANIMATION_NAME + this.mAnimationName + " removeCheckAnimationCompleteMsg");
        if (this.mHandler.hasMessages(100)) {
            this.mHandler.removeMessages(100);
        }
    }

    public void sendCheckAnimationCompleteMsg() {
        Log.d(TAG, ANIMATION_NAME + this.mAnimationName + " sendCheckAnimationCompleteMsg" + this.mAnimationDuration);
        long j10 = this.mAnimationDuration;
        if (j10 <= 0) {
            return;
        }
        this.mHandler.sendEmptyMessageDelayed(100, j10 + 100);
    }

    public void setAnimation(Object obj) {
        this.mAnimation = obj;
    }

    public void setAnimationRunning(boolean z10) {
        if (z10 == this.mAnimationRunning) {
            return;
        }
        this.mAnimationRunning = z10;
    }

    public a(String str, Object obj) {
        this.mAnimationName = str;
        this.mAnimation = obj;
    }
}
