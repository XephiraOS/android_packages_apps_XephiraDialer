package com.customize.contacts.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import com.android.contacts.framework.baseui.util.B;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.widget.p;
import com.oplus.dialer.R;

/* compiled from: CustomizeActivityDialog.java */
/* loaded from: classes3.dex */
public class f extends U0.l {

    /* renamed from: a, reason: collision with root package name */
    public Context f22569a;

    /* renamed from: b, reason: collision with root package name */
    public int f22570b;

    /* renamed from: c, reason: collision with root package name */
    public p.a f22571c;

    /* renamed from: d, reason: collision with root package name */
    public COUIToolbar f22572d;

    /* compiled from: CustomizeActivityDialog.java */
    /* loaded from: classes3.dex */
    public class a implements Toolbar.g {
        public a() {
        }

        @Override // androidx.appcompat.widget.Toolbar.g
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (menuItem.getItemId() != 16908332 && menuItem.getItemId() != R.id.cancel) {
                if (menuItem.getItemId() == R.id.save) {
                    if (f.this.f22571c != null) {
                        f.this.f22571c.a(null);
                    }
                    f.this.dismiss();
                }
                return true;
            }
            if (f.this.f22571c != null) {
                f.this.f22571c.b();
            }
            f.this.dismiss();
            return true;
        }
    }

    public f(Context context, int i10) {
        super(context, i10);
        this.f22570b = -1;
        this.f22569a = context;
        B.c(context, getWindow(), 3);
    }

    public void c(COUIToolbar cOUIToolbar, int i10) {
        this.f22572d = cOUIToolbar;
        cOUIToolbar.inflateMenu(i10);
        this.f22572d.setOnMenuItemClickListener(new a());
    }

    @Override // androidx.activity.j, android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.f22570b > 0) {
            new MenuInflater(this.f22569a).inflate(this.f22570b, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }
}
