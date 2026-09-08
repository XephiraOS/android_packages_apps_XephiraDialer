package com.customize.contacts.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.android.contacts.activities.RequestPermissionsActivity;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.util.C0700a;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.functions.FunctionsFragment;
import com.oplus.dialer.R;

/* loaded from: classes3.dex */
public class FunctionsActivity extends BasicActivity {

    /* renamed from: o, reason: collision with root package name */
    public FunctionsFragment f20371o;

    /* renamed from: p, reason: collision with root package name */
    public String f20372p = null;

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean H0() {
        return true;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean Q0() {
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        this.f20371o.onActivityResult(i10, i11, intent);
        super.onActivityResult(i10, i11, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        com.android.contacts.framework.baseui.util.A.b(this, "setting_back");
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f20372p = C7.e.l(getIntent(), ":settings:fragment_args_key");
        RequestPermissionsActivity.p2(this);
        setContentView(R.layout.functions_activity);
        this.f20371o = (FunctionsFragment) getSupportFragmentManager().l0(R.id.functions_fragment);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C0700a.e(null);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.android.contacts.framework.baseui.util.A.g(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        FunctionsFragment functionsFragment;
        super.onRequestPermissionsResult(i10, strArr, iArr);
        H7.b.e("FunctionsActivity", "requestCode = " + i10);
        if (iArr.length == 1 && iArr[0] == 0) {
            if (FeatureOption.o() && i10 == 1 && strArr != null && iArr.length == 1 && iArr[0] == 0 && strArr.length == 1 && TextUtils.equals(strArr[0], "android.permission.READ_PHONE_NUMBERS") && (functionsFragment = this.f20371o) != null) {
                functionsFragment.A1();
                return;
            }
            return;
        }
        finish();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.android.contacts.framework.baseui.util.A.h(this);
    }
}
