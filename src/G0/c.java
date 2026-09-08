package G0;

import android.content.Context;
import android.net.Uri;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: SettingsCompat.kt */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f1086a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, a> f1087b = new ConcurrentHashMap<>();

    public static final float b(Context context, int i10, String str, float f10, int i11) {
        return f1086a.i(i11).e(context, i10, str, f10);
    }

    public static /* synthetic */ float c(Context context, int i10, String str, float f10, int i11, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            i11 = 2;
        }
        return b(context, i10, str, f10, i11);
    }

    public static final int d(Context context, int i10, String str, int i11) {
        return e(context, i10, str, i11, 2);
    }

    public static final int e(Context context, int i10, String str, int i11, int i12) {
        return f1086a.i(i12).c(context, i10, str, i11);
    }

    public static final long f(Context context, int i10, String str, long j10) {
        return h(context, i10, str, j10, 0, 16, null);
    }

    public static final long g(Context context, int i10, String str, long j10, int i11) {
        return f1086a.i(i11).d(context, i10, str, j10);
    }

    public static /* synthetic */ long h(Context context, int i10, String str, long j10, int i11, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            i11 = 2;
        }
        return g(context, i10, str, j10, i11);
    }

    public static final String j(Context context, int i10, String str) {
        return l(context, i10, str, 0, 8, null);
    }

    public static final String k(Context context, int i10, String str, int i11) {
        return f1086a.i(i11).f(context, i10, str);
    }

    public static /* synthetic */ String l(Context context, int i10, String str, int i11, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            i11 = 2;
        }
        return k(context, i10, str, i11);
    }

    public static final Uri m(int i10, String str, int i11) {
        return f1086a.i(i11).b(i10, str);
    }

    public static final boolean n(Context context, int i10, String str, int i11) {
        return p(context, i10, str, i11, 0, 16, null);
    }

    public static final boolean o(Context context, int i10, String str, int i11, int i12) {
        return f1086a.i(i12).a(context, i10, str, i11);
    }

    public static /* synthetic */ boolean p(Context context, int i10, String str, int i11, int i12, int i13, Object obj) {
        if ((i13 & 16) != 0) {
            i12 = 2;
        }
        return o(context, i10, str, i11, i12);
    }

    public static final boolean q(Context context, int i10, String str, long j10) {
        return s(context, i10, str, j10, 0, 16, null);
    }

    public static final boolean r(Context context, int i10, String str, long j10, int i11) {
        return f1086a.i(i11).g(context, i10, str, j10);
    }

    public static /* synthetic */ boolean s(Context context, int i10, String str, long j10, int i11, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            i11 = 2;
        }
        return r(context, i10, str, j10, i11);
    }

    public static final boolean t(Context context, int i10, String str, String str2) {
        return v(context, i10, str, str2, 0, 16, null);
    }

    public static final boolean u(Context context, int i10, String str, String str2, int i11) {
        return f1086a.i(i11).h(context, i10, str, str2);
    }

    public static /* synthetic */ boolean v(Context context, int i10, String str, String str2, int i11, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            i11 = 2;
        }
        return u(context, i10, str, str2, i11);
    }

    public final a a(int i10) {
        b bVar = new b();
        bVar.j(i10);
        f1087b.put(Integer.valueOf(i10), bVar);
        return bVar;
    }

    public final a i(int i10) {
        a aVar = f1087b.get(Integer.valueOf(i10));
        if (aVar == null) {
            return a(i10);
        }
        return aVar;
    }
}
