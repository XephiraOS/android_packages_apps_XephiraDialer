package com.customize.contacts.pushnotification.model;

import android.content.Context;
import android.util.Log;
import com.customize.contacts.pushnotification.model.PushNotificationScheduler;

/* compiled from: NotificationClickEventProcessor.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f21760a = "NotificationClickEventProcessor";

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x00a6. Please report as an issue. */
    public final void a(Context context, c notification) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(notification, "notification");
        if (kotlin.jvm.internal.i.b(notification.h(), "cloud sync")) {
            notification.o(notification.b() + 1);
        }
        long j10 = 1000;
        notification.p(System.currentTimeMillis() / j10);
        PushNotificationScheduler.b.a aVar = PushNotificationScheduler.b.f21750a;
        int n10 = notification.n();
        Log.i("PushNotificationScheduler", "changeState: " + notification.h());
        if (n10 != notification.n()) {
            Log.i("PushNotificationScheduler", "the state " + n10 + " not equal the state of notification " + notification.n());
            return;
        }
        if (n10 == 6) {
            Log.i("PushNotificationScheduler", "from state  equal to state : " + n10);
            return;
        }
        String str = n10 + "->6";
        notification.r(6);
        switch (str.hashCode()) {
            case 1504977:
                if (str.equals("1->3")) {
                    return;
                }
                Log.i("PushNotificationScheduler", "unknown state path " + n10 + " -> 6");
                return;
            case 1504978:
                if (str.equals("1->4")) {
                    notification.p(System.currentTimeMillis() / j10);
                    notification.o(notification.b() + 1);
                    if (notification.g() != -1 && notification.b() >= notification.g()) {
                        notification.r(7);
                        return;
                    } else {
                        notification.r(6);
                        return;
                    }
                }
                Log.i("PushNotificationScheduler", "unknown state path " + n10 + " -> 6");
                return;
            case 1504979:
                if (str.equals("1->5")) {
                    return;
                }
                Log.i("PushNotificationScheduler", "unknown state path " + n10 + " -> 6");
                return;
            case 1534766:
                if (str.equals("2->1")) {
                    notification.p(System.currentTimeMillis() / j10);
                    return;
                }
                Log.i("PushNotificationScheduler", "unknown state path " + n10 + " -> 6");
                return;
            case 1624140:
                if (str.equals("5->2")) {
                    return;
                }
                Log.i("PushNotificationScheduler", "unknown state path " + n10 + " -> 6");
                return;
            case 1653931:
                if (str.equals("6->2")) {
                    return;
                }
                Log.i("PushNotificationScheduler", "unknown state path " + n10 + " -> 6");
                return;
            default:
                Log.i("PushNotificationScheduler", "unknown state path " + n10 + " -> 6");
                return;
        }
    }

    public final void b(Context context, c notification) {
        int i10;
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(notification, "notification");
        notification.o(notification.b() + 1);
        long j10 = 1000;
        notification.p(System.currentTimeMillis() / j10);
        if (notification.g() != -1 && notification.b() >= notification.g()) {
            PushNotificationScheduler.b.a aVar = PushNotificationScheduler.b.f21750a;
            int n10 = notification.n();
            Log.i("PushNotificationScheduler", "changeState: " + notification.h());
            if (n10 != notification.n()) {
                Log.i("PushNotificationScheduler", "the state " + n10 + " not equal the state of notification " + notification.n());
                return;
            }
            if (n10 == 7) {
                Log.i("PushNotificationScheduler", "from state  equal to state : " + n10);
                return;
            }
            String str = n10 + "->7";
            notification.r(7);
            switch (str.hashCode()) {
                case 1504977:
                    if (str.equals("1->3")) {
                        return;
                    }
                    break;
                case 1504978:
                    if (str.equals("1->4")) {
                        notification.p(System.currentTimeMillis() / j10);
                        notification.o(notification.b() + 1);
                        if (notification.g() != -1 && notification.b() >= notification.g()) {
                            notification.r(7);
                            return;
                        } else {
                            notification.r(6);
                            return;
                        }
                    }
                    break;
                case 1504979:
                    if (str.equals("1->5")) {
                        return;
                    }
                    break;
                case 1534766:
                    if (str.equals("2->1")) {
                        notification.p(System.currentTimeMillis() / j10);
                        return;
                    }
                    break;
                case 1624140:
                    if (str.equals("5->2")) {
                        return;
                    }
                    break;
                case 1653931:
                    if (str.equals("6->2")) {
                        return;
                    }
                    break;
            }
            Log.i("PushNotificationScheduler", "unknown state path " + n10 + " -> 7");
            return;
        }
        PushNotificationScheduler.b.a aVar2 = PushNotificationScheduler.b.f21750a;
        int n11 = notification.n();
        Log.i("PushNotificationScheduler", "changeState: " + notification.h());
        if (n11 != notification.n()) {
            Log.i("PushNotificationScheduler", "the state " + n11 + " not equal the state of notification " + notification.n());
            return;
        }
        if (n11 == 6) {
            Log.i("PushNotificationScheduler", "from state  equal to state : " + n11);
            return;
        }
        String str2 = n11 + "->6";
        notification.r(6);
        switch (str2.hashCode()) {
            case 1504977:
                i10 = 6;
                if (str2.equals("1->3")) {
                    return;
                }
                Log.i("PushNotificationScheduler", "unknown state path " + n11 + " -> " + i10);
            case 1504978:
                if (str2.equals("1->4")) {
                    notification.p(System.currentTimeMillis() / j10);
                    notification.o(notification.b() + 1);
                    if (notification.g() != -1 && notification.b() >= notification.g()) {
                        notification.r(7);
                        return;
                    } else {
                        notification.r(6);
                        return;
                    }
                }
                break;
            case 1504979:
                if (str2.equals("1->5")) {
                    return;
                }
                break;
            case 1534766:
                if (str2.equals("2->1")) {
                    notification.p(System.currentTimeMillis() / j10);
                    return;
                }
                break;
            case 1624140:
                if (str2.equals("5->2")) {
                    return;
                }
                break;
            case 1653931:
                if (str2.equals("6->2")) {
                    return;
                }
                break;
        }
        i10 = 6;
        Log.i("PushNotificationScheduler", "unknown state path " + n11 + " -> " + i10);
    }
}
