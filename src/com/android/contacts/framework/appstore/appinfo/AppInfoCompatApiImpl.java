package com.android.contacts.framework.appstore.appinfo;

import C7.g;
import C9.j;
import P7.c;
import android.app.Activity;
import android.app.role.RoleManager;
import android.content.Context;
import android.content.Intent;
import android.telecom.TelecomManager;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.p;
import com.android.contacts.framework.api.appstore.appinfo.IAppInfoCompatApi;
import com.oplus.foundation.util.OsUtils;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.S;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: AppInfoCompatApiImpl.kt */
/* loaded from: classes.dex */
public final class AppInfoCompatApiImpl implements IAppInfoCompatApi {

    /* renamed from: d, reason: collision with root package name */
    public static final d<Boolean> f15638d;

    /* renamed from: e, reason: collision with root package name */
    public static final d<Boolean> f15639e;

    /* renamed from: f, reason: collision with root package name */
    public static final d<Boolean> f15640f;

    /* renamed from: g, reason: collision with root package name */
    public static final d<Boolean> f15641g;

    /* renamed from: h, reason: collision with root package name */
    public static final AppInfoCompatApiImpl f15642h;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ j<Object>[] f15637c = {k.e(new PropertyReference0Impl(AppInfoCompatApiImpl.class, "act", "<v#0>", 0))};

    /* renamed from: b, reason: collision with root package name */
    public static final a f15636b = new a(null);

    /* compiled from: AppInfoCompatApiImpl.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final boolean a() {
            return ((Boolean) AppInfoCompatApiImpl.f15641g.getValue()).booleanValue();
        }

        public final String b(Context context) {
            i.f(context, "context");
            TelecomManager telecomManager = (TelecomManager) context.getSystemService(TelecomManager.class);
            if (telecomManager != null) {
                return telecomManager.getDefaultDialerPackage();
            }
            return null;
        }

        public final AppInfoCompatApiImpl c() {
            return AppInfoCompatApiImpl.f15642h;
        }

        public final boolean d() {
            return ((Boolean) AppInfoCompatApiImpl.f15640f.getValue()).booleanValue();
        }

        public final boolean e() {
            return ((Boolean) AppInfoCompatApiImpl.f15639e.getValue()).booleanValue();
        }

        public final boolean f() {
            return ((Boolean) AppInfoCompatApiImpl.f15638d.getValue()).booleanValue();
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        d<Boolean> b10;
        d<Boolean> b11;
        d<Boolean> b12;
        d<Boolean> b13;
        b10 = kotlin.a.b(new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.framework.appstore.appinfo.AppInfoCompatApiImpl$Companion$SUPPORT_STORE_TELE_SERVICE$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                return Boolean.valueOf(M7.a.h(P7.a.f2961a.a(), "com.android.phone", "store_dialer_teleservice", "true"));
            }
        });
        f15638d = b10;
        b11 = kotlin.a.b(new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.framework.appstore.appinfo.AppInfoCompatApiImpl$Companion$SUPPORT_NULL_ACCOUNT_MERGE$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                return Boolean.valueOf(M7.a.h(P7.a.f2961a.a(), "com.android.providers.contacts", "store_dialer_support", "true"));
            }
        });
        f15639e = b11;
        b12 = kotlin.a.b(new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.framework.appstore.appinfo.AppInfoCompatApiImpl$Companion$ORIGINAL_DIALER_INSTALLED$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                return Boolean.valueOf(c.d(P7.a.f2961a.a(), "com.android.contacts", true));
            }
        });
        f15640f = b12;
        b13 = kotlin.a.b(new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.framework.appstore.appinfo.AppInfoCompatApiImpl$Companion$CALL_RECORDER_INSTALLED$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                return Boolean.valueOf(c.d(P7.a.f2961a.a(), "com.oplus.callrecorder", true));
            }
        });
        f15641g = b13;
        f15642h = new AppInfoCompatApiImpl();
    }

    public static final AppCompatActivity w(g<AppCompatActivity> gVar) {
        return gVar.a(null, f15637c[0]);
    }

    public static final void x(Activity activity) {
        i.f(activity, "$activity");
        L0.c.f1709a.b(activity);
    }

    @Override // com.android.contacts.framework.api.appstore.appinfo.IAppInfoCompatApi
    public String a() {
        return "com.oplus.dialer.black_list";
    }

    @Override // com.android.contacts.framework.api.appstore.appinfo.IAppInfoCompatApi
    public String b() {
        return "com.oplus.dialer";
    }

    @Override // com.android.contacts.framework.api.appstore.appinfo.IAppInfoCompatApi
    public String c() {
        return "com.oplus.dialer.inquirenoarea";
    }

    @Override // com.android.contacts.framework.api.appstore.appinfo.IAppInfoCompatApi
    public boolean d() {
        return true;
    }

    @Override // com.android.contacts.framework.api.appstore.appinfo.IAppInfoCompatApi
    public void e(final Activity activity) {
        i.f(activity, "activity");
        if (f15636b.f()) {
            h(activity, new Runnable() { // from class: com.android.contacts.framework.appstore.appinfo.a
                @Override // java.lang.Runnable
                public final void run() {
                    AppInfoCompatApiImpl.x(activity);
                }
            });
        } else {
            L0.c.f1709a.a(activity);
        }
    }

    @Override // com.android.contacts.framework.api.appstore.appinfo.IAppInfoCompatApi
    public String f() {
        return "android.intent.action.CALL";
    }

    @Override // com.android.contacts.framework.api.appstore.appinfo.IAppInfoCompatApi
    public boolean g() {
        return f15636b.e();
    }

    @Override // com.android.contacts.framework.api.appstore.appinfo.IAppInfoCompatApi
    public void h(final Context context, Runnable runnable) {
        i.f(runnable, "runnable");
        if (!(context instanceof AppCompatActivity)) {
            Log.e("AppInfoCompatApiImpl", "checkDefaultDialerRun: context need to not be AppCompatActivity type instance.");
            return;
        }
        g gVar = new g(new InterfaceC1637a<AppCompatActivity>() { // from class: com.android.contacts.framework.appstore.appinfo.AppInfoCompatApiImpl$checkDefaultDialerRun$act$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final AppCompatActivity invoke() {
                return (AppCompatActivity) context;
            }
        });
        AppCompatActivity w10 = w(gVar);
        i.d(w10, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        LifecycleCoroutineScope a10 = p.a(w10);
        C1248i.d(a10, S.a(), null, new AppInfoCompatApiImpl$checkDefaultDialerRun$1(gVar, a10, runnable, null), 2, null);
    }

    @Override // com.android.contacts.framework.api.appstore.appinfo.IAppInfoCompatApi
    public String i() {
        return "com.oplus.dialer";
    }

    @Override // com.android.contacts.framework.api.appstore.appinfo.IAppInfoCompatApi
    public String j(String str) {
        i.f(str, "default");
        if (!OsUtils.f28280f && !f15636b.d()) {
            return null;
        }
        return str;
    }

    @Override // com.android.contacts.framework.api.appstore.appinfo.IAppInfoCompatApi
    public String k(String str) {
        i.f(str, "default");
        if (!OsUtils.f28280f && !f15636b.d()) {
            return null;
        }
        return str;
    }

    @Override // com.android.contacts.framework.api.appstore.appinfo.IAppInfoCompatApi
    public void l(Activity activity) {
        i.f(activity, "activity");
        RoleManager roleManager = (RoleManager) activity.getSystemService(RoleManager.class);
        if (roleManager != null && roleManager.isRoleAvailable("android.app.role.DIALER")) {
            Intent createRequestRoleIntent = roleManager.createRequestRoleIntent("android.app.role.DIALER");
            i.e(createRequestRoleIntent, "roleManager.createReques…ROLE_DIALER\n            )");
            activity.startActivityForResult(createRequestRoleIntent, 1051);
        }
    }

    @Override // com.android.contacts.framework.api.appstore.appinfo.IAppInfoCompatApi
    public String m() {
        return "com.oplus.dialer.blacklist.call_intercept_provider";
    }

    @Override // com.android.contacts.framework.api.appstore.appinfo.IAppInfoCompatApi
    public String n() {
        return "com.oplus.dialer";
    }

    @Override // com.android.contacts.framework.api.appstore.appinfo.IAppInfoCompatApi
    public boolean o() {
        return f15636b.f();
    }
}
