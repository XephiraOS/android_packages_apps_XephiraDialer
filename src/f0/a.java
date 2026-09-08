package F0;

import kotlin.jvm.internal.i;

/* compiled from: IdentifyData.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @E4.c("name")
    public final String f785a;

    /* renamed from: b, reason: collision with root package name */
    @E4.c("phoneFlag")
    public String f786b;

    /* renamed from: c, reason: collision with root package name */
    @E4.c("markType")
    public int f787c;

    /* renamed from: d, reason: collision with root package name */
    @E4.c("markCount")
    public int f788d;

    /* renamed from: e, reason: collision with root package name */
    @E4.c("isCustomMark")
    public boolean f789e;

    public a(String str, String str2, int i10, int i11, boolean z10) {
        this.f785a = str;
        this.f786b = str2;
        this.f787c = i10;
        this.f788d = i11;
        this.f789e = z10;
    }

    public final int a() {
        return this.f788d;
    }

    public final int b() {
        return this.f787c;
    }

    public final String c() {
        return this.f785a;
    }

    public final String d() {
        return this.f786b;
    }

    public final boolean e() {
        return this.f789e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (i.b(this.f785a, aVar.f785a) && i.b(this.f786b, aVar.f786b) && this.f787c == aVar.f787c && this.f788d == aVar.f788d && this.f789e == aVar.f789e) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        String str = this.f785a;
        int i10 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i11 = hashCode * 31;
        String str2 = this.f786b;
        if (str2 != null) {
            i10 = str2.hashCode();
        }
        int hashCode2 = (((((i11 + i10) * 31) + Integer.hashCode(this.f787c)) * 31) + Integer.hashCode(this.f788d)) * 31;
        boolean z10 = this.f789e;
        int i12 = z10;
        if (z10 != 0) {
            i12 = 1;
        }
        return hashCode2 + i12;
    }

    public String toString() {
        return "IdentifyData(name=" + this.f785a + ", phoneFlag=" + this.f786b + ", markType=" + this.f787c + ", markCount=" + this.f788d + ", isCustomMark=" + this.f789e + ")";
    }
}
