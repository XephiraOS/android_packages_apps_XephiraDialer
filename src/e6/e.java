package e6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: KeyPath.java */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: c, reason: collision with root package name */
    public static final e f31645c = new e("COMPOSITION");

    /* renamed from: a, reason: collision with root package name */
    public final List<String> f31646a;

    /* renamed from: b, reason: collision with root package name */
    public f f31647b;

    public e(String... strArr) {
        this.f31646a = Arrays.asList(strArr);
    }

    public e a(String str) {
        e eVar = new e(this);
        eVar.f31646a.add(str);
        return eVar;
    }

    public final boolean b() {
        return this.f31646a.get(r1.size() - 1).equals("**");
    }

    public boolean c(String str, int i10) {
        boolean z10;
        boolean z11;
        if (i10 >= this.f31646a.size()) {
            return false;
        }
        if (i10 == this.f31646a.size() - 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        String str2 = this.f31646a.get(i10);
        if (!str2.equals("**")) {
            if (!str2.equals(str) && !str2.equals("*")) {
                z11 = false;
            } else {
                z11 = true;
            }
            if ((!z10 && (i10 != this.f31646a.size() - 2 || !b())) || !z11) {
                return false;
            }
            return true;
        }
        if (!z10 && this.f31646a.get(i10 + 1).equals(str)) {
            if (i10 != this.f31646a.size() - 2 && (i10 != this.f31646a.size() - 3 || !b())) {
                return false;
            }
            return true;
        }
        if (z10) {
            return true;
        }
        int i11 = i10 + 1;
        if (i11 < this.f31646a.size() - 1) {
            return false;
        }
        return this.f31646a.get(i11).equals(str);
    }

    public f d() {
        return this.f31647b;
    }

    public int e(String str, int i10) {
        if (f(str)) {
            return 0;
        }
        if (!this.f31646a.get(i10).equals("**")) {
            return 1;
        }
        if (i10 == this.f31646a.size() - 1 || !this.f31646a.get(i10 + 1).equals(str)) {
            return 0;
        }
        return 2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (!this.f31646a.equals(eVar.f31646a)) {
            return false;
        }
        f fVar = this.f31647b;
        if (fVar != null) {
            return fVar.equals(eVar.f31647b);
        }
        if (eVar.f31647b == null) {
            return true;
        }
        return false;
    }

    public final boolean f(String str) {
        return "__container".equals(str);
    }

    public boolean g(String str, int i10) {
        if (f(str)) {
            return true;
        }
        if (i10 >= this.f31646a.size()) {
            return false;
        }
        if (this.f31646a.get(i10).equals(str) || this.f31646a.get(i10).equals("**") || this.f31646a.get(i10).equals("*")) {
            return true;
        }
        return false;
    }

    public boolean h(String str, int i10) {
        if ("__container".equals(str) || i10 < this.f31646a.size() - 1 || this.f31646a.get(i10).equals("**")) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int hashCode = this.f31646a.hashCode() * 31;
        f fVar = this.f31647b;
        if (fVar != null) {
            i10 = fVar.hashCode();
        } else {
            i10 = 0;
        }
        return hashCode + i10;
    }

    public e i(f fVar) {
        e eVar = new e(this);
        eVar.f31647b = fVar;
        return eVar;
    }

    public String toString() {
        boolean z10;
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f31646a);
        sb.append(",resolved=");
        if (this.f31647b != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        sb.append(z10);
        sb.append('}');
        return sb.toString();
    }

    public e(e eVar) {
        this.f31646a = new ArrayList(eVar.f31646a);
        this.f31647b = eVar.f31647b;
    }
}
