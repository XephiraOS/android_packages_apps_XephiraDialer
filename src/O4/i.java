package O4;

import com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadata;

/* compiled from: MetadataSourceImpl.java */
/* loaded from: classes3.dex */
public final class i implements h {

    /* renamed from: a, reason: collision with root package name */
    public final l f2725a;

    /* renamed from: b, reason: collision with root package name */
    public final f<b> f2726b;

    public i(l lVar, f<b> fVar) {
        this.f2725a = lVar;
        this.f2726b = fVar;
    }

    @Override // O4.k
    public Phonemetadata$PhoneMetadata a(int i10) {
        if (!com.google.i18n.phonenumbers.internal.a.a(i10)) {
            return this.f2726b.a(this.f2725a.a(Integer.valueOf(i10))).b(i10);
        }
        throw new IllegalArgumentException(i10 + " calling code belongs to a geo entity");
    }

    @Override // O4.m
    public Phonemetadata$PhoneMetadata b(String str) {
        if (com.google.i18n.phonenumbers.internal.a.b(str)) {
            return this.f2726b.a(this.f2725a.a(str)).c(str);
        }
        throw new IllegalArgumentException(str + " region code is a non-geo entity");
    }

    public i(l lVar, L4.b bVar, N4.b bVar2) {
        this(lVar, new a(bVar, bVar2, new b()));
    }
}
