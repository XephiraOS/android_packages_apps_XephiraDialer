package h6;

import a6.C0423a;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import c6.AbstractC0558a;
import c6.q;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.model.layer.Layer;
import com.oplus.anim.r;
import m6.C1336b;

/* compiled from: SolidLayer.java */
/* loaded from: classes3.dex */
public class e extends com.oplus.anim.model.layer.a {

    /* renamed from: D, reason: collision with root package name */
    public final RectF f32070D;

    /* renamed from: E, reason: collision with root package name */
    public final Paint f32071E;

    /* renamed from: F, reason: collision with root package name */
    public final float[] f32072F;

    /* renamed from: G, reason: collision with root package name */
    public final Path f32073G;

    /* renamed from: H, reason: collision with root package name */
    public final Layer f32074H;

    /* renamed from: I, reason: collision with root package name */
    public AbstractC0558a<ColorFilter, ColorFilter> f32075I;

    public e(EffectiveAnimationDrawable effectiveAnimationDrawable, Layer layer) {
        super(effectiveAnimationDrawable, layer);
        this.f32070D = new RectF();
        C0423a c0423a = new C0423a();
        this.f32071E = c0423a;
        this.f32072F = new float[8];
        this.f32073G = new Path();
        this.f32074H = layer;
        c0423a.setAlpha(0);
        c0423a.setStyle(Paint.Style.FILL);
        c0423a.setColor(layer.o());
    }

    @Override // com.oplus.anim.model.layer.a, b6.e
    public void e(RectF rectF, Matrix matrix, boolean z10) {
        super.e(rectF, matrix, z10);
        this.f32070D.set(0.0f, 0.0f, this.f32074H.q(), this.f32074H.p());
        this.f26096o.mapRect(this.f32070D);
        rectF.set(this.f32070D);
    }

    @Override // com.oplus.anim.model.layer.a, e6.f
    public <T> void i(T t10, C1336b<T> c1336b) {
        super.i(t10, c1336b);
        if (t10 == r.f26168K) {
            if (c1336b == null) {
                this.f32075I = null;
            } else {
                this.f32075I = new q(c1336b);
            }
        }
    }

    @Override // com.oplus.anim.model.layer.a
    public void u(Canvas canvas, Matrix matrix, int i10) {
        int intValue;
        int alpha = Color.alpha(this.f32074H.o());
        if (alpha == 0) {
            return;
        }
        if (this.f26105x.h() == null) {
            intValue = 100;
        } else {
            intValue = this.f26105x.h().h().intValue();
        }
        int i11 = (int) ((i10 / 255.0f) * (((alpha / 255.0f) * intValue) / 100.0f) * 255.0f);
        this.f32071E.setAlpha(i11);
        AbstractC0558a<ColorFilter, ColorFilter> abstractC0558a = this.f32075I;
        if (abstractC0558a != null) {
            this.f32071E.setColorFilter(abstractC0558a.h());
        }
        if (i11 > 0) {
            float[] fArr = this.f32072F;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.f32074H.q();
            float[] fArr2 = this.f32072F;
            fArr2[3] = 0.0f;
            fArr2[4] = this.f32074H.q();
            this.f32072F[5] = this.f32074H.p();
            float[] fArr3 = this.f32072F;
            fArr3[6] = 0.0f;
            fArr3[7] = this.f32074H.p();
            matrix.mapPoints(this.f32072F);
            this.f32073G.reset();
            Path path = this.f32073G;
            float[] fArr4 = this.f32072F;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.f32073G;
            float[] fArr5 = this.f32072F;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.f32073G;
            float[] fArr6 = this.f32072F;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.f32073G;
            float[] fArr7 = this.f32072F;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.f32073G;
            float[] fArr8 = this.f32072F;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.f32073G.close();
            canvas.drawPath(this.f32073G, this.f32071E);
        }
    }
}
