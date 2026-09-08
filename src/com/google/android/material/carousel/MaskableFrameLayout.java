package com.google.android.material.carousel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.google.android.material.carousel.MaskableFrameLayout;
import f4.C1001b;
import h4.C1079a;
import j4.g;
import j4.k;
import x4.C1679a;
import x4.d;
import x4.n;
import x4.r;
import x4.s;

/* loaded from: classes3.dex */
public class MaskableFrameLayout extends FrameLayout implements g, r {

    /* renamed from: a, reason: collision with root package name */
    public float f22942a;

    /* renamed from: b, reason: collision with root package name */
    public final RectF f22943b;

    /* renamed from: c, reason: collision with root package name */
    public n f22944c;

    /* renamed from: d, reason: collision with root package name */
    public final s f22945d;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f22946e;

    public MaskableFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static /* synthetic */ d d(d dVar) {
        if (dVar instanceof C1679a) {
            return x4.c.b((C1679a) dVar);
        }
        return dVar;
    }

    public final /* synthetic */ void c(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.f22945d.e(canvas, new C1079a.InterfaceC0303a() { // from class: j4.i
            @Override // h4.C1079a.InterfaceC0303a
            public final void a(Canvas canvas2) {
                MaskableFrameLayout.this.c(canvas2);
            }
        });
    }

    public final void e() {
        this.f22945d.f(this, this.f22943b);
    }

    public final void f() {
        if (this.f22942a != -1.0f) {
            float b10 = C1001b.b(0.0f, getWidth() / 2.0f, 0.0f, 1.0f, this.f22942a);
            setMaskRectF(new RectF(b10, 0.0f, getWidth() - b10, getHeight()));
        }
    }

    @Override // android.view.View
    public void getFocusedRect(Rect rect) {
        RectF rectF = this.f22943b;
        rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    public RectF getMaskRectF() {
        return this.f22943b;
    }

    @Deprecated
    public float getMaskXPercentage() {
        return this.f22942a;
    }

    public n getShapeAppearanceModel() {
        return this.f22944c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Boolean bool = this.f22946e;
        if (bool != null) {
            this.f22945d.h(this, bool.booleanValue());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f22946e = Boolean.valueOf(this.f22945d.c());
        this.f22945d.h(this, true);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (this.f22942a != -1.0f) {
            f();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f22943b.isEmpty() && motionEvent.getAction() == 0) {
            if (!this.f22943b.contains(motionEvent.getX(), motionEvent.getY())) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceCompatClipping(boolean z10) {
        this.f22945d.h(this, z10);
    }

    @Override // j4.g
    public void setMaskRectF(RectF rectF) {
        this.f22943b.set(rectF);
        e();
    }

    @Deprecated
    public void setMaskXPercentage(float f10) {
        float a10 = E.a.a(f10, 0.0f, 1.0f);
        if (this.f22942a != a10) {
            this.f22942a = a10;
            f();
        }
    }

    @Override // x4.r
    public void setShapeAppearanceModel(n nVar) {
        n y10 = nVar.y(new n.c() { // from class: j4.h
            @Override // x4.n.c
            public final x4.d a(x4.d dVar) {
                x4.d d10;
                d10 = MaskableFrameLayout.d(dVar);
                return d10;
            }
        });
        this.f22944c = y10;
        this.f22945d.g(this, y10);
    }

    public MaskableFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f22942a = -1.0f;
        this.f22943b = new RectF();
        this.f22945d = s.a(this);
        this.f22946e = null;
        setShapeAppearanceModel(n.f(context, attributeSet, i10, 0, 0).m());
    }

    public void setOnMaskChangedListener(k kVar) {
    }
}
