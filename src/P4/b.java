package P4;

import com.google.zxing.NotFoundException;

/* compiled from: BinaryBitmap.java */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final a f2942a;

    /* renamed from: b, reason: collision with root package name */
    public S4.b f2943b;

    public b(a aVar) {
        if (aVar != null) {
            this.f2942a = aVar;
            return;
        }
        throw new IllegalArgumentException("Binarizer must be non-null.");
    }

    public S4.b a() {
        if (this.f2943b == null) {
            this.f2943b = this.f2942a.b();
        }
        return this.f2943b;
    }

    public S4.a b(int i10, S4.a aVar) {
        return this.f2942a.c(i10, aVar);
    }

    public int c() {
        return this.f2942a.d();
    }

    public int d() {
        return this.f2942a.f();
    }

    public boolean e() {
        return this.f2942a.e().e();
    }

    public b f() {
        return new b(this.f2942a.a(this.f2942a.e().f()));
    }

    public String toString() {
        try {
            return a().toString();
        } catch (NotFoundException unused) {
            return "";
        }
    }
}
