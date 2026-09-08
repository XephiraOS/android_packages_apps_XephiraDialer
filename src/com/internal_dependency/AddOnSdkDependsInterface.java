package com.internal_dependency;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.WindowManager;
import java.io.File;

/* compiled from: AddOnSdkDependsInterface.kt */
/* loaded from: classes3.dex */
public interface AddOnSdkDependsInterface {
    void collapseDragonflyPanels();

    void dismissKeyguard(Context context, Activity activity);

    int getConfigurationFontVariation(Configuration configuration);

    int getFlipFont(Configuration configuration);

    Rect getFloatWindowRect();

    File getInternalSdDirectory(Context context);

    String getInternalSdState(Context context);

    String getNetworkOperatorGemini(Context context, int i10, int i11);

    int getNetworkTypeGemini(Context context, int i10, int i11);

    int getNumberHideSettings(Context context);

    boolean getOplusFreezeState(ApplicationInfo applicationInfo);

    String getOplusSystemProperties(String str);

    String getOplusSystemProperties(String str, String str2);

    String getSimOperatorGemini(Context context, int i10, int i11);

    boolean getSimlockLockdevice(Context context);

    ComponentName getTopActivityComponentName();

    boolean getTopIsFullscreen();

    boolean hasFeature(String str);

    boolean isFeatureSupport(ContentResolver contentResolver, String str);

    boolean isInSplitScreenMode();

    boolean isMotorCameraUp(Context context);

    boolean isNavigating(String str);

    boolean isNetworkRoamingGemini(Context context, int i10, int i11);

    boolean isOplusFreezed(ApplicationInfo applicationInfo);

    boolean isOplusHasSoftSimCard(Context context);

    boolean oplusIsImsRegistered(Context context, int i10, int i11);

    void registerTelephonyExtCallback(Context context);

    void setHomeAndMenuKeyState(WindowManager.LayoutParams layoutParams);

    void setOplusSystemProperties(String str, String str2);

    void setincommingRingtoneListener(IncommingRingtoneListener incommingRingtoneListener);
}
