package J5;

import N5.h;
import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import java.util.Arrays;

/* compiled from: AuthCache.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public LruCache<String, L5.a> f1588a = new LruCache<>(I5.a.f1347b);

    /* renamed from: b, reason: collision with root package name */
    public Context f1589b;

    /* renamed from: c, reason: collision with root package name */
    public String f1590c;

    public a(Context context) {
        this.f1589b = context;
        this.f1590c = N5.b.e(context, "android");
    }

    public boolean a(String str, String str2) {
        L5.a b10 = c.b(this.f1589b, str, N5.e.b(this.f1589b, str));
        L5.a aVar = this.f1588a.get(str);
        if (b10 == null || aVar == null || aVar.f() || !TextUtils.equals(str2, aVar.d())) {
            return false;
        }
        return Arrays.equals(b10.c(), aVar.c());
    }

    public boolean b(String str) {
        return TextUtils.equals(this.f1590c, str);
    }

    public void c(String str, L5.a aVar, String str2) {
        aVar.e();
        aVar.h();
        aVar.g(str2);
        this.f1588a.put(str, aVar);
    }

    public boolean d(String str, String str2, String str3) {
        boolean z10;
        boolean z11;
        L5.a aVar = this.f1588a.get(str);
        if (aVar == null) {
            return false;
        }
        if (h.c(str2, ".").size() > 2) {
            str2 = str2.substring(str2.lastIndexOf(".") + 1);
        }
        if (!aVar.a("epona", str2) && !aVar.a("epona", str3)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!aVar.a("tingle", str2) && !aVar.a("tingle", str3)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z10 && z11) {
            N5.d.b("Action : [" + str2 + "/" + str3 + "] is re-wrapped form Tingle, Caller : [" + str + "]");
        }
        if (!z10 && !z11) {
            return false;
        }
        return true;
    }
}
