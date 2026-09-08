package com.customize.contacts.util;

import android.content.Context;
import android.content.Intent;
import android.telecom.TelecomManager;
import com.android.contacts.dialerui.dialer.SatelliteDialer;
import com.customize.contacts.FeatureOption;

/* compiled from: CallUtils.java */
/* renamed from: com.customize.contacts.util.m, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0802m {
    public static void a(Context context, Intent intent) {
        SatelliteDialer.Statistics statistics;
        if (FeatureOption.i() && com.android.contacts.framework.api.satellite.a.b() && com.android.contacts.framework.api.satellite.a.e()) {
            statistics = SatelliteDialer.H();
            if (H7.a.b()) {
                H7.b.b("CallUtils", "addNewOutgoingCall: satellite in service.");
            }
        } else {
            statistics = null;
        }
        com.android.contacts.framework.baseui.util.p.b(context, intent, statistics);
    }

    public static boolean b(Context context) {
        if (com.android.contacts.util.w.n(context)) {
            return ((TelecomManager) context.getSystemService("telecom")).isInCall();
        }
        return false;
    }
}
