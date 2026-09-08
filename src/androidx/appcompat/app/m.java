package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.InterfaceC0445t;
import androidx.appcompat.widget.O;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.K;
import java.util.ArrayList;

/* compiled from: ToolbarActionBar.java */
/* loaded from: classes.dex */
public class m extends ActionBar {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0445t f7390a;

    /* renamed from: b, reason: collision with root package name */
    public final Window.Callback f7391b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatDelegateImpl.g f7392c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7393d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7394e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7395f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<ActionBar.a> f7396g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    public final Runnable f7397h = new a();

    /* renamed from: i, reason: collision with root package name */
    public final Toolbar.g f7398i;

    /* compiled from: ToolbarActionBar.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.F();
        }
    }

    /* compiled from: ToolbarActionBar.java */
    /* loaded from: classes.dex */
    public class b implements Toolbar.g {
        public b() {
        }

        @Override // androidx.appcompat.widget.Toolbar.g
        public boolean onMenuItemClick(MenuItem menuItem) {
            return m.this.f7391b.onMenuItemSelected(0, menuItem);
        }
    }

    /* compiled from: ToolbarActionBar.java */
    /* loaded from: classes.dex */
    public final class c implements MenuPresenter.Callback {

        /* renamed from: a, reason: collision with root package name */
        public boolean f7401a;

        public c() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z10) {
            if (this.f7401a) {
                return;
            }
            this.f7401a = true;
            m.this.f7390a.h();
            m.this.f7391b.onPanelClosed(108, menuBuilder);
            this.f7401a = false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            m.this.f7391b.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    /* compiled from: ToolbarActionBar.java */
    /* loaded from: classes.dex */
    public final class d implements MenuBuilder.Callback {
        public d() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (m.this.f7390a.b()) {
                m.this.f7391b.onPanelClosed(108, menuBuilder);
            } else if (m.this.f7391b.onPreparePanel(0, null, menuBuilder)) {
                m.this.f7391b.onMenuOpened(108, menuBuilder);
            }
        }
    }

    /* compiled from: ToolbarActionBar.java */
    /* loaded from: classes.dex */
    public class e implements AppCompatDelegateImpl.g {
        public e() {
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.g
        public boolean a(int i10) {
            if (i10 == 0) {
                m mVar = m.this;
                if (!mVar.f7393d) {
                    mVar.f7390a.c();
                    m.this.f7393d = true;
                    return false;
                }
                return false;
            }
            return false;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.g
        public View onCreatePanelView(int i10) {
            if (i10 == 0) {
                return new View(m.this.f7390a.getContext());
            }
            return null;
        }
    }

    public m(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        b bVar = new b();
        this.f7398i = bVar;
        I.h.e(toolbar);
        O o10 = new O(toolbar, false);
        this.f7390a = o10;
        this.f7391b = (Window.Callback) I.h.e(callback);
        o10.setWindowCallback(callback);
        toolbar.setOnMenuItemClickListener(bVar);
        o10.setWindowTitle(charSequence);
        this.f7392c = new e();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void A(CharSequence charSequence) {
        this.f7390a.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void B(CharSequence charSequence) {
        this.f7390a.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void C() {
        this.f7390a.setVisibility(0);
    }

    public final Menu E() {
        if (!this.f7394e) {
            this.f7390a.p(new c(), new d());
            this.f7394e = true;
        }
        return this.f7390a.l();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void F() {
        /*
            r5 = this;
            android.view.Menu r0 = r5.E()
            boolean r1 = r0 instanceof androidx.appcompat.view.menu.MenuBuilder
            r2 = 0
            if (r1 == 0) goto Ld
            r1 = r0
            androidx.appcompat.view.menu.MenuBuilder r1 = (androidx.appcompat.view.menu.MenuBuilder) r1
            goto Le
        Ld:
            r1 = r2
        Le:
            if (r1 == 0) goto L13
            r1.stopDispatchingItemsChanged()
        L13:
            r0.clear()     // Catch: java.lang.Throwable -> L28
            android.view.Window$Callback r3 = r5.f7391b     // Catch: java.lang.Throwable -> L28
            r4 = 0
            boolean r3 = r3.onCreatePanelMenu(r4, r0)     // Catch: java.lang.Throwable -> L28
            if (r3 == 0) goto L2a
            android.view.Window$Callback r5 = r5.f7391b     // Catch: java.lang.Throwable -> L28
            boolean r5 = r5.onPreparePanel(r4, r2, r0)     // Catch: java.lang.Throwable -> L28
            if (r5 != 0) goto L2d
            goto L2a
        L28:
            r5 = move-exception
            goto L33
        L2a:
            r0.clear()     // Catch: java.lang.Throwable -> L28
        L2d:
            if (r1 == 0) goto L32
            r1.startDispatchingItemsChanged()
        L32:
            return
        L33:
            if (r1 == 0) goto L38
            r1.startDispatchingItemsChanged()
        L38:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.m.F():void");
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean g() {
        return this.f7390a.f();
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean h() {
        if (this.f7390a.j()) {
            this.f7390a.collapseActionView();
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void i(boolean z10) {
        if (z10 == this.f7395f) {
            return;
        }
        this.f7395f = z10;
        int size = this.f7396g.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f7396g.get(i10).a(z10);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public int j() {
        return this.f7390a.s();
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context k() {
        return this.f7390a.getContext();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void l() {
        this.f7390a.setVisibility(8);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean m() {
        this.f7390a.q().removeCallbacks(this.f7397h);
        K.a0(this.f7390a.q(), this.f7397h);
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void n(Configuration configuration) {
        super.n(configuration);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void o() {
        this.f7390a.q().removeCallbacks(this.f7397h);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean p(int i10, KeyEvent keyEvent) {
        int i11;
        Menu E10 = E();
        if (E10 == null) {
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
        E10.setQwertyMode(z10);
        return E10.performShortcut(i10, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean q(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            r();
        }
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean r() {
        return this.f7390a.g();
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
        v(i10, -1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void v(int i10, int i11) {
        this.f7390a.k((i10 & i11) | ((~i11) & this.f7390a.s()));
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
    public void z(int i10) {
        CharSequence charSequence;
        InterfaceC0445t interfaceC0445t = this.f7390a;
        if (i10 != 0) {
            charSequence = interfaceC0445t.getContext().getText(i10);
        } else {
            charSequence = null;
        }
        interfaceC0445t.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void s(boolean z10) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void y(boolean z10) {
    }
}
