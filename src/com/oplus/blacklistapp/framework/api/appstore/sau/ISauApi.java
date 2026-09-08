package com.oplus.blacklistapp.framework.api.appstore.sau;

import android.content.Context;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: ISauApi.kt */
/* loaded from: classes3.dex */
public interface ISauApi {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f27212a = Companion.f27213a;

    /* compiled from: ISauApi.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f27213a = new Companion();

        /* renamed from: b, reason: collision with root package name */
        public static final d<ISauApi> f27214b;

        static {
            d<ISauApi> b10;
            b10 = kotlin.a.b(new InterfaceC1637a<ISauApi>() { // from class: com.oplus.blacklistapp.framework.api.appstore.sau.ISauApi$Companion$instance$2
                @Override // v9.InterfaceC1637a
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final ISauApi invoke() {
                    return (ISauApi) A8.a.f202a.a(ISauApi.class);
                }
            });
            f27214b = b10;
        }

        public final ISauApi a() {
            return f27214b.getValue();
        }
    }

    void a(Context context);
}
