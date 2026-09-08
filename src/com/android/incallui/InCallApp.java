package com.android.incallui;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;

/* loaded from: classes.dex */
public class InCallApp extends Application {
    public static final String ACTION_ACCEPT_VIDEO_UPGRADE_REQUEST = "com.android.incallui.ACTION_ACCEPT_VIDEO_UPGRADE_REQUEST";
    public static final String ACTION_ANSWER_MORE_INCOMING_CALL = "com.android.incallui.ACTION_ANSWER_MORE_INCOMING_CALL";
    public static final String ACTION_ANSWER_VOICE_INCOMING_CALL = "com.android.incallui.ACTION_ANSWER_VOICE_INCOMING_CALL";
    public static final String ACTION_DECLINE_INCOMING_CALL = "com.android.incallui.ACTION_DECLINE_INCOMING_CALL";
    public static final String ACTION_DECLINE_VIDEO_UPGRADE_REQUEST = "com.android.incallui.ACTION_DECLINE_VIDEO_UPGRADE_REQUEST";
    public static final String ACTION_HANG_UP_ONGOING_CALL = "com.android.incallui.ACTION_HANG_UP_ONGOING_CALL";

    /* loaded from: classes.dex */
    public static class NotificationBroadcastReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (Log.sDebug) {
                Log.i(this, "Broadcast from Notification: " + action);
            }
            if (action.equals(InCallApp.ACTION_ANSWER_MORE_INCOMING_CALL)) {
                InCallPresenter.getInstance().bringToForeground(false);
                return;
            }
            if (action.equals(InCallApp.ACTION_ANSWER_VOICE_INCOMING_CALL)) {
                InCallPresenter.getInstance().answerIncomingCall(context, 0);
                return;
            }
            if (action.equals(InCallApp.ACTION_DECLINE_INCOMING_CALL)) {
                InCallPresenter.getInstance().declineIncomingCall(context);
                return;
            }
            if (action.equals(InCallApp.ACTION_HANG_UP_ONGOING_CALL)) {
                InCallPresenter.getInstance().hangUpOngoingCall(context);
            } else if (action.equals(InCallApp.ACTION_ACCEPT_VIDEO_UPGRADE_REQUEST)) {
                InCallPresenter.getInstance().acceptUpgradeRequest(3, context);
            } else if (action.equals(InCallApp.ACTION_DECLINE_VIDEO_UPGRADE_REQUEST)) {
                InCallPresenter.getInstance().declineUpgradeRequest(context);
            }
        }
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
    }
}
