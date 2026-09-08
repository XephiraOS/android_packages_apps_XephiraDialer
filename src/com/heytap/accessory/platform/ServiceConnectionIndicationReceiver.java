package com.heytap.accessory.platform;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import com.heytap.accessory.BaseJobAgent;
import com.heytap.accessory.api.ManagerConfig;
import com.heytap.accessory.bean.GeneralException;
import com.heytap.accessory.bean.ServiceProfile;
import com.heytap.accessory.constant.AFConstants;
import com.heytap.accessory.d;
import n5.C1371a;
import r5.e;
import r5.g;
import r5.h;

/* loaded from: classes3.dex */
public final class ServiceConnectionIndicationReceiver extends BroadcastReceiver {
    private static final String TAG = "ServiceConnectionIndicationReceiver";

    private void handleConnectionRequest(Context context, Intent intent, String str) {
        C1371a.c(TAG, "handleConnectionRequest ");
        BaseJobAgent.requestAgent(context, str, new d(1, intent));
    }

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
        boolean z10;
        String str = TAG;
        C1371a.c(str, "onReceive");
        if (intent != null && intent.getAction() != null && "com.heytap.accessory.action.SERVICE_CONNECTION_REQUESTED".equalsIgnoreCase(intent.getAction())) {
            C1371a.g(str, "Incoming service connection request received.");
            try {
                new h(context);
                try {
                    String stringExtra = intent.getStringExtra(AFConstants.EXTRA_AGENT_IMPL_CLASS);
                    if (stringExtra == null) {
                        C1371a.d(str, "Impl class not available in intent. Ignoring request");
                        return;
                    }
                    C1371a.i(str, "Connection request will be handled by :" + stringExtra);
                    Class<?> cls = Class.forName(stringExtra);
                    if (!isValidImplClass(context, cls.getName())) {
                        return;
                    }
                    boolean a10 = r5.d.a(BaseJobAgent.class, cls);
                    boolean z11 = false;
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                    int i10 = packageInfo.applicationInfo.targetSdkVersion;
                    if (i10 >= 21) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (i10 >= 26) {
                        z11 = true;
                    }
                    intent.setClassName(context, stringExtra);
                    if (a10 && z10) {
                        handleConnectionRequest(context.getApplicationContext(), intent, stringExtra);
                        C1371a.g(str, "ServiceConnectionIndicationReceiver handle complete");
                        return;
                    }
                    if (z11) {
                        int a11 = g.a(context);
                        if (!ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE.equals(packageInfo.packageName) && a11 != 1000) {
                            C1371a.c(str, "startForegroundService");
                            context.startForegroundService(intent);
                            return;
                        }
                        C1371a.c(str, "startService directly in OAF APP or system app");
                        context.startService(intent);
                        return;
                    }
                    C1371a.c(str, "startService");
                    context.startService(intent);
                } catch (ClassNotFoundException e10) {
                    C1371a.d(TAG, "Agent Impl class not found!" + e10);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            } catch (GeneralException e12) {
                C1371a.d(TAG, "SDK config init failed." + e12);
            }
        }
    }
}
