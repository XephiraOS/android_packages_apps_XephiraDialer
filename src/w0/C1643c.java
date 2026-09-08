package w0;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.telecom.PhoneAccountHandle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.HashMap;
import java.util.LinkedList;

/* compiled from: CustUstManager.kt */
/* renamed from: w0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1643c {

    /* renamed from: a, reason: collision with root package name */
    public static final C1643c f37560a = new C1643c();

    public static final void A() {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            iVar.F();
        }
    }

    public static final void B(Context context, String str, j<Void> jVar) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            iVar.C(context, str, jVar);
        }
    }

    public static final void C(HashMap<String, Boolean> hashMap, Context context, View view, ImageView imageView) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            iVar.a(hashMap, context, view, imageView);
        }
    }

    public static final void D(HashMap<String, Boolean> hashMap, Context context, View view, ImageView imageView) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            iVar.u(hashMap, context, view, imageView);
        }
    }

    public static final boolean E(Context context, ViewGroup viewGroup) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            return iVar.l(context, viewGroup);
        }
        return false;
    }

    public static final boolean F(Context context, View view) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            return iVar.w(context, view);
        }
        return false;
    }

    public static final boolean G(Context context, String str) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            return iVar.v(context, str);
        }
        return false;
    }

    public static final void H(Context context, PhoneAccountHandle phoneAccountHandle, Bundle bundle) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            iVar.D(context, phoneAccountHandle, null);
        }
    }

    public static final void I(Context context, PhoneAccountHandle phoneAccountHandle, boolean z10, boolean z11) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            iVar.t(context, phoneAccountHandle, z10, z11);
        }
    }

    public static final void J(Context context, PhoneAccountHandle phoneAccountHandle, boolean z10) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            iVar.h(context, phoneAccountHandle, z10);
        }
    }

    public static final void K(Context context, PhoneAccountHandle phoneAccountHandle) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            iVar.i(context, phoneAccountHandle);
        }
    }

    public static final boolean L(Intent intent, Context context, PhoneAccountHandle phoneAccountHandle) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            return iVar.J(intent, context, phoneAccountHandle);
        }
        return false;
    }

    public static final void M(Context context) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            iVar.o(context);
        }
    }

    public static final Intent N(String str, String str2) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            return iVar.b(str, str2);
        }
        return null;
    }

    public static final void a(Activity activity, boolean z10, int i10) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            iVar.r(activity, z10, i10);
        }
    }

    public static final void b() {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            iVar.K();
        }
    }

    public static final void c() {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            iVar.f();
        }
    }

    public static final boolean d(Bundle bundle) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            return iVar.L(bundle);
        }
        return false;
    }

    public static final void e() {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            iVar.d();
        }
    }

    public static final void f(Context context, ImageView imageView, long j10, Integer num) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            iVar.E(context, imageView, j10, num);
        }
    }

    public static final void g(ImageView imageView, ImageView imageView2, int i10, boolean z10) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            iVar.c(imageView, imageView2, i10, z10);
        }
    }

    public static final void h(Context context, String str, Uri uri) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            iVar.H(context, str, uri);
        }
    }

    public static final void i(Bundle bundle, j<Bitmap> jVar) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            iVar.z(bundle, jVar);
        }
    }

    public static final String j(Bundle bundle) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            return iVar.n(bundle);
        }
        return null;
    }

    public static final BroadcastReceiver k() {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            return iVar.m();
        }
        return null;
    }

    public static final HashMap<String, Boolean> l(Context context, String str) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            return iVar.B(context, str);
        }
        return null;
    }

    public static final String m(Context context) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            return iVar.y(context);
        }
        return null;
    }

    public static final String n(Context context, String[] strArr) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            return iVar.p(context, strArr);
        }
        return null;
    }

    public static final boolean o(Context context, String str) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            return iVar.x(context, str);
        }
        return false;
    }

    public static final boolean p(Context context, String str) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            return iVar.g(context, str);
        }
        return false;
    }

    public static final boolean q() {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            return iVar.q();
        }
        return false;
    }

    public static final void r(Context context) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            iVar.init(context);
        }
    }

    public static final void s(Context context) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            iVar.G(context);
        }
    }

    public static final boolean t(String str) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            return iVar.e(str);
        }
        return false;
    }

    public static final boolean u(Context context) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            return iVar.k(context);
        }
        return false;
    }

    public static final boolean v() {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            return iVar.s();
        }
        return false;
    }

    public static final boolean w() {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            return iVar.j();
        }
        return false;
    }

    public static final LinkedList<l> x(String content) {
        kotlin.jvm.internal.i.f(content, "content");
        h hVar = (h) C1642b.a(h.class);
        if (hVar != null) {
            return hVar.parse(content);
        }
        return null;
    }

    public static final void y(String str, Context context, j<Boolean> jVar) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            iVar.I(str, context, jVar);
        }
    }

    public static final void z(Context context) {
        i iVar = (i) C1642b.a(i.class);
        if (iVar != null) {
            iVar.A(context);
        }
    }
}
