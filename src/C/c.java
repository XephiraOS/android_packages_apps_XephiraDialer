package C;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* compiled from: RoundedBitmapDrawable.java */
/* loaded from: classes.dex */
public abstract class c extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public final Bitmap f306a;

    /* renamed from: b, reason: collision with root package name */
    public int f307b;

    /* renamed from: e, reason: collision with root package name */
    public final BitmapShader f310e;

    /* renamed from: g, reason: collision with root package name */
    public float f312g;

    /* renamed from: k, reason: collision with root package name */
    public boolean f316k;

    /* renamed from: l, reason: collision with root package name */
    public int f317l;

    /* renamed from: m, reason: collision with root package name */
    public int f318m;

    /* renamed from: c, reason: collision with root package name */
    public int f308c = 119;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f309d = new Paint(3);

    /* renamed from: f, reason: collision with root package name */
    public final Matrix f311f = new Matrix();

    /* renamed from: h, reason: collision with root package name */
    public final Rect f313h = new Rect();

    /* renamed from: i, reason: collision with root package name */
    public final RectF f314i = new RectF();

    /* renamed from: j, reason: collision with root package name */
    public boolean f315j = true;

    public c(Resources resources, Bitmap bitmap) {
        this.f307b = 160;
        if (resources != null) {
            this.f307b = resources.getDisplayMetrics().densityDpi;
        }
        this.f306a = bitmap;
        if (bitmap != null) {
            a();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f310e = new BitmapShader(bitmap, tileMode, tileMode);
        } else {
            this.f318m = -1;
            this.f317l = -1;
            this.f310e = null;
        }
    }

    public static boolean d(float f10) {
        if (f10 > 0.05f) {
            return true;
        }
        return false;
    }

    public final void a() {
        this.f317l = this.f306a.getScaledWidth(this.f307b);
        this.f318m = this.f306a.getScaledHeight(this.f307b);
    }

    public float b() {
        return this.f312g;
    }

    public abstract void c(int i10, int i11, int i12, Rect rect, Rect rect2);

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f306a;
        if (bitmap == null) {
            return;
        }
        h();
        if (this.f309d.getShader() == null) {
            canvas.drawBitmap(bitmap, (Rect) null, this.f313h, this.f309d);
            return;
        }
        RectF rectF = this.f314i;
        float f10 = this.f312g;
        canvas.drawRoundRect(rectF, f10, f10, this.f309d);
    }

    public void e(boolean z10) {
        this.f309d.setAntiAlias(z10);
        invalidateSelf();
    }

    public void f(float f10) {
        if (this.f312g == f10) {
            return;
        }
        this.f316k = false;
        if (d(f10)) {
            this.f309d.setShader(this.f310e);
        } else {
            this.f309d.setShader(null);
        }
        this.f312g = f10;
        invalidateSelf();
    }

    public final void g() {
        this.f312g = Math.min(this.f318m, this.f317l) / 2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f309d.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f309d.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f318m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f317l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap;
        if (this.f308c != 119 || this.f316k || (bitmap = this.f306a) == null || bitmap.hasAlpha() || this.f309d.getAlpha() < 255 || d(this.f312g)) {
            return -3;
        }
        return -1;
    }

    public void h() {
        if (this.f315j) {
            if (this.f316k) {
                int min = Math.min(this.f317l, this.f318m);
                c(this.f308c, min, min, getBounds(), this.f313h);
                int min2 = Math.min(this.f313h.width(), this.f313h.height());
                this.f313h.inset(Math.max(0, (this.f313h.width() - min2) / 2), Math.max(0, (this.f313h.height() - min2) / 2));
                this.f312g = min2 * 0.5f;
            } else {
                c(this.f308c, this.f317l, this.f318m, getBounds(), this.f313h);
            }
            this.f314i.set(this.f313h);
            if (this.f310e != null) {
                Matrix matrix = this.f311f;
                RectF rectF = this.f314i;
                matrix.setTranslate(rectF.left, rectF.top);
                this.f311f.preScale(this.f314i.width() / this.f306a.getWidth(), this.f314i.height() / this.f306a.getHeight());
                this.f310e.setLocalMatrix(this.f311f);
                this.f309d.setShader(this.f310e);
            }
            this.f315j = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.f316k) {
            g();
        }
        this.f315j = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (i10 != this.f309d.getAlpha()) {
            this.f309d.setAlpha(i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f309d.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z10) {
        this.f309d.setDither(z10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z10) {
        this.f309d.setFilterBitmap(z10);
        invalidateSelf();
    }
}
