package H1;

import kotlin.Pair;
import kotlin.jvm.internal.i;

/* compiled from: MarkInfo.kt */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public Object f1265a;

    /* renamed from: b, reason: collision with root package name */
    public String f1266b;

    /* renamed from: c, reason: collision with root package name */
    public Pair<String, String> f1267c;

    /* renamed from: d, reason: collision with root package name */
    public String f1268d;

    public f() {
        this(null, null, null, null, 15, null);
    }

    public final String a() {
        return this.f1268d;
    }

    public final Pair<String, String> b() {
        return this.f1267c;
    }

    public final String c() {
        return this.f1266b;
    }

    public final void d(String str) {
        this.f1268d = str;
    }

    public final void e(String str) {
        this.f1266b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (i.b(this.f1265a, fVar.f1265a) && i.b(this.f1266b, fVar.f1266b) && i.b(this.f1267c, fVar.f1267c) && i.b(this.f1268d, fVar.f1268d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        Object obj = this.f1265a;
        int i10 = 0;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        int i11 = hashCode * 31;
        String str = this.f1266b;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        Pair<String, String> pair = this.f1267c;
        if (pair == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = pair.hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        String str2 = this.f1268d;
        if (str2 != null) {
            i10 = str2.hashCode();
        }
        return i13 + i10;
    }

    public String toString() {
        return "MarkInfo(icon=" + this.f1265a + ", yellowPageInfo=" + this.f1266b + ", markInfo=" + this.f1267c + ", fraudInfo=" + this.f1268d + ')';
    }

    public f(Object obj, String str, Pair<String, String> pair, String str2) {
        this.f1265a = obj;
        this.f1266b = str;
        this.f1267c = pair;
        this.f1268d = str2;
    }

    public /* synthetic */ f(Object obj, String str, Pair pair, String str2, int i10, kotlin.jvm.internal.f fVar) {
        this((i10 & 1) != 0 ? null : obj, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : pair, (i10 & 8) != 0 ? null : str2);
    }
}
