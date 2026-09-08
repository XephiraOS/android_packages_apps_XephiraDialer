package k5;

import P4.g;

/* compiled from: FinderPattern.java */
/* loaded from: classes3.dex */
public final class d extends g {

    /* renamed from: c, reason: collision with root package name */
    public final float f34155c;

    /* renamed from: d, reason: collision with root package name */
    public final int f34156d;

    public d(float f10, float f11, float f12) {
        this(f10, f11, f12, 1);
    }

    public boolean f(float f10, float f11, float f12) {
        if (Math.abs(f11 - d()) > f10 || Math.abs(f12 - c()) > f10) {
            return false;
        }
        float abs = Math.abs(f10 - this.f34155c);
        if (abs > 1.0f && abs > this.f34155c) {
            return false;
        }
        return true;
    }

    public d g(float f10, float f11, float f12) {
        int i10 = this.f34156d;
        int i11 = i10 + 1;
        float c10 = (i10 * c()) + f11;
        float f13 = i11;
        return new d(c10 / f13, ((this.f34156d * d()) + f10) / f13, ((this.f34156d * this.f34155c) + f12) / f13, i11);
    }

    public int h() {
        return this.f34156d;
    }

    public float i() {
        return this.f34155c;
    }

    public d(float f10, float f11, float f12, int i10) {
        super(f10, f11);
        this.f34155c = f12;
        this.f34156d = i10;
    }
}
