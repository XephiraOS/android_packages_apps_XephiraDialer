package B8;

import com.android.contacts.framework.api.rcs.IRcsApi;
import com.android.contacts.framework.rcs.RcsApiProviderKt;
import java.util.HashMap;
import kotlin.collections.E;
import kotlin.jvm.internal.k;
import v9.InterfaceC1637a;

/* compiled from: DecouplingAutoGenerate_providerRcsApi.kt */
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final a f280a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap<C9.c<?>, InterfaceC1637a<?>> f281b;

    /* compiled from: DecouplingAutoGenerate_providerRcsApi.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public final HashMap<C9.c<?>, InterfaceC1637a<?>> a() {
            return h.f281b;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    static {
        HashMap<C9.c<?>, InterfaceC1637a<?>> e10;
        e10 = E.e(m9.g.a(k.b(IRcsApi.class), RcsApiProviderKt.a()));
        f281b = e10;
    }
}
