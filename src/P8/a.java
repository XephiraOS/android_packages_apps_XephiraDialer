package P8;

import kotlin.jvm.internal.i;

/* compiled from: VideoBackgroundSource.kt */
/* loaded from: classes4.dex */
public final class a<T> implements b<T> {

    /* renamed from: a, reason: collision with root package name */
    public final T f2970a;

    public a(T t10) {
        this.f2970a = t10;
    }

    @Override // P8.b
    public T e() {
        return this.f2970a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        return i.b(e(), ((a) obj).e());
    }

    public int hashCode() {
        int i10;
        T e10 = e();
        if (e10 != null) {
            i10 = e10.hashCode();
        } else {
            i10 = 0;
        }
        return i10 * 31;
    }

    public String toString() {
        return String.valueOf(e());
    }
}
