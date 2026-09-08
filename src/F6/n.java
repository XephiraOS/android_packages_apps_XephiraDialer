package f6;

import java.util.Arrays;
import java.util.List;
import m6.C1337c;

/* compiled from: BaseAnimatableValue.java */
/* loaded from: classes3.dex */
public abstract class n<V, O> implements m<V, O> {

    /* renamed from: a, reason: collision with root package name */
    public final List<C1337c<V>> f31770a;

    public n(List<C1337c<V>> list) {
        this.f31770a = list;
    }

    @Override // f6.m
    public List<C1337c<V>> b() {
        return this.f31770a;
    }

    @Override // f6.m
    public boolean c() {
        if (this.f31770a.isEmpty()) {
            return true;
        }
        if (this.f31770a.size() == 1 && this.f31770a.get(0).i()) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f31770a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f31770a.toArray()));
        }
        return sb.toString();
    }
}
