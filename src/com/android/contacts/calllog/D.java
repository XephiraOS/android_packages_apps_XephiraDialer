package com.android.contacts.calllog;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.net.Uri;
import android.provider.CallLog;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.voicemail.VoicemailDetailActivity;
import com.android.incallui.OplusAutoRedialNotificationUI;
import com.oplus.dialer.R;
import java.util.regex.Pattern;

/* compiled from: DefaultVoicemailNotifier.java */
/* loaded from: classes.dex */
public class D {

    /* renamed from: f, reason: collision with root package name */
    public static D f13771f;

    /* renamed from: a, reason: collision with root package name */
    public final Context f13772a;

    /* renamed from: b, reason: collision with root package name */
    public final NotificationManager f13773b;

    /* renamed from: c, reason: collision with root package name */
    public final e f13774c;

    /* renamed from: d, reason: collision with root package name */
    public final c f13775d;

    /* renamed from: e, reason: collision with root package name */
    public final I f13776e;

    /* compiled from: DefaultVoicemailNotifier.java */
    /* loaded from: classes.dex */
    public static final class a implements c {

        /* renamed from: b, reason: collision with root package name */
        public static final String[] f13777b = {BreenoCallContract.BaseColumns._ID, "number", "display_name"};

        /* renamed from: a, reason: collision with root package name */
        public final ContentResolver f13778a;

        /* JADX WARN: Removed duplicated region for block: B:26:0x0059  */
        @Override // com.android.contacts.calllog.D.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.android.contacts.calllog.D.f b(java.lang.String r8) {
            /*
                r7 = this;
                r0 = 0
                android.content.ContentResolver r1 = r7.f13778a     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
                android.net.Uri r2 = R0.d.c(r8)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
                java.lang.String[] r3 = com.android.contacts.calllog.D.a.f13777b     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
                r5 = 0
                r6 = 0
                r4 = 0
                android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
                if (r7 == 0) goto L31
                boolean r8 = r7.moveToFirst()     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
                if (r8 != 0) goto L19
                goto L31
            L19:
                com.android.contacts.calllog.D$f r8 = new com.android.contacts.calllog.D$f     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
                r1 = 0
                long r1 = r7.getLong(r1)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
                r3 = 2
                java.lang.String r3 = r7.getString(r3)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
                r8.<init>(r1, r3)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
                r7.close()
                return r8
            L2c:
                r8 = move-exception
                r0 = r7
                goto L57
            L2f:
                r8 = move-exception
                goto L3b
            L31:
                if (r7 == 0) goto L36
                r7.close()
            L36:
                return r0
            L37:
                r8 = move-exception
                goto L57
            L39:
                r8 = move-exception
                r7 = r0
            L3b:
                java.lang.String r1 = "DefaultVoicemailNotifier"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2c
                r2.<init>()     // Catch: java.lang.Throwable -> L2c
                java.lang.String r3 = ""
                r2.append(r3)     // Catch: java.lang.Throwable -> L2c
                r2.append(r8)     // Catch: java.lang.Throwable -> L2c
                java.lang.String r8 = r2.toString()     // Catch: java.lang.Throwable -> L2c
                H7.b.c(r1, r8)     // Catch: java.lang.Throwable -> L2c
                if (r7 == 0) goto L56
                r7.close()
            L56:
                return r0
            L57:
                if (r0 == 0) goto L5c
                r0.close()
            L5c:
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.calllog.D.a.b(java.lang.String):com.android.contacts.calllog.D$f");
        }

        public a(ContentResolver contentResolver) {
            this.f13778a = contentResolver;
        }
    }

    /* compiled from: DefaultVoicemailNotifier.java */
    /* loaded from: classes.dex */
    public static final class b implements e {

        /* renamed from: b, reason: collision with root package name */
        public static final String[] f13779b = {BreenoCallContract.BaseColumns._ID, "number", "voicemail_uri"};

        /* renamed from: a, reason: collision with root package name */
        public final ContentResolver f13780a;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.android.contacts.calllog.D.e
        public d[] a() {
            Cursor cursor;
            SQLiteCursor sQLiteCursor = 0;
            try {
                try {
                    cursor = this.f13780a.query(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, f13779b, String.format("%s = 1 AND %s = ?", "new", OplusAutoRedialNotificationUI.TYPE), new String[]{Integer.toString(4)}, "date DESC");
                    if (cursor == null) {
                        com.oplus.foundation.util.io.e.a(cursor);
                        return null;
                    }
                    try {
                        d[] dVarArr = new d[cursor.getCount()];
                        while (cursor.moveToNext()) {
                            dVarArr[cursor.getPosition()] = b(cursor);
                        }
                        com.oplus.foundation.util.io.e.a(cursor);
                        return dVarArr;
                    } catch (Exception e10) {
                        e = e10;
                        H7.b.c("DefaultVoicemailNotifier", "Exception: " + e);
                        com.oplus.foundation.util.io.e.a(cursor);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    sQLiteCursor = "%s = 1 AND %s = ?";
                    com.oplus.foundation.util.io.e.a(sQLiteCursor);
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                com.oplus.foundation.util.io.e.a(sQLiteCursor);
                throw th;
            }
        }

        public final d b(Cursor cursor) {
            Uri parse;
            String string = cursor.getString(2);
            Uri withAppendedId = ContentUris.withAppendedId(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, cursor.getLong(0));
            if (string == null) {
                parse = null;
            } else {
                parse = Uri.parse(string);
            }
            return new d(withAppendedId, parse, cursor.getString(1));
        }

        public b(ContentResolver contentResolver) {
            this.f13780a = contentResolver;
        }
    }

    /* compiled from: DefaultVoicemailNotifier.java */
    /* loaded from: classes.dex */
    public interface c {
        f b(String str);
    }

    /* compiled from: DefaultVoicemailNotifier.java */
    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f13781a;

        /* renamed from: b, reason: collision with root package name */
        public final Uri f13782b;

        /* renamed from: c, reason: collision with root package name */
        public final String f13783c;

        public d(Uri uri, Uri uri2, String str) {
            this.f13781a = uri;
            this.f13782b = uri2;
            this.f13783c = str;
        }
    }

    /* compiled from: DefaultVoicemailNotifier.java */
    /* loaded from: classes.dex */
    public interface e {
        d[] a();
    }

    /* compiled from: DefaultVoicemailNotifier.java */
    /* loaded from: classes.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public long f13784a;

        /* renamed from: b, reason: collision with root package name */
        public String f13785b;

        public f(long j10, String str) {
            this.f13784a = j10;
            this.f13785b = str;
        }
    }

    public D(Context context, NotificationManager notificationManager, e eVar, c cVar, I i10) {
        this.f13772a = context;
        this.f13773b = notificationManager;
        this.f13774c = eVar;
        this.f13775d = cVar;
        this.f13776e = i10;
    }

    public static c c(ContentResolver contentResolver) {
        return new a(contentResolver);
    }

    public static e d(ContentResolver contentResolver) {
        return new b(contentResolver);
    }

    public static I e(Context context) {
        return new I(context);
    }

    public static synchronized D f(Context context) {
        D d10;
        synchronized (D.class) {
            try {
                if (f13771f == null) {
                    NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                    ContentResolver contentResolver = context.getContentResolver();
                    f13771f = new D(context, notificationManager, d(contentResolver), c(contentResolver), e(context));
                }
                d10 = f13771f;
            } catch (Throwable th) {
                throw th;
            }
        }
        return d10;
    }

    public static int g(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            String trim = Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim();
            if (trim.length() >= 10) {
                trim = trim.substring(trim.length() - 8, trim.length());
            }
            H7.b.b("DefaultVoicemailNotifier", "getNotificationId " + trim);
            return Integer.parseInt(trim);
        } catch (Exception unused) {
            H7.b.c("DefaultVoicemailNotifier", "The error of formating number");
            return 0;
        }
    }

    public void a() {
        try {
            for (StatusBarNotification statusBarNotification : this.f13773b.getActiveNotifications()) {
                String tag = statusBarNotification.getTag();
                if (tag != null && tag.startsWith("DefaultVoicemailNotifier")) {
                    this.f13773b.cancel(tag, statusBarNotification.getId());
                }
            }
        } catch (Exception e10) {
            H7.b.c("DefaultVoicemailNotifier", "clearNotification error " + e10);
        }
    }

    public final PendingIntent b() {
        Intent intent = new Intent(this.f13772a, (Class<?>) CallLogNotificationsService.class);
        intent.setAction("com.android.contacts.calllog.ACTION_MARK_NEW_VOICEMAILS_AS_OLD");
        return PendingIntent.getService(this.f13772a, 0, intent, 67108864);
    }

    public void h(Uri uri) {
        String str;
        d dVar;
        long j10;
        String string;
        Uri uri2;
        d[] a10 = this.f13774c.a();
        if (a10 == null) {
            return;
        }
        if (a10.length == 0) {
            H7.b.c("DefaultVoicemailNotifier", "No voicemails to notify about: clear the notification.");
            a();
            return;
        }
        int length = a10.length;
        int i10 = 0;
        while (true) {
            str = null;
            if (i10 < length) {
                dVar = a10[i10];
                if ((uri != null && uri.equals(dVar.f13782b)) || !((uri2 = dVar.f13782b) == null || uri == null || ContentUris.parseId(uri2) != ContentUris.parseId(uri))) {
                    break;
                } else {
                    i10++;
                }
            } else {
                dVar = null;
                break;
            }
        }
        if (dVar == null) {
            H7.b.c("DefaultVoicemailNotifier", "The new call could not be found in the call log: " + uri);
            return;
        }
        f b10 = this.f13775d.b(dVar.f13783c);
        if (b10 != null) {
            str = b10.f13785b;
        }
        if (b10 == null) {
            j10 = -1;
        } else {
            j10 = b10.f13784a;
        }
        if (str == null) {
            str = this.f13776e.d(dVar.f13783c, "", 0).toString();
            if (TextUtils.isEmpty(str)) {
                str = dVar.f13783c;
            }
        }
        int i11 = 0;
        for (d dVar2 : a10) {
            if (TextUtils.equals(dVar2.f13783c, dVar.f13783c)) {
                i11++;
            }
        }
        if (i11 > 1) {
            string = this.f13772a.getResources().getString(R.string.voicemail_sub_title_other, Integer.valueOf(i11));
        } else {
            string = this.f13772a.getResources().getString(R.string.voicemail_sub_title_one);
        }
        Intent intent = new Intent(this.f13772a, (Class<?>) VoicemailDetailActivity.class);
        intent.putExtra("extra_number", dVar.f13783c);
        intent.putExtra("extra_name", str);
        intent.putExtra("extra_contact_id", j10);
        H7.b.b("DefaultVoicemailNotifier", "number " + H7.a.d(dVar.f13783c) + " contact_id " + j10);
        int g10 = g(dVar.f13783c);
        this.f13773b.notify("DefaultVoicemailNotifier", g10, new Notification.Builder(this.f13772a).setShowWhen(true).setSmallIcon(2131232653).setContentTitle(str).setContentText(string).setStyle(new Notification.BigTextStyle().bigText(string)).setDefaults(-1).setContentIntent(PendingIntent.getActivity(this.f13772a, g10, intent, 201326592)).setDeleteIntent(b()).setAutoCancel(true).setChannelId(s1.f.e(this.f13772a)).build());
    }
}
