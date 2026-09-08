package com.oplus.blacklistapp.callintercept.policy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.oplus.blacklistapp.callintercept.policy.b;
import com.oplus.blacklistapp.u;
import com.oplus.utils.C0846g;
import com.oplus.utils.O;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import s6.C1552a;
import v6.C1627a;

/* compiled from: ContactInfoCache.java */
/* loaded from: classes3.dex */
public class a implements b.InterfaceC0240b {

    /* renamed from: d, reason: collision with root package name */
    public static final String f26612d = "a";

    /* renamed from: e, reason: collision with root package name */
    public static a f26613e;

    /* renamed from: a, reason: collision with root package name */
    public final Context f26614a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap<String, C0239a> f26615b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<String, Set<b>> f26616c = new HashMap<>();

    /* compiled from: ContactInfoCache.java */
    /* renamed from: com.oplus.blacklistapp.callintercept.policy.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0239a {

        /* renamed from: B, reason: collision with root package name */
        public String f26618B;

        /* renamed from: C, reason: collision with root package name */
        public String f26619C;

        /* renamed from: a, reason: collision with root package name */
        public String f26624a;

        /* renamed from: b, reason: collision with root package name */
        public String f26625b;

        /* renamed from: c, reason: collision with root package name */
        public String f26626c;

        /* renamed from: d, reason: collision with root package name */
        public String f26627d;

        /* renamed from: e, reason: collision with root package name */
        public Drawable f26628e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f26629f;

        /* renamed from: g, reason: collision with root package name */
        public Uri f26630g;

        /* renamed from: h, reason: collision with root package name */
        public Uri f26631h;

        /* renamed from: i, reason: collision with root package name */
        public Uri f26632i;

        /* renamed from: j, reason: collision with root package name */
        public String f26633j;

        /* renamed from: l, reason: collision with root package name */
        public String f26635l;

        /* renamed from: n, reason: collision with root package name */
        public int f26637n;

        /* renamed from: s, reason: collision with root package name */
        public boolean f26642s;

        /* renamed from: t, reason: collision with root package name */
        public boolean f26643t;

        /* renamed from: k, reason: collision with root package name */
        public int f26634k = -1;

        /* renamed from: m, reason: collision with root package name */
        public int f26636m = -1;

        /* renamed from: o, reason: collision with root package name */
        public long f26638o = -1;

        /* renamed from: p, reason: collision with root package name */
        public int f26639p = 0;

        /* renamed from: q, reason: collision with root package name */
        public f f26640q = new f();

        /* renamed from: r, reason: collision with root package name */
        public int f26641r = 0;

        /* renamed from: u, reason: collision with root package name */
        public int f26644u = 0;

        /* renamed from: v, reason: collision with root package name */
        public long f26645v = 0;

        /* renamed from: w, reason: collision with root package name */
        public int f26646w = 0;

        /* renamed from: x, reason: collision with root package name */
        public boolean f26647x = false;

        /* renamed from: y, reason: collision with root package name */
        public boolean f26648y = false;

        /* renamed from: z, reason: collision with root package name */
        public boolean f26649z = false;

        /* renamed from: A, reason: collision with root package name */
        public int f26617A = 0;

        /* renamed from: D, reason: collision with root package name */
        public long f26620D = 0;

        /* renamed from: E, reason: collision with root package name */
        public boolean f26621E = false;

        /* renamed from: F, reason: collision with root package name */
        public boolean f26622F = false;

        /* renamed from: G, reason: collision with root package name */
        public boolean f26623G = false;

        public String toString() {
            if (C1627a.f37411c) {
                StringBuilder sb = new StringBuilder();
                sb.append("ContactCacheEntry{\n");
                sb.append("  number: " + C0846g.f(this.f26625b));
                sb.append("  label: " + this.f26627d);
                sb.append("  title: " + this.f26619C);
                sb.append("  photo: " + this.f26628e);
                sb.append("  contactUri: " + C0846g.h(this.f26630g));
                sb.append("  displayPhotoUri: " + C0846g.h(this.f26631h));
                sb.append("  subId: " + this.f26636m);
                sb.append("  slotId: " + this.f26634k);
                sb.append("  callState: " + this.f26637n + "\n");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("  person_id: ");
                sb2.append(this.f26638o);
                sb.append(sb2.toString());
                sb.append("  contactQureyState: " + f.b(this.f26639p));
                sb.append("  yellowPageName: " + this.f26640q.f26720c);
                sb.append("  markInfo: " + this.f26640q.f26721d);
                sb.append("  markInfoCounter: " + this.f26640q.f26722e);
                sb.append("  markInfoType: " + this.f26640q.f26723f);
                sb.append("  yellowPagePhoto: " + this.f26640q.f26725h);
                sb.append("  yellowPageQureyState: " + f.b(this.f26641r) + "\n");
                StringBuilder sb3 = new StringBuilder();
                sb3.append("  isIncomingCall: ");
                sb3.append(this.f26642s);
                sb.append(sb3.toString());
                sb.append("  isLocked: " + this.f26643t);
                sb.append("  locationQueryState: " + f.b(this.f26644u));
                sb.append("  lastCallTime: " + this.f26645v);
                sb.append("  callLogQueryState: " + f.b(this.f26646w));
                sb.append("  isVoiceMail: " + this.f26647x);
                sb.append("  isYellowPageNumber: " + this.f26648y);
                sb.append("  shouldAutoRecord: " + this.f26649z);
                sb.append("  contactType: " + this.f26620D);
                sb.append("  starred: " + this.f26621E);
                sb.append("  isPenetratedIncomingCall: " + this.f26622F);
                sb.append("  isInWhiteList: " + this.f26623G);
                sb.append("  customRecordQueryState: " + this.f26617A);
                sb.append("\n}");
                return sb.toString();
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("ContactCacheEntry{\n");
            sb4.append("  label: " + this.f26627d);
            sb4.append("  company: " + this.f26618B);
            sb4.append("  person_id: " + this.f26638o);
            return sb4.toString();
        }
    }

    /* compiled from: ContactInfoCache.java */
    /* loaded from: classes3.dex */
    public interface b {
        void d(String str, C0239a c0239a);

        void e(String str, C0239a c0239a);
    }

    public a(Context context) {
        this.f26614a = context;
    }

    private void b(String str) {
        this.f26616c.remove(str);
    }

    public static synchronized a c(Context context) {
        a aVar;
        synchronized (a.class) {
            try {
                if (f26613e == null) {
                    f26613e = new a(context);
                }
                aVar = f26613e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public static String d(Context context, int i10) {
        return "";
    }

    public static void e(Context context, C1552a c1552a, C0239a c0239a, int i10, boolean z10) {
        boolean z11;
        String str;
        String str2;
        String str3;
        I.h.e(c1552a);
        String str4 = c1552a.f36838b;
        if (!TextUtils.isEmpty(str4)) {
            z11 = O.b(str4);
            if (str4.startsWith("sip:")) {
                str4 = str4.substring(4);
            }
        } else {
            z11 = false;
        }
        String str5 = null;
        if (TextUtils.isEmpty(c1552a.f36837a)) {
            if (!TextUtils.isEmpty(str4) && !str4.startsWith("anonymous")) {
                if (i10 != 1) {
                    str = d(context, i10);
                    C1627a.c(f26612d, "  ==> presentation not allowed!");
                } else if (!TextUtils.isEmpty(c1552a.f36842f)) {
                    str = c1552a.f36842f;
                    c1552a.f36837a = str;
                    C1627a.c(f26612d, "  ==> cnapName available");
                    str2 = null;
                } else {
                    if (c1552a.f()) {
                        str = context.getResources().getString(u.f27679q3);
                    } else {
                        str = null;
                    }
                    if (z10) {
                        str3 = c1552a.f36841e;
                        C1627a.c(f26612d, "Geodescrption: " + c1552a.f36841e);
                    } else {
                        str3 = null;
                    }
                    C1627a.c(f26612d, "  ==>  no name; falling back to number");
                    str5 = str3;
                    str2 = null;
                }
            } else {
                str = d(context, i10);
                C1627a.c(f26612d, "  ==> no name *or* number!");
            }
            str2 = null;
            str4 = null;
        } else if (i10 != 1) {
            str = d(context, i10);
            C1627a.c(f26612d, "  ==> valid name, but presentation not allowed!");
            str2 = null;
            str4 = null;
        } else {
            str = c1552a.f36837a;
            str2 = c1552a.f36849m;
            C1627a.c(f26612d, "  ==>  name is present in CallerInfo");
        }
        c0239a.f26624a = str;
        c0239a.f26625b = str4;
        c0239a.f26618B = c1552a.f36846j;
        c0239a.f26619C = c1552a.f36847k;
        if (TextUtils.isEmpty(c0239a.f26626c) && str5 != null) {
            c0239a.f26626c = str5;
        }
        c0239a.f26647x = c1552a.f();
        if (C1627a.f37414f) {
            C1627a.c(f26612d, "isVoiceMail = " + c0239a.f26647x);
        }
        c0239a.f26627d = str2;
        c0239a.f26629f = z11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x001b, code lost:
    
        if (r6 != null) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.oplus.blacklistapp.callintercept.policy.a.C0239a a(android.content.Context r6, java.lang.String r7, s6.C1552a r8, int r9, boolean r10) {
        /*
            r5 = this;
            r5 = 0
            if (r8 != 0) goto L4
            return r5
        L4:
            com.oplus.blacklistapp.callintercept.policy.a$a r0 = new com.oplus.blacklistapp.callintercept.policy.a$a
            r0.<init>()
            e(r6, r8, r0, r9, r10)
            int r9 = r8.f36852p
            if (r9 == 0) goto L15
            android.graphics.drawable.Drawable r6 = r6.getDrawable(r9)
            goto L26
        L15:
            boolean r6 = r8.f36861y
            if (r6 == 0) goto L1e
            android.graphics.drawable.Drawable r6 = r8.f36860x
            if (r6 == 0) goto L25
            goto L26
        L1e:
            android.net.Uri r6 = r8.f36857u
            if (r6 != 0) goto L23
            goto L25
        L23:
            r0.f26631h = r6
        L25:
            r6 = r5
        L26:
            java.lang.String r9 = r8.f36854r
            if (r9 == 0) goto L3a
            long r1 = r8.f36853q
            r3 = 0
            int r10 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r10 != 0) goto L33
            goto L3a
        L33:
            android.net.Uri r5 = android.provider.ContactsContract.Contacts.getLookupUri(r1, r9)
            r0.f26632i = r5
            goto L43
        L3a:
            java.lang.String r9 = com.oplus.blacklistapp.callintercept.policy.a.f26612d
            java.lang.String r10 = "lookup key is null or contact ID is 0. Don't create a lookup uri."
            v6.C1627a.o(r9, r10)
            r0.f26632i = r5
        L43:
            r0.f26628e = r6
            java.lang.String r5 = r8.f36854r
            r0.f26633j = r5
            boolean r5 = r8.f36845i
            if (r5 == 0) goto L58
            long r5 = r8.f36853q
            r0.f26638o = r5
            r5 = 1
            r0.f26620D = r5
            r5 = 0
            r0.f26648y = r5
        L58:
            r0.f26635l = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.blacklistapp.callintercept.policy.a.a(android.content.Context, java.lang.String, s6.a, int, boolean):com.oplus.blacklistapp.callintercept.policy.a$a");
    }

    public final void f(String str, C0239a c0239a) {
        Set<b> set = this.f26616c.get(str);
        if (set != null && c0239a.f26628e != null) {
            Iterator<b> it = set.iterator();
            while (it.hasNext()) {
                it.next().e(str, c0239a);
            }
        }
    }

    @Override // com.oplus.blacklistapp.callintercept.policy.b.InterfaceC0240b
    public void onImageLoadComplete(int i10, Drawable drawable, Bitmap bitmap, Object obj) {
        C1627a.b(this, "Image load complete with context: ", this.f26614a);
        String str = (String) obj;
        C0239a c0239a = this.f26615b.get(str);
        if (c0239a == null) {
            C1627a.g(this, "Image Load received for empty search entry.");
            b(str);
            return;
        }
        C1627a.b(this, "setting photo for entry: ", c0239a);
        if (c0239a.f26628e != null) {
            C1627a.a(this, "already has photo so return!!! ");
            return;
        }
        if (drawable != null) {
            C1627a.p(this, "direct drawable: ", drawable);
            c0239a.f26628e = drawable;
        } else if (bitmap != null) {
            C1627a.p(this, "photo icon: ", bitmap);
            c0239a.f26628e = new BitmapDrawable(this.f26614a.getResources(), bitmap);
        } else {
            C1627a.o(this, "unknown photo");
            c0239a.f26628e = null;
        }
        f(str, c0239a);
        b(str);
    }
}
