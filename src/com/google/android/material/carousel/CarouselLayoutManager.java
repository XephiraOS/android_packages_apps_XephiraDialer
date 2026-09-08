package com.google.android.material.carousel;

import I.h;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.o;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.carousel.b;
import e4.C0979e;
import e4.m;
import f4.C1001b;
import j4.e;
import j4.f;
import j4.g;
import j4.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class CarouselLayoutManager extends RecyclerView.o implements j4.b, RecyclerView.x.b {

    /* renamed from: a, reason: collision with root package name */
    public int f22918a;

    /* renamed from: b, reason: collision with root package name */
    public int f22919b;

    /* renamed from: c, reason: collision with root package name */
    public int f22920c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f22921d;

    /* renamed from: e, reason: collision with root package name */
    public final c f22922e;

    /* renamed from: f, reason: collision with root package name */
    public f f22923f;

    /* renamed from: g, reason: collision with root package name */
    public com.google.android.material.carousel.c f22924g;

    /* renamed from: h, reason: collision with root package name */
    public com.google.android.material.carousel.b f22925h;

    /* renamed from: i, reason: collision with root package name */
    public int f22926i;

    /* renamed from: j, reason: collision with root package name */
    public Map<Integer, com.google.android.material.carousel.b> f22927j;

    /* renamed from: k, reason: collision with root package name */
    public e f22928k;

    /* renamed from: l, reason: collision with root package name */
    public final View.OnLayoutChangeListener f22929l;

    /* renamed from: m, reason: collision with root package name */
    public int f22930m;

    /* renamed from: n, reason: collision with root package name */
    public int f22931n;

    /* renamed from: o, reason: collision with root package name */
    public int f22932o;

    /* loaded from: classes3.dex */
    public class a extends o {
        public a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.o
        public int calculateDxToMakeVisible(View view, int i10) {
            if (CarouselLayoutManager.this.f22924g != null && CarouselLayoutManager.this.d()) {
                CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
                return carouselLayoutManager.u(carouselLayoutManager.getPosition(view));
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.o
        public int calculateDyToMakeVisible(View view, int i10) {
            if (CarouselLayoutManager.this.f22924g != null && !CarouselLayoutManager.this.d()) {
                CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
                return carouselLayoutManager.u(carouselLayoutManager.getPosition(view));
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.x
        public PointF computeScrollVectorForPosition(int i10) {
            return CarouselLayoutManager.this.computeScrollVectorForPosition(i10);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final View f22934a;

        /* renamed from: b, reason: collision with root package name */
        public final float f22935b;

        /* renamed from: c, reason: collision with root package name */
        public final float f22936c;

        /* renamed from: d, reason: collision with root package name */
        public final d f22937d;

        public b(View view, float f10, float f11, d dVar) {
            this.f22934a = view;
            this.f22935b = f10;
            this.f22936c = f11;
            this.f22937d = dVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends RecyclerView.n {

        /* renamed from: a, reason: collision with root package name */
        public final Paint f22938a;

        /* renamed from: b, reason: collision with root package name */
        public List<b.c> f22939b;

        public c() {
            Paint paint = new Paint();
            this.f22938a = paint;
            this.f22939b = Collections.unmodifiableList(new ArrayList());
            paint.setStrokeWidth(5.0f);
            paint.setColor(-65281);
        }

        public void d(List<b.c> list) {
            this.f22939b = Collections.unmodifiableList(list);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.y yVar) {
            super.onDrawOver(canvas, recyclerView, yVar);
            this.f22938a.setStrokeWidth(recyclerView.getResources().getDimension(C0979e.f30727C));
            for (b.c cVar : this.f22939b) {
                this.f22938a.setColor(B.a.i(-65281, -16776961, cVar.f22962c));
                if (((CarouselLayoutManager) recyclerView.getLayoutManager()).d()) {
                    canvas.drawLine(cVar.f22961b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).K(), cVar.f22961b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).F(), this.f22938a);
                } else {
                    canvas.drawLine(((CarouselLayoutManager) recyclerView.getLayoutManager()).H(), cVar.f22961b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).I(), cVar.f22961b, this.f22938a);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final b.c f22940a;

        /* renamed from: b, reason: collision with root package name */
        public final b.c f22941b;

        public d(b.c cVar, b.c cVar2) {
            boolean z10;
            if (cVar.f22960a <= cVar2.f22960a) {
                z10 = true;
            } else {
                z10 = false;
            }
            h.a(z10);
            this.f22940a = cVar;
            this.f22941b = cVar2;
        }
    }

    public CarouselLayoutManager() {
        this(new j());
    }

    public static d O(List<b.c> list, float f10, boolean z10) {
        float f11;
        float f12 = Float.MAX_VALUE;
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        float f13 = -3.4028235E38f;
        float f14 = Float.MAX_VALUE;
        float f15 = Float.MAX_VALUE;
        for (int i14 = 0; i14 < list.size(); i14++) {
            b.c cVar = list.get(i14);
            if (z10) {
                f11 = cVar.f22961b;
            } else {
                f11 = cVar.f22960a;
            }
            float abs = Math.abs(f11 - f10);
            if (f11 <= f10 && abs <= f12) {
                i10 = i14;
                f12 = abs;
            }
            if (f11 > f10 && abs <= f14) {
                i12 = i14;
                f14 = abs;
            }
            if (f11 <= f15) {
                i11 = i14;
                f15 = f11;
            }
            if (f11 > f13) {
                i13 = i14;
                f13 = f11;
            }
        }
        if (i10 == -1) {
            i10 = i11;
        }
        if (i12 == -1) {
            i12 = i13;
        }
        return new d(list.get(i10), list.get(i12));
    }

    private int convertFocusDirectionToLayoutDirection(int i10) {
        int orientation = getOrientation();
        if (i10 == 1) {
            return -1;
        }
        if (i10 == 2) {
            return 1;
        }
        if (i10 != 17) {
            if (i10 != 33) {
                if (i10 != 66) {
                    if (i10 != 130) {
                        Log.d("CarouselLayoutManager", "Unknown focus request:" + i10);
                        return Integer.MIN_VALUE;
                    }
                    if (orientation == 1) {
                        return 1;
                    }
                    return Integer.MIN_VALUE;
                }
                if (orientation != 0) {
                    return Integer.MIN_VALUE;
                }
                if (P()) {
                    return -1;
                }
                return 1;
            }
            if (orientation == 1) {
                return -1;
            }
            return Integer.MIN_VALUE;
        }
        if (orientation != 0) {
            return Integer.MIN_VALUE;
        }
        if (!P()) {
            return -1;
        }
        return 1;
    }

    private int scrollBy(int i10, RecyclerView.u uVar, RecyclerView.y yVar) {
        float f10;
        if (getChildCount() == 0 || i10 == 0) {
            return 0;
        }
        if (this.f22924g == null) {
            W(uVar);
        }
        int v10 = v(i10, this.f22918a, this.f22919b, this.f22920c);
        this.f22918a += v10;
        e0(this.f22924g);
        float f11 = this.f22925h.f() / 2.0f;
        float s10 = s(getPosition(getChildAt(0)));
        Rect rect = new Rect();
        if (P()) {
            f10 = this.f22925h.h().f22961b;
        } else {
            f10 = this.f22925h.a().f22961b;
        }
        float f12 = Float.MAX_VALUE;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            float abs = Math.abs(f10 - V(childAt, s10, f11, rect));
            if (childAt != null && abs < f12) {
                this.f22931n = getPosition(childAt);
                f12 = abs;
            }
            s10 = m(s10, this.f22925h.f());
        }
        x(uVar, yVar);
        return v10;
    }

    public static int v(int i10, int i11, int i12, int i13) {
        int i14 = i11 + i10;
        if (i14 < i12) {
            return i12 - i11;
        }
        if (i14 > i13) {
            return i13 - i11;
        }
        return i10;
    }

    public final int A() {
        int i10;
        int i11;
        if (getChildCount() <= 0) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) getChildAt(0).getLayoutParams();
        if (this.f22928k.f33863a == 0) {
            i10 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            i11 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        } else {
            i10 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            i11 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        return i10 + i11;
    }

    public final com.google.android.material.carousel.b B(int i10) {
        com.google.android.material.carousel.b bVar;
        Map<Integer, com.google.android.material.carousel.b> map = this.f22927j;
        if (map != null && (bVar = map.get(Integer.valueOf(E.a.b(i10, 0, Math.max(0, getItemCount() - 1))))) != null) {
            return bVar;
        }
        return this.f22924g.g();
    }

    public final int C() {
        if (!getClipToPadding() && this.f22923f.f()) {
            if (getOrientation() == 1) {
                return getPaddingTop();
            }
            return getPaddingLeft();
        }
        return 0;
    }

    public final float D(float f10, d dVar) {
        b.c cVar = dVar.f22940a;
        float f11 = cVar.f22963d;
        b.c cVar2 = dVar.f22941b;
        return C1001b.b(f11, cVar2.f22963d, cVar.f22961b, cVar2.f22961b, f10);
    }

    public int E(int i10, com.google.android.material.carousel.b bVar) {
        return M(i10, bVar) - this.f22918a;
    }

    public final int F() {
        return this.f22928k.g();
    }

    public final int G() {
        return this.f22928k.h();
    }

    public final int H() {
        return this.f22928k.i();
    }

    public final int I() {
        return this.f22928k.j();
    }

    public final int J() {
        return this.f22928k.k();
    }

    public final int K() {
        return this.f22928k.l();
    }

    public final int L() {
        if (!getClipToPadding() && this.f22923f.f()) {
            if (getOrientation() == 1) {
                return getPaddingBottom();
            }
            return getPaddingRight();
        }
        return 0;
    }

    public final int M(int i10, com.google.android.material.carousel.b bVar) {
        float f10;
        if (P()) {
            f10 = ((y() - bVar.h().f22960a) - (i10 * bVar.f())) - (bVar.f() / 2.0f);
        } else {
            f10 = ((i10 * bVar.f()) - bVar.a().f22960a) + (bVar.f() / 2.0f);
        }
        return (int) f10;
    }

    public final int N(int i10, com.google.android.material.carousel.b bVar) {
        int i11;
        int i12 = Integer.MAX_VALUE;
        for (b.c cVar : bVar.e()) {
            float f10 = (i10 * bVar.f()) + (bVar.f() / 2.0f);
            if (P()) {
                i11 = (int) ((y() - cVar.f22960a) - f10);
            } else {
                i11 = (int) (f10 - cVar.f22960a);
            }
            int i13 = i11 - this.f22918a;
            if (Math.abs(i12) > Math.abs(i13)) {
                i12 = i13;
            }
        }
        return i12;
    }

    public boolean P() {
        if (d() && getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public final boolean Q(float f10, d dVar) {
        float n10 = n(f10, D(f10, dVar) / 2.0f);
        if (P()) {
            if (n10 >= 0.0f) {
                return false;
            }
        } else if (n10 <= y()) {
            return false;
        }
        return true;
    }

    public final boolean R(float f10, d dVar) {
        float m10 = m(f10, D(f10, dVar) / 2.0f);
        if (P()) {
            if (m10 <= y()) {
                return false;
            }
        } else if (m10 >= 0.0f) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ void S(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        if (i10 != i14 || i11 != i15 || i12 != i16 || i13 != i17) {
            view.post(new Runnable() { // from class: j4.d
                @Override // java.lang.Runnable
                public final void run() {
                    CarouselLayoutManager.this.X();
                }
            });
        }
    }

    public final void T() {
        if (this.f22921d && Log.isLoggable("CarouselLayoutManager", 3)) {
            Log.d("CarouselLayoutManager", "internal representation of views on the screen");
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                Log.d("CarouselLayoutManager", "item position " + getPosition(childAt) + ", center:" + z(childAt) + ", child index:" + i10);
            }
            Log.d("CarouselLayoutManager", "==============");
        }
    }

    public final b U(RecyclerView.u uVar, float f10, int i10) {
        View o10 = uVar.o(i10);
        measureChildWithMargins(o10, 0, 0);
        float m10 = m(f10, this.f22925h.f() / 2.0f);
        d O10 = O(this.f22925h.g(), m10, false);
        return new b(o10, m10, r(o10, m10, O10), O10);
    }

    public final float V(View view, float f10, float f11, Rect rect) {
        float m10 = m(f10, f11);
        d O10 = O(this.f22925h.g(), m10, false);
        float r10 = r(view, m10, O10);
        super.getDecoratedBoundsWithMargins(view, rect);
        d0(view, m10, O10);
        this.f22928k.o(view, rect, f11, r10);
        return r10;
    }

    public final void W(RecyclerView.u uVar) {
        View o10 = uVar.o(0);
        measureChildWithMargins(o10, 0, 0);
        com.google.android.material.carousel.b g10 = this.f22923f.g(this, o10);
        if (P()) {
            g10 = com.google.android.material.carousel.b.n(g10, y());
        }
        this.f22924g = com.google.android.material.carousel.c.f(this, g10, A(), C(), L());
    }

    public final void X() {
        this.f22924g = null;
        requestLayout();
    }

    public final void Y(RecyclerView.u uVar) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            float z10 = z(childAt);
            if (!R(z10, O(this.f22925h.g(), z10, true))) {
                break;
            } else {
                removeAndRecycleView(childAt, uVar);
            }
        }
        while (getChildCount() - 1 >= 0) {
            View childAt2 = getChildAt(getChildCount() - 1);
            float z11 = z(childAt2);
            if (Q(z11, O(this.f22925h.g(), z11, true))) {
                removeAndRecycleView(childAt2, uVar);
            } else {
                return;
            }
        }
    }

    public final void Z(RecyclerView recyclerView, int i10) {
        if (d()) {
            recyclerView.scrollBy(i10, 0);
        } else {
            recyclerView.scrollBy(0, i10);
        }
    }

    @Override // j4.b
    public int a() {
        return getWidth();
    }

    public void a0(int i10) {
        this.f22932o = i10;
        X();
    }

    @Override // j4.b
    public int b() {
        return getHeight();
    }

    public final void b0(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f31495p1);
            a0(obtainStyledAttributes.getInt(m.f31506q1, 0));
            setOrientation(obtainStyledAttributes.getInt(m.f31458l8, 0));
            obtainStyledAttributes.recycle();
        }
    }

    @Override // j4.b
    public int c() {
        return this.f22932o;
    }

    public void c0(f fVar) {
        this.f22923f = fVar;
        X();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean canScrollHorizontally() {
        return d();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean canScrollVertically() {
        return !d();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollExtent(RecyclerView.y yVar) {
        if (getChildCount() != 0 && this.f22924g != null && getItemCount() > 1) {
            return (int) (getWidth() * (this.f22924g.g().f() / computeHorizontalScrollRange(yVar)));
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollOffset(RecyclerView.y yVar) {
        return this.f22918a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollRange(RecyclerView.y yVar) {
        return this.f22920c - this.f22919b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.x.b
    public PointF computeScrollVectorForPosition(int i10) {
        if (this.f22924g == null) {
            return null;
        }
        int E10 = E(i10, B(i10));
        if (d()) {
            return new PointF(E10, 0.0f);
        }
        return new PointF(0.0f, E10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollExtent(RecyclerView.y yVar) {
        if (getChildCount() != 0 && this.f22924g != null && getItemCount() > 1) {
            return (int) (getHeight() * (this.f22924g.g().f() / computeVerticalScrollRange(yVar)));
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollOffset(RecyclerView.y yVar) {
        return this.f22918a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollRange(RecyclerView.y yVar) {
        return this.f22920c - this.f22919b;
    }

    @Override // j4.b
    public boolean d() {
        if (this.f22928k.f33863a == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d0(View view, float f10, d dVar) {
        if (!(view instanceof g)) {
            return;
        }
        b.c cVar = dVar.f22940a;
        float f11 = cVar.f22962c;
        b.c cVar2 = dVar.f22941b;
        float b10 = C1001b.b(f11, cVar2.f22962c, cVar.f22960a, cVar2.f22960a, f10);
        float height = view.getHeight();
        float width = view.getWidth();
        RectF f12 = this.f22928k.f(height, width, C1001b.b(0.0f, height / 2.0f, 0.0f, 1.0f, b10), C1001b.b(0.0f, width / 2.0f, 0.0f, 1.0f, b10));
        float r10 = r(view, f10, dVar);
        RectF rectF = new RectF(r10 - (f12.width() / 2.0f), r10 - (f12.height() / 2.0f), r10 + (f12.width() / 2.0f), (f12.height() / 2.0f) + r10);
        RectF rectF2 = new RectF(H(), K(), I(), F());
        if (this.f22923f.f()) {
            this.f22928k.a(f12, rectF, rectF2);
        }
        this.f22928k.n(f12, rectF, rectF2);
        ((g) view).setMaskRectF(f12);
    }

    public final void e0(com.google.android.material.carousel.c cVar) {
        com.google.android.material.carousel.b l10;
        int i10 = this.f22920c;
        int i11 = this.f22919b;
        if (i10 <= i11) {
            if (P()) {
                l10 = cVar.h();
            } else {
                l10 = cVar.l();
            }
            this.f22925h = l10;
        } else {
            this.f22925h = cVar.j(this.f22918a, i11, i10);
        }
        this.f22922e.d(this.f22925h.g());
    }

    public final void f0() {
        int itemCount = getItemCount();
        int i10 = this.f22930m;
        if (itemCount != i10 && this.f22924g != null) {
            if (this.f22923f.h(this, i10)) {
                X();
            }
            this.f22930m = itemCount;
        }
    }

    public final void g0() {
        if (this.f22921d && getChildCount() >= 1) {
            int i10 = 0;
            while (i10 < getChildCount() - 1) {
                int position = getPosition(getChildAt(i10));
                int i11 = i10 + 1;
                int position2 = getPosition(getChildAt(i11));
                if (position <= position2) {
                    i10 = i11;
                } else {
                    T();
                    throw new IllegalStateException("Detected invalid child order. Child at index [" + i10 + "] had adapter position [" + position + "] and child at index [" + i11 + "] had adapter position [" + position2 + "].");
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public final View getChildClosestToEnd() {
        int childCount;
        if (P()) {
            childCount = 0;
        } else {
            childCount = getChildCount() - 1;
        }
        return getChildAt(childCount);
    }

    public final View getChildClosestToStart() {
        int i10;
        if (P()) {
            i10 = getChildCount() - 1;
        } else {
            i10 = 0;
        }
        return getChildAt(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        float f10;
        super.getDecoratedBoundsWithMargins(view, rect);
        float centerY = rect.centerY();
        if (d()) {
            centerY = rect.centerX();
        }
        float D10 = D(centerY, O(this.f22925h.g(), centerY, true));
        float f11 = 0.0f;
        if (d()) {
            f10 = (rect.width() - D10) / 2.0f;
        } else {
            f10 = 0.0f;
        }
        if (!d()) {
            f11 = (rect.height() - D10) / 2.0f;
        }
        rect.set((int) (rect.left + f10), (int) (rect.top + f11), (int) (rect.right - f10), (int) (rect.bottom - f11));
    }

    public int getOrientation() {
        return this.f22928k.f33863a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public final void l(View view, int i10, b bVar) {
        float f10 = this.f22925h.f() / 2.0f;
        addView(view, i10);
        float f11 = bVar.f22936c;
        this.f22928k.m(view, (int) (f11 - f10), (int) (f11 + f10));
        d0(view, bVar.f22935b, bVar.f22937d);
    }

    public final float m(float f10, float f11) {
        if (P()) {
            return f10 - f11;
        }
        return f10 + f11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void measureChildWithMargins(View view, int i10, int i11) {
        float f10;
        float f11;
        if (view instanceof g) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            Rect rect = new Rect();
            calculateItemDecorationsForChild(view, rect);
            int i12 = i10 + rect.left + rect.right;
            int i13 = i11 + rect.top + rect.bottom;
            com.google.android.material.carousel.c cVar = this.f22924g;
            if (cVar != null && this.f22928k.f33863a == 0) {
                f10 = cVar.g().f();
            } else {
                f10 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
            }
            com.google.android.material.carousel.c cVar2 = this.f22924g;
            if (cVar2 != null && this.f22928k.f33863a == 1) {
                f11 = cVar2.g().f();
            } else {
                f11 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
            }
            view.measure(RecyclerView.o.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i12, (int) f10, canScrollHorizontally()), RecyclerView.o.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i13, (int) f11, canScrollVertically()));
            return;
        }
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    public final float n(float f10, float f11) {
        if (P()) {
            return f10 + f11;
        }
        return f10 - f11;
    }

    public final void o(RecyclerView.u uVar, int i10, int i11) {
        if (i10 >= 0 && i10 < getItemCount()) {
            b U10 = U(uVar, s(i10), i10);
            l(U10.f22934a, i11, U10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.f22923f.e(recyclerView.getContext());
        X();
        recyclerView.addOnLayoutChangeListener(this.f22929l);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.u uVar) {
        super.onDetachedFromWindow(recyclerView, uVar);
        recyclerView.removeOnLayoutChangeListener(this.f22929l);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View onFocusSearchFailed(View view, int i10, RecyclerView.u uVar, RecyclerView.y yVar) {
        int convertFocusDirectionToLayoutDirection;
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i10)) == Integer.MIN_VALUE) {
            return null;
        }
        if (convertFocusDirectionToLayoutDirection == -1) {
            if (getPosition(view) == 0) {
                return null;
            }
            o(uVar, getPosition(getChildAt(0)) - 1, 0);
            return getChildClosestToStart();
        }
        if (getPosition(view) == getItemCount() - 1) {
            return null;
        }
        o(uVar, getPosition(getChildAt(getChildCount() - 1)) + 1, -1);
        return getChildClosestToEnd();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(getPosition(getChildAt(0)));
            accessibilityEvent.setToIndex(getPosition(getChildAt(getChildCount() - 1)));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsAdded(RecyclerView recyclerView, int i10, int i11) {
        super.onItemsAdded(recyclerView, i10, i11);
        f0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsRemoved(RecyclerView recyclerView, int i10, int i11) {
        super.onItemsRemoved(recyclerView, i10, i11);
        f0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutChildren(RecyclerView.u uVar, RecyclerView.y yVar) {
        boolean z10;
        int i10;
        if (yVar.b() > 0 && y() > 0.0f) {
            boolean P10 = P();
            if (this.f22924g == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                W(uVar);
            }
            int w10 = w(this.f22924g);
            int t10 = t(yVar, this.f22924g);
            if (P10) {
                i10 = t10;
            } else {
                i10 = w10;
            }
            this.f22919b = i10;
            if (P10) {
                t10 = w10;
            }
            this.f22920c = t10;
            if (z10) {
                this.f22918a = w10;
                this.f22927j = this.f22924g.i(getItemCount(), this.f22919b, this.f22920c, P());
                int i11 = this.f22931n;
                if (i11 != -1) {
                    this.f22918a = M(i11, B(i11));
                }
            }
            int i12 = this.f22918a;
            this.f22918a = i12 + v(0, i12, this.f22919b, this.f22920c);
            this.f22926i = E.a.b(this.f22926i, 0, yVar.b());
            e0(this.f22924g);
            detachAndScrapAttachedViews(uVar);
            x(uVar, yVar);
            this.f22930m = getItemCount();
            return;
        }
        removeAndRecycleAllViews(uVar);
        this.f22926i = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutCompleted(RecyclerView.y yVar) {
        super.onLayoutCompleted(yVar);
        if (getChildCount() == 0) {
            this.f22926i = 0;
        } else {
            this.f22926i = getPosition(getChildAt(0));
        }
        g0();
    }

    public final void p(RecyclerView.u uVar, RecyclerView.y yVar, int i10) {
        float s10 = s(i10);
        while (i10 < yVar.b()) {
            b U10 = U(uVar, s10, i10);
            if (!Q(U10.f22936c, U10.f22937d)) {
                s10 = m(s10, this.f22925h.f());
                if (!R(U10.f22936c, U10.f22937d)) {
                    l(U10.f22934a, -1, U10);
                }
                i10++;
            } else {
                return;
            }
        }
    }

    public final void q(RecyclerView.u uVar, int i10) {
        float s10 = s(i10);
        while (i10 >= 0) {
            b U10 = U(uVar, s10, i10);
            if (!R(U10.f22936c, U10.f22937d)) {
                s10 = n(s10, this.f22925h.f());
                if (!Q(U10.f22936c, U10.f22937d)) {
                    l(U10.f22934a, 0, U10);
                }
                i10--;
            } else {
                return;
            }
        }
    }

    public final float r(View view, float f10, d dVar) {
        b.c cVar = dVar.f22940a;
        float f11 = cVar.f22961b;
        b.c cVar2 = dVar.f22941b;
        float b10 = C1001b.b(f11, cVar2.f22961b, cVar.f22960a, cVar2.f22960a, f10);
        if (dVar.f22941b == this.f22925h.c() || dVar.f22940a == this.f22925h.j()) {
            float e10 = this.f22928k.e((RecyclerView.LayoutParams) view.getLayoutParams()) / this.f22925h.f();
            b.c cVar3 = dVar.f22941b;
            return b10 + ((f10 - cVar3.f22960a) * ((1.0f - cVar3.f22962c) + e10));
        }
        return b10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z10, boolean z11) {
        int N10;
        if (this.f22924g == null || (N10 = N(getPosition(view), B(getPosition(view)))) == 0) {
            return false;
        }
        Z(recyclerView, N(getPosition(view), this.f22924g.j(this.f22918a + v(N10, this.f22918a, this.f22919b, this.f22920c), this.f22919b, this.f22920c)));
        return true;
    }

    public final float s(int i10) {
        return m(J() - this.f22918a, this.f22925h.f() * i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int scrollHorizontallyBy(int i10, RecyclerView.u uVar, RecyclerView.y yVar) {
        if (canScrollHorizontally()) {
            return scrollBy(i10, uVar, yVar);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void scrollToPosition(int i10) {
        this.f22931n = i10;
        if (this.f22924g == null) {
            return;
        }
        this.f22918a = M(i10, B(i10));
        this.f22926i = E.a.b(i10, 0, Math.max(0, getItemCount() - 1));
        e0(this.f22924g);
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int scrollVerticallyBy(int i10, RecyclerView.u uVar, RecyclerView.y yVar) {
        if (canScrollVertically()) {
            return scrollBy(i10, uVar, yVar);
        }
        return 0;
    }

    public void setOrientation(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i10);
        }
        assertNotInLayoutOrScroll(null);
        e eVar = this.f22928k;
        if (eVar == null || i10 != eVar.f33863a) {
            this.f22928k = e.c(this, i10);
            X();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.y yVar, int i10) {
        a aVar = new a(recyclerView.getContext());
        aVar.setTargetPosition(i10);
        startSmoothScroll(aVar);
    }

    public final int t(RecyclerView.y yVar, com.google.android.material.carousel.c cVar) {
        com.google.android.material.carousel.b h10;
        b.c h11;
        float f10;
        float f11;
        boolean P10 = P();
        if (P10) {
            h10 = cVar.l();
        } else {
            h10 = cVar.h();
        }
        if (P10) {
            h11 = h10.a();
        } else {
            h11 = h10.h();
        }
        float b10 = (yVar.b() - 1) * h10.f();
        if (P10) {
            f10 = -1.0f;
        } else {
            f10 = 1.0f;
        }
        float f12 = b10 * f10;
        if (P10) {
            f11 = -h11.f22966g;
        } else {
            f11 = h11.f22967h;
        }
        int J10 = (int) ((f12 - (h11.f22960a - J())) + (G() - h11.f22960a) + f11);
        if (P10) {
            return Math.min(0, J10);
        }
        return Math.max(0, J10);
    }

    public int u(int i10) {
        return (int) (this.f22918a - M(i10, B(i10)));
    }

    public final int w(com.google.android.material.carousel.c cVar) {
        com.google.android.material.carousel.b l10;
        b.c a10;
        boolean P10 = P();
        if (P10) {
            l10 = cVar.h();
        } else {
            l10 = cVar.l();
        }
        if (P10) {
            a10 = l10.h();
        } else {
            a10 = l10.a();
        }
        return (int) (J() - n(a10.f22960a, l10.f() / 2.0f));
    }

    public final void x(RecyclerView.u uVar, RecyclerView.y yVar) {
        Y(uVar);
        if (getChildCount() == 0) {
            q(uVar, this.f22926i - 1);
            p(uVar, yVar, this.f22926i);
        } else {
            int position = getPosition(getChildAt(0));
            int position2 = getPosition(getChildAt(getChildCount() - 1));
            q(uVar, position - 1);
            p(uVar, yVar, position2 + 1);
        }
        g0();
    }

    public final int y() {
        if (d()) {
            return a();
        }
        return b();
    }

    public final float z(View view) {
        int centerY;
        Rect rect = new Rect();
        super.getDecoratedBoundsWithMargins(view, rect);
        if (d()) {
            centerY = rect.centerX();
        } else {
            centerY = rect.centerY();
        }
        return centerY;
    }

    public CarouselLayoutManager(f fVar) {
        this(fVar, 0);
    }

    public CarouselLayoutManager(f fVar, int i10) {
        this.f22921d = false;
        this.f22922e = new c();
        this.f22926i = 0;
        this.f22929l = new View.OnLayoutChangeListener() { // from class: j4.c
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                CarouselLayoutManager.this.S(view, i11, i12, i13, i14, i15, i16, i17, i18);
            }
        };
        this.f22931n = -1;
        this.f22932o = 0;
        c0(fVar);
        setOrientation(i10);
    }

    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f22921d = false;
        this.f22922e = new c();
        this.f22926i = 0;
        this.f22929l = new View.OnLayoutChangeListener() { // from class: j4.c
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i112, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                CarouselLayoutManager.this.S(view, i112, i12, i13, i14, i15, i16, i17, i18);
            }
        };
        this.f22931n = -1;
        this.f22932o = 0;
        c0(new j());
        b0(context, attributeSet);
    }
}
