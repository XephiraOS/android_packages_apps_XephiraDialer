package androidx.transition;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

/* compiled from: GhostViewPort.java */
/* renamed from: androidx.transition.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0505h extends ViewGroup implements InterfaceC0503f {

    /* renamed from: a, reason: collision with root package name */
    public ViewGroup f11717a;

    /* renamed from: b, reason: collision with root package name */
    public View f11718b;

    /* renamed from: c, reason: collision with root package name */
    public final View f11719c;

    /* renamed from: d, reason: collision with root package name */
    public int f11720d;

    /* renamed from: e, reason: collision with root package name */
    public Matrix f11721e;

    /* renamed from: f, reason: collision with root package name */
    public final ViewTreeObserver.OnPreDrawListener f11722f;

    /* compiled from: GhostViewPort.java */
    /* renamed from: androidx.transition.h$a */
    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            View view;
            C0505h.this.postInvalidateOnAnimation();
            C0505h c0505h = C0505h.this;
            ViewGroup viewGroup = c0505h.f11717a;
            if (viewGroup != null && (view = c0505h.f11718b) != null) {
                viewGroup.endViewTransition(view);
                C0505h.this.f11717a.postInvalidateOnAnimation();
                C0505h c0505h2 = C0505h.this;
                c0505h2.f11717a = null;
                c0505h2.f11718b = null;
                return true;
            }
            return true;
        }
    }

    public C0505h(View view) {
        super(view.getContext());
        this.f11722f = new a();
        this.f11719c = view;
        setWillNotDraw(false);
        setClipChildren(false);
        setLayerType(2, null);
    }

    public static C0505h b(View view, ViewGroup viewGroup, Matrix matrix) {
        int i10;
        C0504g c0504g;
        if (view.getParent() instanceof ViewGroup) {
            C0504g b10 = C0504g.b(viewGroup);
            C0505h e10 = e(view);
            if (e10 != null && (c0504g = (C0504g) e10.getParent()) != b10) {
                i10 = e10.f11720d;
                c0504g.removeView(e10);
                e10 = null;
            } else {
                i10 = 0;
            }
            if (e10 == null) {
                if (matrix == null) {
                    matrix = new Matrix();
                    c(view, viewGroup, matrix);
                }
                e10 = new C0505h(view);
                e10.h(matrix);
                if (b10 == null) {
                    b10 = new C0504g(viewGroup);
                } else {
                    b10.g();
                }
                d(viewGroup, b10);
                d(viewGroup, e10);
                b10.a(e10);
                e10.f11720d = i10;
            } else if (matrix != null) {
                e10.h(matrix);
            }
            e10.f11720d++;
            return e10;
        }
        throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
    }

    public static void c(View view, ViewGroup viewGroup, Matrix matrix) {
        ViewGroup viewGroup2 = (ViewGroup) view.getParent();
        matrix.reset();
        H.h(viewGroup2, matrix);
        matrix.preTranslate(-viewGroup2.getScrollX(), -viewGroup2.getScrollY());
        H.i(viewGroup, matrix);
    }

    public static void d(View view, View view2) {
        H.e(view2, view2.getLeft(), view2.getTop(), view2.getLeft() + view.getWidth(), view2.getTop() + view.getHeight());
    }

    public static C0505h e(View view) {
        return (C0505h) view.getTag(C0511n.f11725a);
    }

    public static void f(View view) {
        C0505h e10 = e(view);
        if (e10 != null) {
            int i10 = e10.f11720d - 1;
            e10.f11720d = i10;
            if (i10 <= 0) {
                ((C0504g) e10.getParent()).removeView(e10);
            }
        }
    }

    public static void g(View view, C0505h c0505h) {
        view.setTag(C0511n.f11725a, c0505h);
    }

    @Override // androidx.transition.InterfaceC0503f
    public void a(ViewGroup viewGroup, View view) {
        this.f11717a = viewGroup;
        this.f11718b = view;
    }

    public void h(Matrix matrix) {
        this.f11721e = matrix;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        g(this.f11719c, this);
        this.f11719c.getViewTreeObserver().addOnPreDrawListener(this.f11722f);
        H.g(this.f11719c, 4);
        if (this.f11719c.getParent() != null) {
            ((View) this.f11719c.getParent()).invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f11719c.getViewTreeObserver().removeOnPreDrawListener(this.f11722f);
        H.g(this.f11719c, 0);
        g(this.f11719c, null);
        if (this.f11719c.getParent() != null) {
            ((View) this.f11719c.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        C0498a.a(canvas, true);
        canvas.setMatrix(this.f11721e);
        H.g(this.f11719c, 0);
        this.f11719c.invalidate();
        H.g(this.f11719c, 4);
        drawChild(canvas, this.f11719c, getDrawingTime());
        C0498a.a(canvas, false);
    }

    @Override // android.view.View, androidx.transition.InterfaceC0503f
    public void setVisibility(int i10) {
        int i11;
        super.setVisibility(i10);
        if (e(this.f11719c) == this) {
            if (i10 == 0) {
                i11 = 4;
            } else {
                i11 = 0;
            }
            H.g(this.f11719c, i11);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
    }
}
