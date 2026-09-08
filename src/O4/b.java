package O4;

import com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadata;

/* compiled from: CompositeMetadataContainer.java */
/* loaded from: classes3.dex */
public final class b implements g {

    /* renamed from: a, reason: collision with root package name */
    public final e<Integer> f2719a = e.b();

    /* renamed from: b, reason: collision with root package name */
    public final e<String> f2720b = e.c();

    @Override // O4.g
    public void a(Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata) {
        if (com.google.i18n.phonenumbers.internal.a.b(this.f2720b.d().a(phonemetadata$PhoneMetadata))) {
            this.f2720b.a(phonemetadata$PhoneMetadata);
        } else {
            this.f2719a.a(phonemetadata$PhoneMetadata);
        }
    }

    public Phonemetadata$PhoneMetadata b(int i10) {
        return this.f2719a.e(Integer.valueOf(i10));
    }

    public Phonemetadata$PhoneMetadata c(String str) {
        return this.f2720b.e(str);
    }
}
