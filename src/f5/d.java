package f5;

/* compiled from: Codeword.java */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final int f31740a;

    /* renamed from: b, reason: collision with root package name */
    public final int f31741b;

    /* renamed from: c, reason: collision with root package name */
    public final int f31742c;

    /* renamed from: d, reason: collision with root package name */
    public final int f31743d;

    /* renamed from: e, reason: collision with root package name */
    public int f31744e = -1;

    public d(int i10, int i11, int i12, int i13) {
        this.f31740a = i10;
        this.f31741b = i11;
        this.f31742c = i12;
        this.f31743d = i13;
    }

    public int a() {
        return this.f31742c;
    }

    public int b() {
        return this.f31741b;
    }

    public int c() {
        return this.f31744e;
    }

    public int d() {
        return this.f31740a;
    }

    public int e() {
        return this.f31743d;
    }

    public int f() {
        return this.f31741b - this.f31740a;
    }

    public boolean g() {
        return h(this.f31744e);
    }

    public boolean h(int i10) {
        if (i10 != -1 && this.f31742c == (i10 % 3) * 3) {
            return true;
        }
        return false;
    }

    public void i(int i10) {
        this.f31744e = i10;
    }

    public void j() {
        this.f31744e = ((this.f31743d / 30) * 3) + (this.f31742c / 3);
    }

    public String toString() {
        return this.f31744e + "|" + this.f31743d;
    }
}
