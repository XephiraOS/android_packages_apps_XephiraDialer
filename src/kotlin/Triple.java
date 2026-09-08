package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.i;

/* compiled from: Tuples.kt */
/* loaded from: classes4.dex */
public final class Triple<A, B, C> implements Serializable {
    private final A first;
    private final B second;
    private final C third;

    public Triple(A a10, B b10, C c10) {
        this.first = a10;
        this.second = b10;
        this.third = c10;
    }

    public final A a() {
        return this.first;
    }

    public final B b() {
        return this.second;
    }

    public final C c() {
        return this.third;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Triple)) {
            return false;
        }
        Triple triple = (Triple) obj;
        if (i.b(this.first, triple.first) && i.b(this.second, triple.second) && i.b(this.third, triple.third)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        A a10 = this.first;
        int i10 = 0;
        if (a10 == null) {
            hashCode = 0;
        } else {
            hashCode = a10.hashCode();
        }
        int i11 = hashCode * 31;
        B b10 = this.second;
        if (b10 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = b10.hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        C c10 = this.third;
        if (c10 != null) {
            i10 = c10.hashCode();
        }
        return i12 + i10;
    }

    public String toString() {
        return '(' + this.first + ", " + this.second + ", " + this.third + ')';
    }
}
