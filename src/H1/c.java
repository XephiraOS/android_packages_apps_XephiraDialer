package H1;

import kotlin.jvm.internal.i;

/* compiled from: ContactInfo.kt */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public long f1257a;

    /* renamed from: b, reason: collision with root package name */
    public String f1258b;

    /* renamed from: c, reason: collision with root package name */
    public Object f1259c;

    /* renamed from: d, reason: collision with root package name */
    public String f1260d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1261e;

    public c() {
        this(0L, null, null, null, false, 31, null);
    }

    public final long a() {
        return this.f1257a;
    }

    public final String b() {
        return this.f1258b;
    }

    public final void c(String str) {
        this.f1258b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f1257a == cVar.f1257a && i.b(this.f1258b, cVar.f1258b) && i.b(this.f1259c, cVar.f1259c) && i.b(this.f1260d, cVar.f1260d) && this.f1261e == cVar.f1261e) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = Long.hashCode(this.f1257a) * 31;
        String str = this.f1258b;
        int i10 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i11 = (hashCode3 + hashCode) * 31;
        Object obj = this.f1259c;
        if (obj == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = obj.hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        String str2 = this.f1260d;
        if (str2 != null) {
            i10 = str2.hashCode();
        }
        int i13 = (i12 + i10) * 31;
        boolean z10 = this.f1261e;
        int i14 = z10;
        if (z10 != 0) {
            i14 = 1;
        }
        return i13 + i14;
    }

    public String toString() {
        return "ContactInfo(contactId=" + this.f1257a + ", name=" + this.f1258b + ", avatar=" + this.f1259c + ", jobInfo=" + this.f1260d + ", isVip=" + this.f1261e + ')';
    }

    public c(long j10, String str, Object obj, String str2, boolean z10) {
        this.f1257a = j10;
        this.f1258b = str;
        this.f1259c = obj;
        this.f1260d = str2;
        this.f1261e = z10;
    }

    public /* synthetic */ c(long j10, String str, Object obj, String str2, boolean z10, int i10, kotlin.jvm.internal.f fVar) {
        this((i10 & 1) != 0 ? -1L : j10, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : obj, (i10 & 8) != 0 ? null : str2, (i10 & 16) != 0 ? false : z10);
    }
}
