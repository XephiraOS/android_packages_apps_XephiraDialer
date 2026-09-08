package w0;

/* compiled from: RttTranscriptConstants.kt */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public long f37564a;

    /* renamed from: b, reason: collision with root package name */
    public long f37565b;

    /* renamed from: c, reason: collision with root package name */
    public int f37566c;

    /* renamed from: d, reason: collision with root package name */
    public String f37567d;

    public l(long j10, long j11, int i10, String str) {
        this.f37564a = j10;
        this.f37565b = j11;
        this.f37566c = i10;
        this.f37567d = str;
    }

    public final long a() {
        return this.f37565b;
    }

    public final long b() {
        return this.f37564a;
    }

    public final String c() {
        return this.f37567d;
    }

    public final int d() {
        return this.f37566c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (this.f37564a == lVar.f37564a && this.f37565b == lVar.f37565b && this.f37566c == lVar.f37566c && kotlin.jvm.internal.i.b(this.f37567d, lVar.f37567d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((Long.hashCode(this.f37564a) * 31) + Long.hashCode(this.f37565b)) * 31) + Integer.hashCode(this.f37566c)) * 31;
        String str = this.f37567d;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public String toString() {
        return "RttTranscriptInfo(callId=" + this.f37564a + ", callDate=" + this.f37565b + ", type=" + this.f37566c + ", rttText=" + this.f37567d + ")";
    }
}
