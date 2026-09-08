package q4;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import n4.C1370a;
import x4.n;
import x4.o;

/* compiled from: BorderDrawable.java */
/* loaded from: classes3.dex */
public class c extends Drawable {

    /* renamed from: b, reason: collision with root package name */
    public final Paint f36141b;

    /* renamed from: h, reason: collision with root package name */
    public float f36147h;

    /* renamed from: i, reason: collision with root package name */
    public int f36148i;

    /* renamed from: j, reason: collision with root package name */
    public int f36149j;

    /* renamed from: k, reason: collision with root package name */
    public int f36150k;

    /* renamed from: l, reason: collision with root package name */
    public int f36151l;

    /* renamed from: m, reason: collision with root package name */
    public int f36152m;

    /* renamed from: o, reason: collision with root package name */
    public n f36154o;

    /* renamed from: p, reason: collision with root package name */
    public ColorStateList f36155p;

    /* renamed from: a, reason: collision with root package name */
    public final o f36140a = o.k();

    /* renamed from: c, reason: collision with root package name */
    public final Path f36142c = new Path();

    /* renamed from: d, reason: collision with root package name */
    public final Rect f36143d = new Rect();

    /* renamed from: e, reason: collision with root package name */
    public final RectF f36144e = new RectF();

    /* renamed from: f, reason: collision with root package name */
    public final RectF f36145f = new RectF();

    /* renamed from: g, reason: collision with root package name */
    public final b f36146g = new b();

    /* renamed from: n, reason: collision with root package name */
    public boolean f36153n = true;

    /* compiled from: BorderDrawable.java */
    /* loaded from: classes3.dex */
    public class b extends Drawable.ConstantState {
        public b() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return c.this;
        }
    }

    public c(n nVar) {
        this.f36154o = nVar;
        Paint paint = new Paint(1);
        this.f36141b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    public final Shader a() {
        copyBounds(this.f36143d);
        float height = this.f36147h / r1.height();
        return new LinearGradient(0.0f, r1.top, 0.0f, r1.bottom, new int[]{B.a.q(this.f36148i, this.f36152m), B.a.q(this.f36149j, this.f36152m), B.a.q(B.a.w(this.f36149j, 0), this.f36152m), B.a.q(B.a.w(this.f36151l, 0), this.f36152m), B.a.q(this.f36151l, this.f36152m), B.a.q(this.f36150k, this.f36152m)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP);
    }

    public RectF b() {
        this.f36145f.set(getBounds());
        return this.f36145f;
    }

    public void c(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f36152m = colorStateList.getColorForState(getState(), this.f36152m);
        }
        this.f36155p = colorStateList;
        this.f36153n = true;
        invalidateSelf();
    }

    public void d(float f10) {
        if (this.f36147h != f10) {
            this.f36147h = f10;
            this.f36141b.setStrokeWidth(f10 * 1.3333f);
            this.f36153n = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f36153n) {
            this.f36141b.setShader(a());
            this.f36153n = false;
        }
        float strokeWidth = this.f36141b.getStrokeWidth() / 2.0f;
        copyBounds(this.f36143d);
        this.f36144e.set(this.f36143d);
        float min = Math.min(this.f36154o.r().a(b()), this.f36144e.width() / 2.0f);
        if (this.f36154o.u(b())) {
            this.f36144e.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.f36144e, min, min, this.f36141b);
        }
    }

    public void e(int i10, int i11, int i12, int i13) {
        this.f36148i = i10;
        this.f36149j = i11;
        this.f36150k = i12;
        this.f36151l = i13;
    }

    public void f(n nVar) {
        this.f36154o = nVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f36146g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.f36147h > 0.0f) {
            return -3;
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f36154o.u(b())) {
            outline.setRoundRect(getBounds(), this.f36154o.r().a(b()));
        } else {
            copyBounds(this.f36143d);
            this.f36144e.set(this.f36143d);
            this.f36140a.d(this.f36154o, 1.0f, this.f36144e, this.f36142c);
            C1370a.l(outline, this.f36142c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        if (this.f36154o.u(b())) {
            int round = Math.round(this.f36147h);
            rect.set(round, round, round, round);
            return true;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f36155p;
        if ((colorStateList != null && colorStateList.isStateful()) || super.isStateful()) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f36153n = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.f36155p;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.f36152m)) != this.f36152m) {
            this.f36153n = true;
            this.f36152m = colorForState;
        }
        if (this.f36153n) {
            invalidateSelf();
        }
        return this.f36153n;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f36141b.setAlpha(i10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f36141b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
