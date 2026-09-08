package S8;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager.widget.ViewPager;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.blacklistapp.activities.BlockedCallLogAndSmsListActivity;
import com.oplus.utils.C0849j;
import com.oplus.utils.C0853n;
import com.oplus.widget.SmallTabBehavior;

/* compiled from: HeadScaleListViewBehavior.java */
/* loaded from: classes4.dex */
public class m implements AbsListView.OnScrollListener {

    /* renamed from: A, reason: collision with root package name */
    public int f3553A;

    /* renamed from: B, reason: collision with root package name */
    public float f3554B;

    /* renamed from: C, reason: collision with root package name */
    public float f3555C;

    /* renamed from: D, reason: collision with root package name */
    public float f3556D;

    /* renamed from: E, reason: collision with root package name */
    public float f3557E;

    /* renamed from: F, reason: collision with root package name */
    public float f3558F;

    /* renamed from: G, reason: collision with root package name */
    public ViewGroup.LayoutParams f3559G;

    /* renamed from: H, reason: collision with root package name */
    public int f3560H;

    /* renamed from: J, reason: collision with root package name */
    public int f3562J;

    /* renamed from: L, reason: collision with root package name */
    public int f3564L;

    /* renamed from: M, reason: collision with root package name */
    public int f3565M;

    /* renamed from: N, reason: collision with root package name */
    public int f3566N;

    /* renamed from: O, reason: collision with root package name */
    public int f3567O;

    /* renamed from: P, reason: collision with root package name */
    public c4.l f3568P;

    /* renamed from: Q, reason: collision with root package name */
    public c4.g f3569Q;

    /* renamed from: R, reason: collision with root package name */
    public d f3570R;

    /* renamed from: S, reason: collision with root package name */
    public int f3571S;

    /* renamed from: T, reason: collision with root package name */
    public int f3572T;

    /* renamed from: U, reason: collision with root package name */
    public int[] f3573U;

    /* renamed from: V, reason: collision with root package name */
    public int f3574V;

    /* renamed from: W, reason: collision with root package name */
    public int f3575W;

    /* renamed from: X, reason: collision with root package name */
    public boolean f3576X;

    /* renamed from: Y, reason: collision with root package name */
    public boolean f3577Y;

    /* renamed from: Z, reason: collision with root package name */
    public int f3578Z;

    /* renamed from: a, reason: collision with root package name */
    public COUIToolbar f3579a;

    /* renamed from: a0, reason: collision with root package name */
    public SmallTabBehavior f3580a0;

    /* renamed from: b, reason: collision with root package name */
    public ViewPager f3581b;

    /* renamed from: b0, reason: collision with root package name */
    public Activity f3582b0;

    /* renamed from: c, reason: collision with root package name */
    public int f3583c;

    /* renamed from: c0, reason: collision with root package name */
    public int f3584c0;

    /* renamed from: e, reason: collision with root package name */
    public AppBarLayout f3586e;

    /* renamed from: f, reason: collision with root package name */
    public View f3587f;

    /* renamed from: g, reason: collision with root package name */
    public View f3588g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f3589h;

    /* renamed from: i, reason: collision with root package name */
    public View f3590i;

    /* renamed from: j, reason: collision with root package name */
    public Context f3591j;

    /* renamed from: k, reason: collision with root package name */
    public int f3592k;

    /* renamed from: l, reason: collision with root package name */
    public LinearLayout.LayoutParams f3593l;

    /* renamed from: m, reason: collision with root package name */
    public int f3594m;

    /* renamed from: n, reason: collision with root package name */
    public int f3595n;

    /* renamed from: o, reason: collision with root package name */
    public int f3596o;

    /* renamed from: p, reason: collision with root package name */
    public Resources f3597p;

    /* renamed from: q, reason: collision with root package name */
    public int f3598q;

    /* renamed from: r, reason: collision with root package name */
    public int f3599r;

    /* renamed from: x, reason: collision with root package name */
    public int f3600x;

    /* renamed from: y, reason: collision with root package name */
    public int f3601y;

    /* renamed from: z, reason: collision with root package name */
    public int f3602z;

    /* renamed from: d, reason: collision with root package name */
    public int f3585d = 0;

    /* renamed from: I, reason: collision with root package name */
    public int[] f3561I = new int[2];

    /* renamed from: K, reason: collision with root package name */
    public int f3563K = 0;

    /* compiled from: HeadScaleListViewBehavior.java */
    /* loaded from: classes4.dex */
    public class a implements View.OnScrollChangeListener {
        public a() {
        }

        @Override // android.view.View.OnScrollChangeListener
        public void onScrollChange(View view, int i10, int i11, int i12, int i13) {
            m.this.s();
        }
    }

    /* compiled from: HeadScaleListViewBehavior.java */
    /* loaded from: classes4.dex */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (m.this.f3576X) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action == 0 || action == 1) {
                View childAt = ((ViewGroup) m.this.f3587f).getChildAt(1);
                if (childAt != null) {
                    childAt.getLocationOnScreen(m.this.f3573U);
                }
                if (m.this.f3573U[1] < m.this.f3560H && m.this.f3572T == 2 && m.this.f3571S == 0) {
                    if (m.this.f3590i != null) {
                        m.this.f3590i.getLocationOnScreen(m.this.f3561I);
                    }
                    if (m.this.f3561I[1] < m.this.f3566N + m.this.f3584c0 && m.this.f3561I[1] >= m.this.f3567O) {
                        m.this.f3574V = 0;
                        m.this.f3569Q.l(0.0d);
                        m.this.f3569Q.n(m.this.f3573U[1] - m.this.f3560H);
                    } else if (m.this.f3573U[1] > m.this.f3563K && m.this.f3561I[1] < m.this.f3567O && m.this.f3561I[1] >= m.this.f3566N) {
                        m.this.f3574V = 0;
                        m.this.f3569Q.l(0.0d);
                        m.this.f3569Q.n(m.this.f3573U[1] - m.this.f3563K);
                    }
                }
            }
            return false;
        }
    }

    /* compiled from: HeadScaleListViewBehavior.java */
    /* loaded from: classes4.dex */
    public class d extends c4.f {
        @Override // c4.f, c4.j
        public void onSpringUpdate(c4.g gVar) {
            if (m.this.f3576X) {
                return;
            }
            ((AbsListView) m.this.f3587f).scrollListBy((int) (gVar.c() - m.this.f3574V));
            m mVar = m.this;
            mVar.f3574V = (int) mVar.f3569Q.c();
        }

        public d() {
        }
    }

    public m(Context context, SmallTabBehavior smallTabBehavior) {
        c4.l h10 = c4.l.h();
        this.f3568P = h10;
        this.f3569Q = h10.c();
        this.f3571S = -1;
        this.f3572T = -1;
        this.f3573U = new int[2];
        this.f3574V = 0;
        this.f3575W = 0;
        this.f3576X = false;
        this.f3577Y = false;
        r(context);
        d dVar = new d();
        this.f3570R = dVar;
        this.f3569Q.a(dVar);
        this.f3580a0 = smallTabBehavior;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i10) {
        if (this.f3576X) {
            return;
        }
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    this.f3572T = 2;
                    return;
                }
                return;
            } else {
                this.f3571S = 1;
                this.f3572T = -1;
                return;
            }
        }
        this.f3571S = 0;
        this.f3590i.getLocationOnScreen(this.f3561I);
        View view = this.f3587f;
        if (view != null && ((ViewGroup) view).getChildAt(1) != null) {
            ((ViewGroup) this.f3587f).getChildAt(1).getLocationOnScreen(this.f3573U);
            int i11 = this.f3561I[1];
            int i12 = this.f3566N;
            if (i11 < this.f3584c0 + i12 && i11 >= this.f3567O) {
                this.f3574V = 0;
                this.f3569Q.l(0.0d);
                this.f3569Q.n(this.f3573U[1] - this.f3560H);
            } else if (this.f3573U[1] > this.f3563K && i11 < this.f3567O && i11 >= i12) {
                this.f3574V = 0;
                this.f3569Q.l(0.0d);
                this.f3569Q.n(this.f3573U[1] - this.f3563K);
            }
        }
    }

    public final void r(Context context) {
        this.f3591j = context;
        Resources resources = context.getResources();
        this.f3597p = resources;
        this.f3601y = resources.getDimensionPixelOffset(com.oplus.blacklistapp.n.f27285j);
        this.f3600x = this.f3597p.getDimensionPixelOffset(C6.f.f391e);
        this.f3553A = this.f3597p.getDimensionPixelOffset(com.oplus.blacklistapp.n.f27287l);
        this.f3602z = this.f3597p.getDimensionPixelOffset(com.oplus.blacklistapp.n.f27286k);
        this.f3564L = this.f3597p.getDimensionPixelOffset(com.oplus.blacklistapp.n.f27283h);
        this.f3594m = this.f3591j.getResources().getDimensionPixelOffset(C6.f.f388b) * 2;
        this.f3592k = this.f3591j.getResources().getDimensionPixelOffset(com.oplus.blacklistapp.n.f27284i);
        this.f3565M = this.f3597p.getDimensionPixelOffset(C6.f.f392f);
        this.f3578Z = C0853n.a(context);
        this.f3584c0 = this.f3591j.getResources().getDimensionPixelSize(Y8.d.f5654j0);
    }

    public void s() {
        View view;
        int i10;
        int i11;
        int i12;
        if (this.f3577Y) {
            this.f3577Y = false;
            return;
        }
        if (this.f3576X || (view = this.f3587f) == null) {
            return;
        }
        this.f3588g = null;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                int i13 = 0;
                while (true) {
                    if (i13 >= viewGroup.getChildCount()) {
                        break;
                    }
                    if (viewGroup.getChildAt(i13).getVisibility() == 0) {
                        this.f3588g = viewGroup.getChildAt(i13);
                        break;
                    }
                    i13++;
                }
            }
        }
        if (this.f3588g == null) {
            this.f3588g = this.f3587f;
        }
        int[] iArr = new int[2];
        this.f3588g.getLocationOnScreen(iArr);
        int i14 = iArr[1];
        Activity activity = this.f3582b0;
        if (activity != null && (activity instanceof BlockedCallLogAndSmsListActivity)) {
            ((BlockedCallLogAndSmsListActivity) activity).l2(i14);
            if (i14 >= this.f3585d - this.f3601y && this.f3589h.getVisibility() != 0) {
                this.f3589h.setVisibility(0);
            }
        }
        int i15 = this.f3585d;
        int i16 = this.f3601y;
        if (i14 < i15 - i16) {
            i10 = i16;
        } else if (i14 > i15) {
            i10 = 0;
        } else {
            i10 = i15 - i14;
        }
        this.f3583c = i10;
        if (i14 > i15 - i16) {
            float abs = Math.abs(i10) / this.f3601y;
            this.f3558F = abs;
            this.f3589h.setAlpha(1.0f - abs);
        } else {
            this.f3589h.setAlpha(0.0f);
        }
        int i17 = this.f3563K;
        if (i14 < i17) {
            i11 = this.f3599r - i17;
        } else {
            int i18 = this.f3599r;
            if (i14 > i18) {
                i11 = 0;
            } else {
                i11 = i18 - i14;
            }
        }
        this.f3583c = i11;
        if (i14 >= i17) {
            float abs2 = Math.abs(i11) / (this.f3599r - this.f3563K);
            this.f3554B = abs2;
            ViewGroup.LayoutParams layoutParams = this.f3559G;
            layoutParams.width = (int) (this.f3562J + (this.f3594m * abs2));
            this.f3590i.setLayoutParams(layoutParams);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.f3559G;
            layoutParams2.width = this.f3562J + this.f3594m;
            this.f3590i.setLayoutParams(layoutParams2);
        }
        if (i14 < this.f3596o) {
            i12 = this.f3602z;
        } else {
            int i19 = this.f3585d;
            if (i14 > i19) {
                i12 = 0;
            } else {
                i12 = i19 - i14;
            }
        }
        int abs3 = Math.abs(i12);
        this.f3583c = abs3;
        if (i14 > this.f3596o) {
            float f10 = abs3 / this.f3602z;
            this.f3557E = f10;
            LinearLayout.LayoutParams layoutParams3 = this.f3593l;
            layoutParams3.topMargin = (int) (this.f3584c0 * (-1) * f10);
            this.f3589h.setLayoutParams(layoutParams3);
        } else {
            LinearLayout.LayoutParams layoutParams4 = this.f3593l;
            layoutParams4.topMargin = this.f3584c0 * (-1);
            this.f3589h.setLayoutParams(layoutParams4);
        }
        if (i14 > this.f3595n) {
            this.f3579a.setTitleTextColor(Color.argb(0, Color.red(this.f3578Z), Color.green(this.f3578Z), Color.blue(this.f3578Z)));
        } else {
            float f11 = (this.f3583c - this.f3553A) / this.f3598q;
            this.f3556D = f11;
            this.f3579a.setTitleTextColor(Color.argb((int) (f11 * 255.0f), Color.red(this.f3578Z), Color.green(this.f3578Z), Color.blue(this.f3578Z)));
        }
        int i20 = this.f3585d;
        int i21 = this.f3600x;
        if (i14 >= i20 - i21) {
            float f12 = this.f3583c / i21;
            this.f3555C = f12;
            this.f3590i.setAlpha(f12);
            return;
        }
        this.f3590i.setAlpha(1.0f);
    }

    public boolean t(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i10, int i11) {
        if ((i10 & 2) != 0 && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight() && this.f3585d <= 0) {
            this.f3586e = appBarLayout;
            this.f3579a = (COUIToolbar) appBarLayout.findViewById(com.oplus.blacklistapp.p.f27363T0);
            this.f3587f = (AbsListView) view2;
            TextView textView = (TextView) this.f3586e.findViewById(com.oplus.blacklistapp.p.f27365U0);
            this.f3589h = textView;
            this.f3593l = (LinearLayout.LayoutParams) textView.getLayoutParams();
            View findViewById = this.f3586e.findViewById(com.oplus.blacklistapp.p.f27386f);
            this.f3590i = findViewById;
            this.f3559G = findViewById.getLayoutParams();
            if (this.f3575W == 0) {
                this.f3575W = this.f3586e.getMeasuredHeight() + C0849j.l(this.f3591j);
            }
            int i12 = this.f3593l.topMargin;
            int i13 = this.f3584c0;
            if (i12 == (-i13)) {
                int i14 = this.f3575W;
                this.f3585d = i13 + i14 + this.f3565M;
                this.f3566N = i14 - this.f3590i.getHeight();
            } else {
                int i15 = this.f3575W;
                this.f3585d = this.f3565M + i15;
                this.f3566N = (i15 - this.f3590i.getHeight()) - this.f3584c0;
            }
            int i16 = this.f3585d;
            this.f3560H = i16;
            this.f3563K = i16 - (this.f3592k / 2);
            this.f3595n = i16 - this.f3597p.getDimensionPixelOffset(com.oplus.blacklistapp.n.f27287l);
            int dimensionPixelOffset = this.f3585d - this.f3597p.getDimensionPixelOffset(com.oplus.blacklistapp.n.f27286k);
            this.f3596o = dimensionPixelOffset;
            this.f3598q = this.f3595n - dimensionPixelOffset;
            this.f3599r = this.f3585d - this.f3597p.getDimensionPixelOffset(com.oplus.blacklistapp.n.f27283h);
            this.f3562J = this.f3597p.getDisplayMetrics().widthPixels - this.f3594m;
            this.f3567O = this.f3566N + (this.f3584c0 / 2);
            this.f3587f.setOnScrollChangeListener(new a());
            ((AbsListView) this.f3587f).setOnScrollListener(this);
            this.f3587f.setOnTouchListener(new b());
            ViewPager viewPager = (ViewPager) coordinatorLayout.findViewById(com.oplus.blacklistapp.p.f27369W0);
            this.f3581b = viewPager;
            viewPager.addOnPageChangeListener(new c());
            return false;
        }
        return false;
    }

    public void u(Activity activity) {
        this.f3582b0 = activity;
    }

    public void v(int i10) {
        this.f3575W = i10;
    }

    public void w(boolean z10) {
        this.f3577Y = z10;
    }

    public void x(boolean z10) {
        this.f3576X = z10;
        if (z10) {
            this.f3585d = 0;
            View view = this.f3587f;
            if (view != null) {
                view.setOnScrollChangeListener(null);
            }
        }
    }

    /* compiled from: HeadScaleListViewBehavior.java */
    /* loaded from: classes4.dex */
    public class c implements ViewPager.i {
        public c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageSelected(int i10) {
            m mVar = m.this;
            mVar.f3587f = mVar.f3581b.getChildAt(m.this.f3581b.getCurrentItem()).findViewById(com.oplus.blacklistapp.p.f27362T);
            ((AbsListView) m.this.f3587f).setOnScrollListener(m.this);
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageScrollStateChanged(int i10) {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageScrolled(int i10, float f10, int i11) {
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
    }
}
