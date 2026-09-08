package l6;

/* compiled from: MeanCalculator.java */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public float f34721a;

    /* renamed from: b, reason: collision with root package name */
    public int f34722b;

    public void a(float f10) {
        float f11 = this.f34721a + f10;
        this.f34721a = f11;
        int i10 = this.f34722b + 1;
        this.f34722b = i10;
        if (i10 == Integer.MAX_VALUE) {
            this.f34721a = f11 / 2.0f;
            this.f34722b = i10 / 2;
        }
    }
}
