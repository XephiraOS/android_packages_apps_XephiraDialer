package S9;

import java.util.ArrayList;
import java.util.List;

/* compiled from: RawBody.java */
/* loaded from: classes4.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final String f3673a;

    /* renamed from: b, reason: collision with root package name */
    public final List<n> f3674b;

    public p(String str, List<n> list) {
        if (str != null) {
            this.f3673a = str;
            this.f3674b = list == null ? new ArrayList<>() : list;
            return;
        }
        throw new IllegalArgumentException("Field value not be null");
    }

    public List<n> a() {
        return new ArrayList(this.f3674b);
    }

    public String b() {
        return this.f3673a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3673a);
        sb.append("; ");
        for (n nVar : this.f3674b) {
            sb.append("; ");
            sb.append(nVar);
        }
        return sb.toString();
    }
}
