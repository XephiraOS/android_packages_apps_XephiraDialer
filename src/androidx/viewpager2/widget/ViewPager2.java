package androidx.viewpager2.widget;

import J.d;
import J.g;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.K;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.t;
import m0.C1302a;

/* loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {

    /* renamed from: z, reason: collision with root package name */
    public static boolean f11817z = true;

    /* renamed from: a, reason: collision with root package name */
    public final Rect f11818a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f11819b;

    /* renamed from: c, reason: collision with root package name */
    public androidx.viewpager2.widget.b f11820c;

    /* renamed from: d, reason: collision with root package name */
    public int f11821d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f11822e;

    /* renamed from: f, reason: collision with root package name */
    public RecyclerView.i f11823f;

    /* renamed from: g, reason: collision with root package name */
    public LinearLayoutManager f11824g;

    /* renamed from: h, reason: collision with root package name */
    public int f11825h;

    /* renamed from: i, reason: collision with root package name */
    public Parcelable f11826i;

    /* renamed from: j, reason: collision with root package name */
    public RecyclerView f11827j;

    /* renamed from: k, reason: collision with root package name */
    public t f11828k;

    /* renamed from: l, reason: collision with root package name */
    public androidx.viewpager2.widget.e f11829l;

    /* renamed from: m, reason: collision with root package name */
    public androidx.viewpager2.widget.b f11830m;

    /* renamed from: n, reason: collision with root package name */
    public androidx.viewpager2.widget.c f11831n;

    /* renamed from: o, reason: collision with root package name */
    public androidx.viewpager2.widget.d f11832o;

    /* renamed from: p, reason: collision with root package name */
    public RecyclerView.l f11833p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f11834q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f11835r;

    /* renamed from: x, reason: collision with root package name */
    public int f11836x;

    /* renamed from: y, reason: collision with root package name */
    public e f11837y;

    /* loaded from: classes.dex */
    public class a extends g {
        public a() {
            super(null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.g, androidx.recyclerview.widget.RecyclerView.i
        public void onChanged() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.f11822e = true;
            viewPager2.f11829l.notifyDataSetChangeHappened();
        }
    }

    /* loaded from: classes.dex */
    public class b extends i {
        public b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageScrollStateChanged(int i10) {
            if (i10 == 0) {
                ViewPager2.this.n();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageSelected(int i10) {
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.f11821d != i10) {
                viewPager2.f11821d = i10;
                viewPager2.f11837y.q();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends i {
        public c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageSelected(int i10) {
            ViewPager2.this.clearFocus();
            if (ViewPager2.this.hasFocus()) {
                ViewPager2.this.f11827j.requestFocus(2);
            }
        }
    }

    /* loaded from: classes.dex */
    public abstract class e {
        public e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int i10) {
            return false;
        }

        public boolean c(int i10, Bundle bundle) {
            return false;
        }

        public boolean d() {
            return false;
        }

        public String g() {
            throw new IllegalStateException("Not implemented.");
        }

        public boolean k(int i10) {
            throw new IllegalStateException("Not implemented.");
        }

        public boolean l(int i10, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        public CharSequence n() {
            throw new IllegalStateException("Not implemented.");
        }

        public /* synthetic */ e(ViewPager2 viewPager2, a aVar) {
            this();
        }

        public void e(RecyclerView.Adapter<?> adapter) {
        }

        public void f(RecyclerView.Adapter<?> adapter) {
        }

        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        public void j(J.d dVar) {
        }

        public void m() {
        }

        public void o(AccessibilityEvent accessibilityEvent) {
        }

        public void p() {
        }

        public void q() {
        }

        public void r() {
        }

        public void s() {
        }

        public void h(androidx.viewpager2.widget.b bVar, RecyclerView recyclerView) {
        }
    }

    /* loaded from: classes.dex */
    public class f extends e {
        public f() {
            super(ViewPager2.this, null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean b(int i10) {
            if ((i10 == 8192 || i10 == 4096) && !ViewPager2.this.e()) {
                return true;
            }
            return false;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean d() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void j(J.d dVar) {
            if (!ViewPager2.this.e()) {
                dVar.a0(d.a.f1403r);
                dVar.a0(d.a.f1402q);
                dVar.E0(false);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean k(int i10) {
            if (b(i10)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public CharSequence n() {
            if (d()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class g extends RecyclerView.i {
        public g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void onItemRangeChanged(int i10, int i11) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void onItemRangeInserted(int i10, int i11) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void onItemRangeMoved(int i10, int i11, int i12) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void onItemRangeRemoved(int i10, int i11) {
            onChanged();
        }

        public /* synthetic */ g(a aVar) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void onItemRangeChanged(int i10, int i11, Object obj) {
            onChanged();
        }
    }

    /* loaded from: classes.dex */
    public class h extends LinearLayoutManager {
        public h(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(RecyclerView.y yVar, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.calculateExtraLayoutSpace(yVar, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public void onInitializeAccessibilityNodeInfo(RecyclerView.u uVar, RecyclerView.y yVar, J.d dVar) {
            super.onInitializeAccessibilityNodeInfo(uVar, yVar, dVar);
            ViewPager2.this.f11837y.j(dVar);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public boolean performAccessibilityAction(RecyclerView.u uVar, RecyclerView.y yVar, int i10, Bundle bundle) {
            if (ViewPager2.this.f11837y.b(i10)) {
                return ViewPager2.this.f11837y.k(i10);
            }
            return super.performAccessibilityAction(uVar, yVar, i10, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z10, boolean z11) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class j extends e {

        /* renamed from: b, reason: collision with root package name */
        public final J.g f11848b;

        /* renamed from: c, reason: collision with root package name */
        public final J.g f11849c;

        /* renamed from: d, reason: collision with root package name */
        public RecyclerView.i f11850d;

        /* loaded from: classes.dex */
        public class a implements J.g {
            public a() {
            }

            @Override // J.g
            public boolean perform(View view, g.a aVar) {
                j.this.v(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        }

        /* loaded from: classes.dex */
        public class b implements J.g {
            public b() {
            }

            @Override // J.g
            public boolean perform(View view, g.a aVar) {
                j.this.v(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        }

        /* loaded from: classes.dex */
        public class c extends g {
            public c() {
                super(null);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.g, androidx.recyclerview.widget.RecyclerView.i
            public void onChanged() {
                j.this.w();
            }
        }

        public j() {
            super(ViewPager2.this, null);
            this.f11848b = new a();
            this.f11849c = new b();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean a() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean c(int i10, Bundle bundle) {
            if (i10 != 8192 && i10 != 4096) {
                return false;
            }
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void e(RecyclerView.Adapter<?> adapter) {
            w();
            if (adapter != null) {
                adapter.registerAdapterDataObserver(this.f11850d);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void f(RecyclerView.Adapter<?> adapter) {
            if (adapter != null) {
                adapter.unregisterAdapterDataObserver(this.f11850d);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public String g() {
            if (a()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void h(androidx.viewpager2.widget.b bVar, RecyclerView recyclerView) {
            K.t0(recyclerView, 2);
            this.f11850d = new c();
            if (K.t(ViewPager2.this) == 0) {
                K.t0(ViewPager2.this, 1);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
            t(accessibilityNodeInfo);
            u(accessibilityNodeInfo);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean l(int i10, Bundle bundle) {
            int currentItem;
            if (c(i10, bundle)) {
                if (i10 == 8192) {
                    currentItem = ViewPager2.this.getCurrentItem() - 1;
                } else {
                    currentItem = ViewPager2.this.getCurrentItem() + 1;
                }
                v(currentItem);
                return true;
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void m() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void o(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(g());
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void p() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void q() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void r() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void s() {
            w();
        }

        public final void t(AccessibilityNodeInfo accessibilityNodeInfo) {
            int i10;
            int i11;
            if (ViewPager2.this.getAdapter() != null) {
                if (ViewPager2.this.getOrientation() == 1) {
                    i10 = ViewPager2.this.getAdapter().getItemCount();
                    i11 = 0;
                } else {
                    i11 = ViewPager2.this.getAdapter().getItemCount();
                    i10 = 0;
                }
            } else {
                i10 = 0;
                i11 = 0;
            }
            J.d.O0(accessibilityNodeInfo).j0(d.e.b(i10, i11, false, 0));
        }

        public final void u(AccessibilityNodeInfo accessibilityNodeInfo) {
            int itemCount;
            RecyclerView.Adapter adapter = ViewPager2.this.getAdapter();
            if (adapter != null && (itemCount = adapter.getItemCount()) != 0 && ViewPager2.this.e()) {
                if (ViewPager2.this.f11821d > 0) {
                    accessibilityNodeInfo.addAction(8192);
                }
                if (ViewPager2.this.f11821d < itemCount - 1) {
                    accessibilityNodeInfo.addAction(4096);
                }
                accessibilityNodeInfo.setScrollable(true);
            }
        }

        public void v(int i10) {
            if (ViewPager2.this.e()) {
                ViewPager2.this.k(i10, true);
            }
        }

        public void w() {
            int itemCount;
            int i10;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i11 = R.id.accessibilityActionPageLeft;
            K.c0(viewPager2, R.id.accessibilityActionPageLeft);
            K.c0(viewPager2, R.id.accessibilityActionPageRight);
            K.c0(viewPager2, R.id.accessibilityActionPageUp);
            K.c0(viewPager2, R.id.accessibilityActionPageDown);
            if (ViewPager2.this.getAdapter() == null || (itemCount = ViewPager2.this.getAdapter().getItemCount()) == 0 || !ViewPager2.this.e()) {
                return;
            }
            if (ViewPager2.this.getOrientation() == 0) {
                boolean d10 = ViewPager2.this.d();
                if (d10) {
                    i10 = 16908360;
                } else {
                    i10 = 16908361;
                }
                if (d10) {
                    i11 = 16908361;
                }
                if (ViewPager2.this.f11821d < itemCount - 1) {
                    K.e0(viewPager2, new d.a(i10, null), null, this.f11848b);
                }
                if (ViewPager2.this.f11821d > 0) {
                    K.e0(viewPager2, new d.a(i11, null), null, this.f11849c);
                    return;
                }
                return;
            }
            if (ViewPager2.this.f11821d < itemCount - 1) {
                K.e0(viewPager2, new d.a(R.id.accessibilityActionPageDown, null), null, this.f11848b);
            }
            if (ViewPager2.this.f11821d > 0) {
                K.e0(viewPager2, new d.a(R.id.accessibilityActionPageUp, null), null, this.f11849c);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface k {
        void transformPage(View view, float f10);
    }

    /* loaded from: classes.dex */
    public class l extends t {
        public l() {
        }

        @Override // androidx.recyclerview.widget.t, androidx.recyclerview.widget.x
        public View findSnapView(RecyclerView.o oVar) {
            if (ViewPager2.this.c()) {
                return null;
            }
            return super.findSnapView(oVar);
        }
    }

    /* loaded from: classes.dex */
    public class m extends RecyclerView {
        public m(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public CharSequence getAccessibilityClassName() {
            if (ViewPager2.this.f11837y.d()) {
                return ViewPager2.this.f11837y.n();
            }
            return super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f11821d);
            accessibilityEvent.setToIndex(ViewPager2.this.f11821d);
            ViewPager2.this.f11837y.o(accessibilityEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (ViewPager2.this.e() && super.onInterceptTouchEvent(motionEvent)) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (ViewPager2.this.e() && super.onTouchEvent(motionEvent)) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class n implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final int f11857a;

        /* renamed from: b, reason: collision with root package name */
        public final RecyclerView f11858b;

        public n(int i10, RecyclerView recyclerView) {
            this.f11857a = i10;
            this.f11858b = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11858b.smoothScrollToPosition(this.f11857a);
        }
    }

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11818a = new Rect();
        this.f11819b = new Rect();
        this.f11820c = new androidx.viewpager2.widget.b(3);
        this.f11822e = false;
        this.f11823f = new a();
        this.f11825h = -1;
        this.f11833p = null;
        this.f11834q = false;
        this.f11835r = true;
        this.f11836x = -1;
        b(context, attributeSet);
    }

    public final RecyclerView.p a() {
        return new d();
    }

    public final void b(Context context, AttributeSet attributeSet) {
        e fVar;
        if (f11817z) {
            fVar = new j();
        } else {
            fVar = new f();
        }
        this.f11837y = fVar;
        m mVar = new m(context);
        this.f11827j = mVar;
        mVar.setId(K.i());
        this.f11827j.setDescendantFocusability(131072);
        h hVar = new h(context);
        this.f11824g = hVar;
        this.f11827j.setLayoutManager(hVar);
        this.f11827j.setScrollingTouchSlop(1);
        l(context, attributeSet);
        this.f11827j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f11827j.addOnChildAttachStateChangeListener(a());
        androidx.viewpager2.widget.e eVar = new androidx.viewpager2.widget.e(this);
        this.f11829l = eVar;
        this.f11831n = new androidx.viewpager2.widget.c(this, eVar, this.f11827j);
        l lVar = new l();
        this.f11828k = lVar;
        lVar.attachToRecyclerView(this.f11827j);
        this.f11827j.addOnScrollListener(this.f11829l);
        androidx.viewpager2.widget.b bVar = new androidx.viewpager2.widget.b(3);
        this.f11830m = bVar;
        this.f11829l.setOnPageChangeCallback(bVar);
        b bVar2 = new b();
        c cVar = new c();
        this.f11830m.addOnPageChangeCallback(bVar2);
        this.f11830m.addOnPageChangeCallback(cVar);
        this.f11837y.h(this.f11830m, this.f11827j);
        this.f11830m.addOnPageChangeCallback(this.f11820c);
        androidx.viewpager2.widget.d dVar = new androidx.viewpager2.widget.d(this.f11824g);
        this.f11832o = dVar;
        this.f11830m.addOnPageChangeCallback(dVar);
        RecyclerView recyclerView = this.f11827j;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    public boolean c() {
        return this.f11831n.a();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i10) {
        return this.f11827j.canScrollHorizontally(i10);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i10) {
        return this.f11827j.canScrollVertically(i10);
    }

    public boolean d() {
        if (this.f11824g.getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i10 = ((SavedState) parcelable).f11838a;
            sparseArray.put(this.f11827j.getId(), sparseArray.get(i10));
            sparseArray.remove(i10);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        i();
    }

    public boolean e() {
        return this.f11835r;
    }

    public final void f(RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f11823f);
        }
    }

    public void g(i iVar) {
        this.f11820c.addOnPageChangeCallback(iVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (this.f11837y.a()) {
            return this.f11837y.g();
        }
        return super.getAccessibilityClassName();
    }

    public RecyclerView.Adapter getAdapter() {
        return this.f11827j.getAdapter();
    }

    public int getCurrentItem() {
        return this.f11821d;
    }

    public int getItemDecorationCount() {
        return this.f11827j.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.f11836x;
    }

    public int getOrientation() {
        return this.f11824g.getOrientation();
    }

    public int getPageSize() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.f11827j;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.f11829l.getScrollState();
    }

    public void h() {
        if (this.f11832o.getPageTransformer() == null) {
            return;
        }
        double relativeScrollPosition = this.f11829l.getRelativeScrollPosition();
        int i10 = (int) relativeScrollPosition;
        float f10 = (float) (relativeScrollPosition - i10);
        this.f11832o.onPageScrolled(i10, f10, Math.round(getPageSize() * f10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i() {
        RecyclerView.Adapter adapter;
        if (this.f11825h == -1 || (adapter = getAdapter()) == 0) {
            return;
        }
        Parcelable parcelable = this.f11826i;
        if (parcelable != null) {
            if (adapter instanceof androidx.viewpager2.adapter.a) {
                ((androidx.viewpager2.adapter.a) adapter).restoreState(parcelable);
            }
            this.f11826i = null;
        }
        int max = Math.max(0, Math.min(this.f11825h, adapter.getItemCount() - 1));
        this.f11821d = max;
        this.f11825h = -1;
        this.f11827j.scrollToPosition(max);
        this.f11837y.m();
    }

    public void j(int i10, boolean z10) {
        if (!c()) {
            k(i10, z10);
            return;
        }
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    public void k(int i10, boolean z10) {
        int i11;
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            if (this.f11825h != -1) {
                this.f11825h = Math.max(i10, 0);
                return;
            }
            return;
        }
        if (adapter.getItemCount() <= 0) {
            return;
        }
        int min = Math.min(Math.max(i10, 0), adapter.getItemCount() - 1);
        if (min == this.f11821d && this.f11829l.isIdle()) {
            return;
        }
        int i12 = this.f11821d;
        if (min == i12 && z10) {
            return;
        }
        double d10 = i12;
        this.f11821d = min;
        this.f11837y.q();
        if (!this.f11829l.isIdle()) {
            d10 = this.f11829l.getRelativeScrollPosition();
        }
        this.f11829l.notifyProgrammaticScroll(min, z10);
        if (!z10) {
            this.f11827j.scrollToPosition(min);
            return;
        }
        double d11 = min;
        if (Math.abs(d11 - d10) > 3.0d) {
            RecyclerView recyclerView = this.f11827j;
            if (d11 > d10) {
                i11 = min - 3;
            } else {
                i11 = min + 3;
            }
            recyclerView.scrollToPosition(i11);
            RecyclerView recyclerView2 = this.f11827j;
            recyclerView2.post(new n(min, recyclerView2));
            return;
        }
        this.f11827j.smoothScrollToPosition(min);
    }

    public final void l(Context context, AttributeSet attributeSet) {
        int[] iArr = C1302a.f34798g;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        try {
            setOrientation(obtainStyledAttributes.getInt(C1302a.f34799h, 0));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final void m(RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.f11823f);
        }
    }

    public void n() {
        t tVar = this.f11828k;
        if (tVar != null) {
            View findSnapView = tVar.findSnapView(this.f11824g);
            if (findSnapView == null) {
                return;
            }
            int position = this.f11824g.getPosition(findSnapView);
            if (position != this.f11821d && getScrollState() == 0) {
                this.f11830m.onPageSelected(position);
            }
            this.f11822e = false;
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.f11837y.i(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int measuredWidth = this.f11827j.getMeasuredWidth();
        int measuredHeight = this.f11827j.getMeasuredHeight();
        this.f11818a.left = getPaddingLeft();
        this.f11818a.right = (i12 - i10) - getPaddingRight();
        this.f11818a.top = getPaddingTop();
        this.f11818a.bottom = (i13 - i11) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.f11818a, this.f11819b);
        RecyclerView recyclerView = this.f11827j;
        Rect rect = this.f11819b;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.f11822e) {
            n();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        measureChild(this.f11827j, i10, i11);
        int measuredWidth = this.f11827j.getMeasuredWidth();
        int measuredHeight = this.f11827j.getMeasuredHeight();
        int measuredState = this.f11827j.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i10, measuredState), View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i11, measuredState << 16));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f11825h = savedState.f11839b;
        this.f11826i = savedState.f11840c;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f11838a = this.f11827j.getId();
        int i10 = this.f11825h;
        if (i10 == -1) {
            i10 = this.f11821d;
        }
        savedState.f11839b = i10;
        Parcelable parcelable = this.f11826i;
        if (parcelable != null) {
            savedState.f11840c = parcelable;
        } else {
            Object adapter = this.f11827j.getAdapter();
            if (adapter instanceof androidx.viewpager2.adapter.a) {
                savedState.f11840c = ((androidx.viewpager2.adapter.a) adapter).saveState();
            }
        }
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i10, Bundle bundle) {
        if (this.f11837y.c(i10, bundle)) {
            return this.f11837y.l(i10, bundle);
        }
        return super.performAccessibilityAction(i10, bundle);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.f11827j.getAdapter();
        this.f11837y.f(adapter2);
        m(adapter2);
        this.f11827j.setAdapter(adapter);
        this.f11821d = 0;
        i();
        this.f11837y.e(adapter);
        f(adapter);
    }

    public void setCurrentItem(int i10) {
        j(i10, true);
    }

    @Override // android.view.View
    public void setLayoutDirection(int i10) {
        super.setLayoutDirection(i10);
        this.f11837y.p();
    }

    public void setOffscreenPageLimit(int i10) {
        if (i10 < 1 && i10 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.f11836x = i10;
        this.f11827j.requestLayout();
    }

    public void setOrientation(int i10) {
        this.f11824g.setOrientation(i10);
        this.f11837y.r();
    }

    public void setPageTransformer(k kVar) {
        if (kVar != null) {
            if (!this.f11834q) {
                this.f11833p = this.f11827j.getItemAnimator();
                this.f11834q = true;
            }
            this.f11827j.setItemAnimator(null);
        } else if (this.f11834q) {
            this.f11827j.setItemAnimator(this.f11833p);
            this.f11833p = null;
            this.f11834q = false;
        }
        if (kVar == this.f11832o.getPageTransformer()) {
            return;
        }
        this.f11832o.setPageTransformer(kVar);
        h();
    }

    public void setUserInputEnabled(boolean z10) {
        this.f11835r = z10;
        this.f11837y.s();
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public int f11838a;

        /* renamed from: b, reason: collision with root package name */
        public int f11839b;

        /* renamed from: c, reason: collision with root package name */
        public Parcelable f11840c;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            b(parcel, classLoader);
        }

        public final void b(Parcel parcel, ClassLoader classLoader) {
            this.f11838a = parcel.readInt();
            this.f11839b = parcel.readInt();
            this.f11840c = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f11838a);
            parcel.writeInt(this.f11839b);
            parcel.writeParcelable(this.f11840c, i10);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* loaded from: classes.dex */
    public class d implements RecyclerView.p {
        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.p
        public void onChildViewAttachedToWindow(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            if (((ViewGroup.MarginLayoutParams) layoutParams).width == -1 && ((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
            } else {
                throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.p
        public void onChildViewDetachedFromWindow(View view) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class i {
        public void onPageScrollStateChanged(int i10) {
        }

        public void onPageSelected(int i10) {
        }

        public void onPageScrolled(int i10, float f10, int i11) {
        }
    }
}
