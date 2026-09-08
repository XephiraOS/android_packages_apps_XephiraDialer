package v4;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import x4.i;
import x4.n;
import x4.r;

/* compiled from: RippleDrawableCompat.java */
/* renamed from: v4.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1625a extends Drawable implements r {

    /* renamed from: a, reason: collision with root package name */
    public b f37393a;

    @Override // android.graphics.drawable.Drawable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1625a mutate() {
        this.f37393a = new b(this.f37393a);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b bVar = this.f37393a;
        if (bVar.f37395b) {
            bVar.f37394a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f37393a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f37393a.f37394a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f37393a.f37394a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        if (this.f37393a.f37394a.setState(iArr)) {
            onStateChange = true;
        }
        boolean e10 = v4.b.e(iArr);
        b bVar = this.f37393a;
        if (bVar.f37395b != e10) {
            bVar.f37395b = e10;
            return true;
        }
        return onStateChange;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f37393a.f37394a.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f37393a.f37394a.setColorFilter(colorFilter);
    }

    @Override // x4.r
    public void setShapeAppearanceModel(n nVar) {
        this.f37393a.f37394a.setShapeAppearanceModel(nVar);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i10) {
        this.f37393a.f37394a.setTint(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f37393a.f37394a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f37393a.f37394a.setTintMode(mode);
    }

    public C1625a(n nVar) {
        this(new b(new i(nVar)));
    }

    /* compiled from: RippleDrawableCompat.java */
    /* renamed from: v4.a$b */
    /* loaded from: classes3.dex */
    public static final class b extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public i f37394a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f37395b;

        public b(i iVar) {
            this.f37394a = iVar;
            this.f37395b = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C1625a newDrawable() {
            return new C1625a(new b(this));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        public b(b bVar) {
            this.f37394a = (i) bVar.f37394a.getConstantState().newDrawable();
            this.f37395b = bVar.f37395b;
        }
    }

    public C1625a(b bVar) {
        this.f37393a = bVar;
    }
}
