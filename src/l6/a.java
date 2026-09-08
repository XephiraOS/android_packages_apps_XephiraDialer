package L6;

import android.util.Log;
import com.android.ims.ImsManager;
import com.oplus.compat.utils.util.UnSupportedApiVersionException;
import com.oplus.epona.Request;
import com.oplus.epona.Response;
import com.oplus.epona.d;
import com.oplus.utils.reflect.MethodName;
import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefMethod;

/* compiled from: ImsManagerNative.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f1728a;

    /* compiled from: ImsManagerNative.java */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final a f1729a = new a();
    }

    /* compiled from: ImsManagerNative.java */
    /* loaded from: classes3.dex */
    public static class c {

        @MethodName(name = "isEnhanced4gLteModeSettingEnabledByUser", params = {})
        private static RefMethod<Boolean> isEnhanced4gLteModeSettingEnabledByUser;

        @MethodName(name = "isVolteEnabledByPlatform", params = {})
        private static RefMethod<Boolean> isVolteEnabledByPlatform;

        @MethodName(name = "isVtEnabledByPlatform", params = {})
        private static RefMethod<Boolean> isVtEnabledByPlatform;

        @MethodName(name = "isVtEnabledByUser", params = {})
        private static RefMethod<Boolean> isVtEnabledByUser;

        @MethodName(name = "isWfcEnabledByPlatform", params = {})
        private static RefMethod<Boolean> isWfcEnabledByPlatform;

        @MethodName(name = "isWfcEnabledByUser", params = {})
        private static RefMethod<Boolean> isWfcEnabledByUser;

        static {
            RefClass.load((Class<?>) c.class, (Class<?>) ImsManager.class);
        }
    }

    public static a a(int i10) {
        if (S6.c.l()) {
            f1728a = i10;
            return b.f1729a;
        }
        throw new UnSupportedApiVersionException("not supported before Q");
    }

    public boolean b() {
        if (S6.c.m()) {
            Response d10 = d.o(new Request.b().c("com.android.ims.ImsManager").b("isEnhanced4gLteModeSettingEnabledByUser").d("phoneId", f1728a).a()).d();
            if (d10.j()) {
                return d10.h().getBoolean("result");
            }
            Log.e("ImsManagerNative", d10.i());
            return false;
        }
        if (S6.c.l()) {
            return ((Boolean) c.isEnhanced4gLteModeSettingEnabledByUser.call(ImsManager.getInstance(d.g(), f1728a), new Object[0])).booleanValue();
        }
        throw new UnSupportedApiVersionException("not supported before Q");
    }

    public boolean c() {
        if (S6.c.m()) {
            Response d10 = d.o(new Request.b().c("com.android.ims.ImsManager").b("isVtEnabledByPlatform").d("phoneId", f1728a).a()).d();
            if (d10.j()) {
                return d10.h().getBoolean("result");
            }
            Log.e("ImsManagerNative", d10.i());
            return false;
        }
        if (S6.c.l()) {
            return ((Boolean) c.isVtEnabledByPlatform.call(ImsManager.getInstance(d.g(), f1728a), new Object[0])).booleanValue();
        }
        throw new UnSupportedApiVersionException("not supported before Q");
    }

    public boolean d() {
        if (S6.c.m()) {
            Response d10 = d.o(new Request.b().c("com.android.ims.ImsManager").b("isVtEnabledByUser").d("phoneId", f1728a).a()).d();
            if (d10.j()) {
                return d10.h().getBoolean("result");
            }
            Log.e("ImsManagerNative", d10.i());
            return false;
        }
        if (S6.c.l()) {
            return ((Boolean) c.isVtEnabledByUser.call(ImsManager.getInstance(d.g(), f1728a), new Object[0])).booleanValue();
        }
        throw new UnSupportedApiVersionException("not supported before Q");
    }

    public boolean e() {
        if (S6.c.m()) {
            Response d10 = d.o(new Request.b().c("com.android.ims.ImsManager").b("isWfcEnabledByPlatform").d("phoneId", f1728a).a()).d();
            if (d10.j()) {
                return d10.h().getBoolean("result");
            }
            Log.e("ImsManagerNative", d10.i());
            return false;
        }
        if (S6.c.l()) {
            return ((Boolean) c.isWfcEnabledByPlatform.call(ImsManager.getInstance(d.g(), f1728a), new Object[0])).booleanValue();
        }
        throw new UnSupportedApiVersionException("not supported before Q");
    }

    public boolean f() {
        if (S6.c.m()) {
            Response d10 = d.o(new Request.b().c("com.android.ims.ImsManager").b("isWfcEnabledByUser").d("phoneId", f1728a).a()).d();
            if (d10.j()) {
                return d10.h().getBoolean("result");
            }
            Log.e("ImsManagerNative", d10.i());
            return false;
        }
        if (S6.c.l()) {
            return ((Boolean) c.isWfcEnabledByUser.call(ImsManager.getInstance(d.g(), f1728a), new Object[0])).booleanValue();
        }
        throw new UnSupportedApiVersionException("not supported before Q");
    }

    public a() {
    }
}
