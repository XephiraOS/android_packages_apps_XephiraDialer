package com.oplus.blacklistapp.framework.api.appstore.appinfo;

import m9.d;
import m9.e;
import v9.InterfaceC1637a;

/* compiled from: IAppInfoCompatApi.kt */
/* loaded from: classes3.dex */
public interface IAppInfoCompatApi {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f27206a = Companion.f27207a;

    /* compiled from: IAppInfoCompatApi.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f27207a = new Companion();

        /* renamed from: b, reason: collision with root package name */
        public static final d<IAppInfoCompatApi> f27208b = e.b(new InterfaceC1637a<IAppInfoCompatApi>() { // from class: com.oplus.blacklistapp.framework.api.appstore.appinfo.IAppInfoCompatApi$Companion$instance$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final IAppInfoCompatApi invoke() {
                return (IAppInfoCompatApi) A8.a.f202a.a(IAppInfoCompatApi.class);
            }
        });

        public final IAppInfoCompatApi a() {
            return f27208b.getValue();
        }
    }

    String a();

    String b();

    String c();

    boolean d(String str);

    String e();
}
