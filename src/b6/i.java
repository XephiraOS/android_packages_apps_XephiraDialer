package b6;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import c6.AbstractC0558a;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.model.content.GradientType;
import m6.C1336b;
import p.C1420f;

/* compiled from: GradientStrokeContent.java */
/* loaded from: classes3.dex */
public class i extends AbstractC0527a {

    /* renamed from: A, reason: collision with root package name */
    public final AbstractC0558a<PointF, PointF> f12258A;

    /* renamed from: B, reason: collision with root package name */
    public c6.q f12259B;

    /* renamed from: r, reason: collision with root package name */
    public final String f12260r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f12261s;

    /* renamed from: t, reason: collision with root package name */
    public final C1420f<LinearGradient> f12262t;

    /* renamed from: u, reason: collision with root package name */
    public final C1420f<RadialGradient> f12263u;

    /* renamed from: v, reason: collision with root package name */
    public final RectF f12264v;

    /* renamed from: w, reason: collision with root package name */
    public final GradientType f12265w;

    /* renamed from: x, reason: collision with root package name */
    public final int f12266x;

    /* renamed from: y, reason: collision with root package name */
    public final AbstractC0558a<g6.d, g6.d> f12267y;

    /* renamed from: z, reason: collision with root package name */
    public final AbstractC0558a<PointF, PointF> f12268z;

    public i(EffectiveAnimationDrawable effectiveAnimationDrawable, com.oplus.anim.model.layer.a aVar, com.oplus.anim.model.content.a aVar2) {
        super(effectiveAnimationDrawable, aVar, aVar2.b().a(), aVar2.g().a(), aVar2.i(), aVar2.k(), aVar2.m(), aVar2.h(), aVar2.c());
        this.f12262t = new C1420f<>();
        this.f12263u = new C1420f<>();
        this.f12264v = new RectF();
        this.f12260r = aVar2.j();
        this.f12265w = aVar2.f();
        this.f12261s = aVar2.n();
        this.f12266x = (int) (effectiveAnimationDrawable.L().d() / 32.0f);
        AbstractC0558a<g6.d, g6.d> a10 = aVar2.e().a();
        this.f12267y = a10;
        a10.a(this);
        aVar.j(a10);
        AbstractC0558a<PointF, PointF> a11 = aVar2.l().a();
        this.f12268z = a11;
        a11.a(this);
        aVar.j(a11);
        AbstractC0558a<PointF, PointF> a12 = aVar2.d().a();
        this.f12258A = a12;
        a12.a(this);
        aVar.j(a12);
    }

    @Override // b6.c
    public String getName() {
        return this.f12260r;
    }

    @Override // b6.AbstractC0527a, b6.e
    public void h(Canvas canvas, Matrix matrix, int i10) {
        Shader n10;
        if (this.f12261s) {
            return;
        }
        e(this.f12264v, matrix, false);
        if (this.f12265w == GradientType.LINEAR) {
            n10 = m();
        } else {
            n10 = n();
        }
        n10.setLocalMatrix(matrix);
        this.f12193i.setShader(n10);
        super.h(canvas, matrix, i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b6.AbstractC0527a, e6.f
    public <T> void i(T t10, C1336b<T> c1336b) {
        super.i(t10, c1336b);
        if (t10 == com.oplus.anim.r.f26169L) {
            c6.q qVar = this.f12259B;
            if (qVar != null) {
                this.f12190f.H(qVar);
            }
            if (c1336b == null) {
                this.f12259B = null;
                return;
            }
            c6.q qVar2 = new c6.q(c1336b);
            this.f12259B = qVar2;
            qVar2.a(this);
            this.f12190f.j(this.f12259B);
        }
    }

    public final int[] k(int[] iArr) {
        c6.q qVar = this.f12259B;
        if (qVar != null) {
            Integer[] numArr = (Integer[]) qVar.h();
            int i10 = 0;
            if (iArr.length == numArr.length) {
                while (i10 < iArr.length) {
                    iArr[i10] = numArr[i10].intValue();
                    i10++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i10 < numArr.length) {
                    iArr[i10] = numArr[i10].intValue();
                    i10++;
                }
            }
        }
        return iArr;
    }

    public final int l() {
        int i10;
        int round = Math.round(this.f12268z.f() * this.f12266x);
        int round2 = Math.round(this.f12258A.f() * this.f12266x);
        int round3 = Math.round(this.f12267y.f() * this.f12266x);
        if (round != 0) {
            i10 = 527 * round;
        } else {
            i10 = 17;
        }
        if (round2 != 0) {
            i10 = i10 * 31 * round2;
        }
        if (round3 != 0) {
            return i10 * 31 * round3;
        }
        return i10;
    }

    public final LinearGradient m() {
        long l10 = l();
        LinearGradient d10 = this.f12262t.d(l10);
        if (d10 != null) {
            return d10;
        }
        PointF h10 = this.f12268z.h();
        PointF h11 = this.f12258A.h();
        g6.d h12 = this.f12267y.h();
        LinearGradient linearGradient = new LinearGradient(h10.x, h10.y, h11.x, h11.y, k(h12.c()), h12.d(), Shader.TileMode.CLAMP);
        this.f12262t.h(l10, linearGradient);
        return linearGradient;
    }

    public final RadialGradient n() {
        long l10 = l();
        RadialGradient d10 = this.f12263u.d(l10);
        if (d10 != null) {
            return d10;
        }
        PointF h10 = this.f12268z.h();
        PointF h11 = this.f12258A.h();
        g6.d h12 = this.f12267y.h();
        int[] k10 = k(h12.c());
        float[] d11 = h12.d();
        RadialGradient radialGradient = new RadialGradient(h10.x, h10.y, (float) Math.hypot(h11.x - r7, h11.y - r8), k10, d11, Shader.TileMode.CLAMP);
        this.f12263u.h(l10, radialGradient);
        return radialGradient;
    }
}
