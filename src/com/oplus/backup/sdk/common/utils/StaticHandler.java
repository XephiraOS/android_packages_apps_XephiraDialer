package com.oplus.backup.sdk.common.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public abstract class StaticHandler<T> extends Handler {
    private static final String TAG = "StaticHandler";
    protected WeakReference<T> ref;

    public StaticHandler(T t10) {
        this.ref = new WeakReference<>(t10);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        T t10 = this.ref.get();
        if (t10 == null) {
            BRLog.w(TAG, "ref.get is null.");
        } else {
            handleMessage(message, t10);
            super.handleMessage(message);
        }
    }

    public abstract void handleMessage(Message message, T t10);

    public StaticHandler(T t10, Looper looper) {
        super(looper);
        this.ref = new WeakReference<>(t10);
    }
}
