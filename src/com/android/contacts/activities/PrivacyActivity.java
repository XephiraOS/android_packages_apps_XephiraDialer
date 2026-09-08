package com.android.contacts.activities;

import android.os.Bundle;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.oplus.dialer.R;

/* compiled from: PrivacyActivity.kt */
/* loaded from: classes.dex */
public final class PrivacyActivity extends BasicActivity {
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
        setContentView(R.layout.privacy);
    }
}
