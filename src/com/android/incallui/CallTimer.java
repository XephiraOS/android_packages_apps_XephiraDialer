package com.android.incallui;

import android.os.Handler;
import android.os.SystemClock;

/* loaded from: classes.dex */
public class CallTimer extends Handler {
    private Runnable mCallback;
    private Runnable mInternalCallback;
    private long mInterval;
    private long mLastReportedTime;
    private boolean mRunning;

    /* loaded from: classes.dex */
    public class CallTimerCallback implements Runnable {
        private CallTimerCallback() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CallTimer.this.periodicUpdateTimer();
        }
    }

    public CallTimer(Runnable runnable) {
        com.google.common.base.k.o(runnable);
        this.mInterval = 0L;
        this.mLastReportedTime = 0L;
        this.mRunning = false;
        this.mCallback = runnable;
        this.mInternalCallback = new CallTimerCallback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void periodicUpdateTimer() {
        if (!this.mRunning) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        long j10 = this.mLastReportedTime;
        long j11 = this.mInterval;
        while (true) {
            j10 += j11;
            if (uptimeMillis >= j10) {
                j11 = this.mInterval;
            } else {
                postAtTime(this.mInternalCallback, j10);
                this.mLastReportedTime = j10;
                this.mCallback.run();
                return;
            }
        }
    }

    public void cancel() {
        removeCallbacks(this.mInternalCallback);
        this.mRunning = false;
    }

    public boolean start(long j10) {
        if (j10 <= 0) {
            return false;
        }
        cancel();
        this.mInterval = j10;
        this.mLastReportedTime = SystemClock.uptimeMillis();
        this.mRunning = true;
        periodicUpdateTimer();
        return true;
    }
}
