package com.android.incallui.oplus.share;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.telephony.TelephonyManager;
import androidx.core.content.b;
import com.android.incallui.Log;
import com.android.incallui.OplusFeatureOption;
import com.android.incallui.StatusBarNotifier;
import com.android.incallui.oplus.share.OplusInCallUIReceiver;
import i2.c;

/* loaded from: classes.dex */
public class OplusInCallUIReceiver extends BroadcastReceiver {
    public static /* synthetic */ void b() {
        Process.killProcess(Process.myPid());
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.d("OplusInCallUIReceiver", "onReceive--------------action = " + action);
        if ("android.media.ACTION_AUDIO_RECORD_START".equals(action)) {
            if (OplusFeatureOption.OPLUS_VERSION_EXP && !c.c(context)) {
                int intExtra = intent.getIntExtra("android.media.EXTRA_RECORD_ACTION_PID", -1);
                if (b.a(context, "android.permission.READ_PHONE_STATE") != 0) {
                    android.util.Log.d("OplusInCallUIReceiver", "NO READ_PHONE_STATE, return");
                    return;
                }
                int callState = ((TelephonyManager) context.getSystemService("phone")).getCallState();
                Log.d("OplusInCallUIReceiver", "onReceive--------------pid = " + intExtra + " callState = " + callState);
                if (intExtra != -1 && callState == 2) {
                    c.d(context);
                    return;
                }
                return;
            }
            return;
        }
        if ("android.intent.action.USER_BACKGROUND".equals(action)) {
            StatusBarNotifier.clearAllInCallNotification(context);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: A2.m
                @Override // java.lang.Runnable
                public final void run() {
                    OplusInCallUIReceiver.b();
                }
            }, 300L);
        }
    }
}
