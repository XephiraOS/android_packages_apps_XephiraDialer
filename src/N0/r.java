package n0;

import com.android.audio_record.RecordPermissionActivity;
import java.util.Arrays;

/* compiled from: RecordPermissionActivityPermissionsDispatcher.kt */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f35565a = {"android.permission.READ_MEDIA_AUDIO"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f35566b = {"android.permission.READ_EXTERNAL_STORAGE"};

    public static final void a(RecordPermissionActivity recordPermissionActivity) {
        kotlin.jvm.internal.i.f(recordPermissionActivity, "<this>");
        String[] strArr = f35565a;
        if (X9.a.b(recordPermissionActivity, (String[]) Arrays.copyOf(strArr, strArr.length))) {
            recordPermissionActivity.m0();
        } else {
            androidx.core.app.a.q(recordPermissionActivity, strArr, 0);
        }
    }

    public static final void b(RecordPermissionActivity recordPermissionActivity, int i10, int[] grantResults) {
        kotlin.jvm.internal.i.f(recordPermissionActivity, "<this>");
        kotlin.jvm.internal.i.f(grantResults, "grantResults");
        if (i10 != 0) {
            if (i10 == 1) {
                if (X9.a.e(Arrays.copyOf(grantResults, grantResults.length))) {
                    recordPermissionActivity.o0();
                    return;
                }
                String[] strArr = f35566b;
                if (!X9.a.d(recordPermissionActivity, (String[]) Arrays.copyOf(strArr, strArr.length))) {
                    recordPermissionActivity.z0();
                    return;
                } else {
                    recordPermissionActivity.r0();
                    return;
                }
            }
            return;
        }
        if (X9.a.e(Arrays.copyOf(grantResults, grantResults.length))) {
            recordPermissionActivity.m0();
            return;
        }
        String[] strArr2 = f35565a;
        if (!X9.a.d(recordPermissionActivity, (String[]) Arrays.copyOf(strArr2, strArr2.length))) {
            recordPermissionActivity.y0();
        } else {
            recordPermissionActivity.q0();
        }
    }
}
