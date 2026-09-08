package com.oplus.blacklistapp.framework.api.sync;

import android.app.Application;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: ISyncCompatApi.kt */
/* loaded from: classes3.dex */
public interface ISyncCompatApi {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f27230a = Companion.f27231a;

    /* compiled from: ISyncCompatApi.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f27231a = new Companion();

        /* renamed from: b, reason: collision with root package name */
        public static final d<ISyncCompatApi> f27232b;

        static {
            d<ISyncCompatApi> b10;
            b10 = kotlin.a.b(new InterfaceC1637a<ISyncCompatApi>() { // from class: com.oplus.blacklistapp.framework.api.sync.ISyncCompatApi$Companion$instance$2
                @Override // v9.InterfaceC1637a
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final ISyncCompatApi invoke() {
                    return (ISyncCompatApi) A8.a.f202a.a(ISyncCompatApi.class);
                }
            });
            f27232b = b10;
        }

        public final ISyncCompatApi a() {
            return f27232b.getValue();
        }
    }

    boolean a();

    String b();

    void c();

    boolean d();

    boolean e(String str);

    void f();

    void g(Application application, boolean z10);
}
