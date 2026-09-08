package B;

import android.graphics.Insets;

/* compiled from: Insets.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final b f206e = new b(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f207a;

    /* renamed from: b, reason: collision with root package name */
    public final int f208b;

    /* renamed from: c, reason: collision with root package name */
    public final int f209c;

    /* renamed from: d, reason: collision with root package name */
    public final int f210d;

    /* compiled from: Insets.java */
    /* loaded from: classes.dex */
    public static class a {
        public static Insets a(int i10, int i11, int i12, int i13) {
            return Insets.of(i10, i11, i12, i13);
        }
    }

    public b(int i10, int i11, int i12, int i13) {
        this.f207a = i10;
        this.f208b = i11;
        this.f209c = i12;
        this.f210d = i13;
    }

    public static b a(b bVar, b bVar2) {
        return b(Math.max(bVar.f207a, bVar2.f207a), Math.max(bVar.f208b, bVar2.f208b), Math.max(bVar.f209c, bVar2.f209c), Math.max(bVar.f210d, bVar2.f210d));
    }

    public static b b(int i10, int i11, int i12, int i13) {
        if (i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) {
            return f206e;
        }
        return new b(i10, i11, i12, i13);
    }

    public static b c(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets d() {
        return a.a(this.f207a, this.f208b, this.f209c, this.f210d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f210d == bVar.f210d && this.f207a == bVar.f207a && this.f209c == bVar.f209c && this.f208b == bVar.f208b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f207a * 31) + this.f208b) * 31) + this.f209c) * 31) + this.f210d;
    }

    public String toString() {
        return "Insets{left=" + this.f207a + ", top=" + this.f208b + ", right=" + this.f209c + ", bottom=" + this.f210d + '}';
    }
}
