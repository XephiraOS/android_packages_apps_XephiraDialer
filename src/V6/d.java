package V6;

import android.text.TextUtils;
import com.oplus.utils.X;

/* compiled from: ContactInfoRequest.java */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f4040a;

    /* renamed from: b, reason: collision with root package name */
    public final a f4041b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4042c;

    /* renamed from: d, reason: collision with root package name */
    public final String f4043d;

    public d(String str, a aVar, int i10, String str2) {
        this.f4040a = str;
        this.f4041b = aVar;
        this.f4042c = i10;
        this.f4043d = str2;
    }

    public boolean a(Object obj, Object obj2) {
        a aVar = (a) obj;
        a aVar2 = (a) obj2;
        if (aVar == null && aVar2 == null) {
            return true;
        }
        if (aVar != null && aVar2 != null && X.a(aVar.f4011b, aVar2.f4011b) && TextUtils.equals(aVar.f4012c, aVar2.f4012c) && TextUtils.equals(aVar.f4013d, aVar2.f4013d) && TextUtils.equals(aVar.f4014e, aVar2.f4014e) && aVar.f4017h == aVar2.f4017h && X.a(aVar.f4018i, aVar2.f4018i) && aVar.f4010a == aVar2.f4010a && aVar.f4022m == aVar2.f4022m) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (TextUtils.equals(this.f4040a, dVar.f4040a) && a(this.f4041b, dVar.f4041b) && TextUtils.equals(this.f4043d, dVar.f4043d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        a aVar = this.f4041b;
        int i10 = 0;
        if (aVar == null) {
            hashCode = 0;
        } else {
            hashCode = aVar.hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        String str = this.f4040a;
        if (str != null) {
            i10 = str.hashCode();
        }
        return i11 + i10;
    }
}
