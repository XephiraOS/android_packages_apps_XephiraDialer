package h6;

import a6.C0423a;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import c6.AbstractC0558a;
import c6.q;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.I;
import com.oplus.anim.model.layer.Layer;
import com.oplus.anim.r;
import l6.h;
import m6.C1336b;

/* compiled from: ImageLayer.java */
/* renamed from: h6.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1083b extends com.oplus.anim.model.layer.a {

    /* renamed from: D, reason: collision with root package name */
    public final Paint f32062D;

    /* renamed from: E, reason: collision with root package name */
    public final Rect f32063E;

    /* renamed from: F, reason: collision with root package name */
    public final Rect f32064F;

    /* renamed from: G, reason: collision with root package name */
    public final I f32065G;

    /* renamed from: H, reason: collision with root package name */
    public AbstractC0558a<ColorFilter, ColorFilter> f32066H;

    /* renamed from: I, reason: collision with root package name */
    public AbstractC0558a<Bitmap, Bitmap> f32067I;

    public C1083b(EffectiveAnimationDrawable effectiveAnimationDrawable, Layer layer) {
        super(effectiveAnimationDrawable, layer);
        this.f32062D = new C0423a(3);
        this.f32063E = new Rect();
        this.f32064F = new Rect();
        this.f32065G = effectiveAnimationDrawable.R(layer.m());
    }

    public final Bitmap P() {
        Bitmap h10;
        AbstractC0558a<Bitmap, Bitmap> abstractC0558a = this.f32067I;
        if (abstractC0558a != null && (h10 = abstractC0558a.h()) != null) {
            return h10;
        }
        Bitmap J10 = this.f26097p.J(this.f26098q.m());
        if (J10 != null) {
            return J10;
        }
        I i10 = this.f32065G;
        if (i10 != null) {
            return i10.a();
        }
        return null;
    }

    @Override // com.oplus.anim.model.layer.a, b6.e
    public void e(RectF rectF, Matrix matrix, boolean z10) {
        super.e(rectF, matrix, z10);
        if (this.f32065G != null) {
            float e10 = h.e();
            rectF.set(0.0f, 0.0f, this.f32065G.e() * e10, this.f32065G.c() * e10);
            this.f26096o.mapRect(rectF);
        }
    }

    @Override // com.oplus.anim.model.layer.a, e6.f
    public <T> void i(T t10, C1336b<T> c1336b) {
        super.i(t10, c1336b);
        if (t10 == r.f26168K) {
            if (c1336b == null) {
                this.f32066H = null;
                return;
            } else {
                this.f32066H = new q(c1336b);
                return;
            }
        }
        if (t10 == r.f26171N) {
            if (c1336b == null) {
                this.f32067I = null;
            } else {
                this.f32067I = new q(c1336b);
            }
        }
    }

    @Override // com.oplus.anim.model.layer.a
    public void u(Canvas canvas, Matrix matrix, int i10) {
        Bitmap P10 = P();
        if (P10 != null && !P10.isRecycled() && this.f32065G != null) {
            float e10 = h.e();
            this.f32062D.setAlpha(i10);
            AbstractC0558a<ColorFilter, ColorFilter> abstractC0558a = this.f32066H;
            if (abstractC0558a != null) {
                this.f32062D.setColorFilter(abstractC0558a.h());
            }
            canvas.save();
            canvas.concat(matrix);
            this.f32063E.set(0, 0, P10.getWidth(), P10.getHeight());
            if (this.f26097p.S()) {
                this.f32064F.set(0, 0, (int) (this.f32065G.e() * e10), (int) (this.f32065G.c() * e10));
            } else {
                this.f32064F.set(0, 0, (int) (P10.getWidth() * e10), (int) (P10.getHeight() * e10));
            }
            canvas.drawBitmap(P10, this.f32063E, this.f32064F, this.f32062D);
            canvas.restore();
        }
    }
}
