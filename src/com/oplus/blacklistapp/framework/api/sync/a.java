package com.oplus.blacklistapp.framework.api.sync;

import android.app.Application;
import kotlin.jvm.internal.i;

/* compiled from: SyncCompat.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f27234a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final ISyncCompatApi f27235b = ISyncCompatApi.f27230a.a();

    public static final void a() {
        ISyncCompatApi iSyncCompatApi = f27235b;
        if (iSyncCompatApi != null) {
            iSyncCompatApi.f();
        }
    }

    public static final String b() {
        ISyncCompatApi iSyncCompatApi = f27235b;
        if (iSyncCompatApi != null) {
            return iSyncCompatApi.b();
        }
        return null;
    }

    public static final void d() {
        ISyncCompatApi iSyncCompatApi = f27235b;
        if (iSyncCompatApi != null) {
            iSyncCompatApi.c();
        }
    }

    public static final boolean e() {
        ISyncCompatApi iSyncCompatApi = f27235b;
        if (iSyncCompatApi != null) {
            return iSyncCompatApi.d();
        }
        return false;
    }

    public static final boolean f(String accountId) {
        i.f(accountId, "accountId");
        ISyncCompatApi iSyncCompatApi = f27235b;
        if (iSyncCompatApi != null) {
            return iSyncCompatApi.e(accountId);
        }
        return false;
    }

    public static final boolean g() {
        ISyncCompatApi iSyncCompatApi = f27235b;
        if (iSyncCompatApi != null) {
            return iSyncCompatApi.a();
        }
        return false;
    }

    public final void c(Application application, boolean z10) {
        i.f(application, "application");
        ISyncCompatApi iSyncCompatApi = f27235b;
        if (iSyncCompatApi != null) {
            iSyncCompatApi.g(application, z10);
        }
    }
}
