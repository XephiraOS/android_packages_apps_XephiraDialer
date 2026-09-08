package androidx.core.content;

import android.content.Context;
import android.os.Process;

/* compiled from: PermissionChecker.java */
/* loaded from: classes.dex */
public final class e {
    public static int a(Context context, String str, int i10, int i11, String str2) {
        int b10;
        if (context.checkPermission(str, i10, i11) == -1) {
            return -1;
        }
        String c10 = androidx.core.app.d.c(str);
        if (c10 == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i11);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        int myUid = Process.myUid();
        String packageName = context.getPackageName();
        if (myUid == i11 && I.c.a(packageName, str2)) {
            b10 = androidx.core.app.d.a(context, i11, c10, str2);
        } else {
            b10 = androidx.core.app.d.b(context, c10, str2);
        }
        if (b10 == 0) {
            return 0;
        }
        return -2;
    }

    public static int b(Context context, String str) {
        return a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
