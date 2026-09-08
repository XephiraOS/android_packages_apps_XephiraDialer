package r8;

import android.content.Context;
import android.os.Binder;
import android.text.TextUtils;
import n8.C1376a;
import n8.C1377b;
import n8.C1378c;
import o8.C1409a;
import p8.C1465b;
import q8.d;
import q8.e;

/* compiled from: TingleVerifier.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f36552a;

    /* renamed from: b, reason: collision with root package name */
    public final C1376a f36553b;

    public c(Context context) {
        this.f36552a = context;
        this.f36553b = new C1376a(context);
    }

    public final boolean a(C1409a c1409a, String str) {
        int c10 = c1409a.c();
        if (c10 != 1001) {
            e(c10, str);
            return true;
        }
        return false;
    }

    public final boolean b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            d.c("Tingle Authentication Failed Cause Caller Package Empty");
            return true;
        }
        if (TextUtils.isEmpty(str2)) {
            d.c("Tingle Authentication Failed Cause Descriptor Empty : " + str);
            return true;
        }
        return false;
    }

    public final boolean c(String str) {
        return this.f36553b.d(str);
    }

    public final boolean d() {
        if (Binder.getCallingUid() == 1000) {
            return true;
        }
        return false;
    }

    public final void e(int i10, String str) {
        d.c("Tingle Authentication Failed " + C1378c.a(i10) + " Package : " + str);
    }

    public final void f(boolean z10, String str, String str2, int i10) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append("Tingle verity ");
        if (z10) {
            str3 = "SUCCESS";
        } else {
            str3 = "FAILED";
        }
        sb.append(str3);
        sb.append(" Caller : [");
        sb.append(str);
        sb.append("] Descriptor : [");
        sb.append(str2);
        sb.append("] Method : [");
        sb.append(C1465b.a(str2, i10));
        sb.append("]");
        d.b(sb.toString());
    }

    public final boolean g(String str, String str2) {
        if (C1465b.c(str2)) {
            d.b("Tingle verity SUCCESS cause descriptor is [" + str2 + "], Caller Package [" + str + "]");
            return true;
        }
        return false;
    }

    public boolean h(String str, int i10) {
        if (this.f36553b.c()) {
            return true;
        }
        String c10 = e.c(this.f36552a, Binder.getCallingUid(), Binder.getCallingPid());
        String f10 = q8.b.f(this.f36552a, c10);
        if (b(c10, str)) {
            return false;
        }
        if (d() || c(f10) || g(c10, str)) {
            return true;
        }
        if (this.f36553b.b(c10, f10)) {
            boolean i11 = i(C1465b.a(str, i10), c10);
            f(i11, c10, str, i10);
            return i11;
        }
        C1409a a10 = C1377b.a(this.f36552a, c10);
        if (a(a10, c10)) {
            return false;
        }
        this.f36553b.e(c10, a10, f10);
        boolean i12 = i(C1465b.a(str, i10), c10);
        f(i12, c10, str, i10);
        return i12;
    }

    public final boolean i(String str, String str2) {
        C1409a a10 = this.f36553b.a(str2);
        if (a10 != null) {
            return a10.a("tingle", str);
        }
        return false;
    }
}
