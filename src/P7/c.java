package P7;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.android.incallui.OplusPhoneUtils;
import java.util.List;
import kotlin.jvm.internal.i;

/* compiled from: PackageUtils.kt */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f2966a = new c();

    public static final ResolveInfo b(Intent intent, Context context, boolean z10) {
        List<ResolveInfo> queryIntentActivities;
        if (intent == null || context == null) {
            return null;
        }
        if (z10) {
            queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            i.e(queryIntentActivities, "{\n            context.pa…H_DEFAULT_ONLY)\n        }");
        } else {
            queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 1114112);
            i.e(queryIntentActivities, "{\n            context.pa…              )\n        }");
        }
        if (!(!queryIntentActivities.isEmpty())) {
            return null;
        }
        return queryIntentActivities.get(0);
    }

    public static final boolean c(Context context, String packageName, boolean z10) {
        i.f(packageName, "packageName");
        return e(context, packageName, z10, true);
    }

    public static final boolean d(Context context, String packageName, boolean z10) {
        i.f(packageName, "packageName");
        return e(context, packageName, z10, false);
    }

    public static final boolean e(Context context, String str, boolean z10, boolean z11) {
        int i10;
        boolean z12 = false;
        if (context != null) {
            if (z10) {
                i10 = OplusPhoneUtils.PROPERTY_HIGH_DEF_AUDIO_EVS;
            } else {
                i10 = 0;
            }
            ApplicationInfo applicationInfo = null;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    applicationInfo = packageManager.getApplicationInfo(str, i10);
                }
            } catch (PackageManager.NameNotFoundException e10) {
                H7.b.c("PackageUtils", "packageName : " + str + " not installed, e = " + e10);
            }
            if (z11) {
                if (applicationInfo != null) {
                    z12 = applicationInfo.enabled;
                }
            } else if (applicationInfo != null) {
                z12 = true;
            }
        }
        H7.b.e("PackageUtils", str + " isAppInstalled : " + z12);
        return z12;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean f(final android.content.Context r4, final java.lang.String r5, final boolean r6) {
        /*
            java.lang.String r0 = "packageName"
            kotlin.jvm.internal.i.f(r5, r0)
            boolean r0 = H7.a.b()
            java.lang.String r1 = "PackageUtils"
            if (r0 == 0) goto L12
            java.lang.String r0 = "isAppInstalled begin."
            H7.b.b(r1, r0)
        L12:
            r0 = 1
            java.util.concurrent.ExecutorService r0 = java.util.concurrent.Executors.newFixedThreadPool(r0)
            P7.b r2 = new P7.b
            r2.<init>()
            java.util.concurrent.Future r4 = r0.submit(r2)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39 java.lang.InterruptedException -> L42 java.util.concurrent.TimeoutException -> L48
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39 java.lang.InterruptedException -> L42 java.util.concurrent.TimeoutException -> L48
            r2 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r4 = r4.get(r2, r6)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39 java.lang.InterruptedException -> L42 java.util.concurrent.TimeoutException -> L48
            java.lang.String r6 = "future[ONE_SECOND.toLong(), TimeUnit.MILLISECONDS]"
            kotlin.jvm.internal.i.e(r4, r6)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39 java.lang.InterruptedException -> L42 java.util.concurrent.TimeoutException -> L48
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39 java.lang.InterruptedException -> L42 java.util.concurrent.TimeoutException -> L48
            boolean r4 = r4.booleanValue()     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39 java.lang.InterruptedException -> L42 java.util.concurrent.TimeoutException -> L48
            r0.shutdown()
            goto L4f
        L37:
            r4 = move-exception
            goto L72
        L39:
            java.lang.String r4 = "isAppInstalled has an error."
            H7.b.c(r1, r4)     // Catch: java.lang.Throwable -> L37
        L3e:
            r0.shutdown()
            goto L4e
        L42:
            java.lang.String r4 = "isAppInstalled is interrupted."
            H7.b.c(r1, r4)     // Catch: java.lang.Throwable -> L37
            goto L3e
        L48:
            java.lang.String r4 = "isAppInstalled is time out."
            H7.b.c(r1, r4)     // Catch: java.lang.Throwable -> L37
            goto L3e
        L4e:
            r4 = 0
        L4f:
            boolean r6 = H7.a.b()
            if (r6 == 0) goto L71
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "packageName "
            r6.append(r0)
            r6.append(r5)
            java.lang.String r5 = " isAppInstalled end. "
            r6.append(r5)
            r6.append(r4)
            java.lang.String r5 = r6.toString()
            H7.b.b(r1, r5)
        L71:
            return r4
        L72:
            r0.shutdown()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: P7.c.f(android.content.Context, java.lang.String, boolean):boolean");
    }

    public static final Boolean g(boolean z10, Context context, String packageName) {
        int i10;
        i.f(packageName, "$packageName");
        boolean z11 = false;
        if (z10) {
            i10 = OplusPhoneUtils.PROPERTY_HIGH_DEF_AUDIO_EVS;
        } else {
            i10 = 0;
        }
        ApplicationInfo applicationInfo = null;
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    applicationInfo = packageManager.getApplicationInfo(packageName, i10);
                }
            } catch (Exception e10) {
                H7.b.c("PackageUtils", "packageName : " + packageName + " not installed, e = " + e10);
            }
        }
        if (applicationInfo != null && applicationInfo.enabled) {
            z11 = true;
        }
        return Boolean.valueOf(z11);
    }
}
