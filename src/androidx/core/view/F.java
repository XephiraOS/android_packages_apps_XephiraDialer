package androidx.core.view;

import android.R;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.F;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: SoftwareKeyboardControllerCompat.java */
/* loaded from: classes.dex */
public final class F {

    /* renamed from: a, reason: collision with root package name */
    public final c f9428a;

    /* compiled from: SoftwareKeyboardControllerCompat.java */
    /* loaded from: classes.dex */
    public static class a extends c {

        /* renamed from: a, reason: collision with root package name */
        public final View f9429a;

        public a(View view) {
            this.f9429a = view;
        }

        public static /* synthetic */ void d(View view) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
        }

        @Override // androidx.core.view.F.c
        public void a() {
            View view = this.f9429a;
            if (view != null) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f9429a.getWindowToken(), 0);
            }
        }

        @Override // androidx.core.view.F.c
        public void b() {
            final View view = this.f9429a;
            if (view == null) {
                return;
            }
            if (!view.isInEditMode() && !view.onCheckIsTextEditor()) {
                view = view.getRootView().findFocus();
            } else {
                view.requestFocus();
            }
            if (view == null) {
                view = this.f9429a.getRootView().findViewById(R.id.content);
            }
            if (view != null && view.hasWindowFocus()) {
                view.post(new Runnable() { // from class: androidx.core.view.E
                    @Override // java.lang.Runnable
                    public final void run() {
                        F.a.d(view);
                    }
                });
            }
        }
    }

    /* compiled from: SoftwareKeyboardControllerCompat.java */
    /* loaded from: classes.dex */
    public static class c {
        public void a() {
            throw null;
        }

        public void b() {
            throw null;
        }
    }

    public F(View view) {
        this.f9428a = new b(view);
    }

    public void a() {
        this.f9428a.a();
    }

    public void b() {
        this.f9428a.b();
    }

    /* compiled from: SoftwareKeyboardControllerCompat.java */
    /* loaded from: classes.dex */
    public static class b extends a {

        /* renamed from: b, reason: collision with root package name */
        public View f9430b;

        /* renamed from: c, reason: collision with root package name */
        public WindowInsetsController f9431c;

        public b(View view) {
            super(view);
            this.f9430b = view;
        }

        public static /* synthetic */ void f(AtomicBoolean atomicBoolean, WindowInsetsController windowInsetsController, int i10) {
            boolean z10;
            if ((i10 & 8) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            atomicBoolean.set(z10);
        }

        @Override // androidx.core.view.F.a, androidx.core.view.F.c
        public void a() {
            View view;
            WindowInsetsController windowInsetsController = this.f9431c;
            if (windowInsetsController == null) {
                View view2 = this.f9430b;
                if (view2 != null) {
                    windowInsetsController = view2.getWindowInsetsController();
                } else {
                    windowInsetsController = null;
                }
            }
            if (windowInsetsController != null) {
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                WindowInsetsController.OnControllableInsetsChangedListener onControllableInsetsChangedListener = new WindowInsetsController.OnControllableInsetsChangedListener() { // from class: androidx.core.view.G
                    @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
                    public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController2, int i10) {
                        F.b.f(atomicBoolean, windowInsetsController2, i10);
                    }
                };
                windowInsetsController.addOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
                if (!atomicBoolean.get() && (view = this.f9430b) != null) {
                    ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f9430b.getWindowToken(), 0);
                }
                windowInsetsController.removeOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
                windowInsetsController.hide(WindowInsets.Type.ime());
                return;
            }
            super.a();
        }

        @Override // androidx.core.view.F.a, androidx.core.view.F.c
        public void b() {
            View view = this.f9430b;
            WindowInsetsController windowInsetsController = this.f9431c;
            if (windowInsetsController == null) {
                if (view != null) {
                    windowInsetsController = view.getWindowInsetsController();
                } else {
                    windowInsetsController = null;
                }
            }
            if (windowInsetsController != null) {
                windowInsetsController.show(WindowInsets.Type.ime());
            }
            super.b();
        }

        public b(WindowInsetsController windowInsetsController) {
            super(null);
            this.f9431c = windowInsetsController;
        }
    }

    @Deprecated
    public F(WindowInsetsController windowInsetsController) {
        this.f9428a = new b(windowInsetsController);
    }
}
