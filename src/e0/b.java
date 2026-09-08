package E0;

import F0.c;
import android.content.Context;
import android.os.Bundle;
import com.android.contacts.framework.api.numberidentify.interfaces.IMarkerData;
import com.android.contacts.framework.api.numberidentify.interfaces.INumberIdentifyApi;
import com.android.contacts.framework.api.numberidentify.interfaces.IRecognitionNumber;
import java.util.List;
import kotlin.jvm.internal.i;

/* compiled from: NumberIdentifyManager.kt */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f470a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static INumberIdentifyApi f471b = INumberIdentifyApi.f15587a.a();

    public static final void A(F0.b bVar, INumberIdentifyApi.a aVar) {
        INumberIdentifyApi iNumberIdentifyApi = f471b;
        if (iNumberIdentifyApi != null) {
            iNumberIdentifyApi.h(bVar, aVar);
        }
    }

    public static final IRecognitionNumber B(c cVar) {
        INumberIdentifyApi iNumberIdentifyApi = f471b;
        if (iNumberIdentifyApi != null) {
            return iNumberIdentifyApi.A(cVar);
        }
        return null;
    }

    public static final void C(String str) {
        INumberIdentifyApi iNumberIdentifyApi = f471b;
        if (iNumberIdentifyApi != null) {
            iNumberIdentifyApi.g(str);
        }
    }

    public static final void D() {
        INumberIdentifyApi iNumberIdentifyApi = f471b;
        if (iNumberIdentifyApi != null) {
            iNumberIdentifyApi.s();
        }
    }

    public static final void E(String str, IRecognitionNumber iRecognitionNumber) {
        INumberIdentifyApi iNumberIdentifyApi = f471b;
        if (iNumberIdentifyApi != null) {
            iNumberIdentifyApi.i(str, iRecognitionNumber);
        }
    }

    public static final boolean F(c cVar) {
        INumberIdentifyApi iNumberIdentifyApi = f471b;
        if (iNumberIdentifyApi != null) {
            return iNumberIdentifyApi.n(cVar);
        }
        return false;
    }

    public static final void a() {
        INumberIdentifyApi iNumberIdentifyApi = f471b;
        if (iNumberIdentifyApi != null) {
            iNumberIdentifyApi.bindService();
        }
    }

    public static final void b() {
        INumberIdentifyApi iNumberIdentifyApi = f471b;
        if (iNumberIdentifyApi != null) {
            iNumberIdentifyApi.clear();
        }
    }

    public static final boolean c(String str, String str2, String str3, String str4, String str5, int i10) {
        INumberIdentifyApi iNumberIdentifyApi = f471b;
        if (iNumberIdentifyApi != null) {
            return iNumberIdentifyApi.D(str, str2, str3, str4, str5, i10);
        }
        return false;
    }

    public static final void d(String str, String str2, String str3, String str4, int i10) {
        INumberIdentifyApi iNumberIdentifyApi = f471b;
        if (iNumberIdentifyApi != null) {
            iNumberIdentifyApi.y(str, str2, str3, str4, i10);
        }
    }

    public static final F0.a e(String str) {
        if (str == null) {
            return null;
        }
        return (F0.a) U7.b.f3872a.a(str, F0.a.class);
    }

    public static final void f() {
        INumberIdentifyApi iNumberIdentifyApi = f471b;
        if (iNumberIdentifyApi != null) {
            iNumberIdentifyApi.a();
        }
    }

    public static final List<String> g() {
        INumberIdentifyApi iNumberIdentifyApi = f471b;
        if (iNumberIdentifyApi != null) {
            return iNumberIdentifyApi.e();
        }
        return null;
    }

    public static final IRecognitionNumber h(String str) {
        INumberIdentifyApi iNumberIdentifyApi = f471b;
        if (iNumberIdentifyApi != null) {
            return iNumberIdentifyApi.B(str);
        }
        return null;
    }

    public static final int i(Context context, String str) {
        INumberIdentifyApi iNumberIdentifyApi = f471b;
        if (iNumberIdentifyApi != null) {
            return iNumberIdentifyApi.w(context, str);
        }
        return 0;
    }

    public static final String j(Context context, String str) {
        INumberIdentifyApi iNumberIdentifyApi = f471b;
        if (iNumberIdentifyApi != null) {
            return iNumberIdentifyApi.q(context, str);
        }
        return null;
    }

    public static final int k() {
        INumberIdentifyApi iNumberIdentifyApi = f471b;
        if (iNumberIdentifyApi != null) {
            return iNumberIdentifyApi.m();
        }
        return 0;
    }

    public static final String l(F0.a data) {
        i.f(data, "data");
        return U7.b.f3872a.b(data);
    }

    public static final int m(String str) {
        INumberIdentifyApi iNumberIdentifyApi = f471b;
        if (iNumberIdentifyApi != null) {
            return iNumberIdentifyApi.f(str);
        }
        return -1;
    }

    public static final IMarkerData n(String str) {
        INumberIdentifyApi iNumberIdentifyApi = f471b;
        if (iNumberIdentifyApi != null) {
            return iNumberIdentifyApi.z(str);
        }
        return null;
    }

    public static final int o(String str) {
        INumberIdentifyApi iNumberIdentifyApi = f471b;
        if (iNumberIdentifyApi != null) {
            return iNumberIdentifyApi.t(str);
        }
        return -1;
    }

    public static final String p(Context context, IMarkerData iMarkerData) {
        INumberIdentifyApi iNumberIdentifyApi = f471b;
        if (iNumberIdentifyApi != null) {
            return iNumberIdentifyApi.j(context, iMarkerData);
        }
        return null;
    }

    public static final Bundle q() {
        INumberIdentifyApi iNumberIdentifyApi = f471b;
        if (iNumberIdentifyApi != null) {
            return iNumberIdentifyApi.p();
        }
        return null;
    }

    public static final int r() {
        INumberIdentifyApi iNumberIdentifyApi = f471b;
        if (iNumberIdentifyApi != null) {
            return iNumberIdentifyApi.o();
        }
        return 0;
    }

    public static final String s(Context context, IMarkerData iMarkerData) {
        INumberIdentifyApi iNumberIdentifyApi = f471b;
        if (iNumberIdentifyApi != null) {
            return iNumberIdentifyApi.r(context, iMarkerData);
        }
        return null;
    }

    public static final String t(Context context, String str) {
        INumberIdentifyApi iNumberIdentifyApi = f471b;
        if (iNumberIdentifyApi != null) {
            return iNumberIdentifyApi.k(context, str);
        }
        return null;
    }

    public static final String u(String str) {
        INumberIdentifyApi iNumberIdentifyApi = f471b;
        if (iNumberIdentifyApi != null) {
            return iNumberIdentifyApi.v(str);
        }
        return null;
    }

    public static final String[] v(Context context) {
        String[] C10;
        INumberIdentifyApi iNumberIdentifyApi = f471b;
        if (iNumberIdentifyApi == null || (C10 = iNumberIdentifyApi.C(context)) == null) {
            return new String[0];
        }
        return C10;
    }

    public static final boolean w(String str) {
        INumberIdentifyApi iNumberIdentifyApi = f471b;
        if (iNumberIdentifyApi != null) {
            return iNumberIdentifyApi.u(str);
        }
        return false;
    }

    public static final boolean x() {
        INumberIdentifyApi iNumberIdentifyApi = f471b;
        if (iNumberIdentifyApi != null) {
            return iNumberIdentifyApi.x();
        }
        return false;
    }

    public static final boolean y(String str) {
        INumberIdentifyApi iNumberIdentifyApi = f471b;
        if (iNumberIdentifyApi != null) {
            return iNumberIdentifyApi.d(str);
        }
        return false;
    }

    public static final byte[] z(String str) {
        INumberIdentifyApi iNumberIdentifyApi = f471b;
        if (iNumberIdentifyApi != null) {
            return iNumberIdentifyApi.l(str);
        }
        return null;
    }
}
