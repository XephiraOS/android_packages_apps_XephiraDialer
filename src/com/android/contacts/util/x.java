package com.android.contacts.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.sip.SipManager;
import android.telephony.TelephonyManager;
import com.oplus.dialer.R;

/* compiled from: PhoneCapabilityTester.java */
/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f17620a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f17621b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f17622c;

    public static void a(Context context) {
        boolean z10;
        boolean isVoiceCapable = ((TelephonyManager) context.getSystemService("phone")).isVoiceCapable();
        f17621b = isVoiceCapable;
        if (isVoiceCapable && SipManager.isVoipSupported(context)) {
            z10 = true;
        } else {
            z10 = false;
        }
        f17622c = z10;
        f17620a = true;
    }

    public static boolean b(Context context, Intent intent) {
        if (context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0) {
            return true;
        }
        return false;
    }

    public static boolean c(Context context) {
        if (!f17620a) {
            a(context);
        }
        return f17621b;
    }

    public static boolean d(Context context) {
        if (!f17620a) {
            a(context);
        }
        return f17622c;
    }

    public static boolean e(Context context) {
        return b(context, new Intent("android.intent.action.SENDTO", Uri.fromParts("smsto", "", null)));
    }

    public static boolean f(Context context) {
        return context.getResources().getBoolean(R.bool.config_use_two_panes);
    }
}
