package R2;

import com.android.store_incallui.PermissionActivity;
import java.util.Arrays;
import kotlin.jvm.internal.i;

/* compiled from: PermissionActivityPermissionsDispatcher.kt */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f3313a = {"android.permission.BLUETOOTH_CONNECT"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f3314b = {"android.permission.READ_EXTERNAL_STORAGE"};

    public static final void a(PermissionActivity permissionActivity) {
        i.f(permissionActivity, "<this>");
        String[] strArr = f3313a;
        if (X9.a.b(permissionActivity, (String[]) Arrays.copyOf(strArr, strArr.length))) {
            permissionActivity.g0();
        } else {
            androidx.core.app.a.q(permissionActivity, strArr, 0);
        }
    }

    public static final void b(PermissionActivity permissionActivity) {
        i.f(permissionActivity, "<this>");
        String[] strArr = f3314b;
        if (X9.a.b(permissionActivity, (String[]) Arrays.copyOf(strArr, strArr.length))) {
            permissionActivity.k0();
        } else {
            androidx.core.app.a.q(permissionActivity, strArr, 1);
        }
    }

    public static final void c(PermissionActivity permissionActivity, int i10, int[] grantResults) {
        i.f(permissionActivity, "<this>");
        i.f(grantResults, "grantResults");
        if (i10 != 0) {
            if (i10 == 1) {
                if (X9.a.e(Arrays.copyOf(grantResults, grantResults.length))) {
                    permissionActivity.k0();
                    return;
                }
                String[] strArr = f3314b;
                if (!X9.a.d(permissionActivity, (String[]) Arrays.copyOf(strArr, strArr.length))) {
                    permissionActivity.q0();
                    return;
                } else {
                    permissionActivity.m0();
                    return;
                }
            }
            return;
        }
        if (X9.a.e(Arrays.copyOf(grantResults, grantResults.length))) {
            permissionActivity.g0();
            return;
        }
        String[] strArr2 = f3313a;
        if (!X9.a.d(permissionActivity, (String[]) Arrays.copyOf(strArr2, strArr2.length))) {
            permissionActivity.n0();
        } else {
            permissionActivity.l0();
        }
    }
}
