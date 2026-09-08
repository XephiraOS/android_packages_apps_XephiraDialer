package com.customize.contacts.activities;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.provider.VoicemailContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.C0490m;
import androidx.lifecycle.InterfaceC0485h;
import androidx.lifecycle.LiveData;
import androidx.viewpager.widget.ViewPager;
import com.android.contacts.ContactsApplication;
import com.android.contacts.DynamicShortcuts;
import com.android.contacts.activities.CallDetailActivity;
import com.android.contacts.activities.RequestPermissionsActivity;
import com.android.contacts.calllog.r;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.framework.baseui.util.NotificationUtilsKt;
import com.android.contacts.framework.baseui.viewmodel.TabActivityViewModel;
import com.android.contacts.voicemail.VisualVoicemailCallLogFragment;
import com.coui.appcompat.bottomnavigation.COUINavigationView;
import com.coui.appcompat.floatingactionbutton.COUIFloatingButton;
import com.coui.appcompat.scrollbar.COUIScrollBar;
import com.coui.appcompat.statusbar.COUIStatusBarResponseUtil;
import com.coui.responsiveui.config.ResponsiveUIConfig;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.activities.ContactsTabActivity;
import com.customize.contacts.activities.L;
import com.customize.contacts.fragment.DialtactsUnfoldFragment;
import com.customize.contacts.fragment.MainFragment;
import com.customize.contacts.fragment.SearchFragment;
import com.customize.contacts.manager.MainActivitySearchManager;
import com.customize.contacts.startupspeed.CallLogPreload;
import com.customize.contacts.startupspeed.FastReadData;
import com.customize.contacts.startupspeed.StartupSpeedHelper;
import com.customize.contacts.ui.UnfoldContainerView;
import com.customize.contacts.util.C0792c;
import com.customize.contacts.util.C0793d;
import com.customize.contacts.widget.ContactsViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.oplus.contacts.list.fragment.FoldableContactsMainListFragment;
import com.oplus.dialer.R;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.display.DisplayUtil;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import com.oplus.foundation.util.io.CloseableUtils;
import com.oplus.foundation.util.scheduler.ThreadUtilsKt;
import com.oplus.foundation.util.systemcore.PrimaryUserUtils;
import com.oplus.foundation.util.ui.ShowUnfoldScreenStatusChecker;
import java.lang.ref.WeakReference;
import java.util.concurrent.ThreadPoolExecutor;
import m1.C1318n;
import m1.C1319o;
import v9.InterfaceC1637a;
import w0.C1643c;

/* loaded from: classes3.dex */
public class ContactsTabActivity extends BasicActivity implements r.b, com.customize.contacts.fragment.x, UnfoldContainerView.b, COUIStatusBarResponseUtil.StatusBarClickListener, SearchFragment.b {

    /* renamed from: C, reason: collision with root package name */
    public ContactsViewPager f20226C;

    /* renamed from: D, reason: collision with root package name */
    public View f20227D;

    /* renamed from: E, reason: collision with root package name */
    public ViewGroup f20228E;

    /* renamed from: F, reason: collision with root package name */
    public l f20229F;

    /* renamed from: G, reason: collision with root package name */
    public COUINavigationView f20230G;

    /* renamed from: H, reason: collision with root package name */
    public COUINavigationView f20231H;

    /* renamed from: K, reason: collision with root package name */
    public ViewStub f20234K;

    /* renamed from: L, reason: collision with root package name */
    public View f20235L;

    /* renamed from: M, reason: collision with root package name */
    public MenuItem f20236M;

    /* renamed from: N, reason: collision with root package name */
    public MenuItem f20237N;

    /* renamed from: O, reason: collision with root package name */
    public n f20238O;

    /* renamed from: Q, reason: collision with root package name */
    public o f20240Q;

    /* renamed from: R, reason: collision with root package name */
    public HandlerThread f20241R;

    /* renamed from: T, reason: collision with root package name */
    public COUIFloatingButton f20243T;

    /* renamed from: U, reason: collision with root package name */
    public TabActivityViewModel f20244U;

    /* renamed from: X, reason: collision with root package name */
    public Z3.o f20247X;

    /* renamed from: Y, reason: collision with root package name */
    public LiveData<Boolean> f20248Y;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f20251b0;

    /* renamed from: c0, reason: collision with root package name */
    public SharedPreferences f20252c0;

    /* renamed from: d0, reason: collision with root package name */
    public com.android.contacts.calllog.r f20253d0;

    /* renamed from: h0, reason: collision with root package name */
    public ThreadPoolExecutor f20257h0;

    /* renamed from: o, reason: collision with root package name */
    public DialtactsUnfoldFragment f20264o = null;

    /* renamed from: p, reason: collision with root package name */
    public FoldableContactsMainListFragment f20266p = null;

    /* renamed from: q, reason: collision with root package name */
    public VisualVoicemailCallLogFragment f20268q = null;

    /* renamed from: r, reason: collision with root package name */
    public Fragment f20270r = null;

    /* renamed from: x, reason: collision with root package name */
    public final L f20274x = new L();

    /* renamed from: z, reason: collision with root package name */
    public int f20276z = 1;

    /* renamed from: A, reason: collision with root package name */
    public int f20224A = -1;

    /* renamed from: B, reason: collision with root package name */
    public int f20225B = 0;

    /* renamed from: I, reason: collision with root package name */
    public int f20232I = 0;

    /* renamed from: J, reason: collision with root package name */
    public COUIStatusBarResponseUtil f20233J = null;

    /* renamed from: P, reason: collision with root package name */
    public boolean f20239P = false;

    /* renamed from: S, reason: collision with root package name */
    public boolean f20242S = true;

    /* renamed from: V, reason: collision with root package name */
    public int f20245V = -1;

    /* renamed from: W, reason: collision with root package name */
    public FastReadData f20246W = null;

    /* renamed from: Z, reason: collision with root package name */
    public ContentObserver f20249Z = new b(new Handler(Looper.getMainLooper()));

    /* renamed from: a0, reason: collision with root package name */
    public final DataSetObserver f20250a0 = new c();

    /* renamed from: e0, reason: collision with root package name */
    public ContentObserver f20254e0 = new d(new Handler(Looper.getMainLooper()));

    /* renamed from: f0, reason: collision with root package name */
    public final androidx.lifecycle.w<Boolean> f20255f0 = new e();

    /* renamed from: g0, reason: collision with root package name */
    public final androidx.lifecycle.w<Boolean> f20256g0 = new androidx.lifecycle.w() { // from class: com.customize.contacts.activities.C
        @Override // androidx.lifecycle.w
        public final void onChanged(Object obj) {
            ContactsTabActivity.M2((Boolean) obj);
        }
    };

    /* renamed from: i0, reason: collision with root package name */
    public com.customize.contacts.util.T f20258i0 = null;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f20259j0 = true;

    /* renamed from: k0, reason: collision with root package name */
    public Animation f20260k0 = null;

    /* renamed from: l0, reason: collision with root package name */
    public Animation f20261l0 = null;

    /* renamed from: m0, reason: collision with root package name */
    public CallLogPreload f20262m0 = null;

    /* renamed from: n0, reason: collision with root package name */
    public MainActivitySearchManager f20263n0 = null;

    /* renamed from: o0, reason: collision with root package name */
    public View f20265o0 = null;

    /* renamed from: p0, reason: collision with root package name */
    public boolean f20267p0 = true;

    /* renamed from: q0, reason: collision with root package name */
    public final ShowUnfoldScreenStatusChecker f20269q0 = new ShowUnfoldScreenStatusChecker();

    /* renamed from: r0, reason: collision with root package name */
    public final MainActivitySearchManager.b f20271r0 = new f();

    /* renamed from: s0, reason: collision with root package name */
    public final androidx.fragment.app.v f20272s0 = new androidx.fragment.app.v() { // from class: com.customize.contacts.activities.D
        @Override // androidx.fragment.app.v
        public final void a(FragmentManager fragmentManager, Fragment fragment) {
            ContactsTabActivity.this.N2(fragmentManager, fragment);
        }
    };

    /* renamed from: t0, reason: collision with root package name */
    public final androidx.lifecycle.w<Boolean> f20273t0 = new i();

    /* renamed from: y, reason: collision with root package name */
    public final C1318n f20275y = new C1318n(this);

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ContactsTabActivity.this.m3();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends ContentObserver {
        public b(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            try {
                H7.a.a(ContactsTabActivity.this);
            } catch (Exception e10) {
                H7.b.c("ContactsTabActivity", "ContactsTabActivity mLogSwitchObserver " + e10);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends DataSetObserver {
        public c() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            int i10;
            boolean G22 = ContactsTabActivity.this.G2();
            COUINavigationView cOUINavigationView = ContactsTabActivity.this.f20230G;
            if (G22) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            cOUINavigationView.setVisibility(i10);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends ContentObserver {
        public d(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            if (ContactsTabActivity.this.f20253d0 != null) {
                ContactsTabActivity.this.f20253d0.m(ContactsTabActivity.this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements androidx.lifecycle.w<Boolean> {
        public e() {
        }

        @Override // androidx.lifecycle.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (ContactsTabActivity.this.f20258i0 != null) {
                if (H7.a.b()) {
                    H7.b.b("ContactsTabActivity", "mBusinessHallLowReminderObserver : " + bool);
                }
                ContactsTabActivity.this.f20258i0.n(R.id.menu_business, Boolean.TRUE.equals(bool));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements MainActivitySearchManager.b {
        public f() {
        }

        @Override // com.customize.contacts.manager.MainActivitySearchManager.b
        public void a() {
            ContactsTabActivity.this.g3(false);
        }

        @Override // com.customize.contacts.manager.MainActivitySearchManager.b
        public void b() {
            ContactsTabActivity.this.g3(true);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver f20284a;

        public h(ViewTreeObserver viewTreeObserver) {
            this.f20284a = viewTreeObserver;
        }

        public final /* synthetic */ void b() {
            StartupSpeedHelper.I();
            if (ContactsTabActivity.this.f20258i0 != null) {
                ContactsTabActivity.this.f20258i0.j();
            }
            if (ContactsTabActivity.this.f20263n0 != null) {
                ContactsTabActivity.this.f20263n0.c();
            }
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f20284a.removeOnPreDrawListener(this);
            new Handler(ContactsTabActivity.this.getMainLooper()).post(new Runnable() { // from class: com.customize.contacts.activities.H
                @Override // java.lang.Runnable
                public final void run() {
                    ContactsTabActivity.h.this.b();
                }
            });
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class i implements androidx.lifecycle.w<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public boolean f20286a = true;

        public i() {
        }

        @Override // androidx.lifecycle.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (H7.a.b()) {
                H7.b.e("ContactsTabActivity", "mBusinessHallObserver onChange businessHallCanVisible=" + ContactsTabActivity.this.c2() + ", isFirst=" + this.f20286a);
            }
            if (this.f20286a) {
                this.f20286a = false;
                return;
            }
            FragmentManager supportFragmentManager = ContactsTabActivity.this.getSupportFragmentManager();
            androidx.fragment.app.B p10 = supportFragmentManager.p();
            ContactsTabActivity.this.U1(supportFragmentManager, p10, false);
            p10.j();
            supportFragmentManager.i0();
            ContactsTabActivity.this.f20229F.notifyDataSetChanged();
        }
    }

    /* loaded from: classes3.dex */
    public class j implements BottomNavigationView.c {
        public j() {
        }

        @Override // com.google.android.material.navigation.NavigationBarView.c
        public boolean onNavigationItemSelected(MenuItem menuItem) {
            VisualVoicemailCallLogFragment visualVoicemailCallLogFragment;
            VisualVoicemailCallLogFragment visualVoicemailCallLogFragment2;
            DialtactsUnfoldFragment dialtactsUnfoldFragment;
            FoldableContactsMainListFragment foldableContactsMainListFragment;
            int itemId = menuItem.getItemId();
            if (itemId == R.id.menu_delete) {
                if (1 == ContactsTabActivity.this.f20276z && (foldableContactsMainListFragment = ContactsTabActivity.this.f20266p) != null) {
                    foldableContactsMainListFragment.v3(menuItem);
                } else if (ContactsTabActivity.this.f20276z == 0 && (dialtactsUnfoldFragment = ContactsTabActivity.this.f20264o) != null) {
                    dialtactsUnfoldFragment.x4();
                } else if (2 == ContactsTabActivity.this.f20276z && (visualVoicemailCallLogFragment2 = ContactsTabActivity.this.f20268q) != null) {
                    visualVoicemailCallLogFragment2.Q1();
                }
                return true;
            }
            if (itemId == R.id.menu_read && 2 == ContactsTabActivity.this.f20276z && (visualVoicemailCallLogFragment = ContactsTabActivity.this.f20268q) != null) {
                visualVoicemailCallLogFragment.S1();
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static class k implements v9.l<View, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final String f20289a;

        public k(String str) {
            this.f20289a = str;
        }

        @Override // v9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(View view) {
            H7.b.e("ContactsTabActivity", view + "-showMorePopupMenu-" + this.f20289a);
            return Boolean.FALSE;
        }
    }

    /* loaded from: classes3.dex */
    public class m implements ViewPager.i {
        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageScrolled(int i10, float f10, int i11) {
            DialtactsUnfoldFragment dialtactsUnfoldFragment = ContactsTabActivity.this.f20264o;
            if (dialtactsUnfoldFragment != null) {
                dialtactsUnfoldFragment.K3();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageSelected(int i10) {
            int g10 = ContactsTabActivity.this.f20274x.g(i10);
            if (g10 >= 0) {
                ContactsTabActivity.this.f20276z = g10;
                ContactsTabActivity.this.v2(g10);
            }
        }

        public m() {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageScrollStateChanged(int i10) {
        }
    }

    /* loaded from: classes3.dex */
    public class n implements Z3.a {
        @Override // Z3.a
        public void a(View view) {
            if (ContactsTabActivity.this.f20231H == null) {
                ContactsTabActivity.this.z2();
                ContactsTabActivity.this.f20258i0.g(true);
            }
            if (view != null) {
                view.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) view.getTag(R.id.call_log_view_key));
            }
            ContactsTabActivity.this.g3(true);
            ContactsTabActivity.this.f20239P = false;
            ContactsTabActivity.this.f20258i0.f(CommonFeatureOption.j());
        }

        @Override // Z3.a
        public void b(final View view) {
            if (ContactsTabActivity.this.f20231H == null) {
                ContactsTabActivity.this.z2();
                ContactsTabActivity.this.f20258i0.g(true);
            }
            if (ContactsTabActivity.this.f20231H.getWidth() != view.getWidth()) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ContactsTabActivity.this.f20231H.getLayoutParams();
                marginLayoutParams.width = view.getWidth();
                ContactsTabActivity.this.f20231H.setLayoutParams(marginLayoutParams);
            }
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.customize.contacts.activities.J
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    ContactsTabActivity.n.this.d(view);
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
            view.setTag(R.id.call_log_view_key, onGlobalLayoutListener);
            ContactsTabActivity.this.g3(false);
            ContactsTabActivity.this.f20239P = true;
            ContactsTabActivity.this.f20258i0.h(CommonFeatureOption.j());
            if (ContactsTabActivity.this.f20236M == null) {
                ContactsTabActivity contactsTabActivity = ContactsTabActivity.this;
                contactsTabActivity.f20236M = contactsTabActivity.f20231H.getMenu().findItem(R.id.menu_delete);
                ContactsTabActivity contactsTabActivity2 = ContactsTabActivity.this;
                contactsTabActivity2.f20237N = contactsTabActivity2.f20231H.getMenu().findItem(R.id.menu_read);
            }
        }

        public final /* synthetic */ void d(View view) {
            if (ContactsTabActivity.this.f20231H.getWidth() != view.getWidth()) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ContactsTabActivity.this.f20231H.getLayoutParams();
                marginLayoutParams.width = view.getWidth();
                ContactsTabActivity.this.f20231H.setLayoutParams(marginLayoutParams);
            }
        }

        public n() {
        }
    }

    /* loaded from: classes3.dex */
    public static class o extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<ContactsTabActivity> f20296a;

        public o(Looper looper, ContactsTabActivity contactsTabActivity) {
            super(looper);
            this.f20296a = new WeakReference<>(contactsTabActivity);
            H7.b.b("ContactsTabActivity", "create DelayedInitializerHandler looper = " + looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ContactsTabActivity contactsTabActivity = this.f20296a.get();
            if (contactsTabActivity == null) {
                return;
            }
            H7.b.e("ContactsTabActivity", "DelayedInitializerHandler: message: " + message.what);
            int i10 = message.what;
            if (i10 == 1) {
                try {
                    com.android.contacts.framework.api.appstore.sau.a.a(contactsTabActivity);
                    if (contactsTabActivity.getContentResolver() != null && contactsTabActivity.f20249Z != null) {
                        contactsTabActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("log_switch_type"), true, contactsTabActivity.f20249Z);
                        return;
                    }
                    return;
                } catch (Exception e10) {
                    H7.b.c("ContactsTabActivity", "This exception is e:" + e10);
                    return;
                }
            }
            if (i10 == 2) {
                contactsTabActivity.f20233J.onResume();
            } else if (i10 == 3) {
                contactsTabActivity.f20233J.onPause();
            }
        }
    }

    public static /* synthetic */ void M2(Boolean bool) {
        if (H7.a.b()) {
            H7.b.b("ContactsTabActivity", "mToolbarMenuDotObserver : " + bool);
        }
        com.android.contacts.framework.api.businesshall.a.o(bool.booleanValue());
    }

    public static boolean S2(Context context) {
        if (androidx.preference.j.b(context).getInt("show_call_summary_dialog", 1) == 1) {
            return true;
        }
        return false;
    }

    private void j3() {
        DialtactsUnfoldFragment dialtactsUnfoldFragment = this.f20264o;
        if (dialtactsUnfoldFragment != null) {
            dialtactsUnfoldFragment.K7();
        }
    }

    private void q3(boolean z10) {
        COUIFloatingButton cOUIFloatingButton;
        if (H7.a.b()) {
            H7.b.b("ContactsTabActivity", "updateFloatingButtonState mCurrentTab = " + this.f20276z + ", mDialtactsFragment = " + this.f20264o);
        }
        int i10 = this.f20276z;
        if (i10 == 0) {
            DialtactsUnfoldFragment dialtactsUnfoldFragment = this.f20264o;
            if (dialtactsUnfoldFragment != null) {
                dialtactsUnfoldFragment.k8(z10);
                return;
            }
            return;
        }
        if (i10 != 1 && (cOUIFloatingButton = this.f20243T) != null) {
            cOUIFloatingButton.setVisibility(8);
        }
    }

    public final void A2(boolean z10) {
        l lVar = new l(getSupportFragmentManager());
        this.f20229F = lVar;
        lVar.registerDataSetObserver(this.f20250a0);
        this.f20226C.setAdapter(this.f20229F);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        androidx.fragment.app.B p10 = supportFragmentManager.p();
        W1(supportFragmentManager, p10, z10);
        Y1(supportFragmentManager, p10);
        b2(supportFragmentManager, p10);
        U1(supportFragmentManager, p10, z10);
        p10.j();
        supportFragmentManager.i0();
        this.f20229F.notifyDataSetChanged();
    }

    public boolean B2() {
        DialtactsUnfoldFragment dialtactsUnfoldFragment = this.f20264o;
        if (dialtactsUnfoldFragment != null && dialtactsUnfoldFragment.j5()) {
            return true;
        }
        return false;
    }

    public boolean C2() {
        if (this.f20276z == 1) {
            return true;
        }
        return false;
    }

    public final boolean D2(String str) {
        if (!"com.android.contacts.DialtactsActivityAlias".equals(str) && !"com.android.contacts.DialtactsActivity".equals(str) && !"com.android.contacts.RecentCallsListActivity".equals(str) && !"com.android.contacts.activities.CallLogActivity".equals(str)) {
            return false;
        }
        return true;
    }

    public boolean E2() {
        if (this.f20276z == 0) {
            return true;
        }
        return false;
    }

    public boolean F2() {
        boolean z10;
        MainActivitySearchManager mainActivitySearchManager = this.f20263n0;
        if (mainActivitySearchManager != null && mainActivitySearchManager.i()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (H7.a.b()) {
            H7.b.b("ContactsTabActivity", "isInSearch: " + z10);
        }
        return z10;
    }

    public boolean G2() {
        if (this.f20274x.h() > 1) {
            return true;
        }
        return false;
    }

    public boolean H2() {
        if (this.f20276z == 2) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ Boolean I2(View view) {
        H7.b.e("ContactsTabActivity", "BusinessHall menuItemClick showMorePopupMenu");
        h3(view);
        return Boolean.TRUE;
    }

    public final /* synthetic */ boolean J2() {
        if (B3.a.b0()) {
            T2();
            return false;
        }
        if (B2()) {
            ThreadUtilsKt.a().postDelayed(new Runnable() { // from class: com.customize.contacts.activities.x
                @Override // java.lang.Runnable
                public final void run() {
                    ContactsTabActivity.this.T2();
                }
            }, 250L);
            return false;
        }
        T2();
        return false;
    }

    public final /* synthetic */ boolean K2(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.menu_dialer) {
            if (this.f20276z == 0) {
                return false;
            }
            this.f20276z = 0;
            f3(0);
        } else if (itemId == R.id.menu_contacts) {
            if (this.f20276z == 1) {
                return false;
            }
            this.f20276z = 1;
            f3(1);
            DialtactsUnfoldFragment dialtactsUnfoldFragment = this.f20264o;
            if (dialtactsUnfoldFragment != null) {
                dialtactsUnfoldFragment.O8();
                this.f20264o.M7();
            }
        } else if (itemId == R.id.menu_voice_mail) {
            if (this.f20276z == 2) {
                return false;
            }
            this.f20276z = 2;
            f3(2);
        } else if (itemId == R.id.menu_business) {
            if (this.f20276z == 3) {
                return false;
            }
            this.f20276z = 3;
            f3(3);
        }
        return true;
    }

    @Override // com.android.contacts.calllog.r.b
    public void L(Cursor cursor) {
        if (B3.a.W()) {
            if (!isFinishing() && !isDestroyed()) {
                boolean z10 = false;
                if (B3.a.w() ? s1.u.a(cursor) > 0 : !(s1.u.a(cursor) <= 0 || !C1.b.b(this))) {
                    z10 = true;
                }
                if (z10 != this.f20251b0) {
                    this.f20251b0 = z10;
                    if (H7.a.b()) {
                        H7.b.b("ContactsTabActivity", "mHasActiveVoicemailProvider " + this.f20251b0);
                    }
                    FragmentManager supportFragmentManager = getSupportFragmentManager();
                    androidx.fragment.app.B p10 = supportFragmentManager.p();
                    b2(supportFragmentManager, p10);
                    p10.j();
                    supportFragmentManager.i0();
                    this.f20229F.notifyDataSetChanged();
                    this.f20252c0.edit().putBoolean("has_active_voicemail_provider", z10).apply();
                }
            } else {
                com.oplus.foundation.util.io.e.a(cursor);
                return;
            }
        }
        CloseableUtils.b(cursor);
    }

    public final /* synthetic */ boolean L2() {
        DynamicShortcuts.o(getApplicationContext());
        return false;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean M0() {
        return true;
    }

    public final /* synthetic */ void N2(FragmentManager fragmentManager, Fragment fragment) {
        if (fragment instanceof DialtactsUnfoldFragment) {
            this.f20264o = (DialtactsUnfoldFragment) fragment;
        } else if (fragment instanceof FoldableContactsMainListFragment) {
            this.f20266p = (FoldableContactsMainListFragment) fragment;
        } else if (fragment instanceof VisualVoicemailCallLogFragment) {
            this.f20268q = (VisualVoicemailCallLogFragment) fragment;
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public void O0(int i10) {
        View view;
        if (H7.a.b()) {
            H7.b.b("ContactsTabActivity", "navigationBarHeightChanged navigationBarHeight = " + i10);
        }
        if (i10 != this.f20244U.i().getValue().intValue()) {
            this.f20244U.i().m(Integer.valueOf(i10));
        }
        if (this.f20227D != null && (view = this.f20265o0) != null) {
            if (i10 != 0 && view.getVisibility() != 0) {
                this.f20265o0.setVisibility(0);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f20227D.getLayoutParams();
            if (marginLayoutParams != null && marginLayoutParams.bottomMargin != i10) {
                marginLayoutParams.bottomMargin = i10;
                this.f20227D.setLayoutParams(marginLayoutParams);
            }
            ViewGroup.LayoutParams layoutParams = this.f20265o0.getLayoutParams();
            if (this.f20265o0.getHeight() != i10 || layoutParams.height != i10) {
                this.f20265o0.setMinimumHeight(i10);
                layoutParams.height = i10;
                this.f20265o0.setLayoutParams(layoutParams);
            }
        }
        MainActivitySearchManager mainActivitySearchManager = this.f20263n0;
        if (mainActivitySearchManager != null) {
            mainActivitySearchManager.m();
        }
    }

    public final /* synthetic */ Boolean O2() {
        l lVar = this.f20229F;
        if (lVar != null) {
            Fragment c10 = lVar.c();
            if (c10 instanceof MainFragment) {
                ((MainFragment) c10).h1();
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public final /* synthetic */ void P2() {
        if (com.android.contacts.framework.api.cloudsync.a.h() && com.android.contacts.framework.api.cloudsync.a.g()) {
            com.android.contacts.framework.api.cloudsync.a.d();
            com.android.contacts.framework.api.cloudsync.a.l(this, 3);
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean Q0() {
        return false;
    }

    public final /* synthetic */ void Q2() {
        k3(this);
    }

    public final /* synthetic */ void R2(boolean z10) {
        TabActivityViewModel tabActivityViewModel = this.f20244U;
        if (tabActivityViewModel != null) {
            tabActivityViewModel.g().m(Boolean.valueOf(z10));
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean T0() {
        return false;
    }

    public void T2() {
        try {
            n3(false, true);
            L.b c10 = this.f20274x.c(1);
            if (c10 != null) {
                c10.b().b(this, getSupportFragmentManager(), this.f20229F);
                if (this.f20266p == null && (c10.a() instanceof FoldableContactsMainListFragment)) {
                    this.f20266p = (FoldableContactsMainListFragment) c10.a();
                }
            }
        } catch (Exception e10) {
            H7.b.c("ContactsTabActivity", "notifyCallLogCompleted error " + e10);
        }
    }

    public final void U1(FragmentManager fragmentManager, androidx.fragment.app.B b10, boolean z10) {
        MenuItem findItem;
        Fragment a10;
        boolean z11 = false;
        if (FeatureOption.g()) {
            if (c2() && PrimaryUserUtils.a() && !com.android.contacts.framework.baseui.util.m.a(this)) {
                z11 = true;
            }
            H7.b.e("ContactsTabActivity", "showBusinessHall : " + z11);
            Class<? extends Fragment> c10 = com.android.contacts.framework.api.businesshall.a.c();
            if (z11 && c10 != null) {
                L.b Z12 = Z1(fragmentManager, b10, "business_tab_tag", 3, false, c10);
                if (Z12 == null) {
                    a10 = null;
                } else {
                    a10 = Z12.a();
                }
                if (a10 != null) {
                    this.f20270r = a10;
                    if (z10) {
                        Intent intent = getIntent();
                        if ("com.android.contacts.business.BusinessHallActivityAlias".equals(i2(intent)) && c2()) {
                            InterfaceC0485h interfaceC0485h = this.f20270r;
                            if (interfaceC0485h instanceof X0.a) {
                                ((X0.a) interfaceC0485h).a(intent);
                            }
                        }
                    }
                }
                com.android.contacts.framework.api.businesshall.a.m(new v9.l() { // from class: com.customize.contacts.activities.F
                    @Override // v9.l
                    public final Object invoke(Object obj) {
                        Boolean I22;
                        I22 = ContactsTabActivity.this.I2((View) obj);
                        return I22;
                    }
                });
            } else {
                c3(b10, this.f20270r, 3);
                com.android.contacts.framework.api.businesshall.a.m(new k("addBusinessHallFragmentIfNecessary"));
            }
        }
        COUINavigationView cOUINavigationView = this.f20230G;
        if (cOUINavigationView != null && (findItem = cOUINavigationView.getMenu().findItem(R.id.menu_business)) != null && z11 != findItem.isVisible()) {
            findItem.setVisible(z11);
        }
    }

    public void U2() {
        try {
            n3(false, true);
            L.b c10 = this.f20274x.c(0);
            if (c10 != null) {
                c10.b().b(this, getSupportFragmentManager(), this.f20229F);
                if (this.f20264o == null && (c10.a() instanceof DialtactsUnfoldFragment)) {
                    this.f20264o = (DialtactsUnfoldFragment) c10.a();
                }
            }
        } catch (Exception e10) {
            H7.b.c("ContactsTabActivity", "notifyContactsLoadCompleted error " + e10);
        }
    }

    public final void V1(ViewGroup viewGroup, ViewGroup viewGroup2) {
        if (H7.a.b()) {
            H7.b.b("ContactsTabActivity", "addDialChild addDialChild");
        }
        View findViewById = viewGroup2.findViewById(R.id.dial_container_content);
        if (findViewById != null) {
            viewGroup2.removeView(findViewById);
            viewGroup.addView(findViewById);
        }
    }

    public final void V2() {
        DialtactsUnfoldFragment dialtactsUnfoldFragment;
        if (!C7.a.a()) {
            int i10 = this.f20276z;
            if (i10 == 1) {
                if (this.f20266p != null) {
                    if (this.f20243T.isAnimationRunning()) {
                        this.f20243T.animate().cancel();
                        this.f20243T.animationFloatingButtonEnlarge();
                    }
                    C0792c.n(this.f20266p);
                    return;
                }
                return;
            }
            if (i10 == 0 && (dialtactsUnfoldFragment = this.f20264o) != null) {
                if (!dialtactsUnfoldFragment.i5()) {
                    this.f20264o.Q4();
                }
                if (!this.f20264o.e5()) {
                    this.f20264o.d7(true);
                    this.f20264o.e9();
                    this.f20264o.d7(false);
                }
            }
        }
    }

    public final void W1(FragmentManager fragmentManager, androidx.fragment.app.B b10, boolean z10) {
        if (CommonFeatureOption.j()) {
            L.b Z12 = Z1(fragmentManager, b10, "dial_tab_tag", 0, true, DialtactsUnfoldFragment.class);
            if (Z12 != null) {
                Fragment a10 = Z12.a();
                if (a10 instanceof DialtactsUnfoldFragment) {
                    DialtactsUnfoldFragment dialtactsUnfoldFragment = (DialtactsUnfoldFragment) a10;
                    this.f20264o = dialtactsUnfoldFragment;
                    dialtactsUnfoldFragment.O6(this.f20238O);
                    if (z10 && this.f20276z == 0) {
                        this.f20264o.f17420e0 = true;
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        COUINavigationView cOUINavigationView = this.f20230G;
        if (cOUINavigationView != null) {
            cOUINavigationView.getMenu().findItem(R.id.menu_dialer).setVisible(false);
        }
    }

    public final boolean W2(Intent intent) {
        String i22 = i2(intent);
        if (D2(i22) || "com.android.contacts.business.BusinessHallActivityAlias".equals(i22)) {
            return true;
        }
        C1319o a10 = this.f20275y.a(intent);
        if (H7.a.b()) {
            H7.b.b("ContactsTabActivity", this + " processIntent: intent=" + intent + ", request=" + a10 + ", request.isValid() = " + a10.f());
        }
        if (!a10.f()) {
            setResult(0);
            return false;
        }
        if (H7.a.b()) {
            H7.b.b("ContactsTabActivity", this + " processIntent: request.getActionCode()=" + a10.a());
        }
        if (a10.a() != 140 || com.android.contacts.util.x.f(this)) {
            return true;
        }
        Intent intent2 = new Intent(this, (Class<?>) CallDetailActivity.class);
        intent2.setAction("android.intent.action.VIEW");
        intent2.setData(a10.c());
        R7.b.d(this, intent2, R.string.activity_not_found);
        H7.b.e("ContactsTabActivity", this + " processIntent: request.getActionCode() return false");
        return false;
    }

    @Override // com.customize.contacts.fragment.x
    public void X(Animation animation) {
        Animation animation2 = this.f20260k0;
        if (animation2 == null && (animation2 = AnimationUtils.loadAnimation(this, R.anim.coui_open_slide_exit)) != null) {
            this.f20260k0 = animation2;
        }
        if (animation2 != null && animation != null) {
            this.f20227D.setAnimation(animation2);
            AnimationSet animationSet = new AnimationSet(false);
            animationSet.addAnimation(animation2);
            animationSet.addAnimation(animation);
            animationSet.start();
        }
    }

    public final void X1(ViewGroup viewGroup, ViewGroup viewGroup2) {
        if (H7.a.b()) {
            H7.b.b("ContactsTabActivity", "addFoldableContactChild addContactChild");
        }
        View findViewById = viewGroup2.findViewById(R.id.foldable_contact_right_container);
        if (findViewById != null) {
            viewGroup2.removeView(findViewById);
            viewGroup.addView(findViewById);
        }
    }

    public final void X2() {
        o oVar = this.f20240Q;
        if (oVar != null) {
            oVar.removeCallbacksAndMessages(null);
            this.f20240Q.sendEmptyMessageDelayed(1, COUIScrollBar.SCROLLER_FADE_TIMEOUT);
        }
    }

    public final void Y1(FragmentManager fragmentManager, androidx.fragment.app.B b10) {
        Fragment a10;
        L.b Z12 = Z1(fragmentManager, b10, "contacts_tab_tag", 1, CommonFeatureOption.j(), FoldableContactsMainListFragment.class);
        if (Z12 == null) {
            a10 = null;
        } else {
            a10 = Z12.a();
        }
        if (a10 instanceof FoldableContactsMainListFragment) {
            FoldableContactsMainListFragment foldableContactsMainListFragment = (FoldableContactsMainListFragment) a10;
            this.f20266p = foldableContactsMainListFragment;
            foldableContactsMainListFragment.G3(this.f20238O);
        }
        COUINavigationView cOUINavigationView = this.f20230G;
        if (cOUINavigationView != null) {
            cOUINavigationView.getMenu().findItem(R.id.menu_contacts).setVisible(true);
        }
    }

    public final void Y2() {
        try {
            if (FeatureOption.g()) {
                LiveData<Boolean> f10 = com.android.contacts.framework.api.businesshall.a.f();
                this.f20248Y = f10;
                if (f10 != null) {
                    f10.i(this, this.f20273t0);
                }
                LiveData<Boolean> h10 = com.android.contacts.framework.api.businesshall.a.h();
                if (h10 != null) {
                    h10.i(this, this.f20255f0);
                }
                TabActivityViewModel tabActivityViewModel = this.f20244U;
                if (tabActivityViewModel != null) {
                    tabActivityViewModel.l().i(this, this.f20256g0);
                }
            }
        } catch (Throwable th) {
            H7.b.c("ContactsTabActivity", "registerBusinessHallObserver: " + th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T extends androidx.fragment.app.Fragment> com.customize.contacts.activities.L.b Z1(androidx.fragment.app.FragmentManager r9, androidx.fragment.app.B r10, java.lang.String r11, int r12, boolean r13, java.lang.Class<T> r14) {
        /*
            r8 = this;
            java.lang.String r0 = "ContactsTabActivity"
            r1 = 0
            if (r14 != 0) goto L1a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "addFragmentIfNecessary: requiredFragmentCls can not be null. tag: "
            r8.append(r9)
            r8.append(r11)
            java.lang.String r8 = r8.toString()
            H7.b.i(r0, r8)
            return r1
        L1a:
            com.customize.contacts.activities.L r2 = r8.f20274x
            com.customize.contacts.activities.L$b r2 = r2.c(r12)
            if (r2 != 0) goto L37
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "addFragmentIfNecessary: fragment info is null. tag: "
            r8.append(r9)
            r8.append(r11)
            java.lang.String r8 = r8.toString()
            H7.b.i(r0, r8)
            return r1
        L37:
            androidx.fragment.app.Fragment r9 = r9.m0(r11)
            r3 = 1
            if (r9 == 0) goto L46
            boolean r4 = r14.isInstance(r9)
            if (r4 == 0) goto L46
            r4 = r3
            goto L90
        L46:
            r4 = 0
            if (r9 == 0) goto L69
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L66
            r5.<init>()     // Catch: java.lang.Exception -> L66
            java.lang.String r6 = "addFragmentIfNecessary, fragment is not needed: "
            r5.append(r6)     // Catch: java.lang.Exception -> L66
            r5.append(r11)     // Catch: java.lang.Exception -> L66
            java.lang.String r6 = ", fragment: "
            r5.append(r6)     // Catch: java.lang.Exception -> L66
            r5.append(r9)     // Catch: java.lang.Exception -> L66
            java.lang.String r9 = r5.toString()     // Catch: java.lang.Exception -> L66
            H7.b.i(r0, r9)     // Catch: java.lang.Exception -> L66
            goto L69
        L66:
            r9 = move-exception
            r14 = r1
            goto L7b
        L69:
            java.lang.reflect.Constructor r9 = r14.getDeclaredConstructor(r1)     // Catch: java.lang.Exception -> L66
            java.lang.Object r9 = r9.newInstance(r1)     // Catch: java.lang.Exception -> L66
            androidx.fragment.app.Fragment r9 = (androidx.fragment.app.Fragment) r9     // Catch: java.lang.Exception -> L66
            r9.setUserVisibleHint(r4)     // Catch: java.lang.Exception -> L77
            goto L90
        L77:
            r14 = move-exception
            r7 = r14
            r14 = r9
            r9 = r7
        L7b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "addFragmentIfNecessary: e:"
            r5.append(r6)
            r5.append(r9)
            java.lang.String r9 = r5.toString()
            H7.b.i(r0, r9)
            r9 = r14
        L90:
            if (r9 != 0) goto La7
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "addFragmentIfNecessary, requiredFragment is null. tag = "
            r8.append(r9)
            r8.append(r11)
            java.lang.String r8 = r8.toString()
            H7.b.i(r0, r8)
            return r1
        La7:
            boolean r14 = r2.d()
            if (r14 != 0) goto Lca
            r2.f(r3)
            if (r13 == 0) goto Lc2
            if (r4 != 0) goto Lc2
            int r8 = r8.f20276z
            if (r8 != r12) goto Lb9
            goto Lc2
        Lb9:
            com.customize.contacts.delayload.DelayLoadFragmentAdapter r8 = new com.customize.contacts.delayload.DelayLoadFragmentAdapter
            r8.<init>(r9, r11)
            r2.e(r8)
            goto Lca
        Lc2:
            com.customize.contacts.delayload.b r8 = new com.customize.contacts.delayload.b
            r8.<init>(r9)
            r2.e(r8)
        Lca:
            androidx.fragment.app.Fragment r8 = r2.a()
            boolean r9 = r8.isAdded()
            if (r9 != 0) goto Ldd
            r9 = 2131429364(0x7f0b07f4, float:1.8480399E38)
            r10.c(r9, r8, r11)
            r10.p(r8)
        Ldd:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.activities.ContactsTabActivity.Z1(androidx.fragment.app.FragmentManager, androidx.fragment.app.B, java.lang.String, int, boolean, java.lang.Class):com.customize.contacts.activities.L$b");
    }

    public void Z2() {
        FastReadData fastReadData = this.f20246W;
        if (fastReadData != null) {
            fastReadData.i();
        }
    }

    public final void a2() {
        if (this.f20266p == null) {
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.customize.contacts.activities.w
                @Override // android.os.MessageQueue.IdleHandler
                public final boolean queueIdle() {
                    boolean J22;
                    J22 = ContactsTabActivity.this.J2();
                    return J22;
                }
            });
        }
    }

    public final void a3(ViewGroup viewGroup, View view) {
        if (H7.a.b()) {
            H7.b.b("ContactsTabActivity", "removeDialChild removeDialChild");
        }
        ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.dial_fragment_layout);
        if (viewGroup2 != null) {
            viewGroup.removeView(view);
            viewGroup2.addView(view);
        }
    }

    public final void b2(FragmentManager fragmentManager, androidx.fragment.app.B b10) {
        Fragment a10;
        if (B3.a.W()) {
            if (this.f20251b0) {
                if (C1643c.w() && C1643c.q() && !com.customize.contacts.util.b0.U(this, 0)) {
                    this.f20251b0 = false;
                    this.f20252c0.edit().putBoolean("has_active_voicemail_provider", this.f20251b0).apply();
                } else {
                    L.b Z12 = Z1(fragmentManager, b10, "voicemail_tab_tag", 2, false, VisualVoicemailCallLogFragment.class);
                    if (Z12 == null) {
                        a10 = null;
                    } else {
                        a10 = Z12.a();
                    }
                    if (a10 instanceof VisualVoicemailCallLogFragment) {
                        VisualVoicemailCallLogFragment visualVoicemailCallLogFragment = (VisualVoicemailCallLogFragment) a10;
                        this.f20268q = visualVoicemailCallLogFragment;
                        visualVoicemailCallLogFragment.V1(this.f20238O);
                    }
                }
            } else {
                c3(b10, this.f20268q, 2);
            }
            COUINavigationView cOUINavigationView = this.f20230G;
            if (cOUINavigationView != null) {
                cOUINavigationView.getMenu().findItem(R.id.menu_voice_mail).setVisible(this.f20251b0);
            }
        }
    }

    public final void b3(ViewGroup viewGroup, View view) {
        if (H7.a.b()) {
            H7.b.b("ContactsTabActivity", "removeFoldableContactChild removeContactChild");
        }
        ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.foldable_contact_main_layout);
        if (viewGroup2 != null) {
            viewGroup.removeView(view);
            viewGroup2.addView(view);
        }
    }

    public final boolean c2() {
        LiveData<Boolean> liveData;
        if (!FeatureOption.g() || (liveData = this.f20248Y) == null || !Boolean.TRUE.equals(liveData.getValue())) {
            return false;
        }
        return true;
    }

    public final void c3(androidx.fragment.app.B b10, Fragment fragment, int i10) {
        if (fragment != null) {
            if (fragment.isAdded()) {
                b10.r(fragment);
            }
            L.b c10 = this.f20274x.c(i10);
            if (c10 != null) {
                c10.f(false);
                c10.e(new com.customize.contacts.delayload.b());
            }
        }
    }

    @Override // com.android.contacts.calllog.r.b
    public void d(Cursor cursor) {
        CloseableUtils.b(cursor);
    }

    public void d2() {
        NotificationUtilsKt.f(this);
    }

    public final void d3(ViewGroup viewGroup) {
        if (viewGroup == null) {
            H7.b.c("ContactsTabActivity", "removeUnfoldViewChild(): mainLayout is null");
            return;
        }
        if (viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            int id = childAt.getId();
            if (id != R.id.dial_container_content) {
                if (id == R.id.foldable_contact_right_container) {
                    b3(viewGroup, childAt);
                    return;
                }
                return;
            }
            a3(viewGroup, childAt);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        DialtactsUnfoldFragment dialtactsUnfoldFragment;
        if (!CommonFeatureOption.m()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        if (H7.a.b()) {
            H7.b.b("ContactsTabActivity", "dispatchKeyEvent: keyCode = " + keyCode);
        }
        if (this.f20276z == 0 && (dialtactsUnfoldFragment = this.f20264o) != null && keyCode == 67) {
            dialtactsUnfoldFragment.n8();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        DialtactsUnfoldFragment dialtactsUnfoldFragment;
        try {
            if (this.f20276z == 0 && (dialtactsUnfoldFragment = this.f20264o) != null && dialtactsUnfoldFragment.S3()) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Throwable th) {
            H7.b.c("ContactsTabActivity", "th = " + th);
            return false;
        }
    }

    public final void e2() {
        Z3.o oVar = this.f20247X;
        if (oVar != null) {
            oVar.d();
        }
    }

    public void e3(int i10) {
        this.f20225B = i10;
    }

    public void f2() {
        if (this.f20225B != this.f20276z) {
            e2();
        }
    }

    public final void f3(int i10) {
        if (this.f20226C != null) {
            int f10 = this.f20274x.f(i10);
            if (f10 < 0) {
                f10 = 0;
            }
            this.f20226C.setCurrentItem(f10, false);
        }
    }

    public void g2() {
        Animation animation = this.f20261l0;
        if (animation == null) {
            animation = AnimationUtils.loadAnimation(this, R.anim.coui_close_slide_enter);
        }
        if (animation != null) {
            this.f20261l0 = animation;
            this.f20227D.setAnimation(animation);
            animation.start();
        }
    }

    public void g3(boolean z10) {
        DialtactsUnfoldFragment dialtactsUnfoldFragment;
        if (this.f20226C != null) {
            boolean z11 = false;
            if (E2() && (dialtactsUnfoldFragment = this.f20264o) != null && dialtactsUnfoldFragment.G() && this.f20264o.o5()) {
                z10 = false;
            }
            if (!F2()) {
                z11 = z10;
            }
            this.f20226C.setCanScrolling(z11);
        }
    }

    @Override // com.customize.contacts.fragment.SearchFragment.b
    public void h(boolean z10) {
        MainActivitySearchManager mainActivitySearchManager = this.f20263n0;
        if (mainActivitySearchManager != null) {
            mainActivitySearchManager.f(z10);
        }
    }

    public CallLogPreload h2() {
        return this.f20262m0;
    }

    public final boolean h3(View view) {
        Z3.o oVar = this.f20247X;
        if (oVar != null) {
            boolean n10 = oVar.n(view, false);
            if (H7.a.b()) {
                H7.b.e("ContactsTabActivity", "showMorePopupMenu, mCurrentTab : " + this.f20276z);
            }
            if (n10) {
                e3(this.f20276z);
            }
            return n10;
        }
        H7.b.c("ContactsTabActivity", "showMorePopupMenu mMorePopupMenuTool is null");
        return false;
    }

    public final String i2(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            return component.getClassName();
        }
        return "";
    }

    public void i3() {
        MainActivitySearchManager mainActivitySearchManager = this.f20263n0;
        if (mainActivitySearchManager != null) {
            mainActivitySearchManager.l();
        }
    }

    public COUIFloatingButton j2() {
        return this.f20243T;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean k0() {
        return false;
    }

    public int k2() {
        return this.f20276z;
    }

    public final void k3(Context context) {
        com.android.contacts.framework.api.cloudsync.a.c();
    }

    public final int l2() {
        if (CommonFeatureOption.j()) {
            return getResources().getDimensionPixelSize(R.dimen.floating_button_margin_bottom);
        }
        return getResources().getDimensionPixelSize(R.dimen.floating_button_margin_no_label_bottom);
    }

    public final void l3() {
        int dimensionPixelSize;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f20230G.getLayoutParams();
        if (this.f20259j0) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.contact_bottom_tab_unfold_height);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.contact_bottom_tab_height);
        }
        marginLayoutParams.height = dimensionPixelSize;
    }

    public final /* synthetic */ void lambda$onStop$3() {
        C0793d.a(getApplicationContext());
    }

    public final int m2() {
        FoldableContactsMainListFragment foldableContactsMainListFragment;
        if (this.f20259j0) {
            return 2;
        }
        if (E2()) {
            DialtactsUnfoldFragment dialtactsUnfoldFragment = this.f20264o;
            if (dialtactsUnfoldFragment == null || !dialtactsUnfoldFragment.g5()) {
                return 2;
            }
        } else if (!C2() || (foldableContactsMainListFragment = this.f20266p) == null || !foldableContactsMainListFragment.t4()) {
            return 2;
        }
        return 4;
    }

    public void m3() {
        COUINavigationView cOUINavigationView = this.f20230G;
        if (cOUINavigationView == null) {
            return;
        }
        Menu menu = cOUINavigationView.getMenu();
        MenuItem findItem = menu.findItem(R.id.menu_dialer);
        MenuItem findItem2 = menu.findItem(R.id.menu_contacts);
        MenuItem findItem3 = menu.findItem(R.id.menu_voice_mail);
        MenuItem findItem4 = menu.findItem(R.id.menu_business);
        int i10 = this.f20276z;
        if (i10 == 0) {
            if (findItem != null) {
                findItem.setChecked(true);
            }
        } else if (i10 == 1) {
            if (findItem2 != null) {
                findItem2.setChecked(true);
            }
        } else if (i10 == 2) {
            if (findItem3 != null) {
                findItem3.setChecked(true);
            }
        } else if (i10 == 3 && findItem4 != null) {
            findItem4.setChecked(true);
        }
    }

    public Z3.o n2() {
        return this.f20247X;
    }

    public final void n3(final boolean z10, boolean z11) {
        if (H7.a.b()) {
            H7.b.b("ContactsTabActivity", "updateContactsLoadingStatus: isLoadingContact is " + z10 + ", needDelay = " + z11);
        }
        if (z11) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.customize.contacts.activities.z
                @Override // java.lang.Runnable
                public final void run() {
                    ContactsTabActivity.this.R2(z10);
                }
            }, 50L);
        } else {
            this.f20244U.g().m(Boolean.valueOf(z10));
        }
    }

    @Override // com.customize.contacts.ui.UnfoldContainerView.b
    public boolean o() {
        return this.f20259j0;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean o1() {
        return false;
    }

    public int o2() {
        return this.f20244U.i().getValue().intValue();
    }

    public final void o3() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f20243T.getLayoutParams();
        if (this.f20259j0) {
            int f10 = DisplayUtil.f(this, false);
            layoutParams.setMarginEnd(getResources().getDimensionPixelSize(R.dimen.floating_button_margin_end) + (f10 - UnfoldContainerView.a(f10, this)));
        } else {
            layoutParams.setMarginEnd(getResources().getDimensionPixelSize(R.dimen.floating_button_margin_end));
        }
        layoutParams.bottomMargin = l2();
        this.f20243T.setLayoutParams(layoutParams);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 2) {
            this.f20264o.onActivityResult(i10, i11, intent);
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper
    public void onApplyThemeResource(Resources.Theme theme, int i10, boolean z10) {
        super.onApplyThemeResource(theme, i10, z10);
        com.android.contacts.framework.api.businesshall.a.j(theme, i10, z10);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewTreeObserver viewTreeObserver = getWindow().getDecorView().getViewTreeObserver();
        viewTreeObserver.addOnPreDrawListener(new h(viewTreeObserver));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        InterfaceC0485h interfaceC0485h;
        InterfaceC0485h interfaceC0485h2;
        if (H7.a.b()) {
            H7.b.b("ContactsTabActivity", "onBackPressed");
        }
        MainActivitySearchManager mainActivitySearchManager = this.f20263n0;
        if (mainActivitySearchManager != null && mainActivitySearchManager.j()) {
            return;
        }
        int i10 = this.f20276z;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3 && (interfaceC0485h2 = this.f20270r) != null && (interfaceC0485h2 instanceof X0.a) && ((X0.a) interfaceC0485h2).c()) {
                        return;
                    }
                } else {
                    VisualVoicemailCallLogFragment visualVoicemailCallLogFragment = this.f20268q;
                    if (visualVoicemailCallLogFragment != null && visualVoicemailCallLogFragment.O1()) {
                        return;
                    }
                    if (this.f20268q == null && (interfaceC0485h = this.f20270r) != null && (interfaceC0485h instanceof X0.a) && ((X0.a) interfaceC0485h).c()) {
                        return;
                    }
                }
            } else {
                FoldableContactsMainListFragment foldableContactsMainListFragment = this.f20266p;
                if (foldableContactsMainListFragment != null && foldableContactsMainListFragment.x4()) {
                    return;
                }
            }
        } else {
            DialtactsUnfoldFragment dialtactsUnfoldFragment = this.f20264o;
            if (dialtactsUnfoldFragment != null && dialtactsUnfoldFragment.c6()) {
                return;
            }
        }
        super.onBackPressed();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f20230G == null) {
            if (H7.a.b()) {
                H7.b.b("ContactsTabActivity", "onConfigurationChanged mNavigationMainView == null, and retun.");
                return;
            }
            return;
        }
        boolean z10 = this.f20259j0;
        this.f20259j0 = DisplayUtil.o(this, configuration);
        H7.b.e("ContactsTabActivity", "onConfigurationChanged : mIsShowUnfoldScreen = " + this.f20259j0);
        if (CommonFeatureOption.k() && !isInMultiWindowMode()) {
            this.f20269q0.e(this, this.f20259j0);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.dial_fragment_layout);
            ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.foldable_contact_main_layout);
            if (this.f20269q0.b()) {
                this.f20259j0 = this.f20269q0.d();
                if (viewGroup != null) {
                    viewGroup.dispatchConfigurationChanged(configuration);
                }
                if (viewGroup2 != null) {
                    viewGroup2.dispatchConfigurationChanged(configuration);
                }
            }
        }
        boolean z11 = true;
        if (z10 != this.f20259j0) {
            v3();
            this.f20258i0.g(true);
            s3();
            r3();
            l3();
            g3(!this.f20239P);
        } else if (H7.a.b()) {
            H7.b.b("ContactsTabActivity", "onConfigurationChanged mShowChildUi not change: " + this.f20259j0);
        }
        o3();
        if (this.f20259j0 == z10) {
            z11 = false;
        }
        q3(z11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        int i10;
        boolean z10 = false;
        if (bundle == null) {
            try {
                FastReadData fastReadData = new FastReadData(this);
                this.f20246W = fastReadData;
                fastReadData.e();
            } catch (Throwable th) {
                H7.b.c("ContactsTabActivity", "onCreate: FastReadData acquireEvent failed: " + th);
            }
            ComponentName component = getIntent().getComponent();
            if (component != null) {
                str = component.getClassName();
            } else {
                str = "";
            }
            if ("com.android.contacts.DialtactsActivityAlias".equals(str)) {
                this.f20245V = 0;
                if (!B3.a.b0()) {
                    CallLogPreload callLogPreload = new CallLogPreload(this);
                    this.f20262m0 = callLogPreload;
                    callLogPreload.d();
                }
            } else if ("com.android.contacts.PeopleActivityAlias".equals(str)) {
                this.f20245V = 1;
            } else {
                this.f20245V = 2;
            }
            StartupSpeedHelper.K(this.f20245V);
        }
        super.onCreate(bundle);
        this.f20244U = (TabActivityViewModel) new androidx.lifecycle.K(this).a(TabActivityViewModel.class);
        this.f20247X = new Z3.o(this, this.f20244U, new InterfaceC1637a() { // from class: com.customize.contacts.activities.E
            @Override // v9.InterfaceC1637a
            public final Object invoke() {
                Boolean O22;
                O22 = ContactsTabActivity.this.O2();
                return O22;
            }
        });
        d2();
        if (RequestPermissionsActivity.p2(this)) {
            StartupSpeedHelper.I();
            return;
        }
        this.f20259j0 = DisplayUtil.n(this);
        setContentView(R.layout.contacts_tab_activity);
        if (this.f20245V == 0) {
            StartupSpeedHelper.M(this);
        }
        this.f20243T = (COUIFloatingButton) findViewById(R.id.floating_button);
        o3();
        this.f20243T.setOnChangeListener(new g());
        this.f20227D = findViewById(R.id.contact_tab_main);
        this.f20228E = (ViewGroup) findViewById(R.id.unfold_main_layout);
        this.f20265o0 = findViewById(R.id.navigation_bar);
        MainActivitySearchManager mainActivitySearchManager = new MainActivitySearchManager(this);
        this.f20263n0 = mainActivitySearchManager;
        mainActivitySearchManager.h(bundle, this.f20227D, this.f20271r0);
        O0(this.f20244U.i().getValue().intValue());
        ContactsViewPager contactsViewPager = (ContactsViewPager) findViewById(R.id.view_pager);
        this.f20226C = contactsViewPager;
        Object[] objArr = 0;
        contactsViewPager.addOnPageChangeListener(new m());
        ContactsViewPager contactsViewPager2 = this.f20226C;
        if (B3.a.W()) {
            i10 = 3;
        } else {
            i10 = 2;
        }
        contactsViewPager2.setOffscreenPageLimit(i10);
        HandlerThread handlerThread = new HandlerThread("contacts_tab_register_thread");
        this.f20241R = handlerThread;
        handlerThread.start();
        this.f20240Q = new o(this.f20241R.getLooper(), this);
        if (!W2(getIntent())) {
            finish();
            return;
        }
        this.f20238O = new n();
        if (bundle != null && bundle.containsKey("tab")) {
            this.f20224A = bundle.getInt("tab");
            if (H7.a.b()) {
                H7.b.b("ContactsTabActivity", "mCurrentSaveTab = " + this.f20224A);
            }
        }
        Application application = getApplication();
        if (application instanceof ContactsApplication) {
            ((ContactsApplication) application).w(this);
        }
        if (B3.a.W()) {
            if (com.android.contacts.util.w.o(this) && com.android.contacts.util.w.i(this)) {
                getContentResolver().registerContentObserver(VoicemailContract.Status.CONTENT_URI, true, this.f20254e0);
            } else {
                H7.b.i("ContactsTabActivity", "no voicemail read permissions");
            }
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            this.f20252c0 = defaultSharedPreferences;
            this.f20251b0 = defaultSharedPreferences.getBoolean("has_active_voicemail_provider", false);
            this.f20253d0 = new com.android.contacts.calllog.r(getContentResolver(), this);
        }
        w2();
        Y2();
        int i11 = this.f20224A;
        if (i11 != -1) {
            if (i11 == 0) {
                this.f20276z = 0;
            } else if (i11 == 1) {
                this.f20276z = 1;
            } else if (i11 == 2) {
                this.f20276z = 2;
            } else if (i11 == 3) {
                this.f20276z = 3;
            }
        } else {
            String i22 = i2(getIntent());
            if (D2(i22)) {
                this.f20276z = 0;
                if (!CommonFeatureOption.j()) {
                    this.f20276z = 1;
                }
            } else if ("com.android.contacts.business.BusinessHallActivityAlias".equals(i22) && c2()) {
                this.f20276z = 3;
            } else {
                this.f20276z = 1;
            }
        }
        getSupportFragmentManager().k(this.f20272s0);
        v3();
        if (bundle == null) {
            z10 = true;
        }
        x2(z10);
        this.f20257h0 = N7.a.a();
        COUIStatusBarResponseUtil cOUIStatusBarResponseUtil = new COUIStatusBarResponseUtil(this);
        this.f20233J = cOUIStatusBarResponseUtil;
        cOUIStatusBarResponseUtil.setStatusBarClickListener(this);
        y2();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        l lVar = this.f20229F;
        if (lVar != null) {
            lVar.unregisterDataSetObserver(this.f20250a0);
        }
        if (this.f20249Z != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f20249Z);
            } catch (Exception e10) {
                H7.b.c("ContactsTabActivity", "unregisterContentObserver: " + e10);
            }
            this.f20249Z = null;
        }
        if (B3.a.W() && this.f20254e0 != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f20254e0);
            } catch (Exception e11) {
                H7.b.c("ContactsTabActivity", "unregisterContentObserver: " + e11);
            }
            this.f20254e0 = null;
        }
        HandlerThread handlerThread = this.f20241R;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        o oVar = this.f20240Q;
        if (oVar != null) {
            oVar.removeCallbacksAndMessages(null);
        }
        ThreadPoolExecutor threadPoolExecutor = this.f20257h0;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
            this.f20257h0 = null;
        }
        if (FeatureOption.g()) {
            com.android.contacts.framework.api.businesshall.a.m(new k("obDestroy"));
        }
        com.android.contacts.calllog.x.b(this).a();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        DialtactsUnfoldFragment dialtactsUnfoldFragment;
        if (!CommonFeatureOption.m()) {
            return super.onKeyDown(i10, keyEvent);
        }
        if (keyEvent != null && keyEvent.getRepeatCount() > 0) {
            return true;
        }
        if (H7.a.b()) {
            H7.b.b("ContactsTabActivity", "onKeyDown: keyCode = " + i10);
        }
        if (this.f20276z == 0 && (dialtactsUnfoldFragment = this.f20264o) != null) {
            if (dialtactsUnfoldFragment.q5() && com.android.contacts.dialpad.e.c(i10)) {
                return true;
            }
            if (com.android.contacts.dialpad.e.a(i10)) {
                this.f20264o.f6(com.android.contacts.dialpad.e.b(i10), keyEvent);
                if (i10 == 42) {
                    return true;
                }
            }
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (!W2(intent)) {
            finish();
            return;
        }
        setIntent(intent);
        String i22 = i2(intent);
        h(false);
        if (D2(i22) && CommonFeatureOption.j()) {
            if (this.f20276z == 0) {
                DialtactsUnfoldFragment dialtactsUnfoldFragment = this.f20264o;
                if (dialtactsUnfoldFragment != null) {
                    dialtactsUnfoldFragment.g6(intent);
                    return;
                }
                return;
            }
            this.f20276z = 0;
            f3(0);
            DialtactsUnfoldFragment dialtactsUnfoldFragment2 = this.f20264o;
            if (dialtactsUnfoldFragment2 != null) {
                dialtactsUnfoldFragment2.g6(intent);
            }
            VisualVoicemailCallLogFragment visualVoicemailCallLogFragment = this.f20268q;
            if (visualVoicemailCallLogFragment != null) {
                visualVoicemailCallLogFragment.I1();
            }
            FoldableContactsMainListFragment foldableContactsMainListFragment = this.f20266p;
            if (foldableContactsMainListFragment != null) {
                foldableContactsMainListFragment.p4();
                this.f20266p.o4(false);
            }
        } else if ("com.android.contacts.business.BusinessHallActivityAlias".equals(i22) && c2()) {
            if (H7.a.b()) {
                H7.b.b("ContactsTabActivity", "onNewIntent business hall");
            }
            InterfaceC0485h interfaceC0485h = this.f20270r;
            if (interfaceC0485h instanceof X0.a) {
                ((X0.a) interfaceC0485h).b(intent);
            }
            if (this.f20276z == 3) {
                return;
            }
            this.f20276z = 3;
            f3(3);
            VisualVoicemailCallLogFragment visualVoicemailCallLogFragment2 = this.f20268q;
            if (visualVoicemailCallLogFragment2 != null) {
                visualVoicemailCallLogFragment2.I1();
            }
            FoldableContactsMainListFragment foldableContactsMainListFragment2 = this.f20266p;
            if (foldableContactsMainListFragment2 != null) {
                foldableContactsMainListFragment2.p4();
                this.f20266p.o4(false);
            }
            DialtactsUnfoldFragment dialtactsUnfoldFragment3 = this.f20264o;
            if (dialtactsUnfoldFragment3 != null) {
                dialtactsUnfoldFragment3.O8();
                this.f20264o.d9(false);
            }
        } else {
            if (this.f20276z == 1) {
                return;
            }
            this.f20276z = 1;
            f3(1);
            VisualVoicemailCallLogFragment visualVoicemailCallLogFragment3 = this.f20268q;
            if (visualVoicemailCallLogFragment3 != null) {
                visualVoicemailCallLogFragment3.I1();
            }
            DialtactsUnfoldFragment dialtactsUnfoldFragment4 = this.f20264o;
            if (dialtactsUnfoldFragment4 != null) {
                dialtactsUnfoldFragment4.O8();
                this.f20264o.d9(false);
            }
        }
        v3();
        p3();
        s3();
        int i10 = this.f20276z;
        if (i10 == 0) {
            U0.n.e();
            U0.n.g();
            Z3.j.c();
        } else if (i10 == 1) {
            U0.n.f();
            U0.n.g();
            Z3.j.d();
        }
        f2();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (C1643c.w()) {
            C1643c.M(this);
        }
        o oVar = this.f20240Q;
        if (oVar != null) {
            oVar.sendEmptyMessage(3);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        H7.b.e("ContactsTabActivity", "requestCode = " + i10);
        if (FeatureOption.o() && i10 == 1 && strArr != null && iArr != null && iArr.length == 1 && iArr[0] == 0 && strArr.length == 1 && TextUtils.equals(strArr[0], "android.permission.READ_PHONE_NUMBERS")) {
            H7.b.e("ContactsTabActivity", "grant = true");
            FoldableContactsMainListFragment foldableContactsMainListFragment = this.f20266p;
            if (foldableContactsMainListFragment != null) {
                foldableContactsMainListFragment.O0();
            }
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        d2();
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        C1.a.d("ContactsTabActivity", "onRestoreInstanceState");
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com.android.contacts.calllog.r rVar;
        super.onResume();
        Boolean B10 = StartupSpeedHelper.B();
        if (B10 == null) {
            B10 = Boolean.valueOf(com.android.contacts.framework.baseui.util.l.e(this));
        }
        if (B10.booleanValue()) {
            Y0();
        }
        if (!this.f20239P) {
            FoldableContactsMainListFragment foldableContactsMainListFragment = this.f20266p;
            if (foldableContactsMainListFragment != null && foldableContactsMainListFragment.u4()) {
                g3(false);
            } else {
                g3(true);
            }
        }
        if (this.f20276z == 0) {
            a2();
        }
        if (C1643c.w()) {
            C1643c.a(this, false, this.f20276z);
        }
        if (B3.a.W() && (rVar = this.f20253d0) != null) {
            rVar.m(this);
        }
        int i10 = this.f20276z;
        if (i10 == 0) {
            U0.m.c();
        } else if (i10 == 1) {
            U0.m.d();
        }
        if (this.f20267p0) {
            this.f20267p0 = false;
            X2();
            o oVar = this.f20240Q;
            if (oVar != null) {
                oVar.postDelayed(new Runnable() { // from class: com.customize.contacts.activities.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        ContactsTabActivity.this.P2();
                    }
                }, 5000L);
            }
        } else {
            com.android.contacts.framework.api.cloudsync.a.a("cloud_offline_check", C0490m.a(getLifecycle()), new Runnable() { // from class: com.customize.contacts.activities.y
                @Override // java.lang.Runnable
                public final void run() {
                    ContactsTabActivity.this.Q2();
                }
            });
        }
        o oVar2 = this.f20240Q;
        if (oVar2 != null) {
            oVar2.sendEmptyMessage(2);
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Throwable th) {
            H7.b.c("ContactsTabActivity", "e = " + th);
        }
        MainActivitySearchManager mainActivitySearchManager = this.f20263n0;
        if (mainActivitySearchManager != null) {
            mainActivitySearchManager.k(bundle);
        }
        bundle.putInt("tab", this.f20276z);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        ResponsiveUIConfig.getDefault(this);
        super.onStart();
        StartupSpeedHelper.r(this.f20264o);
        if (this.f20242S) {
            this.f20242S = false;
        }
        s3();
        TabActivityViewModel tabActivityViewModel = this.f20244U;
        if (tabActivityViewModel != null) {
            tabActivityViewModel.m();
        }
    }

    @Override // com.coui.appcompat.statusbar.COUIStatusBarResponseUtil.StatusBarClickListener
    public void onStatusBarClicked() {
        if (F2()) {
            return;
        }
        boolean b10 = ThreadUtilsKt.b();
        H7.b.e("ContactsTabActivity", "onStatusBarClicked: isMainThread: " + b10);
        if (b10) {
            u2();
        } else {
            runOnUiThread(new Runnable() { // from class: com.customize.contacts.activities.A
                @Override // java.lang.Runnable
                public final void run() {
                    ContactsTabActivity.this.u2();
                }
            });
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ThreadPoolExecutor threadPoolExecutor = this.f20257h0;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.execute(new Runnable() { // from class: com.customize.contacts.activities.B
                @Override // java.lang.Runnable
                public final void run() {
                    ContactsTabActivity.this.lambda$onStop$3();
                }
            });
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, android.app.Activity
    public void onTopResumedActivityChanged(boolean z10) {
        super.onTopResumedActivityChanged(z10);
        if (this.f20264o != null && E2()) {
            this.f20264o.h6(z10);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        DialtactsUnfoldFragment dialtactsUnfoldFragment;
        super.onWindowFocusChanged(z10);
        if (this.f20276z == 0 && (dialtactsUnfoldFragment = this.f20264o) != null) {
            dialtactsUnfoldFragment.i6(z10);
        }
    }

    public View p2() {
        return this.f20235L;
    }

    public final void p3() {
        q3(true);
    }

    public View q2() {
        return this.f20230G;
    }

    public final int r2() {
        if (this.f20259j0) {
            return com.android.contacts.framework.baseui.util.o.b();
        }
        if (this.f20276z == 0) {
            return getColor(R.color.pb_color_navigation_view);
        }
        return com.android.contacts.framework.baseui.util.o.b();
    }

    public void r3() {
        int m22 = m2();
        this.f20226C.setImportantForAccessibility(m22);
        this.f20243T.setImportantForAccessibility(m22);
        this.f20230G.setImportantForAccessibility(m22);
        COUINavigationView cOUINavigationView = this.f20231H;
        if (cOUINavigationView != null) {
            cOUINavigationView.setImportantForAccessibility(m22);
        }
    }

    public final int s2() {
        DialtactsUnfoldFragment dialtactsUnfoldFragment;
        if (this.f20259j0) {
            return com.android.contacts.framework.baseui.util.o.b();
        }
        if (this.f20276z == 0) {
            if (!OsUtils.f28280f && (dialtactsUnfoldFragment = this.f20264o) != null && dialtactsUnfoldFragment.g5()) {
                return com.android.contacts.framework.baseui.util.o.b();
            }
            return getColor(R.color.pb_color_navigation_view);
        }
        return com.android.contacts.framework.baseui.util.o.b();
    }

    public void s3() {
        int color;
        if (this.f20230G != null && L0()) {
            int r22 = r2();
            color = s2();
            this.f20230G.setBackgroundColor(r22);
            COUINavigationView cOUINavigationView = this.f20231H;
            if (cOUINavigationView != null) {
                cOUINavigationView.setBackgroundColor(r22);
            }
            if (OsUtils.f28280f) {
                View view = this.f20265o0;
                if (view != null) {
                    view.setBackgroundColor(color);
                }
            } else {
                getWindow().setNavigationBarColor(color);
            }
        } else {
            color = getColor(R.color.oplus_navigation_bar_color);
        }
        if (this.f20232I != color) {
            this.f20232I = color;
            if (OsUtils.f28280f) {
                View view2 = this.f20265o0;
                if (view2 != null) {
                    view2.setBackgroundColor(color);
                    return;
                }
                return;
            }
            getWindow().setNavigationBarColor(color);
        }
    }

    public int t2() {
        return this.f20274x.h();
    }

    public void t3(boolean z10) {
        MenuItem menuItem = this.f20236M;
        if (menuItem != null) {
            menuItem.setEnabled(z10);
        }
        MenuItem menuItem2 = this.f20237N;
        if (menuItem2 != null) {
            menuItem2.setVisible(false);
        }
    }

    public final void u2() {
        Object c10 = this.f20229F.c();
        H7.b.e("ContactsTabActivity", "onStatusBarClicked fragment = " + c10);
        if (c10 instanceof COUIStatusBarResponseUtil.StatusBarClickListener) {
            ((COUIStatusBarResponseUtil.StatusBarClickListener) c10).onStatusBarClicked();
        }
    }

    public void u3(boolean z10, boolean z11) {
        int i10;
        MenuItem menuItem = this.f20236M;
        if (menuItem != null) {
            menuItem.setEnabled(z10);
        }
        MenuItem menuItem2 = this.f20237N;
        if (menuItem2 != null) {
            boolean z12 = true;
            menuItem2.setVisible(true);
            MenuItem menuItem3 = this.f20237N;
            if (z10 && !z11) {
                z12 = false;
            }
            menuItem3.setEnabled(z12);
            MenuItem menuItem4 = this.f20237N;
            if (z10) {
                i10 = R.string.read_button;
            } else {
                i10 = R.string.read_button_all;
            }
            menuItem4.setTitle(i10);
        }
        View childAt = this.f20230G.getChildAt(0);
        if (childAt != null) {
            childAt.requestLayout();
        }
    }

    public void v2(int i10) {
        MenuItem menuItem;
        MenuItem menuItem2;
        MenuItem menuItem3;
        MenuItem menuItem4;
        float f10;
        j3();
        s3();
        v3();
        View view = this.f20235L;
        if (view != null) {
            if (this.f20276z == 0 && !this.f20259j0) {
                f10 = 0.0f;
            } else {
                f10 = 1.0f;
            }
            view.setAlpha(f10);
        }
        COUINavigationView cOUINavigationView = this.f20230G;
        if (cOUINavigationView != null) {
            menuItem = cOUINavigationView.getMenu().findItem(R.id.menu_dialer);
            if (menuItem == null) {
                this.f20230G.inflateMenu(R.menu.people_navigation_label);
                menuItem = this.f20230G.getMenu().findItem(R.id.menu_dialer);
                if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
                    menuItem.setTitle(R.string.odialer_app_name);
                }
            }
            menuItem2 = this.f20230G.getMenu().findItem(R.id.menu_contacts);
            menuItem3 = this.f20230G.getMenu().findItem(R.id.menu_voice_mail);
            menuItem4 = this.f20230G.getMenu().findItem(R.id.menu_business);
        } else {
            menuItem = null;
            menuItem2 = null;
            menuItem3 = null;
            menuItem4 = null;
        }
        if (i10 == 0) {
            if (menuItem != null) {
                menuItem.setChecked(true);
            }
            try {
                L.b c10 = this.f20274x.c(0);
                if (c10 != null) {
                    c10.b().b(this, getSupportFragmentManager(), this.f20229F);
                    if (this.f20264o == null && (c10.a() instanceof DialtactsUnfoldFragment)) {
                        this.f20264o = (DialtactsUnfoldFragment) c10.a();
                    }
                }
            } catch (Exception e10) {
                H7.b.c("ContactsTabActivity", "handleTabSelected DIAL_TAB_INDEX error." + e10);
            }
            DialtactsUnfoldFragment dialtactsUnfoldFragment = this.f20264o;
            if (dialtactsUnfoldFragment == null) {
                H7.b.c("ContactsTabActivity", "handleTabSelected mDialtactsFragment == null");
                return;
            }
            if (this.f20235L != null && !this.f20259j0 && !dialtactsUnfoldFragment.G()) {
                this.f20235L.setAlpha(1.0f);
            }
            this.f20264o.O6(this.f20238O);
            this.f20264o.Q3();
            this.f20264o.J7();
            if (this.f20264o.o5()) {
                this.f20264o.k8(true);
            } else {
                this.f20264o.w6();
            }
            this.f20244U.j().m(TabActivityViewModel.TabFragment.Dialer);
            this.f20264o.Q8();
            if (C1643c.w()) {
                if (D2(i2(getIntent()))) {
                    return;
                } else {
                    C1643c.a(this, true, 0);
                }
            }
        } else if (i10 == 1) {
            if (menuItem2 != null) {
                menuItem2.setChecked(true);
            }
            L.b c11 = this.f20274x.c(1);
            if (c11 != null) {
                c11.b().b(this, getSupportFragmentManager(), this.f20229F);
                if (this.f20266p == null && (c11.a() instanceof FoldableContactsMainListFragment)) {
                    this.f20266p = (FoldableContactsMainListFragment) c11.a();
                }
            }
            FoldableContactsMainListFragment foldableContactsMainListFragment = this.f20266p;
            if (foldableContactsMainListFragment == null) {
                H7.b.c("ContactsTabActivity", "handleTabSelected mFoldableContactListFragment == null");
                return;
            }
            foldableContactsMainListFragment.G3(this.f20238O);
            DialtactsUnfoldFragment dialtactsUnfoldFragment2 = this.f20264o;
            if (dialtactsUnfoldFragment2 != null) {
                dialtactsUnfoldFragment2.O8();
                this.f20264o.M7();
            }
            this.f20244U.j().m(TabActivityViewModel.TabFragment.Contact);
            this.f20266p.r4();
        } else if (i10 == 2) {
            if (menuItem3 != null) {
                menuItem3.setChecked(true);
            }
            if (this.f20268q == null) {
                return;
            }
            this.f20244U.j().m(TabActivityViewModel.TabFragment.VoiceMail);
            this.f20268q.W1();
            this.f20268q.V1(this.f20238O);
        } else if (i10 == 3) {
            if (menuItem4 != null) {
                menuItem4.setChecked(true);
            }
            if (this.f20270r == null) {
                return;
            }
            this.f20244U.j().m(TabActivityViewModel.TabFragment.BusinessHall);
            if (H7.a.b()) {
                H7.b.b("ContactsTabActivity", "handleTabSelected: call updateContactsLoadingStatus");
            }
            n3(false, false);
        }
        DialtactsUnfoldFragment dialtactsUnfoldFragment3 = this.f20264o;
        if (dialtactsUnfoldFragment3 != null && dialtactsUnfoldFragment3.o5()) {
            this.f20264o.x6();
        }
        p3();
    }

    public void v3() {
        if (H7.a.b()) {
            H7.b.b("ContactsTabActivity", "updateUnfoldView mShowChildUi = " + this.f20259j0 + ";mCurrentTab = " + this.f20276z);
        }
        ViewGroup viewGroup = this.f20228E;
        if (viewGroup == null) {
            H7.b.c("ContactsTabActivity", "updateUnfoldView(): but mainLayout is null");
            return;
        }
        if (this.f20259j0) {
            d3(viewGroup);
            return;
        }
        if (C2()) {
            ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.foldable_contact_main_layout);
            if (H7.a.b()) {
                H7.b.b("ContactsTabActivity", "updateUnfoldView isFoldableContactsTab contactsFragment = " + viewGroup2);
            }
            if (viewGroup2 != null) {
                if (this.f20228E.getChildCount() > 0) {
                    if (this.f20228E.getChildAt(0).getId() != R.id.foldable_contact_right_container) {
                        d3(this.f20228E);
                        X1(this.f20228E, viewGroup2);
                        return;
                    }
                    return;
                }
                X1(this.f20228E, viewGroup2);
                return;
            }
            return;
        }
        if (E2()) {
            ViewGroup viewGroup3 = (ViewGroup) findViewById(R.id.dial_fragment_layout);
            if (H7.a.b()) {
                H7.b.b("ContactsTabActivity", "updateUnfoldView isDialerTab dialFragment = " + viewGroup3);
            }
            if (viewGroup3 != null) {
                if (this.f20228E.getChildCount() > 0) {
                    if (this.f20228E.getChildAt(0).getId() != R.id.dial_container_content) {
                        d3(this.f20228E);
                        V1(this.f20228E, viewGroup3);
                        return;
                    }
                    return;
                }
                V1(this.f20228E, viewGroup3);
                return;
            }
            return;
        }
        d3(this.f20228E);
    }

    public final void w2() {
        this.f20230G = (COUINavigationView) findViewById(R.id.navigation_label_view);
        this.f20234K = (ViewStub) findViewById(R.id.navigation_tool_subview);
        this.f20235L = this.f20230G.getDividerView();
        com.customize.contacts.util.T t10 = new com.customize.contacts.util.T(this, this.f20230G, this.f20231H);
        this.f20258i0 = t10;
        t10.g(false);
        l3();
        this.f20230G.setOnItemSelectedListener(new NavigationBarView.c() { // from class: com.customize.contacts.activities.G
            @Override // com.google.android.material.navigation.NavigationBarView.c
            public final boolean onNavigationItemSelected(MenuItem menuItem) {
                boolean K22;
                K22 = ContactsTabActivity.this.K2(menuItem);
                return K22;
            }
        });
    }

    public void x2(boolean z10) {
        A2(z10);
        int currentItem = this.f20226C.getCurrentItem();
        f3(this.f20276z);
        int i10 = this.f20276z;
        if (currentItem == i10) {
            v2(i10);
        } else if (this.f20229F.getCount() == 1) {
            v2(this.f20276z);
        }
        if (this.f20224A != -1) {
            this.f20226C.post(new a());
        }
    }

    public final void y2() {
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.customize.contacts.activities.v
            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                boolean L22;
                L22 = ContactsTabActivity.this.L2();
                return L22;
            }
        });
    }

    public final void z2() {
        ViewStub viewStub;
        if (this.f20231H == null && (viewStub = this.f20234K) != null) {
            viewStub.inflate();
            COUINavigationView cOUINavigationView = (COUINavigationView) findViewById(R.id.navigation_tool_view);
            this.f20231H = cOUINavigationView;
            this.f20258i0.o(cOUINavigationView);
            this.f20231H.setImportantForAccessibility(m2());
            if (L0()) {
                this.f20231H.setBackgroundColor(r2());
            }
            this.f20231H.setOnNavigationItemSelectedListener(new j());
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public void u0() {
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public void y0() {
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public void z0() {
    }

    /* loaded from: classes3.dex */
    public class g implements COUIFloatingButton.OnChangeListener {
        public g() {
        }

        @Override // com.coui.appcompat.floatingactionbutton.COUIFloatingButton.OnChangeListener
        public boolean onMainActionSelected() {
            ContactsTabActivity.this.V2();
            return false;
        }

        @Override // com.coui.appcompat.floatingactionbutton.COUIFloatingButton.OnChangeListener
        public void onToggleChanged(boolean z10) {
        }
    }

    /* loaded from: classes3.dex */
    public class l extends com.customize.contacts.widget.c {

        /* renamed from: g, reason: collision with root package name */
        public final FragmentManager f20290g;

        /* renamed from: h, reason: collision with root package name */
        public androidx.fragment.app.B f20291h;

        /* renamed from: i, reason: collision with root package name */
        public Fragment f20292i;

        public l(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.f20290g = ContactsTabActivity.this.getSupportFragmentManager();
            this.f20291h = null;
            this.f20292i = null;
        }

        @Override // androidx.fragment.app.w, androidx.viewpager.widget.a
        public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
            if (this.f20291h == null) {
                this.f20291h = this.f20290g.p();
            }
            this.f20291h.p((Fragment) obj);
        }

        @Override // com.customize.contacts.widget.c, androidx.fragment.app.w, androidx.viewpager.widget.a
        public void finishUpdate(ViewGroup viewGroup) {
            androidx.fragment.app.B b10 = this.f20291h;
            if (b10 != null) {
                b10.j();
                this.f20291h = null;
                if (!this.f20290g.L0()) {
                    this.f20290g.i0();
                }
            }
        }

        @Override // androidx.viewpager.widget.a
        public int getCount() {
            return ContactsTabActivity.this.f20274x.h();
        }

        @Override // androidx.fragment.app.w
        public Fragment getItem(int i10) {
            return ContactsTabActivity.this.f20274x.b(i10);
        }

        @Override // androidx.viewpager.widget.a
        public int getItemPosition(Object obj) {
            int e10 = ContactsTabActivity.this.f20274x.e(obj);
            if (e10 >= 0) {
                return e10;
            }
            return -2;
        }

        @Override // com.customize.contacts.widget.c, androidx.fragment.app.w, androidx.viewpager.widget.a
        public Object instantiateItem(ViewGroup viewGroup, int i10) {
            boolean z10;
            if (this.f20291h == null) {
                this.f20291h = this.f20290g.p();
            }
            Fragment item = getItem(i10);
            this.f20291h.y(item);
            if (item == this.f20292i) {
                z10 = true;
            } else {
                z10 = false;
            }
            item.setUserVisibleHint(z10);
            return item;
        }

        @Override // androidx.fragment.app.w, androidx.viewpager.widget.a
        public boolean isViewFromObject(View view, Object obj) {
            if (((Fragment) obj).getView() == view) {
                return true;
            }
            return false;
        }

        @Override // androidx.fragment.app.w, androidx.viewpager.widget.a
        public Parcelable saveState() {
            return null;
        }

        @Override // com.customize.contacts.widget.c, androidx.fragment.app.w, androidx.viewpager.widget.a
        public void setPrimaryItem(ViewGroup viewGroup, int i10, Object obj) {
            super.d(obj);
            Fragment fragment = (Fragment) obj;
            Fragment fragment2 = this.f20292i;
            if (fragment != fragment2) {
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(false);
                    this.f20292i.setUserVisibleHint(false);
                }
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
                this.f20292i = fragment;
            }
        }

        @Override // androidx.fragment.app.w, androidx.viewpager.widget.a
        public void startUpdate(ViewGroup viewGroup) {
            if (viewGroup.getId() != -1) {
                return;
            }
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }

        @Override // androidx.fragment.app.w, androidx.viewpager.widget.a
        public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public void f1(Activity activity, boolean z10, boolean z11) {
    }
}
