package O4;

import O4.g;
import com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadata;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: BlockingMetadataBootstrappingGuard.java */
/* loaded from: classes3.dex */
public final class a<T extends g> implements f<T> {

    /* renamed from: a, reason: collision with root package name */
    public final L4.b f2715a;

    /* renamed from: b, reason: collision with root package name */
    public final N4.b f2716b;

    /* renamed from: c, reason: collision with root package name */
    public final T f2717c;

    /* renamed from: d, reason: collision with root package name */
    public final Map<String, String> f2718d = new ConcurrentHashMap();

    public a(L4.b bVar, N4.b bVar2, T t10) {
        this.f2715a = bVar;
        this.f2716b = bVar2;
        this.f2717c = t10;
    }

    @Override // O4.f
    public T a(String str) {
        if (!this.f2718d.containsKey(str)) {
            b(str);
        }
        return this.f2717c;
    }

    public final synchronized void b(String str) {
        try {
            if (this.f2718d.containsKey(str)) {
                return;
            }
            Iterator<Phonemetadata$PhoneMetadata> it = c(str).iterator();
            while (it.hasNext()) {
                this.f2717c.a(it.next());
            }
            this.f2718d.put(str, str);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final Collection<Phonemetadata$PhoneMetadata> c(String str) {
        try {
            return this.f2716b.d(this.f2715a.a(str));
        } catch (IllegalArgumentException | IllegalStateException e10) {
            throw new IllegalStateException("Failed to read file " + str, e10);
        }
    }
}
