package t4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;
import j0.AbstractC1152b;
import t4.AbstractC1591b;
import t4.g;

/* compiled from: DeterminateDrawable.java */
/* loaded from: classes3.dex */
public final class e<S extends AbstractC1591b> extends f {

    /* renamed from: z, reason: collision with root package name */
    public static final androidx.dynamicanimation.animation.d<e<?>> f37209z = new a("indicatorLevel");

    /* renamed from: p, reason: collision with root package name */
    public g<S> f37210p;

    /* renamed from: q, reason: collision with root package name */
    public final androidx.dynamicanimation.animation.g f37211q;

    /* renamed from: r, reason: collision with root package name */
    public final androidx.dynamicanimation.animation.f f37212r;

    /* renamed from: x, reason: collision with root package name */
    public final g.a f37213x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f37214y;

    /* compiled from: DeterminateDrawable.java */
    /* loaded from: classes3.dex */
    public class a extends androidx.dynamicanimation.animation.d<e<?>> {
        public a(String str) {
            super(str);
        }

        @Override // androidx.dynamicanimation.animation.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float getValue(e<?> eVar) {
            return eVar.y() * 10000.0f;
        }

        @Override // androidx.dynamicanimation.animation.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(e<?> eVar, float f10) {
            eVar.A(f10 / 10000.0f);
        }
    }

    public e(Context context, AbstractC1591b abstractC1591b, g<S> gVar) {
        super(context, abstractC1591b);
        this.f37214y = false;
        z(gVar);
        this.f37213x = new g.a();
        androidx.dynamicanimation.animation.g gVar2 = new androidx.dynamicanimation.animation.g();
        this.f37211q = gVar2;
        gVar2.d(1.0f);
        gVar2.f(50.0f);
        androidx.dynamicanimation.animation.f fVar = new androidx.dynamicanimation.animation.f(this, f37209z);
        this.f37212r = fVar;
        fVar.x(gVar2);
        n(1.0f);
    }

    public static e<CircularProgressIndicatorSpec> v(Context context, CircularProgressIndicatorSpec circularProgressIndicatorSpec, c cVar) {
        return new e<>(context, circularProgressIndicatorSpec, cVar);
    }

    public static e<LinearProgressIndicatorSpec> w(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec, j jVar) {
        return new e<>(context, linearProgressIndicatorSpec, jVar);
    }

    public final void A(float f10) {
        this.f37213x.f37234b = f10;
        invalidateSelf();
    }

    public void B(float f10) {
        setLevel((int) (f10 * 10000.0f));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.f37210p.g(canvas, getBounds(), h(), k(), j());
            this.f37228m.setStyle(Paint.Style.FILL);
            this.f37228m.setAntiAlias(true);
            g.a aVar = this.f37213x;
            AbstractC1591b abstractC1591b = this.f37217b;
            aVar.f37235c = abstractC1591b.f37184c[0];
            int i10 = abstractC1591b.f37188g;
            if (i10 > 0) {
                if (!(this.f37210p instanceof j)) {
                    i10 = (int) ((i10 * E.a.a(y(), 0.0f, 0.01f)) / 0.01f);
                }
                this.f37210p.d(canvas, this.f37228m, y(), 1.0f, this.f37217b.f37185d, getAlpha(), i10);
            } else {
                this.f37210p.d(canvas, this.f37228m, 0.0f, 1.0f, abstractC1591b.f37185d, getAlpha(), 0);
            }
            this.f37210p.c(canvas, this.f37228m, this.f37213x, getAlpha());
            this.f37210p.b(canvas, this.f37228m, this.f37217b.f37184c[0], getAlpha());
            canvas.restore();
        }
    }

    @Override // t4.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f37210p.e();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f37210p.f();
    }

    @Override // t4.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // t4.f
    public /* bridge */ /* synthetic */ boolean i() {
        return super.i();
    }

    @Override // t4.f, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    @Override // t4.f
    public /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f37212r.y();
        A(getLevel() / 10000.0f);
    }

    @Override // t4.f
    public /* bridge */ /* synthetic */ boolean k() {
        return super.k();
    }

    @Override // t4.f
    public /* bridge */ /* synthetic */ void m(AbstractC1152b abstractC1152b) {
        super.m(abstractC1152b);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i10) {
        if (this.f37214y) {
            this.f37212r.y();
            A(i10 / 10000.0f);
            return true;
        }
        this.f37212r.m(y() * 10000.0f);
        this.f37212r.s(i10);
        return true;
    }

    @Override // t4.f
    public /* bridge */ /* synthetic */ boolean q(boolean z10, boolean z11, boolean z12) {
        return super.q(z10, z11, z12);
    }

    @Override // t4.f
    public boolean r(boolean z10, boolean z11, boolean z12) {
        boolean r10 = super.r(z10, z11, z12);
        float a10 = this.f37218c.a(this.f37216a.getContentResolver());
        if (a10 == 0.0f) {
            this.f37214y = true;
        } else {
            this.f37214y = false;
            this.f37211q.f(50.0f / a10);
        }
        return r10;
    }

    @Override // t4.f
    public /* bridge */ /* synthetic */ boolean s(AbstractC1152b abstractC1152b) {
        return super.s(abstractC1152b);
    }

    @Override // t4.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i10) {
        super.setAlpha(i10);
    }

    @Override // t4.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // t4.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean z10, boolean z11) {
        return super.setVisible(z10, z11);
    }

    @Override // t4.f, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // t4.f, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    public g<S> x() {
        return this.f37210p;
    }

    public final float y() {
        return this.f37213x.f37234b;
    }

    public void z(g<S> gVar) {
        this.f37210p = gVar;
    }
}
