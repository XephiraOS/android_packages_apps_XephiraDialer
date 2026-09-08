package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import x4.i;

/* compiled from: CutoutDrawable.java */
/* loaded from: classes3.dex */
public class h extends x4.i {

    /* renamed from: a, reason: collision with root package name */
    public b f24073a;

    /* compiled from: CutoutDrawable.java */
    /* loaded from: classes3.dex */
    public static class c extends h {
        public c(b bVar) {
            super(bVar);
        }

        @Override // x4.i
        public void drawStrokeShape(Canvas canvas) {
            if (this.f24073a.f24074w.isEmpty()) {
                super.drawStrokeShape(canvas);
                return;
            }
            canvas.save();
            canvas.clipOutRect(this.f24073a.f24074w);
            super.drawStrokeShape(canvas);
            canvas.restore();
        }
    }

    public static h b(b bVar) {
        return new c(bVar);
    }

    public static h c(x4.n nVar) {
        if (nVar == null) {
            nVar = new x4.n();
        }
        return b(new b(nVar, new RectF()));
    }

    public boolean d() {
        return !this.f24073a.f24074w.isEmpty();
    }

    public void e() {
        f(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void f(float f10, float f11, float f12, float f13) {
        if (f10 != this.f24073a.f24074w.left || f11 != this.f24073a.f24074w.top || f12 != this.f24073a.f24074w.right || f13 != this.f24073a.f24074w.bottom) {
            this.f24073a.f24074w.set(f10, f11, f12, f13);
            invalidateSelf();
        }
    }

    public void g(RectF rectF) {
        f(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    @Override // x4.i, android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f24073a = new b(this.f24073a);
        return this;
    }

    /* compiled from: CutoutDrawable.java */
    /* loaded from: classes3.dex */
    public static final class b extends i.c {

        /* renamed from: w, reason: collision with root package name */
        public final RectF f24074w;

        @Override // x4.i.c, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            h b10 = h.b(this);
            b10.invalidateSelf();
            return b10;
        }

        public b(x4.n nVar, RectF rectF) {
            super(nVar, null);
            this.f24074w = rectF;
        }

        public b(b bVar) {
            super(bVar);
            this.f24074w = bVar.f24074w;
        }
    }

    public h(b bVar) {
        super(bVar);
        this.f24073a = bVar;
    }
}
