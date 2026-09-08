package com.customize.contacts.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.CheckBox;
import com.android.contacts.list.ContactListFilter;
import com.coloros.contacts.common.ContactParcelable;
import com.coui.appcompat.list.COUIListView;
import com.customize.contacts.model.IdRecord;
import com.customize.contacts.util.g0;
import com.customize.contacts.widget.ContactTouchSearchView;
import com.customize.contacts.widget.MultiChoiceListView;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.Iterator;
import m1.AbstractC1311g;
import m1.C1322s;

/* compiled from: CustomizePhoneNumberPickerFragment.java */
/* loaded from: classes3.dex */
public class p extends com.android.contacts.list.e implements COUIListView.ScrollMultiChoiceListener {

    /* renamed from: x0, reason: collision with root package name */
    public Context f21325x0;

    /* renamed from: z0, reason: collision with root package name */
    public MultiChoiceListView f21327z0;

    /* renamed from: y0, reason: collision with root package name */
    public P3.a f21326y0 = null;

    /* renamed from: A0, reason: collision with root package name */
    public int f21324A0 = -1;

    /* compiled from: CustomizePhoneNumberPickerFragment.java */
    /* loaded from: classes3.dex */
    public class a implements MultiChoiceListView.b {
        public a() {
        }

        @Override // com.customize.contacts.widget.MultiChoiceListView.b
        public void a() {
            p.this.r2();
            p.this.f21324A0 = -1;
        }
    }

    /* compiled from: CustomizePhoneNumberPickerFragment.java */
    /* loaded from: classes3.dex */
    public class b extends DataSetObserver {
        @Override // android.database.DataSetObserver
        public void onChanged() {
            int c10 = p.this.f34986z.c();
            if (H7.a.b()) {
                H7.b.b("CustomizePhoneNumberPickerFragment", "onChanged COUNT : " + c10);
            }
        }

        public b() {
        }
    }

    @Override // com.android.contacts.list.e, m1.AbstractViewOnFocusChangeListenerC1314j
    public void A1(View view) {
        super.A1(view);
        if (this.f34986z == null) {
            this.f34986z = new com.customize.contacts.manager.g();
        }
        if (this.f34926C == null) {
            this.f34926C = new b();
        }
        this.f34986z.j(this.f34926C);
        this.f34924A = new com.customize.contacts.manager.f(this.f34986z, this.f21325x0);
        if (m1() instanceof P3.f) {
            ((P3.f) m1()).S0(this.f34986z);
        }
        MultiChoiceListView multiChoiceListView = (MultiChoiceListView) u1();
        this.f21327z0 = multiChoiceListView;
        multiChoiceListView.setScrollMultiChoiceListener(this);
        this.f21327z0.setMultiChoiceListener(new a());
        ContactTouchSearchView contactTouchSearchView = this.f34968j;
        if (contactTouchSearchView != null) {
            contactTouchSearchView.q(false);
        }
    }

    public int N2() {
        com.customize.contacts.manager.g gVar = this.f34986z;
        if (gVar != null) {
            return gVar.c();
        }
        return 0;
    }

    public ArrayList<ContactParcelable> O2() {
        ArrayList<ContactParcelable> arrayList = new ArrayList<>();
        Iterator<IdRecord> it = this.f34986z.d().iterator();
        while (it.hasNext()) {
            IdRecord next = it.next();
            ContactParcelable contactParcelable = new ContactParcelable();
            contactParcelable.q(next.b());
            contactParcelable.t(next.getName());
            contactParcelable.w(next.h());
            arrayList.add(contactParcelable);
        }
        return arrayList;
    }

    public void P2() {
        this.f34985y = true;
    }

    public void Q2(Z3.i iVar) {
        this.f34925B = iVar;
    }

    public void R2() {
        this.f34984x = true;
        if (m1() instanceof P3.f) {
            ((P3.f) m1()).T0();
        }
    }

    @Override // com.android.contacts.list.e, m1.AbstractViewOnFocusChangeListenerC1314j, androidx.loader.app.a.InterfaceC0129a
    /* renamed from: S1 */
    public void S0(W.c<Cursor> cVar, Cursor cursor) {
        if (cursor != null && !(cursor instanceof C1322s)) {
            cursor = new C1322s(cursor);
        }
        super.S0(cVar, cursor);
        if (cVar.j() != 0) {
            return;
        }
        if (!this.f34960f) {
            this.f34986z.n(cursor, false);
        }
        if (!this.f34960f && this.f34986z.c() == 0) {
            this.f34986z.f(cursor);
        } else if (E2()) {
            this.f34986z.h(cursor, this.f34962g);
        } else {
            this.f34986z.g(cursor);
        }
        if (!this.f34960f) {
            g0.a(this.f34968j, (String[]) this.f34952b.getSections(), this.f34952b.L());
        }
        Z3.i iVar = this.f34925B;
        if (iVar != null) {
            iVar.k();
        }
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void V1() {
        T t10 = this.f34952b;
        if (t10 != 0) {
            t10.y0(ContactListFilter.n(PreferenceManager.getDefaultSharedPreferences(getActivity())));
        }
        super.V1();
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public W.b j1() {
        Context activity;
        if (getActivity() == null) {
            activity = getContext();
        } else {
            activity = getActivity();
        }
        P3.a aVar = new P3.a(activity);
        this.f21326y0 = aVar;
        return aVar;
    }

    @Override // com.android.contacts.list.e, m1.AbstractViewOnFocusChangeListenerC1314j
    public AbstractC1311g k1() {
        if (!F1()) {
            P3.f fVar = new P3.f(getActivity());
            fVar.y0(ContactListFilter.n(PreferenceManager.getDefaultSharedPreferences(getActivity())));
            fVar.w0(true);
            return fVar;
        }
        m1.J j10 = new m1.J(getActivity());
        j10.y0(ContactListFilter.n(PreferenceManager.getDefaultSharedPreferences(getActivity())));
        j10.w0(true);
        return j10;
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f21325x0 = activity;
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        int headerViewsCount = i10 - u1().getHeaderViewsCount();
        if (this.f34984x) {
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.listview_scrollchoice_checkbox);
            if (checkBox.isEnabled()) {
                this.f34924A.a(checkBox);
                Z3.i iVar = this.f34925B;
                if (iVar != null) {
                    iVar.a();
                }
            } else {
                com.oplus.foundation.util.ui.c.e(getActivity(), getContext().getString(R.string.oplus_number_not_support_rcs));
            }
            com.android.contacts.util.C.b(view, checkBox.isChecked());
            return;
        }
        if (this.f34985y) {
            super.R1(headerViewsCount, j10);
            return;
        }
        M2();
        if (m1() instanceof P3.f) {
            P3.f fVar = (P3.f) m1();
            ContactParcelable contactParcelable = new ContactParcelable();
            Cursor cursor = (Cursor) fVar.getItem(headerViewsCount);
            String string = cursor.getString(7);
            String string2 = cursor.getString(3);
            if (H7.a.b()) {
                H7.b.e("CustomizePhoneNumberPickerFragment", "phoneNumber = " + H7.a.d(string2));
            }
            contactParcelable.t(string);
            contactParcelable.w(string2);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            arrayList.add(contactParcelable);
            Intent intent = new Intent();
            intent.putParcelableArrayListExtra("SELECTED_CONTACTS", arrayList);
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
    }

    @Override // com.coui.appcompat.list.COUIListView.ScrollMultiChoiceListener
    public void onItemTouch(int i10, View view) {
        CheckBox checkBox;
        if (view == null || !this.f34984x || (checkBox = (CheckBox) view.findViewById(R.id.listview_scrollchoice_checkbox)) == null) {
            return;
        }
        if (checkBox.isEnabled()) {
            boolean z10 = true;
            boolean z11 = !checkBox.isChecked();
            if (this.f21324A0 == -1) {
                if (z11) {
                    this.f21324A0 = 1;
                } else {
                    this.f21324A0 = 0;
                }
            }
            if (this.f21324A0 != 1) {
                z10 = false;
            }
            checkBox.setChecked(z10);
            com.android.contacts.util.C.b(view, checkBox.isChecked());
            this.f34924A.b(checkBox);
            this.f34925B.a();
            return;
        }
        com.oplus.foundation.util.ui.c.e(getActivity(), getContext().getString(R.string.oplus_number_not_support_rcs));
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i10) {
        if (i10 != 2 && i10 != 1) {
            P3.a aVar = this.f21326y0;
            if (aVar != null) {
                aVar.W(false);
                if (this.f21326y0.U()) {
                    this.f21326y0.p();
                    this.f21326y0.V(false);
                }
            }
        } else {
            P3.a aVar2 = this.f21326y0;
            if (aVar2 != null) {
                aVar2.W(true);
            }
        }
        super.onScrollStateChanged(absListView, i10);
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, com.coui.appcompat.searchview.COUISearchBar.OnStateChangeListener
    public void onStateChange(int i10, int i11) {
        super.onStateChange(i10, i11);
        if (i11 == 1) {
            this.f34960f = true;
        } else if (i11 == 0) {
            this.f34960f = false;
        }
    }

    public void M2() {
    }
}
