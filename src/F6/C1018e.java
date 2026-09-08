package f6;

import android.graphics.PointF;
import c6.AbstractC0558a;
import java.util.List;
import m6.C1337c;

/* compiled from: AnimatablePathValue.java */
/* renamed from: f6.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1018e implements m<PointF, PointF> {

    /* renamed from: a, reason: collision with root package name */
    public final List<C1337c<PointF>> f31754a;

    public C1018e(List<C1337c<PointF>> list) {
        this.f31754a = list;
    }

    @Override // f6.m
    public AbstractC0558a<PointF, PointF> a() {
        if (this.f31754a.get(0).i()) {
            return new c6.k(this.f31754a);
        }
        return new c6.j(this.f31754a);
    }

    @Override // f6.m
    public List<C1337c<PointF>> b() {
        return this.f31754a;
    }

    @Override // f6.m
    public boolean c() {
        if (this.f31754a.size() != 1 || !this.f31754a.get(0).i()) {
            return false;
        }
        return true;
    }
}
