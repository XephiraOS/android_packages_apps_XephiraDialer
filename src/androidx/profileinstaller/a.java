package androidx.profileinstaller;

import android.content.Context;
import androidx.profileinstaller.ProfileInstallReceiver;
import java.io.File;

/* compiled from: BenchmarkOperation.java */
/* loaded from: classes.dex */
public class a {

    /* compiled from: BenchmarkOperation.java */
    /* renamed from: androidx.profileinstaller.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0133a {
        public static File a(Context context) {
            return context.createDeviceProtectedStorageContext().getCodeCacheDir();
        }
    }

    public static boolean a(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return false;
            }
            boolean z10 = true;
            for (File file2 : listFiles) {
                if (a(file2) && z10) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            }
            return z10;
        }
        file.delete();
        return true;
    }

    public static void b(Context context, ProfileInstallReceiver.a aVar) {
        if (a(C0133a.a(context))) {
            aVar.b(14, null);
        } else {
            aVar.b(15, null);
        }
    }
}
