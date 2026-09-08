package com.customize.contacts.activities;

import R0.d;
import a4.C0421a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.incallui.OplusNumberMarkUtils;
import com.android.incallui.OplusPhoneCapabilities;
import com.coui.appcompat.imageview.COUIRoundImageView;
import com.coui.appcompat.statusbar.COUIStatusBarResponseUtil;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.util.C0797h;
import com.customize.contacts.util.C0802m;
import com.customize.contacts.util.C0811w;
import com.oplus.dialer.R;
import r0.C1498a;

/* loaded from: classes3.dex */
public class ServiceNumberActivity extends BasicActivity implements COUIStatusBarResponseUtil.StatusBarClickListener {

    /* renamed from: E, reason: collision with root package name */
    public static final String[] f20582E = {BreenoCallContract.BaseColumns._ID, "name", "number", "emails", "additionalNumber"};

    /* renamed from: o, reason: collision with root package name */
    public ActionBar f20587o;

    /* renamed from: p, reason: collision with root package name */
    public COUIStatusBarResponseUtil f20588p;

    /* renamed from: y, reason: collision with root package name */
    public d f20592y;

    /* renamed from: z, reason: collision with root package name */
    public ListView f20593z;

    /* renamed from: q, reason: collision with root package name */
    public Object f20589q = new Object();

    /* renamed from: r, reason: collision with root package name */
    public boolean f20590r = false;

    /* renamed from: x, reason: collision with root package name */
    public androidx.appcompat.app.b f20591x = null;

    /* renamed from: A, reason: collision with root package name */
    public String f20583A = null;

    /* renamed from: B, reason: collision with root package name */
    public int f20584B = -1;

    /* renamed from: C, reason: collision with root package name */
    public TextView f20585C = null;

    /* renamed from: D, reason: collision with root package name */
    public BroadcastReceiver f20586D = new b();

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            Cursor cursor = (Cursor) ServiceNumberActivity.this.f20592y.getItem(i10);
            if (cursor == null) {
                return;
            }
            Intent intent = new Intent(C0421a.f6395a, Uri.fromParts("tel", cursor.getString(cursor.getColumnIndex("number")), null));
            intent.setFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
            intent.putExtra("dialer_from", "detail");
            C0802m.a(ServiceNumberActivity.this, intent);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.SIM_STATE_CHANGED".equals(action)) {
                String l10 = C7.e.l(intent, "ss");
                String l11 = C7.e.l(intent, "reason");
                if (H7.a.b()) {
                    H7.b.b("ServiceNumberActivity", "the simStatus is " + l10 + ", the state is " + l11);
                }
                if ("PLUGOUT".equals(l11)) {
                    ServiceNumberActivity.this.finish();
                }
            }
            if (C1498a.f36264w.equals(action)) {
                String l12 = C7.e.l(intent, "simstate");
                if (H7.a.b()) {
                    H7.b.b("ServiceNumberActivity", "here the state is " + l12);
                }
                if ("PLUGOUT".equals(l12)) {
                    ServiceNumberActivity.this.finish();
                }
            }
            if ("local.intent.action.SUBINFO_STATE_CHANGE".equals(action)) {
                String l13 = C7.e.l(intent, "simstate");
                if (H7.a.b()) {
                    H7.b.b("ServiceNumberActivity", "here the state is " + l13);
                }
                if ("PLUGOUT".equals(l13)) {
                    ServiceNumberActivity.this.finish();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends AsyncTask<Void, Void, Cursor> {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f20596a;

        public c(Uri uri) {
            this.f20596a = uri;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Cursor doInBackground(Void... voidArr) {
            try {
                try {
                    if (H7.a.b()) {
                        H7.b.b("ServiceNumberActivity", "doInBackground start -----------");
                    }
                    Cursor query = ServiceNumberActivity.this.getContentResolver().query(this.f20596a, ServiceNumberActivity.f20582E, null, null, null);
                    ServiceNumberActivity.this.f20590r = true;
                    synchronized (ServiceNumberActivity.this.f20589q) {
                        ServiceNumberActivity.this.f20589q.notifyAll();
                    }
                    return query;
                } catch (Exception e10) {
                    H7.b.c("ServiceNumberActivity", "Exception e: " + e10);
                    H7.b.b("ServiceNumberActivity", "query exception");
                    ServiceNumberActivity.this.f20590r = true;
                    synchronized (ServiceNumberActivity.this.f20589q) {
                        ServiceNumberActivity.this.f20589q.notifyAll();
                        return null;
                    }
                }
            } catch (Throwable th) {
                ServiceNumberActivity.this.f20590r = true;
                synchronized (ServiceNumberActivity.this.f20589q) {
                    ServiceNumberActivity.this.f20589q.notifyAll();
                    throw th;
                }
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Cursor cursor) {
            if (H7.a.b()) {
                H7.b.b("ServiceNumberActivity", "onPostExecute()");
            }
            if (!ServiceNumberActivity.this.isFinishing()) {
                ServiceNumberActivity.this.v1();
                if (cursor == null) {
                    ServiceNumberActivity.this.finish();
                    return;
                }
                if (cursor.getCount() == 0) {
                    ServiceNumberActivity.this.f20585C.setVisibility(0);
                    ServiceNumberActivity.this.f20592y.changeCursor(cursor);
                    ServiceNumberActivity.this.f20592y.notifyDataSetChanged();
                } else {
                    ServiceNumberActivity.this.f20585C.setVisibility(8);
                    ServiceNumberActivity.this.f20592y.changeCursor(cursor);
                    ServiceNumberActivity.this.f20592y.notifyDataSetChanged();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CursorAdapter {

        /* loaded from: classes3.dex */
        public class a {

            /* renamed from: a, reason: collision with root package name */
            public COUIRoundImageView f20599a;

            /* renamed from: b, reason: collision with root package name */
            public TextView f20600b;

            /* renamed from: c, reason: collision with root package name */
            public TextView f20601c;

            public a() {
            }
        }

        public d(Context context, Cursor cursor, boolean z10) {
            super(context, cursor, z10);
        }

        @Override // android.widget.CursorAdapter
        public void bindView(View view, Context context, Cursor cursor) {
            a aVar = (a) view.getTag();
            String string = cursor.getString(cursor.getColumnIndex("name"));
            String string2 = cursor.getString(cursor.getColumnIndex("number"));
            aVar.f20600b.setText(string);
            aVar.f20601c.setText(string2);
            aVar.f20599a.setImageResource(R.drawable.pb_ic_default_photo);
            if (com.customize.contacts.util.U.d()) {
                aVar.f20599a.setVisibility(0);
            } else {
                aVar.f20599a.setVisibility(8);
            }
        }

        @Override // android.widget.CursorAdapter
        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
            a aVar = new a();
            View inflate = LayoutInflater.from(context).inflate(R.layout.service_numer_listitem, (ViewGroup) null);
            aVar.f20599a = (COUIRoundImageView) inflate.findViewById(R.id.photo);
            aVar.f20600b = (TextView) inflate.findViewById(R.id.name);
            aVar.f20601c = (TextView) inflate.findViewById(R.id.number);
            inflate.setTag(aVar);
            return inflate;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1() {
        androidx.appcompat.app.b bVar = this.f20591x;
        if (bVar != null && bVar.isShowing()) {
            this.f20591x.dismiss();
        }
        this.f20591x = null;
    }

    public void A1(int i10) {
        String I10 = com.customize.contacts.util.b0.I(this, i10);
        if (TextUtils.isEmpty(I10)) {
            getSupportActionBar().z(R.string.oplus_sdn_serviceNumber);
        } else {
            getSupportActionBar().A(I10);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (H7.a.b()) {
            H7.b.b("ServiceNumberActivity", "onCreate()");
        }
        super.onCreate(bundle);
        setContentView(R.layout.service_numer_browse);
        setSupportActionBar((COUIToolbar) findViewById(R.id.toolbar));
        TextView textView = (TextView) findViewById(R.id.empty_view);
        this.f20585C = textView;
        textView.setText(R.string.noContacts);
        this.f20592y = new d(this, null, true);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.f20593z = listView;
        com.android.contacts.util.C.c(this, listView, getResources().getDimensionPixelSize(R.dimen.DP_30));
        this.f20593z.setNestedScrollingEnabled(true);
        this.f20593z.setAdapter((ListAdapter) this.f20592y);
        this.f20593z.setEmptyView(this.f20585C);
        try {
            this.f20583A = C7.e.l(getIntent(), OplusNumberMarkUtils.OplusContact.OPLUS_COLUMN_SIM_IMSI);
        } catch (Exception e10) {
            H7.b.c("ServiceNumberActivity", "" + e10);
        }
        int K10 = com.customize.contacts.util.b0.K(this, this.f20583A);
        if (-1 == K10) {
            finish();
        }
        this.f20584B = K10;
        w1();
        A1(this.f20584B);
        COUIStatusBarResponseUtil cOUIStatusBarResponseUtil = new COUIStatusBarResponseUtil(this);
        this.f20588p = cOUIStatusBarResponseUtil;
        cOUIStatusBarResponseUtil.setStatusBarClickListener(this);
        this.f20593z.setOnItemClickListener(new a());
        try {
            x1();
        } catch (Exception e11) {
            H7.b.c("ServiceNumberActivity", "Exception: " + e11);
            this.f20586D = null;
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (H7.a.b()) {
            H7.b.b("ServiceNumberActivity", "onDestroy");
        }
        v1();
        super.onDestroy();
        z1(this.f20586D);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.customize.contacts.util.i0.b();
        this.f20588p.onPause();
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        if (H7.a.b()) {
            H7.b.b("ServiceNumberActivity", "onResume()");
        }
        super.onResume();
        this.f20588p.onResume();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (H7.a.b()) {
            H7.b.b("ServiceNumberActivity", "onSaveInstanceState");
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        y1();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    public void w1() {
        ActionBar supportActionBar = getSupportActionBar();
        this.f20587o = supportActionBar;
        if (supportActionBar != null) {
            supportActionBar.v(4, 4);
            this.f20587o.t(true);
        }
    }

    public final void x1() {
        IntentFilter intentFilter = new IntentFilter();
        C0811w.j(this, this.f20586D, intentFilter, "android.intent.action.SIM_STATE_CHANGED");
        intentFilter.addAction(C1498a.f36264w);
        intentFilter.addAction("local.intent.action.SUBINFO_STATE_CHANGE");
        registerReceiver(this.f20586D, intentFilter, R0.b.f3175i, null, 2);
    }

    public void y1() {
        Uri uri = d.b.f3243a;
        if (B3.a.i()) {
            uri = Uri.withAppendedPath(d.b.f3244b, String.valueOf(D7.c.r(getApplicationContext(), Integer.valueOf(this.f20584B))));
        }
        this.f20590r = false;
        C0797h.a(getBaseContext(), new c(uri), this.f20589q);
        if (!this.f20590r) {
            this.f20591x = U0.k.o(this, getString(R.string.simContacts_emptyLoading));
        }
    }

    public void z1(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException e10) {
                H7.b.c("ServiceNumberActivity", "IllegalArgumentException: " + e10);
            }
        }
    }

    @Override // com.coui.appcompat.statusbar.COUIStatusBarResponseUtil.StatusBarClickListener
    public void onStatusBarClicked() {
    }
}
