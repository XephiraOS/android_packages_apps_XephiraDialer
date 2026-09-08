package o;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* compiled from: RoundRectDrawable.java */
/* renamed from: o.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1386d extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public float f35644a;

    /* renamed from: c, reason: collision with root package name */
    public final RectF f35646c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f35647d;

    /* renamed from: e, reason: collision with root package name */
    public float f35648e;

    /* renamed from: h, reason: collision with root package name */
    public ColorStateList f35651h;

    /* renamed from: i, reason: collision with root package name */
    public PorterDuffColorFilter f35652i;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f35653j;

    /* renamed from: f, reason: collision with root package name */
    public boolean f35649f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f35650g = true;

    /* renamed from: k, reason: collision with root package name */
    public PorterDuff.Mode f35654k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f35645b = new Paint(5);

    public C1386d(ColorStateList colorStateList, float f10) {
        this.f35644a = f10;
        e(colorStateList);
        this.f35646c = new RectF();
        this.f35647d = new Rect();
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList != null && mode != null) {
            return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
        }
        return null;
    }

    public ColorStateList b() {
        return this.f35651h;
    }

    public float c() {
        return this.f35648e;
    }

    public float d() {
        return this.f35644a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z10;
        Paint paint = this.f35645b;
        if (this.f35652i != null && paint.getColorFilter() == null) {
            paint.setColorFilter(this.f35652i);
            z10 = true;
        } else {
            z10 = false;
        }
        RectF rectF = this.f35646c;
        float f10 = this.f35644a;
        canvas.drawRoundRect(rectF, f10, f10, paint);
        if (z10) {
            paint.setColorFilter(null);
        }
    }

    public final void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f35651h = colorStateList;
        this.f35645b.setColor(colorStateList.getColorForState(getState(), this.f35651h.getDefaultColor()));
    }

    public void f(ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    public void g(float f10, boolean z10, boolean z11) {
        if (f10 == this.f35648e && this.f35649f == z10 && this.f35650g == z11) {
            return;
        }
        this.f35648e = f10;
        this.f35649f = z10;
        this.f35650g = z11;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f35647d, this.f35644a);
    }

    public void h(float f10) {
        if (f10 == this.f35644a) {
            return;
        }
        this.f35644a = f10;
        i(null);
        invalidateSelf();
    }

    public final void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f35646c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f35647d.set(rect);
        if (this.f35649f) {
            this.f35647d.inset((int) Math.ceil(C1387e.a(this.f35648e, this.f35644a, this.f35650g)), (int) Math.ceil(C1387e.b(this.f35648e, this.f35644a, this.f35650g)));
            this.f35646c.set(this.f35647d);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f35653j;
        if ((colorStateList2 != null && colorStateList2.isStateful()) || (((colorStateList = this.f35651h) != null && colorStateList.isStateful()) || super.isStateful())) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z10;
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f35651h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (colorForState != this.f35645b.getColor()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f35645b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f35653j;
        if (colorStateList2 != null && (mode = this.f35654k) != null) {
            this.f35652i = a(colorStateList2, mode);
            return true;
        }
        return z10;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f35645b.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f35645b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f35653j = colorStateList;
        this.f35652i = a(colorStateList, this.f35654k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f35654k = mode;
        this.f35652i = a(this.f35653j, mode);
        invalidateSelf();
    }
}
