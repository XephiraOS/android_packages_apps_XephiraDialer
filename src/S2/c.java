package S2;

import android.text.TextUtils;

/* compiled from: Header.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f3388a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3389b;

    public c(String str, String str2) {
        this.f3388a = str;
        this.f3389b = str2;
    }

    public final String a() {
        return this.f3388a;
    }

    public final String b() {
        return this.f3389b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (TextUtils.equals(this.f3388a, cVar.f3388a) && TextUtils.equals(this.f3389b, cVar.f3389b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f3388a.hashCode() * 31) + this.f3389b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f3388a + ",value=" + this.f3389b + "]";
    }
}
