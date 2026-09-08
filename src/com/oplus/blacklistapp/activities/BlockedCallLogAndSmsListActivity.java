package com.oplus.blacklistapp.activities;

import X8.n;
import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.w;
import androidx.viewpager.widget.ViewPager;
import com.android.incallui.OplusPhoneUtils;
import com.coui.appcompat.dateutils.COUIDateUtils;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.list.COUIListView;
import com.coui.appcompat.statusbar.COUIStatusBarResponseUtil;
import com.coui.appcompat.tablayout.COUITab;
import com.coui.appcompat.tablayout.COUITabLayout;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationBarView;
import com.oplus.blacklistapp.BlackListAppUtil;
import com.oplus.blacklistapp.activities.BlockedCallLogAndSmsListActivity;
import com.oplus.blacklistapp.p;
import com.oplus.blacklistapp.s;
import com.oplus.blacklistapp.u;
import com.oplus.utils.BlackListCoroutineUtils;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0848i;
import com.oplus.utils.C0849j;
import com.oplus.utils.C0853n;
import com.oplus.utils.C0861w;
import com.oplus.utils.C0863y;
import com.oplus.utils.E;
import com.oplus.utils.G;
import com.oplus.utils.InterfaceC0851l;
import com.oplus.utils.L;
import com.oplus.utils.StatisticsUtils;
import com.oplus.utils.T;
import com.oplus.widget.BlacklistViewPager;
import com.oplus.widget.SmallTabBehavior;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import r6.r;

/* loaded from: classes3.dex */
public class BlockedCallLogAndSmsListActivity extends BaseNavigationActivity implements View.OnClickListener {

    /* renamed from: A, reason: collision with root package name */
    public Context f26267A;

    /* renamed from: B, reason: collision with root package name */
    public MenuItem f26268B;

    /* renamed from: C, reason: collision with root package name */
    public MenuItem f26269C;

    /* renamed from: D, reason: collision with root package name */
    public MenuItem f26270D;

    /* renamed from: E, reason: collision with root package name */
    public MenuItem f26271E;

    /* renamed from: F, reason: collision with root package name */
    public f f26272F;

    /* renamed from: G, reason: collision with root package name */
    public boolean f26273G;

    /* renamed from: H, reason: collision with root package name */
    public COUIStatusBarResponseUtil f26274H;

    /* renamed from: I, reason: collision with root package name */
    public String[] f26275I;

    /* renamed from: J, reason: collision with root package name */
    public TextView f26276J;

    /* renamed from: K, reason: collision with root package name */
    public SmallTabBehavior f26277K;

    /* renamed from: L, reason: collision with root package name */
    public View f26278L;

    /* renamed from: M, reason: collision with root package name */
    public Dialog f26279M;

    /* renamed from: P, reason: collision with root package name */
    public long f26282P;

    /* renamed from: o, reason: collision with root package name */
    public COUIToolbar f26288o;

    /* renamed from: p, reason: collision with root package name */
    public COUITabLayout f26289p;

    /* renamed from: q, reason: collision with root package name */
    public AppBarLayout f26290q;

    /* renamed from: r, reason: collision with root package name */
    public BlacklistViewPager f26291r;

    /* renamed from: y, reason: collision with root package name */
    public r6.g f26293y;

    /* renamed from: z, reason: collision with root package name */
    public r f26294z;

    /* renamed from: m, reason: collision with root package name */
    public String f26286m = "";

    /* renamed from: n, reason: collision with root package name */
    public String f26287n = "";

    /* renamed from: x, reason: collision with root package name */
    public int f26292x = 0;

    /* renamed from: N, reason: collision with root package name */
    public String f26280N = "";

    /* renamed from: O, reason: collision with root package name */
    public boolean f26281O = false;

    /* renamed from: Q, reason: collision with root package name */
    public int f26283Q = -1;

    /* renamed from: R, reason: collision with root package name */
    public final InterfaceC0851l f26284R = new c();

    /* renamed from: S, reason: collision with root package name */
    public final COUITabLayout.OnTabSelectedListener f26285S = new e();

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            BlockedCallLogAndSmsListActivity.this.f26290q.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int measuredHeight = BlockedCallLogAndSmsListActivity.this.f26290q.getMeasuredHeight();
            if (BlockedCallLogAndSmsListActivity.this.f26293y != null) {
                BlockedCallLogAndSmsListActivity.this.f26293y.B1(measuredHeight);
            }
            if (BlockedCallLogAndSmsListActivity.this.f26294z != null) {
                BlockedCallLogAndSmsListActivity.this.f26294z.L1(measuredHeight);
            }
            BlockedCallLogAndSmsListActivity.this.f26291r.setCurrentItem(BlockedCallLogAndSmsListActivity.this.f26292x);
            BlockedCallLogAndSmsListActivity.this.f26289p.setupWithViewPager(BlockedCallLogAndSmsListActivity.this.f26291r);
            BlockedCallLogAndSmsListActivity.this.O1();
            if (BlockedCallLogAndSmsListActivity.this.f26277K != null) {
                BlockedCallLogAndSmsListActivity.this.f26277K.k(measuredHeight + C0849j.l(BlockedCallLogAndSmsListActivity.this.f26267A));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements f {
        public b() {
        }

        @Override // com.oplus.blacklistapp.activities.BlockedCallLogAndSmsListActivity.f
        public void a() {
            boolean z10;
            if (BlockedCallLogAndSmsListActivity.this.f26270D != null) {
                BlockedCallLogAndSmsListActivity.this.f26270D.setEnabled(BlockedCallLogAndSmsListActivity.this.U1());
            }
            boolean z11 = false;
            if (BlockedCallLogAndSmsListActivity.this.f26268B != null) {
                MenuItem menuItem = BlockedCallLogAndSmsListActivity.this.f26268B;
                if (BlockedCallLogAndSmsListActivity.this.R1() == 1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                menuItem.setEnabled(z10);
            }
            if (BlockedCallLogAndSmsListActivity.this.f26269C != null) {
                MenuItem menuItem2 = BlockedCallLogAndSmsListActivity.this.f26269C;
                if (BlockedCallLogAndSmsListActivity.this.R1() == 1 && !BlockedCallLogAndSmsListActivity.this.V1()) {
                    z11 = true;
                }
                menuItem2.setEnabled(z11);
            }
            if (BlockedCallLogAndSmsListActivity.this.f26271E != null) {
                BlockedCallLogAndSmsListActivity.this.f26271E.setEnabled(BlockedCallLogAndSmsListActivity.this.W1());
            }
        }

        @Override // com.oplus.blacklistapp.activities.BlockedCallLogAndSmsListActivity.f
        public void b() {
            BlockedCallLogAndSmsListActivity.this.i2();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements InterfaceC0851l {
        public c() {
        }

        @Override // com.oplus.utils.InterfaceC0851l
        public void onCancel() {
            if (BlockedCallLogAndSmsListActivity.this.f26293y != null) {
                BlockedCallLogAndSmsListActivity.this.f26293y.o2();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends w {

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String[] f26298f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ FragmentManager f26299g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(FragmentManager fragmentManager, String[] strArr, FragmentManager fragmentManager2) {
            super(fragmentManager);
            this.f26298f = strArr;
            this.f26299g = fragmentManager2;
        }

        @Override // androidx.viewpager.widget.a
        public int getCount() {
            return this.f26298f.length;
        }

        @Override // androidx.fragment.app.w
        public Fragment getItem(int i10) {
            if (i10 == 0) {
                BlockedCallLogAndSmsListActivity.this.f26293y = new r6.g();
                BlockedCallLogAndSmsListActivity.this.f26293y.e2(BlockedCallLogAndSmsListActivity.this.f26272F);
                BlockedCallLogAndSmsListActivity.this.f26293y.h2(BlockedCallLogAndSmsListActivity.this.f26288o);
                BlockedCallLogAndSmsListActivity.this.f26293y.g2(BlockedCallLogAndSmsListActivity.this.f26276J);
                return BlockedCallLogAndSmsListActivity.this.f26293y;
            }
            BlockedCallLogAndSmsListActivity.this.f26294z = new r();
            BlockedCallLogAndSmsListActivity.this.f26294z.u2(BlockedCallLogAndSmsListActivity.this.f26272F);
            BlockedCallLogAndSmsListActivity.this.f26294z.x2(BlockedCallLogAndSmsListActivity.this.f26288o);
            BlockedCallLogAndSmsListActivity.this.f26294z.w2(BlockedCallLogAndSmsListActivity.this.f26276J);
            return BlockedCallLogAndSmsListActivity.this.f26294z;
        }

        @Override // androidx.viewpager.widget.a
        public CharSequence getPageTitle(int i10) {
            return this.f26298f[i10];
        }

        @Override // androidx.fragment.app.w, androidx.viewpager.widget.a
        public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
            if (parcelable != null) {
                Bundle bundle = (Bundle) parcelable;
                BlockedCallLogAndSmsListActivity.this.f26286m = bundle.getString("calllog_tab");
                BlockedCallLogAndSmsListActivity.this.f26287n = bundle.getString("sms_tab");
                if (BlockedCallLogAndSmsListActivity.this.f26293y == null) {
                    BlockedCallLogAndSmsListActivity blockedCallLogAndSmsListActivity = BlockedCallLogAndSmsListActivity.this;
                    blockedCallLogAndSmsListActivity.f26293y = (r6.g) this.f26299g.m0(blockedCallLogAndSmsListActivity.f26286m);
                    BlockedCallLogAndSmsListActivity blockedCallLogAndSmsListActivity2 = BlockedCallLogAndSmsListActivity.this;
                    blockedCallLogAndSmsListActivity2.f26294z = (r) this.f26299g.m0(blockedCallLogAndSmsListActivity2.f26287n);
                }
                BlockedCallLogAndSmsListActivity.this.f26293y.e2(BlockedCallLogAndSmsListActivity.this.f26272F);
                BlockedCallLogAndSmsListActivity.this.f26293y.h2(BlockedCallLogAndSmsListActivity.this.f26288o);
                BlockedCallLogAndSmsListActivity.this.f26293y.g2(BlockedCallLogAndSmsListActivity.this.f26276J);
                BlockedCallLogAndSmsListActivity.this.f26294z.u2(BlockedCallLogAndSmsListActivity.this.f26272F);
                BlockedCallLogAndSmsListActivity.this.f26294z.x2(BlockedCallLogAndSmsListActivity.this.f26288o);
                BlockedCallLogAndSmsListActivity.this.f26294z.w2(BlockedCallLogAndSmsListActivity.this.f26276J);
            }
        }

        @Override // androidx.fragment.app.w, androidx.viewpager.widget.a
        public Parcelable saveState() {
            if (BlockedCallLogAndSmsListActivity.this.f26293y != null && BlockedCallLogAndSmsListActivity.this.f26294z != null) {
                Bundle bundle = new Bundle();
                BlockedCallLogAndSmsListActivity blockedCallLogAndSmsListActivity = BlockedCallLogAndSmsListActivity.this;
                blockedCallLogAndSmsListActivity.f26286m = blockedCallLogAndSmsListActivity.f26293y.getTag();
                BlockedCallLogAndSmsListActivity blockedCallLogAndSmsListActivity2 = BlockedCallLogAndSmsListActivity.this;
                blockedCallLogAndSmsListActivity2.f26287n = blockedCallLogAndSmsListActivity2.f26294z.getTag();
                bundle.putString("calllog_tab", BlockedCallLogAndSmsListActivity.this.f26286m);
                bundle.putString("sms_tab", BlockedCallLogAndSmsListActivity.this.f26287n);
                return bundle;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a();

        void b();
    }

    /* loaded from: classes3.dex */
    public interface g {
        void k(boolean z10);
    }

    /* loaded from: classes3.dex */
    public class h implements ViewPager.i {
        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageSelected(int i10) {
            BlockedCallLogAndSmsListActivity.this.T1(i10);
        }

        public h() {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageScrollStateChanged(int i10) {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageScrolled(int i10, float f10, int i11) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O1() {
        r rVar;
        int i10 = this.f26292x;
        if (i10 == 0) {
            r6.g gVar = this.f26293y;
            if (gVar != null) {
                gVar.E1();
                return;
            }
            return;
        }
        if (i10 == 1 && (rVar = this.f26294z) != null) {
            rVar.O1();
        }
    }

    private void P1(boolean z10) {
        if (this.f26289p == null) {
            return;
        }
        for (int i10 = 0; i10 < this.f26289p.getTabCount(); i10++) {
            this.f26289p.enableTab(i10, z10);
        }
        if (z10) {
            this.f26289p.setVisibility(0);
            j2();
        } else {
            this.f26289p.setVisibility(8);
            this.f26278L.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int R1() {
        r rVar;
        int i10 = this.f26292x;
        if (i10 == 0) {
            r6.g gVar = this.f26293y;
            if (gVar != null) {
                return gVar.L1();
            }
            return 0;
        }
        if (i10 == 1 && (rVar = this.f26294z) != null) {
            return rVar.V1();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T1(int i10) {
        if (i10 == 0) {
            if (this.f26292x == 0) {
                return;
            }
            this.f26292x = 0;
            r6.g gVar = this.f26293y;
            if (gVar != null) {
                gVar.p2();
                this.f26293y.n2();
            }
            r rVar = this.f26294z;
            if (rVar != null) {
                rVar.F2();
            }
            J1("block_message", this.f26282P, System.currentTimeMillis());
            this.f26282P = System.currentTimeMillis();
        } else if (i10 == 1) {
            if (this.f26292x == 1) {
                return;
            }
            this.f26292x = 1;
            r6.g gVar2 = this.f26293y;
            if (gVar2 != null) {
                gVar2.p2();
            }
            r rVar2 = this.f26294z;
            if (rVar2 != null) {
                rVar2.F2();
                this.f26294z.D2();
            }
            J1("block_call", this.f26282P, System.currentTimeMillis());
            this.f26282P = System.currentTimeMillis();
        }
        T.c();
        O0();
        invalidateOptionsMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean U1() {
        r rVar;
        int i10 = this.f26292x;
        if (i10 == 0) {
            r6.g gVar = this.f26293y;
            if (gVar != null) {
                return gVar.S1();
            }
            return false;
        }
        if (i10 == 1 && (rVar = this.f26294z) != null) {
            return rVar.Y1();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean V1() {
        r rVar;
        int i10 = this.f26292x;
        if (i10 == 0 || i10 != 1 || (rVar = this.f26294z) == null) {
            return false;
        }
        return rVar.Z1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean W1() {
        r rVar;
        if (this.f26292x == 1 && (rVar = this.f26294z) != null) {
            return rVar.b2();
        }
        return false;
    }

    private boolean X1() {
        r rVar;
        int i10 = this.f26292x;
        if (i10 == 0) {
            r6.g gVar = this.f26293y;
            if (gVar == null || !gVar.R1()) {
                return false;
            }
            return true;
        }
        if (i10 != 1 || (rVar = this.f26294z) == null || !rVar.a2()) {
            return false;
        }
        return true;
    }

    private void Y1() {
        this.f26288o.setOnMenuItemClickListener(new Toolbar.g() { // from class: p6.f
            @Override // androidx.appcompat.widget.Toolbar.g
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean c22;
                c22 = BlockedCallLogAndSmsListActivity.this.c2(menuItem);
                return c22;
            }
        });
    }

    private boolean Z1() {
        r rVar;
        int i10 = this.f26292x;
        if (i10 == 0) {
            r6.g gVar = this.f26293y;
            if (gVar == null || !gVar.U1()) {
                return false;
            }
            return true;
        }
        if (i10 != 1 || (rVar = this.f26294z) == null || !rVar.e2()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d2() {
        C0849j.w(getApplicationContext());
    }

    private void m2(boolean z10) {
        r6.g gVar;
        int i10 = this.f26292x;
        if (i10 == 1) {
            r rVar = this.f26294z;
            if (rVar != null) {
                R0(z10, rVar.X1());
                return;
            }
            return;
        }
        if (i10 == 0 && (gVar = this.f26293y) != null) {
            R0(z10, gVar.O1());
        }
    }

    public final void J1(String str, long j10, long j11) {
        Locale locale = Locale.CHINA;
        String yMDWHMDate = COUIDateUtils.getYMDWHMDate(S1(this, locale), new Date(j10));
        String yMDWHMDate2 = COUIDateUtils.getYMDWHMDate(S1(this, locale), new Date(j11));
        HashMap hashMap = new HashMap();
        hashMap.put("page_name", str);
        hashMap.put("duration", String.valueOf(j11 - j10));
        hashMap.put("begin_time", yMDWHMDate);
        hashMap.put("end_time", yMDWHMDate2);
        StatisticsUtils.a(this, 2010802, 201081001, hashMap, false);
    }

    public void K1(String str) {
        String str2;
        HashMap hashMap = new HashMap();
        hashMap.put("entry_mode", str);
        if (this.f26292x == 0) {
            str2 = "call";
        } else {
            str2 = "message";
        }
        hashMap.put("entry_list", str2);
        StatisticsUtils.a(this, 2010803, 201081006, hashMap, false);
    }

    public final void L1(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("entry", str);
        StatisticsUtils.a(this, 2010802, 201081002, hashMap, false);
    }

    public void M1(int i10, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        hashMap.put("confirm_number", str3);
        StatisticsUtils.a(this, 2010803, StatisticsUtils.f29090a[i10][this.f26292x], hashMap, false);
    }

    public final void N1(String[] strArr) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.f26291r.setAdapter(new d(supportFragmentManager, strArr, supportFragmentManager));
    }

    @Override // com.oplus.blacklistapp.activities.BaseNavigationActivity
    public void O0() {
        boolean z10;
        super.O0();
        if (this.f26263i.getMenu().size() == 0) {
            this.f26263i.inflateMenu(s.f27476e);
        }
        this.f26268B = this.f26263i.getMenu().findItem(p.f27423x0);
        this.f26269C = this.f26263i.getMenu().findItem(p.f27375Z0);
        this.f26270D = this.f26263i.getMenu().findItem(p.f27422x);
        MenuItem findItem = this.f26263i.getMenu().findItem(p.f27378b);
        this.f26271E = findItem;
        int i10 = this.f26292x;
        boolean z11 = false;
        if (i10 == 0) {
            findItem.setVisible(false);
        } else if (i10 == 1) {
            findItem.setVisible(true);
        }
        this.f26268B.setVisible(true);
        this.f26269C.setVisible(true);
        if (l7.b.c(this.f26267A) || l7.b.f34743k) {
            this.f26269C.setVisible(false);
        }
        this.f26263i.setOnItemSelectedListener(new NavigationBarView.c() { // from class: p6.c
            @Override // com.google.android.material.navigation.NavigationBarView.c
            public final boolean onNavigationItemSelected(MenuItem menuItem) {
                boolean b22;
                b22 = BlockedCallLogAndSmsListActivity.this.b2(menuItem);
                return b22;
            }
        });
        MenuItem menuItem = this.f26270D;
        if (menuItem != null) {
            menuItem.setTitle(u.f27508E0);
            this.f26270D.setEnabled(U1());
        }
        this.f26268B.setTitle(u.f27522H2);
        MenuItem menuItem2 = this.f26268B;
        if (R1() == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        menuItem2.setEnabled(z10);
        this.f26269C.setTitle(u.f27605c);
        MenuItem menuItem3 = this.f26269C;
        if (R1() == 1 && !V1()) {
            z11 = true;
        }
        menuItem3.setEnabled(z11);
        MenuItem menuItem4 = this.f26271E;
        if (menuItem4 != null) {
            menuItem4.setEnabled(W1());
        }
    }

    public void Q1() {
        r rVar;
        b1(true);
        P1(false);
        n2(false);
        int i10 = this.f26292x;
        if (i10 == 0) {
            r6.g gVar = this.f26293y;
            if (gVar != null) {
                gVar.I1();
            }
        } else if (i10 == 1 && (rVar = this.f26294z) != null) {
            rVar.S1();
        }
        if (!l7.b.f34742j && !l7.b.f34743k) {
            this.f26277K.m(false);
            this.f26277K.l(true);
            int a10 = C0853n.a(this);
            this.f26288o.setTitleTextColor(Color.argb(0, Color.red(a10), Color.green(a10), Color.blue(a10)));
            if (a2()) {
                this.f26276J.setVisibility(0);
            } else {
                this.f26288o.setTitleTextColor(Color.argb(255, Color.red(a10), Color.green(a10), Color.blue(a10)));
            }
        } else {
            this.f26276J.setVisibility(8);
            this.f26278L.setVisibility(8);
        }
        m2(true);
        this.f26272F.a();
        s0(n0());
    }

    public final Context S1(Context context, Locale locale) {
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(locale);
        return context.createConfigurationContext(configuration);
    }

    public boolean a2() {
        if (this.f26292x == 0) {
            r6.g gVar = this.f26293y;
            if (gVar != null && gVar.N1() <= this.f26277K.h()) {
                return false;
            }
            return true;
        }
        r rVar = this.f26294z;
        if (rVar != null && rVar.W1() <= this.f26277K.h()) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ boolean b2(MenuItem menuItem) {
        r rVar;
        r rVar2;
        int itemId = menuItem.getItemId();
        if (itemId == p.f27378b) {
            if (this.f26292x == 1) {
                r rVar3 = this.f26294z;
                if (rVar3 != null) {
                    rVar3.m2();
                    if (this.f26294z.U1() != null) {
                        this.f26294z.U1().s(true);
                    }
                }
                i2();
            }
            M1(3, "read", "read", String.valueOf(this.f26294z.f36451a.size()));
            return false;
        }
        if (itemId == p.f27423x0) {
            int i10 = this.f26292x;
            if (i10 == 0) {
                r6.g gVar = this.f26293y;
                if (gVar != null) {
                    gVar.k2();
                    return false;
                }
                return false;
            }
            if (i10 == 1 && (rVar2 = this.f26294z) != null) {
                rVar2.A2();
                return false;
            }
            return false;
        }
        if (itemId == p.f27375Z0) {
            int i11 = this.f26292x;
            if (i11 == 0) {
                r6.g gVar2 = this.f26293y;
                if (gVar2 != null) {
                    gVar2.m2();
                    return false;
                }
                return false;
            }
            if (i11 == 1 && (rVar = this.f26294z) != null) {
                rVar.C2();
                return false;
            }
            return false;
        }
        if (itemId == p.f27422x) {
            o2();
            return false;
        }
        return false;
    }

    public final /* synthetic */ boolean c2(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == p.f27330D) {
            O0();
            if (BlackListAppUtil.c().a()) {
                Log.i("BlockedCallLogAndSmsListActivity", "Invalid click return");
                return false;
            }
            this.f26283Q = itemId;
            K1("click_item");
            return true;
        }
        if (itemId == p.f27388g) {
            StatisticsUtils.d(getApplicationContext(), "block_rule");
            Intent intent = new Intent("oplus.intent.action.anti.harassment");
            intent.setPackage(this.f26267A.getPackageName());
            intent.putExtra("navigate_title_id", u.f27696u0);
            C0849j.A(this, intent);
            return true;
        }
        if (itemId == p.f27377a0) {
            if (this.f26292x == 0) {
                return false;
            }
            r rVar = this.f26294z;
            if (rVar != null) {
                rVar.m2();
            }
            return true;
        }
        if (itemId == p.f27400m) {
            i2();
            return true;
        }
        if (itemId == p.f27327B0) {
            k2();
        }
        return true;
    }

    public final /* synthetic */ void e2() {
        if (this.f26283Q == p.f27330D) {
            Q1();
            this.f26283Q = -1;
        }
    }

    public final /* synthetic */ void f2(DialogInterface dialogInterface, int i10) {
        M1(2, "confirm_delete", "no", OplusPhoneUtils.DeviceState.INVALID_STATUS);
    }

    public final /* synthetic */ void g2(DialogInterface dialogInterface, int i10) {
        r rVar;
        if (i10 == -3) {
            int i11 = this.f26292x;
            if (i11 == 0) {
                r6.g gVar = this.f26293y;
                if (gVar != null) {
                    gVar.F1();
                    return;
                }
                return;
            }
            if (i11 == 1 && (rVar = this.f26294z) != null) {
                rVar.P1();
            }
        }
    }

    public COUIToolbar getToolbar() {
        return this.f26288o;
    }

    public void h2(int i10, String[] strArr) {
        this.f26289p.setTabMode(i10);
        this.f26289p.requestLayout();
        this.f26289p.invalidate();
        N1(strArr);
    }

    public void i2() {
        r rVar;
        if (!Z1()) {
            return;
        }
        P1(true);
        n2(true);
        if (!l7.b.f34742j && !l7.b.f34743k) {
            this.f26277K.m(true);
            this.f26277K.l(false);
            int a10 = C0853n.a(this);
            this.f26288o.setTitleTextColor(Color.argb(255, Color.red(a10), Color.green(a10), Color.blue(a10)));
        } else {
            this.f26289p.setVisibility(8);
            this.f26276J.setVisibility(8);
            this.f26278L.setVisibility(8);
            n2(false);
        }
        b1(false);
        int i10 = this.f26292x;
        if (i10 == 0) {
            r6.g gVar = this.f26293y;
            if (gVar != null) {
                gVar.a2();
            }
        } else if (i10 == 1 && (rVar = this.f26294z) != null) {
            rVar.q2();
        }
        m2(false);
        this.f26272F.a();
        s0(n0());
    }

    public final void j2() {
        this.f26276J.setVisibility(8);
        this.f26276J.setAlpha(1.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f26276J.getLayoutParams();
        layoutParams.topMargin = 0;
        this.f26276J.setLayoutParams(layoutParams);
        this.f26278L.setVisibility(8);
        this.f26278L.setAlpha(0.0f);
    }

    public final void k2() {
        r rVar;
        int i10 = this.f26292x;
        if (i10 == 0) {
            r6.g gVar = this.f26293y;
            if (gVar != null) {
                gVar.c2();
            }
        } else if (i10 == 1 && (rVar = this.f26294z) != null) {
            rVar.s2();
        }
        this.f26272F.a();
    }

    public void l2(int i10) {
        r rVar;
        int i11 = this.f26292x;
        if (i11 == 0) {
            r6.g gVar = this.f26293y;
            if (gVar != null) {
                gVar.f2(i10);
                return;
            }
            return;
        }
        if (i11 == 1 && (rVar = this.f26294z) != null) {
            rVar.v2(i10);
        }
    }

    @Override // com.oplus.blacklistapp.framework.baseui.BasicActivity
    public boolean m0() {
        return false;
    }

    @Override // com.oplus.blacklistapp.framework.baseui.BasicActivity
    public boolean n0() {
        r rVar;
        int i10 = this.f26292x;
        if (i10 == 0) {
            r6.g gVar = this.f26293y;
            if (gVar != null) {
                return gVar.U1();
            }
        } else if (i10 == 1 && (rVar = this.f26294z) != null) {
            return rVar.e2();
        }
        return false;
    }

    public void n2(boolean z10) {
        BlacklistViewPager blacklistViewPager = this.f26291r;
        if (blacklistViewPager != null) {
            blacklistViewPager.setCanScrolling(z10);
        }
    }

    public final void o2() {
        int i10;
        boolean z10;
        int i11;
        Dialog dialog = this.f26279M;
        if (dialog != null) {
            dialog.dismiss();
            this.f26279M = null;
        }
        int R12 = R1();
        int i12 = this.f26292x;
        boolean z11 = true;
        if (i12 == 0) {
            r6.g gVar = this.f26293y;
            if (gVar != null && gVar.K1() != null) {
                i10 = this.f26293y.K1().getCount();
            } else {
                i10 = 0;
            }
            z10 = true;
        } else if (i12 == 1) {
            r rVar = this.f26294z;
            if (rVar != null && rVar.U1() != null) {
                i10 = this.f26294z.U1().getCount();
            } else {
                i10 = 0;
            }
            z10 = false;
        } else {
            i10 = 0;
            z10 = false;
        }
        String d10 = C0848i.d(this.f26267A, R12, i10, z10);
        if (i10 != R12) {
            z11 = false;
        }
        COUIAlertDialogBuilder negativeButton = new S8.b(this, n.f5032d).setTitle((CharSequence) d10).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: p6.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i13) {
                BlockedCallLogAndSmsListActivity.this.f2(dialogInterface, i13);
            }
        });
        if (z11) {
            i11 = u.f27560R0;
        } else {
            i11 = u.f27508E0;
        }
        COUIAlertDialogBuilder neutralButton = negativeButton.setNeutralButton(i11, new DialogInterface.OnClickListener() { // from class: p6.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i13) {
                BlockedCallLogAndSmsListActivity.this.g2(dialogInterface, i13);
            }
        });
        String e10 = C0848i.e(this.f26267A, R12, i10, z10);
        if (!TextUtils.isEmpty(e10)) {
            neutralButton.setMessage((CharSequence) e10);
        }
        androidx.appcompat.app.b create = neutralButton.create();
        this.f26279M = create;
        create.show();
        neutralButton.updateViewAfterShown();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 10 && !isFinishing()) {
            String[] f10 = L.f(this);
            this.f26275I = f10;
            if (f10 != null && f10.length > 0) {
                for (String str : f10) {
                    if (shouldShowRequestPermissionRationale(str)) {
                        requestPermissions(this.f26275I, 1);
                        return;
                    }
                }
                L.q(this, this.f26275I, this.f26284R);
                return;
            }
            C0861w.g(getApplicationContext()).k();
            r6.g gVar = this.f26293y;
            if (gVar != null) {
                gVar.o2();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (C0846g.c()) {
            Log.d("BlockedCallLogAndSmsListActivity", "--onBackPressed--");
        }
        this.f26281O = true;
        StatisticsUtils.d(getApplicationContext(), this.f26280N);
        if (Z1()) {
            i2();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        int i10 = this.f26292x;
        if (i10 == 0) {
            r6.g gVar = this.f26293y;
            if (gVar != null) {
                gVar.c2();
            }
        } else if (i10 == 1 && (rVar = this.f26294z) != null) {
            rVar.s2();
        }
        this.f26272F.a();
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        SmallTabBehavior smallTabBehavior = this.f26277K;
        if (smallTabBehavior != null) {
            smallTabBehavior.i();
        }
    }

    @Override // com.oplus.blacklistapp.activities.BaseNavigationActivity, com.oplus.blacklistapp.activities.BaseActivity, com.oplus.blacklistapp.framework.baseui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        this.f26267A = this;
        String[] f10 = L.f(this);
        this.f26275I = f10;
        if (f10 != null) {
            requestPermissions(f10, 1);
        } else {
            androidx.appcompat.app.b bVar = L.f29055a;
            if (bVar != null && bVar.isShowing()) {
                L.f29055a.dismiss();
                L.f29055a = null;
            }
        }
        if (this.f26275I == null) {
            C0861w.g(getApplicationContext()).k();
        }
        BlackListCoroutineUtils.a(new Runnable() { // from class: p6.d
            @Override // java.lang.Runnable
            public final void run() {
                BlockedCallLogAndSmsListActivity.this.d2();
            }
        });
        setContentView(com.oplus.blacklistapp.r.f27455j);
        COUIToolbar cOUIToolbar = (COUIToolbar) findViewById(p.f27363T0);
        this.f26288o = cOUIToolbar;
        setSupportActionBar(cOUIToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.t(true);
        }
        E.c(this, supportActionBar, this.f26288o, getIntent());
        COUITabLayout cOUITabLayout = (COUITabLayout) findViewById(p.f27353O0);
        this.f26289p = cOUITabLayout;
        cOUITabLayout.addOnTabSelectedListener(this.f26285S);
        BlacklistViewPager blacklistViewPager = (BlacklistViewPager) findViewById(p.f27369W0);
        this.f26291r = blacklistViewPager;
        blacklistViewPager.setClipToPadding(false);
        this.f26291r.addOnPageChangeListener(new h());
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(p.f27376a);
        this.f26290q = appBarLayout;
        appBarLayout.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        this.f26276J = (TextView) findViewById(p.f27365U0);
        this.f26278L = findViewById(p.f27386f);
        SmallTabBehavior smallTabBehavior = (SmallTabBehavior) ((CoordinatorLayout.e) this.f26290q.getLayoutParams()).f();
        this.f26277K = smallTabBehavior;
        if (smallTabBehavior != null) {
            smallTabBehavior.j(this);
        }
        this.f26272F = new b();
        Y1();
        try {
            this.f26273G = C0863y.a(getIntent(), "start_from_callLog", false);
        } catch (Exception e10) {
            Log.e("BlockedCallLogAndSmsListActivity", "Exception in getBooleanExtra: " + e10);
        }
        if (C0846g.c()) {
            Log.d("BlockedCallLogAndSmsListActivity", "mStartFromCallLog = " + this.f26273G);
        }
        h2(1, new String[]{getString(u.f27691t0), getString(u.f27701v0)});
        if (!this.f26273G && !F6.a.m(getIntent().getAction())) {
            this.f26292x = 1;
            this.f26280N = "message";
        } else {
            this.f26292x = 0;
            if (this.f26273G) {
                str = "dialer";
            } else {
                str = "notification";
            }
            this.f26280N = str;
        }
        L1(this.f26280N);
        COUIStatusBarResponseUtil cOUIStatusBarResponseUtil = new COUIStatusBarResponseUtil(this);
        this.f26274H = cOUIStatusBarResponseUtil;
        cOUIStatusBarResponseUtil.setStatusBarClickListener(this);
        if (l7.b.f34742j || l7.b.f34743k) {
            this.f26289p.setVisibility(8);
            n2(false);
            if (l7.b.f34743k) {
                this.f26291r.setCurrentItem(1);
            }
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (Z1()) {
            O1();
            return true;
        }
        getMenuInflater().inflate(s.f27473b, menu);
        this.f26288o.setPopupWindowOnDismissListener(new PopupWindow.OnDismissListener() { // from class: p6.e
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                BlockedCallLogAndSmsListActivity.this.e2();
            }
        });
        return true;
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C0846g.i("BlockedCallLogAndSmsListActivity", "onDestroy");
        L.i();
        Dialog dialog = this.f26279M;
        if (dialog != null) {
            dialog.dismiss();
            this.f26279M = null;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        r6.g gVar = this.f26293y;
        if (gVar != null) {
            gVar.Z1();
        }
        if (intent != null && this.f26291r != null) {
            String action = intent.getAction();
            int currentItem = this.f26291r.getCurrentItem();
            if (F6.a.m(action)) {
                if (currentItem != 0) {
                    this.f26291r.setCurrentItem(0, true);
                }
            } else if (F6.a.n(action) && currentItem != 1) {
                this.f26291r.setCurrentItem(1, true);
            }
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            this.f26281O = true;
            StatisticsUtils.d(getApplicationContext(), this.f26280N);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f26274H.onPause();
        T.c();
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if (Z1()) {
            return true;
        }
        MenuItem findItem = menu.findItem(p.f27377a0);
        menu.findItem(p.f27330D).setVisible(X1());
        if (this.f26292x == 0) {
            findItem.setVisible(false);
        } else {
            findItem.setVisible(X1());
            r rVar = this.f26294z;
            if (rVar != null) {
                findItem.setEnabled(rVar.c2());
            } else {
                findItem.setEnabled(false);
            }
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (!L.j(iArr)) {
            String[] f10 = L.f(this);
            this.f26275I = f10;
            if (f10 != null && f10.length > 0) {
                if (C0846g.c()) {
                    for (String str : this.f26275I) {
                        Log.i("BlockedCallLogAndSmsListActivity", "permission : " + str + " \nshouldShowRequestPermissionRationale : " + shouldShowRequestPermissionRationale(str));
                    }
                }
                L.q(this, this.f26275I, this.f26284R);
                return;
            }
            return;
        }
        C0861w.g(getApplicationContext()).k();
        r6.g gVar = this.f26293y;
        if (gVar != null) {
            gVar.o2();
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        L1("background");
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, com.oplus.blacklistapp.framework.baseui.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C0849j.f29160b = false;
        this.f26282P = System.currentTimeMillis();
        this.f26274H.onResume();
        G.f29042a.h();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, com.coui.appcompat.statusbar.COUIStatusBarResponseUtil.StatusBarClickListener
    public void onStatusBarClicked() {
        r rVar;
        COUIListView X12;
        int i10 = this.f26292x;
        if (i10 == 0) {
            r6.g gVar = this.f26293y;
            if (gVar != null) {
                X12 = gVar.O1();
            }
            X12 = null;
        } else {
            if (i10 == 1 && (rVar = this.f26294z) != null) {
                X12 = rVar.X1();
            }
            X12 = null;
        }
        if (X12 != null) {
            T.e(this, X12);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        String str;
        super.onStop();
        if (!this.f26281O && !C0849j.f29160b) {
            StatisticsUtils.d(getApplicationContext(), "background");
        }
        if (this.f26292x == 0) {
            str = "block_call";
        } else {
            str = "block_message";
        }
        J1(str, this.f26282P, System.currentTimeMillis());
    }

    /* loaded from: classes3.dex */
    public class e implements COUITabLayout.OnTabSelectedListener {
        public e() {
        }

        @Override // com.coui.appcompat.tablayout.COUITabLayout.OnTabSelectedListener
        public void onTabSelected(COUITab cOUITab) {
            BlockedCallLogAndSmsListActivity.this.T1(cOUITab.getPosition());
        }

        @Override // com.coui.appcompat.tablayout.COUITabLayout.OnTabSelectedListener
        public void onTabReselected(COUITab cOUITab) {
        }

        @Override // com.coui.appcompat.tablayout.COUITabLayout.OnTabSelectedListener
        public void onTabUnselected(COUITab cOUITab) {
        }
    }
}
