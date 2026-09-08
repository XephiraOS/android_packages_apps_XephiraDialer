package com.android.contacts.framework.baseui.util;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.service.notification.StatusBarNotification;
import android.telephony.TelephonyManager;
import com.oplus.foundation.util.feature.FeatureUtil;
import kotlin.Result;
import kotlinx.coroutines.C1241e0;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.S;

/* compiled from: NotificationUtils.kt */
/* loaded from: classes.dex */
public final class NotificationUtilsKt {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f15870a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f15871b;

    /* renamed from: c, reason: collision with root package name */
    public static String f15872c;

    /* renamed from: d, reason: collision with root package name */
    public static final NotificationUtilsKt$phoneStateListenerReceiver$1 f15873d = new BroadcastReceiver() { // from class: com.android.contacts.framework.baseui.util.NotificationUtilsKt$phoneStateListenerReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str;
            String str2;
            if (intent != null) {
                str = intent.getAction();
            } else {
                str = null;
            }
            if (kotlin.jvm.internal.i.b("android.intent.action.PHONE_STATE", str)) {
                String stringExtra = intent.getStringExtra("state");
                H7.b.e("NotificationUtils", "ACTION_PHONE_STATE_CHANGED : " + stringExtra);
                String str3 = TelephonyManager.EXTRA_STATE_OFFHOOK;
                str2 = NotificationUtilsKt.f15872c;
                if (!str3.equals(str2) || !TelephonyManager.EXTRA_STATE_IDLE.equals(stringExtra)) {
                    NotificationUtilsKt.f15872c = stringExtra;
                    return;
                }
                NotificationUtilsKt.i(P7.a.f2961a.a());
                NotificationUtilsKt.j();
                NotificationUtilsKt.f15872c = null;
            }
        }
    };

    public static final void f(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        if (f15870a) {
            C1248i.d(C1241e0.f34422a, S.b(), null, new NotificationUtilsKt$cancelNumberRecognitionNotification$1(context, null), 2, null);
        }
    }

    public static final boolean g(Context context) {
        StatusBarNotification[] activeNotifications;
        try {
            Result.a aVar = Result.f34166a;
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            if (notificationManager != null && (activeNotifications = notificationManager.getActiveNotifications()) != null) {
                kotlin.jvm.internal.i.e(activeNotifications, "activeNotifications");
                for (StatusBarNotification statusBarNotification : activeNotifications) {
                    if (statusBarNotification.getId() == 1 && kotlin.jvm.internal.i.b(statusBarNotification.getTag(), "number_recognition")) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            Object b10 = Result.b(kotlin.b.a(th));
            Boolean bool = Boolean.FALSE;
            if (Result.f(b10)) {
                b10 = bool;
            }
            return ((Boolean) b10).booleanValue();
        }
    }

    public static final void h() {
        Object b10;
        try {
            Result.a aVar = Result.f34166a;
            if (!f15871b) {
                P7.a.f2961a.a().registerReceiver(f15873d, new IntentFilter("android.intent.action.PHONE_STATE"));
                f15871b = true;
            }
            b10 = Result.b(m9.q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("NotificationUtils", "listenPhoneState : " + d10 + " " + d10.getMessage());
        }
    }

    public static final void i(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        if (FeatureUtil.O()) {
            C1248i.d(C1241e0.f34422a, S.b(), null, new NotificationUtilsKt$showNumberRecognitionNotificationIfNeed$1(context, null), 2, null);
        }
    }

    public static final void j() {
        Object b10;
        try {
            Result.a aVar = Result.f34166a;
            P7.a.f2961a.a().unregisterReceiver(f15873d);
            f15871b = false;
            b10 = Result.b(m9.q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("NotificationUtils", "unRegisterListenPhoneState : " + d10 + " " + d10.getMessage());
        }
    }
}
