package com.customize.contacts.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import r0.C1498a;

/* compiled from: BroadcastReceiverUtils.java */
/* renamed from: com.customize.contacts.util.i, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0798i {
    public static List<ComponentName> a(Context context, String str) {
        Intent intent = new Intent(str);
        ArrayList arrayList = new ArrayList();
        Iterator<ResolveInfo> it = context.getPackageManager().queryBroadcastReceivers(intent, 0).iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            arrayList.add(new ComponentName(activityInfo.packageName, activityInfo.name));
        }
        return arrayList;
    }

    public static void b(Context context) {
        if (context == null) {
            return;
        }
        try {
            String str = C1498a.f36254m;
            Intent intent = new Intent(str);
            for (ComponentName componentName : a(context, str)) {
                intent.setComponent(componentName);
                if (H7.a.b()) {
                    H7.b.b("BroadcastReceiverUtils", "componentName = " + componentName);
                }
                context.sendBroadcast(intent, R0.b.f3175i);
            }
        } catch (Exception e10) {
            H7.b.b("BroadcastReceiverUtils", "send CHANGE_ACTION for Calendar error" + e10);
        }
    }

    public static void c(Context context) {
        if (context == null) {
            return;
        }
        try {
            Intent intent = new Intent("com.android.mms.refresh.all.threads");
            intent.setPackage("com.android.mms");
            context.sendBroadcast(intent, R0.b.f3175i);
        } catch (Exception e10) {
            H7.b.b("BroadcastReceiverUtils", "send CHANGE_ACTION for Mms error" + e10);
        }
    }
}
