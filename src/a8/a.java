package A8;

import C9.c;
import java.util.HashMap;
import kotlin.jvm.internal.i;
import u9.C1614a;
import v9.InterfaceC1637a;

/* compiled from: DecouplingCenter.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f202a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap<c<?>, Object> f203b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public static final HashMap<c<?>, InterfaceC1637a<?>> f204c = new HashMap<>();

    public final <INSTANCE> INSTANCE a(Class<INSTANCE> clazz) {
        i.f(clazz, "clazz");
        Object obj = f203b.get(C1614a.c(clazz));
        if (obj == null) {
            obj = null;
        }
        if (obj == null) {
            InterfaceC1637a<?> interfaceC1637a = f204c.get(C1614a.c(clazz));
            if (interfaceC1637a == null) {
                obj = null;
            } else {
                obj = interfaceC1637a.invoke();
            }
            if (obj == null) {
                return null;
            }
        }
        return (INSTANCE) obj;
    }

    public final HashMap<c<?>, Object> b() {
        return f203b;
    }

    public final HashMap<c<?>, InterfaceC1637a<?>> c() {
        return f204c;
    }
}
