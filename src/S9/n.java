package S9;

/* compiled from: NameValuePair.java */
/* loaded from: classes4.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final String f3668a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3669b;

    public n(String str, String str2) {
        if (str != null) {
            this.f3668a = str;
            this.f3669b = str2;
            return;
        }
        throw new IllegalArgumentException("Name may not be null");
    }

    public String a() {
        return this.f3668a;
    }

    public String b() {
        return this.f3669b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (this.f3668a.equals(nVar.f3668a) && T9.e.a(this.f3669b, nVar.f3669b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return T9.e.c(T9.e.c(17, this.f3668a), this.f3669b);
    }

    public String toString() {
        if (this.f3669b == null) {
            return this.f3668a;
        }
        return this.f3668a + "=\"" + this.f3669b + "\"";
    }
}
