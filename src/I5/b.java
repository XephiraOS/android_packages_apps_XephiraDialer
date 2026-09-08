package I5;

import N5.c;
import N5.d;
import N5.e;
import android.app.Application;
import android.content.Context;
import android.os.Binder;
import android.text.TextUtils;
import java.util.Arrays;

/* compiled from: PermissionCheck.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    public static b f1348d;

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f1349a = false;

    /* renamed from: b, reason: collision with root package name */
    public Context f1350b;

    /* renamed from: c, reason: collision with root package name */
    public J5.a f1351c;

    public static b a() {
        if (f1348d == null) {
            synchronized (b.class) {
                try {
                    if (f1348d == null) {
                        f1348d = new b();
                    }
                } finally {
                }
            }
        }
        return f1348d;
    }

    public synchronized void b(Context context) {
        Context applicationContext;
        if (this.f1349a) {
            return;
        }
        this.f1349a = true;
        if (context instanceof Application) {
            applicationContext = context;
        } else {
            applicationContext = context.getApplicationContext();
        }
        this.f1350b = applicationContext;
        this.f1351c = new J5.a(context);
        M5.a.a();
        Context context2 = this.f1350b;
        if (context2 != null && TextUtils.equals(context2.getPackageName(), "com.heytap.appplatform")) {
            d.e(this.f1350b);
            c.e().f(this.f1350b);
        }
    }

    public boolean c() {
        return !c.e().g();
    }

    public boolean d(String str, String str2, String str3) {
        if (Binder.getCallingUid() == 1000) {
            return true;
        }
        String c10 = e.c(this.f1350b, Binder.getCallingUid(), Binder.getCallingPid());
        if (TextUtils.isEmpty(str)) {
            d.c("Epona Authentication Failed Cause Component Empty : " + c10);
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            d.c("Epona Authentication Failed Cause ActionName Empty : " + c10);
            return false;
        }
        if (TextUtils.isEmpty(str3)) {
            d.c("Epona Authentication Failed Cause Register Package Empty : " + c10);
            return false;
        }
        d.b("Start epona verify Component : [" + str + "] action : [" + str2 + "] register pacage : [" + str3 + "] caller pacakge : [" + c10 + "]");
        if (this.f1351c.b("728E6B5E6D3FAA00E2DE12CC464D027BFFE2DD87329967F72028F2FD13C122E9")) {
            d.b("Epona verity SUCCESS cause local version, Caller Package [" + c10 + "]");
            return true;
        }
        if (TextUtils.isEmpty(c10)) {
            d.c("Get caller package is null");
            String[] packagesForUid = this.f1350b.getPackageManager().getPackagesForUid(Binder.getCallingUid());
            if (packagesForUid != null && packagesForUid.length > 0) {
                d.c("Get UID [" + Binder.getCallingUid() + "] PID [" + Binder.getCallingPid() + "] Packages [" + Arrays.toString(packagesForUid) + "]");
                c10 = packagesForUid[0];
            } else {
                d.c("Get packages Error : Calling pid [" + Binder.getCallingPid() + "] Calling uid [" + Binder.getCallingUid() + "]");
                return false;
            }
        }
        String e10 = N5.b.e(this.f1350b, c10);
        if (this.f1351c.b(e10)) {
            d.b("Epona verity SUCCESS Caller Package [" + c10 + "] is platform signature");
            return true;
        }
        String str4 = "FAILED";
        if (TextUtils.equals("com.heytap.appplatform", str3)) {
            if (TextUtils.equals("com.heytap.appplatform", c10)) {
                return true;
            }
            if (this.f1351c.a(c10, e10)) {
                boolean d10 = this.f1351c.d(c10, str, str2);
                StringBuilder sb = new StringBuilder();
                sb.append("Epona verity ");
                if (d10) {
                    str4 = "SUCCESS";
                }
                sb.append(str4);
                sb.append(" Caller : [");
                sb.append(c10);
                sb.append("] Component : [");
                sb.append(str);
                sb.append("] ActionName : [");
                sb.append(str2);
                sb.append("]");
                d.b(sb.toString());
                return d10;
            }
            L5.a c11 = J5.c.c(this.f1350b, c10);
            int b10 = c11.b();
            if (b10 != 1001) {
                d.c("Epona Authentication Failed " + J5.d.a(b10) + " Package : " + c10);
                return false;
            }
            this.f1351c.c(c10, c11, e10);
            boolean d11 = this.f1351c.d(c10, str, str2);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Epona verity ");
            if (d11) {
                str4 = "SUCCESS";
            }
            sb2.append(str4);
            sb2.append(" Caller : [");
            sb2.append(c10);
            sb2.append("] Component : [");
            sb2.append(str);
            sb2.append("] ActionName : [");
            sb2.append(str2);
            sb2.append("]");
            d.b(sb2.toString());
            return d11;
        }
        boolean equals = TextUtils.equals(N5.b.d(this.f1350b, str3), N5.b.d(this.f1350b, c10));
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Epona verity ");
        if (equals) {
            str4 = "SUCCESS";
        }
        sb3.append(str4);
        sb3.append(" Caller : [");
        sb3.append(c10);
        sb3.append("] Component : [");
        sb3.append(str);
        sb3.append("] ActionName : [");
        sb3.append(str2);
        sb3.append("]");
        d.b(sb3.toString());
        return equals;
    }
}
