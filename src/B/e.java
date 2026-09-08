package B;

import A.e;
import A.h;
import G.g;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.Handler;
import i0.C1089a;
import java.util.List;
import p.C1422h;

/* compiled from: TypefaceCompat.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final g f216a;

    /* renamed from: b, reason: collision with root package name */
    public static final C1422h<String, Typeface> f217b;

    /* compiled from: TypefaceCompat.java */
    /* loaded from: classes.dex */
    public static class a extends g.c {

        /* renamed from: a, reason: collision with root package name */
        public h.e f218a;

        public a(h.e eVar) {
            this.f218a = eVar;
        }

        @Override // G.g.c
        public void a(int i10) {
            h.e eVar = this.f218a;
            if (eVar != null) {
                eVar.f(i10);
            }
        }

        @Override // G.g.c
        public void b(Typeface typeface) {
            h.e eVar = this.f218a;
            if (eVar != null) {
                eVar.g(typeface);
            }
        }
    }

    static {
        C1089a.a("TypefaceCompat static init");
        f216a = new f();
        f217b = new C1422h<>(16);
        C1089a.b();
    }

    public static Typeface a(Context context, Typeface typeface, int i10) {
        if (context != null) {
            return Typeface.create(typeface, i10);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, g.b[] bVarArr, int i10) {
        C1089a.a("TypefaceCompat.createFromFontInfo");
        try {
            return f216a.b(context, cancellationSignal, bVarArr, i10);
        } finally {
            C1089a.b();
        }
    }

    public static Typeface c(Context context, CancellationSignal cancellationSignal, List<g.b[]> list, int i10) {
        C1089a.a("TypefaceCompat.createFromFontInfoWithFallback");
        try {
            return f216a.c(context, cancellationSignal, list, i10);
        } finally {
            C1089a.b();
        }
    }

    public static Typeface d(Context context, e.b bVar, Resources resources, int i10, String str, int i11, int i12, h.e eVar, Handler handler, boolean z10) {
        Typeface a10;
        boolean z11;
        int i13;
        List of;
        if (bVar instanceof e.C0000e) {
            e.C0000e c0000e = (e.C0000e) bVar;
            Typeface h10 = h(c0000e.d());
            if (h10 != null) {
                if (eVar != null) {
                    eVar.d(h10, handler);
                }
                return h10;
            }
            if (!z10 ? eVar == null : c0000e.b() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z10) {
                i13 = c0000e.e();
            } else {
                i13 = -1;
            }
            int i14 = i13;
            Handler e10 = h.e.e(handler);
            a aVar = new a(eVar);
            if (c0000e.a() != null) {
                of = List.of(c0000e.c(), c0000e.a());
            } else {
                of = List.of(c0000e.c());
            }
            a10 = G.g.c(context, of, i12, z11, i14, e10, aVar);
        } else {
            a10 = f216a.a(context, (e.c) bVar, resources, i12);
            if (eVar != null) {
                if (a10 != null) {
                    eVar.d(a10, handler);
                } else {
                    eVar.c(-3, handler);
                }
            }
        }
        if (a10 != null) {
            f217b.put(f(resources, i10, str, i11, i12), a10);
        }
        return a10;
    }

    public static Typeface e(Context context, Resources resources, int i10, String str, int i11, int i12) {
        Typeface d10 = f216a.d(context, resources, i10, str, i12);
        if (d10 != null) {
            f217b.put(f(resources, i10, str, i11, i12), d10);
        }
        return d10;
    }

    public static String f(Resources resources, int i10, String str, int i11, int i12) {
        return resources.getResourcePackageName(i10) + '-' + str + '-' + i11 + '-' + i10 + '-' + i12;
    }

    public static Typeface g(Resources resources, int i10, String str, int i11, int i12) {
        return f217b.get(f(resources, i10, str, i11, i12));
    }

    public static Typeface h(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface create = Typeface.create(str, 0);
        Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
        if (create == null || create.equals(create2)) {
            return null;
        }
        return create;
    }
}
