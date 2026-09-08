package com.customize.contacts.fragment;

import android.content.ContentUris;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.contacts.framework.baseui.widget.EmptyViewGroup;
import com.coui.appcompat.list.COUIListView;
import com.customize.contacts.util.g0;
import com.customize.contacts.widget.ContactTouchSearchView;
import com.customize.contacts.widget.MultiChoiceListView;
import com.oplus.anim.EffectiveAnimationView;
import com.oplus.dialer.R;
import java.util.ArrayList;
import m1.AbstractC1311g;
import m1.C1322s;

/* compiled from: CustomizeEmailAddressPickerFragment.java */
/* loaded from: classes3.dex */
public class n extends m1.G implements COUIListView.ScrollMultiChoiceListener {

    /* renamed from: r0, reason: collision with root package name */
    public MultiChoiceListView f21318r0;

    /* renamed from: s0, reason: collision with root package name */
    public int f21319s0 = -1;

    /* renamed from: t0, reason: collision with root package name */
    public EmptyViewGroup f21320t0;

    /* compiled from: CustomizeEmailAddressPickerFragment.java */
    /* loaded from: classes3.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            n.this.r2();
            return n.this.onTouch(view, motionEvent);
        }
    }

    /* compiled from: CustomizeEmailAddressPickerFragment.java */
    /* loaded from: classes3.dex */
    public class b implements MultiChoiceListView.b {
        public b() {
        }

        @Override // com.customize.contacts.widget.MultiChoiceListView.b
        public void a() {
            n.this.f21319s0 = -1;
        }
    }

    /* compiled from: CustomizeEmailAddressPickerFragment.java */
    /* loaded from: classes3.dex */
    public class c extends DataSetObserver {
        @Override // android.database.DataSetObserver
        public void onChanged() {
            int c10 = n.this.f34986z.c();
            if (H7.a.b()) {
                H7.b.b("CustomizeEmailAddressPicker", "onChanged COUNT : " + c10);
            }
        }

        public c() {
        }
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void A1(View view) {
        super.A1(view);
        D2(view);
    }

    public final void D2(View view) {
        E2(view);
        u1().setOnTouchListener(new a());
        this.f21320t0 = (EmptyViewGroup) view.findViewById(R.id.empty_view_group);
        this.f34974m = (ImageView) view.findViewById(R.id.no_content);
        TextView textView = (TextView) view.findViewById(R.id.empty_view);
        this.f34964h = textView;
        textView.setText(R.string.noContacts);
        if (this.f34986z == null) {
            this.f34986z = new com.customize.contacts.manager.g();
        }
        if (this.f34926C == null) {
            this.f34926C = new c();
        }
        this.f34986z.j(this.f34926C);
        this.f34924A = new com.customize.contacts.manager.f(this.f34986z, getActivity());
        ((P3.e) m1()).P0(this.f34986z);
        MultiChoiceListView multiChoiceListView = (MultiChoiceListView) u1();
        this.f21318r0 = multiChoiceListView;
        multiChoiceListView.setScrollMultiChoiceListener(this);
        this.f21318r0.setMultiChoiceListener(new b());
        B1(view);
    }

    public void E2(View view) {
        ContactTouchSearchView contactTouchSearchView = (ContactTouchSearchView) view.findViewById(R.id.spell_bar);
        this.f34968j = contactTouchSearchView;
        contactTouchSearchView.setVisibility(4);
        this.f34968j.setTouchSearchActionListener(this);
        this.f34968j.q(true);
    }

    public String F2() {
        EditText editText = this.f34970k;
        if (editText != null) {
            return editText.getText().toString();
        }
        return "";
    }

    public final void G2() {
        ImageView imageView = this.f34974m;
        if (imageView instanceof EffectiveAnimationView) {
            ((EffectiveAnimationView) imageView).cancelAnimation();
        }
        this.f34964h.setVisibility(8);
        this.f34974m.setVisibility(8);
    }

    public boolean H2() {
        return !F2().equals("");
    }

    public final void I2(ArrayList<String> arrayList) {
        Intent intent = new Intent();
        intent.putStringArrayListExtra("OPLUS_EMAILS", arrayList);
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    public void J2(V3.a aVar) {
        this.f34975m0 = aVar;
    }

    public final void K2(int i10) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f34974m.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.f34974m.setLayoutParams(layoutParams);
        this.f34974m.setImageDrawable(getContext().getDrawable(i10));
    }

    @Override // m1.G, m1.AbstractViewOnFocusChangeListenerC1314j, androidx.loader.app.a.InterfaceC0129a
    /* renamed from: S1 */
    public void S0(W.c<Cursor> cVar, Cursor cursor) {
        int i10;
        int i11;
        int i12;
        if (cursor != null && !(cursor instanceof C1322s)) {
            cursor = new C1322s(cursor);
        }
        super.S0(cVar, cursor);
        if (cVar.j() != 0) {
            return;
        }
        if (cursor != null) {
            i10 = cursor.getCount();
        } else {
            i10 = 0;
        }
        this.f34983r = i10;
        if (i10 > 0) {
            String format = String.format(getString(R.string.oplus_contact_email_count), U7.a.b(i10));
            G2();
            EditText editText = this.f34970k;
            if (editText != null) {
                editText.setHint(format);
                u1().setNestedScrollingEnabled(true);
            }
            if (this.f34960f) {
                this.f34968j.r();
                this.f34968j.setVisibility(4);
            } else {
                this.f34968j.setVisibility(0);
            }
        } else {
            EditText editText2 = this.f34970k;
            if (editText2 != null) {
                editText2.setHint(getString(R.string.listTotalAllContactsZero));
                u1().setNestedScrollingEnabled(false);
            }
            this.f34968j.r();
            this.f34968j.setVisibility(4);
            this.f34964h.setVisibility(0);
            TextView textView = this.f34964h;
            if (this.f34962g) {
                i11 = R.string.search_no_result;
            } else {
                i11 = R.string.noContacts;
            }
            textView.setText(i11);
            if (this.f34962g) {
                this.f21320t0.n(1);
                if (A7.a.a()) {
                    K2(R.drawable.pb_ic_no_searched_contact);
                } else if (this.f34974m.getVisibility() != 0) {
                    ImageView imageView = this.f34974m;
                    if (imageView instanceof EffectiveAnimationView) {
                        EffectiveAnimationView effectiveAnimationView = (EffectiveAnimationView) imageView;
                        if (com.android.contacts.framework.baseui.util.o.e(getContext())) {
                            i12 = R.raw.no_search_result_night;
                        } else {
                            i12 = R.raw.no_search_result;
                        }
                        effectiveAnimationView.setAnimation(i12);
                        ((EffectiveAnimationView) this.f34974m).playAnimation();
                    }
                }
            } else {
                this.f21320t0.n(0);
                K2(R.drawable.pb_ic_no_contact);
            }
            this.f34974m.setVisibility(0);
        }
        if (!this.f34960f) {
            com.customize.contacts.util.I i13 = this.f34966i;
            if (i13 != null) {
                i13.e(cursor);
            }
            g0.a(this.f34968j, (String[]) this.f34952b.getSections(), this.f34952b.L());
        }
        if (!this.f34960f && this.f34986z.c() == 0) {
            this.f34986z.f(cursor);
        } else {
            this.f34986z.h(cursor, H2());
        }
        Z3.i iVar = this.f34925B;
        if (iVar != null) {
            iVar.k();
        }
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void U1() {
        View view;
        View view2;
        String obj = this.f34970k.getText().toString();
        if (obj.isEmpty()) {
            this.f34962g = false;
        } else {
            this.f34962g = true;
        }
        if (TextUtils.isEmpty(obj)) {
            V3.a aVar = this.f34975m0;
            if (aVar != null) {
                aVar.d();
            }
            if (!A7.a.a() && (view2 = this.f34978o) != null) {
                view2.setVisibility(8);
            }
            m2("", true);
            return;
        }
        m2(obj, true);
        V3.a aVar2 = this.f34975m0;
        if (aVar2 != null) {
            aVar2.b();
        }
        if (!A7.a.a() && (view = this.f34978o) != null) {
            view.setVisibility(0);
        }
    }

    @Override // m1.G, m1.AbstractViewOnFocusChangeListenerC1314j
    public AbstractC1311g k1() {
        P3.e eVar = new P3.e(getActivity());
        eVar.P(true);
        eVar.w0(true);
        return eVar;
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (H7.a.b()) {
            H7.b.b("CustomizeEmailAddressPicker", "onConfigurationChanged");
        }
        ContactTouchSearchView contactTouchSearchView = this.f34968j;
        if (contactTouchSearchView != null) {
            contactTouchSearchView.q(true);
        }
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        int headerViewsCount = i10 - u1().getHeaderViewsCount();
        if (getActivity().getIntent().getAction().equals("com.oplus.contacts.ui.PICK_ONE_CONTACT_EMAIL")) {
            if (this.f34984x) {
                this.f34924A.a((CheckBox) view.findViewById(R.id.listview_scrollchoice_checkbox));
                this.f34925B.a();
                return;
            } else {
                String string = ((Cursor) ((P3.e) m1()).getItem(headerViewsCount)).getString(3);
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(string);
                I2(arrayList);
                return;
            }
        }
        Uri withAppendedId = ContentUris.withAppendedId(ContactsContract.Data.CONTENT_URI, j10);
        Intent intent = new Intent();
        intent.setData(withAppendedId);
        intent.setFlags(1);
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    @Override // com.coui.appcompat.list.COUIListView.ScrollMultiChoiceListener
    public void onItemTouch(int i10, View view) {
        CheckBox checkBox;
        if (view == null || !this.f34984x || (checkBox = (CheckBox) view.findViewById(R.id.listview_scrollchoice_checkbox)) == null) {
            return;
        }
        boolean z10 = true;
        boolean z11 = !checkBox.isChecked();
        if (this.f21319s0 == -1) {
            if (z11) {
                this.f21319s0 = 1;
            } else {
                this.f21319s0 = 0;
            }
        }
        if (this.f21319s0 != 1) {
            z10 = false;
        }
        checkBox.setChecked(z10);
        this.f34924A.b(checkBox);
        this.f34925B.a();
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
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
