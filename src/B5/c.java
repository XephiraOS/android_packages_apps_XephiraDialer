package b5;

import P4.g;

/* compiled from: FinderPattern.java */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f12171a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f12172b;

    /* renamed from: c, reason: collision with root package name */
    public final g[] f12173c;

    public c(int i10, int[] iArr, int i11, int i12, int i13) {
        this.f12171a = i10;
        this.f12172b = iArr;
        float f10 = i11;
        float f11 = i13;
        this.f12173c = new g[]{new g(f10, f11), new g(i12, f11)};
    }

    public g[] a() {
        return this.f12173c;
    }

    public int[] b() {
        return this.f12172b;
    }

    public int c() {
        return this.f12171a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c) || this.f12171a != ((c) obj).f12171a) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f12171a;
    }
}
