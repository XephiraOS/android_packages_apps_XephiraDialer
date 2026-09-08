package M7;

import com.oplus.wrapper.os.SystemProperties;
import kotlin.Result;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: SystemPropertiesCustomize.kt */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f1808a = new d();

    public static final String a(String str) {
        Object b10;
        String a10;
        String str2 = "";
        try {
            Result.a aVar = Result.f34166a;
            if (C7.b.a(30, 1)) {
                a10 = SystemProperties.get(str);
                i.e(a10, "{\n                System…es.get(key)\n            }");
            } else {
                a10 = M6.a.a(str);
                i.e(a10, "{\n                System…ve.get(key)\n            }");
            }
            str2 = a10;
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("SystemPropertiesCustomize", "get error :" + d10);
        }
        return str2;
    }

    public static final String b(String str, String str2) {
        Object b10;
        String b11;
        i.f(str2, "default");
        String str3 = "";
        try {
            Result.a aVar = Result.f34166a;
            if (C7.b.a(30, 1)) {
                b11 = SystemProperties.get(str, str2);
                i.e(b11, "{\n                System…y, default)\n            }");
            } else {
                b11 = M6.a.b(str, str2);
                i.e(b11, "{\n                System…y, default)\n            }");
            }
            str3 = b11;
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("SystemPropertiesCustomize", "get error :" + d10);
            return str2;
        }
        return str3;
    }

    public static final boolean c(String str, boolean z10) {
        Object b10;
        boolean c10;
        boolean z11 = false;
        try {
            Result.a aVar = Result.f34166a;
            if (C7.b.a(30, 1)) {
                c10 = SystemProperties.getBoolean(str, z10);
            } else {
                c10 = M6.a.c(str, z10);
            }
            z11 = c10;
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("SystemPropertiesCustomize", "getBoolean error :" + d10);
            return z10;
        }
        return z11;
    }

    public static final int d(String str, int i10) {
        Object b10;
        int d10;
        int i11 = -1;
        try {
            Result.a aVar = Result.f34166a;
            if (C7.b.a(30, 1)) {
                d10 = SystemProperties.getInt(str, i10);
            } else {
                d10 = M6.a.d(str, i10);
            }
            i11 = d10;
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d11 = Result.d(b10);
        if (d11 != null) {
            H7.b.c("SystemPropertiesCustomize", "getInt error :" + d11);
            return i10;
        }
        return i11;
    }
}
