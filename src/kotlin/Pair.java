package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.i;

/* compiled from: Tuples.kt */
/* loaded from: classes4.dex */
public final class Pair<A, B> implements Serializable {
    private final A first;
    private final B second;

    public Pair(A a10, B b10) {
        this.first = a10;
        this.second = b10;
    }

    public final A a() {
        return this.first;
    }

    public final B b() {
        return this.second;
    }

    public final A c() {
        return this.first;
    }

    public final B d() {
        return this.second;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (i.b(this.first, pair.first) && i.b(this.second, pair.second)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        A a10 = this.first;
        int i10 = 0;
        if (a10 == null) {
            hashCode = 0;
        } else {
            hashCode = a10.hashCode();
        }
        int i11 = hashCode * 31;
        B b10 = this.second;
        if (b10 != null) {
            i10 = b10.hashCode();
        }
        return i11 + i10;
    }

    public String toString() {
        return '(' + this.first + ", " + this.second + ')';
    }
}
