package E3;

import android.text.TextUtils;

/* compiled from: PhoneNumberAttributionTag.java */
/* loaded from: classes3.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    public final String f724a;

    /* renamed from: b, reason: collision with root package name */
    public final long f725b;

    public v(String str, long j10) {
        this.f724a = str;
        this.f725b = j10;
    }

    public long a() {
        return this.f725b;
    }

    public String b() {
        return this.f724a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        v vVar = (v) obj;
        if (this.f725b != vVar.f725b) {
            return false;
        }
        return TextUtils.equals(this.f724a, vVar.f724a);
    }

    public int hashCode() {
        return super.hashCode();
    }
}
