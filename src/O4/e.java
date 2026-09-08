package O4;

import com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadata;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: MapBackedMetadataContainer.java */
/* loaded from: classes3.dex */
public final class e<T> implements g {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentMap<T, Phonemetadata$PhoneMetadata> f2723a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final c<T> f2724b;

    /* compiled from: MapBackedMetadataContainer.java */
    /* loaded from: classes3.dex */
    public class a implements c<String> {
        @Override // O4.e.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a(Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata) {
            return phonemetadata$PhoneMetadata.d();
        }
    }

    /* compiled from: MapBackedMetadataContainer.java */
    /* loaded from: classes3.dex */
    public class b implements c<Integer> {
        @Override // O4.e.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer a(Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata) {
            return Integer.valueOf(phonemetadata$PhoneMetadata.a());
        }
    }

    /* compiled from: MapBackedMetadataContainer.java */
    /* loaded from: classes3.dex */
    public interface c<T> {
        T a(Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata);
    }

    public e(c<T> cVar) {
        this.f2724b = cVar;
    }

    public static e<Integer> b() {
        return new e<>(new b());
    }

    public static e<String> c() {
        return new e<>(new a());
    }

    @Override // O4.g
    public void a(Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata) {
        this.f2723a.put(this.f2724b.a(phonemetadata$PhoneMetadata), phonemetadata$PhoneMetadata);
    }

    public c<T> d() {
        return this.f2724b;
    }

    public Phonemetadata$PhoneMetadata e(T t10) {
        if (t10 != null) {
            return this.f2723a.get(t10);
        }
        return null;
    }
}
