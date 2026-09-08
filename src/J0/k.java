package J0;

import J0.e;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Bundle;
import android.telecom.PhoneAccount;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.telephony.PhoneNumberUtils;
import android.text.BidiFormatter;
import android.text.TextDirectionHeuristics;
import android.text.TextUtils;
import android.util.Pair;
import com.android.contacts.framework.appstore.missedcall.CallLogNotificationsActivity;
import com.android.contacts.framework.appstore.missedcall.MissedCallBroadcastReceiver;
import com.android.incallui.OplusPhoneUtils;
import h1.C1072a;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: MissedCallNotifier.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: c, reason: collision with root package name */
    public static k f1464c;

    /* renamed from: a, reason: collision with root package name */
    public final Context f1465a;

    /* renamed from: b, reason: collision with root package name */
    public final e f1466b;

    public k(Context context, e eVar) {
        this.f1465a = context;
        this.f1466b = eVar;
    }

    public static void a(Context context) {
        H7.b.b("MissedCallNotifier", "clearAllMissedCalls");
        e.e(context);
        j.a(context);
    }

    public static void b(Context context, Bundle bundle) {
        String[] stringArray = bundle.getStringArray("cancel_calls_notifications");
        if (stringArray != null && stringArray.length > 0) {
            for (String str : stringArray) {
                H7.b.b("MissedCallNotifier", "number:" + str);
                c(context, str);
            }
        }
    }

    public static void c(Context context, String str) {
        j.b(context, o(m(str)));
    }

    public static void d(Context context, Intent intent, String str) {
        Uri uri = (Uri) C7.e.j(intent, "callUri");
        int o10 = o(m(str));
        e.g(context, uri);
        j.b(context, o10);
    }

    public static void i(Context context) {
        NotificationChannel notificationChannel = new NotificationChannel("phone_missed_call", context.getText(H0.d.f1218f), 3);
        notificationChannel.setShowBadge(true);
        notificationChannel.enableLights(true);
        notificationChannel.enableVibration(true);
        notificationChannel.setSound(null, new AudioAttributes.Builder().setUsage(5).build());
        ((NotificationManager) context.getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
    }

    public static String m(String str) {
        if (!TextUtils.isEmpty(str) && !OplusPhoneUtils.DeviceState.INVALID_STATUS.equals(str) && !"-2".equals(str) && !"-3".equals(str)) {
            return str.replaceAll(" ", "").replaceAll("-", "");
        }
        return str;
    }

    public static synchronized k n(Context context) {
        k kVar;
        synchronized (k.class) {
            try {
                if (f1464c == null) {
                    f1464c = new k(context, e.c(context));
                }
                kVar = f1464c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return kVar;
    }

    public static int o(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            String trim = Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim();
            if (trim.length() >= 10) {
                trim = trim.substring(trim.length() - 8);
            }
            return Integer.parseInt(trim);
        } catch (Exception unused) {
            H7.b.b("MissedCallNotifier", "The error of formating number");
            return 0;
        }
    }

    public static String p() {
        return "GroupSummary_MissedCall";
    }

    public final void e(Notification notification) {
        notification.flags |= 1;
        notification.defaults |= 4;
    }

    public final PendingIntent f(Uri uri, Uri uri2) {
        return l("com.android.server.telecom.ACTION_CALL_BACK_FROM_NOTIFICATION", uri, uri2);
    }

    public final PendingIntent g(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", (Uri) null);
        intent.setType("vnd.android.cursor.dir/calls");
        intent.putExtra("viewMissCall", "viewMissCallFromStatusBar");
        intent.putExtra("number", str);
        intent.setPackage(this.f1465a.getPackageName());
        TaskStackBuilder create = TaskStackBuilder.create(this.f1465a);
        create.addNextIntent(intent);
        return create.getPendingIntent(0, 67108864, null);
    }

    public final PendingIntent h(Context context) {
        return PendingIntent.getBroadcast(context, 0, new Intent("com.android.server.telecom.ACTION_CLEAR_MISSED_CALLS", null, context, MissedCallBroadcastReceiver.class), 201326592);
    }

    public final Notification.Builder j() {
        return new Notification.Builder(this.f1465a).setGroup("MissedCallGroup").setSmallIcon(H0.a.f1206a).setAutoCancel(true).setOnlyAlertOnce(true).setShowWhen(true).setVibrate(new long[]{0, 0, 1000});
    }

    public final PendingIntent k(Uri uri, Uri uri2) {
        return l("com.android.server.telecom.ACTION_SEND_SMS_FROM_NOTIFICATION", Uri.fromParts("smsto", uri.getSchemeSpecificPart(), null), uri2);
    }

    public final PendingIntent l(String str, Uri uri, Uri uri2) {
        Intent intent = new Intent(str, uri, this.f1465a, CallLogNotificationsActivity.class);
        intent.putExtra("callUri", uri2);
        return PendingIntent.getActivity(this.f1465a, 0, intent, 201326592);
    }

    public final void q(List<e.b> list) {
        ComponentName unflattenFromString;
        PhoneAccount phoneAccount;
        if (list == null) {
            return;
        }
        TelecomManager telecomManager = (TelecomManager) this.f1465a.getSystemService(TelecomManager.class);
        Iterator<e.b> it = list.iterator();
        while (it.hasNext()) {
            e.b next = it.next();
            String str = next.f1435e;
            if (str != null && next.f1436f != null && (unflattenFromString = ComponentName.unflattenFromString(str)) != null && (phoneAccount = telecomManager.getPhoneAccount(new PhoneAccountHandle(unflattenFromString, next.f1436f))) != null && phoneAccount.hasCapabilities(2048)) {
                H7.b.e("MissedCallNotifier.removeSelfManagedCalls", "ignoring self-managed call " + next.f1431a);
                it.remove();
            }
        }
    }

    public Pair<Integer, Integer> r(int i10, String str, List<e.b> list) {
        int i11 = -1;
        if (list != null) {
            if (i10 != -1 && i10 != list.size()) {
                H7.b.i("MissedCallNotifier", "Call count does not match call log count. count: " + i10 + " newCalls.size(): " + list.size());
            }
            int i12 = -1;
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                if (list.get(i14).f1433c.equals(m(str))) {
                    i13++;
                    if (i12 == -1 || list.get(i14).f1439i > list.get(i12).f1439i) {
                        i12 = i14;
                    }
                }
            }
            i10 = i13;
            i11 = i12;
        }
        return new Pair<>(Integer.valueOf(i10), Integer.valueOf(i11));
    }

    public void s(int i10, String str) {
        boolean z10;
        String str2;
        int intValue;
        e.b bVar;
        CharSequence createTtsSpannable;
        int i11;
        if (i10 == 0) {
            e.e(this.f1465a);
            j.a(this.f1465a);
            return;
        }
        if (str == null) {
            return;
        }
        boolean d10 = P7.e.d(this.f1465a);
        H7.b.b("MissedCallNotifier", "isUserUnlocked:" + d10);
        if (!d10) {
            z10 = d10;
            str2 = str;
            intValue = i10;
            bVar = new e.b(null, null, str, 1, null, null, null, null, System.currentTimeMillis(), 0, 0L, 0);
        } else {
            z10 = d10;
            List<e.b> d11 = this.f1466b.d();
            q(d11);
            if (d11 != null && d11.isEmpty()) {
                e.e(this.f1465a);
                j.a(this.f1465a);
                return;
            }
            str2 = str;
            Pair<Integer, Integer> r10 = r(i10, str2, d11);
            intValue = ((Integer) r10.first).intValue();
            int intValue2 = ((Integer) r10.second).intValue();
            if (intValue != -1 && intValue2 != -1) {
                if (d11 != null && intValue2 < d11.size()) {
                    bVar = d11.get(intValue2);
                } else {
                    bVar = null;
                }
            } else {
                return;
            }
        }
        if (bVar == null) {
            return;
        }
        Notification.Builder j10 = j();
        String p10 = p();
        f b10 = this.f1466b.b(bVar.f1433c, bVar.f1434d, bVar.f1438h);
        if (!TextUtils.equals(b10.f1446c, b10.f1450g) && !TextUtils.equals(b10.f1446c, b10.f1449f)) {
            createTtsSpannable = b10.f1446c;
        } else {
            createTtsSpannable = PhoneNumberUtils.createTtsSpannable(BidiFormatter.getInstance().unicodeWrap(b10.f1446c, TextDirectionHeuristics.LTR));
        }
        if ((bVar.f1442l & 1) == 1) {
            i11 = H0.a.f1208c;
        } else {
            i11 = H0.a.f1207b;
        }
        j10.setLargeIcon(BitmapFactory.decodeResource(this.f1465a.getResources(), i11));
        if (z10 && !TextUtils.isEmpty(bVar.f1433c) && !TextUtils.equals(bVar.f1433c, this.f1465a.getString(H0.d.f1215c))) {
            Uri fromParts = Uri.fromParts("tel", str2, null);
            j10.addAction(new Notification.Action.Builder(Icon.createWithResource(this.f1465a, H0.a.f1209d), this.f1465a.getString(H0.d.f1216d), f(fromParts, bVar.f1431a)).build());
            if (!C1072a.f(bVar.f1433c)) {
                j10.addAction(new Notification.Action.Builder(Icon.createWithResource(this.f1465a, H0.a.f1210e), this.f1465a.getString(H0.d.f1217e), k(fromParts, bVar.f1431a)).build());
            }
        }
        String quantityString = this.f1465a.getResources().getQuantityString(H0.c.f1212a, intValue, Integer.valueOf(intValue));
        Notification.Builder j11 = j();
        j11.setContentTitle(createTtsSpannable).setContentIntent(g(bVar.f1433c)).setAutoCancel(true).setDeleteIntent(h(this.f1465a));
        j10.setContentTitle(createTtsSpannable).setContentText(quantityString).setContentIntent(g(bVar.f1433c)).setAutoCancel(true).setDeleteIntent(h(this.f1465a)).setPublicVersion(j11.build());
        if (F.a.a()) {
            i(this.f1465a);
            j10.setChannelId("phone_missed_call");
        }
        Notification build = j10.build();
        e(build);
        h.e(this.f1465a, p10, o(m(str)), build);
    }
}
