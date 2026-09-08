package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: OneShotPreDrawListener.java */
/* loaded from: classes.dex */
public final class B implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final View f9423a;

    /* renamed from: b, reason: collision with root package name */
    public ViewTreeObserver f9424b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f9425c;

    public B(View view, Runnable runnable) {
        this.f9423a = view;
        this.f9424b = view.getViewTreeObserver();
        this.f9425c = runnable;
    }

    public static B a(View view, Runnable runnable) {
        if (view != null) {
            if (runnable != null) {
                B b10 = new B(view, runnable);
                view.getViewTreeObserver().addOnPreDrawListener(b10);
                view.addOnAttachStateChangeListener(b10);
                return b10;
            }
            throw new NullPointerException("runnable == null");
        }
        throw new NullPointerException("view == null");
    }

    public void b() {
        if (this.f9424b.isAlive()) {
            this.f9424b.removeOnPreDrawListener(this);
        } else {
            this.f9423a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f9423a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f9425c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f9424b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
