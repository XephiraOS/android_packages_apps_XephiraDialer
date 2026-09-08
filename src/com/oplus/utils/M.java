package com.oplus.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.heytap.accessory.constant.AFConstants;
import java.util.ArrayList;
import kotlin.Result;

/* compiled from: PermissionSettingJumper.kt */
/* loaded from: classes3.dex */
public final class M {

    /* renamed from: a, reason: collision with root package name */
    public static final M f29056a = new M();

    public static final boolean c(Activity activity, String str, int i10, boolean z10) {
        Object b10;
        kotlin.jvm.internal.i.f(activity, "activity");
        Intent a10 = f29056a.a(activity, str, z10);
        try {
            Result.a aVar = Result.f34166a;
            activity.startActivityForResult(a10, i10);
            b10 = Result.b(m9.q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            Log.e("PermissionSettingJumper", "startAppPermissionSetting " + d10.getMessage());
        }
        return Result.g(b10);
    }

    public final Intent a(Activity activity, String str, boolean z10) {
        Object b10;
        if (z10 && C0844e.h() && str != null) {
            Log.i("PermissionSettingJumper", "createAppPermissionSettingIntent");
            try {
                Result.a aVar = Result.f34166a;
                Intent intent = new Intent("oplus.intent.action.PERMISSION_APP_DETAIL");
                Bundle bundle = new Bundle();
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(str);
                bundle.putStringArrayList("permissionList", arrayList);
                bundle.putString(AFConstants.EXTRA_PACKAGE_NAME, activity.getPackageName());
                bundle.putString("packageLabel", activity.getPackageManager().getApplicationLabel(activity.getApplicationInfo()).toString());
                intent.putExtras(bundle);
                if (intent.resolveActivity(activity.getPackageManager()) == null) {
                    Log.w("PermissionSettingJumper", "resolveActivity fail");
                    intent = b(activity);
                }
                b10 = Result.b(intent);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                Log.e("PermissionSettingJumper", "createAppPermissionSettingIntent " + d10.getMessage());
            }
            Intent b11 = b(activity);
            if (Result.f(b10)) {
                b10 = b11;
            }
            return (Intent) b10;
        }
        return b(activity);
    }

    public final Intent b(Context context) {
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", context.getPackageName(), null));
    }
}
