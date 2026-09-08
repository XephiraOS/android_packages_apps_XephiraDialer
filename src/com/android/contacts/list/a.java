package com.android.contacts.list;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.contacts.ContactsApplication;
import com.android.contacts.framework.baseui.util.o;
import com.android.contacts.framework.baseui.widget.EmptyViewGroup;
import com.android.contacts.list.f;
import com.android.contacts.model.Account;
import com.coui.appcompat.searchview.COUISearchBar;
import com.customize.contacts.util.g0;
import com.customize.contacts.util.i0;
import com.customize.contacts.widget.ContactTouchSearchView;
import com.oplus.anim.EffectiveAnimationView;
import com.oplus.dialer.R;
import m1.AbstractC1311g;
import m1.AbstractC1315k;
import m1.AbstractViewOnFocusChangeListenerC1314j;
import m1.C1304B;
import m1.C1322s;
import m1.I;
import m1.M;

/* compiled from: ContactPickerFragment.java */
/* loaded from: classes.dex */
public class a extends AbstractViewOnFocusChangeListenerC1314j<AbstractC1311g> implements f.c {

    /* renamed from: q0, reason: collision with root package name */
    public M f16864q0;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f16868u0;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f16869v0;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f16870w0;

    /* renamed from: y0, reason: collision with root package name */
    public EmptyViewGroup f16872y0;

    /* renamed from: r0, reason: collision with root package name */
    public boolean f16865r0 = false;

    /* renamed from: s0, reason: collision with root package name */
    public boolean f16866s0 = false;

    /* renamed from: t0, reason: collision with root package name */
    public Account f16867t0 = null;

    /* renamed from: x0, reason: collision with root package name */
    public P3.a f16871x0 = null;

    /* compiled from: ContactPickerFragment.java */
    /* renamed from: com.android.contacts.list.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnTouchListenerC0170a implements View.OnTouchListener {
        public ViewOnTouchListenerC0170a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            a.this.r2();
            return a.this.onTouch(view, motionEvent);
        }
    }

    /* compiled from: ContactPickerFragment.java */
    /* loaded from: classes.dex */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return a.this.f34960f;
        }
    }

    public a() {
        k2(true);
        p2(true);
        t2(true);
        n2(false);
        c2(2);
    }

    private void C2() {
        ImageView imageView = this.f34974m;
        if (imageView instanceof EffectiveAnimationView) {
            ((EffectiveAnimationView) imageView).cancelAnimation();
        }
        this.f34964h.setVisibility(8);
        this.f34974m.setVisibility(8);
    }

    private void O2(int i10) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f34974m.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.f34974m.setLayoutParams(layoutParams);
        this.f34974m.setImageDrawable(getContext().getDrawable(i10));
    }

    private void z2(View view) {
        ContactTouchSearchView contactTouchSearchView = (ContactTouchSearchView) view.findViewById(R.id.spell_bar);
        this.f34968j = contactTouchSearchView;
        contactTouchSearchView.setTouchSearchActionListener(this);
        this.f34968j.setVisibility(4);
        i0.f(this.f34968j);
        u1().setOnTouchListener(new ViewOnTouchListenerC0170a());
        this.f34968j.setOnTouchListener(new b());
        this.f16872y0 = (EmptyViewGroup) view.findViewById(R.id.empty_view_group);
        TextView textView = (TextView) view.findViewById(R.id.empty_view);
        this.f34964h = textView;
        textView.setText(R.string.noContacts);
        this.f34974m = (ImageView) view.findViewById(R.id.no_content);
        B1(view);
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void A1(View view) {
        super.A1(view);
        z2(view);
    }

    public void A2(Uri uri) {
        M m10 = this.f16864q0;
        if (m10 != null) {
            m10.b(uri);
        }
    }

    public String B2() {
        EditText editText = this.f34970k;
        if (editText == null) {
            return "";
        }
        return editText.getText().toString();
    }

    @Override // com.android.contacts.list.f.c
    public void D(Uri uri, Intent intent) {
        M m10 = this.f16864q0;
        if (m10 != null) {
            m10.a(intent);
        }
    }

    public boolean D2() {
        return this.f16868u0;
    }

    public boolean E2() {
        return !B2().equals("");
    }

    public void F2(Uri uri) {
        M m10 = this.f16864q0;
        if (m10 != null) {
            m10.c(uri);
        }
    }

    public void G2(boolean z10) {
        this.f16869v0 = z10;
    }

    public void H2(boolean z10) {
        this.f16866s0 = z10;
    }

    public void I2(boolean z10) {
        this.f16865r0 = z10;
        if (H7.a.b()) {
            H7.b.b("ContactPickerFragment", "mIsForAddContactsToGroup = " + this.f16865r0);
        }
    }

    public void J2(boolean z10) {
        this.f34928E = z10;
    }

    public void K2(M m10) {
        this.f16864q0 = m10;
    }

    public void L2(Intent intent) {
        this.f34927D = intent;
    }

    public void M2(V3.a aVar) {
        this.f34975m0 = aVar;
    }

    public void N2(boolean z10) {
        this.f16870w0 = z10;
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void R1(int i10, long j10) {
        Uri S02;
        if (F1()) {
            S02 = ((I) m1()).L0(i10);
        } else {
            S02 = ((AbstractC1315k) m1()).S0(i10);
        }
        if (this.f16869v0) {
            A2(S02);
        } else if (this.f16870w0) {
            new f(getActivity(), this).g(S02);
        } else {
            F2(S02);
        }
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, androidx.loader.app.a.InterfaceC0129a
    /* renamed from: S1 */
    public void S0(W.c<Cursor> cVar, Cursor cursor) {
        int i10;
        int i11;
        int i12;
        COUISearchBar cOUISearchBar;
        boolean z10;
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
        V3.a aVar = this.f34975m0;
        if (aVar != null) {
            if (i10 > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            aVar.c(z10);
        }
        if (i10 > 0) {
            String format = String.format(getString(R.string.oplus_contact_count), U7.a.b(i10));
            C2();
            EditText editText = this.f34970k;
            if (editText != null) {
                editText.setHint(format);
                u1().setNestedScrollingEnabled(true);
            }
            COUISearchBar cOUISearchBar2 = this.f34972l;
            if (cOUISearchBar2 != null) {
                cOUISearchBar2.setVisibility(0);
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
            if (!J1() && (cOUISearchBar = this.f34972l) != null) {
                cOUISearchBar.setVisibility(4);
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
                this.f16872y0.n(1);
                if (A7.a.a()) {
                    O2(R.drawable.pb_ic_no_searched_contact);
                } else if (this.f34974m.getVisibility() != 0) {
                    ImageView imageView = this.f34974m;
                    if (imageView instanceof EffectiveAnimationView) {
                        EffectiveAnimationView effectiveAnimationView = (EffectiveAnimationView) imageView;
                        if (o.e(getContext())) {
                            i12 = R.raw.no_search_result_night;
                        } else {
                            i12 = R.raw.no_search_result;
                        }
                        effectiveAnimationView.setAnimation(i12);
                        ((EffectiveAnimationView) this.f34974m).playAnimation();
                    }
                }
            } else {
                this.f16872y0.n(0);
                O2(R.drawable.pb_ic_no_contact);
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
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void U1() {
        View view;
        View view2;
        String obj = this.f34970k.getText().toString();
        if (obj.isEmpty()) {
            this.f34962g = false;
            V3.a aVar = this.f34975m0;
            if (aVar != null) {
                aVar.d();
                if (!A7.a.a() && (view2 = this.f34978o) != null) {
                    view2.setVisibility(8);
                }
            }
        } else {
            this.f34962g = true;
            V3.a aVar2 = this.f34975m0;
            if (aVar2 != null) {
                aVar2.b();
                if (!A7.a.a() && (view = this.f34978o) != null) {
                    view.setVisibility(0);
                }
            }
        }
        if (TextUtils.isEmpty(obj)) {
            m2("", true);
        } else {
            m2(obj, true);
        }
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void V1() {
        ContactListFilter n10;
        if (!this.f16865r0) {
            if (this.f34952b != 0) {
                Account account = this.f16867t0;
                if (account != null) {
                    n10 = ContactListFilter.f(account.f16942b, account.f16941a, null, null, false, null);
                } else {
                    n10 = ContactListFilter.n(PreferenceManager.getDefaultSharedPreferences(ContactsApplication.h().getApplicationContext()));
                }
                n10.f16745i = this.f16866s0;
                this.f34952b.y0(n10);
            }
        } else if (this.f34952b != 0) {
            ContactListFilter h10 = ContactListFilter.h(-2);
            h10.f16745i = this.f16866s0;
            this.f34952b.y0(h10);
        }
        super.V1();
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void X1(Bundle bundle) {
        super.X1(bundle);
        if (bundle == null) {
            return;
        }
        this.f16869v0 = bundle.getBoolean("editMode");
        this.f16868u0 = bundle.getBoolean("createContactEnabled");
        this.f16870w0 = bundle.getBoolean("shortcutRequested");
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void g1() {
        super.g1();
        m1().x0(!D2());
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
        this.f16871x0 = aVar;
        return aVar;
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public AbstractC1311g k1() {
        if (!F1()) {
            C1304B c1304b = new C1304B(getActivity());
            ContactListFilter n10 = ContactListFilter.n(PreferenceManager.getDefaultSharedPreferences(getActivity()));
            n10.f16745i = this.f16866s0;
            c1304b.y0(n10);
            c1304b.P(true);
            c1304b.w0(true);
            c1304b.E0(false);
            Intent intent = this.f34927D;
            if (intent != null) {
                c1304b.A1(intent);
            }
            if (this.f34928E) {
                c1304b.t1(true);
            }
            return c1304b;
        }
        I i10 = new I(getActivity());
        i10.P(false);
        i10.w0(false);
        return i10;
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        i0.e(null);
        i0.f(null);
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        M m10;
        if (!C7.a.a()) {
            if (i10 == 0 && this.f16868u0 && (m10 = this.f16864q0) != null) {
                m10.d();
            } else {
                super.onItemClick(adapterView, view, i10, j10);
            }
        }
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, com.customize.contacts.widget.TouchSearchView.d
    public void onKey(CharSequence charSequence) {
        l1(charSequence);
        if (charSequence.equals("*")) {
            this.f34968j.setFirstKeyPopupDrawable(requireActivity().getDrawable(2131232622));
            return;
        }
        this.f34968j.setFirstKeyPopupDrawable(null);
        if (charSequence.equals("#")) {
            this.f34968j.setName(new String[0]);
        } else {
            this.f34966i.i(charSequence);
        }
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f34966i == null) {
            this.f34966i = new com.customize.contacts.util.I(this.f34968j, u1(), requireActivity().getContentResolver());
        }
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("editMode", this.f16869v0);
        bundle.putBoolean("createContactEnabled", this.f16868u0);
        bundle.putBoolean("shortcutRequested", this.f16870w0);
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i10) {
        if (i10 != 2 && i10 != 1) {
            P3.a aVar = this.f16871x0;
            if (aVar != null) {
                aVar.W(false);
                if (this.f16871x0.U()) {
                    this.f16871x0.p();
                    this.f16871x0.V(false);
                }
            }
        } else {
            P3.a aVar2 = this.f16871x0;
            if (aVar2 != null) {
                aVar2.W(true);
            }
        }
        super.onScrollStateChanged(absListView, i10);
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public View z1(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.contact_list_content, (ViewGroup) null);
    }
}
