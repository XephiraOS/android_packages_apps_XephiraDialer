package t4;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;
import j0.AbstractC1152b;
import j0.C1157g;
import t4.AbstractC1591b;
import t4.g;

/* compiled from: IndeterminateDrawable.java */
/* loaded from: classes3.dex */
public final class i<S extends AbstractC1591b> extends f {

    /* renamed from: p, reason: collision with root package name */
    public g<S> f37239p;

    /* renamed from: q, reason: collision with root package name */
    public h<ObjectAnimator> f37240q;

    /* renamed from: r, reason: collision with root package name */
    public Drawable f37241r;

    public i(Context context, AbstractC1591b abstractC1591b, g<S> gVar, h<ObjectAnimator> hVar) {
        super(context, abstractC1591b);
        z(gVar);
        y(hVar);
    }

    public static i<CircularProgressIndicatorSpec> t(Context context, CircularProgressIndicatorSpec circularProgressIndicatorSpec, c cVar) {
        i<CircularProgressIndicatorSpec> iVar = new i<>(context, circularProgressIndicatorSpec, cVar, new d(circularProgressIndicatorSpec));
        iVar.A(C1157g.b(context.getResources(), e4.f.f30827d, null));
        return iVar;
    }

    public static i<LinearProgressIndicatorSpec> u(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec, j jVar) {
        h lVar;
        if (linearProgressIndicatorSpec.f23520h == 0) {
            lVar = new k(linearProgressIndicatorSpec);
        } else {
            lVar = new l(context, linearProgressIndicatorSpec);
        }
        return new i<>(context, linearProgressIndicatorSpec, jVar, lVar);
    }

    public void A(Drawable drawable) {
        this.f37241r = drawable;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable;
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            if (x() && (drawable = this.f37241r) != null) {
                drawable.setBounds(getBounds());
                C.a.n(this.f37241r, this.f37217b.f37184c[0]);
                this.f37241r.draw(canvas);
                return;
            }
            canvas.save();
            this.f37239p.g(canvas, getBounds(), h(), k(), j());
            int i10 = this.f37217b.f37188g;
            int alpha = getAlpha();
            if (i10 == 0) {
                this.f37239p.d(canvas, this.f37228m, 0.0f, 1.0f, this.f37217b.f37185d, alpha, 0);
            } else {
                g.a aVar = this.f37240q.f37238b.get(0);
                g.a aVar2 = this.f37240q.f37238b.get(r3.size() - 1);
                g<S> gVar = this.f37239p;
                if (gVar instanceof j) {
                    gVar.d(canvas, this.f37228m, 0.0f, aVar.f37233a, this.f37217b.f37185d, alpha, i10);
                    this.f37239p.d(canvas, this.f37228m, aVar2.f37234b, 1.0f, this.f37217b.f37185d, alpha, i10);
                } else {
                    alpha = 0;
                    gVar.d(canvas, this.f37228m, aVar2.f37234b, 1.0f + aVar.f37233a, this.f37217b.f37185d, 0, i10);
                }
            }
            for (int i11 = 0; i11 < this.f37240q.f37238b.size(); i11++) {
                g.a aVar3 = this.f37240q.f37238b.get(i11);
                this.f37239p.c(canvas, this.f37228m, aVar3, getAlpha());
                if (i11 > 0 && i10 > 0) {
                    this.f37239p.d(canvas, this.f37228m, this.f37240q.f37238b.get(i11 - 1).f37234b, aVar3.f37233a, this.f37217b.f37185d, alpha, i10);
                }
            }
            canvas.restore();
        }
    }

    @Override // t4.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f37239p.e();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f37239p.f();
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

    @Override // t4.f
    public /* bridge */ /* synthetic */ boolean k() {
        return super.k();
    }

    @Override // t4.f
    public /* bridge */ /* synthetic */ void m(AbstractC1152b abstractC1152b) {
        super.m(abstractC1152b);
    }

    @Override // t4.f
    public /* bridge */ /* synthetic */ boolean q(boolean z10, boolean z11, boolean z12) {
        return super.q(z10, z11, z12);
    }

    @Override // t4.f
    public boolean r(boolean z10, boolean z11, boolean z12) {
        Drawable drawable;
        boolean r10 = super.r(z10, z11, z12);
        if (x() && (drawable = this.f37241r) != null) {
            return drawable.setVisible(z10, z11);
        }
        if (!isRunning()) {
            this.f37240q.a();
        }
        if (z10 && z12) {
            this.f37240q.g();
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

    public h<ObjectAnimator> v() {
        return this.f37240q;
    }

    public g<S> w() {
        return this.f37239p;
    }

    public final boolean x() {
        C1590a c1590a = this.f37218c;
        if (c1590a == null || c1590a.a(this.f37216a.getContentResolver()) != 0.0f) {
            return false;
        }
        return true;
    }

    public void y(h<ObjectAnimator> hVar) {
        this.f37240q = hVar;
        hVar.e(this);
    }

    public void z(g<S> gVar) {
        this.f37239p = gVar;
    }
}
