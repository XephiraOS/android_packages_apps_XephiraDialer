package Y;

/* compiled from: Target.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: e, reason: collision with root package name */
    public static final c f5510e;

    /* renamed from: f, reason: collision with root package name */
    public static final c f5511f;

    /* renamed from: g, reason: collision with root package name */
    public static final c f5512g;

    /* renamed from: h, reason: collision with root package name */
    public static final c f5513h;

    /* renamed from: i, reason: collision with root package name */
    public static final c f5514i;

    /* renamed from: j, reason: collision with root package name */
    public static final c f5515j;

    /* renamed from: a, reason: collision with root package name */
    public final float[] f5516a;

    /* renamed from: b, reason: collision with root package name */
    public final float[] f5517b;

    /* renamed from: c, reason: collision with root package name */
    public final float[] f5518c = new float[3];

    /* renamed from: d, reason: collision with root package name */
    public boolean f5519d = true;

    static {
        c cVar = new c();
        f5510e = cVar;
        m(cVar);
        p(cVar);
        c cVar2 = new c();
        f5511f = cVar2;
        o(cVar2);
        p(cVar2);
        c cVar3 = new c();
        f5512g = cVar3;
        l(cVar3);
        p(cVar3);
        c cVar4 = new c();
        f5513h = cVar4;
        m(cVar4);
        n(cVar4);
        c cVar5 = new c();
        f5514i = cVar5;
        o(cVar5);
        n(cVar5);
        c cVar6 = new c();
        f5515j = cVar6;
        l(cVar6);
        n(cVar6);
    }

    public c() {
        float[] fArr = new float[3];
        this.f5516a = fArr;
        float[] fArr2 = new float[3];
        this.f5517b = fArr2;
        r(fArr);
        r(fArr2);
        q();
    }

    public static void l(c cVar) {
        float[] fArr = cVar.f5517b;
        fArr[1] = 0.26f;
        fArr[2] = 0.45f;
    }

    public static void m(c cVar) {
        float[] fArr = cVar.f5517b;
        fArr[0] = 0.55f;
        fArr[1] = 0.74f;
    }

    public static void n(c cVar) {
        float[] fArr = cVar.f5516a;
        fArr[1] = 0.3f;
        fArr[2] = 0.4f;
    }

    public static void o(c cVar) {
        float[] fArr = cVar.f5517b;
        fArr[0] = 0.3f;
        fArr[1] = 0.5f;
        fArr[2] = 0.7f;
    }

    public static void p(c cVar) {
        float[] fArr = cVar.f5516a;
        fArr[0] = 0.35f;
        fArr[1] = 1.0f;
    }

    public static void r(float[] fArr) {
        fArr[0] = 0.0f;
        fArr[1] = 0.5f;
        fArr[2] = 1.0f;
    }

    public float a() {
        return this.f5518c[1];
    }

    public float b() {
        return this.f5517b[2];
    }

    public float c() {
        return this.f5516a[2];
    }

    public float d() {
        return this.f5517b[0];
    }

    public float e() {
        return this.f5516a[0];
    }

    public float f() {
        return this.f5518c[2];
    }

    public float g() {
        return this.f5518c[0];
    }

    public float h() {
        return this.f5517b[1];
    }

    public float i() {
        return this.f5516a[1];
    }

    public boolean j() {
        return this.f5519d;
    }

    public void k() {
        int length = this.f5518c.length;
        float f10 = 0.0f;
        for (int i10 = 0; i10 < length; i10++) {
            float f11 = this.f5518c[i10];
            if (f11 > 0.0f) {
                f10 += f11;
            }
        }
        if (f10 != 0.0f) {
            int length2 = this.f5518c.length;
            for (int i11 = 0; i11 < length2; i11++) {
                float[] fArr = this.f5518c;
                float f12 = fArr[i11];
                if (f12 > 0.0f) {
                    fArr[i11] = f12 / f10;
                }
            }
        }
    }

    public final void q() {
        float[] fArr = this.f5518c;
        fArr[0] = 0.24f;
        fArr[1] = 0.52f;
        fArr[2] = 0.24f;
    }
}
