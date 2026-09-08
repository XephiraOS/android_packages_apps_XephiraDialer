package androidx.recyclerview.widget;

/* compiled from: BatchingListUpdateCallback.java */
/* loaded from: classes.dex */
public class e implements q {

    /* renamed from: a, reason: collision with root package name */
    public final q f11037a;

    /* renamed from: b, reason: collision with root package name */
    public int f11038b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f11039c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f11040d = -1;

    /* renamed from: e, reason: collision with root package name */
    public Object f11041e = null;

    public e(q qVar) {
        this.f11037a = qVar;
    }

    @Override // androidx.recyclerview.widget.q
    public void a(int i10, int i11) {
        e();
        this.f11037a.a(i10, i11);
    }

    @Override // androidx.recyclerview.widget.q
    public void b(int i10, int i11) {
        int i12;
        if (this.f11038b == 1 && i10 >= (i12 = this.f11039c)) {
            int i13 = this.f11040d;
            if (i10 <= i12 + i13) {
                this.f11040d = i13 + i11;
                this.f11039c = Math.min(i10, i12);
                return;
            }
        }
        e();
        this.f11039c = i10;
        this.f11040d = i11;
        this.f11038b = 1;
    }

    @Override // androidx.recyclerview.widget.q
    public void c(int i10, int i11) {
        int i12;
        if (this.f11038b == 2 && (i12 = this.f11039c) >= i10 && i12 <= i10 + i11) {
            this.f11040d += i11;
            this.f11039c = i10;
        } else {
            e();
            this.f11039c = i10;
            this.f11040d = i11;
            this.f11038b = 2;
        }
    }

    @Override // androidx.recyclerview.widget.q
    public void d(int i10, int i11, Object obj) {
        int i12;
        if (this.f11038b == 3) {
            int i13 = this.f11039c;
            int i14 = this.f11040d;
            if (i10 <= i13 + i14 && (i12 = i10 + i11) >= i13 && this.f11041e == obj) {
                this.f11039c = Math.min(i10, i13);
                this.f11040d = Math.max(i14 + i13, i12) - this.f11039c;
                return;
            }
        }
        e();
        this.f11039c = i10;
        this.f11040d = i11;
        this.f11041e = obj;
        this.f11038b = 3;
    }

    public void e() {
        int i10 = this.f11038b;
        if (i10 == 0) {
            return;
        }
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    this.f11037a.d(this.f11039c, this.f11040d, this.f11041e);
                }
            } else {
                this.f11037a.c(this.f11039c, this.f11040d);
            }
        } else {
            this.f11037a.b(this.f11039c, this.f11040d);
        }
        this.f11041e = null;
        this.f11038b = 0;
    }
}
