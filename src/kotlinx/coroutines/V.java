package kotlinx.coroutines;

/* compiled from: JobSupport.kt */
/* loaded from: classes4.dex */
public final class V implements InterfaceC1245g0 {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f34341a;

    public V(boolean z10) {
        this.f34341a = z10;
    }

    @Override // kotlinx.coroutines.InterfaceC1245g0
    public boolean c() {
        return this.f34341a;
    }

    @Override // kotlinx.coroutines.InterfaceC1245g0
    public x0 f() {
        return null;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        if (c()) {
            str = "Active";
        } else {
            str = "New";
        }
        sb.append(str);
        sb.append('}');
        return sb.toString();
    }
}
