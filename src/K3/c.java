package k3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import j0.AbstractC1152b;
import java.nio.ByteBuffer;
import java.util.List;
import k3.g;
import s3.C1540k;

/* compiled from: GifDrawable.java */
/* loaded from: classes.dex */
public class c extends Drawable implements g.b, Animatable {

    /* renamed from: a, reason: collision with root package name */
    public final a f34100a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f34101b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f34102c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f34103d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f34104e;

    /* renamed from: f, reason: collision with root package name */
    public int f34105f;

    /* renamed from: g, reason: collision with root package name */
    public int f34106g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f34107h;

    /* renamed from: i, reason: collision with root package name */
    public Paint f34108i;

    /* renamed from: j, reason: collision with root package name */
    public Rect f34109j;

    /* renamed from: k, reason: collision with root package name */
    public List<AbstractC1152b> f34110k;

    /* compiled from: GifDrawable.java */
    /* loaded from: classes.dex */
    public static final class a extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public final g f34111a;

        public a(g gVar) {
            this.f34111a = gVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new c(this);
        }
    }

    public c(Context context, W2.a aVar, X2.g<Bitmap> gVar, int i10, int i11, Bitmap bitmap) {
        this(new a(new g(com.bumptech.glide.b.c(context), aVar, i10, i11, gVar, bitmap)));
    }

    @Override // k3.g.b
    public void a() {
        if (b() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (g() == f() - 1) {
            this.f34105f++;
        }
        int i10 = this.f34106g;
        if (i10 != -1 && this.f34105f >= i10) {
            j();
            stop();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Drawable.Callback b() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    public ByteBuffer c() {
        return this.f34100a.f34111a.b();
    }

    public final Rect d() {
        if (this.f34109j == null) {
            this.f34109j = new Rect();
        }
        return this.f34109j;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f34103d) {
            return;
        }
        if (this.f34107h) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), d());
            this.f34107h = false;
        }
        canvas.drawBitmap(this.f34100a.f34111a.c(), (Rect) null, d(), h());
    }

    public Bitmap e() {
        return this.f34100a.f34111a.e();
    }

    public int f() {
        return this.f34100a.f34111a.f();
    }

    public int g() {
        return this.f34100a.f34111a.d();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f34100a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f34100a.f34111a.h();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f34100a.f34111a.k();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public final Paint h() {
        if (this.f34108i == null) {
            this.f34108i = new Paint(2);
        }
        return this.f34108i;
    }

    public int i() {
        return this.f34100a.f34111a.j();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f34101b;
    }

    public final void j() {
        List<AbstractC1152b> list = this.f34110k;
        if (list != null) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f34110k.get(i10).b(this);
            }
        }
    }

    public void k() {
        this.f34103d = true;
        this.f34100a.f34111a.a();
    }

    public final void l() {
        this.f34105f = 0;
    }

    public void m(X2.g<Bitmap> gVar, Bitmap bitmap) {
        this.f34100a.f34111a.o(gVar, bitmap);
    }

    public final void n() {
        C1540k.a(!this.f34103d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f34100a.f34111a.f() == 1) {
            invalidateSelf();
        } else if (!this.f34101b) {
            this.f34101b = true;
            this.f34100a.f34111a.r(this);
            invalidateSelf();
        }
    }

    public final void o() {
        this.f34101b = false;
        this.f34100a.f34111a.s(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f34107h = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        h().setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        h().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        C1540k.a(!this.f34103d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f34104e = z10;
        if (!z10) {
            o();
        } else if (this.f34102c) {
            n();
        }
        return super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f34102c = true;
        l();
        if (this.f34104e) {
            n();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f34102c = false;
        o();
    }

    public c(a aVar) {
        this.f34104e = true;
        this.f34106g = -1;
        this.f34100a = (a) C1540k.d(aVar);
    }
}
