package z6;

import android.content.Context;
import android.net.Uri;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: SettingsCompat.kt */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f38301a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, InterfaceC1735a> f38302b = new ConcurrentHashMap<>();

    public static final int b(Context context, int i10, String str) {
        InterfaceC1735a e10 = f38301a.e(2);
        if (e10 != null) {
            return e10.e(context, i10, str);
        }
        return -1;
    }

    public static final int c(Context context, int i10, String str, int i11) {
        return d(context, i10, str, i11, 2);
    }

    public static final int d(Context context, int i10, String str, int i11, int i12) {
        InterfaceC1735a e10 = f38301a.e(i12);
        if (e10 != null) {
            return e10.c(context, i10, str, i11);
        }
        return -1;
    }

    public static final Uri f(int i10, String str) {
        return h(i10, str, 0, 4, null);
    }

    public static final Uri g(int i10, String str, int i11) {
        InterfaceC1735a e10 = f38301a.e(i11);
        if (e10 != null) {
            return e10.b(i10, str);
        }
        return null;
    }

    public static /* synthetic */ Uri h(int i10, String str, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i11 = 2;
        }
        return g(i10, str, i11);
    }

    public static final boolean i(Context context, int i10, String str, int i11) {
        return k(context, i10, str, i11, 0, 16, null);
    }

    public static final boolean j(Context context, int i10, String str, int i11, int i12) {
        InterfaceC1735a e10 = f38301a.e(i12);
        if (e10 != null) {
            return e10.a(context, i10, str, i11);
        }
        return false;
    }

    public static /* synthetic */ boolean k(Context context, int i10, String str, int i11, int i12, int i13, Object obj) {
        if ((i13 & 16) != 0) {
            i12 = 2;
        }
        return j(context, i10, str, i11, i12);
    }

    public final InterfaceC1735a a(int i10) {
        InterfaceC1735a interfaceC1735a = (InterfaceC1735a) A8.a.f202a.a(InterfaceC1735a.class);
        if (interfaceC1735a != null) {
            interfaceC1735a.d(i10);
            f38302b.put(Integer.valueOf(i10), interfaceC1735a);
            return interfaceC1735a;
        }
        return null;
    }

    public final InterfaceC1735a e(int i10) {
        InterfaceC1735a interfaceC1735a = f38302b.get(Integer.valueOf(i10));
        if (interfaceC1735a == null) {
            return a(i10);
        }
        return interfaceC1735a;
    }
}
