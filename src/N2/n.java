package n2;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.android.incallui.Log;
import com.android.incallui.OplusFeatureOption;
import com.android.incallui.OplusPhoneCapabilities;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.oplus.forceenable.OplusForceEnableDialogActivity;
import com.internal_dependency.AddOnSdkDepends;

/* compiled from: OplusForceEnableUtils.kt */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final n f35606a = new n();

    public static final ApplicationInfo a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            PackageManager packageManager = context.getPackageManager();
            try {
                kotlin.jvm.internal.i.c(str);
                return packageManager.getApplicationInfo(str, 512);
            } catch (PackageManager.NameNotFoundException e10) {
                Log.d("OplusForceEnableUtils", "getApplicationInfo, exception = " + e10.getMessage());
                return null;
            }
        }
        Log.d("OplusForceEnableUtils", "getApplicationInfo, context is null or pkgName is isEmpty ");
        return null;
    }

    public static final boolean b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            ApplicationInfo a10 = a(context, str);
            if (a10 == null || a10.enabled || c(a10)) {
                return false;
            }
            Log.d("OplusForceEnableUtils", "isApkDisable return true");
            return true;
        }
        Log.d("OplusForceEnableUtils", "isApkDisable, context is null or pkgName is isEmpty ");
        return false;
    }

    public static final boolean c(ApplicationInfo applicationInfo) {
        if (OplusFeatureOption.FEATURE_PMS_APP_FROZEN && applicationInfo != null) {
            return AddOnSdkDepends.Companion.getSInstance().getOplusFreezeState(applicationInfo);
        }
        return false;
    }

    public static final void d(Context context, int i10) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) OplusForceEnableDialogActivity.class);
        intent.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
        intent.putExtra("dialog_id", i10);
        OplusPhoneUtils.startSafeActivity(context, intent);
    }
}
