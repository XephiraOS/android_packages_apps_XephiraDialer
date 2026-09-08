package p3;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o3.InterfaceC1399c;
import s3.C1540k;

/* compiled from: ViewTarget.java */
@Deprecated
/* loaded from: classes.dex */
public abstract class i<T extends View, Z> extends AbstractC1431a<Z> {

    /* renamed from: f, reason: collision with root package name */
    public static boolean f35998f;

    /* renamed from: g, reason: collision with root package name */
    public static int f35999g = com.bumptech.glide.f.f19339a;

    /* renamed from: a, reason: collision with root package name */
    public final T f36000a;

    /* renamed from: b, reason: collision with root package name */
    public final a f36001b;

    /* renamed from: c, reason: collision with root package name */
    public View.OnAttachStateChangeListener f36002c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f36003d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f36004e;

    /* compiled from: ViewTarget.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: e, reason: collision with root package name */
        public static Integer f36005e;

        /* renamed from: a, reason: collision with root package name */
        public final View f36006a;

        /* renamed from: b, reason: collision with root package name */
        public final List<InterfaceC1437g> f36007b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public boolean f36008c;

        /* renamed from: d, reason: collision with root package name */
        public ViewTreeObserverOnPreDrawListenerC0340a f36009d;

        /* compiled from: ViewTarget.java */
        /* renamed from: p3.i$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class ViewTreeObserverOnPreDrawListenerC0340a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a, reason: collision with root package name */
            public final WeakReference<a> f36010a;

            public ViewTreeObserverOnPreDrawListenerC0340a(a aVar) {
                this.f36010a = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                a aVar = this.f36010a.get();
                if (aVar != null) {
                    aVar.a();
                    return true;
                }
                return true;
            }
        }

        public a(View view) {
            this.f36006a = view;
        }

        public static int c(Context context) {
            if (f36005e == null) {
                Display defaultDisplay = ((WindowManager) C1540k.d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f36005e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f36005e.intValue();
        }

        public void a() {
            if (this.f36007b.isEmpty()) {
                return;
            }
            int g10 = g();
            int f10 = f();
            if (!i(g10, f10)) {
                return;
            }
            j(g10, f10);
            b();
        }

        public void b() {
            ViewTreeObserver viewTreeObserver = this.f36006a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f36009d);
            }
            this.f36009d = null;
            this.f36007b.clear();
        }

        public void d(InterfaceC1437g interfaceC1437g) {
            int g10 = g();
            int f10 = f();
            if (i(g10, f10)) {
                interfaceC1437g.d(g10, f10);
                return;
            }
            if (!this.f36007b.contains(interfaceC1437g)) {
                this.f36007b.add(interfaceC1437g);
            }
            if (this.f36009d == null) {
                ViewTreeObserver viewTreeObserver = this.f36006a.getViewTreeObserver();
                ViewTreeObserverOnPreDrawListenerC0340a viewTreeObserverOnPreDrawListenerC0340a = new ViewTreeObserverOnPreDrawListenerC0340a(this);
                this.f36009d = viewTreeObserverOnPreDrawListenerC0340a;
                viewTreeObserver.addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0340a);
            }
        }

        public final int e(int i10, int i11, int i12) {
            int i13 = i11 - i12;
            if (i13 > 0) {
                return i13;
            }
            if (this.f36008c && this.f36006a.isLayoutRequested()) {
                return 0;
            }
            int i14 = i10 - i12;
            if (i14 > 0) {
                return i14;
            }
            if (this.f36006a.isLayoutRequested() || i11 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.f36006a.getContext());
        }

        public final int f() {
            int i10;
            int paddingTop = this.f36006a.getPaddingTop() + this.f36006a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f36006a.getLayoutParams();
            if (layoutParams != null) {
                i10 = layoutParams.height;
            } else {
                i10 = 0;
            }
            return e(this.f36006a.getHeight(), i10, paddingTop);
        }

        public final int g() {
            int i10;
            int paddingLeft = this.f36006a.getPaddingLeft() + this.f36006a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f36006a.getLayoutParams();
            if (layoutParams != null) {
                i10 = layoutParams.width;
            } else {
                i10 = 0;
            }
            return e(this.f36006a.getWidth(), i10, paddingLeft);
        }

        public final boolean h(int i10) {
            if (i10 <= 0 && i10 != Integer.MIN_VALUE) {
                return false;
            }
            return true;
        }

        public final boolean i(int i10, int i11) {
            if (h(i10) && h(i11)) {
                return true;
            }
            return false;
        }

        public final void j(int i10, int i11) {
            Iterator it = new ArrayList(this.f36007b).iterator();
            while (it.hasNext()) {
                ((InterfaceC1437g) it.next()).d(i10, i11);
            }
        }

        public void k(InterfaceC1437g interfaceC1437g) {
            this.f36007b.remove(interfaceC1437g);
        }
    }

    public i(T t10) {
        this.f36000a = (T) C1540k.d(t10);
        this.f36001b = new a(t10);
    }

    @Override // p3.InterfaceC1438h
    public void c(InterfaceC1437g interfaceC1437g) {
        this.f36001b.k(interfaceC1437g);
    }

    @Override // p3.InterfaceC1438h
    public void f(InterfaceC1399c interfaceC1399c) {
        m(interfaceC1399c);
    }

    @Override // p3.AbstractC1431a, p3.InterfaceC1438h
    public void g(Drawable drawable) {
        super.g(drawable);
        k();
    }

    @Override // p3.InterfaceC1438h
    public InterfaceC1399c getRequest() {
        Object j10 = j();
        if (j10 != null) {
            if (j10 instanceof InterfaceC1399c) {
                return (InterfaceC1399c) j10;
            }
            throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
        }
        return null;
    }

    @Override // p3.AbstractC1431a, p3.InterfaceC1438h
    public void h(Drawable drawable) {
        super.h(drawable);
        this.f36001b.b();
        if (!this.f36003d) {
            l();
        }
    }

    @Override // p3.InterfaceC1438h
    public void i(InterfaceC1437g interfaceC1437g) {
        this.f36001b.d(interfaceC1437g);
    }

    public final Object j() {
        return this.f36000a.getTag(f35999g);
    }

    public final void k() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f36002c;
        if (onAttachStateChangeListener != null && !this.f36004e) {
            this.f36000a.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f36004e = true;
        }
    }

    public final void l() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f36002c;
        if (onAttachStateChangeListener != null && this.f36004e) {
            this.f36000a.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f36004e = false;
        }
    }

    public final void m(Object obj) {
        f35998f = true;
        this.f36000a.setTag(f35999g, obj);
    }

    public String toString() {
        return "Target for: " + this.f36000a;
    }
}
