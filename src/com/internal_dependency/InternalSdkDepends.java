package com.internal_dependency;

import android.app.ActivityManager;
import android.app.NotificationChannel;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.telecom.Call;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.telephony.PhoneNumberUtils;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.ViewRootImpl;
import android.widget.FrameLayout;
import android.widget.Toast;
import java.io.InputStream;
import java.lang.reflect.Method;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.d;
import m9.e;
import v9.InterfaceC1637a;

/* compiled from: InternalSdkDepends.kt */
/* loaded from: classes3.dex */
public final class InternalSdkDepends implements InternalSdkDependsInterface {
    public static final String LOG_TAG = "InternalSdkDependsImpl";
    public static final Companion Companion = new Companion(null);
    private static final d<InternalSdkDepends> sInstance$delegate = e.a(LazyThreadSafetyMode.f34161a, new InterfaceC1637a<InternalSdkDepends>() { // from class: com.internal_dependency.InternalSdkDepends$Companion$sInstance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // v9.InterfaceC1637a
        public final InternalSdkDepends invoke() {
            return new InternalSdkDepends();
        }
    });

    /* compiled from: InternalSdkDepends.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public final InternalSdkDepends getSInstance() {
            return (InternalSdkDepends) InternalSdkDepends.sInstance$delegate.getValue();
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public static /* synthetic */ void getSInstance$annotations() {
        }
    }

    public static final InternalSdkDepends getSInstance() {
        return Companion.getSInstance();
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public void closeSystemDialogs(String text) {
        i.f(text, "text");
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public String extractNetworkPortionAlt(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        boolean z10 = false;
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (charAt == '+') {
                if (!z10) {
                    z10 = true;
                } else {
                    continue;
                }
            }
            if (PhoneNumberUtils.isDialable(charAt)) {
                sb.append(charAt);
            } else if (PhoneNumberUtils.isStartsPostDial(charAt)) {
                break;
            }
        }
        return sb.toString();
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public boolean getBooleanCarrierConfig(Context context, String key, int i10) {
        i.f(key, "key");
        return false;
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public boolean getBooleanSystemProperties(String key, boolean z10) {
        i.f(key, "key");
        return z10;
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public String getCurrentCountryIso(Context context) {
        String currentCountryIso = OplusCountryDetector.getInstance(context).getCurrentCountryIso();
        i.e(currentCountryIso, "getInstance(context).currentCountryIso");
        return currentCountryIso;
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public int getInitialDisplayDensity(int i10) {
        try {
            Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
            Method method = cls.getMethod("getWindowManagerService", null);
            i.e(method, "aClass.getMethod(\"getWindowManagerService\")");
            method.setAccessible(true);
            Object invoke = method.invoke(cls, null);
            i.d(invoke, "null cannot be cast to non-null type kotlin.Any");
            Method method2 = invoke.getClass().getMethod("getInitialDisplayDensity", Integer.TYPE);
            i.e(method2, "iwm.javaClass.getMethod(…:class.javaPrimitiveType)");
            method2.setAccessible(true);
            Object invoke2 = method2.invoke(invoke, 0);
            i.d(invoke2, "null cannot be cast to non-null type kotlin.Any");
            return ((Integer) invoke2).intValue();
        } catch (Exception e10) {
            Log.d(LOG_TAG, "getInitialDisplayDensity:" + e10.getMessage());
            return -1;
        }
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public int getIntSystemProperties(String key, int i10) {
        i.f(key, "key");
        return SystemProperties.getInt(key, i10);
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public boolean getOplusVolteVideoCallEnable(Context context, int i10, int i11, boolean z10) {
        return true;
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public boolean getOplusVowifiVideoCallEnable(Context context, int i10, int i11, boolean z10) {
        return true;
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public int getPhoneId(Context context, int i10) {
        Object obj;
        int i11;
        int slotIndex = SubscriptionManager.getSlotIndex(i10);
        TelephonyManager telephonyManager = null;
        if (context != null) {
            obj = context.getSystemService("phone");
        } else {
            obj = null;
        }
        if (obj instanceof TelephonyManager) {
            telephonyManager = (TelephonyManager) obj;
        }
        if (telephonyManager != null) {
            i11 = telephonyManager.getActiveModemCount();
        } else {
            i11 = 0;
        }
        if (slotIndex >= i11 || slotIndex < 0) {
            return 0;
        }
        return slotIndex;
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public int getPhoneTypeBySlotId(Context context, int i10) {
        Object obj;
        TelephonyManager telephonyManager = null;
        if (context != null) {
            obj = context.getSystemService("phone");
        } else {
            obj = null;
        }
        if (obj instanceof TelephonyManager) {
            telephonyManager = (TelephonyManager) obj;
        }
        if (telephonyManager != null) {
            return telephonyManager.getPhoneType();
        }
        return -1;
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public int getSecureSettingsIntForCurrentUser(ContentResolver cr, String name, int i10) {
        i.f(cr, "cr");
        i.f(name, "name");
        return i10;
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public int getSecureSettingsIntForSystemUser(ContentResolver cr, String name, int i10) {
        i.f(cr, "cr");
        i.f(name, "name");
        return i10;
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public String getStringSystemProperties(String key, String defaultValue) {
        i.f(key, "key");
        i.f(defaultValue, "defaultValue");
        return defaultValue;
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public int getSubId(Context context, int i10) {
        boolean z10;
        if (context == null) {
            return -1;
        }
        Object systemService = context.getSystemService((Class<Object>) SubscriptionManager.class);
        i.e(systemService, "context.getSystemService…:class.java\n            )");
        int[] subscriptionIds = ((SubscriptionManager) systemService).getSubscriptionIds(i10);
        if (subscriptionIds == null) {
            return -1;
        }
        if (subscriptionIds.length == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!(!z10)) {
            return -1;
        }
        return subscriptionIds[0];
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public String getTelecomCallId(Call call) {
        i.f(call, "call");
        return "";
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public String getTelephonyProperty(Context context, int i10, String property, String defaultVal) {
        i.f(property, "property");
        i.f(defaultVal, "defaultVal");
        return "";
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public String getUsernameFromUriNumber(String number) {
        i.f(number, "number");
        int I10 = kotlin.text.f.I(number, '@', 0, false, 6, null);
        if (I10 < 0) {
            I10 = kotlin.text.f.J(number, "%40", 0, false, 6, null);
        }
        if (I10 < 0) {
            Log.w(LOG_TAG, "getUsernameFromUriNumber: no delimiter found in SIP addr '" + number + '\'');
            I10 = number.length();
        }
        String substring = number.substring(0, I10);
        i.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public int getViewPaddingLeft(View view) {
        i.f(view, "view");
        return view.getPaddingLeft();
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public int getViewPaddingTop(View view) {
        i.f(view, "view");
        return view.getPaddingTop();
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public ViewRootImpl getViewRootImpl(View view) {
        return null;
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public String getVoiceMailNumber(Context context, int i10, PhoneAccountHandle phoneAccountHandle) {
        Object obj;
        TelecomManager telecomManager;
        i.f(phoneAccountHandle, "phoneAccountHandle");
        String str = null;
        if (context != null) {
            obj = context.getSystemService("telecom");
        } else {
            obj = null;
        }
        if (obj instanceof TelecomManager) {
            telecomManager = (TelecomManager) obj;
        } else {
            telecomManager = null;
        }
        if (telecomManager != null) {
            str = telecomManager.getVoiceMailNumber(phoneAccountHandle);
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public boolean hasNavigationBar(int i10) {
        return true;
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public boolean isConfigEnabled(Context context, int i10) {
        return false;
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public boolean isDsdaEnabled(Context context) {
        return false;
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public boolean isEmergencyNumber(Context context, int i10, String number) {
        i.f(number, "number");
        Object systemService = context != null ? context.getSystemService("phone") : null;
        TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
        if (telephonyManager != null) {
            return telephonyManager.isEmergencyNumber(number);
        }
        return false;
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public boolean isInEmergencyCall(Context context) {
        return false;
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public boolean isInLockTaskMode(Context context) {
        Object obj;
        ActivityManager activityManager = null;
        if (context != null) {
            obj = context.getSystemService("activity");
        } else {
            obj = null;
        }
        if (obj instanceof ActivityManager) {
            activityManager = (ActivityManager) obj;
        }
        boolean z10 = false;
        if (activityManager != null && activityManager.getLockTaskModeState() == 0) {
            z10 = true;
        }
        return !z10;
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public boolean isNotSystemUser() {
        if (UserHandle.myUserId() != 0) {
            return true;
        }
        return false;
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public boolean isReplyWithSmsAllowed(Context context) {
        return true;
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public boolean isRinging(Context context) {
        return false;
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public boolean isTelephonyIdle(Context context) {
        Object obj;
        TelecomManager telecomManager = null;
        if (context != null) {
            obj = context.getSystemService("telecom");
        } else {
            obj = null;
        }
        if (obj instanceof TelecomManager) {
            telecomManager = (TelecomManager) obj;
        }
        if (telecomManager != null) {
            return telecomManager.isInCall();
        }
        return false;
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public boolean isUriNumber(String str) {
        if (str == null) {
            return false;
        }
        if (!kotlin.text.f.y(str, "@", false, 2, null) && !kotlin.text.f.y(str, "%40", false, 2, null)) {
            return false;
        }
        return true;
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public boolean isVolteOrWfc(Context context) {
        return false;
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public boolean isZenModeOn(Context context) {
        return false;
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public InputStream openDefaultWallpaper(Context context, int i10) {
        return null;
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public void putSecureSettingsIntForCurrentUser(ContentResolver cr, String name, int i10) {
        i.f(cr, "cr");
        i.f(name, "name");
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public void sendBroadcastAsAllUser(Context context, Intent intent, String str) {
        i.f(intent, "intent");
        if (context != null) {
            context.sendBroadcastAsUser(intent, Process.myUserHandle(), str);
        }
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public void setLayoutParamsForToast(Toast toast) {
        i.f(toast, "toast");
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public void setLocationEnabledForUser(Context context, boolean z10, UserHandle userHandle) {
        i.f(userHandle, "userHandle");
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public void setMarginsRelative(FrameLayout.LayoutParams layoutParams, int i10, int i11, int i12, int i13) {
        i.f(layoutParams, "layoutParams");
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public boolean isEmergencyNumber(Context context, String number) {
        i.f(number, "number");
        Object systemService = context != null ? context.getSystemService("phone") : null;
        TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
        if (telephonyManager != null) {
            return telephonyManager.isEmergencyNumber(number);
        }
        return false;
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public void goToSleep(Context context) {
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public void oplusPokeUserActivity(Context context) {
    }

    @Override // com.internal_dependency.InternalSdkDependsInterface
    public void updateNotificationChannelForPackage(Context context, String str, NotificationChannel notificationChannel) {
    }
}
