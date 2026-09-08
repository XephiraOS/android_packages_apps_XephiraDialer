package b6;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import c6.AbstractC0558a;
import c6.C0559b;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.model.content.ShapeStroke;
import m6.C1336b;

/* compiled from: StrokeContent.java */
/* loaded from: classes3.dex */
public class t extends AbstractC0527a {

    /* renamed from: r, reason: collision with root package name */
    public final com.oplus.anim.model.layer.a f12324r;

    /* renamed from: s, reason: collision with root package name */
    public final String f12325s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f12326t;

    /* renamed from: u, reason: collision with root package name */
    public final AbstractC0558a<Integer, Integer> f12327u;

    /* renamed from: v, reason: collision with root package name */
    public AbstractC0558a<ColorFilter, ColorFilter> f12328v;

    public t(EffectiveAnimationDrawable effectiveAnimationDrawable, com.oplus.anim.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(effectiveAnimationDrawable, aVar, shapeStroke.b().a(), shapeStroke.e().a(), shapeStroke.g(), shapeStroke.i(), shapeStroke.j(), shapeStroke.f(), shapeStroke.d());
        this.f12324r = aVar;
        this.f12325s = shapeStroke.h();
        this.f12326t = shapeStroke.k();
        AbstractC0558a<Integer, Integer> a10 = shapeStroke.c().a();
        this.f12327u = a10;
        a10.a(this);
        aVar.j(a10);
    }

    @Override // b6.c
    public String getName() {
        return this.f12325s;
    }

    @Override // b6.AbstractC0527a, b6.e
    public void h(Canvas canvas, Matrix matrix, int i10) {
        if (this.f12326t) {
            return;
        }
        this.f12193i.setColor(((C0559b) this.f12327u).p());
        AbstractC0558a<ColorFilter, ColorFilter> abstractC0558a = this.f12328v;
        if (abstractC0558a != null) {
            this.f12193i.setColorFilter(abstractC0558a.h());
        }
        super.h(canvas, matrix, i10);
    }

    @Override // b6.AbstractC0527a, e6.f
    public <T> void i(T t10, C1336b<T> c1336b) {
        super.i(t10, c1336b);
        if (t10 == com.oplus.anim.r.f26174b) {
            this.f12327u.n(c1336b);
            return;
        }
        if (t10 == com.oplus.anim.r.f26168K) {
            AbstractC0558a<ColorFilter, ColorFilter> abstractC0558a = this.f12328v;
            if (abstractC0558a != null) {
                this.f12324r.H(abstractC0558a);
            }
            if (c1336b == null) {
                this.f12328v = null;
                return;
            }
            c6.q qVar = new c6.q(c1336b);
            this.f12328v = qVar;
            qVar.a(this);
            this.f12324r.j(this.f12327u);
        }
    }
}
