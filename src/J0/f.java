package J0;

import android.net.Uri;
import android.text.TextUtils;

/* compiled from: ContactInfo.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: q, reason: collision with root package name */
    public static final f f1443q = new f();

    /* renamed from: b, reason: collision with root package name */
    public Uri f1445b;

    /* renamed from: c, reason: collision with root package name */
    public String f1446c;

    /* renamed from: d, reason: collision with root package name */
    public int f1447d;

    /* renamed from: e, reason: collision with root package name */
    public String f1448e;

    /* renamed from: f, reason: collision with root package name */
    public String f1449f;

    /* renamed from: g, reason: collision with root package name */
    public String f1450g;

    /* renamed from: h, reason: collision with root package name */
    public String f1451h;

    /* renamed from: j, reason: collision with root package name */
    public long f1453j;

    /* renamed from: k, reason: collision with root package name */
    public String f1454k;

    /* renamed from: l, reason: collision with root package name */
    public long f1455l;

    /* renamed from: m, reason: collision with root package name */
    public Uri f1456m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f1457n;

    /* renamed from: a, reason: collision with root package name */
    public long f1444a = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f1452i = 0;

    /* renamed from: o, reason: collision with root package name */
    public boolean f1458o = false;

    /* renamed from: p, reason: collision with root package name */
    public boolean f1459p = false;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (U7.g.a(this.f1445b, fVar.f1445b) && TextUtils.equals(this.f1446c, fVar.f1446c) && this.f1447d == fVar.f1447d && TextUtils.equals(this.f1448e, fVar.f1448e) && TextUtils.equals(this.f1449f, fVar.f1449f) && TextUtils.equals(this.f1451h, fVar.f1451h) && this.f1455l == fVar.f1455l && U7.g.a(this.f1456m, fVar.f1456m) && TextUtils.equals(this.f1454k, fVar.f1454k) && this.f1458o == fVar.f1458o && this.f1459p == fVar.f1459p && this.f1453j == fVar.f1453j) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        Uri uri = this.f1445b;
        int i10 = 0;
        if (uri == null) {
            hashCode = 0;
        } else {
            hashCode = uri.hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        String str = this.f1446c;
        if (str != null) {
            i10 = str.hashCode();
        }
        return i11 + i10;
    }
}
