package j;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import j.AbstractC1145b;
import java.lang.ref.WeakReference;

/* compiled from: StandaloneActionMode.java */
/* renamed from: j.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1148e extends AbstractC1145b implements MenuBuilder.Callback {

    /* renamed from: c, reason: collision with root package name */
    public Context f33680c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContextView f33681d;

    /* renamed from: e, reason: collision with root package name */
    public AbstractC1145b.a f33682e;

    /* renamed from: f, reason: collision with root package name */
    public WeakReference<View> f33683f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f33684g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f33685h;

    /* renamed from: i, reason: collision with root package name */
    public MenuBuilder f33686i;

    public C1148e(Context context, ActionBarContextView actionBarContextView, AbstractC1145b.a aVar, boolean z10) {
        this.f33680c = context;
        this.f33681d = actionBarContextView;
        this.f33682e = aVar;
        MenuBuilder defaultShowAsAction = new MenuBuilder(actionBarContextView.getContext()).setDefaultShowAsAction(1);
        this.f33686i = defaultShowAsAction;
        defaultShowAsAction.setCallback(this);
        this.f33685h = z10;
    }

    @Override // j.AbstractC1145b
    public void a() {
        if (this.f33684g) {
            return;
        }
        this.f33684g = true;
        this.f33682e.b(this);
    }

    @Override // j.AbstractC1145b
    public View b() {
        WeakReference<View> weakReference = this.f33683f;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // j.AbstractC1145b
    public Menu c() {
        return this.f33686i;
    }

    @Override // j.AbstractC1145b
    public MenuInflater d() {
        return new C1150g(this.f33681d.getContext());
    }

    @Override // j.AbstractC1145b
    public CharSequence e() {
        return this.f33681d.getSubtitle();
    }

    @Override // j.AbstractC1145b
    public CharSequence g() {
        return this.f33681d.getTitle();
    }

    @Override // j.AbstractC1145b
    public void i() {
        this.f33682e.d(this, this.f33686i);
    }

    @Override // j.AbstractC1145b
    public boolean j() {
        return this.f33681d.j();
    }

    @Override // j.AbstractC1145b
    public void k(View view) {
        WeakReference<View> weakReference;
        this.f33681d.setCustomView(view);
        if (view != null) {
            weakReference = new WeakReference<>(view);
        } else {
            weakReference = null;
        }
        this.f33683f = weakReference;
    }

    @Override // j.AbstractC1145b
    public void l(int i10) {
        m(this.f33680c.getString(i10));
    }

    @Override // j.AbstractC1145b
    public void m(CharSequence charSequence) {
        this.f33681d.setSubtitle(charSequence);
    }

    @Override // j.AbstractC1145b
    public void o(int i10) {
        p(this.f33680c.getString(i10));
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.f33682e.c(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(MenuBuilder menuBuilder) {
        i();
        this.f33681d.l();
    }

    @Override // j.AbstractC1145b
    public void p(CharSequence charSequence) {
        this.f33681d.setTitle(charSequence);
    }

    @Override // j.AbstractC1145b
    public void q(boolean z10) {
        super.q(z10);
        this.f33681d.setTitleOptional(z10);
    }
}
