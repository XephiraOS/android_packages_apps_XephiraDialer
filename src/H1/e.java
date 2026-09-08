package H1;

import kotlin.jvm.internal.i;

/* compiled from: FDNInfo.kt */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public String f1264a;

    /* JADX WARN: Multi-variable type inference failed */
    public e() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final String a() {
        return this.f1264a;
    }

    public final void b(String str) {
        this.f1264a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof e) && i.b(this.f1264a, ((e) obj).f1264a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f1264a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "FDNInfo(name=" + this.f1264a + ')';
    }

    public e(String str) {
        this.f1264a = str;
    }

    public /* synthetic */ e(String str, int i10, kotlin.jvm.internal.f fVar) {
        this((i10 & 1) != 0 ? null : str);
    }
}
