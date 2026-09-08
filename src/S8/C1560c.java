package s8;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import s8.C1558a;
import y8.C1712d;
import y8.C1714f;
import y8.InterfaceC1715g;

/* compiled from: OTrackContext.java */
/* renamed from: s8.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1560c {

    /* renamed from: d, reason: collision with root package name */
    public static Map<String, C1560c> f36881d = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final String f36882a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f36883b;

    /* renamed from: c, reason: collision with root package name */
    public C1558a f36884c;

    public C1560c(String str, Context context, C1558a c1558a) {
        C1558a b10;
        this.f36882a = str;
        this.f36883b = context;
        if (c1558a != null) {
            b10 = c(context, c1558a);
        } else {
            b10 = b(context);
        }
        this.f36884c = b10;
    }

    public static synchronized C1560c d(String str, Context context, C1558a c1558a) {
        C1560c e10;
        synchronized (C1560c.class) {
            e10 = e(str);
            if (e10 == null) {
                e10 = new C1560c(str, context, c1558a);
                f36881d.put(str, e10);
            }
        }
        return e10;
    }

    public static synchronized C1560c e(String str) {
        C1560c c1560c;
        synchronized (C1560c.class) {
            c1560c = f36881d.get(str);
        }
        return c1560c;
    }

    public static /* synthetic */ String g() {
        return "createDefaultConfig PackageManager.NameNotFoundException.";
    }

    public final C1558a b(Context context) {
        PackageInfo packageInfo;
        PackageManager packageManager = context.getPackageManager();
        try {
            packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            C1714f.f("OTrackContext", new InterfaceC1715g() { // from class: s8.b
                @Override // y8.InterfaceC1715g
                public final Object get() {
                    String g10;
                    g10 = C1560c.g();
                    return g10;
                }
            });
            packageInfo = null;
        }
        if (packageInfo == null) {
            return C1558a.f36870f;
        }
        return new C1558a.b().h(packageInfo.packageName).i(packageInfo.versionName).g(packageInfo.applicationInfo.loadLabel(packageManager).toString()).f();
    }

    public final C1558a c(Context context, C1558a c1558a) {
        if (TextUtils.isEmpty(c1558a.d())) {
            c1558a.g(C1712d.e(context));
        }
        if (TextUtils.isEmpty(c1558a.e())) {
            c1558a.h(C1712d.f(context));
        }
        if (TextUtils.isEmpty(c1558a.a())) {
            c1558a.f(C1712d.d(context));
        }
        return c1558a;
    }

    public C1558a f() {
        if (C1558a.f36870f.equals(this.f36884c)) {
            this.f36884c = b(this.f36883b);
        }
        return this.f36884c;
    }
}
