package p3;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import q3.InterfaceC1483b;

/* compiled from: ImageViewTarget.java */
/* renamed from: p3.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1435e<Z> extends i<ImageView, Z> implements InterfaceC1483b.a {

    /* renamed from: h, reason: collision with root package name */
    public Animatable f35997h;

    public AbstractC1435e(ImageView imageView) {
        super(imageView);
    }

    @Override // p3.InterfaceC1438h
    public void a(Z z10, InterfaceC1483b<? super Z> interfaceC1483b) {
        if (interfaceC1483b != null && interfaceC1483b.a(z10, this)) {
            n(z10);
        } else {
            q(z10);
        }
    }

    @Override // p3.AbstractC1431a, p3.InterfaceC1438h
    public void d(Drawable drawable) {
        super.d(drawable);
        q(null);
        o(drawable);
    }

    @Override // p3.AbstractC1431a, com.bumptech.glide.manager.k
    public void e() {
        Animatable animatable = this.f35997h;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Override // p3.i, p3.AbstractC1431a, p3.InterfaceC1438h
    public void g(Drawable drawable) {
        super.g(drawable);
        q(null);
        o(drawable);
    }

    @Override // p3.i, p3.AbstractC1431a, p3.InterfaceC1438h
    public void h(Drawable drawable) {
        super.h(drawable);
        Animatable animatable = this.f35997h;
        if (animatable != null) {
            animatable.stop();
        }
        q(null);
        o(drawable);
    }

    public final void n(Z z10) {
        if (z10 instanceof Animatable) {
            Animatable animatable = (Animatable) z10;
            this.f35997h = animatable;
            animatable.start();
            return;
        }
        this.f35997h = null;
    }

    public void o(Drawable drawable) {
        ((ImageView) this.f36000a).setImageDrawable(drawable);
    }

    @Override // p3.AbstractC1431a, com.bumptech.glide.manager.k
    public void onStart() {
        Animatable animatable = this.f35997h;
        if (animatable != null) {
            animatable.start();
        }
    }

    public abstract void p(Z z10);

    public final void q(Z z10) {
        p(z10);
        n(z10);
    }
}
