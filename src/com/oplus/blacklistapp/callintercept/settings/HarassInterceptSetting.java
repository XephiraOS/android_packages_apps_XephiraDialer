package com.oplus.blacklistapp.callintercept.settings;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.oplus.blacklistapp.activities.BaseActivity;
import com.oplus.utils.C0861w;
import com.oplus.utils.L;

/* loaded from: classes3.dex */
public class HarassInterceptSetting extends BaseActivity {

    /* renamed from: e, reason: collision with root package name */
    public String[] f26796e;

    /* renamed from: f, reason: collision with root package name */
    public Fragment f26797f;

    /* renamed from: g, reason: collision with root package name */
    public final String f26798g = "SETTING";

    @Override // com.oplus.blacklistapp.framework.baseui.BasicActivity
    public boolean o0() {
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 10 && !isFinishing()) {
            String[] f10 = L.f(this);
            this.f26796e = f10;
            if (f10 != null && f10.length > 0) {
                for (String str : f10) {
                    if (shouldShowRequestPermissionRationale(str)) {
                        requestPermissions(this.f26796e, 1);
                        return;
                    }
                }
                L.p(this, this.f26796e);
                return;
            }
            C0861w.g(getApplicationContext()).k();
        }
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, com.oplus.blacklistapp.framework.baseui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String[] f10 = L.f(this);
        this.f26796e = f10;
        if (f10 != null) {
            requestPermissions(f10, 1);
        } else {
            androidx.appcompat.app.b bVar = L.f29055a;
            if (bVar != null && bVar.isShowing()) {
                try {
                    try {
                        L.f29055a.dismiss();
                    } catch (IllegalArgumentException e10) {
                        Log.e("HarassInterceptSetting", "dismiss permission Exception: " + e10);
                    }
                } finally {
                    L.f29055a = null;
                }
            }
        }
        if (this.f26796e == null) {
            C0861w.g(getApplicationContext()).k();
        }
        setContentView(com.oplus.blacklistapp.r.f27447b);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment m02 = supportFragmentManager.m0("SETTING");
        this.f26797f = m02;
        if (m02 == null) {
            this.f26797f = new t();
        }
        supportFragmentManager.p().t(com.oplus.blacklistapp.p.f27338H, this.f26797f, "SETTING").i();
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        L.i();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (!L.j(iArr)) {
            String[] f10 = L.f(this);
            this.f26796e = f10;
            if (f10 != null && f10.length > 0) {
                L.p(this, f10);
                return;
            }
            return;
        }
        C0861w.g(getApplicationContext()).k();
        Fragment fragment = this.f26797f;
        if (fragment != null && (fragment instanceof t)) {
            ((t) fragment).x1();
        }
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, com.coui.appcompat.statusbar.COUIStatusBarResponseUtil.StatusBarClickListener
    public void onStatusBarClicked() {
    }
}
