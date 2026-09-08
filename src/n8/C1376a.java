package n8;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import m8.C1344a;
import o8.C1409a;
import q8.e;

/* compiled from: AuthCache.java */
/* renamed from: n8.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1376a {

    /* renamed from: a, reason: collision with root package name */
    public final LruCache<String, C1409a> f35640a = new LruCache<>(C1344a.f35483b);

    /* renamed from: b, reason: collision with root package name */
    public final Context f35641b;

    /* renamed from: c, reason: collision with root package name */
    public String f35642c;

    public C1376a(Context context) {
        this.f35641b = context;
    }

    public C1409a a(String str) {
        return this.f35640a.get(str);
    }

    public boolean b(String str, String str2) {
        String b10 = e.b(this.f35641b, str);
        C1409a c1409a = this.f35640a.get(str);
        if (c1409a == null || c1409a.f() || !TextUtils.equals(str2, c1409a.d())) {
            return false;
        }
        return TextUtils.equals(b10, c1409a.b());
    }

    public boolean c() {
        if (TextUtils.isEmpty(this.f35642c)) {
            this.f35642c = q8.b.f(this.f35641b, "android");
        }
        return TextUtils.equals(this.f35642c, "72:8E:6B:5E:6D:3F:AA:00:E2:DE:12:CC:46:4D:02:7B:FF:E2:DD:87:32:99:67:F7:20:28:F2:FD:13:C1:22:E9");
    }

    public boolean d(String str) {
        if (TextUtils.isEmpty(this.f35642c)) {
            this.f35642c = q8.b.f(this.f35641b, "android");
        }
        return TextUtils.equals(this.f35642c, str);
    }

    public void e(String str, C1409a c1409a, String str2) {
        c1409a.e();
        c1409a.h();
        c1409a.g(str2);
        this.f35640a.put(str, c1409a);
    }
}
