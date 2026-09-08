package com.customize.contacts.activities;

import android.database.DataSetObserver;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.oplus.dialer.R;

/* loaded from: classes3.dex */
public abstract class CommonTopTitlebarActivity extends SearchAnimatorsActivity {

    /* renamed from: Q, reason: collision with root package name */
    public a f20189Q = null;

    /* renamed from: R, reason: collision with root package name */
    public boolean f20190R = false;

    /* renamed from: S, reason: collision with root package name */
    public String f20191S = null;

    /* loaded from: classes3.dex */
    public class a extends DataSetObserver {
        public a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            CommonTopTitlebarActivity.this.g2();
            CommonTopTitlebarActivity.this.Y1();
        }
    }

    public abstract void Y1();

    public boolean Z1() {
        return this.f20190R;
    }

    public abstract int a2();

    public abstract int b2();

    public a c2() {
        return new a();
    }

    public void d2() {
        markAllContacts();
        h2();
    }

    public abstract void e2(boolean z10);

    public void f2(boolean z10) {
        this.f20190R = z10;
    }

    public void g2() {
        if (this.f20191S == null) {
            this.f20191S = getString(R.string.select_items);
        }
        int a22 = a2();
        int b22 = b2();
        if (H7.a.b()) {
            H7.b.b("CommonTopTitlebarActivity", "updateMarkCount(), marked = " + a22 + ", total = " + b22);
        }
        if (this.f20571x != null) {
            if (a2() == 0) {
                this.f20571x.setTitle(R.string.select_item);
            } else {
                this.f20571x.setTitle(String.format(this.f20191S, Integer.valueOf(U7.a.b(a22))));
            }
        }
    }

    public void h2() {
        if (U1()) {
            return;
        }
        if (b2() == 0) {
            this.f20571x.getMenu().findItem(R.id.select_all).setEnabled(false);
            return;
        }
        COUIToolbar cOUIToolbar = this.f20571x;
        if (cOUIToolbar != null) {
            if (this.f20190R) {
                cOUIToolbar.getMenu().findItem(R.id.select_all).setTitle(R.string.oplus_option_selectcancel);
            } else {
                cOUIToolbar.getMenu().findItem(R.id.select_all).setTitle(R.string.oplus_option_selectall);
            }
        }
    }

    public void markAllContacts() {
        if (!this.f20190R) {
            e2(true);
            this.f20190R = true;
        } else {
            e2(false);
            this.f20190R = false;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.android.contacts.framework.baseui.util.A.g(this);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.android.contacts.framework.baseui.util.A.h(this);
    }
}
