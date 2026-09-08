package kotlinx.coroutines;

/* compiled from: JobSupport.kt */
/* loaded from: classes4.dex */
public final class t0 {

    /* renamed from: a, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.C f34635a = new kotlinx.coroutines.internal.C("COMPLETING_ALREADY");

    /* renamed from: b, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.C f34636b = new kotlinx.coroutines.internal.C("COMPLETING_WAITING_CHILDREN");

    /* renamed from: c, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.C f34637c = new kotlinx.coroutines.internal.C("COMPLETING_RETRY");

    /* renamed from: d, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.C f34638d = new kotlinx.coroutines.internal.C("TOO_LATE_TO_CANCEL");

    /* renamed from: e, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.C f34639e = new kotlinx.coroutines.internal.C("SEALED");

    /* renamed from: f, reason: collision with root package name */
    public static final V f34640f = new V(false);

    /* renamed from: g, reason: collision with root package name */
    public static final V f34641g = new V(true);

    public static final Object g(Object obj) {
        if (obj instanceof InterfaceC1245g0) {
            return new C1247h0((InterfaceC1245g0) obj);
        }
        return obj;
    }

    public static final Object h(Object obj) {
        C1247h0 c1247h0;
        InterfaceC1245g0 interfaceC1245g0;
        if (obj instanceof C1247h0) {
            c1247h0 = (C1247h0) obj;
        } else {
            c1247h0 = null;
        }
        if (c1247h0 != null && (interfaceC1245g0 = c1247h0.f34476a) != null) {
            return interfaceC1245g0;
        }
        return obj;
    }
}
