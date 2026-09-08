package com.oplus.foundation.util.feature;

import C7.b;
import J6.e;
import android.content.Context;
import android.telephony.OplusTelephonyManager;
import com.oplus.content.OplusFeatureConfigManager;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.a;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: VirtualSupportUtils.kt */
/* loaded from: classes3.dex */
public final class VirtualSupportUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final VirtualSupportUtils f28344a = new VirtualSupportUtils();

    /* renamed from: b, reason: collision with root package name */
    public static Context f28345b;

    /* renamed from: c, reason: collision with root package name */
    public static final d f28346c;

    /* renamed from: d, reason: collision with root package name */
    public static final d f28347d;

    /* renamed from: e, reason: collision with root package name */
    public static final d f28348e;

    /* renamed from: f, reason: collision with root package name */
    public static final d f28349f;

    /* renamed from: g, reason: collision with root package name */
    public static final d f28350g;

    static {
        d a10;
        d a11;
        d a12;
        d a13;
        d a14;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f34162b;
        a10 = a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.oplus.foundation.util.feature.VirtualSupportUtils$VIRTUAL_CALL_DATABASE_SUPPORT$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                Context context;
                context = VirtualSupportUtils.f28345b;
                return Boolean.valueOf(M7.a.h(context, "com.android.providers.contacts", "virtual_call_db", "true"));
            }
        });
        f28346c = a10;
        a11 = a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.oplus.foundation.util.feature.VirtualSupportUtils$VIRTUAL_MODEM_SUPPORT$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                Context context;
                context = VirtualSupportUtils.f28345b;
                return Boolean.valueOf(VirtualSupportUtils.o(context));
            }
        });
        f28347d = a11;
        a12 = a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.oplus.foundation.util.feature.VirtualSupportUtils$PRIMARY_VIRTUAL_DEVICE$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                Context context;
                context = VirtualSupportUtils.f28345b;
                return Boolean.valueOf(VirtualSupportUtils.j(context));
            }
        });
        f28348e = a12;
        a13 = a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.oplus.foundation.util.feature.VirtualSupportUtils$SECONDARY_VIRTUAL_DEVICE$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                Context context;
                context = VirtualSupportUtils.f28345b;
                return Boolean.valueOf(VirtualSupportUtils.l(context));
            }
        });
        f28349f = a13;
        a14 = a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.oplus.foundation.util.feature.VirtualSupportUtils$DATA_ONLY_DEVICE$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                return Boolean.valueOf(VirtualSupportUtils.h());
            }
        });
        f28350g = a14;
    }

    public static final void f(Context context) {
        f28345b = context;
    }

    public static final boolean g() {
        return f28344a.b();
    }

    public static final boolean h() {
        boolean a10;
        try {
            Result.a aVar = Result.f34166a;
            if (b.a(30, 1)) {
                a10 = OplusFeatureConfigManager.getInstance().hasFeature("oplus.software.radio.virtualmodem_data_only");
            } else {
                a10 = e.a("oplus.software.radio.virtualmodem_data_only");
            }
            H7.b.b("VirtualSupportUtils", "isHasDataOnlyFeature dataOnly = " + a10);
            return a10;
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            Throwable d10 = Result.d(Result.b(kotlin.b.a(th)));
            if (d10 != null) {
                H7.b.c("VirtualSupportUtils", "isHasDataOnlyFeature exception" + d10);
                return false;
            }
            return false;
        }
    }

    public static final boolean i(Context context) {
        if (q(context) && r(context)) {
            return true;
        }
        return false;
    }

    public static final boolean j(Context context) {
        try {
            Result.a aVar = Result.f34166a;
            int virtualcommDeviceType = OplusTelephonyManager.getInstance(context).getVirtualcommDeviceType();
            H7.b.b("VirtualSupportUtils", "isPrimaryDevice result = " + virtualcommDeviceType);
            if (virtualcommDeviceType != 1) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            Throwable d10 = Result.d(Result.b(kotlin.b.a(th)));
            if (d10 != null) {
                H7.b.c("VirtualSupportUtils", "isPrimaryDevice exception" + d10);
            }
            return false;
        }
    }

    public static final boolean k() {
        return f28344a.c();
    }

    public static final boolean l(Context context) {
        try {
            Result.a aVar = Result.f34166a;
            int virtualcommDeviceType = OplusTelephonyManager.getInstance(context).getVirtualcommDeviceType();
            H7.b.b("VirtualSupportUtils", "isSecondaryDevice result = " + virtualcommDeviceType);
            if (virtualcommDeviceType != 2) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            Throwable d10 = Result.d(Result.b(kotlin.b.a(th)));
            if (d10 != null) {
                H7.b.c("VirtualSupportUtils", "isSecondaryDevice exception" + d10);
            }
            return false;
        }
    }

    public static final boolean m() {
        if (k() && !g()) {
            return true;
        }
        return false;
    }

    public static final boolean n() {
        return f28344a.e();
    }

    public static final boolean o(Context context) {
        try {
            Result.a aVar = Result.f34166a;
            boolean isVirtualCommSupport = OplusTelephonyManager.getInstance(context).isVirtualCommSupport();
            H7.b.b("VirtualSupportUtils", "isSupportVirtualModem result = " + isVirtualCommSupport);
            return isVirtualCommSupport;
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            Throwable d10 = Result.d(Result.b(kotlin.b.a(th)));
            if (d10 != null) {
                H7.b.c("VirtualSupportUtils", "isSupportVirtualModem exception" + d10);
                return false;
            }
            return false;
        }
    }

    public static final boolean p() {
        return f28344a.d();
    }

    public static final boolean q(Context context) {
        try {
            Result.a aVar = Result.f34166a;
            boolean hasVirtualCommCapability = OplusTelephonyManager.getInstance(context).hasVirtualCommCapability(0, 1);
            H7.b.b("VirtualSupportUtils", "hasPhoneShared = " + hasVirtualCommCapability);
            return hasVirtualCommCapability;
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            Throwable d10 = Result.d(Result.b(kotlin.b.a(th)));
            if (d10 != null) {
                H7.b.c("VirtualSupportUtils", "isVirtualHasCallSharedCapabilty exception" + d10);
            }
            return false;
        }
    }

    public static final boolean r(Context context) {
        try {
            Result.a aVar = Result.f34166a;
            int state = OplusTelephonyManager.getInstance(context).getVirtualCommState().getState();
            H7.b.b("VirtualSupportUtils", "isVirtualStateInService serviceState = " + state);
            if (state != 0) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            Throwable d10 = Result.d(Result.b(kotlin.b.a(th)));
            if (d10 != null) {
                H7.b.c("VirtualSupportUtils", "isVirtualStateInService exception" + d10);
            }
            return false;
        }
    }

    public final boolean b() {
        return ((Boolean) f28350g.getValue()).booleanValue();
    }

    public final boolean c() {
        return ((Boolean) f28349f.getValue()).booleanValue();
    }

    public final boolean d() {
        return ((Boolean) f28346c.getValue()).booleanValue();
    }

    public final boolean e() {
        return ((Boolean) f28347d.getValue()).booleanValue();
    }
}
