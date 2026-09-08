package com.android.contacts.cust.business.export;

import C7.e;
import H7.b;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.UserManager;
import android.provider.ContactsContract;
import android.telephony.SubscriptionInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import com.android.incallui.OplusPhoneUtils;
import com.oplus.foundation.util.OsUtils;
import java.util.ArrayList;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.jvm.internal.i;
import kotlin.text.n;
import m9.d;
import m9.q;
import r0.g;
import t0.C1577a;
import t0.C1578b;
import u0.C1600a;
import u0.C1601b;
import v0.c;
import v9.InterfaceC1637a;
import w0.f;
import w0.m;

/* compiled from: CustExportImpl.kt */
/* loaded from: classes.dex */
public final class CustExportImpl implements f {

    /* renamed from: a, reason: collision with root package name */
    public static final a f14143a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public static final d<CustExportImpl> f14144b;

    /* compiled from: CustExportImpl.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final CustExportImpl a() {
            return (CustExportImpl) CustExportImpl.f14144b.getValue();
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    static {
        d<CustExportImpl> a10;
        a10 = kotlin.a.a(LazyThreadSafetyMode.f34161a, new InterfaceC1637a<CustExportImpl>() { // from class: com.android.contacts.cust.business.export.CustExportImpl$Companion$instance$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final CustExportImpl invoke() {
                return new CustExportImpl();
            }
        });
        f14144b = a10;
    }

    public static final CustExportImpl A() {
        return f14143a.a();
    }

    public final String B(String str) {
        String a10;
        if (OsUtils.c()) {
            a10 = CustCustomizeFeature.f14117a.j();
        } else {
            String str2 = "";
            if (OsUtils.f28275a.i()) {
                if (str != null) {
                    str2 = str;
                }
                a10 = M7.d.b("ro.vendor.oplus.operator", str2);
            } else {
                if (str != null) {
                    str2 = str;
                }
                a10 = g.a(str2);
            }
        }
        if (!TextUtils.isEmpty(a10)) {
            return a10;
        }
        return str;
    }

    public final String C(String str) {
        return CustCustomizeFeature.f14117a.o().get(str);
    }

    public final String D() {
        boolean v10;
        if (CustCustomizeFeature.f14117a.n()) {
            return "*611";
        }
        String B10 = B(" ");
        if (B10 != null) {
            v10 = n.v(B10, "TELSTRA", false, 2, null);
            if (v10) {
                return "#101#";
            }
        }
        return null;
    }

    public final String E(String str) {
        return CustCustomizeFeature.f14117a.q().get(str);
    }

    public final String F(String str) {
        boolean v10;
        String B10 = B(" ");
        if (B10 != null) {
            v10 = n.v(B10, "TELSTRA", false, 2, null);
            if (!v10 || !i.b(OplusPhoneUtils.TELSTRA_DEFAULT_VOICE_MAIL, str)) {
                return null;
            }
            return "MessageBank";
        }
        return null;
    }

    public boolean G() {
        CustCustomizeFeature custCustomizeFeature = CustCustomizeFeature.f14117a;
        if (!custCustomizeFeature.i() && (!custCustomizeFeature.l() || !t0.d.f37139g)) {
            return false;
        }
        return true;
    }

    @Override // w0.f
    public boolean a() {
        return CustCustomizeFeature.f14117a.h();
    }

    @Override // w0.f
    public boolean b(Context context, String[] strArr) {
        return h(context, strArr, true);
    }

    @Override // w0.f
    public m c(Context context, w0.n nVar) {
        return new c(context, nVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
    
        if (G0.c.d(r5, 1, "fdn_enable_key", 0) > 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0030, code lost:
    
        if (r3 > 0) goto L17;
     */
    @Override // w0.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean d(android.content.Context r5, boolean r6) {
        /*
            r4 = this;
            java.lang.String r4 = "CustUtilsImpl"
            java.lang.String r0 = "fdn_enable_key"
            boolean r1 = com.oplus.foundation.util.OsUtils.k()
            if (r1 == 0) goto L11
            if (r6 == 0) goto L11
            boolean r6 = t0.C1577a.e(r5)
            goto L17
        L11:
            com.android.contacts.cust.business.export.CustCustomizeFeature r6 = com.android.contacts.cust.business.export.CustCustomizeFeature.f14117a
            boolean r6 = r6.f()
        L17:
            r1 = 0
            if (r6 != 0) goto L1b
            return r1
        L1b:
            if (r5 != 0) goto L1e
            return r1
        L1e:
            r6 = -1
            r2 = 1
            int r3 = G0.c.e(r5, r2, r0, r6, r2)     // Catch: java.lang.SecurityException -> L2e
            if (r3 != r6) goto L30
            int r5 = G0.c.d(r5, r2, r0, r1)     // Catch: java.lang.SecurityException -> L2e
            if (r5 <= 0) goto L47
        L2c:
            r1 = r2
            goto L47
        L2e:
            r5 = move-exception
            goto L33
        L30:
            if (r3 <= 0) goto L47
            goto L2c
        L33:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "isNeedShowFdnName  Exception:"
            r6.append(r0)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            H7.b.c(r4, r5)
        L47:
            boolean r5 = H7.a.b()
            if (r5 == 0) goto L61
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "isNeedShowFdnName isAvailable:"
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            H7.b.b(r4, r5)
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.cust.business.export.CustExportImpl.d(android.content.Context, boolean):boolean");
    }

    @Override // w0.f
    public void e(Context context, String str, Intent intent) {
        Context context2;
        CustCustomizeFeature custCustomizeFeature = CustCustomizeFeature.f14117a;
        if ((custCustomizeFeature.i() || custCustomizeFeature.l()) && TextUtils.equals(str, "android.intent.action.SIM_STATE_CHANGED")) {
            try {
                String l10 = e.l(intent, "ss");
                int d10 = e.d(intent, "phone", -1);
                if (context != null) {
                    context2 = context.getApplicationContext();
                } else {
                    context2 = null;
                }
                t0.d c10 = t0.d.c(context2);
                if (c10 != null) {
                    c10.e(l10, d10);
                }
            } catch (Exception e10) {
                b.c("CustUtilsImpl", "sdn sim error" + e10);
            }
        }
    }

    @Override // w0.f
    public boolean f(long j10) {
        return ContactsContract.Contacts.isEnterpriseContactId(j10);
    }

    @Override // w0.f
    public w0.d g(Context context, w0.e eVar) {
        return new C1600a(context, eVar);
    }

    @Override // w0.f
    public boolean h(Context context, String[] strArr, boolean z10) {
        String str;
        boolean z11 = false;
        if (strArr != null && CustCustomizeFeature.f14117a.k()) {
            String z12 = z(context);
            if (z12 == null) {
                str = strArr[0];
            } else {
                str = z12;
            }
            strArr[0] = str;
            if (z10) {
                strArr[1] = "IMEI:" + strArr[1];
            }
            if (!TextUtils.isEmpty(z12)) {
                z11 = true;
            }
        }
        Log.i("CustUtilsImpl", "isShowImeiSv = " + z11);
        return z11;
    }

    @Override // w0.f
    public boolean i(Context context) {
        boolean v10;
        if (context == null) {
            return false;
        }
        String[] stringArray = context.getResources().getStringArray(C1578b.f37131a);
        i.e(stringArray, "context.resources.getStr…rray.att_operator_mccmnc)");
        String[] stringArray2 = context.getResources().getStringArray(C1578b.f37132b);
        i.e(stringArray2, "context.resources.getStr….array.colo_operator_mcc)");
        if (stringArray.length > 0 && stringArray2.length > 0) {
            for (SubscriptionInfo subscriptionInfo : C1577a.a(context)) {
                if (subscriptionInfo != null) {
                    String c10 = C1577a.c(subscriptionInfo.getSimSlotIndex(), OplusPhoneUtils.PROPERTY_ICC_OPERATOR_NUMERIC, "");
                    if (TextUtils.isEmpty(c10)) {
                        continue;
                    } else {
                        for (String str : stringArray) {
                            if (i.b(c10, str)) {
                                if (H7.a.b()) {
                                    b.b("CustUtilsImpl", "equals att is true");
                                }
                                return true;
                            }
                        }
                        for (String str2 : stringArray2) {
                            i.e(str2, "colombiaNumberOfOperator[k]");
                            v10 = n.v(c10, str2, false, 2, null);
                            if (v10) {
                                if (H7.a.b()) {
                                    b.b("CustUtilsImpl", "equals colom is true");
                                }
                                return true;
                            }
                        }
                    }
                }
            }
            b.b("CustUtilsImpl", "isNeedShowSdnNumberSimCardActivated is false");
            return false;
        }
        b.b("CustUtilsImpl", "NumberOfOperator is null");
        return false;
    }

    @Override // w0.f
    public void init(Context context) {
        CustCustomizeFeature.f14117a.s(context);
    }

    @Override // w0.f
    public boolean j(String str, String str2) {
        return C1601b.a(str, str2);
    }

    @Override // w0.f
    public String k(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String C10 = C(str);
        if (C10 == null) {
            return D();
        }
        return C10;
    }

    @Override // w0.f
    public void l(long j10, ImageView imageView) {
        if (imageView == null) {
            return;
        }
        if (f(j10)) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    @Override // w0.f
    public void m(Context context, Uri uri) {
        Object b10;
        try {
            Result.a aVar = Result.f34166a;
            ContactsContract.QuickContact.showQuickContact(context, new Rect(), uri, 3, (String[]) null);
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            b.c("CustUtilsImpl", "startEnterpriseDetailActivity error" + d10.getMessage());
        }
    }

    @Override // w0.f
    public boolean n(Context context) {
        UserManager userManager;
        if (context != null) {
            userManager = (UserManager) context.getSystemService(UserManager.class);
        } else {
            userManager = null;
        }
        if (userManager == null) {
            return false;
        }
        return userManager.isManagedProfile();
    }

    @Override // w0.f
    public boolean o(Context context, String str, int i10, boolean z10) {
        CustCustomizeFeature custCustomizeFeature = CustCustomizeFeature.f14117a;
        if (!custCustomizeFeature.i() && (!custCustomizeFeature.l() || !t0.d.f37139g)) {
            return false;
        }
        v0.b d10 = v0.b.d(context);
        i.e(d10, "getInstance(context)");
        return d10.e(str, i10, true);
    }

    @Override // w0.f
    public boolean p(Uri uri) {
        Object b10;
        if (uri != null) {
            try {
                Result.a aVar = Result.f34166a;
                b10 = Result.b(Boolean.valueOf(ContactsContract.Contacts.isEnterpriseContactId(ContentUris.parseId(uri))));
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                b.c("CustUtilsImpl", "isNeedUpdateCallLogDatabase exception " + d10.getMessage());
            }
            Boolean bool = Boolean.FALSE;
            if (Result.f(b10)) {
                b10 = bool;
            }
            return ((Boolean) b10).booleanValue();
        }
        return false;
    }

    @Override // w0.f
    public String q(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String E10 = E(str);
        if (E10 == null) {
            return F(str);
        }
        return E10;
    }

    @Override // w0.f
    public boolean r(Context context) {
        if (context != null) {
            CustCustomizeFeature custCustomizeFeature = CustCustomizeFeature.f14117a;
            if (custCustomizeFeature.i() || custCustomizeFeature.m() || (custCustomizeFeature.l() && t0.d.f37139g)) {
                return !C1577a.a(context).isEmpty();
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
    
        if (r1 != false) goto L12;
     */
    @Override // w0.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.net.Uri s(java.lang.String r6) {
        /*
            r5 = this;
            boolean r5 = android.text.TextUtils.isEmpty(r6)
            if (r5 != 0) goto L58
            if (r6 != 0) goto L9
            goto L58
        L9:
            int r5 = r6.length()
            r0 = 1
            if (r5 <= r0) goto L2d
            java.lang.String r1 = ";"
            r2 = 0
            r3 = 2
            r4 = 0
            boolean r1 = kotlin.text.f.o(r6, r1, r2, r3, r4)
            if (r1 != 0) goto L23
            java.lang.String r1 = ","
            boolean r1 = kotlin.text.f.o(r6, r1, r2, r3, r4)
            if (r1 == 0) goto L2d
        L23:
            int r5 = r5 - r0
            java.lang.String r6 = r6.substring(r2, r5)
            java.lang.String r5 = "substring(...)"
            kotlin.jvm.internal.i.e(r6, r5)
        L2d:
            boolean r5 = H7.a.b()
            if (r5 == 0) goto L4d
            java.lang.String r5 = H7.a.d(r6)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "number = "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            java.lang.String r0 = "CustUtilsImpl"
            H7.b.e(r0, r5)
        L4d:
            android.net.Uri r5 = android.provider.ContactsContract.PhoneLookup.ENTERPRISE_CONTENT_FILTER_URI
            java.lang.String r6 = android.net.Uri.encode(r6)
            android.net.Uri r5 = android.net.Uri.withAppendedPath(r5, r6)
            return r5
        L58:
            android.net.Uri r5 = android.provider.ContactsContract.PhoneLookup.CONTENT_FILTER_URI
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.cust.business.export.CustExportImpl.s(java.lang.String):android.net.Uri");
    }

    @Override // w0.f
    public String t(Context context, ArrayList<String> arrayList, String str) {
        String b10 = C1601b.b(context, arrayList, str);
        i.e(b10, "getRespondingFdnName(con…phonesNumbers, fdnNumber)");
        return b10;
    }

    @Override // w0.f
    public boolean u(Context context, Uri uri, String str, int i10) {
        v0.b d10;
        boolean z10 = false;
        if (G() && uri == null && !TextUtils.isEmpty(str) && (d10 = v0.b.d(context)) != null) {
            try {
                z10 = d10.b(str, i10);
                if (H7.a.b()) {
                    b.b("CustUtilsImpl", " isSdn:" + z10);
                }
            } catch (Exception e10) {
                b.c("CustUtilsImpl", "error" + e10);
            }
        }
        return z10;
    }

    @Override // w0.f
    public String v(Context context, String str) {
        return C1601b.c(context, str);
    }

    @Override // w0.f
    public boolean w() {
        return CustCustomizeFeature.f14117a.g();
    }

    @Override // w0.f
    public void x(m mVar, String str, int i10) {
        CustCustomizeFeature custCustomizeFeature = CustCustomizeFeature.f14117a;
        if (custCustomizeFeature.i() || custCustomizeFeature.l()) {
            b.b("CustUtilsImpl", "refreshSdnData");
            if (mVar != null) {
                try {
                    mVar.b(str, i10);
                } catch (Exception e10) {
                    b.c("CustUtilsImpl", "querySdnInformation error" + e10);
                }
            }
        }
    }

    public final String z(Context context) {
        String str = "";
        if (context == null) {
            return "";
        }
        try {
            Object systemService = context.getSystemService("phone");
            i.d(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            str = ((TelephonyManager) systemService).getDeviceSoftwareVersion();
        } catch (Exception e10) {
            Log.e("CustUtilsImpl", "get sv error: " + e10);
        }
        Log.i("CustUtilsImpl", "imeiSv = " + str);
        return str;
    }
}
