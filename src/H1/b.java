package H1;

import com.heytap.accessory.constant.FastPairConstants;
import kotlin.jvm.internal.i;

/* compiled from: CallState.kt */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public String f1239a;

    /* renamed from: b, reason: collision with root package name */
    public int f1240b;

    /* renamed from: c, reason: collision with root package name */
    public int f1241c;

    /* renamed from: d, reason: collision with root package name */
    public int f1242d;

    /* renamed from: e, reason: collision with root package name */
    public int f1243e;

    /* renamed from: f, reason: collision with root package name */
    public int f1244f;

    /* renamed from: g, reason: collision with root package name */
    public String f1245g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1246h;

    /* renamed from: i, reason: collision with root package name */
    public long f1247i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1248j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1249k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1250l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1251m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f1252n;

    /* renamed from: o, reason: collision with root package name */
    public int f1253o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f1254p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1255q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f1256r;

    public b() {
        this(null, 0, 0, 0, 0, 0, null, false, 0L, false, false, false, false, false, 0, false, false, false, 262143, null);
    }

    public final int a() {
        return this.f1244f;
    }

    public final boolean b() {
        return this.f1254p;
    }

    public final int c() {
        return this.f1253o;
    }

    public final long d() {
        return this.f1247i;
    }

    public final String e() {
        return this.f1245g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (i.b(this.f1239a, bVar.f1239a) && this.f1240b == bVar.f1240b && this.f1241c == bVar.f1241c && this.f1242d == bVar.f1242d && this.f1243e == bVar.f1243e && this.f1244f == bVar.f1244f && i.b(this.f1245g, bVar.f1245g) && this.f1246h == bVar.f1246h && this.f1247i == bVar.f1247i && this.f1248j == bVar.f1248j && this.f1249k == bVar.f1249k && this.f1250l == bVar.f1250l && this.f1251m == bVar.f1251m && this.f1252n == bVar.f1252n && this.f1253o == bVar.f1253o && this.f1254p == bVar.f1254p && this.f1255q == bVar.f1255q && this.f1256r == bVar.f1256r) {
            return true;
        }
        return false;
    }

    public final String f() {
        return this.f1239a;
    }

    public final boolean g() {
        return this.f1256r;
    }

    public final int h() {
        return this.f1240b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        String str = this.f1239a;
        int i10 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int hashCode2 = ((((((((((hashCode * 31) + Integer.hashCode(this.f1240b)) * 31) + Integer.hashCode(this.f1241c)) * 31) + Integer.hashCode(this.f1242d)) * 31) + Integer.hashCode(this.f1243e)) * 31) + Integer.hashCode(this.f1244f)) * 31;
        String str2 = this.f1245g;
        if (str2 != null) {
            i10 = str2.hashCode();
        }
        int i11 = (hashCode2 + i10) * 31;
        boolean z10 = this.f1246h;
        int i12 = 1;
        int i13 = z10;
        if (z10 != 0) {
            i13 = 1;
        }
        int hashCode3 = (((i11 + i13) * 31) + Long.hashCode(this.f1247i)) * 31;
        boolean z11 = this.f1248j;
        int i14 = z11;
        if (z11 != 0) {
            i14 = 1;
        }
        int i15 = (hashCode3 + i14) * 31;
        boolean z12 = this.f1249k;
        int i16 = z12;
        if (z12 != 0) {
            i16 = 1;
        }
        int i17 = (i15 + i16) * 31;
        boolean z13 = this.f1250l;
        int i18 = z13;
        if (z13 != 0) {
            i18 = 1;
        }
        int i19 = (i17 + i18) * 31;
        boolean z14 = this.f1251m;
        int i20 = z14;
        if (z14 != 0) {
            i20 = 1;
        }
        int i21 = (i19 + i20) * 31;
        boolean z15 = this.f1252n;
        int i22 = z15;
        if (z15 != 0) {
            i22 = 1;
        }
        int hashCode4 = (((i21 + i22) * 31) + Integer.hashCode(this.f1253o)) * 31;
        boolean z16 = this.f1254p;
        int i23 = z16;
        if (z16 != 0) {
            i23 = 1;
        }
        int i24 = (hashCode4 + i23) * 31;
        boolean z17 = this.f1255q;
        int i25 = z17;
        if (z17 != 0) {
            i25 = 1;
        }
        int i26 = (i24 + i25) * 31;
        boolean z18 = this.f1256r;
        if (!z18) {
            i12 = z18 ? 1 : 0;
        }
        return i26 + i12;
    }

    public final int i() {
        return this.f1242d;
    }

    public final int j() {
        return this.f1241c;
    }

    public final boolean k() {
        return this.f1248j;
    }

    public final boolean l() {
        return this.f1252n;
    }

    public final boolean m() {
        return this.f1246h;
    }

    public final boolean n() {
        return this.f1249k;
    }

    public String toString() {
        return b.class.getName() + '@' + Integer.toHexString(hashCode());
    }

    public b(String str, int i10, int i11, int i12, int i13, int i14, String str2, boolean z10, long j10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, int i15, boolean z16, boolean z17, boolean z18) {
        this.f1239a = str;
        this.f1240b = i10;
        this.f1241c = i11;
        this.f1242d = i12;
        this.f1243e = i13;
        this.f1244f = i14;
        this.f1245g = str2;
        this.f1246h = z10;
        this.f1247i = j10;
        this.f1248j = z11;
        this.f1249k = z12;
        this.f1250l = z13;
        this.f1251m = z14;
        this.f1252n = z15;
        this.f1253o = i15;
        this.f1254p = z16;
        this.f1255q = z17;
        this.f1256r = z18;
    }

    public /* synthetic */ b(String str, int i10, int i11, int i12, int i13, int i14, String str2, boolean z10, long j10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, int i15, boolean z16, boolean z17, boolean z18, int i16, kotlin.jvm.internal.f fVar) {
        this((i16 & 1) != 0 ? null : str, (i16 & 2) != 0 ? -1 : i10, (i16 & 4) == 0 ? i11 : -1, (i16 & 8) != 0 ? 0 : i12, (i16 & 16) != 0 ? 0 : i13, (i16 & 32) != 0 ? 0 : i14, (i16 & 64) == 0 ? str2 : null, (i16 & 128) != 0 ? false : z10, (i16 & 256) != 0 ? 0L : j10, (i16 & 512) != 0 ? false : z11, (i16 & 1024) != 0 ? false : z12, (i16 & 2048) != 0 ? false : z13, (i16 & 4096) != 0 ? false : z14, (i16 & 8192) != 0 ? false : z15, (i16 & 16384) != 0 ? 0 : i15, (i16 & FastPairConstants.PAIR_TYPE_BLE_IN_PAIR) != 0 ? false : z16, (i16 & 65536) != 0 ? false : z17, (i16 & 131072) != 0 ? false : z18);
    }
}
