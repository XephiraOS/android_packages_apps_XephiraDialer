package com.oplus.blacklistapp.activities;

import C6.f;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.w;
import androidx.viewpager.widget.ViewPager;
import com.coui.appcompat.statusbar.COUIStatusBarResponseUtil;
import com.coui.appcompat.tablayout.COUITab;
import com.coui.appcompat.tablayout.COUITabLayout;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.blacklistapp.BlackListAppUtil;
import com.oplus.blacklistapp.fragment.q;
import com.oplus.blacklistapp.fragment.r;
import com.oplus.blacklistapp.p;
import com.oplus.blacklistapp.u;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0849j;
import com.oplus.utils.C0853n;
import com.oplus.utils.C0861w;
import com.oplus.utils.L;
import com.oplus.utils.StatisticsUtils;
import com.oplus.utils.T;
import com.oplus.widget.BlacklistViewPager;
import com.oplus.widget.SmallTabBehavior;
import h9.C1087a;
import y6.C1707a;

/* loaded from: classes3.dex */
public class CustomBlackListActivity extends BaseActivity {

    /* renamed from: B, reason: collision with root package name */
    public String[] f26304B;

    /* renamed from: e, reason: collision with root package name */
    public COUITabLayout f26306e;

    /* renamed from: f, reason: collision with root package name */
    public C1087a f26307f;

    /* renamed from: g, reason: collision with root package name */
    public int f26308g;

    /* renamed from: h, reason: collision with root package name */
    public COUIToolbar f26309h;

    /* renamed from: i, reason: collision with root package name */
    public AppBarLayout f26310i;

    /* renamed from: j, reason: collision with root package name */
    public COUIStatusBarResponseUtil f26311j;

    /* renamed from: k, reason: collision with root package name */
    public BlacklistViewPager f26312k;

    /* renamed from: m, reason: collision with root package name */
    public q f26314m;

    /* renamed from: n, reason: collision with root package name */
    public r f26315n;

    /* renamed from: o, reason: collision with root package name */
    public TextView f26316o;

    /* renamed from: p, reason: collision with root package name */
    public View f26317p;

    /* renamed from: q, reason: collision with root package name */
    public String[] f26318q;

    /* renamed from: r, reason: collision with root package name */
    public CoordinatorLayout.e f26319r;

    /* renamed from: x, reason: collision with root package name */
    public SmallTabBehavior f26320x;

    /* renamed from: l, reason: collision with root package name */
    public int f26313l = 0;

    /* renamed from: y, reason: collision with root package name */
    public String f26321y = "";

    /* renamed from: z, reason: collision with root package name */
    public String f26322z = "";

    /* renamed from: A, reason: collision with root package name */
    public int f26303A = 0;

    /* renamed from: C, reason: collision with root package name */
    public COUITabLayout.OnTabSelectedListener f26305C = new c();

    /* loaded from: classes3.dex */
    public class a implements Toolbar.g {
        public a() {
        }

        @Override // androidx.appcompat.widget.Toolbar.g
        public boolean onMenuItemClick(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == p.f27330D) {
                if (BlackListAppUtil.c().a()) {
                    Log.i("CustomBlackListActivity", "Invalid click return --------------");
                    return false;
                }
                CustomBlackListActivity.this.j1();
                return true;
            }
            if (itemId == p.f27400m) {
                CustomBlackListActivity.this.r1(false);
                CustomBlackListActivity.this.e1();
                return true;
            }
            if (itemId == p.f27380c) {
                C0846g.i("CustomBlackListActivity", "onNavigationItemSelected: add_list");
                StatisticsUtils.a(CustomBlackListActivity.this, 2010802, 201080003, null, false);
                CustomBlackListActivity customBlackListActivity = CustomBlackListActivity.this;
                customBlackListActivity.u1(customBlackListActivity);
                return true;
            }
            if (itemId == p.f27327B0) {
                CustomBlackListActivity.this.f26314m.r2();
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CustomBlackListActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public class d extends w {

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String[] f26326f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ FragmentManager f26327g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(FragmentManager fragmentManager, String[] strArr, FragmentManager fragmentManager2) {
            super(fragmentManager);
            this.f26326f = strArr;
            this.f26327g = fragmentManager2;
        }

        @Override // androidx.viewpager.widget.a
        public int getCount() {
            if (!l7.b.k() || CustomBlackListActivity.this.f26308g != 1) {
                return 1;
            }
            String[] strArr = this.f26326f;
            if (strArr != null) {
                return strArr.length;
            }
            return 0;
        }

        @Override // androidx.fragment.app.w
        public Fragment getItem(int i10) {
            if (i10 == 0) {
                CustomBlackListActivity.this.f26314m = new q();
                CustomBlackListActivity.this.f26314m.u2(CustomBlackListActivity.this.f26309h);
                return CustomBlackListActivity.this.f26314m;
            }
            if (i10 == 1) {
                CustomBlackListActivity.this.f26315n = new r();
                CustomBlackListActivity.this.f26315n.u2(CustomBlackListActivity.this.f26309h);
                return CustomBlackListActivity.this.f26315n;
            }
            return new C1707a();
        }

        @Override // androidx.viewpager.widget.a
        public CharSequence getPageTitle(int i10) {
            String[] strArr = this.f26326f;
            if (strArr != null && strArr.length > i10) {
                return strArr[i10];
            }
            return "";
        }

        @Override // androidx.fragment.app.w, androidx.viewpager.widget.a
        public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
            C0846g.i("CustomBlackListActivity", "restoreState");
            if (parcelable != null) {
                Bundle bundle = (Bundle) parcelable;
                CustomBlackListActivity.this.f26321y = bundle.getString("normal_tab");
                CustomBlackListActivity.this.f26322z = bundle.getString("service_tab");
                if (CustomBlackListActivity.this.f26314m == null) {
                    CustomBlackListActivity customBlackListActivity = CustomBlackListActivity.this;
                    customBlackListActivity.f26314m = (q) this.f26327g.m0(customBlackListActivity.f26321y);
                    if (CustomBlackListActivity.this.f26314m != null) {
                        CustomBlackListActivity.this.f26314m.u2(CustomBlackListActivity.this.f26309h);
                    }
                }
                if (CustomBlackListActivity.this.f26315n == null) {
                    CustomBlackListActivity customBlackListActivity2 = CustomBlackListActivity.this;
                    customBlackListActivity2.f26315n = (r) this.f26327g.m0(customBlackListActivity2.f26322z);
                    if (CustomBlackListActivity.this.f26315n != null) {
                        CustomBlackListActivity.this.f26315n.u2(CustomBlackListActivity.this.f26309h);
                    }
                }
            }
        }

        @Override // androidx.fragment.app.w, androidx.viewpager.widget.a
        public Parcelable saveState() {
            C0846g.i("CustomBlackListActivity", "saveState");
            Bundle bundle = new Bundle();
            if (CustomBlackListActivity.this.f26314m != null) {
                CustomBlackListActivity customBlackListActivity = CustomBlackListActivity.this;
                customBlackListActivity.f26321y = customBlackListActivity.f26314m.getTag();
            }
            if (CustomBlackListActivity.this.f26315n != null) {
                CustomBlackListActivity customBlackListActivity2 = CustomBlackListActivity.this;
                customBlackListActivity2.f26322z = customBlackListActivity2.f26315n.getTag();
            }
            bundle.putString("normal_tab", CustomBlackListActivity.this.f26321y);
            bundle.putString("service_tab", CustomBlackListActivity.this.f26322z);
            return bundle;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements ViewPager.i {
        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageSelected(int i10) {
            CustomBlackListActivity.this.f26313l = i10;
        }

        public e() {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageScrollStateChanged(int i10) {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageScrolled(int i10, float f10, int i11) {
        }
    }

    private void f1(String[] strArr) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.f26312k.setAdapter(new d(supportFragmentManager, strArr, supportFragmentManager));
    }

    private void h1() {
        r rVar;
        int i10 = this.f26313l;
        if (i10 == 0) {
            q qVar = this.f26314m;
            if (qVar != null) {
                qVar.U1();
                return;
            }
            return;
        }
        if (i10 == 1 && (rVar = this.f26315n) != null) {
            rVar.U1();
        }
    }

    private int l1() {
        if (F6.a.r(getIntent().getAction())) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1(int i10) {
        this.f26313l = i10;
        h1();
    }

    private void p1() {
        this.f26309h.setOnMenuItemClickListener(new a());
        this.f26309h.setNavigationOnClickListener(new b());
    }

    private void s1() {
        this.f26316o.setVisibility(8);
        this.f26316o.setAlpha(1.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f26316o.getLayoutParams();
        layoutParams.topMargin = 0;
        this.f26316o.setLayoutParams(layoutParams);
        this.f26317p.setVisibility(8);
        this.f26317p.setAlpha(0.0f);
    }

    public final void d1() {
        C1087a e10 = C1087a.e(this);
        this.f26307f = e10;
        e10.b();
    }

    public void e1() {
        r rVar;
        int i10 = this.f26313l;
        if (i10 == 0) {
            q qVar = this.f26314m;
            if (qVar != null) {
                qVar.S1();
                return;
            }
            return;
        }
        if (i10 == 1 && (rVar = this.f26315n) != null) {
            rVar.S1();
        }
    }

    public final void g1() {
        String[] f10 = L.f(this);
        this.f26304B = f10;
        if (f10 != null) {
            requestPermissions(f10, 1);
        } else {
            androidx.appcompat.app.b bVar = L.f29055a;
            if (bVar != null && bVar.isShowing()) {
                try {
                    try {
                        L.f29055a.dismiss();
                    } catch (IllegalArgumentException e10) {
                        Log.e("CustomBlackListActivity", "dismiss permission Exception: " + e10);
                    }
                } finally {
                    L.f29055a = null;
                }
            }
        }
        if (this.f26304B == null) {
            C0861w.g(getApplicationContext()).k();
        }
    }

    public COUIToolbar getToolbar() {
        return this.f26309h;
    }

    public void i1(boolean z10) {
        if (l7.b.k() && this.f26308g != 2) {
            C0846g.i("CustomBlackListActivity", "enableAllTab enable:" + z10);
            COUITabLayout cOUITabLayout = this.f26306e;
            if (cOUITabLayout != null) {
                int tabCount = cOUITabLayout.getTabCount();
                for (int i10 = 0; i10 < tabCount; i10++) {
                    this.f26306e.enableTab(i10, z10);
                }
                if (z10) {
                    if (this.f26308g == 1) {
                        this.f26306e.setVisibility(0);
                    }
                    s1();
                } else {
                    this.f26306e.setVisibility(8);
                    this.f26316o.setVisibility(0);
                    COUIToolbar cOUIToolbar = this.f26309h;
                    if (cOUIToolbar != null) {
                        cOUIToolbar.setTitle("");
                    }
                }
            }
        }
    }

    public void j1() {
        r rVar;
        t1(false);
        i1(false);
        if (l7.b.k() && this.f26308g == 1) {
            SmallTabBehavior smallTabBehavior = this.f26320x;
            if (smallTabBehavior != null) {
                smallTabBehavior.m(false);
                this.f26320x.l(true);
            }
            if (this.f26309h != null) {
                int a10 = C0853n.a(this);
                this.f26309h.setTitleTextColor(Color.argb(0, Color.red(a10), Color.green(a10), Color.blue(a10)));
            }
        }
        int i10 = this.f26313l;
        if (i10 == 0) {
            q qVar = this.f26314m;
            if (qVar != null) {
                qVar.Y1();
            }
        } else if (i10 == 1 && (rVar = this.f26315n) != null) {
            rVar.Y1();
        }
        s0(n0());
    }

    public int k1() {
        return this.f26313l;
    }

    public TextView m1() {
        return this.f26316o;
    }

    @Override // com.oplus.blacklistapp.framework.baseui.BasicActivity
    public boolean n0() {
        r rVar;
        int i10 = this.f26313l;
        if (i10 == 0) {
            q qVar = this.f26314m;
            if (qVar != null) {
                return qVar.f2();
            }
            return false;
        }
        if (i10 == 1 && (rVar = this.f26315n) != null) {
            return rVar.f2();
        }
        return false;
    }

    public int n1() {
        return this.f26303A;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        Log.d("CustomBlackListActivity", "requestCode==" + i10 + " resultCode==" + i11 + " data==" + intent);
        if (i10 == 10 && !isFinishing()) {
            String[] f10 = L.f(this);
            this.f26304B = f10;
            if (f10 != null && f10.length > 0) {
                for (String str : f10) {
                    if (shouldShowRequestPermissionRationale(str)) {
                        requestPermissions(this.f26304B, 1);
                        return;
                    }
                }
                L.p(this, this.f26304B);
                return;
            }
            C0861w.g(getApplicationContext()).k();
            return;
        }
        Log.e("CustomBlackListActivity", "acitivity may be finished");
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (n0()) {
            r1(true);
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        SmallTabBehavior smallTabBehavior = this.f26320x;
        if (smallTabBehavior != null) {
            smallTabBehavior.i();
        }
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, com.oplus.blacklistapp.framework.baseui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g1();
        this.f26308g = l1();
        Log.i("CustomBlackListActivity", "onCreate ListMode = " + this.f26308g);
        this.f26318q = new String[]{getString(u.f27555Q), getString(u.f27559R)};
        this.f26313l = 0;
        C0849j.w(this);
        setContentView(com.oplus.blacklistapp.r.f27449d);
        d1();
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(null);
        }
        this.f26309h = (COUIToolbar) findViewById(p.f27363T0);
        this.f26316o = (TextView) findViewById(p.f27365U0);
        this.f26317p = findViewById(p.f27386f);
        BlacklistViewPager blacklistViewPager = (BlacklistViewPager) findViewById(p.f27369W0);
        this.f26312k = blacklistViewPager;
        blacklistViewPager.setVisibility(0);
        this.f26312k.setClipToPadding(false);
        this.f26312k.addOnPageChangeListener(new e());
        this.f26306e = (COUITabLayout) findViewById(p.f27412s);
        p1();
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(p.f27376a);
        this.f26310i = appBarLayout;
        CoordinatorLayout.e eVar = (CoordinatorLayout.e) appBarLayout.getLayoutParams();
        this.f26319r = eVar;
        this.f26320x = (SmallTabBehavior) eVar.f();
        this.f26303A = getResources().getDimensionPixelSize(f.f393g) + getResources().getDimensionPixelSize(X8.f.f4621W5);
        if (l7.b.k() && this.f26308g == 1) {
            this.f26306e.addOnTabSelectedListener(this.f26305C);
            this.f26306e.setVisibility(0);
            this.f26303A += getResources().getDimensionPixelSize(Y8.d.f5654j0);
        }
        C0846g.i("CustomBlackListActivity", "mBehavior height:" + this.f26303A);
        SmallTabBehavior smallTabBehavior = this.f26320x;
        if (smallTabBehavior != null) {
            smallTabBehavior.k(this.f26303A + C0849j.l(this));
        }
        this.f26312k.setCurrentItem(this.f26313l);
        this.f26306e.setupWithViewPager(this.f26312k);
        q1(1, this.f26318q);
        COUIStatusBarResponseUtil cOUIStatusBarResponseUtil = new COUIStatusBarResponseUtil(this);
        this.f26311j = cOUIStatusBarResponseUtil;
        cOUIStatusBarResponseUtil.setStatusBarClickListener(this);
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        L.i();
        C1087a c1087a = this.f26307f;
        if (c1087a != null) {
            try {
                c1087a.v();
            } catch (Exception e10) {
                Log.e("CustomBlackListActivity", "Exception:" + e10);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f26311j.onPause();
        T.c();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (!L.j(iArr)) {
            String[] f10 = L.f(this);
            this.f26304B = f10;
            if (f10 != null && f10.length > 0) {
                L.p(this, f10);
                return;
            }
            return;
        }
        C0861w.g(getApplicationContext()).k();
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, com.oplus.blacklistapp.framework.baseui.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f26311j.onResume();
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, com.coui.appcompat.statusbar.COUIStatusBarResponseUtil.StatusBarClickListener
    public void onStatusBarClicked() {
        r rVar;
        ListView b22;
        int i10 = this.f26313l;
        if (i10 == 0) {
            q qVar = this.f26314m;
            if (qVar != null) {
                b22 = qVar.b2();
            }
            b22 = null;
        } else {
            if (i10 == 1 && (rVar = this.f26315n) != null) {
                b22 = rVar.b2();
            }
            b22 = null;
        }
        T.e(this, b22);
    }

    public void q1(int i10, String[] strArr) {
        this.f26306e.setTabMode(i10);
        this.f26306e.requestLayout();
        this.f26306e.invalidate();
        f1(strArr);
    }

    public void r1(boolean z10) {
        r rVar;
        t1(true);
        i1(true);
        if (l7.b.k() && this.f26308g == 1) {
            SmallTabBehavior smallTabBehavior = this.f26320x;
            if (smallTabBehavior != null) {
                smallTabBehavior.m(true);
                this.f26320x.l(false);
            }
            if (this.f26309h != null) {
                int a10 = C0853n.a(this);
                this.f26309h.setTitleTextColor(Color.argb(255, Color.red(a10), Color.green(a10), Color.blue(a10)));
            }
        }
        if (z10) {
            q qVar = this.f26314m;
            if (qVar != null) {
                qVar.p2();
            }
            r rVar2 = this.f26315n;
            if (rVar2 != null) {
                rVar2.p2();
            }
        } else {
            int i10 = this.f26313l;
            if (i10 == 0) {
                q qVar2 = this.f26314m;
                if (qVar2 != null) {
                    qVar2.p2();
                }
            } else if (i10 == 1 && (rVar = this.f26315n) != null) {
                rVar.p2();
            }
        }
        s0(n0());
    }

    public void t1(boolean z10) {
        BlacklistViewPager blacklistViewPager = this.f26312k;
        if (blacklistViewPager != null) {
            blacklistViewPager.setCanScrolling(z10);
        }
    }

    public void u1(Context context) {
        r rVar;
        int i10 = this.f26313l;
        if (i10 == 0) {
            q qVar = this.f26314m;
            if (qVar != null) {
                qVar.y2(context);
                return;
            }
            return;
        }
        if (i10 == 1 && (rVar = this.f26315n) != null) {
            rVar.y2(context);
        }
    }

    public void v1() {
        r rVar;
        int i10 = this.f26313l;
        if (i10 == 0) {
            q qVar = this.f26314m;
            if (qVar != null) {
                qVar.A2();
                return;
            }
            return;
        }
        if (i10 == 1 && (rVar = this.f26315n) != null) {
            rVar.A2();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements COUITabLayout.OnTabSelectedListener {
        public c() {
        }

        @Override // com.coui.appcompat.tablayout.COUITabLayout.OnTabSelectedListener
        public void onTabSelected(COUITab cOUITab) {
            int position = cOUITab.getPosition();
            CustomBlackListActivity.this.r1(false);
            CustomBlackListActivity.this.e1();
            CustomBlackListActivity.this.o1(position);
            CustomBlackListActivity.this.t1(true);
        }

        @Override // com.coui.appcompat.tablayout.COUITabLayout.OnTabSelectedListener
        public void onTabReselected(COUITab cOUITab) {
        }

        @Override // com.coui.appcompat.tablayout.COUITabLayout.OnTabSelectedListener
        public void onTabUnselected(COUITab cOUITab) {
        }
    }
}
