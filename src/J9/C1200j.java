package j9;

import j9.InterfaceC1197g;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: CompressorRegistry.java */
/* renamed from: j9.j, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1200j {

    /* renamed from: b, reason: collision with root package name */
    public static final C1200j f34023b = new C1200j(new InterfaceC1197g.a(), InterfaceC1197g.b.f34015a);

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentMap<String, InterfaceC1199i> f34024a = new ConcurrentHashMap();

    public C1200j(InterfaceC1199i... interfaceC1199iArr) {
        for (InterfaceC1199i interfaceC1199i : interfaceC1199iArr) {
            this.f34024a.put(interfaceC1199i.a(), interfaceC1199i);
        }
    }

    public static C1200j a() {
        return f34023b;
    }

    public InterfaceC1199i b(String str) {
        return this.f34024a.get(str);
    }
}
