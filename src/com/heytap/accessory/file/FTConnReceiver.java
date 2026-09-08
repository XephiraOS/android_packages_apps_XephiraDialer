package com.heytap.accessory.file;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import n5.C1371a;

/* loaded from: classes3.dex */
public class FTConnReceiver extends BroadcastReceiver {
    private String TAG = FTConnReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1371a.c(this.TAG, "onReceive");
        if (intent != null) {
            try {
                if (intent.getAction() != null && FileTransfer.ACTION_AFP_FILE_TRANSFER_REQUESTED.equalsIgnoreCase(intent.getAction())) {
                    C1371a.g(this.TAG, "Intent action is " + intent.getAction());
                    String stringExtra = intent.getStringExtra("agentClass");
                    Log.d(this.TAG, "onReceive: implClass" + stringExtra);
                    FileTransfer z10 = FileTransferManager.g(context).z(stringExtra);
                    if (z10 != null) {
                        z10.informIncomingFTRequest(intent);
                    } else {
                        Log.e(this.TAG, "onReceive:fileTransfer is null");
                    }
                }
            } catch (Exception e10) {
                C1371a.e(this.TAG, "FTConnReceiver receive exception", e10);
            }
        }
    }
}
