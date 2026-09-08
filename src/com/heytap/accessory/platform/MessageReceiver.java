package com.heytap.accessory.platform;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.heytap.accessory.BaseJobAgent;
import com.heytap.accessory.BaseJobService;
import com.heytap.accessory.BaseMessage;
import com.heytap.accessory.bean.GeneralException;
import com.heytap.accessory.bean.PeerAgent;
import com.heytap.accessory.bean.ServiceProfile;
import com.heytap.accessory.constant.AFConstants;
import n5.C1371a;
import r5.d;
import r5.e;
import r5.h;

/* loaded from: classes3.dex */
public final class MessageReceiver extends BroadcastReceiver {
    private static String TAG = "MessageReceiver";

    private synchronized boolean isValidImplClass(Context context, String str) {
        boolean z10;
        try {
            e c10 = e.c(context);
            if (c10 != null) {
                ServiceProfile b10 = c10.b(str);
                if (b10 != null) {
                    if (str.equalsIgnoreCase(b10.getServiceImpl())) {
                        z10 = true;
                    }
                } else {
                    C1371a.d(TAG, "fetch service profile description failed !!");
                }
            } else {
                C1371a.d(TAG, "config  util default instance  creation failed !!");
            }
            z10 = false;
        } finally {
        }
        return z10;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ComponentName startService;
        if (intent != null && intent.getAction() != null) {
            if (BaseMessage.ACTION_ACCESSORY_MESSAGE_RECEIVED.equalsIgnoreCase(intent.getAction())) {
                C1371a.c(TAG, "Incoming Data Received!!!");
                try {
                    new h(context);
                    try {
                        String stringExtra = intent.getStringExtra(AFConstants.EXTRA_AGENT_IMPL_CLASS);
                        if (stringExtra == null) {
                            C1371a.d(TAG, "Impl class not available in intent. ignoring message received");
                            return;
                        }
                        Class<?> cls = Class.forName(stringExtra);
                        if (!isValidImplClass(context, cls.getName())) {
                            C1371a.k(TAG, "invalid impl class: " + cls.getName());
                            return;
                        }
                        boolean z10 = false;
                        if (context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion >= 26) {
                            z10 = true;
                        }
                        intent.setClassName(context, stringExtra);
                        if (d.a(BaseJobAgent.class, cls) && z10) {
                            BaseJobService.scheduleMessageJob(context.getApplicationContext(), stringExtra, intent.getLongExtra("transactionId", 0L), intent.getStringExtra(AFConstants.EXTRA_AGENT_ID), (PeerAgent) intent.getParcelableExtra("peerAgent"));
                            return;
                        }
                        if (z10) {
                            startService = context.startForegroundService(intent);
                        } else {
                            startService = context.startService(intent);
                        }
                        if (startService == null) {
                            C1371a.d(TAG, "Agent " + stringExtra + " not found. Check Accessory Service XML for serviceImpl attribute");
                            return;
                        }
                        return;
                    } catch (ClassNotFoundException e10) {
                        C1371a.d(TAG, "Agent Impl class not found!" + e10);
                        return;
                    } catch (Exception e11) {
                        C1371a.e(TAG, "", e11);
                        return;
                    }
                } catch (GeneralException e12) {
                    C1371a.d(TAG, "SDK config initialization failed." + e12);
                    return;
                }
            }
            return;
        }
        C1371a.c(TAG, "received null intent!");
    }
}
