package com.oplus.blacklistapp.callintercept.policy;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Log;
import com.oplus.blacklistapp.callintercept.CallInterceptController;
import com.oplus.blacklistapp.callintercept.a;
import com.oplus.blacklistapp.callintercept.policy.a;
import com.oplus.blacklistapp.callintercept.policy.c;
import com.oplus.utils.C0846g;
import com.oplus.utils.G;
import v6.C1627a;
import v6.C1632f;

/* compiled from: InterceptQuery.java */
/* loaded from: classes3.dex */
public class d implements c.a {

    /* renamed from: a, reason: collision with root package name */
    public Context f26663a;

    /* renamed from: b, reason: collision with root package name */
    public a.C0239a f26664b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f26665c;

    /* renamed from: d, reason: collision with root package name */
    public int f26666d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f26667e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f26668f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f26669g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f26670h;

    /* renamed from: i, reason: collision with root package name */
    public f f26671i;

    /* renamed from: j, reason: collision with root package name */
    public int f26672j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f26673k;

    /* renamed from: l, reason: collision with root package name */
    public C1632f.e f26674l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f26675m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f26676n;

    /* renamed from: o, reason: collision with root package name */
    public C1632f.d f26677o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f26678p;

    /* renamed from: q, reason: collision with root package name */
    public int f26679q;

    /* renamed from: r, reason: collision with root package name */
    public e f26680r;

    /* renamed from: s, reason: collision with root package name */
    public Handler f26681s;

    /* compiled from: InterceptQuery.java */
    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1000:
                    C1627a.l("InterceptQuery", "EVENT_DELAY_TO_ADD_CALL delayRing = " + d.this.f26669g);
                    if (d.this.f26669g) {
                        d.this.O(20);
                        return;
                    }
                    return;
                case 1001:
                    d.K("EVENT_ASYNC_QUERY_POLICY");
                    if (d.this.f26664b == null) {
                        return;
                    }
                    CallInterceptController.e().g().z(d.this.f26664b.f26625b);
                    d.this.b0();
                    d dVar = d.this;
                    dVar.P(dVar.f26664b.f26625b);
                    if (C1632f.L(d.this.f26663a)) {
                        d.this.Z();
                        d.this.U();
                        d.this.T();
                        if (!TextUtils.isEmpty(d.this.f26664b.f26625b)) {
                            CallInterceptController.e().g().u(d.this.f26664b.f26625b, d.this.f26664b, d.this);
                        }
                        d dVar2 = d.this;
                        dVar2.S(dVar2.f26664b, "Start");
                        return;
                    }
                    return;
                case 1002:
                    C1627a.l("InterceptQuery", "EVENT_DEAL_TIME_OUT");
                    if (d.this.f26667e) {
                        d dVar3 = d.this;
                        dVar3.O(dVar3.F(dVar3.f26672j));
                    }
                    d.this.c0();
                    return;
                case 1003:
                    d.K("EVENT_QUERY_BLACKLIST_COMPLETE");
                    d dVar4 = d.this;
                    dVar4.S(dVar4.f26664b, "Blacklist");
                    return;
                case 1004:
                    d.K("EVENT_QUERY_FAVORITES_COMPLETE");
                    d dVar5 = d.this;
                    dVar5.S(dVar5.f26664b, "Favorites");
                    return;
                case 1005:
                    d.K("EVENT_QUERY_SMART_DRIVE_COMPLETE");
                    d dVar6 = d.this;
                    dVar6.S(dVar6.f26664b, "SmartDrive");
                    return;
                case 1006:
                    d.K("EVENT_QUERY_RIDE_MODE_COMPLETE");
                    d dVar7 = d.this;
                    dVar7.S(dVar7.f26664b, "RideMode");
                    return;
                default:
                    C1627a.q("InterceptQuery", "Message not expected: " + message.what);
                    return;
            }
        }
    }

    /* compiled from: InterceptQuery.java */
    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f26683a;

        public b(String str) {
            this.f26683a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            dVar.f26666d = C1632f.W(dVar.f26663a, this.f26683a, d.this.f26680r.f26696j, d.this.f26680r.f26704r);
            if (l7.b.c(d.this.f26663a)) {
                d dVar2 = d.this;
                dVar2.f26666d = d.C(dVar2.f26666d, d.this.f26663a);
            }
            if (C1627a.f37411c) {
                C1627a.d("InterceptQuery", "queryBlackList blockType = " + d.this.f26666d);
            }
            d.this.f26665c = true;
            d.this.f26681s.sendEmptyMessage(1003);
        }
    }

    /* compiled from: InterceptQuery.java */
    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C1632f.a0(d.this.f26663a);
            if (C1627a.f37411c) {
                C1627a.d("InterceptQuery", "querySmartDriveData end");
            }
            d.this.f26674l = C1632f.t();
            d.this.f26675m = true;
            d.this.f26681s.sendEmptyMessage(1005);
        }
    }

    /* compiled from: InterceptQuery.java */
    /* renamed from: com.oplus.blacklistapp.callintercept.policy.d$d, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0241d implements Runnable {
        public RunnableC0241d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C1632f.Z(d.this.f26663a);
            if (C1627a.f37411c) {
                C1627a.d("InterceptQuery", "queryRideModeData end");
            }
            d.this.f26677o = C1632f.s();
            d.this.f26678p = true;
            d.this.f26681s.sendEmptyMessage(1006);
        }
    }

    /* compiled from: InterceptQuery.java */
    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public boolean f26687a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f26688b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f26689c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f26690d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f26691e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f26692f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f26693g;

        /* renamed from: h, reason: collision with root package name */
        public int f26694h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f26695i;

        /* renamed from: j, reason: collision with root package name */
        public int f26696j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f26697k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f26698l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f26699m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f26700n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f26701o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f26702p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f26703q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f26704r;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BlockSettings{ ");
            sb.append("  onlyRingOnceOn: " + this.f26687a);
            sb.append("  unknownNumberOn: " + this.f26688b);
            sb.append("  mAnonymousNumberOn: " + this.f26700n);
            sb.append("  mUnrecognizedNumberOn: " + this.f26701o);
            sb.append("  mPayphoneNumberOn: " + this.f26702p);
            sb.append("  strangerFirstOn: " + this.f26689c);
            sb.append("  allStrangersOn: " + this.f26690d + "\n");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("  allIncomingCallsOn: ");
            sb2.append(this.f26691e);
            sb.append(sb2.toString());
            sb.append("  repeatIncomingOn: " + this.f26692f);
            sb.append("  recognitionOn: " + this.f26695i);
            sb.append("  needInterceptMarkNumber: " + this.f26693g);
            sb.append("  delayDuration: " + this.f26694h);
            sb.append("  mSlotId: " + this.f26696j);
            sb.append("  mRepeatMarkNumberOn: " + this.f26697k);
            sb.append("  mRepeatAttributionOn: " + this.f26698l);
            sb.append("  mAttributionConfidenceOn: " + this.f26699m);
            sb.append("  mIsNAFCEnabled: " + this.f26703q);
            sb.append("  mAttributionInterceptOn: " + this.f26704r);
            sb.append(" }\n");
            return sb.toString();
        }
    }

    /* compiled from: InterceptQuery.java */
    /* loaded from: classes3.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public Object f26705a;
    }

    public d(Context context, String str, int i10) {
        this.f26666d = 0;
        this.f26667e = true;
        this.f26668f = false;
        this.f26669g = false;
        this.f26672j = -1;
        this.f26673k = false;
        this.f26674l = null;
        this.f26675m = false;
        this.f26676n = false;
        this.f26677o = null;
        this.f26678p = false;
        this.f26680r = null;
        this.f26681s = new a(Looper.getMainLooper());
        this.f26663a = context;
        this.f26680r = C1632f.b0(context, i10, true);
        if (C1627a.f37411c) {
            C1627a.d("InterceptQuery", "InterceptQuery number = " + C0846g.f(str) + " mBlockSettings = " + this.f26680r);
        }
        a.C0239a c0239a = new a.C0239a();
        this.f26664b = c0239a;
        c0239a.f26642s = true;
        if (!TextUtils.isEmpty(str) && str.equals("anonymous")) {
            this.f26664b.f26625b = null;
        } else {
            this.f26664b.f26625b = str;
        }
        this.f26670h = C1632f.y(this.f26664b.f26625b);
    }

    public static int C(int i10, Context context) {
        int E10 = E(context);
        boolean G10 = G(context);
        if (E10 == 0) {
            return i10;
        }
        if (!G10) {
            if (E10 == 1) {
                i10 = 0;
            } else if (E10 == 2) {
                i10 = 1;
            }
        }
        K("getConvertBlackListType, blackListType:" + i10);
        return i10;
    }

    public static int E(Context context) {
        int a10 = G.a(context);
        K("currentListPattern: " + a10);
        return a10;
    }

    public static boolean G(Context context) {
        int f10 = G.f(context);
        K("currentListType: " + f10);
        if (f10 != 0 && f10 != 2) {
            return false;
        }
        return true;
    }

    public static boolean H(a.C0239a c0239a) {
        boolean z10;
        if (R(c0239a) && TextUtils.isEmpty(c0239a.f26624a) && TextUtils.isEmpty(c0239a.f26640q.f26720c) && c0239a.f26640q.f26723f <= 0 && !C1632f.y(c0239a.f26625b)) {
            z10 = true;
        } else {
            z10 = false;
        }
        K("isStrangerIncomingCall = " + z10);
        return z10;
    }

    public static boolean I(Context context) {
        UserManager userManager;
        if (context == null || (userManager = (UserManager) context.getSystemService(UserManager.class)) == null) {
            return true;
        }
        return userManager.isUserUnlocked();
    }

    public static void K(String str) {
        if (C1627a.f37411c) {
            C1627a.c("InterceptQuery", str);
        }
    }

    public static boolean R(a.C0239a c0239a) {
        boolean z10;
        int i10 = c0239a.f26639p;
        boolean z11 = true;
        if (i10 != 2 && i10 != 3) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!TextUtils.isEmpty(c0239a.f26625b)) {
            z11 = z10;
        }
        K("queryContactsComplete   complete = " + z11);
        return z11;
    }

    public static boolean V(a.C0239a c0239a) {
        boolean z10;
        int i10 = c0239a.f26641r;
        boolean z11 = true;
        if (i10 != 2 && i10 != 3) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!TextUtils.isEmpty(c0239a.f26625b)) {
            z11 = z10;
        }
        K("queryYellowPageComplete   complete = " + z11);
        return z11;
    }

    public final boolean A() {
        int i10;
        C1632f.e eVar;
        C1632f.d dVar;
        K("easyCaseBlocked mBlockListType = " + this.f26666d);
        int i11 = this.f26666d;
        boolean z10 = false;
        if (i11 == 1) {
            i10 = 27;
        } else {
            if (i11 != 3 && !C1632f.J(this.f26663a)) {
                e eVar2 = this.f26680r;
                boolean z11 = eVar2.f26691e;
                if (z11) {
                    i10 = 26;
                } else if (!z11 && !eVar2.f26690d && !eVar2.f26687a && !eVar2.f26693g && !eVar2.f26689c && (((eVar = this.f26674l) == null || eVar.f37488b == 1) && (((dVar = this.f26677o) == null || dVar.f37485b == 1) && this.f26666d == 0))) {
                    K("all block cases is closed return");
                } else {
                    i10 = -1;
                }
            }
            i10 = 0;
        }
        if (i10 != -1) {
            O(i10);
            z10 = true;
        }
        K("easyCaseBlocked blocked = " + z10 + " blockType = " + i10);
        return z10;
    }

    public long B() {
        a.C0239a c0239a = this.f26664b;
        if (c0239a != null) {
            return c0239a.f26638o;
        }
        return -1L;
    }

    public int D() {
        K("getCurrentInterceptType = " + this.f26672j);
        return this.f26672j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0052, code lost:
    
        if (r7.f26680r.f26687a != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0054, code lost:
    
        r8 = 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0056, code lost:
    
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0090, code lost:
    
        if (r7.f26680r.f26687a != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int F(int r8) {
        /*
            r7 = this;
            com.oplus.blacklistapp.callintercept.policy.a$a r0 = r7.f26664b
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L10
            long r3 = r0.f26638o
            r5 = -1
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L10
            r0 = r1
            goto L11
        L10:
            r0 = r2
        L11:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "getTimeOutTypeByPriority currentInterceptType = "
            r3.append(r4)
            r3.append(r8)
            java.lang.String r4 = " isContact = "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            K(r3)
            r3 = 4
            r4 = 20
            if (r8 != r3) goto L34
            r5 = r4
            goto L35
        L34:
            r5 = r8
        L35:
            r6 = 25
            if (r5 == r4) goto L58
            if (r5 == r3) goto L58
            r3 = -1
            if (r5 != r3) goto L3f
            goto L58
        L3f:
            if (r5 != r6) goto L93
            com.oplus.blacklistapp.callintercept.policy.d$e r0 = r7.f26680r
            boolean r0 = r0.f26692f
            boolean r0 = r7.w(r0)
            if (r0 == 0) goto L93
            r7.e0(r1)
            com.oplus.blacklistapp.callintercept.policy.d$e r7 = r7.f26680r
            boolean r7 = r7.f26687a
            if (r7 == 0) goto L56
        L54:
            r8 = r4
            goto L93
        L56:
            r8 = r2
            goto L93
        L58:
            com.oplus.blacklistapp.callintercept.policy.d$e r8 = r7.f26680r
            boolean r1 = r8.f26690d
            if (r1 == 0) goto L68
            boolean r8 = r8.f26692f
            boolean r8 = r7.w(r8)
            if (r8 != 0) goto L68
            r8 = r6
            goto L93
        L68:
            int r8 = r7.f26666d
            r1 = 2
            if (r8 != r1) goto L7a
            com.oplus.blacklistapp.callintercept.policy.d$e r8 = r7.f26680r
            boolean r8 = r8.f26699m
            boolean r8 = r7.w(r8)
            if (r8 != 0) goto L7a
            r8 = 24
            goto L93
        L7a:
            boolean r8 = r7.y(r0)
            if (r8 == 0) goto L83
            r8 = 54
            goto L93
        L83:
            boolean r8 = r7.x(r0)
            if (r8 == 0) goto L8c
            r8 = 55
            goto L93
        L8c:
            com.oplus.blacklistapp.callintercept.policy.d$e r7 = r7.f26680r
            boolean r7 = r7.f26687a
            if (r7 == 0) goto L56
            goto L54
        L93:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "getTimeOutTypeByPriority = "
            r7.append(r0)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            K(r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.blacklistapp.callintercept.policy.d.F(int):int");
    }

    public final boolean J(a.C0239a c0239a) {
        boolean z10;
        if (TextUtils.isEmpty(c0239a.f26640q.f26720c) && !C1632f.w(c0239a.f26640q.f26723f)) {
            z10 = false;
        } else {
            z10 = true;
        }
        K("isYellowPageCredible = " + z10);
        return z10;
    }

    public final void L(a.C0239a c0239a, int i10, boolean z10) {
        if (z10) {
            if (this.f26670h) {
                M("FamilyOrCornetGroup");
                return;
            }
            if (!V(c0239a)) {
                d0(i10);
                K("wait query yellow page complete");
                return;
            } else if (J(c0239a)) {
                M("YellowPageCredible");
                return;
            } else {
                if (this.f26668f) {
                    e0(true);
                    M("Penetrated");
                    C1632f.T(this.f26663a, this.f26664b.f26625b, 0, i10);
                    return;
                }
                O(i10);
                return;
            }
        }
        if (!this.f26668f) {
            O(i10);
            return;
        }
        e0(true);
        M("RecognitionConfidenceClose");
        C1632f.T(this.f26663a, this.f26664b.f26625b, 0, i10);
    }

    public final void M(String str) {
        K("notifyDefaultPolicyExceptContacts  " + str);
        if (y(false)) {
            O(54);
            return;
        }
        if (x(false)) {
            O(55);
        } else if (!this.f26680r.f26687a) {
            O(0);
        } else {
            d0(20);
            this.f26669g = true;
        }
    }

    public void N() {
        K("notifyMainThreadRequest");
        O(0);
    }

    public void O(int i10) {
        boolean z10;
        boolean z11;
        C1627a.l("InterceptQuery", "notifyMainThreadRequest type = " + com.oplus.blacklistapp.callintercept.a.d(i10));
        if (this.f26671i.f26705a != null) {
            K("notifyMainThreadRequest already notify return ");
            return;
        }
        a.C0239a s10 = CallInterceptController.e().g().s(this.f26664b.f26625b);
        if (this.f26666d == 3 && i10 == 0) {
            if (s10 != null) {
                s10.f26623G = true;
            }
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f26676n && (i10 == 0 || i10 == 20)) {
            if (s10 != null) {
                s10.f26622F = true;
            }
            z11 = true;
        } else {
            z11 = false;
        }
        W();
        Y();
        this.f26667e = false;
        a.C0237a c0237a = new a.C0237a(i10, B(), 0);
        if (s10 != null) {
            int a10 = com.oplus.blacklistapp.callintercept.a.a(c0237a.f26584c, 1, z11);
            c0237a.f26584c = a10;
            c0237a.f26584c = com.oplus.blacklistapp.callintercept.a.a(a10, 2, z10);
            K("notifyMainThreadRequest retInterceptTactics = " + c0237a);
        }
        f fVar = this.f26671i;
        fVar.f26705a = c0237a;
        synchronized (fVar) {
            this.f26671i.notifyAll();
        }
        X(i10);
    }

    public void P(String str) {
        new Thread(new b(str)).start();
    }

    public final void Q(String str, a.C0239a c0239a) {
        if (c0239a == null) {
            if (C1627a.f37411c) {
                C1627a.d("InterceptQuery", "queryContactOrYellowPageComplete entry is null return");
                return;
            }
            return;
        }
        if (C1627a.f37411c) {
            C1627a.d("InterceptQuery", "queryComplete  person_id = " + c0239a.f26638o + " contactName = " + c0239a.f26624a + " yellowPageName = " + c0239a.f26640q.f26720c + ", starred = " + c0239a.f26621E);
        }
        this.f26673k = c0239a.f26621E;
        com.oplus.blacklistapp.callintercept.policy.e.q(this.f26664b, c0239a);
        if (c0239a.f26624a != null && TextUtils.isEmpty(this.f26664b.f26624a)) {
            com.oplus.blacklistapp.callintercept.policy.e.p(c0239a, this.f26664b, false);
        }
        com.oplus.blacklistapp.callintercept.policy.f fVar = c0239a.f26640q;
        if (fVar != null) {
            com.oplus.blacklistapp.callintercept.policy.e.r(this.f26664b.f26640q, fVar);
        }
        S(this.f26664b, "ContactOrYellowPage");
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void S(com.oplus.blacklistapp.callintercept.policy.a.C0239a r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 617
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.blacklistapp.callintercept.policy.d.S(com.oplus.blacklistapp.callintercept.policy.a$a, java.lang.String):void");
    }

    public void T() {
        new Thread(new RunnableC0241d()).start();
    }

    public void U() {
        new Thread(new c()).start();
    }

    public final void W() {
        K("removeDelayRingingMessage");
        if (this.f26681s.hasMessages(1000)) {
            this.f26681s.removeMessages(1000);
        }
    }

    public final void X(int i10) {
        if (i10 >= 21 && i10 <= 26 && !TextUtils.isEmpty(this.f26664b.f26625b)) {
            CallInterceptController.e().g().z(this.f26664b.f26625b);
        } else if (this.f26663a != null && i10 == 20 && !TextUtils.isEmpty(this.f26664b.f26625b)) {
            CallInterceptController.e().g().z(this.f26664b.f26625b);
        }
    }

    public final void Y() {
        K("removeTimeOutCheckMessage");
        if (this.f26681s.hasMessages(1002)) {
            this.f26681s.removeMessages(1002);
        }
    }

    public final void Z() {
        K("sendDelayRingingMessage");
        if (!this.f26681s.hasMessages(1000)) {
            this.f26681s.sendEmptyMessageDelayed(1000, this.f26680r.f26694h);
        }
    }

    @Override // com.oplus.blacklistapp.callintercept.policy.c.a
    public void a(String str, a.C0239a c0239a) {
        if (c0239a == null) {
            if (C1627a.f37411c) {
                C1627a.d("InterceptQuery", "onQueryLocationComplete entry is null return");
                return;
            }
            return;
        }
        if (C1627a.f37411c) {
            C1627a.d("InterceptQuery", "queryComplete  Location = " + c0239a.f26626c);
        }
        com.oplus.blacklistapp.callintercept.policy.e.q(this.f26664b, c0239a);
        if (!TextUtils.isEmpty(c0239a.f26626c) && !c0239a.f26626c.equals(this.f26664b.f26626c)) {
            this.f26664b.f26626c = c0239a.f26626c;
        }
        S(this.f26664b, "Location");
    }

    public final Object a0(int i10, Object obj) {
        Object obj2;
        if (Looper.myLooper() == this.f26681s.getLooper()) {
            C1627a.h("InterceptQuery", "This method will deadlock if called from the main thread.");
            return 0;
        }
        if (this.f26681s.hasMessages(1001)) {
            K("sendRequest has EVENT_ASYNC_QUERY_INFO remove it");
            this.f26681s.removeMessages(1001);
        }
        f fVar = new f();
        this.f26671i = fVar;
        this.f26681s.obtainMessage(i10, fVar).sendToTarget();
        K("sendRequest request = " + this.f26671i);
        synchronized (this.f26671i) {
            while (true) {
                f fVar2 = this.f26671i;
                obj2 = fVar2.f26705a;
                if (obj2 == null) {
                    try {
                        fVar2.wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
        return obj2;
    }

    @Override // com.oplus.blacklistapp.callintercept.policy.c.a
    public void b(String str, a.C0239a c0239a) {
        if (c0239a == null) {
            if (C1627a.f37411c) {
                C1627a.d("InterceptQuery", "onQueryCallLogComplete entry is null return");
                return;
            }
            return;
        }
        if (C1627a.f37411c) {
            C1627a.d("InterceptQuery", "queryComplete CallLog = " + c0239a.f26645v);
        }
        com.oplus.blacklistapp.callintercept.policy.e.q(this.f26664b, c0239a);
        a.C0239a c0239a2 = this.f26664b;
        c0239a2.f26645v = c0239a.f26645v;
        S(c0239a2, "CallLog");
    }

    public final void b0() {
        K("sendTimeOutCheckMessage");
        if (!this.f26681s.hasMessages(1002)) {
            this.f26681s.sendEmptyMessageDelayed(1002, 6000L);
        }
    }

    public void c0() {
        K("setAllQueryComplete  mContactInfo = " + this.f26664b);
        this.f26665c = true;
        a.C0239a c0239a = this.f26664b;
        c0239a.f26639p = 3;
        c0239a.f26641r = 3;
        c0239a.f26646w = 5;
        this.f26680r.f26687a = false;
        this.f26675m = true;
    }

    @Override // com.oplus.blacklistapp.callintercept.policy.a.b
    public void d(String str, a.C0239a c0239a) {
        K("onContactInfoComplete number = " + C0846g.f(str));
        if (c0239a == null) {
            if (C1627a.f37411c) {
                C1627a.d("InterceptQuery", "onContactInfoComplete entry is null return");
                return;
            }
            return;
        }
        Q(str, c0239a);
    }

    public final void d0(int i10) {
        K("setCurrentInterceptType = " + i10);
        this.f26672j = i10;
    }

    @Override // com.oplus.blacklistapp.callintercept.policy.a.b
    public void e(String str, a.C0239a c0239a) {
        if (c0239a == null) {
            if (C1627a.f37411c) {
                C1627a.d("InterceptQuery", "onImageLoadComplete entry is null return");
                return;
            }
            return;
        }
        if (C1627a.f37411c) {
            C1627a.d("InterceptQuery", "ImageLoadComplete  person_id = " + c0239a.f26638o + " contactName = " + c0239a.f26624a + " yellowPageName = " + c0239a.f26640q.f26720c);
        }
        Q(str, c0239a);
    }

    public void e0(boolean z10) {
        K("setIsPenetratedIncomingCall isPenetratedIncomingCall =  " + z10);
        this.f26676n = z10;
    }

    public a.C0237a f0() {
        if (TextUtils.isEmpty(this.f26664b.f26625b) && z()) {
            if (C1632f.J(this.f26663a)) {
                d0(0);
                return new a.C0237a(0);
            }
            if (l7.b.o() && (D() == 28 || D() == 29 || D() == 30)) {
                C1627a.l("InterceptQuery", "empty number blocked by policy = " + com.oplus.blacklistapp.callintercept.a.d(this.f26672j));
                return new a.C0237a(D());
            }
            if (D() >= 21 && D() <= 26) {
                C1627a.l("InterceptQuery", "empty number blocked by policy = " + com.oplus.blacklistapp.callintercept.a.d(this.f26672j));
                return new a.C0237a(D());
            }
            if (D() == 1) {
                try {
                    Thread.sleep(this.f26680r.f26694h);
                } catch (InterruptedException e10) {
                    Log.e("InterceptQuery", "e = " + e10);
                }
                return new a.C0237a(20);
            }
        }
        return (a.C0237a) a0(1001, null);
    }

    @Override // com.oplus.blacklistapp.callintercept.policy.c.a
    public boolean isInterceptQuery() {
        return true;
    }

    public boolean w(boolean z10) {
        a.C0239a c0239a;
        boolean z11 = false;
        if (z10 && (c0239a = this.f26664b) != null) {
            long j10 = c0239a.f26645v;
            if (j10 != 0 && C1632f.u(j10)) {
                z11 = true;
            }
        }
        K("canPenetratedBlocked = " + z11);
        return z11;
    }

    public final boolean x(boolean z10) {
        C1632f.d dVar = this.f26677o;
        boolean z11 = false;
        if (dVar == null) {
            return false;
        }
        boolean w10 = w(dVar.f37486c);
        if ((!w10 && !z10 && this.f26677o.f37485b == 2) || ((!w10 && this.f26677o.f37485b == 0) || (!w10 && !this.f26673k && this.f26677o.f37485b == 3))) {
            z11 = true;
        }
        K("checkRideModeBlocked isContact = " + z10 + "  repeatRing = " + w10 + " blocked = " + z11);
        return z11;
    }

    public final boolean y(boolean z10) {
        C1632f.e eVar = this.f26674l;
        boolean z11 = false;
        if (eVar == null) {
            return false;
        }
        boolean w10 = w(eVar.f37489c);
        if ((!w10 && !z10 && this.f26674l.f37488b == 2) || ((!w10 && this.f26674l.f37488b == 0) || (!w10 && !this.f26673k && this.f26674l.f37488b == 3))) {
            z11 = true;
        }
        K("checkSmartDriveBlocked isContact = " + z10 + "  repeatRing = " + w10 + " blocked = " + z11);
        return z11;
    }

    public boolean z() {
        e eVar = this.f26680r;
        boolean z10 = true;
        if (eVar.f26691e) {
            d0(26);
        } else if (eVar.f26690d) {
            d0(25);
        } else if (eVar.f26688b) {
            d0(22);
        } else if (eVar.f26689c && C1632f.X(this.f26663a, null) == 0) {
            d0(21);
        } else if (this.f26680r.f26687a) {
            d0(1);
        } else {
            if (l7.b.o()) {
                e eVar2 = this.f26680r;
                if (eVar2.f26700n && this.f26679q == 2) {
                    d0(28);
                } else if (eVar2.f26701o && this.f26679q == 3) {
                    d0(29);
                } else if (eVar2.f26702p && this.f26679q == 4) {
                    d0(30);
                }
            }
            z10 = false;
        }
        K("dealWithEmptyNumber isDone = " + z10);
        return z10;
    }

    public d(Context context, String str, int i10, int i11) {
        this(context, str, i10);
        this.f26679q = i11;
    }

    @Override // com.oplus.blacklistapp.callintercept.policy.c.a
    public void c(String str, a.C0239a c0239a) {
    }
}
