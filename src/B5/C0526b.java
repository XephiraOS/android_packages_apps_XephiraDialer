package b5;

/* compiled from: DataCharacter.java */
/* renamed from: b5.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0526b {

    /* renamed from: a, reason: collision with root package name */
    public final int f12169a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12170b;

    public C0526b(int i10, int i11) {
        this.f12169a = i10;
        this.f12170b = i11;
    }

    public final int a() {
        return this.f12170b;
    }

    public final int b() {
        return this.f12169a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0526b)) {
            return false;
        }
        C0526b c0526b = (C0526b) obj;
        if (this.f12169a != c0526b.f12169a || this.f12170b != c0526b.f12170b) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f12170b ^ this.f12169a;
    }

    public final String toString() {
        return this.f12169a + "(" + this.f12170b + ')';
    }
}
