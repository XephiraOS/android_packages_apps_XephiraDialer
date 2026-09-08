package com.oplus.foundation.appsupport.ui.widget.recyclerview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.K;
import androidx.recyclerview.widget.RecyclerView;
import com.android.incallui.OplusAutoRedial;
import com.coui.appcompat.animation.COUILinearInterpolator;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.foundation.appsupport.ui.widget.recyclerview.DragSelectRecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m7.C1342c;

/* compiled from: DragSelectRecyclerView.kt */
/* loaded from: classes3.dex */
public class DragSelectRecyclerView extends AppSupportRecyclerView {

    /* renamed from: M, reason: collision with root package name */
    public static final a f28226M = new a(null);

    /* renamed from: A, reason: collision with root package name */
    public boolean f28227A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f28228B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f28229C;

    /* renamed from: D, reason: collision with root package name */
    public OverScroller f28230D;

    /* renamed from: E, reason: collision with root package name */
    public final int f28231E;

    /* renamed from: F, reason: collision with root package name */
    public final int f28232F;

    /* renamed from: G, reason: collision with root package name */
    public int f28233G;

    /* renamed from: H, reason: collision with root package name */
    public int f28234H;

    /* renamed from: I, reason: collision with root package name */
    public int f28235I;

    /* renamed from: J, reason: collision with root package name */
    public final b f28236J;

    /* renamed from: K, reason: collision with root package name */
    public final View.OnLayoutChangeListener f28237K;

    /* renamed from: L, reason: collision with root package name */
    public w7.b f28238L;

    /* renamed from: e, reason: collision with root package name */
    public final Rect f28239e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f28240f;

    /* renamed from: g, reason: collision with root package name */
    public int f28241g;

    /* renamed from: h, reason: collision with root package name */
    public int f28242h;

    /* renamed from: i, reason: collision with root package name */
    public int f28243i;

    /* renamed from: j, reason: collision with root package name */
    public int f28244j;

    /* renamed from: k, reason: collision with root package name */
    public float f28245k;

    /* renamed from: l, reason: collision with root package name */
    public float f28246l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f28247m;

    /* renamed from: n, reason: collision with root package name */
    public Rect f28248n;

    /* renamed from: o, reason: collision with root package name */
    public int f28249o;

    /* renamed from: p, reason: collision with root package name */
    public int f28250p;

    /* renamed from: q, reason: collision with root package name */
    public int f28251q;

    /* renamed from: r, reason: collision with root package name */
    public int f28252r;

    /* renamed from: x, reason: collision with root package name */
    public int f28253x;

    /* renamed from: y, reason: collision with root package name */
    public int f28254y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f28255z;

    /* compiled from: DragSelectRecyclerView.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: DragSelectRecyclerView.kt */
    /* loaded from: classes3.dex */
    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int max;
            OverScroller overScroller = DragSelectRecyclerView.this.f28230D;
            if (overScroller != null && overScroller.computeScrollOffset()) {
                if (DragSelectRecyclerView.this.f28233G > 0) {
                    max = Math.min(DragSelectRecyclerView.this.f28233G, DragSelectRecyclerView.this.f28231E);
                } else {
                    max = Integer.max(DragSelectRecyclerView.this.f28233G, -DragSelectRecyclerView.this.f28231E);
                }
                DragSelectRecyclerView.this.scrollBy(0, max);
                if (DragSelectRecyclerView.this.f28245k != Float.MIN_VALUE && DragSelectRecyclerView.this.f28245k != Float.MIN_VALUE) {
                    DragSelectRecyclerView dragSelectRecyclerView = DragSelectRecyclerView.this;
                    dragSelectRecyclerView.w(dragSelectRecyclerView.f28245k, DragSelectRecyclerView.this.f28246l);
                }
                K.a0(DragSelectRecyclerView.this, this);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DragSelectRecyclerView(Context context) {
        this(context, null);
        i.f(context, "context");
    }

    public static /* synthetic */ void j(DragSelectRecyclerView dragSelectRecyclerView, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if (obj == null) {
            if ((i14 & 1) != 0) {
                i10 = dragSelectRecyclerView.getContext().getResources().getDimensionPixelSize(C1342c.f35175b);
            }
            if ((i14 & 2) != 0) {
                i11 = 0;
            }
            if ((i14 & 4) != 0) {
                i12 = 0;
            }
            if ((i14 & 8) != 0) {
                i13 = 0;
            }
            dragSelectRecyclerView.i(i10, i11, i12, i13);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enterDragSelectMode");
    }

    public static final void n(DragSelectRecyclerView this$0, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        i.f(this$0, "this$0");
        if (view != null) {
            if (i10 != i14 || i11 != i15 || i12 != i16 || i13 != i17) {
                this$0.v();
            }
        }
    }

    private final void r() {
        this.f28247m = false;
        this.f28241g = -1;
        this.f28242h = -1;
        this.f28243i = -1;
        this.f28244j = -1;
        this.f28245k = Float.MIN_VALUE;
        this.f28246l = Float.MIN_VALUE;
        this.f28228B = false;
        this.f28229C = false;
        u();
    }

    @Override // com.oplus.foundation.appsupport.ui.widget.recyclerview.AppSupportRecyclerView, androidx.recyclerview.widget.COUIRecyclerView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        w7.b bVar;
        i.f(event, "event");
        try {
            Result.a aVar = Result.f34166a;
            if (this.f28240f) {
                int action = event.getAction() & 255;
                if (action != 0) {
                    if (action != 1) {
                        if (action != 2) {
                            if (action != 3) {
                            }
                        } else if (this.f28247m) {
                            if (!this.f28228B && !this.f28229C && m(event)) {
                                w(event.getX(), event.getY());
                            }
                            q(event);
                            return true;
                        }
                    }
                    r();
                } else {
                    View findChildViewUnder = findChildViewUnder(event.getX(), event.getY());
                    if (findChildViewUnder != null) {
                        int childLayoutPosition = getChildLayoutPosition(findChildViewUnder);
                        if (m(event) && (bVar = this.f28238L) != null && bVar.Z0(findChildViewUnder, childLayoutPosition)) {
                            t(childLayoutPosition);
                            return true;
                        }
                    }
                }
                return super.dispatchTouchEvent(event);
            }
            return super.dispatchTouchEvent(event);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            Throwable d10 = Result.d(Result.b(kotlin.b.a(th)));
            if (d10 != null) {
                H7.b.c("DragSelectRecyclerView", "e = " + d10);
                return false;
            }
            return false;
        }
    }

    public final w7.b getDragSelectListener() {
        return this.f28238L;
    }

    public final void i(int i10, int i11, int i12, int i13) {
        this.f28240f = true;
        this.f28234H = i10;
        this.f28235I = i11;
        this.f28249o = i12;
        this.f28250p = i13;
        v();
    }

    public final void k() {
        this.f28240f = false;
        r();
    }

    public final void l() {
        if (getParent() instanceof CoordinatorLayout) {
            ViewParent parent = getParent();
            i.d(parent, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout");
            List<View> p10 = ((CoordinatorLayout) parent).p(this);
            i.e(p10, "parent as CoordinatorLayout).getDependencies(this)");
            for (View view : p10) {
                if (view instanceof AppBarLayout) {
                    ((AppBarLayout) view).setExpanded(false, true);
                    return;
                }
            }
        }
    }

    public final boolean m(MotionEvent motionEvent) {
        return this.f28248n.contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    public final void o(int i10, int i11) {
        View view;
        int min = Math.min(i10, i11);
        int max = Integer.max(i10, i11);
        ArrayList arrayList = new ArrayList();
        if (min <= max) {
            while (true) {
                RecyclerView.o layoutManager = getLayoutManager();
                if (layoutManager != null) {
                    view = layoutManager.findViewByPosition(min);
                } else {
                    view = null;
                }
                if (view != null) {
                    arrayList.add(view);
                } else {
                    Log.d("DragSelectRecyclerView", "notifyItemRangTouch: child is null " + min);
                }
                if (min == max) {
                    break;
                } else {
                    min++;
                }
            }
        }
        w7.b bVar = this.f28238L;
        if (bVar != null) {
            bVar.K(i10, i11, arrayList);
        }
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        addOnLayoutChangeListener(this.f28237K);
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeOnLayoutChangeListener(this.f28237K);
    }

    public final void p() {
        int i10;
        int i11;
        if (this.f28238L != null && (i10 = this.f28241g) != -1 && (i11 = this.f28242h) != -1) {
            int min = Math.min(i10, i11);
            int max = Integer.max(this.f28241g, this.f28242h);
            int i12 = this.f28243i;
            if (min < i12) {
                o(min, i12 - 1);
            } else if (min > i12) {
                o(i12, min - 1);
            }
            int i13 = this.f28244j;
            if (max > i13) {
                o(i13 + 1, max);
            } else if (max < i13) {
                o(max + 1, i13);
            }
            this.f28243i = min;
            this.f28244j = max;
        }
    }

    public final void q(MotionEvent motionEvent) {
        int y10 = (int) motionEvent.getY();
        int i10 = this.f28251q;
        if (y10 <= this.f28252r && i10 <= y10) {
            this.f28245k = motionEvent.getX();
            this.f28246l = motionEvent.getY();
            this.f28233G = (int) (this.f28231E * ((this.f28252r - motionEvent.getY()) / (this.f28252r - this.f28251q)) * (-1.0f));
            if (!this.f28228B) {
                this.f28228B = true;
                s();
                return;
            }
            return;
        }
        if (this.f28255z && y10 < i10) {
            this.f28245k = motionEvent.getX();
            this.f28246l = motionEvent.getY();
            this.f28233G = (int) (this.f28231E * (-1.0f));
            if (!this.f28228B) {
                this.f28228B = true;
                s();
                return;
            }
            return;
        }
        int i11 = this.f28253x;
        int i12 = this.f28254y;
        if (y10 <= i12 && i11 <= y10) {
            this.f28245k = motionEvent.getX();
            this.f28246l = motionEvent.getY();
            float y11 = motionEvent.getY();
            int i13 = this.f28253x;
            this.f28233G = (int) (this.f28231E * ((y11 - i13) / (this.f28254y - i13)));
            if (!this.f28229C) {
                this.f28229C = true;
                l();
                s();
                return;
            }
            return;
        }
        if (this.f28227A && y10 > i12) {
            this.f28245k = motionEvent.getX();
            this.f28246l = motionEvent.getY();
            this.f28233G = this.f28231E;
            if (!this.f28229C) {
                this.f28229C = true;
                s();
                return;
            }
            return;
        }
        this.f28228B = false;
        this.f28229C = false;
        this.f28245k = Float.MIN_VALUE;
        this.f28246l = Float.MIN_VALUE;
        u();
    }

    public final void s() {
        OverScroller overScroller = this.f28230D;
        if (overScroller == null) {
            overScroller = new OverScroller(getContext(), new COUILinearInterpolator());
            this.f28230D = overScroller;
        }
        OverScroller overScroller2 = overScroller;
        if (overScroller2.isFinished()) {
            w7.b bVar = this.f28238L;
            if (bVar != null) {
                bVar.p0();
            }
            removeCallbacks(this.f28236J);
            overScroller2.startScroll(0, overScroller2.getCurrY(), 0, OplusAutoRedial.DELAY_FIVE_SECOND, 100000);
            K.a0(this, this.f28236J);
        }
    }

    public final void setDragRegionWidth(int i10) {
        this.f28234H = i10;
        v();
    }

    public final void setDragSelectListener(w7.b bVar) {
        this.f28238L = bVar;
    }

    public final void t(int i10) {
        this.f28247m = true;
        this.f28241g = i10;
        this.f28242h = i10;
        this.f28243i = i10;
        this.f28244j = i10;
    }

    public final void u() {
        OverScroller overScroller = this.f28230D;
        if (overScroller != null && !overScroller.isFinished()) {
            w7.b bVar = this.f28238L;
            if (bVar != null) {
                bVar.T();
            }
            removeCallbacks(this.f28236J);
            OverScroller overScroller2 = this.f28230D;
            if (overScroller2 != null) {
                overScroller2.abortAnimation();
            }
        }
    }

    public final void v() {
        getLocalVisibleRect(this.f28239e);
        Rect rect = this.f28239e;
        int i10 = rect.top + this.f28249o;
        this.f28251q = i10;
        int i11 = this.f28232F;
        this.f28252r = i10 + i11;
        int i12 = rect.bottom - this.f28250p;
        this.f28254y = i12;
        this.f28253x = i12 - i11;
        if (getLayoutDirection() == 1) {
            Rect rect2 = this.f28248n;
            int i13 = this.f28235I;
            Rect rect3 = this.f28239e;
            rect2.set(i13, rect3.top, this.f28234H + i13, rect3.height());
            return;
        }
        Rect rect4 = this.f28248n;
        int width = (this.f28239e.width() - this.f28235I) - this.f28234H;
        Rect rect5 = this.f28239e;
        rect4.set(width, rect5.top, rect5.width() - this.f28235I, getMeasuredHeight());
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0016, code lost:
    
        if (r4 > r0) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0009, code lost:
    
        if (r4 < r0) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000b, code lost:
    
        r4 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(float r3, float r4) {
        /*
            r2 = this;
            boolean r0 = r2.f28255z
            if (r0 == 0) goto Ld
            int r0 = r2.f28251q
            float r1 = (float) r0
            int r1 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r1 >= 0) goto Ld
        Lb:
            float r4 = (float) r0
            goto L19
        Ld:
            boolean r0 = r2.f28227A
            if (r0 == 0) goto L19
            int r0 = r2.f28254y
            float r1 = (float) r0
            int r1 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r1 <= 0) goto L19
            goto Lb
        L19:
            android.view.View r3 = r2.findChildViewUnder(r3, r4)
            if (r3 == 0) goto L2f
            int r3 = r2.getChildAdapterPosition(r3)
            r4 = -1
            if (r3 == r4) goto L2f
            int r4 = r2.f28242h
            if (r4 == r3) goto L2f
            r2.f28242h = r3
            r2.p()
        L2f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.foundation.appsupport.ui.widget.recyclerview.DragSelectRecyclerView.w(float, float):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DragSelectRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        i.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragSelectRecyclerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
        this.f28239e = new Rect();
        this.f28241g = -1;
        this.f28242h = -1;
        this.f28243i = -1;
        this.f28244j = -1;
        this.f28248n = new Rect();
        this.f28255z = true;
        this.f28227A = true;
        this.f28231E = (int) (Resources.getSystem().getDisplayMetrics().density * 7);
        this.f28232F = (int) (Resources.getSystem().getDisplayMetrics().density * 56);
        this.f28236J = new b();
        this.f28237K = new View.OnLayoutChangeListener() { // from class: w7.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                DragSelectRecyclerView.n(DragSelectRecyclerView.this, view, i11, i12, i13, i14, i15, i16, i17, i18);
            }
        };
    }
}
