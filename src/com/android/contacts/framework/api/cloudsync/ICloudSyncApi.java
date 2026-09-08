package com.android.contacts.framework.api.cloudsync;

import android.app.Application;
import android.content.Context;
import kotlinx.coroutines.E;
import kotlinx.coroutines.InterfaceC1265l0;
import v9.InterfaceC1637a;

/* compiled from: ICloudSyncApi.kt */
/* loaded from: classes.dex */
public interface ICloudSyncApi {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f15567a = Companion.f15568a;

    /* compiled from: ICloudSyncApi.kt */
    /* loaded from: classes.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f15568a = new Companion();

        /* renamed from: b, reason: collision with root package name */
        public static final m9.d<ICloudSyncApi> f15569b;

        static {
            m9.d<ICloudSyncApi> b10;
            b10 = kotlin.a.b(new InterfaceC1637a<ICloudSyncApi>() { // from class: com.android.contacts.framework.api.cloudsync.ICloudSyncApi$Companion$instance$2
                @Override // v9.InterfaceC1637a
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final ICloudSyncApi invoke() {
                    return (ICloudSyncApi) A8.a.f202a.a(ICloudSyncApi.class);
                }
            });
            f15569b = b10;
        }

        public final ICloudSyncApi a() {
            return f15569b.getValue();
        }
    }

    /* compiled from: ICloudSyncApi.kt */
    /* loaded from: classes.dex */
    public interface a {
    }

    /* compiled from: ICloudSyncApi.kt */
    /* loaded from: classes.dex */
    public interface b {
    }

    /* compiled from: ICloudSyncApi.kt */
    /* loaded from: classes.dex */
    public interface c {
    }

    /* compiled from: ICloudSyncApi.kt */
    /* loaded from: classes.dex */
    public interface d {
    }

    void a(boolean z10);

    D0.a b();

    void c(Context context, int i10);

    InterfaceC1265l0 d(String str, E e10, Runnable runnable);

    void e(d dVar);

    void f(d dVar);

    boolean g();

    c h();

    void i(Context context, boolean z10);

    b j();

    a k();

    boolean l();

    boolean m(Application application, String str, String str2, String str3, String str4, boolean z10);
}
