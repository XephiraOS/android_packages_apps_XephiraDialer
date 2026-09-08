package com.android.contacts.framework.api.appstore.missedcall;

import android.content.Context;
import android.os.Bundle;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: IMissedCallApi.kt */
/* loaded from: classes.dex */
public interface IMissedCallApi {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f15538a = Companion.f15539a;

    /* compiled from: IMissedCallApi.kt */
    /* loaded from: classes.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f15539a = new Companion();

        /* renamed from: b, reason: collision with root package name */
        public static final d<IMissedCallApi> f15540b;

        static {
            d<IMissedCallApi> b10;
            b10 = kotlin.a.b(new InterfaceC1637a<IMissedCallApi>() { // from class: com.android.contacts.framework.api.appstore.missedcall.IMissedCallApi$Companion$instance$2
                @Override // v9.InterfaceC1637a
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final IMissedCallApi invoke() {
                    return (IMissedCallApi) A8.a.f202a.a(IMissedCallApi.class);
                }
            });
            f15540b = b10;
        }

        public final IMissedCallApi a() {
            return f15540b.getValue();
        }
    }

    void a(Context context);

    void b(Context context, Bundle bundle);
}
