package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.D;
import androidx.appcompat.widget.InterfaceC0445t;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.K;
import androidx.core.view.Q;
import androidx.core.view.S;
import androidx.core.view.T;
import androidx.core.view.U;
import e.C0961a;
import j.AbstractC1145b;
import j.C1144a;
import j.C1150g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: WindowDecorActionBar.java */
/* loaded from: classes.dex */
public class p extends ActionBar implements ActionBarOverlayLayout.d {

    /* renamed from: E, reason: collision with root package name */
    public static final Interpolator f7415E = new AccelerateInterpolator();

    /* renamed from: F, reason: collision with root package name */
    public static final Interpolator f7416F = new DecelerateInterpolator();

    /* renamed from: A, reason: collision with root package name */
    public boolean f7417A;

    /* renamed from: a, reason: collision with root package name */
    public Context f7421a;

    /* renamed from: b, reason: collision with root package name */
    public Context f7422b;

    /* renamed from: c, reason: collision with root package name */
    public Activity f7423c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarOverlayLayout f7424d;

    /* renamed from: e, reason: collision with root package name */
    public ActionBarContainer f7425e;

    /* renamed from: f, reason: collision with root package name */
    public InterfaceC0445t f7426f;

    /* renamed from: g, reason: collision with root package name */
    public ActionBarContextView f7427g;

    /* renamed from: h, reason: collision with root package name */
    public View f7428h;

    /* renamed from: i, reason: collision with root package name */
    public D f7429i;

    /* renamed from: l, reason: collision with root package name */
    public boolean f7432l;

    /* renamed from: m, reason: collision with root package name */
    public d f7433m;

    /* renamed from: n, reason: collision with root package name */
    public AbstractC1145b f7434n;

    /* renamed from: o, reason: collision with root package name */
    public AbstractC1145b.a f7435o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f7436p;

    /* renamed from: r, reason: collision with root package name */
    public boolean f7438r;

    /* renamed from: u, reason: collision with root package name */
    public boolean f7441u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f7442v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f7443w;

    /* renamed from: y, reason: collision with root package name */
    public j.h f7445y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f7446z;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList<Object> f7430j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    public int f7431k = -1;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList<ActionBar.a> f7437q = new ArrayList<>();

    /* renamed from: s, reason: collision with root package name */
    public int f7439s = 0;

    /* renamed from: t, reason: collision with root package name */
    public boolean f7440t = true;

    /* renamed from: x, reason: collision with root package name */
    public boolean f7444x = true;

    /* renamed from: B, reason: collision with root package name */
    public final S f7418B = new a();

    /* renamed from: C, reason: collision with root package name */
    public final S f7419C = new b();

    /* renamed from: D, reason: collision with root package name */
    public final U f7420D = new c();

    /* compiled from: WindowDecorActionBar.java */
    /* loaded from: classes.dex */
    public class a extends T {
        public a() {
        }

        @Override // androidx.core.view.S
        public void b(View view) {
            View view2;
            p pVar = p.this;
            if (pVar.f7440t && (view2 = pVar.f7428h) != null) {
                view2.setTranslationY(0.0f);
                p.this.f7425e.setTranslationY(0.0f);
            }
            p.this.f7425e.setVisibility(8);
            p.this.f7425e.setTransitioning(false);
            p pVar2 = p.this;
            pVar2.f7445y = null;
            pVar2.G();
            ActionBarOverlayLayout actionBarOverlayLayout = p.this.f7424d;
            if (actionBarOverlayLayout != null) {
                K.f0(actionBarOverlayLayout);
            }
        }
    }

    /* compiled from: WindowDecorActionBar.java */
    /* loaded from: classes.dex */
    public class b extends T {
        public b() {
        }

        @Override // androidx.core.view.S
        public void b(View view) {
            p pVar = p.this;
            pVar.f7445y = null;
            pVar.f7425e.requestLayout();
        }
    }

    /* compiled from: WindowDecorActionBar.java */
    /* loaded from: classes.dex */
    public class c implements U {
        public c() {
        }

        @Override // androidx.core.view.U
        public void a(View view) {
            ((View) p.this.f7425e.getParent()).invalidate();
        }
    }

    /* compiled from: WindowDecorActionBar.java */
    /* loaded from: classes.dex */
    public class d extends AbstractC1145b implements MenuBuilder.Callback {

        /* renamed from: c, reason: collision with root package name */
        public final Context f7450c;

        /* renamed from: d, reason: collision with root package name */
        public final MenuBuilder f7451d;

        /* renamed from: e, reason: collision with root package name */
        public AbstractC1145b.a f7452e;

        /* renamed from: f, reason: collision with root package name */
        public WeakReference<View> f7453f;

        public d(Context context, AbstractC1145b.a aVar) {
            this.f7450c = context;
            this.f7452e = aVar;
            MenuBuilder defaultShowAsAction = new MenuBuilder(context).setDefaultShowAsAction(1);
            this.f7451d = defaultShowAsAction;
            defaultShowAsAction.setCallback(this);
        }

        @Override // j.AbstractC1145b
        public void a() {
            p pVar = p.this;
            if (pVar.f7433m != this) {
                return;
            }
            if (!p.F(pVar.f7441u, pVar.f7442v, false)) {
                p pVar2 = p.this;
                pVar2.f7434n = this;
                pVar2.f7435o = this.f7452e;
            } else {
                this.f7452e.b(this);
            }
            this.f7452e = null;
            p.this.E(false);
            p.this.f7427g.g();
            p pVar3 = p.this;
            pVar3.f7424d.setHideOnContentScrollEnabled(pVar3.f7417A);
            p.this.f7433m = null;
        }

        @Override // j.AbstractC1145b
        public View b() {
            WeakReference<View> weakReference = this.f7453f;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // j.AbstractC1145b
        public Menu c() {
            return this.f7451d;
        }

        @Override // j.AbstractC1145b
        public MenuInflater d() {
            return new C1150g(this.f7450c);
        }

        @Override // j.AbstractC1145b
        public CharSequence e() {
            return p.this.f7427g.getSubtitle();
        }

        @Override // j.AbstractC1145b
        public CharSequence g() {
            return p.this.f7427g.getTitle();
        }

        @Override // j.AbstractC1145b
        public void i() {
            if (p.this.f7433m != this) {
                return;
            }
            this.f7451d.stopDispatchingItemsChanged();
            try {
                this.f7452e.d(this, this.f7451d);
            } finally {
                this.f7451d.startDispatchingItemsChanged();
            }
        }

        @Override // j.AbstractC1145b
        public boolean j() {
            return p.this.f7427g.j();
        }

        @Override // j.AbstractC1145b
        public void k(View view) {
            p.this.f7427g.setCustomView(view);
            this.f7453f = new WeakReference<>(view);
        }

        @Override // j.AbstractC1145b
        public void l(int i10) {
            m(p.this.f7421a.getResources().getString(i10));
        }

        @Override // j.AbstractC1145b
        public void m(CharSequence charSequence) {
            p.this.f7427g.setSubtitle(charSequence);
        }

        @Override // j.AbstractC1145b
        public void o(int i10) {
            p(p.this.f7421a.getResources().getString(i10));
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            AbstractC1145b.a aVar = this.f7452e;
            if (aVar != null) {
                return aVar.c(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (this.f7452e == null) {
                return;
            }
            i();
            p.this.f7427g.l();
        }

        @Override // j.AbstractC1145b
        public void p(CharSequence charSequence) {
            p.this.f7427g.setTitle(charSequence);
        }

        @Override // j.AbstractC1145b
        public void q(boolean z10) {
            super.q(z10);
            p.this.f7427g.setTitleOptional(z10);
        }

        public boolean r() {
            this.f7451d.stopDispatchingItemsChanged();
            try {
                return this.f7452e.a(this, this.f7451d);
            } finally {
                this.f7451d.startDispatchingItemsChanged();
            }
        }
    }

    public p(Activity activity, boolean z10) {
        this.f7423c = activity;
        View decorView = activity.getWindow().getDecorView();
        M(decorView);
        if (z10) {
            return;
        }
        this.f7428h = decorView.findViewById(R.id.content);
    }

    public static boolean F(boolean z10, boolean z11, boolean z12) {
        if (z12) {
            return true;
        }
        if (!z10 && !z11) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void A(CharSequence charSequence) {
        this.f7426f.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void B(CharSequence charSequence) {
        this.f7426f.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void C() {
        if (this.f7441u) {
            this.f7441u = false;
            T(false);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public AbstractC1145b D(AbstractC1145b.a aVar) {
        d dVar = this.f7433m;
        if (dVar != null) {
            dVar.a();
        }
        this.f7424d.setHideOnContentScrollEnabled(false);
        this.f7427g.k();
        d dVar2 = new d(this.f7427g.getContext(), aVar);
        if (dVar2.r()) {
            this.f7433m = dVar2;
            dVar2.i();
            this.f7427g.h(dVar2);
            E(true);
            return dVar2;
        }
        return null;
    }

    public void E(boolean z10) {
        Q f10;
        Q q10;
        if (z10) {
            S();
        } else {
            L();
        }
        if (R()) {
            if (z10) {
                f10 = this.f7426f.o(4, 100L);
                q10 = this.f7427g.f(0, 200L);
            } else {
                Q o10 = this.f7426f.o(0, 200L);
                f10 = this.f7427g.f(8, 100L);
                q10 = o10;
            }
            j.h hVar = new j.h();
            hVar.d(f10, q10);
            hVar.h();
            return;
        }
        if (z10) {
            this.f7426f.setVisibility(4);
            this.f7427g.setVisibility(0);
        } else {
            this.f7426f.setVisibility(0);
            this.f7427g.setVisibility(8);
        }
    }

    public void G() {
        AbstractC1145b.a aVar = this.f7435o;
        if (aVar != null) {
            aVar.b(this.f7434n);
            this.f7434n = null;
            this.f7435o = null;
        }
    }

    public void H(boolean z10) {
        View view;
        j.h hVar = this.f7445y;
        if (hVar != null) {
            hVar.a();
        }
        if (this.f7439s == 0 && (this.f7446z || z10)) {
            this.f7425e.setAlpha(1.0f);
            this.f7425e.setTransitioning(true);
            j.h hVar2 = new j.h();
            float f10 = -this.f7425e.getHeight();
            if (z10) {
                this.f7425e.getLocationInWindow(new int[]{0, 0});
                f10 -= r5[1];
            }
            Q n10 = K.d(this.f7425e).n(f10);
            n10.l(this.f7420D);
            hVar2.c(n10);
            if (this.f7440t && (view = this.f7428h) != null) {
                hVar2.c(K.d(view).n(f10));
            }
            hVar2.f(f7415E);
            hVar2.e(250L);
            hVar2.g(this.f7418B);
            this.f7445y = hVar2;
            hVar2.h();
            return;
        }
        this.f7418B.b(null);
    }

    public void I(boolean z10) {
        View view;
        View view2;
        j.h hVar = this.f7445y;
        if (hVar != null) {
            hVar.a();
        }
        this.f7425e.setVisibility(0);
        if (this.f7439s == 0 && (this.f7446z || z10)) {
            this.f7425e.setTranslationY(0.0f);
            float f10 = -this.f7425e.getHeight();
            if (z10) {
                this.f7425e.getLocationInWindow(new int[]{0, 0});
                f10 -= r5[1];
            }
            this.f7425e.setTranslationY(f10);
            j.h hVar2 = new j.h();
            Q n10 = K.d(this.f7425e).n(0.0f);
            n10.l(this.f7420D);
            hVar2.c(n10);
            if (this.f7440t && (view2 = this.f7428h) != null) {
                view2.setTranslationY(f10);
                hVar2.c(K.d(this.f7428h).n(0.0f));
            }
            hVar2.f(f7416F);
            hVar2.e(250L);
            hVar2.g(this.f7419C);
            this.f7445y = hVar2;
            hVar2.h();
        } else {
            this.f7425e.setAlpha(1.0f);
            this.f7425e.setTranslationY(0.0f);
            if (this.f7440t && (view = this.f7428h) != null) {
                view.setTranslationY(0.0f);
            }
            this.f7419C.b(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f7424d;
        if (actionBarOverlayLayout != null) {
            K.f0(actionBarOverlayLayout);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final InterfaceC0445t J(View view) {
        String str;
        if (view instanceof InterfaceC0445t) {
            return (InterfaceC0445t) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        if (view != 0) {
            str = view.getClass().getSimpleName();
        } else {
            str = "null";
        }
        sb.append(str);
        throw new IllegalStateException(sb.toString());
    }

    public int K() {
        return this.f7426f.n();
    }

    public final void L() {
        if (this.f7443w) {
            this.f7443w = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f7424d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            T(false);
        }
    }

    public final void M(View view) {
        boolean z10;
        boolean z11;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(e.f.f30230q);
        this.f7424d = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f7426f = J(view.findViewById(e.f.f30214a));
        this.f7427g = (ActionBarContextView) view.findViewById(e.f.f30219f);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(e.f.f30216c);
        this.f7425e = actionBarContainer;
        InterfaceC0445t interfaceC0445t = this.f7426f;
        if (interfaceC0445t != null && this.f7427g != null && actionBarContainer != null) {
            this.f7421a = interfaceC0445t.getContext();
            if ((this.f7426f.s() & 4) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                this.f7432l = true;
            }
            C1144a b10 = C1144a.b(this.f7421a);
            if (!b10.a() && !z10) {
                z11 = false;
            } else {
                z11 = true;
            }
            Q(z11);
            O(b10.g());
            TypedArray obtainStyledAttributes = this.f7421a.obtainStyledAttributes(null, e.j.f30412a, C0961a.f30104c, 0);
            if (obtainStyledAttributes.getBoolean(e.j.f30465k, false)) {
                P(true);
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(e.j.f30455i, 0);
            if (dimensionPixelSize != 0) {
                N(dimensionPixelSize);
            }
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
    }

    public void N(float f10) {
        K.r0(this.f7425e, f10);
    }

    public final void O(boolean z10) {
        boolean z11;
        boolean z12;
        this.f7438r = z10;
        if (!z10) {
            this.f7426f.i(null);
            this.f7425e.setTabContainer(this.f7429i);
        } else {
            this.f7425e.setTabContainer(null);
            this.f7426f.i(this.f7429i);
        }
        boolean z13 = true;
        if (K() == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        D d10 = this.f7429i;
        if (d10 != null) {
            if (z11) {
                d10.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f7424d;
                if (actionBarOverlayLayout != null) {
                    K.f0(actionBarOverlayLayout);
                }
            } else {
                d10.setVisibility(8);
            }
        }
        InterfaceC0445t interfaceC0445t = this.f7426f;
        if (!this.f7438r && z11) {
            z12 = true;
        } else {
            z12 = false;
        }
        interfaceC0445t.v(z12);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f7424d;
        if (this.f7438r || !z11) {
            z13 = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z13);
    }

    public void P(boolean z10) {
        if (z10 && !this.f7424d.r()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.f7417A = z10;
        this.f7424d.setHideOnContentScrollEnabled(z10);
    }

    public void Q(boolean z10) {
        this.f7426f.r(z10);
    }

    public final boolean R() {
        return this.f7425e.isLaidOut();
    }

    public final void S() {
        if (!this.f7443w) {
            this.f7443w = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f7424d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            T(false);
        }
    }

    public final void T(boolean z10) {
        if (F(this.f7441u, this.f7442v, this.f7443w)) {
            if (!this.f7444x) {
                this.f7444x = true;
                I(z10);
                return;
            }
            return;
        }
        if (this.f7444x) {
            this.f7444x = false;
            H(z10);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a() {
        if (this.f7442v) {
            this.f7442v = false;
            T(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c(boolean z10) {
        this.f7440t = z10;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d() {
        if (!this.f7442v) {
            this.f7442v = true;
            T(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void e() {
        j.h hVar = this.f7445y;
        if (hVar != null) {
            hVar.a();
            this.f7445y = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void f(int i10) {
        this.f7439s = i10;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean h() {
        InterfaceC0445t interfaceC0445t = this.f7426f;
        if (interfaceC0445t != null && interfaceC0445t.j()) {
            this.f7426f.collapseActionView();
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void i(boolean z10) {
        if (z10 == this.f7436p) {
            return;
        }
        this.f7436p = z10;
        int size = this.f7437q.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f7437q.get(i10).a(z10);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public int j() {
        return this.f7426f.s();
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context k() {
        if (this.f7422b == null) {
            TypedValue typedValue = new TypedValue();
            this.f7421a.getTheme().resolveAttribute(C0961a.f30108g, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                this.f7422b = new ContextThemeWrapper(this.f7421a, i10);
            } else {
                this.f7422b = this.f7421a;
            }
        }
        return this.f7422b;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void l() {
        if (!this.f7441u) {
            this.f7441u = true;
            T(false);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void n(Configuration configuration) {
        O(C1144a.b(this.f7421a).g());
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean p(int i10, KeyEvent keyEvent) {
        Menu c10;
        int i11;
        d dVar = this.f7433m;
        if (dVar == null || (c10 = dVar.c()) == null) {
            return false;
        }
        if (keyEvent != null) {
            i11 = keyEvent.getDeviceId();
        } else {
            i11 = -1;
        }
        boolean z10 = true;
        if (KeyCharacterMap.load(i11).getKeyboardType() == 1) {
            z10 = false;
        }
        c10.setQwertyMode(z10);
        return c10.performShortcut(i10, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void s(boolean z10) {
        if (!this.f7432l) {
            t(z10);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void t(boolean z10) {
        int i10;
        if (z10) {
            i10 = 4;
        } else {
            i10 = 0;
        }
        v(i10, 4);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void u(int i10) {
        if ((i10 & 4) != 0) {
            this.f7432l = true;
        }
        this.f7426f.k(i10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void v(int i10, int i11) {
        int s10 = this.f7426f.s();
        if ((i11 & 4) != 0) {
            this.f7432l = true;
        }
        this.f7426f.k((i10 & i11) | ((~i11) & s10));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void w(boolean z10) {
        int i10;
        if (z10) {
            i10 = 2;
        } else {
            i10 = 0;
        }
        v(i10, 2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void x(boolean z10) {
        int i10;
        if (z10) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        v(i10, 8);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void y(boolean z10) {
        j.h hVar;
        this.f7446z = z10;
        if (!z10 && (hVar = this.f7445y) != null) {
            hVar.a();
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void z(int i10) {
        A(this.f7421a.getString(i10));
    }

    public p(Dialog dialog) {
        M(dialog.getWindow().getDecorView());
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b() {
    }
}
