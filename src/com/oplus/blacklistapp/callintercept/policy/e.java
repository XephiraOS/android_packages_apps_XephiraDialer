package com.oplus.blacklistapp.callintercept.policy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.android.contacts.framework.virtualsupport.utils.GrpcUtils;
import com.oplus.blacklistapp.callintercept.policy.CallerInfoAsyncQuery;
import com.oplus.blacklistapp.callintercept.policy.a;
import com.oplus.blacklistapp.callintercept.policy.b;
import com.oplus.blacklistapp.callintercept.policy.c;
import com.oplus.blacklistapp.callintercept.policy.f;
import com.oplus.utils.C0846g;
import java.util.HashMap;
import s6.C1552a;
import v6.C1627a;
import v6.C1632f;

/* compiled from: NumberInfoManager.java */
/* loaded from: classes3.dex */
public class e extends com.oplus.blacklistapp.callintercept.policy.c implements b.InterfaceC0240b {

    /* renamed from: f, reason: collision with root package name */
    public Context f26709f;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<String, a.C0239a> f26706c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap<String, a.C0239a> f26707d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    public boolean f26708e = false;

    /* renamed from: g, reason: collision with root package name */
    public d f26710g = new d();

    /* renamed from: h, reason: collision with root package name */
    public Handler f26711h = new a();

    /* compiled from: NumberInfoManager.java */
    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1000:
                    if (C1627a.f37411c) {
                        C1627a.e("NumberInfoManager", "MSG_START_EARLY_QUERY_INFO message received...");
                    }
                    e.this.B((String) message.obj);
                    return;
                case 1001:
                    f fVar = (f) message.obj;
                    a.C0239a c0239a = (a.C0239a) e.this.f26706c.get(fVar.f26718a);
                    if (c0239a == null) {
                        return;
                    }
                    c0239a.f26644u = 4;
                    if (!TextUtils.isEmpty(fVar.f26720c)) {
                        c0239a.f26626c = fVar.f26720c;
                        e.this.d(fVar.f26718a, c0239a, 4, false);
                        return;
                    }
                    return;
                case 1002:
                    e.this.o();
                    return;
                case 1003:
                    String str = (String) message.obj;
                    a.C0239a c0239a2 = (a.C0239a) e.this.f26706c.get(str);
                    C1627a.c("NumberInfoManager", "MSM_QUERY_CALL_LOG_COMPLETE entryInfo = " + c0239a2);
                    if (c0239a2 == null) {
                        return;
                    }
                    c0239a2.f26646w = 5;
                    e.this.d(str, c0239a2, 5, false);
                    return;
                case 1004:
                default:
                    return;
                case 1005:
                    String str2 = (String) message.obj;
                    a.C0239a c0239a3 = (a.C0239a) e.this.f26706c.get(str2);
                    if (c0239a3 == null) {
                        C1627a.c("NumberInfoManager", "MSG_QUERY_LOCATION_COMPLETE cacheEntryForRecord is null");
                        return;
                    }
                    C1627a.c("NumberInfoManager", "MSG_QUERY_LOCATION_COMPLETE cacheEntryForRecord = " + c0239a3.f26649z);
                    c0239a3.f26617A = 6;
                    e.this.d(str2, c0239a3, 6, false);
                    return;
            }
        }
    }

    /* compiled from: NumberInfoManager.java */
    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f26713a;

        public b(String str) {
            this.f26713a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            if (C1627a.f37411c) {
                C1627a.e("NumberInfoManager", "getLocationByNumber begin... ");
            }
            C1632f.c Y9 = C1632f.Y(this.f26713a, e.this.f26709f);
            if (Y9 != null) {
                str = Y9.f37482a;
            } else {
                str = null;
            }
            Message obtain = Message.obtain(e.this.f26711h, 1001);
            f fVar = new f();
            fVar.f26718a = this.f26713a;
            fVar.f26720c = str;
            obtain.obj = fVar;
            e.this.f26711h.sendMessage(obtain);
        }
    }

    /* compiled from: NumberInfoManager.java */
    /* loaded from: classes3.dex */
    public class c implements CallerInfoAsyncQuery.c {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f26715a;

        public c(boolean z10) {
            this.f26715a = z10;
        }

        @Override // com.oplus.blacklistapp.callintercept.policy.CallerInfoAsyncQuery.c
        public void a(int i10, Object obj, C1552a c1552a) {
            if (c1552a != null && obj != null) {
                String str = (String) obj;
                a.C0239a c0239a = (a.C0239a) e.this.f26706c.get(str);
                if (c0239a == null) {
                    C1627a.c("NumberInfoManager", "onQueryComplete  cacheEntry not find return");
                    return;
                }
                e eVar = e.this;
                eVar.l(eVar.f26709f, c0239a, "query", c1552a, 1, false);
                c0239a.f26639p = 2;
                if (C1627a.f37411c) {
                    C1627a.c("NumberInfoManager", "onQueryComplete build entry complete  cacheEntry = " + c0239a);
                }
                if (c0239a.f26631h != null && c0239a.f26628e == null) {
                    if (C1627a.f37411c) {
                        C1627a.e("NumberInfoManager", "Contact lookup. Local contact found, starting image load");
                    }
                    e.this.d(str, c0239a, 2, true);
                    com.oplus.blacklistapp.callintercept.policy.b.b(0, e.this.f26709f, c1552a.f36857u, e.this, obj);
                    return;
                }
                if (C1627a.f37411c) {
                    C1627a.e("NumberInfoManager", "Contact lookup. Local contact photo not found, query down!");
                }
                c0239a.f26639p = 3;
                e.this.d(str, c0239a, 3, true);
                return;
            }
            if (C1627a.f37411c) {
                C1627a.c("NumberInfoManager", "onQueryComplete callerInfo or cookie is null");
            }
        }
    }

    /* compiled from: NumberInfoManager.java */
    /* loaded from: classes3.dex */
    public class d implements f.a {
        public d() {
        }

        @Override // com.oplus.blacklistapp.callintercept.policy.f.a
        public void a(f fVar) {
            if (fVar == null) {
                C1627a.m("NumberInfoManager", "yellowPageComplete info is null");
                return;
            }
            a.C0239a c0239a = (a.C0239a) e.this.f26706c.get(fVar.f26718a);
            if (C1627a.f37411c) {
                C1627a.c("NumberInfoManager", "onQueryYellowPageComplete number = " + C0846g.f(fVar.f26718a));
            }
            if (c0239a == null) {
                C1627a.m("NumberInfoManager", "yellowPageComplete can not find info in cache return ");
                return;
            }
            e.r(c0239a.f26640q, fVar);
            if (fVar.f26726i == 3) {
                c0239a.f26641r = 3;
            } else {
                c0239a.f26641r = 2;
            }
            e.this.d(fVar.f26718a, c0239a, c0239a.f26641r, false);
        }
    }

    public e(Context context) {
        this.f26709f = context;
    }

    public static void p(a.C0239a c0239a, a.C0239a c0239a2, boolean z10) {
        f fVar;
        String str;
        if (C1627a.f37411c) {
            C1627a.c("NumberInfoManager", "copycontactCacheEntry  src = " + c0239a);
        }
        String str2 = c0239a.f26624a;
        if (str2 != null) {
            c0239a2.f26624a = str2;
        }
        long j10 = c0239a.f26638o;
        if (j10 != -1) {
            c0239a2.f26638o = j10;
            c0239a2.f26620D = c0239a.f26620D;
            c0239a2.f26648y = false;
            c0239a2.f26621E = c0239a.f26621E;
        }
        Uri uri = c0239a.f26630g;
        if (uri != null) {
            c0239a2.f26630g = uri;
        }
        String str3 = c0239a.f26618B;
        if (str3 != null) {
            c0239a2.f26618B = str3;
        }
        String str4 = c0239a.f26619C;
        if (str4 != null) {
            c0239a2.f26619C = str4;
        }
        String str5 = c0239a.f26626c;
        if (str5 != null) {
            c0239a2.f26626c = str5;
        }
        Drawable drawable = c0239a.f26628e;
        if (drawable != null) {
            c0239a2.f26628e = drawable;
        }
        long j11 = c0239a.f26645v;
        if (j11 != 0) {
            c0239a2.f26645v = j11;
        }
        if (z10 && TextUtils.isEmpty(c0239a2.f26624a) && (str = (fVar = c0239a.f26640q).f26720c) != null) {
            c0239a2.f26624a = str;
            c0239a2.f26628e = fVar.f26725h;
        }
        c0239a2.f26649z = c0239a.f26649z;
        r(c0239a2.f26640q, c0239a.f26640q);
        c0239a2.f26622F = c0239a.f26622F;
        c0239a2.f26623G = c0239a.f26623G;
        c0239a2.f26639p = c0239a.f26639p;
        if (C1627a.f37411c) {
            C1627a.c("NumberInfoManager", "copycontactCacheEntry copy down  dest = " + c0239a2);
        }
    }

    public static void q(a.C0239a c0239a, a.C0239a c0239a2) {
        c0239a.f26639p = c0239a2.f26639p;
        c0239a.f26641r = c0239a2.f26641r;
        c0239a.f26644u = c0239a2.f26644u;
        c0239a.f26646w = c0239a2.f26646w;
        c0239a.f26617A = c0239a2.f26617A;
    }

    public static void r(f fVar, f fVar2) {
        if (fVar != null && fVar2 != null) {
            fVar.f26728k = fVar2.f26728k;
            fVar.f26721d = fVar2.f26721d;
            fVar.f26722e = fVar2.f26722e;
            fVar.f26723f = fVar2.f26723f;
            fVar.f26724g = fVar2.f26724g;
            fVar.f26720c = fVar2.f26720c;
            fVar.f26725h = fVar2.f26725h;
        }
    }

    public void A() {
        if (this.f26711h.hasMessages(1002)) {
            this.f26711h.removeMessages(1002);
        }
    }

    public void B(String str) {
        int indexOf;
        String str2;
        if (str != null) {
            Uri uri = null;
            if (str.startsWith("(") && (indexOf = str.indexOf(41)) > 1) {
                String substring = str.substring(1, indexOf);
                int i10 = indexOf + 1;
                if (str.length() > i10) {
                    str2 = str.substring(i10);
                } else {
                    str2 = null;
                }
                if (str2 != null) {
                    uri = Uri.parse(str2);
                }
                str = substring;
            }
            if (str != null) {
                C(str, uri, "JUST_QUERY_OUTGOING", false);
            }
            y();
            this.f26711h.sendEmptyMessageDelayed(1004, GrpcUtils.CREATE_CHANNEL_TIME_OUT);
            if (C1627a.f37411c) {
                C1627a.e("NumberInfoManager", "startEarlyQueryContactInfo end  mNumber = " + C0846g.f(str) + "  mContactUri = " + C0846g.h(uri));
            }
        }
    }

    public void C(String str, Uri uri, String str2, boolean z10) {
        A();
        if (x(str)) {
            if (C1627a.f37411c) {
                C1627a.e("NumberInfoManager", "startQueryContactInfoAndYellowPage number = " + C0846g.f(str) + "  info is in map return...");
                return;
            }
            return;
        }
        C1627a.m("NumberInfoManager", "# # # # # #begin a new query# # # # # # number = " + C0846g.f(str) + "  contactUri = " + C0846g.h(uri) + " callId = " + str2 + " isIncoming = " + z10);
        C1552a c1552a = new C1552a();
        c1552a.f36838b = str;
        c1552a.f36856t = uri;
        a.C0239a a10 = com.oplus.blacklistapp.callintercept.policy.a.c(this.f26709f).a(this.f26709f, str2, c1552a, 1, z10);
        this.f26706c.put(str, a10);
        int i10 = 1;
        a10.f26639p = 1;
        CallerInfoAsyncQuery.g(-1, this.f26709f, c1552a, new c(false), str);
        a10.f26641r = 1;
        h d10 = h.d();
        Context context = this.f26709f;
        if (!z10) {
            i10 = 2;
        }
        d10.f(context, str, i10, a10.f26636m);
        if (z10) {
            C1632f.i0(this.f26709f, str, a10, this.f26711h);
        }
        v(str, a10, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.oplus.blacklistapp.callintercept.policy.a.C0239a l(android.content.Context r5, com.oplus.blacklistapp.callintercept.policy.a.C0239a r6, java.lang.String r7, s6.C1552a r8, int r9, boolean r10) {
        /*
            r4 = this;
            com.oplus.blacklistapp.callintercept.policy.a.e(r5, r8, r6, r9, r10)
            int r4 = r8.f36852p
            r9 = 0
            if (r4 == 0) goto Ld
            android.graphics.drawable.Drawable r4 = r5.getDrawable(r4)
            goto L1d
        Ld:
            boolean r4 = r8.f36861y
            if (r4 == 0) goto L16
            android.graphics.drawable.Drawable r4 = r8.f36860x
            if (r4 == 0) goto L16
            goto L1d
        L16:
            android.net.Uri r4 = r8.f36857u
            if (r4 == 0) goto L1c
            r6.f26631h = r4
        L1c:
            r4 = r9
        L1d:
            java.lang.String r5 = r8.f36854r
            r0 = 0
            if (r5 == 0) goto L31
            long r2 = r8.f36853q
            int r10 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r10 != 0) goto L2a
            goto L31
        L2a:
            android.net.Uri r5 = android.provider.ContactsContract.Contacts.getLookupUri(r2, r5)
            r6.f26632i = r5
            goto L3a
        L31:
            java.lang.String r5 = "NumberInfoManager"
            java.lang.String r10 = "lookup key is null or contact ID is 0. Don't create a lookup uri."
            v6.C1627a.o(r5, r10)
            r6.f26632i = r9
        L3a:
            r6.f26628e = r4
            java.lang.String r4 = r8.f36854r
            r6.f26633j = r4
            boolean r4 = r8.f36845i
            if (r4 == 0) goto L57
            long r4 = r8.f36853q
            r6.f26638o = r4
            boolean r4 = r8.f36836B
            if (r4 == 0) goto L4e
            r0 = 1
        L4e:
            r6.f26620D = r0
            boolean r4 = r8.f36848l
            r6.f26621E = r4
            r4 = 0
            r6.f26648y = r4
        L57:
            r6.f26635l = r7
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.blacklistapp.callintercept.policy.e.l(android.content.Context, com.oplus.blacklistapp.callintercept.policy.a$a, java.lang.String, s6.a, int, boolean):com.oplus.blacklistapp.callintercept.policy.a$a");
    }

    public final boolean m(a.C0239a c0239a) {
        boolean z10 = true;
        if ((c0239a == null || c0239a.f26639p != 3 || c0239a.f26641r != 3 || c0239a.f26644u != 4) && (c0239a == null || c0239a.f26639p != 3 || c0239a.f26638o == -1 || c0239a.f26644u != 4)) {
            z10 = false;
        }
        if (C1627a.f37411c) {
            C1627a.c("NumberInfoManager", "checkQueryComplete  isComplete = " + z10);
        }
        return z10;
    }

    public void n() {
        HashMap<String, a.C0239a> hashMap = this.f26707d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public void o() {
        String str;
        if (C1627a.f37411c) {
            C1627a.e("NumberInfoManager", "clearResource...");
        }
        b();
        n();
        for (String str2 : this.f26706c.keySet()) {
            if (!TextUtils.isEmpty(str2) && str2.contains(" ")) {
                str = str2.replace(" ", "");
            } else {
                str = str2;
            }
            if (!TextUtils.isEmpty(str) && str.contains("-")) {
                str = str.replace("-", "");
            }
            this.f26707d.put(str, this.f26706c.get(str2));
        }
        this.f26706c.clear();
        h.d().c();
    }

    @Override // com.oplus.blacklistapp.callintercept.policy.b.InterfaceC0240b
    public void onImageLoadComplete(int i10, Drawable drawable, Bitmap bitmap, Object obj) {
        if (C1627a.f37411c) {
            C1627a.m("NumberInfoManager", " token = " + i10 + " photo =  photoIcon = " + bitmap);
        }
        String str = (String) obj;
        a.C0239a c0239a = this.f26706c.get(str);
        if (c0239a == null) {
            C1627a.g(this, "Image Load received for empty search entry.");
            return;
        }
        c0239a.f26639p = 3;
        if (C1627a.f37411c) {
            C1627a.b(this, "setting photo for entry: ", c0239a);
        }
        if (c0239a.f26628e != null) {
            C1627a.a(this, "already has photo so return!!! ");
            return;
        }
        if (drawable != null) {
            C1627a.p(this, "direct drawable: ", drawable);
            c0239a.f26628e = drawable;
        } else if (bitmap != null) {
            C1627a.p(this, "photo icon: ", bitmap);
            c0239a.f26628e = new BitmapDrawable(this.f26709f.getResources(), bitmap);
        } else {
            C1627a.o(this, "unknown photo");
            c0239a.f26628e = null;
        }
        d(str, c0239a, 3, true);
    }

    public a.C0239a s(String str) {
        String str2;
        if (str == null) {
            return null;
        }
        if (str.contains(" ")) {
            str = str.replace(" ", "");
        }
        if (str.contains("-")) {
            str = str.replace("-", "");
        }
        HashMap hashMap = new HashMap();
        for (String str3 : this.f26706c.keySet()) {
            if (!TextUtils.isEmpty(str3) && str3.contains(" ")) {
                str2 = str3.replace(" ", "");
            } else {
                str2 = str3;
            }
            if (!TextUtils.isEmpty(str2) && str2.contains("-")) {
                str2 = str2.replace("-", "");
            }
            hashMap.put(str2, this.f26706c.get(str3));
        }
        a.C0239a c0239a = (a.C0239a) hashMap.get(str);
        String[] split = this.f26706c.toString().split("=");
        if (split.length != 2) {
            C1627a.o("NumberInfoManager", "findInfoInCache cacheEntry = " + c0239a + " mInfoMap is " + this.f26706c);
        } else {
            C1627a.o("NumberInfoManager", "findInfoInCache cacheEntry = " + c0239a + " mInfoMap is " + C0846g.f(split[0]) + "=" + split[1]);
        }
        return c0239a;
    }

    public a.C0239a t(String str, c.a aVar) {
        boolean z10;
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            z10 = true;
        } else {
            z10 = false;
        }
        I.h.g(z10);
        I.h.e(aVar);
        if (str == null) {
            C1627a.m("NumberInfoManager", "findInfoInCache  number = " + C0846g.f(str) + " number is null return");
            return null;
        }
        a.C0239a c0239a = this.f26706c.get(str);
        C1627a.m("NumberInfoManager", "findInfoInCache  number = " + C0846g.f(str) + " cacheEntry = " + c0239a);
        if (c0239a == null) {
            return null;
        }
        if (m(c0239a)) {
            return c0239a;
        }
        C1627a.m("NumberInfoManager", "findInfoInCache not find complete add callBack ");
        a(str, aVar);
        return c0239a;
    }

    public void u(String str, a.C0239a c0239a, c.a aVar) {
        boolean z10 = c0239a.f26642s;
        a.C0239a t10 = t(str, aVar);
        if (t10 != null && x(str)) {
            if (z10) {
                int i10 = t10.f26646w;
                if (i10 == 0) {
                    C1632f.i0(this.f26709f, str, t10, this.f26711h);
                } else if (i10 != 5) {
                    a(str, aVar);
                }
            }
            p(t10, c0239a, true);
            return;
        }
        a(str, aVar);
        C(str, null, "INTERCEPT_QUERY", z10);
    }

    public void v(String str, a.C0239a c0239a, c.a aVar) {
        if (aVar != null) {
            a(str, aVar);
        }
        c0239a.f26644u = 1;
        new Thread(new b(str)).start();
    }

    public d w() {
        return this.f26710g;
    }

    public final boolean x(String str) {
        boolean z10;
        if (this.f26706c.get(str) != null && (this.f26706c.get(str).f26624a != null || this.f26706c.get(str).f26640q.f26720c != null)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (C1627a.f37411c) {
            C1627a.c("NumberInfoManager", "infoIsValid  isValid = " + z10 + "  number = " + C0846g.f(str));
        }
        return z10;
    }

    public void y() {
        if (this.f26711h.hasMessages(1004)) {
            this.f26711h.removeMessages(1004);
        }
    }

    public void z(String str) {
        if (C1627a.f37411c) {
            C1627a.e("NumberInfoManager", "clearCacheInfo number = " + C0846g.f(str));
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        o();
        c(str);
        this.f26706c.remove(str);
        h.d().e(str);
    }
}
