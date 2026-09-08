package V6;

import android.text.TextUtils;

/* compiled from: NumberWithSubId.java */
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public final String f4084a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4085b;

    public i(String str, int i10) {
        this.f4084a = str;
        this.f4085b = i10;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (!TextUtils.equals(this.f4084a, iVar.f4084a) || this.f4085b != iVar.f4085b) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        String str = this.f4084a;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return this.f4085b ^ hashCode;
    }
}
