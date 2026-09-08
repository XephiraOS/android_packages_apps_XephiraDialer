package v6;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.UserManager;
import android.provider.Settings;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.preference.j;
import androidx.recyclerview.widget.RecyclerView;
import c7.C0566b;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.incallui.OplusPhoneCapabilities;
import com.android.incallui.OplusPhoneUserActionStatistics;
import com.android.incallui.OplusPhoneUtils;
import com.heytap.accessory.constant.AFConstants;
import com.oplus.backup.sdk.common.utils.Constants;
import com.oplus.blacklistapp.callintercept.InCallDialogActivity;
import com.oplus.blacklistapp.callintercept.policy.a;
import com.oplus.blacklistapp.callintercept.policy.d;
import com.oplus.blacklistapp.callintercept.settings.MarkNumberThresholdUtil;
import com.oplus.common.data.PreferenceWrapper;
import com.oplus.common.data.SettingsWrapper$Global;
import com.oplus.utils.C0844e;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0848i;
import com.oplus.utils.C0849j;
import com.oplus.utils.D;
import j8.C1188a;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import l7.C1296a;
import v9.InterfaceC1637a;

/* compiled from: InterceptUtils.java */
/* renamed from: v6.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1632f {

    /* renamed from: a, reason: collision with root package name */
    public static final String f37447a = F6.e.j();

    /* renamed from: b, reason: collision with root package name */
    public static final String f37448b = F6.e.a0();

    /* renamed from: c, reason: collision with root package name */
    public static final String f37449c = F6.e.Z();

    /* renamed from: d, reason: collision with root package name */
    public static final String f37450d = F6.e.g();

    /* renamed from: e, reason: collision with root package name */
    public static final String f37451e = F6.e.i();

    /* renamed from: f, reason: collision with root package name */
    public static final String f37452f = F6.e.h();

    /* renamed from: g, reason: collision with root package name */
    public static final String f37453g = C1629c.f37419e + "$dialog";

    /* renamed from: h, reason: collision with root package name */
    public static final String f37454h = F6.e.K();

    /* renamed from: i, reason: collision with root package name */
    public static final String f37455i = F6.e.u();

    /* renamed from: j, reason: collision with root package name */
    public static final String f37456j = F6.e.s();

    /* renamed from: k, reason: collision with root package name */
    public static final String f37457k = F6.e.q();

    /* renamed from: l, reason: collision with root package name */
    public static final String f37458l = F6.e.w();

    /* renamed from: m, reason: collision with root package name */
    public static final String f37459m = F6.e.v();

    /* renamed from: n, reason: collision with root package name */
    public static final String f37460n = F6.e.t();

    /* renamed from: o, reason: collision with root package name */
    public static final String f37461o = F6.e.r();

    /* renamed from: p, reason: collision with root package name */
    public static final String f37462p = F6.e.x();

    /* renamed from: q, reason: collision with root package name */
    public static final String f37463q = F6.e.N();

    /* renamed from: r, reason: collision with root package name */
    public static final String f37464r = F6.e.n();

    /* renamed from: s, reason: collision with root package name */
    public static final String f37465s = F6.e.J();

    /* renamed from: t, reason: collision with root package name */
    public static final String f37466t = F6.e.p();

    /* renamed from: u, reason: collision with root package name */
    public static final String f37467u = F6.e.o();

    /* renamed from: v, reason: collision with root package name */
    public static final String f37468v = F6.e.y();

    /* renamed from: w, reason: collision with root package name */
    public static final String f37469w = F6.e.D();

    /* renamed from: x, reason: collision with root package name */
    public static final String f37470x = F6.e.A();

    /* renamed from: y, reason: collision with root package name */
    public static final String f37471y = F6.e.F();

    /* renamed from: z, reason: collision with root package name */
    public static final String f37472z = F6.e.B();

    /* renamed from: A, reason: collision with root package name */
    public static final String f37426A = F6.e.G();

    /* renamed from: B, reason: collision with root package name */
    public static final String f37427B = F6.e.z();

    /* renamed from: C, reason: collision with root package name */
    public static final String f37428C = F6.e.E();

    /* renamed from: D, reason: collision with root package name */
    public static final String f37429D = F6.e.C();

    /* renamed from: E, reason: collision with root package name */
    public static final String f37430E = F6.e.H();

    /* renamed from: F, reason: collision with root package name */
    public static final String f37431F = F6.e.Y();

    /* renamed from: G, reason: collision with root package name */
    public static final String f37432G = F6.e.b();

    /* renamed from: H, reason: collision with root package name */
    public static final String f37433H = F6.e.a();

    /* renamed from: I, reason: collision with root package name */
    public static final String[] f37434I = {BreenoCallContract.BaseColumns._ID, "number", BreenoCallContract.BaseColumns.DATE};

    /* renamed from: J, reason: collision with root package name */
    public static final char[] f37435J = {'2', '3', '5', '7', '8'};

    /* renamed from: K, reason: collision with root package name */
    public static final Uri f37436K = Uri.parse(F6.d.e());

    /* renamed from: L, reason: collision with root package name */
    public static final String[] f37437L = {"ride_mode_switch", "ride_mode_allow_calls_from", "ride_mode_repeat_ringing"};

    /* renamed from: M, reason: collision with root package name */
    public static final Uri f37438M = Uri.parse(F6.d.h());

    /* renamed from: N, reason: collision with root package name */
    public static final Uri f37439N = Uri.parse("content://com.oplus.ocar.smartdrive.data.DataProvider/smart_drive_settings");

    /* renamed from: O, reason: collision with root package name */
    public static final String f37440O = "content://" + com.oplus.blacklist.database.a.f26232a + "/bl_area_for_country";

    /* renamed from: P, reason: collision with root package name */
    public static final String[] f37441P = {"smart_drive_switch", "allow_calls_from", "repeat_ringing"};

    /* renamed from: Q, reason: collision with root package name */
    public static int f37442Q = -1;

    /* renamed from: R, reason: collision with root package name */
    public static InCallDialogActivity f37443R = null;

    /* renamed from: S, reason: collision with root package name */
    public static boolean f37444S = false;

    /* renamed from: T, reason: collision with root package name */
    public static e f37445T = new e();

    /* renamed from: U, reason: collision with root package name */
    public static d f37446U = new d();

    /* compiled from: InterceptUtils.java */
    /* renamed from: v6.f$a */
    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.C0239a f37473a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f37474b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f37475c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Handler f37476d;

        public a(a.C0239a c0239a, Context context, String str, Handler handler) {
            this.f37473a = c0239a;
            this.f37474b = context;
            this.f37475c = str;
            this.f37476d = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f37473a.f26645v = C1632f.X(this.f37474b, this.f37475c);
            if (this.f37476d != null) {
                Message obtain = Message.obtain();
                obtain.what = 1003;
                obtain.obj = this.f37475c;
                this.f37476d.sendMessage(obtain);
            }
        }
    }

    /* compiled from: InterceptUtils.java */
    /* renamed from: v6.f$b */
    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f37477a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f37478b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f37479c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f37480d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Handler f37481e;

        public b(Context context, String str, int i10, int i11, Handler handler) {
            this.f37477a = context;
            this.f37478b = str;
            this.f37479c = i10;
            this.f37480d = i11;
            this.f37481e = handler;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x008e A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00bb A[Catch: all -> 0x004f, Exception -> 0x0052, SQLiteException -> 0x0055, TryCatch #3 {SQLiteException -> 0x0055, Exception -> 0x0052, blocks: (B:10:0x001d, B:13:0x0033, B:17:0x003a, B:19:0x0043, B:20:0x0058, B:22:0x008a, B:25:0x0090, B:26:0x00b0, B:28:0x00bb, B:30:0x00d1, B:32:0x00d9, B:56:0x0060, B:58:0x0069, B:59:0x0074, B:61:0x0078, B:62:0x0085, B:64:0x0080), top: B:9:0x001d, outer: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00d1 A[Catch: all -> 0x004f, Exception -> 0x0052, SQLiteException -> 0x0055, TryCatch #3 {SQLiteException -> 0x0055, Exception -> 0x0052, blocks: (B:10:0x001d, B:13:0x0033, B:17:0x003a, B:19:0x0043, B:20:0x0058, B:22:0x008a, B:25:0x0090, B:26:0x00b0, B:28:0x00bb, B:30:0x00d1, B:32:0x00d9, B:56:0x0060, B:58:0x0069, B:59:0x0074, B:61:0x0078, B:62:0x0085, B:64:0x0080), top: B:9:0x001d, outer: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x011f  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x015e  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0169  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 397
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: v6.C1632f.b.run():void");
        }
    }

    /* compiled from: InterceptUtils.java */
    /* renamed from: v6.f$c */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f37482a;

        /* renamed from: b, reason: collision with root package name */
        public String f37483b;
    }

    /* compiled from: InterceptUtils.java */
    /* renamed from: v6.f$d */
    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public boolean f37484a;

        /* renamed from: b, reason: collision with root package name */
        public int f37485b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f37486c;

        public void a() {
            this.f37484a = false;
            this.f37485b = 1;
            this.f37486c = false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("mRideModeSwitch = " + this.f37484a);
            sb.append(" mAllowCallsFrom = " + this.f37485b);
            sb.append(" mAllowRepeatRing = " + this.f37486c);
            return sb.toString();
        }
    }

    /* compiled from: InterceptUtils.java */
    /* renamed from: v6.f$e */
    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public boolean f37487a;

        /* renamed from: b, reason: collision with root package name */
        public int f37488b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f37489c;

        public void a() {
            this.f37487a = false;
            this.f37488b = 1;
            this.f37489c = false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("mDriveSwitch = " + this.f37487a);
            sb.append(" mAllowCallsFrom = " + this.f37488b);
            sb.append(" mAllowRepeatRing = " + this.f37489c);
            return sb.toString();
        }
    }

    public static boolean A(int i10, int i11) {
        boolean z10 = false;
        if (i11 != 0 ? (i10 & 2) == 2 : (i10 & 1) == 1) {
            z10 = true;
        }
        if (C1627a.f37411c) {
            C1627a.c("InterceptUtils", "isHarassIntercepOpen " + z10);
        }
        return z10;
    }

    public static boolean B(final Context context, final String str, int i10, int i11) {
        if (context == null) {
            return false;
        }
        int a10 = SettingsWrapper$Global.a(context.getContentResolver(), str, i10, new InterfaceC1637a() { // from class: v6.d
            @Override // v9.InterfaceC1637a
            public final Object invoke() {
                Integer M10;
                M10 = C1632f.M(context, str);
                return M10;
            }
        });
        j0(context, str, a10, i10);
        boolean A10 = A(a10, i11);
        if (C1627a.f37411c) {
            C1627a.c("InterceptUtils", "isHarassInterceptOpen " + str + " =  " + a10 + "  isOpen = " + A10);
        }
        return A10;
    }

    public static boolean C(SharedPreferences sharedPreferences, String str, int i10, int i11) {
        PreferenceWrapper preferenceWrapper = new PreferenceWrapper(sharedPreferences);
        int a10 = preferenceWrapper.a(str, i10);
        if (a10 == i10) {
            a10 = preferenceWrapper.a(l0(str), i10);
        }
        boolean A10 = A(a10, i11);
        if (C1627a.f37411c) {
            C1627a.c("InterceptUtils", "isHarassInterceptOpen " + str + " =  " + a10 + "  isOpen = " + A10);
        }
        return A10;
    }

    public static boolean D(Context context) {
        return C1296a.t(context.getPackageManager(), context.getContentResolver(), "", "com.android.contacts.hide_call_harass_intercept");
    }

    public static boolean E(int i10, int i11, boolean z10) {
        int i12;
        int i13;
        int i14;
        boolean z11 = true;
        boolean z12 = false;
        if (z10) {
            if (i11 == 1) {
                i13 = 7;
            } else {
                i13 = i11 - 1;
            }
            i12 = 0;
        } else {
            i12 = i11;
            i13 = 0;
        }
        int i15 = 0;
        while (true) {
            try {
                int[] iArr = com.oplus.blacklistapp.callintercept.a.f26578m;
                if (i15 < iArr.length) {
                    int i16 = iArr[i15];
                    if ((i10 & i16) == i16 && (i12 == (i14 = com.oplus.blacklistapp.callintercept.a.f26580o[i15]) || i13 == i14)) {
                        break;
                    }
                    i15++;
                } else {
                    z11 = false;
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
                C1627a.q("InterceptUtils", "ArrayIndexOutOfBoundsException ");
            }
        }
        z12 = z11;
        if (C1627a.f37411c) {
            C1627a.c("InterceptUtils", "isInBlockedDay = " + z12 + " dayOfWeek = " + i11 + " preDay = " + i13);
        }
        return z12;
    }

    public static boolean F(Context context, int i10) {
        if (context == null) {
            if (C1627a.f37411c) {
                C1627a.k("InterceptUtils", "context is null!");
            }
            return false;
        }
        boolean B10 = B(context, "harass_intercept_anonymous", 0, i10);
        if (C1627a.f37411c) {
            C1627a.c("InterceptUtils", "isOn = " + B10);
        }
        return B10;
    }

    public static boolean G(Context context, int i10) {
        if (context == null) {
            if (C1627a.f37411c) {
                C1627a.k("InterceptUtils", "context is null!");
            }
            return false;
        }
        boolean B10 = B(context, "harass_intercept_payphone", 0, i10);
        if (C1627a.f37411c) {
            C1627a.c("InterceptUtils", "isOn = " + B10);
        }
        return B10;
    }

    public static boolean H(Context context, int i10) {
        if (context == null) {
            if (C1627a.f37411c) {
                C1627a.k("InterceptUtils", "context is null!");
            }
            return false;
        }
        boolean B10 = B(context, f37448b, 0, i10);
        if (C1627a.f37411c) {
            C1627a.c("InterceptUtils", "isOn = " + B10);
        }
        return B10;
    }

    public static boolean I(Context context, int i10) {
        if (context == null) {
            if (C1627a.f37411c) {
                C1627a.k("InterceptUtils", "context is null!");
            }
            return false;
        }
        boolean B10 = B(context, "harass_intercept_unrecognized", 0, i10);
        if (C1627a.f37411c) {
            C1627a.c("InterceptUtils", "isOn = " + B10);
        }
        return B10;
    }

    public static boolean J(Context context) {
        if (l7.b.f34737e && context != null) {
            boolean z10 = l7.b.f34738f;
            C1627a.c("InterceptUtils", "isNeedHideCallHarassInterceptSetting  = " + z10);
            return z10;
        }
        return false;
    }

    public static boolean K(Context context) {
        boolean z10;
        if (context == null) {
            C1627a.c("InterceptUtils", "isNumberRecognitionEnabled context is null");
            return false;
        }
        if (z6.b.c(context, 1, "numberrecognition_switch", 1) == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        C1627a.c("InterceptUtils", "isNumberRecognitionEnabled canShowNumberRecognition = " + z10);
        if (l7.b.d() && z10) {
            if (z6.b.c(context, 0, "UpdateStrangers", 1) == 0) {
                C1627a.c("InterceptUtils", "isNumberRecognitionEnabled, number recognition switch is closed, return false");
                return false;
            }
            C1627a.c("InterceptUtils", "isNumberRecognitionEnabled, return true");
            return true;
        }
        C1627a.c("InterceptUtils", "isNumberRecognitionEnabled, not support number recognition, return false");
        return false;
    }

    public static boolean L(Context context) {
        UserManager userManager;
        if (context == null || (userManager = (UserManager) context.getSystemService(UserManager.class)) == null) {
            return true;
        }
        return userManager.isUserUnlocked();
    }

    public static /* synthetic */ Integer M(Context context, String str) {
        return Integer.valueOf(z6.b.b(context, 1, str));
    }

    public static /* synthetic */ Integer N(Context context, String str) {
        return Integer.valueOf(z6.b.b(context, 1, l0(str)));
    }

    public static void O(String str) {
        if (C1627a.f37411c) {
            C1627a.c("InterceptUtils", str);
        }
    }

    public static boolean P(Context context, int i10) {
        if (context == null) {
            C1627a.c("InterceptUtils", "needInterceptMarkNumber context is null");
            return false;
        }
        if (C0844e.f29134b) {
            C1627a.k("InterceptUtils", "FiveInOneVersion no need intercept marknumber");
            return false;
        }
        if (!C(j.b(context), "harass_intercept_marked_number_v2", 3, i10)) {
            C1627a.c("InterceptUtils", "intercept mark number is not open");
            return false;
        }
        boolean B10 = B(context, f37455i, 3, i10);
        boolean B11 = B(context, f37456j, 0, i10);
        boolean B12 = B(context, f37457k, 0, i10);
        boolean B13 = B(context, f37458l, 0, i10);
        C1627a.c("InterceptUtils", "needInterceptMarkNumber, isInterceptFraudOpen = " + B10 + ", isInterceptHarassmentOpen = " + B11 + ", isInterceptAdvertisingOpen = " + B12 + ", isInterceptIntermediaryOpen = " + B13 + ", isNumberRecognitionEnabled = " + K(context));
        if (!B12 && !B10 && !B11 && !B13) {
            return false;
        }
        return true;
    }

    public static void Q(Context context) {
        R(context, OplusPhoneUserActionStatistics.USER_ACTION_HARASS_INTERCEPT_DIALOG_DISPLAY, f37442Q);
    }

    public static void R(Context context, int i10, int i11) {
        int i12;
        HashMap hashMap = new HashMap();
        int o10 = o(context) + m(context) + n(context);
        if (i11 == 0) {
            i12 = o(context);
        } else if (i11 == 1) {
            i12 = m(context);
        } else if (i11 == 2) {
            i12 = n(context);
        } else {
            i12 = 0;
        }
        hashMap.put("harass_intercept_type", String.valueOf(i11));
        hashMap.put("harass_intercept_count", String.valueOf(i12));
        hashMap.put("harass_intercept_all_count", String.valueOf(o10));
        if (C1627a.f37411c) {
            C1627a.c("InterceptUtils", "phoneAddHarassInterceptUserAction actionId=" + i10 + ",type=" + i11 + ",count=" + i12 + ",allCount" + o10);
        }
        C1628b.a(context, "2011101", i10, hashMap);
    }

    public static void S(Context context, boolean z10) {
        int i10;
        if (z10) {
            i10 = OplusPhoneUserActionStatistics.USER_ACTION_HARASS_INTERCEPT_DIALOG_CLICK;
        } else {
            i10 = OplusPhoneUserActionStatistics.USER_ACTION_HARASS_INTERCEPT_DIALOG_CANCEL;
        }
        R(context, i10, f37442Q);
    }

    public static void T(Context context, String str, int i10, int i11) {
        HashMap hashMap = new HashMap();
        hashMap.put("harass_intercept_type", String.valueOf(i11));
        hashMap.put("harass_intercept_ringing_time", String.valueOf(0));
        hashMap.put("harass_intercept_presentation", String.valueOf(i10));
        C1627a.c("InterceptUtils", "phoneAddHarassInterceptUserAction type=" + i11 + ",ringTime=0,presentation=" + i10);
        C1628b.a(context, OplusPhoneUserActionStatistics.TAG_NUMBER_RECOGNITION, 201090045, hashMap);
    }

    public static void U(Activity activity) {
        if (activity == null) {
            O("playActivityAnimationUpDownExit activity is null!");
        } else {
            activity.overridePendingTransition(H6.b.f1289c, H6.b.f1288b);
        }
    }

    public static void V(Context context, String str, Handler handler, int i10, int i11) {
        if (context == null) {
            return;
        }
        new Thread(new b(context, str, i10, i11, handler)).start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x014d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int W(android.content.Context r12, java.lang.String r13, int r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v6.C1632f.W(android.content.Context, java.lang.String, int, boolean):int");
    }

    public static long X(Context context, String str) {
        Uri g10 = C0848i.g(context);
        if (TextUtils.isEmpty(str)) {
            str = OplusPhoneUtils.DeviceState.INVALID_STATUS;
        }
        Cursor cursor = null;
        long j10 = 0;
        try {
            cursor = context.getContentResolver().query(g10, f37434I, new StringBuilder("number=?").toString(), new String[]{str}, "date DESC");
            if (cursor != null && cursor.moveToFirst()) {
                j10 = cursor.getLong(cursor.getColumnIndexOrThrow(BreenoCallContract.BaseColumns.DATE));
                if (C1627a.f37411c) {
                    C1627a.c("InterceptUtils", "queryCallLogByNumber callsDate = " + j10);
                }
            }
            return j10;
        } catch (SQLiteException e10) {
            C1627a.h("InterceptUtils", "Catch a SQLiteException when query: " + e10);
            return j10;
        } catch (Exception e11) {
            Log.e("InterceptUtils", "queryLastCallTimeByNumber: " + e11);
            return j10;
        } finally {
            I9.a.a(cursor);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00c4, code lost:
    
        if (r0 != null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c6, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00d2, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00cf, code lost:
    
        if (r0 == null) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static v6.C1632f.c Y(java.lang.String r9, android.content.Context r10) {
        /*
            r0 = 0
            java.lang.String r1 = "InterceptUtils"
            if (r10 != 0) goto Lf
            boolean r9 = v6.C1627a.f37411c
            if (r9 == 0) goto Le
            java.lang.String r9 = "context is null, do nothing and return."
            v6.C1627a.c(r1, r9)
        Le:
            return r0
        Lf:
            if (r9 != 0) goto L1b
            boolean r9 = v6.C1627a.f37411c
            if (r9 == 0) goto L1a
            java.lang.String r9 = "number is null, do nothing and return."
            v6.C1627a.c(r1, r9)
        L1a:
            return r0
        L1b:
            java.lang.String r2 = " "
            java.lang.String r3 = ""
            java.lang.String r9 = r9.replaceAll(r2, r3)
            v6.f$c r2 = new v6.f$c
            r2.<init>()
            boolean r3 = v6.C1627a.f37411c
            if (r3 == 0) goto L31
            java.lang.String r3 = "query number attribution begin..."
            v6.C1627a.c(r1, r3)
        L31:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> Lca
            r3.<init>()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> Lca
            java.lang.String r4 = "content://"
            r3.append(r4)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> Lca
            java.lang.String r4 = v6.C1629c.f37421g     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> Lca
            r3.append(r4)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> Lca
            java.lang.String r4 = "/phoneno"
            r3.append(r4)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> Lca
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> Lca
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> Lca
            android.net.Uri r3 = android.net.Uri.withAppendedPath(r3, r9)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> Lca
            I6.a r4 = I6.a.b(r10)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> Lca
            java.lang.String r4 = r4.a()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> Lca
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> Lca
            if (r5 != 0) goto L6d
            android.net.Uri$Builder r3 = r3.buildUpon()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> Lca
            java.lang.String r5 = "countryiso"
            android.net.Uri$Builder r3 = r3.appendQueryParameter(r5, r4)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> Lca
            android.net.Uri r3 = r3.build()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> Lca
        L6d:
            r4 = r3
            goto L71
        L6f:
            r9 = move-exception
            goto Ld3
        L71:
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> Lca
            r7 = 0
            r8 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> Lca
            if (r10 == 0) goto Lc3
            boolean r3 = r10.moveToFirst()     // Catch: java.lang.Throwable -> Lba java.lang.Exception -> Lbd
            if (r3 == 0) goto Lbf
            java.lang.String r3 = "cityname"
            int r3 = r10.getColumnIndex(r3)     // Catch: java.lang.Throwable -> Lba java.lang.Exception -> Lbd
            java.lang.String r3 = r10.getString(r3)     // Catch: java.lang.Throwable -> Lba java.lang.Exception -> Lbd
            java.lang.String r4 = "areano"
            int r4 = r10.getColumnIndex(r4)     // Catch: java.lang.Throwable -> Lba java.lang.Exception -> Lbd
            java.lang.String r4 = r10.getString(r4)     // Catch: java.lang.Throwable -> Lba java.lang.Exception -> Lbd
            r2.f37482a = r3     // Catch: java.lang.Throwable -> Lba java.lang.Exception -> Lbd
            r2.f37483b = r4     // Catch: java.lang.Throwable -> Lba java.lang.Exception -> Lbd
            boolean r3 = v6.C1627a.f37411c     // Catch: java.lang.Throwable -> Lba java.lang.Exception -> Lbd
            if (r3 == 0) goto Lbf
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lba java.lang.Exception -> Lbd
            r3.<init>()     // Catch: java.lang.Throwable -> Lba java.lang.Exception -> Lbd
            java.lang.String r4 = "query number attribution end, number = "
            r3.append(r4)     // Catch: java.lang.Throwable -> Lba java.lang.Exception -> Lbd
            java.lang.String r9 = com.oplus.utils.C0846g.f(r9)     // Catch: java.lang.Throwable -> Lba java.lang.Exception -> Lbd
            r3.append(r9)     // Catch: java.lang.Throwable -> Lba java.lang.Exception -> Lbd
            java.lang.String r9 = r3.toString()     // Catch: java.lang.Throwable -> Lba java.lang.Exception -> Lbd
            v6.C1627a.c(r1, r9)     // Catch: java.lang.Throwable -> Lba java.lang.Exception -> Lbd
            goto Lbf
        Lba:
            r9 = move-exception
            r0 = r10
            goto Ld3
        Lbd:
            r0 = r10
            goto Lca
        Lbf:
            r10.close()     // Catch: java.lang.Throwable -> Lba java.lang.Exception -> Lbd
            goto Lc4
        Lc3:
            r0 = r10
        Lc4:
            if (r0 == 0) goto Ld2
        Lc6:
            r0.close()
            goto Ld2
        Lca:
            java.lang.String r9 = "URI error!"
            v6.C1627a.h(r1, r9)     // Catch: java.lang.Throwable -> L6f
            if (r0 == 0) goto Ld2
            goto Lc6
        Ld2:
            return r2
        Ld3:
            if (r0 == 0) goto Ld8
            r0.close()
        Ld8:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: v6.C1632f.Y(java.lang.String, android.content.Context):v6.f$c");
    }

    public static void Z(Context context) {
        boolean z10;
        if (f37446U == null) {
            f37446U = new d();
        }
        f37446U.a();
        if (context == null) {
            C1627a.c("InterceptUtils", "queryRideModeData, context is null...");
            return;
        }
        if (((Integer) j(context, "smartdrive.ride_mode_settings.", "ride_mode_switch")).intValue() != -1) {
            d dVar = f37446U;
            boolean z11 = false;
            if (((Integer) j(context, "smartdrive.ride_mode_settings.", "ride_mode_switch")).intValue() == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            dVar.f37484a = z10;
            d dVar2 = f37446U;
            if (dVar2.f37484a) {
                dVar2.f37485b = ((Integer) j(context, "smartdrive.ride_mode_settings.", "ride_mode_allow_calls_from")).intValue();
                d dVar3 = f37446U;
                if (((Integer) j(context, "smartdrive.ride_mode_settings.", "ride_mode_repeat_ringing")).intValue() == 1) {
                    z11 = true;
                }
                dVar3.f37486c = z11;
            }
        } else {
            Cursor cursor = null;
            try {
                try {
                    cursor = context.getContentResolver().query(f37436K, f37437L, null, null, null);
                    if (cursor != null && cursor.moveToFirst()) {
                        f37446U.f37484a = l(cursor, "ride_mode_switch");
                        d dVar4 = f37446U;
                        if (dVar4.f37484a) {
                            dVar4.f37485b = cursor.getInt(cursor.getColumnIndex("ride_mode_allow_calls_from"));
                            f37446U.f37486c = l(cursor, "ride_mode_repeat_ringing");
                        }
                    }
                } catch (Exception e10) {
                    f37446U.a();
                    C1627a.h("InterceptUtils", "e : " + e10);
                }
            } finally {
                I9.a.a(cursor);
            }
        }
        if (C1627a.f37411c) {
            C1627a.c("InterceptUtils", "sRideModeData : " + f37446U.toString());
        }
    }

    public static void a0(Context context) {
        boolean z10;
        boolean z11;
        if (f37445T == null) {
            f37445T = new e();
        }
        f37445T.a();
        if (context == null) {
            C1627a.c("InterceptUtils", "querySmartDriveData, context is null...");
            return;
        }
        Cursor cursor = null;
        boolean z12 = false;
        if (l7.b.g(context)) {
            if (((Integer) j(context, "ocar.smartdrive.smart_drive_settings.", "smart_drive_switch")).intValue() != -1) {
                e eVar = f37445T;
                if (((Integer) j(context, "ocar.smartdrive.smart_drive_settings.", "smart_drive_switch")).intValue() == 1) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                eVar.f37487a = z11;
                e eVar2 = f37445T;
                if (eVar2.f37487a) {
                    eVar2.f37488b = ((Integer) j(context, "ocar.smartdrive.smart_drive_settings.", "allow_calls_from")).intValue();
                    e eVar3 = f37445T;
                    if (((Integer) j(context, "ocar.smartdrive.smart_drive_settings.", "repeat_ringing")).intValue() == 1) {
                        z12 = true;
                    }
                    eVar3.f37489c = z12;
                }
            } else {
                try {
                    try {
                        cursor = context.getContentResolver().query(f37439N, f37441P, null, null, null);
                        if (cursor != null && cursor.moveToFirst()) {
                            f37445T.f37487a = l(cursor, "smart_drive_switch");
                            e eVar4 = f37445T;
                            if (eVar4.f37487a) {
                                eVar4.f37488b = cursor.getInt(cursor.getColumnIndex("allow_calls_from"));
                                f37445T.f37489c = l(cursor, "repeat_ringing");
                            }
                        }
                    } catch (Exception e10) {
                        f37445T.a();
                        C1627a.h("InterceptUtils", "e : " + e10);
                    }
                } finally {
                }
            }
        } else if (((Integer) j(context, "smartdrive.smart_drive_settings.", "smart_drive_switch")).intValue() != -1) {
            e eVar5 = f37445T;
            if (((Integer) j(context, "smartdrive.smart_drive_settings.", "smart_drive_switch")).intValue() == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            eVar5.f37487a = z10;
            e eVar6 = f37445T;
            if (eVar6.f37487a) {
                eVar6.f37488b = ((Integer) j(context, "smartdrive.smart_drive_settings.", "allow_calls_from")).intValue();
                e eVar7 = f37445T;
                if (((Integer) j(context, "smartdrive.smart_drive_settings.", "repeat_ringing")).intValue() == 1) {
                    z12 = true;
                }
                eVar7.f37489c = z12;
            }
        } else {
            try {
                try {
                    cursor = context.getContentResolver().query(f37438M, f37441P, null, null, null);
                    if (cursor != null && cursor.moveToFirst()) {
                        f37445T.f37487a = l(cursor, "smart_drive_switch");
                        e eVar8 = f37445T;
                        if (eVar8.f37487a) {
                            eVar8.f37488b = cursor.getInt(cursor.getColumnIndex("allow_calls_from"));
                            f37445T.f37489c = l(cursor, "repeat_ringing");
                        }
                    }
                } catch (Exception e11) {
                    f37445T.a();
                    C1627a.h("InterceptUtils", "e : " + e11);
                }
            } finally {
            }
        }
        if (C1627a.f37411c) {
            C1627a.c("InterceptUtils", "mSmartDriveData : " + f37445T.toString());
        }
    }

    public static d.e b0(Context context, int i10, boolean z10) {
        int i11;
        d.e eVar = new d.e();
        SharedPreferences b10 = j.b(context);
        if (C1627a.f37411c) {
            C1627a.c("InterceptUtils", "readBlockSettings slotId =" + i10);
        }
        if (i10 == 1 && B(context, f37454h, 3, i10)) {
            if (C1627a.f37411c) {
                C1627a.c("InterceptUtils", "readBlockSettings useSim1RulesOn need change slot id to 00");
            }
            i10 = 0;
        }
        eVar.f26696j = i10;
        String str = f37447a;
        if (l7.b.f34739g) {
            i11 = 0;
        } else {
            i11 = 3;
        }
        eVar.f26687a = B(context, str, i11, i10);
        eVar.f26688b = H(context, i10);
        eVar.f26689c = false;
        if (l7.b.o()) {
            eVar.f26700n = F(context, i10);
            eVar.f26701o = I(context, i10);
            eVar.f26702p = G(context, i10);
        }
        boolean B10 = B(context, f37467u, 0, i10);
        eVar.f26690d = B10;
        if (B10 && !k0(context, i10, false, Calendar.getInstance()) && z10) {
            eVar.f26690d = false;
        }
        boolean B11 = B(context, f37464r, 0, i10);
        eVar.f26691e = B11;
        if (B11 && !k0(context, i10, true, Calendar.getInstance()) && z10) {
            eVar.f26691e = false;
        }
        if (eVar.f26690d) {
            eVar.f26692f = C(b10, "not_intercept_repeat_call", 0, i10);
        }
        if (l7.b.f34737e) {
            eVar.f26695i = false;
            eVar.f26699m = false;
        } else {
            eVar.f26695i = C(b10, "not_intercept_credible_strangers", 3, i10);
            eVar.f26699m = C(b10, "not_intercept_credible_strangers", 3, i10);
        }
        eVar.f26698l = C(b10, "not_intercept_repeat_call", 0, i10);
        z6.b.c(context, 1, "numberrecognition_switch", 1);
        eVar.f26694h = q(context);
        eVar.f26693g = P(context, i10);
        if (D.c(context)) {
            eVar.f26703q = D.a(context);
        }
        if (eVar.f26693g) {
            eVar.f26697k = C(b10, "not_intercept_repeat_call", 0, i10);
        }
        eVar.f26704r = C(b10, "harass_intercept_attribution", 3, i10);
        return eVar;
    }

    public static void c0(Context context) {
        if (context == null) {
            return;
        }
        C1627a.c("InterceptUtils", "sendChangeDefaultDialerBroadcast");
        Intent intent = new Intent(C1629c.f37418d);
        intent.putExtra("app_type", "default_app_dial");
        intent.putExtra("app_pkg", C1629c.f37417c);
        intent.setFlags(OplusPhoneUtils.FLAG_RECEIVER_INCLUDE_BACKGROUND);
        context.sendBroadcast(intent, OplusPhoneUtils.PERMISSION_OPLUS_COMPONENT_SAFE);
    }

    public static void d(Context context) {
        int m10 = m(context) + 1;
        if (C1627a.f37411c) {
            C1627a.c("InterceptUtils", "addCountDelayType count = " + m10);
        }
        z6.b.i(context, 1, f37450d, m10);
    }

    public static void d0(int i10) {
        if (C1627a.f37411c) {
            C1627a.c("InterceptUtils", "setHarassInterceptDialogType type = " + i10);
        }
        f37442Q = i10;
    }

    public static void e(Context context) {
        int n10 = n(context) + 1;
        if (C1627a.f37411c) {
            C1627a.c("InterceptUtils", "addCountStrangerType count = " + n10);
        }
        z6.b.i(context, 1, f37452f, n10);
    }

    public static void e0(InCallDialogActivity inCallDialogActivity) {
        if (C1627a.f37411c) {
            C1627a.c("InterceptUtils", "setInCallDialogActivity activity = " + inCallDialogActivity);
        }
        f37443R = inCallDialogActivity;
    }

    public static void f(Context context) {
        int o10 = o(context) + 1;
        if (C1627a.f37411c) {
            C1627a.c("InterceptUtils", "addCountUnknownType count = " + o10);
        }
        z6.b.i(context, 1, f37451e, o10);
    }

    public static void f0(Context context, RecyclerView recyclerView) {
        if (recyclerView == null) {
            O("setListViewEffects, listView is null, return");
            return;
        }
        recyclerView.setVerticalScrollBarEnabled(false);
        recyclerView.setClipToPadding(false);
        recyclerView.setPadding(0, context.getResources().getDimensionPixelOffset(C6.f.f392f), 0, 0);
    }

    public static void g(Context context) {
        int i10 = f37442Q;
        if (i10 == 0) {
            f(context);
        } else if (i10 == 2) {
            e(context);
        } else if (i10 == 1) {
            d(context);
        }
    }

    public static void g0(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Exception e10) {
            C1627a.q("InterceptUtils", "startActivitySafely catch error " + e10);
        }
    }

    public static String h(String str) {
        int i10;
        if (C1627a.f37411c) {
            C1627a.c("InterceptUtils", "filterSpecialCharacter number = " + C0846g.f(str));
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            str = str.replace(" ", "");
            int length = str.length();
            int indexOf = str.indexOf(",");
            int indexOf2 = str.indexOf(Constants.DataMigration.SPLIT_TAG);
            if (indexOf != -1 && indexOf2 == -1) {
                i10 = indexOf;
            } else if (indexOf == -1 && indexOf2 != -1) {
                i10 = indexOf2;
            } else if (indexOf != -1 && indexOf2 != -1) {
                i10 = Math.min(indexOf, indexOf2);
            } else {
                i10 = -1;
            }
            if (i10 != -1 && i10 < length) {
                str = str.substring(0, i10);
            }
            if (C1627a.f37411c) {
                C1627a.c("InterceptUtils", "filterSpecialCharacter length = " + length + "  commaPos = " + indexOf + " semicolonPos = " + indexOf2 + " number = " + C0846g.f(str));
            }
        } catch (Exception e10) {
            Log.e("InterceptUtils", "e = " + e10);
        }
        return str;
    }

    public static void h0(Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction("oplus.intent.action.anti.harassment");
            intent.setPackage(context.getPackageName());
            intent.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
            intent.putExtra("package", f37453g);
            context.startActivity(intent);
        } catch (Exception e10) {
            Log.e("InterceptUtils", "startInterceptActivity: " + e10);
            C1627a.q("InterceptUtils", "startInterceptActivity catch error");
        }
    }

    public static List<SubscriptionInfo> i(Context context) {
        List<SubscriptionInfo> list;
        if (context == null) {
            O("onCreate context is null, finish this activity.");
            return null;
        }
        try {
            list = SubscriptionManager.from(context).getActiveSubscriptionInfoList();
        } catch (SecurityException e10) {
            Log.e("InterceptUtils", "getActiveSubscriptionInfoList lack of perimission: " + e10);
            list = null;
        }
        if (list == null) {
            O("onCreate simList is null, finish this activity.");
            return null;
        }
        if (F6.b.e(context)) {
            int f10 = F6.b.f(context);
            Iterator<SubscriptionInfo> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SubscriptionInfo next = it.next();
                if (next.getSimSlotIndex() == f10) {
                    list.remove(next);
                    break;
                }
            }
        }
        return list;
    }

    public static void i0(Context context, String str, a.C0239a c0239a, Handler handler) {
        if (C1627a.f37411c) {
            C1627a.c("InterceptUtils", "startStrangerCalllogQuery...");
        }
        c0239a.f26646w = 1;
        new Thread(new a(c0239a, context, str, handler)).start();
    }

    public static Object j(Context context, String str, String str2) {
        try {
            return Integer.valueOf(C1188a.f.c(context.getContentResolver(), str + str2));
        } catch (Exception e10) {
            Log.e("InterceptUtils", "getAppSetting error. e = " + e10);
            return -1;
        }
    }

    public static void j0(final Context context, final String str, int i10, int i11) {
        int a10 = SettingsWrapper$Global.a(context.getContentResolver(), l0(str), i11, new InterfaceC1637a() { // from class: v6.e
            @Override // v9.InterfaceC1637a
            public final Object invoke() {
                Integer N10;
                N10 = C1632f.N(context, str);
                return N10;
            }
        });
        if (i10 == 5 || i10 != a10) {
            C0846g.i("InterceptUtils", "手机搬家，需要设置拦截类型的勾选状态");
            Settings.Global.putInt(context.getContentResolver(), str, a10);
        }
    }

    public static String k(PackageManager packageManager, String str) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = packageManager.getApplicationInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            C1627a.q("InterceptUtils", "Application info not found for packageName " + str);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            return str;
        }
        return applicationInfo.loadLabel(packageManager).toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0140, code lost:
    
        if (r5 <= r2) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0153  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean k0(android.content.Context r10, int r11, boolean r12, java.util.Calendar r13) {
        /*
            Method dump skipped, instructions count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v6.C1632f.k0(android.content.Context, int, boolean, java.util.Calendar):boolean");
    }

    public static boolean l(Cursor cursor, String str) {
        if (cursor == null || cursor.getInt(cursor.getColumnIndex(str)) != 1) {
            return false;
        }
        return true;
    }

    public static String l0(String str) {
        if (str.endsWith("_v2")) {
            return str.substring(0, str.length() - 3);
        }
        return str;
    }

    public static int m(Context context) {
        int c10 = z6.b.c(context, 1, f37450d, 0);
        if (C1627a.f37411c) {
            C1627a.c("InterceptUtils", "getCountDelayType count = " + c10);
        }
        return c10;
    }

    public static void m0(Context context, int i10, int i11) {
        int i12;
        int i13;
        int i14;
        boolean B10 = B(context, f37464r, 0, i10);
        boolean B11 = B(context, f37467u, 0, i10);
        SharedPreferences b10 = j.b(context);
        SharedPreferences.Editor edit = j.b(context).edit();
        int a10 = new PreferenceWrapper(b10).a("not_intercept_repeat_call", 0);
        int i15 = 1;
        if (i10 == 0) {
            i12 = 2;
        } else {
            i12 = 1;
        }
        int i16 = i12 & a10;
        if (i10 == 0) {
            i13 = 1;
        } else {
            i13 = 2;
        }
        int i17 = a10 | i13;
        int i18 = b10.getInt("not_intercept_credible_strangers", 3);
        if (i10 == 0) {
            i14 = 2;
        } else {
            i14 = 1;
        }
        int i19 = i14 & i18;
        if (i10 != 0) {
            i15 = 2;
        }
        int i20 = i18 | i15;
        if (B10) {
            edit.putInt("not_intercept_repeat_call", i16);
            edit.putInt("not_intercept_credible_strangers", i19);
        } else if (B11) {
            boolean B12 = B(context, f37465s, 0, i10);
            boolean B13 = B(context, f37466t, 3, i10);
            if (B12) {
                edit.putInt("not_intercept_repeat_call", i17);
            } else {
                edit.putInt("not_intercept_repeat_call", i16);
            }
            if (B13) {
                edit.putInt("not_intercept_credible_strangers", i20);
            } else {
                edit.putInt("not_intercept_credible_strangers", i19);
            }
        } else {
            boolean B14 = B(context, f37432G, 0, i10);
            boolean B15 = B(context, f37433H, 3, i10);
            boolean B16 = B(context, f37463q, 0, i10);
            if (!B14 && !B16) {
                edit.putInt("not_intercept_repeat_call", i16);
            } else {
                edit.putInt("not_intercept_repeat_call", i17);
            }
            if (B15) {
                edit.putInt("not_intercept_credible_strangers", i20);
            } else {
                edit.putInt("not_intercept_credible_strangers", i19);
            }
        }
        if (-1 != i11) {
            edit.putInt("not_intercept_repeat_call", i11);
        }
        edit.apply();
    }

    public static int n(Context context) {
        int c10 = z6.b.c(context, 1, f37452f, 0);
        if (C1627a.f37411c) {
            C1627a.c("InterceptUtils", "getCountStrangerType count = " + c10);
        }
        return c10;
    }

    public static void n0(Context context) {
        if (context == null) {
            return;
        }
        SharedPreferences b10 = j.b(context);
        int i10 = -1;
        if (!b10.contains("not_intercept_repeat_call")) {
            i10 = new PreferenceWrapper(b10).a("not_intercept_repeat_call", -1);
        }
        o0(context, 0);
        o0(context, 1);
        m0(context, 0, i10);
        m0(context, 1, i10);
        C0849j.z(context);
    }

    public static int o(Context context) {
        int c10 = z6.b.c(context, 1, f37451e, 0);
        if (C1627a.f37411c) {
            C1627a.c("InterceptUtils", "getCountUnknownType count = " + c10);
        }
        return c10;
    }

    public static void o0(Context context, int i10) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        boolean B10 = B(context, f37464r, 0, i10);
        boolean B11 = B(context, f37467u, 0, i10);
        if (B10) {
            str = com.oplus.blacklistapp.callintercept.a.f26566a;
            str2 = com.oplus.blacklistapp.callintercept.a.f26568c + i10;
            str3 = com.oplus.blacklistapp.callintercept.a.f26569d + i10;
            str4 = com.oplus.blacklistapp.callintercept.a.f26570e + i10;
            str5 = com.oplus.blacklistapp.callintercept.a.f26571f + i10;
            str6 = com.oplus.blacklistapp.callintercept.a.f26572g + i10;
        } else if (B11) {
            str = com.oplus.blacklistapp.callintercept.a.f26567b;
            str2 = com.oplus.blacklistapp.callintercept.a.f26573h + i10;
            str3 = com.oplus.blacklistapp.callintercept.a.f26574i + i10;
            str4 = com.oplus.blacklistapp.callintercept.a.f26575j + i10;
            str5 = com.oplus.blacklistapp.callintercept.a.f26576k + i10;
            str6 = com.oplus.blacklistapp.callintercept.a.f26577l + i10;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
        }
        SharedPreferences b10 = j.b(context);
        SharedPreferences.Editor edit = j.b(context).edit();
        if (B10 || B11) {
            boolean B12 = B(context, str, 0, i10);
            int i11 = b10.getInt("auto_open_and_close", 0);
            int i12 = 2;
            if (B12) {
                if (i10 == 0) {
                    i12 = 1;
                }
                edit.putInt("auto_open_and_close", i11 | i12);
            } else {
                if (i10 != 0) {
                    i12 = 1;
                }
                edit.putInt("auto_open_and_close", i11 & i12);
            }
            edit.putInt("open_days_" + i10, z6.b.c(context, 1, str2, 65));
            edit.putInt("open_start_hour_" + i10, z6.b.c(context, 1, str3, 23));
            edit.putInt("open_start_minute_" + i10, z6.b.c(context, 1, str4, 0));
            edit.putInt("open_end_hour_" + i10, z6.b.c(context, 1, str5, 8));
            edit.putInt("open_end_minute_" + i10, z6.b.c(context, 1, str6, 0));
            edit.apply();
        }
    }

    public static String p(Context context) {
        String str = C1629c.f37417c;
        TelecomManager telecomManager = (TelecomManager) context.getSystemService("telecom");
        if (telecomManager == null) {
            return str;
        }
        try {
            str = telecomManager.getDefaultDialerPackage();
        } catch (Exception e10) {
            O("getDefaultDialerPackage error! " + e10);
        }
        if (TextUtils.isEmpty(str)) {
            return C1629c.f37417c;
        }
        return str;
    }

    public static int q(Context context) {
        if (context == null) {
            return AFConstants.BIND_SERVICE_TIMEOUTMILLIS;
        }
        int c10 = z6.b.c(context, 1, f37449c, AFConstants.BIND_SERVICE_TIMEOUTMILLIS);
        if (C1627a.f37411c) {
            C1627a.c("InterceptUtils", "getTimeDelayRing time = " + c10);
        }
        return c10;
    }

    public static int r(Context context, int i10) {
        if (context == null) {
            return 0;
        }
        int i11 = 1;
        try {
            int d10 = MarkNumberThresholdUtil.d(i10, context);
            i11 = MarkNumberThresholdUtil.c(d10);
            if (C1627a.f37411c) {
                C1627a.c("InterceptUtils", "getMarkNumberThreshold  oldThreshold " + d10 + " newThreshold = " + i11);
            }
        } catch (Exception e10) {
            C0846g.i("InterceptUtils", "e=" + e10.toString());
        }
        return i11;
    }

    public static d s() {
        return f37446U;
    }

    public static e t() {
        return f37445T;
    }

    public static boolean u(long j10) {
        boolean z10;
        long currentTimeMillis = System.currentTimeMillis() - j10;
        if (C1627a.f37411c) {
            C1627a.c("InterceptUtils", "hasLastCallInShortTime   dua = " + currentTimeMillis);
        }
        if (180000 >= currentTimeMillis) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (C1627a.f37411c) {
            C1627a.c("InterceptUtils", "hasLastCallInShortTime   bRet = " + z10);
        }
        return z10;
    }

    public static int v(Context context, int i10, int i11, int i12) {
        String str;
        int i13;
        boolean B10;
        int i14;
        if (C1627a.f37411c) {
            C1627a.c("InterceptUtils", "isBlockedByMarkNumberInfo slotId = " + i10 + "  markInfoType =  " + i11);
        }
        if (i11 != 1) {
            if (i11 != 3) {
                if (i11 != 4) {
                    if (i11 != 5) {
                        str = null;
                        i13 = -1;
                    } else {
                        str = f37458l;
                        i13 = 53;
                    }
                } else {
                    str = f37456j;
                    i13 = 51;
                }
            } else {
                str = f37455i;
                i13 = 50;
            }
        } else {
            str = f37457k;
            i13 = 52;
        }
        if (!TextUtils.isEmpty(str)) {
            if (str == f37455i) {
                B10 = B(context, str, 3, i10);
            } else {
                B10 = B(context, str, 0, i10);
            }
            if (B10 && i12 == -1) {
                C1627a.c("InterceptUtils", "local marked count is zeto threshold return blocked " + str);
                return i13;
            }
            if (B10) {
                i14 = MarkNumberThresholdUtil.e(i10, context, str);
            } else {
                i14 = -1;
            }
            if (i14 == 0) {
                i14 = r(context, i10);
            }
            if (C1627a.f37411c) {
                C1627a.c("InterceptUtils", "isBlockedByMarkNumberInfo threshold = " + i14 + "  markInfoCount =  " + i12);
            }
            if (i12 == 0) {
                i12 = 2;
            }
            if (i14 != -1 && i12 > i14) {
                return i13;
            }
        }
        return -1;
    }

    public static boolean w(int i10) {
        boolean z10;
        if (i10 >= 6 && i10 <= 8) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (C1627a.f37411c) {
            C1627a.c("InterceptUtils", "isCredibleMarkInfo   bRet = " + z10 + "  markInfoType = " + i10);
        }
        return z10;
    }

    public static boolean x() {
        return !"wifi-only".equals(C0566b.a("ro.carrier"));
    }

    public static boolean y(String str) {
        boolean z10;
        boolean z11 = false;
        if (!TextUtils.isEmpty(str)) {
            String replace = str.replace(" ", "");
            int length = replace.length();
            char charAt = replace.charAt(0);
            if (C1627a.f37411c) {
                C1627a.c("InterceptUtils", "isFamilyOrCornetGroupNumber number = " + C0846g.f(replace) + "  length = " + length + "  startChar = " + charAt);
            }
            if (charAt == '6' && length >= 3 && length <= 6) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10 && length >= 3 && length <= 5) {
                for (char c10 : f37435J) {
                    if (c10 == charAt) {
                        z11 = true;
                        break;
                    }
                }
            }
            z11 = z10;
        }
        if (C1627a.f37411c) {
            C1627a.c("InterceptUtils", "isFamilyOrCornetGroupNumber bRet = " + z11);
        }
        return z11;
    }

    public static boolean z(Context context) {
        return true;
    }
}
