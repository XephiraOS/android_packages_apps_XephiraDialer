package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.Toolbar;
import e.C0961a;
import f.C0991a;

/* compiled from: ToolbarWidgetWrapper.java */
/* loaded from: classes.dex */
public class O implements InterfaceC0445t {

    /* renamed from: a, reason: collision with root package name */
    public Toolbar f7769a;

    /* renamed from: b, reason: collision with root package name */
    public int f7770b;

    /* renamed from: c, reason: collision with root package name */
    public View f7771c;

    /* renamed from: d, reason: collision with root package name */
    public View f7772d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f7773e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f7774f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable f7775g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f7776h;

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f7777i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f7778j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f7779k;

    /* renamed from: l, reason: collision with root package name */
    public Window.Callback f7780l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f7781m;

    /* renamed from: n, reason: collision with root package name */
    public ActionMenuPresenter f7782n;

    /* renamed from: o, reason: collision with root package name */
    public int f7783o;

    /* renamed from: p, reason: collision with root package name */
    public int f7784p;

    /* renamed from: q, reason: collision with root package name */
    public Drawable f7785q;

    /* compiled from: ToolbarWidgetWrapper.java */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final ActionMenuItem f7786a;

        public a() {
            this.f7786a = new ActionMenuItem(O.this.f7769a.getContext(), 0, R.id.home, 0, 0, O.this.f7777i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            O o10 = O.this;
            Window.Callback callback = o10.f7780l;
            if (callback != null && o10.f7781m) {
                callback.onMenuItemSelected(0, this.f7786a);
            }
        }
    }

    /* compiled from: ToolbarWidgetWrapper.java */
    /* loaded from: classes.dex */
    public class b extends androidx.core.view.T {

        /* renamed from: a, reason: collision with root package name */
        public boolean f7788a = false;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f7789b;

        public b(int i10) {
            this.f7789b = i10;
        }

        @Override // androidx.core.view.T, androidx.core.view.S
        public void a(View view) {
            this.f7788a = true;
        }

        @Override // androidx.core.view.S
        public void b(View view) {
            if (!this.f7788a) {
                O.this.f7769a.setVisibility(this.f7789b);
            }
        }

        @Override // androidx.core.view.T, androidx.core.view.S
        public void c(View view) {
            O.this.f7769a.setVisibility(0);
        }
    }

    public O(Toolbar toolbar, boolean z10) {
        this(toolbar, z10, e.h.f30261a, e.e.f30180n);
    }

    public void A(int i10) {
        String string;
        if (i10 == 0) {
            string = null;
        } else {
            string = getContext().getString(i10);
        }
        B(string);
    }

    public void B(CharSequence charSequence) {
        this.f7779k = charSequence;
        F();
    }

    public void C(Drawable drawable) {
        this.f7775g = drawable;
        G();
    }

    public void D(CharSequence charSequence) {
        this.f7778j = charSequence;
        if ((this.f7770b & 8) != 0) {
            this.f7769a.setSubtitle(charSequence);
        }
    }

    public final void E(CharSequence charSequence) {
        this.f7777i = charSequence;
        if ((this.f7770b & 8) != 0) {
            this.f7769a.setTitle(charSequence);
            if (this.f7776h) {
                androidx.core.view.K.m0(this.f7769a.getRootView(), charSequence);
            }
        }
    }

    public final void F() {
        if ((this.f7770b & 4) != 0) {
            if (TextUtils.isEmpty(this.f7779k)) {
                this.f7769a.setNavigationContentDescription(this.f7784p);
            } else {
                this.f7769a.setNavigationContentDescription(this.f7779k);
            }
        }
    }

    public final void G() {
        if ((this.f7770b & 4) != 0) {
            Toolbar toolbar = this.f7769a;
            Drawable drawable = this.f7775g;
            if (drawable == null) {
                drawable = this.f7785q;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f7769a.setNavigationIcon((Drawable) null);
    }

    public final void H() {
        Drawable drawable;
        int i10 = this.f7770b;
        if ((i10 & 2) != 0) {
            if ((i10 & 1) != 0) {
                drawable = this.f7774f;
                if (drawable == null) {
                    drawable = this.f7773e;
                }
            } else {
                drawable = this.f7773e;
            }
        } else {
            drawable = null;
        }
        this.f7769a.setLogo(drawable);
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public void a(Menu menu, MenuPresenter.Callback callback) {
        if (this.f7782n == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.f7769a.getContext());
            this.f7782n = actionMenuPresenter;
            actionMenuPresenter.setId(e.f.f30220g);
        }
        this.f7782n.setCallback(callback);
        this.f7769a.setMenu((MenuBuilder) menu, this.f7782n);
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public boolean b() {
        return this.f7769a.isOverflowMenuShowing();
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public void c() {
        this.f7781m = true;
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public void collapseActionView() {
        this.f7769a.collapseActionView();
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public boolean d() {
        return this.f7769a.canShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public boolean e() {
        return this.f7769a.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public boolean f() {
        return this.f7769a.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public boolean g() {
        return this.f7769a.showOverflowMenu();
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public Context getContext() {
        return this.f7769a.getContext();
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public CharSequence getTitle() {
        return this.f7769a.getTitle();
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public void h() {
        this.f7769a.dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public void i(D d10) {
        View view = this.f7771c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f7769a;
            if (parent == toolbar) {
                toolbar.removeView(this.f7771c);
            }
        }
        this.f7771c = d10;
        if (d10 != null && this.f7783o == 2) {
            this.f7769a.addView(d10, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f7771c.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
            layoutParams.gravity = 8388691;
            d10.setAllowCollapse(true);
        }
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public boolean j() {
        return this.f7769a.hasExpandedActionView();
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public void k(int i10) {
        View view;
        int i11 = this.f7770b ^ i10;
        this.f7770b = i10;
        if (i11 != 0) {
            if ((i11 & 4) != 0) {
                if ((i10 & 4) != 0) {
                    F();
                }
                G();
            }
            if ((i11 & 3) != 0) {
                H();
            }
            if ((i11 & 8) != 0) {
                if ((i10 & 8) != 0) {
                    this.f7769a.setTitle(this.f7777i);
                    this.f7769a.setSubtitle(this.f7778j);
                } else {
                    this.f7769a.setTitle((CharSequence) null);
                    this.f7769a.setSubtitle((CharSequence) null);
                }
            }
            if ((i11 & 16) != 0 && (view = this.f7772d) != null) {
                if ((i10 & 16) != 0) {
                    this.f7769a.addView(view);
                } else {
                    this.f7769a.removeView(view);
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public Menu l() {
        return this.f7769a.getMenu();
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public void m(int i10) {
        Drawable drawable;
        if (i10 != 0) {
            drawable = C0991a.b(getContext(), i10);
        } else {
            drawable = null;
        }
        z(drawable);
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public int n() {
        return this.f7783o;
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public androidx.core.view.Q o(int i10, long j10) {
        float f10;
        androidx.core.view.Q d10 = androidx.core.view.K.d(this.f7769a);
        if (i10 == 0) {
            f10 = 1.0f;
        } else {
            f10 = 0.0f;
        }
        return d10.b(f10).g(j10).i(new b(i10));
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public void p(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.f7769a.setMenuCallbacks(callback, callback2);
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public ViewGroup q() {
        return this.f7769a;
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public int s() {
        return this.f7770b;
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public void setIcon(int i10) {
        setIcon(i10 != 0 ? C0991a.b(getContext(), i10) : null);
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public void setTitle(CharSequence charSequence) {
        this.f7776h = true;
        E(charSequence);
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public void setVisibility(int i10) {
        this.f7769a.setVisibility(i10);
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public void setWindowCallback(Window.Callback callback) {
        this.f7780l = callback;
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public void setWindowTitle(CharSequence charSequence) {
        if (!this.f7776h) {
            E(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public void t() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public void u() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public void v(boolean z10) {
        this.f7769a.setCollapsible(z10);
    }

    public final int w() {
        if (this.f7769a.getNavigationIcon() != null) {
            this.f7785q = this.f7769a.getNavigationIcon();
            return 15;
        }
        return 11;
    }

    public void x(View view) {
        View view2 = this.f7772d;
        if (view2 != null && (this.f7770b & 16) != 0) {
            this.f7769a.removeView(view2);
        }
        this.f7772d = view;
        if (view != null && (this.f7770b & 16) != 0) {
            this.f7769a.addView(view);
        }
    }

    public void y(int i10) {
        if (i10 == this.f7784p) {
            return;
        }
        this.f7784p = i10;
        if (TextUtils.isEmpty(this.f7769a.getNavigationContentDescription())) {
            A(this.f7784p);
        }
    }

    public void z(Drawable drawable) {
        this.f7774f = drawable;
        H();
    }

    public O(Toolbar toolbar, boolean z10, int i10, int i11) {
        Drawable drawable;
        this.f7783o = 0;
        this.f7784p = 0;
        this.f7769a = toolbar;
        this.f7777i = toolbar.getTitle();
        this.f7778j = toolbar.getSubtitle();
        this.f7776h = this.f7777i != null;
        this.f7775g = toolbar.getNavigationIcon();
        K w10 = K.w(toolbar.getContext(), null, e.j.f30412a, C0961a.f30104c, 0);
        this.f7785q = w10.g(e.j.f30470l);
        if (z10) {
            CharSequence p10 = w10.p(e.j.f30500r);
            if (!TextUtils.isEmpty(p10)) {
                setTitle(p10);
            }
            CharSequence p11 = w10.p(e.j.f30490p);
            if (!TextUtils.isEmpty(p11)) {
                D(p11);
            }
            Drawable g10 = w10.g(e.j.f30480n);
            if (g10 != null) {
                z(g10);
            }
            Drawable g11 = w10.g(e.j.f30475m);
            if (g11 != null) {
                setIcon(g11);
            }
            if (this.f7775g == null && (drawable = this.f7785q) != null) {
                C(drawable);
            }
            k(w10.k(e.j.f30450h, 0));
            int n10 = w10.n(e.j.f30445g, 0);
            if (n10 != 0) {
                x(LayoutInflater.from(this.f7769a.getContext()).inflate(n10, (ViewGroup) this.f7769a, false));
                k(this.f7770b | 16);
            }
            int m10 = w10.m(e.j.f30460j, 0);
            if (m10 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f7769a.getLayoutParams();
                layoutParams.height = m10;
                this.f7769a.setLayoutParams(layoutParams);
            }
            int e10 = w10.e(e.j.f30440f, -1);
            int e11 = w10.e(e.j.f30435e, -1);
            if (e10 >= 0 || e11 >= 0) {
                this.f7769a.setContentInsetsRelative(Math.max(e10, 0), Math.max(e11, 0));
            }
            int n11 = w10.n(e.j.f30505s, 0);
            if (n11 != 0) {
                Toolbar toolbar2 = this.f7769a;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), n11);
            }
            int n12 = w10.n(e.j.f30495q, 0);
            if (n12 != 0) {
                Toolbar toolbar3 = this.f7769a;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), n12);
            }
            int n13 = w10.n(e.j.f30485o, 0);
            if (n13 != 0) {
                this.f7769a.setPopupTheme(n13);
            }
        } else {
            this.f7770b = w();
        }
        w10.y();
        y(i10);
        this.f7779k = this.f7769a.getNavigationContentDescription();
        this.f7769a.setNavigationOnClickListener(new a());
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public void setIcon(Drawable drawable) {
        this.f7773e = drawable;
        H();
    }

    @Override // androidx.appcompat.widget.InterfaceC0445t
    public void r(boolean z10) {
    }
}
