package com.customize.contacts.manager;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.customize.contacts.feature.OSPublicFeature;
import com.customize.contacts.util.SettingUtils;
import com.customize.contacts.util.b0;
import com.oplus.backup.sdk.common.utils.ApplicationFileInfo;
import com.oplus.backup.sdk.common.utils.Constants;
import java.util.List;
import kotlin.Result;
import kotlin.collections.C1229j;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: CustomVibrationManager.kt */
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f21549a = new h();

    /* renamed from: b, reason: collision with root package name */
    public static final Integer[] f21550b = {-1, 64};

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, android.content.Intent] */
    public static final Intent a(Context context, String str) {
        int d10;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        if (context != null) {
            ?? intent = new Intent();
            intent.setAction("oplus.intent.action.settings.VIBRATE_PICKER");
            intent.putExtra(ApplicationFileInfo.PACKAGE_NAME, context.getPackageName());
            int f10 = f(context, str);
            if (j(f10)) {
                intent.putExtra("init_vibrate_type", f10);
            } else {
                if (b0.O() == 1) {
                    if (b0.u0(context, 0)) {
                        d10 = G0.c.d(context, 2, "ringtone_vibrate_type", 64);
                    } else {
                        d10 = G0.c.d(context, 2, "ringtone_sim2_vibrate_type", 64);
                    }
                } else {
                    d10 = G0.c.d(context, 2, "ringtone_vibrate_type", 64);
                }
                intent.putExtra("init_vibrate_type", d10);
            }
            ref$ObjectRef.element = intent;
        }
        return (Intent) ref$ObjectRef.element;
    }

    public static final String b(Integer num, String str) {
        if (num != null && str != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(num.intValue());
            stringBuffer.append(Constants.DataMigration.SPLIT_TAG);
            stringBuffer.append(str);
            return stringBuffer.toString();
        }
        return null;
    }

    public static final void c(Fragment fragment, Intent intent) {
        Object b10;
        m9.q qVar;
        kotlin.jvm.internal.i.f(intent, "intent");
        try {
            Result.a aVar = Result.f34166a;
            if (fragment != null) {
                fragment.startActivityForResult(intent, 989);
                qVar = m9.q.f35511a;
            } else {
                qVar = null;
            }
            b10 = Result.b(qVar);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        if (Result.d(b10) != null) {
            H7.b.c("CustomVibrationManager", "No activity found for intent: " + intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final String d(Context context, String str, String str2, String str3) {
        Object b10;
        T t10;
        Context createPackageContext;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        try {
            Result.a aVar = Result.f34166a;
            if (context != null && (createPackageContext = context.createPackageContext(str3, 3)) != null) {
                t10 = createPackageContext.getResources().getString(createPackageContext.getResources().getIdentifier(str, str2, str3));
            } else {
                t10 = 0;
            }
            ref$ObjectRef.element = t10;
            b10 = Result.b(m9.q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("CustomVibrationManager", "getStringFromOtherApp(), e = " + d10);
        }
        return (String) ref$ObjectRef.element;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String e(android.content.Context r8, java.lang.String r9, java.lang.String r10) {
        /*
            r0 = 0
            kotlin.Result$a r1 = kotlin.Result.f34166a     // Catch: java.lang.Throwable -> L3d
            if (r9 == 0) goto L46
            java.lang.String r1 = ";"
            java.lang.String[] r3 = new java.lang.String[]{r1}     // Catch: java.lang.Throwable -> L3d
            r6 = 6
            r7 = 0
            r4 = 0
            r5 = 0
            r2 = r9
            java.util.List r9 = kotlin.text.f.Y(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L3d
            int r1 = r9.size()     // Catch: java.lang.Throwable -> L3d
            r2 = 2
            if (r1 != r2) goto L3f
            r1 = 0
            java.lang.Object r1 = r9.get(r1)     // Catch: java.lang.Throwable -> L3d
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L3d
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Throwable -> L3d
            r2 = 1
            java.lang.Object r9 = r9.get(r2)     // Catch: java.lang.Throwable -> L3d
            java.lang.String r9 = (java.lang.String) r9     // Catch: java.lang.Throwable -> L3d
            java.lang.String r2 = "string"
            java.lang.String r3 = "com.android.settings"
            boolean r1 = k(r8, r1)     // Catch: java.lang.Throwable -> L3d
            if (r1 != 0) goto L38
            goto L40
        L38:
            java.lang.String r10 = d(r8, r9, r2, r3)     // Catch: java.lang.Throwable -> L3d
            goto L40
        L3d:
            r8 = move-exception
            goto L4c
        L3f:
            r10 = r0
        L40:
            m9.q r0 = m9.q.f35511a     // Catch: java.lang.Throwable -> L43
            goto L47
        L43:
            r8 = move-exception
            r0 = r10
            goto L4c
        L46:
            r10 = r0
        L47:
            java.lang.Object r8 = kotlin.Result.b(r0)     // Catch: java.lang.Throwable -> L43
            goto L57
        L4c:
            kotlin.Result$a r9 = kotlin.Result.f34166a
            java.lang.Object r8 = kotlin.b.a(r8)
            java.lang.Object r8 = kotlin.Result.b(r8)
            r10 = r0
        L57:
            java.lang.Throwable r8 = kotlin.Result.d(r8)
            if (r8 == 0) goto L73
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "getVibrationName(), e = "
            r9.append(r0)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            java.lang.String r9 = "CustomVibrationManager"
            H7.b.c(r9, r8)
        L73:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.manager.h.e(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    public static final int f(Context context, String str) {
        Object b10;
        List Y9;
        int i10 = -1;
        try {
            Result.a aVar = Result.f34166a;
            if (context != null && str != null) {
                Y9 = StringsKt__StringsKt.Y(str, new String[]{Constants.DataMigration.SPLIT_TAG}, false, 0, 6, null);
                if (Y9.size() == 2 && Y9.get(0) != null) {
                    i10 = Integer.parseInt((String) Y9.get(0));
                }
            }
            b10 = Result.b(m9.q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("CustomVibrationManager", "getVibrationType(), e = " + d10);
        }
        H7.b.e("CustomVibrationManager", "getVibrationType, type: " + i10);
        return i10;
    }

    public static final boolean g() {
        if (H7.a.b()) {
            H7.b.b("CustomVibrationManager", "isSupportCustomVibration--> isCustomVibrationColumnAdded: " + SettingUtils.g() + ",isSettingAppOK: " + SettingUtils.i() + ",isSupportImVibrator: " + OSPublicFeature.f21034a.t());
        }
        if (SettingUtils.g() && SettingUtils.i() && OSPublicFeature.f21034a.t()) {
            return true;
        }
        return false;
    }

    public static final boolean h(int i10, String name) {
        kotlin.jvm.internal.i.f(name, "name");
        if (j(i10) && i(name)) {
            return true;
        }
        return false;
    }

    public static final boolean i(String str) {
        if (str != null) {
            return true;
        }
        return false;
    }

    public static final boolean j(int i10) {
        if (i10 != -1) {
            return true;
        }
        return false;
    }

    public static final boolean k(Context context, int i10) {
        boolean t10;
        t10 = C1229j.t(f21550b, Integer.valueOf(i10));
        return !t10;
    }

    public static final boolean l(Context context, String str) {
        if (g() && str != null) {
            return k(context, f(context, str));
        }
        return false;
    }
}
