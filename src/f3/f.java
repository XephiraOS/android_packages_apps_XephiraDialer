package F3;

import android.content.Context;
import com.customize.contacts.util.D;
import java.io.File;
import java.io.IOException;

/* compiled from: TempFileCache.java */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: c, reason: collision with root package name */
    public static volatile f f844c;

    /* renamed from: a, reason: collision with root package name */
    public Context f845a;

    /* renamed from: b, reason: collision with root package name */
    public String f846b;

    public f(Context context) {
        this.f845a = context;
        try {
            D.i(e());
        } catch (IOException e10) {
            H7.b.c("TempFileCache", "Init cache dir failed" + e10);
        }
    }

    public static String d(Context context) {
        return h(context.getFilesDir().getAbsolutePath() + File.separatorChar + "BusinessCard");
    }

    public static f g(Context context) {
        if (f844c == null) {
            synchronized (f.class) {
                try {
                    if (f844c == null) {
                        f844c = new f(context);
                    }
                } finally {
                }
            }
        }
        return f844c;
    }

    public static String h(String str) {
        File file = new File(str);
        if (!file.isDirectory() && !file.mkdirs()) {
            H7.b.i("TempFileCache", "getOrCreateDir mkdirs fail!");
        }
        return file.getPath();
    }

    public boolean a() {
        return D.d(e());
    }

    public String b(String str) {
        this.f846b = str;
        return e() + str;
    }

    public final String c() {
        return h(this.f845a.getCacheDir().getAbsolutePath() + File.separatorChar + "BusinessCard/.cache");
    }

    public String e() {
        return c() + File.separatorChar;
    }

    public String f(Context context) {
        return d(context) + File.separatorChar + this.f846b;
    }
}
