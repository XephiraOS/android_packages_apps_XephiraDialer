package com.android.store_incallui;

import R2.b;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.android.incallui.OplusPhoneCapabilities;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: PermissionActivity.kt */
/* loaded from: classes.dex */
public final class PermissionActivity extends AppCompatActivity {

    /* renamed from: a, reason: collision with root package name */
    public static final a f19200a = new a(null);

    /* compiled from: PermissionActivity.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public final void g0() {
        b.b(this);
    }

    public final void k0() {
        if (!Settings.canDrawOverlays(this)) {
            Intent intent = new Intent();
            intent.setAction("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            intent.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
            startActivity(intent);
        }
        finish();
    }

    public final void l0() {
        finish();
    }

    public final void m0() {
        finish();
    }

    public final void n0() {
        o0();
    }

    public final void o0() {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivity(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d("PermissionActivity", "onCreate");
        supportRequestWindowFeature(1);
        b.a(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Log.d("PermissionActivity", "onDestroy");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] permissions, int[] grantResults) {
        i.f(permissions, "permissions");
        i.f(grantResults, "grantResults");
        super.onRequestPermissionsResult(i10, permissions, grantResults);
        b.c(this, i10, grantResults);
    }

    public final void q0() {
        o0();
    }
}
