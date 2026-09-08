package o0;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.android.contacts.Engineer.NetworkEngineerModeUtil;
import com.android.incallui.OplusPhoneUtils;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.util.b0;
import com.oplus.dialer.R;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import com.oplus.foundation.util.feature.VirtualSupportUtils;
import java.lang.reflect.Method;
import java.util.List;
import w0.C1641a;
import w0.C1643c;

/* compiled from: SpecialCharSequenceMgr.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f35672a;

    /* compiled from: SpecialCharSequenceMgr.java */
    /* loaded from: classes.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f35673a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f35674b;

        public a(String str, Context context) {
            this.f35673a = str;
            this.f35674b = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            String str = this.f35673a;
            int r10 = D7.c.r(this.f35674b, Integer.valueOf(i10));
            if (!SubscriptionManager.isValidSubscriptionId(r10)) {
                return;
            }
            H7.b.b("SpecialCharSequenceMgr", " handlePinEntry pinSubId=" + r10);
            f.f35672a = D7.c.f(Integer.valueOf(r10), str);
            dialogInterface.dismiss();
        }
    }

    public static String c() {
        try {
            Method declaredMethod = Build.class.getDeclaredMethod("getPhoneSerial", null);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, null);
                if (invoke == null || "unknown".equals(invoke)) {
                    return "";
                }
                return invoke.toString();
            }
        } catch (Throwable th) {
            H7.b.c("SpecialCharSequenceMgr", "ex = " + th);
        }
        return null;
    }

    public static String d() {
        String str;
        try {
            if (FeatureOption.o()) {
                String a10 = M7.d.a("persist.sys.oplus.serialno");
                if (!TextUtils.isEmpty(a10)) {
                    return a10;
                }
            }
            if (CommonFeatureOption.n()) {
                str = M7.d.a("vendor.gsm.phoneserial");
                if (TextUtils.isEmpty(str)) {
                    str = M7.d.a("gsm.phoneserial");
                }
                H7.b.e("SpecialCharSequenceMgr", "getSerialNumber: snStr is empty first: " + TextUtils.isEmpty(str));
                if (TextUtils.isEmpty(str)) {
                    str = c();
                }
                H7.b.e("SpecialCharSequenceMgr", "getSerialNumber: snStr is empty second : " + TextUtils.isEmpty(str));
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            if (TextUtils.equals(M7.d.a("persist.sys.factory.sn16"), OplusPhoneUtils.DeviceState.LOCK_DEVICE)) {
                return M7.d.a("ro.boot.chipecid");
            }
            return Build.getSerial();
        } catch (Throwable th) {
            H7.b.c("SpecialCharSequenceMgr", "th = " + th);
            return "";
        }
    }

    public static boolean e(Context context, String str) {
        if (C1643c.w()) {
            return C1643c.o(context, str);
        }
        return false;
    }

    public static boolean f(Context context, String str, String str2) {
        NetworkEngineerModeUtil.f13131a.c(str2, 0);
        if ("*#07#".equals(str) && C1643c.v()) {
            return false;
        }
        if (g(context, str)) {
            return true;
        }
        if (C1390c.g(context, str2)) {
            H7.b.i("SpecialCharSequenceMgr", "handleEngineerTestCommands ");
            return true;
        }
        if (h(context, str) || k(context, str) || j(context, str)) {
            return true;
        }
        if (C1643c.v() && C1643c.p(context, str)) {
            return true;
        }
        if (!C1643c.w() || !C1643c.G(context, str)) {
            return false;
        }
        return true;
    }

    public static boolean g(Context context, String str) {
        if (!"*#06#".equals(str)) {
            return false;
        }
        if (!com.android.contacts.framework.api.permission.a.b()) {
            return true;
        }
        if (FeatureOption.o() && CommonFeatureOption.m() && (!CommonFeatureOption.j() || VirtualSupportUtils.m())) {
            return true;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return false;
        }
        if (B3.a.i()) {
            if (FeatureOption.o()) {
                p(context, telephonyManager);
            } else {
                n(context, telephonyManager);
            }
            return true;
        }
        o(context);
        return true;
    }

    public static boolean h(Context context, String str) {
        if (B3.a.h()) {
            return i(context, str);
        }
        if ((!str.startsWith("**04") && !str.startsWith("**05")) || !str.endsWith("#")) {
            return false;
        }
        if (B3.a.T()) {
            try {
                long defaultVoiceSubscriptionId = SubscriptionManager.getDefaultVoiceSubscriptionId();
                if (defaultVoiceSubscriptionId == -1000) {
                    defaultVoiceSubscriptionId = 0;
                }
                return D7.c.f(Integer.valueOf((int) defaultVoiceSubscriptionId), str);
            } catch (Throwable th) {
                H7.b.c("SpecialCharSequenceMgr", "handlePinEntry, The e is " + th);
                return false;
            }
        }
        return ((TelecomManager) context.getSystemService("telecom")).handleMmi(str);
    }

    public static boolean i(Context context, String str) {
        int size;
        if ((str.startsWith("**04") || str.startsWith("**05")) && str.endsWith("#")) {
            if (B3.a.i()) {
                List<SubscriptionInfo> e10 = b0.e(context);
                if (e10.isEmpty()) {
                    size = 0;
                } else {
                    size = e10.size();
                }
                H7.b.b("SpecialCharSequenceMgr", "SimCount:" + size);
                String string = context.getResources().getString(R.string.oplus_title_sim_card);
                if (size > 1) {
                    new COUIAlertDialogBuilder(context).setTitle((CharSequence) string).setCancelable(false).setSingleChoiceItems(new String[]{"sim1", "sim2"}, 0, new a(str, context)).show();
                    return f35672a;
                }
                try {
                    long defaultVoiceSubscriptionId = SubscriptionManager.getDefaultVoiceSubscriptionId();
                    int i10 = (int) defaultVoiceSubscriptionId;
                    H7.b.e("SpecialCharSequenceMgr", "handlePinEntry,subId = " + defaultVoiceSubscriptionId + " ,tempSubId = " + i10);
                    return D7.c.f(Integer.valueOf(i10), str);
                } catch (Exception e11) {
                    H7.b.c("SpecialCharSequenceMgr", "Exception occur in  handlePinEntryExp " + e11);
                }
            } else {
                return ((TelecomManager) context.getSystemService("telecom")).handleMmi(str);
            }
        }
        return false;
    }

    public static boolean j(Context context, String str) {
        if (!str.equals("*#07#")) {
            return false;
        }
        H7.b.b("SpecialCharSequenceMgr", "handleRegulatoryInfoDisplay() sending intent to settings app");
        Intent intent = new Intent("android.settings.SHOW_REGULATORY_INFO");
        H7.b.b("SpecialCharSequenceMgr", "Settings.ACTION_SHOW_REGULATORY_INFO = android.settings.SHOW_REGULATORY_INFO");
        R7.b.d(context, intent, 0);
        return true;
    }

    public static boolean k(Context context, String str) {
        int length = str.length();
        if (length > 8 && str.startsWith("*#*#") && str.endsWith("#*#*")) {
            try {
                ((TelephonyManager) context.getSystemService(TelephonyManager.class)).sendDialerSpecialCode(str.substring(4, length - 4));
                return true;
            } catch (Exception e10) {
                H7.b.b("SpecialCharSequenceMgr", "handleSecretCode,the e is " + e10);
                return true;
            }
        }
        return false;
    }

    public static TextView l(final Context context, androidx.appcompat.app.b bVar, int i10, boolean z10) {
        int i11;
        final TextView textView = (TextView) bVar.findViewById(i10);
        if (z10) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        textView.setVisibility(i11);
        textView.setClickable(true);
        textView.setOnLongClickListener(new View.OnLongClickListener() { // from class: o0.e
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean m10;
                m10 = f.m(context, textView, view);
                return m10;
            }
        });
        return textView;
    }

    public static /* synthetic */ boolean m(Context context, TextView textView, View view) {
        try {
            ((ClipboardManager) context.getSystemService("clipboard")).setText(textView.getText().toString());
            Toast.makeText(context, R.string.text_copied, 1).show();
        } catch (Exception e10) {
            H7.b.b("SpecialCharSequenceMgr", " imeiLongPressCopy Exception e" + e10);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0070 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void n(android.content.Context r14, android.telephony.TelephonyManager r15) {
        /*
            Method dump skipped, instructions count: 505
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.f.n(android.content.Context, android.telephony.TelephonyManager):void");
    }

    public static void o(Context context) {
        String str;
        String str2;
        try {
            str = ((TelephonyManager) context.getSystemService(TelephonyManager.class)).getImei(0);
        } catch (Throwable th) {
            H7.b.c("SpecialCharSequenceMgr", "showIMEIPanel th = " + th);
            str = null;
        }
        String[] strArr = {"", str};
        boolean p10 = C1641a.p(context, strArr);
        if (p10) {
            String str3 = strArr[0];
            String str4 = strArr[1];
            str2 = str3;
            str = str4;
        } else {
            str2 = null;
        }
        androidx.appcompat.app.b show = new COUIAlertDialogBuilder(context).setTitle(R.string.imei).setView(R.layout.alert_dialog_for_imei).setPositiveButton(R.string.oplus_know, (DialogInterface.OnClickListener) null).show();
        l(context, show, R.id.message_meid, false);
        l(context, show, R.id.message_imei1, true).setText(str);
        l(context, show, R.id.message_imei2, false);
        l(context, show, R.id.message_imeisv, p10).setText("SVN:" + str2);
        if (FeatureOption.i()) {
            String d10 = d();
            l(context, show, R.id.message_sn, !TextUtils.isEmpty(d10)).setText("SN:" + d10);
        }
        show.setCanceledOnTouchOutside(false);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:5|(2:6|7)|8|9|10|(1:12)|13|(1:15)(1:26)|16|(1:18)(1:25)|19|(1:21)|22|23) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0041, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0042, code lost:
    
        H7.b.c("SpecialCharSequenceMgr", "" + r5);
        r5 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void p(android.content.Context r13, android.telephony.TelephonyManager r14) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.f.p(android.content.Context, android.telephony.TelephonyManager):void");
    }
}
