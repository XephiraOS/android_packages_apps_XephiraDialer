package com.android.contacts.framework.baseui.behavior;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import c4.g;
import c4.l;
import com.android.contacts.framework.baseui.behavior.BaseTitleBehavior;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.foundation.util.display.DisplayUtil;
import kotlin.Result;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: BaseTitleBehavior.kt */
/* loaded from: classes.dex */
public abstract class BaseTitleBehavior extends CoordinatorLayout.Behavior<AppBarLayout> {

    /* renamed from: T, reason: collision with root package name */
    public static final a f15674T = new a(null);

    /* renamed from: A, reason: collision with root package name */
    public int f15675A;

    /* renamed from: B, reason: collision with root package name */
    public int f15676B;

    /* renamed from: C, reason: collision with root package name */
    public int f15677C;

    /* renamed from: D, reason: collision with root package name */
    public int f15678D;

    /* renamed from: E, reason: collision with root package name */
    public int f15679E;

    /* renamed from: F, reason: collision with root package name */
    public float f15680F;

    /* renamed from: G, reason: collision with root package name */
    public int f15681G;

    /* renamed from: H, reason: collision with root package name */
    public int f15682H;

    /* renamed from: I, reason: collision with root package name */
    public final l f15683I;

    /* renamed from: J, reason: collision with root package name */
    public final g f15684J;

    /* renamed from: K, reason: collision with root package name */
    public AbsListView.OnScrollListener f15685K;

    /* renamed from: L, reason: collision with root package name */
    public RecyclerView.s f15686L;

    /* renamed from: M, reason: collision with root package name */
    public c f15687M;

    /* renamed from: N, reason: collision with root package name */
    public LinearLayout.LayoutParams f15688N;

    /* renamed from: O, reason: collision with root package name */
    public final int[] f15689O;

    /* renamed from: P, reason: collision with root package name */
    public boolean f15690P;

    /* renamed from: Q, reason: collision with root package name */
    public boolean f15691Q;

    /* renamed from: R, reason: collision with root package name */
    public b f15692R;

    /* renamed from: S, reason: collision with root package name */
    public float f15693S;

    /* renamed from: a, reason: collision with root package name */
    public Context f15694a;

    /* renamed from: b, reason: collision with root package name */
    public View f15695b;

    /* renamed from: c, reason: collision with root package name */
    public COUIToolbar f15696c;

    /* renamed from: d, reason: collision with root package name */
    public ViewGroup f15697d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f15698e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f15699f;

    /* renamed from: g, reason: collision with root package name */
    public AppBarLayout f15700g;

    /* renamed from: h, reason: collision with root package name */
    public LinearLayout f15701h;

    /* renamed from: i, reason: collision with root package name */
    public View f15702i;

    /* renamed from: j, reason: collision with root package name */
    public View f15703j;

    /* renamed from: k, reason: collision with root package name */
    public View f15704k;

    /* renamed from: l, reason: collision with root package name */
    public int f15705l;

    /* renamed from: m, reason: collision with root package name */
    public int f15706m;

    /* renamed from: n, reason: collision with root package name */
    public int f15707n;

    /* renamed from: o, reason: collision with root package name */
    public int f15708o;

    /* renamed from: p, reason: collision with root package name */
    public int f15709p;

    /* renamed from: q, reason: collision with root package name */
    public int f15710q;

    /* renamed from: r, reason: collision with root package name */
    public int f15711r;

    /* renamed from: x, reason: collision with root package name */
    public int f15712x;

    /* renamed from: y, reason: collision with root package name */
    public int f15713y;

    /* renamed from: z, reason: collision with root package name */
    public int f15714z;

    /* compiled from: BaseTitleBehavior.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: BaseTitleBehavior.kt */
    /* loaded from: classes.dex */
    public interface b {
        void A(ViewGroup viewGroup, int i10);

        void K0(ViewGroup viewGroup, int i10, int i11, int i12);
    }

    /* compiled from: BaseTitleBehavior.kt */
    /* loaded from: classes.dex */
    public final class c extends c4.f {
        public c() {
        }

        @Override // c4.f, c4.j
        public void onSpringUpdate(g spring) {
            Object b10;
            i.f(spring, "spring");
            BaseTitleBehavior baseTitleBehavior = BaseTitleBehavior.this;
            try {
                Result.a aVar = Result.f34166a;
                if (baseTitleBehavior.E() == ((int) baseTitleBehavior.B().e())) {
                    baseTitleBehavior.B().k();
                } else {
                    ViewGroup A10 = baseTitleBehavior.A();
                    if (A10 != null) {
                        A10.scrollBy(0, (int) (spring.c() - baseTitleBehavior.E()));
                    }
                }
                baseTitleBehavior.h0((int) baseTitleBehavior.B().c());
                b10 = Result.b(q.f35511a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.c("BaseTitleBehavior", "onSpringUpdate error: " + d10);
            }
        }
    }

    /* compiled from: BaseTitleBehavior.kt */
    /* loaded from: classes.dex */
    public static final class d implements AbsListView.OnScrollListener {
        public d() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
            b v10 = BaseTitleBehavior.this.v();
            if (v10 != null) {
                v10.K0(absListView, i10, i11, i12);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView listView, int i10) {
            i.f(listView, "listView");
            b v10 = BaseTitleBehavior.this.v();
            if (v10 != null) {
                v10.A(listView, i10);
            }
        }
    }

    /* compiled from: BaseTitleBehavior.kt */
    /* loaded from: classes.dex */
    public static final class e extends RecyclerView.s {
        public e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            i.f(recyclerView, "recyclerView");
            b v10 = BaseTitleBehavior.this.v();
            if (v10 != null) {
                v10.A(recyclerView, i10);
            }
            BaseTitleBehavior.this.W(recyclerView, i10);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            i.f(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i10, i11);
            b v10 = BaseTitleBehavior.this.v();
            if (v10 != null) {
                v10.K0(recyclerView, 1, 0, 0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseTitleBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i.f(context, "context");
        l h10 = l.h();
        this.f15683I = h10;
        g c10 = h10.c();
        i.e(c10, "mSpringSystem.createSpring()");
        this.f15684J = c10;
        this.f15689O = new int[2];
        Resources resources = context.getResources();
        this.f15694a = context;
        this.f15707n = resources.getDimensionPixelSize(N0.f.f1886l);
        this.f15706m = resources.getDimensionPixelSize(N0.f.f1896v);
        this.f15705l = resources.getDimensionPixelSize(N0.f.f1895u);
        this.f15708o = resources.getDimensionPixelSize(N0.f.f1897w);
        this.f15710q = resources.getDimensionPixelSize(N0.f.f1870F);
        this.f15676B = resources.getDimensionPixelSize(N0.f.f1871G);
        this.f15677C = resources.getDimensionPixelSize(N0.f.f1869E);
        this.f15711r = resources.getDimensionPixelSize(N0.f.f1898x);
        this.f15712x = resources.getDimensionPixelSize(N0.f.f1868D);
        this.f15713y = resources.getDimensionPixelSize(N0.f.f1872H);
        this.f15679E = COUIContextUtil.getAttrColor(context, N0.c.f1847h);
        this.f15681G = resources.getDimensionPixelSize(N0.f.f1894t);
        int g10 = DisplayUtil.g(context);
        this.f15682H = g10;
        this.f15709p = ((g10 + this.f15681G) + this.f15710q) - this.f15708o;
    }

    public static final void U(TextView it, LinearLayout.LayoutParams layoutParams) {
        i.f(it, "$it");
        it.setLayoutParams(layoutParams);
    }

    public static final void V(LinearLayout it, AppBarLayout.LayoutParams layoutParams) {
        i.f(it, "$it");
        it.setLayoutParams(layoutParams);
    }

    public static final void j0(BaseTitleBehavior this$0, View view, int i10, int i11, int i12, int i13) {
        i.f(this$0, "this$0");
        this$0.onListScroll();
    }

    public final ViewGroup A() {
        return this.f15697d;
    }

    public final g B() {
        return this.f15684J;
    }

    public final int C() {
        return this.f15682H;
    }

    public final int D() {
        return this.f15709p;
    }

    public final int E() {
        return this.f15678D;
    }

    public final TextView F() {
        return this.f15698e;
    }

    public final int G() {
        return this.f15711r;
    }

    public final int H() {
        return this.f15677C;
    }

    public final int I() {
        return this.f15710q;
    }

    public final int J() {
        return this.f15676B;
    }

    public final COUIToolbar K() {
        return this.f15696c;
    }

    public final int L() {
        return this.f15681G;
    }

    public abstract int M();

    public final float N() {
        return this.f15710q;
    }

    public void O(AppBarLayout appBarLayout, View target) {
        ViewGroup viewGroup;
        int i10;
        Object obj;
        View view;
        i.f(appBarLayout, "appBarLayout");
        i.f(target, "target");
        LinearLayout.LayoutParams layoutParams = null;
        if (target instanceof ViewGroup) {
            viewGroup = (ViewGroup) target;
        } else {
            viewGroup = null;
        }
        this.f15697d = viewGroup;
        if (this.f15696c == null) {
            this.f15700g = appBarLayout;
            this.f15696c = (COUIToolbar) appBarLayout.findViewById(N0.i.f1919A);
            this.f15698e = (TextView) appBarLayout.findViewById(N0.i.f1920B);
            this.f15699f = (TextView) appBarLayout.findViewById(N0.i.f1937o);
            TextView textView = this.f15698e;
            int i11 = 0;
            if (textView != null) {
                i10 = textView.getWidth();
            } else {
                i10 = 0;
            }
            this.f15714z = i10;
            TextView textView2 = this.f15699f;
            if (textView2 != null) {
                i11 = textView2.getWidth();
            }
            this.f15675A = i11;
            this.f15701h = (LinearLayout) appBarLayout.findViewById(N0.i.f1931i);
            this.f15704k = appBarLayout.findViewById(N0.i.f1928f);
            this.f15680F = N();
            View findViewById = appBarLayout.findViewById(N0.i.f1936n);
            this.f15702i = findViewById;
            if (findViewById != null) {
                obj = findViewById.getLayoutParams();
            } else {
                obj = null;
            }
            if (obj instanceof LinearLayout.LayoutParams) {
                layoutParams = (LinearLayout.LayoutParams) obj;
            }
            this.f15688N = layoutParams;
            if (A7.a.a() && (view = this.f15702i) != null) {
                view.setVisibility(8);
            }
            i0();
        }
    }

    public boolean P() {
        return g();
    }

    public final boolean Q() {
        return this.f15691Q;
    }

    public boolean R() {
        return false;
    }

    public final boolean S() {
        if (this.f15693S < 0.5f) {
            return true;
        }
        return false;
    }

    public final void T() {
        RecyclerView recyclerView;
        RecyclerView.Adapter adapter;
        LinearLayout.LayoutParams layoutParams;
        int i10;
        final AppBarLayout.LayoutParams layoutParams2;
        final LinearLayout linearLayout = this.f15701h;
        final LinearLayout.LayoutParams layoutParams3 = null;
        if (linearLayout != null) {
            ViewGroup.LayoutParams layoutParams4 = linearLayout.getLayoutParams();
            if (layoutParams4 instanceof AppBarLayout.LayoutParams) {
                layoutParams2 = (AppBarLayout.LayoutParams) layoutParams4;
            } else {
                layoutParams2 = null;
            }
            if (layoutParams2 != null) {
                ((LinearLayout.LayoutParams) layoutParams2).topMargin = 0;
            } else {
                layoutParams2 = null;
            }
            if (linearLayout.isInLayout()) {
                linearLayout.post(new Runnable() { // from class: P0.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseTitleBehavior.V(linearLayout, layoutParams2);
                    }
                });
            } else {
                linearLayout.setLayoutParams(layoutParams2);
            }
        }
        final TextView textView = this.f15698e;
        if (textView != null) {
            textView.getPaint().setTextSize(this.f15676B);
            ViewGroup.LayoutParams layoutParams5 = textView.getLayoutParams();
            if (layoutParams5 instanceof LinearLayout.LayoutParams) {
                layoutParams = (LinearLayout.LayoutParams) layoutParams5;
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                layoutParams.height = this.f15710q;
                if (this.f15714z <= 0) {
                    TextView textView2 = this.f15698e;
                    if (textView2 != null) {
                        i10 = textView2.getWidth();
                    } else {
                        i10 = 0;
                    }
                    this.f15714z = i10;
                }
                int i11 = this.f15714z;
                if (i11 > 0) {
                    layoutParams.width = i11;
                }
                layoutParams3 = layoutParams;
            }
            if (textView.isInLayout()) {
                textView.post(new Runnable() { // from class: P0.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseTitleBehavior.U(textView, layoutParams3);
                    }
                });
            } else {
                textView.setLayoutParams(layoutParams3);
            }
            textView.setAlpha(1.0f);
        }
        View view = this.f15702i;
        if (view != null) {
            view.setAlpha(0.0f);
        }
        View view2 = this.f15703j;
        if (view2 != null) {
            view2.setAlpha(0.0f);
        }
        ViewGroup viewGroup = this.f15697d;
        if (viewGroup != null) {
            if (viewGroup instanceof ListView) {
                ListView listView = (ListView) viewGroup;
                ListAdapter adapter2 = listView.getAdapter();
                if (adapter2 != null) {
                    i.e(adapter2, "adapter");
                    if (adapter2.getCount() > 0) {
                        listView.setSelection(0);
                    }
                }
            } else if ((viewGroup instanceof RecyclerView) && (adapter = (recyclerView = (RecyclerView) viewGroup).getAdapter()) != null && adapter.getItemCount() > 0) {
                recyclerView.scrollToPosition(0);
            }
        }
        f();
    }

    public final void W(ViewGroup viewGroup, int i10) {
        if ((viewGroup instanceof RecyclerView) && i10 == 0) {
            e(viewGroup);
        }
        if ((viewGroup instanceof ListView) && i10 == 0) {
            e(viewGroup);
        }
    }

    public final void X(boolean z10) {
        this.f15690P = z10;
    }

    public final void Y(float f10) {
        this.f15693S = f10;
    }

    public void Z(boolean z10) {
        X(z10);
    }

    public final void a0(View view) {
        this.f15703j = view;
    }

    public final void b0(boolean z10) {
        this.f15691Q = z10;
    }

    public final void c0(b listener) {
        i.f(listener, "listener");
        this.f15692R = listener;
    }

    public final void d0(View view) {
        this.f15703j = view;
    }

    public final void e(ViewGroup viewGroup) {
        int h10 = h(viewGroup);
        if (h10 >= 0) {
            float f10 = this.f15680F;
            if (h10 <= ((int) f10)) {
                this.f15678D = 0;
                if (h10 / f10 > 0.5f) {
                    g gVar = this.f15684J;
                    gVar.l(0.0d);
                    gVar.n(this.f15680F - h10);
                } else {
                    g gVar2 = this.f15684J;
                    gVar2.l(0.0d);
                    gVar2.n(-h10);
                }
            }
        }
    }

    public final void e0(View view) {
        this.f15695b = view;
    }

    public abstract void f();

    public final void f0(int i10) {
        this.f15714z = i10;
    }

    public final boolean g() {
        return this.f15690P;
    }

    public final void g0(int i10) {
        this.f15709p = i10;
    }

    public int h(ViewGroup viewGroup) {
        int i10;
        if (viewGroup != null && viewGroup.getChildCount() > 1) {
            if (viewGroup.getChildCount() > 0) {
                int childCount = viewGroup.getChildCount();
                i10 = 0;
                while (i10 < childCount) {
                    View childAt = viewGroup.getChildAt(i10);
                    if (childAt != null && childAt.getVisibility() == 0) {
                        break;
                    }
                    i10++;
                }
            }
            i10 = 0;
            viewGroup.getChildAt(i10).getLocationInWindow(this.f15689O);
            int i11 = this.f15709p - this.f15689O[1];
            if (i11 < 0) {
                return 0;
            }
            return i11;
        }
        return -1;
    }

    public final void h0(int i10) {
        this.f15678D = i10;
    }

    public final AppBarLayout i() {
        return this.f15700g;
    }

    public final void i0() {
        ViewGroup viewGroup = this.f15697d;
        if (viewGroup != null) {
            viewGroup.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: P0.a
                @Override // android.view.View.OnScrollChangeListener
                public final void onScrollChange(View view, int i10, int i11, int i12, int i13) {
                    BaseTitleBehavior.j0(BaseTitleBehavior.this, view, i10, i11, i12, i13);
                }
            });
        }
        ViewGroup viewGroup2 = this.f15697d;
        if (viewGroup2 != null) {
            if (viewGroup2 instanceof ListView) {
                if (this.f15685K == null) {
                    this.f15685K = new d();
                }
                AbsListView.OnScrollListener onScrollListener = this.f15685K;
                if (onScrollListener != null) {
                    ((ListView) viewGroup2).setOnScrollListener(onScrollListener);
                }
            } else if (viewGroup2 instanceof RecyclerView) {
                if (this.f15686L == null) {
                    this.f15686L = new e();
                }
                RecyclerView.s sVar = this.f15686L;
                if (sVar != null) {
                    ((RecyclerView) viewGroup2).addOnScrollListener(sVar);
                }
            }
        }
        if (R()) {
            if (this.f15687M == null) {
                this.f15687M = new c();
            }
            this.f15684J.a(this.f15687M);
        }
    }

    public final View j() {
        return this.f15703j;
    }

    public final View k() {
        return this.f15695b;
    }

    public final void k0() {
        this.f15709p = M();
        this.f15680F = N();
    }

    public final LinearLayout l() {
        return this.f15701h;
    }

    public final void l0() {
        onListScroll();
    }

    public final int m() {
        return this.f15705l;
    }

    public final int n() {
        return this.f15708o;
    }

    public final View o() {
        return this.f15702i;
    }

    public abstract void onListScroll();

    public final int p() {
        return this.f15707n;
    }

    public final LinearLayout.LayoutParams q() {
        return this.f15688N;
    }

    public final int r() {
        return this.f15706m;
    }

    public final int s() {
        return this.f15712x;
    }

    public final boolean t() {
        return this.f15690P;
    }

    public final boolean u() {
        return this.f15691Q;
    }

    public final b v() {
        return this.f15692R;
    }

    public final int[] w() {
        return this.f15689O;
    }

    public final int x() {
        return this.f15675A;
    }

    public final int y() {
        return this.f15714z;
    }

    public final float z() {
        return this.f15680F;
    }
}
