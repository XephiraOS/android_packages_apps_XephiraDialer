package t8;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import s8.C1562e;
import w8.C1657d;
import x8.HandlerThreadC1695h;
import y8.C1714f;
import y8.C1716h;
import y8.InterfaceC1715g;

/* compiled from: PageVisitAgent.java */
/* loaded from: classes3.dex */
public class m {

    /* compiled from: PageVisitAgent.java */
    /* loaded from: classes3.dex */
    public static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public Context f37287a;

        /* renamed from: b, reason: collision with root package name */
        public String f37288b;

        /* renamed from: c, reason: collision with root package name */
        public long f37289c;

        /* renamed from: d, reason: collision with root package name */
        public int f37290d;

        public a(Context context, String str, long j10, int i10) {
            this.f37287a = context;
            this.f37288b = str;
            this.f37289c = j10;
            this.f37290d = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10 = this.f37290d;
            if (i10 == 0) {
                m.p(this.f37287a, this.f37288b, this.f37289c);
            } else if (i10 == 1) {
                m.o(this.f37287a, this.f37288b, this.f37289c);
            }
        }
    }

    public static String g(Context context) {
        if (context != null) {
            return context.getClass().getSimpleName();
        }
        return "";
    }

    public static /* synthetic */ String h(String str) {
        return "onPause: " + str;
    }

    public static /* synthetic */ String i() {
        return "onPause() called without context.";
    }

    public static /* synthetic */ String j(String str) {
        return "onResume: " + str;
    }

    public static /* synthetic */ String k() {
        return "onPause() called without context.";
    }

    public static void n(Context context) {
        String f10 = C1657d.f(context);
        int e10 = C1657d.e(context);
        if (!TextUtils.isEmpty(f10)) {
            u8.d dVar = new u8.d(context);
            dVar.o(f10);
            dVar.p(e10);
            dVar.q(C1716h.a());
            v8.h.c().a(context, dVar);
        }
        C1657d.n(context, 0);
        C1657d.o(context, "");
    }

    public static void o(Context context, String str, long j10) {
        JSONArray jSONArray;
        long b10 = C1657d.b(context);
        int i10 = (int) ((j10 - b10) / 1000);
        if (str.equals(C1657d.c(context)) && i10 >= 0 && -1 != b10) {
            try {
                String f10 = C1657d.f(context);
                int e10 = C1657d.e(context);
                if (!TextUtils.isEmpty(f10)) {
                    jSONArray = new JSONArray(f10);
                    if (jSONArray.length() >= 10) {
                        n(context);
                        jSONArray = new JSONArray();
                    }
                } else {
                    jSONArray = new JSONArray();
                }
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(str);
                jSONArray2.put(i10);
                jSONArray.put(jSONArray2);
                C1657d.n(context, e10 + i10);
                C1657d.o(context, jSONArray.toString());
            } catch (JSONException e11) {
                C1714f.b("PageVisitAgent", new InterfaceC1715g() { // from class: t8.l
                    @Override // y8.InterfaceC1715g
                    public final Object get() {
                        return e11.toString();
                    }
                });
            } catch (Exception e12) {
                C1714f.b("PageVisitAgent", new C1562e(e12));
                C1657d.o(context, "");
                C1657d.n(context, 0);
            }
        }
        C1657d.j(context, j10);
    }

    public static void p(Context context, String str, long j10) {
        long a10 = C1657d.a(context);
        long g10 = C1657d.g(context) * 1000;
        if (j10 - C1657d.b(context) >= g10 && (-1 == a10 || a10 >= j10 || j10 - a10 >= g10)) {
            C1597b.c(context);
            n(context);
        }
        C1657d.k(context, j10);
        C1657d.l(context, str);
    }

    public void l(Context context) {
        if (context != null) {
            long currentTimeMillis = System.currentTimeMillis();
            final String g10 = g(context);
            C1714f.c("PageVisitAgent", new InterfaceC1715g() { // from class: t8.h
                @Override // y8.InterfaceC1715g
                public final Object get() {
                    String h10;
                    h10 = m.h(g10);
                    return h10;
                }
            });
            HandlerThreadC1695h.b(new a(context, g10, currentTimeMillis, 1));
            return;
        }
        C1714f.b("PageVisitAgent", new InterfaceC1715g() { // from class: t8.i
            @Override // y8.InterfaceC1715g
            public final Object get() {
                String i10;
                i10 = m.i();
                return i10;
            }
        });
    }

    public void m(Context context) {
        if (context != null) {
            long currentTimeMillis = System.currentTimeMillis();
            final String g10 = g(context);
            C1714f.c("PageVisitAgent", new InterfaceC1715g() { // from class: t8.j
                @Override // y8.InterfaceC1715g
                public final Object get() {
                    String j10;
                    j10 = m.j(g10);
                    return j10;
                }
            });
            HandlerThreadC1695h.b(new a(context, g10, currentTimeMillis, 0));
            return;
        }
        C1714f.b("PageVisitAgent", new InterfaceC1715g() { // from class: t8.k
            @Override // y8.InterfaceC1715g
            public final Object get() {
                String k10;
                k10 = m.k();
                return k10;
            }
        });
    }
}
