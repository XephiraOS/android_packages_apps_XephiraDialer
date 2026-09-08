package c6;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
import m6.C1336b;
import m6.C1337c;

/* compiled from: PathKeyframeAnimation.java */
/* loaded from: classes3.dex */
public class j extends AbstractC0564g<PointF> {

    /* renamed from: i, reason: collision with root package name */
    public final PointF f12826i;

    /* renamed from: j, reason: collision with root package name */
    public final float[] f12827j;

    /* renamed from: k, reason: collision with root package name */
    public final PathMeasure f12828k;

    /* renamed from: l, reason: collision with root package name */
    public i f12829l;

    public j(List<? extends C1337c<PointF>> list) {
        super(list);
        this.f12826i = new PointF();
        this.f12827j = new float[2];
        this.f12828k = new PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // c6.AbstractC0558a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public PointF i(C1337c<PointF> c1337c, float f10) {
        PointF pointF;
        i iVar = (i) c1337c;
        Path k10 = iVar.k();
        if (k10 == null) {
            return c1337c.f35155b;
        }
        C1336b<A> c1336b = this.f12801e;
        if (c1336b != 0 && (pointF = (PointF) c1336b.b(iVar.f35160g, iVar.f35161h.floatValue(), (PointF) iVar.f35155b, (PointF) iVar.f35156c, e(), f10, f())) != null) {
            return pointF;
        }
        if (this.f12829l != iVar) {
            this.f12828k.setPath(k10, false);
            this.f12829l = iVar;
        }
        PathMeasure pathMeasure = this.f12828k;
        pathMeasure.getPosTan(f10 * pathMeasure.getLength(), this.f12827j, null);
        PointF pointF2 = this.f12826i;
        float[] fArr = this.f12827j;
        pointF2.set(fArr[0], fArr[1]);
        return this.f12826i;
    }
}
