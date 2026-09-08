package com.oplus.contacts.list.viewmodel;

import L7.a;
import a7.C0424a;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import androidx.lifecycle.I;
import androidx.lifecycle.J;
import kotlin.Result;
import kotlin.jvm.internal.f;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.S;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.m;
import kotlinx.coroutines.flow.n;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: ImportContactsTipsViewModel.kt */
/* loaded from: classes3.dex */
public final class ImportContactsTipsViewModel extends I implements a.InterfaceC0040a {

    /* renamed from: g, reason: collision with root package name */
    public static final a f28098g = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public final d f28099d;

    /* renamed from: e, reason: collision with root package name */
    public i<C0424a> f28100e;

    /* renamed from: f, reason: collision with root package name */
    public final m<C0424a> f28101f;

    /* compiled from: ImportContactsTipsViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public ImportContactsTipsViewModel() {
        d b10;
        b10 = kotlin.a.b(new InterfaceC1637a<Context>() { // from class: com.oplus.contacts.list.viewmodel.ImportContactsTipsViewModel$appContext$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Context invoke() {
                return P7.a.f2961a.a();
            }
        });
        this.f28099d = b10;
        i<C0424a> a10 = n.a(new C0424a(false, new C0424a.C0094a(null, L7.a.c())));
        this.f28100e = a10;
        this.f28101f = a10;
        if (!com.android.contacts.framework.api.appstore.appinfo.a.k()) {
            L7.a.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context k() {
        return (Context) this.f28099d.getValue();
    }

    public static final void o(ImportContactsTipsViewModel this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        C1248i.d(J.a(this$0), S.b(), null, new ImportContactsTipsViewModel$updateCloudSyncState$1$1(this$0, null), 2, null);
    }

    @Override // L7.a.InterfaceC0040a
    public void a(boolean z10) {
        C1248i.d(J.a(this), S.b(), null, new ImportContactsTipsViewModel$onModeChanged$1(this, z10, null), 2, null);
    }

    @Override // androidx.lifecycle.I
    public void e() {
        super.e();
        if (!com.android.contacts.framework.api.appstore.appinfo.a.k()) {
            L7.a.e(this);
        }
    }

    public final String l(String str) {
        PackageManager packageManager = k().getPackageManager();
        try {
            Result.a aVar = Result.f34166a;
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
            kotlin.jvm.internal.i.e(applicationInfo, "pkgManager.getApplicationInfo(pkgName, 0)");
            return applicationInfo.loadLabel(packageManager).toString();
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            Result.b(kotlin.b.a(th));
            return null;
        }
    }

    public final m<C0424a> m() {
        return this.f28101f;
    }

    public final void n() {
        com.android.contacts.framework.api.cloudsync.a.a("ImportContactsTipsViewModel updateCloudSyncState", J.a(this), new Runnable() { // from class: com.oplus.contacts.list.viewmodel.b
            @Override // java.lang.Runnable
            public final void run() {
                ImportContactsTipsViewModel.o(ImportContactsTipsViewModel.this);
            }
        });
    }

    public final void p(String pkgName) {
        kotlin.jvm.internal.i.f(pkgName, "pkgName");
        if (!com.android.contacts.framework.api.appstore.appinfo.a.k()) {
            this.f28100e.getValue().d();
            C1248i.d(J.a(this), S.b(), null, new ImportContactsTipsViewModel$updatePhoneCloneLabel$1$1(this, pkgName, null), 2, null);
        }
    }
}
