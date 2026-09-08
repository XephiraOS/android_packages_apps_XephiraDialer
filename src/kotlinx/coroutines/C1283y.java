package kotlinx.coroutines;

/* compiled from: CompletionState.kt */
/* renamed from: kotlinx.coroutines.y, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1283y {

    /* renamed from: a, reason: collision with root package name */
    public final Object f34651a;

    /* renamed from: b, reason: collision with root package name */
    public final v9.l<Throwable, m9.q> f34652b;

    /* JADX WARN: Multi-variable type inference failed */
    public C1283y(Object obj, v9.l<? super Throwable, m9.q> lVar) {
        this.f34651a = obj;
        this.f34652b = lVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1283y)) {
            return false;
        }
        C1283y c1283y = (C1283y) obj;
        if (kotlin.jvm.internal.i.b(this.f34651a, c1283y.f34651a) && kotlin.jvm.internal.i.b(this.f34652b, c1283y.f34652b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        Object obj = this.f34651a;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        return (hashCode * 31) + this.f34652b.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f34651a + ", onCancellation=" + this.f34652b + ')';
    }
}
