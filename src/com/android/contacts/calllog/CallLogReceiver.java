package com.android.contacts.calllog;

import R0.c;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.PowerManager;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.android.contacts.DynamicShortcuts;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.util.NotificationUtilsKt;
import com.android.contacts.framework.baseui.util.NumberIdentifyUtils;
import com.android.contacts.framework.virtualsupport.utils.GrpcUtils;
import com.android.incallui.OplusAutoRedialNotificationUI;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.util.V;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import n1.AbstractC1362a;
import r0.C1498a;

/* loaded from: classes.dex */
public class CallLogReceiver extends BroadcastReceiver {
    public static /* synthetic */ void j(Context context) {
        if (B3.a.r()) {
            V.b(context);
        }
        GrpcUtils.initGrpcProvider(context, GrpcUtils.getOperationCallBack());
    }

    public static /* synthetic */ void k(Context context) {
        int a10;
        if (!M7.a.h(context, "com.coloros.bootreg", "strengthenService", "true") || (a10 = NumberIdentifyUtils.a(context)) == -1) {
            return;
        }
        int i10 = 1;
        if (a10 != 1) {
            i10 = 0;
        }
        NumberIdentifyUtils.k(context, i10);
    }

    public static /* synthetic */ void l(Context context, Intent intent) {
        try {
            if (((PowerManager) context.getSystemService("power")).isIgnoringBatteryOptimizations(context.getPackageName())) {
                context.startService(intent);
            }
        } catch (Throwable th) {
            H7.b.c("CallLogReceiver", "throwable = " + th);
        }
    }

    public final int e(Context context) {
        int d10 = G0.c.d(context, 1, c.a.f3201g, 0);
        if (H7.a.b()) {
            H7.b.b("CallLogReceiver", "getHideCardRecognizeValue value = " + d10);
        }
        return d10;
    }

    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final void i(Context context) {
        if (B3.a.I()) {
            if (h()) {
                g(context, true);
                return;
            } else {
                if (e(context) != 2) {
                    g(context, false);
                    return;
                }
                return;
            }
        }
        g(context, true);
    }

    public final void g(Context context, boolean z10) {
        H7.b.b("CallLogReceiver", "hideOrShowCardRecognize isHide=" + z10);
        G0.c.n(context, 1, c.a.f3201g, z10 ? 1 : 0);
    }

    public final boolean h() {
        String c10 = B3.a.c();
        if (H7.a.b()) {
            H7.b.b("CallLogReceiver", "isNeedHideCardRecognize regionMark = " + c10);
        }
        if (!"EUEX".equals(c10) && !"RU".equals(c10) && !"JP".equals(c10)) {
            return false;
        }
        return true;
    }

    public final void m(final Context context, final Intent intent) {
        N7.a.b().execute(new Runnable() { // from class: com.android.contacts.calllog.v
            @Override // java.lang.Runnable
            public final void run() {
                CallLogReceiver.l(context, intent);
            }
        });
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        H7.b.e("CallLogReceiver", "Action = " + intent.getAction());
        if ("android.intent.action.NEW_VOICEMAIL".equals(intent.getAction())) {
            Intent intent2 = new Intent(context, (Class<?>) CallLogNotificationsService.class);
            intent2.setAction("com.android.contacts.calllog.UPDATE_NOTIFICATIONS");
            intent2.putExtra("NEW_VOICEMAIL_URI", intent.getData());
            m(context, intent2);
            return;
        }
        if (C1498a.f36259r.equals(intent.getAction())) {
            N7.a.b().execute(new Runnable() { // from class: com.android.contacts.calllog.s
                @Override // java.lang.Runnable
                public final void run() {
                    CallLogReceiver.this.i(context);
                }
            });
            X.a.b(context.getApplicationContext()).d(new Intent("com.oplus.contacts.update_name_card_layout"));
            Intent intent3 = new Intent(context, (Class<?>) CallLogNotificationsService.class);
            intent3.setAction("com.android.contacts.calllog.UPDATE_NOTIFICATIONS");
            m(context, intent3);
            Intent intent4 = new Intent();
            intent4.setAction("com.oplus.querySimCard");
            intent4.setPackage(context.getPackageName());
            context.sendBroadcast(intent4);
            DynamicShortcuts.o(context.getApplicationContext());
            PreferenceManager.getDefaultSharedPreferences(context);
            AbstractC1362a.h(context);
            com.customize.contacts.simcontacts.b.k(context.getApplicationContext());
            N7.a.b().execute(new Runnable() { // from class: com.android.contacts.calllog.t
                @Override // java.lang.Runnable
                public final void run() {
                    CallLogReceiver.j(context);
                }
            });
            return;
        }
        if ("android.intent.action.PACKAGE_DATA_CLEARED".equals(intent.getAction())) {
            Uri data = intent.getData();
            if (data != null) {
                String schemeSpecificPart = data.getSchemeSpecificPart();
                H7.b.b("CallLogReceiver", "mAppDataClearReceiver: pkgName: " + schemeSpecificPart);
                if ("com.heytap.cloud".equals(schemeSpecificPart)) {
                    G0.c.n(context, 0, "ocloud_contacts_state", 0);
                    return;
                }
                return;
            }
            return;
        }
        if (C1498a.f36245d.equals(intent.getAction())) {
            if (G0.c.d(context, 0, "not_requery_ted_mark_info", 0) == 1) {
                return;
            }
            long f10 = C7.e.f(intent, BreenoCallContract.BaseColumns._ID, 0L);
            int d10 = C7.e.d(intent, OplusAutoRedialNotificationUI.TYPE, 0);
            String l10 = C7.e.l(intent, "number");
            int d11 = C7.e.d(intent, "simid", -1);
            long f11 = C7.e.f(intent, "duration", 0L);
            String l11 = C7.e.l(intent, "hasRecog");
            if (H7.a.b()) {
                H7.b.b("CallLogReceiver", "received new calls number is " + H7.a.d(l10) + " ,call type is " + d10 + " ,id is " + f10 + " ,simId = " + d11 + " ,hasRecog = " + l11);
            }
            if (!TextUtils.isEmpty(l10) && f10 != 0 && d10 != 0 && d10 != 2) {
                com.customize.contacts.util.J j10 = new com.customize.contacts.util.J();
                j10.q();
                j10.p(context, l10, d11, d10, f11, f10, l11);
                return;
            }
            return;
        }
        if ("com.coloros.bootreg".equals(intent.getAction())) {
            if (FeatureOption.i() && CommonFeatureOption.j()) {
                boolean c10 = C7.e.c(intent, "period", true);
                H7.b.e("CallLogReceiver", "periodStatus = " + c10);
                if (c10) {
                    return;
                }
                final Context applicationContext = context.getApplicationContext();
                N7.a.a().execute(new Runnable() { // from class: com.android.contacts.calllog.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        CallLogReceiver.k(applicationContext);
                    }
                });
                return;
            }
            return;
        }
        if ("oplus.intent.action.contacts.NUMBER_RECOGNITION_UPDATE_NOTIFICATION".equals(intent.getAction())) {
            NotificationUtilsKt.h();
            return;
        }
        H7.b.i("CallLogReceiver", "onReceive: could not handle: " + intent);
    }
}
