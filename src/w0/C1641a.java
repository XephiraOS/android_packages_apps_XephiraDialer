package w0;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.widget.ImageView;
import java.util.ArrayList;

/* compiled from: CustExportManager.kt */
/* renamed from: w0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1641a {

    /* renamed from: a, reason: collision with root package name */
    public static final C1641a f37559a = new C1641a();

    public static final boolean a(String str, String str2) {
        f fVar = (f) C1642b.a(f.class);
        if (fVar != null) {
            return fVar.j(str, str2);
        }
        return false;
    }

    public static final boolean b(Context context, Uri uri, String str, int i10) {
        f fVar = (f) C1642b.a(f.class);
        if (fVar != null) {
            return fVar.u(context, uri, str, i10);
        }
        return false;
    }

    public static final Uri c(String str) {
        Uri s10;
        f fVar = (f) C1642b.a(f.class);
        if (fVar == null || (s10 = fVar.s(str)) == null) {
            return ContactsContract.PhoneLookup.CONTENT_FILTER_URI;
        }
        return s10;
    }

    public static final String d(Context context, ArrayList<String> arrayList, String str) {
        f fVar = (f) C1642b.a(f.class);
        if (fVar != null) {
            return fVar.t(context, arrayList, str);
        }
        return null;
    }

    public static final String e(String str) {
        f fVar = (f) C1642b.a(f.class);
        if (fVar != null) {
            return fVar.k(str);
        }
        return null;
    }

    public static final String f(String str) {
        f fVar = (f) C1642b.a(f.class);
        if (fVar != null) {
            return fVar.q(str);
        }
        return null;
    }

    public static final void g(Context context) {
        f fVar = (f) C1642b.a(f.class);
        if (fVar != null) {
            fVar.init(context);
        }
    }

    public static final d h(Context context, e eVar) {
        f fVar = (f) C1642b.a(f.class);
        if (fVar != null) {
            return fVar.g(context, eVar);
        }
        return null;
    }

    public static final m i(Context context, n nVar) {
        f fVar = (f) C1642b.a(f.class);
        if (fVar != null) {
            return fVar.c(context, nVar);
        }
        return null;
    }

    public static final boolean j() {
        f fVar = (f) C1642b.a(f.class);
        if (fVar != null) {
            return fVar.w();
        }
        return false;
    }

    public static final boolean k(long j10) {
        f fVar = (f) C1642b.a(f.class);
        if (fVar != null) {
            return fVar.f(j10);
        }
        return false;
    }

    public static final boolean l(Context context, boolean z10) {
        f fVar = (f) C1642b.a(f.class);
        if (fVar != null) {
            return fVar.d(context, z10);
        }
        return false;
    }

    public static final boolean m(Context context) {
        f fVar = (f) C1642b.a(f.class);
        if (fVar != null) {
            return fVar.i(context);
        }
        return false;
    }

    public static final boolean n(Uri uri) {
        f fVar = (f) C1642b.a(f.class);
        if (fVar != null) {
            return fVar.p(uri);
        }
        return false;
    }

    public static final boolean o(Context context, String[] strArr, boolean z10) {
        f fVar = (f) C1642b.a(f.class);
        if (fVar != null) {
            return fVar.h(context, strArr, z10);
        }
        return false;
    }

    public static final boolean p(Context context, String[] strArr) {
        f fVar = (f) C1642b.a(f.class);
        if (fVar != null) {
            return fVar.b(context, strArr);
        }
        return false;
    }

    public static final boolean q(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        f fVar = (f) C1642b.a(f.class);
        if (fVar != null) {
            return fVar.n(context);
        }
        return false;
    }

    public static final boolean r() {
        f fVar = (f) C1642b.a(f.class);
        if (fVar != null) {
            return fVar.a();
        }
        return false;
    }

    public static final void s(Context context, String str, Intent intent) {
        f fVar = (f) C1642b.a(f.class);
        if (fVar != null) {
            fVar.e(context, str, intent);
        }
    }

    public static final String t(Context context, String str) {
        f fVar = (f) C1642b.a(f.class);
        if (fVar != null) {
            return fVar.v(context, str);
        }
        return null;
    }

    public static final boolean u(Context context, String str, int i10, boolean z10) {
        f fVar = (f) C1642b.a(f.class);
        if (fVar != null) {
            return fVar.o(context, str, i10, z10);
        }
        return false;
    }

    public static final void v(m mVar, String str, int i10) {
        f fVar = (f) C1642b.a(f.class);
        if (fVar != null) {
            fVar.x(mVar, str, i10);
        }
    }

    public static final void w(long j10, ImageView imageView) {
        f fVar = (f) C1642b.a(f.class);
        if (fVar != null) {
            fVar.l(j10, imageView);
        }
    }

    public static final boolean x(Context context) {
        f fVar = (f) C1642b.a(f.class);
        if (fVar != null) {
            return fVar.r(context);
        }
        return false;
    }

    public static final void y(Context context, Uri uri) {
        kotlin.jvm.internal.i.f(uri, "uri");
        f fVar = (f) C1642b.a(f.class);
        if (fVar != null) {
            fVar.m(context, uri);
        }
    }
}
