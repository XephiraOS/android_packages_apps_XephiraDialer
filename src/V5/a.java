package V5;

import kotlin.jvm.internal.k;
import v9.InterfaceC1637a;

/* compiled from: FoldScreenConvenienceInvoke.kt */
/* loaded from: classes3.dex */
public final class a {
    public static final b a() {
        Object obj;
        A8.a aVar = A8.a.f202a;
        Object obj2 = aVar.b().get(k.b(b.class));
        Object obj3 = null;
        if (!(obj2 instanceof b)) {
            obj2 = null;
        }
        b bVar = (b) obj2;
        if (bVar == null) {
            InterfaceC1637a<?> interfaceC1637a = aVar.c().get(k.b(b.class));
            if (interfaceC1637a != null) {
                obj = interfaceC1637a.invoke();
            } else {
                obj = null;
            }
            if (obj instanceof b) {
                obj3 = obj;
            }
            return (b) obj3;
        }
        return bVar;
    }
}
