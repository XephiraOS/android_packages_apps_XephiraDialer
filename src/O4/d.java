package O4;

import com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadata;

/* compiled from: FormattingMetadataSourceImpl.java */
/* loaded from: classes3.dex */
public final class d implements c {

    /* renamed from: a, reason: collision with root package name */
    public final l f2721a;

    /* renamed from: b, reason: collision with root package name */
    public final f<e<Integer>> f2722b;

    public d(l lVar, f<e<Integer>> fVar) {
        this.f2721a = lVar;
        this.f2722b = fVar;
    }

    @Override // O4.c
    public Phonemetadata$PhoneMetadata a(int i10) {
        return this.f2722b.a(this.f2721a.a(Integer.valueOf(i10))).e(Integer.valueOf(i10));
    }

    public d(l lVar, L4.b bVar, N4.b bVar2) {
        this(lVar, new a(bVar, bVar2, e.b()));
    }
}
