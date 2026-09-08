package androidx.core.view;

/* compiled from: VelocityTrackerFallback.java */
/* loaded from: classes.dex */
public class I {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f9434a = new float[20];

    /* renamed from: b, reason: collision with root package name */
    public final long[] f9435b = new long[20];

    /* renamed from: c, reason: collision with root package name */
    public float f9436c = 0.0f;

    /* renamed from: d, reason: collision with root package name */
    public int f9437d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f9438e = 0;

    public static float c(float f10) {
        float f11;
        if (f10 < 0.0f) {
            f11 = -1.0f;
        } else {
            f11 = 1.0f;
        }
        return f11 * ((float) Math.sqrt(Math.abs(f10) * 2.0f));
    }

    public void a(int i10, float f10) {
        float b10 = b() * i10;
        this.f9436c = b10;
        if (b10 < (-Math.abs(f10))) {
            this.f9436c = -Math.abs(f10);
        } else if (this.f9436c > Math.abs(f10)) {
            this.f9436c = Math.abs(f10);
        }
    }

    public final float b() {
        long[] jArr;
        long j10;
        int i10 = this.f9437d;
        if (i10 < 2) {
            return 0.0f;
        }
        int i11 = this.f9438e;
        int i12 = ((i11 + 20) - (i10 - 1)) % 20;
        long j11 = this.f9435b[i11];
        while (true) {
            jArr = this.f9435b;
            j10 = jArr[i12];
            if (j11 - j10 <= 100) {
                break;
            }
            this.f9437d--;
            i12 = (i12 + 1) % 20;
        }
        int i13 = this.f9437d;
        if (i13 < 2) {
            return 0.0f;
        }
        if (i13 == 2) {
            int i14 = (i12 + 1) % 20;
            long j12 = jArr[i14];
            if (j10 == j12) {
                return 0.0f;
            }
            return this.f9434a[i14] / ((float) (j12 - j10));
        }
        float f10 = 0.0f;
        int i15 = 0;
        for (int i16 = 0; i16 < this.f9437d - 1; i16++) {
            int i17 = i16 + i12;
            long[] jArr2 = this.f9435b;
            long j13 = jArr2[i17 % 20];
            int i18 = (i17 + 1) % 20;
            if (jArr2[i18] != j13) {
                i15++;
                float c10 = c(f10);
                float f11 = this.f9434a[i18] / ((float) (this.f9435b[i18] - j13));
                f10 += (f11 - c10) * Math.abs(f11);
                if (i15 == 1) {
                    f10 *= 0.5f;
                }
            }
        }
        return c(f10);
    }
}
