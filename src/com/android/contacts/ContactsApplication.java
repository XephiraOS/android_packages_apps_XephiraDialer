package com.android.contacts;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.sqlite.SQLiteDatabase;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Trace;
import android.text.TextUtils;
import android.util.Log;
import com.android.contacts.ContactsApplication;
import com.android.contacts.business.calllog.RecordingSummaryUpdatedReceiver;
import com.android.contacts.compat.data.WashManager;
import com.android.contacts.framework.baseui.util.C0637b;
import com.android.contacts.framework.virtualsupport.utils.GrpcUtils;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.activities.ContactsTabActivity;
import com.customize.contacts.feature.OSCustomizeFeature;
import com.customize.contacts.feature.OSPublicFeature;
import com.customize.contacts.manager.C0786a;
import com.customize.contacts.receiver.DebugStatusChangeReceiver;
import com.customize.contacts.receiver.RegionChangeReceiver;
import com.customize.contacts.receiver.RomUpdateReceiver;
import com.customize.contacts.startupspeed.StartupSpeedHelper;
import com.customize.contacts.util.C0794e;
import com.oplus.coreapp.appfeature.AppFeatureProviderUtils;
import com.oplus.dialer.R;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import com.oplus.foundation.util.feature.FeatureUtil;
import com.oplus.foundation.util.feature.VirtualSupportUtils;
import com.oplus.foundation.util.scheduler.ThreadUtilsKt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import m1.AbstractC1316l;
import n1.AbstractC1362a;
import r0.C1498a;
import r1.C1503a;
import s0.C1521a;
import v9.InterfaceC1637a;
import w0.C1641a;
import w0.C1643c;

/* loaded from: classes.dex */
public final class ContactsApplication extends BaseApplication implements C0.a {

    /* renamed from: h, reason: collision with root package name */
    public static boolean f13092h = false;

    /* renamed from: i, reason: collision with root package name */
    public static ContactsApplication f13093i = null;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f13094j = false;

    /* renamed from: a, reason: collision with root package name */
    public AbstractC1362a f13095a;

    /* renamed from: b, reason: collision with root package name */
    public Z0.b f13096b;

    /* renamed from: c, reason: collision with root package name */
    public AbstractC1316l f13097c;

    /* renamed from: d, reason: collision with root package name */
    public final CountDownLatch f13098d = new CountDownLatch(1);

    /* renamed from: e, reason: collision with root package name */
    public WeakReference<ContactsTabActivity> f13099e = null;

    /* renamed from: f, reason: collision with root package name */
    public final C0658o f13100f = new C0658o();

    /* renamed from: g, reason: collision with root package name */
    public final StartupSpeedHelper.b f13101g = new c();

    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getData() != null) {
                String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                if (!TextUtils.isEmpty(schemeSpecificPart)) {
                    t1.l.b(context, schemeSpecificPart);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends BroadcastReceiver {
        public b() {
        }

        public final /* synthetic */ void b(Context context) {
            ContactsApplication.this.x(context);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(final Context context, Intent intent) {
            N7.a.b().execute(new Runnable() { // from class: com.android.contacts.u
                @Override // java.lang.Runnable
                public final void run() {
                    ContactsApplication.b.this.b(context);
                }
            });
        }
    }

    /* loaded from: classes.dex */
    public class c implements StartupSpeedHelper.b {
        public c() {
        }

        @Override // com.customize.contacts.startupspeed.StartupSpeedHelper.b
        public void a(boolean z10) {
            ContactsApplication.this.f13098d.countDown();
            if (z10) {
                C0786a.j().d();
            }
            N7.a.b().execute(new Runnable() { // from class: com.android.contacts.v
                @Override // java.lang.Runnable
                public final void run() {
                    ContactsApplication.c.this.c();
                }
            });
        }

        public final /* synthetic */ void c() {
            com.android.contacts.util.B.d(ContactsApplication.this);
        }
    }

    /* loaded from: classes.dex */
    public static class d extends ContentObserver {
        public d() {
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            H7.b.b("ContactsApplication", "the feature value has change, we will update the cached feature value");
            OSPublicFeature.H();
        }
    }

    public static void g(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            String packageName = context.getPackageName();
            arrayList.add(packageName);
            D7.a.a(packageName, arrayList);
        } catch (Throwable th) {
            H7.b.c("ContactsApplication", "e = " + th);
        }
    }

    public static ContactsApplication h() {
        return f13093i;
    }

    public static C1503a i() {
        return null;
    }

    @Override // C0.a
    public void a() {
        this.f13100f.a();
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        f13093i = this;
        P7.a.f2962b = this;
        C0706w.a();
        Thread.setDefaultUncaughtExceptionHandler(new com.android.contacts.util.m());
        FeatureUtil.X(FeatureOption.i());
        WashManager.f14100a.h(this);
        com.android.contacts.framework.api.appstore.application.a.a(context, this);
        n();
        FeatureOption.f(context);
        VirtualSupportUtils.f(this);
        StartupSpeedHelper.P(context, this.f13101g);
        if (C7.b.b()) {
            V8.a.a(this);
        } else {
            S6.a.a(this);
        }
        C1521a.a();
        C1641a.g(this);
    }

    public final void f() {
        com.android.contacts.framework.api.businesshall.a.a(new InterfaceC1637a() { // from class: com.android.contacts.t
            @Override // v9.InterfaceC1637a
            public final Object invoke() {
                return Boolean.valueOf(FeatureOption.g());
            }
        });
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ContentResolver getContentResolver() {
        return super.getContentResolver();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i10) {
        return super.getSharedPreferences(str, i10);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("contactAccountTypes".equals(str)) {
            if (this.f13095a == null) {
                try {
                    this.f13095a = AbstractC1362a.b(this);
                } catch (Throwable th) {
                    Log.e("ContactsApplication", "Throwable when getSystemService " + th);
                }
            }
            return this.f13095a;
        }
        if ("contactPhotos".equals(str)) {
            if (this.f13096b == null) {
                Z0.b c10 = Z0.b.c(this);
                this.f13096b = c10;
                registerComponentCallbacks(c10);
                if (com.customize.contacts.util.U.d()) {
                    this.f13096b.s();
                }
            }
            return this.f13096b;
        }
        if ("contactListFilter".equals(str)) {
            if (this.f13097c == null) {
                this.f13097c = AbstractC1316l.d(this);
            }
            return this.f13097c;
        }
        return super.getSystemService(str);
    }

    public final void j() {
        onLowMemory();
        SQLiteDatabase.releaseMemory();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x002d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(android.content.Context r8) {
        /*
            r7 = this;
            java.lang.String r0 = "ContactsApplication"
            g(r8)
            boolean r1 = P7.e.d(r8)     // Catch: java.lang.Throwable -> L14
            if (r1 == 0) goto L2a
            android.preference.PreferenceManager.getDefaultSharedPreferences(r8)     // Catch: java.lang.Throwable -> L12
            com.customize.contacts.simcontacts.b.k(r8)     // Catch: java.lang.Throwable -> L12
            goto L2a
        L12:
            r2 = move-exception
            goto L16
        L14:
            r2 = move-exception
            r1 = 0
        L16:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "excpetion "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            H7.b.c(r0, r2)
        L2a:
            r2 = 0
            if (r1 == 0) goto L91
            boolean r3 = com.android.contacts.activities.RequestPermissionsActivityBase.e2(r8)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            if (r3 == 0) goto L3b
            java.lang.AutoCloseable[] r7 = new java.lang.AutoCloseable[]{r2}
            com.oplus.foundation.util.io.CloseableUtils.a(r7)
            return
        L3b:
            android.os.Bundle r3 = new android.os.Bundle     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            r3.<init>()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            android.os.Binder r4 = new android.os.Binder     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            r4.<init>()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            java.lang.String r5 = "appication_calling_pid_binder"
            r3.putBinder(r5, r4)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            android.content.ContentResolver r7 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            android.net.Uri r4 = android.provider.ContactsContract.AUTHORITY_URI     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            android.content.ContentProviderClient r7 = r7.acquireUnstableContentProviderClient(r4)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            if (r7 == 0) goto L65
            java.lang.String r4 = r4.getAuthority()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            java.lang.String r5 = "appication_calling_pid"
            r7.call(r4, r5, r2, r3)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            goto L65
        L60:
            r8 = move-exception
            r2 = r7
            goto L89
        L63:
            r2 = move-exception
            goto L6d
        L65:
            r2 = r7
            goto L91
        L67:
            r8 = move-exception
            goto L89
        L69:
            r7 = move-exception
            r6 = r2
            r2 = r7
            r7 = r6
        L6d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60
            r3.<init>()     // Catch: java.lang.Throwable -> L60
            java.lang.String r4 = "Exception in call ContactsProvider "
            r3.append(r4)     // Catch: java.lang.Throwable -> L60
            r3.append(r2)     // Catch: java.lang.Throwable -> L60
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> L60
            H7.b.c(r0, r2)     // Catch: java.lang.Throwable -> L60
            java.lang.AutoCloseable[] r7 = new java.lang.AutoCloseable[]{r7}
            com.oplus.foundation.util.io.CloseableUtils.a(r7)
            goto L98
        L89:
            java.lang.AutoCloseable[] r7 = new java.lang.AutoCloseable[]{r2}
            com.oplus.foundation.util.io.CloseableUtils.a(r7)
            throw r8
        L91:
            java.lang.AutoCloseable[] r7 = new java.lang.AutoCloseable[]{r2}
            com.oplus.foundation.util.io.CloseableUtils.a(r7)
        L98:
            if (r1 == 0) goto Lc7
            boolean r7 = com.customize.contacts.StatisticsService.d(r8)     // Catch: java.lang.Exception -> Lb2
            if (r7 == 0) goto Lc7
            boolean r7 = com.android.contacts.activities.RequestPermissionsActivityBase.e2(r8)     // Catch: java.lang.Exception -> Lb2
            if (r7 == 0) goto La7
            return
        La7:
            android.content.Intent r7 = new android.content.Intent     // Catch: java.lang.Exception -> Lb2
            java.lang.Class<com.customize.contacts.StatisticsService> r2 = com.customize.contacts.StatisticsService.class
            r7.<init>(r8, r2)     // Catch: java.lang.Exception -> Lb2
            r8.startService(r7)     // Catch: java.lang.Exception -> Lb2
            goto Lc7
        Lb2:
            r7 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "start StatisticsService error "
            r2.append(r3)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            H7.b.c(r0, r7)
        Lc7:
            if (r1 == 0) goto Lcd
            r7 = 1
            com.customize.contacts.util.Y.c(r8, r7)
        Lcd:
            com.android.contacts.util.x.c(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.ContactsApplication.k(android.content.Context):void");
    }

    public final void l(Context context) {
        String[] strArr;
        com.android.contacts.framework.baseui.util.p.f15955b = B3.a.J();
        C0794e.g(context);
        C0637b.b().g();
        try {
            H7.a.a(context);
        } catch (Exception e10) {
            H7.b.c("ContactsApplication", "Exception in ContactLogUtil.init " + e10);
        }
        try {
            com.customize.contacts.util.j0.b();
        } catch (Exception e11) {
            H7.b.c("ContactsApplication", "Exception in getAsciiTransliterator " + e11);
        }
        try {
            C7.c.b(context).a();
        } catch (Exception e12) {
            H7.b.c("ContactsApplication", "Exception in getCurrentCountryIso.init " + e12);
        }
        if (B3.a.M(context)) {
            try {
                if (OsUtils.k()) {
                    strArr = new String[]{"android.permission.READ_CONTACTS"};
                } else {
                    strArr = new String[]{"android.permission.READ_CONTACTS", "android.permission.READ_EXTERNAL_STORAGE"};
                }
                com.android.contacts.framework.api.rcs.a.d(context, com.android.contacts.util.w.l(context, strArr));
            } catch (Throwable th) {
                H7.b.c("ContactsApplication", "doInBackground: " + th);
            }
        }
        try {
            com.android.contacts.framework.baseui.util.A.e(this);
        } catch (Exception e13) {
            H7.b.c("ContactsApplication", "start statisticsInit error " + e13);
        }
        if (B3.a.r() && P7.e.d(context)) {
            com.customize.contacts.util.V.b(this);
        }
    }

    public final void m() {
        Trace.beginSection("initCloudKit");
        H7.b.e("ContactsApplication", "initCloudkitSync: support: " + com.android.contacts.framework.api.cloudsync.a.f(this, com.android.contacts.compat.data.f.c("local"), com.android.contacts.compat.data.f.c("com.android.local"), C1498a.f36254m, R0.b.f3175i, FeatureOption.i()));
        Trace.endSection();
    }

    public final void n() {
        com.android.contacts.compat.data.e.f14111c.b(new r0.j());
        com.android.contacts.compat.data.c.f14105a.b(new r0.h());
        com.android.contacts.compat.data.d.f14108b.b(new r0.i());
    }

    public final /* synthetic */ boolean o() {
        ContactsTabActivity contactsTabActivity;
        if (B3.a.b0()) {
            m();
            return false;
        }
        WeakReference<ContactsTabActivity> weakReference = this.f13099e;
        if (weakReference != null) {
            contactsTabActivity = weakReference.get();
        } else {
            contactsTabActivity = null;
        }
        if (contactsTabActivity != null && contactsTabActivity.B2()) {
            ThreadUtilsKt.a().postDelayed(new Runnable() { // from class: com.android.contacts.s
                @Override // java.lang.Runnable
                public final void run() {
                    ContactsApplication.this.m();
                }
            }, 250L);
            return false;
        }
        m();
        return false;
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.android.contacts.framework.api.appstore.application.a.c(configuration);
        boolean z10 = true;
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) {
            z10 = false;
        }
        f13094j = z10;
        com.android.contacts.framework.api.appstore.application.a.e(z10);
    }

    @Override // android.app.Application
    public void onCreate() {
        com.android.contacts.framework.api.appstore.application.a.d(this);
        H7.b.b("ContactsApplication", "ContactsApplication.onCreate start");
        super.onCreate();
        CommonFeatureOption.i(new InterfaceC1637a() { // from class: com.android.contacts.p
            @Override // v9.InterfaceC1637a
            public final Object invoke() {
                return Boolean.valueOf(B3.a.V());
            }
        });
        com.android.contacts.framework.baseui.util.A.f(this);
        boolean z10 = false;
        f13092h = false;
        A7.a.b(getResources().getBoolean(R.bool.is_immersive_theme));
        com.customize.contacts.util.Z.a(this);
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            z10 = true;
        }
        f13094j = z10;
        com.android.contacts.framework.api.appstore.application.a.e(z10);
        H7.b.b("ContactsApplication", "ContactsApplication.onCreate end");
        this.f13100f.c(this);
        if (FeatureOption.o()) {
            C1643c.r(this);
            if (C1643c.w()) {
                C1643c.s(this);
            }
        }
        Looper.getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.android.contacts.q
            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                boolean o10;
                o10 = ContactsApplication.this.o();
                return o10;
            }
        });
        N7.a.b().execute(new Runnable() { // from class: com.android.contacts.r
            @Override // java.lang.Runnable
            public final void run() {
                ContactsApplication.this.p();
            }
        });
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        super.onTrimMemory(i10);
        H7.b.b("ContactsApplication", "ContactsApplication onTrimMemory level = " + i10);
        if (i10 >= 80) {
            j();
        }
    }

    public final /* synthetic */ void p() {
        if (FeatureOption.i()) {
            try {
                f();
            } catch (Throwable th) {
                H7.b.c("ContactsApplication", "asyncInitBusinessHallIfNeed error " + th);
            }
        }
        if (M7.d.d("sys.oplus.boot_completed", 0) == 1) {
            GrpcUtils.initGrpcProvider(this, GrpcUtils.getOperationCallBack());
        }
        if (FeatureOption.i() && com.android.contacts.framework.api.satellite.a.b()) {
            com.android.contacts.framework.api.satellite.a.a(this);
        }
        try {
            this.f13098d.await(1L, TimeUnit.SECONDS);
        } catch (Exception e10) {
            H7.b.b("ContactsApplication", "ContactsApplication waitActivityStart e = " + e10);
        }
        k(this);
        t();
        l(this);
        RecordingSummaryUpdatedReceiver.a(this);
        FeatureOption.q();
        OSPublicFeature.G();
        OSCustomizeFeature.J();
    }

    public final void q() {
        DebugStatusChangeReceiver debugStatusChangeReceiver = new DebugStatusChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("contact.log.switch.broadcast");
        intentFilter.addAction("dialer.log.switch.broadcast");
        registerReceiver(debugStatusChangeReceiver, intentFilter, R0.b.f3175i, null, 2);
    }

    public final void r() {
        b bVar = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        registerReceiver(bVar, intentFilter, R0.b.f3175i, null, 2);
    }

    public final void s() {
        if (C1643c.q() || !B3.a.W()) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        registerReceiver(new a(), intentFilter, 2);
    }

    public final void t() {
        try {
            com.android.contacts.framework.baseui.util.n.a(getApplicationContext());
            com.android.contacts.framework.baseui.util.o.d(getApplicationContext());
            AppFeatureProviderUtils.s(getContentResolver(), true, new d());
            r();
            q();
            u();
            s();
            v();
            com.android.contacts.framework.baseui.calllog.utils.a.d(getApplicationContext());
        } catch (Exception e10) {
            H7.b.c("ContactsApplication", "Exception when registerContentObserver for app feature " + e10);
        }
    }

    public final void u() {
        RegionChangeReceiver regionChangeReceiver = new RegionChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(C1498a.f36267z);
        registerReceiver(regionChangeReceiver, intentFilter, R0.b.f3175i, null, 2);
    }

    public final void v() {
        RomUpdateReceiver romUpdateReceiver = new RomUpdateReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(C1498a.f36248g);
        intentFilter.addAction(C1498a.f36247f);
        try {
            registerReceiver(romUpdateReceiver, intentFilter, R0.b.f3175i, null, 2);
        } catch (Exception e10) {
            H7.b.c("ContactsApplication", "registRomupdateReceiver error " + e10);
        }
    }

    public void w(ContactsTabActivity contactsTabActivity) {
        this.f13099e = new WeakReference<>(contactsTabActivity);
    }

    public void x(Context context) {
        try {
            if (P7.e.d(context)) {
                this.f13095a = AbstractC1362a.b(this);
            }
        } catch (Throwable th) {
            H7.b.c("ContactsApplication", "updateAccountTypeManager error " + th);
        }
    }
}
