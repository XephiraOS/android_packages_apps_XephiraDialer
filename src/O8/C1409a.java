package o8;

import android.text.TextUtils;
import com.oplus.backup.sdk.common.utils.Constants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import m8.C1344a;
import n8.C1379d;
import q8.d;
import q8.h;

/* compiled from: AuthResult.java */
/* renamed from: o8.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1409a {

    /* renamed from: a, reason: collision with root package name */
    public final String f35777a;

    /* renamed from: b, reason: collision with root package name */
    public final int f35778b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f35779c;

    /* renamed from: d, reason: collision with root package name */
    public long f35780d;

    /* renamed from: e, reason: collision with root package name */
    public Map<String, C1379d> f35781e;

    /* renamed from: f, reason: collision with root package name */
    public String f35782f;

    /* renamed from: g, reason: collision with root package name */
    public final String f35783g;

    public C1409a(String str, int i10, byte[] bArr, String str2) {
        this.f35777a = str;
        this.f35778b = i10;
        this.f35779c = bArr;
        this.f35783g = str2;
    }

    public boolean a(String str, String str2) {
        C1379d c1379d = this.f35781e.get(str);
        if (c1379d != null) {
            return c1379d.a(str2);
        }
        return false;
    }

    public String b() {
        return this.f35783g;
    }

    public int c() {
        return this.f35778b;
    }

    public String d() {
        return this.f35782f;
    }

    public void e() {
        this.f35781e = new ConcurrentHashMap();
        for (String str : h.c(new String(this.f35779c), Constants.DataMigration.SPLIT_TAG)) {
            int indexOf = str.indexOf(",");
            if (indexOf != -1) {
                String substring = str.substring(0, indexOf);
                String substring2 = str.substring(indexOf + 1);
                if (TextUtils.equals(substring, "epona") || TextUtils.equals(substring, "tingle")) {
                    this.f35781e.put(substring, new C1379d(substring2));
                    d.b("Package : " + this.f35777a + " Permission : type [" + substring + "] -" + h.c(substring2, ","));
                }
            }
        }
    }

    public boolean f() {
        if (System.currentTimeMillis() - this.f35780d > C1344a.f35482a) {
            return true;
        }
        return false;
    }

    public void g(String str) {
        this.f35782f = str;
    }

    public void h() {
        this.f35780d = System.currentTimeMillis();
    }
}
