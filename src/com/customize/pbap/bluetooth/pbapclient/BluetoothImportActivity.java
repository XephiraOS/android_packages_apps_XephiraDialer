package com.customize.pbap.bluetooth.pbapclient;

import C7.e;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.v;
import b4.i;
import b4.j;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.pbap.bluetooth.pbapclient.BluetoothImportActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.dialer.R;

/* loaded from: classes3.dex */
public class BluetoothImportActivity extends BasicActivity {

    /* renamed from: o, reason: collision with root package name */
    public View f22613o = null;

    /* renamed from: p, reason: collision with root package name */
    public i f22614p = null;

    /* renamed from: q, reason: collision with root package name */
    public j f22615q = null;

    /* renamed from: r, reason: collision with root package name */
    public FragmentManager f22616r = null;

    /* renamed from: x, reason: collision with root package name */
    public v f22617x = new a();

    /* renamed from: y, reason: collision with root package name */
    public BroadcastReceiver f22618y = new b();

    /* loaded from: classes3.dex */
    public class a implements v {
        public a() {
        }

        @Override // androidx.fragment.app.v
        public void a(FragmentManager fragmentManager, Fragment fragment) {
            String tag = fragment.getTag();
            tag.hashCode();
            if (!tag.equals("TransportFragment")) {
                if (tag.equals("FromDeviceFragment")) {
                    BluetoothImportActivity.this.f22614p = (i) fragment;
                    return;
                }
                return;
            }
            BluetoothImportActivity.this.f22615q = (j) fragment;
            BluetoothImportActivity.this.f22615q.n1();
            if (BluetoothImportActivity.this.f22615q.j1()) {
                BluetoothImportActivity.this.f22615q.q1();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) e.j(intent, "android.bluetooth.device.extra.DEVICE");
            BluetoothImportActivity.this.y1("TransportFragment");
            BluetoothImportActivity.this.f22615q = new j();
            Bundle bundle = new Bundle();
            bundle.putParcelable("Device", bluetoothDevice);
            BluetoothImportActivity.this.f22615q.setArguments(bundle);
            BluetoothImportActivity bluetoothImportActivity = BluetoothImportActivity.this;
            bluetoothImportActivity.v1(bluetoothImportActivity.f22615q, "TransportFragment");
            BluetoothImportActivity.this.f22615q.i1();
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.f22616r = supportFragmentManager;
        supportFragmentManager.k(this.f22617x);
        super.onCreate(bundle);
        setContentView(R.layout.from_device_activity);
        final AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        setSupportActionBar((COUIToolbar) findViewById(R.id.toolbar));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.x(true);
            supportActionBar.t(true);
            supportActionBar.w(false);
        }
        setTitle(R.string.from_other_device_tablet);
        View findViewById = findViewById(R.id.from_device_fragment);
        this.f22613o = findViewById;
        findViewById.post(new Runnable() { // from class: b4.a
            @Override // java.lang.Runnable
            public final void run() {
                BluetoothImportActivity.this.w1(appBarLayout);
            }
        });
        x1();
        if (bundle == null) {
            i iVar = new i();
            this.f22614p = iVar;
            v1(iVar, "FromDeviceFragment");
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.f22618y);
        this.f22616r.o1(this.f22617x);
        this.f22614p = null;
        this.f22615q = null;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        return true;
    }

    public final void v1(Fragment fragment, String str) {
        if (this.f22616r.m0(str) == null) {
            this.f22616r.p().c(R.id.from_device_fragment, fragment, str).j();
            this.f22616r.i0();
        }
    }

    public final /* synthetic */ void w1(AppBarLayout appBarLayout) {
        this.f22613o.setPadding(0, appBarLayout.getMeasuredHeight(), 0, 0);
    }

    public final void x1() {
        registerReceiver(this.f22618y, new IntentFilter("android.bluetooth.devicepicker.action.DEVICE_SELECTED"), 2);
    }

    public final void y1(String str) {
        Fragment m02 = this.f22616r.m0(str);
        if (m02 != null) {
            this.f22616r.p().r(m02).j();
            this.f22616r.i0();
        }
    }
}
