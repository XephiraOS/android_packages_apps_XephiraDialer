package com.google.android.material.behavior;

import J.d;
import J.g;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.K;
import androidx.customview.widget.c;
import com.android.incallui.OplusPhoneUtils;

/* loaded from: classes3.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a, reason: collision with root package name */
    public androidx.customview.widget.c f22723a;

    /* renamed from: b, reason: collision with root package name */
    public c f22724b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f22725c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f22726d;

    /* renamed from: f, reason: collision with root package name */
    public boolean f22728f;

    /* renamed from: e, reason: collision with root package name */
    public float f22727e = 0.0f;

    /* renamed from: g, reason: collision with root package name */
    public int f22729g = 2;

    /* renamed from: h, reason: collision with root package name */
    public float f22730h = 0.5f;

    /* renamed from: i, reason: collision with root package name */
    public float f22731i = 0.0f;

    /* renamed from: j, reason: collision with root package name */
    public float f22732j = 0.5f;

    /* renamed from: k, reason: collision with root package name */
    public final c.AbstractC0115c f22733k = new a();

    /* loaded from: classes3.dex */
    public class a extends c.AbstractC0115c {

        /* renamed from: a, reason: collision with root package name */
        public int f22734a;

        /* renamed from: b, reason: collision with root package name */
        public int f22735b = -1;

        public a() {
        }

        public final boolean a(View view, float f10) {
            boolean z10;
            if (f10 != 0.0f) {
                if (K.v(view) == 1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                int i10 = SwipeDismissBehavior.this.f22729g;
                if (i10 == 2) {
                    return true;
                }
                if (i10 == 0) {
                    if (z10) {
                        if (f10 >= 0.0f) {
                            return false;
                        }
                    } else if (f10 <= 0.0f) {
                        return false;
                    }
                    return true;
                }
                if (i10 != 1) {
                    return false;
                }
                if (z10) {
                    if (f10 <= 0.0f) {
                        return false;
                    }
                } else if (f10 >= 0.0f) {
                    return false;
                }
                return true;
            }
            if (Math.abs(view.getLeft() - this.f22734a) < Math.round(view.getWidth() * SwipeDismissBehavior.this.f22730h)) {
                return false;
            }
            return true;
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public int clampViewPositionHorizontal(View view, int i10, int i11) {
            boolean z10;
            int width;
            int width2;
            int width3;
            if (K.v(view) == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            int i12 = SwipeDismissBehavior.this.f22729g;
            if (i12 == 0) {
                if (z10) {
                    width = this.f22734a - view.getWidth();
                    width2 = this.f22734a;
                } else {
                    width = this.f22734a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i12 == 1) {
                if (z10) {
                    width = this.f22734a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                } else {
                    width = this.f22734a - view.getWidth();
                    width2 = this.f22734a;
                }
            } else {
                width = this.f22734a - view.getWidth();
                width2 = this.f22734a + view.getWidth();
            }
            return SwipeDismissBehavior.d(width, i10, width2);
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public int clampViewPositionVertical(View view, int i10, int i11) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public int getViewHorizontalDragRange(View view) {
            return view.getWidth();
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public void onViewCaptured(View view, int i10) {
            this.f22735b = i10;
            this.f22734a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                SwipeDismissBehavior.this.f22726d = true;
                parent.requestDisallowInterceptTouchEvent(true);
                SwipeDismissBehavior.this.f22726d = false;
            }
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public void onViewDragStateChanged(int i10) {
            c cVar = SwipeDismissBehavior.this.f22724b;
            if (cVar != null) {
                cVar.b(i10);
            }
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public void onViewPositionChanged(View view, int i10, int i11, int i12, int i13) {
            float width = view.getWidth() * SwipeDismissBehavior.this.f22731i;
            float width2 = view.getWidth() * SwipeDismissBehavior.this.f22732j;
            float abs = Math.abs(i10 - this.f22734a);
            if (abs <= width) {
                view.setAlpha(1.0f);
            } else if (abs >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.c(0.0f, 1.0f - SwipeDismissBehavior.f(width, width2, abs), 1.0f));
            }
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public void onViewReleased(View view, float f10, float f11) {
            int i10;
            boolean z10;
            c cVar;
            this.f22735b = -1;
            int width = view.getWidth();
            if (a(view, f10)) {
                if (f10 >= 0.0f) {
                    int left = view.getLeft();
                    int i11 = this.f22734a;
                    if (left >= i11) {
                        i10 = i11 + width;
                        z10 = true;
                    }
                }
                i10 = this.f22734a - width;
                z10 = true;
            } else {
                i10 = this.f22734a;
                z10 = false;
            }
            if (SwipeDismissBehavior.this.f22723a.P(i10, view.getTop())) {
                K.a0(view, new d(view, z10));
            } else if (z10 && (cVar = SwipeDismissBehavior.this.f22724b) != null) {
                cVar.a(view);
            }
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public boolean tryCaptureView(View view, int i10) {
            int i11 = this.f22735b;
            if ((i11 == -1 || i11 == i10) && SwipeDismissBehavior.this.b(view)) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements g {
        public b() {
        }

        @Override // J.g
        public boolean perform(View view, g.a aVar) {
            int width;
            boolean z10 = false;
            if (!SwipeDismissBehavior.this.b(view)) {
                return false;
            }
            if (K.v(view) == 1) {
                z10 = true;
            }
            int i10 = SwipeDismissBehavior.this.f22729g;
            if ((i10 == 0 && z10) || (i10 == 1 && !z10)) {
                width = -view.getWidth();
            } else {
                width = view.getWidth();
            }
            K.T(view, width);
            view.setAlpha(0.0f);
            c cVar = SwipeDismissBehavior.this.f22724b;
            if (cVar != null) {
                cVar.a(view);
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(View view);

        void b(int i10);
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final View f22738a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f22739b;

        public d(View view, boolean z10) {
            this.f22738a = view;
            this.f22739b = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar;
            androidx.customview.widget.c cVar2 = SwipeDismissBehavior.this.f22723a;
            if (cVar2 != null && cVar2.n(true)) {
                K.a0(this.f22738a, this);
            } else if (this.f22739b && (cVar = SwipeDismissBehavior.this.f22724b) != null) {
                cVar.a(this.f22738a);
            }
        }
    }

    public static float c(float f10, float f11, float f12) {
        return Math.min(Math.max(f10, f11), f12);
    }

    public static int d(int i10, int i11, int i12) {
        return Math.min(Math.max(i10, i11), i12);
    }

    public static float f(float f10, float f11, float f12) {
        return (f12 - f10) / (f11 - f10);
    }

    public boolean b(View view) {
        return true;
    }

    public final void e(ViewGroup viewGroup) {
        androidx.customview.widget.c p10;
        if (this.f22723a == null) {
            if (this.f22728f) {
                p10 = androidx.customview.widget.c.o(viewGroup, this.f22727e, this.f22733k);
            } else {
                p10 = androidx.customview.widget.c.p(viewGroup, this.f22733k);
            }
            this.f22723a = p10;
        }
    }

    public void g(float f10) {
        this.f22732j = c(0.0f, f10, 1.0f);
    }

    public void h(c cVar) {
        this.f22724b = cVar;
    }

    public void i(float f10) {
        this.f22731i = c(0.0f, f10, 1.0f);
    }

    public void j(int i10) {
        this.f22729g = i10;
    }

    public final void k(View view) {
        K.c0(view, OplusPhoneUtils.PROPERTY_HIGH_DEF_AUDIO_EVS);
        if (b(view)) {
            K.e0(view, d.a.f1410y, null, new b());
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        boolean z10 = this.f22725c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                this.f22725c = false;
            }
        } else {
            z10 = coordinatorLayout.z(v10, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f22725c = z10;
        }
        if (!z10) {
            return false;
        }
        e(coordinatorLayout);
        if (!this.f22726d && this.f22723a.Q(motionEvent)) {
            return true;
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, v10, i10);
        if (K.t(v10) == 0) {
            K.t0(v10, 1);
            k(v10);
        }
        return onLayoutChild;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        if (this.f22723a != null) {
            if (!this.f22726d || motionEvent.getActionMasked() != 3) {
                this.f22723a.G(motionEvent);
                return true;
            }
            return true;
        }
        return false;
    }
}
