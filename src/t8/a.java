package T8;

import android.util.Log;
import com.oplus.epona.Request;
import com.oplus.epona.Response;
import com.oplus.epona.d;

/* compiled from: ImsManagerNative.java */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f3783a;

    /* compiled from: ImsManagerNative.java */
    /* renamed from: T8.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0069a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3784a = new a();
    }

    public static a a(int i10) {
        f3783a = i10;
        return C0069a.f3784a;
    }

    public boolean b() {
        V8.b.a(22);
        Response d10 = d.o(new Request.b().c("com.android.ims.ImsManager").b("isEnhanced4gLteModeSettingEnabledByUser").d("phoneId", f3783a).a()).d();
        if (d10.j()) {
            return d10.h().getBoolean("result");
        }
        Log.e("ImsManagerNative", d10.i());
        return false;
    }

    public boolean c() {
        V8.b.a(22);
        Response d10 = d.o(new Request.b().c("com.android.ims.ImsManager").b("isVtEnabledByPlatform").d("phoneId", f3783a).a()).d();
        if (d10.j()) {
            return d10.h().getBoolean("result");
        }
        Log.e("ImsManagerNative", d10.i());
        return false;
    }

    public boolean d() {
        V8.b.a(22);
        Response d10 = d.o(new Request.b().c("com.android.ims.ImsManager").b("isVtEnabledByUser").d("phoneId", f3783a).a()).d();
        if (d10.j()) {
            return d10.h().getBoolean("result");
        }
        Log.e("ImsManagerNative", d10.i());
        return false;
    }

    public boolean e() {
        V8.b.a(22);
        Response d10 = d.o(new Request.b().c("com.android.ims.ImsManager").b("isWfcEnabledByPlatform").d("phoneId", f3783a).a()).d();
        if (d10.j()) {
            return d10.h().getBoolean("result");
        }
        Log.e("ImsManagerNative", d10.i());
        return false;
    }

    public boolean f() {
        V8.b.a(22);
        Response d10 = d.o(new Request.b().c("com.android.ims.ImsManager").b("isWfcEnabledByUser").d("phoneId", f3783a).a()).d();
        if (d10.j()) {
            return d10.h().getBoolean("result");
        }
        Log.e("ImsManagerNative", d10.i());
        return false;
    }

    public a() {
    }
}
