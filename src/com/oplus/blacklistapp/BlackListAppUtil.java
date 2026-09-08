package com.oplus.blacklistapp;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.android.incallui.OplusPhoneUtils;
import com.oplus.blacklistapp.callintercept.CallInterceptController;
import com.oplus.blacklistapp.framework.baseui.util.CommonFeatureOption;
import com.oplus.common.data.WashManager;
import com.oplus.utils.C0844e;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0848i;
import com.oplus.utils.C0849j;
import com.oplus.utils.C0852m;
import com.oplus.utils.C0854o;
import com.oplus.utils.StatisticsUtils;
import java.util.ConcurrentModificationException;
import java.util.Locale;
import kotlinx.coroutines.C1241e0;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.S;
import v6.C1632f;

/* compiled from: BlackListAppUtil.kt */
/* loaded from: classes3.dex */
public final class BlackListAppUtil {

    /* renamed from: b, reason: collision with root package name */
    public static boolean f26245b;

    /* renamed from: a, reason: collision with root package name */
    public static final BlackListAppUtil f26244a = new BlackListAppUtil();

    /* renamed from: c, reason: collision with root package name */
    public static final C0852m f26246c = new C0852m();

    /* compiled from: BlackListAppUtil.kt */
    /* loaded from: classes3.dex */
    public static final class a extends ContentObserver {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f26247a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, Handler handler) {
            super(handler);
            this.f26247a = context;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            C0846g.l(this.f26247a);
        }
    }

    public static final void a(Context context, Application application) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(application, "application");
        if (!C0854o.c(0, 0, 3, null)) {
            S6.a.a(context);
        }
        g.a();
        WashManager.f27755a.g(application);
        C0846g.a(application);
        C0844e.g(application);
        l7.b.a(application);
        CommonFeatureOption.e(context);
        com.oplus.blacklistapp.framework.api.appstore.virtualsupport.b.a(application);
        com.oplus.blacklistapp.framework.api.sync.a.f27234a.c(application, l7.b.c(context));
    }

    public static final void b(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        d(context);
        e(context);
        f(context);
        C1244g.d(C1241e0.f34422a, S.a(), null, new BlackListAppUtil$create$1(context, null), 2, null);
        try {
            if (C0848i.u(context)) {
                Intent intent = new Intent(context, (Class<?>) StatisticsService.class);
                intent.setPackage(context.getPackageName());
                context.startService(intent);
            }
        } catch (IllegalStateException e10) {
            Log.e("BlackListAppUtil", "start StatisticsService error " + e10);
        }
        if (!C0844e.f29134b) {
            SharedPreferences b10 = androidx.preference.j.b(context);
            if (C0848i.v(context)) {
                C1632f.n0(context);
                b10.edit().putBoolean("have_updated_intercept_rule", true).apply();
            }
        }
        com.oplus.blacklistapp.framework.api.sync.a.d();
    }

    public static final C0852m c() {
        return f26246c;
    }

    public static final void d(Context context) {
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.i.e(applicationContext, "context.applicationContext");
        C6.c.a(applicationContext);
        boolean z10 = true;
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) {
            z10 = false;
        }
        f26245b = z10;
        CallInterceptController.e().o(context);
        C0849j.c(context);
        try {
            StatisticsUtils.h(context);
        } catch (ConcurrentModificationException e10) {
            Log.e("BlackListAppUtil", "start statisticsInit error " + e10);
        }
    }

    public static final void e(Context context) {
        LogSwitchSettingsReceiver logSwitchSettingsReceiver = new LogSwitchSettingsReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("blacklist.log.switch.broadcast");
        context.registerReceiver(logSwitchSettingsReceiver, intentFilter, OplusPhoneUtils.PERMISSION_OPLUS_COMPONENT_SAFE, null, 2);
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver != null) {
            contentResolver.registerContentObserver(Settings.System.getUriFor("log_switch_type"), true, new a(context, new Handler()));
        }
    }

    public static final void f(Context context) {
        RegionChangeReceiver regionChangeReceiver = new RegionChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(F6.a.f997a.j());
        context.registerReceiver(regionChangeReceiver, intentFilter, OplusPhoneUtils.PERMISSION_OPLUS_COMPONENT_SAFE, null, 2);
    }

    public static final void g() {
        boolean z10 = true;
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) {
            z10 = false;
        }
        f26245b = z10;
    }
}
