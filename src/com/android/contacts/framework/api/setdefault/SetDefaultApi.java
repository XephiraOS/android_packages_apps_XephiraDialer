package com.android.contacts.framework.api.setdefault;

import android.app.Activity;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: SetDefaultApi.kt */
/* loaded from: classes.dex */
public interface SetDefaultApi {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f15612a = Companion.f15613a;

    /* compiled from: SetDefaultApi.kt */
    /* loaded from: classes.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f15613a = new Companion();

        /* renamed from: b, reason: collision with root package name */
        public static final d<SetDefaultApi> f15614b;

        static {
            d<SetDefaultApi> b10;
            b10 = kotlin.a.b(new InterfaceC1637a<SetDefaultApi>() { // from class: com.android.contacts.framework.api.setdefault.SetDefaultApi$Companion$instance$2
                @Override // v9.InterfaceC1637a
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final SetDefaultApi invoke() {
                    return (SetDefaultApi) A8.a.f202a.a(SetDefaultApi.class);
                }
            });
            f15614b = b10;
        }

        public final SetDefaultApi a() {
            return f15614b.getValue();
        }
    }

    boolean a(Activity activity);

    void b(Activity activity);
}
