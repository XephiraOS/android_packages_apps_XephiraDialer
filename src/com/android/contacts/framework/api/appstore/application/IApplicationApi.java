package com.android.contacts.framework.api.appstore.application;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: IApplicationApi.kt */
/* loaded from: classes.dex */
public interface IApplicationApi {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f15531a = Companion.f15532a;

    /* compiled from: IApplicationApi.kt */
    /* loaded from: classes.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f15532a = new Companion();

        /* renamed from: b, reason: collision with root package name */
        public static final d<IApplicationApi> f15533b;

        static {
            d<IApplicationApi> b10;
            b10 = kotlin.a.b(new InterfaceC1637a<IApplicationApi>() { // from class: com.android.contacts.framework.api.appstore.application.IApplicationApi$Companion$instance$2
                @Override // v9.InterfaceC1637a
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final IApplicationApi invoke() {
                    return (IApplicationApi) A8.a.f202a.a(IApplicationApi.class);
                }
            });
            f15533b = b10;
        }

        public final IApplicationApi a() {
            return f15533b.getValue();
        }
    }

    void a(Application application);

    void b(Context context, Application application);

    void onConfigurationChanged(Configuration configuration);
}
