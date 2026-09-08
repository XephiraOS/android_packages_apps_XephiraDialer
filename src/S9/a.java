package S9;

/* compiled from: BasicBodyDescriptor.java */
/* loaded from: classes4.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public final String f3608a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3609b;

    /* renamed from: c, reason: collision with root package name */
    public final String f3610c;

    /* renamed from: d, reason: collision with root package name */
    public final String f3611d;

    /* renamed from: e, reason: collision with root package name */
    public final String f3612e;

    /* renamed from: f, reason: collision with root package name */
    public final String f3613f;

    /* renamed from: g, reason: collision with root package name */
    public final long f3614g;

    public a(String str, String str2, String str3, String str4, String str5, String str6, long j10) {
        this.f3608a = str;
        this.f3609b = str2;
        this.f3610c = str3;
        this.f3611d = str4;
        this.f3612e = str5;
        this.f3613f = str6;
        this.f3614g = j10;
    }

    @Override // S9.d
    public String a() {
        return this.f3608a;
    }

    @Override // S9.d
    public String b() {
        return this.f3613f;
    }

    @Override // S9.b
    public String c() {
        return this.f3611d;
    }

    public String toString() {
        return "[mimeType=" + this.f3608a + ", mediaType=" + this.f3609b + ", subType=" + this.f3610c + ", boundary=" + this.f3611d + ", charset=" + this.f3612e + "]";
    }
}
