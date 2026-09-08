package h6;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.model.layer.Layer;

/* compiled from: NullLayer.java */
/* loaded from: classes3.dex */
public class c extends com.oplus.anim.model.layer.a {
    public c(EffectiveAnimationDrawable effectiveAnimationDrawable, Layer layer) {
        super(effectiveAnimationDrawable, layer);
    }

    @Override // com.oplus.anim.model.layer.a, b6.e
    public void e(RectF rectF, Matrix matrix, boolean z10) {
        super.e(rectF, matrix, z10);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // com.oplus.anim.model.layer.a
    public void u(Canvas canvas, Matrix matrix, int i10) {
    }
}
