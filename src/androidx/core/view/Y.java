package androidx.core.view;

import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* compiled from: WindowInsetsControllerCompat.java */
/* loaded from: classes.dex */
public final class Y {

    /* renamed from: a, reason: collision with root package name */
    public final d f9489a;

    /* compiled from: WindowInsetsControllerCompat.java */
    /* loaded from: classes.dex */
    public static class b extends a {
        public b(Window window, Y y10, F f10) {
            super(window, y10, f10);
        }

        @Override // androidx.core.view.Y.d
        public void e(int i10) {
            this.f9491b.setSystemBarsBehavior(i10);
        }

        public b(WindowInsetsController windowInsetsController, Y y10, F f10) {
            super(windowInsetsController, y10, f10);
        }
    }

    /* compiled from: WindowInsetsControllerCompat.java */
    /* loaded from: classes.dex */
    public static class c extends b {
        public c(Window window, Y y10, F f10) {
            super(window, y10, f10);
        }

        @Override // androidx.core.view.Y.d
        public boolean b() {
            if ((this.f9491b.getSystemBarsAppearance() & 8) != 0) {
                return true;
            }
            return false;
        }

        public c(WindowInsetsController windowInsetsController, Y y10, F f10) {
            super(windowInsetsController, y10, f10);
        }
    }

    /* compiled from: WindowInsetsControllerCompat.java */
    /* loaded from: classes.dex */
    public static class d {
        public void a(int i10) {
            throw null;
        }

        public boolean b() {
            throw null;
        }

        public void c(boolean z10) {
            throw null;
        }

        public void d(boolean z10) {
            throw null;
        }

        public void e(int i10) {
            throw null;
        }

        public void f(int i10) {
            throw null;
        }
    }

    @Deprecated
    public Y(WindowInsetsController windowInsetsController) {
        this.f9489a = new c(windowInsetsController, this, new F(windowInsetsController));
    }

    @Deprecated
    public static Y g(WindowInsetsController windowInsetsController) {
        return new Y(windowInsetsController);
    }

    public void a(int i10) {
        this.f9489a.a(i10);
    }

    public boolean b() {
        return this.f9489a.b();
    }

    public void c(boolean z10) {
        this.f9489a.c(z10);
    }

    public void d(boolean z10) {
        this.f9489a.d(z10);
    }

    public void e(int i10) {
        this.f9489a.e(i10);
    }

    public void f(int i10) {
        this.f9489a.f(i10);
    }

    /* compiled from: WindowInsetsControllerCompat.java */
    /* loaded from: classes.dex */
    public static class a extends d {

        /* renamed from: a, reason: collision with root package name */
        public final Y f9490a;

        /* renamed from: b, reason: collision with root package name */
        public final WindowInsetsController f9491b;

        /* renamed from: c, reason: collision with root package name */
        public final F f9492c;

        /* renamed from: d, reason: collision with root package name */
        public final p.i<Object, WindowInsetsController.OnControllableInsetsChangedListener> f9493d;

        /* renamed from: e, reason: collision with root package name */
        public Window f9494e;

        public a(Window window, Y y10, F f10) {
            this(window.getInsetsController(), y10, f10);
            this.f9494e = window;
        }

        @Override // androidx.core.view.Y.d
        public void a(int i10) {
            if ((i10 & 8) != 0) {
                this.f9492c.a();
            }
            this.f9491b.hide(i10 & (-9));
        }

        @Override // androidx.core.view.Y.d
        public void c(boolean z10) {
            if (z10) {
                if (this.f9494e != null) {
                    g(16);
                }
                this.f9491b.setSystemBarsAppearance(16, 16);
            } else {
                if (this.f9494e != null) {
                    h(16);
                }
                this.f9491b.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // androidx.core.view.Y.d
        public void d(boolean z10) {
            if (z10) {
                if (this.f9494e != null) {
                    g(8192);
                }
                this.f9491b.setSystemBarsAppearance(8, 8);
            } else {
                if (this.f9494e != null) {
                    h(8192);
                }
                this.f9491b.setSystemBarsAppearance(0, 8);
            }
        }

        @Override // androidx.core.view.Y.d
        public void f(int i10) {
            if ((i10 & 8) != 0) {
                this.f9492c.b();
            }
            this.f9491b.show(i10 & (-9));
        }

        public void g(int i10) {
            View decorView = this.f9494e.getDecorView();
            decorView.setSystemUiVisibility(i10 | decorView.getSystemUiVisibility());
        }

        public void h(int i10) {
            View decorView = this.f9494e.getDecorView();
            decorView.setSystemUiVisibility((~i10) & decorView.getSystemUiVisibility());
        }

        public a(WindowInsetsController windowInsetsController, Y y10, F f10) {
            this.f9493d = new p.i<>();
            this.f9491b = windowInsetsController;
            this.f9490a = y10;
            this.f9492c = f10;
        }
    }

    public Y(Window window, View view) {
        this.f9489a = new c(window, this, new F(view));
    }
}
