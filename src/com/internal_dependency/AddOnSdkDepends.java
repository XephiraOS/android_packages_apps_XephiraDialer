package com.internal_dependency;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Environment;
import android.os.RemoteException;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.OplusWindowManager;
import android.view.WindowManager;
import androidx.core.content.b;
import com.oplus.content.OplusFeatureConfigManager;
import com.oplus.coreapp.appfeature.AppFeatureProviderUtils;
import java.io.File;
import kotlin.LazyThreadSafetyMode;
import kotlin.a;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: AddOnSdkDepends.kt */
/* loaded from: classes3.dex */
public final class AddOnSdkDepends implements AddOnSdkDependsInterface {
    public static final Companion Companion = new Companion(null);
    public static final String LOG_TAG = "AddOnSdkDependsImpl";
    private static final d<AddOnSdkDepends> sInstance$delegate;

    /* compiled from: AddOnSdkDepends.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public final AddOnSdkDepends getSInstance() {
            return (AddOnSdkDepends) AddOnSdkDepends.sInstance$delegate.getValue();
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public static /* synthetic */ void getSInstance$annotations() {
        }
    }

    static {
        d<AddOnSdkDepends> a10;
        a10 = a.a(LazyThreadSafetyMode.f34161a, new InterfaceC1637a<AddOnSdkDepends>() { // from class: com.internal_dependency.AddOnSdkDepends$Companion$sInstance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final AddOnSdkDepends invoke() {
                return new AddOnSdkDepends();
            }
        });
        sInstance$delegate = a10;
    }

    public static final AddOnSdkDepends getSInstance() {
        return Companion.getSInstance();
    }

    @Override // com.internal_dependency.AddOnSdkDependsInterface
    public void collapseDragonflyPanels() {
        try {
            new OplusWindowManager().requestKeyguard("secondaryhome:collapse_panels");
            Log.d(LOG_TAG, "collapseDragonflyKeyguardPanel: ");
        } catch (RemoteException e10) {
            Log.d(LOG_TAG, "collapseDragonflyKeyguardPanel: exception:" + e10.getMessage());
        } catch (NoSuchMethodError e11) {
            Log.d(LOG_TAG, "collapseDragonflyKeyguardPanel: error:" + e11.getMessage());
        }
    }

    @Override // com.internal_dependency.AddOnSdkDependsInterface
    public void dismissKeyguard(Context context, Activity activity) {
        Object obj;
        KeyguardManager keyguardManager;
        if (activity != null) {
            if (context != null) {
                obj = context.getSystemService("keyguard");
            } else {
                obj = null;
            }
            if (obj instanceof KeyguardManager) {
                keyguardManager = (KeyguardManager) obj;
            } else {
                keyguardManager = null;
            }
            if (keyguardManager != null) {
                keyguardManager.requestDismissKeyguard(activity, null);
            }
        }
    }

    @Override // com.internal_dependency.AddOnSdkDependsInterface
    public int getConfigurationFontVariation(Configuration newConfig) {
        i.f(newConfig, "newConfig");
        return 0;
    }

    @Override // com.internal_dependency.AddOnSdkDependsInterface
    public int getFlipFont(Configuration configuration) {
        return -1;
    }

    @Override // com.internal_dependency.AddOnSdkDependsInterface
    public Rect getFloatWindowRect() {
        return null;
    }

    @Override // com.internal_dependency.AddOnSdkDependsInterface
    public File getInternalSdDirectory(Context context) {
        if (context == null) {
            return null;
        }
        return Environment.getExternalStorageDirectory();
    }

    @Override // com.internal_dependency.AddOnSdkDependsInterface
    public String getInternalSdState(Context context) {
        Object obj;
        StorageManager storageManager;
        StorageVolume storageVolume;
        String str = null;
        if (context != null) {
            obj = context.getSystemService("storage");
        } else {
            obj = null;
        }
        if (obj instanceof StorageManager) {
            storageManager = (StorageManager) obj;
        } else {
            storageManager = null;
        }
        if (storageManager != null) {
            storageVolume = storageManager.getStorageVolume(getInternalSdDirectory(context));
        } else {
            storageVolume = null;
        }
        if (storageVolume != null) {
            str = storageVolume.getState();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // com.internal_dependency.AddOnSdkDependsInterface
    public String getNetworkOperatorGemini(Context context, int i10, int i11) {
        if (context == null) {
            return "";
        }
        Object systemService = context.getSystemService("phone");
        i.d(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        TelephonyManager createForSubscriptionId = ((TelephonyManager) systemService).createForSubscriptionId(i11);
        i.e(createForSubscriptionId, "telephonyManager.createForSubscriptionId(subId)");
        String networkOperator = createForSubscriptionId.getNetworkOperator();
        i.e(networkOperator, "telephonyManager.networkOperator");
        return networkOperator;
    }

    @Override // com.internal_dependency.AddOnSdkDependsInterface
    public int getNetworkTypeGemini(Context context, int i10, int i11) {
        TelephonyManager telephonyManager;
        if (context == null) {
            return -1;
        }
        Object systemService = context.getSystemService("phone");
        TelephonyManager telephonyManager2 = null;
        if (systemService instanceof TelephonyManager) {
            telephonyManager = (TelephonyManager) systemService;
        } else {
            telephonyManager = null;
        }
        if (telephonyManager != null) {
            telephonyManager2 = telephonyManager.createForSubscriptionId(i11);
        }
        if (b.a(context, "android.permission.READ_PHONE_STATE") != 0 || telephonyManager2 == null) {
            return -1;
        }
        return telephonyManager2.getDataNetworkType();
    }

    @Override // com.internal_dependency.AddOnSdkDependsInterface
    public int getNumberHideSettings(Context context) {
        return 0;
    }

    @Override // com.internal_dependency.AddOnSdkDependsInterface
    public boolean getOplusFreezeState(ApplicationInfo applicationInfo) {
        return false;
    }

    @Override // com.internal_dependency.AddOnSdkDependsInterface
    public String getOplusSystemProperties(String key, String def) {
        i.f(key, "key");
        i.f(def, "def");
        return def;
    }

    @Override // com.internal_dependency.AddOnSdkDependsInterface
    public String getSimOperatorGemini(Context context, int i10, int i11) {
        Object obj;
        TelephonyManager telephonyManager;
        TelephonyManager telephonyManager2;
        String str = null;
        if (context != null) {
            obj = context.getSystemService("phone");
        } else {
            obj = null;
        }
        if (obj instanceof TelephonyManager) {
            telephonyManager = (TelephonyManager) obj;
        } else {
            telephonyManager = null;
        }
        if (telephonyManager != null) {
            telephonyManager2 = telephonyManager.createForSubscriptionId(i11);
        } else {
            telephonyManager2 = null;
        }
        if (telephonyManager2 != null) {
            str = telephonyManager2.getSimOperator();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // com.internal_dependency.AddOnSdkDependsInterface
    public boolean getSimlockLockdevice(Context context) {
        return false;
    }

    @Override // com.internal_dependency.AddOnSdkDependsInterface
    public ComponentName getTopActivityComponentName() {
        return new ComponentName("", "");
    }

    @Override // com.internal_dependency.AddOnSdkDependsInterface
    public boolean getTopIsFullscreen() {
        return false;
    }

    @Override // com.internal_dependency.AddOnSdkDependsInterface
    public boolean hasFeature(String str) {
        return OplusFeatureConfigManager.getInstance().hasFeature(str);
    }

    @Override // com.internal_dependency.AddOnSdkDependsInterface
    public boolean isFeatureSupport(ContentResolver contentResolver, String str) {
        return AppFeatureProviderUtils.p(contentResolver, str);
    }

    @Override // com.internal_dependency.AddOnSdkDependsInterface
    public boolean isInSplitScreenMode() {
        return false;
    }

    @Override // com.internal_dependency.AddOnSdkDependsInterface
    public boolean isMotorCameraUp(Context context) {
        return false;
    }

    @Override // com.internal_dependency.AddOnSdkDependsInterface
    public boolean isNavigating(String packageName) {
        i.f(packageName, "packageName");
        return false;
    }

    @Override // com.internal_dependency.AddOnSdkDependsInterface
    public boolean isNetworkRoamingGemini(Context context, int i10, int i11) {
        Object obj;
        TelephonyManager telephonyManager;
        TelephonyManager telephonyManager2 = null;
        if (context != null) {
            obj = context.getSystemService("phone");
        } else {
            obj = null;
        }
        if (obj instanceof TelephonyManager) {
            telephonyManager = (TelephonyManager) obj;
        } else {
            telephonyManager = null;
        }
        if (telephonyManager != null) {
            telephonyManager2 = telephonyManager.createForSubscriptionId(i11);
        }
        if (telephonyManager2 != null) {
            return telephonyManager2.isNetworkRoaming();
        }
        return false;
    }

    @Override // com.internal_dependency.AddOnSdkDependsInterface
    public boolean isOplusFreezed(ApplicationInfo applicationInfo) {
        return false;
    }

    @Override // com.internal_dependency.AddOnSdkDependsInterface
    public boolean isOplusHasSoftSimCard(Context context) {
        return false;
    }

    @Override // com.internal_dependency.AddOnSdkDependsInterface
    public boolean oplusIsImsRegistered(Context context, int i10, int i11) {
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
            return telephonyManager.isImsRegistered(i11);
        }
        return false;
    }

    @Override // com.internal_dependency.AddOnSdkDependsInterface
    public void registerTelephonyExtCallback(Context context) {
        Log.d(LOG_TAG, "registerTelephonyExtCallback , context:" + context);
    }

    @Override // com.internal_dependency.AddOnSdkDependsInterface
    public void setOplusSystemProperties(String key, String str) {
        i.f(key, "key");
    }

    @Override // com.internal_dependency.AddOnSdkDependsInterface
    public void setincommingRingtoneListener(IncommingRingtoneListener incommingRingtoneListener) {
        i.f(incommingRingtoneListener, "incommingRingtoneListener");
        Log.d(LOG_TAG, "setincommingRingtoneListener");
    }

    @Override // com.internal_dependency.AddOnSdkDependsInterface
    public String getOplusSystemProperties(String key) {
        i.f(key, "key");
        return "";
    }

    @Override // com.internal_dependency.AddOnSdkDependsInterface
    public void setHomeAndMenuKeyState(WindowManager.LayoutParams layoutParams) {
    }
}
