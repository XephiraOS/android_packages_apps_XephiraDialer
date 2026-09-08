package B8;

import com.android.contacts.framework.api.appstore.appinfo.IAppInfoCompatApi;
import com.android.contacts.framework.api.appstore.application.IApplicationApi;
import com.android.contacts.framework.api.appstore.missedcall.IMissedCallApi;
import com.android.contacts.framework.api.appstore.simcard.ISimCardApi;
import com.android.contacts.framework.api.permission.IPermissionApi;
import com.android.contacts.framework.appstore.AppStoreProviderKt;
import java.util.HashMap;
import kotlin.collections.E;
import kotlin.jvm.internal.k;
import v9.InterfaceC1637a;

/* compiled from: DecouplingAutoGenerate_providerInfoCompatApi_providerApplicationApi_providerSimCardApi_providerPermissionApi.kt */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final a f274a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap<C9.c<?>, InterfaceC1637a<?>> f275b;

    /* compiled from: DecouplingAutoGenerate_providerInfoCompatApi_providerApplicationApi_providerSimCardApi_providerPermissionApi.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public final HashMap<C9.c<?>, InterfaceC1637a<?>> a() {
            return e.f275b;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    static {
        HashMap<C9.c<?>, InterfaceC1637a<?>> e10;
        e10 = E.e(m9.g.a(k.b(IAppInfoCompatApi.class), AppStoreProviderKt.b()), m9.g.a(k.b(IApplicationApi.class), AppStoreProviderKt.a()), m9.g.a(k.b(ISimCardApi.class), AppStoreProviderKt.e()), m9.g.a(k.b(IPermissionApi.class), AppStoreProviderKt.d()), m9.g.a(k.b(IMissedCallApi.class), AppStoreProviderKt.c()));
        f275b = e10;
    }
}
