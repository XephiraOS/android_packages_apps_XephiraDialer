package com.internal_dependency;

import android.app.NotificationChannel;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.UserHandle;
import android.telecom.Call;
import android.telecom.PhoneAccountHandle;
import android.view.View;
import android.view.ViewRootImpl;
import android.widget.FrameLayout;
import android.widget.Toast;
import java.io.InputStream;

/* compiled from: InternalSdkDependsInterface.kt */
/* loaded from: classes3.dex */
public interface InternalSdkDependsInterface {
    void closeSystemDialogs(String str);

    String extractNetworkPortionAlt(String str);

    boolean getBooleanCarrierConfig(Context context, String str, int i10);

    boolean getBooleanSystemProperties(String str, boolean z10);

    String getCurrentCountryIso(Context context);

    int getInitialDisplayDensity(int i10);

    int getIntSystemProperties(String str, int i10);

    boolean getOplusVolteVideoCallEnable(Context context, int i10, int i11, boolean z10);

    boolean getOplusVowifiVideoCallEnable(Context context, int i10, int i11, boolean z10);

    int getPhoneId(Context context, int i10);

    int getPhoneTypeBySlotId(Context context, int i10);

    int getSecureSettingsIntForCurrentUser(ContentResolver contentResolver, String str, int i10);

    int getSecureSettingsIntForSystemUser(ContentResolver contentResolver, String str, int i10);

    String getStringSystemProperties(String str, String str2);

    int getSubId(Context context, int i10);

    String getTelecomCallId(Call call);

    String getTelephonyProperty(Context context, int i10, String str, String str2);

    String getUsernameFromUriNumber(String str);

    int getViewPaddingLeft(View view);

    int getViewPaddingTop(View view);

    ViewRootImpl getViewRootImpl(View view);

    String getVoiceMailNumber(Context context, int i10, PhoneAccountHandle phoneAccountHandle);

    void goToSleep(Context context);

    boolean hasNavigationBar(int i10);

    boolean isConfigEnabled(Context context, int i10);

    boolean isDsdaEnabled(Context context);

    boolean isEmergencyNumber(Context context, int i10, String str);

    boolean isEmergencyNumber(Context context, String str);

    boolean isInEmergencyCall(Context context);

    boolean isInLockTaskMode(Context context);

    boolean isNotSystemUser();

    boolean isReplyWithSmsAllowed(Context context);

    boolean isRinging(Context context);

    boolean isTelephonyIdle(Context context);

    boolean isUriNumber(String str);

    boolean isVolteOrWfc(Context context);

    boolean isZenModeOn(Context context);

    InputStream openDefaultWallpaper(Context context, int i10);

    void oplusPokeUserActivity(Context context);

    void putSecureSettingsIntForCurrentUser(ContentResolver contentResolver, String str, int i10);

    void sendBroadcastAsAllUser(Context context, Intent intent, String str);

    void setLayoutParamsForToast(Toast toast);

    void setLocationEnabledForUser(Context context, boolean z10, UserHandle userHandle);

    void setMarginsRelative(FrameLayout.LayoutParams layoutParams, int i10, int i11, int i12, int i13);

    void updateNotificationChannelForPackage(Context context, String str, NotificationChannel notificationChannel);
}
