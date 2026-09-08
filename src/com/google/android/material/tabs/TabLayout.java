package com.google.android.material.tabs;

import J.d;
import android.R;
import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.P;
import androidx.core.view.C;
import androidx.core.view.C0458m;
import androidx.core.view.K;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.internal.ViewUtils;
import e4.C0977c;
import e4.k;
import e4.l;
import f.C0991a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import n4.C1370a;

@ViewPager.e
/* loaded from: classes3.dex */
public class TabLayout extends HorizontalScrollView {

    /* renamed from: f0, reason: collision with root package name */
    public static final int f23868f0 = l.f31033p;

    /* renamed from: g0, reason: collision with root package name */
    public static final I.e<g> f23869g0 = new I.g(16);

    /* renamed from: A, reason: collision with root package name */
    public int f23870A;

    /* renamed from: B, reason: collision with root package name */
    public final int f23871B;

    /* renamed from: C, reason: collision with root package name */
    public final int f23872C;

    /* renamed from: D, reason: collision with root package name */
    public final int f23873D;

    /* renamed from: E, reason: collision with root package name */
    public int f23874E;

    /* renamed from: F, reason: collision with root package name */
    public int f23875F;

    /* renamed from: G, reason: collision with root package name */
    public int f23876G;

    /* renamed from: H, reason: collision with root package name */
    public int f23877H;

    /* renamed from: I, reason: collision with root package name */
    public int f23878I;

    /* renamed from: J, reason: collision with root package name */
    public boolean f23879J;

    /* renamed from: K, reason: collision with root package name */
    public boolean f23880K;

    /* renamed from: L, reason: collision with root package name */
    public int f23881L;

    /* renamed from: M, reason: collision with root package name */
    public int f23882M;

    /* renamed from: N, reason: collision with root package name */
    public boolean f23883N;

    /* renamed from: O, reason: collision with root package name */
    public com.google.android.material.tabs.a f23884O;

    /* renamed from: P, reason: collision with root package name */
    public final TimeInterpolator f23885P;

    /* renamed from: Q, reason: collision with root package name */
    public c f23886Q;

    /* renamed from: R, reason: collision with root package name */
    public final ArrayList<c> f23887R;

    /* renamed from: S, reason: collision with root package name */
    public c f23888S;

    /* renamed from: T, reason: collision with root package name */
    public ValueAnimator f23889T;

    /* renamed from: U, reason: collision with root package name */
    public ViewPager f23890U;

    /* renamed from: V, reason: collision with root package name */
    public androidx.viewpager.widget.a f23891V;

    /* renamed from: W, reason: collision with root package name */
    public DataSetObserver f23892W;

    /* renamed from: a, reason: collision with root package name */
    public int f23893a;

    /* renamed from: a0, reason: collision with root package name */
    public h f23894a0;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<g> f23895b;

    /* renamed from: b0, reason: collision with root package name */
    public b f23896b0;

    /* renamed from: c, reason: collision with root package name */
    public g f23897c;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f23898c0;

    /* renamed from: d, reason: collision with root package name */
    public final f f23899d;

    /* renamed from: d0, reason: collision with root package name */
    public int f23900d0;

    /* renamed from: e, reason: collision with root package name */
    public int f23901e;

    /* renamed from: e0, reason: collision with root package name */
    public final I.e<i> f23902e0;

    /* renamed from: f, reason: collision with root package name */
    public int f23903f;

    /* renamed from: g, reason: collision with root package name */
    public int f23904g;

    /* renamed from: h, reason: collision with root package name */
    public int f23905h;

    /* renamed from: i, reason: collision with root package name */
    public final int f23906i;

    /* renamed from: j, reason: collision with root package name */
    public final int f23907j;

    /* renamed from: k, reason: collision with root package name */
    public int f23908k;

    /* renamed from: l, reason: collision with root package name */
    public ColorStateList f23909l;

    /* renamed from: m, reason: collision with root package name */
    public ColorStateList f23910m;

    /* renamed from: n, reason: collision with root package name */
    public ColorStateList f23911n;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f23912o;

    /* renamed from: p, reason: collision with root package name */
    public int f23913p;

    /* renamed from: q, reason: collision with root package name */
    public PorterDuff.Mode f23914q;

    /* renamed from: r, reason: collision with root package name */
    public float f23915r;

    /* renamed from: x, reason: collision with root package name */
    public float f23916x;

    /* renamed from: y, reason: collision with root package name */
    public float f23917y;

    /* renamed from: z, reason: collision with root package name */
    public final int f23918z;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ViewPager.h {

        /* renamed from: a, reason: collision with root package name */
        public boolean f23920a;

        public b() {
        }

        public void a(boolean z10) {
            this.f23920a = z10;
        }

        @Override // androidx.viewpager.widget.ViewPager.h
        public void onAdapterChanged(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f23890U == viewPager) {
                tabLayout.L(aVar2, this.f23920a);
            }
        }
    }

    @Deprecated
    /* loaded from: classes3.dex */
    public interface c<T extends g> {
        void a(T t10);

        void b(T t10);

        void c(T t10);
    }

    /* loaded from: classes3.dex */
    public interface d extends c<g> {
    }

    /* loaded from: classes3.dex */
    public class e extends DataSetObserver {
        public e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.E();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.E();
        }
    }

    /* loaded from: classes3.dex */
    public class f extends LinearLayout {

        /* renamed from: a, reason: collision with root package name */
        public ValueAnimator f23923a;

        /* renamed from: b, reason: collision with root package name */
        public int f23924b;

        /* loaded from: classes3.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f23926a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f23927b;

            public a(View view, View view2) {
                this.f23926a = view;
                this.f23927b = view2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.j(this.f23926a, this.f23927b, valueAnimator.getAnimatedFraction());
            }
        }

        public f(Context context) {
            super(context);
            this.f23924b = -1;
            setWillNotDraw(false);
        }

        public void c(int i10, int i11) {
            ValueAnimator valueAnimator = this.f23923a;
            if (valueAnimator != null && valueAnimator.isRunning() && TabLayout.this.f23893a != i10) {
                this.f23923a.cancel();
            }
            k(true, i10, i11);
        }

        public boolean d() {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                if (getChildAt(i10).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            int height;
            int height2 = TabLayout.this.f23912o.getBounds().height();
            if (height2 < 0) {
                height2 = TabLayout.this.f23912o.getIntrinsicHeight();
            }
            int i10 = TabLayout.this.f23877H;
            if (i10 != 0) {
                if (i10 != 1) {
                    height = 0;
                    if (i10 != 2) {
                        if (i10 != 3) {
                            height2 = 0;
                        } else {
                            height2 = getHeight();
                        }
                    }
                } else {
                    height = (getHeight() - height2) / 2;
                    height2 = (getHeight() + height2) / 2;
                }
            } else {
                height = getHeight() - height2;
                height2 = getHeight();
            }
            if (TabLayout.this.f23912o.getBounds().width() > 0) {
                Rect bounds = TabLayout.this.f23912o.getBounds();
                TabLayout.this.f23912o.setBounds(bounds.left, height, bounds.right, height2);
                TabLayout.this.f23912o.draw(canvas);
            }
            super.draw(canvas);
        }

        public final void e() {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f23893a == -1) {
                tabLayout.f23893a = tabLayout.getSelectedTabPosition();
            }
            f(TabLayout.this.f23893a);
        }

        public final void f(int i10) {
            if (TabLayout.this.f23900d0 != 0 && (TabLayout.this.getTabSelectedIndicator().getBounds().left != -1 || TabLayout.this.getTabSelectedIndicator().getBounds().right != -1)) {
                return;
            }
            View childAt = getChildAt(i10);
            com.google.android.material.tabs.a aVar = TabLayout.this.f23884O;
            TabLayout tabLayout = TabLayout.this;
            aVar.c(tabLayout, childAt, tabLayout.f23912o);
            TabLayout.this.f23893a = i10;
        }

        public final void g() {
            f(TabLayout.this.getSelectedTabPosition());
        }

        public void h(int i10, float f10) {
            TabLayout.this.f23893a = Math.round(i10 + f10);
            ValueAnimator valueAnimator = this.f23923a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f23923a.cancel();
            }
            j(getChildAt(i10), getChildAt(i10 + 1), f10);
        }

        public void i(int i10) {
            Rect bounds = TabLayout.this.f23912o.getBounds();
            TabLayout.this.f23912o.setBounds(bounds.left, 0, bounds.right, i10);
            requestLayout();
        }

        public final void j(View view, View view2, float f10) {
            if (view != null && view.getWidth() > 0) {
                com.google.android.material.tabs.a aVar = TabLayout.this.f23884O;
                TabLayout tabLayout = TabLayout.this;
                aVar.d(tabLayout, view, view2, f10, tabLayout.f23912o);
            } else {
                Drawable drawable = TabLayout.this.f23912o;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.f23912o.getBounds().bottom);
            }
            K.Z(this);
        }

        public final void k(boolean z10, int i10, int i11) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f23893a == i10) {
                return;
            }
            View childAt = getChildAt(tabLayout.getSelectedTabPosition());
            View childAt2 = getChildAt(i10);
            if (childAt2 == null) {
                g();
                return;
            }
            TabLayout.this.f23893a = i10;
            a aVar = new a(childAt, childAt2);
            if (z10) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.f23923a = valueAnimator;
                valueAnimator.setInterpolator(TabLayout.this.f23885P);
                valueAnimator.setDuration(i11);
                valueAnimator.setFloatValues(0.0f, 1.0f);
                valueAnimator.addUpdateListener(aVar);
                valueAnimator.start();
                return;
            }
            this.f23923a.removeAllUpdateListeners();
            this.f23923a.addUpdateListener(aVar);
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
            super.onLayout(z10, i10, i11, i12, i13);
            ValueAnimator valueAnimator = this.f23923a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                k(false, TabLayout.this.getSelectedTabPosition(), -1);
            } else {
                e();
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            if (View.MeasureSpec.getMode(i10) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f23875F == 1 || tabLayout.f23878I == 2) {
                int childCount = getChildCount();
                int i12 = 0;
                for (int i13 = 0; i13 < childCount; i13++) {
                    View childAt = getChildAt(i13);
                    if (childAt.getVisibility() == 0) {
                        i12 = Math.max(i12, childAt.getMeasuredWidth());
                    }
                }
                if (i12 <= 0) {
                    return;
                }
                if (i12 * childCount <= getMeasuredWidth() - (((int) ViewUtils.dpToPx(getContext(), 16)) * 2)) {
                    boolean z10 = false;
                    for (int i14 = 0; i14 < childCount; i14++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i14).getLayoutParams();
                        if (layoutParams.width != i12 || layoutParams.weight != 0.0f) {
                            layoutParams.width = i12;
                            layoutParams.weight = 0.0f;
                            z10 = true;
                        }
                    }
                    if (!z10) {
                        return;
                    }
                } else {
                    TabLayout tabLayout2 = TabLayout.this;
                    tabLayout2.f23875F = 0;
                    tabLayout2.T(false);
                }
                super.onMeasure(i10, i11);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i10) {
            super.onRtlPropertiesChanged(i10);
        }
    }

    /* loaded from: classes3.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public Object f23929a;

        /* renamed from: b, reason: collision with root package name */
        public Drawable f23930b;

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f23931c;

        /* renamed from: d, reason: collision with root package name */
        public CharSequence f23932d;

        /* renamed from: f, reason: collision with root package name */
        public View f23934f;

        /* renamed from: h, reason: collision with root package name */
        public TabLayout f23936h;

        /* renamed from: i, reason: collision with root package name */
        public i f23937i;

        /* renamed from: e, reason: collision with root package name */
        public int f23933e = -1;

        /* renamed from: g, reason: collision with root package name */
        public int f23935g = 1;

        /* renamed from: j, reason: collision with root package name */
        public int f23938j = -1;

        public View e() {
            return this.f23934f;
        }

        public Drawable f() {
            return this.f23930b;
        }

        public int g() {
            return this.f23933e;
        }

        public int h() {
            return this.f23935g;
        }

        public CharSequence i() {
            return this.f23931c;
        }

        public boolean j() {
            TabLayout tabLayout = this.f23936h;
            if (tabLayout != null) {
                int selectedTabPosition = tabLayout.getSelectedTabPosition();
                if (selectedTabPosition != -1 && selectedTabPosition == this.f23933e) {
                    return true;
                }
                return false;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public void k() {
            this.f23936h = null;
            this.f23937i = null;
            this.f23929a = null;
            this.f23930b = null;
            this.f23938j = -1;
            this.f23931c = null;
            this.f23932d = null;
            this.f23933e = -1;
            this.f23934f = null;
        }

        public void l() {
            TabLayout tabLayout = this.f23936h;
            if (tabLayout != null) {
                tabLayout.J(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public g m(CharSequence charSequence) {
            this.f23932d = charSequence;
            s();
            return this;
        }

        public g n(int i10) {
            return o(LayoutInflater.from(this.f23937i.getContext()).inflate(i10, (ViewGroup) this.f23937i, false));
        }

        public g o(View view) {
            this.f23934f = view;
            s();
            return this;
        }

        public g p(Drawable drawable) {
            this.f23930b = drawable;
            TabLayout tabLayout = this.f23936h;
            if (tabLayout.f23875F == 1 || tabLayout.f23878I == 2) {
                tabLayout.T(true);
            }
            s();
            if (com.google.android.material.badge.b.f22709a && this.f23937i.l() && this.f23937i.f23946e.isVisible()) {
                this.f23937i.invalidate();
            }
            return this;
        }

        public void q(int i10) {
            this.f23933e = i10;
        }

        public g r(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f23932d) && !TextUtils.isEmpty(charSequence)) {
                this.f23937i.setContentDescription(charSequence);
            }
            this.f23931c = charSequence;
            s();
            return this;
        }

        public void s() {
            i iVar = this.f23937i;
            if (iVar != null) {
                iVar.t();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class h implements ViewPager.i {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<TabLayout> f23939a;

        /* renamed from: b, reason: collision with root package name */
        public int f23940b;

        /* renamed from: c, reason: collision with root package name */
        public int f23941c;

        public h(TabLayout tabLayout) {
            this.f23939a = new WeakReference<>(tabLayout);
        }

        public void a() {
            this.f23941c = 0;
            this.f23940b = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageScrollStateChanged(int i10) {
            this.f23940b = this.f23941c;
            this.f23941c = i10;
            TabLayout tabLayout = this.f23939a.get();
            if (tabLayout != null) {
                tabLayout.U(this.f23941c);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageScrolled(int i10, float f10, int i11) {
            boolean z10;
            boolean z11;
            TabLayout tabLayout = this.f23939a.get();
            if (tabLayout != null) {
                int i12 = this.f23941c;
                if (i12 == 2 && this.f23940b != 1) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (i12 == 2 && this.f23940b == 0) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                tabLayout.O(i10, f10, z10, z11, false);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageSelected(int i10) {
            boolean z10;
            TabLayout tabLayout = this.f23939a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i10 && i10 < tabLayout.getTabCount()) {
                int i11 = this.f23941c;
                if (i11 != 0 && (i11 != 2 || this.f23940b != 0)) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                tabLayout.K(tabLayout.A(i10), z10);
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class i extends LinearLayout {

        /* renamed from: a, reason: collision with root package name */
        public g f23942a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f23943b;

        /* renamed from: c, reason: collision with root package name */
        public ImageView f23944c;

        /* renamed from: d, reason: collision with root package name */
        public View f23945d;

        /* renamed from: e, reason: collision with root package name */
        public com.google.android.material.badge.a f23946e;

        /* renamed from: f, reason: collision with root package name */
        public View f23947f;

        /* renamed from: g, reason: collision with root package name */
        public TextView f23948g;

        /* renamed from: h, reason: collision with root package name */
        public ImageView f23949h;

        /* renamed from: i, reason: collision with root package name */
        public Drawable f23950i;

        /* renamed from: j, reason: collision with root package name */
        public int f23951j;

        /* loaded from: classes3.dex */
        public class a implements View.OnLayoutChangeListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f23953a;

            public a(View view) {
                this.f23953a = view;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                if (this.f23953a.getVisibility() == 0) {
                    i.this.s(this.f23953a);
                }
            }
        }

        public i(Context context) {
            super(context);
            this.f23951j = 2;
            u(context);
            K.A0(this, TabLayout.this.f23901e, TabLayout.this.f23903f, TabLayout.this.f23904g, TabLayout.this.f23905h);
            setGravity(17);
            setOrientation(!TabLayout.this.f23879J ? 1 : 0);
            setClickable(true);
            K.B0(this, C.b(getContext(), 1002));
        }

        private com.google.android.material.badge.a getBadge() {
            return this.f23946e;
        }

        private com.google.android.material.badge.a getOrCreateBadge() {
            if (this.f23946e == null) {
                this.f23946e = com.google.android.material.badge.a.c(getContext());
            }
            r();
            com.google.android.material.badge.a aVar = this.f23946e;
            if (aVar != null) {
                return aVar;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        @Override // android.view.ViewGroup, android.view.View
        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f23950i;
            if (drawable != null && drawable.isStateful() && this.f23950i.setState(drawableState)) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        public final void f(View view) {
            if (view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new a(view));
        }

        public final float g(Layout layout, int i10, float f10) {
            return layout.getLineWidth(i10) * (f10 / layout.getPaint().getTextSize());
        }

        public int getContentHeight() {
            View[] viewArr = {this.f23943b, this.f23944c, this.f23947f};
            int i10 = 0;
            int i11 = 0;
            boolean z10 = false;
            for (int i12 = 0; i12 < 3; i12++) {
                View view = viewArr[i12];
                if (view != null && view.getVisibility() == 0) {
                    if (z10) {
                        i11 = Math.min(i11, view.getTop());
                    } else {
                        i11 = view.getTop();
                    }
                    if (z10) {
                        i10 = Math.max(i10, view.getBottom());
                    } else {
                        i10 = view.getBottom();
                    }
                    z10 = true;
                }
            }
            return i10 - i11;
        }

        public int getContentWidth() {
            View[] viewArr = {this.f23943b, this.f23944c, this.f23947f};
            int i10 = 0;
            int i11 = 0;
            boolean z10 = false;
            for (int i12 = 0; i12 < 3; i12++) {
                View view = viewArr[i12];
                if (view != null && view.getVisibility() == 0) {
                    if (z10) {
                        i11 = Math.min(i11, view.getLeft());
                    } else {
                        i11 = view.getLeft();
                    }
                    if (z10) {
                        i10 = Math.max(i10, view.getRight());
                    } else {
                        i10 = view.getRight();
                    }
                    z10 = true;
                }
            }
            return i10 - i11;
        }

        public g getTab() {
            return this.f23942a;
        }

        public final void h(boolean z10) {
            setClipChildren(z10);
            setClipToPadding(z10);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z10);
                viewGroup.setClipToPadding(z10);
            }
        }

        public final FrameLayout i() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        public final void j(Canvas canvas) {
            Drawable drawable = this.f23950i;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.f23950i.draw(canvas);
            }
        }

        public final FrameLayout k(View view) {
            if ((view != this.f23944c && view != this.f23943b) || !com.google.android.material.badge.b.f22709a) {
                return null;
            }
            return (FrameLayout) view.getParent();
        }

        public final boolean l() {
            if (this.f23946e != null) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void m() {
            FrameLayout frameLayout;
            if (com.google.android.material.badge.b.f22709a) {
                frameLayout = i();
                addView(frameLayout, 0);
            } else {
                frameLayout = this;
            }
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(e4.i.f30923c, (ViewGroup) frameLayout, false);
            this.f23944c = imageView;
            frameLayout.addView(imageView, 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void n() {
            FrameLayout frameLayout;
            if (com.google.android.material.badge.b.f22709a) {
                frameLayout = i();
                addView(frameLayout);
            } else {
                frameLayout = this;
            }
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(e4.i.f30924d, (ViewGroup) frameLayout, false);
            this.f23943b = textView;
            frameLayout.addView(textView);
        }

        public void o() {
            setTab(null);
            setSelected(false);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            J.d O02 = J.d.O0(accessibilityNodeInfo);
            com.google.android.material.badge.a aVar = this.f23946e;
            if (aVar != null && aVar.isVisible()) {
                O02.l0(this.f23946e.h());
            }
            O02.k0(d.f.a(0, 1, this.f23942a.g(), 1, false, isSelected()));
            if (isSelected()) {
                O02.i0(false);
                O02.a0(d.a.f1394i);
            }
            O02.C0(getResources().getString(k.f30983k));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i10);
            int mode = View.MeasureSpec.getMode(i10);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i10 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.f23870A, Integer.MIN_VALUE);
            }
            super.onMeasure(i10, i11);
            if (this.f23943b != null) {
                float f10 = TabLayout.this.f23915r;
                int i12 = this.f23951j;
                ImageView imageView = this.f23944c;
                if (imageView != null && imageView.getVisibility() == 0) {
                    i12 = 1;
                } else {
                    TextView textView = this.f23943b;
                    if (textView != null && textView.getLineCount() > 1) {
                        f10 = TabLayout.this.f23917y;
                    }
                }
                float textSize = this.f23943b.getTextSize();
                int lineCount = this.f23943b.getLineCount();
                int d10 = androidx.core.widget.k.d(this.f23943b);
                if (f10 != textSize || (d10 >= 0 && i12 != d10)) {
                    if (TabLayout.this.f23878I != 1 || f10 <= textSize || lineCount != 1 || ((layout = this.f23943b.getLayout()) != null && g(layout, 0, f10) <= (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        this.f23943b.setTextSize(0, f10);
                        this.f23943b.setMaxLines(i12);
                        super.onMeasure(i10, i11);
                    }
                }
            }
        }

        public final void p(View view) {
            if (l() && view != null) {
                h(false);
                com.google.android.material.badge.b.a(this.f23946e, view, k(view));
                this.f23945d = view;
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f23942a != null) {
                if (!performClick) {
                    playSoundEffect(0);
                }
                this.f23942a.l();
                return true;
            }
            return performClick;
        }

        public final void q() {
            if (!l()) {
                return;
            }
            h(true);
            View view = this.f23945d;
            if (view != null) {
                com.google.android.material.badge.b.d(this.f23946e, view);
                this.f23945d = null;
            }
        }

        public final void r() {
            g gVar;
            g gVar2;
            if (!l()) {
                return;
            }
            if (this.f23947f != null) {
                q();
                return;
            }
            if (this.f23944c != null && (gVar2 = this.f23942a) != null && gVar2.f() != null) {
                View view = this.f23945d;
                ImageView imageView = this.f23944c;
                if (view != imageView) {
                    q();
                    p(this.f23944c);
                    return;
                } else {
                    s(imageView);
                    return;
                }
            }
            if (this.f23943b != null && (gVar = this.f23942a) != null && gVar.h() == 1) {
                View view2 = this.f23945d;
                TextView textView = this.f23943b;
                if (view2 != textView) {
                    q();
                    p(this.f23943b);
                    return;
                } else {
                    s(textView);
                    return;
                }
            }
            q();
        }

        public final void s(View view) {
            if (l() && view == this.f23945d) {
                com.google.android.material.badge.b.e(this.f23946e, view, k(view));
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z10) {
            isSelected();
            super.setSelected(z10);
            TextView textView = this.f23943b;
            if (textView != null) {
                textView.setSelected(z10);
            }
            ImageView imageView = this.f23944c;
            if (imageView != null) {
                imageView.setSelected(z10);
            }
            View view = this.f23947f;
            if (view != null) {
                view.setSelected(z10);
            }
        }

        public void setTab(g gVar) {
            if (gVar != this.f23942a) {
                this.f23942a = gVar;
                t();
            }
        }

        public final void t() {
            boolean z10;
            w();
            g gVar = this.f23942a;
            if (gVar != null && gVar.j()) {
                z10 = true;
            } else {
                z10 = false;
            }
            setSelected(z10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [android.graphics.drawable.RippleDrawable] */
        public final void u(Context context) {
            int i10 = TabLayout.this.f23918z;
            GradientDrawable gradientDrawable = null;
            if (i10 != 0) {
                Drawable b10 = C0991a.b(context, i10);
                this.f23950i = b10;
                if (b10 != null && b10.isStateful()) {
                    this.f23950i.setState(getDrawableState());
                }
            } else {
                this.f23950i = null;
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(0);
            if (TabLayout.this.f23911n != null) {
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setCornerRadius(1.0E-5f);
                gradientDrawable3.setColor(-1);
                ColorStateList a10 = v4.b.a(TabLayout.this.f23911n);
                boolean z10 = TabLayout.this.f23883N;
                if (z10) {
                    gradientDrawable2 = null;
                }
                if (!z10) {
                    gradientDrawable = gradientDrawable3;
                }
                gradientDrawable2 = new RippleDrawable(a10, gradientDrawable2, gradientDrawable);
            }
            K.n0(this, gradientDrawable2);
            TabLayout.this.invalidate();
        }

        public final void v() {
            setOrientation(!TabLayout.this.f23879J ? 1 : 0);
            TextView textView = this.f23948g;
            if (textView == null && this.f23949h == null) {
                x(this.f23943b, this.f23944c, true);
            } else {
                x(textView, this.f23949h, false);
            }
        }

        public final void w() {
            View view;
            ViewParent parent;
            g gVar = this.f23942a;
            if (gVar != null) {
                view = gVar.e();
            } else {
                view = null;
            }
            if (view != null) {
                ViewParent parent2 = view.getParent();
                if (parent2 != this) {
                    if (parent2 != null) {
                        ((ViewGroup) parent2).removeView(view);
                    }
                    View view2 = this.f23947f;
                    if (view2 != null && (parent = view2.getParent()) != null) {
                        ((ViewGroup) parent).removeView(this.f23947f);
                    }
                    addView(view);
                }
                this.f23947f = view;
                TextView textView = this.f23943b;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f23944c;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f23944c.setImageDrawable(null);
                }
                TextView textView2 = (TextView) view.findViewById(R.id.text1);
                this.f23948g = textView2;
                if (textView2 != null) {
                    this.f23951j = androidx.core.widget.k.d(textView2);
                }
                this.f23949h = (ImageView) view.findViewById(R.id.icon);
            } else {
                View view3 = this.f23947f;
                if (view3 != null) {
                    removeView(view3);
                    this.f23947f = null;
                }
                this.f23948g = null;
                this.f23949h = null;
            }
            if (this.f23947f == null) {
                if (this.f23944c == null) {
                    m();
                }
                if (this.f23943b == null) {
                    n();
                    this.f23951j = androidx.core.widget.k.d(this.f23943b);
                }
                androidx.core.widget.k.p(this.f23943b, TabLayout.this.f23906i);
                if (isSelected() && TabLayout.this.f23908k != -1) {
                    androidx.core.widget.k.p(this.f23943b, TabLayout.this.f23908k);
                } else {
                    androidx.core.widget.k.p(this.f23943b, TabLayout.this.f23907j);
                }
                ColorStateList colorStateList = TabLayout.this.f23909l;
                if (colorStateList != null) {
                    this.f23943b.setTextColor(colorStateList);
                }
                x(this.f23943b, this.f23944c, true);
                r();
                f(this.f23944c);
                f(this.f23943b);
            } else {
                TextView textView3 = this.f23948g;
                if (textView3 != null || this.f23949h != null) {
                    x(textView3, this.f23949h, false);
                }
            }
            if (gVar != null && !TextUtils.isEmpty(gVar.f23932d)) {
                setContentDescription(gVar.f23932d);
            }
        }

        public final void x(TextView textView, ImageView imageView, boolean z10) {
            Drawable drawable;
            CharSequence charSequence;
            int i10;
            CharSequence charSequence2;
            int i11;
            g gVar = this.f23942a;
            CharSequence charSequence3 = null;
            if (gVar != null && gVar.f() != null) {
                drawable = C.a.r(this.f23942a.f()).mutate();
            } else {
                drawable = null;
            }
            if (drawable != null) {
                C.a.o(drawable, TabLayout.this.f23910m);
                PorterDuff.Mode mode = TabLayout.this.f23914q;
                if (mode != null) {
                    C.a.p(drawable, mode);
                }
            }
            g gVar2 = this.f23942a;
            if (gVar2 != null) {
                charSequence = gVar2.i();
            } else {
                charSequence = null;
            }
            if (imageView != null) {
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z11 = true;
            boolean z12 = !TextUtils.isEmpty(charSequence);
            if (textView != null) {
                if (!z12 || this.f23942a.f23935g != 1) {
                    z11 = false;
                }
                if (z12) {
                    charSequence2 = charSequence;
                } else {
                    charSequence2 = null;
                }
                textView.setText(charSequence2);
                if (z11) {
                    i11 = 0;
                } else {
                    i11 = 8;
                }
                textView.setVisibility(i11);
                if (z12) {
                    setVisibility(0);
                }
            } else {
                z11 = false;
            }
            if (z10 && imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                if (z11 && imageView.getVisibility() == 0) {
                    i10 = (int) ViewUtils.dpToPx(getContext(), 8);
                } else {
                    i10 = 0;
                }
                if (TabLayout.this.f23879J) {
                    if (i10 != C0458m.a(marginLayoutParams)) {
                        C0458m.c(marginLayoutParams, i10);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (i10 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = i10;
                    C0458m.c(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            g gVar3 = this.f23942a;
            if (gVar3 != null) {
                charSequence3 = gVar3.f23932d;
            }
            if (!z12) {
                charSequence = charSequence3;
            }
            P.a(this, charSequence);
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0977c.f30702x0);
    }

    private int getDefaultHeight() {
        int size = this.f23895b.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                break;
            }
            g gVar = this.f23895b.get(i10);
            if (gVar != null && gVar.f() != null && !TextUtils.isEmpty(gVar.i())) {
                if (!this.f23879J) {
                    return 72;
                }
            } else {
                i10++;
            }
        }
        return 48;
    }

    private int getTabMinWidth() {
        int i10 = this.f23871B;
        if (i10 != -1) {
            return i10;
        }
        int i11 = this.f23878I;
        if (i11 != 0 && i11 != 2) {
            return 0;
        }
        return this.f23873D;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f23899d.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    public static ColorStateList s(int i10, int i11) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i11, i10});
    }

    private void setSelectedTabView(int i10) {
        boolean z10;
        boolean z11;
        int childCount = this.f23899d.getChildCount();
        if (i10 < childCount) {
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = this.f23899d.getChildAt(i11);
                boolean z12 = true;
                if ((i11 == i10 && !childAt.isSelected()) || (i11 != i10 && childAt.isSelected())) {
                    if (i11 == i10) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    childAt.setSelected(z11);
                    if (i11 != i10) {
                        z12 = false;
                    }
                    childAt.setActivated(z12);
                    if (childAt instanceof i) {
                        ((i) childAt).w();
                    }
                } else {
                    if (i11 == i10) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    childAt.setSelected(z10);
                    if (i11 != i10) {
                        z12 = false;
                    }
                    childAt.setActivated(z12);
                }
            }
        }
    }

    public g A(int i10) {
        if (i10 >= 0 && i10 < getTabCount()) {
            return this.f23895b.get(i10);
        }
        return null;
    }

    public final boolean B() {
        if (getTabMode() != 0 && getTabMode() != 2) {
            return false;
        }
        return true;
    }

    public boolean C() {
        return this.f23880K;
    }

    public g D() {
        g u10 = u();
        u10.f23936h = this;
        u10.f23937i = v(u10);
        if (u10.f23938j != -1) {
            u10.f23937i.setId(u10.f23938j);
        }
        return u10;
    }

    public void E() {
        int currentItem;
        G();
        androidx.viewpager.widget.a aVar = this.f23891V;
        if (aVar != null) {
            int count = aVar.getCount();
            for (int i10 = 0; i10 < count; i10++) {
                j(D().r(this.f23891V.getPageTitle(i10)), false);
            }
            ViewPager viewPager = this.f23890U;
            if (viewPager != null && count > 0 && (currentItem = viewPager.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                J(A(currentItem));
            }
        }
    }

    public boolean F(g gVar) {
        return f23869g0.a(gVar);
    }

    public void G() {
        for (int childCount = this.f23899d.getChildCount() - 1; childCount >= 0; childCount--) {
            I(childCount);
        }
        Iterator<g> it = this.f23895b.iterator();
        while (it.hasNext()) {
            g next = it.next();
            it.remove();
            next.k();
            F(next);
        }
        this.f23897c = null;
    }

    @Deprecated
    public void H(c cVar) {
        this.f23887R.remove(cVar);
    }

    public final void I(int i10) {
        i iVar = (i) this.f23899d.getChildAt(i10);
        this.f23899d.removeViewAt(i10);
        if (iVar != null) {
            iVar.o();
            this.f23902e0.a(iVar);
        }
        requestLayout();
    }

    public void J(g gVar) {
        K(gVar, true);
    }

    public void K(g gVar, boolean z10) {
        int i10;
        g gVar2 = this.f23897c;
        if (gVar2 == gVar) {
            if (gVar2 != null) {
                w(gVar);
                n(gVar.g());
                return;
            }
            return;
        }
        if (gVar != null) {
            i10 = gVar.g();
        } else {
            i10 = -1;
        }
        if (z10) {
            if ((gVar2 == null || gVar2.g() == -1) && i10 != -1) {
                M(i10, 0.0f, true);
            } else {
                n(i10);
            }
            if (i10 != -1) {
                setSelectedTabView(i10);
            }
        }
        this.f23897c = gVar;
        if (gVar2 != null && gVar2.f23936h != null) {
            y(gVar2);
        }
        if (gVar != null) {
            x(gVar);
        }
    }

    public void L(androidx.viewpager.widget.a aVar, boolean z10) {
        DataSetObserver dataSetObserver;
        androidx.viewpager.widget.a aVar2 = this.f23891V;
        if (aVar2 != null && (dataSetObserver = this.f23892W) != null) {
            aVar2.unregisterDataSetObserver(dataSetObserver);
        }
        this.f23891V = aVar;
        if (z10 && aVar != null) {
            if (this.f23892W == null) {
                this.f23892W = new e();
            }
            aVar.registerDataSetObserver(this.f23892W);
        }
        E();
    }

    public void M(int i10, float f10, boolean z10) {
        N(i10, f10, z10, true);
    }

    public void N(int i10, float f10, boolean z10, boolean z11) {
        O(i10, f10, z10, z11, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x006e, code lost:
    
        if (r10 == false) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void O(int r6, float r7, boolean r8, boolean r9, boolean r10) {
        /*
            r5 = this;
            float r0 = (float) r6
            float r0 = r0 + r7
            int r0 = java.lang.Math.round(r0)
            if (r0 < 0) goto L7b
            com.google.android.material.tabs.TabLayout$f r1 = r5.f23899d
            int r1 = r1.getChildCount()
            if (r0 < r1) goto L12
            goto L7b
        L12:
            if (r9 == 0) goto L19
            com.google.android.material.tabs.TabLayout$f r9 = r5.f23899d
            r9.h(r6, r7)
        L19:
            android.animation.ValueAnimator r9 = r5.f23889T
            if (r9 == 0) goto L28
            boolean r9 = r9.isRunning()
            if (r9 == 0) goto L28
            android.animation.ValueAnimator r9 = r5.f23889T
            r9.cancel()
        L28:
            int r7 = r5.q(r6, r7)
            int r9 = r5.getScrollX()
            int r1 = r5.getSelectedTabPosition()
            r2 = 0
            r3 = 1
            if (r6 >= r1) goto L3a
            if (r7 >= r9) goto L48
        L3a:
            int r1 = r5.getSelectedTabPosition()
            if (r6 <= r1) goto L42
            if (r7 <= r9) goto L48
        L42:
            int r1 = r5.getSelectedTabPosition()
            if (r6 != r1) goto L4a
        L48:
            r1 = r3
            goto L4b
        L4a:
            r1 = r2
        L4b:
            int r4 = androidx.core.view.K.v(r5)
            if (r4 != r3) goto L68
            int r1 = r5.getSelectedTabPosition()
            if (r6 >= r1) goto L59
            if (r7 <= r9) goto L70
        L59:
            int r1 = r5.getSelectedTabPosition()
            if (r6 <= r1) goto L61
            if (r7 >= r9) goto L70
        L61:
            int r9 = r5.getSelectedTabPosition()
            if (r6 != r9) goto L6a
            goto L70
        L68:
            if (r1 != 0) goto L70
        L6a:
            int r9 = r5.f23900d0
            if (r9 == r3) goto L70
            if (r10 == 0) goto L76
        L70:
            if (r6 >= 0) goto L73
            r7 = r2
        L73:
            r5.scrollTo(r7, r2)
        L76:
            if (r8 == 0) goto L7b
            r5.setSelectedTabView(r0)
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.O(int, float, boolean, boolean, boolean):void");
    }

    public void P(ViewPager viewPager, boolean z10) {
        Q(viewPager, z10, false);
    }

    public final void Q(ViewPager viewPager, boolean z10, boolean z11) {
        ViewPager viewPager2 = this.f23890U;
        if (viewPager2 != null) {
            h hVar = this.f23894a0;
            if (hVar != null) {
                viewPager2.removeOnPageChangeListener(hVar);
            }
            b bVar = this.f23896b0;
            if (bVar != null) {
                this.f23890U.removeOnAdapterChangeListener(bVar);
            }
        }
        c cVar = this.f23888S;
        if (cVar != null) {
            H(cVar);
            this.f23888S = null;
        }
        if (viewPager != null) {
            this.f23890U = viewPager;
            if (this.f23894a0 == null) {
                this.f23894a0 = new h(this);
            }
            this.f23894a0.a();
            viewPager.addOnPageChangeListener(this.f23894a0);
            j jVar = new j(viewPager);
            this.f23888S = jVar;
            g(jVar);
            androidx.viewpager.widget.a adapter = viewPager.getAdapter();
            if (adapter != null) {
                L(adapter, z10);
            }
            if (this.f23896b0 == null) {
                this.f23896b0 = new b();
            }
            this.f23896b0.a(z10);
            viewPager.addOnAdapterChangeListener(this.f23896b0);
            M(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.f23890U = null;
            L(null, false);
        }
        this.f23898c0 = z11;
    }

    public final void R() {
        int size = this.f23895b.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f23895b.get(i10).s();
        }
    }

    public final void S(LinearLayout.LayoutParams layoutParams) {
        if (this.f23878I == 1 && this.f23875F == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    public void T(boolean z10) {
        for (int i10 = 0; i10 < this.f23899d.getChildCount(); i10++) {
            View childAt = this.f23899d.getChildAt(i10);
            childAt.setMinimumWidth(getTabMinWidth());
            S((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z10) {
                childAt.requestLayout();
            }
        }
    }

    public void U(int i10) {
        this.f23900d0 = i10;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        m(view);
    }

    @Deprecated
    public void g(c cVar) {
        if (!this.f23887R.contains(cVar)) {
            this.f23887R.add(cVar);
        }
    }

    public int getSelectedTabPosition() {
        g gVar = this.f23897c;
        if (gVar != null) {
            return gVar.g();
        }
        return -1;
    }

    public int getTabCount() {
        return this.f23895b.size();
    }

    public int getTabGravity() {
        return this.f23875F;
    }

    public ColorStateList getTabIconTint() {
        return this.f23910m;
    }

    public int getTabIndicatorAnimationMode() {
        return this.f23882M;
    }

    public int getTabIndicatorGravity() {
        return this.f23877H;
    }

    public int getTabMaxWidth() {
        return this.f23870A;
    }

    public int getTabMode() {
        return this.f23878I;
    }

    public ColorStateList getTabRippleColor() {
        return this.f23911n;
    }

    public Drawable getTabSelectedIndicator() {
        return this.f23912o;
    }

    public ColorStateList getTabTextColors() {
        return this.f23909l;
    }

    public void h(g gVar) {
        j(gVar, this.f23895b.isEmpty());
    }

    public void i(g gVar, int i10, boolean z10) {
        if (gVar.f23936h == this) {
            r(gVar, i10);
            l(gVar);
            if (z10) {
                gVar.l();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void j(g gVar, boolean z10) {
        i(gVar, this.f23895b.size(), z10);
    }

    public final void k(TabItem tabItem) {
        g D10 = D();
        CharSequence charSequence = tabItem.f23865a;
        if (charSequence != null) {
            D10.r(charSequence);
        }
        Drawable drawable = tabItem.f23866b;
        if (drawable != null) {
            D10.p(drawable);
        }
        int i10 = tabItem.f23867c;
        if (i10 != 0) {
            D10.n(i10);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            D10.m(tabItem.getContentDescription());
        }
        h(D10);
    }

    public final void l(g gVar) {
        i iVar = gVar.f23937i;
        iVar.setSelected(false);
        iVar.setActivated(false);
        this.f23899d.addView(iVar, gVar.g(), t());
    }

    public final void m(View view) {
        if (view instanceof TabItem) {
            k((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    public final void n(int i10) {
        if (i10 == -1) {
            return;
        }
        if (getWindowToken() != null && K.O(this) && !this.f23899d.d()) {
            int scrollX = getScrollX();
            int q10 = q(i10, 0.0f);
            if (scrollX != q10) {
                z();
                this.f23889T.setIntValues(scrollX, q10);
                this.f23889T.start();
            }
            this.f23899d.c(i10, this.f23876G);
            return;
        }
        M(i10, 0.0f, true);
    }

    public final void o(int i10) {
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    return;
                }
            } else {
                this.f23899d.setGravity(1);
                return;
            }
        } else {
            Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        }
        this.f23899d.setGravity(8388611);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        x4.j.e(this);
        if (this.f23890U == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                Q((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f23898c0) {
            setupWithViewPager(null);
            this.f23898c0 = false;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        for (int i10 = 0; i10 < this.f23899d.getChildCount(); i10++) {
            View childAt = this.f23899d.getChildAt(i10);
            if (childAt instanceof i) {
                ((i) childAt).j(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        J.d.O0(accessibilityNodeInfo).j0(d.e.b(1, getTabCount(), false, 1));
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (B() && super.onInterceptTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int round = Math.round(ViewUtils.dpToPx(getContext(), getDefaultHeight()));
        int mode = View.MeasureSpec.getMode(i11);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i11 = View.MeasureSpec.makeMeasureSpec(round + getPaddingTop() + getPaddingBottom(), 1073741824);
            }
        } else if (getChildCount() == 1 && View.MeasureSpec.getSize(i11) >= round) {
            getChildAt(0).setMinimumHeight(round);
        }
        int size = View.MeasureSpec.getSize(i10);
        if (View.MeasureSpec.getMode(i10) != 0) {
            int i12 = this.f23872C;
            if (i12 <= 0) {
                i12 = (int) (size - ViewUtils.dpToPx(getContext(), 56));
            }
            this.f23870A = i12;
        }
        super.onMeasure(i10, i11);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i13 = this.f23878I;
            if (i13 != 0) {
                if (i13 != 1) {
                    if (i13 != 2) {
                        return;
                    }
                } else {
                    if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                        return;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i11, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
                }
            }
            if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                return;
            }
            childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i11, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 8 && !B()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void p() {
        int max;
        int i10 = this.f23878I;
        if (i10 != 0 && i10 != 2) {
            max = 0;
        } else {
            max = Math.max(0, this.f23874E - this.f23901e);
        }
        K.A0(this.f23899d, max, 0, 0, 0);
        int i11 = this.f23878I;
        if (i11 != 0) {
            if (i11 == 1 || i11 == 2) {
                if (this.f23875F == 2) {
                    Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
                }
                this.f23899d.setGravity(1);
            }
        } else {
            o(this.f23875F);
        }
        T(true);
    }

    public final int q(int i10, float f10) {
        View childAt;
        View view;
        int i11 = this.f23878I;
        int i12 = 0;
        if ((i11 != 0 && i11 != 2) || (childAt = this.f23899d.getChildAt(i10)) == null) {
            return 0;
        }
        int i13 = i10 + 1;
        if (i13 < this.f23899d.getChildCount()) {
            view = this.f23899d.getChildAt(i13);
        } else {
            view = null;
        }
        int width = childAt.getWidth();
        if (view != null) {
            i12 = view.getWidth();
        }
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i14 = (int) ((width + i12) * 0.5f * f10);
        if (K.v(this) == 0) {
            return left + i14;
        }
        return left - i14;
    }

    public final void r(g gVar, int i10) {
        gVar.q(i10);
        this.f23895b.add(i10, gVar);
        int size = this.f23895b.size();
        int i11 = -1;
        for (int i12 = i10 + 1; i12 < size; i12++) {
            if (this.f23895b.get(i12).g() == this.f23893a) {
                i11 = i12;
            }
            this.f23895b.get(i12).q(i12);
        }
        this.f23893a = i11;
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        x4.j.d(this, f10);
    }

    public void setInlineLabel(boolean z10) {
        if (this.f23879J != z10) {
            this.f23879J = z10;
            for (int i10 = 0; i10 < this.f23899d.getChildCount(); i10++) {
                View childAt = this.f23899d.getChildAt(i10);
                if (childAt instanceof i) {
                    ((i) childAt).v();
                }
            }
            p();
        }
    }

    public void setInlineLabelResource(int i10) {
        setInlineLabel(getResources().getBoolean(i10));
    }

    @Deprecated
    public void setOnTabSelectedListener(d dVar) {
        setOnTabSelectedListener((c) dVar);
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        z();
        this.f23889T.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (drawable == null) {
            drawable = new GradientDrawable();
        }
        Drawable mutate = C.a.r(drawable).mutate();
        this.f23912o = mutate;
        C1370a.n(mutate, this.f23913p);
        int i10 = this.f23881L;
        if (i10 == -1) {
            i10 = this.f23912o.getIntrinsicHeight();
        }
        this.f23899d.i(i10);
    }

    public void setSelectedTabIndicatorColor(int i10) {
        this.f23913p = i10;
        C1370a.n(this.f23912o, i10);
        T(false);
    }

    public void setSelectedTabIndicatorGravity(int i10) {
        if (this.f23877H != i10) {
            this.f23877H = i10;
            K.Z(this.f23899d);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i10) {
        this.f23881L = i10;
        this.f23899d.i(i10);
    }

    public void setTabGravity(int i10) {
        if (this.f23875F != i10) {
            this.f23875F = i10;
            p();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.f23910m != colorStateList) {
            this.f23910m = colorStateList;
            R();
        }
    }

    public void setTabIconTintResource(int i10) {
        setTabIconTint(C0991a.a(getContext(), i10));
    }

    public void setTabIndicatorAnimationMode(int i10) {
        this.f23882M = i10;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    this.f23884O = new A4.b();
                    return;
                }
                throw new IllegalArgumentException(i10 + " is not a valid TabIndicatorAnimationMode");
            }
            this.f23884O = new A4.a();
            return;
        }
        this.f23884O = new com.google.android.material.tabs.a();
    }

    public void setTabIndicatorFullWidth(boolean z10) {
        this.f23880K = z10;
        this.f23899d.g();
        K.Z(this.f23899d);
    }

    public void setTabMode(int i10) {
        if (i10 != this.f23878I) {
            this.f23878I = i10;
            p();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.f23911n != colorStateList) {
            this.f23911n = colorStateList;
            for (int i10 = 0; i10 < this.f23899d.getChildCount(); i10++) {
                View childAt = this.f23899d.getChildAt(i10);
                if (childAt instanceof i) {
                    ((i) childAt).u(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int i10) {
        setTabRippleColor(C0991a.a(getContext(), i10));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f23909l != colorStateList) {
            this.f23909l = colorStateList;
            R();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(androidx.viewpager.widget.a aVar) {
        L(aVar, false);
    }

    public void setUnboundedRipple(boolean z10) {
        if (this.f23883N != z10) {
            this.f23883N = z10;
            for (int i10 = 0; i10 < this.f23899d.getChildCount(); i10++) {
                View childAt = this.f23899d.getChildAt(i10);
                if (childAt instanceof i) {
                    ((i) childAt).u(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i10) {
        setUnboundedRipple(getResources().getBoolean(i10));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        P(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        if (getTabScrollRange() > 0) {
            return true;
        }
        return false;
    }

    public final LinearLayout.LayoutParams t() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        S(layoutParams);
        return layoutParams;
    }

    public g u() {
        g b10 = f23869g0.b();
        if (b10 == null) {
            return new g();
        }
        return b10;
    }

    public final i v(g gVar) {
        i iVar;
        I.e<i> eVar = this.f23902e0;
        if (eVar != null) {
            iVar = eVar.b();
        } else {
            iVar = null;
        }
        if (iVar == null) {
            iVar = new i(getContext());
        }
        iVar.setTab(gVar);
        iVar.setFocusable(true);
        iVar.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(gVar.f23932d)) {
            iVar.setContentDescription(gVar.f23931c);
        } else {
            iVar.setContentDescription(gVar.f23932d);
        }
        return iVar;
    }

    public final void w(g gVar) {
        for (int size = this.f23887R.size() - 1; size >= 0; size--) {
            this.f23887R.get(size).a(gVar);
        }
    }

    public final void x(g gVar) {
        for (int size = this.f23887R.size() - 1; size >= 0; size--) {
            this.f23887R.get(size).b(gVar);
        }
    }

    public final void y(g gVar) {
        for (int size = this.f23887R.size() - 1; size >= 0; size--) {
            this.f23887R.get(size).c(gVar);
        }
    }

    public final void z() {
        if (this.f23889T == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f23889T = valueAnimator;
            valueAnimator.setInterpolator(this.f23885P);
            this.f23889T.setDuration(this.f23876G);
            this.f23889T.addUpdateListener(new a());
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public TabLayout(android.content.Context r11, android.util.AttributeSet r12, int r13) {
        /*
            Method dump skipped, instructions count: 532
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i10) {
        m(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(c cVar) {
        c cVar2 = this.f23886Q;
        if (cVar2 != null) {
            H(cVar2);
        }
        this.f23886Q = cVar;
        if (cVar != null) {
            g(cVar);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        m(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        m(view);
    }

    public void setSelectedTabIndicator(int i10) {
        if (i10 != 0) {
            setSelectedTabIndicator(C0991a.b(getContext(), i10));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    /* loaded from: classes3.dex */
    public static class j implements d {

        /* renamed from: a, reason: collision with root package name */
        public final ViewPager f23955a;

        public j(ViewPager viewPager) {
            this.f23955a = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(g gVar) {
            this.f23955a.setCurrentItem(gVar.g());
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(g gVar) {
        }
    }
}
