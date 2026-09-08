package u8;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import java.util.Map;
import java.util.Objects;
import s8.C1560c;
import v8.l;
import y8.C1709a;
import y8.C1712d;
import y8.C1714f;
import y8.InterfaceC1715g;

/* compiled from: TrackEvent.java */
/* loaded from: classes3.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public final Context f37363a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayMap<String, Object> f37364b;

    /* renamed from: c, reason: collision with root package name */
    public String f37365c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f37366d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f37367e = "";

    /* renamed from: f, reason: collision with root package name */
    public String f37368f = "";

    public f(Context context) {
        Objects.requireNonNull(context, "TrackEvent: context is null");
        this.f37363a = context;
        this.f37364b = new ArrayMap<>();
        i(context);
    }

    public static /* synthetic */ String j() {
        return "appId is empty";
    }

    public void b(String str, int i10) {
        this.f37364b.put(str, Integer.valueOf(i10));
    }

    public void c(String str, long j10) {
        this.f37364b.put(str, Long.valueOf(j10));
    }

    public void d(String str, String str2) {
        this.f37364b.put(str, str2);
    }

    public String e() {
        return this.f37365c;
    }

    public Context f() {
        return this.f37363a;
    }

    public abstract int g();

    public Map<String, Object> h() {
        return new ArrayMap(this.f37364b);
    }

    public final void i(Context context) {
        this.f37364b.put("dataType", Integer.valueOf(g()));
        this.f37364b.put("ssoid", C1709a.a(context));
        this.f37364b.put("statSId", l.e().c(context));
        String c10 = C1712d.c(context);
        if (TextUtils.isEmpty(c10)) {
            C1714f.f("TrackEvent", new InterfaceC1715g() { // from class: u8.e
                @Override // y8.InterfaceC1715g
                public final Object get() {
                    String j10;
                    j10 = f.j();
                    return j10;
                }
            });
        } else {
            k(c10);
        }
        C1560c e10 = C1560c.e(c10);
        if (e10 != null) {
            this.f37364b.put("headerFlag", Integer.valueOf(e10.f().c()));
            this.f37364b.put("appVersion", e10.f().e());
            this.f37364b.put("appPackage", e10.f().d());
            this.f37364b.put("appName", e10.f().a());
            return;
        }
        this.f37364b.put("appVersion", C1712d.f(context));
        this.f37364b.put("appPackage", C1712d.e(context));
        this.f37364b.put("appName", C1712d.d(context));
    }

    public void k(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f37365c = str;
        d("appIdStr", str);
        if (TextUtils.isDigitsOnly(this.f37365c)) {
            b("appId", Integer.parseInt(this.f37365c));
        }
    }
}
