package com.customize.contacts.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import com.coui.appcompat.list.COUIListView;
import com.customize.contacts.util.C0811w;
import com.customize.contacts.widget.MultiChoiceListView;
import com.oplus.dialer.R;
import java.util.ArrayList;
import m1.C1304B;
import m1.C1322s;

/* compiled from: CustomizeContactPickerFragment.java */
/* loaded from: classes3.dex */
public class l extends com.android.contacts.list.a implements COUIListView.ScrollMultiChoiceListener {

    /* renamed from: A0, reason: collision with root package name */
    public MultiChoiceListView f21309A0;

    /* renamed from: C0, reason: collision with root package name */
    public P3.c f21311C0;

    /* renamed from: D0, reason: collision with root package name */
    public DataSetObserver f21312D0;

    /* renamed from: z0, reason: collision with root package name */
    public P3.b f21315z0;

    /* renamed from: B0, reason: collision with root package name */
    public int f21310B0 = -1;

    /* renamed from: E0, reason: collision with root package name */
    public boolean f21313E0 = false;

    /* renamed from: F0, reason: collision with root package name */
    public boolean f21314F0 = false;

    /* compiled from: CustomizeContactPickerFragment.java */
    /* loaded from: classes3.dex */
    public class a implements MultiChoiceListView.b {
        public a() {
        }

        @Override // com.customize.contacts.widget.MultiChoiceListView.b
        public void a() {
            l.this.f21310B0 = -1;
        }
    }

    /* compiled from: CustomizeContactPickerFragment.java */
    /* loaded from: classes3.dex */
    public class b extends DataSetObserver {
        @Override // android.database.DataSetObserver
        public void onChanged() {
            int i10 = l.this.f21311C0.i();
            if (H7.a.b()) {
                H7.b.b("CustomizeContactPickerFragment", "onChanged COUNT : " + i10);
            }
        }

        public b() {
        }
    }

    private void R2() {
        this.f34984x = true;
        ((C1304B) m1()).u1(true);
    }

    @Override // com.android.contacts.list.a, m1.AbstractViewOnFocusChangeListenerC1314j
    public void A1(View view) {
        super.A1(view);
        if (this.f21311C0 == null) {
            this.f21311C0 = new P3.c();
        }
        b bVar = new b();
        this.f21312D0 = bVar;
        this.f21311C0.z(bVar);
        this.f21315z0 = new P3.b(this.f21311C0, getActivity());
        ((C1304B) m1()).q1(this.f21311C0);
        ((C1304B) m1()).r1(true);
        ((C1304B) m1()).v1(this.f21314F0);
        R2();
        MultiChoiceListView multiChoiceListView = (MultiChoiceListView) u1();
        this.f21309A0 = multiChoiceListView;
        multiChoiceListView.setScrollMultiChoiceListener(this);
        this.f21309A0.setMultiChoiceListener(new a());
        this.f21313E0 = true;
    }

    public int P2() {
        return this.f21311C0.i();
    }

    public void Q2(Z3.i iVar) {
        this.f34925B = iVar;
    }

    @Override // com.android.contacts.list.a, m1.AbstractViewOnFocusChangeListenerC1314j, androidx.loader.app.a.InterfaceC0129a
    /* renamed from: S1 */
    public void S0(W.c<Cursor> cVar, Cursor cursor) {
        com.customize.contacts.util.I i10;
        if (cursor != null && !(cursor instanceof C1322s)) {
            cursor = new C1322s(cursor);
        }
        super.S0(cVar, cursor);
        if (cVar.j() != 0) {
            return;
        }
        if (!this.f34960f && this.f21311C0.i() == 0 && this.f21313E0) {
            this.f21311C0.A();
            this.f21311C0.q(cursor, false);
        } else if (this.f34970k != null && E2()) {
            this.f21311C0.r(cursor, this.f34962g);
        } else {
            if (cVar.j() != -1 && K1() && cVar.j() == this.f34952b.I() && (i10 = this.f34966i) != null) {
                i10.e(cursor);
            }
            this.f21311C0.M(null);
            this.f21311C0.P(cursor, false);
        }
        this.f21313E0 = false;
        Z3.i iVar = this.f34925B;
        if (iVar != null) {
            iVar.k();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        ArrayList i12;
        if (i10 == 4 && i11 == -1 && intent != null && (i12 = C7.e.i(intent, "SELECTED_CONTACTS")) != null && !i12.isEmpty()) {
            C0811w.k(getActivity(), i12);
            getActivity().finish();
        }
    }

    @Override // com.android.contacts.list.a, m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (m1() instanceof C1304B) {
            ((C1304B) m1()).r1(false);
            ((C1304B) m1()).p1(null);
            ((C1304B) m1()).B1(null);
        }
        P3.c cVar = this.f21311C0;
        if (cVar != null) {
            cVar.d();
            this.f21311C0.O(this.f21312D0);
        }
    }

    @Override // com.android.contacts.list.a, m1.AbstractViewOnFocusChangeListenerC1314j, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.listview_scrollchoice_checkbox);
        if (this.f34984x) {
            this.f21315z0.b(checkBox, m1().p(i10 - this.f34950a.getHeaderViewsCount()));
            this.f34925B.a();
        }
    }

    public void onItemTouch(int i10, View view) {
        CheckBox checkBox;
        if (view == null || !this.f34984x || (checkBox = (CheckBox) view.findViewById(R.id.listview_scrollchoice_checkbox)) == null) {
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
        this.f21315z0.c(checkBox, m1().p(i10 - this.f34950a.getHeaderViewsCount()));
        this.f34925B.a();
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
}
