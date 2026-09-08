package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import j.AbstractC1145b;

/* loaded from: classes.dex */
public abstract class ActionBar {

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z10);
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract CharSequence d();

        public abstract void e();
    }

    public abstract void A(CharSequence charSequence);

    public abstract void B(CharSequence charSequence);

    public abstract void C();

    public AbstractC1145b D(AbstractC1145b.a aVar) {
        return null;
    }

    public boolean g() {
        return false;
    }

    public abstract boolean h();

    public abstract void i(boolean z10);

    public abstract int j();

    public abstract Context k();

    public abstract void l();

    public boolean m() {
        return false;
    }

    public abstract boolean p(int i10, KeyEvent keyEvent);

    public boolean q(KeyEvent keyEvent) {
        return false;
    }

    public boolean r() {
        return false;
    }

    public abstract void s(boolean z10);

    public abstract void t(boolean z10);

    public abstract void u(int i10);

    public abstract void v(int i10, int i11);

    public abstract void w(boolean z10);

    public abstract void x(boolean z10);

    public abstract void y(boolean z10);

    public abstract void z(int i10);

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.j.f30510t);
            this.gravity = obtainStyledAttributes.getInt(e.j.f30515u, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
            this.gravity = 8388627;
        }

        public LayoutParams(int i10, int i11, int i12) {
            super(i10, i11);
            this.gravity = i12;
        }

        public LayoutParams(int i10) {
            this(-2, -1, i10);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.gravity = 0;
            this.gravity = layoutParams.gravity;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
        }
    }

    public void n(Configuration configuration) {
    }

    public void o() {
    }
}
