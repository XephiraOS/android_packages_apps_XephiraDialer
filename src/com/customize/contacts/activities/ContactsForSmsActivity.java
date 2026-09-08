package com.customize.contacts.activities;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import androidx.appcompat.app.ActionBar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.android.contacts.framework.baseui.behavior.SmallTabBehavior;
import com.android.contacts.framework.baseui.util.C0636a;
import com.coloros.contacts.common.ContactParcelable;
import com.coui.appcompat.bottomnavigation.COUINavigationView;
import com.coui.appcompat.statusbar.COUIStatusBarResponseUtil;
import com.coui.appcompat.tablayout.COUITab;
import com.coui.appcompat.tablayout.COUITabLayout;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.fragment.C0783h;
import com.customize.contacts.util.C0792c;
import com.customize.contacts.util.C0811w;
import com.customize.contacts.widget.ContactsViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationBarView;
import com.oplus.dialer.R;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ContactsForSmsActivity extends SearchAnimatorsActivity implements Z3.i, View.OnTouchListener, COUIStatusBarResponseUtil.StatusBarClickListener {

    /* renamed from: Q, reason: collision with root package name */
    public C0783h f20193Q;

    /* renamed from: R, reason: collision with root package name */
    public com.customize.contacts.fragment.A f20194R;

    /* renamed from: S, reason: collision with root package name */
    public com.customize.contacts.fragment.F f20195S;

    /* renamed from: T, reason: collision with root package name */
    public BroadcastReceiver f20196T;

    /* renamed from: X, reason: collision with root package name */
    public N3.d f20200X;

    /* renamed from: c0, reason: collision with root package name */
    public ContactsViewPager f20205c0;

    /* renamed from: d0, reason: collision with root package name */
    public FrameLayout f20206d0;

    /* renamed from: e0, reason: collision with root package name */
    public com.customize.contacts.widget.c f20207e0;

    /* renamed from: g0, reason: collision with root package name */
    public MenuItem f20209g0;

    /* renamed from: h0, reason: collision with root package name */
    public COUIStatusBarResponseUtil f20210h0;

    /* renamed from: j0, reason: collision with root package name */
    public SmallTabBehavior f20212j0;

    /* renamed from: U, reason: collision with root package name */
    public ArrayList<ContactParcelable> f20197U = null;

    /* renamed from: V, reason: collision with root package name */
    public boolean f20198V = false;

    /* renamed from: W, reason: collision with root package name */
    public boolean f20199W = false;

    /* renamed from: Y, reason: collision with root package name */
    public boolean f20201Y = true;

    /* renamed from: Z, reason: collision with root package name */
    public boolean f20202Z = false;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f20203a0 = true;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f20204b0 = false;

    /* renamed from: f0, reason: collision with root package name */
    public int f20208f0 = 2;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f20211i0 = false;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f20213k0 = false;

    /* loaded from: classes3.dex */
    public enum TabState {
        CALLS,
        GROUPS,
        ALL
    }

    /* loaded from: classes3.dex */
    public class a extends com.customize.contacts.widget.c {

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String[] f20218g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FragmentManager fragmentManager, String[] strArr) {
            super(fragmentManager);
            this.f20218g = strArr;
        }

        @Override // androidx.fragment.app.w
        public long a(int i10) {
            if (ContactsForSmsActivity.this.f20211i0) {
                return 0L;
            }
            if (CommonFeatureOption.j()) {
                if (ContactsForSmsActivity.this.z2()) {
                    if (i10 == 0) {
                        return 0L;
                    }
                    if (i10 == 1) {
                        return 1L;
                    }
                    if (i10 == 2) {
                        return 2L;
                    }
                } else {
                    if (i10 == 0) {
                        return 0L;
                    }
                    if (i10 == 1) {
                        return 2L;
                    }
                }
            } else if (ContactsForSmsActivity.this.z2()) {
                if (i10 == 0) {
                    return 1L;
                }
                if (i10 == 1) {
                    return 2L;
                }
            } else if (i10 == 0) {
                return 2L;
            }
            return super.a(i10);
        }

        @Override // androidx.viewpager.widget.a
        public int getCount() {
            return this.f20218g.length;
        }

        @Override // androidx.fragment.app.w
        public Fragment getItem(int i10) {
            int a10 = (int) a(i10);
            if (a10 != 0) {
                if (a10 != 1) {
                    if (a10 != 2) {
                        return null;
                    }
                    if (ContactsForSmsActivity.this.f20195S == null) {
                        ContactsForSmsActivity.this.f20195S = new com.customize.contacts.fragment.F();
                        ContactsForSmsActivity.this.f20195S.m3(ContactsForSmsActivity.this.f20201Y);
                        ContactsForSmsActivity.this.f20195S.Q2(ContactsForSmsActivity.this);
                        ContactsForSmsActivity.this.f20195S.H2(new e());
                    }
                    return ContactsForSmsActivity.this.f20195S;
                }
                if (ContactsForSmsActivity.this.f20194R == null) {
                    ContactsForSmsActivity.this.f20194R = new com.customize.contacts.fragment.A();
                    ContactsForSmsActivity.this.f20194R.p1(ContactsForSmsActivity.this.f20201Y);
                    ContactsForSmsActivity.this.f20194R.r1(ContactsForSmsActivity.this);
                    if (ContactsForSmsActivity.this.f20202Z) {
                        ContactsForSmsActivity.this.f20194R.q1(true);
                    }
                }
                return ContactsForSmsActivity.this.f20194R;
            }
            if (ContactsForSmsActivity.this.f20211i0) {
                if (ContactsForSmsActivity.this.f20195S == null) {
                    ContactsForSmsActivity.this.f20195S = new com.customize.contacts.fragment.F();
                    ContactsForSmsActivity.this.f20195S.m3(ContactsForSmsActivity.this.f20201Y);
                    ContactsForSmsActivity.this.f20195S.o3(ContactsForSmsActivity.this.f20211i0);
                    ContactsForSmsActivity.this.f20195S.Q2(ContactsForSmsActivity.this);
                    ContactsForSmsActivity.this.f20195S.H2(new e());
                }
                return ContactsForSmsActivity.this.f20195S;
            }
            if (ContactsForSmsActivity.this.f20193Q == null) {
                ContactsForSmsActivity.this.f20193Q = new C0783h();
                ContactsForSmsActivity.this.f20193Q.p1(ContactsForSmsActivity.this);
            }
            return ContactsForSmsActivity.this.f20193Q;
        }

        @Override // androidx.viewpager.widget.a
        public CharSequence getPageTitle(int i10) {
            return this.f20218g[i10];
        }
    }

    /* loaded from: classes3.dex */
    public final class b extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("com.oplus.contacts.display_settings_changed".equals(intent.getAction())) {
                if (ContactsForSmsActivity.this.f20195S != null) {
                    ContactsForSmsActivity.this.f20195S.V1();
                }
                if (ContactsForSmsActivity.this.f20194R != null) {
                    ContactsForSmsActivity.this.f20194R.t1();
                }
                if (ContactsForSmsActivity.this.f20193Q != null) {
                    ContactsForSmsActivity.this.f20193Q.q1();
                }
            }
        }

        public b() {
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ViewPager.i {
        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageScrolled(int i10, float f10, int i11) {
            if (ContactsForSmsActivity.this.f20195S != null) {
                ContactsForSmsActivity.this.f20195S.r2();
            }
        }

        public c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageScrollStateChanged(int i10) {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageSelected(int i10) {
        }
    }

    /* loaded from: classes3.dex */
    public class d implements COUITabLayout.OnTabSelectedListener {
        @Override // com.coui.appcompat.tablayout.COUITabLayout.OnTabSelectedListener
        public void onTabSelected(COUITab cOUITab) {
            ContactsForSmsActivity.this.t2(cOUITab.getPosition());
        }

        public d() {
        }

        @Override // com.coui.appcompat.tablayout.COUITabLayout.OnTabSelectedListener
        public void onTabReselected(COUITab cOUITab) {
        }

        @Override // com.coui.appcompat.tablayout.COUITabLayout.OnTabSelectedListener
        public void onTabUnselected(COUITab cOUITab) {
        }
    }

    /* loaded from: classes3.dex */
    public class e implements V3.a {
        @Override // V3.a
        public void a() {
            ContactsForSmsActivity.this.n2();
        }

        @Override // V3.a
        public void b() {
            ContactsForSmsActivity.this.f20213k0 = true;
            View view = ContactsForSmsActivity.this.f20570r;
            if (view != null) {
                view.setVisibility(8);
            }
            if (ContactsForSmsActivity.this.f20195S != null) {
                ContactsForSmsActivity.this.f20195S.i3().setVisibility(0);
            }
        }

        @Override // V3.a
        public void c(boolean z10) {
            boolean z11;
            ContactsForSmsActivity contactsForSmsActivity = ContactsForSmsActivity.this;
            if (z10 && contactsForSmsActivity.f20213k0) {
                z11 = true;
            } else {
                z11 = false;
            }
            contactsForSmsActivity.K2(z11);
        }

        @Override // V3.a
        public void d() {
            ContactsForSmsActivity.this.f20213k0 = false;
            View view = ContactsForSmsActivity.this.f20570r;
            if (view != null) {
                view.setVisibility(0);
            }
            if (ContactsForSmsActivity.this.f20195S != null) {
                ContactsForSmsActivity.this.f20195S.i3().setVisibility(8);
            }
        }

        @Override // V3.a
        public void e() {
            ContactsForSmsActivity.this.o2();
        }

        public e() {
        }
    }

    private void E2() {
        this.f20196T = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.oplus.contacts.display_settings_changed");
        X.a.b(this).c(this.f20196T, intentFilter);
    }

    private void F2(boolean z10) {
        ContactsViewPager contactsViewPager = this.f20205c0;
        if (contactsViewPager != null) {
            contactsViewPager.setCanScrolling(z10);
        }
    }

    private void q2() {
        setContentView(R.layout.contacts_for_sms_activity);
        W1((COUITabLayout) findViewById(R.id.color_tab_layout));
        this.f20572y = (AppBarLayout) findViewById(R.id.appbar);
        this.f20571x = (COUIToolbar) findViewById(R.id.toolbar);
        ContactsViewPager contactsViewPager = (ContactsViewPager) findViewById(R.id.view_pager);
        this.f20205c0 = contactsViewPager;
        contactsViewPager.setOffscreenPageLimit(2);
        this.f20205c0.addOnPageChangeListener(new c());
        setSupportActionBar(this.f20571x);
        this.f20571x.setTitle(R.string.oplus_select_phones);
        boolean z10 = true;
        this.f20571x.setIsTitleCenterStyle(true);
        u2();
        View b10 = com.android.contacts.framework.baseui.util.B.b(this, false);
        this.f20572y.addView(b10, 0, b10.getLayoutParams());
        COUIStatusBarResponseUtil cOUIStatusBarResponseUtil = new COUIStatusBarResponseUtil(this);
        this.f20210h0 = cOUIStatusBarResponseUtil;
        cOUIStatusBarResponseUtil.setStatusBarClickListener(this);
        SmallTabBehavior smallTabBehavior = (SmallTabBehavior) ((CoordinatorLayout.e) this.f20572y.getLayoutParams()).f();
        this.f20212j0 = smallTabBehavior;
        if (smallTabBehavior != null) {
            smallTabBehavior.c(true);
            SmallTabBehavior smallTabBehavior2 = this.f20212j0;
            if (this.f20208f0 == 2) {
                z10 = false;
            }
            smallTabBehavior2.d(z10);
        }
    }

    private int r2() {
        int i10;
        if (this.f20211i0) {
            return 0;
        }
        if (CommonFeatureOption.j()) {
            if (z2()) {
                return this.f20208f0;
            }
            if (this.f20208f0 == 2) {
                return 1;
            }
        } else if (z2() && (i10 = this.f20208f0) > 0) {
            return i10 - 1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t2(int i10) {
        int a10 = (int) this.f20207e0.a(i10);
        if (a10 == 0) {
            SmallTabBehavior smallTabBehavior = this.f20212j0;
            if (smallTabBehavior != null) {
                smallTabBehavior.d(true);
            }
            if (this.f20211i0) {
                if (this.f20208f0 == 2) {
                    return;
                }
                com.customize.contacts.util.i0.b();
                this.f20208f0 = 2;
            } else {
                if (this.f20208f0 == 0) {
                    return;
                }
                com.customize.contacts.util.i0.b();
                this.f20208f0 = 0;
            }
        } else if (a10 == 1) {
            SmallTabBehavior smallTabBehavior2 = this.f20212j0;
            if (smallTabBehavior2 != null) {
                smallTabBehavior2.d(true);
            }
            if (this.f20208f0 == 1) {
                return;
            }
            com.customize.contacts.util.i0.b();
            this.f20208f0 = 1;
        } else if (a10 == 2) {
            SmallTabBehavior smallTabBehavior3 = this.f20212j0;
            if (smallTabBehavior3 != null) {
                smallTabBehavior3.d(false);
            }
            if (this.f20208f0 == 2) {
                return;
            }
            com.customize.contacts.util.i0.b();
            this.f20208f0 = 2;
        }
        H2();
    }

    private void w2() {
        if (this.f20570r == null) {
            View g32 = this.f20195S.g3();
            this.f20570r = g32;
            g32.setOnTouchListener(this);
        }
    }

    public boolean A2() {
        int i10;
        ArrayList<ContactParcelable> m12;
        com.customize.contacts.fragment.A a10 = this.f20194R;
        if (a10 != null && a10.l1()) {
            return true;
        }
        C0783h c0783h = this.f20193Q;
        if (c0783h != null && (m12 = c0783h.m1()) != null && m12.size() > 0) {
            return true;
        }
        com.customize.contacts.fragment.F f10 = this.f20195S;
        if (f10 == null) {
            return false;
        }
        ArrayList<ContactParcelable> O22 = f10.O2();
        if (O22 != null) {
            i10 = O22.size();
        } else {
            i10 = 0;
        }
        if (this.f20211i0) {
            if (i10 > 1) {
                return true;
            }
        } else if (i10 > 0) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ boolean B2(MenuItem menuItem) {
        C2();
        return true;
    }

    public final void C2() {
        Intent intent = new Intent();
        com.customize.contacts.fragment.A a10 = this.f20194R;
        if (a10 != null) {
            intent = a10.o1(this.f20198V);
        } else {
            intent.setAction("com.oplus.contacts.ui.GET_GROUPS_CONTACTS_PHONES_FOR_SMS");
            intent.setComponent(new ComponentName(this, (Class<?>) MultiContactsSendSmsActivity.class));
            intent.putExtra("contain_email", this.f20201Y);
        }
        if (intent == null) {
            D2();
        } else {
            Q7.b.b(this, intent, 339, 0);
        }
    }

    public final void D2() {
        ArrayList<ContactParcelable> s22 = s2();
        if (s22.size() > 200) {
            if (this.f20198V) {
                com.oplus.foundation.util.ui.c.e(this, getString(R.string.too_many_recipients, 200));
                return;
            } else {
                com.oplus.foundation.util.ui.c.e(this, getString(R.string.too_many_contacts_tips, 200));
                return;
            }
        }
        C0811w.l(this, s22, this.f20204b0);
        finish();
    }

    public final void H2() {
        if (!U1()) {
            if (y2()) {
                N3.d dVar = this.f20200X;
                if (dVar != null) {
                    dVar.u(false);
                    if (this.f20200X.o()) {
                        if (H7.a.b()) {
                            H7.b.b("ContactsForSmsActivity", "---onPageSelected onContentChanged---");
                        }
                        this.f20200X.s(false);
                        return;
                    }
                    return;
                }
                return;
            }
            N3.d dVar2 = this.f20200X;
            if (dVar2 != null) {
                dVar2.u(true);
            }
        }
    }

    public final void I2() {
        int i10;
        com.customize.contacts.fragment.F f10 = this.f20195S;
        if (f10 != null) {
            i10 = f10.N2();
        } else {
            i10 = 0;
        }
        if (!this.f20211i0) {
            C0783h c0783h = this.f20193Q;
            if (c0783h != null) {
                i10 += c0783h.l1();
            }
            com.customize.contacts.fragment.A a10 = this.f20194R;
            if (a10 != null) {
                i10 += a10.j1();
            }
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            if (i10 == 0) {
                this.f20199W = false;
                supportActionBar.z(R.string.select_item);
            } else if (r0.f.g(getIntent().getAction()) && i10 < 2) {
                this.f20199W = false;
                supportActionBar.A(String.format(getString(R.string.oplus_x_phones_selected), U7.a.b(i10)));
            } else {
                this.f20199W = true;
                supportActionBar.A(String.format(getString(R.string.select_items), Integer.valueOf(U7.a.b(i10))));
            }
        }
        invalidateOptionsMenu();
    }

    public final void J2(boolean z10) {
        MenuItem menuItem = this.f20209g0;
        if (menuItem != null) {
            menuItem.setEnabled(z10);
        }
    }

    public final void K2(boolean z10) {
        com.customize.contacts.fragment.A a10;
        com.customize.contacts.fragment.F f10;
        m1(this.f20206d0, z10);
        f1(this, false, K0());
        if (z10) {
            J2(A2());
        }
        int i10 = this.f20208f0;
        if (i10 == 2 && (f10 = this.f20195S) != null) {
            f10.h2(z10);
            return;
        }
        if (i10 == 1 && (a10 = this.f20194R) != null) {
            a10.c1(z10);
            return;
        }
        C0783h c0783h = this.f20193Q;
        if (c0783h != null) {
            c0783h.c1(z10);
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean Q0() {
        return false;
    }

    @Override // Z3.i
    public void a() {
        I2();
        if (U1()) {
            J2(A2());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public void f1(Activity activity, boolean z10, boolean z11) {
        g1(this.f20206d0);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        C0636a.b(this);
    }

    @Override // Z3.i
    public void k() {
        if (!this.f20203a0) {
            return;
        }
        I2();
    }

    public void n2() {
        if (this.f20568p == null) {
            this.f20568p = this.f20195S.n1();
        }
        C1();
        D1();
        y1();
        p2();
        w2();
        N1();
        FrameLayout frameLayout = this.f20206d0;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        K2(false);
        F2(true);
    }

    public void o2() {
        if (this.f20568p == null) {
            this.f20568p = this.f20195S.n1();
        }
        C1();
        D1();
        y1();
        p2();
        w2();
        G1();
        F2(false);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        ArrayList arrayList;
        super.onActivityResult(i10, i11, intent);
        if (339 == i10) {
            if (-1 == i11) {
                try {
                    arrayList = C7.e.i(intent, "SELECTED_CONTACTS");
                } catch (Exception e10) {
                    H7.b.c("ContactsForSmsActivity", "" + e10);
                    arrayList = null;
                }
                ArrayList<ContactParcelable> s22 = s2();
                if (arrayList != null) {
                    s22.addAll(arrayList);
                }
                H7.b.e("ContactsForSmsActivity", "onActivityResult list.size() = " + s22.size());
                if (s22.size() == 0) {
                    if (arrayList != null) {
                        if (arrayList.size() == 0) {
                            if (C7.e.c(intent, "click_complete", false)) {
                                com.oplus.foundation.util.ui.c.d(this, R.string.toast_msg_no_phone_number_select);
                                return;
                            } else {
                                com.oplus.foundation.util.ui.c.d(this, R.string.toast_msg_group_contact_no_phone_number);
                                return;
                            }
                        }
                        com.oplus.foundation.util.ui.c.d(this, R.string.toast_msg_contacts_no_phone_number);
                        return;
                    }
                    return;
                }
                if (s22.size() > 200) {
                    if (this.f20198V) {
                        com.oplus.foundation.util.ui.c.e(this, getString(R.string.too_many_recipients, 200));
                        return;
                    } else {
                        com.oplus.foundation.util.ui.c.e(this, getString(R.string.too_many_contacts_tips, 200));
                        return;
                    }
                }
                C0811w.l(this, s22, this.f20204b0);
                finish();
                return;
            }
            return;
        }
        if (340 == i10) {
            if (-1 == i11) {
                try {
                    this.f20197U = C7.e.i(intent, "SELECTED_CONTACTS");
                } catch (Exception e11) {
                    H7.b.c("ContactsForSmsActivity", "" + e11);
                }
                if (this.f20197U.size() == 0) {
                    com.oplus.foundation.util.ui.c.d(this, R.string.toast_msg_contacts_no_phone_number);
                    return;
                } else if (this.f20197U.size() > 200) {
                    com.oplus.foundation.util.ui.c.e(this, getString(R.string.too_many_contacts_tips, 200));
                    return;
                } else {
                    C2();
                    return;
                }
            }
            return;
        }
        if (i10 == 999) {
            boolean a10 = C0792c.a(this, i10, i11, intent);
            this.f20203a0 = a10;
            if (a10) {
                q2();
                x2();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (U1()) {
            com.customize.contacts.fragment.F f10 = this.f20195S;
            if (f10 != null && f10.n1() != null) {
                this.f20195S.n1().changeStateWithAnimation(0);
                return;
            }
            return;
        }
        com.customize.contacts.fragment.F f11 = this.f20195S;
        if (f11 != null) {
            f11.r2();
        }
        super.onBackPressed();
    }

    @Override // com.customize.contacts.activities.SearchAnimatorsActivity, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f20203a0 = com.android.contacts.util.w.w(this);
        String action = getIntent().getAction();
        this.f20204b0 = C7.e.c(getIntent(), "is_from_no_brand_app", false);
        if (r0.f.e(action)) {
            this.f20201Y = false;
            this.f20202Z = true;
        } else if (r0.f.b(action)) {
            this.f20201Y = false;
            this.f20202Z = true;
        } else if (!r0.f.g(action) && !r0.f.h(action)) {
            if (r0.f.i(action)) {
                this.f20201Y = false;
                this.f20202Z = true;
            } else if (r0.f.f(action)) {
                this.f20198V = true;
                this.f20202Z = true;
            }
        } else {
            this.f20201Y = false;
            this.f20202Z = true;
            this.f20211i0 = true;
        }
        if (H7.a.b()) {
            H7.b.b("ContactsForSmsActivity", "action = " + action);
        }
        E2();
        if (!this.f20203a0) {
            return;
        }
        q2();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!this.f20203a0) {
            return false;
        }
        getMenuInflater().inflate(R.menu.cancel_save_menu, menu);
        return true;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f20196T != null) {
            X.a.b(this).e(this.f20196T);
        }
        Z0.b.g(this).a();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.save) {
            C2();
            return true;
        }
        if (menuItem.getItemId() == R.id.cancel) {
            setResult(0);
            finish();
            return true;
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        N3.d dVar;
        super.onPause();
        com.customize.contacts.util.i0.b();
        if (!this.f20203a0) {
            return;
        }
        if (y2() && (dVar = this.f20200X) != null) {
            dVar.u(true);
        }
        this.f20210h0.onPause();
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem findItem = menu.findItem(R.id.save);
        if (findItem != null) {
            findItem.setEnabled(this.f20199W);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        boolean f10 = C0792c.f(this, i10, strArr, iArr);
        this.f20203a0 = f10;
        if (f10) {
            q2();
            x2();
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.f20203a0) {
            return;
        }
        x2();
        this.f20210h0.onResume();
    }

    @Override // com.coui.appcompat.statusbar.COUIStatusBarResponseUtil.StatusBarClickListener
    public void onStatusBarClicked() {
        ListView listView;
        if (this.f20208f0 == TabState.ALL.ordinal()) {
            com.customize.contacts.fragment.F f10 = this.f20195S;
            if (f10 == null) {
                return;
            } else {
                listView = f10.u1();
            }
        } else {
            listView = null;
        }
        if (listView != null) {
            com.customize.contacts.util.i0.d(this, listView);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!V1() && motionEvent.getAction() == 0) {
            this.f20195S.n1().changeStateWithAnimation(0);
        }
        return true;
    }

    public final void p2() {
        A1(this.f20195S.u1(), this.f20195S.h3());
    }

    public final ArrayList<ContactParcelable> s2() {
        ArrayList<ContactParcelable> arrayList = new ArrayList<>();
        C0783h c0783h = this.f20193Q;
        if (c0783h != null) {
            arrayList.addAll(c0783h.m1());
        }
        arrayList.addAll(this.f20195S.O2());
        if (this.f20197U != null && B3.a.g()) {
            arrayList.addAll(this.f20197U);
        }
        return arrayList;
    }

    public void u2() {
        if (this.f20211i0) {
            v2(new String[]{getString(R.string.oplus_contacts_label)});
        } else if (!CommonFeatureOption.j()) {
            if (z2()) {
                v2(new String[]{getString(R.string.groupsLabel), getString(R.string.oplus_contacts_label)});
            } else {
                v2(new String[]{getString(R.string.oplus_contacts_label)});
            }
        } else if (z2()) {
            v2(new String[]{getString(R.string.call_title), getString(R.string.groupsLabel), getString(R.string.oplus_contacts_label)});
        } else {
            v2(new String[]{getString(R.string.call_title), getString(R.string.oplus_contacts_label)});
        }
        Q1().setupWithViewPager(this.f20205c0);
        Q1().addOnTabSelectedListener(new d());
        Q1().setTabMode(1);
        Q1().requestLayout();
        Q1().invalidate();
        COUITab tabAt = Q1().getTabAt(r2());
        if (tabAt != null) {
            tabAt.select();
        }
    }

    public final void v2(String[] strArr) {
        a aVar = new a(getSupportFragmentManager(), strArr);
        this.f20207e0 = aVar;
        this.f20205c0.setAdapter(aVar);
    }

    public void x2() {
        N3.d dVar;
        com.customize.contacts.fragment.A a10;
        if (this.f20200X == null && (a10 = this.f20194R) != null) {
            this.f20200X = a10.i1();
        }
        if (y2() && (dVar = this.f20200X) != null) {
            dVar.u(false);
        }
        G2();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public void y0() {
        this.f20206d0 = (FrameLayout) findViewById(R.id.navigation_view_panel);
        COUINavigationView cOUINavigationView = (COUINavigationView) findViewById(R.id.navigation_view);
        cOUINavigationView.inflateMenu(R.menu.add_action);
        MenuItem findItem = cOUINavigationView.getMenu().findItem(R.id.ok);
        this.f20209g0 = findItem;
        findItem.setTitle(R.string.confirm_description);
        this.f20209g0.setIcon(R.drawable.pb_dr_bottom_menu_add);
        cOUINavigationView.setOnItemSelectedListener(new NavigationBarView.c() { // from class: com.customize.contacts.activities.p
            @Override // com.google.android.material.navigation.NavigationBarView.c
            public final boolean onNavigationItemSelected(MenuItem menuItem) {
                boolean B22;
                B22 = ContactsForSmsActivity.this.B2(menuItem);
                return B22;
            }
        });
        FrameLayout frameLayout = this.f20206d0;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    public final boolean y2() {
        if (this.f20208f0 == TabState.GROUPS.ordinal()) {
            return true;
        }
        return false;
    }

    public final boolean z2() {
        if (com.android.contacts.framework.api.appstore.appinfo.a.k() && R0.a.f3166b == null) {
            return false;
        }
        return true;
    }

    public final void G2() {
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
    }
}
