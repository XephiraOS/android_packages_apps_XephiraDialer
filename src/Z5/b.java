package Z5;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import kotlin.jvm.internal.i;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.m;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f5955a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static int f5956b;

    /* renamed from: c, reason: collision with root package name */
    public static Boolean f5957c;

    /* renamed from: d, reason: collision with root package name */
    public static String f5958d;

    /* renamed from: e, reason: collision with root package name */
    public static Integer f5959e;

    public static final int a(Context context) {
        Integer g10;
        int i10;
        i.f(context, "context");
        Integer num = f5959e;
        if (num == null) {
            g10 = m.g(d(context, "protocol_version_codes"));
            if (g10 != null) {
                i10 = g10.intValue();
            } else {
                i10 = 0;
            }
            f5959e = Integer.valueOf(i10);
            return i10;
        }
        return num.intValue();
    }

    public static final boolean b(Context context) {
        Boolean i02;
        boolean z10;
        i.f(context, "context");
        Boolean bool = f5957c;
        if (bool == null) {
            i02 = StringsKt__StringsKt.i0(d(context, "aiunit_download_enable"));
            if (i02 != null) {
                z10 = i02.booleanValue();
            } else {
                z10 = false;
            }
            f5957c = Boolean.valueOf(z10);
            return z10;
        }
        return bool.booleanValue();
    }

    public static final String c(Context context) {
        i.f(context, "context");
        String str = f5958d;
        if (str == null) {
            String d10 = d(context, "aiunit_download_group");
            f5958d = d10;
            return d10;
        }
        return str;
    }

    public static final String d(Context context, String key) {
        Object obj;
        String obj2;
        i.f(context, "context");
        i.f(key, "key");
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        i.e(applicationInfo, "getApplicationInfo(...)");
        Bundle bundle = applicationInfo.metaData;
        if (bundle == null || (obj = bundle.get(key)) == null || (obj2 = obj.toString()) == null) {
            return "";
        }
        return obj2;
    }

    public static final String e(Context context, String pkgName, String key) {
        Object obj;
        i.f(context, "context");
        i.f(pkgName, "pkgName");
        i.f(key, "key");
        try {
            PackageManager packageManager = context.getPackageManager();
            i.e(packageManager, "getPackageManager(...)");
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(pkgName, 128);
            i.e(applicationInfo, "getApplicationInfo(...)");
            Bundle bundle = applicationInfo.metaData;
            if (bundle == null || (obj = bundle.get(key)) == null) {
                return "";
            }
            String obj2 = obj.toString();
            if (obj2 == null) {
                return "";
            }
            return obj2;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static final int f(Context context) {
        i.f(context, "context");
        int i10 = f5956b;
        if (i10 > 0) {
            return i10;
        }
        String packageName = context.getPackageName();
        i.e(packageName, "getPackageName(...)");
        int g10 = g(context, packageName);
        f5956b = g10;
        return g10;
    }

    public static final int g(Context context, String pkgName) {
        i.f(context, "context");
        i.f(pkgName, "pkgName");
        try {
            PackageManager packageManager = context.getPackageManager();
            i.e(packageManager, "getPackageManager(...)");
            return packageManager.getPackageInfo(pkgName, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public static final boolean h(Context context, String pkgName) {
        Boolean i02;
        i.f(context, "context");
        i.f(pkgName, "pkgName");
        i02 = StringsKt__StringsKt.i0(e(context, pkgName, "com.oplus.aiunit.large.model"));
        if (i02 != null) {
            return i02.booleanValue();
        }
        return false;
    }

    public static final boolean i(Context context, String pkgName) {
        i.f(context, "context");
        i.f(pkgName, "pkgName");
        return Boolean.parseBoolean(e(context, pkgName, "supportAIUnitAndOcrService"));
    }
}
