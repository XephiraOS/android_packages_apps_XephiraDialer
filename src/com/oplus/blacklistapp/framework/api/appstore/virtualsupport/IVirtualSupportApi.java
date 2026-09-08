package com.oplus.blacklistapp.framework.api.appstore.virtualsupport;

import android.content.Context;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: IVirtualSupportApi.kt */
/* loaded from: classes3.dex */
public interface IVirtualSupportApi {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f27222a = Companion.f27223a;

    /* compiled from: IVirtualSupportApi.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f27223a = new Companion();

        /* renamed from: b, reason: collision with root package name */
        public static final d<IVirtualSupportApi> f27224b;

        static {
            d<IVirtualSupportApi> b10;
            b10 = kotlin.a.b(new InterfaceC1637a<IVirtualSupportApi>() { // from class: com.oplus.blacklistapp.framework.api.appstore.virtualsupport.IVirtualSupportApi$Companion$instance$2
                @Override // v9.InterfaceC1637a
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final IVirtualSupportApi invoke() {
                    return (IVirtualSupportApi) A8.a.f202a.a(IVirtualSupportApi.class);
                }
            });
            f27224b = b10;
        }

        public final IVirtualSupportApi a() {
            return f27224b.getValue();
        }
    }

    void init(Context context);
}
