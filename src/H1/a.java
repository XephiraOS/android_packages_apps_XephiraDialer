package H1;

import kotlin.jvm.internal.i;

/* compiled from: CallInfo.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public String f1225a;

    /* renamed from: b, reason: collision with root package name */
    public String f1226b;

    /* renamed from: c, reason: collision with root package name */
    public String f1227c;

    /* renamed from: d, reason: collision with root package name */
    public String f1228d;

    /* renamed from: e, reason: collision with root package name */
    public int f1229e;

    /* renamed from: f, reason: collision with root package name */
    public c f1230f;

    /* renamed from: g, reason: collision with root package name */
    public f f1231g;

    /* renamed from: h, reason: collision with root package name */
    public e f1232h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1233i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1234j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1235k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1236l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1237m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f1238n;

    public a() {
        this(null, null, null, null, 0, null, null, null, false, false, false, false, false, false, 16383, null);
    }

    public final c a() {
        return this.f1230f;
    }

    public final String b() {
        return this.f1227c;
    }

    public final e c() {
        return this.f1232h;
    }

    public final String d() {
        return this.f1225a;
    }

    public final String e() {
        return this.f1228d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (i.b(this.f1225a, aVar.f1225a) && i.b(this.f1226b, aVar.f1226b) && i.b(this.f1227c, aVar.f1227c) && i.b(this.f1228d, aVar.f1228d) && this.f1229e == aVar.f1229e && i.b(this.f1230f, aVar.f1230f) && i.b(this.f1231g, aVar.f1231g) && i.b(this.f1232h, aVar.f1232h) && this.f1233i == aVar.f1233i && this.f1234j == aVar.f1234j && this.f1235k == aVar.f1235k && this.f1236l == aVar.f1236l && this.f1237m == aVar.f1237m && this.f1238n == aVar.f1238n) {
            return true;
        }
        return false;
    }

    public final f f() {
        return this.f1231g;
    }

    public final String g() {
        return this.f1226b;
    }

    public final int h() {
        return this.f1229e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        String str = this.f1225a;
        int i10 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i11 = hashCode * 31;
        String str2 = this.f1226b;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        String str3 = this.f1227c;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        String str4 = this.f1228d;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int hashCode7 = (((i13 + hashCode4) * 31) + Integer.hashCode(this.f1229e)) * 31;
        c cVar = this.f1230f;
        if (cVar == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = cVar.hashCode();
        }
        int i14 = (hashCode7 + hashCode5) * 31;
        f fVar = this.f1231g;
        if (fVar == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = fVar.hashCode();
        }
        int i15 = (i14 + hashCode6) * 31;
        e eVar = this.f1232h;
        if (eVar != null) {
            i10 = eVar.hashCode();
        }
        int i16 = (i15 + i10) * 31;
        boolean z10 = this.f1233i;
        int i17 = 1;
        int i18 = z10;
        if (z10 != 0) {
            i18 = 1;
        }
        int i19 = (i16 + i18) * 31;
        boolean z11 = this.f1234j;
        int i20 = z11;
        if (z11 != 0) {
            i20 = 1;
        }
        int i21 = (i19 + i20) * 31;
        boolean z12 = this.f1235k;
        int i22 = z12;
        if (z12 != 0) {
            i22 = 1;
        }
        int i23 = (i21 + i22) * 31;
        boolean z13 = this.f1236l;
        int i24 = z13;
        if (z13 != 0) {
            i24 = 1;
        }
        int i25 = (i23 + i24) * 31;
        boolean z14 = this.f1237m;
        int i26 = z14;
        if (z14 != 0) {
            i26 = 1;
        }
        int i27 = (i25 + i26) * 31;
        boolean z15 = this.f1238n;
        if (!z15) {
            i17 = z15 ? 1 : 0;
        }
        return i27 + i17;
    }

    public final boolean i() {
        return this.f1233i;
    }

    public final boolean j() {
        return this.f1234j;
    }

    public final boolean k() {
        return this.f1237m;
    }

    public final void l(String str) {
        this.f1227c = str;
    }

    public String toString() {
        return a.class.getName() + '@' + Integer.toHexString(hashCode());
    }

    public a(String str, String str2, String str3, String str4, int i10, c cVar, f fVar, e eVar, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        this.f1225a = str;
        this.f1226b = str2;
        this.f1227c = str3;
        this.f1228d = str4;
        this.f1229e = i10;
        this.f1230f = cVar;
        this.f1231g = fVar;
        this.f1232h = eVar;
        this.f1233i = z10;
        this.f1234j = z11;
        this.f1235k = z12;
        this.f1236l = z13;
        this.f1237m = z14;
        this.f1238n = z15;
    }

    public /* synthetic */ a(String str, String str2, String str3, String str4, int i10, c cVar, f fVar, e eVar, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, int i11, kotlin.jvm.internal.f fVar2) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : str4, (i11 & 16) != 0 ? -1 : i10, (i11 & 32) != 0 ? null : cVar, (i11 & 64) != 0 ? null : fVar, (i11 & 128) == 0 ? eVar : null, (i11 & 256) != 0 ? false : z10, (i11 & 512) != 0 ? false : z11, (i11 & 1024) != 0 ? false : z12, (i11 & 2048) != 0 ? false : z13, (i11 & 4096) != 0 ? false : z14, (i11 & 8192) == 0 ? z15 : false);
    }
}
