package O9;

import java.util.HashMap;
import java.util.Map;

/* compiled from: DelegatingFieldParser.java */
/* loaded from: classes4.dex */
public class n implements L9.a<N9.o> {

    /* renamed from: a, reason: collision with root package name */
    public final L9.a<? extends N9.o> f2771a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, L9.a<? extends N9.o>> f2772b = new HashMap();

    public n(L9.a<? extends N9.o> aVar) {
        this.f2771a = aVar;
    }

    @Override // L9.a
    public N9.o a(S9.i iVar, K9.c cVar) {
        return b(iVar.getName()).a(iVar, cVar);
    }

    public L9.a<? extends N9.o> b(String str) {
        L9.a<? extends N9.o> aVar = this.f2772b.get(str.toLowerCase());
        if (aVar == null) {
            return this.f2771a;
        }
        return aVar;
    }

    public void c(String str, L9.a<? extends N9.o> aVar) {
        this.f2772b.put(str.toLowerCase(), aVar);
    }
}
