package com.android.contacts.framework.baseui.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.lifecycle.LiveData;
import com.android.incallui.BuildConfig;
import com.android.incallui.Log;
import com.oplus.evolution.NetworklessCallback;
import com.oplus.evolution.NetworklessManager;
import com.oplus.foundation.util.systemcore.PrimaryUserUtils;
import com.oplus.os.OplusBuild;
import j8.C1188a;
import kotlin.Result;
import u5.C1609a;
import v9.InterfaceC1637a;

/* compiled from: NoNetworkCommUiStateUtil.kt */
/* loaded from: classes.dex */
public final class NoNetworkCommUiStateUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final NoNetworkCommUiStateUtil f15861a;

    /* renamed from: b, reason: collision with root package name */
    public static final m9.d f15862b;

    /* renamed from: c, reason: collision with root package name */
    public static final m9.d f15863c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f15864d;

    /* renamed from: e, reason: collision with root package name */
    public static final androidx.lifecycle.v<Boolean> f15865e;

    /* renamed from: f, reason: collision with root package name */
    public static final LiveData<Boolean> f15866f;

    /* renamed from: g, reason: collision with root package name */
    public static NetworklessCallback f15867g;

    /* compiled from: NoNetworkCommUiStateUtil.kt */
    /* loaded from: classes.dex */
    public static final class a extends NetworklessCallback implements NetworklessCallback.DeviceSupportChangedListener {
        public void onDeviceSupportChanged(boolean z10) {
            H7.b.e("NoNetworkCommUiStateUtil", "onDeviceSupportChanged " + z10);
            NoNetworkCommUiStateUtil.f15864d = z10;
            NoNetworkCommUiStateUtil.f15865e.m(Boolean.valueOf(NoNetworkCommUiStateUtil.f15861a.d()));
        }
    }

    static {
        m9.d b10;
        m9.d b11;
        NoNetworkCommUiStateUtil noNetworkCommUiStateUtil = new NoNetworkCommUiStateUtil();
        f15861a = noNetworkCommUiStateUtil;
        b10 = kotlin.a.b(new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.framework.baseui.util.NoNetworkCommUiStateUtil$isFeatureSupport$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                Boolean bool;
                try {
                    Result.a aVar = Result.f34166a;
                    boolean b12 = C1609a.a(P7.a.f2961a.a()).b("oplus.software.radio.networkless_support");
                    H7.b.e("NoNetworkCommUiStateUtil", "featureSupport " + b12);
                    bool = Boolean.valueOf(b12);
                } catch (Throwable th) {
                    Result.a aVar2 = Result.f34166a;
                    Throwable d10 = Result.d(Result.b(kotlin.b.a(th)));
                    if (d10 != null) {
                        StackTraceElement stackTraceElement = d10.getStackTrace()[0];
                        int lineNumber = stackTraceElement.getLineNumber();
                        String methodName = stackTraceElement.getMethodName();
                        H7.b.c(stackTraceElement.getClassName(), "line:" + lineNumber + " " + methodName + " " + d10.getMessage());
                    }
                    bool = null;
                }
                return Boolean.valueOf(bool != null ? bool.booleanValue() : false);
            }
        });
        f15862b = b10;
        b11 = kotlin.a.b(new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.framework.baseui.util.NoNetworkCommUiStateUtil$isOSDKApiSupport$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                int i10 = OplusBuild.VERSION.SDK_VERSION;
                int i11 = OplusBuild.VERSION.SDK_SUB_VERSION;
                boolean z10 = (i10 == 31 && i11 >= 24) || (i10 == 33 && i11 >= 42) || ((i10 == 34 && i11 >= 4) || i10 >= 35);
                H7.b.e("NoNetworkCommUiStateUtil", "isOSDKApiSupport : " + z10 + " " + i10 + Log.TAG_DELIMETER + i11);
                return Boolean.valueOf(z10);
            }
        });
        f15863c = b11;
        f15864d = true;
        androidx.lifecycle.v<Boolean> vVar = new androidx.lifecycle.v<>(Boolean.valueOf(noNetworkCommUiStateUtil.d()));
        f15865e = vVar;
        H7.b.e("NoNetworkCommUiStateUtil", "_isSupport : " + vVar.getValue());
        f15866f = vVar;
        if (noNetworkCommUiStateUtil.h()) {
            try {
                Result.a aVar = Result.f34166a;
                f15867g = new a();
                new NetworklessManager(P7.a.f2961a.a()).registerNetworklessCallback(f15867g);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                Throwable d10 = Result.d(Result.b(kotlin.b.a(th)));
                if (d10 != null) {
                    StackTraceElement stackTraceElement = d10.getStackTrace()[0];
                    int lineNumber = stackTraceElement.getLineNumber();
                    String methodName = stackTraceElement.getMethodName();
                    H7.b.c(stackTraceElement.getClassName(), "line:" + lineNumber + " " + methodName + " " + d10.getMessage());
                }
            }
        }
    }

    public static final LiveData<Boolean> i() {
        return f15866f;
    }

    public final boolean d() {
        if (h() && f() && f15864d && g() && k() && e() && j()) {
            return true;
        }
        return false;
    }

    public final boolean e() {
        boolean h10 = M7.a.h(P7.a.f2961a.a(), "com.oplus.beaconlink", "support_beacon_link", "true");
        H7.b.e("NoNetworkCommUiStateUtil", "isBeaconAppSupport: " + h10);
        return h10;
    }

    public final boolean f() {
        return ((Boolean) f15862b.getValue()).booleanValue();
    }

    public final boolean g() {
        boolean h10 = M7.a.h(P7.a.f2961a.a(), BuildConfig.LIBRARY_PACKAGE_NAME, "support_beacon_link", "true");
        H7.b.e("NoNetworkCommUiStateUtil", "isInCallUIAppSupport: " + h10);
        return h10;
    }

    public final boolean h() {
        return ((Boolean) f15863c.getValue()).booleanValue();
    }

    public final boolean j() {
        Object b10;
        try {
            Result.a aVar = Result.f34166a;
            boolean isNetworklessSupported = new NetworklessManager(P7.a.f2961a.a()).isNetworklessSupported();
            H7.b.e("NoNetworkCommUiStateUtil", "systemNetworkSupport: " + isNetworklessSupported);
            b10 = Result.b(Boolean.valueOf(isNetworklessSupported));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("NoNetworkCommUiStateUtil", "isSystemNetworkSupport " + d10 + " " + d10.getMessage());
        }
        Boolean bool = Boolean.FALSE;
        if (Result.f(b10)) {
            b10 = bool;
        }
        return ((Boolean) b10).booleanValue();
    }

    public final boolean k() {
        boolean h10 = M7.a.h(P7.a.f2961a.a(), "com.android.server.telecom", "support_beacon_link", "true");
        H7.b.e("NoNetworkCommUiStateUtil", "isTelecomAppSupport: " + h10);
        return h10;
    }

    public final boolean l(Context context, boolean z10) {
        String str;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        if (z10) {
            str = "no_network_comm_entered_or_ignored_under_no_net";
        } else {
            str = "no_network_comm_entered_or_ignored_under_net";
        }
        return R7.d.d(defaultSharedPreferences, str, false, 2, null);
    }

    public final boolean m(Context context) {
        Object b10;
        try {
            Result.a aVar = Result.f34166a;
            int c10 = C1188a.b.c(context.getContentResolver(), "user_setup_beacon");
            boolean z10 = true;
            if (c10 != 1) {
                z10 = false;
            }
            b10 = Result.b(Boolean.valueOf(z10));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("NoNetworkCommUiStateUtil", "isUserSetNetworkFunc getInt error " + d10 + " " + d10.getMessage());
        }
        Boolean bool = Boolean.FALSE;
        if (Result.f(b10)) {
            b10 = bool;
        }
        return ((Boolean) b10).booleanValue();
    }

    public final boolean n(Context context) {
        if (!kotlin.jvm.internal.i.b(f15866f.getValue(), Boolean.TRUE)) {
            return false;
        }
        if (!PrimaryUserUtils.a()) {
            H7.b.e("NoNetworkCommUiStateUtil", "needShowNoNetworkTipsUnderNoNet not primary user");
            return false;
        }
        if (context == null) {
            H7.b.e("NoNetworkCommUiStateUtil", "needShowNetworkTipsUnderNet context is null");
            return false;
        }
        if (!J7.a.d() || m(context) || l(context, false)) {
            return false;
        }
        return true;
    }

    public final boolean o(Context context, boolean z10) {
        if (!kotlin.jvm.internal.i.b(f15866f.getValue(), Boolean.TRUE)) {
            return false;
        }
        if (!PrimaryUserUtils.a()) {
            H7.b.e("NoNetworkCommUiStateUtil", "needShowNoNetworkTipsUnderNoNet not primary user");
            return false;
        }
        if (context == null) {
            H7.b.e("NoNetworkCommUiStateUtil", "needShowNoNetworkTipsUnderNoNet context is null");
            return false;
        }
        if (z10 || J7.a.d() || M7.c.a(context)) {
            return false;
        }
        H7.b.e("NoNetworkCommUiStateUtil", "needShowNoNetworkTips noInternet");
        if (!m(context) || l(context, true)) {
            return false;
        }
        return true;
    }

    public final void p(Context context) {
        H7.b.e("NoNetworkCommUiStateUtil", "startNoNetworkActivity");
        if (context == null) {
            H7.b.c("NoNetworkCommUiStateUtil", "startNoNetworkActivity context is null");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("oplus.intent.action.Beacon_Link_SETTINGS");
        intent.setPackage("com.oplus.beaconlink");
        R7.b.f(context, intent, 0, null, 6, null);
    }

    public final void q(Context context, boolean z10) {
        String str;
        kotlin.jvm.internal.i.f(context, "context");
        SharedPreferences.Editor b10 = R7.d.b(PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext()));
        if (z10) {
            str = "no_network_comm_entered_or_ignored_under_no_net";
        } else {
            str = "no_network_comm_entered_or_ignored_under_net";
        }
        R7.d.a(R7.d.h(b10, str, true));
    }
}
