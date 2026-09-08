package J0;

import J0.o;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.incallui.OplusAutoRedialNotificationUI;
import h1.C1074c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: CallLogNotificationsQueryHelper.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1423a;

    /* renamed from: b, reason: collision with root package name */
    public final c f1424b;

    /* renamed from: c, reason: collision with root package name */
    public final g f1425c;

    /* renamed from: d, reason: collision with root package name */
    public final String f1426d;

    /* compiled from: CallLogNotificationsQueryHelper.java */
    /* loaded from: classes.dex */
    public static final class a implements c {

        /* renamed from: c, reason: collision with root package name */
        public static final String[] f1427c;

        /* renamed from: d, reason: collision with root package name */
        public static final String[] f1428d;

        /* renamed from: a, reason: collision with root package name */
        public final ContentResolver f1429a;

        /* renamed from: b, reason: collision with root package name */
        public final Context f1430b;

        static {
            String[] strArr = {BreenoCallContract.BaseColumns._ID, "number", "voicemail_uri", "presentation", "subscription_component_name", "subscription_id", "transcription", "countryiso", BreenoCallContract.BaseColumns.DATE, "duration", "features"};
            f1427c = strArr;
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(Arrays.asList(strArr));
            arrayList.add("transcription_state");
            f1428d = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }

        @Override // J0.e.c
        public List<b> a(int i10) {
            return c(i10, Long.MAX_VALUE);
        }

        public final b b(Cursor cursor) {
            Uri parse;
            String string = cursor.getString(2);
            Uri withAppendedId = ContentUris.withAppendedId(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, cursor.getLong(0));
            if (string == null) {
                parse = null;
            } else {
                parse = Uri.parse(string);
            }
            return new b(withAppendedId, parse, cursor.getString(1), cursor.getInt(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getLong(8), cursor.getInt(11), cursor.getLong(9), cursor.getInt(10));
        }

        public List<b> c(int i10, long j10) {
            if (androidx.core.content.b.a(this.f1430b, "android.permission.READ_CALL_LOG") != 0) {
                H7.b.i("CallLogNotificationsQueryHelper.DefaultNewCallsQuery.query", "no READ_CALL_LOG permission, returning null for calls lookup.");
                return null;
            }
            o.a a10 = o.d().a(o.e("new").a("= 1")).a(o.e(OplusAutoRedialNotificationUI.TYPE).b("=", Integer.valueOf(i10))).a(o.e("is_read").a("IS NOT 1"));
            if (i10 == 4) {
                a10.a(o.e("deleted").a(" = 0"));
            }
            if (j10 != Long.MAX_VALUE) {
                a10 = a10.a(o.e(BreenoCallContract.BaseColumns.DATE).a("IS NULL").c().d(o.e(BreenoCallContract.BaseColumns.DATE).b(">=", Long.valueOf(j10))).b());
            }
            o b10 = a10.b();
            try {
                Cursor query = this.f1429a.query(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, f1428d, b10.g(), b10.h(), "date DESC");
                if (query == null) {
                    if (query != null) {
                        query.close();
                    }
                    return null;
                }
                try {
                    ArrayList arrayList = new ArrayList();
                    while (query.moveToNext()) {
                        arrayList.add(b(query));
                    }
                    query.close();
                    return arrayList;
                } catch (Throwable th) {
                    try {
                        query.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable unused) {
                H7.b.i("CallLogNotificationsQueryHelper.DefaultNewCallsQuery.query", "exception when querying Contacts Provider for calls lookup");
                return null;
            }
        }

        public a(Context context, ContentResolver contentResolver) {
            this.f1430b = context;
            this.f1429a = contentResolver;
        }
    }

    /* compiled from: CallLogNotificationsQueryHelper.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f1431a;

        /* renamed from: b, reason: collision with root package name */
        public final Uri f1432b;

        /* renamed from: c, reason: collision with root package name */
        public final String f1433c;

        /* renamed from: d, reason: collision with root package name */
        public final int f1434d;

        /* renamed from: e, reason: collision with root package name */
        public final String f1435e;

        /* renamed from: f, reason: collision with root package name */
        public final String f1436f;

        /* renamed from: g, reason: collision with root package name */
        public final String f1437g;

        /* renamed from: h, reason: collision with root package name */
        public final String f1438h;

        /* renamed from: i, reason: collision with root package name */
        public final long f1439i;

        /* renamed from: j, reason: collision with root package name */
        public final int f1440j;

        /* renamed from: k, reason: collision with root package name */
        public final long f1441k;

        /* renamed from: l, reason: collision with root package name */
        public final int f1442l;

        public b(Uri uri, Uri uri2, String str, int i10, String str2, String str3, String str4, String str5, long j10, int i11, long j11, int i12) {
            this.f1431a = uri;
            this.f1432b = uri2;
            this.f1433c = str;
            this.f1434d = i10;
            this.f1435e = str2;
            this.f1436f = str3;
            this.f1437g = str4;
            this.f1438h = str5;
            this.f1439i = j10;
            this.f1440j = i11;
            this.f1441k = j11;
            this.f1442l = i12;
        }
    }

    /* compiled from: CallLogNotificationsQueryHelper.java */
    /* loaded from: classes.dex */
    public interface c {
        List<b> a(int i10);
    }

    public e(Context context, c cVar, g gVar, String str) {
        this.f1423a = context;
        this.f1424b = cVar;
        this.f1425c = gVar;
        this.f1426d = str;
    }

    public static c a(Context context, ContentResolver contentResolver) {
        return new a(context.getApplicationContext(), contentResolver);
    }

    public static e c(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        String b10 = C1074c.b(context);
        return new e(context, a(context, contentResolver), new g(context, b10), b10);
    }

    public static void e(Context context) {
        f(context, null);
    }

    public static void f(Context context, Uri uri) {
        if (!P7.e.d(context)) {
            H7.b.c("CallLogNotificationsQueryHelper.markMissedCallsInCallLogAsRead", "locked");
            return;
        }
        if (androidx.core.content.b.a(context, "android.permission.CALL_PHONE") != 0) {
            H7.b.c("CallLogNotificationsQueryHelper.markMissedCallsInCallLogAsRead", "no phone permission");
            return;
        }
        if (androidx.core.content.b.a(context, "android.permission.WRITE_CALL_LOG") != 0) {
            H7.b.e("CallLogNotifications", "no call log write permission to markMissedCallsInCallLogAsRead!");
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("new", (Integer) 0);
        contentValues.put("is_read", (Integer) 1);
        try {
            ContentResolver contentResolver = context.getContentResolver();
            if (uri == null) {
                uri = CallLog.Calls.CONTENT_URI;
            }
            contentResolver.update(uri, contentValues, "new = 1 AND " + OplusAutoRedialNotificationUI.TYPE + " = ?", new String[]{Integer.toString(3)});
        } catch (Throwable th) {
            H7.b.c("CallLogNotificationsQueryHelper.markMissedCallsInCallLogAsRead", "contacts provider update command failed = " + th);
        }
    }

    public static void g(Context context, Uri uri) {
        if (uri == null) {
            H7.b.c("CallLogNotificationsQueryHelper.markSingleMissedCallInCallLogAsRead", "call URI is null, unable to mark call as read");
        } else {
            f(context, uri);
        }
    }

    public f b(String str, int i10, String str2) {
        if (str2 == null) {
            str2 = this.f1426d;
        }
        String str3 = str2;
        if (str == null) {
            str = "";
        }
        f fVar = new f();
        fVar.f1449f = str;
        fVar.f1450g = PhoneNumberUtils.formatNumber(str, str3);
        fVar.f1451h = PhoneNumberUtils.formatNumberToE164(str, str3);
        f e10 = this.f1425c.e(str, str3, "", -1L);
        if (e10 != null && !TextUtils.isEmpty(e10.f1446c)) {
            return e10;
        }
        if (!TextUtils.isEmpty(fVar.f1450g)) {
            fVar.f1446c = fVar.f1450g;
        } else if (!TextUtils.isEmpty(str)) {
            fVar.f1446c = str;
        } else {
            fVar.f1446c = this.f1423a.getResources().getString(H0.d.f1223k);
        }
        return fVar;
    }

    public List<b> d() {
        return this.f1424b.a(3);
    }
}
