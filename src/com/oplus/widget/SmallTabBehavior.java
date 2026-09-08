package com.oplus.widget;

import C6.f;
import S8.m;
import android.app.Activity;
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
import androidx.viewpager.widget.ViewPager;
import com.coui.appcompat.tablayout.COUITabLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.blacklistapp.activities.BlockedCallLogAndSmsListActivity;
import com.oplus.blacklistapp.n;
import com.oplus.blacklistapp.p;
import com.oplus.utils.C0849j;

/* loaded from: classes4.dex */
public class SmallTabBehavior extends CoordinatorLayout.Behavior<AppBarLayout> implements AbsListView.OnScrollListener {

    /* renamed from: A, reason: collision with root package name */
    public int f29319A;

    /* renamed from: B, reason: collision with root package name */
    public int f29320B;

    /* renamed from: C, reason: collision with root package name */
    public Context f29321C;

    /* renamed from: D, reason: collision with root package name */
    public int f29322D;

    /* renamed from: E, reason: collision with root package name */
    public int f29323E;

    /* renamed from: F, reason: collision with root package name */
    public int f29324F;

    /* renamed from: G, reason: collision with root package name */
    public int f29325G;

    /* renamed from: H, reason: collision with root package name */
    public Activity f29326H;

    /* renamed from: a, reason: collision with root package name */
    public int f29327a;

    /* renamed from: b, reason: collision with root package name */
    public ViewPager f29328b;

    /* renamed from: c, reason: collision with root package name */
    public View f29329c;

    /* renamed from: d, reason: collision with root package name */
    public int f29330d;

    /* renamed from: e, reason: collision with root package name */
    public COUITabLayout f29331e;

    /* renamed from: f, reason: collision with root package name */
    public View f29332f;

    /* renamed from: g, reason: collision with root package name */
    public View f29333g;

    /* renamed from: h, reason: collision with root package name */
    public int f29334h;

    /* renamed from: i, reason: collision with root package name */
    public int f29335i;

    /* renamed from: j, reason: collision with root package name */
    public int f29336j;

    /* renamed from: k, reason: collision with root package name */
    public int f29337k;

    /* renamed from: l, reason: collision with root package name */
    public int f29338l;

    /* renamed from: m, reason: collision with root package name */
    public int f29339m;

    /* renamed from: n, reason: collision with root package name */
    public int f29340n;

    /* renamed from: o, reason: collision with root package name */
    public ViewGroup.LayoutParams f29341o;

    /* renamed from: p, reason: collision with root package name */
    public float f29342p;

    /* renamed from: q, reason: collision with root package name */
    public float f29343q;

    /* renamed from: r, reason: collision with root package name */
    public Resources f29344r;

    /* renamed from: x, reason: collision with root package name */
    public int[] f29345x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f29346y;

    /* renamed from: z, reason: collision with root package name */
    public m f29347z;

    /* loaded from: classes4.dex */
    public class b implements View.OnScrollChangeListener {
        public b() {
        }

        @Override // android.view.View.OnScrollChangeListener
        public void onScrollChange(View view, int i10, int i11, int i12, int i13) {
            if (SmallTabBehavior.this.f29346y) {
                SmallTabBehavior.this.onListScroll();
            }
        }
    }

    public SmallTabBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f29345x = new int[2];
        this.f29346y = true;
        this.f29322D = 0;
        init(context);
        this.f29347z = new m(context, this);
    }

    private void init(Context context) {
        this.f29321C = context;
        Resources resources = context.getResources();
        this.f29344r = resources;
        this.f29338l = resources.getDimensionPixelOffset(f.f391e);
        this.f29337k = this.f29344r.getDimensionPixelOffset(f.f389c);
        this.f29340n = context.getResources().getDimensionPixelOffset(f.f388b) * 2;
        this.f29323E = this.f29344r.getDimensionPixelOffset(f.f392f);
        this.f29324F = this.f29344r.getDimensionPixelOffset(n.f27285j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onListScroll() {
        View view;
        int i10;
        if (this.f29333g != null && (view = this.f29329c) != null) {
            if ((view instanceof ListView) && ((ListView) view).getAdapter() != null) {
                this.f29319A = ((ListView) this.f29329c).getHeaderViewsCount();
                this.f29320B = ((ListView) this.f29329c).getFooterViewsCount();
                if (((ListAdapter) ((AbsListView) this.f29329c).getAdapter()).getCount() <= this.f29319A + this.f29320B) {
                    return;
                }
            }
            this.f29333g.getLocationOnScreen(this.f29345x);
            this.f29332f = null;
            View view2 = this.f29329c;
            int i11 = 0;
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                if (viewGroup.getChildCount() > 0) {
                    int i12 = 0;
                    while (true) {
                        if (i12 >= viewGroup.getChildCount()) {
                            break;
                        }
                        if (viewGroup.getChildAt(i12).getVisibility() == 0) {
                            this.f29332f = viewGroup.getChildAt(i12);
                            break;
                        }
                        i12++;
                    }
                }
            }
            if (this.f29332f == null) {
                this.f29332f = this.f29329c;
            }
            int[] iArr = new int[2];
            this.f29332f.getLocationOnScreen(iArr);
            int i13 = iArr[1];
            Activity activity = this.f29326H;
            if (activity != null && (activity instanceof BlockedCallLogAndSmsListActivity)) {
                ((BlockedCallLogAndSmsListActivity) activity).l2(i13);
            }
            if (i13 < this.f29334h) {
                i10 = this.f29338l;
            } else {
                int i14 = this.f29327a;
                if (i13 > i14) {
                    i10 = 0;
                } else {
                    i10 = i14 - i13;
                }
            }
            this.f29330d = i10;
            if (this.f29343q <= 1.0f) {
                float abs = Math.abs(i10) / this.f29338l;
                this.f29343q = abs;
                this.f29333g.setAlpha(abs);
            }
            if (i13 < this.f29336j) {
                i11 = this.f29337k;
            } else {
                int i15 = this.f29335i;
                if (i13 <= i15) {
                    i11 = i15 - i13;
                }
            }
            this.f29330d = i11;
            if (i13 > this.f29335i) {
                this.f29342p = 0.0f;
                this.f29341o.width = this.f29339m;
                int width = this.f29333g.getWidth();
                ViewGroup.LayoutParams layoutParams = this.f29341o;
                if (width != layoutParams.width) {
                    this.f29333g.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            float abs2 = Math.abs(i11) / this.f29337k;
            this.f29342p = abs2;
            this.f29341o.width = (int) (this.f29339m + (this.f29340n * abs2));
            int width2 = this.f29333g.getWidth();
            ViewGroup.LayoutParams layoutParams2 = this.f29341o;
            if (width2 != layoutParams2.width) {
                this.f29333g.setLayoutParams(layoutParams2);
            }
        }
    }

    public int h() {
        return this.f29325G - this.f29324F;
    }

    public void i() {
        this.f29339m = C0849j.i(this.f29321C) - this.f29340n;
        onListScroll();
    }

    public void j(Activity activity) {
        this.f29326H = activity;
        this.f29347z.u(activity);
    }

    public void k(int i10) {
        this.f29347z.v(i10);
    }

    public void l(boolean z10) {
        this.f29347z.w(z10);
    }

    public void m(boolean z10) {
        this.f29346y = z10;
        this.f29347z.x(z10);
        ViewPager viewPager = this.f29328b;
        if (viewPager != null && viewPager.getChildAt(viewPager.getCurrentItem()) != null) {
            ViewPager viewPager2 = this.f29328b;
            this.f29333g = viewPager2.getChildAt(viewPager2.getCurrentItem()).findViewById(p.f27386f);
        }
        if (this.f29346y) {
            View view = this.f29333g;
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        View view2 = this.f29333g;
        if (view2 != null) {
            view2.setVisibility(4);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        if (!this.f29346y) {
            return;
        }
        onListScroll();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i10, int i11) {
        if (!this.f29346y) {
            this.f29347z.t(coordinatorLayout, appBarLayout, view, view2, i10, i11);
            this.f29331e = null;
            return false;
        }
        if (this.f29331e == null) {
            for (int i12 = 0; i12 < appBarLayout.getChildCount(); i12++) {
                if (appBarLayout.getChildAt(i12) instanceof COUITabLayout) {
                    this.f29331e = (COUITabLayout) appBarLayout.getChildAt(i12);
                }
            }
            ViewPager viewPager = (ViewPager) coordinatorLayout.findViewById(p.f27369W0);
            this.f29328b = viewPager;
            viewPager.setOffscreenPageLimit(2);
            this.f29328b.addOnPageChangeListener(new a(appBarLayout));
            appBarLayout.getLocationOnScreen(new int[2]);
            int measuredHeight = appBarLayout.getMeasuredHeight() + C0849j.l(this.f29321C);
            this.f29327a = measuredHeight;
            int i13 = measuredHeight - this.f29338l;
            this.f29334h = i13;
            this.f29335i = i13;
            this.f29336j = i13 - this.f29337k;
            Activity activity = this.f29326H;
            if (activity != null && (activity instanceof BlockedCallLogAndSmsListActivity)) {
                TextView textView = (TextView) appBarLayout.findViewById(p.f27365U0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
                if (this.f29322D == 0) {
                    this.f29322D = appBarLayout.getMeasuredHeight() + C0849j.l(this.f29321C);
                }
                if (layoutParams.topMargin == (-textView.getHeight())) {
                    this.f29325G = this.f29322D + textView.getHeight() + this.f29323E;
                } else {
                    this.f29325G = this.f29322D + this.f29323E;
                }
            }
        }
        ViewPager viewPager2 = this.f29328b;
        View childAt = viewPager2.getChildAt(viewPager2.getCurrentItem());
        int i14 = p.f27386f;
        View findViewById = childAt.findViewById(i14);
        this.f29333g = findViewById;
        if (findViewById == null) {
            this.f29333g = appBarLayout.findViewById(i14);
        }
        this.f29341o = this.f29333g.getLayoutParams();
        this.f29329c = view2;
        this.f29339m = coordinatorLayout.getContext().getResources().getDisplayMetrics().widthPixels - this.f29340n;
        COUITabLayout cOUITabLayout = this.f29331e;
        if (cOUITabLayout != null && !cOUITabLayout.isEnabled()) {
            return false;
        }
        view2.setOnScrollChangeListener(new b());
        return false;
    }

    /* loaded from: classes4.dex */
    public class a implements ViewPager.i {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppBarLayout f29348a;

        public a(AppBarLayout appBarLayout) {
            this.f29348a = appBarLayout;
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageSelected(int i10) {
            SmallTabBehavior smallTabBehavior = SmallTabBehavior.this;
            View childAt = smallTabBehavior.f29328b.getChildAt(SmallTabBehavior.this.f29328b.getCurrentItem());
            int i11 = p.f27386f;
            smallTabBehavior.f29333g = childAt.findViewById(i11);
            SmallTabBehavior smallTabBehavior2 = SmallTabBehavior.this;
            smallTabBehavior2.f29329c = smallTabBehavior2.f29328b.getChildAt(SmallTabBehavior.this.f29328b.getCurrentItem()).findViewById(p.f27362T);
            if (SmallTabBehavior.this.f29333g == null) {
                SmallTabBehavior.this.f29333g = this.f29348a.findViewById(i11);
            }
            SmallTabBehavior smallTabBehavior3 = SmallTabBehavior.this;
            smallTabBehavior3.f29341o = smallTabBehavior3.f29333g.getLayoutParams();
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageScrollStateChanged(int i10) {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageScrolled(int i10, float f10, int i11) {
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i10) {
    }
}
