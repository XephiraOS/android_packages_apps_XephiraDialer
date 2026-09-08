package com.android.incallui;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import com.android.incallui.widget.multiwaveview.GlowPadView;

/* loaded from: classes.dex */
public class GlowPadWrapper extends GlowPadView implements GlowPadView.OnTriggerListener {
    private static final boolean ENABLE_PING_AUTO_REPEAT = true;
    private static final int PING_MESSAGE_WHAT = 101;
    private static final long PING_REPEAT_DELAY_MS = 1200;
    private boolean mPingEnabled;
    private final Handler mPingHandler;
    private boolean mTargetTriggered;
    private int mVideoState;

    public GlowPadWrapper(Context context) {
        super(context);
        this.mPingHandler = new Handler() { // from class: com.android.incallui.GlowPadWrapper.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 101) {
                    GlowPadWrapper.this.triggerPing();
                }
            }
        };
        this.mPingEnabled = true;
        this.mTargetTriggered = false;
        this.mVideoState = 3;
        Log.d(this, "class created " + this + " ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void triggerPing() {
        Log.d(this, "triggerPing(): " + this.mPingEnabled + " " + this);
        if (this.mPingEnabled && !this.mPingHandler.hasMessages(101)) {
            ping();
            this.mPingHandler.sendEmptyMessageDelayed(101, PING_REPEAT_DELAY_MS);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Log.d(this, "onFinishInflate()");
        super.onFinishInflate();
        setOnTriggerListener(this);
    }

    @Override // com.android.incallui.widget.multiwaveview.GlowPadView.OnTriggerListener
    public void onGrabbed(View view, int i10) {
        Log.d(this, "onGrabbed()");
        stopPing();
    }

    @Override // com.android.incallui.widget.multiwaveview.GlowPadView.OnTriggerListener
    public void onReleased(View view, int i10) {
        Log.d(this, "onReleased()");
        if (this.mTargetTriggered) {
            this.mTargetTriggered = false;
        } else {
            startPing();
        }
    }

    @Override // com.android.incallui.widget.multiwaveview.GlowPadView.OnTriggerListener
    public void onTrigger(View view, int i10) {
        Log.d(this, "onTrigger() view=" + view + " target=" + i10);
        int resourceIdForTarget = getResourceIdForTarget(i10);
        if (resourceIdForTarget == R.drawable.ic_lockscreen_answer) {
            this.mTargetTriggered = true;
            return;
        }
        if (resourceIdForTarget == R.drawable.ic_lockscreen_decline) {
            this.mTargetTriggered = true;
            return;
        }
        if (resourceIdForTarget == R.drawable.ic_lockscreen_text) {
            this.mTargetTriggered = true;
            return;
        }
        if (resourceIdForTarget != R.drawable.ic_videocam && resourceIdForTarget != R.drawable.ic_lockscreen_answer_video) {
            if (resourceIdForTarget == R.drawable.ic_lockscreen_decline_video) {
                this.mTargetTriggered = true;
                return;
            }
            if (resourceIdForTarget == R.drawable.qti_ic_lockscreen_answer_tx_video) {
                this.mTargetTriggered = true;
                return;
            }
            if (resourceIdForTarget == R.drawable.qti_ic_lockscreen_answer_rx_video) {
                this.mTargetTriggered = true;
                return;
            } else if (resourceIdForTarget == R.drawable.qti_ic_lockscreen_deflect) {
                this.mTargetTriggered = true;
                return;
            } else {
                Log.e(this, "Trigger detected on unhandled resource. Skipping.");
                return;
            }
        }
        this.mTargetTriggered = true;
    }

    public void startPing() {
        Log.d(this, "startPing");
        this.mPingEnabled = true;
        triggerPing();
    }

    public void stopPing() {
        Log.d(this, "stopPing");
        this.mPingEnabled = false;
        this.mPingHandler.removeMessages(101);
    }

    public GlowPadWrapper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPingHandler = new Handler() { // from class: com.android.incallui.GlowPadWrapper.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 101) {
                    GlowPadWrapper.this.triggerPing();
                }
            }
        };
        this.mPingEnabled = true;
        this.mTargetTriggered = false;
        this.mVideoState = 3;
        Log.d(this, "class created " + this);
    }

    @Override // com.android.incallui.widget.multiwaveview.GlowPadView.OnTriggerListener
    public void onFinishFinalAnimation() {
    }

    @Override // com.android.incallui.widget.multiwaveview.GlowPadView.OnTriggerListener
    public void onGrabbedStateChange(View view, int i10) {
    }
}
