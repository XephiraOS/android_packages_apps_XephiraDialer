package x4;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import h4.C1079a;

/* compiled from: ShapeableDelegate.java */
/* loaded from: classes3.dex */
public abstract class s {

    /* renamed from: c, reason: collision with root package name */
    public n f37995c;

    /* renamed from: a, reason: collision with root package name */
    public boolean f37993a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f37994b = false;

    /* renamed from: d, reason: collision with root package name */
    public RectF f37996d = new RectF();

    /* renamed from: e, reason: collision with root package name */
    public final Path f37997e = new Path();

    public static s a(View view) {
        return new t(view);
    }

    public abstract void b(View view);

    public boolean c() {
        return this.f37993a;
    }

    public final boolean d() {
        RectF rectF = this.f37996d;
        if (rectF.left <= rectF.right && rectF.top <= rectF.bottom) {
            return true;
        }
        return false;
    }

    public void e(Canvas canvas, C1079a.InterfaceC0303a interfaceC0303a) {
        if (j() && !this.f37997e.isEmpty()) {
            canvas.save();
            canvas.clipPath(this.f37997e);
            interfaceC0303a.a(canvas);
            canvas.restore();
            return;
        }
        interfaceC0303a.a(canvas);
    }

    public void f(View view, RectF rectF) {
        this.f37996d = rectF;
        k();
        b(view);
    }

    public void g(View view, n nVar) {
        this.f37995c = nVar;
        k();
        b(view);
    }

    public void h(View view, boolean z10) {
        if (z10 != this.f37993a) {
            this.f37993a = z10;
            b(view);
        }
    }

    public void i(View view, boolean z10) {
        this.f37994b = z10;
        b(view);
    }

    public abstract boolean j();

    public final void k() {
        if (d() && this.f37995c != null) {
            o.k().d(this.f37995c, 1.0f, this.f37996d, this.f37997e);
        }
    }
}
