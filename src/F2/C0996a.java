package f2;

/* compiled from: FragmentStateUseCase.kt */
/* renamed from: f2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0996a {

    /* renamed from: a, reason: collision with root package name */
    public final int f31675a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f31676b;

    public C0996a(int i10, boolean z10) {
        this.f31675a = i10;
        this.f31676b = z10;
    }

    public final int a() {
        return this.f31675a;
    }

    public final boolean b() {
        return this.f31676b;
    }

    public final void c(boolean z10) {
        this.f31676b = z10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0996a)) {
            return false;
        }
        C0996a c0996a = (C0996a) obj;
        if (this.f31675a == c0996a.f31675a && this.f31676b == c0996a.f31676b) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = Integer.hashCode(this.f31675a) * 31;
        boolean z10 = this.f31676b;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    public String toString() {
        return "CallFragmentState(callFragmentType=" + this.f31675a + ", visible=" + this.f31676b + ')';
    }

    public /* synthetic */ C0996a(int i10, boolean z10, int i11, kotlin.jvm.internal.f fVar) {
        this(i10, (i11 & 2) != 0 ? false : z10);
    }
}
