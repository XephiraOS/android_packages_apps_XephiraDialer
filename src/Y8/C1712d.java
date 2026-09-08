package y8;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.android.incallui.OplusPhoneUtils;
import java.util.HashMap;
import java.util.Map;
import s8.C1562e;

/* compiled from: ApkInfoUtil.java */
/* renamed from: y8.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1712d {

    /* renamed from: a, reason: collision with root package name */
    public static final Map<Application, String> f38154a = new HashMap();

    public static String c(Context context) {
        Application application = (Application) context.getApplicationContext();
        Map<Application, String> map = f38154a;
        String str = map.get(application);
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = null;
        try {
            str2 = String.valueOf(context.getPackageManager().getApplicationInfo(e(context), 128).metaData.get("AppCode"));
            if (TextUtils.isEmpty(str2)) {
                C1714f.b("ApkInfoUtil", new InterfaceC1715g() { // from class: y8.b
                    @Override // y8.InterfaceC1715g
                    public final Object get() {
                        String g10;
                        g10 = C1712d.g();
                        return g10;
                    }
                });
            } else {
                map.put(application, str2);
            }
        } catch (Exception e10) {
            C1714f.b("ApkInfoUtil", new C1562e(e10));
            e10.printStackTrace();
        }
        return str2;
    }

    public static String d(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (Exception e10) {
            C1714f.b("ApkInfoUtil", new C1562e(e10));
            return OplusPhoneUtils.DeviceState.UNLOCK_DEVICE;
        }
    }

    public static String e(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (Exception e10) {
            C1714f.b("ApkInfoUtil", new C1562e(e10));
            return OplusPhoneUtils.DeviceState.UNLOCK_DEVICE;
        }
    }

    public static String f(Context context) {
        String str = OplusPhoneUtils.DeviceState.UNLOCK_DEVICE;
        try {
            final PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo == null) {
                return OplusPhoneUtils.DeviceState.UNLOCK_DEVICE;
            }
            String str2 = packageInfo.versionName;
            if (str2 == null) {
                return OplusPhoneUtils.DeviceState.UNLOCK_DEVICE;
            }
            try {
                C1714f.c("ApkInfoUtil", new InterfaceC1715g() { // from class: y8.c
                    @Override // y8.InterfaceC1715g
                    public final Object get() {
                        String h10;
                        h10 = C1712d.h(packageInfo);
                        return h10;
                    }
                });
                return str2;
            } catch (Exception e10) {
                e = e10;
                str = str2;
                C1714f.b("ApkInfoUtil", new C1562e(e));
                return str;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    public static /* synthetic */ String g() {
        return "AppCode not set. please read the document of OplusTrack SDK.";
    }

    public static /* synthetic */ String h(PackageInfo packageInfo) {
        return "versionName=" + packageInfo.versionName;
    }

    public static void i(Context context, String str) {
        f38154a.put((Application) context.getApplicationContext(), str);
    }
}
