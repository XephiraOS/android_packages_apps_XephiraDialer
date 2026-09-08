package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: AppCompatBackgroundHelper.java */
/* renamed from: androidx.appcompat.widget.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0430d {

    /* renamed from: a, reason: collision with root package name */
    public final View f7838a;

    /* renamed from: d, reason: collision with root package name */
    public I f7841d;

    /* renamed from: e, reason: collision with root package name */
    public I f7842e;

    /* renamed from: f, reason: collision with root package name */
    public I f7843f;

    /* renamed from: c, reason: collision with root package name */
    public int f7840c = -1;

    /* renamed from: b, reason: collision with root package name */
    public final C0433g f7839b = C0433g.b();

    public C0430d(View view) {
        this.f7838a = view;
    }

    public final boolean a(Drawable drawable) {
        if (this.f7843f == null) {
            this.f7843f = new I();
        }
        I i10 = this.f7843f;
        i10.a();
        ColorStateList o10 = androidx.core.view.K.o(this.f7838a);
        if (o10 != null) {
            i10.f7722d = true;
            i10.f7719a = o10;
        }
        PorterDuff.Mode p10 = androidx.core.view.K.p(this.f7838a);
        if (p10 != null) {
            i10.f7721c = true;
            i10.f7720b = p10;
        }
        if (!i10.f7722d && !i10.f7721c) {
            return false;
        }
        C0433g.i(drawable, i10, this.f7838a.getDrawableState());
        return true;
    }

    public void b() {
        Drawable background = this.f7838a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            I i10 = this.f7842e;
            if (i10 != null) {
                C0433g.i(background, i10, this.f7838a.getDrawableState());
                return;
            }
            I i11 = this.f7841d;
            if (i11 != null) {
                C0433g.i(background, i11, this.f7838a.getDrawableState());
            }
        }
    }

    public ColorStateList c() {
        I i10 = this.f7842e;
        if (i10 != null) {
            return i10.f7719a;
        }
        return null;
    }

    public PorterDuff.Mode d() {
        I i10 = this.f7842e;
        if (i10 != null) {
            return i10.f7720b;
        }
        return null;
    }

    public void e(AttributeSet attributeSet, int i10) {
        Context context = this.f7838a.getContext();
        int[] iArr = e.j.f30391V3;
        K w10 = K.w(context, attributeSet, iArr, i10, 0);
        View view = this.f7838a;
        androidx.core.view.K.h0(view, view.getContext(), iArr, attributeSet, w10.r(), i10, 0);
        try {
            int i11 = e.j.f30396W3;
            if (w10.s(i11)) {
                this.f7840c = w10.n(i11, -1);
                ColorStateList f10 = this.f7839b.f(this.f7838a.getContext(), this.f7840c);
                if (f10 != null) {
                    h(f10);
                }
            }
            int i12 = e.j.f30401X3;
            if (w10.s(i12)) {
                androidx.core.view.K.o0(this.f7838a, w10.c(i12));
            }
            int i13 = e.j.f30406Y3;
            if (w10.s(i13)) {
                androidx.core.view.K.p0(this.f7838a, u.d(w10.k(i13, -1), null));
            }
            w10.y();
        } catch (Throwable th) {
            w10.y();
            throw th;
        }
    }

    public void f(Drawable drawable) {
        this.f7840c = -1;
        h(null);
        b();
    }

    public void g(int i10) {
        ColorStateList colorStateList;
        this.f7840c = i10;
        C0433g c0433g = this.f7839b;
        if (c0433g != null) {
            colorStateList = c0433g.f(this.f7838a.getContext(), i10);
        } else {
            colorStateList = null;
        }
        h(colorStateList);
        b();
    }

    public void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f7841d == null) {
                this.f7841d = new I();
            }
            I i10 = this.f7841d;
            i10.f7719a = colorStateList;
            i10.f7722d = true;
        } else {
            this.f7841d = null;
        }
        b();
    }

    public void i(ColorStateList colorStateList) {
        if (this.f7842e == null) {
            this.f7842e = new I();
        }
        I i10 = this.f7842e;
        i10.f7719a = colorStateList;
        i10.f7722d = true;
        b();
    }

    public void j(PorterDuff.Mode mode) {
        if (this.f7842e == null) {
            this.f7842e = new I();
        }
        I i10 = this.f7842e;
        i10.f7720b = mode;
        i10.f7721c = true;
        b();
    }

    public final boolean k() {
        if (this.f7841d != null) {
            return true;
        }
        return false;
    }
}
