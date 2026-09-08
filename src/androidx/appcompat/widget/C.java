package androidx.appcompat.widget;

/* compiled from: RtlSpacingHelper.java */
/* loaded from: classes.dex */
public class C {

    /* renamed from: a, reason: collision with root package name */
    public int f7648a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f7649b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f7650c = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name */
    public int f7651d = Integer.MIN_VALUE;

    /* renamed from: e, reason: collision with root package name */
    public int f7652e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f7653f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7654g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f7655h = false;

    public int a() {
        if (this.f7654g) {
            return this.f7648a;
        }
        return this.f7649b;
    }

    public int b() {
        return this.f7648a;
    }

    public int c() {
        return this.f7649b;
    }

    public int d() {
        if (this.f7654g) {
            return this.f7649b;
        }
        return this.f7648a;
    }

    public void e(int i10, int i11) {
        this.f7655h = false;
        if (i10 != Integer.MIN_VALUE) {
            this.f7652e = i10;
            this.f7648a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f7653f = i11;
            this.f7649b = i11;
        }
    }

    public void f(boolean z10) {
        if (z10 == this.f7654g) {
            return;
        }
        this.f7654g = z10;
        if (this.f7655h) {
            if (z10) {
                int i10 = this.f7651d;
                if (i10 == Integer.MIN_VALUE) {
                    i10 = this.f7652e;
                }
                this.f7648a = i10;
                int i11 = this.f7650c;
                if (i11 == Integer.MIN_VALUE) {
                    i11 = this.f7653f;
                }
                this.f7649b = i11;
                return;
            }
            int i12 = this.f7650c;
            if (i12 == Integer.MIN_VALUE) {
                i12 = this.f7652e;
            }
            this.f7648a = i12;
            int i13 = this.f7651d;
            if (i13 == Integer.MIN_VALUE) {
                i13 = this.f7653f;
            }
            this.f7649b = i13;
            return;
        }
        this.f7648a = this.f7652e;
        this.f7649b = this.f7653f;
    }

    public void g(int i10, int i11) {
        this.f7650c = i10;
        this.f7651d = i11;
        this.f7655h = true;
        if (this.f7654g) {
            if (i11 != Integer.MIN_VALUE) {
                this.f7648a = i11;
            }
            if (i10 != Integer.MIN_VALUE) {
                this.f7649b = i10;
                return;
            }
            return;
        }
        if (i10 != Integer.MIN_VALUE) {
            this.f7648a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f7649b = i11;
        }
    }
}
