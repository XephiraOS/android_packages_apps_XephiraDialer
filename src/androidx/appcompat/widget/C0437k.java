package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import f.C0991a;

/* compiled from: AppCompatImageHelper.java */
/* renamed from: androidx.appcompat.widget.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0437k {

    /* renamed from: a, reason: collision with root package name */
    public final ImageView f7869a;

    /* renamed from: b, reason: collision with root package name */
    public I f7870b;

    /* renamed from: c, reason: collision with root package name */
    public I f7871c;

    /* renamed from: d, reason: collision with root package name */
    public I f7872d;

    /* renamed from: e, reason: collision with root package name */
    public int f7873e = 0;

    public C0437k(ImageView imageView) {
        this.f7869a = imageView;
    }

    public final boolean a(Drawable drawable) {
        if (this.f7872d == null) {
            this.f7872d = new I();
        }
        I i10 = this.f7872d;
        i10.a();
        ColorStateList a10 = androidx.core.widget.g.a(this.f7869a);
        if (a10 != null) {
            i10.f7722d = true;
            i10.f7719a = a10;
        }
        PorterDuff.Mode b10 = androidx.core.widget.g.b(this.f7869a);
        if (b10 != null) {
            i10.f7721c = true;
            i10.f7720b = b10;
        }
        if (!i10.f7722d && !i10.f7721c) {
            return false;
        }
        C0433g.i(drawable, i10, this.f7869a.getDrawableState());
        return true;
    }

    public void b() {
        if (this.f7869a.getDrawable() != null) {
            this.f7869a.getDrawable().setLevel(this.f7873e);
        }
    }

    public void c() {
        Drawable drawable = this.f7869a.getDrawable();
        if (drawable != null) {
            u.b(drawable);
        }
        if (drawable != null) {
            if (l() && a(drawable)) {
                return;
            }
            I i10 = this.f7871c;
            if (i10 != null) {
                C0433g.i(drawable, i10, this.f7869a.getDrawableState());
                return;
            }
            I i11 = this.f7870b;
            if (i11 != null) {
                C0433g.i(drawable, i11, this.f7869a.getDrawableState());
            }
        }
    }

    public ColorStateList d() {
        I i10 = this.f7871c;
        if (i10 != null) {
            return i10.f7719a;
        }
        return null;
    }

    public PorterDuff.Mode e() {
        I i10 = this.f7871c;
        if (i10 != null) {
            return i10.f7720b;
        }
        return null;
    }

    public boolean f() {
        if (this.f7869a.getBackground() instanceof RippleDrawable) {
            return false;
        }
        return true;
    }

    public void g(AttributeSet attributeSet, int i10) {
        int n10;
        Context context = this.f7869a.getContext();
        int[] iArr = e.j.f30367R;
        K w10 = K.w(context, attributeSet, iArr, i10, 0);
        ImageView imageView = this.f7869a;
        androidx.core.view.K.h0(imageView, imageView.getContext(), iArr, attributeSet, w10.r(), i10, 0);
        try {
            Drawable drawable = this.f7869a.getDrawable();
            if (drawable == null && (n10 = w10.n(e.j.f30372S, -1)) != -1 && (drawable = C0991a.b(this.f7869a.getContext(), n10)) != null) {
                this.f7869a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                u.b(drawable);
            }
            int i11 = e.j.f30377T;
            if (w10.s(i11)) {
                androidx.core.widget.g.c(this.f7869a, w10.c(i11));
            }
            int i12 = e.j.f30382U;
            if (w10.s(i12)) {
                androidx.core.widget.g.d(this.f7869a, u.d(w10.k(i12, -1), null));
            }
            w10.y();
        } catch (Throwable th) {
            w10.y();
            throw th;
        }
    }

    public void h(Drawable drawable) {
        this.f7873e = drawable.getLevel();
    }

    public void i(int i10) {
        if (i10 != 0) {
            Drawable b10 = C0991a.b(this.f7869a.getContext(), i10);
            if (b10 != null) {
                u.b(b10);
            }
            this.f7869a.setImageDrawable(b10);
        } else {
            this.f7869a.setImageDrawable(null);
        }
        c();
    }

    public void j(ColorStateList colorStateList) {
        if (this.f7871c == null) {
            this.f7871c = new I();
        }
        I i10 = this.f7871c;
        i10.f7719a = colorStateList;
        i10.f7722d = true;
        c();
    }

    public void k(PorterDuff.Mode mode) {
        if (this.f7871c == null) {
            this.f7871c = new I();
        }
        I i10 = this.f7871c;
        i10.f7720b = mode;
        i10.f7721c = true;
        c();
    }

    public final boolean l() {
        if (this.f7870b != null) {
            return true;
        }
        return false;
    }
}
