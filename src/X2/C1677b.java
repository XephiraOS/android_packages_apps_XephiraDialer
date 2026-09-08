package x2;

import D2.g;
import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.incallui.Log;
import com.android.incallui.OplusAutoRedialNotificationUI;
import com.android.incallui.OplusPhoneUtils;

/* compiled from: OplusMissedCallQuery.java */
/* renamed from: x2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1677b {

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f37871e = {BreenoCallContract.BaseColumns._ID, "number", BreenoCallContract.BaseColumns.DATE, "duration", OplusAutoRedialNotificationUI.TYPE, "ring_time", "simid", "features"};

    /* renamed from: c, reason: collision with root package name */
    public Context f37874c;

    /* renamed from: a, reason: collision with root package name */
    public a f37872a = null;

    /* renamed from: b, reason: collision with root package name */
    public int f37873b = 0;

    /* renamed from: d, reason: collision with root package name */
    public c f37875d = null;

    /* compiled from: OplusMissedCallQuery.java */
    /* renamed from: x2.b$a */
    /* loaded from: classes.dex */
    public class a extends AsyncQueryHandler {
        public a(ContentResolver contentResolver) {
            super(contentResolver);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x003f, code lost:
        
            r7.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x003d, code lost:
        
            if (r7.isClosed() != false) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x009c, code lost:
        
            if (r7.isClosed() == false) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0088, code lost:
        
            r7.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0086, code lost:
        
            if (r7.isClosed() != false) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0053, code lost:
        
            if (r7.isClosed() == false) goto L18;
         */
        @Override // android.content.AsyncQueryHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onQueryComplete(int r5, java.lang.Object r6, android.database.Cursor r7) {
            /*
                r4 = this;
                r0 = -3
                java.lang.String r1 = "Exception: "
                java.lang.String r2 = "OplusMissedCallQuery"
                r3 = 0
                if (r5 == r0) goto L58
                r0 = -1
                if (r5 == r0) goto Ld
                goto L9f
            Ld:
                java.lang.String r5 = "CALL_LOG_TOKEN"
                x2.C1677b.e(r5)
                if (r7 == 0) goto L4d
                if (r6 == 0) goto L4d
                x2.b r4 = x2.C1677b.this     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
                x2.b$c r4 = x2.C1677b.a(r4)     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
                r4.b(r7, r6)     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
                goto L4d
            L20:
                r4 = move-exception
                goto L43
            L22:
                r4 = move-exception
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L20
                r5.<init>()     // Catch: java.lang.Throwable -> L20
                r5.append(r1)     // Catch: java.lang.Throwable -> L20
                java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L20
                r5.append(r4)     // Catch: java.lang.Throwable -> L20
                java.lang.String r4 = r5.toString()     // Catch: java.lang.Throwable -> L20
                com.android.incallui.Log.d(r2, r4)     // Catch: java.lang.Throwable -> L20
                boolean r4 = r7.isClosed()
                if (r4 != 0) goto L56
            L3f:
                r7.close()
                goto L56
            L43:
                boolean r5 = r7.isClosed()
                if (r5 != 0) goto L4c
                r7.close()
            L4c:
                throw r4
            L4d:
                if (r7 == 0) goto L56
                boolean r4 = r7.isClosed()
                if (r4 != 0) goto L56
                goto L3f
            L56:
                r7 = r3
                goto L9f
            L58:
                java.lang.String r5 = "OPLUS_CALL_LOG_TOKEN"
                x2.C1677b.e(r5)
                if (r7 == 0) goto L96
                x2.b r4 = x2.C1677b.this     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
                x2.b$c r4 = x2.C1677b.a(r4)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
                r4.a(r7)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
                goto L96
            L69:
                r4 = move-exception
                goto L8c
            L6b:
                r4 = move-exception
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L69
                r5.<init>()     // Catch: java.lang.Throwable -> L69
                r5.append(r1)     // Catch: java.lang.Throwable -> L69
                java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L69
                r5.append(r4)     // Catch: java.lang.Throwable -> L69
                java.lang.String r4 = r5.toString()     // Catch: java.lang.Throwable -> L69
                com.android.incallui.Log.d(r2, r4)     // Catch: java.lang.Throwable -> L69
                boolean r4 = r7.isClosed()
                if (r4 != 0) goto L56
            L88:
                r7.close()
                goto L56
            L8c:
                boolean r5 = r7.isClosed()
                if (r5 != 0) goto L95
                r7.close()
            L95:
                throw r4
            L96:
                if (r7 == 0) goto L56
                boolean r4 = r7.isClosed()
                if (r4 != 0) goto L56
                goto L88
            L9f:
                if (r7 == 0) goto Laa
                boolean r4 = r7.isClosed()
                if (r4 != 0) goto Laa
                r7.close()
            Laa:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: x2.C1677b.a.onQueryComplete(int, java.lang.Object, android.database.Cursor):void");
        }
    }

    /* compiled from: OplusMissedCallQuery.java */
    /* renamed from: x2.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0378b {

        /* renamed from: a, reason: collision with root package name */
        public String f37877a;

        /* renamed from: b, reason: collision with root package name */
        public String f37878b;

        /* renamed from: c, reason: collision with root package name */
        public String f37879c;

        /* renamed from: d, reason: collision with root package name */
        public long f37880d;

        /* renamed from: e, reason: collision with root package name */
        public int f37881e;

        /* renamed from: f, reason: collision with root package name */
        public long f37882f = -1;

        /* renamed from: g, reason: collision with root package name */
        public int f37883g;

        /* renamed from: h, reason: collision with root package name */
        public int f37884h;

        public C0378b() {
        }
    }

    /* compiled from: OplusMissedCallQuery.java */
    /* renamed from: x2.b$c */
    /* loaded from: classes.dex */
    public interface c {
        void a(Cursor cursor);

        void b(Cursor cursor, Object obj);
    }

    public C1677b(Context context) {
        this.f37874c = context;
    }

    public static void e(String str) {
        Log.d("OplusMissedCallQuery", str);
    }

    public int b() {
        e("getCurrNumberMissedCallCount =" + this.f37873b);
        return this.f37873b;
    }

    public final C0378b c(Cursor cursor) {
        C0378b c0378b = new C0378b();
        c0378b.f37877a = null;
        c0378b.f37878b = cursor.getString(cursor.getColumnIndexOrThrow("number"));
        c0378b.f37879c = cursor.getString(cursor.getColumnIndexOrThrow(OplusAutoRedialNotificationUI.TYPE));
        c0378b.f37880d = cursor.getLong(cursor.getColumnIndexOrThrow(BreenoCallContract.BaseColumns.DATE));
        c0378b.f37881e = cursor.getInt(cursor.getColumnIndexOrThrow("simid"));
        c0378b.f37883g = cursor.getInt(cursor.getColumnIndexOrThrow("features"));
        c0378b.f37884h = SubscriptionManager.getSlotIndex(c0378b.f37881e);
        e("MissCallInfo constructed for number: " + g.l(c0378b.f37878b));
        return c0378b;
    }

    public String d(String str) {
        StringBuilder sb = new StringBuilder("(type=");
        sb.append(3);
        sb.append(" or type=");
        sb.append(10);
        sb.append(") AND new=1");
        if (!TextUtils.isEmpty(str)) {
            sb.append(" AND ");
            sb.append("number");
            sb.append(" = ?");
        }
        return sb.toString();
    }

    public void f(int i10) {
        e("setCurrNumberMissedCallCount =" + this.f37873b);
        this.f37873b = i10;
    }

    public void g(c cVar) {
        this.f37875d = cVar;
        this.f37872a = new a(this.f37874c.getContentResolver());
    }

    public void h(C0378b c0378b) {
        String[] strArr;
        String str;
        e("startCurrNumberMissedCallCountQuery...");
        String str2 = c0378b.f37878b;
        if (str2 == null) {
            str = "(number ='-1' or number ='-2' or number ='-3')";
            strArr = null;
        } else {
            strArr = new String[]{str2};
            str = "number=?";
        }
        String str3 = str + " AND new=1 AND (type=3 or type=10)";
        Uri uri = CallLog.Calls.CONTENT_URI;
        if (!OplusPhoneUtils.isUserUnlocked(this.f37874c)) {
            uri = OplusPhoneUtils.SHADOW_CONTENT_URI;
        }
        this.f37872a.startQuery(-1, c0378b, uri, f37871e, str3.toString(), strArr, "date DESC");
    }

    public void i(String str) {
        String str2;
        String[] strArr;
        Uri parse = Uri.parse("content://call_log/oppo_calls");
        if (!OplusPhoneUtils.isUserUnlocked(this.f37874c)) {
            parse = OplusPhoneUtils.SHADOW_CONTENT_URI;
            str2 = "date DESC";
        } else {
            str2 = "MAX(DATE) DESC";
        }
        Uri uri = parse;
        String str3 = str2;
        e("startOplusMissedCalllogQuery...number = " + g.l(str));
        if (!TextUtils.isEmpty(str)) {
            strArr = new String[]{str};
        } else {
            strArr = null;
        }
        this.f37872a.startQuery(-3, null, uri, f37871e, d(str), strArr, str3);
    }
}
