package com.oplus.blacklistapp.callintercept.policy;

import android.content.AsyncQueryHandler;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Log;
import c7.C0566b;
import com.oplus.blacklistapp.l;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0848i;
import java.util.Arrays;
import s6.C1552a;
import v6.C1627a;

/* loaded from: classes3.dex */
public class CallerInfoAsyncQuery {

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f26601b = C1627a.f37411c;

    /* renamed from: a, reason: collision with root package name */
    public a f26602a;

    /* loaded from: classes3.dex */
    public static class QueryPoolException extends SQLException {
        public QueryPoolException(String str) {
            super(str);
        }
    }

    /* loaded from: classes3.dex */
    public class a extends AsyncQueryHandler {

        /* renamed from: a, reason: collision with root package name */
        public Context f26603a;

        /* renamed from: b, reason: collision with root package name */
        public Uri f26604b;

        /* renamed from: c, reason: collision with root package name */
        public C1552a f26605c;

        /* renamed from: com.oplus.blacklistapp.callintercept.policy.CallerInfoAsyncQuery$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0238a extends AsyncQueryHandler.WorkerHandler {
            public C0238a(Looper looper) {
                super(a.this, looper);
            }

            @Override // android.content.AsyncQueryHandler.WorkerHandler, android.os.Handler
            public void handleMessage(Message message) {
                AsyncQueryHandler.WorkerArgs workerArgs = (AsyncQueryHandler.WorkerArgs) message.obj;
                b bVar = (b) workerArgs.cookie;
                if (bVar == null) {
                    C1627a.a(this, "Unexpected command (CookieWrapper is null): " + message.what + " ignored by CallerInfoWorkerHandler, passing onto parent.");
                    super.handleMessage(message);
                    return;
                }
                C1627a.a(this, "Processing event: " + bVar.f26610c + " token (arg1): " + message.arg1 + " command: " + message.what + " query URI: " + CallerInfoAsyncQuery.f(workerArgs.uri));
                int i10 = bVar.f26610c;
                if (i10 != 1) {
                    if (i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5) {
                        Message obtainMessage = workerArgs.handler.obtainMessage(message.what);
                        obtainMessage.obj = workerArgs;
                        obtainMessage.arg1 = message.arg1;
                        obtainMessage.sendToTarget();
                        return;
                    }
                    return;
                }
                super.handleMessage(message);
            }
        }

        @Override // android.content.AsyncQueryHandler
        public Handler createHandler(Looper looper) {
            return new C0238a(looper);
        }

        @Override // android.content.AsyncQueryHandler
        public void onQueryComplete(int i10, Object obj, Cursor cursor) {
            b bVar;
            Uri uri;
            try {
                try {
                    C1627a.m("CallerInfoAsyncQuery", "##### onQueryComplete() #####   query complete for token: " + i10 + "  cookie = " + obj);
                    bVar = (b) obj;
                } catch (Exception e10) {
                    Log.e("CallerInfoAsyncQuery", "e = " + e10);
                    if (cursor == null || cursor.isClosed()) {
                        return;
                    }
                }
                if (bVar == null) {
                    C1627a.a(this, "Cookie is null, ignoring onQueryComplete() request.");
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                        return;
                    }
                    return;
                }
                int i11 = bVar.f26610c;
                if (i11 == 3) {
                    CallerInfoAsyncQuery.this.e();
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                        return;
                    }
                    return;
                }
                if (this.f26605c == null) {
                    Context context = this.f26603a;
                    if (context != null && (uri = this.f26604b) != null) {
                        if (i11 == 4) {
                            if (!context.getResources().getBoolean(l.f27272b) && !"cmcc".equals(C0566b.a("persist.carrier.mode"))) {
                                C1627a.a(this, "Emergency Number and Mark Emergency Number disabled");
                                this.f26605c = new C1552a().g(this.f26603a);
                            }
                            C1627a.a(this, "Emergency Number and Mark Emergency Number enabled");
                            this.f26605c = new C1552a().h(this.f26603a, bVar.f26611d);
                        } else if (i11 == 5) {
                            this.f26605c = new C1552a().i(this.f26603a);
                        } else {
                            this.f26605c = C1552a.c(context, uri, cursor);
                            C1627a.a(this, "==> Got mCallerInfo: " + this.f26605c);
                            C1552a a10 = C1552a.a(this.f26603a, bVar.f26611d, this.f26605c);
                            if (a10 != this.f26605c) {
                                this.f26605c = a10;
                                C1627a.a(this, "#####async contact look up with numeric username" + this.f26605c);
                            }
                            if (l7.b.f34737e && TextUtils.isEmpty(this.f26605c.f36837a)) {
                                this.f26605c.k(this.f26603a, bVar.f26611d);
                            }
                            if (!TextUtils.isEmpty(bVar.f26611d)) {
                                C1552a c1552a = this.f26605c;
                                c1552a.f36838b = PhoneNumberUtils.formatNumber(bVar.f26611d, c1552a.f36839c, I6.a.b(this.f26603a).a());
                            }
                        }
                        C1627a.a(this, "constructing CallerInfo object for token: " + i10);
                        b bVar2 = new b();
                        bVar2.f26610c = 3;
                        startQuery(i10, bVar2, null, null, null, null, null);
                    } else {
                        throw new QueryPoolException("Bad context or query uri, or CallerInfoAsyncQuery already released.");
                    }
                }
                if (bVar.f26608a != null) {
                    C1627a.a(this, "notifying listener: " + bVar.f26608a.getClass().toString() + " for token: " + i10);
                    if (this.f26605c != null) {
                        C1627a.m("CallerInfoAsyncQuery", "notifying personId = " + this.f26605c.f36853q);
                    }
                    bVar.f26608a.a(i10, bVar.f26609b, this.f26605c);
                }
                if (cursor == null || cursor.isClosed()) {
                    return;
                }
                cursor.close();
            } catch (Throwable th) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                throw th;
            }
        }

        @Override // android.content.AsyncQueryHandler
        public void startQuery(int i10, Object obj, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
            if (CallerInfoAsyncQuery.f26601b) {
                Log.d("CallerInfoAsyncQuery", "InCall: startQuery: url=" + C0846g.h(uri) + " projection=[" + Arrays.toString(strArr) + "] selection=" + C0846g.g(str));
            }
            C1627a.m("CallerInfoAsyncQuery", "start query contact info");
            super.startQuery(i10, obj, uri, strArr, str, strArr2, str2);
        }

        public a(Context context) {
            super(context.getContentResolver());
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public c f26608a;

        /* renamed from: b, reason: collision with root package name */
        public Object f26609b;

        /* renamed from: c, reason: collision with root package name */
        public int f26610c;

        /* renamed from: d, reason: collision with root package name */
        public String f26611d;

        public b() {
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(int i10, Object obj, C1552a c1552a);
    }

    public static String f(Uri uri) {
        if (uri != null) {
            String uri2 = uri.toString();
            int lastIndexOf = uri2.lastIndexOf(47);
            if (lastIndexOf > 0) {
                return uri2.substring(0, lastIndexOf) + "/xxxxxxx";
            }
            return uri2;
        }
        return "";
    }

    public static CallerInfoAsyncQuery g(int i10, Context context, C1552a c1552a, c cVar, Object obj) {
        Uri build;
        boolean z10 = f26601b;
        if (z10) {
            C1627a.c("CallerInfoAsyncQuery", "##### CallerInfoAsyncQuery startQuery()... #####");
            C1627a.c("CallerInfoAsyncQuery", "- number: " + C0846g.f(c1552a.f36838b));
            if (obj != null && C0846g.e(obj.toString())) {
                C1627a.c("CallerInfoAsyncQuery", "- cookie: " + C0846g.f(obj.toString()));
            } else {
                C1627a.c("CallerInfoAsyncQuery", "- cookie: " + obj);
            }
        }
        if (z10) {
            C1627a.c("CallerInfoAsyncQuery", "==> info.contactRefUri: " + C0846g.h(c1552a.f36856t));
        }
        Uri uri = c1552a.f36856t;
        if (uri != null) {
            build = uri.buildUpon().appendQueryParameter("query_vip", "true").build();
        } else {
            build = C0848i.i(context, c1552a.f36838b).buildUpon().appendQueryParameter("query_vip", "true").build();
        }
        Uri uri2 = build;
        if (z10) {
            C1627a.c("CallerInfoAsyncQuery", "==> contactRef: " + f(uri2));
        }
        CallerInfoAsyncQuery callerInfoAsyncQuery = new CallerInfoAsyncQuery();
        if (context == null) {
            return callerInfoAsyncQuery;
        }
        callerInfoAsyncQuery.d(context, uri2);
        b bVar = new b();
        bVar.f26608a = cVar;
        bVar.f26609b = obj;
        bVar.f26611d = c1552a.f36838b;
        if (c1552a.f()) {
            bVar.f26610c = 5;
        } else {
            bVar.f26610c = 1;
        }
        callerInfoAsyncQuery.f26602a.startQuery(i10, bVar, uri2, null, null, null, null);
        return callerInfoAsyncQuery;
    }

    public final void d(Context context, Uri uri) {
        if (context != null && uri != null) {
            a aVar = new a(context);
            this.f26602a = aVar;
            aVar.f26603a = context;
            this.f26602a.f26604b = uri;
            return;
        }
        C1627a.h("CallerInfoAsyncQuery", "Bad context or query uri.");
    }

    public final void e() {
        this.f26602a.f26603a = null;
        this.f26602a.f26604b = null;
        this.f26602a.f26605c = null;
        this.f26602a = null;
    }
}
