package com.android.contacts.list;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.contacts.framework.baseui.util.o;
import com.android.contacts.framework.baseui.widget.EmptyViewGroup;
import com.android.contacts.list.ContactListItemView;
import com.android.contacts.list.f;
import com.android.contacts.util.C0700a;
import com.customize.contacts.util.I;
import com.customize.contacts.widget.ContactTouchSearchView;
import com.oplus.anim.EffectiveAnimationView;
import com.oplus.dialer.R;
import m1.AbstractC1311g;
import m1.AbstractC1316l;
import m1.AbstractViewOnFocusChangeListenerC1314j;
import m1.C1322s;
import m1.J;
import m1.O;

/* compiled from: PhoneNumberPickerFragment.java */
/* loaded from: classes.dex */
public class e extends AbstractViewOnFocusChangeListenerC1314j<AbstractC1311g> implements f.c {

    /* renamed from: w0, reason: collision with root package name */
    public static final String f16908w0 = "e";

    /* renamed from: q0, reason: collision with root package name */
    public O f16909q0;

    /* renamed from: r0, reason: collision with root package name */
    public String f16910r0;

    /* renamed from: s0, reason: collision with root package name */
    public ContactListFilter f16911s0;

    /* renamed from: t0, reason: collision with root package name */
    public EmptyViewGroup f16912t0;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f16913u0;

    /* renamed from: v0, reason: collision with root package name */
    public ContactListItemView.PhotoPosition f16914v0 = ContactListItemView.f16756I0;

    /* compiled from: PhoneNumberPickerFragment.java */
    /* loaded from: classes.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return e.this.onTouch(view, motionEvent);
        }
    }

    /* compiled from: PhoneNumberPickerFragment.java */
    /* loaded from: classes.dex */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return e.this.f34960f;
        }
    }

    public e() {
        n2(false);
        k2(true);
        p2(true);
        c2(3);
        setHasOptionsMenu(true);
    }

    private void C2() {
        ImageView imageView = this.f34974m;
        if (imageView instanceof EffectiveAnimationView) {
            ((EffectiveAnimationView) imageView).cancelAnimation();
        }
        this.f34964h.setVisibility(8);
        this.f34974m.setVisibility(8);
    }

    private void J2(int i10) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f34974m.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.f34974m.setLayoutParams(layoutParams);
        this.f34974m.setImageDrawable(getContext().getDrawable(i10));
    }

    private void z2(View view) {
        A2(view);
        u1().setOnTouchListener(new a());
        this.f34968j.setOnTouchListener(new b());
        this.f16912t0 = (EmptyViewGroup) view.findViewById(R.id.empty_view_group);
        this.f34974m = (ImageView) view.findViewById(R.id.no_content);
        TextView textView = (TextView) view.findViewById(R.id.empty_view);
        this.f34964h = textView;
        textView.setText(R.string.noContacts);
        B1(view);
        t2(false);
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void A1(View view) {
        super.A1(view);
        z2(view);
    }

    public void A2(View view) {
        ContactTouchSearchView contactTouchSearchView = (ContactTouchSearchView) view.findViewById(R.id.spell_bar);
        this.f34968j = contactTouchSearchView;
        contactTouchSearchView.setTouchSearchActionListener(this);
        this.f34968j.setVisibility(0);
        this.f34968j.q(true);
    }

    public String B2() {
        return this.f34970k.getText().toString();
    }

    @Override // com.android.contacts.list.f.c
    public void D(Uri uri, Intent intent) {
        this.f16909q0.a(intent);
    }

    public void D2(W.c<Cursor> cVar, Cursor cursor) {
        int i10;
        int i11;
        int i12;
        if (cursor != null) {
            i10 = cursor.getCount();
        } else {
            i10 = 0;
        }
        this.f34983r = i10;
        if (i10 > 0) {
            this.f34970k.setHint(String.format(getString(R.string.oplus_contact_number_count), U7.a.b(i10)));
            this.f34972l.setVisibility(0);
            C2();
            if (this.f34960f) {
                this.f34968j.r();
                this.f34968j.setVisibility(4);
            } else {
                this.f34968j.setVisibility(0);
            }
        } else {
            this.f34970k.setHint(getString(R.string.listTotalAllContactsZero));
            if (!J1()) {
                this.f34972l.setVisibility(4);
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
                this.f16912t0.n(1);
                if (A7.a.a()) {
                    J2(R.drawable.pb_ic_no_searched_contact);
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
                this.f16912t0.n(0);
                J2(R.drawable.pb_ic_no_contact);
            }
            this.f34974m.setVisibility(0);
        }
        I i13 = this.f34966i;
        if (i13 != null) {
            i13.e(cursor);
        }
    }

    public boolean E2() {
        return !B2().equals("");
    }

    public void F2(Uri uri) {
        if (this.f16910r0 == null) {
            this.f16909q0.c(uri);
        } else {
            if (!F1()) {
                new f(getActivity(), this).i(uri, this.f16910r0);
                return;
            }
            throw new UnsupportedOperationException();
        }
    }

    public void G2(O o10) {
        this.f16909q0 = o10;
    }

    public void H2(V3.a aVar) {
        this.f34975m0 = aVar;
    }

    public void I2(String str) {
        this.f16910r0 = str;
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void R1(int i10, long j10) {
        Uri uri;
        AbstractC1311g m12 = m1();
        if (m12 instanceof d) {
            uri = ((d) m12).Q0(i10);
        } else if (m12 instanceof J) {
            uri = ((J) m12).L0(i10);
        } else {
            uri = null;
        }
        if (uri != null) {
            F2(uri);
            return;
        }
        H7.b.i(f16908w0, "Item at " + i10 + " was clicked before adapter is ready. Ignoring");
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, androidx.loader.app.a.InterfaceC0129a
    /* renamed from: S1 */
    public void S0(W.c<Cursor> cVar, Cursor cursor) {
        boolean z10;
        if (getActivity() == null || cursor == null) {
            return;
        }
        if (!(cursor instanceof C1322s)) {
            cursor = new C1322s(cursor);
        }
        super.S0(cVar, cursor);
        if (cVar.j() != 0) {
            return;
        }
        V3.a aVar = this.f34975m0;
        if (aVar != null) {
            if (cursor.getCount() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            aVar.c(z10);
        }
        try {
            D2(cVar, cursor);
        } catch (Exception e10) {
            H7.b.c(f16908w0, "" + e10);
        }
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void U1() {
        View view;
        String obj = this.f34970k.getText().toString();
        int i10 = 0;
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
            m2("", true);
        } else {
            V3.a aVar2 = this.f34975m0;
            if (aVar2 != null) {
                aVar2.b();
            }
            m2(obj, true);
        }
        if (!A7.a.a() && (view = this.f34978o) != null) {
            if (TextUtils.isEmpty(obj)) {
                i10 = 8;
            }
            view.setVisibility(i10);
        }
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void X1(Bundle bundle) {
        super.X1(bundle);
        if (bundle == null) {
            return;
        }
        this.f16911s0 = (ContactListFilter) bundle.getParcelable("filter");
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void g1() {
        ContactListFilter contactListFilter;
        super.g1();
        AbstractC1311g m12 = m1();
        if (m12 == null) {
            return;
        }
        if (!J1() && (contactListFilter = this.f16911s0) != null) {
            m12.y0(contactListFilter);
        }
        if (!F1()) {
            ((d) m12).R0(this.f16914v0);
        }
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public AbstractC1311g k1() {
        if (!F1()) {
            d dVar = new d(getActivity());
            dVar.w0(true);
            return dVar;
        }
        J j10 = new J(getActivity());
        j10.w0(true);
        return j10;
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void o2(boolean z10) {
        super.o2(z10);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (i10 == 1) {
            if (getActivity() != null) {
                C0700a.d(AbstractC1316l.f(getActivity()), i11, intent);
            } else {
                H7.b.c(f16908w0, "getActivity() returns null during Fragment#onActivityResult()");
            }
        }
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            O o10 = this.f16909q0;
            if (o10 != null) {
                o10.b();
                return true;
            }
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("filter", this.f16911s0);
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void r2() {
        ContactTouchSearchView contactTouchSearchView = this.f34968j;
        if (contactTouchSearchView != null) {
            contactTouchSearchView.r();
        }
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void w2() {
        this.f16913u0 = true;
        super.w2();
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public View z1(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.contact_list_content, (ViewGroup) null);
    }
}
