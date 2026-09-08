package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* compiled from: AppCompatSeekBarHelper.java */
/* renamed from: androidx.appcompat.widget.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0441o extends C0439m {

    /* renamed from: d, reason: collision with root package name */
    public final SeekBar f7879d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f7880e;

    /* renamed from: f, reason: collision with root package name */
    public ColorStateList f7881f;

    /* renamed from: g, reason: collision with root package name */
    public PorterDuff.Mode f7882g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f7883h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f7884i;

    public C0441o(SeekBar seekBar) {
        super(seekBar);
        this.f7881f = null;
        this.f7882g = null;
        this.f7883h = false;
        this.f7884i = false;
        this.f7879d = seekBar;
    }

    @Override // androidx.appcompat.widget.C0439m
    public void c(AttributeSet attributeSet, int i10) {
        super.c(attributeSet, i10);
        Context context = this.f7879d.getContext();
        int[] iArr = e.j.f30387V;
        K w10 = K.w(context, attributeSet, iArr, i10, 0);
        SeekBar seekBar = this.f7879d;
        androidx.core.view.K.h0(seekBar, seekBar.getContext(), iArr, attributeSet, w10.r(), i10, 0);
        Drawable h10 = w10.h(e.j.f30392W);
        if (h10 != null) {
            this.f7879d.setThumb(h10);
        }
        j(w10.g(e.j.f30397X));
        int i11 = e.j.f30407Z;
        if (w10.s(i11)) {
            this.f7882g = u.d(w10.k(i11, -1), this.f7882g);
            this.f7884i = true;
        }
        int i12 = e.j.f30402Y;
        if (w10.s(i12)) {
            this.f7881f = w10.c(i12);
            this.f7883h = true;
        }
        w10.y();
        f();
    }

    public final void f() {
        Drawable drawable = this.f7880e;
        if (drawable != null) {
            if (this.f7883h || this.f7884i) {
                Drawable r10 = C.a.r(drawable.mutate());
                this.f7880e = r10;
                if (this.f7883h) {
                    C.a.o(r10, this.f7881f);
                }
                if (this.f7884i) {
                    C.a.p(this.f7880e, this.f7882g);
                }
                if (this.f7880e.isStateful()) {
                    this.f7880e.setState(this.f7879d.getDrawableState());
                }
            }
        }
    }

    public void g(Canvas canvas) {
        int i10;
        if (this.f7880e != null) {
            int max = this.f7879d.getMax();
            int i11 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f7880e.getIntrinsicWidth();
                int intrinsicHeight = this.f7880e.getIntrinsicHeight();
                if (intrinsicWidth >= 0) {
                    i10 = intrinsicWidth / 2;
                } else {
                    i10 = 1;
                }
                if (intrinsicHeight >= 0) {
                    i11 = intrinsicHeight / 2;
                }
                this.f7880e.setBounds(-i10, -i11, i10, i11);
                float width = ((this.f7879d.getWidth() - this.f7879d.getPaddingLeft()) - this.f7879d.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.f7879d.getPaddingLeft(), this.f7879d.getHeight() / 2);
                for (int i12 = 0; i12 <= max; i12++) {
                    this.f7880e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    public void h() {
        Drawable drawable = this.f7880e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f7879d.getDrawableState())) {
            this.f7879d.invalidateDrawable(drawable);
        }
    }

    public void i() {
        Drawable drawable = this.f7880e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void j(Drawable drawable) {
        Drawable drawable2 = this.f7880e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f7880e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f7879d);
            C.a.m(drawable, this.f7879d.getLayoutDirection());
            if (drawable.isStateful()) {
                drawable.setState(this.f7879d.getDrawableState());
            }
            f();
        }
        this.f7879d.invalidate();
    }
}
