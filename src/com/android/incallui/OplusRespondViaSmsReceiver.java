package com.android.incallui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/* loaded from: classes.dex */
public class OplusRespondViaSmsReceiver extends BroadcastReceiver {
    private static final String LOG_TAG = "OplusRespondViaSmsReceiver";
    public static final String MESSAGE_SEND_ACTION = "com.android.server.telecom.MESSAGE_SEND";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        int resultCode = getResultCode();
        Log.d(LOG_TAG, "onReceive result " + resultCode + ", action" + action);
        if (resultCode != -1) {
            Toast c10 = A2.b.b().c(R.string.oplus_sms_sent_failed, 1);
            if (c10 != null) {
                c10.show();
                return;
            }
            return;
        }
        OplusPhoneUtils.messageSentToast(context);
    }
}
