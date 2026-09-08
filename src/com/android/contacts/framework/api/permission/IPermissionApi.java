package com.android.contacts.framework.api.permission;

import java.util.List;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: IPermissionApi.kt */
/* loaded from: classes.dex */
public interface IPermissionApi {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f15591a = Companion.f15592a;

    /* compiled from: IPermissionApi.kt */
    /* loaded from: classes.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f15592a = new Companion();

        /* renamed from: b, reason: collision with root package name */
        public static final d<IPermissionApi> f15593b;

        static {
            d<IPermissionApi> b10;
            b10 = kotlin.a.b(new InterfaceC1637a<IPermissionApi>() { // from class: com.android.contacts.framework.api.permission.IPermissionApi$Companion$instance$2
                @Override // v9.InterfaceC1637a
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final IPermissionApi invoke() {
                    return (IPermissionApi) A8.a.f202a.a(IPermissionApi.class);
                }
            });
            f15593b = b10;
        }

        public final IPermissionApi a() {
            return f15593b.getValue();
        }
    }

    List<String> a();

    boolean b();
}
