package x2;

import A2.A;
import A2.j;
import D2.f;
import D2.g;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.android.incallui.ContactInfoCache;
import com.android.incallui.Log;
import com.android.incallui.OplusPhoneUtils;
import java.util.ArrayList;
import java.util.List;
import x2.C1677b;

/* compiled from: OplusMissedCallMessagesMgr.java */
/* renamed from: x2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1676a {

    /* renamed from: g, reason: collision with root package name */
    public static final List<Integer> f37850g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public static C1676a f37851h;

    /* renamed from: a, reason: collision with root package name */
    public b f37852a;

    /* renamed from: b, reason: collision with root package name */
    public Context f37853b;

    /* renamed from: c, reason: collision with root package name */
    public C1677b f37854c;

    /* renamed from: d, reason: collision with root package name */
    public String f37855d;

    /* renamed from: e, reason: collision with root package name */
    public c f37856e;

    /* renamed from: f, reason: collision with root package name */
    public C0376a f37857f = new C0376a();

    /* compiled from: OplusMissedCallMessagesMgr.java */
    /* renamed from: x2.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0376a {

        /* renamed from: a, reason: collision with root package name */
        public String f37858a;

        /* renamed from: b, reason: collision with root package name */
        public String f37859b;

        /* renamed from: c, reason: collision with root package name */
        public String f37860c;

        /* renamed from: d, reason: collision with root package name */
        public long f37861d;

        /* renamed from: e, reason: collision with root package name */
        public long f37862e = -1;

        /* renamed from: f, reason: collision with root package name */
        public int f37863f;

        /* renamed from: g, reason: collision with root package name */
        public int f37864g;

        public C0376a() {
        }
    }

    /* compiled from: OplusMissedCallMessagesMgr.java */
    /* renamed from: x2.a$b */
    /* loaded from: classes.dex */
    public class b implements C1677b.c {

        /* compiled from: OplusMissedCallMessagesMgr.java */
        /* renamed from: x2.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0377a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f37867a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f37868b;

            public RunnableC0377a(String str, int i10) {
                this.f37867a = str;
                this.f37868b = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.android.incallui.oplus.third.a.a() != null) {
                        com.android.incallui.oplus.third.a.a().e(C1676a.this.f37853b, OplusPhoneUtils.filterSpecialCharacters(this.f37867a), this.f37867a, 2, C1676a.this.f37856e, this.f37868b);
                    }
                } catch (Exception e10) {
                    Log.d("OplusMissedCallMessagesMgr", "Exception: " + e10.toString());
                }
            }
        }

        public b() {
        }

        @Override // x2.C1677b.c
        public void a(Cursor cursor) {
            if (cursor != null && cursor.moveToFirst()) {
                C1676a.this.f37854c.h(C1676a.this.f37854c.c(cursor));
            } else {
                j.J().v();
            }
        }

        @Override // x2.C1677b.c
        public void b(Cursor cursor, Object obj) {
            String str;
            if (cursor != null && obj != null) {
                C1677b.C0378b c0378b = (C1677b.C0378b) obj;
                if (cursor.moveToFirst()) {
                    C1676a.this.f37854c.f(cursor.getCount());
                    C1676a.this.f37855d = null;
                    String str2 = c0378b.f37878b;
                    if (str2 != null && !str2.equals(OplusPhoneUtils.DeviceState.INVALID_STATUS)) {
                        j J10 = j.J();
                        ContactInfoCache.ContactCacheEntry E10 = J10.E(c0378b.f37878b);
                        if (E10 == null) {
                            E10 = J10.G(c0378b.f37878b);
                        }
                        if (E10 != null) {
                            c0378b.f37877a = E10.name;
                            C1676a c1676a = C1676a.this;
                            if (!E10.isWhiteListNumber && !TextUtils.isEmpty(E10.yellowPageInfo.f96d)) {
                                str = E10.yellowPageInfo.f96d;
                            } else {
                                str = E10.yellowPageInfo.f97e;
                            }
                            c1676a.f37855d = str;
                        }
                    }
                    Log.d("OplusMissedCallMessagesMgr", " missCallInfo name " + g.o(c0378b.f37877a));
                    c(c0378b);
                }
            }
            j.J().v();
        }

        public void c(C1677b.C0378b c0378b) {
            int b10 = C1676a.this.f37854c.b();
            Log.d("OplusMissedCallMessagesMgr", "onQueryFinalComplete", "the missCallInfo.number is " + g.l(c0378b.f37878b) + " the missCallInfo.name is " + g.o(c0378b.f37877a));
            C1676a.this.f37857f.f37858a = c0378b.f37877a;
            C1676a.this.f37857f.f37859b = c0378b.f37878b;
            C1676a.this.f37857f.f37860c = c0378b.f37879c;
            C1676a.this.f37857f.f37861d = c0378b.f37880d;
            C1676a.this.f37857f.f37862e = c0378b.f37882f;
            C1676a.this.f37857f.f37863f = b10;
            C0376a c0376a = C1676a.this.f37857f;
            int i10 = c0378b.f37883g;
            c0376a.f37864g = i10;
            C1676a c1676a = C1676a.this;
            c1676a.i(c0378b.f37877a, c0378b.f37878b, c0378b.f37880d, c0378b.f37882f, i10, b10, c1676a.f37855d);
            String str = c0378b.f37878b;
            String str2 = c0378b.f37877a;
            int i11 = c0378b.f37884h;
            if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(C1676a.this.f37855d)) {
                C2.b.a().execute(new RunnableC0377a(str, i11));
            }
        }
    }

    /* compiled from: OplusMissedCallMessagesMgr.java */
    /* renamed from: x2.a$c */
    /* loaded from: classes.dex */
    public class c implements A.a {
        public c() {
        }

        @Override // A2.A.a
        public void a(A a10) {
            String str;
            String str2;
            int notificationId = OplusPhoneUtils.getNotificationId(C1676a.this.f37857f.f37859b);
            List<Integer> list = C1676a.f37850g;
            if (list != null && !list.contains(Integer.valueOf(notificationId))) {
                Log.d("OplusMissedCallMessagesMgr", "The notification has been canceled.Do not refresh!");
                return;
            }
            if (f.w(C1676a.this.f37853b, a10)) {
                Log.d("OplusMissedCallMessagesMgr", "BlockedByMark type has been canceled.Do not refresh!");
                return;
            }
            String str3 = a10.f95c;
            ContactInfoCache.ContactCacheEntry E10 = j.J().E(a10.f94b);
            if (E10 == null) {
                E10 = j.J().G(a10.f94b);
            }
            if (E10 != null && !E10.isWhiteListNumber && !TextUtils.isEmpty(a10.f96d)) {
                str = a10.f96d;
            } else {
                str = a10.f97e;
            }
            Log.d("OplusMissedCallMessagesMgr", "name is " + g.o(str3) + "markInfo is " + str);
            if (str3 != null || str == null) {
                str2 = null;
            } else {
                str2 = str;
            }
            C1676a.this.f37857f.f37858a = str3;
            C1676a c1676a = C1676a.this;
            c1676a.i(c1676a.f37857f.f37858a, C1676a.this.f37857f.f37859b, C1676a.this.f37857f.f37861d, C1676a.this.f37857f.f37862e, C1676a.this.f37857f.f37864g, C1676a.this.f37857f.f37863f, str2);
        }
    }

    public static synchronized C1676a g() {
        C1676a c1676a;
        synchronized (C1676a.class) {
            try {
                if (f37851h == null) {
                    f37851h = new C1676a();
                }
                c1676a = f37851h;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c1676a;
    }

    public void h(Context context) {
        if (this.f37853b != null) {
            return;
        }
        this.f37853b = context;
        this.f37856e = new c();
        this.f37852a = new b();
        C1677b c1677b = new C1677b(context);
        this.f37854c = c1677b;
        c1677b.g(this.f37852a);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0171  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i(java.lang.String r13, java.lang.String r14, long r15, long r17, int r19, int r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.C1676a.i(java.lang.String, java.lang.String, long, long, int, int, java.lang.String):void");
    }

    public void j(String str) {
        C1677b c1677b = this.f37854c;
        if (c1677b != null) {
            c1677b.i(str);
        }
    }
}
