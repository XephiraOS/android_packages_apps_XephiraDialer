package B3;

import R0.b;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.android.contacts.compat.data.f;
import com.android.contacts.framework.baseui.util.C0638c;
import com.android.contacts.voicemail.LegacyVoicemailNotificationReceiver;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.feature.OSCustomizeFeature;
import com.customize.contacts.feature.OSPublicFeature;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import com.oplus.foundation.util.feature.VirtualSupportUtils;
import java.util.Arrays;
import kotlin.jvm.internal.i;
import kotlin.text.Regex;
import kotlin.text.n;
import r0.g;

/* compiled from: FeatureUtils.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f244a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f245b;

    public static final boolean A() {
        OSCustomizeFeature oSCustomizeFeature = OSCustomizeFeature.f20960a;
        Boolean s10 = oSCustomizeFeature.s();
        if (s10 != null) {
            return s10.booleanValue();
        }
        return oSCustomizeFeature.t();
    }

    public static final boolean B() {
        if (FeatureOption.i() && !CommonFeatureOption.f28289a.g()) {
            return true;
        }
        return false;
    }

    public static final boolean C() {
        return OSCustomizeFeature.f20960a.i();
    }

    public static final boolean D() {
        return OSCustomizeFeature.f20960a.v();
    }

    public static final boolean E() {
        return OSCustomizeFeature.f20960a.w();
    }

    public static final boolean F() {
        if (!m() && CommonFeatureOption.j() && !VirtualSupportUtils.m() && com.android.contacts.framework.api.appstore.appinfo.a.f15529a.l()) {
            return true;
        }
        return false;
    }

    public static final boolean G() {
        return OSPublicFeature.f21034a.q();
    }

    public static final boolean H() {
        return OSCustomizeFeature.f20960a.z();
    }

    public static final boolean I() {
        return OSPublicFeature.f21034a.r();
    }

    public static final boolean J() {
        return OSCustomizeFeature.f20960a.j();
    }

    public static final boolean K() {
        return OSPublicFeature.f21034a.s();
    }

    public static final boolean L() {
        return OSCustomizeFeature.f20960a.A();
    }

    public static final boolean M(Context context) {
        if (context == null) {
            return f245b;
        }
        try {
            f245b = !TextUtils.isEmpty(G0.c.l(context, 1, f.a("customize_mms_rcs_config_server_address"), 0, 8, null));
        } catch (SecurityException e10) {
            H7.b.c("FeatureUtils", "isSupportExportSalesRCS: " + e10);
        }
        if (H7.a.b()) {
            H7.b.b("FeatureUtils", "isSupportExpRCS: sRcsSwitch = " + f245b);
        }
        return f245b;
    }

    public static final boolean N(int i10) {
        if (OSCustomizeFeature.n()) {
            return true;
        }
        if (i10 == 2 && f244a.O()) {
            return true;
        }
        return false;
    }

    public static final boolean P() {
        if (!FeatureOption.i() && !x()) {
            return false;
        }
        return true;
    }

    public static final boolean Q() {
        return V();
    }

    public static final boolean R() {
        if (OsUtils.f28275a.i()) {
            return true;
        }
        return OSPublicFeature.f21034a.u();
    }

    public static final boolean S() {
        return OSPublicFeature.f21034a.v();
    }

    public static final boolean T() {
        if (OsUtils.f28275a.i()) {
            return true;
        }
        return OSPublicFeature.f21034a.w();
    }

    public static final boolean U() {
        return OSPublicFeature.f21034a.x();
    }

    public static final boolean V() {
        OSPublicFeature oSPublicFeature = OSPublicFeature.f21034a;
        if (oSPublicFeature.y() == null) {
            OSPublicFeature.H();
        }
        Boolean y10 = oSPublicFeature.y();
        if (y10 != null) {
            return y10.booleanValue();
        }
        return false;
    }

    public static final boolean W() {
        if (FeatureOption.o()) {
            OSPublicFeature oSPublicFeature = OSPublicFeature.f21034a;
            if ((oSPublicFeature.A() || oSPublicFeature.p()) && CommonFeatureOption.j() && !VirtualSupportUtils.m() && !com.android.contacts.framework.api.appstore.appinfo.a.k()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean X() {
        return OSCustomizeFeature.f20960a.B();
    }

    public static final boolean Y() {
        return OSCustomizeFeature.f20960a.C();
    }

    public static final boolean Z() {
        return OSPublicFeature.f21034a.B();
    }

    public static final String a(String str) {
        String a10;
        if (OsUtils.c()) {
            a10 = OSCustomizeFeature.f20960a.q();
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

    public static final boolean a0() {
        return OSCustomizeFeature.f20960a.F();
    }

    public static final boolean b0() {
        return OSPublicFeature.f21034a.C();
    }

    public static final String c() {
        if (OsUtils.c()) {
            return OSCustomizeFeature.f20960a.r();
        }
        return M7.d.b(b.a.f3182b, "CN");
    }

    public static final boolean c0() {
        if (CommonFeatureOption.j() && !VirtualSupportUtils.m()) {
            return true;
        }
        return false;
    }

    public static final boolean d() {
        return OSPublicFeature.f21034a.e();
    }

    public static final boolean d0() {
        return f245b;
    }

    public static final boolean e() {
        if (OSCustomizeFeature.f20960a.h() && FeatureOption.o()) {
            return true;
        }
        return false;
    }

    public static final void e0(Context context, boolean z10) {
        if (context != null) {
            if (z10) {
                context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, (Class<?>) LegacyVoicemailNotificationReceiver.class), 1, 1);
            } else {
                context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, (Class<?>) LegacyVoicemailNotificationReceiver.class), 2, 1);
            }
        }
    }

    public static final boolean f() {
        return OSCustomizeFeature.f20960a.k();
    }

    public static final boolean f0() {
        return OSCustomizeFeature.f20960a.l();
    }

    public static final boolean g() {
        return OSPublicFeature.f21034a.h();
    }

    public static final boolean h() {
        return OSPublicFeature.f21034a.i();
    }

    public static final boolean i() {
        if (OsUtils.f28275a.i() || R() || T()) {
            return true;
        }
        return false;
    }

    public static final boolean j() {
        String hardware = Build.HARDWARE;
        i.e(hardware, "hardware");
        return new Regex("mt[0-9]*").a(hardware);
    }

    public static final boolean k() {
        String hardware = Build.HARDWARE;
        i.e(hardware, "hardware");
        return new Regex("qcom").a(hardware);
    }

    public static final boolean l() {
        return OSPublicFeature.f21034a.j();
    }

    public static final boolean m() {
        return OSPublicFeature.f21034a.k();
    }

    public static final boolean n() {
        return OSCustomizeFeature.f20960a.m();
    }

    public static final boolean o() {
        return OSPublicFeature.f21034a.l();
    }

    public static final boolean p() {
        if (!C0638c.f15889a.d() && !VirtualSupportUtils.m() && com.android.contacts.framework.api.appstore.appinfo.a.f15529a.l()) {
            return false;
        }
        return true;
    }

    public static final boolean q(Context context) {
        if (CommonFeatureOption.f28289a.f()) {
            return true;
        }
        if (context != null) {
            try {
                if (G0.c.d(context, 1, f.a("customize_contacts_hide_card_recognize"), 0) > 0) {
                    return true;
                }
            } catch (SecurityException e10) {
                H7.b.c("FeatureUtils", "Exception e: " + e10);
            }
        }
        if (!I()) {
            return true;
        }
        H7.b.b("FeatureUtils", "isNeedHideCardRecognize, false");
        return false;
    }

    public static final boolean r() {
        return OSCustomizeFeature.f20960a.o();
    }

    public static final boolean s(Context context) {
        return t(context, OSPublicFeature.f21034a.o());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean t(android.content.Context r5, boolean r6) {
        /*
            java.lang.String r0 = "FeatureUtils"
            r1 = 0
            if (r5 == 0) goto L50
            if (r6 != 0) goto L8
            goto L50
        L8:
            r6 = 1
            java.lang.String r2 = "customize_mms_rcs_process_run_background"
            java.lang.String r2 = com.android.contacts.compat.data.f.a(r2)     // Catch: java.lang.SecurityException -> L17
            int r2 = G0.c.d(r5, r6, r2, r1)     // Catch: java.lang.SecurityException -> L17
            if (r2 <= 0) goto L2c
            r2 = r6
            goto L2d
        L17:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "isNeedShowSMSGroupChat = "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            H7.b.c(r0, r2)
        L2c:
            r2 = r1
        L2d:
            boolean r3 = H7.a.b()
            if (r3 == 0) goto L47
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "isAvailable = "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            H7.b.b(r0, r3)
        L47:
            if (r2 == 0) goto L50
            boolean r5 = com.customize.contacts.util.C0811w.h(r5)
            if (r5 == 0) goto L50
            r1 = r6
        L50:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: B3.a.t(android.content.Context, boolean):boolean");
    }

    public static final boolean u() {
        return v(FeatureOption.o(), V());
    }

    public static final boolean v(boolean z10, boolean z11) {
        if (z10 && !z11) {
            return false;
        }
        return true;
    }

    public static final boolean w() {
        return OSPublicFeature.f21034a.A();
    }

    public static final boolean x() {
        boolean p10;
        p10 = n.p("OC", M7.d.b(b.a.f3181a, "CN"), true);
        return p10;
    }

    public static final boolean y() {
        return OSPublicFeature.f21034a.m();
    }

    public static final boolean z() {
        return OSPublicFeature.f21034a.n();
    }

    public final boolean O() {
        String c10 = c();
        String[] d10 = R0.b.d();
        return Arrays.asList(Arrays.copyOf(d10, d10.length)).contains(c10);
    }

    public final boolean b() {
        return f245b;
    }
}
