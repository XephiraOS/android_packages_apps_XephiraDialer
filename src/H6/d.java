package h6;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.oplus.anim.C0820a;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.model.layer.Layer;
import g6.C1048a;
import g6.k;
import j6.C1182j;
import java.util.Collections;
import java.util.List;

/* compiled from: ShapeLayer.java */
/* loaded from: classes3.dex */
public class d extends com.oplus.anim.model.layer.a {

    /* renamed from: D, reason: collision with root package name */
    public final b6.d f32068D;

    /* renamed from: E, reason: collision with root package name */
    public final com.oplus.anim.model.layer.b f32069E;

    public d(EffectiveAnimationDrawable effectiveAnimationDrawable, Layer layer, com.oplus.anim.model.layer.b bVar, C0820a c0820a) {
        super(effectiveAnimationDrawable, layer);
        this.f32069E = bVar;
        b6.d dVar = new b6.d(effectiveAnimationDrawable, this, new k("__container", layer.n(), false), c0820a);
        this.f32068D = dVar;
        dVar.b(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.oplus.anim.model.layer.a
    public void I(e6.e eVar, int i10, List<e6.e> list, e6.e eVar2) {
        this.f32068D.g(eVar, i10, list, eVar2);
    }

    @Override // com.oplus.anim.model.layer.a, b6.e
    public void e(RectF rectF, Matrix matrix, boolean z10) {
        super.e(rectF, matrix, z10);
        this.f32068D.e(rectF, this.f26096o, z10);
    }

    @Override // com.oplus.anim.model.layer.a
    public void u(Canvas canvas, Matrix matrix, int i10) {
        this.f32068D.h(canvas, matrix, i10);
    }

    @Override // com.oplus.anim.model.layer.a
    public C1048a w() {
        C1048a w10 = super.w();
        if (w10 != null) {
            return w10;
        }
        return this.f32069E.w();
    }

    @Override // com.oplus.anim.model.layer.a
    public C1182j y() {
        C1182j y10 = super.y();
        if (y10 != null) {
            return y10;
        }
        return this.f32069E.y();
    }
}
