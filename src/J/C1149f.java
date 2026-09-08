package j;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuWrapperICS;
import j.AbstractC1145b;
import java.util.ArrayList;

/* compiled from: SupportActionModeWrapper.java */
/* renamed from: j.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1149f extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    public final Context f33687a;

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC1145b f33688b;

    /* compiled from: SupportActionModeWrapper.java */
    /* renamed from: j.f$a */
    /* loaded from: classes.dex */
    public static class a implements AbstractC1145b.a {

        /* renamed from: a, reason: collision with root package name */
        public final ActionMode.Callback f33689a;

        /* renamed from: b, reason: collision with root package name */
        public final Context f33690b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList<C1149f> f33691c = new ArrayList<>();

        /* renamed from: d, reason: collision with root package name */
        public final p.i<Menu, Menu> f33692d = new p.i<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f33690b = context;
            this.f33689a = callback;
        }

        @Override // j.AbstractC1145b.a
        public boolean a(AbstractC1145b abstractC1145b, Menu menu) {
            return this.f33689a.onCreateActionMode(e(abstractC1145b), f(menu));
        }

        @Override // j.AbstractC1145b.a
        public void b(AbstractC1145b abstractC1145b) {
            this.f33689a.onDestroyActionMode(e(abstractC1145b));
        }

        @Override // j.AbstractC1145b.a
        public boolean c(AbstractC1145b abstractC1145b, MenuItem menuItem) {
            return this.f33689a.onActionItemClicked(e(abstractC1145b), new MenuItemWrapperICS(this.f33690b, (D.b) menuItem));
        }

        @Override // j.AbstractC1145b.a
        public boolean d(AbstractC1145b abstractC1145b, Menu menu) {
            return this.f33689a.onPrepareActionMode(e(abstractC1145b), f(menu));
        }

        public ActionMode e(AbstractC1145b abstractC1145b) {
            int size = this.f33691c.size();
            for (int i10 = 0; i10 < size; i10++) {
                C1149f c1149f = this.f33691c.get(i10);
                if (c1149f != null && c1149f.f33688b == abstractC1145b) {
                    return c1149f;
                }
            }
            C1149f c1149f2 = new C1149f(this.f33690b, abstractC1145b);
            this.f33691c.add(c1149f2);
            return c1149f2;
        }

        public final Menu f(Menu menu) {
            Menu menu2 = this.f33692d.get(menu);
            if (menu2 == null) {
                MenuWrapperICS menuWrapperICS = new MenuWrapperICS(this.f33690b, (D.a) menu);
                this.f33692d.put(menu, menuWrapperICS);
                return menuWrapperICS;
            }
            return menu2;
        }
    }

    public C1149f(Context context, AbstractC1145b abstractC1145b) {
        this.f33687a = context;
        this.f33688b = abstractC1145b;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f33688b.a();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f33688b.b();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new MenuWrapperICS(this.f33687a, (D.a) this.f33688b.c());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f33688b.d();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f33688b.e();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f33688b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f33688b.g();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f33688b.h();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f33688b.i();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f33688b.j();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f33688b.k(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f33688b.m(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f33688b.n(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f33688b.p(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z10) {
        this.f33688b.q(z10);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i10) {
        this.f33688b.l(i10);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i10) {
        this.f33688b.o(i10);
    }
}
