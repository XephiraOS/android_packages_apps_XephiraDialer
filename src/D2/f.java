package D2;

import A2.A;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.android.incallui.Call;
import com.android.incallui.ContactInfoCache;
import com.android.incallui.InCallPresenter;
import com.android.incallui.Log;
import com.android.incallui.OplusFeatureOption;
import com.android.incallui.OplusPhoneCapabilities;
import com.android.incallui.OplusPhoneUserActionStatistics;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.oplus.share.OplusInCallDialogActivity;
import com.internal_dependency.SettingsUtils;
import java.util.HashMap;

/* compiled from: OplusInterceptUtils.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static int f437a = -1;

    /* renamed from: b, reason: collision with root package name */
    public static OplusInCallDialogActivity f438b = null;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f439c = false;

    /* renamed from: d, reason: collision with root package name */
    public static final char[] f440d = {'2', '3', '5', '7', '8'};

    /* renamed from: e, reason: collision with root package name */
    public static boolean f441e = false;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f442f = false;

    /* renamed from: g, reason: collision with root package name */
    public static int f443g = -1;

    /* renamed from: h, reason: collision with root package name */
    public static int f444h = -1;

    /* compiled from: OplusInterceptUtils.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactInfoCache.ContactCacheEntry f445a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f446b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f447c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Handler f448d;

        public a(ContactInfoCache.ContactCacheEntry contactCacheEntry, Context context, String str, Handler handler) {
            this.f445a = contactCacheEntry;
            this.f446b = context;
            this.f447c = str;
            this.f448d = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f445a.lastCallTime = OplusPhoneUtils.queryCallTimeByNumber(this.f446b, this.f447c);
            if (this.f448d != null) {
                Message obtain = Message.obtain();
                obtain.what = 1003;
                obtain.obj = this.f447c;
                this.f448d.sendMessage(obtain);
            }
        }
    }

    public static boolean A(Context context, String str, int i10, int i11) {
        if (context == null) {
            return false;
        }
        int globalSettingsInt = SettingsUtils.INSTANCE.getGlobalSettingsInt(context.getContentResolver(), str, i10);
        boolean z10 = z(globalSettingsInt, i11);
        if (Log.sDebug) {
            Log.d("OplusInterceptUtils", "isHarassInterceptOpen " + str + " =  " + globalSettingsInt + "  isOpen = " + z10);
        }
        return z10;
    }

    public static boolean B(A a10) {
        if (Log.sDebug) {
            Log.d("OplusInterceptUtils", "getMarkIntercept  yellowPageInfo = " + a10);
        }
        boolean z10 = false;
        if (a10 != null && a10.f99g > 0) {
            if (Log.sDebug) {
                Log.d("OplusInterceptUtils", "getMarkIntercept  markInfoType = " + a10.f99g);
            }
            int i10 = a10.f99g;
            if (1 == i10 || 3 == i10 || 4 == i10) {
                z10 = true;
            }
            if (Log.sDebug) {
                Log.d("OplusInterceptUtils", "getMarkIntercept   retType = " + z10);
            }
        }
        return z10;
    }

    public static boolean C() {
        boolean z10 = OplusFeatureOption.FEATURE_HIDE_CALL_HARASS_INTERCEPT;
        if (Log.sDebug) {
            Log.d("OplusInterceptUtils", "isNeedHideCallHarassInterceptSetting   isNeedHide = " + z10);
        }
        return z10;
    }

    public static boolean D(Context context) {
        boolean z10;
        if (context == null) {
            Log.d("OplusInterceptUtils", "isNumberRecognitionEnabled context is null");
            return false;
        }
        if (SettingsUtils.INSTANCE.getGlobalSettingsInt(context.getContentResolver(), "numberrecognition_switch", 1) == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        Log.d("OplusInterceptUtils", "isNumberRecognitionEnabled canShowNumberRecognition = " + z10);
        if ((!OplusFeatureOption.FEATURE_NUMBER_RECOGNITION.value().booleanValue() && OplusFeatureOption.OPLUS_VERSION_EXP) || !z10) {
            Log.d("OplusInterceptUtils", "isNumberRecognitionEnabled, not support number recognition, return false");
            return false;
        }
        Log.d("OplusInterceptUtils", "isNumberRecognitionEnabled, return true");
        return true;
    }

    public static boolean E(Context context, int i10) {
        if (context == null) {
            Log.d("OplusInterceptUtils", "needInterceptMarkNumber context is null");
            return false;
        }
        if (!D(context)) {
            return false;
        }
        boolean A10 = A(context, "oplus_customize_harass_intercept_mark_number_fraud", 3, i10);
        boolean A11 = A(context, "oplus_customize_harass_intercept_mark_number_harassment", 0, i10);
        boolean A12 = A(context, "oplus_customize_harass_intercept_mark_number_advertising", 0, i10);
        boolean A13 = A(context, "oplus_customize_harass_intercept_mark_number_intermediary", 0, i10);
        Log.d("OplusInterceptUtils", "needInterceptMarkNumber, isInterceptFraudOpen = " + A10 + ", isInterceptHarassmentOpen = " + A11 + ", isInterceptAdvertisingOpen = " + A12 + ", isInterceptIntermediaryOpen = " + A13);
        if (!A12 && !A10 && !A11 && !A13) {
            return false;
        }
        return true;
    }

    public static boolean F(Context context, Call call) {
        int i10;
        if (context == null) {
            Log.d("OplusInterceptUtils", "needShowDeclineAndInterceptIcon context is null");
            return false;
        }
        if (call == null) {
            Log.d("OplusInterceptUtils", "needShowDeclineAndInterceptIcon incomingCall is null");
            return false;
        }
        if (!OplusPhoneUtils.isUserUnlocked(context)) {
            Log.d("OplusInterceptUtils", "needShowDeclineAndInterceptIcon, user unlocked, not show intercept icon");
            return false;
        }
        if (!OplusPhoneUtils.isSystemUser(context)) {
            Log.d("OplusInterceptUtils", "needShowDeclineAndInterceptIcon, not system user, return false");
            return false;
        }
        if (!D(context)) {
            return false;
        }
        ContactInfoCache.ContactCacheEntry contactInfo = call.getContactInfo();
        if (contactInfo != null) {
            Log.d("OplusInterceptUtils", "needShowDeclineAndInterceptIcon isPenetratedIncomingCall = " + contactInfo.isPenetratedIncomingCall + ", isInWhiteList = " + contactInfo.isInWhiteList + ", person_id = " + contactInfo.person_id + ", mMarkInfoType = " + contactInfo.yellowPageInfo.f99g);
        } else {
            Log.d("OplusInterceptUtils", "needShowDeclineAndInterceptIcon contactInfo = null");
        }
        if (contactInfo != null && !contactInfo.isPenetratedIncomingCall && !contactInfo.isInWhiteList && contactInfo.person_id == -1 && ((i10 = contactInfo.yellowPageInfo.f99g) == 3 || i10 == 4 || i10 == 1 || i10 == 5)) {
            N(i10, call.getSlotId());
            Log.d("OplusInterceptUtils", "needShowDeclineAndInterceptIcon return true");
            return true;
        }
        N(-1, -1);
        Log.d("OplusInterceptUtils", "needShowDeclineAndInterceptIcon return false");
        return false;
    }

    public static void G(Context context) {
        H(context, OplusPhoneUserActionStatistics.USER_ACTION_HARASS_INTERCEPT_DIALOG_DISPLAY, f437a);
    }

    public static void H(Context context, int i10, int i11) {
        int i12;
        HashMap hashMap = new HashMap();
        int l10 = l(context) + j(context) + k(context);
        if (i11 == 0) {
            i12 = l(context);
        } else if (i11 == 1) {
            i12 = j(context);
        } else if (i11 == 2) {
            i12 = k(context);
        } else {
            i12 = 0;
        }
        hashMap.put("harass_intercept_type", String.valueOf(i11));
        hashMap.put("harass_intercept_count", String.valueOf(i12));
        hashMap.put("harass_intercept_all_count", String.valueOf(l10));
        if (Log.sDebug) {
            Log.d("OplusInterceptUtils", "oplusPhoneAddHarassInterceptUserAction actionId=" + i10 + ",type=" + i11 + ",count=" + i12 + ",allCount" + l10);
        }
        OplusPhoneUserActionStatistics.onCommon(context, OplusPhoneUserActionStatistics.TAG_HARASS_INTERCEPT, i10, hashMap);
    }

    public static void I(Context context, boolean z10) {
        int i10;
        if (z10) {
            i10 = OplusPhoneUserActionStatistics.USER_ACTION_HARASS_INTERCEPT_DIALOG_CLICK;
        } else {
            i10 = OplusPhoneUserActionStatistics.USER_ACTION_HARASS_INTERCEPT_DIALOG_CANCEL;
        }
        H(context, i10, f437a);
    }

    public static void J(Context context, int i10, String str, boolean z10, int i11) {
        if (context == null) {
            Log.d("OplusInterceptUtils", "putIntHarassIntercept, context is null");
            return;
        }
        SettingsUtils settingsUtils = SettingsUtils.INSTANCE;
        int globalSettingsInt = settingsUtils.getGlobalSettingsInt(context.getContentResolver(), str, i11);
        int i12 = 1;
        if (i10 == 1) {
            i12 = 2;
        }
        int e10 = e(globalSettingsInt, i12, z10);
        if (Log.sDebug) {
            Log.d("OplusInterceptUtils", "putIntHarassIntercept, slotId = " + i10 + " " + str + " =  " + globalSettingsInt + "  newKeyValue = " + e10);
        }
        settingsUtils.putGlobalSettingsInt(context.getContentResolver(), str, e10);
    }

    public static void K(Context context, int i10) {
        if (context == null) {
            if (Log.sDebug) {
                Log.d("OplusInterceptUtils", "context is null return  count = " + i10);
                return;
            }
            return;
        }
        if (Log.sDebug) {
            Log.d("OplusInterceptUtils", "putInterceptCount count = " + i10);
        }
        SettingsUtils.INSTANCE.putGlobalSettingsInt(context.getContentResolver(), OplusPhoneUtils.COUNT_INTERCEPT_CALL, i10);
    }

    public static void L(boolean z10) {
        f442f = z10;
    }

    public static void M(int i10) {
        if (Log.sDebug) {
            Log.d("OplusInterceptUtils", "setHarassInterceptDialogType type = " + i10);
        }
        f437a = i10;
    }

    public static void N(int i10, int i11) {
        f443g = i10;
        f444h = i11;
    }

    public static void O(OplusInCallDialogActivity oplusInCallDialogActivity) {
        if (Log.sDebug) {
            Log.d("OplusInterceptUtils", "setOplusInCallDialogActivity activity = " + oplusInCallDialogActivity);
        }
        f438b = oplusInCallDialogActivity;
    }

    public static void P(boolean z10) {
        f441e = z10;
    }

    public static boolean Q(Context context) {
        if (Log.sDebug) {
            Log.d("OplusInterceptUtils", "shouldShowInterceptDialog  context = " + context);
        }
        if (context == null) {
            Log.i("OplusInterceptUtils", "shouldShowInterceptDialog  context is null");
            return false;
        }
        if (!OplusPhoneUtils.isSystemUser(context)) {
            Log.i("OplusInterceptUtils", "shouldShowInterceptDialog not system user, return false");
            return false;
        }
        if (C()) {
            return false;
        }
        if (OplusFeatureOption.OPLUS_PHONE_HARASS_INTERCEPT_OFF) {
            Log.i("OplusInterceptUtils", "OPLUS_PHONE_HARASS_INTERCEPT_OFF is true, shouldShowInterceptDialog return false!");
            return false;
        }
        if (!OplusPhoneUtils.isDeviceProvisioned(context)) {
            if (Log.sDebug) {
                Log.d("OplusInterceptUtils", "shouldShowInterceptDialog  isDeviceProvisioned return");
            }
            return false;
        }
        if (k(context) > 1) {
            if (Log.sDebug) {
                Log.d("OplusInterceptUtils", "shouldShowInterceptDialog  out max return");
            }
            return false;
        }
        f437a = 2;
        if (Log.sDebug) {
            Log.d("OplusInterceptUtils", "shouldShowInterceptDialog mHarassInterceptDialogType =  " + f437a);
        }
        return true;
    }

    public static void R(Context context) {
        if (Log.sDebug) {
            Log.d("OplusInterceptUtils", "showInterceptDialog");
        }
        OplusPhoneUtils.startOplusInCallDialogActivity(context, 1);
        i();
        d(context);
    }

    public static void S(Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction(OplusPhoneUtils.OPLUS_HARASSMENT_ACTION);
            intent.setClassName(OplusPhoneUtils.OPLUS_BLACK_LIST_PACKAGE, OplusPhoneUtils.OPLUS_BLACK_LIST_CLASS_NAME);
            intent.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
            intent.putExtra("package", "com.android.incallui$dialog");
            context.startActivity(intent);
        } catch (Exception e10) {
            Log.d("OplusInterceptUtils", "Exception: " + e10.toString());
            Log.w("OplusInterceptUtils", "startInterceptActivity catch error");
        }
    }

    public static void T(Context context, String str, ContactInfoCache.ContactCacheEntry contactCacheEntry, Handler handler) {
        if (Log.sDebug) {
            Log.d("OplusInterceptUtils", "startOplusStrangerCalllogQuery...");
        }
        contactCacheEntry.callLogQueryState = 1;
        C2.b.a().execute(new a(contactCacheEntry, context, str, handler));
    }

    public static void a(Context context) {
        int j10 = j(context) + 1;
        if (Log.sDebug) {
            Log.d("OplusInterceptUtils", "addCountDelayType count = " + j10);
        }
        SettingsUtils.INSTANCE.putGlobalSettingsInt(context.getContentResolver(), OplusPhoneUtils.COUNT_DELAY_TYPE, j10);
    }

    public static void b(Context context) {
        int k10 = k(context) + 1;
        if (Log.sDebug) {
            Log.d("OplusInterceptUtils", "addCountStrangerType count = " + k10);
        }
        SettingsUtils.INSTANCE.putGlobalSettingsInt(context.getContentResolver(), OplusPhoneUtils.COUNT_STRANGER_TYPE, k10);
    }

    public static void c(Context context) {
        int l10 = l(context) + 1;
        if (Log.sDebug) {
            Log.d("OplusInterceptUtils", "addCountUnknownType count = " + l10);
        }
        SettingsUtils.INSTANCE.putGlobalSettingsInt(context.getContentResolver(), OplusPhoneUtils.COUNT_UNKNOWN_TYPE, l10);
    }

    public static void d(Context context) {
        int i10 = f437a;
        if (i10 == 0) {
            c(context);
        } else if (i10 == 2) {
            b(context);
        } else if (i10 == 1) {
            a(context);
        }
    }

    public static int e(int i10, int i11, boolean z10) {
        if (z10) {
            return i10 | i11;
        }
        return i10 & (~i11);
    }

    public static void f(Context context) {
        int j10 = j(context) - 1;
        if (j10 < 0) {
            j10 = 0;
        }
        if (Log.sDebug) {
            Log.d("OplusInterceptUtils", "decreaseCountDelayType count = " + j10);
        }
        SettingsUtils.INSTANCE.putGlobalSettingsInt(context.getContentResolver(), OplusPhoneUtils.COUNT_DELAY_TYPE, j10);
    }

    public static void g(Context context) {
        int k10 = k(context) - 1;
        if (k10 < 0) {
            k10 = 0;
        }
        if (Log.sDebug) {
            Log.d("OplusInterceptUtils", "decreateCountStrangerType count = " + k10);
        }
        SettingsUtils.INSTANCE.putGlobalSettingsInt(context.getContentResolver(), OplusPhoneUtils.COUNT_STRANGER_TYPE, k10);
    }

    public static void h(Context context) {
        int l10 = l(context) - 1;
        if (l10 < 0) {
            l10 = 0;
        }
        if (Log.sDebug) {
            Log.d("OplusInterceptUtils", "decreateCountUnknownType count = " + l10);
        }
        SettingsUtils.INSTANCE.putGlobalSettingsInt(context.getContentResolver(), OplusPhoneUtils.COUNT_UNKNOWN_TYPE, l10);
    }

    public static void i() {
        OplusInCallDialogActivity oplusInCallDialogActivity = f438b;
        if (oplusInCallDialogActivity != null && !oplusInCallDialogActivity.isFinishing()) {
            if (Log.sDebug) {
                Log.d("OplusInterceptUtils", "dismiss mInterceptDialog!");
            }
            f438b.l0();
        }
    }

    public static int j(Context context) {
        int globalSettingsInt = SettingsUtils.INSTANCE.getGlobalSettingsInt(context.getContentResolver(), OplusPhoneUtils.COUNT_DELAY_TYPE, 0);
        if (Log.sDebug) {
            Log.d("OplusInterceptUtils", "getCountDelayType count = " + globalSettingsInt);
        }
        return globalSettingsInt;
    }

    public static int k(Context context) {
        int globalSettingsInt = SettingsUtils.INSTANCE.getGlobalSettingsInt(context.getContentResolver(), OplusPhoneUtils.COUNT_STRANGER_TYPE, 0);
        if (Log.sDebug) {
            Log.d("OplusInterceptUtils", "getCountStrangerType count = " + globalSettingsInt);
        }
        return globalSettingsInt;
    }

    public static int l(Context context) {
        int globalSettingsInt = SettingsUtils.INSTANCE.getGlobalSettingsInt(context.getContentResolver(), OplusPhoneUtils.COUNT_UNKNOWN_TYPE, 0);
        if (Log.sDebug) {
            Log.d("OplusInterceptUtils", "getCountUnknownType count = " + globalSettingsInt);
        }
        return globalSettingsInt;
    }

    public static int m(Context context) {
        if (context == null) {
            return 1;
        }
        int globalSettingsInt = SettingsUtils.INSTANCE.getGlobalSettingsInt(context.getContentResolver(), OplusPhoneUtils.COUNT_INTERCEPT_CALL, 0);
        if (Log.sDebug) {
            Log.d("OplusInterceptUtils", "getInterceptCount count = " + globalSettingsInt);
        }
        int i10 = globalSettingsInt + 1;
        K(context, i10);
        return i10;
    }

    public static PendingIntent n(Context context, int i10) {
        Intent intent = new Intent();
        if (i10 == 1) {
            intent.setAction(OplusPhoneUtils.OPLUS_HARASSMENT_ACTION);
        } else if (i10 == 2) {
            intent.setAction("oppo.intent.action.BLOCK_CALLS");
        }
        intent.setPackage(OplusPhoneUtils.OPLUS_BLACK_LIST_PACKAGE);
        intent.addFlags(335544320);
        intent.putExtra("package", "com.android.incallui$status_bar");
        return PendingIntent.getActivity(context, 0, intent, 67108864);
    }

    public static int o() {
        return f443g;
    }

    public static int p() {
        return f444h;
    }

    public static int q(Context context, int i10) {
        if (context == null) {
            Log.d("OplusInterceptUtils", "getInterceptSettingSlotId, context is null");
            return i10;
        }
        if (i10 == 1 && A(context, "oplus_customize_sim2_use_sim1_rules", 3, i10)) {
            Log.d("OplusInterceptUtils", "getInterceptSettingSlotId, UseSim1Rules change slotId to 0");
            return 0;
        }
        return i10;
    }

    public static int r(Context context, int i10) {
        String str;
        if (context == null) {
            return 0;
        }
        if (i10 == 0) {
            str = "oplus_customize_harass_intercept_mark_number_threshold";
        } else {
            str = "oplus_customize_harass_intercept_mark_number_threshold_1";
        }
        int globalSettingsInt = SettingsUtils.INSTANCE.getGlobalSettingsInt(context.getContentResolver(), str, 0);
        if (Log.sDebug) {
            Log.d("OplusInterceptUtils", "getMarkNumberThreshold " + str + " threshold = " + globalSettingsInt);
        }
        return globalSettingsInt;
    }

    public static int s(Context context) {
        if (context == null) {
            return 10;
        }
        int globalSettingsInt = SettingsUtils.INSTANCE.getGlobalSettingsInt(context.getContentResolver(), "oplus_time_show_intercept_dialog_key", 10);
        if (Log.sDebug) {
            Log.d("OplusInterceptUtils", "getTimeJudgeShowDialog time = " + globalSettingsInt);
        }
        return globalSettingsInt;
    }

    public static boolean t(Context context) {
        if (!f439c) {
            boolean z10 = false;
            if (SettingsUtils.INSTANCE.getGlobalSettingsInt(context.getContentResolver(), "oplus_had_started_harass_setting", 0) != 0) {
                z10 = true;
            }
            f439c = z10;
        }
        if (Log.sDebug) {
            Log.d("OplusInterceptUtils", "hasStartedInterceptSetting time = " + f439c);
        }
        return f439c;
    }

    public static void u() {
        Context context = InCallPresenter.getInstance().getContext();
        OplusInCallDialogActivity oplusInCallDialogActivity = f438b;
        if (oplusInCallDialogActivity != null && !oplusInCallDialogActivity.isFinishing()) {
            if (Log.sDebug) {
                Log.d("OplusInterceptUtils", "ignoreInterceptDialogSomeTime mHarassInterceptDialogType = " + f437a);
            }
            int i10 = f437a;
            if (i10 == 0) {
                h(context);
            } else if (i10 == 2) {
                g(context);
            } else if (i10 == 1) {
                f(context);
            }
            f438b.l0();
            f437a = -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int v(android.content.Context r7, int r8, int r9, int r10) {
        /*
            boolean r0 = D(r7)
            java.lang.String r1 = "OplusInterceptUtils"
            r2 = -1
            if (r0 != 0) goto Lf
            java.lang.String r7 = "isBlockedByMarkNumberInfo, number recognition not enabled"
            com.android.incallui.Log.d(r1, r7)
            return r2
        Lf:
            boolean r0 = com.android.incallui.Log.sDebug
            if (r0 == 0) goto L2f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "isBlockedByMarkNumberInfo slotId = "
            r0.append(r3)
            r0.append(r8)
            java.lang.String r3 = "  markInfoType =  "
            r0.append(r3)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            com.android.incallui.Log.d(r1, r0)
        L2f:
            r0 = 1
            java.lang.String r3 = "oplus_customize_harass_intercept_mark_number_fraud"
            r4 = 3
            if (r9 == r0) goto L52
            if (r9 == r4) goto L4d
            r0 = 4
            if (r9 == r0) goto L48
            r0 = 5
            if (r9 == r0) goto L40
            r9 = 0
            r0 = r2
            goto L57
        L40:
            r9 = 53
            java.lang.String r0 = "oplus_customize_harass_intercept_mark_number_intermediary"
        L44:
            r6 = r0
            r0 = r9
            r9 = r6
            goto L57
        L48:
            r9 = 51
            java.lang.String r0 = "oplus_customize_harass_intercept_mark_number_harassment"
            goto L44
        L4d:
            r9 = 50
            r0 = r9
            r9 = r3
            goto L57
        L52:
            r9 = 52
            java.lang.String r0 = "oplus_customize_harass_intercept_mark_number_advertising"
            goto L44
        L57:
            boolean r5 = android.text.TextUtils.isEmpty(r9)
            if (r5 != 0) goto Laf
            if (r9 != r3) goto L64
            boolean r3 = A(r7, r9, r4, r8)
            goto L69
        L64:
            r3 = 0
            boolean r3 = A(r7, r9, r3, r8)
        L69:
            if (r3 == 0) goto L82
            if (r10 != 0) goto L82
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "local marked count is zeto threshold return blocked "
            r7.append(r8)
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            com.android.incallui.Log.d(r1, r7)
            return r0
        L82:
            if (r3 == 0) goto L89
            int r7 = r(r7, r8)
            goto L8a
        L89:
            r7 = r2
        L8a:
            boolean r8 = com.android.incallui.Log.sDebug
            if (r8 == 0) goto Laa
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "isBlockedByMarkNumberInfo threshold = "
            r8.append(r9)
            r8.append(r7)
            java.lang.String r9 = "  markInfoCount =  "
            r8.append(r9)
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            com.android.incallui.Log.d(r1, r8)
        Laa:
            if (r7 == r2) goto Laf
            if (r10 < r7) goto Laf
            return r0
        Laf:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: D2.f.v(android.content.Context, int, int, int):int");
    }

    public static boolean w(Context context, A a10) {
        if (a10 == null || context == null || !E(context, a10.f104l) || -1 == v(context, a10.f104l, a10.f99g, a10.f100h)) {
            return false;
        }
        return true;
    }

    public static boolean x() {
        return f442f;
    }

    public static boolean y(String str) {
        boolean z10;
        boolean z11 = false;
        if (!TextUtils.isEmpty(str)) {
            String replace = str.replace(" ", "");
            int length = replace.length();
            char charAt = replace.charAt(0);
            if (Log.sDebug) {
                Log.d("OplusInterceptUtils", "isFamilyOrCornetGroupNumber number = " + g.l(replace) + "  length = " + length + "  startChar = " + charAt);
            }
            if (charAt == '6' && length >= 3 && length <= 6) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10 && length >= 3 && length <= 5) {
                for (char c10 : f440d) {
                    if (c10 == charAt) {
                        z11 = true;
                        break;
                    }
                }
            }
            z11 = z10;
        }
        if (Log.sDebug) {
            Log.d("OplusInterceptUtils", "isFamilyOrCornetGroupNumber bRet = " + z11);
        }
        return z11;
    }

    public static boolean z(int i10, int i11) {
        boolean z10 = false;
        if (i11 != 0 ? (i10 & 2) == 2 : (i10 & 1) == 1) {
            z10 = true;
        }
        if (Log.sDebug) {
            Log.d("OplusInterceptUtils", "isHarassIntercepOpen " + z10);
        }
        return z10;
    }
}
