package j4;

/* compiled from: Arrangement.java */
/* renamed from: j4.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1162a {

    /* renamed from: a, reason: collision with root package name */
    public final int f33853a;

    /* renamed from: b, reason: collision with root package name */
    public float f33854b;

    /* renamed from: c, reason: collision with root package name */
    public int f33855c;

    /* renamed from: d, reason: collision with root package name */
    public int f33856d;

    /* renamed from: e, reason: collision with root package name */
    public float f33857e;

    /* renamed from: f, reason: collision with root package name */
    public float f33858f;

    /* renamed from: g, reason: collision with root package name */
    public final int f33859g;

    /* renamed from: h, reason: collision with root package name */
    public final float f33860h;

    public C1162a(int i10, float f10, float f11, float f12, int i11, float f13, int i12, float f14, int i13, float f15) {
        this.f33853a = i10;
        this.f33854b = E.a.a(f10, f11, f12);
        this.f33855c = i11;
        this.f33857e = f13;
        this.f33856d = i12;
        this.f33858f = f14;
        this.f33859g = i13;
        d(f15, f11, f12, f14);
        this.f33860h = b(f14);
    }

    public static C1162a c(float f10, float f11, float f12, float f13, int[] iArr, float f14, int[] iArr2, float f15, int[] iArr3) {
        C1162a c1162a = null;
        int i10 = 1;
        for (int i11 : iArr3) {
            int length = iArr2.length;
            int i12 = 0;
            while (i12 < length) {
                int i13 = iArr2[i12];
                int length2 = iArr.length;
                int i14 = 0;
                while (i14 < length2) {
                    int i15 = i14;
                    int i16 = length2;
                    int i17 = i12;
                    int i18 = length;
                    C1162a c1162a2 = new C1162a(i10, f11, f12, f13, iArr[i14], f14, i13, f15, i11, f10);
                    if (c1162a == null || c1162a2.f33860h < c1162a.f33860h) {
                        if (c1162a2.f33860h == 0.0f) {
                            return c1162a2;
                        }
                        c1162a = c1162a2;
                    }
                    i10++;
                    i14 = i15 + 1;
                    length2 = i16;
                    i12 = i17;
                    length = i18;
                }
                i12++;
            }
        }
        return c1162a;
    }

    public final float a(float f10, int i10, float f11, int i11, int i12) {
        if (i10 <= 0) {
            f11 = 0.0f;
        }
        float f12 = i10;
        float f13 = i11 / 2.0f;
        return (f10 - ((f12 + f13) * f11)) / (i12 + f13);
    }

    public final float b(float f10) {
        if (!g()) {
            return Float.MAX_VALUE;
        }
        return Math.abs(f10 - this.f33858f) * this.f33853a;
    }

    public final void d(float f10, float f11, float f12, float f13) {
        float f14;
        float f15 = f10 - f();
        int i10 = this.f33855c;
        if (i10 > 0 && f15 > 0.0f) {
            float f16 = this.f33854b;
            this.f33854b = f16 + Math.min(f15 / i10, f12 - f16);
        } else if (i10 > 0 && f15 < 0.0f) {
            float f17 = this.f33854b;
            this.f33854b = f17 + Math.max(f15 / i10, f11 - f17);
        }
        int i11 = this.f33855c;
        if (i11 > 0) {
            f14 = this.f33854b;
        } else {
            f14 = 0.0f;
        }
        this.f33854b = f14;
        float a10 = a(f10, i11, f14, this.f33856d, this.f33859g);
        this.f33858f = a10;
        float f18 = (this.f33854b + a10) / 2.0f;
        this.f33857e = f18;
        int i12 = this.f33856d;
        if (i12 > 0 && a10 != f13) {
            float f19 = (f13 - a10) * this.f33859g;
            float min = Math.min(Math.abs(f19), f18 * 0.1f * i12);
            if (f19 > 0.0f) {
                this.f33857e -= min / this.f33856d;
                this.f33858f += min / this.f33859g;
            } else {
                this.f33857e += min / this.f33856d;
                this.f33858f -= min / this.f33859g;
            }
        }
    }

    public int e() {
        return this.f33855c + this.f33856d + this.f33859g;
    }

    public final float f() {
        return (this.f33858f * this.f33859g) + (this.f33857e * this.f33856d) + (this.f33854b * this.f33855c);
    }

    public final boolean g() {
        int i10 = this.f33859g;
        if (i10 > 0 && this.f33855c > 0 && this.f33856d > 0) {
            float f10 = this.f33858f;
            float f11 = this.f33857e;
            if (f10 <= f11 || f11 <= this.f33854b) {
                return false;
            }
            return true;
        }
        if (i10 > 0 && this.f33855c > 0 && this.f33858f <= this.f33854b) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "Arrangement [priority=" + this.f33853a + ", smallCount=" + this.f33855c + ", smallSize=" + this.f33854b + ", mediumCount=" + this.f33856d + ", mediumSize=" + this.f33857e + ", largeCount=" + this.f33859g + ", largeSize=" + this.f33858f + ", cost=" + this.f33860h + "]";
    }
}
