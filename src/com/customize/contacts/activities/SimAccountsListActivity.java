package com.customize.contacts.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.model.Account;
import com.customize.contacts.fragment.SimAccountFragment;
import com.customize.contacts.util.C0811w;
import com.oplus.dialer.R;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class SimAccountsListActivity extends BasicActivity {

    /* renamed from: o, reason: collision with root package name */
    public final String f20603o = "SimAccountsListActivity";

    /* renamed from: p, reason: collision with root package name */
    public ArrayList<Account> f20604p = null;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList<Integer> f20605q = null;

    /* renamed from: r, reason: collision with root package name */
    public final BroadcastReceiver f20606r = new a();

    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (H7.a.b()) {
                H7.b.b("SimAccountsListActivity", "action = " + action);
            }
            if ("android.intent.action.SIM_STATE_CHANGED".equals(action) || TextUtils.equals("local.intent.action.SUBINFO_STATE_CHANGE", action)) {
                com.customize.contacts.util.b0.H0();
                if (SimAccountsListActivity.this.r1() == 0 || TextUtils.equals("PLUGOUT", C7.e.l(intent, "simstate"))) {
                    SimAccountsListActivity.this.finish();
                }
            }
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean H0() {
        return true;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean Q0() {
        return false;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.sim_account_list_activity);
        SimAccountFragment simAccountFragment = (SimAccountFragment) getSupportFragmentManager().l0(R.id.sim_account_fragment);
        r1();
        simAccountFragment.f1(this.f20604p);
        simAccountFragment.g1(this.f20605q);
        simAccountFragment.h1();
        q1();
        IntentFilter intentFilter = new IntentFilter();
        C0811w.j(this, this.f20606r, intentFilter, "android.intent.action.SIM_STATE_CHANGED");
        intentFilter.addAction("local.intent.action.SUBINFO_STATE_CHANGE");
        registerReceiver(this.f20606r, intentFilter, R0.b.f3175i, null, 2);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        try {
            X.a.b(this).e(this.f20606r);
            unregisterReceiver(this.f20606r);
        } catch (Exception e10) {
            H7.b.b("SimAccountsListActivity", "unregister local receiver error" + e10);
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    public final void q1() {
        try {
            X.a b10 = X.a.b(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("local.intent.action.SUBINFO_STATE_CHANGE");
            b10.c(this.f20606r, intentFilter);
        } catch (Exception e10) {
            H7.b.b("SimAccountsListActivity", "regist local broadcast error" + e10);
        }
    }

    public final int r1() {
        this.f20604p = M3.c.m(getApplicationContext());
        if (this.f20605q == null) {
            this.f20605q = new ArrayList<>();
        }
        this.f20605q.clear();
        int size = this.f20604p.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f20605q.add(Integer.valueOf(com.customize.contacts.util.b0.K(getApplicationContext(), this.f20604p.get(i10).f16941a)));
        }
        return size;
    }
}
