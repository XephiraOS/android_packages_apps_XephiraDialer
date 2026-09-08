package K7;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.heytap.accessory.constant.AFConstants;
import com.oplus.foundation.util.OsUtils;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.jvm.internal.i;

/* compiled from: PermissionSettingJumper.kt */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f1675a = new b();

    public static final Intent a(Activity activity, String str, boolean z10) {
        Object b10;
        i.f(activity, "activity");
        if (z10 && OsUtils.f() && str != null) {
            H7.b.e("PermissionSettingJumper", "createAppPermissionSettingIntent");
            b bVar = f1675a;
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
                    H7.b.i("PermissionSettingJumper", "resolveActivity fail");
                    intent = bVar.b(activity);
                }
                b10 = Result.b(intent);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.c("PermissionSettingJumper", "createAppPermissionSettingIntent " + d10.getMessage());
            }
            Intent b11 = f1675a.b(activity);
            if (Result.f(b10)) {
                b10 = b11;
            }
            return (Intent) b10;
        }
        return f1675a.b(activity);
    }

    public static final boolean c(Activity activity, String str, int i10, boolean z10) {
        i.f(activity, "activity");
        return Q7.b.c(activity, a(activity, str, z10), i10, 0, 4, null);
    }

    public final Intent b(Context context) {
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", context.getPackageName(), null));
    }
}
