package U4;

import com.coui.appcompat.hapticfeedback.COUIHapticFeedbackConstants;

/* compiled from: GenericGF.java */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: h, reason: collision with root package name */
    public static final a f3852h = new a(4201, 4096, 1);

    /* renamed from: i, reason: collision with root package name */
    public static final a f3853i = new a(1033, 1024, 1);

    /* renamed from: j, reason: collision with root package name */
    public static final a f3854j;

    /* renamed from: k, reason: collision with root package name */
    public static final a f3855k;

    /* renamed from: l, reason: collision with root package name */
    public static final a f3856l;

    /* renamed from: m, reason: collision with root package name */
    public static final a f3857m;

    /* renamed from: n, reason: collision with root package name */
    public static final a f3858n;

    /* renamed from: o, reason: collision with root package name */
    public static final a f3859o;

    /* renamed from: a, reason: collision with root package name */
    public final int[] f3860a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f3861b;

    /* renamed from: c, reason: collision with root package name */
    public final b f3862c;

    /* renamed from: d, reason: collision with root package name */
    public final b f3863d;

    /* renamed from: e, reason: collision with root package name */
    public final int f3864e;

    /* renamed from: f, reason: collision with root package name */
    public final int f3865f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3866g;

    static {
        a aVar = new a(67, 64, 1);
        f3854j = aVar;
        f3855k = new a(19, 16, 1);
        f3856l = new a(285, 256, 0);
        a aVar2 = new a(COUIHapticFeedbackConstants.KEYBOARD_TOUCH_FEEDBACK, 256, 1);
        f3857m = aVar2;
        f3858n = aVar2;
        f3859o = aVar;
    }

    public a(int i10, int i11, int i12) {
        this.f3865f = i10;
        this.f3864e = i11;
        this.f3866g = i12;
        this.f3860a = new int[i11];
        this.f3861b = new int[i11];
        int i13 = 1;
        for (int i14 = 0; i14 < i11; i14++) {
            this.f3860a[i14] = i13;
            i13 <<= 1;
            if (i13 >= i11) {
                i13 = (i13 ^ i10) & (i11 - 1);
            }
        }
        for (int i15 = 0; i15 < i11 - 1; i15++) {
            this.f3861b[this.f3860a[i15]] = i15;
        }
        this.f3862c = new b(this, new int[]{0});
        this.f3863d = new b(this, new int[]{1});
    }

    public static int a(int i10, int i11) {
        return i10 ^ i11;
    }

    public b b(int i10, int i11) {
        if (i10 >= 0) {
            if (i11 == 0) {
                return this.f3862c;
            }
            int[] iArr = new int[i10 + 1];
            iArr[0] = i11;
            return new b(this, iArr);
        }
        throw new IllegalArgumentException();
    }

    public int c(int i10) {
        return this.f3860a[i10];
    }

    public int d() {
        return this.f3866g;
    }

    public b e() {
        return this.f3863d;
    }

    public int f() {
        return this.f3864e;
    }

    public b g() {
        return this.f3862c;
    }

    public int h(int i10) {
        if (i10 != 0) {
            return this.f3860a[(this.f3864e - this.f3861b[i10]) - 1];
        }
        throw new ArithmeticException();
    }

    public int i(int i10) {
        if (i10 != 0) {
            return this.f3861b[i10];
        }
        throw new IllegalArgumentException();
    }

    public int j(int i10, int i11) {
        if (i10 != 0 && i11 != 0) {
            int[] iArr = this.f3860a;
            int[] iArr2 = this.f3861b;
            return iArr[(iArr2[i10] + iArr2[i11]) % (this.f3864e - 1)];
        }
        return 0;
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f3865f) + ',' + this.f3864e + ')';
    }
}
