package com.android.contacts.framework.api.appstore.sau;

import android.content.Context;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: ISauApi.kt */
/* loaded from: classes.dex */
public interface ISauApi {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f15544a = Companion.f15545a;

    /* compiled from: ISauApi.kt */
    /* loaded from: classes.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f15545a = new Companion();

        /* renamed from: b, reason: collision with root package name */
        public static final d<ISauApi> f15546b;

        static {
            d<ISauApi> b10;
            b10 = kotlin.a.b(new InterfaceC1637a<ISauApi>() { // from class: com.android.contacts.framework.api.appstore.sau.ISauApi$Companion$instance$2
                @Override // v9.InterfaceC1637a
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final ISauApi invoke() {
                    return (ISauApi) A8.a.f202a.a(ISauApi.class);
                }
            });
            f15546b = b10;
        }

        public final ISauApi a() {
            return f15546b.getValue();
        }
    }

    void a(Context context);
}
