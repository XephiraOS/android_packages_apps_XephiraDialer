package com.android.contacts.activities;

import android.content.Intent;
import android.os.Bundle;
import com.android.contacts.detail.CallDetailActivityFragment;
import com.oplus.dialer.R;
import kotlin.jvm.internal.i;

/* compiled from: ContactShortcutDetailActivity.kt */
/* loaded from: classes.dex */
public final class ContactShortcutDetailActivity extends CallDetailActivity {
    @Override // com.android.contacts.activities.CallDetailActivity, com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (i.b(getIntent().getAction(), "com.oplus.contacts.intent.action.SHORTCUT_CONTACT")) {
            getIntent().setAction("android.intent.action.VIEW");
        }
        getSupportFragmentManager().p().s(R.id.coordinator, new CallDetailActivityFragment()).l();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        String str;
        super.onNewIntent(intent);
        if (intent != null) {
            str = intent.getAction();
        } else {
            str = null;
        }
        if (i.b(str, "com.oplus.contacts.intent.action.SHORTCUT_CONTACT")) {
            intent.setAction("android.intent.action.VIEW");
        }
        setIntent(intent);
        getSupportFragmentManager().p().s(R.id.coordinator, new CallDetailActivityFragment()).l();
    }

    @Override // com.android.contacts.activities.CallDetailActivity
    public int p1() {
        return R.layout.contact_shortcut_detail_activity;
    }
}
