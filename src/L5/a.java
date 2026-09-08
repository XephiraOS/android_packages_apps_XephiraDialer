package L5;

import J5.e;
import N5.d;
import N5.h;
import android.text.TextUtils;
import com.oplus.backup.sdk.common.utils.Constants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: AuthResult.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f1720a;

    /* renamed from: b, reason: collision with root package name */
    public int f1721b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f1722c;

    /* renamed from: d, reason: collision with root package name */
    public long f1723d;

    /* renamed from: e, reason: collision with root package name */
    public Map<String, e> f1724e;

    /* renamed from: f, reason: collision with root package name */
    public String f1725f;

    public a(String str, int i10, byte[] bArr) {
        this.f1720a = str;
        this.f1721b = i10;
        this.f1722c = bArr;
    }

    public boolean a(String str, String str2) {
        e eVar = this.f1724e.get(str);
        if (eVar != null) {
            return eVar.a(str2);
        }
        return false;
    }

    public int b() {
        return this.f1721b;
    }

    public byte[] c() {
        return this.f1722c;
    }

    public String d() {
        return this.f1725f;
    }

    public void e() {
        this.f1724e = new ConcurrentHashMap();
        for (String str : h.c(new String(this.f1722c), Constants.DataMigration.SPLIT_TAG)) {
            int indexOf = str.indexOf(",");
            if (indexOf != -1) {
                String substring = str.substring(0, indexOf);
                String substring2 = str.substring(indexOf + 1);
                if (TextUtils.equals(substring, "epona") || TextUtils.equals(substring, "tingle")) {
                    this.f1724e.put(substring, new e(substring2));
                    d.b("Package : " + this.f1720a + " Permission : type [" + substring + "] -" + h.c(substring2, ","));
                }
            }
        }
    }

    public boolean f() {
        if (System.currentTimeMillis() - this.f1723d > I5.a.f1346a) {
            return true;
        }
        return false;
    }

    public void g(String str) {
        this.f1725f = str;
    }

    public void h() {
        this.f1723d = System.currentTimeMillis();
    }
}
