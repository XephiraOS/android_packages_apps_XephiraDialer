package M7;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import kotlin.Result;
import kotlin.jvm.internal.i;

/* compiled from: MetaDataUtils.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1795a = new a();

    public static final String a(Context context, String packageName, String str, String str2) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo;
        Bundle bundle;
        Object obj;
        i.f(packageName, "packageName");
        if (context != null) {
            try {
                packageManager = context.getPackageManager();
            } catch (Throwable th) {
                H7.b.c("MetaDataUtils", "hasMetaData has NameNotFoundException = " + th);
            }
            if (packageManager != null) {
                applicationInfo = packageManager.getApplicationInfo(packageName, 128);
                if (applicationInfo == null && (bundle = applicationInfo.metaData) != null && (obj = bundle.get(str)) != null) {
                    str2 = obj.toString();
                } else {
                    str2 = null;
                }
                H7.b.e("MetaDataUtils", "getMetaData: packageName = " + packageName + ", metaDataName = " + str + ", metaValue = " + str2);
                return str2;
            }
        }
        applicationInfo = null;
        if (applicationInfo == null) {
        }
        str2 = null;
        H7.b.e("MetaDataUtils", "getMetaData: packageName = " + packageName + ", metaDataName = " + str + ", metaValue = " + str2);
        return str2;
    }

    public static final String[] b(Context context, String packageName, String str) {
        i.f(packageName, "packageName");
        return d(context, packageName, str, null, 8, null);
    }

    public static final String[] c(Context context, String packageName, String str, Context context2) {
        Object b10;
        Integer num;
        String[] strArr;
        Resources resources;
        i.f(packageName, "packageName");
        Object obj = null;
        try {
            Result.a aVar = Result.f34166a;
            String a10 = a(context, packageName, str, null);
            if (a10 != null) {
                num = Integer.valueOf(Integer.parseInt(a10));
            } else {
                num = null;
            }
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        if (num == null) {
            return null;
        }
        if (context2 == null) {
            if (context != null) {
                context2 = context.createPackageContext(packageName, 0);
            } else {
                context2 = null;
            }
        }
        if (context2 != null && (resources = context2.getResources()) != null) {
            strArr = resources.getStringArray(num.intValue());
        } else {
            strArr = null;
        }
        b10 = Result.b(strArr);
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("MetaDataUtils", "getMetaDataStringRes " + packageName + " " + str + " " + d10 + " " + d10.getMessage());
        }
        if (!Result.f(b10)) {
            obj = b10;
        }
        return (String[]) obj;
    }

    public static /* synthetic */ String[] d(Context context, String str, String str2, Context context2, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            context2 = null;
        }
        return c(context, str, str2, context2);
    }

    public static final String e(Context context, String packageName, String str) {
        i.f(packageName, "packageName");
        return g(context, packageName, str, null, 8, null);
    }

    public static final String f(Context context, String packageName, String str, Context context2) {
        Object b10;
        Integer num;
        String str2;
        i.f(packageName, "packageName");
        Object obj = null;
        try {
            Result.a aVar = Result.f34166a;
            String a10 = a(context, packageName, str, null);
            if (a10 != null) {
                num = Integer.valueOf(Integer.parseInt(a10));
            } else {
                num = null;
            }
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        if (num == null) {
            return null;
        }
        if (context2 == null) {
            if (context != null) {
                context2 = context.createPackageContext(packageName, 0);
            } else {
                context2 = null;
            }
        }
        if (context2 != null) {
            str2 = context2.getString(num.intValue());
        } else {
            str2 = null;
        }
        b10 = Result.b(str2);
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("MetaDataUtils", "getMetaDataStringRes " + packageName + " " + str + " " + d10 + " " + d10.getMessage());
        }
        if (!Result.f(b10)) {
            obj = b10;
        }
        return (String) obj;
    }

    public static /* synthetic */ String g(Context context, String str, String str2, Context context2, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            context2 = null;
        }
        return f(context, str, str2, context2);
    }

    public static final boolean h(Context context, String packageName, String str, String str2) {
        i.f(packageName, "packageName");
        String a10 = a(context, packageName, str, "-");
        boolean equals = TextUtils.equals(a10, str2);
        H7.b.e("MetaDataUtils", "hasMetaData: packageName = " + packageName + ", metaDataName = " + str + ", enableValue = " + str2 + ", metaDataValue = " + a10 + ", hasMeta = " + equals);
        return equals;
    }
}
