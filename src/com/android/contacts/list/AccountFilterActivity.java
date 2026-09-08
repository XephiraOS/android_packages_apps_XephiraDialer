package com.android.contacts.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.loader.app.a;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.android.contacts.ContactsActivity;
import com.android.contacts.framework.baseui.util.A;
import com.android.contacts.list.AccountFilterActivity;
import com.android.contacts.list.c;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.util.C;
import com.android.contacts.util.C0700a;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.util.b0;
import com.google.common.collect.n;
import com.oplus.dialer.R;
import com.oplus.foundation.appsupport.ui.widget.recyclerview.HeaderFooterRecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import m1.AbstractC1316l;
import n1.AbstractC1362a;
import q7.C1493b;
import q7.InterfaceC1492a;

/* loaded from: classes.dex */
public class AccountFilterActivity extends ContactsActivity implements c.InterfaceC0172c {

    /* renamed from: A, reason: collision with root package name */
    public static final String f16728A = "AccountFilterActivity";

    /* renamed from: q, reason: collision with root package name */
    public HeaderFooterRecyclerView f16729q;

    /* renamed from: r, reason: collision with root package name */
    public c f16730r;

    /* renamed from: x, reason: collision with root package name */
    public ContactListFilter f16731x;

    /* renamed from: y, reason: collision with root package name */
    public ContactListFilter f16732y;

    /* renamed from: z, reason: collision with root package name */
    public final InterfaceC1492a f16733z = new C1493b();

    /* loaded from: classes.dex */
    public static class a extends W.a<List<ContactListFilter>> {

        /* renamed from: p, reason: collision with root package name */
        public final WeakReference<Context> f16734p;

        /* renamed from: q, reason: collision with root package name */
        public final ContactListFilter f16735q;

        @Override // W.a
        /* renamed from: L, reason: merged with bridge method [inline-methods] */
        public List<ContactListFilter> I() {
            Context context = this.f16734p.get();
            if (context == null) {
                return null;
            }
            return AccountFilterActivity.C1(context, this.f16735q, false);
        }

        @Override // W.c
        public void r() {
            t();
        }

        @Override // W.c
        public void s() {
            h();
        }

        @Override // W.c
        public void t() {
            b();
        }

        public a(Context context, ContactListFilter contactListFilter) {
            super(context);
            this.f16734p = new WeakReference<>(context);
            this.f16735q = contactListFilter;
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.InterfaceC0129a<List<ContactListFilter>> {
        @Override // androidx.loader.app.a.InterfaceC0129a
        public W.c<List<ContactListFilter>> Z(int i10, Bundle bundle) {
            AccountFilterActivity accountFilterActivity = AccountFilterActivity.this;
            return new a(accountFilterActivity, accountFilterActivity.f16731x);
        }

        @Override // androidx.loader.app.a.InterfaceC0129a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void S0(W.c<List<ContactListFilter>> cVar, List<ContactListFilter> list) {
            if (list == null) {
                H7.b.c(AccountFilterActivity.f16728A, "Failed to load filters");
                return;
            }
            H7.b.b(AccountFilterActivity.f16728A, "load finish");
            AccountFilterActivity.this.y1();
            if (AccountFilterActivity.this.f16729q.getAdapter() == null) {
                AccountFilterActivity accountFilterActivity = AccountFilterActivity.this;
                AccountFilterActivity accountFilterActivity2 = AccountFilterActivity.this;
                accountFilterActivity.f16730r = new c(accountFilterActivity2, list, accountFilterActivity2.f16731x, AccountFilterActivity.this);
                AccountFilterActivity.this.f16730r.s(true);
                AccountFilterActivity.this.f16729q.setAdapter(AccountFilterActivity.this.f16730r);
                return;
            }
            AccountFilterActivity.this.f16730r.r(list);
            AccountFilterActivity.this.f16730r.q(AccountFilterActivity.this.f16731x);
            AccountFilterActivity.this.f16730r.v();
        }

        public b() {
        }

        @Override // androidx.loader.app.a.InterfaceC0129a
        public void Q(W.c<List<ContactListFilter>> cVar) {
        }
    }

    public static List<ContactListFilter> C1(Context context, ContactListFilter contactListFilter, boolean z10) {
        ArrayList f10 = n.f();
        ArrayList f11 = n.f();
        AbstractC1362a h10 = AbstractC1362a.h(context);
        boolean z11 = contactListFilter.f16744h;
        x1(context, f11, z11);
        for (AccountWithDataSet accountWithDataSet : h10.g(z10)) {
            AccountType c10 = h10.c(accountWithDataSet.f16942b, accountWithDataSet.f16970c);
            if (c10 != null && (!c10.o() || accountWithDataSet.i(context))) {
                f11.add(ContactListFilter.f(accountWithDataSet.f16942b, accountWithDataSet.f16941a, accountWithDataSet.f16970c, c10.e(context), z11, (String) c10.f(context)));
            }
        }
        f10.add(new ContactListFilter(-2, "ALL", "ALL", null, null, z11, null));
        if (f11.size() >= 1) {
            f10.addAll(f11);
        }
        if (R0.a.f3166b != null) {
            f10.add(new ContactListFilter(-3, "CUSTOM", "CUSTOM", null, null, z11, null));
        }
        return f10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void x1(Context context, ArrayList<ContactListFilter> arrayList, boolean z10) {
        int i10;
        boolean z11;
        int i11;
        if (!FeatureOption.k()) {
            return;
        }
        if (B3.a.i()) {
            boolean m02 = b0.m0(context, 0);
            z11 = b0.m0(context, 1);
            i11 = m02;
        } else {
            if (!b0.m0(context, 0) && !b0.m0(context, 1)) {
                i10 = 0;
            } else {
                i10 = 1;
            }
            z11 = false;
            i11 = i10;
        }
        if (i11 != 0 && z11) {
            arrayList.add(ContactListFilter.f("com.android.oplus.sim", com.customize.contacts.simcontacts.b.g(0), null, null, z10, com.customize.contacts.simcontacts.b.f(context, 0)));
            arrayList.add(ContactListFilter.f("com.android.oplus.sim", com.customize.contacts.simcontacts.b.g(1), null, null, z10, com.customize.contacts.simcontacts.b.f(context, 1)));
        } else if (i11 != 0 || z11) {
            arrayList.add(ContactListFilter.f("com.android.oplus.sim", com.customize.contacts.simcontacts.b.g(i11 ^ 1), null, null, z10, com.customize.contacts.simcontacts.b.c(context)));
        }
    }

    public final /* synthetic */ void A1(View view) {
        finish();
    }

    public final /* synthetic */ boolean B1(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.save) {
            D1();
            X.a.b(this).d(new Intent("com.oplus.contacts.display_settings_changed"));
            finish();
        }
        A.b(this, "contact_to_display_back");
        return true;
    }

    public final void D1() {
        String str;
        if (this.f16732y == null) {
            this.f16732y = this.f16731x;
        }
        Intent intent = new Intent();
        intent.putExtra("contactListFilter", this.f16732y);
        AbstractC1316l c10 = C0700a.c();
        if (c10 == null) {
            c10 = AbstractC1316l.f(this);
        }
        C0700a.d(c10, -1, intent);
        setResult(-1, intent);
        if (TextUtils.equals(this.f16732y.f16739c, "ALL")) {
            str = "com.oplus.contacts.all";
        } else {
            str = this.f16732y.f16739c;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("account_type", str);
        A.a(getBaseContext(), 2000312, 200030100, hashMap, false);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        c cVar;
        super.onActivityResult(i10, i11, intent);
        if (i11 == -1 && i10 == 0 && (cVar = this.f16730r) != null) {
            cVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        A.b(this, "contact_to_display_back");
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.contact_list_filter);
        COUIToolbar cOUIToolbar = (COUIToolbar) findViewById(R.id.toolbar);
        cOUIToolbar.setIsTitleCenterStyle(false);
        cOUIToolbar.setTitle(R.string.display_setting);
        cOUIToolbar.setNavigationIcon(R.drawable.coui_back_arrow);
        cOUIToolbar.setNavigationContentDescription(R.string.abc_action_bar_up_description);
        cOUIToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: m1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountFilterActivity.this.A1(view);
            }
        });
        cOUIToolbar.setOnMenuItemClickListener(new Toolbar.g() { // from class: m1.b
            @Override // androidx.appcompat.widget.Toolbar.g
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean B12;
                B12 = AccountFilterActivity.this.B1(menuItem);
                return B12;
            }
        });
        cOUIToolbar.inflateMenu(R.menu.cancel_save_menu);
        cOUIToolbar.getMenu().findItem(R.id.cancel).setVisible(false);
        HeaderFooterRecyclerView headerFooterRecyclerView = (HeaderFooterRecyclerView) findViewById(R.id.filter_list);
        this.f16729q = headerFooterRecyclerView;
        this.f16733z.T0(this, headerFooterRecyclerView, null);
        C.c(this, this.f16729q, getResources().getDimensionPixelSize(R.dimen.DP_30));
        this.f16729q.setClipToPadding(false);
        this.f16729q.setNestedScrollingEnabled(true);
        this.f16729q.setLayoutManager(new LinearLayoutManager(this));
        this.f16729q.x(z1());
        getSupportLoaderManager().e(0, null, new b());
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getSupportLoaderManager().a(0);
        c cVar = this.f16730r;
        if (cVar != null) {
            cVar.u();
        }
        this.f16733z.F();
    }

    @Override // com.android.contacts.list.c.InterfaceC0172c
    public void onItemClick(View view, int i10) {
        ContactListFilter contactListFilter = (ContactListFilter) view.getTag();
        if (contactListFilter == null) {
            return;
        }
        contactListFilter.f16744h = this.f16731x.f16744h;
        if (contactListFilter.f16738b == -3) {
            this.f16731x = contactListFilter;
            this.f16732y = contactListFilter;
            c cVar = this.f16730r;
            if (cVar != null) {
                cVar.q(contactListFilter);
            }
            Q7.b.b(this, new Intent(this, (Class<?>) CustomContactListFilterActivity.class), 0, 0);
            return;
        }
        this.f16731x = contactListFilter;
        this.f16732y = contactListFilter;
        c cVar2 = this.f16730r;
        if (cVar2 != null) {
            cVar2.q(contactListFilter);
            this.f16730r.notifyDataSetChanged();
        }
    }

    @Override // com.android.contacts.activities.TransactionSafeActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f16733z.p();
    }

    @Override // com.android.contacts.activities.TransactionSafeActivity, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f16733z.H0();
    }

    public final void y1() {
        ContactListFilter contactListFilter = this.f16731x;
        if (contactListFilter.f16738b == 0 && "com.android.oplus.sim".equals(contactListFilter.f16739c) && !b0.m0(this, com.customize.contacts.simcontacts.b.j(this.f16731x.f16740d))) {
            this.f16731x = ContactListFilter.h(-2);
        }
    }

    public final View z1() {
        LayoutInflater layoutInflater = getLayoutInflater();
        this.f16731x = ContactListFilter.n(PreferenceManager.getDefaultSharedPreferences(this));
        View inflate = layoutInflater.inflate(R.layout.preference_separetor, (ViewGroup) this.f16729q, false);
        ((TextView) inflate.findViewById(R.id.title)).setText(R.string.select_accounts_to_display);
        return inflate;
    }
}
