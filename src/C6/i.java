package c6;

import android.graphics.Path;
import android.graphics.PointF;
import com.oplus.anim.C0820a;
import m6.C1337c;

/* compiled from: PathKeyframe.java */
/* loaded from: classes3.dex */
public class i extends C1337c<PointF> {

    /* renamed from: q, reason: collision with root package name */
    public Path f12824q;

    /* renamed from: r, reason: collision with root package name */
    public final C1337c<PointF> f12825r;

    public i(C0820a c0820a, C1337c<PointF> c1337c) {
        super(c0820a, c1337c.f35155b, c1337c.f35156c, c1337c.f35157d, c1337c.f35158e, c1337c.f35159f, c1337c.f35160g, c1337c.f35161h);
        this.f12825r = c1337c;
        j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void j() {
        boolean z10;
        T t10;
        T t11;
        T t12 = this.f35156c;
        if (t12 != 0 && (t11 = this.f35155b) != 0 && ((PointF) t11).equals(((PointF) t12).x, ((PointF) t12).y)) {
            z10 = true;
        } else {
            z10 = false;
        }
        T t13 = this.f35155b;
        if (t13 != 0 && (t10 = this.f35156c) != 0 && !z10) {
            C1337c<PointF> c1337c = this.f12825r;
            this.f12824q = l6.h.d((PointF) t13, (PointF) t10, c1337c.f35168o, c1337c.f35169p);
        }
    }

    public Path k() {
        return this.f12824q;
    }
}
