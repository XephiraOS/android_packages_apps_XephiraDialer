package R5;

import kotlin.jvm.internal.k;
import v9.InterfaceC1637a;

/* compiled from: BrandConvenienceInvoke.kt */
/* loaded from: classes3.dex */
public final class a {
    public static final T5.a a() {
        Object obj;
        A8.a aVar = A8.a.f202a;
        Object obj2 = aVar.b().get(k.b(T5.a.class));
        Object obj3 = null;
        if (!(obj2 instanceof T5.a)) {
            obj2 = null;
        }
        T5.a aVar2 = (T5.a) obj2;
        if (aVar2 == null) {
            InterfaceC1637a<?> interfaceC1637a = aVar.c().get(k.b(T5.a.class));
            if (interfaceC1637a != null) {
                obj = interfaceC1637a.invoke();
            } else {
                obj = null;
            }
            if (obj instanceof T5.a) {
                obj3 = obj;
            }
            return (T5.a) obj3;
        }
        return aVar2;
    }

    public static final boolean b() {
        Object obj;
        A8.a aVar = A8.a.f202a;
        Object obj2 = aVar.b().get(k.b(T5.a.class));
        Object obj3 = null;
        if (!(obj2 instanceof T5.a)) {
            obj2 = null;
        }
        T5.a aVar2 = (T5.a) obj2;
        if (aVar2 == null) {
            InterfaceC1637a<?> interfaceC1637a = aVar.c().get(k.b(T5.a.class));
            if (interfaceC1637a != null) {
                obj = interfaceC1637a.invoke();
            } else {
                obj = null;
            }
            if (obj instanceof T5.a) {
                obj3 = obj;
            }
            aVar2 = (T5.a) obj3;
        }
        if (aVar2 != null) {
            return aVar2.k();
        }
        return false;
    }
}
