package c5;

import b5.C0526b;
import java.util.Objects;

/* compiled from: ExpandedPair.java */
/* renamed from: c5.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0555b {

    /* renamed from: a, reason: collision with root package name */
    public final C0526b f12781a;

    /* renamed from: b, reason: collision with root package name */
    public final C0526b f12782b;

    /* renamed from: c, reason: collision with root package name */
    public final b5.c f12783c;

    public C0555b(C0526b c0526b, C0526b c0526b2, b5.c cVar) {
        this.f12781a = c0526b;
        this.f12782b = c0526b2;
        this.f12783c = cVar;
    }

    public b5.c a() {
        return this.f12783c;
    }

    public C0526b b() {
        return this.f12781a;
    }

    public C0526b c() {
        return this.f12782b;
    }

    public boolean d() {
        if (this.f12782b == null) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0555b)) {
            return false;
        }
        C0555b c0555b = (C0555b) obj;
        if (!Objects.equals(this.f12781a, c0555b.f12781a) || !Objects.equals(this.f12782b, c0555b.f12782b) || !Objects.equals(this.f12783c, c0555b.f12783c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.f12783c) ^ (Objects.hashCode(this.f12781a) ^ Objects.hashCode(this.f12782b));
    }

    public String toString() {
        Object valueOf;
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.f12781a);
        sb.append(" , ");
        sb.append(this.f12782b);
        sb.append(" : ");
        b5.c cVar = this.f12783c;
        if (cVar == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(cVar.c());
        }
        sb.append(valueOf);
        sb.append(" ]");
        return sb.toString();
    }
}
