package w8;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import y8.C1714f;
import y8.InterfaceC1715g;

/* compiled from: MemoryPreference.java */
/* renamed from: w8.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1656c {

    /* renamed from: a, reason: collision with root package name */
    public Map<String, String> f37632a = new HashMap();

    public static /* synthetic */ String f(String str, String str2, NumberFormatException numberFormatException) {
        return "getInt key=" + str + ", value=" + str2 + ", exception=" + numberFormatException.toString();
    }

    public static /* synthetic */ String g(String str, String str2, NumberFormatException numberFormatException) {
        return "getLong key=" + str + ", value=" + str2 + ", exception=" + numberFormatException.toString();
    }

    public int c(final String str, int i10) {
        final String str2 = this.f37632a.get(str);
        if (TextUtils.isEmpty(str2)) {
            return i10;
        }
        try {
            return Integer.parseInt(str2);
        } catch (NumberFormatException e10) {
            C1714f.f("MemoryPreference", new InterfaceC1715g() { // from class: w8.b
                @Override // y8.InterfaceC1715g
                public final Object get() {
                    String f10;
                    f10 = C1656c.f(str, str2, e10);
                    return f10;
                }
            });
            return i10;
        }
    }

    public long d(final String str, long j10) {
        final String str2 = this.f37632a.get(str);
        if (TextUtils.isEmpty(str2)) {
            return j10;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException e10) {
            C1714f.f("MemoryPreference", new InterfaceC1715g() { // from class: w8.a
                @Override // y8.InterfaceC1715g
                public final Object get() {
                    String g10;
                    g10 = C1656c.g(str, str2, e10);
                    return g10;
                }
            });
            return j10;
        }
    }

    public String e(String str, String str2) {
        String str3 = this.f37632a.get(str);
        if (!TextUtils.isEmpty(str3)) {
            return str3;
        }
        return str2;
    }

    public void h(String str, long j10) {
        this.f37632a.put(str, String.valueOf(j10));
    }

    public void i(String str, long j10) {
        this.f37632a.put(str, String.valueOf(j10));
    }

    public void j(String str, String str2) {
        this.f37632a.put(str, str2);
    }
}
