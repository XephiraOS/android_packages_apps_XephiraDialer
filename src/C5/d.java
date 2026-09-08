package C5;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ProviderRepo.java */
/* loaded from: classes3.dex */
public class d implements com.heytap.epona.e {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, com.heytap.epona.b> f366a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, G5.a> f367b = new ConcurrentHashMap<>();

    @Override // com.heytap.epona.e
    public com.heytap.epona.b a(String str) {
        return this.f366a.get(str);
    }

    @Override // com.heytap.epona.e
    public G5.a b(String str) {
        return this.f367b.get(str);
    }
}
