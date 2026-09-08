package com.oplus.blacklistapp.callintercept.settings;

import android.content.Intent;
import android.os.Bundle;
import com.oplus.blacklistapp.activities.BaseActivity;

/* compiled from: NonBlockedRulesSetting.kt */
/* loaded from: classes3.dex */
public final class NonBlockedRulesSetting extends BaseActivity {
    @Override // com.oplus.blacklistapp.framework.baseui.BasicActivity
    public boolean o0() {
        return false;
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, com.oplus.blacklistapp.framework.baseui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.oplus.blacklistapp.r.f27447b);
        NonBlockedRulesSettingFragment nonBlockedRulesSettingFragment = new NonBlockedRulesSettingFragment();
        Intent intent = getIntent();
        kotlin.jvm.internal.i.e(intent, "intent");
        nonBlockedRulesSettingFragment.o1(intent);
        getSupportFragmentManager().p().s(com.oplus.blacklistapp.p.f27338H, nonBlockedRulesSettingFragment).i();
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, com.coui.appcompat.statusbar.COUIStatusBarResponseUtil.StatusBarClickListener
    public void onStatusBarClicked() {
    }
}
