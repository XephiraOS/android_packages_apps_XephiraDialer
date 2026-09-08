package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.util.Log;
import androidx.profileinstaller.c;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

/* compiled from: ProfileInstaller.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final InterfaceC0134c f10790a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final InterfaceC0134c f10791b = new b();

    /* compiled from: ProfileInstaller.java */
    /* loaded from: classes.dex */
    public class b implements InterfaceC0134c {
        @Override // androidx.profileinstaller.c.InterfaceC0134c
        public void a(int i10, Object obj) {
            String str;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            if (i10 != 5) {
                                str = "";
                            } else {
                                str = "DIAGNOSTIC_PROFILE_IS_COMPRESSED";
                            }
                        } else {
                            str = "DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST";
                        }
                    } else {
                        str = "DIAGNOSTIC_REF_PROFILE_EXISTS";
                    }
                } else {
                    str = "DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST";
                }
            } else {
                str = "DIAGNOSTIC_CURRENT_PROFILE_EXISTS";
            }
            Log.d("ProfileInstaller", str);
        }

        @Override // androidx.profileinstaller.c.InterfaceC0134c
        public void b(int i10, Object obj) {
            String str;
            switch (i10) {
                case 1:
                    str = "RESULT_INSTALL_SUCCESS";
                    break;
                case 2:
                    str = "RESULT_ALREADY_INSTALLED";
                    break;
                case 3:
                    str = "RESULT_UNSUPPORTED_ART_VERSION";
                    break;
                case 4:
                    str = "RESULT_NOT_WRITABLE";
                    break;
                case 5:
                    str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                    break;
                case 6:
                    str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                    break;
                case 7:
                    str = "RESULT_IO_EXCEPTION";
                    break;
                case 8:
                    str = "RESULT_PARSE_EXCEPTION";
                    break;
                case 9:
                default:
                    str = "";
                    break;
                case 10:
                    str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                    break;
                case 11:
                    str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                    break;
            }
            if (i10 != 6 && i10 != 7 && i10 != 8) {
                Log.d("ProfileInstaller", str);
            } else {
                Log.e("ProfileInstaller", str, (Throwable) obj);
            }
        }
    }

    /* compiled from: ProfileInstaller.java */
    /* renamed from: androidx.profileinstaller.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0134c {
        void a(int i10, Object obj);

        void b(int i10, Object obj);
    }

    public static boolean b(File file) {
        return new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
    }

    public static void c(Context context, Executor executor, InterfaceC0134c interfaceC0134c) {
        b(context.getFilesDir());
        g(executor, interfaceC0134c, 11, null);
    }

    public static boolean d(PackageInfo packageInfo, File file, InterfaceC0134c interfaceC0134c) {
        File file2 = new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
        boolean z10 = false;
        if (!file2.exists()) {
            return false;
        }
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file2));
            try {
                long readLong = dataInputStream.readLong();
                dataInputStream.close();
                if (readLong == packageInfo.lastUpdateTime) {
                    z10 = true;
                }
                if (z10) {
                    interfaceC0134c.b(2, null);
                }
                return z10;
            } finally {
            }
        } catch (IOException unused) {
            return false;
        }
    }

    public static void f(PackageInfo packageInfo, File file) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } finally {
            }
        } catch (IOException unused) {
        }
    }

    public static void g(Executor executor, final InterfaceC0134c interfaceC0134c, final int i10, final Object obj) {
        executor.execute(new Runnable() { // from class: Z.e
            @Override // java.lang.Runnable
            public final void run() {
                c.InterfaceC0134c.this.b(i10, obj);
            }
        });
    }

    public static boolean h(AssetManager assetManager, String str, PackageInfo packageInfo, File file, String str2, Executor executor, InterfaceC0134c interfaceC0134c) {
        androidx.profileinstaller.b bVar = new androidx.profileinstaller.b(assetManager, executor, interfaceC0134c, str2, "dexopt/baseline.prof", "dexopt/baseline.profm", new File(new File("/data/misc/profiles/cur/0", str), "primary.prof"));
        if (!bVar.e()) {
            return false;
        }
        boolean n10 = bVar.i().m().n();
        if (n10) {
            f(packageInfo, file);
        }
        return n10;
    }

    public static void i(Context context) {
        j(context, new Z.d(), f10790a);
    }

    public static void j(Context context, Executor executor, InterfaceC0134c interfaceC0134c) {
        k(context, executor, interfaceC0134c, false);
    }

    public static void k(Context context, Executor executor, InterfaceC0134c interfaceC0134c, boolean z10) {
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        AssetManager assets = applicationContext.getAssets();
        String name = new File(applicationInfo.sourceDir).getName();
        boolean z11 = false;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            if (!z10 && d(packageInfo, filesDir, interfaceC0134c)) {
                Log.d("ProfileInstaller", "Skipping profile installation for " + context.getPackageName());
                e.c(context, false);
                return;
            }
            Log.d("ProfileInstaller", "Installing profile for " + context.getPackageName());
            if (h(assets, packageName, packageInfo, filesDir, name, executor, interfaceC0134c) && z10) {
                z11 = true;
            }
            e.c(context, z11);
        } catch (PackageManager.NameNotFoundException e10) {
            interfaceC0134c.b(7, e10);
            e.c(context, false);
        }
    }

    public static void l(Context context, Executor executor, InterfaceC0134c interfaceC0134c) {
        try {
            f(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
            g(executor, interfaceC0134c, 10, null);
        } catch (PackageManager.NameNotFoundException e10) {
            g(executor, interfaceC0134c, 7, e10);
        }
    }

    /* compiled from: ProfileInstaller.java */
    /* loaded from: classes.dex */
    public class a implements InterfaceC0134c {
        @Override // androidx.profileinstaller.c.InterfaceC0134c
        public void a(int i10, Object obj) {
        }

        @Override // androidx.profileinstaller.c.InterfaceC0134c
        public void b(int i10, Object obj) {
        }
    }
}
