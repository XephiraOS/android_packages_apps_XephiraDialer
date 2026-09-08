package com.heytap.accessory.stream;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import n5.C1371a;

/* loaded from: classes3.dex */
public class StreamConnReceiver extends BroadcastReceiver {
    private String TAG = StreamConnReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1371a.c(this.TAG, "onReceive");
        if (intent != null) {
            try {
                if (intent.getAction() != null && StreamTransfer.ACTION_STREAM_TRANSFER_REQUESTED.equalsIgnoreCase(intent.getAction())) {
                    C1371a.g(this.TAG, "Intent action is " + intent.getAction());
                    try {
                        String stringExtra = intent.getStringExtra("agentClass");
                        C1371a.c(this.TAG, "onReceive: implClass" + stringExtra);
                        StreamTransfer w10 = a.w(stringExtra);
                        if (w10 != null) {
                            w10.informIncomingSTRequest(context, intent);
                        } else {
                            C1371a.d(this.TAG, "onReceive:streamTransfer is null");
                        }
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            } catch (Exception e11) {
                C1371a.e(this.TAG, "StreamConnReceiver receive exception", e11);
            }
        }
    }
}
