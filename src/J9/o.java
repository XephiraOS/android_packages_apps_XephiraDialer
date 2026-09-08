package j9;

import j9.InterfaceC1197g;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: DecompressorRegistry.java */
/* loaded from: classes4.dex */
public final class o {

    /* renamed from: c, reason: collision with root package name */
    public static final com.google.common.base.e f34034c = com.google.common.base.e.f(',');

    /* renamed from: d, reason: collision with root package name */
    public static final o f34035d = a().f(new InterfaceC1197g.a(), true).f(InterfaceC1197g.b.f34015a, false);

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, a> f34036a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f34037b;

    /* compiled from: DecompressorRegistry.java */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final InterfaceC1204n f34038a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f34039b;

        public a(InterfaceC1204n interfaceC1204n, boolean z10) {
            this.f34038a = (InterfaceC1204n) com.google.common.base.k.p(interfaceC1204n, "decompressor");
            this.f34039b = z10;
        }
    }

    public o(InterfaceC1204n interfaceC1204n, boolean z10, o oVar) {
        String a10 = interfaceC1204n.a();
        com.google.common.base.k.e(!a10.contains(","), "Comma is currently not allowed in message encoding");
        int size = oVar.f34036a.size();
        LinkedHashMap linkedHashMap = new LinkedHashMap(oVar.f34036a.containsKey(interfaceC1204n.a()) ? size : size + 1);
        for (a aVar : oVar.f34036a.values()) {
            String a11 = aVar.f34038a.a();
            if (!a11.equals(a10)) {
                linkedHashMap.put(a11, new a(aVar.f34038a, aVar.f34039b));
            }
        }
        linkedHashMap.put(a10, new a(interfaceC1204n, z10));
        this.f34036a = Collections.unmodifiableMap(linkedHashMap);
        this.f34037b = f34034c.d(b()).getBytes(Charset.forName("US-ASCII"));
    }

    public static o a() {
        return new o();
    }

    public static o c() {
        return f34035d;
    }

    public Set<String> b() {
        HashSet hashSet = new HashSet(this.f34036a.size());
        for (Map.Entry<String, a> entry : this.f34036a.entrySet()) {
            if (entry.getValue().f34039b) {
                hashSet.add(entry.getKey());
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public byte[] d() {
        return this.f34037b;
    }

    public InterfaceC1204n e(String str) {
        a aVar = this.f34036a.get(str);
        if (aVar != null) {
            return aVar.f34038a;
        }
        return null;
    }

    public o f(InterfaceC1204n interfaceC1204n, boolean z10) {
        return new o(interfaceC1204n, z10, this);
    }

    public o() {
        this.f34036a = new LinkedHashMap(0);
        this.f34037b = new byte[0];
    }
}
