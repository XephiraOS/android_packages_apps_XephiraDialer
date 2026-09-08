package o0;

import R0.b;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.android.contacts.Engineer.CommonLogSwitchActivity;
import com.android.contacts.dialpad.SimInfoManager;
import com.android.incallui.OplusPhoneCapabilities;
import com.android.incallui.OplusPhoneUtils;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.util.b0;
import com.oplus.dialer.R;
import com.oplus.foundation.util.OsUtils;
import java.util.ArrayList;
import java.util.Arrays;
import r0.C1498a;
import r0.C1499b;
import r0.C1501d;
import w0.C1641a;

/* compiled from: EngineerCharSequence.java */
/* renamed from: o0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1390c {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f35665a = {"CHT", "FET", "TWM", "VBO", "TWOP", "APT"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f35666b = {"SGOP", "SINGTEL", "STARHUB", "M1", "MYREPUBLIC", "TPG"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f35667c = {"2DEGREES", "SPARK", "NZOP", "SKINNY", "WAREHOUSE", "VODAFONE_NZ"};

    /* renamed from: d, reason: collision with root package name */
    public static final String f35668d = com.android.contacts.compat.data.f.a("oplus_customize_simettings_network_mode_visible");

    /* renamed from: e, reason: collision with root package name */
    public static String f35669e = null;

    public static String a(String str) {
        String a10 = B3.a.a("EX");
        if (H7.a.b()) {
            H7.b.b("EngineerCharSequence", "getCarrierVersion(), the carrierVersion = " + a10);
        }
        if (TextUtils.isEmpty(a10)) {
            return "EX";
        }
        if (Arrays.asList(f35665a).contains(a10.toUpperCase())) {
            return "TW";
        }
        if (Arrays.asList(f35666b).contains(a10.toUpperCase())) {
            return "SG";
        }
        if (Arrays.asList(f35667c).contains(a10.toUpperCase())) {
            return "NZ";
        }
        if (a10.equalsIgnoreCase("SGM1")) {
            return "SG-M1";
        }
        if (!a10.startsWith("OPTUS")) {
            if (a10.equalsIgnoreCase("GLOBE")) {
                return "PH-GLB";
            }
            if (a10.startsWith("VODAFONE") && "AU".equals(str)) {
                return "AU-VHA";
            }
            if (a10.startsWith("VIRGIN")) {
                return "AU-V";
            }
            if (!a10.equalsIgnoreCase("TELSTRA_POSTPAID")) {
                String str2 = "EE";
                if (!a10.equalsIgnoreCase("EE")) {
                    str2 = "O2";
                    if (!a10.equalsIgnoreCase("O2")) {
                        return "EX";
                    }
                }
                return str2;
            }
        }
        return "AU";
    }

    public static String b() {
        String a10 = B3.a.a("null");
        if (!"null".equals(a10)) {
            String b10 = M7.d.b("ro.operator.display." + a10, "null");
            if (!"null".equals(b10)) {
                return b10;
            }
            return null;
        }
        return null;
    }

    public static String c() {
        return f35669e;
    }

    public static String d(String str) {
        if (C7.f.b()) {
            return M7.d.a("ro.build.display.id.show");
        }
        return str;
    }

    public static boolean e(Context context) {
        ArrayList<b0.a> d10;
        b0.a aVar;
        if (C1641a.r()) {
            return false;
        }
        SimInfoManager simInfoManager = new SimInfoManager();
        simInfoManager.h(context, null);
        if (simInfoManager.c() != 1 || (d10 = simInfoManager.d()) == null || d10.size() <= 0 || (aVar = d10.get(0)) == null) {
            return false;
        }
        int i10 = aVar.f22051a;
        if (k(context, "com.android.phone", "com.android.simsettings.apn.ApnSettings", i10)) {
            return true;
        }
        k(context, C1501d.f36276e, C1499b.f36269b, i10);
        return true;
    }

    public static boolean f(Context context) {
        if (!H7.a.b()) {
            return false;
        }
        context.getContentResolver();
        String str = f35668d;
        try {
            int d10 = G0.c.d(context, 2, str, 0);
            if (d10 == 1) {
                G0.c.n(context, 2, str, 0);
                com.oplus.foundation.util.ui.c.b(context, R.string.not_show_network_mode);
            } else if (d10 == 0) {
                G0.c.n(context, 2, str, 1);
                com.oplus.foundation.util.ui.c.b(context, R.string.show_network_mode);
            }
            return true;
        } catch (Exception e10) {
            H7.b.b("EngineerCharSequence", "handleDynamicalShowNetworkMode : " + e10);
            return false;
        }
    }

    public static boolean g(Context context, String str) {
        if (str == null || str == "") {
            return false;
        }
        try {
            if (TextUtils.equals(f35669e, str)) {
                return false;
            }
            f35669e = str;
            if (str.equals("#*#*9567*#*#")) {
                return f(context);
            }
            if (str.equals("*#1234#")) {
                i(context);
                return true;
            }
            if (str.equals("*#564#")) {
                Intent intent = new Intent(context, (Class<?>) CommonLogSwitchActivity.class);
                intent.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
                R7.b.c(context, intent);
                return true;
            }
            if (str.equals("##467#")) {
                return e(context);
            }
            if (str.equals("*#547967#") && !OsUtils.g()) {
                Intent intent2 = new Intent(C1498a.f36260s);
                intent2.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
                R7.b.c(context, intent2);
                return true;
            }
            int length = str.length();
            if (str.startsWith("*#") && str.endsWith("#")) {
                if (length < 4) {
                    return false;
                }
                H7.b.e("EngineerCharSequence", "sendBroadcast to EngineerModeTest input:: ");
                Intent intent3 = new Intent(C1498a.f36238A);
                intent3.putExtra("order", str);
                if (OsUtils.f28279e) {
                    intent3.setFlags(32);
                }
                context.sendBroadcast(intent3, R0.b.f3175i);
                return false;
            }
            if (str.startsWith("#") && str.endsWith("#")) {
                if (str.contains(" ")) {
                    str = U7.f.f(str);
                }
                if (!TextUtils.isEmpty(str) && str.length() > 2) {
                    if (H7.a.b()) {
                        H7.b.b("EngineerCharSequence", "sendBroadcast to EngineerModeTest input:: ");
                    }
                    String substring = str.substring(1, str.length() - 1);
                    Intent intent4 = new Intent(C1498a.f36261t);
                    intent4.putExtra("password", substring);
                    context.sendBroadcast(intent4, R0.b.f3175i);
                }
            }
            return false;
        } finally {
            f35669e = str;
        }
    }

    public static void h(String str) {
        f35669e = str;
    }

    public static void i(Context context) {
        if (FeatureOption.o()) {
            j(context);
        } else {
            new COUIAlertDialogBuilder(context).setTitle(R.string.oplus_version).setMessage((CharSequence) d(Build.DISPLAY)).setPositiveButton(R.string.oplus_know, (DialogInterface.OnClickListener) null).show();
        }
    }

    public static void j(Context context) {
        int i10;
        String b10;
        boolean z10;
        String str;
        String[] split;
        String str2 = Build.DISPLAY;
        try {
            i10 = Integer.parseInt(M7.d.b("ro.product.first_api_level", OplusPhoneUtils.DeviceState.UNLOCK_DEVICE));
        } catch (NumberFormatException e10) {
            H7.b.c("EngineerCharSequence", "NumberFormatException ex : " + e10);
            i10 = -1;
        }
        H7.b.b("EngineerCharSequence", "The firstApiLevel is " + i10);
        if (i10 < 29) {
            String b11 = M7.d.b(b.a.f3181a, "CN");
            if (H7.a.b()) {
                H7.b.b("EngineerCharSequence", "The region is " + b11);
            }
            if (!"SG".equals(b11) && !"TW".equals(b11) && !"AU".equals(b11) && !"PH".equals(b11) && !"NZ".equals(b11) && !"GB".equals(b11)) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (b() != null) {
                b10 = b();
            } else {
                String b12 = M7.d.b("ro.vendor.oplus.exp.version", "");
                if (TextUtils.isEmpty(b12)) {
                    str = M7.d.b("ro.vendor.oppo.exp.version", Build.DISPLAY);
                } else {
                    str = b12;
                }
                if (z10) {
                    if (("SG".equals(b11) || "TW".equals(b11)) && !str.contains(b11) && (split = str.split("_")) != null) {
                        str = str.replace(split[0], split[0] + b11);
                    }
                    b10 = str.replace(b11, a(b11));
                } else {
                    b10 = str;
                }
            }
        } else {
            b10 = M7.d.b("ro.vendor.oplus.exp.version", "");
            if (TextUtils.isEmpty(b10)) {
                b10 = M7.d.b("ro.vendor.oppo.exp.version", Build.DISPLAY);
            }
        }
        new COUIAlertDialogBuilder(context).setTitle((CharSequence) "Version").setMessage((CharSequence) d(b10)).setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) null).setCancelable(false).show();
    }

    public static boolean k(Context context, String str, String str2, int i10) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        intent.putExtra(D7.a.r(), i10);
        intent.putExtra("show_ims_from_dial", "show_ims_from_dial");
        return R7.b.d(context, intent, 0);
    }
}
