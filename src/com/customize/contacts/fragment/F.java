package com.customize.contacts.fragment;

import E1.a;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.contacts.framework.api.rcs.IRcsApi;
import com.android.contacts.framework.baseui.widget.EmptyViewGroup;
import com.android.contacts.list.ContactListFilter;
import com.coui.appcompat.grid.COUIPercentUtils;
import com.coui.appcompat.searchview.COUISearchBar;
import com.customize.contacts.activities.ContactsForSmsActivity;
import com.customize.contacts.util.b0;
import com.customize.contacts.util.k0;
import com.customize.contacts.widget.ContactTouchSearchView;
import com.oplus.anim.EffectiveAnimationView;
import com.oplus.dialer.R;
import m1.AbstractC1311g;
import m1.C1322s;

/* compiled from: PhoneNumberOrEmailPickerFragment.java */
/* loaded from: classes3.dex */
public class F extends p {

    /* renamed from: B0, reason: collision with root package name */
    public P3.g f21221B0;

    /* renamed from: E0, reason: collision with root package name */
    public ContactsForSmsActivity f21224E0;

    /* renamed from: F0, reason: collision with root package name */
    public int f21225F0;

    /* renamed from: G0, reason: collision with root package name */
    public androidx.appcompat.app.b f21226G0;

    /* renamed from: H0, reason: collision with root package name */
    public int f21227H0;

    /* renamed from: I0, reason: collision with root package name */
    public long f21228I0;

    /* renamed from: J0, reason: collision with root package name */
    public String f21229J0;

    /* renamed from: N0, reason: collision with root package name */
    public Cursor f21233N0;

    /* renamed from: O0, reason: collision with root package name */
    public EmptyViewGroup f21234O0;

    /* renamed from: C0, reason: collision with root package name */
    public boolean f21222C0 = true;

    /* renamed from: D0, reason: collision with root package name */
    public boolean f21223D0 = false;

    /* renamed from: K0, reason: collision with root package name */
    public boolean f21230K0 = false;

    /* renamed from: L0, reason: collision with root package name */
    public boolean f21231L0 = false;

    /* renamed from: M0, reason: collision with root package name */
    public boolean f21232M0 = false;

    /* renamed from: P0, reason: collision with root package name */
    public View.OnClickListener f21235P0 = new a();

    /* compiled from: PhoneNumberOrEmailPickerFragment.java */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            F.this.r2();
            Intent intent = new Intent(k0.f22137a, ContactsContract.Contacts.CONTENT_URI);
            intent.putExtra("finishActivityOnSaveCompleted", true);
            F.this.startActivityForResult(intent, 341);
        }
    }

    /* compiled from: PhoneNumberOrEmailPickerFragment.java */
    /* loaded from: classes3.dex */
    public class b implements IRcsApi.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21237a;

        public b(int i10) {
            this.f21237a = i10;
        }

        @Override // com.android.contacts.framework.api.rcs.IRcsApi.a
        public void a(String str, boolean z10, String str2, boolean z11) {
            F.this.f21227H0++;
            boolean c10 = com.android.contacts.framework.api.rcs.a.c(str.substring(3));
            if (c10) {
                F.this.f34986z.k(F.this.f21228I0, null, str.substring(3), true);
            }
            if (H7.a.b()) {
                H7.b.b("PhoneNumberOrEmailPickerFragment", "onCap: isRcs = " + c10);
            }
            if (F.this.f21227H0 == this.f21237a) {
                F.this.f21231L0 = true;
                F.this.f21221B0.notifyDataSetChanged();
                F.this.f34986z.n(F.this.f21233N0, false);
                F.this.f34925B.a();
                F.this.f3();
            }
        }
    }

    /* compiled from: PhoneNumberOrEmailPickerFragment.java */
    /* loaded from: classes3.dex */
    public class c extends AsyncTask<Void, Void, Integer> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Cursor f21239a;

        public c(Cursor cursor) {
            this.f21239a = cursor;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(Void... voidArr) {
            try {
                this.f21239a.moveToPosition(-1);
                while (!this.f21239a.isClosed() && this.f21239a.moveToNext()) {
                    long j10 = this.f21239a.getLong(4);
                    String string = this.f21239a.getString(3);
                    if (j10 == F.this.f21228I0 && string.equals(F.this.f21229J0)) {
                        return Integer.valueOf(this.f21239a.getPosition());
                    }
                }
            } catch (Exception e10) {
                H7.b.c("testtest", "doInBackground: " + e10);
            }
            return 0;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            a.C0010a K10 = F.this.f21221B0.K(num.intValue());
            F.this.f21221B0.notifyDataSetChanged();
            if (K10.f478a) {
                F.this.f34950a.setSelection(num.intValue());
            } else {
                F.this.f34950a.setSelectionFromTop(num.intValue(), 102);
            }
            F.this.f21232M0 = true;
            F.this.f3();
        }
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
        this.f34974m.setImageDrawable(requireContext().getDrawable(i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f3() {
        androidx.appcompat.app.b bVar = this.f21226G0;
        if (bVar != null && bVar.isShowing() && this.f21232M0 && this.f21231L0) {
            this.f21226G0.dismiss();
        }
    }

    private void p3(Context context) {
        if (context != null && this.f34968j != null) {
            if (COUIPercentUtils.getTotalGridSize(context) > context.getResources().getInteger(R.integer.grid_guide_column_preference)) {
                this.f34968j.q(false);
            } else {
                this.f34968j.q(true);
            }
        }
    }

    @Override // com.customize.contacts.fragment.p, com.android.contacts.list.e, m1.AbstractViewOnFocusChangeListenerC1314j
    public void A1(View view) {
        RelativeLayout relativeLayout;
        super.A1(view);
        COUISearchBar cOUISearchBar = this.f34972l;
        if (cOUISearchBar != null) {
            cOUISearchBar.setVisibility(4);
        }
        View findViewById = view.findViewById(R.id.contact_list_view);
        this.f21234O0 = (EmptyViewGroup) view.findViewById(R.id.empty_view_group);
        if (B3.a.d0()) {
            RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.sms_add_contact_layout);
            this.f34931H = relativeLayout2;
            relativeLayout2.setOnClickListener(this.f21235P0);
        }
        if (this.f21223D0 && (relativeLayout = this.f34931H) != null) {
            relativeLayout.setVisibility(0);
        }
        u1().setNestedScrollingEnabled(true);
        u1().setTag(findViewById);
        u1().setOnTouchListener(new View.OnTouchListener() { // from class: com.customize.contacts.fragment.E
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean k32;
                k32 = F.this.k3(view2, motionEvent);
                return k32;
            }
        });
        R2();
        if (B3.a.g() && b0.l0(getActivity())) {
            C1(LayoutInflater.from(getContext()));
            if (u1() != null && q1() != null) {
                u1().addHeaderView(q1());
            }
        }
        int a10 = com.android.contacts.framework.baseui.util.B.a(getActivity());
        int dimensionPixelOffset = requireActivity().getResources().getDimensionPixelOffset(R.dimen.large_toolbar_height) + requireActivity().getResources().getDimensionPixelOffset(R.dimen.tablayout_small_layout_height) + a10;
        this.f21225F0 = requireActivity().getResources().getDimensionPixelOffset(R.dimen.search_view_height) + dimensionPixelOffset + requireActivity().getResources().getDimensionPixelOffset(R.dimen.list_padding_top);
        COUISearchBar cOUISearchBar2 = this.f34972l;
        if (cOUISearchBar2 != null) {
            ((ViewGroup.MarginLayoutParams) cOUISearchBar2.getLayoutParams()).topMargin = dimensionPixelOffset;
            this.f34972l.setExtraActivateMarginTop(a10);
        }
        n3(this.f21225F0);
        p3(getActivity());
    }

    @Override // com.android.contacts.list.e
    public void A2(View view) {
        ContactTouchSearchView contactTouchSearchView = (ContactTouchSearchView) view.findViewById(R.id.spell_bar);
        this.f34968j = contactTouchSearchView;
        contactTouchSearchView.setTouchSearchActionListener(this);
        this.f34968j.setVisibility(4);
    }

    @Override // com.android.contacts.list.e
    public void D2(W.c<Cursor> cVar, Cursor cursor) {
        int i10;
        boolean z10;
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
            C2();
            if (this.f34960f) {
                this.f34968j.r();
                this.f34968j.setVisibility(4);
            } else {
                this.f34968j.setVisibility(0);
            }
        } else {
            if (B3.a.g() && b0.l0(getActivity())) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f34970k.setHint(getString(R.string.listTotalAllContactsZero));
            this.f34968j.r();
            if (!z10) {
                this.f34964h.setVisibility(0);
                TextView textView = this.f34964h;
                if (this.f34962g) {
                    i11 = R.string.search_no_result;
                } else {
                    i11 = R.string.noContacts;
                }
                textView.setText(i11);
                if (this.f34962g) {
                    this.f21234O0.n(1);
                    this.f21234O0.k(0);
                    if (A7.a.a()) {
                        J2(R.drawable.pb_ic_no_searched_contact);
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
                    this.f21234O0.n(0);
                    this.f21234O0.k(getResources().getDimensionPixelSize(R.dimen.tablayout_small_layout_height));
                    J2(R.drawable.pb_ic_no_contact);
                }
                this.f34974m.setVisibility(0);
            }
            this.f34968j.setVisibility(4);
        }
        com.customize.contacts.util.I i13 = this.f34966i;
        if (i13 != null) {
            i13.e(cursor);
        }
    }

    @Override // com.customize.contacts.fragment.p, com.android.contacts.list.e, m1.AbstractViewOnFocusChangeListenerC1314j, androidx.loader.app.a.InterfaceC0129a
    /* renamed from: S1 */
    public void S0(W.c<Cursor> cVar, Cursor cursor) {
        int i10;
        boolean z10;
        if (cursor != null && B3.a.d0() && !(cursor instanceof C1322s)) {
            cursor = new C1322s(cursor);
        }
        this.f21233N0 = cursor;
        super.S0(cVar, cursor);
        if (cVar.j() != 0) {
            return;
        }
        if (cursor != null && B3.a.d0() && cVar.j() == 0 && !this.f21232M0 && this.f21230K0) {
            l3(cursor);
        }
        boolean z11 = true;
        if (cursor != null && !cursor.isClosed() && this.f34972l != null && !this.f34960f) {
            if (!B3.a.g() || !b0.l0(getActivity())) {
                COUISearchBar cOUISearchBar = this.f34972l;
                if (cursor.getCount() > 0) {
                    i10 = 0;
                } else {
                    i10 = 8;
                }
                cOUISearchBar.setVisibility(i10);
            }
            COUISearchBar cOUISearchBar2 = this.f34972l;
            if (cursor.getCount() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            cOUISearchBar2.setEnabled(z10);
        }
        if (this.f34960f) {
            if (this.f34975m0 != null && cursor != null && !cursor.isClosed()) {
                V3.a aVar = this.f34975m0;
                if (cursor.getCount() <= 0) {
                    z11 = false;
                }
                aVar.c(z11);
                return;
            }
            return;
        }
        V3.a aVar2 = this.f34975m0;
        if (aVar2 != null) {
            aVar2.c(false);
        }
    }

    @Override // com.customize.contacts.fragment.p, m1.AbstractViewOnFocusChangeListenerC1314j
    public void V1() {
        P3.g gVar = this.f21221B0;
        if (gVar != null) {
            gVar.y0(ContactListFilter.n(PreferenceManager.getDefaultSharedPreferences(getActivity())));
        }
        super.V1();
    }

    public View g3() {
        return this.f34980p;
    }

    public int h3() {
        return this.f21225F0;
    }

    public View i3() {
        return this.f34978o;
    }

    public final void j3(Intent intent) {
        String[] split = C7.e.l(intent, "number").split(",");
        b bVar = new b(split.length);
        for (String str : split) {
            if (com.android.contacts.framework.api.rcs.a.c(str)) {
                this.f34986z.l(this.f21228I0, null, str, true, false);
            }
            com.android.contacts.framework.api.rcs.a.f(str, bVar, true);
        }
    }

    @Override // com.customize.contacts.fragment.p, com.android.contacts.list.e, m1.AbstractViewOnFocusChangeListenerC1314j
    public AbstractC1311g k1() {
        this.f21224E0 = (ContactsForSmsActivity) getActivity();
        P3.g gVar = new P3.g(getActivity());
        this.f21221B0 = gVar;
        gVar.y0(ContactListFilter.n(PreferenceManager.getDefaultSharedPreferences(getActivity())));
        this.f21221B0.w0(true);
        this.f21221B0.U0(this.f21222C0);
        this.f21221B0.W0(this.f21223D0);
        this.f21221B0.V0(this.f34950a);
        return this.f21221B0;
    }

    public final /* synthetic */ boolean k3(View view, MotionEvent motionEvent) {
        r2();
        return onTouch(view, motionEvent);
    }

    public final void l3(Cursor cursor) {
        new c(cursor).execute(new Void[0]);
    }

    public void m3(boolean z10) {
        this.f21222C0 = z10;
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public COUISearchBar n1() {
        return this.f34972l;
    }

    public final void n3(int i10) {
        ListView listView = this.f34950a;
        if (listView == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) listView.getLayoutParams();
        marginLayoutParams.topMargin = i10;
        this.f34950a.setLayoutParams(marginLayoutParams);
    }

    public void o3(boolean z10) {
        this.f21223D0 = z10;
    }

    @Override // com.android.contacts.list.e, androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (B3.a.d0() && i10 == 341 && -1 == i11 && C7.e.l(intent, "number") != null && !C7.e.l(intent, "number").equals("")) {
            this.f21228I0 = C7.e.f(intent, "CONTACT_ID", -1L);
            this.f21229J0 = C7.e.l(intent, "number").split(",")[0];
            this.f21230K0 = true;
            this.f21232M0 = false;
            this.f21227H0 = 0;
            this.f21226G0 = U0.k.o(getActivity(), getString(R.string.loading));
            j3(intent);
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (H7.a.b()) {
            H7.b.b("PhoneNumberOrEmailPickerFragment", "onConfigurationChanged");
        }
        p3(getContext());
    }

    @Override // com.customize.contacts.fragment.p, m1.AbstractViewOnFocusChangeListenerC1314j, com.coui.appcompat.searchview.COUISearchBar.OnStateChangeListener
    public void onStateChange(int i10, int i11) {
        if (this.f21224E0 != null) {
            if (i11 == 1) {
                u1().setNestedScrollingEnabled(false);
                s2(false);
                Y1(false);
                e2(true);
                V3.a aVar = this.f34975m0;
                if (aVar != null) {
                    aVar.e();
                    return;
                }
                return;
            }
            if (i11 == 0) {
                u1().setNestedScrollingEnabled(true);
                s2(true);
                Y1(true);
                e2(false);
                V3.a aVar2 = this.f34975m0;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }
        }
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void y2() {
        COUISearchBar cOUISearchBar = this.f34972l;
        if (cOUISearchBar == null) {
            return;
        }
        cOUISearchBar.setBackgroundResource(R.drawable.pb_bg_search_view);
    }

    @Override // com.android.contacts.list.e, m1.AbstractViewOnFocusChangeListenerC1314j
    public View z1(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.contact_sms_list_content_view, (ViewGroup) null);
    }
}
