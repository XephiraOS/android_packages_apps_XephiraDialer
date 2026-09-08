package c5;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ExpandedRow.java */
/* renamed from: c5.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0556c {

    /* renamed from: a, reason: collision with root package name */
    public final List<C0555b> f12784a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12785b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f12786c;

    public C0556c(List<C0555b> list, int i10, boolean z10) {
        this.f12784a = new ArrayList(list);
        this.f12785b = i10;
        this.f12786c = z10;
    }

    public List<C0555b> a() {
        return this.f12784a;
    }

    public int b() {
        return this.f12785b;
    }

    public boolean c(List<C0555b> list) {
        return this.f12784a.equals(list);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0556c)) {
            return false;
        }
        C0556c c0556c = (C0556c) obj;
        if (!this.f12784a.equals(c0556c.a()) || this.f12786c != c0556c.f12786c) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Boolean.valueOf(this.f12786c).hashCode() ^ this.f12784a.hashCode();
    }

    public String toString() {
        return "{ " + this.f12784a + " }";
    }
}
