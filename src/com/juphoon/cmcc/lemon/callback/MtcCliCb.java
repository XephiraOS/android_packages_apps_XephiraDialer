package com.juphoon.cmcc.lemon.callback;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes3.dex */
public class MtcCliCb {

    /* renamed from: a, reason: collision with root package name */
    public static final Handler f25456a = new a(Looper.getMainLooper());

    /* loaded from: classes3.dex */
    public static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            O5.a.a(((Long) message.obj).longValue());
        }
    }

    private static native void destroyCallback();

    private static native void initCallback();
}
