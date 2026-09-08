package k5;

import P4.g;

/* compiled from: AlignmentPattern.java */
/* renamed from: k5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1212a extends g {

    /* renamed from: c, reason: collision with root package name */
    public final float f34143c;

    public C1212a(float f10, float f11, float f12) {
        super(f10, f11);
        this.f34143c = f12;
    }

    public boolean f(float f10, float f11, float f12) {
        if (Math.abs(f11 - d()) > f10 || Math.abs(f12 - c()) > f10) {
            return false;
        }
        float abs = Math.abs(f10 - this.f34143c);
        if (abs > 1.0f && abs > this.f34143c) {
            return false;
        }
        return true;
    }

    public C1212a g(float f10, float f11, float f12) {
        return new C1212a((c() + f11) / 2.0f, (d() + f10) / 2.0f, (this.f34143c + f12) / 2.0f);
    }
}
