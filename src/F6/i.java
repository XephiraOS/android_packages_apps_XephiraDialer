package f6;

import android.graphics.PointF;
import c6.AbstractC0558a;
import java.util.List;
import m6.C1337c;

/* compiled from: AnimatableSplitDimensionPathValue.java */
/* loaded from: classes3.dex */
public class i implements m<PointF, PointF> {

    /* renamed from: a, reason: collision with root package name */
    public final C1015b f31755a;

    /* renamed from: b, reason: collision with root package name */
    public final C1015b f31756b;

    public i(C1015b c1015b, C1015b c1015b2) {
        this.f31755a = c1015b;
        this.f31756b = c1015b2;
    }

    @Override // f6.m
    public AbstractC0558a<PointF, PointF> a() {
        return new c6.n(this.f31755a.a(), this.f31756b.a());
    }

    @Override // f6.m
    public List<C1337c<PointF>> b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // f6.m
    public boolean c() {
        if (this.f31755a.c() && this.f31756b.c()) {
            return true;
        }
        return false;
    }
}
