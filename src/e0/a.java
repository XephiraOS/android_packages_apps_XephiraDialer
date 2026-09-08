package E0;

import com.android.contacts.framework.api.numberidentify.interfaces.INAFCApi;
import java.util.List;
import kotlin.jvm.internal.i;

/* compiled from: NAFCManager.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f468a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static INAFCApi f469b = INAFCApi.f15583a.a();

    public static final int a() {
        INAFCApi iNAFCApi = f469b;
        if (iNAFCApi != null) {
            return iNAFCApi.i();
        }
        return 0;
    }

    public static final boolean b(String str) {
        INAFCApi iNAFCApi = f469b;
        if (iNAFCApi != null) {
            return iNAFCApi.e(str);
        }
        return false;
    }

    public static final boolean c() {
        INAFCApi iNAFCApi = f469b;
        if (iNAFCApi != null) {
            return iNAFCApi.c();
        }
        return false;
    }

    public static final boolean d() {
        INAFCApi iNAFCApi = f469b;
        if (iNAFCApi != null) {
            return iNAFCApi.a();
        }
        return false;
    }

    public static final boolean e() {
        INAFCApi iNAFCApi = f469b;
        if (iNAFCApi != null) {
            return iNAFCApi.f();
        }
        return false;
    }

    public static final boolean f() {
        INAFCApi iNAFCApi = f469b;
        if (iNAFCApi != null) {
            return iNAFCApi.g();
        }
        return false;
    }

    public static final void g(List<String> list, INAFCApi.a listener) {
        i.f(listener, "listener");
        INAFCApi iNAFCApi = f469b;
        if (iNAFCApi != null) {
            iNAFCApi.d(list, listener);
        }
    }

    public static final boolean h() {
        INAFCApi iNAFCApi = f469b;
        if (iNAFCApi != null) {
            return iNAFCApi.b();
        }
        return false;
    }

    public static final void i() {
        INAFCApi iNAFCApi = f469b;
        if (iNAFCApi != null) {
            iNAFCApi.h();
        }
    }
}
