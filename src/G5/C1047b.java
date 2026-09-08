package g5;

/* compiled from: ModulusGF.java */
/* renamed from: g5.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1047b {

    /* renamed from: f, reason: collision with root package name */
    public static final C1047b f31878f = new C1047b(929, 3);

    /* renamed from: a, reason: collision with root package name */
    public final int[] f31879a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f31880b;

    /* renamed from: c, reason: collision with root package name */
    public final c f31881c;

    /* renamed from: d, reason: collision with root package name */
    public final c f31882d;

    /* renamed from: e, reason: collision with root package name */
    public final int f31883e;

    public C1047b(int i10, int i11) {
        this.f31883e = i10;
        this.f31879a = new int[i10];
        this.f31880b = new int[i10];
        int i12 = 1;
        for (int i13 = 0; i13 < i10; i13++) {
            this.f31879a[i13] = i12;
            i12 = (i12 * i11) % i10;
        }
        for (int i14 = 0; i14 < i10 - 1; i14++) {
            this.f31880b[this.f31879a[i14]] = i14;
        }
        this.f31881c = new c(this, new int[]{0});
        this.f31882d = new c(this, new int[]{1});
    }

    public int a(int i10, int i11) {
        return (i10 + i11) % this.f31883e;
    }

    public c b(int i10, int i11) {
        if (i10 >= 0) {
            if (i11 == 0) {
                return this.f31881c;
            }
            int[] iArr = new int[i10 + 1];
            iArr[0] = i11;
            return new c(this, iArr);
        }
        throw new IllegalArgumentException();
    }

    public int c(int i10) {
        return this.f31879a[i10];
    }

    public c d() {
        return this.f31882d;
    }

    public int e() {
        return this.f31883e;
    }

    public c f() {
        return this.f31881c;
    }

    public int g(int i10) {
        if (i10 != 0) {
            return this.f31879a[(this.f31883e - this.f31880b[i10]) - 1];
        }
        throw new ArithmeticException();
    }

    public int h(int i10) {
        if (i10 != 0) {
            return this.f31880b[i10];
        }
        throw new IllegalArgumentException();
    }

    public int i(int i10, int i11) {
        if (i10 != 0 && i11 != 0) {
            int[] iArr = this.f31879a;
            int[] iArr2 = this.f31880b;
            return iArr[(iArr2[i10] + iArr2[i11]) % (this.f31883e - 1)];
        }
        return 0;
    }

    public int j(int i10, int i11) {
        int i12 = this.f31883e;
        return ((i10 + i12) - i11) % i12;
    }
}
