package W4;

import com.google.zxing.FormatException;
import org.opencv.imgproc.Imgproc;

/* compiled from: Version.java */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: h, reason: collision with root package name */
    public static final d[] f4196h = a();

    /* renamed from: a, reason: collision with root package name */
    public final int f4197a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4198b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4199c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4200d;

    /* renamed from: e, reason: collision with root package name */
    public final int f4201e;

    /* renamed from: f, reason: collision with root package name */
    public final c f4202f;

    /* renamed from: g, reason: collision with root package name */
    public final int f4203g;

    /* compiled from: Version.java */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f4204a;

        /* renamed from: b, reason: collision with root package name */
        public final int f4205b;

        public int a() {
            return this.f4204a;
        }

        public int b() {
            return this.f4205b;
        }

        public b(int i10, int i11) {
            this.f4204a = i10;
            this.f4205b = i11;
        }
    }

    public d(int i10, int i11, int i12, int i13, int i14, c cVar) {
        this.f4197a = i10;
        this.f4198b = i11;
        this.f4199c = i12;
        this.f4200d = i13;
        this.f4201e = i14;
        this.f4202f = cVar;
        int b10 = cVar.b();
        int i15 = 0;
        for (b bVar : cVar.a()) {
            i15 += bVar.a() * (bVar.b() + b10);
        }
        this.f4203g = i15;
    }

    public static d[] a() {
        int i10 = 1;
        int i11 = 5;
        d dVar = new d(1, 10, 10, 8, 8, new c(i11, new b(i10, 3)));
        d dVar2 = new d(2, 12, 12, 10, 10, new c(7, new b(i10, i11)));
        d dVar3 = new d(3, 14, 14, 12, 12, new c(10, new b(i10, 8)));
        int i12 = 12;
        d dVar4 = new d(4, 16, 16, 14, 14, new c(i12, new b(i10, i12)));
        int i13 = 18;
        d dVar5 = new d(5, 18, 18, 16, 16, new c(14, new b(i10, i13)));
        d dVar6 = new d(6, 20, 20, 18, 18, new c(i13, new b(i10, 22)));
        d dVar7 = new d(7, 22, 22, 20, 20, new c(20, new b(i10, 30)));
        int i14 = 36;
        d dVar8 = new d(8, 24, 24, 22, 22, new c(24, new b(i10, i14)));
        d dVar9 = new d(9, 26, 26, 24, 24, new c(28, new b(i10, 44)));
        d dVar10 = new d(10, 32, 32, 14, 14, new c(i14, new b(i10, 62)));
        int i15 = 42;
        int i16 = 56;
        int i17 = 2;
        int i18 = 4;
        return new d[]{dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, dVar8, dVar9, dVar10, new d(11, 36, 36, 16, 16, new c(i15, new b(i10, 86))), new d(12, 40, 40, 18, 18, new c(48, new b(i10, 114))), new d(13, 44, 44, 20, 20, new c(i16, new b(i10, 144))), new d(14, 48, 48, 22, 22, new c(68, new b(i10, 174))), new d(15, 52, 52, 24, 24, new c(i15, new b(i17, 102))), new d(16, 64, 64, 14, 14, new c(i16, new b(i17, 140))), new d(17, 72, 72, 16, 16, new c(36, new b(i18, 92))), new d(18, 80, 80, 18, 18, new c(48, new b(i18, 114))), new d(19, 88, 88, 20, 20, new c(i16, new b(i18, 144))), new d(20, 96, 96, 22, 22, new c(68, new b(i18, 174))), new d(21, 104, 104, 24, 24, new c(i16, new b(6, 136))), new d(22, 120, 120, 18, 18, new c(68, new b(6, 175))), new d(23, Imgproc.COLOR_BGR2YUV_YV12, Imgproc.COLOR_BGR2YUV_YV12, 20, 20, new c(62, new b(8, 163))), new d(24, 144, 144, 22, 22, new c(62, new b(8, 156), new b(i17, 155))), new d(25, 8, 18, 6, 16, new c(7, new b(1, 5))), new d(26, 8, 32, 6, 14, new c(11, new b(1, 10))), new d(27, 12, 26, 10, 24, new c(14, new b(1, 16))), new d(28, 12, 36, 10, 16, new c(18, new b(1, 22))), new d(29, 16, 36, 14, 16, new c(24, new b(1, 32))), new d(30, 16, 48, 14, 22, new c(28, new b(1, 49)))};
    }

    public static d h(int i10, int i11) {
        if ((i10 & 1) == 0 && (i11 & 1) == 0) {
            for (d dVar : f4196h) {
                if (dVar.f4198b == i10 && dVar.f4199c == i11) {
                    return dVar;
                }
            }
            throw FormatException.a();
        }
        throw FormatException.a();
    }

    public int b() {
        return this.f4201e;
    }

    public int c() {
        return this.f4200d;
    }

    public c d() {
        return this.f4202f;
    }

    public int e() {
        return this.f4199c;
    }

    public int f() {
        return this.f4198b;
    }

    public int g() {
        return this.f4203g;
    }

    public int i() {
        return this.f4197a;
    }

    public String toString() {
        return String.valueOf(this.f4197a);
    }

    /* compiled from: Version.java */
    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f4206a;

        /* renamed from: b, reason: collision with root package name */
        public final b[] f4207b;

        public b[] a() {
            return this.f4207b;
        }

        public int b() {
            return this.f4206a;
        }

        public c(int i10, b bVar) {
            this.f4206a = i10;
            this.f4207b = new b[]{bVar};
        }

        public c(int i10, b bVar, b bVar2) {
            this.f4206a = i10;
            this.f4207b = new b[]{bVar, bVar2};
        }
    }
}
