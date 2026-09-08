package com.android.contacts.framework.api.cloudsync;

import android.app.Application;
import android.content.Context;
import com.android.contacts.framework.api.cloudsync.ICloudSyncApi;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.E;
import kotlinx.coroutines.InterfaceC1265l0;

/* compiled from: ContactsSyncManager.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15575a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final ICloudSyncApi f15576b = ICloudSyncApi.f15567a.a();

    public static final InterfaceC1265l0 a(String str, E e10, Runnable runnable) {
        ICloudSyncApi iCloudSyncApi = f15576b;
        if (iCloudSyncApi == null) {
            if (runnable != null) {
                runnable.run();
            }
            return null;
        }
        return iCloudSyncApi.d(str, e10, runnable);
    }

    public static final ICloudSyncApi.a b() {
        ICloudSyncApi iCloudSyncApi = f15576b;
        if (iCloudSyncApi != null) {
            iCloudSyncApi.k();
            return null;
        }
        return null;
    }

    public static final ICloudSyncApi.b c() {
        ICloudSyncApi iCloudSyncApi = f15576b;
        if (iCloudSyncApi != null) {
            iCloudSyncApi.j();
            return null;
        }
        return null;
    }

    public static final D0.a d() {
        ICloudSyncApi iCloudSyncApi = f15576b;
        if (iCloudSyncApi != null) {
            iCloudSyncApi.b();
            return null;
        }
        return null;
    }

    public static final ICloudSyncApi.c e() {
        ICloudSyncApi iCloudSyncApi = f15576b;
        if (iCloudSyncApi != null) {
            iCloudSyncApi.h();
            return null;
        }
        return null;
    }

    public static final boolean f(Application application, String str, String str2, String str3, String str4, boolean z10) {
        ICloudSyncApi iCloudSyncApi = f15576b;
        if (iCloudSyncApi != null) {
            return iCloudSyncApi.m(application, str, str2, str3, str4, z10);
        }
        return false;
    }

    public static final boolean g() {
        ICloudSyncApi iCloudSyncApi = f15576b;
        if (iCloudSyncApi != null) {
            return iCloudSyncApi.g();
        }
        return false;
    }

    public static final boolean h() {
        ICloudSyncApi iCloudSyncApi = f15576b;
        if (iCloudSyncApi != null) {
            return iCloudSyncApi.l();
        }
        return true;
    }

    public static final void i(Context context, boolean z10) {
        i.f(context, "context");
        ICloudSyncApi iCloudSyncApi = f15576b;
        if (iCloudSyncApi != null) {
            iCloudSyncApi.i(context, z10);
        }
    }

    public static final void j(ICloudSyncApi.d syncListener) {
        i.f(syncListener, "syncListener");
        ICloudSyncApi iCloudSyncApi = f15576b;
        if (iCloudSyncApi != null) {
            iCloudSyncApi.e(syncListener);
        }
    }

    public static final void k(boolean z10) {
        ICloudSyncApi iCloudSyncApi = f15576b;
        if (iCloudSyncApi != null) {
            iCloudSyncApi.a(z10);
        }
    }

    public static final void l(Context context, int i10) {
        i.f(context, "context");
        ICloudSyncApi iCloudSyncApi = f15576b;
        if (iCloudSyncApi != null) {
            iCloudSyncApi.c(context, i10);
        }
    }

    public static final void m(ICloudSyncApi.d syncListener) {
        i.f(syncListener, "syncListener");
        ICloudSyncApi iCloudSyncApi = f15576b;
        if (iCloudSyncApi != null) {
            iCloudSyncApi.f(syncListener);
        }
    }
}
