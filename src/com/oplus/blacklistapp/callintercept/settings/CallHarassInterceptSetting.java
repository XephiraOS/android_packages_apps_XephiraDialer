package com.oplus.blacklistapp.callintercept.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SubscriptionInfo;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.B;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.android.incallui.OplusPhoneUtils;
import com.coui.appcompat.tablayout.COUIFragmentStatePagerAdapter;
import com.coui.appcompat.tablayout.COUITabLayout;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.oplus.utils.C0844e;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0861w;
import com.oplus.utils.C0863y;
import com.oplus.utils.L;
import com.oplus.utils.StatisticsUtils;
import com.oplus.widget.BlacklistViewPager;
import java.util.HashMap;
import java.util.List;
import v6.C1628b;
import v6.C1632f;
import v6.C1633g;

/* loaded from: classes3.dex */
public class CallHarassInterceptSetting extends HotPlugActivity {

    /* renamed from: f, reason: collision with root package name */
    public List<SubscriptionInfo> f26783f;

    /* renamed from: h, reason: collision with root package name */
    public ActionBar f26785h;

    /* renamed from: i, reason: collision with root package name */
    public COUIToolbar f26786i;

    /* renamed from: j, reason: collision with root package name */
    public COUITabLayout f26787j;

    /* renamed from: k, reason: collision with root package name */
    public BlacklistViewPager f26788k;

    /* renamed from: l, reason: collision with root package name */
    public String[] f26789l;

    /* renamed from: e, reason: collision with root package name */
    public String f26782e = null;

    /* renamed from: g, reason: collision with root package name */
    public int f26784g = 0;

    /* renamed from: m, reason: collision with root package name */
    public boolean f26790m = false;

    /* renamed from: n, reason: collision with root package name */
    public BroadcastReceiver f26791n = null;

    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        public boolean f26792a = true;

        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (this.f26792a) {
                CallHarassInterceptSetting.log("mSimReceiver is first call");
                this.f26792a = false;
            } else {
                CallHarassInterceptSetting.this.T0(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends COUIFragmentStatePagerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f26794a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FragmentManager fragmentManager, String[] strArr) {
            super(fragmentManager);
            this.f26794a = strArr;
        }

        @Override // androidx.viewpager.widget.a
        public int getCount() {
            return this.f26794a.length;
        }

        @Override // androidx.fragment.app.z
        public Fragment getItem(int i10) {
            boolean z10 = true;
            if (this.f26794a.length != 1) {
                z10 = false;
            }
            return e.z1(z10, i10);
        }

        @Override // androidx.viewpager.widget.a
        public CharSequence getPageTitle(int i10) {
            return this.f26794a[i10];
        }
    }

    private void O0(String[] strArr) {
        this.f26788k.setAdapter(new b(getSupportFragmentManager(), strArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void log(String str) {
        C0846g.i("CallHarassInterceptSetting", str);
    }

    public void M0() {
        if (getApplicationContext() == null) {
            return;
        }
        for (int i10 = 0; i10 <= 1; i10++) {
            C1628b.b(this, "2011101", "time_area_blocked_all_incoming", com.oplus.blacklistapp.callintercept.a.f(getApplicationContext(), true, i10));
        }
        for (int i11 = 0; i11 <= 1; i11++) {
            C1628b.b(this, "2011101", "time_area_blocked_all_stranger", com.oplus.blacklistapp.callintercept.a.f(getApplicationContext(), false, i11));
        }
    }

    public void N0(int i10, String str, String str2) {
        log("addUserAction type = " + i10 + " tag = " + str + "value = " + str2);
        C1628b.a(this, "2011101", i10, Q0(str, str2));
    }

    public final HashMap<String, String> Q0(String str, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(str, str2);
        return hashMap;
    }

    public void R0(boolean z10, int i10, String[] strArr) {
        this.f26787j.setTabMode(i10);
        this.f26787j.requestLayout();
        this.f26787j.invalidate();
        O0(strArr);
    }

    public final void T0(boolean z10) {
        String string;
        String string2;
        String string3;
        Intent intent = getIntent();
        boolean z11 = false;
        if (intent != null && intent.hasExtra("slotId")) {
            try {
                this.f26784g = C0863y.b(intent, "slotId", 0);
            } catch (Exception e10) {
                Log.e("CallHarassInterceptSetting", "Exception in getIntExtra: " + e10);
            }
            log("onCreate, mInitialSlotId = " + this.f26784g);
        }
        List<SubscriptionInfo> i10 = C1632f.i(getApplicationContext());
        this.f26783f = i10;
        if (i10 == null) {
            log("active sim list is null, return");
            finish();
            return;
        }
        int size = i10.size();
        log("simSize = " + size);
        if (size != 0 && size <= 2) {
            this.f26782e = C1633g.b(this, intent);
            this.f26790m = true;
            if (size == 1) {
                setContentView(com.oplus.blacklistapp.r.f27469x);
                COUIToolbar cOUIToolbar = (COUIToolbar) findViewById(com.oplus.blacklistapp.p.f27363T0);
                this.f26786i = cOUIToolbar;
                cOUIToolbar.setTitle(com.oplus.blacklistapp.u.f27660n);
                setSupportActionBar(this.f26786i);
                ActionBar supportActionBar = getSupportActionBar();
                this.f26785h = supportActionBar;
                if (supportActionBar != null) {
                    supportActionBar.x(true);
                    this.f26785h.v(4, 4);
                    this.f26785h.t(true);
                }
                SubscriptionInfo subscriptionInfo = this.f26783f.get(0);
                if (subscriptionInfo == null) {
                    finish();
                    return;
                }
                this.f26784g = subscriptionInfo.getSimSlotIndex();
                Bundle bundle = new Bundle();
                bundle.putBoolean("isSingleSim", true);
                bundle.putInt("position", this.f26784g);
                Fragment instantiate = Fragment.instantiate(this, e.class.getName(), bundle);
                B p10 = getSupportFragmentManager().p();
                p10.s(com.oplus.blacklistapp.p.f27374Z, instantiate);
                p10.j();
                getFragmentManager().executePendingTransactions();
            } else {
                setContentView(com.oplus.blacklistapp.r.f27468w);
                COUIToolbar cOUIToolbar2 = (COUIToolbar) findViewById(com.oplus.blacklistapp.p.f27363T0);
                this.f26786i = cOUIToolbar2;
                cOUIToolbar2.setTitle(com.oplus.blacklistapp.u.f27660n);
                setSupportActionBar(this.f26786i);
                ActionBar supportActionBar2 = getSupportActionBar();
                this.f26785h = supportActionBar2;
                supportActionBar2.x(true);
                this.f26785h.v(4, 4);
                this.f26785h.t(true);
                this.f26787j = (COUITabLayout) findViewById(com.oplus.blacklistapp.p.f27353O0);
                BlacklistViewPager blacklistViewPager = (BlacklistViewPager) findViewById(com.oplus.blacklistapp.p.f27369W0);
                this.f26788k = blacklistViewPager;
                blacklistViewPager.setClipToPadding(false);
                String[] strArr = new String[2];
                SubscriptionInfo subscriptionInfo2 = this.f26783f.get(0);
                SubscriptionInfo subscriptionInfo3 = this.f26783f.get(1);
                if (subscriptionInfo2 != null && subscriptionInfo2.getSimSlotIndex() == 0) {
                    strArr[0] = subscriptionInfo2.getDisplayName().toString();
                    if (subscriptionInfo3 != null) {
                        string3 = subscriptionInfo3.getDisplayName().toString();
                    } else {
                        string3 = getString(com.oplus.blacklistapp.u.f27604b3);
                    }
                    strArr[1] = string3;
                } else {
                    if (subscriptionInfo3 != null) {
                        string = subscriptionInfo3.getDisplayName().toString();
                    } else {
                        string = getString(com.oplus.blacklistapp.u.f27599a3);
                    }
                    strArr[0] = string;
                    if (subscriptionInfo2 != null) {
                        string2 = subscriptionInfo2.getDisplayName().toString();
                    } else {
                        string2 = getString(com.oplus.blacklistapp.u.f27604b3);
                    }
                    strArr[1] = string2;
                }
                R0(false, 1, strArr);
                if (z10) {
                    this.f26788k.setCurrentItem(this.f26784g);
                }
                this.f26787j.setupWithViewPager(this.f26788k);
            }
            if (intent != null) {
                String d10 = C0863y.d(intent, "package");
                log("updateUI end fromPackage = " + d10);
                N0(201110018, "start_harass_type", d10);
            }
            if (size == 1) {
                z11 = true;
            }
            StatisticsUtils.c(this, "setting_entry", z11, this.f26784g);
            return;
        }
        finish();
    }

    @Override // android.app.Activity
    public void finish() {
        log("finish activity");
        super.finish();
        if (TextUtils.isEmpty(this.f26782e)) {
            C1632f.U(this);
        }
        M0();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 10 && !isFinishing()) {
            String[] f10 = L.f(this);
            this.f26789l = f10;
            if (f10 != null && f10.length > 0) {
                for (String str : f10) {
                    if (shouldShowRequestPermissionRationale(str)) {
                        requestPermissions(this.f26789l, 1);
                        return;
                    }
                }
                L.p(this, this.f26789l);
                return;
            }
            if (!this.f26790m) {
                T0(true);
            }
            C0861w.g(getApplicationContext()).k();
        }
    }

    @Override // com.oplus.blacklistapp.callintercept.settings.HotPlugActivity, com.oplus.blacklistapp.activities.BaseActivity, com.oplus.blacklistapp.framework.baseui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String[] f10 = L.f(this);
        this.f26789l = f10;
        boolean z10 = true;
        if (f10 != null) {
            requestPermissions(f10, 1);
            return;
        }
        androidx.appcompat.app.b bVar = L.f29055a;
        if (bVar != null && bVar.isShowing()) {
            L.f29055a.dismiss();
            L.f29055a = null;
        }
        if (this.f26789l == null) {
            C0861w.g(getApplicationContext()).k();
        }
        this.f26791n = new a();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SIM_STATE_CHANGED");
        if (C0844e.j()) {
            try {
                registerReceiver(this.f26791n, intentFilter, 2);
            } catch (Exception e10) {
                Log.e("CallHarassInterceptSetting", "e =" + e10);
            }
        } else {
            registerReceiver(this.f26791n, intentFilter, OplusPhoneUtils.PERMISSION_OPLUS_COMPONENT_SAFE, null, 2);
        }
        if (bundle != null) {
            z10 = false;
        }
        T0(z10);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        log("onCreateOptionsMenu");
        if (TextUtils.isEmpty(this.f26782e)) {
            getMenuInflater().inflate(com.oplus.blacklistapp.s.f27477f, menu);
            return true;
        }
        return true;
    }

    @Override // com.oplus.blacklistapp.callintercept.settings.HotPlugActivity, com.oplus.blacklistapp.activities.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        log("onDestroy");
        try {
            unregisterReceiver(this.f26791n);
            this.f26791n = null;
        } catch (Exception e10) {
            Log.e("CallHarassInterceptSetting", "unRegisterSimReceiver error: " + e10);
        }
        super.onDestroy();
        L.i();
        StatisticsUtils.e(this, "setting_back");
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != 16908332 && itemId != com.oplus.blacklistapp.p.f27379b0) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (!L.j(iArr)) {
            String[] f10 = L.f(this);
            this.f26789l = f10;
            if (f10 != null && f10.length > 0) {
                L.p(this, f10);
                return;
            }
            return;
        }
        C0861w.g(getApplicationContext()).k();
        log("onRequestPermissionsResult: updateUI");
        T0(true);
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, com.oplus.blacklistapp.framework.baseui.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        log("onResume");
        super.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        log("onStart");
    }
}
