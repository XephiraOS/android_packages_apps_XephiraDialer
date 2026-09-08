package s8;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import java.util.Map;
import java.util.regex.Pattern;
import v8.C1635a;
import x8.C1691d;
import x8.C1693f;
import x8.HandlerThreadC1695h;
import y8.C1712d;
import y8.C1714f;
import y8.InterfaceC1715g;

/* compiled from: OplusTrack.java */
/* renamed from: s8.l, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1569l {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f36890a = Pattern.compile("^[a-zA-Z0-9\\_\\-]{1,64}$");

    /* renamed from: b, reason: collision with root package name */
    public static final t8.m f36891b = new t8.m();

    /* renamed from: c, reason: collision with root package name */
    public static final C1693f f36892c = new C1693f.b(120, 120000).c();

    /* renamed from: d, reason: collision with root package name */
    public static volatile C1571n f36893d;

    public static void h(Context context) {
        j(context, null);
    }

    public static void i(Context context, String str, C1558a c1558a) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            C1635a.a().b((Application) applicationContext);
        }
        if (TextUtils.isEmpty(str)) {
            C1714f.f("OplusTrack", new InterfaceC1715g() { // from class: s8.k
                @Override // y8.InterfaceC1715g
                public final Object get() {
                    String k10;
                    k10 = C1569l.k();
                    return k10;
                }
            });
        }
        C1712d.i(context, str);
        C1560c.d(str, context, c1558a);
        if (c1558a != null) {
            boolean z10 = true;
            if (c1558a.b() != 1) {
                z10 = false;
            }
            C1714f.d(z10);
        }
    }

    public static void j(Context context, C1558a c1558a) {
        i(context, C1712d.c(context), c1558a);
    }

    public static /* synthetic */ String k() {
        return "AppCode is empty.";
    }

    public static /* synthetic */ String l(u8.b bVar, int i10) {
        return "onCommon logTag is " + bVar.o() + ",eventID:" + bVar.m() + ",flagSendTo:" + i10;
    }

    public static /* synthetic */ void m(u8.b bVar) {
        t8.f.a(bVar.f(), bVar);
    }

    public static /* synthetic */ void n(u8.b bVar) {
        t8.d.d(bVar.f(), bVar);
    }

    public static /* synthetic */ String o() {
        return "onError...";
    }

    public static /* synthetic */ String p() {
        return "onPause...";
    }

    public static /* synthetic */ String q() {
        return "onResume...";
    }

    public static boolean r(Context context, String str, String str2, String str3, Map<String, String> map) {
        u8.b bVar = new u8.b(context);
        bVar.k(str);
        bVar.r(str2);
        bVar.p(str3);
        bVar.q(map);
        return t(bVar, 1);
    }

    public static boolean s(Context context, String str, String str2, Map<String, String> map) {
        u8.b bVar = new u8.b(context);
        bVar.r(str);
        bVar.p(str2);
        bVar.q(map);
        return t(bVar, 1);
    }

    public static boolean t(final u8.b bVar, final int i10) {
        if (!f36892c.d(bVar.e() + "_" + bVar.o() + "_" + bVar.m())) {
            C1691d.e().j(bVar);
            return false;
        }
        try {
            C1714f.e("OplusTrack", new InterfaceC1715g() { // from class: s8.g
                @Override // y8.InterfaceC1715g
                public final Object get() {
                    String l10;
                    l10 = C1569l.l(u8.b.this, i10);
                    return l10;
                }
            });
            if ((i10 & 1) == 1) {
                HandlerThreadC1695h.b(new Runnable() { // from class: s8.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        C1569l.m(u8.b.this);
                    }
                });
            }
            if ((i10 & 2) == 2) {
                HandlerThreadC1695h.b(new Runnable() { // from class: s8.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        C1569l.n(u8.b.this);
                    }
                });
            }
            return true;
        } catch (Exception e10) {
            C1714f.b("OplusTrack", new C1562e(e10));
            return false;
        }
    }

    public static synchronized void u(Context context) {
        synchronized (C1569l.class) {
            try {
                C1714f.a("OplusTrack", new InterfaceC1715g() { // from class: s8.j
                    @Override // y8.InterfaceC1715g
                    public final Object get() {
                        String o10;
                        o10 = C1569l.o();
                        return o10;
                    }
                });
                if (f36893d == null) {
                    f36893d = new C1571n(context);
                    f36893d.d();
                }
            } catch (Exception e10) {
                C1714f.b("OplusTrack", new C1562e(e10));
            }
        }
    }

    public static void v(Context context) {
        try {
            C1714f.a("OplusTrack", new InterfaceC1715g() { // from class: s8.f
                @Override // y8.InterfaceC1715g
                public final Object get() {
                    String p10;
                    p10 = C1569l.p();
                    return p10;
                }
            });
            f36891b.l(context);
        } catch (Exception e10) {
            C1714f.b("OplusTrack", new C1562e(e10));
        }
    }

    public static void w(Context context) {
        try {
            C1714f.a("OplusTrack", new InterfaceC1715g() { // from class: s8.d
                @Override // y8.InterfaceC1715g
                public final Object get() {
                    String q10;
                    q10 = C1569l.q();
                    return q10;
                }
            });
            f36891b.m(context);
        } catch (Exception e10) {
            C1714f.b("OplusTrack", new C1562e(e10));
        }
    }
}
