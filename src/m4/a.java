package M4;

import N4.b;
import O4.c;
import O4.d;
import O4.h;
import O4.i;
import O4.j;
import O4.l;
import O4.m;
import O4.n;

/* compiled from: DefaultMetadataDependenciesProvider.java */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: i, reason: collision with root package name */
    public static final a f1764i = new a();

    /* renamed from: a, reason: collision with root package name */
    public final b f1765a;

    /* renamed from: b, reason: collision with root package name */
    public final L4.b f1766b;

    /* renamed from: c, reason: collision with root package name */
    public final l f1767c;

    /* renamed from: d, reason: collision with root package name */
    public final h f1768d;

    /* renamed from: e, reason: collision with root package name */
    public final l f1769e;

    /* renamed from: f, reason: collision with root package name */
    public final m f1770f;

    /* renamed from: g, reason: collision with root package name */
    public final l f1771g;

    /* renamed from: h, reason: collision with root package name */
    public final c f1772h;

    public a() {
        b c10 = b.c();
        this.f1765a = c10;
        N4.a aVar = new N4.a();
        this.f1766b = aVar;
        j jVar = new j("/com/google/i18n/phonenumbers/data/PhoneNumberMetadataProto");
        this.f1767c = jVar;
        this.f1768d = new i(jVar, aVar, c10);
        j jVar2 = new j("/com/google/i18n/phonenumbers/data/ShortNumberMetadataProto");
        this.f1769e = jVar2;
        this.f1770f = new n(jVar2, aVar, c10);
        j jVar3 = new j("/com/google/i18n/phonenumbers/data/PhoneNumberAlternateFormatsProto");
        this.f1771g = jVar3;
        this.f1772h = new d(jVar3, aVar, c10);
    }

    public static a b() {
        return f1764i;
    }

    public c a() {
        return this.f1772h;
    }

    public L4.b c() {
        return this.f1766b;
    }

    public b d() {
        return this.f1765a;
    }

    public l e() {
        return this.f1767c;
    }
}
