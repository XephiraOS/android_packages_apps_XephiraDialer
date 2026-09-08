package l7;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import c7.C0566b;
import com.oplus.coreapp.appfeature.AppFeatureProviderUtils;
import com.oplus.feature.NumberRecognitionRegionSupportUtil;
import com.oplus.utils.C0844e;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0848i;
import com.oplus.utils.G;
import l7.C1296a;

/* compiled from: FeatureOption.java */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: A, reason: collision with root package name */
    public static boolean f34730A = false;

    /* renamed from: B, reason: collision with root package name */
    public static String f34731B = null;

    /* renamed from: C, reason: collision with root package name */
    public static Boolean f34732C = null;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f34733a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f34734b = false;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f34735c = false;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f34736d = false;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f34737e = false;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f34738f = false;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f34739g = true;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f34740h = true;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f34741i = true;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f34742j = false;

    /* renamed from: k, reason: collision with root package name */
    public static boolean f34743k = false;

    /* renamed from: l, reason: collision with root package name */
    public static boolean f34744l = false;

    /* renamed from: m, reason: collision with root package name */
    public static boolean f34745m = true;

    /* renamed from: n, reason: collision with root package name */
    public static boolean f34746n = true;

    /* renamed from: o, reason: collision with root package name */
    public static boolean f34747o = true;

    /* renamed from: p, reason: collision with root package name */
    public static boolean f34748p = false;

    /* renamed from: q, reason: collision with root package name */
    public static boolean f34749q = false;

    /* renamed from: r, reason: collision with root package name */
    public static boolean f34750r = false;

    /* renamed from: s, reason: collision with root package name */
    public static boolean f34751s = false;

    /* renamed from: t, reason: collision with root package name */
    public static boolean f34752t = false;

    /* renamed from: u, reason: collision with root package name */
    public static boolean f34753u = false;

    /* renamed from: v, reason: collision with root package name */
    public static boolean f34754v = false;

    /* renamed from: w, reason: collision with root package name */
    public static boolean f34755w = false;

    /* renamed from: x, reason: collision with root package name */
    public static boolean f34756x = false;

    /* renamed from: y, reason: collision with root package name */
    public static boolean f34757y = false;

    /* renamed from: z, reason: collision with root package name */
    public static boolean f34758z = false;

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        PackageManager packageManager = context.getPackageManager();
        ContentResolver contentResolver = context.getContentResolver();
        f34733a = true;
        f34734b = C1296a.t(packageManager, contentResolver, "", "com.oplus.blacklistapp.disable_fake_bs");
        boolean j10 = j("domestic");
        f34735c = j10;
        f34737e = true ^ j10;
        C1296a.C0330a c0330a = C1296a.f34729a;
        f34738f = c0330a.b(packageManager, contentResolver, "", "com.oplus.blacklistapp.hide_call_harass_intercept");
        n(context);
        m(context, packageManager, f34737e);
        l(context, f34737e);
        f34749q = c0330a.b(packageManager, contentResolver, "", "com.oplus.blacklistapp.harass_intercept_anonymous_etc");
        f34750r = c0330a.b(packageManager, contentResolver, "", "com.oplus.blacklistapp.special_number_expand_detail");
        f34753u = c0330a.b(packageManager, contentResolver, "", "com.oplus.blacklistapp.hide_intercept_unknown_number_dialog");
        f34754v = c0330a.b(packageManager, contentResolver, "", "com.oplus.blacklistapp.mms_rcs_support");
        f34756x = C0848i.q(context, "com.android.mms", "com.oplus.mms.intent.RCS_CHATBOT_BLACKLIST");
        f34757y = C0848i.q(context, "com.android.mms", "com.oplus.mms.intent.SHOP_BLACKLIST");
        f34731B = c0330a.a(contentResolver, "com.oplus.blacklistapp.region_mark", "CN");
        f34755w = c0330a.b(packageManager, contentResolver, "", "com.oplus.blacklistapp.disable_volte_vowifi_icon");
        f34758z = c0330a.b(packageManager, contentResolver, "", "com.oplus.blacklistapp.remove_block_messages_menu");
        f34730A = AppFeatureProviderUtils.p(contentResolver, "com.android.launcher.TASKBAR_ENABLE");
    }

    public static boolean b(Activity activity) {
        if (!f34740h && !f34741i) {
            return false;
        }
        return true;
    }

    public static boolean c(Context context) {
        return G.g(context);
    }

    public static boolean d() {
        return f34736d;
    }

    public static boolean e() {
        return f34758z;
    }

    public static boolean f() {
        return f34750r;
    }

    public static boolean g(Context context) {
        try {
            return AppFeatureProviderUtils.p(context.getContentResolver(), "com.oplus.ocar.drivemode.enable");
        } catch (Exception e10) {
            Log.e("FeatureOption", "Exception :" + e10);
            return false;
        }
    }

    public static boolean h(Context context) {
        if (f34732C == null) {
            boolean z10 = false;
            if (context == null) {
                return false;
            }
            if (!C0844e.f29134b && C0844e.c(context, "com.android.mms", "block_sms_and_call_support")) {
                z10 = true;
            }
            f34732C = Boolean.valueOf(z10);
            C0846g.i("FeatureOption", "isSupportFunctionBlock " + f34732C);
        }
        return f34732C.booleanValue();
    }

    public static boolean i() {
        if (!C0844e.l()) {
            return "TW".equals(C0566b.b("ro.vendor.oplus.regionmark", "CN"));
        }
        return "TW".equals(f34731B);
    }

    public static boolean j(String str) {
        return "gdpr".equalsIgnoreCase(str);
    }

    public static boolean k() {
        if ((f34744l || f34754v) && C0844e.f29133a && !f34756x) {
            return true;
        }
        return false;
    }

    public static void l(Context context, boolean z10) {
        boolean z11;
        if (z10) {
            if (!C0844e.f29134b && !C0848i.p(context, "com.android.contacts")) {
                z11 = true;
            } else {
                z11 = false;
            }
            f34743k = z11;
        }
    }

    public static void m(Context context, PackageManager packageManager, boolean z10) {
        boolean z11;
        if (z10) {
            if (!C0844e.f29134b && C0848i.p(context, "com.android.mms")) {
                z11 = false;
            } else {
                z11 = true;
            }
            f34742j = z11;
        }
    }

    public static void n(Context context) {
        boolean z10;
        C0846g.i("FeatureOption", "setTedNumberRecognitionSupport");
        if (f34737e) {
            if (context == null) {
                return;
            }
            boolean z11 = false;
            if (C0844e.f29134b) {
                f34736d = false;
                return;
            }
            if (!C1296a.f34729a.b(context.getPackageManager(), context.getContentResolver(), "", "com.oplus.blacklistapp.number_recognition") && !NumberRecognitionRegionSupportUtil.c()) {
                z10 = false;
            } else {
                z10 = true;
            }
            boolean z12 = !C0848i.p(context, "com.ted.number");
            if (z10 && !z12) {
                z11 = true;
            }
            f34736d = z11;
            return;
        }
        f34736d = f34735c;
    }

    public static boolean o() {
        return f34749q;
    }

    public static boolean p() {
        if (f34742j && f34748p) {
            return true;
        }
        return false;
    }
}
