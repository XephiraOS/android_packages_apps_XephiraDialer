package B8;

import com.android.contacts.framework.api.setdefault.SetDefaultApi;
import com.oplus.contacts.config.defaultdialer.SetDefaultProviderKt;
import java.util.HashMap;
import kotlin.collections.E;
import kotlin.jvm.internal.k;
import v9.InterfaceC1637a;

/* compiled from: DecouplingAutoGenerate_providerSetDefaultApi.kt */
/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final a f282a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap<C9.c<?>, InterfaceC1637a<?>> f283b;

    /* compiled from: DecouplingAutoGenerate_providerSetDefaultApi.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public final HashMap<C9.c<?>, InterfaceC1637a<?>> a() {
            return i.f283b;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    static {
        HashMap<C9.c<?>, InterfaceC1637a<?>> e10;
        e10 = E.e(m9.g.a(k.b(SetDefaultApi.class), SetDefaultProviderKt.a()));
        f283b = e10;
    }
}
