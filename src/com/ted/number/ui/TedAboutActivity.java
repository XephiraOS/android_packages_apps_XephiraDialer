package com.ted.number.ui;

import android.os.Bundle;
import com.oplus.dialer.R;

/* loaded from: classes4.dex */
public class TedAboutActivity extends TedBaseActivity {
    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean H0() {
        return true;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean Q0() {
        return false;
    }

    @Override // com.ted.number.ui.TedBaseActivity, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ted_about_activity);
    }
}
