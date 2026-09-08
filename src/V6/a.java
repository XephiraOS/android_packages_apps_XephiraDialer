package V6;

import android.net.Uri;
import android.text.TextUtils;
import com.oplus.utils.X;

/* compiled from: ContactInfo.java */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: q, reason: collision with root package name */
    public static final a f4009q = new a();

    /* renamed from: a, reason: collision with root package name */
    public long f4010a = -1;

    /* renamed from: b, reason: collision with root package name */
    public Uri f4011b;

    /* renamed from: c, reason: collision with root package name */
    public String f4012c;

    /* renamed from: d, reason: collision with root package name */
    public String f4013d;

    /* renamed from: e, reason: collision with root package name */
    public String f4014e;

    /* renamed from: f, reason: collision with root package name */
    public String f4015f;

    /* renamed from: g, reason: collision with root package name */
    public String f4016g;

    /* renamed from: h, reason: collision with root package name */
    public long f4017h;

    /* renamed from: i, reason: collision with root package name */
    public Uri f4018i;

    /* renamed from: j, reason: collision with root package name */
    public long f4019j;

    /* renamed from: k, reason: collision with root package name */
    public int f4020k;

    /* renamed from: l, reason: collision with root package name */
    public long f4021l;

    /* renamed from: m, reason: collision with root package name */
    public int f4022m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f4023n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f4024o;

    /* renamed from: p, reason: collision with root package name */
    public String f4025p;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (X.a(this.f4011b, aVar.f4011b) && TextUtils.equals(this.f4012c, aVar.f4012c) && TextUtils.equals(this.f4013d, aVar.f4013d) && TextUtils.equals(this.f4015f, aVar.f4015f) && this.f4017h == aVar.f4017h && X.a(this.f4018i, aVar.f4018i) && TextUtils.equals(this.f4016g, aVar.f4016g)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        Uri uri = this.f4011b;
        int i10 = 0;
        if (uri == null) {
            hashCode = 0;
        } else {
            hashCode = uri.hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        String str = this.f4012c;
        if (str != null) {
            i10 = str.hashCode();
        }
        return i11 + i10;
    }
}
