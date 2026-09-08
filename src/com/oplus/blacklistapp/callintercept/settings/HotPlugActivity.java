package com.oplus.blacklistapp.callintercept.settings;

import android.os.Bundle;
import com.oplus.blacklistapp.activities.BaseActivity;
import com.oplus.blacklistapp.callintercept.CallInterceptController;

/* loaded from: classes3.dex */
public class HotPlugActivity extends BaseActivity implements CallInterceptController.b {
    @Override // com.oplus.blacklistapp.activities.BaseActivity, com.oplus.blacklistapp.framework.baseui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CallInterceptController.e().d(this);
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CallInterceptController.e().m(this);
    }

    @Override // com.oplus.blacklistapp.callintercept.CallInterceptController.b
    public void u(int i10) {
        finish();
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, com.coui.appcompat.statusbar.COUIStatusBarResponseUtil.StatusBarClickListener
    public void onStatusBarClicked() {
    }

    @Override // com.oplus.blacklistapp.callintercept.CallInterceptController.b
    public void P0(int i10) {
    }
}
