package com.customize.contacts.activities;

import android.os.Bundle;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.customize.contacts.fragment.AssistedDialingSettingFragment;
import com.oplus.dialer.R;

/* loaded from: classes3.dex */
public class AssistedDialingSettingActivity extends BasicActivity {

    /* renamed from: o, reason: collision with root package name */
    public AssistedDialingSettingFragment f20108o;

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean Q0() {
        return false;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (B3.a.f()) {
            H7.b.e("AssistedDialingSettingActivity", "AssistedDialingSettingActivity onCreate finish because isDisableRoamingAssistant is true");
            finish();
        } else {
            setContentView(R.layout.assisted_dialing_settings);
            p1();
        }
    }

    public final void p1() {
        AssistedDialingSettingFragment assistedDialingSettingFragment = (AssistedDialingSettingFragment) getSupportFragmentManager().l0(R.id.assisted_dialing_settings_fragment);
        this.f20108o = assistedDialingSettingFragment;
        assistedDialingSettingFragment.getListView().setNestedScrollingEnabled(true);
    }
}
