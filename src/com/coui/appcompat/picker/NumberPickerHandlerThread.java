package com.coui.appcompat.picker;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;

/* loaded from: classes.dex */
class NumberPickerHandlerThread extends Thread {
    static final int ONE_WAIT_TIME = 10;
    static final int OUT_WAIT_TIME = 1000;
    static final String TAG = "numberThread";
    Handler mHandler;
    Looper mLooper;
    int mPriority;
    int mTid;

    public NumberPickerHandlerThread(String str) {
        super(str);
        this.mTid = -1;
        this.mPriority = 0;
    }

    public Looper getLooper() {
        boolean z10;
        if (!isAlive()) {
            return null;
        }
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis();
            z10 = false;
            while (true) {
                if (!isAlive() || this.mLooper != null) {
                    break;
                }
                if (System.currentTimeMillis() - currentTimeMillis > 1000) {
                    Log.e(TAG, "numberPick Wait for looper timeout");
                    break;
                }
                try {
                    wait(10L);
                } catch (InterruptedException unused) {
                    z10 = true;
                }
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return this.mLooper;
    }

    public Handler getThreadHandler() {
        if (this.mHandler == null && getLooper() != null) {
            this.mHandler = new Handler(getLooper());
        }
        return this.mHandler;
    }

    public int getThreadId() {
        return this.mTid;
    }

    public boolean quit() {
        Looper looper = getLooper();
        if (looper != null) {
            looper.quit();
            return true;
        }
        return false;
    }

    public boolean quitSafely() {
        Looper looper = getLooper();
        if (looper != null) {
            looper.quitSafely();
            return true;
        }
        return false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.mTid = Process.myTid();
        Looper.prepare();
        synchronized (this) {
            this.mLooper = Looper.myLooper();
            notifyAll();
        }
        Process.setThreadPriority(this.mPriority);
        onLooperPrepared();
        Looper.loop();
        this.mTid = -1;
    }

    public NumberPickerHandlerThread(String str, int i10) {
        super(str);
        this.mTid = -1;
        this.mPriority = i10;
    }

    public void onLooperPrepared() {
    }
}
