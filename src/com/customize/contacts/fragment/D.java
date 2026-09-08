package com.customize.contacts.fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import com.android.contacts.list.ContactListFilter;
import com.android.contacts.model.Account;
import com.coui.appcompat.grid.COUIPercentUtils;
import com.coui.appcompat.statusbar.COUIStatusBarResponseUtil;
import com.customize.contacts.model.IdRecord;
import com.customize.contacts.util.i0;
import com.customize.contacts.widget.ContactTouchSearchView;
import com.oplus.dialer.R;
import java.util.ArrayList;
import m1.AbstractC1311g;
import m1.C1304B;
import m1.C1322s;

/* compiled from: MultiContactPickerFragment.java */
/* loaded from: classes3.dex */
public class D extends l implements COUIStatusBarResponseUtil.StatusBarClickListener {

    /* renamed from: G0, reason: collision with root package name */
    public ArrayList<IdRecord> f21188G0;

    /* renamed from: H0, reason: collision with root package name */
    public ArrayList<IdRecord> f21189H0;

    /* renamed from: K0, reason: collision with root package name */
    public COUIStatusBarResponseUtil f21192K0;

    /* renamed from: O0, reason: collision with root package name */
    public long[] f21196O0;

    /* renamed from: P0, reason: collision with root package name */
    public View f21197P0;

    /* renamed from: I0, reason: collision with root package name */
    public Account f21190I0 = null;

    /* renamed from: J0, reason: collision with root package name */
    public boolean f21191J0 = false;

    /* renamed from: L0, reason: collision with root package name */
    public boolean f21193L0 = false;

    /* renamed from: M0, reason: collision with root package name */
    public ArrayList<Account> f21194M0 = null;

    /* renamed from: N0, reason: collision with root package name */
    public boolean f21195N0 = false;

    /* compiled from: MultiContactPickerFragment.java */
    /* loaded from: classes3.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            D.this.r2();
            return D.this.onTouch(view, motionEvent);
        }
    }

    @Override // com.customize.contacts.fragment.l, com.android.contacts.list.a, m1.AbstractViewOnFocusChangeListenerC1314j
    public void A1(View view) {
        super.A1(view);
        this.f21311C0.I(true);
        j3(getContext());
        this.f34972l.setVisibility(4);
        if (u1() != null) {
            u1().setOnTouchListener(new a());
        }
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void B1(View view) {
        super.B1(view);
        ContactTouchSearchView contactTouchSearchView = this.f34968j;
        if (contactTouchSearchView != null) {
            contactTouchSearchView.O(this.f34972l, this.f21197P0);
        }
    }

    @Override // com.customize.contacts.fragment.l, com.android.contacts.list.a, m1.AbstractViewOnFocusChangeListenerC1314j, androidx.loader.app.a.InterfaceC0129a
    /* renamed from: S1 */
    public void S0(W.c<Cursor> cVar, Cursor cursor) {
        V3.a aVar;
        boolean z10;
        if (cursor != null && !(cursor instanceof C1322s)) {
            cursor = new C1322s(cursor);
        }
        super.S0(cVar, cursor);
        if (cVar.j() != 0) {
            return;
        }
        if (cursor != null && (aVar = this.f34975m0) != null) {
            if (cursor.getCount() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            aVar.c(z10);
        }
        if (!this.f34960f && U2() == 0 && this.f21193L0) {
            this.f21311C0.A();
            if (this.f21188G0 != null && H7.a.b()) {
                H7.b.b("MultiContactPicker", "mInitSelectedContacts.size() = " + this.f21188G0.size());
            }
            this.f21311C0.M(this.f21188G0);
            this.f21311C0.q(cursor, false);
            i3();
        } else {
            boolean z11 = this.f34962g;
            if (z11) {
                this.f21311C0.r(cursor, z11);
            } else {
                this.f21311C0.M(this.f21188G0);
                this.f21311C0.P(cursor, this.f34962g);
            }
        }
        this.f21193L0 = false;
        Z3.i iVar = this.f34925B;
        if (iVar != null) {
            iVar.k();
        }
    }

    public int S2() {
        return this.f21311C0.g();
    }

    public int T2() {
        return this.f21311C0.h();
    }

    public int U2() {
        return this.f21311C0.i();
    }

    public ArrayList<IdRecord> V2() {
        return this.f21311C0.k();
    }

    public int W2() {
        return this.f21311C0.l();
    }

    @Override // com.android.contacts.list.a, m1.AbstractViewOnFocusChangeListenerC1314j
    public void X1(Bundle bundle) {
        int length;
        super.X1(bundle);
        if (bundle != null) {
            this.f21195N0 = bundle.getBoolean("markAllFlag");
            this.f21196O0 = bundle.getLongArray("unSelectedContacts");
            if (H7.a.b()) {
                H7.b.b("MultiContactPicker", "restoreSavedState mRestoredMarkAllFlag:" + this.f21195N0);
                StringBuilder sb = new StringBuilder();
                sb.append("restoreSavedState mRestoredUnSelectedContactArr length:");
                long[] jArr = this.f21196O0;
                if (jArr == null) {
                    length = 0;
                } else {
                    length = jArr.length;
                }
                sb.append(length);
                H7.b.b("MultiContactPicker", sb.toString());
            }
        }
    }

    public void X2() {
        this.f21311C0.p();
    }

    public boolean Y2() {
        return this.f21311C0.u();
    }

    public void Z2() {
        m1().notifyDataSetChanged();
    }

    public void a3(boolean z10) {
        this.f21311C0.w(z10);
        Z2();
    }

    public void b3(Account account) {
        if (account != null) {
            this.f21190I0 = account;
        }
        if (H7.a.b()) {
            H7.b.b("MultiContactPicker", "mAccount 2= " + this.f21190I0);
        }
    }

    public void c3(ArrayList<IdRecord> arrayList) {
        if (arrayList != null) {
            this.f21189H0 = arrayList;
        }
    }

    public void d3(Account account) {
        this.f16867t0 = account;
    }

    public void e3(boolean z10) {
        this.f21191J0 = z10;
        if (H7.a.b()) {
            H7.b.b("MultiContactPicker", "mIsForCopyContactsToSim = " + this.f21191J0);
        }
    }

    public void f3(View view) {
        this.f21197P0 = view;
    }

    public void g3(ArrayList<IdRecord> arrayList) {
        if (arrayList != null) {
            this.f21188G0 = arrayList;
        }
    }

    public void h3(ArrayList<Account> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            this.f21194M0 = arrayList;
        }
    }

    public final void i3() {
        if (H7.a.b()) {
            H7.b.b("MultiContactPicker", "processRestoreState mRestoredMarkAllFlag:" + this.f21195N0);
        }
        if (this.f21195N0) {
            this.f21311C0.H(true);
            if (this.f21196O0 == null) {
                this.f21311C0.J();
            } else {
                if (H7.a.b()) {
                    H7.b.b("MultiContactPicker", "processRestoreState unselected contacts size:" + this.f21196O0.length);
                }
                this.f21311C0.N(this.f21196O0);
                this.f21196O0 = null;
            }
            this.f21195N0 = false;
        }
    }

    public final void j3(Context context) {
        if (context != null && this.f34968j != null) {
            if (COUIPercentUtils.getTotalGridSize(context) > context.getResources().getInteger(R.integer.grid_guide_column_preference)) {
                this.f34968j.q(false);
            } else {
                this.f34968j.q(true);
            }
        }
    }

    @Override // com.android.contacts.list.a, m1.AbstractViewOnFocusChangeListenerC1314j
    public AbstractC1311g k1() {
        if (!F1()) {
            C1304B c1304b = new C1304B(getActivity());
            Account account = this.f16867t0;
            if (account != null) {
                c1304b.y0(ContactListFilter.f(account.f16942b, account.f16941a, null, null, false, null));
            } else if (!this.f16865r0) {
                ContactListFilter n10 = ContactListFilter.n(PreferenceManager.getDefaultSharedPreferences(getActivity()));
                n10.f16745i = this.f16866s0;
                c1304b.y0(n10);
            } else {
                ContactListFilter h10 = ContactListFilter.h(-2);
                h10.f16745i = this.f16866s0;
                c1304b.y0(h10);
            }
            c1304b.P(true);
            c1304b.w0(true);
            c1304b.E0(false);
            c1304b.u1(true);
            c1304b.p1(this.f21190I0);
            c1304b.B1(this.f21194M0);
            c1304b.s1(this.f21191J0);
            c1304b.y1(this.f21189H0);
            return c1304b;
        }
        m1.I i10 = new m1.I(getActivity());
        i10.P(false);
        i10.w0(false);
        return i10;
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        j3(getContext());
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        COUIStatusBarResponseUtil cOUIStatusBarResponseUtil = new COUIStatusBarResponseUtil(getActivity());
        this.f21192K0 = cOUIStatusBarResponseUtil;
        cOUIStatusBarResponseUtil.setStatusBarClickListener(this);
        this.f21193L0 = true;
    }

    @Override // com.customize.contacts.fragment.l, com.android.contacts.list.a, m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        C1304B c1304b = (C1304B) m1();
        if (c1304b != null) {
            c1304b.s1(false);
            c1304b.u1(false);
        }
    }

    @Override // com.customize.contacts.fragment.l, com.android.contacts.list.a, m1.AbstractViewOnFocusChangeListenerC1314j, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.listview_scrollchoice_checkbox);
        this.f21315z0.b(checkBox, m1().p(i10 - this.f34950a.getHeaderViewsCount()));
        this.f34925B.a();
        com.android.contacts.util.C.b(view, checkBox.isChecked());
    }

    @Override // com.customize.contacts.fragment.l, com.coui.appcompat.list.COUIListView.ScrollMultiChoiceListener
    public void onItemTouch(int i10, View view) {
        CheckBox checkBox;
        if (view == null || (checkBox = (CheckBox) view.findViewById(R.id.listview_scrollchoice_checkbox)) == null) {
            return;
        }
        boolean z10 = true;
        boolean z11 = !checkBox.isChecked();
        if (this.f21310B0 == -1) {
            if (z11) {
                this.f21310B0 = 1;
            } else {
                this.f21310B0 = 0;
            }
        }
        if (this.f21310B0 != 1) {
            z10 = false;
        }
        checkBox.setChecked(z10);
        com.android.contacts.util.C.b(view, z10);
        this.f21315z0.c(checkBox, m1().p(i10 - this.f34950a.getHeaderViewsCount()));
        this.f34925B.a();
    }

    @Override // com.android.contacts.list.a, m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        i0.b();
        this.f21192K0.onPause();
    }

    @Override // com.android.contacts.list.a, m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f21192K0.onResume();
    }

    @Override // com.android.contacts.list.a, m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        P3.c cVar = this.f21311C0;
        if (cVar != null && cVar.f2890b) {
            if (H7.a.b()) {
                H7.b.b("MultiContactPicker", "onSaveInstanceState mIsClickMarkAll true");
            }
            bundle.putBoolean("markAllFlag", true);
            long[] m10 = this.f21311C0.m();
            if (m10 != null && m10.length > 0) {
                bundle.putLongArray("unSelectedContacts", m10);
            }
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // com.coui.appcompat.statusbar.COUIStatusBarResponseUtil.StatusBarClickListener
    public void onStatusBarClicked() {
        i0.d(getActivity(), this.f34950a);
    }
}
