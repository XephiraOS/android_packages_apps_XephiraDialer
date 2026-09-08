package H1;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.i;

/* compiled from: EventProduct.kt */
/* loaded from: classes.dex */
public abstract class d<P> {

    /* renamed from: a, reason: collision with root package name */
    public final P f1262a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f1263b = new AtomicBoolean(false);

    public d(P p10) {
        this.f1262a = p10;
    }

    public final P a() {
        if (this.f1263b.compareAndSet(false, true)) {
            return this.f1262a;
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (dVar.f1263b.get() == this.f1263b.get() && i.b(dVar.f1262a, this.f1262a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i10;
        P p10 = this.f1262a;
        if (p10 != null) {
            i10 = p10.hashCode();
        } else {
            i10 = 0;
        }
        return (i10 * 31) + Boolean.hashCode(this.f1263b.get());
    }
}
